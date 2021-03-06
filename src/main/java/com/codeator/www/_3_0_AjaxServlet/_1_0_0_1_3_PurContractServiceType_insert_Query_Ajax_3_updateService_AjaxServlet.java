/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.PurContractServiceType;
import com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import com.codeator.www._1_3_DB_daos.PurContractServiceTypeDao;
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
public class _1_0_0_1_3_PurContractServiceType_insert_Query_Ajax_3_updateService_AjaxServlet extends HttpServlet {

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
            String serviceSeq = request.getParameter("serviceSeq");
            String serviceName = request.getParameter("serviceName");
            String serviceCode = request.getParameter("serviceCode");
            String deptId = request.getParameter("deptId");
            String sectionId = request.getParameter("sectionId");
            String accUnitId = request.getParameter("accUnitId");
            

            List<InvoAccUintDept> perDeptOld = new InvoAccUintDeptDao().GetInvoAccUintInDeptAndUnit(accUnitId, sectionId, deptId);
            if (perDeptOld.isEmpty()) {
                throw new Exception();
            }

            List<PerEmploymentMaster> perEmploymentMaster = new PerEmploymentMasterDao().GetEmployeesByEmployee_ID("" + employee_session.getEmployeeId());
            if (perEmploymentMaster.isEmpty()) {
                throw new Exception();
            }

            List<PurContractServiceType> purContractServiceType = new PurContractServiceTypeDao().GetAllContractServicePerDeptAndSeq(serviceSeq, accUnitId, sectionId, deptId);
            if (purContractServiceType.isEmpty()) {
                throw new Exception();
            }

            PurContractServiceType pcst = purContractServiceType.get(0);

            pcst.setServiceName(serviceName);
            pcst.setServiceCode(serviceCode);
            pcst.setUpdateDate(new DateOp().getSysDate());
            pcst.setUpdateDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
            pcst.setPerEmploymentMaster(perEmploymentMaster.get(0));

            new HibernateSessionCon().beginTrans();
            new PurContractServiceTypeDao().update(pcst);
            new HibernateSessionCon().CommitTrans();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            response.getWriter().write("?????? ??????");
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
