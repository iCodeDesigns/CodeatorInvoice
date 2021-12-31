/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleEmployeeMaster;
import com.codeator.www._1_2_DB_entities.VcleVehicleDriverJoin;
import com.codeator.www._1_2_DB_entities.VcleVehicleMaster;
import com.codeator.www._1_3_DB_daos.VcleEmployeeMasterDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleDriverJoinDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_15__AJAX_getVcleByDriver extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        new HibernateSessionCon().OpenCon();
        try {
            String emp_id = request.getParameter("emp_id");

            String HTML_DIV = "";            

            List<VcleVehicleDriverJoin> vList = new VcleVehicleDriverJoinDAO().GetVcleVehicleDriverJoinByDriver(emp_id);
            if (vList.size() > 0) {
                
                for (VcleVehicleDriverJoin v : vList) {
                    HTML_DIV += "<option value='" + v.getBoardNumber() + "'>" + v.getBoardNumber() + "-أقصى عدد للركاب-" + v.getVcleVehicleMaster().getVcleVehicleType().getGuestNo() + " </option>";

                }
                response.getWriter().write(HTML_DIV);
            }
        } catch (Exception e) {
            //e.printStackTrace();
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
