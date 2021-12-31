/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._6_0_1_AjaxServlets_For_Developers;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppName;
import com.codeator.www._1_2_DB_entities.AppSubTab;
import com.codeator.www._1_2_DB_entities.AppTabs;
import com.codeator.www._1_3_DB_daos.AppName_DAO;
import com.codeator.www._1_3_DB_daos.AppSubTab_DAO;
import com.codeator.www._1_3_DB_daos.AppTabs_DAO;
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
public class _9_9_9_9_9_9_Application_Super_Control_Ajax_92_LoadBasicDataFromApplicationSubTabs_AjaxServlet extends HttpServlet {

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
                        + "    <td style=\"align-items: center;\">لا توجد أنظمة</td>\n"
                        + "</tr>";
            } else {
                for (AppName app : pList) {
                    HTML_TEXT += "<thead style=\"background-color: #337ab7;color: white;\">\n"
                            + "      <tr>\n"
                            + "          <th style=\"text-align: center;font-size: large;\">" + app.getApplicationName() + "</th>\n"
                            + "      </tr>                                            \n"
                            + "  </thead>    \n";

                    HTML_TEXT += "  <tbody>\n";
                    List<AppTabs> AppTabsList = new AppTabs_DAO().get_ApplicationTabsByApplicationId("" + app.getApplicationId());
                    if (AppTabsList.isEmpty()) {
                        HTML_TEXT += "<tr>\n"
                                + "     <td style=\"text-align: center;font-size: large;\">لا توجد قوائم</td>\n"
                                + "   </tr>\n";
                    } else {
                        //int i = 0;
                        for (AppTabs Tabs : AppTabsList) {
                            String tabCode = Tabs.getId().getTabId() + "-" + Tabs.getId().getApplicationId();
                            HTML_TEXT += "      <tr>\n"
                                    + "          <td>\n"
                                    + "              <div class=\"x_panel\" style=\"box-shadow: -1px 2px 5px 1px #929292;\">\n"
                                    + "                  <div class=\"x_title\" style=\"text-align: right;\" onclick=\"show('content" + tabCode + "');\">\n"
                                    + "                      <h2 style=\"width: 50%;\">" + Tabs.getTabName() + "</h2>\n"
                                    + "                      <ul class=\"nav navbar-left panel_toolbox\" style=\"direction: ltr;float: left;width: 50%;\">\n"
                                    + "                          <li><a class=\"collapse-link\"><i class=\"fa fa-chevron-down\"></i></a>\n"
                                    + "                          </li>\n"
                                    + "                      </ul>\n"
                                    + "                      <div class=\"clearfix\" ></div>\n"
                                    + "                  </div>\n"
                                    + "                  <!-- for Edit -->                            \n"
                                    + "                  <div class=\"\" id='content" + tabCode + "' style='display:none'>\n"
                                    + "                      <table class=\"table table-striped table-bordered table-hover\" style=\"text-align: center;font-size: large;\">                                                                    \n"
                                    + "                          <thead style=\"background-color: green;color: white;\">\n"
                                    + "                              <tr>\n"
                                    + "                                  <th style=\"text-align: center;font-size: large;\">كود الشاشة</th>\n"
                                    + "                                  <th style=\"text-align: center;font-size: large;\">إسم الشاشة</th>\n"
                                    + "                                  <th style=\"text-align: center;font-size: large;\">إسم ال Access Servlet</th>\n"
                                    + "                              </tr>                                            \n"
                                    + "                          </thead>\n"
                                    + "                          <tbody>\n";

                            List<AppSubTab> ppList = new AppSubTab_DAO().get_ApplicationSubTabsByApplicationId("" + Tabs.getId().getApplicationId(), "" + Tabs.getId().getTabId());
                            if (ppList.isEmpty()) {
                                HTML_TEXT += "<tr>\n"
                                        + "     <td colspan='3' style=\"text-align: center;font-size: large;\">لا توجد شاشات</td>\n"
                                        + "   </tr>\n";
                            } else {
                                for (AppSubTab SubTab : ppList) {
                                    String AuthTypeId = "";
                                    try {
                                        AuthTypeId = "" + SubTab.getAppSubTabAuthType().getAuthTypeId();
                                    } catch (Exception e) {
                                        AuthTypeId = "";
                                    }
                                    HTML_TEXT += "                              <tr>\n"
                                            + "                                  <td style=\"text-align: center;font-size: large;\">" + SubTab.getId().getApplicationId() + "-" + SubTab.getId().getTabId() + "-" + SubTab.getId().getSubTabId() + "</td>\n"
                                            + "                                  <td style=\"text-align: center;font-size: large;\">" + SubTab.getSubTabName() + "</td>\n"
                                            + "                                  <td style=\"text-align: center;font-size: large;direction:ltr;\">" + SubTab.getSubTabAccessservlet() + "</td>\n"
                                            + "                                  <td style=\"font-weight: bold;\">"
                                            + "     <button class=\"btn btn-success form-group fa fa-edit\" style=\"height: 5%;box-shadow: -1px 2px 5px 1px black;margin: 0px;\" data-toggle=\"modal\" data-target=\".UpdateAppSubTabs\" onclick=\"updateAppSubTabs(" + SubTab.getId().getApplicationId() + "," + SubTab.getId().getTabId() + "," + SubTab.getId().getSubTabId() + ",'" + SubTab.getSubTabName() + "','" + SubTab.getSubTabAccessservlet() + "','" + SubTab.getAvailableToUserControl() + "','" + AuthTypeId + "');\"  type=\"button\"></button>"
                                            + "     <button class=\"btn btn-danger form-group fa fa-trash\" style=\"height: 5%;box-shadow: -1px 2px 5px 1px black;margin: 0px;\" data-toggle=\"modal\" data-target=\".DeleteAppSubTabs\" onclick=\"deleteAppSubTabs(" + SubTab.getId().getApplicationId() + "," + SubTab.getId().getTabId() + "," + SubTab.getId().getSubTabId() + ");\" type=\"button\"></button>"
                                            + "                                  </td>\n"
                                            + "                              </tr>\n";
                                }
                            }

                            HTML_TEXT += "                          </tbody>\n"
                                    + "                      </table>\n"
                                    + "                  </div>\n"
                                    + "              </div>\n"
                                    + "          </td>\n"
                                    + "      </tr>\n";
                        }
                    }

                    HTML_TEXT += "  </tbody>";
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
