/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_012_taxableItem {

    private String taxType;
    private double amount;
    private String subType;
    private double rate;

    private String taxLineNumber;//مش للضرايب
    private String taxTypeName;//مش للضرايب
    private String subTypeName;//مش للضرايب
    private String subTypeNickName;//مش للضرايب

    private String active;//مش للضرايب
    private String taxbleStatus;//مش للضرايب

    private String sectionId;//مش للضرايب
    private String deptId;//مش للضرايب
    private String accUnitId;//مش للضرايب

    public _200_Submit_Documents_012_taxableItem() {

    }

    /**
     * مش محتاجاه الضرايب
     *
     * @param taxType
     * @param amount
     * @param subType
     * @param rate
     * @param taxLineNumber
     * @param taxTypeName
     * @param subTypeName
     */
    public _200_Submit_Documents_012_taxableItem(String taxType, double amount, String subType, double rate, String taxLineNumber, String taxTypeName, String subTypeName) {
        this.taxType = taxType;
        this.amount = amount;
        this.subType = subType;
        this.rate = rate;
        this.taxLineNumber = taxLineNumber;
        this.taxTypeName = taxTypeName;
        this.subTypeName = subTypeName;
    }

    /**
     * محتاجاه الضرايب
     *
     * @param taxType
     * @param amount
     * @param subType
     * @param rate
     */
    public _200_Submit_Documents_012_taxableItem(String taxType, double amount, String subType, double rate) {
        this.taxType = taxType;
        this.amount = amount;
        this.subType = subType;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getTaxTypeName() {
        return taxTypeName;
    }

    public void setTaxTypeName(String taxTypeName) {
        this.taxTypeName = taxTypeName;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }

    public String getTaxLineNumber() {
        return taxLineNumber;
    }

    public void setTaxLineNumber(String taxLineNumber) {
        this.taxLineNumber = taxLineNumber;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTaxbleStatus() {
        return taxbleStatus;
    }

    public void setTaxbleStatus(String taxbleStatus) {
        this.taxbleStatus = taxbleStatus;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    
    public String getAccUnitId() {
        return accUnitId;
    }

    public void setAccUnitId(String accUnitId) {
        this.accUnitId = accUnitId;
    }

    public String getSubTypeNickName() {
        return subTypeNickName;
    }

    public void setSubTypeNickName(String subTypeNickName) {
        this.subTypeNickName = subTypeNickName;
    }

}
