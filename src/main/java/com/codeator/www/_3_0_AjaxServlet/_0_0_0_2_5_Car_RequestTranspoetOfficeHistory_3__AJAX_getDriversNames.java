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
import java.util.Date;
import java.util.HashSet;
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
public class _0_0_0_2_5_Car_RequestTranspoetOfficeHistory_3__AJAX_getDriversNames extends HttpServlet {

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
            String from_date = request.getParameter("from_date");
            String to_date = request.getParameter("to_date");
//dd-MMM-yyyy
            Date FromDate = new DateOp().String2Date(from_date, "yyyy-MM-dd");
            Date ToDate = new DateOp().String2Date(to_date, "yyyy-MM-dd");

            String HTML_DIV = "";
            List<VcleRecordMovement> vList = new VcleRecordMovementDAO().GetVcleRecordMovementDrvicersInPeriod(FromDate, ToDate);
            if (vList.isEmpty()) {
                HTML_DIV = "NoData";
            } else {
                //int i = 0;
                Set<String> DriversNames = new HashSet<>();
                HTML_DIV = "<option value=''>اختر إسم السائق ...</option>";
                for (VcleRecordMovement v : vList) {
                    //System.out.println(i);
                    if (DriversNames.add(v.getPerEmploymentMaster().getEmployeeNo())) {
                        HTML_DIV += "<option value='" + v.getPerEmploymentMaster().getEmployeeNo() + "'>" + v.getPerEmploymentMaster().getEmpAname()+" </option>";
                    }
                    //i++;
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
