/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._6_0_Json_entities;

import java.util.List;

/**
 *
 * @author Moham
 */
public class _1_0_0_1_4_Electronic_Invoice_Count_Report {

    private List<_1_0_0_1_4_Electronic_Invoice_Count_Report_2> docStatus;
    private List<_1_0_0_1_4_Electronic_Invoice_Count_Report_2> taxSubType;
    private List<String> dept;

    public _1_0_0_1_4_Electronic_Invoice_Count_Report() {

    }

    public _1_0_0_1_4_Electronic_Invoice_Count_Report(List<_1_0_0_1_4_Electronic_Invoice_Count_Report_2> docStatus, List<_1_0_0_1_4_Electronic_Invoice_Count_Report_2> taxSubType, List<String> dept) {
        this.docStatus = docStatus;
        this.taxSubType = taxSubType;
        this.dept = dept;
    }


    public List<String> getDept() {
        return dept;
    }

    public void setDept(List<String> dept) {
        this.dept = dept;
    }

    public List<_1_0_0_1_4_Electronic_Invoice_Count_Report_2> getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(List<_1_0_0_1_4_Electronic_Invoice_Count_Report_2> docStatus) {
        this.docStatus = docStatus;
    }

    public List<_1_0_0_1_4_Electronic_Invoice_Count_Report_2> getTaxSubType() {
        return taxSubType;
    }

    public void setTaxSubType(List<_1_0_0_1_4_Electronic_Invoice_Count_Report_2> taxSubType) {
        this.taxSubType = taxSubType;
    }
}
