/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._6_0_1_AjaxServlets_For_Developers;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppSubTab;
import com.codeator.www._1_2_DB_entities.AppSubTabSpecAuth;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.AppSubTabSpecAuth_DAO;
import com.codeator.www._1_3_DB_daos.AppSubTab_DAO;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
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
public class _9_9_9_9_9_6_Application_Menu_Index_Sort_Ajax_1_LoadDataFromApplicationSubTabsSpecAuth_AjaxServlet extends HttpServlet {

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

            String applicationIdS = request.getParameter("applicationIdS");
            String applicationTabIdS = request.getParameter("applicationTabIdS");
            String searchEmpId = request.getParameter("searchEmpId");
            String HTML_TEXT = "";// vacStatus = "0" Deal With Ajax Request from (_0_0_0_0_4_1_PerEmpVacationReqJava.jsp) عرض حالة طلب الاجازات للموظف الواحد

            List<PerEmploymentMaster> pemList = new PerEmploymentMasterDao().GetEmployeesByEmployee_ID(searchEmpId);
            if (pemList.isEmpty()) {
                throw new Exception();
            }
            PerEmploymentMaster pem = pemList.get(0);

            List<AppSubTab> pList = new AppSubTab_DAO().get_ApplicationSubTabsByApplicationIdExceptAuthType1(applicationIdS, applicationTabIdS);
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"4\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                        + "</tr>";
            } else {
                for (AppSubTab p : pList) {
                    List<AppSubTabSpecAuth> screenAuthList = new AppSubTabSpecAuth_DAO().getEmpSubTabSpecAuth("" + pem.getEmployeeId(), "" + p.getId().getApplicationId(), "" + p.getId().getTabId(), "" + p.getId().getSubTabId());
                    String checked;
                    int PrimaryAuthPass;
                    if (screenAuthList.isEmpty()) {
                        checked = "";
                        PrimaryAuthPass = 1;
                    } else {
                        checked = "checked";
                        AppSubTabSpecAuth astsa = screenAuthList.get(0);
                        PrimaryAuthPass = astsa.getPrimaryAuthPass();
                    }

                    HTML_TEXT += "<tr>\n"
                            + "                    <td style=\"font-weight: bold;\" class='sub_tab_id'>" + p.getId().getApplicationId() + "-" + p.getId().getTabId() + "-" + p.getId().getSubTabId() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getSubTabName() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">"
                            + "                         <div class=\"\">\n"
                            + "                            <label>\n"
                            + "                              <input type=\"checkbox\" name='cheackBox1' class=\"js-switch\" " + checked + " />\n"
                            + "                            </label>\n"
                            + "                          </div>"
                            + "                     </td>\n"
                            + "                     <td>"
                            + "                         <select style=\"font-size: 15px;font-weight: bold;\"  name=\"primaryAuthPass\" class=\"form-control\" >"
                            + "                             <option value='1' " + (PrimaryAuthPass == 1 ? "selected" : "") + ">private user Access</option>"
                            + "                             <option value='2' " + (PrimaryAuthPass == 2 ? "selected" : "") + ">public user Access</option>"
                            + "                         </select>"
                            + "                     </td>"
                            + "</tr>\n";
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
