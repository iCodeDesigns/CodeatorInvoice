/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._5_0_DashboardsModulesBean;

/**
 *
 * @author Moham
 */
public class _02_invoice_json_charts {

    private String x_axis_title;
    private String value;

    public _02_invoice_json_charts() {

    }

    public _02_invoice_json_charts(String x_axis_title, String value) {
        this.x_axis_title = x_axis_title;
        this.value = value;
    }

    public String getX_axis_title() {
        return x_axis_title;
    }

    public void setX_axis_title(String x_axis_title) {
        this.x_axis_title = x_axis_title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
