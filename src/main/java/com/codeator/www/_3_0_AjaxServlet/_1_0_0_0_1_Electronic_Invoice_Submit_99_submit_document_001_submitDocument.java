/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.alahram.constants.InvoiceDocumentConstants;
import com.codeator.www._0_0_CodeatorLib.MathOp;
import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
import com.codeator.www._1_2_DB_entities.AccAccountUnits;
import com.codeator.www._1_2_DB_entities.AccCurrencyCode;
import com.codeator.www._1_2_DB_entities.InvItemCode;
import com.codeator.www._1_2_DB_entities.InvoAccUintDept;
import com.codeator.www._1_2_DB_entities.InvoAccUnitsCode;
import com.codeator.www._1_2_DB_entities.InvoDeptItemJoinDescDtl;
import com.codeator.www._1_2_DB_entities.InvoDocumentStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterId;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterItem;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterItemId;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatusId;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterTax;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterTaxId;
import com.codeator.www._1_2_DB_entities.InvoItemCode;
import com.codeator.www._1_2_DB_entities.InvoTaxTypeDtl;
import com.codeator.www._1_2_DB_entities.InvoUnitType;
import com.codeator.www._1_2_DB_entities.PerCountryCode;
import com.codeator.www._1_2_DB_entities.PerDeptOld;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_2_DB_entities.PerGovernorateCode;
import com.codeator.www._1_2_DB_entities.PurContractServiceType;
import com.codeator.www._1_2_DB_entities.PurSuppWork;
import com.codeator.www._1_2_DB_entities.PurSuppWorkDtl;
import com.codeator.www._1_2_DB_entities.PurSupplier;
import com.codeator.www._1_3_DB_daos.AccAccountUnitsDAO;
import com.codeator.www._1_3_DB_daos.AccCurrencyCodeDAO;
import com.codeator.www._1_3_DB_daos.InvInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvInvoiceMasterItemDAO;
import com.codeator.www._1_3_DB_daos.InvoItemCodeDAO;
import com.codeator.www._1_3_DB_daos.InvTaxSubtypeDAO;
import com.codeator.www._1_3_DB_daos.InvUnitTypeDAO;
import com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao;
import com.codeator.www._1_3_DB_daos.InvoAccUnitsCodeDao;
import com.codeator.www._1_3_DB_daos.InvoDeptItemJoinDescDtlDAO;
import com.codeator.www._1_3_DB_daos.InvoDocumentStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterItemDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoTaxTypeDtlDAO;
import com.codeator.www._1_3_DB_daos.InvoUnitTypeDAO;
import com.codeator.www._1_3_DB_daos.PerCountryCodeDAO;
import com.codeator.www._1_3_DB_daos.PerDeptOldDao;
import com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao;
import com.codeator.www._1_3_DB_daos.PerGovernorateCodeDAO;
import com.codeator.www._1_3_DB_daos.PurContractServiceTypeDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDao;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDtlDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_009_unitValue;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_010_discount;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_014_taxTotal;
import com.taxdemo.www._4_0_0_customCalculation.invoiceCalculation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamed
 */
public class _1_0_0_0_1_Electronic_Invoice_Submit_99_submit_document_001_submitDocument extends HttpServlet {

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
            //System.out.println("----- Json :" + json);
            // 2. initiate jackson mapper
            ObjectMapper mapper = new ObjectMapper();

            // 3. Convert received JSON to Article
            _200_Submit_Documents_001_document document = mapper.readValue(json, _200_Submit_Documents_001_document.class);
            String sectionId = request.getParameter("sectionId");
            String deptId = request.getParameter("deptId");
            String accUnitId = request.getParameter("accUnitId");
            String search = request.getParameter("search"); // true : يعني حصل اشعار خصم او اضافة  ||||| false : يعني فاتورة 
            String chkInvoInternalIdSeq = request.getParameter("chkInvoInternalIdSeq");

            String reciver_type = document.getReceiver().getType();
            double Total_Amount = document.getTotalAmount();
            String reciver_id = document.getReceiver().getId();

