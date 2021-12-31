/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_010_discount {

    private double rate;
    private double amount;

    public _200_Submit_Documents_010_discount() {

    }

    public _200_Submit_Documents_010_discount(double rate, double amount) {
        this.rate = rate;
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
