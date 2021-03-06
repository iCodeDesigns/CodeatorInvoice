package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PerGovernorateCode generated by hbm2java
 */
public class PerGovernorateCode  implements java.io.Serializable {


     private PerGovernorateCodeId id;
     private PerCountryCode perCountryCode;
     private String AGovName;
     private String EGovName;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set invoInvoiceMasters = new HashSet(0);
     private Set vcleRecordMovements = new HashSet(0);
     private Set vcleTravelExchanges = new HashSet(0);
     private Set vcleTrafficCodes = new HashSet(0);
     private Set purSuppWorks = new HashSet(0);
     private Set vcleVehicleIncomes = new HashSet(0);
     private Set perCityCodes = new HashSet(0);
     private Set perLocationCodes = new HashSet(0);

    public PerGovernorateCode() {
    }

	
    public PerGovernorateCode(PerGovernorateCodeId id, PerCountryCode perCountryCode, String AGovName) {
        this.id = id;
        this.perCountryCode = perCountryCode;
        this.AGovName = AGovName;
    }
    public PerGovernorateCode(PerGovernorateCodeId id, PerCountryCode perCountryCode, String AGovName, String EGovName, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set invoInvoiceMasters, Set vcleRecordMovements, Set vcleTravelExchanges, Set vcleTrafficCodes, Set purSuppWorks, Set vcleVehicleIncomes, Set perCityCodes, Set perLocationCodes) {
       this.id = id;
       this.perCountryCode = perCountryCode;
       this.AGovName = AGovName;
       this.EGovName = EGovName;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.invoInvoiceMasters = invoInvoiceMasters;
       this.vcleRecordMovements = vcleRecordMovements;
       this.vcleTravelExchanges = vcleTravelExchanges;
       this.vcleTrafficCodes = vcleTrafficCodes;
       this.purSuppWorks = purSuppWorks;
       this.vcleVehicleIncomes = vcleVehicleIncomes;
       this.perCityCodes = perCityCodes;
       this.perLocationCodes = perLocationCodes;
    }
   
    public PerGovernorateCodeId getId() {
        return this.id;
    }
    
    public void setId(PerGovernorateCodeId id) {
        this.id = id;
    }
    public PerCountryCode getPerCountryCode() {
        return this.perCountryCode;
    }
    
    public void setPerCountryCode(PerCountryCode perCountryCode) {
        this.perCountryCode = perCountryCode;
    }
    public String getAGovName() {
        return this.AGovName;
    }
    
    public void setAGovName(String AGovName) {
        this.AGovName = AGovName;
    }
    public String getEGovName() {
        return this.EGovName;
    }
    
    public void setEGovName(String EGovName) {
        this.EGovName = EGovName;
    }
    public String getRecordCreateUser() {
        return this.recordCreateUser;
    }
    
    public void setRecordCreateUser(String recordCreateUser) {
        this.recordCreateUser = recordCreateUser;
    }
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }
    public String getRecordUpdateUser() {
        return this.recordUpdateUser;
    }
    
    public void setRecordUpdateUser(String recordUpdateUser) {
        this.recordUpdateUser = recordUpdateUser;
    }
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }
    public Set getInvoInvoiceMasters() {
        return this.invoInvoiceMasters;
    }
    
    public void setInvoInvoiceMasters(Set invoInvoiceMasters) {
        this.invoInvoiceMasters = invoInvoiceMasters;
    }
    public Set getVcleRecordMovements() {
        return this.vcleRecordMovements;
    }
    
    public void setVcleRecordMovements(Set vcleRecordMovements) {
        this.vcleRecordMovements = vcleRecordMovements;
    }
    public Set getVcleTravelExchanges() {
        return this.vcleTravelExchanges;
    }
    
    public void setVcleTravelExchanges(Set vcleTravelExchanges) {
        this.vcleTravelExchanges = vcleTravelExchanges;
    }
    public Set getVcleTrafficCodes() {
        return this.vcleTrafficCodes;
    }
    
    public void setVcleTrafficCodes(Set vcleTrafficCodes) {
        this.vcleTrafficCodes = vcleTrafficCodes;
    }
    public Set getPurSuppWorks() {
        return this.purSuppWorks;
    }
    
    public void setPurSuppWorks(Set purSuppWorks) {
        this.purSuppWorks = purSuppWorks;
    }
    public Set getVcleVehicleIncomes() {
        return this.vcleVehicleIncomes;
    }
    
    public void setVcleVehicleIncomes(Set vcleVehicleIncomes) {
        this.vcleVehicleIncomes = vcleVehicleIncomes;
    }
    public Set getPerCityCodes() {
        return this.perCityCodes;
    }
    
    public void setPerCityCodes(Set perCityCodes) {
        this.perCityCodes = perCityCodes;
    }
    public Set getPerLocationCodes() {
        return this.perLocationCodes;
    }
    
    public void setPerLocationCodes(Set perLocationCodes) {
        this.perLocationCodes = perLocationCodes;
    }




}


