/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.PurContractMaster;
import com.codeator.www._1_2_DB_entities.PurContractMasterDtl;
import com.codeator.www._1_2_DB_entities.PurContractServiceJoin;
import com.codeator.www._1_3_DB_daos.PurContractMasterDAO;
import com.codeator.www._1_3_DB_daos.PurContractMasterDtlDAO;
import com.codeator.www._6_0_Json_entities._1_0_0_5_0_Pur_Contract_Insert_dtl_json;
import com.codeator.www._6_0_Json_entities._1_0_0_5_0_Pur_Contract_Insert_json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_003_receiver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class _1_0_0_5_0_Pur_Contract_Insert_02_getContracts_AjaxServlet extends HttpServlet {

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
            _1_0_0_5_0_Pur_Contract_Insert_json contract = mapper.readValue(json, _1_0_0_5_0_Pur_Contract_Insert_json.class);

            String SuppSeq = contract.getReceiver().getSuppSeq();
            _200_Submit_Documents_003_receiver receiver = contract.getReceiver();

            String sectionId = request.getParameter("sectionId");
            String deptId = request.getParameter("deptId");
            String titleSeq = request.getParameter("title_id");

            List<PurContractMaster> pList = new PurContractMasterDAO().GetAllContractInDeptBySupplier(deptId, sectionId, SuppSeq, titleSeq);

            _1_0_0_5_0_Pur_Contract_Insert_json[] contract_master_arr = new _1_0_0_5_0_Pur_Contract_Insert_json[pList.size()];
            int i = 0;
            for (PurContractMaster purContractMaster : pList) {
                _1_0_0_5_0_Pur_Contract_Insert_json contract_master = new _1_0_0_5_0_Pur_Contract_Insert_json();
                List<String> serviceSeq = new ArrayList<String>();
                for (PurContractServiceJoin purContractServiceJoin : purContractMaster.getPurContractServiceJoins()) {
                    serviceSeq.add("" + purContractServiceJoin.getId().getServiceSeq());
                }
                contract_master.setServiceSeq(serviceSeq);
                contract_master.setContractDate(new DateOp().Date2String(purContractMaster.getContractDate(), "yyyy-MM-dd"));
                contract_master.setContractValue("" + purContractMaster.getContractValue());
                contract_master.setContractFromDate(new DateOp().Date2String(purContractMaster.getContractFromDate(), "yyyy-MM-dd"));
                contract_master.setContractToDate(new DateOp().Date2String(purContractMaster.getContractToDate(), "yyyy-MM-dd"));
                contract_master.setContractTax(purContractMaster.getContractTax());
                contract_master.setPeriodType("" + purContractMaster.getPurContractPeriodType().getPeriodType() + "," + purContractMaster.getPurContractPeriodType().getPeriodVal() + "," + purContractMaster.getPurContractPeriodType().getPeriodValAlert());
                contract_master.setPaymentKind("" + purContractMaster.getInvoSuppPaymentType().getPaymentType());
                contract_master.setContractAlertDate(new DateOp().Date2String(purContractMaster.getContractAlertDate(), "yyyy-MM-dd"));
                contract_master.setRmrk(purContractMaster.getRmrk());
                contract_master.setPeriodVal("" + purContractMaster.getPeriodVal());
                //// contract_master id
                System.out.println("--" + deptId);
                contract_master.setContractSp("" + purContractMaster.getId().getContractSp());
                contract_master.setDeptNoOld("" + purContractMaster.getId().getDepNoOld());
                contract_master.setSectionNoOld("" + purContractMaster.getId().getSectionNoOld());
                contract_master.setTitleId("" + purContractMaster.getId().getTitelSp() + "," + purContractMaster.getId().getSectionNoOld() + "," + purContractMaster.getId().getDepNoOld());

                List<_1_0_0_5_0_Pur_Contract_Insert_dtl_json> purContractMasterDtl = new ArrayList<>();
                List<PurContractMasterDtl> dtlList
                        = new PurContractMasterDtlDAO<>().GetContractsDtl(
                                "" + purContractMaster.getId().getContractSp(),
                                "" + purContractMaster.getId().getTitelSp(),
                                "" + purContractMaster.getId().getDepNoOld(),
                                "" + purContractMaster.getId().getSectionNoOld());

                for (PurContractMasterDtl purContractMasterDtl1 : dtlList) {
                    _1_0_0_5_0_Pur_Contract_Insert_dtl_json dtl = new _1_0_0_5_0_Pur_Contract_Insert_dtl_json();
                    dtl.setConFromDate(new DateOp().Date2String(purContractMasterDtl1.getConFromDate(), "yyyy-MM-dd"));
                    dtl.setConToDate(new DateOp().Date2String(purContractMasterDtl1.getConToDate(), "yyyy-MM-dd"));
                    dtl.setConValue(purContractMasterDtl1.getConValue().doubleValue());
                    purContractMasterDtl.add(dtl);
                }

                contract_master.setPurContractMasterDtl(purContractMasterDtl);

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
