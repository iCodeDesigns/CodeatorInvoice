/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.PurSuppWork;
import com.codeator.www._1_2_DB_entities.PurSuppWorkDtl;
import com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDtlDao;
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
public class _1_0_0_0_8_Pur_Supplier_Work_Dtl_insert_Query_Ajax_3_updateSuppDetail_AjaxServlet extends HttpServlet {

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
            String suppSeq = request.getParameter("suppSeq");
            String suppSeqBr = request.getParameter("suppSeqBr");
            String suppNameBr = request.getParameter("suppNameBr");
            String addressBr = request.getParameter("addressBr");
            String suppMainFrameCode = request.getParameter("suppMainFrameCode");
            String deptId = request.getParameter("deptId");
            String sectionId = request.getParameter("sectionId");
            String accUnitId = request.getParameter("accUnitId");

            List<PurSuppWork> PurSuppWorkList = new PurSuppWorkDao().GetPurSupplierById(suppSeq);
            if (PurSuppWorkList.isEmpty()) {
                throw new Exception();
            }
            
            List<InvoAccUintDept> InvoAccUintDeptDaoList = new InvoAccUintDeptDao().GetInvoAccUintInDeptAndUnit(accUnitId, sectionId, deptId);
            if (PurSuppWorkList.isEmpty()) {
                throw new Exception();
            }

            List<PurSuppWorkDtl> PurSuppWorkDtlList = new PurSuppWorkDtlDao().GetPurSupplierWorkDtlBySuppSeqBr(suppSeqBr);
            if (PurSuppWorkDtlList.isEmpty()) {
                throw new Exception();
            } else {
                PurSuppWorkDtl purSuppWorkDtlList = PurSuppWorkDtlList.get(0);
                purSuppWorkDtlList.setSuppNameBr(suppNameBr);
                purSuppWorkDtlList.setSuppMainFrameCode(suppMainFrameCode);
                purSuppWorkDtlList.setPurSuppWork(PurSuppWorkList.get(0));
                purSuppWorkDtlList.setPerEmploymentMaster(employee_session);
                purSuppWorkDtlList.setInsertDate(new Date());
                purSuppWorkDtlList.setInsertDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                purSuppWorkDtlList.setInvoAccUintDept(InvoAccUintDeptDaoList.get(0));

                if (addressBr == null || addressBr == "") {
                    purSuppWorkDtlList.setAddressBr(PurSuppWorkList.get(0).getAddress());
                } else {
                    purSuppWorkDtlList.setAddressBr(addressBr);
                }

                new HibernateSessionCon().beginTrans();
                new PurSuppWorkDtlDao().update(purSuppWorkDtlList);
                new HibernateSessionCon().CommitTrans();

                response.getWriter().write("Success");
            }

        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
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
