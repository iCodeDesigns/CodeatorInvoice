package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * VcleIssueDocumentFin generated by hbm2java
 */
public class VcleIssueDocumentFin  implements java.io.Serializable {


     private VcleIssueDocumentFinId id;
     private AccCurrencyCode accCurrencyCode;
     private PerOrganizationStructure perOrganizationStructure;
     private String accountUnitCode;
     private Long issueDocSerial;
     private Date issueDocDate;
     private String issueType;
     private BigDecimal editorUserId;
     private String issueDocStatus;
     private BigDecimal vcDeserveValue;
     private BigDecimal vcCutValue;
     private String vcDeserveNotes;
     private String vcDeserveName;
     private Short vcDeserveDocCount;
     private String vcIssueDocType;
     private String sectionNoVcle;
     private Set vcleTravelExchanges = new HashSet(0);
     private Set vcleIssueDocumentFinTypes = new HashSet(0);

    public VcleIssueDocumentFin() {
    }

	
    public VcleIssueDocumentFin(VcleIssueDocumentFinId id) {
        this.id = id;
    }
    public VcleIssueDocumentFin(VcleIssueDocumentFinId id, AccCurrencyCode accCurrencyCode, PerOrganizationStructure perOrganizationStructure, String accountUnitCode, Long issueDocSerial, Date issueDocDate, String issueType, BigDecimal editorUserId, String issueDocStatus, BigDecimal vcDeserveValue, BigDecimal vcCutValue, String vcDeserveNotes, String vcDeserveName, Short vcDeserveDocCount, String vcIssueDocType, String sectionNoVcle, Set vcleTravelExchanges, Set vcleIssueDocumentFinTypes) {
       this.id = id;
       this.accCurrencyCode = accCurrencyCode;
       this.perOrganizationStructure = perOrganizationStructure;
       this.accountUnitCode = accountUnitCode;
       this.issueDocSerial = issueDocSerial;
       this.issueDocDate = issueDocDate;
       this.issueType = issueType;
       this.editorUserId = editorUserId;
       this.issueDocStatus = issueDocStatus;
       this.vcDeserveValue = vcDeserveValue;
       this.vcCutValue = vcCutValue;
       this.vcDeserveNotes = vcDeserveNotes;
       this.vcDeserveName = vcDeserveName;
       this.vcDeserveDocCount = vcDeserveDocCount;
       this.vcIssueDocType = vcIssueDocType;
       this.sectionNoVcle = sectionNoVcle;
       this.vcleTravelExchanges = vcleTravelExchanges;
       this.vcleIssueDocumentFinTypes = vcleIssueDocumentFinTypes;
    }
   
    public VcleIssueDocumentFinId getId() {
        return this.id;
    }
    
    public void setId(VcleIssueDocumentFinId id) {
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
    public String getAccountUnitCode() {
        return this.accountUnitCode;
    }
    
    public void setAccountUnitCode(String accountUnitCode) {
        this.accountUnitCode = accountUnitCode;
    }
    public Long getIssueDocSerial() {
        return this.issueDocSerial;
    }
    
    public void setIssueDocSerial(Long issueDocSerial) {
        this.issueDocSerial = issueDocSerial;
    }
    public Date getIssueDocDate() {
        return this.issueDocDate;
    }
    
    public void setIssueDocDate(Date issueDocDate) {
        this.issueDocDate = issueDocDate;
    }
    public String getIssueType() {
        return this.issueType;
    }
    
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }
    public BigDecimal getEditorUserId() {
        return this.editorUserId;
    }
    
    public void setEditorUserId(BigDecimal editorUserId) {
        this.editorUserId = editorUserId;
    }
    public String getIssueDocStatus() {
        return this.issueDocStatus;
    }
    
    public void setIssueDocStatus(String issueDocStatus) {
        this.issueDocStatus = issueDocStatus;
    }
    public BigDecimal getVcDeserveValue() {
        return this.vcDeserveValue;
    }
    
    public void setVcDeserveValue(BigDecimal vcDeserveValue) {
        this.vcDeserveValue = vcDeserveValue;
    }
    public BigDecimal getVcCutValue() {
        return this.vcCutValue;
    }
    
    public void setVcCutValue(BigDecimal vcCutValue) {
        this.vcCutValue = vcCutValue;
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
    public Short getVcDeserveDocCount() {
        return this.vcDeserveDocCount;
    }
    
    public void setVcDeserveDocCount(Short vcDeserveDocCount) {
        this.vcDeserveDocCount = vcDeserveDocCount;
    }
    public String getVcIssueDocType() {
        return this.vcIssueDocType;
    }
    
    public void setVcIssueDocType(String vcIssueDocType) {
        this.vcIssueDocType = vcIssueDocType;
    }
    public String getSectionNoVcle() {
        return this.sectionNoVcle;
    }
    
    public void setSectionNoVcle(String sectionNoVcle) {
        this.sectionNoVcle = sectionNoVcle;
    }
    public Set getVcleTravelExchanges() {
        return this.vcleTravelExchanges;
    }
    
    public void setVcleTravelExchanges(Set vcleTravelExchanges) {
        this.vcleTravelExchanges = vcleTravelExchanges;
    }
    public Set getVcleIssueDocumentFinTypes() {
        return this.vcleIssueDocumentFinTypes;
    }
    
    public void setVcleIssueDocumentFinTypes(Set vcleIssueDocumentFinTypes) {
        this.vcleIssueDocumentFinTypes = vcleIssueDocumentFinTypes;
    }




}


