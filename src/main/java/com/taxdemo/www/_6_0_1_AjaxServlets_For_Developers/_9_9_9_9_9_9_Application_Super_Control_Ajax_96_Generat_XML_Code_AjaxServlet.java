/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._6_0_1_AjaxServlets_For_Developers;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppSubTab;
import com.codeator.www._1_3_DB_daos.AppSubTab_DAO;
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
public class _9_9_9_9_9_9_Application_Super_Control_Ajax_96_Generat_XML_Code_AjaxServlet extends HttpServlet {

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
            String filterName = request.getParameter("filterName");
            String filterPath = request.getParameter("filterPath");

            List<AppSubTab> pList = new AppSubTab_DAO().getAllApplicationSubTabs();

            if(pList.isEmpty()){
                throw new Exception();
            }
            /*String XML_CODE
                    = "    <filter>\n"
                    + "        <filter-name>" + filterName + "</filter-name>\n"
                    + "        <filter-class>com.ahramattend.www._0_1_0_0_0_SystemFilters.SystemMainFilter</filter-class>\n"
                    + "    </filter>\n";

            XML_CODE
                    += "    <filter-mapping>\n"
                    + "        <filter-name>SystemMainFilter</filter-name>\n"
                    + "        <servlet-name>_0_0_0_4_0_0_document_scan_AccessServlet</servlet-name>\n"
                    + "    </filter-mapping>";*/
            String XML_CODE
                    = "    <filter>\n"
                    + "        <filter-name>" + filterName + "</filter-name>\n"
                    + "        <filter-class>" + filterPath + "." + filterName + "</filter-class>\n"
                    + "    </filter>\n";
            for (AppSubTab ast : pList) {
                XML_CODE
                        += "    <filter-mapping>\n"
                        + "        <filter-name>" + filterName + "</filter-name>\n"
                        + "        <servlet-name>" + ast.getSubTabAccessservlet() + "</servlet-name>\n"
                        + "    </filter-mapping>\n";
            }

            response.getWriter().write(XML_CODE);
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
