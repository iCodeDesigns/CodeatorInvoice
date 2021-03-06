package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * InvoTaxTokenServerStatus generated by hbm2java
 */
public class InvoTaxTokenServerStatus  implements java.io.Serializable {


     private short serverSeq;
     private String taxStatus;
     private String tokenStatus;
     private String signAppStatus;

    public InvoTaxTokenServerStatus() {
    }

	
    public InvoTaxTokenServerStatus(short serverSeq) {
        this.serverSeq = serverSeq;
    }
    public InvoTaxTokenServerStatus(short serverSeq, String taxStatus, String tokenStatus, String signAppStatus) {
       this.serverSeq = serverSeq;
       this.taxStatus = taxStatus;
       this.tokenStatus = tokenStatus;
       this.signAppStatus = signAppStatus;
    }
   
    public short getServerSeq() {
        return this.serverSeq;
    }
    
    public void setServerSeq(short serverSeq) {
        this.serverSeq = serverSeq;
    }
    public String getTaxStatus() {
        return this.taxStatus;
    }
    
    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }
    public String getTokenStatus() {
        return this.tokenStatus;
    }
    
    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }
    public String getSignAppStatus() {
        return this.signAppStatus;
    }
    
    public void setSignAppStatus(String signAppStatus) {
        this.signAppStatus = signAppStatus;
    }




}