            if (reciver_type.equals("P")
                    && Total_Amount > 50000
                    && (reciver_id.equals("") || reciver_id.isEmpty() || reciver_id == null)) {
                String host = request.getHeader("host"); // -- Server Host IP and PORT
                String Client_IP = request.getRemoteAddr();// -- Client IP
                boolean split_status = seperateDocument(accUnitId, document, deptId, sectionId, employee_session, Client_IP, chkInvoInternalIdSeq);
                if (!split_status) {
                    throw new Exception();
                }

            } else {

                long invoSpMax = new InvoInvoiceMasterDao().GetMaxInvoSp(accUnitId, sectionId, deptId);
                InvoInvoiceMasterId id = new InvoInvoiceMasterId(Long.parseLong(deptId), accUnitId, Integer.parseInt(sectionId), invoSpMax);

                //get deptUnit
                List<InvoAccUintDept> InvoAccUintDeptList = new InvoAccUintDeptDao<>().GetInvoAccUintInDeptAndUnit(accUnitId, sectionId, deptId);
                if (InvoAccUintDeptList.isEmpty()) {
                    throw new Exception();
                }

                //get Supplier 
                List<PurSuppWork> PurSupplierList = new PurSuppWorkDao().GetPurSupplierById(document.getReceiver().getSuppSeq());
                /*if (PurSupplierList.isEmpty()) {
                throw new Exception();
            }*/

                //get document status
                List<InvoDocumentStatus> invoDocumentStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus("1");// انشاء
                if (invoDocumentStatusList.isEmpty()) {
                    throw new Exception();
                }

                new HibernateSessionCon().beginTrans();
                InvoInvoiceMasterDao dao = new InvoInvoiceMasterDao();

                // ------------------------ Invoice Master -------------------------
                // ------------------------ Invoice Master -------------------------
                // ------------------------ Invoice Master -------------------------
                // ------------------------ Invoice Master -------------------------
                String internalId;
                switch (document.getDocumentType()) {
                    case "D":
                    case "C":
                        internalId = document.getDocumentInternalIDSearch();
                        break;
                    default:
                        if (chkInvoInternalIdSeq.equals("true")) {
                            long InternalID_Start = Long.parseLong(document.getInternalID());
                            long internalId_long = dao.GetMaxInternalID(accUnitId, sectionId, deptId);
                            if (internalId_long <= InternalID_Start) {
                                internalId = "" + InternalID_Start;
                            } else {
                                internalId = String.valueOf(internalId_long);
                            }
                        } else {
                            internalId = document.getInternalID();
                        }
                }

                List<InvoInvoiceMaster> existInvoiceList
                        = new InvoInvoiceMasterDao().GetInvoInvoiceMasterByInternalIdInDeptAndSection(
                                internalId,//document.getInternalID(),
                                deptId,
                                sectionId,
                                accUnitId);
                if (search.equals("false")) {
                    if (document.getDocumentType().equals("I") && existInvoiceList.size() > 0) {
                        throw new Exception("existDocument");
                    }
                }

                InvoInvoiceMaster inv_master
                        = new InvoInvoiceMaster(
                                id,//InvoInvoiceMasterId
                                InvoAccUintDeptList.get(0),//unitDept
                                document.getReceiver().getType(),//receiverType
                                document.getDocumentType(),//documentType
                                new DateOp().String2Date(document.getDateTimeIssued(), "yyyy-MM-dd"),//issueDate
                                internalId,//document.getInternalID(),//InternalID 
                                "--" //statusTax
                        );
                inv_master.setInvoRealDate(new DateOp().String2Date(document.getInvoRealDate(), "yyyy-MM-dd"));

                if (!PurSupplierList.isEmpty()) {

                    PurSuppWork purSuppWork = PurSupplierList.get(0);
                    String building_number = purSuppWork.getBuildingNum() == null ? "-" : purSuppWork.getBuildingNum();
                    String Address = purSuppWork.getAddress() == null ? "-" : purSuppWork.getAddress();
                    String SuppName = purSuppWork.getSuppName() == null ? "-" : purSuppWork.getSuppName();

                    inv_master.setPurSuppWork(purSuppWork);
                    inv_master.setBuildingNum(building_number);
                    inv_master.setAddress(Address);
                    inv_master.setSuppName(SuppName);

                    //String id = (iim.getReceiverType() == "B") ? iim.get : "Segel";
                    String temp_id = "";
                    //System.out.println(iim.getReceiverType());
                    //System.out.println("B");
                    //System.out.println(iim.getReceiverType().equals("B"));
                    if (document.getReceiver().getType().equals("B")) {
                        String TaxCard = purSuppWork.getTaxCardNo() == null
                                ? "" : purSuppWork.getTaxCardNo().replaceAll("\\D+", "");
                        String TaxFileNo = purSuppWork.getTaxFileNo() == null
                                ? "" : purSuppWork.getTaxFileNo().replaceAll("\\D+", "");
                        if (TaxCard.length() == 9) {
                            temp_id = TaxCard;
                        } else if (TaxFileNo.length() == 9) {
                            temp_id = TaxFileNo;
                        } else {
                            temp_id = "";
                        }
                    } else if (document.getReceiver().getType().equals("P")) {
                        temp_id = purSuppWork.getIdentNo() == null
                                ? "" : purSuppWork.getIdentNo();
                    } else if (document.getReceiver().getType().equals("F")) {
                        /*temp_id = iim.getPurSuppWork().getIdentNo() == null
                            ? "" : iim.getPurSuppWork().getIdentNo();*/
                        temp_id = purSuppWork.getPassportNum();
                    }
                    String SuppInfoId = temp_id == null ? "" : temp_id.replaceAll("[/-]*", "");
                    inv_master.setSuppInfoId(SuppInfoId);

//                    PerCountryCode perCountryCode = (purSuppWork.getPerCountryCode() != null) ? purSuppWork.getPerCountryCode()
//                            : (purSuppWork.getPerGovernorateCode() == null) ? null : purSuppWork.getPerGovernorateCode().getPerCountryCode();
                    if (purSuppWork.getPerGovernorateCode() != null) {
                        inv_master.setPerCountryCode(purSuppWork.getPerGovernorateCode().getPerCountryCode());
                        inv_master.setPerGovernorateCode(purSuppWork.getPerGovernorateCode());
                    } else if (purSuppWork.getPerCountryCode() != null) {
                        inv_master.setPerCountryCode(purSuppWork.getPerCountryCode());
                    } else if (document.getReceiver().getType().equals("B")) {
                        PerCountryCode perCountryCode = new PerCountryCode();
                        perCountryCode.setCountryCode("1");
                        inv_master.setPerCountryCode(perCountryCode);
                    }

                } else {
                    inv_master.setSuppName(document.getReceiver().getName());
                }

                inv_master.setPerEmploymentMasterByEmployeeId(employee_session);

                //inv_master.setReviewSendDate(new DateOp().getSysDate());
                //inv_master.setSendDate(new DateOp().getSysDate());
                //inv_master.setIssueState("");
                //inv_master.setReviewDate(new DateOp().getSysDate());
                //inv_master.setFinalSendDate(new DateOp().getSysDate());
                inv_master.setCreatedDate(new DateOp().getSysDate());
                inv_master.setTotalAmount(BigDecimal.valueOf(document.getTotalAmount()));
                inv_master.setTotalDiscountAmount(BigDecimal.valueOf(document.getTotalDiscountAmount()));
                inv_master.setRmrk("");
                inv_master.setNetAmount(BigDecimal.valueOf(document.getNetAmount()));
                inv_master.setDateTimeIssued(document.getDateTimeIssued());
                inv_master.setExtraDiscountAmount(BigDecimal.valueOf(document.getExtraDiscountAmount()));

                //inv_master.setApprovedSendDate(new DateOp().getSysDate());
                inv_master.setTotalItemsDiscountAmount(BigDecimal.valueOf(document.getTotalItemsDiscountAmount()));
                inv_master.setTotalSalesAmount(BigDecimal.valueOf(document.getTotalSalesAmount()));

                inv_master.setUuid("");
                //inv_master.setIssueResType("");

                inv_master.setInvoDocumentStatus(invoDocumentStatusList.get(0));

                //inv_master.setApprovedDate(new DateOp().getSysDate());
                inv_master.setChkLock("");

                inv_master.setNotes(document.getNotes());

                List<PurContractServiceType> PurContractServiceTypeList = new PurContractServiceTypeDao<>().GetContractService("" + document.getServiceSeq());
                if (!PurContractServiceTypeList.isEmpty()) {
                    inv_master.setPurContractServiceType(PurContractServiceTypeList.get(0));
                    inv_master.setServiceCode(PurContractServiceTypeList.get(0).getServiceCode());
                }

                //if (!reciver_type.equals("P")) {
                if (document.getReceiver().getReceiverDetails() != null) {
                    List<PurSuppWorkDtl> purSuppWorkDtlList = new PurSuppWorkDtlDao<>().GetPurSupplierWorkDtlBySuppSeqBr("" + document.getReceiver().getReceiverDetails().get(0).getSuppSeqBr());
                    if (!purSuppWorkDtlList.isEmpty()) {
                        inv_master.setAddressBr(purSuppWorkDtlList.get(0).getAddressBr());
                        inv_master.setSuppNameBr(purSuppWorkDtlList.get(0).getSuppNameBr());
                        inv_master.setSuppMainFrameCodeBr(purSuppWorkDtlList.get(0).getSuppMainFrameCode());
                        inv_master.setPurSuppWorkDtl(purSuppWorkDtlList.get(0));
                    }
                }
                //}

                if (!document.getPermToDeliverCode().equals("")) {
                    inv_master.setPermToDeliverCode(document.getPermToDeliverCode());
                    inv_master.setPermToReceiveCode(document.getPermToReceiveCode());
                    if (document.getPermToReceiveDate() != null) {
                        inv_master.setPermToDeliverDate(new DateOp().String2Date(document.getPermToReceiveDate(), "yyyy-MM-dd"));
                    }
                    if (document.getPermToReceiveDate() != null) {
                        inv_master.setPermToReceiveDate(new DateOp().String2Date(document.getPermToReceiveDate(), "yyyy-MM-dd"));
                    }
                }
                /**
                 * جزء أضعار الخصم والأضافة وعمل الرابطة
                 * <<---------------------------------------------------------------
                 * ADD To Table INVO_INVOICE_MASTER
                 */
                if (search.equals("true")) {
                    String invSp = request.getParameter("invSp");
                    List<InvoInvoiceMaster> masterInvoiceList
                            = new InvoInvoiceMasterDao().GetInvoInvoiceMasterBySeq(invSp, deptId, sectionId, accUnitId);
                    if (masterInvoiceList.isEmpty()) {
                        throw new Exception();
                    }
                    inv_master.setInvoInvoiceMasterByInvoimsInvoimsFk(masterInvoiceList.get(0));
                    InvoInvoiceMaster mainInvoInvoiceMaster = masterInvoiceList.get(0);

                    //get document status
                    List<InvoDocumentStatus> invoDocumentStatusList1 = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus("17");// انشاء
                    if (invoDocumentStatusList1.isEmpty()) {
                        throw new Exception();
                    }
                    mainInvoInvoiceMaster.setInvoDocumentStatus(invoDocumentStatusList1.get(0));

                    dao.update(mainInvoInvoiceMaster);

                    // --------------------- Invoice Master Status ---------------------
                    // --------------------- Invoice Master Status ---------------------
                    // --------------------- Invoice Master Status ---------------------
                    // --------------------- Invoice Master Status ---------------------
                    short logSeq = new InvoInvoiceMasterStatusDAO().GetMaxLogSeq(accUnitId, deptId, sectionId, "" + mainInvoInvoiceMaster.getId().getInvoSp());
                    InvoInvoiceMasterStatusId id_MasterStatus = new InvoInvoiceMasterStatusId(Integer.parseInt(sectionId), Long.parseLong(deptId), mainInvoInvoiceMaster.getId().getInvoSp(), accUnitId, logSeq);
                    InvoInvoiceMasterStatus invoInvoiceMasterStatus = new InvoInvoiceMasterStatus(id_MasterStatus, mainInvoInvoiceMaster);
                    invoInvoiceMasterStatus.setPerEmploymentMaster(employee_session);
                    invoInvoiceMasterStatus.setInvoDocumentStatus(invoDocumentStatusList1.get(0));
                    invoInvoiceMasterStatus.setCurrDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));

