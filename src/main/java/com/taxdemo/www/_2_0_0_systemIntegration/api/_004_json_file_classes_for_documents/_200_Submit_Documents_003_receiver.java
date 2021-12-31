/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import java.util.List;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_003_receiver {

    private _200_Submit_Documents_004_address address;
    private String type;
    private String id;
    private String name;

    private String suppCode;// مش للضرايب
    private String suppSeq;// مش للضرايب
    private String identNo;// مش للضرايب
    private String taxCardNo;// مش للضرايب
    private String passportNo;// مش للضرايب
    private String foundedInAhramData; // مش للضرايب
    private List<_201_receiverDetails> receiverDetails;// مش للضرايب

    public _200_Submit_Documents_003_receiver() {

    }

    public _200_Submit_Documents_003_receiver(_200_Submit_Documents_003_receiver Submit_Documents_003_receiver) {
        this(
                Submit_Documents_003_receiver.getAddress(),
                Submit_Documents_003_receiver.getType(),
                Submit_Documents_003_receiver.getId(),
                Submit_Documents_003_receiver.getName()
        );
    }

    public _200_Submit_Documents_003_receiver(_200_Submit_Documents_004_address address, String type, String id, String name) {
        this.address = address;
        this.type = type;
        this.id = id;
        this.name = name;
    }

    public _200_Submit_Documents_004_address getAddress() {
        return address;
    }

    public void setAddress(_200_Submit_Documents_004_address address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundedInAhramData() {
        return foundedInAhramData;
    }

    public void setFoundedInAhramData(String foundedInAhramData) {
        this.foundedInAhramData = foundedInAhramData;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getSuppSeq() {
        return suppSeq;
    }

    public void setSuppSeq(String suppSeq) {
        this.suppSeq = suppSeq;
    }

    public String getIdentNo() {
        return identNo;
    }

    public void setIdentNo(String identNo) {
        this.identNo = identNo;
    }

    public String getTaxCardNo() {
        return taxCardNo;
    }

    public void setTaxCardNo(String taxCardNo) {
        this.taxCardNo = taxCardNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public List<_201_receiverDetails> getReceiverDetails() {
        return receiverDetails;
    }

    public void setReceiverDetails(List<_201_receiverDetails> receiverDetails) {
        this.receiverDetails = receiverDetails;
    }

}
