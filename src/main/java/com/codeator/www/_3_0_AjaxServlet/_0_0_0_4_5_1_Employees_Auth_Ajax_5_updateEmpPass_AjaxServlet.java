/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_1_CodeatorLib.Hashing.hashing_algorithm_class;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppAuthJavaUsers;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.AppAuthJavaUsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _0_0_0_4_5_1_Employees_Auth_Ajax_5_updateEmpPass_AjaxServlet extends HttpServlet {

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
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }
            String employee_id = "" + employee_session.getEmployeeId();

            String new_password = request.getParameter("new_password");

            String json;
            if (new_password.equals(employee_id)) {
                json = "لايمكن لكلمة المرور أن تكون مطابقة لرقم التأمين";
            } else {
                List<AppAuthJavaUsers> pList = new AppAuthJavaUsersDAO<>().getEmployee("" + employee_session.getEmployeeId());
                if (pList.isEmpty()) {
                    throw new Exception();
                }
                AppAuthJavaUsers appAuthJavaUsers = pList.get(0);

                hashing_algorithm_class h = new hashing_algorithm_class("SHA-256");
                String password = h.getHash(new_password.getBytes(StandardCharsets.UTF_8));

                appAuthJavaUsers.setPasswordResetStatus("1");
                appAuthJavaUsers.setEmployeePassword(password);

                new HibernateSessionCon().beginTrans();
                new AppAuthJavaUsersDAO().update(appAuthJavaUsers);
                new HibernateSessionCon().CommitTrans();

                json = "Success";
            }

            response.getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
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
