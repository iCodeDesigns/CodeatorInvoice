/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._6_0_1_AjaxServlets_For_Developers;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppName;
import com.codeator.www._1_2_DB_entities.AppSubElem;
import com.codeator.www._1_2_DB_entities.AppSubElemSpecAuth;
import com.codeator.www._1_2_DB_entities.AppSubElemSpecAuthId;
import com.codeator.www._1_2_DB_entities.AppSubTab;
import com.codeator.www._1_2_DB_entities.AppTabs;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.AppName_DAO;
import com.codeator.www._1_3_DB_daos.AppSubElemSpecAuth_DAO;
import com.codeator.www._1_3_DB_daos.AppSubElem_DAO;
import com.codeator.www._1_3_DB_daos.AppSubTab_DAO;
import com.codeator.www._1_3_DB_daos.AppTabs_DAO;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _9_9_9_9_9_5_Application_Menu_Screen_Elements_Ajax_1_LoadDataFromElements_AjaxServlet extends HttpServlet {

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
                        + "    <td colspan=\"6\" style=\"align-items: center;\">لا يوجد أنظمة</td>\n"
                        + "</tr>";
            } else {
                int color_index = 0;
                for (AppName p : pList) {
                    String ColorStyle = (color_index % 2 == 0) ? "style='background-color : gainsboro;'" : "";

                    int No_of_SubTabs_In_Application = 0;
                    for (AppTabs AppTabse : p.getAppTabses()) {
                        if (AppTabse.getAppSubTabs().isEmpty()) {
                            No_of_SubTabs_In_Application += 1;
                        } else {
                            No_of_SubTabs_In_Application += AppTabse.getAppSubTabs().size();
                        }

                    }
                    /**
                     * First Row Of Each Application
                     */
                    List<AppTabs> tabList = new AppTabs_DAO().get_ApplicationTabsByApplicationId("" + p.getApplicationId());
                    List<AppSubTab> subTabList = new ArrayList<>();
                    String rowSpanMain = (No_of_SubTabs_In_Application != 0) ? "rowspan='" + No_of_SubTabs_In_Application + "'" : "rowspan='1'";
                    HTML_TEXT += "<tr " + ColorStyle + ">\n"
                            + "         <td " + rowSpanMain + ">" + p.getApplicationName() + "</td>\n";
                    if (tabList.isEmpty()) {
                        HTML_TEXT += "  <td colspan='5'>No Tabs</td>\n";
                    } else {
                        /**
                         * First Tab
                         */
                        AppTabs FirstAT = tabList.get(0);
                        int No_of_SubTabs_In_ApplicationTab = FirstAT.getAppSubTabs().size();

                        String rowSpan = (No_of_SubTabs_In_ApplicationTab != 0) ? "rowspan='" + No_of_SubTabs_In_ApplicationTab + "'" : "rowspan='1'";
                        HTML_TEXT += ""
                                + "      <td " + rowSpan + ">" + FirstAT.getTabName() + "</td>\n";

                        subTabList = new AppSubTab_DAO().get_ApplicationSubTabsByApplicationId("" + FirstAT.getId().getApplicationId(), "" + FirstAT.getId().getTabId());

                        if (subTabList.isEmpty()) {
                            HTML_TEXT += "  <td colspan='3'>No Sub Tabs</td>\n";
                        } else {
                            AppSubTab FirstAST = subTabList.get(0);
                            /**
                             * First Sub Tab
                             */
                            boolean SkipSubTab = (FirstAST.getAppSubTabAuthType().getAuthTypeId() == 1);

                            HTML_TEXT += ""
                                    + "      <td>" + FirstAST.getSubTabName() + "</td>\n";

                            if (SkipSubTab) {
                                HTML_TEXT += "   <td colspan='2'>This Sub Tab For All Users</td>\n";
                            } else {
                                /**
                                 * First Element
                                 */
                                int No_of_Elements_In_AppSubTab = FirstAST.getAppSubElems().size();

                                HTML_TEXT += "   <td>" + No_of_Elements_In_AppSubTab + "</td>\n"
                                        + "      <td> "
                                        + "         <button type=\"button\" class=\"fa fa-search btn btn-primary form-control\" onclick=\"FillElementModel('" + FirstAST.getId().getApplicationId() + "','" + FirstAST.getId().getApplicationId() + "-" + FirstAST.getId().getTabId() + "','" + FirstAST.getId().getApplicationId() + "-" + FirstAST.getId().getTabId() + "-" + FirstAST.getId().getSubTabId() + "')\" data-toggle=\"modal\" data-target=\".elementsModel\" style=\"font-size: large;font-weight: bold;border: 2px solid black;box-shadow: -1px 5px 8px black;\"></button>"
                                        + "      </td>\n";
                            }

                        }
                    }
                    HTML_TEXT += "  </tr>";
                    ////////////////////////////////////////////////////////////////////////////
                    /**
                     * The Rest Of SubTabs if Exist in First Tab
                     */
                    HTML_TEXT += getRestOfSubTabsHTML(subTabList, ColorStyle);

                    ////////////////////////////////////////////////////////////////////////////
                    /**
                     * The Rest Of Tabs if Exist in First Application
                     */
                    if (tabList.size() > 1) {
                        for (int i = 1; i < tabList.size(); i++) {
                            HTML_TEXT += "<tr " + ColorStyle + ">";
                            AppTabs RestAT = tabList.get(i);
                            int No_of_SubTabs_In_ApplicationTab = RestAT.getAppSubTabs().size();

                            String rowSpan = (No_of_SubTabs_In_ApplicationTab != 0) ? "rowspan='" + No_of_SubTabs_In_ApplicationTab + "'" : "rowspan='1'";
                            HTML_TEXT += ""
                                    + "      <td " + rowSpan + " >" + RestAT.getTabName() + "</td>\n";

                            subTabList = new AppSubTab_DAO().get_ApplicationSubTabsByApplicationId("" + RestAT.getId().getApplicationId(), "" + RestAT.getId().getTabId());

                            if (subTabList.isEmpty()) {
                                HTML_TEXT += "  <td colspan='3'>No Sub Tabs</td>\n";
                            } else {

                                AppSubTab RestAST = subTabList.get(0);
                                /**
                                 * First Sub Tab
                                 */
                                boolean SkipSubTab = (RestAST.getAppSubTabAuthType().getAuthTypeId() == 1);
                                HTML_TEXT += ""
                                        + "      <td>" + RestAST.getSubTabName() + "</td>\n";

                                if (SkipSubTab) {
                                    HTML_TEXT += "   <td colspan='2'>This Sub Tab For All Users</td>\n";
                                } else {
                                    /**
                                     * First Element
                                     */
                                    int No_of_Elements_In_AppSubTab = RestAST.getAppSubElems().size();

                                    HTML_TEXT += "   <td>" + No_of_Elements_In_AppSubTab + "</td>\n"
                                            + "      <td> "
                                            + "         <button type=\"button\" class=\"fa fa-search btn btn-primary form-control\" onclick=\"FillElementModel('" + RestAST.getId().getApplicationId() + "','" + RestAST.getId().getApplicationId() + "-" + RestAST.getId().getTabId() + "','" + RestAST.getId().getApplicationId() + "-" + RestAST.getId().getTabId() + "-" + RestAST.getId().getSubTabId() + "')\" data-toggle=\"modal\" data-target=\".elementsModel\" style=\"font-size: large;font-weight: bold;border: 2px solid black;box-shadow: -1px 5px 8px black;\"></button>"
                                            + "      </td>\n";
                                }
                            }
                            HTML_TEXT += "</tr>";
                            /**
                             * The Rest Of SubTabs if Exist in First Tab
                             */
                            HTML_TEXT += getRestOfSubTabsHTML(subTabList, ColorStyle);
                        }
                    }
                    color_index++;
                }
            }

            response.getWriter().write(HTML_TEXT);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
        }

        new HibernateSessionCon().closeConn();
    }

    private String getRestOfSubTabsHTML(List<AppSubTab> subTabList, String ColorStyle) {
        String HTML_TEXT = "";
        if (subTabList.size() > 1) {
            for (int ii = 1; ii < subTabList.size(); ii++) {
                AppSubTab RestAST = subTabList.get(ii);
                boolean SkipSubTab = (RestAST.getAppSubTabAuthType().getAuthTypeId() == 1);
                HTML_TEXT += "<tr " + ColorStyle + ">"
                        + "      <td>" + RestAST.getSubTabName() + "</td>\n";
                if (SkipSubTab) {
                    HTML_TEXT += "   <td colspan='2'>This Sub Tab For All Users</td>\n";
                } else {
                    /**
                     * First Element
                     */
                    int No_of_Elements_In_AppSubTab = RestAST.getAppSubElems().size();

                    HTML_TEXT += "   <td>" + No_of_Elements_In_AppSubTab + "</td>\n"
                            + "      <td> "
                            + "         <button type=\"button\" class=\"fa fa-search btn btn-primary form-control\" onclick=\"FillElementModel('" + RestAST.getId().getApplicationId() + "','" + RestAST.getId().getApplicationId() + "-" + RestAST.getId().getTabId() + "','" + RestAST.getId().getApplicationId() + "-" + RestAST.getId().getTabId() + "-" + RestAST.getId().getSubTabId() + "')\" data-toggle=\"modal\" data-target=\".elementsModel\" style=\"font-size: large;font-weight: bold;border: 2px solid black;box-shadow: -1px 5px 8px black;\"></button>"
                            + "      </td>\n";
                }
            }
        }
        return HTML_TEXT;
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