                    //ip -----------> user Ip
                    String host = request.getHeader("host"); // -- Server Host IP and PORT
                    String Client_IP = request.getRemoteAddr();// -- Client IP
                    invoInvoiceMasterStatus.setDeskId(Client_IP);

                    invoInvoiceMasterStatus.setRmrk("");
                    invoInvoiceMasterStatus.setCurrDate(new DateOp().getSysDate());
                    /**
                     * add Data To Invoice Master Status
                     * <<---------------------------------------------------------------
                     * ADD To Table INVO_INVOICE_MASTER_STATUS
                     */
                    dao.save(invoInvoiceMasterStatus);

                    inv_master.setUuidReference(mainInvoInvoiceMaster.getUuid());
                }
                /**
                 * add Data To Invoice Master
                 * <<---------------------------------------------------------------
                 * ADD To Table INVO_INVOICE_MASTER
                 */
                {
                    dao.save(inv_master);
                }

                // --------------------- Invoice Master Status ---------------------
                // --------------------- Invoice Master Status ---------------------
                // --------------------- Invoice Master Status ---------------------
                // --------------------- Invoice Master Status ---------------------
                short logSeq = new InvoInvoiceMasterStatusDAO().GetMaxLogSeq(accUnitId, deptId, sectionId, "" + invoSpMax);
                InvoInvoiceMasterStatusId id_MasterStatus = new InvoInvoiceMasterStatusId(Integer.parseInt(sectionId), Long.parseLong(deptId), invoSpMax, accUnitId, logSeq);
                InvoInvoiceMasterStatus invoInvoiceMasterStatus = new InvoInvoiceMasterStatus(id_MasterStatus, inv_master);
                invoInvoiceMasterStatus.setPerEmploymentMaster(employee_session);
                invoInvoiceMasterStatus.setInvoDocumentStatus(invoDocumentStatusList.get(0));
                invoInvoiceMasterStatus.setCurrDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));

                //ip -----------> user Ip
                String host = request.getHeader("host"); // -- Server Host IP and PORT
                String Client_IP = request.getRemoteAddr();// -- Client IP
                invoInvoiceMasterStatus.setDeskId(Client_IP);

                invoInvoiceMasterStatus.setRmrk("");
                invoInvoiceMasterStatus.setCurrDate(new DateOp().getSysDate());
                /**
                 * add Data To Invoice Master Status
                 * <<---------------------------------------------------------------
                 * ADD To Table INVO_INVOICE_MASTER_STATUS
                 */
                dao.save(invoInvoiceMasterStatus);

                // ---------------------- Invoice Master Items ---------------------
                // ---------------------- Invoice Master Items ---------------------
                // ---------------------- Invoice Master Items ---------------------
                // ---------------------- Invoice Master Items ---------------------
                for (_200_Submit_Documents_008_invoiceLine invoiceLine : document.getInvoiceLines()) {
                    int invoSpItem = new InvoInvoiceMasterItemDAO().GetMaxInvoSpItem(accUnitId, deptId, sectionId, "" + invoSpMax);
                    InvoInvoiceMasterItemId id_ = new InvoInvoiceMasterItemId(accUnitId, invoSpMax, Integer.parseInt(sectionId), Long.parseLong(deptId), invoSpItem);
                    String currencyCode = invoiceLine.getUnitValue().getCurrencySold();//"" + new InvoiceDocumentConstants().currency.get(invoiceLine.getUnitValue().getCurrencySold());

                    List<AccCurrencyCode> AccCurrencyCodeList = new AccCurrencyCodeDAO().GetAccCurrencyCodeByCode(currencyCode);
                    if (AccCurrencyCodeList.isEmpty()) {
                        throw new Exception();
                    }

                    List<InvoItemCode> InvoItemCodeList = new InvoItemCodeDAO().GetInvItemCodeByItemCode(invoiceLine.getItemCode());
                    if (InvoItemCodeList.isEmpty()) {
                        throw new Exception();
                    }

                    List<InvoUnitType> InvUnitTypeList = new InvoUnitTypeDAO().GetInvoUnitTypeByUnitTypeCode(invoiceLine.getUnitType());
                    if (InvUnitTypeList.isEmpty()) {
                        throw new Exception();
                    }

                    List<InvoDeptItemJoinDescDtl> invoItemCodeDescList = new InvoDeptItemJoinDescDtlDAO().GetInvoItemCodeDescByItemSeqAndItemCode(invoiceLine.getItemSeq(), invoiceLine.getItemCode());

                    //System.out.println(" >>>>>>>>>>>>>>>>>>>> ||||||||||| ?>>>>> " + invoiceLine.getUnitValue().getCurrencySold());
                    List<AccCurrencyCode> accCurrencyCodeList = new AccCurrencyCodeDAO().GetAccCurrencyCodeByCode(invoiceLine.getUnitValue().getCurrencySold());
                    if (accCurrencyCodeList.isEmpty()) {
                        throw new Exception();
                    }

                    InvoInvoiceMasterItem invMasterItems
                            = new InvoInvoiceMasterItem();

                    invMasterItems.setId(id_);
                    invMasterItems.setInvoItemCode(InvoItemCodeList.get(0));
                    invMasterItems.setInvoUnitType(InvUnitTypeList.get(0));
                    invMasterItems.setInvoInvoiceMaster(inv_master);
                    invMasterItems.setItemDescription(invoiceLine.getDescription());
                    invMasterItems.setDiscountAmount(BigDecimal.valueOf(invoiceLine.getDiscount().getAmount()));
                    invMasterItems.setQuantity(BigDecimal.valueOf(invoiceLine.getQuantity()));
                    invMasterItems.setTotal(BigDecimal.valueOf(invoiceLine.getTotal()));
                    invMasterItems.setCurrencyExchangeRate(BigDecimal.valueOf(invoiceLine.getUnitValue().getCurrencyExchangeRate()));
                    invMasterItems.setAmountSold(BigDecimal.valueOf(invoiceLine.getUnitValue().getAmountSold()));
                    invMasterItems.setNetTotal(BigDecimal.valueOf(invoiceLine.getNetTotal()));
                    invMasterItems.setSalesTotal(BigDecimal.valueOf(invoiceLine.getSalesTotal()));

                    if (!invoItemCodeDescList.isEmpty()) {
                        invMasterItems.setInvoDeptItemJoinDescDtl(invoItemCodeDescList.get(0));
                    }

                    invMasterItems.setAccCurrencyCode(accCurrencyCodeList.get(0));
                    invMasterItems.setItemsDiscount(BigDecimal.valueOf(invoiceLine.getItemsDiscount()));
                    invMasterItems.setTotalTaxableFees(BigDecimal.valueOf(invoiceLine.getTotalTaxableFees()));
                    invMasterItems.setAmountEgp(BigDecimal.valueOf(invoiceLine.getUnitValue().getAmountEGP()));
                    invMasterItems.setDiscountRate(BigDecimal.valueOf(invoiceLine.getDiscount().getRate()));
                    invMasterItems.setValueDifference(BigDecimal.valueOf(invoiceLine.getValueDifference()));

                    if (invoiceLine.getCalcUnit() == 0) {
                        invMasterItems.setCalcUnit(null);
                        invMasterItems.setPriceBeforeCalcUnit(null);
                        invMasterItems.setMinimumLimit(null);
                    } else {
                        invMasterItems.setCalcUnit(BigDecimal.valueOf(invoiceLine.getCalcUnit()));
                        invMasterItems.setPriceBeforeCalcUnit(BigDecimal.valueOf(invoiceLine.getPriceBeforeCalcUnit()));
                        invMasterItems.setMinimumLimit(BigDecimal.valueOf(0));
                    }

                    /**
                     * add Data To Invoice Master Items
                     * <<-----------------------------------------------------------
                     * ADD To Table INVO_INVOICE_MASTER_ITEM
                     */
                    dao.save(invMasterItems);

                    // ------------------ Invoice Master Items Tax -----------------
                    // ------------------ Invoice Master Items Tax -----------------
                    // ------------------ Invoice Master Items Tax -----------------
                    // ------------------ Invoice Master Items Tax -----------------
                    for (_200_Submit_Documents_012_taxableItem taxableItem : invoiceLine.getTaxableItems()) {

                        InvoInvoiceMasterTaxId _id_ = new InvoInvoiceMasterTaxId(accUnitId, Integer.parseInt(sectionId), Long.parseLong(deptId), invoSpItem, invoSpMax, taxableItem.getSubType(), taxableItem.getTaxType());
                        List<InvoTaxTypeDtl> InvoTaxTypeDtlList = new InvoTaxTypeDtlDAO().GetInvTaxSubtypeById(taxableItem.getTaxType(), taxableItem.getSubType());
                        if (InvoTaxTypeDtlList.isEmpty()) {
                            throw new Exception();
                        }

                        InvoInvoiceMasterTax tax
                                = new InvoInvoiceMasterTax(
                                        _id_,//InvoInvoiceMasterTaxId                                    
                                        InvoTaxTypeDtlList.get(0),//InvoTaxTypeDtl
                                        invMasterItems,//InvoInvoiceMasterItem
                                        BigDecimal.valueOf(taxableItem.getAmount())//amount
                                );
                        tax.setRate(BigDecimal.valueOf(taxableItem.getRate()));
                        /**
                         * add Data To Invoice Master Items Tax
                         * <<-----------------------------------------------------------
                         * ADD To Table INVO_INVOICE_MASTER_TAX
                         */
                        dao.save(tax);
                    }
                }
                new HibernateSessionCon().CommitTrans();
            }
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
            String message = e.getMessage();
            if (message.equals("existDocument")) {
                message = "الرقم الداخلي للفاتورة مسجل من قبل";
            } else {
                message = "JError";
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

    /**
     * function used to round all numbers to two decimal numbers
     *
     * @param num
     * @return
     */
    private invoiceCalculation invoice_calculation = new invoiceCalculation();
    private InvoInvoiceMaster inv_master_relation = new InvoInvoiceMaster();

    private boolean seperateDocument(String accUnitId, _200_Submit_Documents_001_document document, String deptId, String sectionId, PerEmploymentMaster employee_session, String Client_IP, String chkInvoInternalIdSeq) {

        try {
            String reciver_type = document.getReceiver().getType();
            double Total_Amount = document.getTotalAmount();
            /*
            // max_val_before_tax : المبلغ للفاتورة الواخدة قبل تطبيق الضريبة ----> مثال : ---> tax = 0.14 | total = 50,000 | price befor = 50,000/(1+tax)
            // no_of_50000LE_documents : عدد الفواتير اللي هتبقى ب خمسين الف ----> Total_Amount / 50,000
            // reminder_of_TotalAmount_after_applying_tax : المبلغ المتبقي بعد عمل الفواتير الخمسينات عشان نعمل الفاتورة الأخيرة ----> Total_Amount - (50,000 * no_of_50000LE_documents)
            // reminder_of_TotalAmount_before_applying_tax : المبلغ قبل الضريبة للفاتروة الأخيرة ---> reminder_of_TotalAmount_after_applying_tax / ( 1 + tax )
             */
            double tax = 0;
            List<_200_Submit_Documents_012_taxableItem> oneTaxList = document.getInvoiceLines().get(0).getTaxableItems();
            if (oneTaxList.isEmpty()) {
                tax = 0;
            } else {
                tax = new MathOp().round3Points(oneTaxList.get(0).getRate() / 100);
            }

            double max_val_before_tax = new MathOp().round3Points(49000.0 / (1.0 + tax)); //-----><--------------------------------- قبل الضريبة لكل فاتورة
            int no_of_50000LE_documents = (int) (Total_Amount / 49000.0);    //-----><--------------------------------- بعد الضريبة لكل فاتورة
            double taxt_rate = tax * 100;                                    //-----><--------------------------------- نسبة الضريبة  / مثال 14%
            double tax_amount = new MathOp().round3Points(max_val_before_tax * tax);      //-----><--------------------------------- قيمة الضريبة الزائدة
            double max_val_after_tax = new MathOp().round3Points(max_val_before_tax + tax_amount);

            // المبلغ المتبقى بعد الضريبة بعد عمل فواتير ال خمسين الف
            double reminder_of_TotalAmount_after_applying_tax_temp = new MathOp().round3Points(Total_Amount - (max_val_after_tax * no_of_50000LE_documents));

            new HibernateSessionCon().OpenCon();
            new HibernateSessionCon().beginTrans();

            InvoInvoiceMasterDao dao = new InvoInvoiceMasterDao();
            String internalId;
            if (chkInvoInternalIdSeq.equals("true")) {
                long InternalID_Start = Long.parseLong(document.getInternalID());
                long internalId_long = dao.GetMaxInternalID(accUnitId, sectionId, deptId);
                if (internalId_long <= InternalID_Start) {
                    internalId = "" + InternalID_Start;
                } else {
                    internalId = String.valueOf(internalId_long);
                }
            } else {
                internalId = document.getInternalID();
            }

            int i = 0;
            for (i = 0; i < no_of_50000LE_documents; i++) {
                addToDB(accUnitId, document, deptId, sectionId, employee_session, Client_IP, max_val_before_tax, internalId, i);
            }

            //المتبقي قبل الضريبة
            double reminder_of_TotalAmount_before_applying_tax = new MathOp().round3Points(reminder_of_TotalAmount_after_applying_tax_temp / (1.0 + tax));//-------s--><--- قبل الضريبة لاخر فاتورة
            double reminder_of_tax_amount = new MathOp().round3Points(reminder_of_TotalAmount_before_applying_tax * tax);//------------------------------------------><-- قيمة الضريبة الزائدة
            double reminder_of_TotalAmount_after_applying_tax = new MathOp().round3Points(reminder_of_TotalAmount_before_applying_tax + reminder_of_tax_amount);//---><--- بعد الضريبة الضريبة لاخر فاتورة

            if (reminder_of_TotalAmount_after_applying_tax_temp > 0) {

                addToDB(accUnitId, document, deptId, sectionId, employee_session, Client_IP, reminder_of_TotalAmount_before_applying_tax, internalId, i);
            }
            new HibernateSessionCon().CommitTrans();
            //double t = max_val_after_tax * no_of_50000LE_documents + reminder_of_TotalAmount_after_applying_tax;
            //System.out.println(" Total : " + t);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void addToDB(String accUnitId, _200_Submit_Documents_001_document document, String deptId, String sectionId, PerEmploymentMaster employee_session, String Client_IP,
            double max_val_before_tax, String internalId,
            int i
    ) throws Exception {
        _200_Submit_Documents_001_document doc_2 = new _200_Submit_Documents_001_document();
        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 15. invoiceLines -----------------------> can take many Lines or Rows
         * (LOOP)
         */
        List<_200_Submit_Documents_008_invoiceLine> invoiceLines = new ArrayList<>();

        // Line Num : 1 ------------------------------------------------------------->
        // A. unitValue
        String currencySold = document.getInvoiceLines().get(0).getUnitValue().getCurrencySold();
        double amountEGP;
        double amountSold;
        double currencyExchangeRate;

        amountSold = new MathOp().round3Points(document.getInvoiceLines().get(0).getUnitValue().getAmountSold());
        currencyExchangeRate = new MathOp().round3Points(document.getInvoiceLines().get(0).getUnitValue().getCurrencyExchangeRate());
        amountEGP = new MathOp().round3Points(max_val_before_tax); // هنا يوضع سعر الوحدة بالمصري

        _200_Submit_Documents_009_unitValue unitValue = new _200_Submit_Documents_009_unitValue(
                currencySold, //currencySold
                amountEGP,//amountEGP
                amountSold,//amountSold
                currencyExchangeRate);//currencyExchangeRate

        // B. discount
        double rate_discount = new MathOp().round3Points(0.00);//rate >> can set it to 0 in all cases
        double amount_discount = new MathOp().round3Points(0.00);//amount >> can set the discount value without rate calculation
        _200_Submit_Documents_010_discount discount = new _200_Submit_Documents_010_discount(
                rate_discount,//rate >> can set it to 0 in all cases
                amount_discount);//amount >> can set the discount value without rate calculation        

        // C. salesTotal calculation
        int quantity = 1;
        double salesTotal = new MathOp().round3Points(quantity * amountEGP);

        // D. netTotal calculation
        double netTotal = new MathOp().round3Points(salesTotal - amount_discount);

        // E. valueDifference
        double valueDifference = new MathOp().round3Points(0.00);

        // F. taxableItems -----------------------> can take many type of taxes (LOOP)
        List<_200_Submit_Documents_012_taxableItem> taxableItems = new ArrayList<>();

        ///// I. Tax-1
        if (document.getInvoiceLines().get(0).getTaxableItems().size() > 0) {
            double rate = new MathOp().round3Points(document.getInvoiceLines().get(0).getTaxableItems().get(0).getRate());
            _200_Submit_Documents_012_taxableItem taxableItem_1 = new _200_Submit_Documents_012_taxableItem(
                    document.getInvoiceLines().get(0).getTaxableItems().get(0).getTaxType(),//taxType
                    new MathOp().round3Points(netTotal * (rate / 100.00)),//amount
                    document.getInvoiceLines().get(0).getTaxableItems().get(0).getSubType(),//subType
                    rate);//rate
            taxableItems.add(taxableItem_1);
        }
        // G. totalTaxableFees calculation3
        double totalTaxableFees = new MathOp().round3Points(invoice_calculation.calcTotalTaxableFees(taxableItems));

        // H. itemsDiscount
        double itemsDiscount = new MathOp().round3Points(0.00); // قيمة توضع بعد حساب الضرايب ممكن نعمل خصم كمان فبنحط قيمة الخصم

        // I. total : حساب مجموع الصف الواحد
        double all_line_taxableItem = new MathOp().round3Points(invoice_calculation.calcTotalTaxableFees_for_total(taxableItems));
        double total = new MathOp().round3Points((netTotal + all_line_taxableItem) - itemsDiscount);//2969.89; // Equation = (netTotal+(T1_amount+T2_amount+T3_amount)) - itemsDiscount;

        // J. One Invoice Line         
        _200_Submit_Documents_008_invoiceLine inv_line = document.getInvoiceLines().get(0);
        _200_Submit_Documents_008_invoiceLine invoiceLine_1 = new _200_Submit_Documents_008_invoiceLine(
                inv_line.getDescription(), //description
                inv_line.getItemType(), //itemType
                inv_line.getItemCode(), //itemCode
                inv_line.getUnitType(), //unitType
                quantity, //quantity
                inv_line.getItemCode(), //internalCode
                unitValue, //unitValue
                salesTotal, //salesTotal
                discount, //discount
                netTotal, //netTotal
                valueDifference, //valueDifference
                taxableItems,//taxableItems
                totalTaxableFees,//totalTaxableFees
                itemsDiscount,//itemsDiscount
                total);//total
        invoiceLines.add(invoiceLine_1);
        //-----------> end Line Num : 1  --------------------------------------

        // add invoiceLines to the document
        doc_2.setInvoiceLines(invoiceLines);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 16. totalSalesAmount
         */
        double totalSalesAmount = new MathOp().round3Points(invoice_calculation.calcTotalSalesAmount(invoiceLines));
        doc_2.setTotalSalesAmount(totalSalesAmount);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 17. totalDiscountAmount
         */
        double totalDiscountAmount = new MathOp().round3Points(invoice_calculation.calcTotalDiscountAmount(invoiceLines));
        doc_2.setTotalDiscountAmount(totalDiscountAmount);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 18. totalDiscountAmount
         */
        double netAmount = new MathOp().round3Points(totalSalesAmount - totalDiscountAmount);
        doc_2.setNetAmount(netAmount);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 19. taxTotals
         */
        List<_200_Submit_Documents_014_taxTotal> taxTotals = invoice_calculation.calcTaxTotals(invoiceLines);
        doc_2.setTaxTotals(taxTotals);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 20. totalItemsDiscountAmount (??)
         */
        double totalItemsDiscountAmount = invoice_calculation.calcTotalItemDiscount(invoiceLines);
        doc_2.setTotalItemsDiscountAmount(totalItemsDiscountAmount);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 21. totalItemsDiscountAmount
         */
        double extraDiscountAmount = new MathOp().round3Points(0.00);
        doc_2.setExtraDiscountAmount(extraDiscountAmount);

        ///////////////////////////////////////////////////////////////////////////////////////
        /**
         * 22. totalAmount
         */
        double total_of_all_line = new MathOp().round3Points(invoice_calculation.getSumOfAll_Totals_InAllLines(invoiceLines));
        double totalAmount = new MathOp().round3Points(total_of_all_line - extraDiscountAmount);
        doc_2.setTotalAmount(totalAmount);

        List<InvoInvoiceMaster> existInvoiceList
                = new InvoInvoiceMasterDao().GetInvoInvoiceMasterByInternalIdInDeptAndSection(
                        internalId,//document.getInternalID(),
                        deptId,
                        sectionId,
                        accUnitId);
        if (document.getDocumentType().equals("I") && existInvoiceList.size() > 0) {
            throw new Exception("existDocument");
        }

        long invoSpMax = new InvoInvoiceMasterDao().GetMaxInvoSp(accUnitId, sectionId, deptId);
        InvoInvoiceMasterId id = new InvoInvoiceMasterId(Long.parseLong(deptId), accUnitId, Integer.parseInt(sectionId), invoSpMax);

        //get dept
        List<InvoAccUintDept> InvoAccUintDeptList = new InvoAccUintDeptDao<>().GetInvoAccUintInDeptAndUnit(accUnitId, sectionId, deptId);
        if (InvoAccUintDeptList.isEmpty()) {
            throw new Exception();
        }

        //get Supplier 
        List<PurSuppWork> PurSupplierList = new PurSuppWorkDao().GetPurSupplierById(document.getReceiver().getSuppSeq());
        /*if (PurSupplierList.isEmpty()) {
                throw new Exception();
            }*/

        //get document status
        List<InvoDocumentStatus> invoDocumentStatusList = new InvoDocumentStatusDAO<>().GetInvoDocumentStatusByDocStatus("1");// انشاء
        if (invoDocumentStatusList.isEmpty()) {
            throw new Exception();
        }

        InvoInvoiceMasterDao dao = new InvoInvoiceMasterDao();
        // ------------------------ Invoice Master -------------------------
        // ------------------------ Invoice Master -------------------------
        // ------------------------ Invoice Master -------------------------
        // ------------------------ Invoice Master -------------------------

        InvoInvoiceMaster inv_master
                = new InvoInvoiceMaster(
                        id,//InvoInvoiceMasterId
                        InvoAccUintDeptList.get(0),//unitDept                          
                        document.getReceiver().getType(),//receiverType
                        document.getDocumentType(),//documentType
                        new DateOp().String2Date(document.getDateTimeIssued(), "yyyy-MM-dd"),//issueDate
                        internalId + "-" + (i + 1),//document.getInternalID() + "-" + (i + 1),//InternalID
                        "--" //statusTax
                );

        inv_master.setInvoRealDate(new DateOp().String2Date(document.getInvoRealDate(), "yyyy-MM-dd"));
        if (!PurSupplierList.isEmpty()) {

            PurSuppWork purSuppWork = PurSupplierList.get(0);
            String building_number = purSuppWork.getBuildingNum() == null ? "-" : purSuppWork.getBuildingNum();
            String Address = purSuppWork.getAddress() == null ? "-" : purSuppWork.getAddress();
            String SuppName = purSuppWork.getSuppName() == null ? "-" : purSuppWork.getSuppName();

            inv_master.setPurSuppWork(purSuppWork);
            inv_master.setBuildingNum(building_number);
            inv_master.setAddress(Address);
            inv_master.setSuppName(SuppName);

            //String id = (iim.getReceiverType() == "B") ? iim.get : "Segel";
            String temp_id = "";
            //System.out.println(iim.getReceiverType());
            //System.out.println("B");
            //System.out.println(iim.getReceiverType().equals("B"));
            if (document.getReceiver().getType().equals("B")) {
                String TaxCard = purSuppWork.getTaxCardNo() == null
                        ? "" : purSuppWork.getTaxCardNo().replaceAll("\\D+", "");
                String TaxFileNo = purSuppWork.getTaxFileNo() == null
                        ? "" : purSuppWork.getTaxFileNo().replaceAll("\\D+", "");
                if (TaxCard.length() == 9) {
                    temp_id = TaxCard;
                } else if (TaxFileNo.length() == 9) {
                    temp_id = TaxFileNo;
                } else {
                    temp_id = "";
                }
            } else if (document.getReceiver().getType().equals("P")) {
                temp_id = purSuppWork.getIdentNo() == null
                        ? "" : purSuppWork.getIdentNo();
            } else if (document.getReceiver().getType().equals("F")) {
                /*temp_id = iim.getPurSuppWork().getIdentNo() == null
                            ? "" : iim.getPurSuppWork().getIdentNo();*/
                temp_id = purSuppWork.getPassportNum();
            }
            String SuppInfoId = temp_id == null ? "" : temp_id.replaceAll("[/-]*", "");
            inv_master.setSuppInfoId(SuppInfoId);

//            PerCountryCode perCountryCode = (purSuppWork.getPerCountryCode() != null) ? purSuppWork.getPerCountryCode()
//                    : (purSuppWork.getPerGovernorateCode() == null) ? null : purSuppWork.getPerGovernorateCode().getPerCountryCode();
            if (purSuppWork.getPerGovernorateCode() != null) {
                inv_master.setPerCountryCode(purSuppWork.getPerGovernorateCode().getPerCountryCode());
                inv_master.setPerGovernorateCode(purSuppWork.getPerGovernorateCode());
            } else if (purSuppWork.getPerCountryCode() != null) {
                inv_master.setPerCountryCode(purSuppWork.getPerCountryCode());
            } else if (document.getReceiver().getType().equals("B")) {
                PerCountryCode perCountryCode = new PerCountryCode();
                perCountryCode.setCountryCode("1");
                inv_master.setPerCountryCode(perCountryCode);
            }

            //inv_master.setPerCountryCode(perCountryCode);
            //inv_master.setPerGovernorateCode(purSuppWork.getPerGovernorateCode());
        } else {
            inv_master.setSuppName(document.getReceiver().getName());
        }

        inv_master.setPerEmploymentMasterByEmployeeId(employee_session);

        //inv_master.setReviewSendDate(new DateOp().getSysDate());
        //inv_master.setSendDate(new DateOp().getSysDate());
        //inv_master.setIssueState("");
        //inv_master.setReviewDate(new DateOp().getSysDate());
        //inv_master.setFinalSendDate(new DateOp().getSysDate());
        inv_master.setCreatedDate(new DateOp().getSysDate());
        inv_master.setTotalAmount(BigDecimal.valueOf(doc_2.getTotalAmount()));//-- Done
        inv_master.setTotalDiscountAmount(BigDecimal.valueOf(doc_2.getExtraDiscountAmount()));//--Done
        inv_master.setRmrk("");//--Done
        inv_master.setNetAmount(BigDecimal.valueOf(doc_2.getNetAmount()));//--Done
        inv_master.setDateTimeIssued(document.getDateTimeIssued());//--Done
        inv_master.setExtraDiscountAmount(BigDecimal.valueOf(doc_2.getExtraDiscountAmount()));//--Done

        //inv_master.setApprovedSendDate(new DateOp().getSysDate());
        inv_master.setTotalItemsDiscountAmount(BigDecimal.valueOf(doc_2.getTotalItemsDiscountAmount()));
        inv_master.setTotalSalesAmount(BigDecimal.valueOf(doc_2.getTotalSalesAmount()));

        inv_master.setUuid("");
        //inv_master.setIssueResType("");

        inv_master.setInvoDocumentStatus(invoDocumentStatusList.get(0));

        //inv_master.setApprovedDate(new DateOp().getSysDate());
        inv_master.setChkLock("");

        inv_master.setNotes(document.getNotes());

        List<PurContractServiceType> PurContractServiceTypeList = new PurContractServiceTypeDao<>().GetContractService("" + document.getServiceSeq());
        if (!PurContractServiceTypeList.isEmpty()) {
            inv_master.setPurContractServiceType(PurContractServiceTypeList.get(0));
            inv_master.setServiceCode(PurContractServiceTypeList.get(0).getServiceCode());
        }

        if (!document.getPermToDeliverCode().equals("")) {
            inv_master.setPermToDeliverCode(document.getPermToDeliverCode());
            inv_master.setPermToReceiveCode(document.getPermToReceiveCode());
            inv_master.setPermToDeliverDate(new DateOp().String2Date(document.getPermToReceiveDate(), "yyyy-MM-dd"));
            inv_master.setPermToReceiveDate(new DateOp().String2Date(document.getPermToReceiveDate(), "yyyy-MM-dd"));
        }

        /**
         * add Data To Invoice Master
         * <<--------------------------------------------------------------- ADD
         * To Table INVO_INVOICE_MASTER
         */
        if (i == 0) {
            inv_master_relation = inv_master;
        } else {
            inv_master.setInvoInvoiceMasterByInvoimsInvoimsSplitFk(inv_master_relation);
        }
        System.out.println("inv_master Insert");
        dao.insert(inv_master);
        System.out.println("inv_master Insert");

        if (i == 0) {
            // --------------------- Invoice Master Status ---------------------
            // --------------------- Invoice Master Status ---------------------
            // --------------------- Invoice Master Status ---------------------
            // --------------------- Invoice Master Status ---------------------
            short logSeq = new InvoInvoiceMasterStatusDAO().GetMaxLogSeq(accUnitId, deptId, sectionId, "" + invoSpMax);
            InvoInvoiceMasterStatusId id_MasterStatus = new InvoInvoiceMasterStatusId(Integer.parseInt(sectionId), Long.parseLong(deptId), invoSpMax, accUnitId, logSeq);
            InvoInvoiceMasterStatus invoInvoiceMasterStatus = new InvoInvoiceMasterStatus(id_MasterStatus, inv_master);
            invoInvoiceMasterStatus.setPerEmploymentMaster(employee_session);
            invoInvoiceMasterStatus.setInvoDocumentStatus(invoDocumentStatusList.get(0));
            invoInvoiceMasterStatus.setCurrDateTime(new DateOp().getCustomSysDate("yyyy-MM-dd HH:mm:ss"));

            //ip -----------> user Ip
            invoInvoiceMasterStatus.setDeskId(Client_IP);

            invoInvoiceMasterStatus.setRmrk("");
            invoInvoiceMasterStatus.setCurrDate(new DateOp().getSysDate());
            /**
             * add Data To Invoice Master Status
             * <<---------------------------------------------------------------
             * ADD To Table INVO_INVOICE_MASTER_STATUS
             */
            System.out.println("invoInvoiceMasterStatus Insert");
            dao.insert(invoInvoiceMasterStatus);
            System.out.println("invoInvoiceMasterStatus Insert");
        }

        // ---------------------- Invoice Master Items ---------------------
        // ---------------------- Invoice Master Items ---------------------
        // ---------------------- Invoice Master Items ---------------------
        // ---------------------- Invoice Master Items ---------------------
        for (_200_Submit_Documents_008_invoiceLine invoiceLine : doc_2.getInvoiceLines()) {

            int invoSpItem = new InvoInvoiceMasterItemDAO().GetMaxInvoSpItem(accUnitId, deptId, sectionId, "" + invoSpMax);
            InvoInvoiceMasterItemId id_ = new InvoInvoiceMasterItemId(accUnitId, invoSpMax, Integer.parseInt(sectionId), Long.parseLong(deptId), invoSpItem);
            String currencyCode = invoiceLine.getUnitValue().getCurrencySold();//"" + new InvoiceDocumentConstants().currency.get(invoiceLine.getUnitValue().getCurrencySold());

            List<AccCurrencyCode> AccCurrencyCodeList = new AccCurrencyCodeDAO().GetAccCurrencyCodeByCode(currencyCode);
            if (AccCurrencyCodeList.isEmpty()) {
                throw new Exception();
            }

            List<InvoItemCode> InvItemCodeList = new InvoItemCodeDAO().GetInvItemCodeByItemCode(invoiceLine.getItemCode());
            if (InvItemCodeList.isEmpty()) {
                throw new Exception();
            }

            List<InvoUnitType> InvUnitTypeList = new InvoUnitTypeDAO().GetInvoUnitTypeByUnitTypeCode(invoiceLine.getUnitType());
            if (InvUnitTypeList.isEmpty()) {
                throw new Exception();
            }

            List<InvoDeptItemJoinDescDtl> invoItemCodeDescList = new InvoDeptItemJoinDescDtlDAO().GetInvoItemCodeDescByItemSeqAndItemCode(invoiceLine.getItemSeq(), invoiceLine.getItemCode());

            List<AccCurrencyCode> accCurrencyCodeList = new AccCurrencyCodeDAO().GetAccCurrencyCodeByCode(invoiceLine.getUnitValue().getCurrencySold());
            if (accCurrencyCodeList.isEmpty()) {
                throw new Exception();
            }

            InvoInvoiceMasterItem invMasterItems
                    = new InvoInvoiceMasterItem();

            invMasterItems.setId(id_);
            invMasterItems.setInvoItemCode(InvItemCodeList.get(0));
            invMasterItems.setInvoUnitType(InvUnitTypeList.get(0));
            invMasterItems.setInvoInvoiceMaster(inv_master);
            invMasterItems.setItemDescription(invoiceLine.getDescription());
            invMasterItems.setDiscountAmount(BigDecimal.valueOf(invoiceLine.getDiscount().getAmount()));
            invMasterItems.setQuantity(BigDecimal.valueOf(invoiceLine.getQuantity()));
            invMasterItems.setTotal(BigDecimal.valueOf(invoiceLine.getTotal()));
            invMasterItems.setCurrencyExchangeRate(BigDecimal.valueOf(invoiceLine.getUnitValue().getCurrencyExchangeRate()));
            invMasterItems.setAmountSold(BigDecimal.valueOf(invoiceLine.getUnitValue().getAmountSold()));
            invMasterItems.setNetTotal(BigDecimal.valueOf(invoiceLine.getNetTotal()));
            invMasterItems.setSalesTotal(BigDecimal.valueOf(invoiceLine.getSalesTotal()));

            if (!invoItemCodeDescList.isEmpty()) {
                invMasterItems.setInvoDeptItemJoinDescDtl(invoItemCodeDescList.get(0));
            }

            invMasterItems.setAccCurrencyCode(accCurrencyCodeList.get(0));
            invMasterItems.setItemsDiscount(BigDecimal.valueOf(invoiceLine.getItemsDiscount()));
            invMasterItems.setTotalTaxableFees(BigDecimal.valueOf(invoiceLine.getTotalTaxableFees()));
            invMasterItems.setAmountEgp(BigDecimal.valueOf(invoiceLine.getUnitValue().getAmountEGP()));
            invMasterItems.setDiscountRate(BigDecimal.valueOf(invoiceLine.getDiscount().getRate()));
            invMasterItems.setValueDifference(BigDecimal.valueOf(invoiceLine.getValueDifference()));

            if (invoiceLine.getCalcUnit() == 0) {
                invMasterItems.setCalcUnit(null);
                invMasterItems.setPriceBeforeCalcUnit(null);
                invMasterItems.setMinimumLimit(null);
            } else {
                invMasterItems.setCalcUnit(BigDecimal.valueOf(invoiceLine.getCalcUnit()));
                invMasterItems.setPriceBeforeCalcUnit(BigDecimal.valueOf(invoiceLine.getPriceBeforeCalcUnit()));
                invMasterItems.setMinimumLimit(BigDecimal.valueOf(0));
            }

            /**
             * add Data To Invoice Master Items
             * <<----------------------------------------------------------- ADD
             * To Table INVO_INVOICE_MASTER_ITEM
             */
            System.out.println("invMasterItems Insert");
            dao.insert(invMasterItems);
            System.out.println("invMasterItems Insert");

            // ------------------ Invoice Master Items Tax -----------------
            // ------------------ Invoice Master Items Tax -----------------
            // ------------------ Invoice Master Items Tax -----------------
            // ------------------ Invoice Master Items Tax -----------------
            try {
                for (_200_Submit_Documents_012_taxableItem taxableItem : invoiceLine.getTaxableItems()) {

                    InvoInvoiceMasterTaxId _id_ = new InvoInvoiceMasterTaxId(accUnitId, Integer.parseInt(sectionId), Long.parseLong(deptId), invoSpItem, invoSpMax, taxableItem.getSubType(), taxableItem.getTaxType());
                    List<InvoTaxTypeDtl> InvoTaxTypeDtlList = new InvoTaxTypeDtlDAO().GetInvTaxSubtypeById(taxableItem.getTaxType(), taxableItem.getSubType());
                    if (InvoTaxTypeDtlList.isEmpty()) {
                        throw new Exception();
                    }

                    InvoInvoiceMasterTax tax_2
                            = new InvoInvoiceMasterTax(
                                    _id_,//InvoInvoiceMasterTaxId                                    
                                    InvoTaxTypeDtlList.get(0),//InvoTaxTypeDtl
                                    invMasterItems,//InvoInvoiceMasterItem
                                    BigDecimal.valueOf(taxableItem.getAmount())//amount
                            );
                    tax_2.setRate(BigDecimal.valueOf(taxableItem.getRate()));
                    /**
                     * add Data To Invoice Master Items Tax
                     * <<-----------------------------------------------------------
                     * ADD To Table INVO_INVOICE_MASTER_TAX
                     */
                    System.out.println("Tax Insert");
                    dao.insert(tax_2);
                    System.out.println("/Tax Insert");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception();
            }
        }
    }

}
