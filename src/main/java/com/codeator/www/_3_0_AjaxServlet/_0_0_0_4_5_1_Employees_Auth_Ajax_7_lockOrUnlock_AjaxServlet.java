/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AppAuthJavaUsers;
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_3_DB_daos.AppAuthJavaUsersDAO;
import com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _0_0_0_4_5_1_Employees_Auth_Ajax_7_lockOrUnlock_AjaxServlet extends HttpServlet {

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

            String employeeId = request.getParameter("employeeId");
            String sectionId = request.getParameter("sectionId");
            String deptId = request.getParameter("deptId");
            String accUnitId = request.getParameter("accUnitId");
            String chkLockStatus = request.getParameter("chkLockStatus");

            List<InvoAccUintDept> invoAccUintDeptDaoList = new InvoAccUintDeptDao().GetInvoAccUintInDeptAndUnit(accUnitId, sectionId, deptId);
            if (invoAccUintDeptDaoList.isEmpty()) {
                throw new Exception("Unit Not Exist");
            }

            List<AppAuthJavaUsers> appAuthJavaUsersList = new AppAuthJavaUsersDAO().getEmployee(employeeId);
            if (appAuthJavaUsersList.isEmpty()) {
                throw new Exception("Not Exist");
            }

            AppAuthJavaUsers appAuthJavaUsers = appAuthJavaUsersList.get(0);

            if (chkLockStatus.equals("true")) {
                appAuthJavaUsers.setChkLock("1");
            } else {
                appAuthJavaUsers.setChkLock("0");
            }


            new HibernateSessionCon().beginTrans();
            new AppAuthJavaUsersDAO().update(appAuthJavaUsers);
            new HibernateSessionCon().CommitTrans();

            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            response.getWriter().write(e.getMessage());
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
