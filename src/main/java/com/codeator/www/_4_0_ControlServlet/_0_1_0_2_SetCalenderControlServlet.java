/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._4_0_ControlServlet;

import com.codeator.www._0_1_CodeatorLib.Alerts.Alerts;
import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mySqlMainDao.HibernateSessionConMySql;
import com.codeator.www._1_2_DB_entities_mysql.CalenderAlertNotifications;
import com.codeator.www._1_2_DB_entities_mysql.Employees;
import com.codeator.www._1_2_DB_entities_mysql.ExternalGov;
import com.codeator.www._1_3_DB_daos_mysql.CalenderAlertNotificationsDao;
import com.codeator.www._1_3_DB_daos_mysql.EmployeesDao;
import com.codeator.www._1_3_DB_daos_mysql.ExternalGovDao;
import java.io.IOException;
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
public class _0_1_0_2_SetCalenderControlServlet extends HttpServlet {

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
        Alerts alerts = new Alerts();
        try {
            CalenderAlertNotificationsDao dao = new CalenderAlertNotificationsDao();
            Employees e = (Employees) request.getSession().getAttribute("Employees");
            String calDate = request.getParameter("calDate");
            String calTime = request.getParameter("calTime");
            String radio = request.getParameter("radio");
            String calNote = request.getParameter("calNote");
            String[] empID = null;
            String[] ExtenalGovIds = null;
            Set<Employees> ee = new HashSet<Employees>(0);
            Set<ExternalGov> eg = new HashSet<ExternalGov>(0);

            switch (radio) {
                case "employee":
                    empID = request.getParameterValues("empID");
                    for (String s : empID) {
                        List<Employees> pList = new EmployeesDao().GetEmployeesByEmpId(s);
                        ee.add(pList.get(0));
                    }
                    break;
                case "external":
                    ExtenalGovIds = request.getParameterValues("ExtenalGovIds");
                    for (String s : ExtenalGovIds) {
                        List<ExternalGov> dList = new ExternalGovDao().GetExternalGovById(s);
                        eg.add(dList.get(0));
                    }

                    break;
                case "both":
                    empID = request.getParameterValues("empID");
                    for (String s : empID) {
                        List<Employees> pList = new EmployeesDao().GetEmployeesByEmpId(s);
                        ee.add(pList.get(0));
                    }
                    ExtenalGovIds = request.getParameterValues("ExtenalGovIds");
                    for (String s : ExtenalGovIds) {
                        List<ExternalGov> dList = new ExternalGovDao().GetExternalGovById(s);
                        eg.add(dList.get(0));
                    }
                    break;
            }
            CalenderAlertNotifications can = new CalenderAlertNotifications(Integer.parseInt("" + dao.GetMaxCalenderAlertNotificationsID()), e, new DateOp().String2Date(calDate + " " + calTime + ":00", "yyyy-MM-dd HH:mm:ss"), calNote, "active", ee, eg);
            HibernateSessionConMySql.MySQL_beginTrans();
            dao.insert(can);
            HibernateSessionConMySql.MySQL_CommitTrans();
            // success
            alerts.setSuccessType("SuccessAlert");
            alerts.setTitle("تمت");
            alerts.setMessage("تم جدولة الموعد بنجاح");

            request.getSession().setAttribute("Alerts", alerts);

            response.sendRedirect("_0_1_0_2_SetCalenderAccessServlet");
        } catch (Exception e) {
            e.printStackTrace();
            HibernateSessionConMySql.MySQL_RollBack();
            alerts.setSuccessType("ErrorAlert");
            alerts.setTitle("خطأ");
            alerts.setMessage("فشلت العملية");

            request.getSession().setAttribute("Alerts", alerts);

            response.sendRedirect("_0_1_0_2_SetCalenderAccessServlet");
        }
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
