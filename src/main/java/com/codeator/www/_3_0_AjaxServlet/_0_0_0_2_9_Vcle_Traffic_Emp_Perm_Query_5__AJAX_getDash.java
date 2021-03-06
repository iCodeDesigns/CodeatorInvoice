/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleTrafficEmpPerm;
import com.codeator.www._1_3_DB_daos.VcleTrafficEmpPermDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_5__AJAX_getDash extends HttpServlet {

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
                    String from_date = request.getParameter("from_date") + "-01";
                    String to_date = request.getParameter("to_date") + "-01";
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
                        pList = new VcleTrafficEmpPermDao().GetAllVcleTrafficEmpPermByDate2(HQL);
                    } else {
                        HQL = "";
                        pList = new VcleTrafficEmpPermDao().GetAllVcleTrafficEmpPermByDate2(HQL);
                    }
                    break;
                case "EmpId":
                    String EmployeeId = request.getParameter("EmployeeId");
                    pList = new VcleTrafficEmpPermDao().GetAllVcleTrafficEmpPermByEmployeeId2(EmployeeId, HQL);
                    break;
                case "Val":
                    String Val = request.getParameter("Val");
                    pList = new VcleTrafficEmpPermDao().GetAllVcleTrafficEmpPermByVal2(Val, HQL);
                    break;
                default:
                    break;
            }
            int size = pList.size();
            int i = 0;
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"3\" style=\"align-items: center;\">???? ???????? ????????????</td>\n"
                        + "</tr>";
                writer.write(HTML_TEXT);
            } else {
                List<BigDecimal> valsList = new ArrayList<>();
                List<Long> empSizeList = new ArrayList<>();
                long empSize = 0;
                for (int j = 0; j < pList.size(); j++) {

                    if (!valsList.contains(pList.get(j).getVal())) {
                        valsList.add(pList.get(j).getVal());
                        empSizeList.add(empSize);
                        empSize = 1;
                    } else {
                        empSize++;
                    }

                    int message = (int) ((i * 100.0) / size);
                    if (message > 10) {
                        request.getSession().setAttribute("_0_0_0_2_9_Loading", message);
                    }
                    i++;
                }
                empSizeList.add(empSize);

                empSizeList.remove(0);
                //if (!searchType.equals("EmpId")) {
                int TotalEmpSizeList = 0;
                double TotalVal = 0;
                for (int j = 0; j < valsList.size(); j++) {
                    TotalEmpSizeList += empSizeList.get(j);
                    TotalVal += Double.parseDouble("" + valsList.get(j)) * empSizeList.get(j);
                    HTML_TEXT = "<tr>\n"
                            + "    <td  style=\"align-items: center;\">" + valsList.get(j) + " ????????</td>\n"
                            + "    <td  style=\"align-items: center;\">" + empSizeList.get(j) + "</td>\n"
                            + "    <td  style=\"align-items: center;\">" + (Double.parseDouble("" + valsList.get(j)) * empSizeList.get(j)) + "</td>\n"
                            + "</tr>";
                    writer.write(HTML_TEXT);

                }
                HTML_TEXT = "<tr style='background-color: #337ab7;color: white;'>\n"
                        + "    <td  style=\"align-items: center;\"></td>\n"
                        + "    <td  style=\"align-items: center;\">" + TotalEmpSizeList + "</td>\n"
                        + "    <td  style=\"align-items: center;\">" + TotalVal + " ????????</td>\n"
                        + "</tr>";
                writer.write(HTML_TEXT);

                /*} else {
                    for (VcleTrafficEmpPerm p : pList) {
                        HTML_TEXT = "<tr>\n"
                                + "    <td  style=\"align-items: center;\">" + p.getVal() + " ????????</td>\n"
                                + "    <td  style=\"align-items: center;\">" + p.getId().getExecMm() + "</td>\n"
                                + "</tr>";
                        writer.write(HTML_TEXT);
                    }
                }*/
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
