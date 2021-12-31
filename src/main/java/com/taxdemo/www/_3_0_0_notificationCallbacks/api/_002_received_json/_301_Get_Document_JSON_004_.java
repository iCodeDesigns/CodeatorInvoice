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
public class _301_Get_Document_JSON_004_ {

    private String propertyName;
    private String propertyPath;
    private String errorCode;
    private String error;
    private List<_301_Get_Document_JSON_004_> innerError;

    public _301_Get_Document_JSON_004_() {
        
    }

    public _301_Get_Document_JSON_004_(String propertyName, String propertyPath, String errorCode, String error, List<_301_Get_Document_JSON_004_> innerError) {
        this.propertyName = propertyName;
        this.propertyPath = propertyPath;
        this.errorCode = errorCode;
        this.error = error;
        this.innerError = innerError;
    }

    public List<_301_Get_Document_JSON_004_> getInnerError() {
        return innerError;
    }

    public void setInnerError(List<_301_Get_Document_JSON_004_> innerError) {
        this.innerError = innerError;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyPath() {
        return propertyPath;
    }

    public void setPropertyPath(String propertyPath) {
        this.propertyPath = propertyPath;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
