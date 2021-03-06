package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PerLocationCode generated by hbm2java
 */
public class PerLocationCode  implements java.io.Serializable {


     private PerLocationCodeId id;
     private PerGovernorateCode perGovernorateCode;
     private String locName;
     private String locFax;
     private String locTel;
     private String locAddress;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set vcleEmployeeMasters = new HashSet(0);
     private Set perDeptPlaces = new HashSet(0);
     private Set perEmploymentMasters = new HashSet(0);
     private Set stoResponsibilityDepts = new HashSet(0);
     private Set vcleRecordMovements = new HashSet(0);
     private Set vcleVehicleIncomes = new HashSet(0);
     private Set vcleVehicleClassDtls = new HashSet(0);

    public PerLocationCode() {
    }

	
    public PerLocationCode(PerLocationCodeId id, String locName) {
        this.id = id;
        this.locName = locName;
    }
    public PerLocationCode(PerLocationCodeId id, PerGovernorateCode perGovernorateCode, String locName, String locFax, String locTel, String locAddress, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set vcleEmployeeMasters, Set perDeptPlaces, Set perEmploymentMasters, Set stoResponsibilityDepts, Set vcleRecordMovements, Set vcleVehicleIncomes, Set vcleVehicleClassDtls) {
       this.id = id;
       this.perGovernorateCode = perGovernorateCode;
       this.locName = locName;
       this.locFax = locFax;
       this.locTel = locTel;
       this.locAddress = locAddress;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.vcleEmployeeMasters = vcleEmployeeMasters;
       this.perDeptPlaces = perDeptPlaces;
       this.perEmploymentMasters = perEmploymentMasters;
       this.stoResponsibilityDepts = stoResponsibilityDepts;
       this.vcleRecordMovements = vcleRecordMovements;
       this.vcleVehicleIncomes = vcleVehicleIncomes;
       this.vcleVehicleClassDtls = vcleVehicleClassDtls;
    }
   
    public PerLocationCodeId getId() {
        return this.id;
    }
    
    public void setId(PerLocationCodeId id) {
        this.id = id;
    }
    public PerGovernorateCode getPerGovernorateCode() {
        return this.perGovernorateCode;
    }
    
    public void setPerGovernorateCode(PerGovernorateCode perGovernorateCode) {
        this.perGovernorateCode = perGovernorateCode;
    }
    public String getLocName() {
        return this.locName;
    }
    
    public void setLocName(String locName) {
        this.locName = locName;
    }
    public String getLocFax() {
        return this.locFax;
    }
    
    public void setLocFax(String locFax) {
        this.locFax = locFax;
    }
    public String getLocTel() {
        return this.locTel;
    }
    
    public void setLocTel(String locTel) {
        this.locTel = locTel;
    }
    public String getLocAddress() {
        return this.locAddress;
    }
    
    public void setLocAddress(String locAddress) {
        this.locAddress = locAddress;
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
    public Set getVcleEmployeeMasters() {
        return this.vcleEmployeeMasters;
    }
    
    public void setVcleEmployeeMasters(Set vcleEmployeeMasters) {
        this.vcleEmployeeMasters = vcleEmployeeMasters;
    }
    public Set getPerDeptPlaces() {
        return this.perDeptPlaces;
    }
    
    public void setPerDeptPlaces(Set perDeptPlaces) {
        this.perDeptPlaces = perDeptPlaces;
    }
    public Set getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(Set perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }
    public Set getStoResponsibilityDepts() {
        return this.stoResponsibilityDepts;
    }
    
    public void setStoResponsibilityDepts(Set stoResponsibilityDepts) {
        this.stoResponsibilityDepts = stoResponsibilityDepts;
    }
    public Set getVcleRecordMovements() {
        return this.vcleRecordMovements;
    }
    
    public void setVcleRecordMovements(Set vcleRecordMovements) {
        this.vcleRecordMovements = vcleRecordMovements;
    }
    public Set getVcleVehicleIncomes() {
        return this.vcleVehicleIncomes;
    }
    
    public void setVcleVehicleIncomes(Set vcleVehicleIncomes) {
        this.vcleVehicleIncomes = vcleVehicleIncomes;
    }
    public Set getVcleVehicleClassDtls() {
        return this.vcleVehicleClassDtls;
    }
    
    public void setVcleVehicleClassDtls(Set vcleVehicleClassDtls) {
        this.vcleVehicleClassDtls = vcleVehicleClassDtls;
    }




}


