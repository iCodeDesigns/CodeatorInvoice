/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
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
 * @author Mohamed
 */
public class _0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_3__AJAX_getEmployee extends HttpServlet {

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
            String execSearchType = request.getParameter("execSearchType");
            String HQL = "";
            switch (execSearchType) {
                case "All":
                    HQL += " where ";
                    HQL += " p.employeeId in (SELECT distinct v.id.employeeId from VcleTrafficEmpPerm v) order by p.empAname ";
                    break;
                case "DateFromTo":
                    String from_date = request.getParameter("from_date")+"-01";
                    String to_date = request.getParameter("to_date")+"-01";
                    HQL += " where ";
                    HQL += " p.employeeId in "
                            + " ("
                            + "   SELECT distinct v.id.employeeId from VcleTrafficEmpPerm v where "
                            + "   v.id.execMm "
                            + "   between to_date('" + from_date + "','yyyy-MM-dd') and to_date('" + to_date + "','yyyy-MM-dd')"
                            + " ) "
                            + " order by p.empAname ";
                    break;
                case "Month":
                    String execMm = request.getParameter("execMm");
                    HQL += " where ";
                    HQL += " p.employeeId in "
                            + " ("
                            + "   SELECT distinct v.id.employeeId from VcleTrafficEmpPerm v where "
                            + "   v.id.execMm= to_date('" + execMm + "','yyyy-MM-dd')"
                            + " ) "
                            + " order by p.empAname ";
                    break;
            }
            String HTML_TEXT = "";
            if(HQL.isEmpty()||"".equals(HQL)||HQL==null){
                throw new Exception();
            }
            
            List<PerEmploymentMaster> vtepList = new PerEmploymentMasterDao().GetAllEmpsCustomHQL(HQL);
            if (vtepList.isEmpty()) {
            } else {
                for (PerEmploymentMaster vtep : vtepList) {
                    String EmpID = "" + vtep.getEmployeeId();
                    String EmpName = "" + vtep.getEmpAname();

                    HTML_TEXT += "<option class=\"font-style\" value=\"" + EmpID + "\">" + EmpName + "</option>";

                }
            }

            response.getWriter().write(HTML_TEXT);
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
