/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_2_DB_JSonEntities;

/**
 *
 * @author Mohamed
 */
public class VcleTrafficEmpPerm_Query_Jason {

    private String employeeId;
    private String execMm;
    private String employeeNo;
    private String employee_name;
    private String CountEmployeeIdInMonth;
    private String CountValInMonth;
    private String sectionNoOld;
    private String depNoOld;
    private String val;
    private String chkAsso;
    private String rmrk;
    

    public VcleTrafficEmpPerm_Query_Jason() {

    }

    public VcleTrafficEmpPerm_Query_Jason(String employeeId,String employee_name, String execMm, String employeeNo, String CountEmployeeIdInMonth, String CountValInMonth, String sectionNoOld, String depNoOld, String val, String chkAsso, String rmrk) {
        this.employeeId = employeeId;
        this.execMm = execMm;
        this.employeeNo = employeeNo;
        this.employee_name = employee_name;
        this.CountEmployeeIdInMonth = CountEmployeeIdInMonth;
        this.CountValInMonth = CountValInMonth;
        this.sectionNoOld = sectionNoOld;
        this.depNoOld = depNoOld;
        this.val = val;
        this.chkAsso = chkAsso;
        this.rmrk = rmrk;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getExecMm() {
        return execMm;
    }

    public void setExecMm(String execMm) {
        this.execMm = execMm;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getCountEmployeeIdInMonth() {
        return CountEmployeeIdInMonth;
    }

    public void setCountEmployeeIdInMonth(String CountEmployeeIdInMonth) {
        this.CountEmployeeIdInMonth = CountEmployeeIdInMonth;
    }

    public String getCountValInMonth() {
        return CountValInMonth;
    }

    public void setCountValInMonth(String CountValInMonth) {
        this.CountValInMonth = CountValInMonth;
    }

    public String getSectionNoOld() {
        return sectionNoOld;
    }

    public void setSectionNoOld(String sectionNoOld) {
        this.sectionNoOld = sectionNoOld;
    }

    public String getDepNoOld() {
        return depNoOld;
    }

    public void setDepNoOld(String depNoOld) {
        this.depNoOld = depNoOld;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getChkAsso() {
        return chkAsso;
    }

    public void setChkAsso(String chkAsso) {
        this.chkAsso = chkAsso;
    }

    public String getRmrk() {
        return rmrk;
    }

    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    
    
}
