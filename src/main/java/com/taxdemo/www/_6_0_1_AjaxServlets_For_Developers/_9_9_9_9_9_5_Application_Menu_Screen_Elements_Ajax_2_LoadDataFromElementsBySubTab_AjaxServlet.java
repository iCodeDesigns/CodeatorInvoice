/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._6_0_1_AjaxServlets_For_Developers;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppSubElem;
import com.codeator.www._1_3_DB_daos.AppSubElem_DAO;
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
public class _9_9_9_9_9_5_Application_Menu_Screen_Elements_Ajax_2_LoadDataFromElementsBySubTab_AjaxServlet extends HttpServlet {

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
            String applicationId = request.getParameter("applicationId");
            String tabId = request.getParameter("tabId");
            String subTabId = request.getParameter("subTabId");
            String HTML_TEXT = "";
            List<AppSubElem> pList = new AppSubElem_DAO().getAll_ApplicationNameElementBySubTab(applicationId, tabId, subTabId);
            if (pList.isEmpty()) {
                HTML_TEXT += "<tr>\n"
                        + "      <td colspan='4'>No Elements</td>"
                        + "  </tr>";
            } else {
                for (AppSubElem p : pList) {
                    HTML_TEXT += "<tr>\n"
                            + "      <td>" + p.getId().getApplicationId() + "-" + p.getId().getTabId() + "-" + p.getId().getSubTabId() + "-" + p.getId().getElementId() + "</td>\n"
                            + "      <td>" + p.getElementName() + "</td>\n"
                            + "      <td>" + p.getElementType() + "</td>\n"
                            + "      <td>"
                            + "        <button type=\"button\" class=\"fa fa-trash-o btn btn-danger form-control\" onclick=\"deleteData('" + p.getId().getApplicationId() + "','" + p.getId().getTabId() + "','" + p.getId().getSubTabId() + "','" + p.getId().getElementId() + "')\" data-toggle=\"modal\" data-target=\".AlertModal\" style=\"font-size: large;font-weight: bold;border: 2px solid black;box-shadow: -1px 5px 8px black;\"></button>"
                            + "      </td>\n"
                            + "  </tr>";
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
