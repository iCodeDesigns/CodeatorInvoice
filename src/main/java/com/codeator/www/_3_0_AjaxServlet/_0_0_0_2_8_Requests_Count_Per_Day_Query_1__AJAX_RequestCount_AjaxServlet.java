/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleRecordMovement;
import com.codeator.www._1_3_DB_daos.VcleRecordMovementDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
public class _0_0_0_2_8_Requests_Count_Per_Day_Query_1__AJAX_RequestCount_AjaxServlet extends HttpServlet {

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
            String searchType = request.getParameter("searchType");

            String HTML_TEXT = "";
            List<VcleRecordMovement> pList = null;
            switch (searchType) {
                case "All":
                    pList = new VcleRecordMovementDAO().GetAllVcleRecordMovement();
                    break;
                case "Date":
                    String from_date = request.getParameter("from_date");
                    String to_date = request.getParameter("to_date");

                    Date FromDate = new DateOp().String2Date(from_date, "yyyy-MM-dd");
                    Date ToDate = new DateOp().String2Date(to_date, "yyyy-MM-dd");

                    String HQL = " v.goingDate>='" + new DateOp().Date2String(FromDate, "dd-MMM-yyyy") + "'";
                    HQL += " AND v.goingDate<='" + new DateOp().Date2String(ToDate, "dd-MMM-yyyy") + "'";
                    pList = new VcleRecordMovementDAO().GetVcleRecordMovementCustomQuery(HQL);
                    break;
                default:
                    break;
            }
            if (pList.isEmpty()) {
                HTML_TEXT = "<tr>\n"
                        + "    <td colspan=\"3\" style=\"align-items: center;\">لا توجد بيانات</td>\n"
                        + "</tr>";
            } else {
                List<String> setGoingDate = new ArrayList<String>();
                //System.out.println();
                for (VcleRecordMovement p : pList) {
                    String Day = new DateOp().getDayName(p.getGoingDate(), "ar");
                    String GoingDate = "" + p.getGoingDate();
                    if (!setGoingDate.contains(GoingDate)) {
                        setGoingDate.add(GoingDate);
                        List<VcleRecordMovement> vList = new VcleRecordMovementDAO().GetAllVcleRecordMovementByGoingDate("" + p.getGoingDate());
                        HTML_TEXT += "<tr>\n"
                                + "                    <td style=\"font-weight: bold;\">" + GoingDate + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + Day + "</td>\n"
                                + "                    <td style=\"font-weight: bold;\">" + vList.size() + "</td>\n";
                        HTML_TEXT += "                </tr>";
                    }
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
