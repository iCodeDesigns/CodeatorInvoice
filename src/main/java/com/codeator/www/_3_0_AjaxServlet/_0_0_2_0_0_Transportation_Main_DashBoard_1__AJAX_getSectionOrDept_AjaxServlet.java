/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.PerSectionOld;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._1_3_DB_daos.PerSectionOldDao;
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
public class _0_0_2_0_0_Transportation_Main_DashBoard_1__AJAX_getSectionOrDept_AjaxServlet extends HttpServlet {

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
            String searchLevel = request.getParameter("searchLevel");
            String HTML_TEXT = "";
            switch (searchLevel) {
                case "Section":
                    HTML_TEXT += getSectionComboHTML();
                    break;

                case "Dept":
                    HTML_TEXT += getDeptComboHTML();
                    break;
                default:
                    throw new Exception();
            }

            response.getWriter().write(HTML_TEXT);
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

    private String getSectionComboHTML() {
        String HTML_TEXT = "";
        List<PerSectionOld> pList = new PerSectionOldDao().GetAllSections();

        if (pList.isEmpty()) {
            HTML_TEXT = "";
        } else {
            HTML_TEXT += "<option value=\"\"></option>";
            HTML_TEXT += "<option style=\"font-weight: bold; font-size: medium;\" value=\"All\" >كل الأقسام</option>";
            for (PerSectionOld p : pList) {
                if (p.getSectionName().equals("بدون")) {
                    continue;
                }
                HTML_TEXT += "<option style=\"font-weight: bold; font-size: medium;\" value=\"" + p.getSectionNoOld() + "\">" + p.getSectionName() + "</option>";
            }
        }
        return HTML_TEXT;
    }

    private String getDeptComboHTML() {

        String HTML_TEXT = "";
        List<PerDeptOld> pList = new PerDeptOldDao().GetAllDept();

        if (pList.isEmpty()) {
            HTML_TEXT = "";
        } else {
            HTML_TEXT += "<option value=\"\"></option>";
            HTML_TEXT += "<option style=\"font-weight: bold; font-size: medium;\" value=\"All\" >كل الإدارات</option>";

            for (PerDeptOld p : pList) {
                if (p.getDepName().equals("بدون")) {
                    continue;
                }
                HTML_TEXT += "<option style=\"font-weight: bold; font-size: medium;\" value=\"" + p.getId().getSectionNoOld() + "-" + p.getId().getDepNoOld() + "\">" + p.getDepName() + "</option>";
            }
        }
        return HTML_TEXT;
    }
}
