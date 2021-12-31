/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.MainframeSuppMobawaba;
import com.codeator.www._1_2_DB_entities.MainframeSuppTogarya;
import com.codeator.www._1_3_DB_daos.MainframeSuppMobawaba_DAO;
import com.codeator.www._1_3_DB_daos.MainframeSuppTogarya_DAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_1_7_Mainframe_Supp_Mobawaba_Togarya_Query_Ajax_02_update_supp_mainFrame_AjaxServlet extends HttpServlet {

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
            //String locationCode = "0";
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            MainframeSuppMobawaba MainframeSuppMobawaba_JasonFile = mapper.readValue(json, MainframeSuppMobawaba.class);
            MainframeSuppTogarya MainframeSuppTogarya_JasonFile = mapper.readValue(json, MainframeSuppTogarya.class);

            String accUnitId = request.getParameter("accUnitId");
            new HibernateSessionCon().beginTrans();
            if (accUnitId.equals("20") || accUnitId.equals("80")) {
                MainframeSuppMobawaba_JasonFile.setChkMoved("0");
                new MainframeSuppMobawaba_DAO().update(MainframeSuppMobawaba_JasonFile);
            } else if (accUnitId.equals("02") || accUnitId.equals("81")) {
                MainframeSuppTogarya_JasonFile.setChkMoved("0");
                new MainframeSuppTogarya_DAO().update(MainframeSuppTogarya_JasonFile);
            }
            new HibernateSessionCon().CommitTrans();
            //System.out.println(pList.size());
            // success
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            switch (message) {
                default:
                    message = "حدث خطأ أثناء تنفيذ العملية";
                    break;
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
