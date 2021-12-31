package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleIssueDocumentLinType generated by hbm2java
 */
@Entity
@Table(name="VCLE_ISSUE_DOCUMENT_LIN_TYPE"
    ,schema="CODEATOR"
)
public class VcleIssueDocumentLinType  implements java.io.Serializable {


     private VcleIssueDocumentLinTypeId id;
     private VcleIssueDocumentMainType vcleIssueDocumentMainType;
     private VcleIssueDocumentLin vcleIssueDocumentLin;
     private Byte docCount;
     private Date docDate;
     private Long docNo;
     private String rmrk;

    public VcleIssueDocumentLinType() {
    }

	
    public VcleIssueDocumentLinType(VcleIssueDocumentLinTypeId id, VcleIssueDocumentLin vcleIssueDocumentLin) {
        this.id = id;
        this.vcleIssueDocumentLin = vcleIssueDocumentLin;
    }
    public VcleIssueDocumentLinType(VcleIssueDocumentLinTypeId id, VcleIssueDocumentMainType vcleIssueDocumentMainType, VcleIssueDocumentLin vcleIssueDocumentLin, Byte docCount, Date docDate, Long docNo, String rmrk) {
       this.id = id;
       this.vcleIssueDocumentMainType = vcleIssueDocumentMainType;
       this.vcleIssueDocumentLin = vcleIssueDocumentLin;
       this.docCount = docCount;
       this.docDate = docDate;
       this.docNo = docNo;
       this.rmrk = rmrk;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="costCode", column=@Column(name="COST_CODE", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="fiscalYear", column=@Column(name="FISCAL_YEAR", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="licenseType", column=@Column(name="LICENSE_TYPE", nullable=false, precision=3, scale=0) ), 
        @AttributeOverride(name="vcIssueDocSp", column=@Column(name="VC_ISSUE_DOC_SP", nullable=false, precision=12, scale=0) ), 
        @AttributeOverride(name="costType", column=@Column(name="COST_TYPE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="vcIssueDocSeq", column=@Column(name="VC_ISSUE_DOC_SEQ", nullable=false, precision=2, scale=0) ) } )
    public VcleIssueDocumentLinTypeId getId() {
        return this.id;
    }
    
    public void setId(VcleIssueDocumentLinTypeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="VCLE_DEPT_TYPE", referencedColumnName="VCLE_DEPT_TYPE"), 
        @JoinColumn(name="ISSUE_MAIN_CODE", referencedColumnName="ISSUE_MAIN_CODE") } )
    public VcleIssueDocumentMainType getVcleIssueDocumentMainType() {
        return this.vcleIssueDocumentMainType;
    }
    
    public void setVcleIssueDocumentMainType(VcleIssueDocumentMainType vcleIssueDocumentMainType) {
        this.vcleIssueDocumentMainType = vcleIssueDocumentMainType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="FISCAL_YEAR", referencedColumnName="FISCAL_YEAR", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="VC_ISSUE_DOC_SP", referencedColumnName="VC_ISSUE_DOC_SP", nullable=false, insertable=false, updatable=false) } )
    public VcleIssueDocumentLin getVcleIssueDocumentLin() {
        return this.vcleIssueDocumentLin;
    }
    
    public void setVcleIssueDocumentLin(VcleIssueDocumentLin vcleIssueDocumentLin) {
        this.vcleIssueDocumentLin = vcleIssueDocumentLin;
    }

    
    @Column(name="DOC_COUNT", precision=2, scale=0)
    public Byte getDocCount() {
        return this.docCount;
    }
    
    public void setDocCount(Byte docCount) {
        this.docCount = docCount;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DOC_DATE", length=7)
    public Date getDocDate() {
        return this.docDate;
    }
    
    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    
    @Column(name="DOC_NO", precision=11, scale=0)
    public Long getDocNo() {
        return this.docNo;
    }
    
    public void setDocNo(Long docNo) {
        this.docNo = docNo;
    }

    
    @Column(name="RMRK", length=150)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }




}


