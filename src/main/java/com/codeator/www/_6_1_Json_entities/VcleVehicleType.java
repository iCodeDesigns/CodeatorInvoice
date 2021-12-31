package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * VcleVehicleType generated by hbm2java
 */
public class VcleVehicleType  implements java.io.Serializable {


     private String vcleType;
     private String vcleTypeName;
     private Boolean licenseDgree;
     private Byte vcleLineVal;
     private Byte guestNo;
     private Boolean inspectPeriod;
     private Boolean licensePeriod;
     private Set vcleVehicleNotifyTranses = new HashSet(0);
     private Set vclePriceKilometers = new HashSet(0);
     private Set vcleVehicleResponsibleJoins = new HashSet(0);
     private Set vcleProcedureLicenseJoins = new HashSet(0);
     private Set vcleWorkTypeTransCars = new HashSet(0);
     private Set vcleTrafficLines = new HashSet(0);
     private Set vcleVehicleIncomes = new HashSet(0);
     private Set vcleVehicleMasters = new HashSet(0);
     private Set vcleVehicleModels = new HashSet(0);
     private Set vcleRecordMovements = new HashSet(0);
     private Set vcleVehicleClassDtls = new HashSet(0);
     private Set vcleTrafficPriceDateVals = new HashSet(0);
     private Set vcleVehicleRequires = new HashSet(0);
     private Set vcleVehicleLicenseReports = new HashSet(0);
     private Set vcleVehicleTransactionDtls = new HashSet(0);
     private Set vcleVehicleTypeUsers = new HashSet(0);
     private Set vcleWorkshopeResponses = new HashSet(0);
     private Set vcleFuelIssueLiquids = new HashSet(0);

    public VcleVehicleType() {
    }

	
    public VcleVehicleType(String vcleType, String vcleTypeName) {
        this.vcleType = vcleType;
        this.vcleTypeName = vcleTypeName;
    }
    public VcleVehicleType(String vcleType, String vcleTypeName, Boolean licenseDgree, Byte vcleLineVal, Byte guestNo, Boolean inspectPeriod, Boolean licensePeriod, Set vcleVehicleNotifyTranses, Set vclePriceKilometers, Set vcleVehicleResponsibleJoins, Set vcleProcedureLicenseJoins, Set vcleWorkTypeTransCars, Set vcleTrafficLines, Set vcleVehicleIncomes, Set vcleVehicleMasters, Set vcleVehicleModels, Set vcleRecordMovements, Set vcleVehicleClassDtls, Set vcleTrafficPriceDateVals, Set vcleVehicleRequires, Set vcleVehicleLicenseReports, Set vcleVehicleTransactionDtls, Set vcleVehicleTypeUsers, Set vcleWorkshopeResponses, Set vcleFuelIssueLiquids) {
       this.vcleType = vcleType;
       this.vcleTypeName = vcleTypeName;
       this.licenseDgree = licenseDgree;
       this.vcleLineVal = vcleLineVal;
       this.guestNo = guestNo;
       this.inspectPeriod = inspectPeriod;
       this.licensePeriod = licensePeriod;
       this.vcleVehicleNotifyTranses = vcleVehicleNotifyTranses;
       this.vclePriceKilometers = vclePriceKilometers;
       this.vcleVehicleResponsibleJoins = vcleVehicleResponsibleJoins;
       this.vcleProcedureLicenseJoins = vcleProcedureLicenseJoins;
       this.vcleWorkTypeTransCars = vcleWorkTypeTransCars;
       this.vcleTrafficLines = vcleTrafficLines;
       this.vcleVehicleIncomes = vcleVehicleIncomes;
       this.vcleVehicleMasters = vcleVehicleMasters;
       this.vcleVehicleModels = vcleVehicleModels;
       this.vcleRecordMovements = vcleRecordMovements;
       this.vcleVehicleClassDtls = vcleVehicleClassDtls;
       this.vcleTrafficPriceDateVals = vcleTrafficPriceDateVals;
       this.vcleVehicleRequires = vcleVehicleRequires;
       this.vcleVehicleLicenseReports = vcleVehicleLicenseReports;
       this.vcleVehicleTransactionDtls = vcleVehicleTransactionDtls;
       this.vcleVehicleTypeUsers = vcleVehicleTypeUsers;
       this.vcleWorkshopeResponses = vcleWorkshopeResponses;
       this.vcleFuelIssueLiquids = vcleFuelIssueLiquids;
    }
   
    public String getVcleType() {
        return this.vcleType;
    }
    
    public void setVcleType(String vcleType) {
        this.vcleType = vcleType;
    }
    public String getVcleTypeName() {
        return this.vcleTypeName;
    }
    
    public void setVcleTypeName(String vcleTypeName) {
        this.vcleTypeName = vcleTypeName;
    }
    public Boolean getLicenseDgree() {
        return this.licenseDgree;
    }
    
    public void setLicenseDgree(Boolean licenseDgree) {
        this.licenseDgree = licenseDgree;
    }
    public Byte getVcleLineVal() {
        return this.vcleLineVal;
    }
    
    public void setVcleLineVal(Byte vcleLineVal) {
        this.vcleLineVal = vcleLineVal;
    }
    public Byte getGuestNo() {
        return this.guestNo;
    }
    
    public void setGuestNo(Byte guestNo) {
        this.guestNo = guestNo;
    }
    public Boolean getInspectPeriod() {
        return this.inspectPeriod;
    }
    
