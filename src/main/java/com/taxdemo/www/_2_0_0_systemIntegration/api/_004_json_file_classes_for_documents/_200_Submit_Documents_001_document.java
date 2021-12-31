/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_001_document implements Serializable {

    private String deptOld;
    private String sectionOld;
    private String accUnitId;
    private String accAcountUnitCode;
    private String newAccAcountUnitCode;
    private String invSp;
    private String rmrk;
    private String status;
    private String statusDescription;
    private String deleteStatus;//مش للضرايب
    private String updateStatus;//مش للضرايب

    private String allowUnVerify;//مش للضرايب
    private String employeeNameWhoLastVerify;//مش للضرايب
    private String employeeNoWhoLastVerify;//مش للضرايب

    private String uuid;//مش للضرايب

    private String documentDividedStatus;//مش للضرايب
    private String startDocSerial;//مش للضرايب
    private String endDocSerial;//مش للضرايب
    private String chkPaied;//مش للضرايب
    private String tel;//مش للضرايب
    private String fax;//مش للضرايب

    private String paidFormCode;//مش للضرايب
    
    private String permToReceiveCode;//مش للضرايب
    private String permToDeliverCode;//مش للضرايب
    private String permToReceiveDate;//مش للضرايب
    private String permToDeliverDate;//مش للضرايب
    
   
    private String statusRmrk; // مش للضرايب

    private String notes;
    private String serviceSeq;
    private String serviceName;

    private _200_Submit_Documents_002_issuer issuer;
    private _200_Submit_Documents_003_receiver receiver;

    private String documentType;            // I : Invoice , C : Creditor , D : Depite
    private String documentTypeVersion;     // 0.9 : Disable signature validator , 1.0 : Enable signature validator
    private String dateTimeIssued;          // DateTime Of Invoice , Ex:. "2020-10-27T23:59:59Z"
    private String invoRealDate;//مش للضرايب
    private String dateTimeCreated;//مش للضرايب
    private String taxpayerActivityCode;    // this number come from the org account on the portal : كود النشاط الضريبي المسجل بمصلحة الضرائب للجهة
    private String internalID;              // Invoice number in the Org : APIهناك امكانية لتكرار هذا الرقم على ال - رقم الفاتورة عند الجهة المصدرة للفتورة

    private String documentInternalIDSearch;//مش للضرايب

    private String purchaseOrderReference;
    private String purchaseOrderDescription;
    private String salesOrderReference;
    private String salesOrderDescription;
    private String proformaInvoiceNumber;

    private _200_Submit_Documents_005_payment payment;
    private _200_Submit_Documents_006_delivery delivery;

    private List<_200_Submit_Documents_008_invoiceLine> invoiceLines; // All Invoice Rows : كل صفوف الفاتورة من مبيعات

    private double totalSalesAmount;
    private double totalDiscountAmount;
    private double netAmount;

    private List<_200_Submit_Documents_014_taxTotal> taxTotals;

    private double totalItemsDiscountAmount;
    private double extraDiscountAmount;
    private double totalAmount;

    private List<_200_Submit_Documents_016_signature> signatures;

    public _200_Submit_Documents_001_document() {

    }

    public _200_Submit_Documents_001_document(_200_Submit_Documents_001_document Submit_Documents_001_document) {
        this(
                Submit_Documents_001_document.getIssuer(),
                Submit_Documents_001_document.getReceiver(),
                Submit_Documents_001_document.getDocumentType(),
                Submit_Documents_001_document.getDocumentTypeVersion(),
                Submit_Documents_001_document.getDateTimeIssued(),
                Submit_Documents_001_document.getTaxpayerActivityCode(),
                Submit_Documents_001_document.getInternalID(),
                Submit_Documents_001_document.getPurchaseOrderReference(),
                Submit_Documents_001_document.getPurchaseOrderDescription(),
                Submit_Documents_001_document.getSalesOrderReference(),
                Submit_Documents_001_document.getSalesOrderDescription(),
                Submit_Documents_001_document.getProformaInvoiceNumber(),
                Submit_Documents_001_document.getPayment(),
                Submit_Documents_001_document.getDelivery(),
                Submit_Documents_001_document.getInvoiceLines(),
                Submit_Documents_001_document.getTotalSalesAmount(),
                Submit_Documents_001_document.getTotalDiscountAmount(),
                Submit_Documents_001_document.getNetAmount(),
                Submit_Documents_001_document.getTaxTotals(),
                Submit_Documents_001_document.getTotalItemsDiscountAmount(),
                Submit_Documents_001_document.getExtraDiscountAmount(),
                Submit_Documents_001_document.getTotalAmount(),
                Submit_Documents_001_document.getSignatures()
        );
    }

    public _200_Submit_Documents_001_document(_200_Submit_Documents_002_issuer issuer, _200_Submit_Documents_003_receiver receiver, String documentType, String documentTypeVersion, String dateTimeIssued, String taxpayerActivityCode, String internalID, String purchaseOrderReference, String purchaseOrderDescription, String salesOrderReference, String salesOrderDescription, String proformaInvoiceNumber, _200_Submit_Documents_005_payment payment, _200_Submit_Documents_006_delivery delivery, List<_200_Submit_Documents_008_invoiceLine> invoiceLines, double totalSalesAmount, double totalDiscountAmount, double netAmount, List<_200_Submit_Documents_014_taxTotal> taxTotals, double totalItemsDiscountAmount, double extraDiscountAmount, double totalAmount, List<_200_Submit_Documents_016_signature> signatures) {
        this.issuer = issuer;
        this.receiver = receiver;
        this.documentType = documentType;
        this.documentTypeVersion = documentTypeVersion;
        this.dateTimeIssued = dateTimeIssued;
        this.taxpayerActivityCode = taxpayerActivityCode;
        this.internalID = internalID;
        this.purchaseOrderReference = purchaseOrderReference;
        this.purchaseOrderDescription = purchaseOrderDescription;
        this.salesOrderReference = salesOrderReference;
        this.salesOrderDescription = salesOrderDescription;
        this.proformaInvoiceNumber = proformaInvoiceNumber;
        this.payment = payment;
        this.delivery = delivery;
        this.invoiceLines = invoiceLines;
        this.totalSalesAmount = totalSalesAmount;
        this.totalDiscountAmount = totalDiscountAmount;
        this.netAmount = netAmount;
        this.taxTotals = taxTotals;
        this.totalItemsDiscountAmount = totalItemsDiscountAmount;
        this.extraDiscountAmount = extraDiscountAmount;
        this.totalAmount = totalAmount;
        this.signatures = signatures;
    }

    public _200_Submit_Documents_002_issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(_200_Submit_Documents_002_issuer issuer) {
        this.issuer = issuer;
    }

    public _200_Submit_Documents_003_receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(_200_Submit_Documents_003_receiver receiver) {
        this.receiver = receiver;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentTypeVersion() {
        return documentTypeVersion;
    }

    public void setDocumentTypeVersion(String documentTypeVersion) {
        this.documentTypeVersion = documentTypeVersion;
    }

    public String getDateTimeIssued() {
        return dateTimeIssued;
    }

    public void setDateTimeIssued(String dateTimeIssued) {
        this.dateTimeIssued = dateTimeIssued;
    }

    public String getTaxpayerActivityCode() {
        return taxpayerActivityCode;
    }

    public void setTaxpayerActivityCode(String taxpayerActivityCode) {
        this.taxpayerActivityCode = taxpayerActivityCode;
    }

    public String getInternalID() {
        return internalID;
    }

    public void setInternalID(String internalID) {
        this.internalID = internalID;
    }

    public String getPurchaseOrderReference() {
        return purchaseOrderReference;
    }

    public void setPurchaseOrderReference(String purchaseOrderReference) {
        this.purchaseOrderReference = purchaseOrderReference;
    }

    public String getPurchaseOrderDescription() {
        return purchaseOrderDescription;
    }

    public void setPurchaseOrderDescription(String purchaseOrderDescription) {
        this.purchaseOrderDescription = purchaseOrderDescription;
    }

    public String getSalesOrderReference() {
        return salesOrderReference;
    }

    public void setSalesOrderReference(String salesOrderReference) {
        this.salesOrderReference = salesOrderReference;
    }

    public String getSalesOrderDescription() {
        return salesOrderDescription;
    }

    public void setSalesOrderDescription(String salesOrderDescription) {
        this.salesOrderDescription = salesOrderDescription;
    }

    public String getProformaInvoiceNumber() {
        return proformaInvoiceNumber;
    }

    public void setProformaInvoiceNumber(String proformaInvoiceNumber) {
        this.proformaInvoiceNumber = proformaInvoiceNumber;
    }

    public _200_Submit_Documents_005_payment getPayment() {
        return payment;
    }

    public void setPayment(_200_Submit_Documents_005_payment payment) {
        this.payment = payment;
    }

    public _200_Submit_Documents_006_delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(_200_Submit_Documents_006_delivery delivery) {
        this.delivery = delivery;
    }

    public List<_200_Submit_Documents_008_invoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(List<_200_Submit_Documents_008_invoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    public double getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public void setTotalDiscountAmount(double totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public List<_200_Submit_Documents_014_taxTotal> getTaxTotals() {
        return taxTotals;
    }

    public void setTaxTotals(List<_200_Submit_Documents_014_taxTotal> taxTotals) {
        this.taxTotals = taxTotals;
    }

    public double getTotalItemsDiscountAmount() {
        return totalItemsDiscountAmount;
    }

    public void setTotalItemsDiscountAmount(double totalItemsDiscountAmount) {
        this.totalItemsDiscountAmount = totalItemsDiscountAmount;
    }

    public double getExtraDiscountAmount() {
        return extraDiscountAmount;
    }

    public void setExtraDiscountAmount(double extraDiscountAmount) {
        this.extraDiscountAmount = extraDiscountAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<_200_Submit_Documents_016_signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<_200_Submit_Documents_016_signature> signatures) {
        this.signatures = signatures;
    }

    public String getAccAcountUnitCode() {
        return accAcountUnitCode;
    }

    public void setAccAcountUnitCode(String accAcountUnitCode) {
        this.accAcountUnitCode = accAcountUnitCode;
    }

    public String getInvSp() {
        return invSp;
    }

    public void setInvSp(String invSp) {
        this.invSp = invSp;
    }

    public String getRmrk() {
        return rmrk;
    }

    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    public String getDeptOld() {
        return deptOld;
    }

    public void setDeptOld(String deptOld) {
        this.deptOld = deptOld;
    }

    public String getAccUnitId() {
        return accUnitId;
    }

    public void setAccUnitId(String accUnitId) {
        this.accUnitId = accUnitId;
    }

    public String getSectionOld() {
        return sectionOld;
    }

    public void setSectionOld(String sectionOld) {
        this.sectionOld = sectionOld;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getDocumentDividedStatus() {
        return documentDividedStatus;
    }

    public void setDocumentDividedStatus(String documentDividedStatus) {
        this.documentDividedStatus = documentDividedStatus;
    }

    public String getStartDocSerial() {
        return startDocSerial;
    }

    public void setStartDocSerial(String startDocSerial) {
        this.startDocSerial = startDocSerial;
    }

    public String getEndDocSerial() {
        return endDocSerial;
    }

    public void setEndDocSerial(String endDocSerial) {
        this.endDocSerial = endDocSerial;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getServiceSeq() {
        return serviceSeq;
    }

    public void setServiceSeq(String serviceSeq) {
        this.serviceSeq = serviceSeq;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getChkPaied() {
        return chkPaied;
    }

    public void setChkPaied(String chkPaied) {
        this.chkPaied = chkPaied;
    }

    public String getNewAccAcountUnitCode() {
        return newAccAcountUnitCode;
    }

    public void setNewAccAcountUnitCode(String newAccAcountUnitCode) {
        this.newAccAcountUnitCode = newAccAcountUnitCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDocumentInternalIDSearch() {
        return documentInternalIDSearch;
    }

    public void setDocumentInternalIDSearch(String documentInternalIDSearch) {
        this.documentInternalIDSearch = documentInternalIDSearch;
    }

    public String getPermToReceiveCode() {
        return permToReceiveCode;
    }

    public void setPermToReceiveCode(String permToReceiveCode) {
        this.permToReceiveCode = permToReceiveCode;
    }

    public String getPermToDeliverCode() {
        return permToDeliverCode;
    }

    public void setPermToDeliverCode(String permToDeliverCode) {
        this.permToDeliverCode = permToDeliverCode;
    }

    public String getPermToReceiveDate() {
        return permToReceiveDate;
    }

    public void setPermToReceiveDate(String permToReceiveDate) {
        this.permToReceiveDate = permToReceiveDate;
    }

    public String getPaidFormCode() {
        return paidFormCode;
    }

    public void setPaidFormCode(String paidFormCode) {
        this.paidFormCode = paidFormCode;
    }

    public String getAllowUnVerify() {
        return allowUnVerify;
    }

    public void setAllowUnVerify(String allowUnVerify) {
        this.allowUnVerify = allowUnVerify;
    }

    public String getEmployeeNameWhoLastVerify() {
        return employeeNameWhoLastVerify;
    }

    public void setEmployeeNameWhoLastVerify(String employeeNameWhoLastVerify) {
        this.employeeNameWhoLastVerify = employeeNameWhoLastVerify;
    }

    public String getEmployeeNoWhoLastVerify() {
        return employeeNoWhoLastVerify;
    }

    public void setEmployeeNoWhoLastVerify(String employeeNoWhoLastVerify) {
        this.employeeNoWhoLastVerify = employeeNoWhoLastVerify;
    }

    public String getStatusRmrk() {
        return statusRmrk;
    }

    public void setStatusRmrk(String statusRmrk) {
        this.statusRmrk = statusRmrk;
    }

    public String getPermToDeliverDate() {
        return permToDeliverDate;
    }

    public void setPermToDeliverDate(String permToDeliverDate) {
        this.permToDeliverDate = permToDeliverDate;
    }

    public String getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(String dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public String getInvoRealDate() {
        return invoRealDate;
    }

    public void setInvoRealDate(String invoRealDate) {
        this.invoRealDate = invoRealDate;
    }

}
