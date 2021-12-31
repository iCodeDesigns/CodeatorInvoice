package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * InvoSuppPaymentType generated by hbm2java
 */
public class InvoSuppPaymentType  implements java.io.Serializable {


     private byte paymentType;
     private String paymentName;
     private Set invoInvoiceMasters = new HashSet(0);
     private Set purContractMasters = new HashSet(0);

    public InvoSuppPaymentType() {
    }

	
    public InvoSuppPaymentType(byte paymentType) {
        this.paymentType = paymentType;
    }
    public InvoSuppPaymentType(byte paymentType, String paymentName, Set invoInvoiceMasters, Set purContractMasters) {
       this.paymentType = paymentType;
       this.paymentName = paymentName;
       this.invoInvoiceMasters = invoInvoiceMasters;
       this.purContractMasters = purContractMasters;
    }
   
    public byte getPaymentType() {
        return this.paymentType;
    }
    
    public void setPaymentType(byte paymentType) {
        this.paymentType = paymentType;
    }
    public String getPaymentName() {
        return this.paymentName;
    }
    
    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
    public Set getInvoInvoiceMasters() {
        return this.invoInvoiceMasters;
    }
    
    public void setInvoInvoiceMasters(Set invoInvoiceMasters) {
        this.invoInvoiceMasters = invoInvoiceMasters;
    }
    public Set getPurContractMasters() {
        return this.purContractMasters;
    }
    
    public void setPurContractMasters(Set purContractMasters) {
        this.purContractMasters = purContractMasters;
    }




}

