package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * VcleCostType generated by hbm2java
 */
public class VcleCostType  implements java.io.Serializable {


     private VcleCostTypeId id;
     private String costName;
     private BigDecimal val;
     private Boolean costState;
     private String issueDocTypeName;
     private Byte issueDocFor;
     private String issueDocType;
     private Boolean actionPlace;
     private Set vcleProcedureLicenseJoins = new HashSet(0);
     private Set vcleVehicleInvoiceMans = new HashSet(0);
     private Set vcleVehicleInvoiceLiqs = new HashSet(0);
     private Set vcleTravelExchanges = new HashSet(0);
     private Set vcleVehicleLicenseReportDts = new HashSet(0);
     private Set vcleVehicleInspectDtls = new HashSet(0);
     private Set vcleVehicleLicenseDtls = new HashSet(0);

    public VcleCostType() {
    }

	
    public VcleCostType(VcleCostTypeId id, String costName) {
        this.id = id;
        this.costName = costName;
    }
    public VcleCostType(VcleCostTypeId id, String costName, BigDecimal val, Boolean costState, String issueDocTypeName, Byte issueDocFor, String issueDocType, Boolean actionPlace, Set vcleProcedureLicenseJoins, Set vcleVehicleInvoiceMans, Set vcleVehicleInvoiceLiqs, Set vcleTravelExchanges, Set vcleVehicleLicenseReportDts, Set vcleVehicleInspectDtls, Set vcleVehicleLicenseDtls) {
       this.id = id;
       this.costName = costName;
       this.val = val;
       this.costState = costState;
       this.issueDocTypeName = issueDocTypeName;
       this.issueDocFor = issueDocFor;
       this.issueDocType = issueDocType;
       this.actionPlace = actionPlace;
       this.vcleProcedureLicenseJoins = vcleProcedureLicenseJoins;
       this.vcleVehicleInvoiceMans = vcleVehicleInvoiceMans;
       this.vcleVehicleInvoiceLiqs = vcleVehicleInvoiceLiqs;
       this.vcleTravelExchanges = vcleTravelExchanges;
       this.vcleVehicleLicenseReportDts = vcleVehicleLicenseReportDts;
       this.vcleVehicleInspectDtls = vcleVehicleInspectDtls;
       this.vcleVehicleLicenseDtls = vcleVehicleLicenseDtls;
    }
   
    public VcleCostTypeId getId() {
        return this.id;
    }
    
    public void setId(VcleCostTypeId id) {
        this.id = id;
    }
    public String getCostName() {
        return this.costName;
    }
    
    public void setCostName(String costName) {
        this.costName = costName;
    }
    public BigDecimal getVal() {
        return this.val;
    }
    
    public void setVal(BigDecimal val) {
        this.val = val;
    }
    public Boolean getCostState() {
        return this.costState;
    }
    
    public void setCostState(Boolean costState) {
        this.costState = costState;
    }
    public String getIssueDocTypeName() {
        return this.issueDocTypeName;
    }
    
    public void setIssueDocTypeName(String issueDocTypeName) {
        this.issueDocTypeName = issueDocTypeName;
    }
    public Byte getIssueDocFor() {
        return this.issueDocFor;
    }
    
    public void setIssueDocFor(Byte issueDocFor) {
        this.issueDocFor = issueDocFor;
    }
    public String getIssueDocType() {
        return this.issueDocType;
    }
    
    public void setIssueDocType(String issueDocType) {
        this.issueDocType = issueDocType;
    }
    public Boolean getActionPlace() {
        return this.actionPlace;
    }
    
    public void setActionPlace(Boolean actionPlace) {
        this.actionPlace = actionPlace;
    }
    public Set getVcleProcedureLicenseJoins() {
        return this.vcleProcedureLicenseJoins;
    }
    
    public void setVcleProcedureLicenseJoins(Set vcleProcedureLicenseJoins) {
        this.vcleProcedureLicenseJoins = vcleProcedureLicenseJoins;
    }
    public Set getVcleVehicleInvoiceMans() {
        return this.vcleVehicleInvoiceMans;
    }
    
    public void setVcleVehicleInvoiceMans(Set vcleVehicleInvoiceMans) {
        this.vcleVehicleInvoiceMans = vcleVehicleInvoiceMans;
    }
    public Set getVcleVehicleInvoiceLiqs() {
        return this.vcleVehicleInvoiceLiqs;
    }
    
    public void setVcleVehicleInvoiceLiqs(Set vcleVehicleInvoiceLiqs) {
        this.vcleVehicleInvoiceLiqs = vcleVehicleInvoiceLiqs;
    }
    public Set getVcleTravelExchanges() {
        return this.vcleTravelExchanges;
    }
    
    public void setVcleTravelExchanges(Set vcleTravelExchanges) {
        this.vcleTravelExchanges = vcleTravelExchanges;
    }
    public Set getVcleVehicleLicenseReportDts() {
        return this.vcleVehicleLicenseReportDts;
    }
    
    public void setVcleVehicleLicenseReportDts(Set vcleVehicleLicenseReportDts) {
        this.vcleVehicleLicenseReportDts = vcleVehicleLicenseReportDts;
    }
    public Set getVcleVehicleInspectDtls() {
        return this.vcleVehicleInspectDtls;
    }
    
    public void setVcleVehicleInspectDtls(Set vcleVehicleInspectDtls) {
        this.vcleVehicleInspectDtls = vcleVehicleInspectDtls;
    }
    public Set getVcleVehicleLicenseDtls() {
        return this.vcleVehicleLicenseDtls;
    }
    
    public void setVcleVehicleLicenseDtls(Set vcleVehicleLicenseDtls) {
        this.vcleVehicleLicenseDtls = vcleVehicleLicenseDtls;
    }




}


