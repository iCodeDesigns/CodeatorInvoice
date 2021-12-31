/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.VcleVehicleType;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._1_3_DB_daos.VcleVehicleTypeDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud
 */
public class _0_0_0_2_6_Car_Request_1__AJAX_getDepNoOldBySectionNoOld extends HttpServlet {

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
            String SectionNoOld = request.getParameter("SectionNoOld");
            String HTML_Div = "<option value=''>لا توجد إدارات</option>";
            List<PerDeptOld> vlist = new PerDeptOldDao().GetDeptBySectionNoOld(SectionNoOld);
            if (vlist.size() > 0) {
                HTML_Div = "<option value=\"\" style=\"text-align: center;\">اختر الإدارة ...</option>";
                for (PerDeptOld v : vlist) {
                    if (v.getDepName().equals("بدون")) {
                        continue;
                    }
                    HTML_Div += "<option value='" + v.getId().getDepNoOld() + "'>" + v.getDepName() + "</option>";
                }
            }

            response.getWriter().write(HTML_Div);

        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println(" ---------- Error In Query -----------");
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
