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
public class _1_0_0_5_0_Pur_Contract_Insert_dtl_json {

    private double conValue;
    private String conFromDate;
    private String conToDate;

    public _1_0_0_5_0_Pur_Contract_Insert_dtl_json() {

    }

    public _1_0_0_5_0_Pur_Contract_Insert_dtl_json(double conValue, String conFromDate, String conToDate) {
        this.conValue = conValue;
        this.conFromDate = conFromDate;
        this.conToDate = conToDate;
    }

    public double getConValue() {
        return conValue;
    }

    public void setConValue(double conValue) {
        this.conValue = conValue;
    }

    public String getConFromDate() {
        return conFromDate;
    }

    public void setConFromDate(String conFromDate) {
        this.conFromDate = conFromDate;
    }

    public String getConToDate() {
        return conToDate;
    }

    public void setConToDate(String conToDate) {
        this.conToDate = conToDate;
    }
}
