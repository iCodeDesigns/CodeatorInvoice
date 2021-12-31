/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoDocumentStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.InvoDocumentStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_1_2_Electronic_Invoice_Query_Collecting_Ajax_01_updateCheckPay_AjaxServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected synchronized void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        new HibernateSessionCon().OpenCon();

        try {
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }
            //String locationCode = "0";
            /*BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                ////System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _200_Submit_Documents_001_document document = mapper.readValue(json, _200_Submit_Documents_001_document.class);*/
            String invSp = request.getParameter("invSp");
            String sectionId = request.getParameter("sectionOld");
            String deptId = request.getParameter("deptOld");
            String accUnitCode = request.getParameter("accUnitId");

            String employeeId = request.getParameter("employeeId");
            String safeCheckBoxStatus = request.getParameter("safeCheckBoxStatus");
            String paidFormCode = request.getParameter("paidFormCode");
            String paidDate = request.getParameter("paidDate");
            String paiedRmrk = request.getParameter("paiedRmrk");

            List<InvoInvoiceMaster> existInvoiceList = new InvoInvoiceMasterDao().GetInvoInvoiceMasterBySeq(invSp, deptId, sectionId, accUnitCode);

            if (existInvoiceList.isEmpty()) {
                throw new Exception("notExistDocument");
            }

            List<PerEmploymentMaster> empList = new PerEmploymentMasterDao<>().GetEmployeesByEmployee_IDByDeptOnly(employeeId, deptId, sectionId);

            if (existInvoiceList.isEmpty()) {
                throw new Exception("EmpError");
            }
            new HibernateSessionCon().beginTrans();
            InvoInvoiceMaster inv_master = existInvoiceList.get(0);

            if (safeCheckBoxStatus.equals("true")) {
                inv_master.setPerEmploymentMasterByEmployeeIdPaid(employee_session);
                inv_master.setPaidFormCode(paidFormCode);
                inv_master.setChkPaidDirect("1");
            } else {
                inv_master.setPerEmploymentMasterByEmployeeIdPaid(empList.get(0));
                inv_master.setPaidFormCode(paidFormCode);
                inv_master.setChkPaidDirect("0");
            }
            inv_master.setChkPaid("1");
            inv_master.setPaidRmrk(paiedRmrk);
            inv_master.setPaidDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
            inv_master.setPaidDate(new DateOp().String2Date(paidDate, "yyyy-MM-dd"));

            new InvoInvoiceMasterDao().update(inv_master);
            for (InvoInvoiceMaster invoInvoiceMaster : inv_master.getInvoInvoiceMastersForInvoimsInvoimsSplitFk()) {
                invoInvoiceMaster.setChkPaid("1");

                if (safeCheckBoxStatus.equals("true")) {
                    invoInvoiceMaster.setPerEmploymentMasterByEmployeeIdPaid(employee_session);
                    invoInvoiceMaster.setPaidFormCode(paidFormCode);
                } else {
                    invoInvoiceMaster.setPerEmploymentMasterByEmployeeIdPaid(empList.get(0));
                }
                invoInvoiceMaster.setPerEmploymentMasterByEmployeeIdPaid(employee_session);
                invoInvoiceMaster.setPaidRmrk(paiedRmrk);
                invoInvoiceMaster.setPaidDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                invoInvoiceMaster.setPaidDate(new DateOp().String2Date(paidDate, "yyyy-MM-dd"));

                new InvoInvoiceMasterDao().update(invoInvoiceMaster);
            }
            new HibernateSessionCon().CommitTrans();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            if (message.equals("EmpError")) {
                message = "EmpError";
            } else {
                message = "Error";
            }
            response.getWriter().write(message);
        }

        new HibernateSessionCon().closeConn();
        //new HibernateSessionCon().clearConn();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
