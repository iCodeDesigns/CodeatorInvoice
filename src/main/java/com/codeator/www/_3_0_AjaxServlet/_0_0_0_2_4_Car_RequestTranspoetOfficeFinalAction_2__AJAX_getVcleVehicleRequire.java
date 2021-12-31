/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleVehicleMaster;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import com.codeator.www._1_3_DB_daos.VcleVehicleMasterDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao;
import com.codeator.www._1_4_GeneralsModules.EnumDataBaseValues;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud
 */
public class _0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_2__AJAX_getVcleVehicleRequire extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");new HibernateSessionCon().OpenCon();
        try {
            String[] RequireSpClass = request.getParameterValues("RequireSpClass");
            List<String> ReqDates = new ArrayList<String>();
            String HTML_DIV = "";
            //System.out.println(RequireSpClass.length);

            int totalNumOgGest = 0;
            for (String r : RequireSpClass) {
                List<VcleVehicleRequire> vList = new VcleVehicleRequireDao().GetVcleVehicleRequireByRequireSp(r);

                if (vList.size() > 0) {
                    for (VcleVehicleRequire v : vList) {
                        String requireEndHour = "";
                        if (v.getRequireEndHour().equals("العودة")) {
                            requireEndHour = "العودة";
                        } else {
                            requireEndHour = new DateOp().Date2String(new DateOp().String2Date(v.getRequireEndHour(), "HH:mm"), "hh:mm a");
                        }
                        String RequireType = new EnumDataBaseValues().RequireType(v.getRequireType());

                        String Time = new DateOp().Date2String(new DateOp().String2Date(v.getRequireDateTime(), "yyy-MM-dd HH:mm:ss"), "hh:mm a");
                        ReqDates.add(v.getRequireDateTime());
                        HTML_DIV += "<tr>"
                                + "<td>" + v.getRequireSp() + "</td>"
                                + "<td>" + v.getRequireDate() + "</td>"
                                + "<td>" + Time + "</td>"
                                + "<td>" + v.getRequirePlace() + "</td>"
                                + "<td>" + requireEndHour + "</td>"
                                + "<td>" + RequireType + "</td>"
                                + "<td>" + v.getDriverPlace() + "</td>"
                                + "<td>" + v.getPerDeptOld().getDepName() + "</td>"
                                + "<td>" + v.getPerEmploymentMasterByEmployeeId().getEmpAname() + "</td>"
                                + "<td>" + v.getGuestNo() + "</td>"
                                + "</tr>";
                        totalNumOgGest += v.getGuestNo();
                    }

                }
            }
            HTML_DIV += "<tr>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td>إجمالي عدد الركاب</td>"
                    + "<td><input type=\"number\" class=\"form-control\" name=\"guestNo\" id=\"guestNo\" value=\"" + totalNumOgGest + "\" required=\"\" readonly=\"\"></td>"
                    + "</tr>";
            //checkDifference in Dates
            boolean HighDifferenceTimes = false;
            for (int i = 0; i < ReqDates.size(); i++) {
                String _1stLoop_ReqDate = ReqDates.get(i);
                for (int j = i + 1; j < ReqDates.size(); j++) {
                    String _2ndLoop_ReqDate = ReqDates.get(j);
                    long diff = new DateOp().differentsBetweenTwoDatesInHours(_1stLoop_ReqDate, _2ndLoop_ReqDate, "yyy-MM-dd HH:mm:ss");
                    diff = (diff >= 0) ? diff : ((-1) * diff);
                    if (diff > 1) {
                        HighDifferenceTimes = true;
                        break;
                    }
                }
                if (HighDifferenceTimes) {
                    break;
                }
            }
            if (HighDifferenceTimes) {
                HTML_DIV += "<tr colspan='10'><td>"
                        + "<div class=\"alert alert-warning alert-st-three\" role=\"alert\">\n"
                        + "                                <i class=\"fa fa-exclamation-triangle adminpro-warning-danger admin-check-pro admin-check-pro-none\" aria-hidden=\"true\"></i>\n"
                        + "                                <p class=\"message-mg-rt message-alert-none\"><strong>تحذير!</strong>هناك فرق بين التوقيتات بمعدل أكبر من ساعة</p>\n"
                        + "                            </div>"
                        + "</td></tr>";
            }
            response.getWriter().write(HTML_DIV);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(" ---------- Error In Query -----------");
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
