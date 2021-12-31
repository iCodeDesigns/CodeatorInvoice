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
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatusId;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.InvoDocumentStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterStatusDAO;
import com.taxdemo.www._0_1_0_api_tracks._003_connect_and_get_document;
import com.taxdemo.www._0_1_0_api_tracks._004_connect_and_cancel_document;
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
public class _1_0_0_0_3_Electronic_Invoice_Query_02_cancelDocument extends HttpServlet {

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
            //System.out.println("host            : " + request.getHeader("host")); // -- Server Host IP and PORT
            //System.out.println("Remote Address  : " + request.getRemoteAddr());   // -- Client IP

            String portal_type = request.getParameter("portal_type");
            // request.getParameter("documentUUID");
            String invSp = request.getParameter("invSp");
            String sectionId = request.getParameter("sectionId");
            String deptId = request.getParameter("deptId");
            String accUnitCode = request.getParameter("accUnitCode");
            String rmrk = request.getParameter("rmrk");
            rmrk = (rmrk.equals("")) ? "خطأ في المستند" : rmrk;

            List<InvoInvoiceMaster> existInvoiceList
                    = new InvoInvoiceMasterDao().GetInvoInvoiceMasterBySeq(invSp, deptId, sectionId, accUnitCode);

            if (existInvoiceList.isEmpty()) {
                throw new Exception("notExistDocument");
            }
            List<InvoDocumentStatus> invoDocumentStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus("14");// جاري الالغاء
            if (invoDocumentStatusList.isEmpty()) {
                throw new Exception();
            }

            InvoInvoiceMaster invoInvoiceMaster = existInvoiceList.get(0);

            String documentUUID = invoInvoiceMaster.getUuid();

            _004_connect_and_cancel_document doc = new _004_connect_and_cancel_document();
            //String json = recent_doc.getJson();
            doc.cancelDocuments(portal_type, documentUUID, rmrk);
            String json = doc.getJson();
            if (json.equals("true")) {
                //get document status

                new HibernateSessionCon().beginTrans();
                invoInvoiceMaster.setInvoDocumentStatus(invoDocumentStatusList.get(0));
                new InvoDocumentStatusDAO().update(invoInvoiceMaster);
                // --------------------- Invoice Master Status ---------------------
                // --------------------- Invoice Master Status ---------------------
                // --------------------- Invoice Master Status ---------------------
                // --------------------- Invoice Master Status ---------------------
                short logSeq = new InvoInvoiceMasterStatusDAO().GetMaxLogSeq(accUnitCode, deptId, sectionId, invSp);
                InvoInvoiceMasterStatusId id_MasterStatus = new InvoInvoiceMasterStatusId(Integer.parseInt(sectionId), Long.parseLong(deptId), Long.parseLong(invSp), accUnitCode, logSeq);
                InvoInvoiceMasterStatus invoInvoiceMasterStatus = new InvoInvoiceMasterStatus(id_MasterStatus, invoInvoiceMaster);
                invoInvoiceMasterStatus.setPerEmploymentMaster(employee_session);
                invoInvoiceMasterStatus.setInvoDocumentStatus(invoDocumentStatusList.get(0));
                invoInvoiceMasterStatus.setCurrDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                //ip -----------> user Ip
                String host = request.getHeader("host"); // -- Server Host IP and PORT
                String Client_IP = request.getRemoteAddr();// -- Client IP
                invoInvoiceMasterStatus.setDeskId(Client_IP);

                invoInvoiceMasterStatus.setRmrk("");
                invoInvoiceMasterStatus.setCurrDate(new DateOp().getSysDate());
                /**
                 * add Data To Invoice Master Status
                 * <<---------------------------------------------------------------
                 * ADD To Table INVO_INVOICE_MASTER_STATUS
                 */
                new InvoInvoiceMasterStatusDAO().insert(invoInvoiceMasterStatus);
                new HibernateSessionCon().CommitTrans();
                response.getWriter().write("Success");
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            if (message.equals("Fire Wall Stands On Request Traffic")) {
                message = "جدار الحماية يمنع اللإتصال";
            } else {
                message = "لا يمكن الغاء الفاتورة من مصلحة الضرائب";
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
