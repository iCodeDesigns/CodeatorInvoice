/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import java.io.Serializable;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_005_payment implements Serializable {

    private String bankName;
    private String bankAddress;
    private String bankAccountNo;
    private String bankAccountIBAN;
    private String swiftCode;
    private String terms;

    public _200_Submit_Documents_005_payment() {

    }

    public _200_Submit_Documents_005_payment(_200_Submit_Documents_005_payment Submit_Documents_005_payment) {
        this(
                Submit_Documents_005_payment.getBankName(),
                Submit_Documents_005_payment.getBankAddress(),
                Submit_Documents_005_payment.getBankAccountNo(),
                Submit_Documents_005_payment.getBankAccountIBAN(),
                Submit_Documents_005_payment.getSwiftCode(),
                Submit_Documents_005_payment.getTerms()
        );
    }

    public _200_Submit_Documents_005_payment(String bankName, String bankAddress, String bankAccountNo, String bankAccountIBAN, String swiftCode, String terms) {
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.bankAccountNo = bankAccountNo;
        this.bankAccountIBAN = bankAccountIBAN;
        this.swiftCode = swiftCode;
        this.terms = terms;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankAccountIBAN() {
        return bankAccountIBAN;
    }

    public void setBankAccountIBAN(String bankAccountIBAN) {
        this.bankAccountIBAN = bankAccountIBAN;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

}
