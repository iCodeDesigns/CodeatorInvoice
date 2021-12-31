/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_3_DB_daos.VcleTrafficEmpPermDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_4__AJAX_getVal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        new HibernateSessionCon().OpenCon();
        try {
            String execSearchType = request.getParameter("execSearchType");
            String HQL = "";
            switch (execSearchType) {
                case "All":
                    //HQL += " where ";
                    //HQL += " p.employeeId in (SELECT distinct v.id.employeeId from VcleTrafficEmpPerm v) ";
                    break;
                case "DateFromTo":
                    String from_date = request.getParameter("from_date")+"-01";
                    String to_date = request.getParameter("to_date")+"-01";
                    HQL += " where "
                            + "   v.id.execMm "
                            + "   between to_date('" + from_date + "','yyyy-MM-dd') and to_date('" + to_date + "','yyyy-MM-dd')";
                    break;
                case "Month":
                    String execMm = request.getParameter("execMm");
                    HQL += " where "
                            + "   v.id.execMm= to_date('" + execMm + "','yyyy-MM-dd')";
                    break;
            }
            String HTML_TEXT = "";
            /*if (HQL.isEmpty() || "".equals(HQL) || HQL == null) {
                throw new Exception();
            }*/

            List<BigDecimal> vtepvList = new VcleTrafficEmpPermDao().GetValValusFromVcleTrafficEmpPerm(HQL);
            if (vtepvList.isEmpty()) {

            } else {
                for (BigDecimal vtepv : vtepvList) {
                    HTML_TEXT += "<option class=\"font-style\" value ='" + vtepv + "'>جنيه " + vtepv + "</option>";

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
