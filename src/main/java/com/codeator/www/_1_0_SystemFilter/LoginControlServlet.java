/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_0_SystemFilter;

import com.codeator.www._0_0_App_tasks._0_0_1_API_Login;
import com.codeator.www._0_1_CodeatorLib.Hashing.hashing_algorithm_class;
import com.codeator.www._0_2_CodeatorLib.Baisc_HTML_Generator.DevelopmenUserNametPassword;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class LoginControlServlet extends HttpServlet {

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

            String emp_user = request.getParameter("username");//ID
            String emp_pass = request.getParameter("password");//BirthDate

            hashing_algorithm_class h = new hashing_algorithm_class("SHA-256");
            String password = h.getHash(emp_pass.getBytes(StandardCharsets.UTF_8));

            new HibernateSessionCon().clearConn();
            List<PerEmploymentMaster> pList = new PerEmploymentMasterDao().GetEmployeesByEmployee_UserName_Password(emp_user, password);
            if (pList.size() > 0) {
                List<String> users = new USERS().getUsers();
                /*if (!users.contains(emp_user)) {
                    throw new Exception("تأكد من الاسم ورقم المرور");
                } else {*/
                PerEmploymentMaster employee_session = pList.get(0);
                request.getSession().setAttribute("employee_session", employee_session);

                String host = request.getHeader("host"); // -- Server Host IP and PORT
                String Client_IP = request.getRemoteAddr();// -- Client IP
                new _00010_Login_BusinessRule().loginControl(request.getSession(), host, Client_IP, employee_session);
                //}
            } else {
                DevelopmenUserNametPassword p = new DevelopmenUserNametPassword(emp_user, emp_pass, "Administrator");
                if (!(/*(pList.size() > 0) ||*/(emp_user.equals(p.getUserName()) && emp_pass.equals(p.getPassword())))) {
                    throw new Exception();
                }
                PerEmploymentMaster employee_session = new PerEmploymentMaster();
                employee_session.setEmpAname(p.getName());
                request.getSession().setAttribute("employee_session", employee_session);
                String host = request.getHeader("host"); // -- Server Host IP and PORT
                String Client_IP = request.getRemoteAddr();// -- Client IP
                new _00010_Login_BusinessRule().loginControl(request.getSession(), host, Client_IP, employee_session);
            }
            request.getSession().setAttribute("LastActiveTime", new Date());
            response.sendRedirect("_0_0_0_0_MainMenuAccessServlet");
            try {
                _0_0_1_API_Login._0_0_1_API_Login();
            } catch (Exception e) {

            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("_0_0_0_0_LoginAccesServlet");
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
