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
import com.codeator.www._1_3_DB_daos.VcleRecordMovementJoinDao;
import com.codeator.www._1_4_GeneralsModules.EnumDataBaseValues;
import java.io.IOException;
import java.io.PrintWriter;
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
public class _0_0_0_2_2_Car_RequestManegersRequestHandeler_2__AJAX_getRequestsData extends HttpServlet {

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
        //
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");new HibernateSessionCon().OpenCon();
        try {
            String from_date = request.getParameter("from_date");
            String to_date = request.getParameter("to_date");
            String deptId = request.getParameter("deptId");

//dd-MMM-yyyy
            Date FromDate = new DateOp().String2Date(from_date, "yyyy-MM-dd");
            Date ToDate = new DateOp().String2Date(to_date, "yyyy-MM-dd");

            String HQL = " v.vcleRecordMovement.goingDate>=to_date('" + new DateOp().Date2String(FromDate, "yyyy-MM-dd") + "','yyyy-MM-dd')";
            HQL += " AND v.vcleRecordMovement.goingDate<=to_date('" + new DateOp().Date2String(ToDate, "yyyy-MM-dd") + "','yyyy-MM-dd')";

            String HTML_DIV = getUpperTableText();
            List<VcleRecordMovementJoin> vList = new VcleRecordMovementJoinDao().GetVcleRecordMovementJoinByPeriodAndDept(HQL, deptId);
            if (vList.isEmpty()) {
                HTML_DIV += "<tr>\n"
                        + "    <td>لا توجد طلبات</td>\n"
                        + "    <td></td>\n"
                        + "    <td></td>\n"
                        + "    <td></td>\n"
                        + "    <td></td>\n"
                        + "    <td></td>\n"
                        + "    <td></td>\n"
                        + "    <td></td>\n"
                        + "    <td></td>\n"
                        + "    <td></td>\n"
                        + "    <td></td>\n"
                        + "    <td></td>\n"
                        + "  </tr>";
            } else {
                int i = 0;
                for (VcleRecordMovementJoin vr : vList) {

                    VcleVehicleRequire v = vr.getVcleVehicleRequire();
                    //System.out.println(i);
                    String RequireType = new EnumDataBaseValues().RequireType(v.getRequireType());

                    String GoingDateHour = vr.getVcleRecordMovement().getGoingDateHour();
                    String ComingDateHour = vr.getVcleRecordMovement().getComingDateHour();
                    Date Going = new DateOp().String2Date(GoingDateHour, "yyyy-MM-dd HH:mm:ss");
                    Date Coming = new DateOp().String2Date(ComingDateHour, "yyyy-MM-dd HH:mm:ss");
                    long diff_muintis = new DateOp().differentsBetweenTwoDatesInMinuts(Coming, Going);
                    long Days = diff_muintis / (24 * 60);
                    diff_muintis = diff_muintis % (24 * 60);
                    long Hours = diff_muintis / 60;
                    diff_muintis = diff_muintis % 60;
                    HTML_DIV += "<tr>\n"
                            + "     <td>" + (++i) + "</td>"
                            + "     <td>" + new DateOp().Date2String(new DateOp().String2Date(v.getRequireDateTime(), "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd") + "</td>\n"
                            + "     <td>" + new DateOp().Date2String(new DateOp().String2Date(v.getRequireDateTime(), "yyyy-MM-dd HH:mm:ss"), "hh:mm a") + "</td>\n"
                            + "     <td>" + vr.getRequireSp() + "</td>\n"
                            + "     <td>" + v.getPerEmploymentMasterByEmployeeId().getEmpAname() + "</td>\n"
                            + "     <td>" + v.getGuestNo() + "</td>\n"
                            + "     <td>" + v.getDriverPlace() + "</td>\n"
                            + "     <td>" + RequireType + "</td>\n"
                            + "     <td>" + v.getRequirePlace() + "</td>\n"
                            + "     <td>" + ++Days + "</td>\n"
                            + "     <td>" + Hours + "</td>\n"
                            + "     <td>" + diff_muintis + "</td>\n"
                            + " </tr>";
                    //i++;
                }
            }
            HTML_DIV += getLowerTableText();
            response.getWriter().write(HTML_DIV);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
            System.err.println(" ---------- Error In Update -----------");
        }
        new HibernateSessionCon().closeConn();
    }

    private String getUpperTableText() {
        return "<thead>                                                                                                \n"
                + "                                                                                                    <tr>                                               \n"
                + "                                                                                                        <th style=\"text-align: center;\">م</th>\n"
                + "                                                                                                        <th style=\"text-align: center;\">تاريخ الطلب</th>\n"
                + "                                                                                                        <th style=\"text-align: center;\">توقيت الطلب</th>\n"
                + "                                                                                                        <th style=\"text-align: center;\">رقم الطلب</th>\n"
                + "                                                                                                        <th style=\"text-align: center;\">اسم طالب السيارة</th>\n"
                + "                                                                                                        <th style=\"text-align: center;\">عدد الركاب</th>\n"
                + "                                                                                                        <th style=\"text-align: center;\">مكان مقابلة السائق</th>\n"
                + "                                                                                                        <th style=\"text-align: center;\">نوع الطلب</th>   \n"
                + "                                                                                                        <th style=\"text-align: center;\">خط سير السيارة</th>\n"
                + "                                                                                                        <th style=\"text-align: center;\">عدد أيام الرحلة</th>   \n"
                + "                                                                                                        <th style=\"text-align: center;\">عدد الساعات</th>   \n"
                + "                                                                                                        <th style=\"text-align: center;\">عدد الدقائق</th> \n"
                + "                                                                                                    </tr>\n"
                + "                                                                                                </thead>\n"
                + "                                                                                                <tbody>\n"
                + "";
    }

    private String getLowerTableText() {
        return "</tbody>\n";
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
