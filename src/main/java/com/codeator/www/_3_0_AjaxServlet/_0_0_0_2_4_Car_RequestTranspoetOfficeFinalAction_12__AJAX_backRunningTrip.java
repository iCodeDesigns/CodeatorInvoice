/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleRecordMovement;
import com.codeator.www._1_2_DB_entities.VcleRecordMovementJoin;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import com.codeator.www._1_3_DB_daos.VcleRecordMovementDAO;
import com.codeator.www._1_4_GeneralsModules.EnumDataBaseValues;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class _0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_12__AJAX_backRunningTrip extends HttpServlet {

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
            String GoingSp = request.getParameter("GoingSp");
            List<VcleRecordMovement> vMovementList = new VcleRecordMovementDAO().GetVcleRecordMovementStellOutByGoingSp(GoingSp);
            String HTML_DIV = "";
            for (VcleRecordMovement v : vMovementList) {
                HTML_DIV += "<div id=\"Header1\" class=\"modal-header\" style=\"background-color: #131e33;color: white;direction: rtl;\">\n"
                        + "                                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\" style=\"opacity: 1;float: left;\"><span aria-hidden=\"true\" style=\"color: white;\">×</span>\n"
                        + "                                                </button>\n"
                        + "                                                <h4 class=\"modal-title\" id=\"myModalLabel21\" style=\"font-size: 30px;\">إنهاء الرحلة ورجوعها</h4>\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"modal-body\" style=\"direction: rtl;\" >                                                \n"
                        + "                                                <div class=\"row\">\n"
                        + "                                                    <form onmouseover=\"applyCheckCheckerr("+v.getGoingSp()+")\">\n"
                        + "                                                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\" >\n"
                        + "                                                            <div class=\"chosen-select-single mg-b-20\">\n"
                        + "                                                                <label style=\"font-size: 20px;\">تاريخ العودة</label>    \n"
                        + "                                                                <div class=\"input-group date\">\n"
                        + "                                                                    <input type=\"date\" class=\"form-control\" name=\"BackDate\" id=\"BackDate"+v.getGoingSp()+"\" max='"+new DateOp().getCustomSysDate("yyyy-MM-dd")+"' value='"+new DateOp().getCustomSysDate("yyyy-MM-dd")+"' required=\"\">\n"
                        + "                                                                    <span class=\"input-group-addon\" style=\"border: 1px solid #e5e6e7;\"><i class=\"fa fa-calendar\"></i></span>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                        </div>\n"
                        + "                                                        <div class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12\" >\n"
                        + "                                                            <div class=\"chosen-select-single mg-b-20\">\n"
                        + "                                                                <label style=\"font-size: 20px;\">توقيت العودة</label>\n"
                        + "                                                                <div class=\"input-group date\">                                                                    \n"
                        + "                                                                    <input type=\"time\" class=\"form-control\" name=\"BackHour\" id=\"BackHour"+v.getGoingSp()+"\" value=\"\" required=\"\">\n"
                        + "                                                                    <span class=\"input-group-addon\" style=\"border: 1px solid #e5e6e7;\"><i class=\"fa fa-clock-o\"></i></span>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                        </div>\n"
                        + "                                                        <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\" >\n"
                        + "                                                            <div class=\"i-checks pull-right\">\n"
                        + "                                                                <label><input type=\"checkbox\" value=\"\" onclick=\"applyCheckCheckerr("+v.getGoingSp()+")\" id=\"comingCountNumberStatus"+v.getGoingSp()+"\" > <i></i> عداد السيارة معطل </label>                                                                    \n"
                        + "                                                            </div>\n"
                        + "                                                        </div>\n"
                        + "                                                        <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\" id=\"comingCountNumberDIV"+v.getGoingSp()+"\" >\n"
                        + "                                                            <div class=\"chosen-select-single mg-b-20\">\n"
                        + "                                                                <label style=\"font-size: 20px;\">قراءة عداد السيارة عند العودة</label>                                                                 \n"
                        + "                                                                <input type=\"number\" class=\"form-control\" name=\"comingCountNumber\" id=\"comingCountNumber"+v.getGoingSp()+"\" value=\"\" required=\"\">                                                                                                    \n"
                        + "                                                            </div>\n"
                        + "                                                        </div>\n"
                        + "\n"
                        + "\n"
                        + "                                                    </form>                                                                                      \n"
                        + "                                                </div>\n"
                        + "                                            </div> \n"
                        + "                                            <div id=\"Footer1\" class=\"modal-footer\" style=\"background-color: #131e33; direction: rtl;\">\n"
                        + "                                                <div id=\"BackSubmitButton\">\n"
                        + "                                                    <button type=\"button\" onclick=\"BackAction("+v.getGoingSp()+","+v.getGoingCountNumber()+");\" style=\"font-weight: bold;border-color: black;width: 15%;\" class=\"btn btn-custon-four btn-defult\"><i class=\"fa fa-reply adminpro-checked-pro\" aria-hidden=\"true\"></i>حفظ</button>\n"
                        + "                                                </div>\n"
                        + "                                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" style=\"font-weight: bold;border-color: black;width: 15%;\">اغلاق</button>\n"
                        + "                                            </div>";
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
