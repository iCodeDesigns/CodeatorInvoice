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
public class _200_Submit_Documents_009_unitValue {

    /**
     * if currencySold = (EGP)
     * then amountSold = 0.00
     * currencyExchangeRate = 0.00
     */
    
    /**
     * if currencySold = any other currency
     * then amountSold = سعر الوحدة بالعملة المختارة
     * currencyExchangeRate = سعر التحويل من العملة المختارة للجنيه المصري
     * amountEGP = amountSold * currencyExchangeRate
     */
    private String currencySold; // Currency used code (this code come from the sdk)
    private double amountEGP;
    private double amountSold;
    private double currencyExchangeRate;

    public _200_Submit_Documents_009_unitValue() {

    }

    public _200_Submit_Documents_009_unitValue(String currencySold, double amountEGP, double amountSold, double currencyExchangeRate) {
        this.currencySold = currencySold;
        this.amountEGP = amountEGP;
        this.amountSold = amountSold;
        this.currencyExchangeRate = currencyExchangeRate;
    }

    public double getCurrencyExchangeRate() {
        return currencyExchangeRate;
    }

    public void setCurrencyExchangeRate(double currencyExchangeRate) {
        this.currencyExchangeRate = currencyExchangeRate;
    }

    public String getCurrencySold() {
        return currencySold;
    }

    public void setCurrencySold(String currencySold) {
        this.currencySold = currencySold;
    }

    public double getAmountEGP() {
        return amountEGP;
    }

    public void setAmountEGP(double amountEGP) {
        this.amountEGP = amountEGP;
    }

    public double getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(double amountSold) {
        this.amountSold = amountSold;
    }

}
