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
import com.codeator.www._1_2_DB_entities.AppSubElemId;
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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _9_9_9_9_9_5_Application_Menu_Screen_Elements_Ajax_3_SaveElementsBySubTab_AjaxServlet extends HttpServlet {

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
            String element_name = request.getParameter("element_name");
            String elementType = request.getParameter("elementType");
            /**
             * Check If element Name Exist In This Sub Tab Before
             */
            List<AppSubElem> aseList = new AppSubElem_DAO().getApplicationNameElementByNameInSubTab(applicationId, tabId, subTabId, element_name);
            if (!aseList.isEmpty()) {
                throw new Exception("Element Name Exist Before");
            }
            //////////////////////////////////////////////////////
            int elementId = new AppSubElem_DAO().getMaxID(applicationId, tabId, subTabId);
            AppSubElemId id = new AppSubElemId(Short.parseShort(applicationId), Integer.parseInt(tabId), Integer.parseInt(subTabId), elementId);

            List<AppSubTab> pList = new AppSubTab_DAO().get_ApplicationSubTabsById(applicationId, tabId, subTabId);
            if (pList.isEmpty()) {
                throw new Exception();
            }
            AppSubTab ast = pList.get(0);

            AppSubElem ase = new AppSubElem(id, ast, element_name);
            ase.setElementType(elementType);

            new HibernateSessionCon().beginTrans();
            new AppSubElem_DAO().insert(ase);
            new HibernateSessionCon().CommitTrans();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().equals("Element Name Exist Before")) {
                response.getWriter().write("Element Name Exist Before");
            } else {
                response.getWriter().write("Error");
            }

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
