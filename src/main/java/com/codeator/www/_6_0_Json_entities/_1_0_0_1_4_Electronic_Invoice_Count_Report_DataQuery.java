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
public class _1_0_0_1_4_Electronic_Invoice_Count_Report_DataQuery {

    private String deptOld;
    private String sectionOld;
    private String deptName;

    private List<_1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl> dataDetail;

    public _1_0_0_1_4_Electronic_Invoice_Count_Report_DataQuery() {

    }

    public _1_0_0_1_4_Electronic_Invoice_Count_Report_DataQuery(String deptOld, String sectionOld, String deptName, List<_1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl> dataDetail) {
        this.deptOld = deptOld;
        this.sectionOld = sectionOld;
        this.deptName = deptName;
        this.dataDetail = dataDetail;
    }

    public String getDeptOld() {
        return deptOld;
    }

    public void setDeptOld(String deptOld) {
        this.deptOld = deptOld;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<_1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl> getDataDetail() {
        return dataDetail;
    }

    public void setDataDetail(List<_1_0_0_1_4_Electronic_Invoice_Count_Report_DataQueryDtl> dataDetail) {
        this.dataDetail = dataDetail;
    }

    public String getSectionOld() {
        return sectionOld;
    }

    public void setSectionOld(String sectionOld) {
        this.sectionOld = sectionOld;
    }
}
