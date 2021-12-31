/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoDeptUnitJoin;
import com.codeator.www._1_2_DB_entities.InvoUnitType;
import com.codeator.www._1_3_DB_daos.InvoDeptUnitJoinDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._201_units_in_dept;
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
public class _1_0_0_0_9_Invo_Item_Tax_Unit_Join_03_getUnits_AjaxServlet extends HttpServlet {

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

            List<InvoDeptUnitJoin> selectedTaxList = new InvoDeptUnitJoinDAO().GetSelectedUnitInDept(accUnitId, sectionId, deptId);
            List<InvoUnitType> notSelectedTaxList = new InvoDeptUnitJoinDAO().GetNotSelectedUnitInDept(accUnitId, sectionId, deptId);
            int data_size = selectedTaxList.size() + notSelectedTaxList.size();
            _201_units_in_dept[] unit_list = new _201_units_in_dept[data_size];
            int i = 0;

            for (InvoDeptUnitJoin p : selectedTaxList) {
                _201_units_in_dept unit = new _201_units_in_dept();

                unit.setDeptId(deptId);
                unit.setSectionId(sectionId);
                unit.setAccUnitId(accUnitId);
                

                unit.setUnitCode(p.getInvoUnitType().getUnitType());
                unit.setUnitName(p.getInvoUnitType().getAUnitName());
                unit.setUnitNickName(p.getUnitNickname());
                unit.setActive("true");
                unit_list[i] = unit;
                i++;
            }

            for (InvoUnitType p : notSelectedTaxList) {
                _201_units_in_dept unit = new _201_units_in_dept();

                unit.setDeptId(deptId);
                unit.setSectionId(sectionId);
                unit.setAccUnitId(accUnitId);

                unit.setUnitCode(p.getUnitType());
                unit.setUnitName(p.getAUnitName());
                unit.setUnitNickName(p.getAUnitName());
                unit.setActive("false");
                unit_list[i] = unit;
                i++;
            }

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(unit_list);
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
