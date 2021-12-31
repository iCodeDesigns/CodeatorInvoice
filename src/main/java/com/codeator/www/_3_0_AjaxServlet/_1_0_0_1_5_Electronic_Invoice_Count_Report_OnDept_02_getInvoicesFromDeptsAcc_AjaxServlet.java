/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._6_0_Json_entities._1_0_0_1_4_Electronic_Invoice_Count_Report;
import com.codeator.www._6_0_Json_entities._1_0_0_1_4_Electronic_Invoice_Count_Report_2;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_1_5_Electronic_Invoice_Count_Report_OnDept_02_getInvoicesFromDeptsAcc_AjaxServlet extends HttpServlet {

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
        new HibernateSessionCon().clearConn();
        try {
            List<_200_Submit_Documents_001_document> _200_Submit_Documents_001_document_List = new ArrayList<>();

            //-- ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            //-- Get Json Data
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            String json = (br == null) ? "" : br.readLine();

            //-- Convert JSON to Article Class
            _1_0_0_1_4_Electronic_Invoice_Count_Report counts = mapper.readValue(json, _1_0_0_1_4_Electronic_Invoice_Count_Report.class);

            String fromDate = request.getParameter("fromDate");
            String toDate = request.getParameter("toDate");
            String createdDate_OR_issueDate = request.getParameter("createdDate_OR_issueDate");

            List<String> all_id_split = counts.getDept();

            List<String> documentStatus = new ArrayList<>();
            for (_1_0_0_1_4_Electronic_Invoice_Count_Report_2 docStatu : counts.getDocStatus()) {
                documentStatus.add(docStatu.getValue());
            }

            for (String id_split : all_id_split) {
                String[] id = id_split.split(",");
                String accUnitId = id[0].replace("'", "");
                String sectionId = id[1].replace("'", "");
                String deptId = id[2].replace("'", "");

                _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class dao
                        = new _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class();
                dao.setUsePeriod(true);
                dao.setFromDate(fromDate);
                dao.setToDate(toDate);
                dao.setCreatedDate_OR_issueDate(createdDate_OR_issueDate);

                _200_Submit_Documents_001_document[] _200_Submit_Documents_001_document_arr
                        = dao.getMultiInvoices(deptId, sectionId, accUnitId, documentStatus, "internalId");

                List<_200_Submit_Documents_001_document> _200_Submit_Documents_001_document_TempList = Arrays.asList(_200_Submit_Documents_001_document_arr);
                _200_Submit_Documents_001_document_List.addAll(_200_Submit_Documents_001_document_TempList);
            }

            // 2. initiate jackson mapper
            String json1 = "";
            json1 = mapper.writeValueAsString(_200_Submit_Documents_001_document_List);
            response.setContentType("application/json");
            // success
            response.getWriter().write(json1);

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
