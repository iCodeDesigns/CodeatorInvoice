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
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
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
public class addEmpUsers extends HttpServlet {

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

            List<PerEmploymentMaster> pList = new PerEmploymentMasterDao().GetAllEmployees2();
            System.out.println("---- Size = " + pList.size());
            if (pList.isEmpty()) {
                response.getWriter().write("Empty");
            } else {
                String sql = "";
                int i = 1;
                for (PerEmploymentMaster perEmploymentMaster : pList) {
                    //AppAuthJavaUsersDAO
                    hashing_algorithm_class h = new hashing_algorithm_class("SHA-256");
                    String emp_id = "" + perEmploymentMaster.getEmployeeId();
                    String password = h.getHash(emp_id.getBytes(StandardCharsets.UTF_8));
                    // System.out.println(" --- " + password);
                    System.out.println(" -- " + i);

                    sql = "INSERT INTO \"AHRAM\".\"APP_AUTH_JAVA_USERS\" (EMPLOYEE_ID, EMPLOYEE_PASSWORD, PASSWORD_RESET_STATUS) VALUES ('" + perEmploymentMaster.getEmployeeId() + "', '" + password + "', '0');";
                    System.out.println(sql);
//                    System.out.println(" --- " + perEmploymentMaster.getEmployeeId());
//                    System.out.println(" --- " + perEmploymentMaster.getEmpAname());
//
//                    hashing_algorithm_class h = new hashing_algorithm_class("SHA-256");
//                    String emp_id = "" + perEmploymentMaster.getEmployeeId();
//                    String password = h.getHash(emp_id.getBytes(StandardCharsets.UTF_8));
//                    System.out.println(" --- " + password);
//
//                    System.out.println(" ----------------------------------------------");
//                    AppAuthJavaUsers record = new AppAuthJavaUsers();
//
//                    record.setEmployeeId(Long.parseLong(emp_id));
//                    record.setPerEmploymentMaster(perEmploymentMaster);
//                    record.setPasswordResetStatus("0");
//
//                    record.setEmployeePassword(password);
//                    new HibernateSessionCon().beginTrans();
//                    new AppAuthJavaUsersDAO().insert(record);
//                    new HibernateSessionCon().CommitTrans();
                    i++;
                }

                response.getWriter().write("Done");
            }
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