    public void setInspectPeriod(Boolean inspectPeriod) {
        this.inspectPeriod = inspectPeriod;
    }
    public Boolean getLicensePeriod() {
        return this.licensePeriod;
    }
    
    public void setLicensePeriod(Boolean licensePeriod) {
        this.licensePeriod = licensePeriod;
    }
    public Set getVcleVehicleNotifyTranses() {
        return this.vcleVehicleNotifyTranses;
    }
    
    public void setVcleVehicleNotifyTranses(Set vcleVehicleNotifyTranses) {
        this.vcleVehicleNotifyTranses = vcleVehicleNotifyTranses;
    }
    public Set getVclePriceKilometers() {
        return this.vclePriceKilometers;
    }
    
    public void setVclePriceKilometers(Set vclePriceKilometers) {
        this.vclePriceKilometers = vclePriceKilometers;
    }
    public Set getVcleVehicleResponsibleJoins() {
        return this.vcleVehicleResponsibleJoins;
    }
    
    public void setVcleVehicleResponsibleJoins(Set vcleVehicleResponsibleJoins) {
        this.vcleVehicleResponsibleJoins = vcleVehicleResponsibleJoins;
    }
    public Set getVcleProcedureLicenseJoins() {
        return this.vcleProcedureLicenseJoins;
    }
    
    public void setVcleProcedureLicenseJoins(Set vcleProcedureLicenseJoins) {
        this.vcleProcedureLicenseJoins = vcleProcedureLicenseJoins;
    }
    public Set getVcleWorkTypeTransCars() {
        return this.vcleWorkTypeTransCars;
    }
    
    public void setVcleWorkTypeTransCars(Set vcleWorkTypeTransCars) {
        this.vcleWorkTypeTransCars = vcleWorkTypeTransCars;
    }
    public Set getVcleTrafficLines() {
        return this.vcleTrafficLines;
    }
    
    public void setVcleTrafficLines(Set vcleTrafficLines) {
        this.vcleTrafficLines = vcleTrafficLines;
    }
    public Set getVcleVehicleIncomes() {
        return this.vcleVehicleIncomes;
    }
    
    public void setVcleVehicleIncomes(Set vcleVehicleIncomes) {
        this.vcleVehicleIncomes = vcleVehicleIncomes;
    }
    public Set getVcleVehicleMasters() {
        return this.vcleVehicleMasters;
    }
    
    public void setVcleVehicleMasters(Set vcleVehicleMasters) {
        this.vcleVehicleMasters = vcleVehicleMasters;
    }
    public Set getVcleVehicleModels() {
        return this.vcleVehicleModels;
    }
    
    public void setVcleVehicleModels(Set vcleVehicleModels) {
        this.vcleVehicleModels = vcleVehicleModels;
    }
    public Set getVcleRecordMovements() {
        return this.vcleRecordMovements;
    }
    
    public void setVcleRecordMovements(Set vcleRecordMovements) {
        this.vcleRecordMovements = vcleRecordMovements;
    }
    public Set getVcleVehicleClassDtls() {
        return this.vcleVehicleClassDtls;
    }
    
    public void setVcleVehicleClassDtls(Set vcleVehicleClassDtls) {
        this.vcleVehicleClassDtls = vcleVehicleClassDtls;
    }
    public Set getVcleTrafficPriceDateVals() {
        return this.vcleTrafficPriceDateVals;
    }
    
    public void setVcleTrafficPriceDateVals(Set vcleTrafficPriceDateVals) {
        this.vcleTrafficPriceDateVals = vcleTrafficPriceDateVals;
    }
    public Set getVcleVehicleRequires() {
        return this.vcleVehicleRequires;
    }
    
    public void setVcleVehicleRequires(Set vcleVehicleRequires) {
        this.vcleVehicleRequires = vcleVehicleRequires;
    }
    public Set getVcleVehicleLicenseReports() {
        return this.vcleVehicleLicenseReports;
    }
    
    public void setVcleVehicleLicenseReports(Set vcleVehicleLicenseReports) {
        this.vcleVehicleLicenseReports = vcleVehicleLicenseReports;
    }
    public Set getVcleVehicleTransactionDtls() {
        return this.vcleVehicleTransactionDtls;
    }
    
    public void setVcleVehicleTransactionDtls(Set vcleVehicleTransactionDtls) {
        this.vcleVehicleTransactionDtls = vcleVehicleTransactionDtls;
    }
    public Set getVcleVehicleTypeUsers() {
        return this.vcleVehicleTypeUsers;
    }
    
    public void setVcleVehicleTypeUsers(Set vcleVehicleTypeUsers) {
        this.vcleVehicleTypeUsers = vcleVehicleTypeUsers;
    }
    public Set getVcleWorkshopeResponses() {
        return this.vcleWorkshopeResponses;
    }
    
    public void setVcleWorkshopeResponses(Set vcleWorkshopeResponses) {
        this.vcleWorkshopeResponses = vcleWorkshopeResponses;
    }
    public Set getVcleFuelIssueLiquids() {
        return this.vcleFuelIssueLiquids;
    }
    
    public void setVcleFuelIssueLiquids(Set vcleFuelIssueLiquids) {
        this.vcleFuelIssueLiquids = vcleFuelIssueLiquids;
    }




}


