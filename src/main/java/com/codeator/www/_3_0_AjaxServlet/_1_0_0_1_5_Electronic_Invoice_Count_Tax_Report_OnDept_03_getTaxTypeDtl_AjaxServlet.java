/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoTaxTypeDtl;
import com.codeator.www._1_3_DB_daos.InvoTaxTypeDtlDAO;
import com.codeator.www._6_1_Json_entities.InvoTaxTypeDtlId;
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
 * @author Moham
 */
public class _1_0_0_1_5_Electronic_Invoice_Count_Tax_Report_OnDept_03_getTaxTypeDtl_AjaxServlet extends HttpServlet {

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
            /*BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            String[] accUnitCode_arr = mapper.readValue(json, String[].class);*/

            String taxable = request.getParameter("taxable");
            List<InvoTaxTypeDtl> pList = new InvoTaxTypeDtlDAO().GetInvoItemCodeByTaxble(taxable);
            com.codeator.www._6_1_Json_entities.InvoTaxTypeDtl[] InvoTaxTypeDtl = new com.codeator.www._6_1_Json_entities.InvoTaxTypeDtl[pList.size()];

            int i = 0;
            for (InvoTaxTypeDtl pcst : pList) {

                com.codeator.www._6_1_Json_entities.InvoTaxTypeDtl r = new com.codeator.www._6_1_Json_entities.InvoTaxTypeDtl();
                InvoTaxTypeDtlId id = new InvoTaxTypeDtlId();
                id.setTaxType(pcst.getId().getTaxType());
                id.setTaxSubtype(pcst.getId().getTaxSubtype());
                r.setId(id);
                
                r.setATaxSubname(pcst.getATaxSubname());
                r.setEtaxSubname(pcst.getEtaxSubname());
                InvoTaxTypeDtl[i] = r;
                i++;
                
            }

            ObjectMapper mapper = new ObjectMapper();
            String json1 = mapper.writeValueAsString(InvoTaxTypeDtl);
            //System.out.println(pList.size());
            // success
            response.setContentType("application/json");
            response.getWriter().write(json1);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
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
