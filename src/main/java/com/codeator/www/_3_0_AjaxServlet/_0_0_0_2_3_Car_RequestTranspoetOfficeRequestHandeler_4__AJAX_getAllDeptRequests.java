/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.VcleVehicleRequire;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
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
public class _0_0_0_2_3_Car_RequestTranspoetOfficeRequestHandeler_4__AJAX_getAllDeptRequests extends HttpServlet {

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
            long rowsShown = 0;
            int NumberOfRequestes = 0;
            int NumberOfDepartments = 0;
            List<PerDeptOld> deptList = new PerDeptOldDao().GetAllDept();
            if (deptList.size() > 0) {
                for (PerDeptOld d : deptList) {
                    List<VcleVehicleRequire> vList = new VcleVehicleRequireDao().GetVcleVehicleRequireByDeptIdWithRequireStatusIs4("" + d.getId().getDepNoOld(), "" + d.getId().getSectionNoOld());
                    if (vList.size() > 0) {
                        rowsShown++;
                        NumberOfRequestes += vList.size();
                        NumberOfDepartments++;
                        HTML_DIV += "<tr>\n"
                                + "     <td>" + d.getDepName() + "</td>\n"
                                + "     <td>" + vList.size() + "</td>\n"
                                + "     <td>\n"
                                + "         <button type=\"button\" class=\"btn btn-custon-rounded-three btn-success\" href=\"#\" data-toggle=\"modal\" onclick=\"getDeptRequests(" + d.getId().getDepNoOld() + "," + d.getId().getSectionNoOld() + "," + vList.size() + ",'" + d.getDepName() + "');\" data-target=\"#AllRequestedCars\"><i class=\"fa fa-search adminpro-checked-pro\" aria-hidden=\"true\"></i> إستعلام عن طلبات الإدارة</button>\n"
                                + "     </td>\n"
                                + " </tr>";
                    }
                }
            }
            if (rowsShown == 0) {
                HTML_DIV += "<tr>\n"
                        + "     <td colspan='3'>لا توجد طلبات</td>\n"
                        + " </tr>";
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
