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
 * @author Mohamed
 */
public class _1_0_0_1_6_Electronic_Dept_Credit_Count_Report_OnDept_03_getInvoicesDtlFromInvoiceMain_AjaxServlet extends HttpServlet {

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
            String deptId = request.getParameter("deptOld");
            String sectionId = request.getParameter("sectionOld");
            String accUnitId = request.getParameter("accUnitId");
            String inv_sp = request.getParameter("inv_sp");

            _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class getAllInvoices
                    = new _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class();

            List<InvoInvoiceMaster> pList = new InvoInvoiceMasterDao().GetInvoInvoiceMasterBySeq(inv_sp, deptId, sectionId, accUnitId);
            _200_Submit_Documents_001_document[] _200_Submit_Documents_001_document_arr_main
                    = getAllInvoices.generalInvoice_Data_collection(deptId, sectionId, accUnitId, pList);

            _200_Submit_Documents_001_document[] _200_Submit_Documents_001_document_arr_dtl
                    = getAllInvoices.getInvoicesMainDtl(deptId, sectionId, accUnitId, inv_sp);

            // determines length of firstArray
            int main_length = _200_Submit_Documents_001_document_arr_main.length;

            // determines length of secondArray
            int dtl_length = _200_Submit_Documents_001_document_arr_dtl.length;

            // resultant array size
            int length = main_length + dtl_length;

            _200_Submit_Documents_001_document[] _200_Submit_Documents_001_document_arr
                    = new _200_Submit_Documents_001_document[length];

            System.arraycopy(_200_Submit_Documents_001_document_arr_main, 0, _200_Submit_Documents_001_document_arr, 0, main_length);
            System.arraycopy(_200_Submit_Documents_001_document_arr_dtl, 0, _200_Submit_Documents_001_document_arr, main_length, dtl_length);
            /*_200_Submit_Documents_001_document_arr[0] = _200_Submit_Documents_001_document_arr_main[0];
            for (int i = 0; i < _200_Submit_Documents_001_document_arr_dtl.length; i++) {
                _200_Submit_Documents_001_document_arr[i + 1] = _200_Submit_Documents_001_document_arr_dtl[i];
            }*/
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();
            String json = "";
            json = mapper.writeValueAsString(_200_Submit_Documents_001_document_arr);
            // success
            response.setContentType("application/json");
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
