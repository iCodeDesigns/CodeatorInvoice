/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoDeptTaxJoin;
import com.codeator.www._1_2_DB_entities.InvoTaxTypeDtl;
import com.codeator.www._1_3_DB_daos.InvTaxSubtypeDAO;
import com.codeator.www._1_3_DB_daos.InvoDeptTaxJoinDAO;
import com.codeator.www._1_3_DB_daos.InvoTaxTypeDtlDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
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
public class _1_0_0_0_1_Electronic_Invoice_Submit_03_Tax_Info_001_getTaxes extends HttpServlet {

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
                ////System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile perDecisionSheet_1_JasonFile = mapper.readValue(json, _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.class);
             */

            String taxable = request.getParameter("taxable");
            String sectionNoOld = request.getParameter("sectionNoOld");
            String depNoOld = request.getParameter("depNoOld");
            String accUnitId = request.getParameter("accUnitId");
            //List<InvoTaxTypeDtl> pList = new InvoTaxTypeDtlDAO().GetInvoItemCodeByDeptAndSection(taxable, sectionNoOld, depNoOld);

            List<InvoDeptTaxJoin> pList = new InvoDeptTaxJoinDAO().GetInvoItemCodeByDeptAndSection(taxable, accUnitId, sectionNoOld, depNoOld);
            _200_Submit_Documents_012_taxableItem[] taxableItemList = new _200_Submit_Documents_012_taxableItem[pList.size()];

            int i = 0;
            for (InvoDeptTaxJoin invoTaxTypeDtl : pList) {

                _200_Submit_Documents_012_taxableItem taxableItem = new _200_Submit_Documents_012_taxableItem();
                taxableItem.setTaxType(invoTaxTypeDtl.getId().getTaxType());//taxType
                taxableItem.setTaxTypeName(invoTaxTypeDtl.getInvoTaxTypeDtl().getInvoTaxType().getATaxName());//taxTypeName

                taxableItem.setSubType(invoTaxTypeDtl.getId().getTaxSubtype());//subType
                taxableItem.setSubTypeName(invoTaxTypeDtl.getTaxNickname());//subTypeName
                taxableItem.setRate(invoTaxTypeDtl.getRate().doubleValue());//subTypeName
                taxableItemList[i] = taxableItem;
                i++;
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(taxableItemList);
            ////System.out.println(pList.size());
            // success
            response.setContentType("application/json");
            response.getWriter().write(json);
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
