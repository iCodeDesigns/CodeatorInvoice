/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleTrafficEmpPerm;
import com.codeator.www._1_3_DB_daos.VcleTrafficEmpPermDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_1__AJAX_LoadTrafficEmpPerm_AjaxServlet extends HttpServlet {

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
            Writer writer = response.getWriter();
            String searchType = request.getParameter("searchType");
            String execSearchType = request.getParameter("execSearchType");
            request.getSession().setAttribute("_0_0_0_2_9_Loading", 10);
            String HTML_TEXT = "";
            String HQL = "";
            switch (execSearchType) {
                case "All":
                    HQL = "where";
                    break;
                case "DateFromTo":
                    String from_date = request.getParameter("from_date")+"-01";
                    String to_date = request.getParameter("to_date")+"-01";
                    HQL = "where v.id.execMm BETWEEN TO_DATE('" + from_date + "', 'yyyy/MM/dd') AND TO_DATE('" + to_date + "', 'yyyy/MM/dd') and";
                    break;
                case "Month":
                    String exec_Mm = request.getParameter("execMm");
                    HQL = "where v.id.execMm=TO_DATE('" + exec_Mm + "', 'yyyy-MM-dd') and";
                    break;
                default:
                    break;
            }
            List<VcleTrafficEmpPerm> pList = null;
            switch (searchType) {
                case "All":
                    if (HQL.startsWith("where") && HQL.endsWith("and")) {
                        String HQL_Arr[] = HQL.split("and");
                        HQL = HQL_Arr[0];
                        pList = new VcleTrafficEmpPermDao().GetAllVcleTrafficEmpPermByDate(HQL);
                    } else {
                        HQL ="";
                        pList = new VcleTrafficEmpPermDao().GetAllVcleTrafficEmpPermByDate(HQL);
                    }
                    break;
                case "EmpId":                    
                    String EmployeeId = request.getParameter("EmployeeId");
                    pList = new VcleTrafficEmpPermDao().GetAllVcleTrafficEmpPermByEmployeeId(EmployeeId, HQL);
                    break;
                case "Val":
                    String Val = request.getParameter("Val");
                    pList = new VcleTrafficEmpPermDao().GetAllVcleTrafficEmpPermByVal(Val, HQL);
                    break;
                default:
                    break;
            }
            int size = pList.size();
            int i = 0;
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"5\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                        + "</tr>";
                writer.write(HTML_TEXT);
            } else {
                for (VcleTrafficEmpPerm p : pList) {
                    HTML_TEXT = "<tr>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getEmployeeNo() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getPerEmploymentMaster().getEmpAname() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getPerEmploymentMaster().getPerDeptOld().getPerSectionOld().getSectionName() + "-" + p.getPerEmploymentMaster().getPerDeptOld().getDepName() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getId().getExecMm() + "</td>\n"
                            + "                    <td style=\"font-weight: bold;\">" + p.getVal() + "</td>\n";
                    HTML_TEXT += "                </tr>";
                    writer.write(HTML_TEXT);
                    int message = (int) ((i * 100.0) / size);
                    if (message > 10) {
                        request.getSession().setAttribute("_0_0_0_2_9_Loading", message);
                    }

                    i++;
                }
            }
            //response.getWriter().write(HTML_TEXT);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
        }

        new HibernateSessionCon().closeConn();
        request.getSession().removeAttribute("_0_0_0_2_9_Loading");
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
