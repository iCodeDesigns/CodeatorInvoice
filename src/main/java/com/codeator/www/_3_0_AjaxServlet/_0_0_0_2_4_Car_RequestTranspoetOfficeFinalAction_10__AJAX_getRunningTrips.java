/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleRecordMovement;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import com.codeator.www._1_3_DB_daos.VcleRecordMovementDAO;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao;
import com.codeator.www._1_4_GeneralsModules.EnumDataBaseValues;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_10__AJAX_getRunningTrips extends HttpServlet {

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
            String HTML_DIV = "";
            List<VcleRecordMovement> vMovementList = new VcleRecordMovementDAO().GetVcleRecordMovementStellOut();
            if (vMovementList.isEmpty()) {
                HTML_DIV += "<tr>\n"
                        + "    <td colspan=\"8\">لا توجد رحلات</td>\n"
                        + "  </tr>  ";
            } else {
                for (VcleRecordMovement v : vMovementList) {
                    String Time = new DateOp().Date2String(new DateOp().String2Date(v.getGoingDateHour(), "yyy-MM-dd HH:mm:ss"), "hh:mm a");
                    String goingCountNumber = v.getChkMov().equals("1") ? "العداد معطل" : "" + v.getGoingCountNumber();
                    HTML_DIV += "<tr>\n"
                            + "    <td>" + v.getGoingSp() + "</td>\n"
                            + "    <td>" + v.getGoingDate() + "</td>\n"
                            + "    <td>" + Time + "</td>\n"
                            + "    <td>" + v.getVcleVehicleMaster().getBoardNumber() + "</td>\n"
                            + "    <td>" + v.getPerEmploymentMaster().getEmpAname() + "</td>\n"
                            + "    <td>" + goingCountNumber + "</td>\n"
                            + "    <td><button type=\"button\" class=\"btn btn-custon-rounded-three btn-success\" href=\"#\" data-toggle=\"modal\" onclick=\"getRequestsOfRunningTrips(" + v.getGoingSp() + ");\" data-target=\"#RequestsMosakana\"><i class=\"fa fa-info adminpro-checked-pro\" aria-hidden=\"true\"></i> الطلبات التابعة للرحلة</button></td>\n"
                            + "    <td><button type=\"button\" class=\"btn btn-custon-rounded-three btn-success\" href=\"#\" data-toggle=\"modal\" onclick=\"backRunningTrip(" + v.getGoingSp() + ");\" data-target=\"#RequestBack\"><i class=\"fa fa-calendar-o adminpro-checked-pro\" aria-hidden=\"true\"></i> عودة الطلب</button></td>\n"
                            + "    <td>" + v.getVcleRecordMovementJoins().size() + "</td>\n"
                            + "    <td><button type=\"button\" class=\"btn btn-custon-rounded-three btn-danger\" href=\"#\"  data-toggle=\"modal\" onclick=\"setGoingSpInGlobal(" + v.getGoingSp() + ");\" data-target=\"#IgnorReasonDiv2\" ><i class=\"fa fa-trash adminpro-checked-pro\" aria-hidden=\"true\"></i>إلغاء</button></td>\n"
                            + "</tr>  ";
                }
            }
            response.getWriter().write(HTML_DIV);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
            System.err.println(" ---------- Error In Update -----------");
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
