/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import com.alahram.constants.InvoiceDocumentConstants;
import com.codeator.www._0_0_CodeatorLib.MathOp;
import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_2_DB_entities.InvoDeptTaxJoin;
import com.codeator.www._1_2_DB_entities.InvoDeptUnitJoin;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMaster;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterItem;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterStatus;
import com.codeator.www._1_2_DB_entities.InvoInvoiceMasterTax;
import com.codeator.www._1_2_DB_entities.PurSuppWorkDtl;
import com.codeator.www._1_3_DB_daos.InvoDeptTaxJoinDAO;
import com.codeator.www._1_3_DB_daos.InvoDeptUnitJoinDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterDao;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterItemDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterStatusDAO;
import com.codeator.www._1_3_DB_daos.InvoInvoiceMasterTaxDAO;
import com.codeator.www._1_3_DB_daos.PurSuppWorkDtlDao;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_003_receiver;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_004_address;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_008_invoiceLine;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_009_unitValue;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_010_discount;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_012_taxableItem;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._201_receiverDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Moham
 */
public class _1_0_0_0_2_Electronic_Invoice_Query_Ajax_0_getAllInvoice_Class {

    private boolean searchByInternalID = false; //السماح بالبحص بالكود الداخلي للمستند
    private boolean useLikeQuery = false;// استخدام Like % %
    private String internalID = "";
    private boolean allowSplit = true;// السماح بظهور الفواتير المقسمة
    private boolean last_document_of_same_internalID = false;// الحصول على اخر فاتورة لاشعاري الهصم والاضافة

    private boolean usePeriod = false;
    private String fromDate = "";
    private String toDate = "";
    private String createdDate_OR_issueDate = "";

    private boolean showAllSperatedDocument = false;// السماح بظهور الفواتير المقسمة

    private InvoInvoiceMasterStatusDAO dao = new InvoInvoiceMasterStatusDAO();

    public void setShowAllSperatedDocument(boolean showAllSperatedDocument) {
        this.showAllSperatedDocument = showAllSperatedDocument;
    }

    public synchronized _200_Submit_Documents_001_document[] getMultiInvoices(String deptId, String sectionId, String accUnitCode, List<String> documentStatus, String searchType) throws Exception {

        boolean result_founded = false;
        /**
         * validation part
         */
        if (searchByInternalID && internalID.equals("")) {
            throw new Exception("No Passed internalID Value");
        }

        /**
         * ///validation part
         */
        List<InvoInvoiceMaster> iimList = null;
        if (searchByInternalID && result_founded == false) {
            if (last_document_of_same_internalID && result_founded == false) {
                iimList = new InvoInvoiceMasterDao().GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusByInternalIdLastOne1(
                        deptId,
                        sectionId,
                        accUnitCode,
                        documentStatus,
                        internalID,
                        useLikeQuery, searchType);////// باستخدام كود كامل و اخر فاتورة
                result_founded = true;
            } else {
                iimList = new InvoInvoiceMasterDao().GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusByInternalId(
                        deptId,
                        sectionId,
                        accUnitCode,
                        documentStatus,
                        internalID,
                        useLikeQuery);////// باستخدام كود كامل
                result_founded = true;
            }
        }

        if (showAllSperatedDocument && result_founded == false) {
            iimList = new InvoInvoiceMasterDao().GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusWithSperatedDoc(
                    deptId,
                    sectionId,
                    accUnitCode,
                    documentStatus);
            result_founded = true;
        }

        if (usePeriod && result_founded == false) {
            iimList = new InvoInvoiceMasterDao().GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusWithoutSperatedDoc(
                    deptId,
                    sectionId,
                    accUnitCode,
                    documentStatus, toDate, fromDate, createdDate_OR_issueDate);
            result_founded = true;
        }

        if (result_founded == false) {
            iimList = new InvoInvoiceMasterDao().GetAllInvInvoiceMasterByDeptAndSectionAndDocumentStatusWithoutSperatedDoc(
                    deptId,
                    sectionId,
                    accUnitCode,
                    documentStatus);
            result_founded = true;
        }

        return generalInvoice_Data_collection(deptId, sectionId, accUnitCode, iimList);
    }

    public synchronized _200_Submit_Documents_001_document[] getInvoicesMainDtl(String deptId, String sectionId, String accUnitCode, String inv_sp) throws Exception {
        List<InvoInvoiceMaster> iimList = null;
        iimList = new InvoInvoiceMasterDao().GetInvoInvoiceMasterDtlFromMain(inv_sp, deptId, sectionId, accUnitCode);
        return generalInvoice_Data_collection(deptId, sectionId, accUnitCode, iimList);
    }

    public synchronized _200_Submit_Documents_001_document[] getOneInvoices(String deptId, String sectionId, String accUnitCode, String invSp) throws Exception {
        List<InvoInvoiceMaster> iimList
                = new InvoInvoiceMasterDao().GetInvoInvoiceMasterBySeq(
                        invSp,
                        deptId,
                        sectionId,
                        accUnitCode);

        return generalInvoice_Data_collection(deptId, sectionId, accUnitCode, iimList);

    }

