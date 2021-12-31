/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._6_0_1_AjaxServlets_For_Developers;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppName;
import com.codeator.www._1_3_DB_daos.AppName_DAO;
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
public class _9_9_9_9_9_9_Application_Super_Control_Ajax_1_LoadBasicDataFromApplicationName_AjaxServlet extends HttpServlet {

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

            String HTML_TEXT = "";// vacStatus = "0" Deal With Ajax Request from (_0_0_0_0_4_1_PerEmpVacationReqJava.jsp) عرض حالة طلب الاجازات للموظف الواحد

            List<AppName> pList = new AppName_DAO().getAll_ApplicationName();
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"4\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                        + "</tr>";
            } else {
                for (AppName p : pList) {
                    HTML_TEXT += "<tr>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getApplicationId() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getApplicationIndex() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getApplicationName() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">"
                            + " <button class=\"btn btn-success form-group fa fa-edit\" style=\"height: 5%;box-shadow: -1px 2px 5px 1px black;margin: 0px;\" data-toggle=\"modal\" data-target=\".UpdateApplication\" onclick=\"updateApplicationName(" + p.getApplicationId() + ",'" + p.getApplicationName() + "');\"  type=\"button\"></button>"
                            + " <button class=\"btn btn-danger form-group fa fa-trash\" style=\"height: 5%;box-shadow: -1px 2px 5px 1px black;margin: 0px;\" data-toggle=\"modal\" data-target=\".DeleteApplication\" onclick=\"deleteApplicationName(" + p.getApplicationId() + ");\" type=\"button\"></button>"
                            + "</td>\n";
                }
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

}
