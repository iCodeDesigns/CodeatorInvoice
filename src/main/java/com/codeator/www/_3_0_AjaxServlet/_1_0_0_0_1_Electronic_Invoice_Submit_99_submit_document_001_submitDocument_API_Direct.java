/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.alahram.constants.InvoiceDocumentConstants;
import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AccAccountUnits;
import com.codeator.www._1_2_DB_entities.AccCurrencyCode;
import com.codeator.www._1_2_DB_entities.InvItemCode;
import com.codeator.www._1_3_DB_daos.AccAccountUnitsDAO;
import com.codeator.www._1_3_DB_daos.AccCurrencyCodeDAO;
import com.codeator.www._1_3_DB_daos.InvInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvInvoiceMasterItemDAO;
import com.codeator.www._1_3_DB_daos.InvoItemCodeDAO;
import com.codeator.www._1_3_DB_daos.InvTaxSubtypeDAO;
import com.codeator.www._1_3_DB_daos.InvUnitTypeDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._0_1_0_api_tracks._001_connect_and_submit_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._003_creation_of_document_json._201_Submit_Documents_003_json_generated_for_All_documents;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import com.taxdemo.www._2_0_0_systemIntegration.api._005_creation_of_document_json_Custom._201_Submit_Documents_003_json_generated_for_All_documents_custom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _1_0_0_0_1_Electronic_Invoice_Submit_99_submit_document_001_submitDocument_API_Direct extends HttpServlet {

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

            //String locationCode = "0";
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _200_Submit_Documents_001_document document = mapper.readValue(json, _200_Submit_Documents_001_document.class);

            List<_200_Submit_Documents_001_document> doucuments = new ArrayList<>();
            doucuments.add(document);

            _201_Submit_Documents_003_json_generated_for_All_documents_custom Submit_Documents_create_json
                    = new _201_Submit_Documents_003_json_generated_for_All_documents_custom("1.0", doucuments, false);

            String json_str = Submit_Documents_create_json.getDocuments_json_str();
            //System.out.println("-------------------------> JSON");
            //System.out.println(json_str);

            //if(json_str.contains("")){
            String sendType = request.getParameter("sendType");
            if (json_str.contains("No slots found") || json_str.contains("not detected")) {
                throw new Exception("No slots found");
            } else if (sendType.equals("postman")) {
                //response.setContentType("application/json");
                response.getWriter().write(json_str);

            } else if (sendType.equals("pre-production") || sendType.equals("production")) {

                new _001_connect_and_submit_document().submitDocument(json_str);
                response.getWriter().write("Success");

            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            if (message.equals("existDocument")) {
                message = "الرقم الداخلي للفاتورة مسجل من قبل";
            } else if (message.equals("Token Server Not Running")) {
                message = "برنامج التوقيع مغلق";
            } else if (message.equals("Fire Wall Stands On Request Traffic")) {
                message = "جدار الحماية يمنع اللإتصال";
            } else if (message.equals("No slots found")) {
                message = "برجاء التأكد من توصيل فلاشة التوقيع الإلكتروني";
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
