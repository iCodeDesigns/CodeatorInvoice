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
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud
 */
public class _0_0_0_2_5_Car_RequestTranspoetOfficeHistory_2__AJAX_TripsTalabat extends HttpServlet {

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
            String goingSP = request.getParameter("goingSP");
            String HTML_DIV = "";
            List<VcleRecordMovement> vList = new VcleRecordMovementDAO().GetVcleRecordMovementByGopingSp(goingSP);
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
                        + "  </tr>";
            } else {
                VcleRecordMovement v = vList.get(0);
                Set<VcleRecordMovementJoin> vrmjList = v.getVcleRecordMovementJoins();
                int RequestsMosakana_Rows = 0;
                int numberOfGuestNumbers = 0;
                for (VcleRecordMovementJoin r : vrmjList) {
                    VcleVehicleRequire vcleVehicleRequire = r.getVcleVehicleRequire();
                    String requireEndHour = "";
                    if (vcleVehicleRequire.getRequireEndHour().equals("العودة")) {
                        requireEndHour = "العودة";
                    } else {
                        requireEndHour = new DateOp().Date2String(new DateOp().String2Date(vcleVehicleRequire.getRequireEndHour(), "HH:mm"), "hh:mm a");
                    }
                    String RequireType = new EnumDataBaseValues().RequireType(vcleVehicleRequire.getRequireType());

                    String Time = new DateOp().Date2String(new DateOp().String2Date(vcleVehicleRequire.getRequireDateTime(), "yyy-MM-dd HH:mm:ss"), "hh:mm a");
                    HTML_DIV += "<tr>\n"
                            + "     <td>" + r.getRequireSp() + "</td>\n"
                            + "     <td>" + vcleVehicleRequire.getRequireDate() + "</td>\n"
                            + "     <td>" + Time + "</td>\n"
                            + "     <td>" + vcleVehicleRequire.getRequirePlace() + "</td>\n"
                            + "     <td>" + requireEndHour + "</td>\n"
                            + "     <td>" + RequireType + "</td>\n"
                            + "     <td>" + vcleVehicleRequire.getDriverPlace() + "</td>\n"
                            + "     <td>" + vcleVehicleRequire.getPerDeptOld().getDepName() + "</td>\n"
                            + "     <td>" + vcleVehicleRequire.getPerEmploymentMasterByEmployeeId().getEmpAname() + "</td>\n"
                            + "     <td>" + vcleVehicleRequire.getGuestNo() + "</td>\n"
                            + "  </tr>  ";
                    numberOfGuestNumbers += vcleVehicleRequire.getGuestNo();
                    RequestsMosakana_Rows++;
                }
                if (RequestsMosakana_Rows > 0) {
                    HTML_DIV += "<tr>\n"
                            + "     <td></td>\n"
                            + "     <td></td>\n"
                            + "     <td></td>\n"
                            + "     <td></td>\n"
                            + "     <td></td>\n"
                            + "     <td></td>\n"
                            + "     <td></td>\n"
                            + "     <td></td>\n"
                            + "     <td>مجموع عدد الركاب</td>\n"
                            + "     <td>" + numberOfGuestNumbers + "</td>\n"
                            + " </tr>";
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
