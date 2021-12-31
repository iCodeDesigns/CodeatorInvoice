/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._6_0_Json_entities;

/**
 *
 * @author Moham
 */
public class _1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl {

    private String documentStatusName;// tax_name
    private String documentStatusId;// taxType,TaxSubType
    private String count;//
    private String sum;//--

    public String getDocumentStatusName() {
        return documentStatusName;
    }

    public void setDocumentStatusName(String documentStatusName) {
        this.documentStatusName = documentStatusName;
    }

    public String getDocumentStatusId() {
        return documentStatusId;
    }

    public void setDocumentStatusId(String documentStatusId) {
        this.documentStatusId = documentStatusId;
    }

    public _1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl() {

    }

    public _1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl(String documentStatusName, String documentStatusId, String count, String sum) {
        this.documentStatusName = documentStatusName;
        this.documentStatusId = documentStatusId;
        this.count = count;
        this.sum = sum;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

}
