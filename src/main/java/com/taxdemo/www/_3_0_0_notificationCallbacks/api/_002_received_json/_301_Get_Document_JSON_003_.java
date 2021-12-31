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
public class _301_Get_Document_JSON_003_ {

    private String name;
    private String status;
    private _301_Get_Document_JSON_004_ error;

    public _301_Get_Document_JSON_003_() {

    }

    public _301_Get_Document_JSON_003_(String name, String status, _301_Get_Document_JSON_004_ error) {
        this.name = name;
        this.status = status;
        this.error = error;
    }

    public _301_Get_Document_JSON_004_ getError() {
        return error;
    }

    public void setError(_301_Get_Document_JSON_004_ error) {
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
