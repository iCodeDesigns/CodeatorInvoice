/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterStatusDAO;
import com.codeator.www._6_1_Json_entities.InvoDocumentStatus;
import com.codeator.www._6_1_Json_entities.InvoInvoiceMasterStatusId;
import com.codeator.www._6_1_Json_entities.PerEmploymentMaster;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _1_0_0_1_0_Electronic_Invoice_Query_02_getInvoiceLog_AjaxServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        new HibernateSessionCon().OpenCon();
        new HibernateSessionCon().clearConn();
        try {
            // logic Business
            //List<PhotoInsertDataJasonFileClass> articles = new LinkedList<PhotoInsertDataJasonFileClass>();

            /*BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();*/
            // 3. Convert received JSON to Article
            String deptId = request.getParameter("deptId");
            String sectionId = request.getParameter("sectionId");
            String accUnitCode = request.getParameter("accUnitId");
            String invoSp = request.getParameter("invoSp");

            InvoInvoiceMasterStatusDAO DAO = new InvoInvoiceMasterStatusDAO();
            List<InvoInvoiceMasterStatus> pList = DAO.documentStatusLog(accUnitCode, deptId, sectionId, invoSp);

            com.codeator.www._6_1_Json_entities.InvoInvoiceMasterStatus logClass[]
                    = new com.codeator.www._6_1_Json_entities.InvoInvoiceMasterStatus[pList.size()];
            int i = 0;
            for (InvoInvoiceMasterStatus invoInvoiceMasterStatus : pList) {
                com.codeator.www._6_1_Json_entities.InvoInvoiceMasterStatus log
                        = new com.codeator.www._6_1_Json_entities.InvoInvoiceMasterStatus();

                InvoInvoiceMasterStatusId id = new InvoInvoiceMasterStatusId(
                        invoInvoiceMasterStatus.getId().getDepNoOld(),
                        invoInvoiceMasterStatus.getId().getInvoSp(),
                        invoInvoiceMasterStatus.getId().getSectionNoOld(),
                        invoInvoiceMasterStatus.getId().getLogSeq());
                log.setId(id);
                log.setCurrDateTime(invoInvoiceMasterStatus.getCurrDateTime());

                InvoDocumentStatus invoDocumentStatus = new InvoDocumentStatus();
                invoDocumentStatus.setDocStatusName(invoInvoiceMasterStatus.getInvoDocumentStatus().getDocStatusName());
                log.setInvoDocumentStatus(invoDocumentStatus);

                PerEmploymentMaster perEmploymentMaster = new PerEmploymentMaster();
                if (invoInvoiceMasterStatus.getPerEmploymentMaster() != null) {
                    perEmploymentMaster.setEmployeeId(invoInvoiceMasterStatus.getPerEmploymentMaster().getEmployeeId());
                    perEmploymentMaster.setEmpAname(invoInvoiceMasterStatus.getPerEmploymentMaster().getEmpAname());
                    log.setPerEmploymentMaster(perEmploymentMaster);
                }

                log.setDeskId(invoInvoiceMasterStatus.getDeskId());
                logClass[i] = log;
                i++;
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String json = "";
            json = mapper.writeValueAsString(logClass);
            //System.out.println("json : " + json);
            // success
            response.getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
        }
        new HibernateSessionCon().closeConn();
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
