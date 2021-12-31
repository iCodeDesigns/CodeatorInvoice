/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_JSonEntities.StoItemCate_Query_Jason;
import com.codeator.www._1_2_DB_entities.StoItemCateGroup;
import com.codeator.www._1_3_DB_daos.StoItemCateGroupDao;
import com.codeator.www._1_3_DB_daos.StoResponsibilityDeptDao;
import com.codeator.www._1_3_DB_daos.StoResponsibilityHistoryEmpDao;
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
 * @author Mohamed
 */
public class _0_0_1_0_0_StoItemCate_Query_Ajax_2_getAllCateCodeGroups_AjaxServlet extends HttpServlet {

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
            String cateCode = request.getParameter("cateCode");
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
            List<StoItemCateGroup> sicgList = new StoItemCateGroupDao().GetAllStoItemCateGroup(cateCode);

            StoItemCate_Query_Jason[] stoItemCate_Query_Jason_arr = new StoItemCate_Query_Jason[sicgList.size()];

            int i = 0;
            for (StoItemCateGroup sicg : sicgList) {
                StoItemCate_Query_Jason stoItemCate_Query_Jason2 = new StoItemCate_Query_Jason();
                stoItemCate_Query_Jason2.setGroupCode(sicg.getId().getGroupCode());
                stoItemCate_Query_Jason2.setCateCode(sicg.getId().getCateCode());
                stoItemCate_Query_Jason2.setCateName(sicg.getStoItemCateCode().getCateName());
                stoItemCate_Query_Jason2.setGroupName(sicg.getGroupName());

                String HQL;
                HQL = "s.cateCode= " + sicg.getId().getCateCode() + " ";
                HQL += "and s.groupCode= '" + sicg.getId().getGroupCode() + "' ";
                long Count = new StoResponsibilityHistoryEmpDao().GetCountEmployeesRespsByRespTypeActNot9(HQL);
                stoItemCate_Query_Jason2.setGroupCodeTotal("" + Count);
                
                long CountDept = new StoResponsibilityDeptDao().GetCountDeptRespsByRespTypeActNot9(HQL);
                stoItemCate_Query_Jason2.setGroupCodeDeptTotal(""+CountDept);

                stoItemCate_Query_Jason_arr[i] = stoItemCate_Query_Jason2;
                i++;
            }
            json = mapper.writeValueAsString(stoItemCate_Query_Jason_arr);
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
