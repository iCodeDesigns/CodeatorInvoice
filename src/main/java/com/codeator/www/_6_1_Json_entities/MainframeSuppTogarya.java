package com.codeator.www._6_1_Json_entities;
// Generated Dec 22, 2021 5:43:28 PM by Hibernate Tools 4.3.1

import com.codeator.www._6_1_Json_entities.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class MainframeSuppTogarya implements java.io.Serializable {

    private String mainFrameCode;
    private String suppName;
    private String adress;
    private String receiverCode;
    private String prodCode;
    private String taxCardNo;
    private String chkMoved;
    private String countryCode;
    private String govCode;
    private String serviceSeq;

    public MainframeSuppTogarya() {
    }

    public MainframeSuppTogarya(String mainFrameCode) {
        this.mainFrameCode = mainFrameCode;
    }

    public MainframeSuppTogarya(String mainFrameCode, String suppName, String adress, String receiverCode, String prodCode, String taxCardNo, String chkMoved) {
        this.mainFrameCode = mainFrameCode;
        this.suppName = suppName;
        this.adress = adress;
        this.receiverCode = receiverCode;
        this.prodCode = prodCode;
        this.taxCardNo = taxCardNo;
        this.chkMoved = chkMoved;
    }

    public String getMainFrameCode() {
        return this.mainFrameCode;
    }

    public void setMainFrameCode(String mainFrameCode) {
        this.mainFrameCode = mainFrameCode;
    }

    public String getSuppName() {
        return this.suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getReceiverCode() {
        return this.receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }

    public String getProdCode() {
        return this.prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getTaxCardNo() {
        return this.taxCardNo;
    }

    public void setTaxCardNo(String taxCardNo) {
        this.taxCardNo = taxCardNo;
    }

    public String getChkMoved() {
        return this.chkMoved;
    }

    public void setChkMoved(String chkMoved) {
        this.chkMoved = chkMoved;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getGovCode() {
        return this.govCode;
    }

    public void setGovCode(String govCode) {
        this.govCode = govCode;
    }

    public String getServiceSeq() {
        return this.serviceSeq;
    }

    public void setServiceSeq(String serviceSeq) {
        this.serviceSeq = serviceSeq;
    }

}
