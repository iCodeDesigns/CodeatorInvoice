/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatus;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireStatusDao;
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
public class _0_0_0_2_3_Car_RequestTranspoetOfficeRequestHandeler_3__AJAX_getDeptRequests extends HttpServlet {

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

            String deptId = request.getParameter("deptId");
            String sectionId = request.getParameter("sectionId");
            String HTML_DIV = "";
            List<VcleVehicleRequire> vList = new VcleVehicleRequireDao().GetVcleVehicleRequireByDeptIdWithRequireStatusIs4(deptId, sectionId);
            if (vList.size() > 0) {
                for (VcleVehicleRequire v : vList) {
                    String requireEndHour = "";
                    if (v.getRequireEndHour().equals("العودة")) {
                        requireEndHour = "العودة";
                    } else {
                        requireEndHour = new DateOp().Date2String(new DateOp().String2Date(v.getRequireEndHour(), "HH:mm"), "hh:mm a");
                    }
                    String RequireType = new EnumDataBaseValues().RequireType(v.getRequireType());
                    HTML_DIV += "<tr>\n"
                            + "      <td>" + new DateOp().Date2String(new DateOp().String2Date(v.getRequireDateTime(), "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd") + "</td>\n"
                            + "      <td>" + new DateOp().Date2String(new DateOp().String2Date(v.getRequireDateTime(), "yyyy-MM-dd HH:mm:ss"), "hh:mm a") + "</td>\n"
                            + "      <td>" + RequireType + "</td>\n"
                            + "      <td>" + v.getDriverPlace() + "</td>\n"
                            + "      <td>" + v.getRequirePlace() + "</td>\n"
                            + "      <td>" + requireEndHour + "</td>\n"
                            + "      <td>" + v.getRequireSp() + "</td>\n"
                            + "      <td>" + v.getPerEmploymentMasterByEmployeeId().getEmpAname() + "</td>\n"
                            + "      <td>" + v.getGuestNo() + "</td>\n"
                            + "      <td id=\"cell" + v.getRequireSp() + "\">\n"
                            + "          <button type=\"button\" class=\"btn btn-custon-rounded-three btn-success\" onclick=\"ActivateRequest(" + v.getRequireSp() + ");\"><i class=\"fa fa-check adminpro-checked-pro\" aria-hidden=\"true\"></i> قبول الطلب</button>\n"
                            + "          <button type=\"button\" class=\"btn btn-custon-rounded-three btn-danger\" onclick=\"IgnoreRequestModal(" + v.getRequireSp() + ");\" href=\"#\" data-toggle=\"modal\" data-target=\"#IgnorReasonDiv\"><i class=\"fa fa-close adminpro-danger-error\" aria-hidden=\"true\"></i> رفض الطلب</button>\n"
                            + "      </td>\n"
                            + "  </tr>";
                }
            } else {
                HTML_DIV += "<tr>"
                        + "<td colspan='10'>لا توجد بيانات</td>"
                        + "</tr>";
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
