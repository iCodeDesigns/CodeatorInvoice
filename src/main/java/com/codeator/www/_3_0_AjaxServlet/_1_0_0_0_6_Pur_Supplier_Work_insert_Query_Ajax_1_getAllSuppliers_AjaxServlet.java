/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PurSuppWork;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_003_receiver;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_004_address;
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
public class _1_0_0_0_6_Pur_Supplier_Work_insert_Query_Ajax_1_getAllSuppliers_AjaxServlet extends HttpServlet {

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
            /*BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            String json = "";
            if (br != null) {
                json = br.readLine();
                //System.out.println(json);
            }
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile perDecisionSheet_1_JasonFile = mapper.readValue(json, _0_0_0_4_0_0_PerDecisionSheet_1_JasonFile.class);
             */

            List<PurSuppWork> pList = new PurSuppWorkDao().GetAllPurSupplierWork();
            _200_Submit_Documents_003_receiver[] receiver = new _200_Submit_Documents_003_receiver[pList.size()];

            int i = 0;
            for (PurSuppWork purSuppWork : pList) {

                String buildingNumber = (purSuppWork.getBuildingNum() == null) ? "-" : purSuppWork.getBuildingNum();
                String governate = (purSuppWork.getPerGovernorateCode() == null)
                        ? "-" : purSuppWork.getPerGovernorateCode().getAGovName();
                String street = (purSuppWork.getAddress() == null) ? "-" : purSuppWork.getAddress();
                String regionCity = governate;//// لازم نجيب السيتي

                String CountryCode = (purSuppWork.getPerCountryCode() == null) ? "1" : purSuppWork.getPerCountryCode().getCountryCode();
                String countryCode_govCode = (purSuppWork.getPerGovernorateCode() == null) ? "" : purSuppWork.getPerGovernorateCode().getId().getCountryCode() + "-" + purSuppWork.getPerGovernorateCode().getId().getGovCode();
                _200_Submit_Documents_004_address address
                        = new _200_Submit_Documents_004_address(
                                null,
                                CountryCode, //contry
                                governate,//governate                             
                                regionCity, //regionCity
                                street, //street
                                buildingNumber,//buildingNumber 
                                "", //postalCode
                                "", //floor
                                "", //room
                                "", //landmark
                                countryCode_govCode);//additionalInformation

                String taxCardNo_temp_id = purSuppWork.getTaxCardNo() == null
                        ? "" : purSuppWork.getTaxCardNo();
                String taxCardNo = taxCardNo_temp_id == null ? "" : taxCardNo_temp_id.replaceAll("[/-]*", "");

                String identNo_temp_id = purSuppWork.getIdentNo() == null
                        ? "" : purSuppWork.getIdentNo();
                String identNo = identNo_temp_id == null ? "" : identNo_temp_id.replaceAll("[/-]*", "");

                String passportNo_temp_id = purSuppWork.getPassportNum() == null
                        ? "" : purSuppWork.getPassportNum();
                String passportNo = passportNo_temp_id == null ? "" : passportNo_temp_id.replaceAll("[/-]*", "");

                _200_Submit_Documents_003_receiver r
                        = new _200_Submit_Documents_003_receiver(
                                address,
                                "BPF",
                                taxCardNo,
                                purSuppWork.getSuppName());

                //r.setSuppCode("" + purSuppWork.getPurSupplier().getSuppCode());
                r.setSuppSeq("" + purSuppWork.getSuppSeq());
                r.setTaxCardNo(taxCardNo);
                r.setIdentNo(identNo);
                r.setPassportNo(passportNo);
                r.setFoundedInAhramData("In");
                receiver[i] = r;
                i++;
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(receiver);
            //System.out.println(pList.size());
            // success
            response.setContentType("application/json");
            response.getWriter().write(json);
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
