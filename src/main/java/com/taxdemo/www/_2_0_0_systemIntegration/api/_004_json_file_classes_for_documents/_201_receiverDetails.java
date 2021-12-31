/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

/**
 *
 * @author Moham
 */
public class _201_receiverDetails {

    private long suppSeqBr;
    private String addressBr;
    private String suppNameBr;
    private String suppMainFrameCode;

    public long getSuppSeqBr() {
        return suppSeqBr;
    }

    public void setSuppSeqBr(long suppSeqBr) {
        this.suppSeqBr = suppSeqBr;
    }

    public String getAddressBr() {
        return addressBr;
    }

    public void setAddressBr(String addressBr) {
        this.addressBr = addressBr;
    }

    public String getSuppNameBr() {
        return suppNameBr;
    }

    public void setSuppNameBr(String suppNameBr) {
        this.suppNameBr = suppNameBr;
    }

    public _201_receiverDetails() {

    }

    public _201_receiverDetails(long suppSeqBr, String addressBr, String suppNameBr , String suppMainFrameCode) {
        this.suppSeqBr = suppSeqBr;
        this.addressBr = addressBr;
        this.suppNameBr = suppNameBr;
        this.suppMainFrameCode = suppMainFrameCode;
    }

    public String getSuppMainFrameCode() {
        return suppMainFrameCode;
    }

    public void setSuppMainFrameCode(String suppMainFrameCode) {
        this.suppMainFrameCode = suppMainFrameCode;
    }

}
