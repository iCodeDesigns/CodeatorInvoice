/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_JSonEntities.SupSuppliersInfoTest_Query_jason;
import com.codeator.www._1_2_DB_entities.SupSuppliersInfoTest;
import com.codeator.www._1_3_DB_daos.SupSuppliersInfoTestDao;
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
public class _0_0_3_0_0_Sup_Suppliers_Info_Test_Ajax_1_getAllSuppliersInfoTest_AjaxServlet extends HttpServlet {

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

            String start = request.getParameter("start");
            int Start_int = Integer.parseInt(start);
            int end = Start_int + 1000;
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
            List<SupSuppliersInfoTest> ssitList = new SupSuppliersInfoTestDao().GetAllSupSuppliersInfoTest(Start_int, end);
            SupSuppliersInfoTest_Query_jason[] supSuppliersInfoTest_Query_jason_arr = new SupSuppliersInfoTest_Query_jason[ssitList.size()];

            int i = 0;
            for (SupSuppliersInfoTest ssit : ssitList) {
                SupSuppliersInfoTest_Query_jason supSuppliersInfoTest_Query_jason2 = new SupSuppliersInfoTest_Query_jason();
                supSuppliersInfoTest_Query_jason2.setSupplierId("" + ssit.getSupplierId());
                supSuppliersInfoTest_Query_jason2.setSupplierName(ssit.getSupplierName());
                supSuppliersInfoTest_Query_jason2.setCommercialRegister(ssit.getCommercialRegister());
                supSuppliersInfoTest_Query_jason2.setTaxRegister(ssit.getTaxRegister());
                supSuppliersInfoTest_Query_jason2.setOwnerFirstName(ssit.getOwnerFirstName());
                supSuppliersInfoTest_Query_jason2.setOwnerMiddleName(ssit.getOwnerMiddleName());
                supSuppliersInfoTest_Query_jason2.setOwnerLastName(ssit.getOwnerLastName());
                supSuppliersInfoTest_Query_jason2.setFax(ssit.getFax());
                supSuppliersInfoTest_Query_jason2.setSupplierStatus(ssit.getSupplierStatus());
                supSuppliersInfoTest_Query_jason2.setTelephone1(ssit.getTelephone2());
                supSuppliersInfoTest_Query_jason2.setTelephone2(ssit.getTelephone2());
                supSuppliersInfoTest_Query_jason2.setAddress(ssit.getAddress());
                supSuppliersInfoTest_Query_jason2.setSupplierType(ssit.getSupplierType());
                supSuppliersInfoTest_Query_jason2.setSalesTaxNo(ssit.getSalesTaxNo());
                supSuppliersInfoTest_Query_jason2.setRankStar(ssit.getRankStar());
                supSuppliersInfoTest_Query_jason2.setRankPercent(ssit.getRankPercent());
                supSuppliersInfoTest_Query_jason2.setSupplierOffers(ssit.getSupplierOffers());
                supSuppliersInfoTest_Query_jason2.setActivities(ssit.getActivities());

                supSuppliersInfoTest_Query_jason_arr[i] = supSuppliersInfoTest_Query_jason2;
                i++;

                //System.out.println(i);
            }
            json = mapper.writeValueAsString(supSuppliersInfoTest_Query_jason_arr);
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
