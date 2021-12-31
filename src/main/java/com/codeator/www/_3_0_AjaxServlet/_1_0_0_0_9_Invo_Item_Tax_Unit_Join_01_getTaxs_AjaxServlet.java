/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoDeptTaxJoin;
import com.codeator.www._1_2_DB_entities.InvoTaxTypeDtl;
import com.codeator.www._1_3_DB_daos.InvoDeptTaxJoinDAO;
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
public class _1_0_0_0_9_Invo_Item_Tax_Unit_Join_01_getTaxs_AjaxServlet extends HttpServlet {

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
            String deptId = request.getParameter("deptId");
            String sectionId = request.getParameter("sectionId");
            String accUnitId = request.getParameter("accUnitId");

            List<InvoDeptTaxJoin> selectedTaxList = new InvoDeptTaxJoinDAO().GetSelectedTaxInDept(accUnitId, sectionId, deptId);
            List<InvoTaxTypeDtl> notSelectedTaxList = new InvoDeptTaxJoinDAO().GetNotSelectedTaxInDept(accUnitId, sectionId, deptId);
            int data_size = selectedTaxList.size() + notSelectedTaxList.size();
            _200_Submit_Documents_012_taxableItem[] tax_list = new _200_Submit_Documents_012_taxableItem[data_size];
            int i = 0;

            for (InvoDeptTaxJoin p : selectedTaxList) {
                _200_Submit_Documents_012_taxableItem tax = new _200_Submit_Documents_012_taxableItem();

                tax.setDeptId(deptId);
                tax.setSectionId(sectionId);
                tax.setAccUnitId(accUnitId);

                tax.setTaxType(p.getId().getTaxType());
                tax.setTaxTypeName(p.getInvoTaxTypeDtl().getATaxSubname());

                tax.setSubType(p.getId().getTaxSubtype());
                tax.setSubTypeName(p.getInvoTaxTypeDtl().getATaxSubname());

                tax.setSubTypeNickName(p.getTaxNickname());

                tax.setRate(p.getRate().doubleValue());
                tax.setActive("true");

                tax.setTaxbleStatus("" + p.getInvoTaxTypeDtl().getInvoTaxType().getTaxable());
                tax_list[i] = tax;
                i++;
            }

            for (InvoTaxTypeDtl p : notSelectedTaxList) {
                _200_Submit_Documents_012_taxableItem tax = new _200_Submit_Documents_012_taxableItem();

                tax.setDeptId(deptId);
                tax.setSectionId(sectionId);

                tax.setTaxType(p.getId().getTaxType());
                tax.setTaxTypeName(p.getInvoTaxType().getATaxName());

                tax.setSubType(p.getId().getTaxSubtype());
                tax.setSubTypeName(p.getATaxSubname());

                tax.setSubTypeNickName(p.getATaxSubname());

                tax.setRate(0.0);
                tax.setActive("false");

                tax.setTaxbleStatus("" + p.getInvoTaxType().getTaxable());

                tax_list[i] = tax;
                i++;
            }

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(tax_list);
            //System.out.println(pList.size());
            // success
            response.setContentType("application/json");
            response.getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
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
