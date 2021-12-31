/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.VcleRecordMovement;
import com.codeator.www._1_2_DB_entities.VcleVehicleMaster;
import com.codeator.www._1_3_DB_daos.VcleRecordMovementDAO;
import com.codeator.www._1_3_DB_daos.VcleVehicleMasterDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud
 */
public class _0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_1__AJAX_getFullCarNumber extends HttpServlet {

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
            String BoardDigital = request.getParameter("BoardDigital");
            String guestNo = request.getParameter("guestNo");
            String useGuestNo = request.getParameter("useGuestNo");
            Integer.parseInt(BoardDigital);
            List<VcleVehicleMaster> vList;
            if (useGuestNo.equals("true")) {
                vList = new VcleVehicleMasterDao().GetAllVehiclesCarsByBoardDigitalAccordingToGuestNo(BoardDigital,guestNo);
            } else {
                vList = new VcleVehicleMasterDao().GetAllVehiclesCarsByBoardDigital(BoardDigital);
            }

            if (vList.size() > 0) {
                String HTML_DIV = "<option value=\"\">اختر السيارة ...</option>";
                for (VcleVehicleMaster v : vList) {
                    HTML_DIV += "<option value='" + v.getBoardNumber() + "'>" + v.getBoardNumber() + "-أقصى عدد للركاب-" + v.getVcleVehicleType().getGuestNo() + " </option>";

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
