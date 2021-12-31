/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_0_CodeatorLib.ip_config;
import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._0_1_0_api_tracks._002_connect_and_get_recent_document;
import com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json._300_Get_Recent_Documents_JSON_000_;
import com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json._300_Get_Recent_Documents_JSON_001_;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_0_4_Electronic_Invoice_Invoice_Status_InTax_01_getFromPortal extends HttpServlet {

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
            //System.out.println("host            : " + request.getHeader("host")); // -- Server Host IP and PORT
            //System.out.println("Remote Address  : " + request.getRemoteAddr());   // -- Client IP

            String portal_type = request.getParameter("portal_type");
            String PageSize = request.getParameter("PageSize");
            String PageNo = request.getParameter("PageNo");

            /*System.out.println(portal_type);
            //System.out.println(PageSize);
            //System.out.println(PageNo);*/

            _002_connect_and_get_recent_document recent_doc = new _002_connect_and_get_recent_document();
            //String json = recent_doc.getJson();
            recent_doc.getRecentDocuments(portal_type, PageSize, PageNo);
            _300_Get_Recent_Documents_JSON_000_ json_object = recent_doc.getGet_Recent_Documents_JSON();
            //response.getWriter().write(json);
            for (int i = 0; i < json_object.getResult().size(); i++) {
                Date date = new DateOp().String2Date(json_object.getResult().get(i).getDateTimeReceived(), "yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
                json_object.getResult().get(i).setDateTimeReceived(new DateOp().Date2String(date, "yyyy-MM-dd hh:mm:ss a"));
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(json_object);
            response.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            if (message.equals("existDocument")) {
                message = "الرقم الداخلي للفاتورة مسجل من قبل";
            } else if (message.equals("Token Server Not Running")) {
                message = "برنامج التوقيع مغلق";
            } else if (message.equals("Fire Wall Stands On Request Traffic")) {
                message = "جدار الحماية يمنع اللإتصال";
            } else if (message.equals("No slots found")) {
                message = "برجاء التأكد من توصيل فلاشة التوقيع الإلكتروني";
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
