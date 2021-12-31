/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._2_0_AccessServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _1_0_0_1_1_Electronic_Invoice_Query_print2_AccessServlet extends HttpServlet {

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
        String deptOld = request.getParameter("deptOld");
        String sectionOld = request.getParameter("sectionOld");
        String accUnitId = request.getParameter("accUnitId");
        String searchType = request.getParameter("searchType");
        String fromDate = request.getParameter("fromDate");
        String toDate = request.getParameter("toDate");
        String createdDate_OR_issueDate = request.getParameter("createdDate_OR_issueDate");
        String Numbers_Of_Invoices = request.getParameter("Numbers_Of_Invoices");
        String lang = request.getParameter("lang");

        request.getSession().setAttribute("OpenHTMLFile", "Open");
        request.getSession().setAttribute("deptOld", deptOld);
        request.getSession().setAttribute("sectionOld", sectionOld);
        request.getSession().setAttribute("accUnitId", accUnitId);
        request.getSession().setAttribute("searchType", searchType);
        request.getSession().setAttribute("fromDate", fromDate);
        request.getSession().setAttribute("toDate", toDate);
        request.getSession().setAttribute("createdDate_OR_issueDate", createdDate_OR_issueDate);
        request.getSession().setAttribute("Numbers_Of_Invoices", Numbers_Of_Invoices);
        request.getSession().setAttribute("lang", lang);
        //request.getRequestDispatcher("/_0_0_0_0_8_2_PayEmployeeReq_print.jsp").forward(request, response);
        response.sendRedirect("_1_0_0_1_1_Electronic_Invoice_Query_print.jsp");
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
