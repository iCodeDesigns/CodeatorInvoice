/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_1_CodeatorLib.Alerts;

/**
 *
 * @author Mahmoud
 */
public class Alerts {

    private String SuccessType;
    private String Title;
    private String Message;

    public Alerts() {

    }

    public Alerts(String SuccessType, String Title, String Message) {
        this.SuccessType = SuccessType;
        this.Title = Title;
        this.Message = Message;
    }

    public String getSuccessType() {
        return SuccessType;
    }

    public void setSuccessType(String SuccessType) {
        this.SuccessType = SuccessType;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
}
