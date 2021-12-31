/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoTaxTokenServerStatus;
import com.codeator.www._1_3_DB_daos.InvoTaxTokenServerStatusDAO;
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
public class _1_0_0_0_2_Electronic_Invoice_Query_zPortal_Send_03_getServiceStatus_AjaxServlet extends HttpServlet {

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
            new HibernateSessionCon().OpenCon();
            String message = "";
            List<InvoTaxTokenServerStatus> pList = new InvoTaxTokenServerStatusDAO().getServerStatus();
            InvoTaxTokenServerStatus InvoTaxTokenServerStatus = null;
            if (pList.isEmpty()) {
                InvoTaxTokenServerStatus = new InvoTaxTokenServerStatus(Short.valueOf("1"), "0", "0", "0");
                new HibernateSessionCon().beginTrans();
                new InvoTaxTokenServerStatusDAO().insert(InvoTaxTokenServerStatus);
                new HibernateSessionCon().CommitTrans();
                message = "0,0,0";
            } else {
                InvoTaxTokenServerStatus = pList.get(0);
                message = InvoTaxTokenServerStatus.getTaxStatus() + ","
                        + InvoTaxTokenServerStatus.getSignAppStatus() + ","
                        + InvoTaxTokenServerStatus.getTokenStatus();
            }
            response.getWriter().write(message);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            if (message.equals("notExistDocument")) {
                message = "الفاتورة غير موجودة لتعديلها";
            } else {
                message = "Error";
            }
            response.getWriter().write(message);
        }

        new HibernateSessionCon().closeConn();
        //new HibernateSessionCon().clearConn();
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
