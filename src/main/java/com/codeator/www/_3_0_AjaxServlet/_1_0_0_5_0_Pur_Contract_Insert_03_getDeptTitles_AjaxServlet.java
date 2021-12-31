/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.PurContractTitel;
import com.codeator.www._1_3_DB_daos.PurContractTitelDao;
import com.codeator.www._6_0_Json_entities._1_0_0_5_0_Pur_Contract_Insert_json;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
@WebServlet(name = "_1_0_0_5_0_Pur_Contract_Insert_03_getDeptTitles_AjaxServlet", urlPatterns = {"/_1_0_0_5_0_Pur_Contract_Insert_03_getDeptTitles_AjaxServlet"})
public class _1_0_0_5_0_Pur_Contract_Insert_03_getDeptTitles_AjaxServlet extends HttpServlet {

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
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }

            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            String sectionId = request.getParameter("sectionId");
            String deptId = request.getParameter("deptId");

            List<PurContractTitel> PurContractTitelList = new PurContractTitelDao().getAllTitlesByDept(sectionId, deptId);

            _1_0_0_5_0_Pur_Contract_Insert_json[] contract_master_arr = new _1_0_0_5_0_Pur_Contract_Insert_json[PurContractTitelList.size()];
            int i = 0;
            for (PurContractTitel purContractMaster : PurContractTitelList) {
                _1_0_0_5_0_Pur_Contract_Insert_json contract_master = new _1_0_0_5_0_Pur_Contract_Insert_json();
                contract_master.setDeptNoOld("" + purContractMaster.getId().getDepNoOld());
                contract_master.setSectionNoOld("" + purContractMaster.getId().getSectionNoOld());
                contract_master.setTitleId("" + purContractMaster.getId().getTitelSp());
                contract_master.setTitleText("" + purContractMaster.getTitelName());

                contract_master_arr[i] = contract_master;
                i++;
            }

            // 2. initiate jackson mapper
            String json2 = "";
            json2 = mapper.writeValueAsString(contract_master_arr);
            //System.out.println("json : " + json);
            // success
            response.getWriter().write(json2);
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = "Error";
            response.getWriter().write(message);
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
