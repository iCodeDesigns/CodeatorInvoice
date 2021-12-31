/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._6_1_Json_entities.InvoAccUintDeptId;
import com.codeator.www._6_1_Json_entities.PerDeptOldId;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class _1_0_0_1_5_Electronic_Invoice_Count_Report_OnDept_01_getDeptsFromAcc_AjaxServlet extends HttpServlet {

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
            String[] accUnitCode_arr = mapper.readValue(json, String[].class);

            //String accUnitCode = request.getParameter("accUnitCode");
            List<InvoAccUintDept> pList = new PerDeptOldDao().GetPerDeptOldDistinctFromInvoiceMaster(accUnitCode_arr);
            com.codeator.www._6_1_Json_entities.InvoAccUintDept[] InvoAccUintDept = new com.codeator.www._6_1_Json_entities.InvoAccUintDept[pList.size()];

            int i = 0;
            for (InvoAccUintDept pcst : pList) {

                com.codeator.www._6_1_Json_entities.InvoAccUintDept r = new com.codeator.www._6_1_Json_entities.InvoAccUintDept();
                InvoAccUintDeptId id = new InvoAccUintDeptId();
                id.setDepNoOld(pcst.getId().getDepNoOld());
                id.setSectionNoOld(pcst.getId().getSectionNoOld());
                id.setAccUnitCode(pcst.getId().getAccUnitCode());
                r.setId(id);
                com.codeator.www._6_1_Json_entities.PerDeptOld perDeptOld = new com.codeator.www._6_1_Json_entities.PerDeptOld();
                perDeptOld.setDepName(pcst.getPerDeptOld().getDepName());
                r.setPerDeptOld(perDeptOld);
                InvoAccUintDept[i] = r;
                i++;
                
            }

            String json1 = mapper.writeValueAsString(InvoAccUintDept);
            //System.out.println(pList.size());
            // success
            response.setContentType("application/json");
            response.getWriter().write(json1);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error");
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
