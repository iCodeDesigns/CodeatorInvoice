/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json;

import java.util.List;

/**
 *
 * @author Moham
 */
public class _301_Get_Document_JSON_000_ {

    private String document;
    private String transformationStatus;
    private _301_Get_Document_JSON_001_ validationResults;//class
    private String maxPercision;
    private List<_301_Get_Document_JSON_002_> invoiceLineItemCodes;//List of Class
    private String uuid;
    private String submissionUUID;
    private String longId;
    private String internalId;
    private String typeName;
    private String typeVersionName;
    private String issuerId;
    private String issuerName;

    private String receiverId;
    private String receiverName;
    private String dateTimeIssued;
    private String dateTimeReceived;
    private String totalSales;
    private String totalDiscount;
    private String netAmount;
    private String total;
    private String status;

    public _301_Get_Document_JSON_000_() {

    }

    public _301_Get_Document_JSON_000_(String document, String transformationStatus, _301_Get_Document_JSON_001_ validationResults, String maxPercision, List<_301_Get_Document_JSON_002_> invoiceLineItemCodes, String uuid, String submissionUUID, String longId, String internalId, String typeName, String typeVersionName, String issuerId, String issuerName, String receiverId, String receiverName, String dateTimeIssued, String dateTimeReceived, String totalSales, String totalDiscount, String netAmount, String total, String status) {
        this.document = document;
        this.transformationStatus = transformationStatus;
        this.validationResults = validationResults;
        this.maxPercision = maxPercision;
        this.invoiceLineItemCodes = invoiceLineItemCodes;
        this.uuid = uuid;
        this.submissionUUID = submissionUUID;
        this.longId = longId;
        this.internalId = internalId;
        this.typeName = typeName;
        this.typeVersionName = typeVersionName;
        this.issuerId = issuerId;
        this.issuerName = issuerName;
        this.receiverId = receiverId;
        this.receiverName = receiverName;
        this.dateTimeIssued = dateTimeIssued;
        this.dateTimeReceived = dateTimeReceived;
        this.totalSales = totalSales;
        this.totalDiscount = totalDiscount;
        this.netAmount = netAmount;
        this.total = total;
        this.status = status;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getTransformationStatus() {
        return transformationStatus;
    }

    public void setTransformationStatus(String transformationStatus) {
        this.transformationStatus = transformationStatus;
    }

    public _301_Get_Document_JSON_001_ getValidationResults() {
        return validationResults;
    }

    public void setValidationResults(_301_Get_Document_JSON_001_ validationResults) {
        this.validationResults = validationResults;
    }

    public String getMaxPercision() {
        return maxPercision;
    }

    public void setMaxPercision(String maxPercision) {
        this.maxPercision = maxPercision;
    }

    public List<_301_Get_Document_JSON_002_> getInvoiceLineItemCodes() {
        return invoiceLineItemCodes;
    }

    public void setInvoiceLineItemCodes(List<_301_Get_Document_JSON_002_> invoiceLineItemCodes) {
        this.invoiceLineItemCodes = invoiceLineItemCodes;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSubmissionUUID() {
        return submissionUUID;
    }

    public void setSubmissionUUID(String submissionUUID) {
        this.submissionUUID = submissionUUID;
    }

    public String getLongId() {
        return longId;
    }

    public void setLongId(String longId) {
        this.longId = longId;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeVersionName() {
        return typeVersionName;
    }

    public void setTypeVersionName(String typeVersionName) {
        this.typeVersionName = typeVersionName;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDateTimeIssued() {
        return dateTimeIssued;
    }

    public void setDateTimeIssued(String dateTimeIssued) {
        this.dateTimeIssued = dateTimeIssued;
    }

    public String getDateTimeReceived() {
        return dateTimeReceived;
    }

    public void setDateTimeReceived(String dateTimeReceived) {
        this.dateTimeReceived = dateTimeReceived;
    }

    public String getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(String totalSales) {
        this.totalSales = totalSales;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
