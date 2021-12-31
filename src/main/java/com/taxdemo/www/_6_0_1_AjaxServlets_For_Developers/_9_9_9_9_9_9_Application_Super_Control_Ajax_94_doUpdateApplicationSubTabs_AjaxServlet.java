/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._6_0_1_AjaxServlets_For_Developers;

import com.codeator.www._0_0_CodeatorLib.Encryption;
import com.codeator.www._0_0_CodeatorLib.FileOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppSubTab;
import com.codeator.www._1_2_DB_entities.AppSubTabAuthType;
import com.codeator.www._1_3_DB_daos.AppSubTabAuthType_DAO;
import com.codeator.www._1_3_DB_daos.AppSubTab_DAO;
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
public class _9_9_9_9_9_9_Application_Super_Control_Ajax_94_doUpdateApplicationSubTabs_AjaxServlet extends HttpServlet {

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
            String subTabName = request.getParameter("subTabName");
            String subTabAccessservlet = request.getParameter("subTabAccessservlet");
            String applicationId = request.getParameter("applicationId");
            String tabId = request.getParameter("tabId");
            String subTabId = request.getParameter("subTabId");
            String authTypeId = request.getParameter("authTypeId");
            String availableToUserControl = request.getParameter("availableToUserControl");

            List<AppSubTab> pList = new AppSubTab_DAO().get_ApplicationSubTabsById(applicationId, tabId, subTabId);

            AppSubTab AppSubTab = pList.get(0);
            AppSubTab.setSubTabAccessservlet(subTabAccessservlet);
            AppSubTab.setSubTabName(subTabName);

            availableToUserControl = new Encryption().enchrypt_AvailableToUserControl(applicationId, tabId, "" + subTabId, availableToUserControl);
            AppSubTab.setAvailableToUserControl(availableToUserControl);
            List<AppSubTabAuthType> ppList = new AppSubTabAuthType_DAO().getApplicationSubTabAuthTypeById(authTypeId);
            if (ppList.isEmpty()) {
                throw new Exception();
            }
            AppSubTabAuthType astat = ppList.get(0);
            AppSubTab.setAppSubTabAuthType(astat);
            /**
             * server C:// File
             */
            String DirectoryPath = "C:\\LIC\\b532t91";
            String FileName = "S_" + applicationId + tabId + subTabId + ".txt";
            List<String> lines = new ArrayList<>();
            lines.add(availableToUserControl);
            new FileOp().CreateAndWriteFileOnWebApp(DirectoryPath, FileName, lines);
            /**
             * DB File
             */

            new HibernateSessionCon().beginTrans();
            new AppSubTab_DAO().update(AppSubTab);
            new HibernateSessionCon().CommitTrans();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
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
