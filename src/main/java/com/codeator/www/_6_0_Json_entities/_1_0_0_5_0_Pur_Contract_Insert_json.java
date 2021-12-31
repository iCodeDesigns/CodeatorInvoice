/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._6_0_Json_entities;

import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_003_receiver;
import java.util.List;

/**
 *
 * @author Moham
 */
public class _1_0_0_5_0_Pur_Contract_Insert_json {

    private String titleText;
    private String addNewTitle;//true || false

    private String contractType;
    private List<String> serviceSeq;
    private String contractDate;
    private String contractValue;
    private String contractTax;
    private String paymentKind;
    private String periodType;
    private String contractFromDate;
    private String contractToDate;
    private String contractAlertDate;
    private String periodVal;
    private String rmrk;

    //id
    private String contractSp;
    private String deptNoOld;
    private String sectionNoOld;
    private String titleId;

    private _200_Submit_Documents_003_receiver receiver;
    private List<_1_0_0_5_0_Pur_Contract_Insert_dtl_json> purContractMasterDtl;

    public _1_0_0_5_0_Pur_Contract_Insert_json() {

    }

    public _1_0_0_5_0_Pur_Contract_Insert_json(String titleText, String addNewTitle, String contractType, List<String> serviceSeq, String contractDate, String contractValue, String contractTax, String paymentKind, String periodType, String contractFromDate, String contractToDate, String contractAlertDate, String periodVal, String rmrk, String contractSp, String deptNoOld, String sectionNoOld, String titleId, _200_Submit_Documents_003_receiver receiver, List<_1_0_0_5_0_Pur_Contract_Insert_dtl_json> purContractMasterDtl) {
        this.titleText = titleText;
        this.addNewTitle = addNewTitle;
        this.contractType = contractType;
        this.serviceSeq = serviceSeq;
        this.contractDate = contractDate;
        this.contractValue = contractValue;
        this.contractTax = contractTax;
        this.paymentKind = paymentKind;
        this.periodType = periodType;
        this.contractFromDate = contractFromDate;
        this.contractToDate = contractToDate;
        this.contractAlertDate = contractAlertDate;
        this.periodVal = periodVal;
        this.rmrk = rmrk;
        this.contractSp = contractSp;
        this.deptNoOld = deptNoOld;
        this.sectionNoOld = sectionNoOld;
        this.titleId = titleId;
        this.receiver = receiver;
        this.purContractMasterDtl = purContractMasterDtl;
    }

    public List<String> getServiceSeq() {
        return serviceSeq;
    }

    public void setServiceSeq(List<String> serviceSeq) {
        this.serviceSeq = serviceSeq;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractValue() {
        return contractValue;
    }

    public void setContractValue(String contractValue) {
        this.contractValue = contractValue;
    }

    public String getContractTax() {
        return contractTax;
    }

    public void setContractTax(String contractTax) {
        this.contractTax = contractTax;
    }

    public String getPaymentKind() {
        return paymentKind;
    }

    public void setPaymentKind(String paymentKind) {
        this.paymentKind = paymentKind;
    }

    public String getContractFromDate() {
        return contractFromDate;
    }

    public void setContractFromDate(String contractFromDate) {
        this.contractFromDate = contractFromDate;
    }

    public String getContractToDate() {
        return contractToDate;
    }

    public void setContractToDate(String contractToDate) {
        this.contractToDate = contractToDate;
    }

    public String getRmrk() {
        return rmrk;
    }

    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    public String getContractSp() {
        return contractSp;
    }

    public void setContractSp(String contractSp) {
        this.contractSp = contractSp;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public _200_Submit_Documents_003_receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(_200_Submit_Documents_003_receiver receiver) {
        this.receiver = receiver;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public List<_1_0_0_5_0_Pur_Contract_Insert_dtl_json> getPurContractMasterDtl() {
        return purContractMasterDtl;
    }

    public void setPurContractMasterDtl(List<_1_0_0_5_0_Pur_Contract_Insert_dtl_json> purContractMasterDtl) {
        this.purContractMasterDtl = purContractMasterDtl;
    }

    public String getContractAlertDate() {
        return contractAlertDate;
    }

    public void setContractAlertDate(String contractAlertDate) {
        this.contractAlertDate = contractAlertDate;
    }

    public String getPeriodVal() {
        return periodVal;
    }

    public void setPeriodVal(String periodVal) {
        this.periodVal = periodVal;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getAddNewTitle() {
        return addNewTitle;
    }

    public void setAddNewTitle(String addNewTitle) {
        this.addNewTitle = addNewTitle;
    }

    public String getDeptNoOld() {
        return deptNoOld;
    }

    public void setDeptNoOld(String deptNoOld) {
        this.deptNoOld = deptNoOld;
    }

    public String getSectionNoOld() {
        return sectionNoOld;
    }

    public void setSectionNoOld(String sectionNoOld) {
        this.sectionNoOld = sectionNoOld;
    }

}
