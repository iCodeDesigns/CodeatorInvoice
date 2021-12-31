/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_JSonEntities.VcleTrafficEmpPerm_Query_Jason;
import com.codeator.www._1_2_DB_entities.VcleTrafficEmpPerm;
import com.codeator.www._1_3_DB_daos.VcleTrafficEmpPermDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_Main_Ajax_8_getValDashByMonth extends HttpServlet {

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
            // logic Business
            //List<PhotoInsertDataJasonFileClass> articles = new LinkedList<PhotoInsertDataJasonFileClass>();
            String Month = request.getParameter("Month");
            String val = request.getParameter("val");

            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            //StoItemCate_Query_Jason stoItemCate_Query_Jason = mapper.readValue(json, StoItemCate_Query_Jason.class);
            List<VcleTrafficEmpPerm> vList = new VcleTrafficEmpPermDao().GetVcleTrafficEmpPermByMonthAndVal(Month, val);

            VcleTrafficEmpPerm_Query_Jason[] vcleTrafficEmpPerm_Query_Jason_arr = new VcleTrafficEmpPerm_Query_Jason[vList.size()];

            int i = 0;
            for (VcleTrafficEmpPerm vtep : vList) {
                VcleTrafficEmpPerm_Query_Jason vcleTrafficEmpPerm_Query_Jason2 = new VcleTrafficEmpPerm_Query_Jason();
                vcleTrafficEmpPerm_Query_Jason2.setEmployeeNo("" + vtep.getEmployeeNo());
                vcleTrafficEmpPerm_Query_Jason2.setEmployee_name(vtep.getPerEmploymentMaster().getEmpAname());
                vcleTrafficEmpPerm_Query_Jason2.setDepNoOld(vtep.getPerEmploymentMaster().getPerDeptOld().getDepName());                

                vcleTrafficEmpPerm_Query_Jason_arr[i] = vcleTrafficEmpPerm_Query_Jason2;
                i++;
            }
            json = mapper.writeValueAsString(vcleTrafficEmpPerm_Query_Jason_arr);
            // success
            response.getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
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