    public _200_Submit_Documents_001_document[] generalInvoice_Data_collection(String deptId, String sectionId, String accUnitCode, List<InvoInvoiceMaster> iimList) throws Exception {

        _200_Submit_Documents_001_document[] _200_Submit_Documents_001_document_arr = new _200_Submit_Documents_001_document[iimList.size()];

        int i = 0;
        for (InvoInvoiceMaster iim : iimList) {
            if (iim.getInvoInvoiceMastersForInvoimsInvoimsSplitFk().isEmpty() || showAllSperatedDocument) {
                //فواتير عادي وليست مقسمة
                _200_Submit_Documents_001_document _200_Submit_Documents_001_document2 = new _200_Submit_Documents_001_document();

                //List<InvoInvoiceMasterStatus> pList = new InvoInvoiceMasterStatusDAO<>().documentsReviewed(iim.getId().getAccUnitCode(), "" + iim.getId().getDepNoOld(), "" + iim.getId().getSectionNoOld(), "" + iim.getId().getInvoSp());
                /*if (pList.isEmpty()) {// No Review
                    _200_Submit_Documents_001_document2.setDeleteStatus("true");
                } else {//Founded Review
                    _200_Submit_Documents_001_document2.setDeleteStatus("false");
                }*/
                _200_Submit_Documents_001_document2.setDeleteStatus("true");

                _200_Submit_Documents_001_document2.setUpdateStatus("true");
                _200_Submit_Documents_001_document2.setDocumentDividedStatus("NotDivided");

                _200_Submit_Documents_001_document2.setStatus("" + iim.getInvoDocumentStatus().getDocStatus());
                _200_Submit_Documents_001_document2.setStatusDescription("" + iim.getInvoDocumentStatus().getDocStatusName());

                _200_Submit_Documents_001_document2.setDeptOld(deptId);
                _200_Submit_Documents_001_document2.setSectionOld(sectionId);
                _200_Submit_Documents_001_document2.setAccUnitId(accUnitCode);
                _200_Submit_Documents_001_document2.setAccAcountUnitCode(/*iim.getInvoAccUintDept().getPerDeptOld().getPerSectionOld().getSectionName() + "/" + iim.getInvoAccUintDept().getPerDeptOld().getDepName() + "/" + */iim.getInvoAccUintDept().getInvoAccUnitsCode().getAccUnitName());
                _200_Submit_Documents_001_document2.setNewAccAcountUnitCode(iim.getInvoAccUintDept().getPerDeptOld().getDepName());
                _200_Submit_Documents_001_document2.setInvSp("" + iim.getId().getInvoSp());
                _200_Submit_Documents_001_document2.setRmrk(iim.getRmrk());
                _200_Submit_Documents_001_document2.setUuid(iim.getUuid());
                _200_Submit_Documents_001_document2.setTel(iim.getInvoAccUintDept().getUnitTel());
                _200_Submit_Documents_001_document2.setFax(iim.getInvoAccUintDept().getUnitFax());

                _200_Submit_Documents_001_document2.setChkPaied(iim.getChkPaid());
                //String id = (iim.getReceiverType() == "B") ? iim.get : "Segel";
                String temp_id = iim.getSuppInfoId();
                //System.out.println(iim.getReceiverType());
                //System.out.println("B");
                //System.out.println(iim.getReceiverType().equals("B"));
                /*if (iim.getReceiverType().equals("B")) {
                    String TaxCard = iim.getSuppInfoId()== null;
                    if (TaxCard.length() == 9) {
                        temp_id = TaxCard;
                    } else if (TaxFileNo.length() == 9) {
                        temp_id = TaxFileNo;
                    } else {
                        temp_id = "";
                    }
                } else if (iim.getReceiverType().equals("P")) {
                    temp_id = iim.getPurSuppWork().getIdentNo() == null
                            ? "" : iim.getPurSuppWork().getIdentNo();
                }else if (document.getReceiver().getType().equals("F")) {
                    temp_id = iim.getPurSuppWork().getIdentNo() == null
                            ? "" : iim.getPurSuppWork().getIdentNo();
                }*/
                //String id = temp_id == null ? "" : temp_id.replaceAll("[/-]*", "");
                String id = temp_id;

                String CountrySynbol = (iim.getPerCountryCode() == null) ? ""
                        : iim.getPerCountryCode().getCountrySymbol();
                String buildingNumber = (iim.getBuildingNum() == null) ? "-" : iim.getBuildingNum();
                String governate = (iim.getPerGovernorateCode() == null)
                        ? "-" : iim.getPerGovernorateCode().getAGovName();
                String street = (iim.getAddress() == null) ? "-" : iim.getAddress();
                String regionCity = governate;//// لازم نجيب السيتي
                _200_Submit_Documents_004_address receiver_address = new _200_Submit_Documents_004_address(
                        CountrySynbol, //country // دايما هتكون مصر
                        governate, //governate
                        regionCity, //regionCity
                        street, //street
                        buildingNumber, //buildingNumber
                        "-", //postalCode
                        "-", //floor
                        "-", //room
                        "-", //landmark 
                        "-"
                );     //additionalInformation
                receiver_address.setCountryCode((iim.getPerCountryCode() == null && !iim.getReceiverType().equals("F")) ? "مصر" : iim.getPerCountryCode().getACountryName());
                String SuppName = (iim.getPurSuppWork() == null) ? (iim.getSuppName() == null ? "" : iim.getSuppName()) : iim.getPurSuppWork().getSuppName();
                //SuppName = (SuppName.equals("") && iim.getSuppName() != null) ? iim.getSuppName() : "";
                _200_Submit_Documents_003_receiver receiver = new _200_Submit_Documents_003_receiver(
                        receiver_address, iim.getReceiverType(),
                        id,
                        SuppName);

                List<_201_receiverDetails> receiverDetails = new ArrayList<>();
                if (iim.getPurSuppWork() != null) {
                    receiver.setSuppSeq("" + iim.getPurSuppWork().getSuppSeq());

                    if (iim.getPurSuppWorkDtl() != null) {
                        _201_receiverDetails dtl
                                = new _201_receiverDetails(
                                        iim.getPurSuppWorkDtl().getSuppSeqBr(),
                                        iim.getAddressBr(),
                                        iim.getSuppNameBr(),
                                        iim.getPurSuppWorkDtl().getSuppMainFrameCode());
                        receiverDetails.add(dtl);
                        SuppName = iim.getSuppNameBr() + ((iim.getSuppMainFrameCodeBr() == null) ? "" : " - " + iim.getSuppMainFrameCodeBr());
                    }
                }
                receiver.setName(SuppName);
                receiver.setReceiverDetails(receiverDetails);

                _200_Submit_Documents_001_document2.setReceiver(receiver);
                _200_Submit_Documents_001_document2.setDocumentType("" + iim.getDocumentType());
                _200_Submit_Documents_001_document2.setDateTimeIssued(iim.getDateTimeIssued());
                _200_Submit_Documents_001_document2.setInvoRealDate((iim.getInvoRealDate() == null) ? iim.getDateTimeIssued() : new DateOp().Date2String(iim.getInvoRealDate(), "yyyy-MM-dd"));
                _200_Submit_Documents_001_document2.setDateTimeCreated(new DateOp().Date2String(iim.getCreatedDate(), "yyyy-MM-dd"));
                _200_Submit_Documents_001_document2.setInternalID("" + iim.getInvoAccUintDept().getId().getAccUnitCode() + "/" + iim.getInvoAccUintDept().getId().getSectionNoOld() + iim.getInvoAccUintDept().getId().getDepNoOld() + "/" + iim.getServiceCode() + "/" + iim.getInternalId());

                _200_Submit_Documents_001_document2.setPaidFormCode(iim.getPaidFormCode());

                _200_Submit_Documents_001_document2.setPermToDeliverCode(iim.getPermToDeliverCode());
                _200_Submit_Documents_001_document2.setPermToReceiveCode(iim.getPermToReceiveCode());
                if (iim.getPermToReceiveDate() != null) {
                    _200_Submit_Documents_001_document2.setPermToReceiveDate(new DateOp().Date2String(iim.getPermToReceiveDate(), "yyyy-MM-dd"));
                }

                if (iim.getPermToDeliverDate() != null) {
                    _200_Submit_Documents_001_document2.setPermToReceiveDate(new DateOp().Date2String(iim.getPermToDeliverDate(), "yyyy-MM-dd"));
                }

                String ServiceSeq = "";
                String ServiceName = "";
                if (iim.getPurContractServiceType() == null) {
                    ServiceSeq = "";
                    ServiceName = "";
                } else {
                    ServiceSeq = "" + iim.getPurContractServiceType().getServiceSeq();
                    ServiceName = "" + iim.getPurContractServiceType().getServiceName();
                }
                _200_Submit_Documents_001_document2.setServiceSeq(ServiceSeq);
                _200_Submit_Documents_001_document2.setNotes(iim.getNotes());
                _200_Submit_Documents_001_document2.setServiceName(ServiceName);
                // الصفوف
                List<_200_Submit_Documents_008_invoiceLine> invoiceLines = new ArrayList<>();

                ////////////////////////هات الصفوف من الداتا بيز////////////////////
                List<InvoInvoiceMasterItem> iimiList
                        = new InvoInvoiceMasterItemDAO()
                                .GetInvInvoiceMasterItemByinvoSpAndDeptAndSection(
                                        "" + iim.getId().getInvoSp(),
                                        accUnitCode,
                                        deptId,
                                        sectionId);

                for (InvoInvoiceMasterItem iimi : iimiList) {

                    _200_Submit_Documents_008_invoiceLine invoiceLine
                            = new _200_Submit_Documents_008_invoiceLine();
                    invoiceLine.setLineNumber("" + iimi.getId().getInvoSpItem());
                    invoiceLine.setItemSeq("" + iimi.getId().getInvoSpItem());
                    invoiceLine.setDescription(iimi.getItemDescription());
                    invoiceLine.setItemType(iimi.getInvoItemCode().getCodeType());
                    invoiceLine.setItemCode(iimi.getInvoItemCode().getItemCode());
                    invoiceLine.setUnitType(iimi.getInvoUnitType().getUnitType());
                    invoiceLine.setQuantity(iimi.getQuantity().doubleValue());

                    String internalCode
                            = (iimi.getInvoDeptItemJoinDescDtl() == null) ? ""
                            : (iimi.getInvoDeptItemJoinDescDtl().getItemBarcode() == null)
                            ? "" + iimi.getInvoDeptItemJoinDescDtl().getItemSeq()
                            : iimi.getInvoDeptItemJoinDescDtl().getItemBarcode();

                    invoiceLine.setInternalCode(internalCode);

                    // العملة للصف
                    String currencySold = "";
                    for (Map.Entry<String, Integer> en : new InvoiceDocumentConstants().currency.entrySet()) {
                        String key = en.getKey();
                        String value = "" + en.getValue();
                        if (iimi.getAccCurrencyCode().getCurrencyCode().equals(value)) {
                            currencySold = key;
                            break;
                        }
                    }

                    // سعر العملة بالمصر والأجنبي ان وجدت
                    _200_Submit_Documents_009_unitValue unitValue
                            = new _200_Submit_Documents_009_unitValue(
                                    currencySold,//currencySold
                                    iimi.getAmountEgp().doubleValue(),//amountEGP
                                    iimi.getAmountSold().doubleValue(),//amountSold
                                    iimi.getCurrencyExchangeRate().doubleValue());//currencyExchangeRate

                    invoiceLine.setUnitValue(unitValue);

                    invoiceLine.setSalesTotal(iimi.getSalesTotal().doubleValue());

                    // الخصم
                    _200_Submit_Documents_010_discount discount
                            = new _200_Submit_Documents_010_discount(
                                    iimi.getDiscountRate().doubleValue(), //discountRate
                                    iimi.getDiscountAmount().doubleValue());//discountAmount
                    invoiceLine.setDiscount(discount);

                    invoiceLine.setNetTotal(iimi.getNetTotal().doubleValue());
                    invoiceLine.setValueDifference(iimi.getValueDifference().doubleValue());

                    // تفاصيل التفاصيل اللي هي الضرايب ع الصف الواحد
                    List< _200_Submit_Documents_012_taxableItem> taxableItems = new ArrayList<>();
                    // هات الضرايب اللي ع الصف الواحد
                    List<InvoInvoiceMasterTax> iimitList
                            = new InvoInvoiceMasterTaxDAO().GetInvoInvoiceMasterTaxByinvoSpAndSectionAndDept(
                                    "" + iimi.getId().getInvoSp(),
                                    accUnitCode,
                                    deptId,
                                    sectionId,
                                    "" + iimi.getId().getInvoSpItem());
                    // لف ع الضرايب اللي فالصف الواحد
                    for (InvoInvoiceMasterTax iimit : iimitList) {

                        List<InvoDeptTaxJoin> InvUnitTypeList = new InvoDeptTaxJoinDAO<>().GetTaxInDeptByTaxSubType(iimit.getId().getTaxType(), iimit.getId().getTaxSubtype(), accUnitCode, sectionId, deptId);
                        if (InvUnitTypeList.isEmpty()) {
                            throw new Exception();
                        }
                        InvoDeptTaxJoin invoDeptTaxJoin = InvUnitTypeList.get(0);
                        _200_Submit_Documents_012_taxableItem taxableItem
                                = new _200_Submit_Documents_012_taxableItem(
                                        iimit.getId().getTaxType(), //taxType
                                        iimit.getAmount().doubleValue(), //amount
                                        iimit.getId().getTaxSubtype(), //subType
                                        iimit.getRate().doubleValue(), //rate
                                        "" + iimit.getId().getInvoSpItem(), //taxLineNumber 
                                        iimit.getInvoTaxTypeDtl().getInvoTaxType().getATaxName(), //taxTypeName
                                        invoDeptTaxJoin.getTaxNickname()/*iimit.getInvoTaxTypeDtl().getATaxSubname()*/);//subTypeName
                        taxableItems.add(taxableItem);
                    }

                    invoiceLine.setTaxableItems(taxableItems);
                    invoiceLine.setTotalTaxableFees(iimi.getTotalTaxableFees().doubleValue());
                    invoiceLine.setItemsDiscount(iimi.getItemsDiscount().doubleValue());
                    invoiceLine.setTotal(iimi.getTotal().doubleValue());

                    //For AMAC
                    if (iimi.getCalcUnit() == null) {
                        invoiceLine.setCalcUnit(0);
                        invoiceLine.setPriceBeforeCalcUnit(0);
                        invoiceLine.setMinimumLimit(0);
                    } else {
                        invoiceLine.setCalcUnit((iimi.getCalcUnit() == null ? 0 : iimi.getCalcUnit().doubleValue()));
                        invoiceLine.setPriceBeforeCalcUnit((iimi.getPriceBeforeCalcUnit() == null ? 0 : iimi.getPriceBeforeCalcUnit().doubleValue()));
                        invoiceLine.setMinimumLimit((iimi.getMinimumLimit() == null ? 0 : iimi.getMinimumLimit().doubleValue()));
                    }
                    // _200_Submit_Documents_001_document2.setInvoiceLines(invoiceLines);
                    invoiceLines.add(invoiceLine);
                }
                _200_Submit_Documents_001_document2.setInvoiceLines(invoiceLines);

                _200_Submit_Documents_001_document2.setTotalSalesAmount(iim.getTotalSalesAmount().doubleValue());
                _200_Submit_Documents_001_document2.setTotalDiscountAmount(iim.getTotalDiscountAmount().doubleValue());
                _200_Submit_Documents_001_document2.setNetAmount(iim.getNetAmount().doubleValue());

                _200_Submit_Documents_001_document2.setTotalItemsDiscountAmount(iim.getTotalItemsDiscountAmount().doubleValue());
                _200_Submit_Documents_001_document2.setExtraDiscountAmount(iim.getExtraDiscountAmount().doubleValue());
                _200_Submit_Documents_001_document2.setTotalAmount(iim.getTotalAmount().doubleValue());

                /**
                 * Get Last Document Status in Log File
                 */
                _200_Submit_Documents_001_document2.setInternalID("" + iim.getInvoAccUintDept().getId().getAccUnitCode() + "/" + iim.getInvoAccUintDept().getId().getSectionNoOld() + iim.getInvoAccUintDept().getId().getDepNoOld() + "/" + iim.getServiceCode() + "/" + iim.getInternalId());

                String deptId_temp = "" + iim.getId().getDepNoOld();
                String sectionId_temp = "" + iim.getId().getSectionNoOld();
                String accUnitId_temp = "" + iim.getId().getAccUnitCode();
                String invoSp_temp = "" + iim.getId().getInvoSp();

                List<InvoInvoiceMasterStatus> lastLogList = dao.documentsLastLog(accUnitId_temp, deptId_temp, sectionId_temp, invoSp_temp);
                InvoInvoiceMasterStatus invoiceLastVerifyLog = lastLogList.get(0);

                _200_Submit_Documents_001_document2.setStatusRmrk(invoiceLastVerifyLog.getRmrk());

                _200_Submit_Documents_001_document_arr[i] = _200_Submit_Documents_001_document2;
                i++;

                //System.out.println(i);
            } else if (allowSplit) {
                //فواتير مقسمة
                _200_Submit_Documents_001_document _200_Submit_Documents_001_document2 = new _200_Submit_Documents_001_document();

                List<InvoInvoiceMasterStatus> pList = new InvoInvoiceMasterStatusDAO<>().documentsReviewed(iim.getId().getAccUnitCode(), "" + iim.getId().getDepNoOld(), "" + iim.getId().getSectionNoOld(), "" + iim.getId().getInvoSp());
                /*if (pList.isEmpty()) {// No Review
                    _200_Submit_Documents_001_document2.setDeleteStatus("true");
                } else {//Founded Review
                    _200_Submit_Documents_001_document2.setDeleteStatus("false");
                }*/
                _200_Submit_Documents_001_document2.setDeleteStatus("true");

                _200_Submit_Documents_001_document2.setUpdateStatus("false");
                _200_Submit_Documents_001_document2.setDocumentDividedStatus("Divided");

                _200_Submit_Documents_001_document2.setStatus("" + iim.getInvoDocumentStatus().getDocStatus());
                _200_Submit_Documents_001_document2.setStatusDescription("" + iim.getInvoDocumentStatus().getDocStatusName());

                _200_Submit_Documents_001_document2.setDeptOld(deptId);
                _200_Submit_Documents_001_document2.setSectionOld(sectionId);
                _200_Submit_Documents_001_document2.setAccUnitId(accUnitCode);
                _200_Submit_Documents_001_document2.setAccAcountUnitCode(/*iim.getInvoAccUintDept().getPerDeptOld().getPerSectionOld().getSectionName() + "/" + iim.getInvoAccUintDept().getPerDeptOld().getDepName() + "/" + */iim.getInvoAccUintDept().getInvoAccUnitsCode().getAccUnitName());
                _200_Submit_Documents_001_document2.setNewAccAcountUnitCode(iim.getInvoAccUintDept().getPerDeptOld().getDepName());
                _200_Submit_Documents_001_document2.setInvSp("" + iim.getId().getInvoSp());
                _200_Submit_Documents_001_document2.setRmrk(iim.getRmrk());
                _200_Submit_Documents_001_document2.setUuid(iim.getUuid());

                _200_Submit_Documents_001_document2.setChkPaied(iim.getChkPaid());

                String ServiceSeq = "";
                String ServiceName = "";
                if (iim.getPurContractServiceType() == null) {
                    ServiceSeq = "";
                    ServiceName = "";
                } else {
                    ServiceSeq = "" + iim.getPurContractServiceType().getServiceSeq();
                    ServiceName = "" + iim.getPurContractServiceType().getServiceName();
                }
                _200_Submit_Documents_001_document2.setServiceSeq(ServiceSeq);
                _200_Submit_Documents_001_document2.setNotes(iim.getNotes());
                _200_Submit_Documents_001_document2.setServiceName(ServiceName);

                //String id = (iim.getReceiverType() == "B") ? iim.get : "Segel";
                String temp_id = iim.getSuppInfoId();
                //System.out.println(iim.getReceiverType());
                //System.out.println("B");
                //System.out.println(iim.getReceiverType().equals("B"));
                /*if (iim.getReceiverType().equals("B")) {
                    String TaxCard = iim.getSuppInfoId()== null;
                    if (TaxCard.length() == 9) {
                        temp_id = TaxCard;
                    } else if (TaxFileNo.length() == 9) {
                        temp_id = TaxFileNo;
                    } else {
                        temp_id = "";
                    }
                } else if (iim.getReceiverType().equals("P")) {
                    temp_id = iim.getPurSuppWork().getIdentNo() == null
                            ? "" : iim.getPurSuppWork().getIdentNo();
                }else if (document.getReceiver().getType().equals("F")) {
                    temp_id = iim.getPurSuppWork().getIdentNo() == null
                            ? "" : iim.getPurSuppWork().getIdentNo();
                }*/
                //String id = temp_id == null ? "" : temp_id.replaceAll("[/-]*", "");
                String id = temp_id;

                String CountrySynbol = (iim.getPerCountryCode() == null) ? ""
                        : iim.getPerCountryCode().getCountrySymbol();
                String buildingNumber = (iim.getBuildingNum() == null) ? "-" : iim.getBuildingNum();
                String governate = (iim.getPerGovernorateCode() == null)
                        ? "-" : iim.getPerGovernorateCode().getAGovName();
                String street = (iim.getAddress() == null) ? "-" : iim.getAddress();
                String regionCity = governate;//// لازم نجيب السيتي

                _200_Submit_Documents_004_address receiver_address = new _200_Submit_Documents_004_address(
                        CountrySynbol, //country // دايما هتكون مصر
                        governate, //governate
                        regionCity, //regionCity
                        street, //street
                        buildingNumber, //buildingNumber
                        "-", //postalCode
                        "-", //floor
                        "-", //room
                        "-", //landmark 
                        "-"
                );     //additionalInformation
                receiver_address.setCountryCode((iim.getPerCountryCode() == null && !iim.getReceiverType().equals("F")) ? "مصر" : iim.getPerCountryCode().getACountryName());
                String SuppName = (iim.getPurSuppWork() == null) ? (iim.getSuppName() == null ? "" : iim.getSuppName()) : iim.getPurSuppWork().getSuppName();
                //SuppName = (SuppName.equals("") && iim.getSuppName() != null) ? iim.getSuppName() : "";
                _200_Submit_Documents_003_receiver receiver = new _200_Submit_Documents_003_receiver(
                        receiver_address, iim.getReceiverType(),
                        id,
                        SuppName);

                List<_201_receiverDetails> receiverDetails = new ArrayList<>();
                if (iim.getPurSuppWork() != null) {
                    receiver.setSuppSeq("" + iim.getPurSuppWork().getSuppSeq());

                    if (iim.getPurSuppWorkDtl() != null) {
                        _201_receiverDetails dtl
                                = new _201_receiverDetails(
                                        iim.getPurSuppWorkDtl().getSuppSeqBr(),
                                        iim.getAddressBr(),
                                        iim.getSuppNameBr(),
                                        iim.getPurSuppWorkDtl().getSuppMainFrameCode());

                        receiverDetails.add(dtl);
                        SuppName = iim.getSuppNameBr() + ((iim.getSuppMainFrameCodeBr() == null) ? "" : " - " + iim.getSuppMainFrameCodeBr());

                    }

                }
                receiver.setReceiverDetails(receiverDetails);

                int number_of_invoices = iim.getInvoInvoiceMastersForInvoimsInvoimsSplitFk().size();
                _200_Submit_Documents_001_document2.setReceiver(receiver);
                _200_Submit_Documents_001_document2.setDocumentType("" + iim.getDocumentType());
                _200_Submit_Documents_001_document2.setDateTimeIssued(iim.getDateTimeIssued());
                _200_Submit_Documents_001_document2.setInvoRealDate((iim.getInvoRealDate() == null) ? iim.getDateTimeIssued() : new DateOp().Date2String(iim.getInvoRealDate(), "yyyy-MM-dd"));
                _200_Submit_Documents_001_document2.setDateTimeCreated(new DateOp().Date2String(iim.getCreatedDate(), "yyyy-MM-dd"));

                String internalID = "" + iim.getInvoAccUintDept().getId().getAccUnitCode() + "/" + iim.getInvoAccUintDept().getId().getSectionNoOld() + iim.getInvoAccUintDept().getId().getDepNoOld() + "/" + iim.getServiceCode() + "/" + iim.getInternalId();

                String actual_internalID = internalID.subSequence(0, internalID.length() - 2).toString();
                _200_Submit_Documents_001_document2.setInternalID(actual_internalID);
                _200_Submit_Documents_001_document2.setStartDocSerial("1");
                _200_Submit_Documents_001_document2.setEndDocSerial("" + (number_of_invoices + 1));

                _200_Submit_Documents_001_document2.setPaidFormCode(iim.getPaidFormCode());

                _200_Submit_Documents_001_document2.setPermToDeliverCode(iim.getPermToDeliverCode());
                _200_Submit_Documents_001_document2.setPermToReceiveCode(iim.getPermToReceiveCode());
                if (iim.getPermToReceiveDate() != null) {
                    _200_Submit_Documents_001_document2.setPermToReceiveDate(new DateOp().Date2String(iim.getPermToReceiveDate(), "yyyy-MM-dd"));
                }

                if (iim.getPermToDeliverDate() != null) {
                    _200_Submit_Documents_001_document2.setPermToReceiveDate(new DateOp().Date2String(iim.getPermToDeliverDate(), "yyyy-MM-dd"));
                }

                List<_200_Submit_Documents_008_invoiceLine> invoiceLines = new ArrayList<>();

                ////////////////////////هات الفواتير من الداتا بيز////////////////////
                List<InvoInvoiceMasterItem> iimiList
                        = new InvoInvoiceMasterItemDAO()
                                .GetInvInvoiceMasterItemByinvoSpAndDeptAndSection(
                                        "" + iim.getId().getInvoSp(),
                                        accUnitCode,
                                        deptId,
                                        sectionId);

                double TotalSalesAmount = 0;//iim.getTotalSalesAmount().doubleValue();
                double TotalDiscountAmount = 0;// iim.getTotalDiscountAmount().doubleValue();
                double NetAmount = 0;//iim.getNetAmount().doubleValue();
                double TotalItemsDiscountAmount = 0;//iim.getTotalItemsDiscountAmount().doubleValue();
                double ExtraDiscountAmount = 0;//iim.getExtraDiscountAmount().doubleValue();
                double TotalAmount = 0;//iim.getTotalAmount().doubleValue();

                //------ invoice 
                _200_Submit_Documents_008_invoiceLine invoiceLine
                        = new _200_Submit_Documents_008_invoiceLine();
                invoiceLine.setLineNumber("" + iimiList.get(0).getId().getInvoSpItem());
                invoiceLine.setItemSeq("" + iimiList.get(0).getId().getInvoSpItem());
                invoiceLine.setDescription(iimiList.get(0).getItemDescription());
                invoiceLine.setItemType(iimiList.get(0).getInvoItemCode().getCodeType());
                invoiceLine.setItemCode(iimiList.get(0).getInvoItemCode().getItemCode());
                invoiceLine.setUnitType(iimiList.get(0).getInvoUnitType().getUnitType());

                invoiceLine.setQuantity(iimiList.get(0).getQuantity().doubleValue());
                String internalCode
                        = (iimiList.get(0).getInvoDeptItemJoinDescDtl() == null) ? ""
                        : (iimiList.get(0).getInvoDeptItemJoinDescDtl().getItemBarcode() == null)
                        ? "" + iimiList.get(0).getInvoDeptItemJoinDescDtl().getItemSeq()
                        : iimiList.get(0).getInvoDeptItemJoinDescDtl().getItemBarcode();

                invoiceLine.setInternalCode(internalCode);

                double amountEGP = 0;
                double amountSold = 0;
                double currencyExchangeRate = 0;
                double salesTotal = 0;
                double discountRate = 0;
                double discountAmount = 0;
                double netTotal = 0;
                double valueDifference = 0;
                double totalTaxableFees = 0;
                double itemsDiscount = 0;
                double total = 0;

                //taxes vals
                String taxType = "";
                double amount = 0;
                String subType = "";
                double rate = 0;
                String taxLineNumber = "";
                String taxTypeName = "";
                String subTypeName = "";

                List< _200_Submit_Documents_012_taxableItem> taxableItems = new ArrayList<>();

                //--- الفاتورة الأولى الأساسية
                //--- الفاتورة الأولى الأساسية
                //--- الفاتورة الأولى الأساسية
                //--- الفاتورة الأولى الأساسية
                //--- الفاتورة الأولى الأساسية
                TotalSalesAmount += new MathOp().round3Points(iim.getTotalSalesAmount().doubleValue());
                TotalDiscountAmount += new MathOp().round3Points(iim.getTotalDiscountAmount().doubleValue());
                NetAmount += new MathOp().round3Points(iim.getNetAmount().doubleValue());
                TotalItemsDiscountAmount += new MathOp().round3Points(iim.getTotalItemsDiscountAmount().doubleValue());
                ExtraDiscountAmount += new MathOp().round3Points(iim.getExtraDiscountAmount().doubleValue());
                TotalAmount += new MathOp().round3Points(iim.getTotalAmount().doubleValue());
                for (InvoInvoiceMasterItem iimi : iim.getInvoInvoiceMasterItems()) {
                    amountEGP = new MathOp().round3Points(iimi.getAmountEgp().doubleValue());
                    amountSold += new MathOp().round3Points(iimi.getAmountSold().doubleValue());
                    currencyExchangeRate = iimi.getCurrencyExchangeRate().doubleValue();//-- Const

                    salesTotal += new MathOp().round3Points(iimi.getSalesTotal().doubleValue());

                    discountRate = new MathOp().round3Points(iimi.getDiscountRate().doubleValue());//-- Const = 0

                    discountAmount += new MathOp().round3Points(iimi.getDiscountAmount().doubleValue());

                    netTotal += new MathOp().round3Points(iimi.getNetTotal().doubleValue());
                    valueDifference = iimi.getValueDifference().doubleValue();//-- Const = 0

                    totalTaxableFees += new MathOp().round3Points(iimi.getTotalTaxableFees().doubleValue());
                    itemsDiscount += new MathOp().round3Points(iimi.getItemsDiscount().doubleValue());
                    total += new MathOp().round3Points(iimi.getTotal().doubleValue());
                    /// tax dtl
                    // هات الضرايب اللي ع الصف الواحد
                    List<InvoInvoiceMasterTax> iimitList
                            = new InvoInvoiceMasterTaxDAO().GetInvoInvoiceMasterTaxByinvoSpAndSectionAndDept(
                                    "" + iimi.getId().getInvoSp(),
                                    accUnitCode,
                                    deptId,
                                    sectionId,
                                    "" + iimi.getId().getInvoSpItem());
                    // لف ع الضرايب اللي فالصف الواحد

                    for (InvoInvoiceMasterTax iimit : iimitList) {
                        List<InvoDeptTaxJoin> InvUnitTypeList = new InvoDeptTaxJoinDAO<>().GetTaxInDeptByTaxSubType(iimit.getId().getTaxType(), iimit.getId().getTaxSubtype(), accUnitCode, sectionId, deptId);
                        if (InvUnitTypeList.isEmpty()) {
                            throw new Exception();
                        }
                        InvoDeptTaxJoin invoDeptTaxJoin = InvUnitTypeList.get(0);

                        taxType = iimit.getId().getTaxType();//-- Const
                        amount += new MathOp().round3Points(iimit.getAmount().doubleValue());
                        subType = iimit.getId().getTaxSubtype();// -- Const
                        rate = iimit.getRate().doubleValue(); // -- Const
                        taxLineNumber = "" + iimit.getId().getInvoSpItem();// -- Const
                        taxTypeName = iimit.getInvoTaxTypeDtl().getInvoTaxType().getATaxName();// -- Const
                        subTypeName = invoDeptTaxJoin.getTaxNickname()/*iimit.getInvoTaxTypeDtl().getATaxSubname()*/;// -- Const                           
                    }
                    // end tax dtl
                }

                //--- الفواتير التابعة لأول فاتورة أساسية
                //--- الفواتير التابعة لأول فاتورة أساسية
                //--- الفواتير التابعة لأول فاتورة أساسية
                //--- الفواتير التابعة لأول فاتورة أساسية
                //--- الفواتير التابعة لأول فاتورة أساسية
                //--- الفواتير التابعة لأول فاتورة أساسية
                for (InvoInvoiceMaster invoInvoiceMaster_related : iim.getInvoInvoiceMastersForInvoimsInvoimsSplitFk()) {

                    TotalSalesAmount += new MathOp().round3Points(invoInvoiceMaster_related.getTotalSalesAmount().doubleValue());
                    TotalDiscountAmount += new MathOp().round3Points(invoInvoiceMaster_related.getTotalDiscountAmount().doubleValue());
                    NetAmount += new MathOp().round3Points(invoInvoiceMaster_related.getNetAmount().doubleValue());
                    TotalItemsDiscountAmount += new MathOp().round3Points(invoInvoiceMaster_related.getTotalItemsDiscountAmount().doubleValue());
                    ExtraDiscountAmount += new MathOp().round3Points(invoInvoiceMaster_related.getExtraDiscountAmount().doubleValue());
                    TotalAmount += new MathOp().round3Points(invoInvoiceMaster_related.getTotalAmount().doubleValue());

                    for (InvoInvoiceMasterItem iimi : invoInvoiceMaster_related.getInvoInvoiceMasterItems()) {
                        amountEGP += new MathOp().round3Points(iimi.getAmountEgp().doubleValue());
                        amountSold += new MathOp().round3Points(iimi.getAmountSold().doubleValue());
                        currencyExchangeRate = iimi.getCurrencyExchangeRate().doubleValue();//-- Const

                        salesTotal += new MathOp().round3Points(iimi.getSalesTotal().doubleValue());

                        discountRate = new MathOp().round3Points(iimi.getDiscountRate().doubleValue());//-- Const = 0

                        discountAmount += new MathOp().round3Points(iimi.getDiscountAmount().doubleValue());

                        netTotal += new MathOp().round3Points(iimi.getNetTotal().doubleValue());
                        valueDifference = iimi.getValueDifference().doubleValue();//-- Const = 0

                        totalTaxableFees += new MathOp().round3Points(iimi.getTotalTaxableFees().doubleValue());
                        itemsDiscount += new MathOp().round3Points(iimi.getItemsDiscount().doubleValue());
                        total += new MathOp().round3Points(iimi.getTotal().doubleValue());
                        /// tax dtl
                        // هات الضرايب اللي ع الصف الواحد
                        List<InvoInvoiceMasterTax> iimitList
                                = new InvoInvoiceMasterTaxDAO().GetInvoInvoiceMasterTaxByinvoSpAndSectionAndDept(
                                        "" + iimi.getId().getInvoSp(),
                                        accUnitCode,
                                        deptId,
                                        sectionId,
                                        "" + iimi.getId().getInvoSpItem());
                        // لف ع الضرايب اللي فالصف الواحد
                        for (InvoInvoiceMasterTax iimit : iimitList) {
                            List<InvoDeptTaxJoin> InvUnitTypeList = new InvoDeptTaxJoinDAO<>().GetTaxInDeptByTaxSubType(iimit.getId().getTaxType(), iimit.getId().getTaxSubtype(), accUnitCode, sectionId, deptId);
                            if (InvUnitTypeList.isEmpty()) {
                                throw new Exception();
                            }
                            InvoDeptTaxJoin invoDeptTaxJoin = InvUnitTypeList.get(0);
                            taxType = iimit.getId().getTaxType();//-- Const
                            amount += new MathOp().round3Points(iimit.getAmount().doubleValue());
                            subType = iimit.getId().getTaxSubtype();// -- Const
                            rate = iimit.getRate().doubleValue(); // -- Const
                            taxLineNumber = "" + iimit.getId().getInvoSpItem();// -- Const
                            taxTypeName = iimit.getInvoTaxTypeDtl().getInvoTaxType().getATaxName();// -- Const
                            subTypeName = invoDeptTaxJoin.getTaxNickname() /*iimit.getInvoTaxTypeDtl().getATaxSubname()*/;// -- Const                           
                        }
                        // end tax dtl
                    }
                }

                String currencySold = "";
                for (Map.Entry<String, Integer> en : new InvoiceDocumentConstants().currency.entrySet()) {
                    String key = en.getKey();
                    String value = "" + en.getValue();
                    if (iimiList.get(0).getAccCurrencyCode().getCurrencyCode().equals(value)) {
                        currencySold = key;
                        break;
                    }
                }

                double acutal_netTotal = new MathOp().round3Points(total) / (1 + new MathOp().round3Points(rate / 100.0));
                _200_Submit_Documents_009_unitValue unitValue
                        = new _200_Submit_Documents_009_unitValue(
                                currencySold,//currencySold
                                new MathOp().round3Points(acutal_netTotal)/*new MathOp().round3Points(amountEGP)*/,//amountEGP
                                new MathOp().round3Points(amountSold),//amountSold
                                currencyExchangeRate);//currencyExchangeRate

                // العملة للصف
                invoiceLine.setUnitValue(unitValue);

                invoiceLine.setSalesTotal(new MathOp().round3Points(acutal_netTotal)/*new MathOp().round3Points(salesTotal)*/);

                // الخصم
                _200_Submit_Documents_010_discount discount
                        = new _200_Submit_Documents_010_discount(
                                discountRate, //discountRate
                                new MathOp().round3Points(discountAmount));//discountAmount
                invoiceLine.setDiscount(discount);

                invoiceLine.setNetTotal(new MathOp().round3Points(acutal_netTotal)/*new MathOp().round3Points(netTotal)*/);

                invoiceLine.setValueDifference(valueDifference);

                invoiceLine.setTotalTaxableFees(new MathOp().round3Points(totalTaxableFees));
                invoiceLine.setItemsDiscount(new MathOp().round3Points(itemsDiscount));
                invoiceLine.setTotal(new MathOp().round3Points(total));//

                double acutal_tax_amount = new MathOp().round3Points(acutal_netTotal) * (new MathOp().round3Points(rate / 100.0));
                _200_Submit_Documents_012_taxableItem taxableItem
                        = new _200_Submit_Documents_012_taxableItem(
                                taxType, //taxType
                                new MathOp().round3Points(acutal_tax_amount)/*new MathOp().round3Points(amount)*/, //amount
                                subType, //subType
                                rate, //rate
                                taxLineNumber, //taxLineNumber 
                                taxTypeName, //taxTypeName
                                subTypeName);//subTypeName
                taxableItems.add(taxableItem);
                invoiceLine.setTaxableItems(taxableItems);

                //For AMAC
                if (iimiList.get(0).getCalcUnit() == null) {
                    invoiceLine.setCalcUnit(0);
                    invoiceLine.setPriceBeforeCalcUnit(0);
                    invoiceLine.setMinimumLimit(0);
                } else {
                    invoiceLine.setCalcUnit((iimiList.get(0).getCalcUnit() == null ? 0 : iimiList.get(0).getCalcUnit().doubleValue()));
                    invoiceLine.setPriceBeforeCalcUnit((iimiList.get(0).getPriceBeforeCalcUnit() == null ? 0 : iimiList.get(0).getPriceBeforeCalcUnit().doubleValue()));
                    invoiceLine.setMinimumLimit((iimiList.get(0).getMinimumLimit() == null ? 0 : iimiList.get(0).getMinimumLimit().doubleValue()));
                }

                // _200_Submit_Documents_001_document2.setInvoiceLines(invoiceLines);
                invoiceLines.add(invoiceLine);

                _200_Submit_Documents_001_document2.setInvoiceLines(invoiceLines);
                _200_Submit_Documents_001_document2.setTotalSalesAmount(TotalSalesAmount);
                _200_Submit_Documents_001_document2.setTotalDiscountAmount(TotalDiscountAmount);
                _200_Submit_Documents_001_document2.setNetAmount(NetAmount);

                _200_Submit_Documents_001_document2.setTotalItemsDiscountAmount(TotalItemsDiscountAmount);
                _200_Submit_Documents_001_document2.setExtraDiscountAmount(ExtraDiscountAmount);
                _200_Submit_Documents_001_document2.setTotalAmount(TotalAmount);

                /**
                 * Get Last Document Status in Log File
                 */
                _200_Submit_Documents_001_document2.setInternalID("" + iim.getInvoAccUintDept().getId().getAccUnitCode() + "/" + iim.getInvoAccUintDept().getId().getSectionNoOld() + iim.getInvoAccUintDept().getId().getDepNoOld() + "/" + iim.getServiceCode() + "/" + iim.getInternalId());

                String deptId_temp = "" + iim.getId().getDepNoOld();
                String sectionId_temp = "" + iim.getId().getSectionNoOld();
                String accUnitId_temp = "" + iim.getId().getAccUnitCode();
                String invoSp_temp = "" + iim.getId().getInvoSp();

                List<InvoInvoiceMasterStatus> lastLogList = dao.documentsLastLog(accUnitId_temp, deptId_temp, sectionId_temp, invoSp_temp);
                InvoInvoiceMasterStatus invoiceLastVerifyLog = lastLogList.get(0);

                _200_Submit_Documents_001_document2.setStatusRmrk(invoiceLastVerifyLog.getRmrk());

                _200_Submit_Documents_001_document_arr[i] = _200_Submit_Documents_001_document2;
                i++;
            }
        }
        return _200_Submit_Documents_001_document_arr;
    }

    public void setSearchByInternalID(boolean searchByInternalID) {
        this.searchByInternalID = searchByInternalID;
    }

    public void setUseLikeQuery(boolean useLikeQuery) {
        this.useLikeQuery = useLikeQuery;
    }

    public void setInternalID(String internalID) {
        this.internalID = internalID;
    }

    public void setAllowSplit(boolean allowSplit) {
        this.allowSplit = allowSplit;
    }

    public void setLast_document_of_same_internalID(boolean last_document_of_same_internalID) {
        this.last_document_of_same_internalID = last_document_of_same_internalID;
    }

    public boolean isUsePeriod() {
        return usePeriod;
    }

    public void setUsePeriod(boolean usePeriod) {
        this.usePeriod = usePeriod;
    }

    public InvoInvoiceMasterStatusDAO getDao() {
        return dao;
    }

    public void setDao(InvoInvoiceMasterStatusDAO dao) {
        this.dao = dao;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getCreatedDate_OR_issueDate() {
        return createdDate_OR_issueDate;
    }

    public void setCreatedDate_OR_issueDate(String createdDate_OR_issueDate) {
        this.createdDate_OR_issueDate = createdDate_OR_issueDate;
    }

}
