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
public class _201_units_in_dept {

    private String unitName;//مش للضرايب
    private String unitCode;//مش للضرايب
    private String unitNickName;//مش للضرايب

    private String active;//مش للضرايب

    private String sectionId;//مش للضرايب
    private String deptId;//مش للضرايب
    private String accUnitId;//مش للضرايب

    public _201_units_in_dept() {

    }

    public _201_units_in_dept(String unitName, String unitCode, String unitNickName, String active, String sectionId, String deptId, String accUnitId) {
        this.unitName = unitName;
        this.unitCode = unitCode;
        this.unitNickName = unitNickName;
        this.active = active;
        this.sectionId = sectionId;
        this.deptId = deptId;
        this.accUnitId = accUnitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitNickName() {
        return unitNickName;
    }

    public void setUnitNickName(String unitNickName) {
        this.unitNickName = unitNickName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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
}
