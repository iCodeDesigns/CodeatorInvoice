package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * VcleVehicleTransaction generated by hbm2java
 */
public class VcleVehicleTransaction  implements java.io.Serializable {


     private byte transType;
     private String transName;
     private Set vcleVehicleTransactionDtls = new HashSet(0);
     private Set vcleVehicleResponsibles = new HashSet(0);

    public VcleVehicleTransaction() {
    }

	
    public VcleVehicleTransaction(byte transType, String transName) {
        this.transType = transType;
        this.transName = transName;
    }
    public VcleVehicleTransaction(byte transType, String transName, Set vcleVehicleTransactionDtls, Set vcleVehicleResponsibles) {
       this.transType = transType;
       this.transName = transName;
       this.vcleVehicleTransactionDtls = vcleVehicleTransactionDtls;
       this.vcleVehicleResponsibles = vcleVehicleResponsibles;
    }
   
    public byte getTransType() {
        return this.transType;
    }
    
    public void setTransType(byte transType) {
        this.transType = transType;
    }
    public String getTransName() {
        return this.transName;
    }
    
    public void setTransName(String transName) {
        this.transName = transName;
    }
    public Set getVcleVehicleTransactionDtls() {
        return this.vcleVehicleTransactionDtls;
    }
    
    public void setVcleVehicleTransactionDtls(Set vcleVehicleTransactionDtls) {
        this.vcleVehicleTransactionDtls = vcleVehicleTransactionDtls;
    }
    public Set getVcleVehicleResponsibles() {
        return this.vcleVehicleResponsibles;
    }
    
    public void setVcleVehicleResponsibles(Set vcleVehicleResponsibles) {
        this.vcleVehicleResponsibles = vcleVehicleResponsibles;
    }




}


