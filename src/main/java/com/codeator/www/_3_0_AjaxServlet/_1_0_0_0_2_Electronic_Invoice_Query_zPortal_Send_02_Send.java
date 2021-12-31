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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class _1_0_0_0_2_Electronic_Invoice_Query_zPortal_Send_02_Send extends HttpServlet {

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
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                ////System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _200_Submit_Documents_001_document[] document = mapper.readValue(json, _200_Submit_Documents_001_document[].class);

            new HibernateSessionCon().beginTrans();
            InvoInvoiceMasterDao dao = new InvoInvoiceMasterDao();

            for (_200_Submit_Documents_001_document doc : document) {
                String invSp = doc.getInvSp();
                String sectionId = doc.getSectionOld();
                String deptId = doc.getDeptOld();
                String accUnitCode = doc.getNewAccAcountUnitCode();
                System.out.println("invSp : " + invSp);
                System.out.println("sectionId : " + sectionId);
                System.out.println("deptId : " + deptId);
                System.out.println("accUnitCode : " + accUnitCode);
                System.out.println("------------------------------------");
                List<InvoInvoiceMaster> existInvoiceList
                        = new InvoInvoiceMasterDao().GetInvoInvoiceMasterBySeq(invSp, deptId, sectionId, accUnitCode);

                if (existInvoiceList.isEmpty()) {
                    throw new Exception("notExistDocument");
                }
                //get document status
                List<InvoDocumentStatus> invoDocumentStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus("8");// إعتماد
                if (invoDocumentStatusList.isEmpty()) {
                    throw new Exception();
                }

                InvoInvoiceMaster inv_master = existInvoiceList.get(0);

                inv_master.setInvoDocumentStatus(invoDocumentStatusList.get(0));
                dao.update(inv_master);

                // --------------------- Invoice Master Status ---------------------
                // --------------------- Invoice Master Status ---------------------
                // --------------------- Invoice Master Status ---------------------
                // --------------------- Invoice Master Status ---------------------
                short logSeq = new InvoInvoiceMasterStatusDAO().GetMaxLogSeq(accUnitCode, deptId, sectionId, invSp);
                InvoInvoiceMasterStatusId id_MasterStatus = new InvoInvoiceMasterStatusId(Integer.parseInt(sectionId), Long.parseLong(deptId), Long.parseLong(invSp), accUnitCode, logSeq);
                InvoInvoiceMasterStatus invoInvoiceMasterStatus = new InvoInvoiceMasterStatus(id_MasterStatus, inv_master);
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
                dao.insert(invoInvoiceMasterStatus);

                if (!inv_master.getInvoInvoiceMastersForInvoimsInvoimsSplitFk().isEmpty()) {
                    //فواتير عادي وليست مقسمة
                    for (InvoInvoiceMaster invoInvoiceMaster : inv_master.getInvoInvoiceMastersForInvoimsInvoimsSplitFk()) {
                        invoInvoiceMaster.setInvoDocumentStatus(invoDocumentStatusList.get(0));
                        dao.update(invoInvoiceMaster);
                    }
                }
            }

            new HibernateSessionCon().CommitTrans();
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            if (message.equals("notExistDocument")) {
                message = "الفاتورة غير موجودة لتعديلها";
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
