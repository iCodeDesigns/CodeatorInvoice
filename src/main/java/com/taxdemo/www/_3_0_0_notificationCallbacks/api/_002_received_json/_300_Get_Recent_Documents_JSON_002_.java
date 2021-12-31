/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json;

/**
 *
 * @author Moham
 */
public class _300_Get_Recent_Documents_JSON_002_ {

    private int totalPages;
    private int totalCount;

    public _300_Get_Recent_Documents_JSON_002_() {

    }

    public _300_Get_Recent_Documents_JSON_002_(int totalPages, int totalCount) {
        this.totalPages = totalPages;
        this.totalCount = totalCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
