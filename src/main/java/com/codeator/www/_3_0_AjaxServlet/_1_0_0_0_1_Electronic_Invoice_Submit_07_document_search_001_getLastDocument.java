/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_0_1_Electronic_Invoice_Submit_07_document_search_001_getLastDocument extends HttpServlet {

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
            String deptId = request.getParameter("depNoOld");
            String sectionId = request.getParameter("sectionNoOld");
            String accUnitCode = request.getParameter("accUnitId");
            String internalId = request.getParameter("internalId");
            List<String> documentStatus = new ArrayList<String>() {
                {
                    add("9");//تمت المراجعة
                }
            };
            _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class getAllInvoice
                    = new _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class();

            getAllInvoice.setSearchByInternalID(true);//رقم الفاتورة
            getAllInvoice.setInternalID(internalId);//رقم الفاتورة
            getAllInvoice.setAllowSplit(false);// لا تسمح بالفواتير المقسمة
            getAllInvoice.setLast_document_of_same_internalID(true);// هات اخر فاتوة اشعار او خصم

            _200_Submit_Documents_001_document[] _200_Submit_Documents_001_document_arr
                    = getAllInvoice.getMultiInvoices(deptId, sectionId, accUnitCode, documentStatus, "internalId");

            if (_200_Submit_Documents_001_document_arr.length == 0) {
                List<InvoInvoiceMaster> iimList = new InvoInvoiceMasterDao().GetInvoInvoiceMasterByInternalIdInDeptAndSection(internalId, deptId, sectionId, accUnitCode);
                if (iimList.isEmpty()) {

                } else {
                    throw new Exception("NotSendToTaxPayerServer");
                }

            }

            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();
            String json = "";
            json = mapper.writeValueAsString(_200_Submit_Documents_001_document_arr);
            System.out.println("json : " + json);
            // success
            response.getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().equals("NotSendToTaxPayerServer")) {
                response.getWriter().write("NotSendToTaxPayerServer");
            } else {
                response.getWriter().write("Error");
            }

        }
        new HibernateSessionCon().clearConn();
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
