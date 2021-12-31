/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_1_DB_mySqlMainDao.HibernateSessionConMySql;
import com.codeator.www._1_2_DB_entities_mysql.CalenderAlertNotifications;
import com.codeator.www._1_2_DB_entities_mysql.Employees;
import com.codeator.www._1_2_DB_entities_mysql.ExternalGov;
import com.codeator.www._1_3_DB_daos_mysql.CalenderAlertNotificationsDao;
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
public class _0_1_0_2_SetCalender_2__AJAX_T2geelCalenderNotification extends HttpServlet {

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
            String cal_id = request.getParameter("cal_id");
            String newDateTime = request.getParameter("newDateTime");

            /////////////////////////////////////////////////////////////////////
            String date = newDateTime.substring(0, 10);
            String Time = newDateTime.substring(11, 16) + ":00";
            String date_time = date + " " + Time;
            Date calDateTime = new DateOp().String2Date(date_time, "yyyy-MM-dd HH:mm:ss");

            /////////////////////////////////////////////////////////////////////
            CalenderAlertNotificationsDao dao = new CalenderAlertNotificationsDao();
            List<CalenderAlertNotifications> dList = dao.GetNotificationsByID(cal_id);
            CalenderAlertNotifications can = dList.get(0);

            Employees e = can.getEmployees();
            Set<Employees> elist = can.getEmployeeses();
            Set<ExternalGov> govList = can.getExternalGovs();
            CalenderAlertNotifications NewCan = new CalenderAlertNotifications(Integer.parseInt("" + dao.GetMaxCalenderAlertNotificationsID()), e, calDateTime, can.getCalNote(), can.getCalStatus(), Integer.parseInt(cal_id), elist, govList);        
            HibernateSessionConMySql.MySQL_beginTrans();
            HibernateSessionConMySql.session.evict(can);
            dao.insert(NewCan);
            HibernateSessionConMySql.MySQL_CommitTrans();
            /////////////////////////////////////////////
            HibernateSessionConMySql.MySQL_beginTrans();
            can.setCalId(Integer.parseInt(cal_id));
            can.setCalStatus("not_in_time");
            dao.update(can);
            HibernateSessionConMySql.MySQL_CommitTrans();
            response.getWriter().write("Done");

        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println(" ---------- Error In Query -----------");
            HibernateSessionConMySql.MySQL_RollBack();
            response.getWriter().write("Error");
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
