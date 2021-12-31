/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._6_0_Json_entities._1_0_0_1_4_Electronic_Invoice_Count_Report;
import com.codeator.www._6_0_Json_entities._1_0_0_1_4_Electronic_Invoice_Count_Report_2;
import com.codeator.www._6_0_Json_entities._1_0_0_1_4_Electronic_Invoice_Count_Report_DataQuery;
import com.codeator.www._6_0_Json_entities._1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class _1_0_0_1_5_Electronic_Invoice_Count_Report_insert_Query_Ajax_1_search_counts_AjaxServlet extends HttpServlet {

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

            List<InvoAccUintDept> all_dept = null;
            if (counts.getDept().size() > 0) {
                all_dept = new PerDeptOldDao().GetAllAccDeptInInvoiceInDepts(counts.getDept());
            } else {
                all_dept = new PerDeptOldDao().GetAllAccDeptInInvoice();
            }

            List<String> taxTypeDtl = new ArrayList<>();
            for (_1_0_0_1_4_Electronic_Invoice_Count_Report_2 tax : counts.getTaxSubType()) {
                taxTypeDtl.add(tax.getValue());
            }

            List<_1_0_0_1_4_Electronic_Invoice_Count_Report_DataQuery> JSON_Array = new ArrayList<_1_0_0_1_4_Electronic_Invoice_Count_Report_DataQuery>();
            for (InvoAccUintDept perDeptOld : all_dept) {
                _1_0_0_1_4_Electronic_Invoice_Count_Report_DataQuery data = new _1_0_0_1_4_Electronic_Invoice_Count_Report_DataQuery();
                data.setDeptOld("" + perDeptOld.getId().getDepNoOld());
                data.setSectionOld("" + perDeptOld.getId().getSectionNoOld());
                data.setDeptName(perDeptOld.getInvoAccUnitsCode().getAccUnitName() + "-" + perDeptOld.getPerDeptOld().getDepName());

                // get Counts
                List<_1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl> dataDetail = new ArrayList<_1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl>();
                for (String tax : taxTypeDtl) {

                    InvoInvoiceMasterDao invoInvoiceMasterDao = new InvoInvoiceMasterDao();
                    //long count = invoInvoiceMasterDao.GetCountInvoSp("" + perDeptOld.getId().getSectionNoOld(), "" + perDeptOld.getId().getDepNoOld(), perDeptOld.getId().getAccUnitCode(), documentStatu, fromDate, toDate, createdDate_OR_issueDate);
                    BigDecimal sum = invoInvoiceMasterDao.GetSumTaxInvoSp("" + perDeptOld.getId().getSectionNoOld(), "" + perDeptOld.getId().getDepNoOld(), perDeptOld.getId().getAccUnitCode(), tax, fromDate, toDate, createdDate_OR_issueDate);

                    _1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl detail = new _1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl();
                    detail.setDocumentStatusId(tax);
                    //detail.setDocumentStatusName(documentStatu);
                    //detail.setCount("" + count);
                    detail.setSum("" + sum.doubleValue());

                    dataDetail.add(detail);
                }
                data.setDataDetail(dataDetail);
                JSON_Array.add(data);
            }
            //-- Convert Article Class to JSON
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            json = mapper.writeValueAsString(JSON_Array);

            response.setContentType("application/json");
            //-- Response JSON
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
