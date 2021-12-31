package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * VcleIssueDocumentLiq generated by hbm2java
 */
public class VcleIssueDocumentLiq  implements java.io.Serializable {


     private VcleIssueDocumentLiqId id;
     private AccCurrencyCode accCurrencyCode;
     private PerOrganizationStructure perOrganizationStructure;
     private PerEmploymentMaster perEmploymentMaster;
     private Long issueDocSerial;
     private BigDecimal editorUserId;
     private Boolean actionPlace;
     private String issueType;
     private String issueDocStatus;
     private Date issueDocDate;
     private String vcIssueDocType;
     private BigDecimal vcCutValue;
     private Short vcDeserveDocCount;
     private String vcDeserveNotes;
     private String vcDeserveName;
     private BigDecimal vcDeserveValue;
     private String accountUnitCode;
     private Set vcleVehicleInvoiceLiqs = new HashSet(0);

    public VcleIssueDocumentLiq() {
    }

	
    public VcleIssueDocumentLiq(VcleIssueDocumentLiqId id) {
        this.id = id;
    }
    public VcleIssueDocumentLiq(VcleIssueDocumentLiqId id, AccCurrencyCode accCurrencyCode, PerOrganizationStructure perOrganizationStructure, PerEmploymentMaster perEmploymentMaster, Long issueDocSerial, BigDecimal editorUserId, Boolean actionPlace, String issueType, String issueDocStatus, Date issueDocDate, String vcIssueDocType, BigDecimal vcCutValue, Short vcDeserveDocCount, String vcDeserveNotes, String vcDeserveName, BigDecimal vcDeserveValue, String accountUnitCode, Set vcleVehicleInvoiceLiqs) {
       this.id = id;
       this.accCurrencyCode = accCurrencyCode;
       this.perOrganizationStructure = perOrganizationStructure;
       this.perEmploymentMaster = perEmploymentMaster;
       this.issueDocSerial = issueDocSerial;
       this.editorUserId = editorUserId;
       this.actionPlace = actionPlace;
       this.issueType = issueType;
       this.issueDocStatus = issueDocStatus;
       this.issueDocDate = issueDocDate;
       this.vcIssueDocType = vcIssueDocType;
       this.vcCutValue = vcCutValue;
       this.vcDeserveDocCount = vcDeserveDocCount;
       this.vcDeserveNotes = vcDeserveNotes;
       this.vcDeserveName = vcDeserveName;
       this.vcDeserveValue = vcDeserveValue;
       this.accountUnitCode = accountUnitCode;
       this.vcleVehicleInvoiceLiqs = vcleVehicleInvoiceLiqs;
    }
   
    public VcleIssueDocumentLiqId getId() {
        return this.id;
    }
    
    public void setId(VcleIssueDocumentLiqId id) {
        this.id = id;
    }
    public AccCurrencyCode getAccCurrencyCode() {
        return this.accCurrencyCode;
    }
    
    public void setAccCurrencyCode(AccCurrencyCode accCurrencyCode) {
        this.accCurrencyCode = accCurrencyCode;
    }
    public PerOrganizationStructure getPerOrganizationStructure() {
        return this.perOrganizationStructure;
    }
    
    public void setPerOrganizationStructure(PerOrganizationStructure perOrganizationStructure) {
        this.perOrganizationStructure = perOrganizationStructure;
    }
    public PerEmploymentMaster getPerEmploymentMaster() {
        return this.perEmploymentMaster;
    }
    
    public void setPerEmploymentMaster(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }
    public Long getIssueDocSerial() {
        return this.issueDocSerial;
    }
    
    public void setIssueDocSerial(Long issueDocSerial) {
        this.issueDocSerial = issueDocSerial;
    }
    public BigDecimal getEditorUserId() {
        return this.editorUserId;
    }
    
    public void setEditorUserId(BigDecimal editorUserId) {
        this.editorUserId = editorUserId;
    }
    public Boolean getActionPlace() {
        return this.actionPlace;
    }
    
    public void setActionPlace(Boolean actionPlace) {
        this.actionPlace = actionPlace;
    }
    public String getIssueType() {
        return this.issueType;
    }
    
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }
    public String getIssueDocStatus() {
        return this.issueDocStatus;
    }
    
    public void setIssueDocStatus(String issueDocStatus) {
        this.issueDocStatus = issueDocStatus;
    }
    public Date getIssueDocDate() {
        return this.issueDocDate;
    }
    
    public void setIssueDocDate(Date issueDocDate) {
        this.issueDocDate = issueDocDate;
    }
    public String getVcIssueDocType() {
        return this.vcIssueDocType;
    }
    
    public void setVcIssueDocType(String vcIssueDocType) {
        this.vcIssueDocType = vcIssueDocType;
    }
    public BigDecimal getVcCutValue() {
        return this.vcCutValue;
    }
    
    public void setVcCutValue(BigDecimal vcCutValue) {
        this.vcCutValue = vcCutValue;
    }
    public Short getVcDeserveDocCount() {
        return this.vcDeserveDocCount;
    }
    
    public void setVcDeserveDocCount(Short vcDeserveDocCount) {
        this.vcDeserveDocCount = vcDeserveDocCount;
    }
    public String getVcDeserveNotes() {
        return this.vcDeserveNotes;
    }
    
    public void setVcDeserveNotes(String vcDeserveNotes) {
        this.vcDeserveNotes = vcDeserveNotes;
    }
    public String getVcDeserveName() {
        return this.vcDeserveName;
    }
    
    public void setVcDeserveName(String vcDeserveName) {
        this.vcDeserveName = vcDeserveName;
    }
    public BigDecimal getVcDeserveValue() {
        return this.vcDeserveValue;
    }
    
    public void setVcDeserveValue(BigDecimal vcDeserveValue) {
        this.vcDeserveValue = vcDeserveValue;
    }
    public String getAccountUnitCode() {
        return this.accountUnitCode;
    }
    
    public void setAccountUnitCode(String accountUnitCode) {
        this.accountUnitCode = accountUnitCode;
    }
    public Set getVcleVehicleInvoiceLiqs() {
        return this.vcleVehicleInvoiceLiqs;
    }
    
    public void setVcleVehicleInvoiceLiqs(Set vcleVehicleInvoiceLiqs) {
        this.vcleVehicleInvoiceLiqs = vcleVehicleInvoiceLiqs;
    }




}


