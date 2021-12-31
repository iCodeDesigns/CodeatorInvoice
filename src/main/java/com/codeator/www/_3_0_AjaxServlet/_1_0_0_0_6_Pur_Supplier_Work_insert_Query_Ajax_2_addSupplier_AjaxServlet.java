/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerCountryCode;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.PerGovernorateCode;
import com.codeator.www._1_2_DB_entities.PurSuppWork;
import com.codeator.www._1_3_DB_daos.PerCountryCodeDAO;
import com.codeator.www._1_3_DB_daos.PerGovernorateCodeDAO;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_0_6_Pur_Supplier_Work_insert_Query_Ajax_2_addSupplier_AjaxServlet extends HttpServlet {

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

            String supplierName = request.getParameter("supplierName");
            String countryCode = request.getParameter("countryCode");
            String govCode = request.getParameter("govCode");
            String street = request.getParameter("street");
            String buildingNumber = request.getParameter("buildingNumber");

            long suppSeq = new PurSuppWorkDao<>().GetMaxInvoSp();
            PurSuppWork purSuppWork = new PurSuppWork(suppSeq);
            purSuppWork.setChkUpd("J");
            purSuppWork.setSuppName(supplierName);

            if (countryCode.equals("1")) {
                String taxCardNo = request.getParameter("taxCardNo");
                String identNo = request.getParameter("identNo");

                if (!(taxCardNo == null || taxCardNo.equals(""))) {
                    List<PurSuppWork> PurSuppWorkList1 = new PurSuppWorkDao().GetPurSupplierWorkByTaxCardNo(taxCardNo);
                    if (!PurSuppWorkList1.isEmpty()) {
                        throw new Exception("taxCardNoExist");
                    }
                }

                if (!(identNo == null || identNo.equals(""))) {
                    List<PurSuppWork> PurSuppWorkList2 = new PurSuppWorkDao().GetPurSupplierWorkByIdentNo(identNo);
                    if (!PurSuppWorkList2.isEmpty()) {
                        throw new Exception("identNoExist");
                    }
                }

                purSuppWork.setTaxCardNo(taxCardNo);
                purSuppWork.setIdentNo(identNo);
            } else if (!countryCode.equals("1")) {
                String passport = request.getParameter("passport");
                purSuppWork.setPassportNum(passport);
            }

            List<PerCountryCode> PerCountryCodeList = new PerCountryCodeDAO().GetCountriesByCountryCode(countryCode);
            if (PerCountryCodeList.isEmpty()) {
                throw new Exception();
            }

            purSuppWork.setPerCountryCode(PerCountryCodeList.get(0));

            if (govCode == null || govCode.equals("")) {

            } else {
                List<PerGovernorateCode> PerGovernorateCodeList = new PerGovernorateCodeDAO().GetPerGovernorateCodeByID(countryCode, govCode);
                if (PerGovernorateCodeList.isEmpty()) {
                    throw new Exception();
                }
                purSuppWork.setPerGovernorateCode(PerGovernorateCodeList.get(0));
            }

            purSuppWork.setAddress(street);
            purSuppWork.setBuildingNum(buildingNumber);
            purSuppWork.setPerEmploymentMasterByUpdateEmpId(employee_session);
            
            purSuppWork.setInsertDate(new DateOp().getSysDate());
            purSuppWork.setInsertDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
            
            new HibernateSessionCon().beginTrans();
            new PerGovernorateCodeDAO().insert(purSuppWork);
            new HibernateSessionCon().CommitTrans();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            if (message.equals("identNoExist")) {
                message = "الرقم القومي مسجل لعميل من قبل";
            } else if (message.equals("taxCardNoExist")) {
                message = "السجل الضريبي مسجل لعميل من قبل";
            } else {
                message = "حدث خطأ";
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
