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
import com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatus;
import com.codeator.www._1_3_DB_daos.VcleRecordMovementDAO;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleRequireStatusDao;
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
public class _0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_5__AJAX_BackEltalabat extends HttpServlet {

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
            String BackDate = request.getParameter("BackDate");
            String BackHour = request.getParameter("BackHour");

            String BackDateTime = BackDate + " " + BackHour + ":00";

            VcleRecordMovementDAO vcleRecordMovementDAO = new VcleRecordMovementDAO();
            List<VcleRecordMovement> vList = vcleRecordMovementDAO.GetVcleRecordMovementByGopingSp(GoingSp);
            if (vList.isEmpty()) {
                throw new Exception();
            } else {
                VcleRecordMovement v = vList.get(0);

                //Currect Date
                Date CurrentDate = new DateOp().getSysDate();
                String CurrentDateStr = new DateOp().Date2String(CurrentDate, "yyyy-MM-dd HH:mm:ss");
                double diffDays = new DateOp().differentsBetweenTwoDatesInMinuts(CurrentDateStr, BackDateTime, "yyyy-MM-dd HH:mm:ss");
                if (diffDays < 0) {
                    throw new Exception();// car cant be back in future..!!
                }
                //System.out.println(diffDays);
                /// cant return the car befor it go out
                String GoingDate = v.getGoingDateHour();
                diffDays = new DateOp().differentsBetweenTwoDatesInMinuts(BackDateTime, GoingDate, "yyyy-MM-dd HH:mm:ss");
                if (diffDays < 0) {
                    throw new Exception();// car cant be back before go out..!!
                }
                //System.out.println(diffDays);

                v.setComingDate(new DateOp().String2Date(BackDate, "yyyy-MM-dd"));
                v.setComingDateHour(BackDateTime);

                String comingCountNumberStatus = request.getParameter("comingCountNumberStatus");
                if (comingCountNumberStatus.equals("true")) {
                    //dont add goingCountNumber                    
                } else {
                    String comingCountNumber = request.getParameter("comingCountNumber");
                    v.setComingCountNumber(Long.parseLong(comingCountNumber));
                }

                new HibernateSessionCon().beginTrans();
                //update vcle_vcle_require Status
                Set<VcleRecordMovementJoin> vcleRecordMovementJoins = v.getVcleRecordMovementJoins();
                for (VcleRecordMovementJoin vrmj : vcleRecordMovementJoins) {
                    long RequireSp = vrmj.getVcleVehicleRequire().getRequireSp();
                    
                    List<VcleVehicleRequireStatus> vvrsList = new VcleVehicleRequireStatusDao().GetVcleVehicleRequireByRequireStatus("25");
                    if (vvrsList.isEmpty()) {
                        throw new Exception();
                    }
                    VcleVehicleRequireStatus vvrs = vvrsList.get(0);
                    
                    List<VcleVehicleRequire> vvrList = new VcleVehicleRequireDao().GetVcleVehicleRequireByRequireSp(""+RequireSp);
                    if (vvrList.isEmpty()) {
                        continue;
                    }
                    VcleVehicleRequire vvr = vvrList.get(0);
                    vvr.setVcleVehicleRequireStatus(vvrs);
                    vcleRecordMovementDAO.update(vvr);
                }
                ////
                vcleRecordMovementDAO.update(v);
                new HibernateSessionCon().CommitTrans();
                new HibernateSessionCon().clearConn();
                response.getWriter().write("Success");
            }
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
