package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleIssueDocumentLin generated by hbm2java
 */
@Entity
@Table(name="VCLE_ISSUE_DOCUMENT_LIN"
    ,schema="CODEATOR"
)
public class VcleIssueDocumentLin  implements java.io.Serializable {


     private VcleIssueDocumentLinId id;
     private PerOrganizationStructure perOrganizationStructure;
     private String currencyCode;
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
     private Date execMm;
     private Integer vcIssueDocSeq;
     private Set<VcleVehicleLicenseReport> vcleVehicleLicenseReports = new HashSet<VcleVehicleLicenseReport>(0);
     private Set<VcleIssueDocumentLinType> vcleIssueDocumentLinTypes = new HashSet<VcleIssueDocumentLinType>(0);

    public VcleIssueDocumentLin() {
    }

	
    public VcleIssueDocumentLin(VcleIssueDocumentLinId id) {
        this.id = id;
    }
    public VcleIssueDocumentLin(VcleIssueDocumentLinId id, PerOrganizationStructure perOrganizationStructure, String currencyCode, String accountUnitCode, Long issueDocSerial, Date issueDocDate, String issueType, BigDecimal editorUserId, String issueDocStatus, BigDecimal vcDeserveValue, BigDecimal vcCutValue, String vcDeserveNotes, String vcDeserveName, Short vcDeserveDocCount, String vcIssueDocType, Date execMm, Integer vcIssueDocSeq, Set<VcleVehicleLicenseReport> vcleVehicleLicenseReports, Set<VcleIssueDocumentLinType> vcleIssueDocumentLinTypes) {
       this.id = id;
       this.perOrganizationStructure = perOrganizationStructure;
       this.currencyCode = currencyCode;
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
       this.execMm = execMm;
       this.vcIssueDocSeq = vcIssueDocSeq;
       this.vcleVehicleLicenseReports = vcleVehicleLicenseReports;
       this.vcleIssueDocumentLinTypes = vcleIssueDocumentLinTypes;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="fiscalYear", column=@Column(name="FISCAL_YEAR", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="vcIssueDocSp", column=@Column(name="VC_ISSUE_DOC_SP", nullable=false, precision=12, scale=0) ) } )
    public VcleIssueDocumentLinId getId() {
        return this.id;
    }
    
    public void setId(VcleIssueDocumentLinId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ORG_ID")
    public PerOrganizationStructure getPerOrganizationStructure() {
        return this.perOrganizationStructure;
    }
    
    public void setPerOrganizationStructure(PerOrganizationStructure perOrganizationStructure) {
        this.perOrganizationStructure = perOrganizationStructure;
    }

    
    @Column(name="CURRENCY_CODE", length=4)
    public String getCurrencyCode() {
        return this.currencyCode;
    }
    
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    
    @Column(name="ACCOUNT_UNIT_CODE", length=4)
    public String getAccountUnitCode() {
        return this.accountUnitCode;
    }
    
    public void setAccountUnitCode(String accountUnitCode) {
        this.accountUnitCode = accountUnitCode;
    }

    
    @Column(name="ISSUE_DOC_SERIAL", precision=12, scale=0)
    public Long getIssueDocSerial() {
        return this.issueDocSerial;
    }
    
    public void setIssueDocSerial(Long issueDocSerial) {
        this.issueDocSerial = issueDocSerial;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ISSUE_DOC_DATE", length=7)
    public Date getIssueDocDate() {
        return this.issueDocDate;
    }
    
    public void setIssueDocDate(Date issueDocDate) {
        this.issueDocDate = issueDocDate;
    }

    
    @Column(name="ISSUE_TYPE", length=2)
    public String getIssueType() {
        return this.issueType;
    }
    
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    
    @Column(name="EDITOR_USER_ID", precision=22, scale=0)
    public BigDecimal getEditorUserId() {
        return this.editorUserId;
    }
    
    public void setEditorUserId(BigDecimal editorUserId) {
        this.editorUserId = editorUserId;
    }

    
    @Column(name="ISSUE_DOC_STATUS", length=2)
    public String getIssueDocStatus() {
        return this.issueDocStatus;
    }
    
    public void setIssueDocStatus(String issueDocStatus) {
        this.issueDocStatus = issueDocStatus;
    }

    
    @Column(name="VC_DESERVE_VALUE", precision=16, scale=3)
    public BigDecimal getVcDeserveValue() {
        return this.vcDeserveValue;
    }
    
    public void setVcDeserveValue(BigDecimal vcDeserveValue) {
        this.vcDeserveValue = vcDeserveValue;
    }

    
    @Column(name="VC_CUT_VALUE", precision=16, scale=3)
    public BigDecimal getVcCutValue() {
        return this.vcCutValue;
    }
    
    public void setVcCutValue(BigDecimal vcCutValue) {
        this.vcCutValue = vcCutValue;
    }

    
    @Column(name="VC_DESERVE_NOTES", length=100)
    public String getVcDeserveNotes() {
        return this.vcDeserveNotes;
    }
    
    public void setVcDeserveNotes(String vcDeserveNotes) {
        this.vcDeserveNotes = vcDeserveNotes;
    }

    
    @Column(name="VC_DESERVE_NAME", length=150)
    public String getVcDeserveName() {
        return this.vcDeserveName;
    }
    
    public void setVcDeserveName(String vcDeserveName) {
        this.vcDeserveName = vcDeserveName;
    }

    
    @Column(name="VC_DESERVE_DOC_COUNT", precision=3, scale=0)
    public Short getVcDeserveDocCount() {
        return this.vcDeserveDocCount;
    }
    
    public void setVcDeserveDocCount(Short vcDeserveDocCount) {
        this.vcDeserveDocCount = vcDeserveDocCount;
    }

    
    @Column(name="VC_ISSUE_DOC_TYPE", length=5)
    public String getVcIssueDocType() {
        return this.vcIssueDocType;
    }
    
    public void setVcIssueDocType(String vcIssueDocType) {
        this.vcIssueDocType = vcIssueDocType;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="EXEC_MM", length=7)
    public Date getExecMm() {
        return this.execMm;
    }
    
    public void setExecMm(Date execMm) {
        this.execMm = execMm;
    }

    
    @Column(name="VC_ISSUE_DOC_SEQ", precision=6, scale=0)
    public Integer getVcIssueDocSeq() {
        return this.vcIssueDocSeq;
    }
    
    public void setVcIssueDocSeq(Integer vcIssueDocSeq) {
        this.vcIssueDocSeq = vcIssueDocSeq;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleIssueDocumentLin")
    public Set<VcleVehicleLicenseReport> getVcleVehicleLicenseReports() {
        return this.vcleVehicleLicenseReports;
    }
    
    public void setVcleVehicleLicenseReports(Set<VcleVehicleLicenseReport> vcleVehicleLicenseReports) {
        this.vcleVehicleLicenseReports = vcleVehicleLicenseReports;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleIssueDocumentLin")
    public Set<VcleIssueDocumentLinType> getVcleIssueDocumentLinTypes() {
        return this.vcleIssueDocumentLinTypes;
    }
    
    public void setVcleIssueDocumentLinTypes(Set<VcleIssueDocumentLinType> vcleIssueDocumentLinTypes) {
        this.vcleIssueDocumentLinTypes = vcleIssueDocumentLinTypes;
    }




}


