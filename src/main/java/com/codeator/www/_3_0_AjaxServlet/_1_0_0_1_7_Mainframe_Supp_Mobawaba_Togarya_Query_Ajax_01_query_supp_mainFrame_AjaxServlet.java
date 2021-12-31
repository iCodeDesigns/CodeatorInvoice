/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.MainframeSuppMobawaba;
import com.codeator.www._1_2_DB_entities.MainframeSuppTogarya;
import com.codeator.www._1_2_DB_entities.PerCountryCode;
import com.codeator.www._1_2_DB_entities.PerGovernorateCode;
import com.codeator.www._1_2_DB_entities.PurContractServiceType;
import com.codeator.www._1_3_DB_daos.MainframeSuppMobawaba_DAO;
import com.codeator.www._1_3_DB_daos.MainframeSuppTogarya_DAO;
import com.codeator.www._1_3_DB_daos.PerCountryCodeDAO;
import com.codeator.www._1_3_DB_daos.PerGovernorateCodeDAO;
import com.codeator.www._1_3_DB_daos.PurContractServiceTypeDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_1_7_Mainframe_Supp_Mobawaba_Togarya_Query_Ajax_01_query_supp_mainFrame_AjaxServlet extends HttpServlet {

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

            List<MainframeSuppTogarya> MainframeSuppTogaryaList = new ArrayList<>();
            List<MainframeSuppMobawaba> MainframeSuppMobawabaList = new ArrayList<>();
            String accUnitId = request.getParameter("accUnitId");
            String taxCardStatus = request.getParameter("taxCardStatus");
            String mainFrameCode = request.getParameter("mainFrameCode");

            if (accUnitId.equals("20") || accUnitId.equals("80")) {
                switch (taxCardStatus) {
                    case "null":
                        MainframeSuppMobawabaList = new MainframeSuppMobawaba_DAO().GetByTaxCardNoIsNull();
                        break;
                    case "not_null":
                        MainframeSuppMobawabaList = new MainframeSuppMobawaba_DAO().GetByTaxCardNoIsNotNull();
                        break;
                    case "all":
                        MainframeSuppMobawabaList = new MainframeSuppMobawaba_DAO().GetAll();
                        break;
                    case "mainFrameCode":
                        MainframeSuppMobawabaList = new MainframeSuppMobawaba_DAO().GetByMainFrameCode(mainFrameCode);
                        break;
                }
            } else if (accUnitId.equals("02") || accUnitId.equals("81")) {

                switch (taxCardStatus) {
                    case "null":
                        MainframeSuppTogaryaList = new MainframeSuppTogarya_DAO().GetByTaxCardNoIsNull();
                        break;
                    case "not_null":
                        MainframeSuppTogaryaList = new MainframeSuppTogarya_DAO().GetByTaxCardNoIsNotNull();
                        break;
                    case "all":
                        MainframeSuppTogaryaList = new MainframeSuppTogarya_DAO().GetAll();
                        break;
                    case "mainFrameCode":
                        MainframeSuppTogaryaList = new MainframeSuppTogarya_DAO().GetByMainFrameCode(mainFrameCode);
                        break;

                }
            }

            ObjectMapper mapper = new ObjectMapper();
            String json = "[]";

            List<com.codeator.www._6_1_Json_entities.MainframeSuppTogarya> MainframeSuppTogarya_JSON_List = new ArrayList<>();
            List<com.codeator.www._6_1_Json_entities.MainframeSuppMobawaba> MainframeSuppMobawaba_JSON_List = new ArrayList<>();
            if (!MainframeSuppMobawabaList.isEmpty()) {
                for (MainframeSuppMobawaba mainframeSuppMobawaba : MainframeSuppMobawabaList) {
                    com.codeator.www._6_1_Json_entities.MainframeSuppMobawaba MainframeSuppMobawaba_Temp = new com.codeator.www._6_1_Json_entities.MainframeSuppMobawaba();

                    MainframeSuppMobawaba_Temp.setAdress(mainframeSuppMobawaba.getAdress());
                    MainframeSuppMobawaba_Temp.setMainFrameCode(mainframeSuppMobawaba.getMainFrameCode());
                    MainframeSuppMobawaba_Temp.setProdCode(mainframeSuppMobawaba.getProdCode());
                    MainframeSuppMobawaba_Temp.setReceiverCode(mainframeSuppMobawaba.getReceiverCode());
                    MainframeSuppMobawaba_Temp.setSuppName(mainframeSuppMobawaba.getSuppName());

                    String taxCardNo = (mainframeSuppMobawaba.getTaxCardNo() == null) ? null : mainframeSuppMobawaba.getTaxCardNo().replaceAll("[-/]", "");
                    MainframeSuppMobawaba_Temp.setTaxCardNo(taxCardNo);

                    List<PerCountryCode> PerCountryCodeList = new PerCountryCodeDAO().GetCountriesByCountryCode(mainframeSuppMobawaba.getCountryCode());
                    String CountryCode = "";
                    try {
                        CountryCode = mainframeSuppMobawaba.getCountryCode() + "-" + PerCountryCodeList.get(0).getACountryName();
                    } catch (Exception ee) {
                        CountryCode = "-";
                    }
                    MainframeSuppMobawaba_Temp.setCountryCode(CountryCode);

                    List<PerGovernorateCode> PerGovernorateCodeList = new PerGovernorateCodeDAO().GetPerGovernorateCodeByID(mainframeSuppMobawaba.getCountryCode(), mainframeSuppMobawaba.getGovCode());
                    String govData = "";
                    try {
                        govData = mainframeSuppMobawaba.getGovCode() + "-" + PerGovernorateCodeList.get(0).getAGovName();
                    } catch (Exception ee) {
                        govData = "*-";
                    }
                    MainframeSuppMobawaba_Temp.setGovCode(govData);

                    List<PurContractServiceType> pList = new PurContractServiceTypeDao().GetContractService(mainframeSuppMobawaba.getServiceSeq());
                    String ServiceCodeName = "";
                    if (!pList.isEmpty()) {
                        ServiceCodeName = pList.get(0).getServiceCode() + "(" + pList.get(0).getServiceName() + ")";
                    }
                    MainframeSuppMobawaba_Temp.setServiceSeq(mainframeSuppMobawaba.getServiceSeq() + "-" + ServiceCodeName);

                    MainframeSuppMobawaba_JSON_List.add(MainframeSuppMobawaba_Temp);

                }
                json = mapper.writeValueAsString(MainframeSuppMobawaba_JSON_List);
            } else if (!MainframeSuppTogaryaList.isEmpty()) {
                for (MainframeSuppTogarya mainframeSuppTogarya : MainframeSuppTogaryaList) {
                    com.codeator.www._6_1_Json_entities.MainframeSuppTogarya MainframeSuppTogarya_Temp = new com.codeator.www._6_1_Json_entities.MainframeSuppTogarya();

                    MainframeSuppTogarya_Temp.setAdress(mainframeSuppTogarya.getAdress());
                    MainframeSuppTogarya_Temp.setMainFrameCode(mainframeSuppTogarya.getMainFrameCode());
                    MainframeSuppTogarya_Temp.setProdCode(mainframeSuppTogarya.getProdCode());
                    MainframeSuppTogarya_Temp.setReceiverCode(mainframeSuppTogarya.getReceiverCode());
                    MainframeSuppTogarya_Temp.setSuppName(mainframeSuppTogarya.getSuppName());

                    String taxCardNo = (mainframeSuppTogarya.getTaxCardNo() == null) ? null : mainframeSuppTogarya.getTaxCardNo().replaceAll("[-/]", "");
                    MainframeSuppTogarya_Temp.setTaxCardNo(taxCardNo);

                    List<PerCountryCode> PerCountryCodeList = new PerCountryCodeDAO().GetCountriesByCountryCode(mainframeSuppTogarya.getCountryCode());
                    String CountryCode = "";
                    try {
                        CountryCode = mainframeSuppTogarya.getCountryCode() + "-" + PerCountryCodeList.get(0).getACountryName();
                    } catch (Exception ee) {
                        CountryCode = "-";
                    }
                    MainframeSuppTogarya_Temp.setCountryCode(CountryCode);

                    List<PerGovernorateCode> PerGovernorateCodeList = new PerGovernorateCodeDAO().GetPerGovernorateCodeByID(mainframeSuppTogarya.getCountryCode(), mainframeSuppTogarya.getGovCode());
                    String govData = "";
                    try {
                        govData = mainframeSuppTogarya.getGovCode() + "-" + PerGovernorateCodeList.get(0).getAGovName();
                    } catch (Exception ee) {
                        govData = "*-";
                    }
                    MainframeSuppTogarya_Temp.setGovCode(govData);

                    List<PurContractServiceType> pList = new PurContractServiceTypeDao().GetContractService(mainframeSuppTogarya.getServiceSeq());
                    String ServiceCodeName = "";
                    if (!pList.isEmpty()) {
                        ServiceCodeName = pList.get(0).getServiceCode() + "(" + pList.get(0).getServiceName() + ")";
                    }
                    MainframeSuppTogarya_Temp.setServiceSeq(mainframeSuppTogarya.getServiceSeq() + "-" + ServiceCodeName);

                    MainframeSuppTogarya_JSON_List.add(MainframeSuppTogarya_Temp);

                }
                json = mapper.writeValueAsString(MainframeSuppTogarya_JSON_List);
            }

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
