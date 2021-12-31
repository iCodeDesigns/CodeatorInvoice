/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._5_0_DashboardsModulesBean;

/**
 *
 * @author Mahmoud
 */
public class vcleRequestDashboardBean {

    private String deptName;
    private long noOfRequestes;

    public vcleRequestDashboardBean(String deptName, long noOfRequestes) {
        this.deptName = deptName;
        this.noOfRequestes = noOfRequestes;
    }

    public long getNoOfRequestes() {
        return noOfRequestes;
    }

    public void setNoOfRequestes(long noOfRequestes) {
        this.noOfRequestes = noOfRequestes;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
