/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import java.io.Serializable;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_014_taxTotal implements Serializable {

    private String taxType;
    private double amount;

    public _200_Submit_Documents_014_taxTotal() {

    }

    public _200_Submit_Documents_014_taxTotal(_200_Submit_Documents_014_taxTotal Submit_Documents_014_taxTotal) {
        this(
                Submit_Documents_014_taxTotal.getTaxType(),
                Submit_Documents_014_taxTotal.getAmount()
        );
    }

    public _200_Submit_Documents_014_taxTotal(String taxType, double amount) {
        this.taxType = taxType;
        this.amount = amount;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
