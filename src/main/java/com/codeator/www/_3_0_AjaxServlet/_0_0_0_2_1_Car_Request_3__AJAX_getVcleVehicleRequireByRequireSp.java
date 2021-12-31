/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
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
public class _0_0_0_2_1_Car_Request_3__AJAX_getVcleVehicleRequireByRequireSp extends HttpServlet {

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
            String RequireSp = request.getParameter("RequireSp");
            String HTML_DIV = "";
            int shownRows = 0;
            List<VcleVehicleRequire> vList = new VcleVehicleRequireDao().GetVcleVehicleRequireByRequireSp(RequireSp);
            //vList = new VcleVehicleRequireDao().GetVcleVehicleRequireByDepNoOldAndAprovalNotNull("" + pList.get(0).getPerDeptOld().getId().getDepNoOld());
            if (vList.size() > 0) {
                for (VcleVehicleRequire v : vList) {
                    String RequireType = new EnumDataBaseValues().RequireType(v.getRequireType());

                    String requireEndHour = "";
                    if (v.getRequireEndHour().equals("العودة")) {
                        requireEndHour = "العودة";
                    } else {
                        requireEndHour = new DateOp().Date2String(new DateOp().String2Date(v.getRequireEndHour(), "HH:mm"), "hh:mm a");
                    }
                    HTML_DIV += "<tr>\n"
                            + "     <td>" + v.getPerEmploymentMasterByEmployeeId().getEmpAname()+ "</td>\n"
                            + "     <td>" + v.getGuestNo()+ "</td> \n"
                            + "     <td>" + v.getDriverPlace() + "</td>\n"
                            + "     <td>" + RequireType + "</td>\n"
                            + "     <td>" + requireEndHour + "</td>\n"
                            + "     <td>" + v.getRequirePlace() + "</td>\n"
                            + " </tr>";
                }
            }else{
                HTML_DIV = "<tr colspan='6'>\n"
                        + "    <td>لا توجد طلبات</td>\n"
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
