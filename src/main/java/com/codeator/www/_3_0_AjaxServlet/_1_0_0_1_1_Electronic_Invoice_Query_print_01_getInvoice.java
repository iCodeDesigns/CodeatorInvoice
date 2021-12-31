/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.alahram.constants.InvoiceDocumentConstants;
import com.codeator.www._0_0_CodeatorLib.MathOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterItem;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterTax;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterItemDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterTaxDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_003_receiver;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_004_address;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_009_unitValue;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_010_discount;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _1_0_0_1_1_Electronic_Invoice_Query_print_01_getInvoice extends HttpServlet {

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
            String sectionId = request.getParameter("sectionId");
            String deptId = request.getParameter("deptId");
            String accUnitCode = request.getParameter("accUnitId");
            String searchType = request.getParameter("searchType");

            _200_Submit_Documents_001_document[] _200_Submit_Documents_001_document_arr;
            if (searchType.equals("bulk")) {
                List<String> documentStatus = new ArrayList<String>() {
                    {
                        add("0");//تمت المراجعة
                        add("1");//تمت المراجعة
                        add("2");//تمت المراجعة
                        add("3");//تمت المراجعة
                        add("4");//تمت المراجعة
                        add("5");//تمت المراجعة
                        add("6");//تمت المراجعة
                        add("7");//تمت المراجعة
                        add("8");//تمت المراجعة
                        add("9");//تمت المراجعة
                        add("17");//تمت المراجعة
                    }
                };
                _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class getAllInvoice
                        = new _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class();

                String fromDate = request.getParameter("fromDate");
                String toDate = request.getParameter("toDate");
                String createdDate_OR_issueDate = request.getParameter("createdDate_OR_issueDate");
                getAllInvoice.setUsePeriod(true);//الاستعلام برقم الفاتورة
                getAllInvoice.setFromDate(fromDate);
                getAllInvoice.setToDate(toDate);
                getAllInvoice.setCreatedDate_OR_issueDate(createdDate_OR_issueDate);

                //getAllInvoice.setInternalID(internalId);//رقم الفاتورة
                getAllInvoice.setLast_document_of_same_internalID(true);

                _200_Submit_Documents_001_document_arr
                        = getAllInvoice.getMultiInvoices(deptId, sectionId, accUnitCode, documentStatus, searchType);

            } else {
                _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class getAllInvoice
                        = new _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class();

                String invSp = request.getParameter("invSp");
                getAllInvoice.setAllowSplit(true);

                _200_Submit_Documents_001_document_arr
                        = getAllInvoice.getOneInvoices(deptId, sectionId, accUnitCode, invSp);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();
            String json = "";
            json = mapper.writeValueAsString(_200_Submit_Documents_001_document_arr);
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
