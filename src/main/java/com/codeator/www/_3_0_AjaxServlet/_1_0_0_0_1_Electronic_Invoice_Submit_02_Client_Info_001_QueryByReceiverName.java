/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.PerGovernorateCode;
import com.codeator.www._1_2_DB_entities.PurSuppWork;
import com.codeator.www._1_2_DB_entities.PurSuppWorkDtl;
import com.codeator.www._1_2_DB_entities.PurSupplier;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDtlDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_003_receiver;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_004_address;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._201_receiverDetails;
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
 * @author Mohamed
 */
public class _1_0_0_0_1_Electronic_Invoice_Submit_02_Client_Info_001_QueryByReceiverName extends HttpServlet {

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
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            if (employee_session == null) {
                throw new Exception();
            }
            List<PerEmploymentMaster> empList = new PerEmploymentMasterDao().GetEmployeesByEmployee_ID("" + employee_session.getEmployeeId());
            employee_session = empList.get(0);
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

            String receivername = request.getParameter("receivername");
            String receiverType = request.getParameter("receiverType");
            String deptId = request.getParameter("deptId");
            String sectionId = request.getParameter("sectionId");
            String accUnitId = request.getParameter("accUnitId");

            List<PurSuppWork> pList = new PurSuppWorkDao().GetPurSupplierWorkByName(receivername, receiverType);
            _200_Submit_Documents_003_receiver[] receiver = new _200_Submit_Documents_003_receiver[pList.size()];

            int i = 0;
            for (PurSuppWork purSuppWork : pList) {

                String address_str = (purSuppWork.getAddress() == null) ? "-" : purSuppWork.getAddress();
                String buildingNumber = "";

                if (purSuppWork.getBuildingNum() == null) {
                    try {
                        buildingNumber = address_str == null ? "" : address_str.substring(0, 5).replaceAll("\\D+", "");
                    } catch (Exception e) {
                        buildingNumber = "-";
                    }
                } else {
                    buildingNumber = purSuppWork.getBuildingNum();
                }
                PerGovernorateCode perGovernorateCode = purSuppWork.getPerGovernorateCode();
                String governate = (perGovernorateCode == null)
                        ? "-" : perGovernorateCode.getAGovName();
                String regionCity = governate;//// لازم نجيب السيتي

                String country = (purSuppWork.getPerCountryCode() == null && receiverType != "F") ? "EG" : purSuppWork.getPerCountryCode().getCountrySymbol();

                _200_Submit_Documents_004_address address
                        = new _200_Submit_Documents_004_address(
                                null,
                                country, //contry
                                governate,//governate                             
                                regionCity, //regionCity
                                address_str, //street
                                buildingNumber,//buildingNumber 
                                "", //postalCode
                                "", //floor
                                "", //room
                                "", //landmark
                                "");//additionalInformation
                address.setCountryCode((purSuppWork.getPerCountryCode() == null && receiverType != "F") ? "مصر" : purSuppWork.getPerCountryCode().getACountryName());

                String temp_id = "";
                if (receiverType.equals("B")) {
                    temp_id = purSuppWork.getTaxCardNo() == null
                            ? "" : purSuppWork.getTaxCardNo();
                } else if (receiverType.equals("P")) {
                    temp_id = purSuppWork.getIdentNo() == null
                            ? "" : purSuppWork.getIdentNo();
                } else if (receiverType.equals("F")) {
                    temp_id = purSuppWork.getPassportNum() == null
                            ? "" : purSuppWork.getPassportNum();
                }
                String id = temp_id == null ? "" : temp_id.replaceAll("[/-]*", "");
                _200_Submit_Documents_003_receiver r
                        = new _200_Submit_Documents_003_receiver(
                                address,
                                receiverType,
                                id,
                                purSuppWork.getSuppName());
                //r.setSuppCode("" + purSuppWork.getSuppCode());
                r.setSuppSeq("" + purSuppWork.getSuppSeq());
                r.setFoundedInAhramData("In");

                List<_201_receiverDetails> receiverDetails = new ArrayList<>();

                List<PurSuppWorkDtl> purSuppWorkDtlList
                        = new PurSuppWorkDtlDao<>().GetPurSupplierWorkDtlBySuppSeqAndDept(
                                "" + purSuppWork.getSuppSeq(),
                                "" + employee_session.getPerDeptOld().getId().getDepNoOld(),
                                "" + employee_session.getPerDeptOld().getId().getSectionNoOld(),
                                "" + accUnitId);

                //for (PurSuppWorkDtl purSuppWorkDtl : purSuppWork.getPurSuppWorkDtls()) {
                for (PurSuppWorkDtl purSuppWorkDtl : purSuppWorkDtlList) {
                    _201_receiverDetails dtl
                            = new _201_receiverDetails(
                                    purSuppWorkDtl.getSuppSeqBr(),
                                    purSuppWorkDtl.getAddressBr(),
                                    purSuppWorkDtl.getSuppNameBr(),
                                    purSuppWorkDtl.getSuppMainFrameCode());
                    receiverDetails.add(dtl);
                }

                r.setReceiverDetails(receiverDetails);
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
