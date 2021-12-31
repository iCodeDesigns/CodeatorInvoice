/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._5_0_DashboardsModulesBean;

import java.util.List;

/**
 *
 * @author Moham
 */
public class _01_invoice_json_charts {

    private String title_extra;
    private String data_name;
    private List<_02_invoice_json_charts> x_axis_data;

    public _01_invoice_json_charts() {

    }

    public _01_invoice_json_charts(String data_name, String title_extra, List<_02_invoice_json_charts> x_axis_data) {
        this.data_name = data_name;
        this.title_extra = title_extra;
        this.x_axis_data = x_axis_data;
    }

    public String getData_name() {
        return data_name;
    }

    public void setData_name(String data_name) {
        this.data_name = data_name;
    }

    public List<_02_invoice_json_charts> getX_axis_data() {
        return x_axis_data;
    }

    public void setX_axis_data(List<_02_invoice_json_charts> x_axis_data) {
        this.x_axis_data = x_axis_data;
    }

    public String getTitle_extra() {
        return title_extra;
    }

    public void setTitle_extra(String Title_extra) {
        this.title_extra = Title_extra;
    }
}
