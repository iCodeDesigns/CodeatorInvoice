/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_2_DB_entities.InvoSuppPaymentType;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.PurContractMaster;
import com.codeator.www._1_2_DB_entities.PurContractMasterDtl;
import com.codeator.www._1_2_DB_entities.PurContractMasterDtlId;
import com.codeator.www._1_2_DB_entities.PurContractMasterId;
import com.codeator.www._1_2_DB_entities.PurContractPeriodType;
import com.codeator.www._1_2_DB_entities.PurContractServiceJoin;
import com.codeator.www._1_2_DB_entities.PurContractServiceJoinId;
import com.codeator.www._1_2_DB_entities.PurContractServiceType;
import com.codeator.www._1_2_DB_entities.PurContractTitel;
import com.codeator.www._1_2_DB_entities.PurContractTitelId;
import com.codeator.www._1_2_DB_entities.PurSuppWork;
import com.codeator.www._1_2_DB_entities.PurSuppWorkDtl;
import com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao;
import com.codeator.www._1_3_DB_daos.InvoSuppPaymentTypeDAO;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._1_3_DB_daos.PurContractMasterDAO;
import com.codeator.www._1_3_DB_daos.PurContractMasterDtlDAO;
import com.codeator.www._1_3_DB_daos.PurContractPeriodTypeDAO;
import com.codeator.www._1_3_DB_daos.PurContractServiceTypeDao;
import com.codeator.www._1_3_DB_daos.PurContractTitelDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDtlDao;
import com.codeator.www._6_0_Json_entities._1_0_0_5_0_Pur_Contract_Insert_dtl_json;
import com.codeator.www._6_0_Json_entities._1_0_0_5_0_Pur_Contract_Insert_json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_003_receiver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Moham
 */
public class _1_0_0_5_0_Pur_Contract_Insert_01_saveContract_AjaxServlet extends HttpServlet {

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

            List<String> serviceSeqList = contract.getServiceSeq();
            String contractDate = contract.getContractDate();
            String contractValue = contract.getContractValue();
            String contractTax = contract.getContractTax();
            String periodType = contract.getPeriodType();
            String paymentKind = contract.getPaymentKind();
            String contractFromDate = contract.getContractFromDate();
            String contractToDate = contract.getContractToDate();
            String contractAlertDate = contract.getContractAlertDate();
            String periodVal = contract.getPeriodVal();
            String title_id = contract.getTitleId();
            String title_text = contract.getTitleText();
            String addNewTitle = contract.getAddNewTitle();

            String rmrk = contract.getRmrk();
            _200_Submit_Documents_003_receiver receiver = contract.getReceiver();

            String sectionId = request.getParameter("sectionId");
            String deptId = request.getParameter("deptId");
            String accUnitCode = request.getParameter("accUnitId");

            String transaction_type = request.getParameter("transaction_type");

            List<InvoAccUintDept> deptList
                    = new InvoAccUintDeptDao().GetInvoAccUintInDeptAndUnit(accUnitCode, sectionId, deptId);

            if (deptList.isEmpty()) {
                throw new Exception();
            }

            List<PurSuppWork> PurSuppWorkDaoList = new PurSuppWorkDao().GetPurSupplierById(contract.getReceiver().getSuppSeq());
            if (PurSuppWorkDaoList.isEmpty()) {
                throw new Exception();
            }

            List<PurContractPeriodType> PurContractPeriodTypeList = new PurContractPeriodTypeDAO().GetContractServiceById(periodType);
            if (PurContractPeriodTypeList.isEmpty()) {
                throw new Exception();
            }

            List<InvoSuppPaymentType> PaymentTypeList = new InvoSuppPaymentTypeDAO().GetInvoSuppPaymentTypeById(paymentKind);
            if (PaymentTypeList.isEmpty()) {
                throw new Exception();
            }

