/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json;

import java.util.List;

/**
 *
 * @author Moham
 */
public class _301_Get_Document_JSON_001_ {

    private String status;
    private List<_301_Get_Document_JSON_003_> validationSteps; // List of class

    public _301_Get_Document_JSON_001_() {

    }

    public _301_Get_Document_JSON_001_(String status, List<_301_Get_Document_JSON_003_> validationSteps) {
        this.status = status;
        this.validationSteps = validationSteps;
    }

    public List<_301_Get_Document_JSON_003_> getValidationSteps() {
        return validationSteps;
    }

    public void setValidationSteps(List<_301_Get_Document_JSON_003_> validationSteps) {
        this.validationSteps = validationSteps;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
