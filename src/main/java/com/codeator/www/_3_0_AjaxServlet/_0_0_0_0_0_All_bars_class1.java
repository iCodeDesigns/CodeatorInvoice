/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._3_0_AjaxServlet;

import java.util.List;

/**
 *
 * @author Mohamed
 */
public class _0_0_0_0_0_All_bars_class1 {
    private List<String> parts;

    private List<_0_0_0_0_0_single_bar_class2> data_list;

    public _0_0_0_0_0_All_bars_class1(){
        
    }
    public _0_0_0_0_0_All_bars_class1(List<String> parts, List<_0_0_0_0_0_single_bar_class2> data_list) {
        this.parts = parts;
        this.data_list = data_list;
    }

    public List<String> getParts() {
        return parts;
    }

    public void setParts(List<String> parts) {
        this.parts = parts;
    }

    public List<_0_0_0_0_0_single_bar_class2> getData_list() {
        return data_list;
    }

    public void setData_list(List<_0_0_0_0_0_single_bar_class2> data_list) {
        this.data_list = data_list;
    }
}
