package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * VcleInsuranceCompany generated by hbm2java
 */
public class VcleInsuranceCompany  implements java.io.Serializable {


     private byte companyCode;
     private String icompanyName;
     private Set vcleVehicleLicenses = new HashSet(0);

    public VcleInsuranceCompany() {
    }

	
    public VcleInsuranceCompany(byte companyCode, String icompanyName) {
        this.companyCode = companyCode;
        this.icompanyName = icompanyName;
    }
    public VcleInsuranceCompany(byte companyCode, String icompanyName, Set vcleVehicleLicenses) {
       this.companyCode = companyCode;
       this.icompanyName = icompanyName;
       this.vcleVehicleLicenses = vcleVehicleLicenses;
    }
   
    public byte getCompanyCode() {
        return this.companyCode;
    }
    
    public void setCompanyCode(byte companyCode) {
        this.companyCode = companyCode;
    }
    public String getIcompanyName() {
        return this.icompanyName;
    }
    
    public void setIcompanyName(String icompanyName) {
        this.icompanyName = icompanyName;
    }
    public Set getVcleVehicleLicenses() {
        return this.vcleVehicleLicenses;
    }
    
    public void setVcleVehicleLicenses(Set vcleVehicleLicenses) {
        this.vcleVehicleLicenses = vcleVehicleLicenses;
    }




}