            if (transaction_type.equals("add")) {
                new HibernateSessionCon().beginTrans();
                /////----- add purContractTitel or get Record
                PurContractTitel purContractTitel = new PurContractTitel();
                if (addNewTitle.equals("true")) {
                    int titelSp = new PurContractTitelDao<>().getMaxID(sectionId, deptId);
                    PurContractTitelId Titelid = new PurContractTitelId(titelSp, Long.parseLong(deptId), Integer.parseInt(sectionId), accUnitCode);
                    purContractTitel = new PurContractTitel(Titelid, deptList.get(0));
                    purContractTitel.setTitelName(title_text);
                    new PurContractTitelDao().save(purContractTitel);
                } else {
                    List<PurContractTitel> purContractTitelList = new PurContractTitelDao().getTitlesByDept(title_id, sectionId, deptId);
                    if (purContractTitelList.isEmpty()) {
                        throw new Exception();
                    }
                    purContractTitel = purContractTitelList.get(0);
                }

                List<PurContractMasterDtl> dateFromInsideIntervalList = new PurContractMasterDtlDAO().GetContractsHaveThisDate(contractFromDate, "" + purContractTitel.getId().getDepNoOld(), "" + purContractTitel.getId().getSectionNoOld(), receiver.getSuppSeq(), "" + purContractTitel.getId().getTitelSp());
                if (!dateFromInsideIntervalList.isEmpty()) {
                    throw new Exception("existContractDateFrom");
                }

                List<PurContractMasterDtl> dateToInsideIntervalList = new PurContractMasterDtlDAO().GetContractsHaveThisDate(contractToDate, deptId, sectionId, receiver.getSuppSeq(), "" + purContractTitel.getId().getTitelSp());
                if (!dateToInsideIntervalList.isEmpty()) {
                    throw new Exception("existContractDateTo");
                }

                long contractSp
                        = new PurContractMasterDAO().GetMaxInvoSp(
                                "" + purContractTitel.getId().getDepNoOld(),
                                "" + purContractTitel.getId().getSectionNoOld(),
                                "" + purContractTitel.getId().getTitelSp());
                PurContractMasterId id = new PurContractMasterId(contractSp, purContractTitel.getId().getSectionNoOld(), purContractTitel.getId().getDepNoOld(), purContractTitel.getId().getTitelSp(), purContractTitel.getId().getAccUnitCode());

                PurContractMaster purContractMaster
                        = new PurContractMaster(
                                id,
                                PurSuppWorkDaoList.get(0),
                                purContractTitel,
                                PurContractPeriodTypeList.get(0),
                                new DateOp().String2Date(contractDate, "yyyy-MM-dd"),
                                BigDecimal.valueOf(Double.parseDouble(contractValue)));

                purContractMaster.setContractAlertDate(new DateOp().String2Date(contractAlertDate, "yyyy-MM-dd"));
                purContractMaster.setContractTax(contractTax);
                purContractMaster.setInsertDate(new Date());
                purContractMaster.setInsertDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));
                purContractMaster.setInvoSuppPaymentType(PaymentTypeList.get(0));
                purContractMaster.setRmrk(rmrk);
                purContractMaster.setPerEmploymentMaster(employee_session);
                purContractMaster.setContractFromDate(new DateOp().String2Date(contractFromDate, "yyyy-MM-dd"));
                purContractMaster.setContractToDate(new DateOp().String2Date(contractToDate, "yyyy-MM-dd"));
                purContractMaster.setPeriodVal(Integer.parseInt(periodVal));

                new PurContractMasterDAO().save(purContractMaster);////<<<<----------------------------------------------------------purContractMaster

                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl
                int contractSeq = 1;//new PurContractMasterDtlDAO().GetMaxInvoSp("" + contractSp);
                for (_1_0_0_5_0_Pur_Contract_Insert_dtl_json dtl : contract.getPurContractMasterDtl()) {

                    PurContractMasterDtlId Dtlid = new PurContractMasterDtlId(
                            contractSp,
                            purContractTitel.getId().getDepNoOld(),
                            purContractTitel.getId().getTitelSp(),
                            purContractTitel.getId().getSectionNoOld(),
                            contractSeq,
                            purContractTitel.getId().getAccUnitCode());

                    PurContractMasterDtl purContractMasterDtl
                            = new PurContractMasterDtl(Dtlid, purContractMaster, BigDecimal.valueOf(dtl.getConValue()));

                    purContractMasterDtl.setConFromDate(new DateOp().String2Date(dtl.getConFromDate(), "yyyy-MM-dd"));
                    purContractMasterDtl.setConToDate(new DateOp().String2Date(dtl.getConToDate(), "yyyy-MM-dd"));
                    new PurContractMasterDtlDAO().save(purContractMasterDtl);////<<<<----------------------------------------------------------purContractMasterDtl
                    contractSeq++;
                }
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl

                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl
                for (String serviceSeq : serviceSeqList) {

                    List<PurContractServiceType> PurContractServiceTypeList = new PurContractServiceTypeDao<>().GetContractService(serviceSeq);
                    if (PurContractServiceTypeList.isEmpty()) {
                        throw new Exception();
                    }
                    PurContractServiceType purContractServiceType = PurContractServiceTypeList.get(0);

                    PurContractServiceJoinId ServiceJoinid = new PurContractServiceJoinId(
                            purContractServiceType.getInvoAccUintDept().getId().getDepNoOld(),
                            purContractTitel.getId().getTitelSp(),
                            contractSp,
                            purContractServiceType.getInvoAccUintDept().getId().getSectionNoOld(),
                            Long.parseLong(serviceSeq),
                            purContractServiceType.getInvoAccUintDept().getId().getAccUnitCode());

                    PurContractServiceJoin purContractServiceJoin
                            = new PurContractServiceJoin(ServiceJoinid, purContractMaster, purContractServiceType);

                    purContractServiceJoin.setRmrk("");

                    new PurContractMasterDtlDAO().save(purContractServiceJoin);////<<<<----------------------------------------------------------purContractServiceJoin
                    contractSeq++;
                }
                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl

                new HibernateSessionCon().CommitTrans();
            } else {
                new HibernateSessionCon().beginTrans();
                String contractSp = request.getParameter("contractSp");
                String titleId = request.getParameter("titleId");
                List<PurContractMaster> pList = new PurContractMasterDAO().GetContractById(contractSp, titleId, sectionId, deptId);
                if (pList.isEmpty()) {
                    throw new Exception("");
                }

                PurContractMaster purContractMaster = pList.get(0);
                //-- Delete detail
                for (PurContractMasterDtl purContractMasterDtl : purContractMaster.getPurContractMasterDtls()) {
                    new PurContractMasterDAO().delete(purContractMasterDtl);
                }
                for (PurContractServiceJoin purContractServiceJoin : purContractMaster.getPurContractServiceJoins()) {
                    new PurContractMasterDAO().delete(purContractServiceJoin);
                }

                /////----- add purContractTitel or get Record
                PurContractTitel purContractTitel = new PurContractTitel();
                if (addNewTitle.equals("true")) {
                    int titelSp = new PurContractTitelDao<>().getMaxID(sectionId, deptId);
                    PurContractTitelId Titelid = new PurContractTitelId(titelSp, Long.parseLong(deptId), Integer.parseInt(sectionId), accUnitCode);
                    purContractTitel = new PurContractTitel(Titelid, deptList.get(0));
                    purContractTitel.setTitelName(title_text);
                    new PurContractTitelDao().save(purContractTitel);
                } else {
                    List<PurContractTitel> purContractTitelList = new PurContractTitelDao().getTitlesByDept(title_id, sectionId, deptId);
                    if (purContractTitelList.isEmpty()) {
                        throw new Exception();
                    }
                    purContractTitel = purContractTitelList.get(0);
                }

                //-- update Master
                purContractMaster.setPurSuppWork(PurSuppWorkDaoList.get(0));
                purContractMaster.setPurContractPeriodType(PurContractPeriodTypeList.get(0));
                purContractMaster.setPurContractTitel(purContractTitel);
                purContractMaster.setContractDate(new DateOp().String2Date(contractDate, "yyyy-MM-dd"));
                purContractMaster.setContractValue(BigDecimal.valueOf(Double.parseDouble(contractValue)));

                purContractMaster.setContractAlertDate(new DateOp().String2Date(contractAlertDate, "yyyy-MM-dd"));
                purContractMaster.setContractTax(contractTax);

                purContractMaster.setUpdateDate(new Date());
                purContractMaster.setUpdateDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));

                purContractMaster.setInvoSuppPaymentType(PaymentTypeList.get(0));
                purContractMaster.setRmrk(rmrk);
                purContractMaster.setPerEmploymentMaster(employee_session);
                purContractMaster.setContractFromDate(new DateOp().String2Date(contractFromDate, "yyyy-MM-dd"));
                purContractMaster.setContractToDate(new DateOp().String2Date(contractToDate, "yyyy-MM-dd"));
                purContractMaster.setPeriodVal(Integer.parseInt(periodVal));

                new PurContractMasterDAO().update(purContractMaster);

                //-- insert new dtl
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl
                int contractSeq = 1;//new PurContractMasterDtlDAO().GetMaxInvoSp("" + contractSp);
                for (_1_0_0_5_0_Pur_Contract_Insert_dtl_json dtl : contract.getPurContractMasterDtl()) {

                    PurContractMasterDtlId id = new PurContractMasterDtlId(
                            purContractMaster.getId().getContractSp(),
                            purContractMaster.getId().getDepNoOld(),
                            purContractMaster.getId().getTitelSp(),
                            purContractMaster.getId().getSectionNoOld(),
                            contractSeq,
                            purContractMaster.getId().getAccUnitCode());

                    PurContractMasterDtl purContractMasterDtl
                            = new PurContractMasterDtl(id, purContractMaster, BigDecimal.valueOf(dtl.getConValue()));

                    purContractMasterDtl.setConFromDate(new DateOp().String2Date(dtl.getConFromDate(), "yyyy-MM-dd"));
                    purContractMasterDtl.setConToDate(new DateOp().String2Date(dtl.getConToDate(), "yyyy-MM-dd"));
                    new PurContractMasterDtlDAO().insert(purContractMasterDtl);
                    contractSeq++;
                }
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl
                /////---------------- Insert Contract Dtl

                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl
                for (String serviceSeq : serviceSeqList) {

                    List<PurContractServiceType> PurContractServiceTypeList = new PurContractServiceTypeDao<>().GetContractService(serviceSeq);
                    if (PurContractServiceTypeList.isEmpty()) {
                        throw new Exception();
                    }
                    PurContractServiceType purContractServiceType = PurContractServiceTypeList.get(0);

                    PurContractServiceJoinId ServiceJoinid = new PurContractServiceJoinId(
                            purContractServiceType.getInvoAccUintDept().getId().getDepNoOld(),
                            purContractTitel.getId().getTitelSp(),
                            purContractMaster.getId().getContractSp(),
                            purContractServiceType.getInvoAccUintDept().getId().getSectionNoOld(),
                            Long.parseLong(serviceSeq),
                            purContractServiceType.getInvoAccUintDept().getId().getAccUnitCode());

                    PurContractServiceJoin purContractServiceJoin
                            = new PurContractServiceJoin(ServiceJoinid, purContractMaster, purContractServiceType);

                    purContractServiceJoin.setRmrk("");

                    new PurContractMasterDtlDAO().save(purContractServiceJoin);
                    contractSeq++;
                }
                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl
                /////---------------- Insert Service Dtl

                new HibernateSessionCon().CommitTrans();

            }
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            if (message.equals("existContractDateFrom")) {
                message = "تاريخ بداية العقد متواجد بعقد ساري لنفس العنوان لنفس العميل";
            } else if (message.equals("existContractDateTo")) {
                message = "تاريخ نهاية العقد متواجد بعقد ساري لنفس العنوان لنفس العميل";
            } else {
                message = "Error";
            }
            response.getWriter().write(message);
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
