package com.codeator.www._1_2_DB_entities;
// Generated Sep 11, 2021 5:44:32 PM by Hibernate Tools 4.3.1


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
 * InvoInvoiceMasterStatus generated by hbm2java
 */
@Entity
@Table(name="INVO_INVOICE_MASTER_STATUS"
    ,schema="CODEATOR"
)
public class InvoInvoiceMasterStatus  implements java.io.Serializable {


     private InvoInvoiceMasterStatusId id;
     private PerEmploymentMaster perEmploymentMaster;
     private InvoDocumentStatus invoDocumentStatus;
     private InvoInvoiceMaster invoInvoiceMaster;
     private String deskId;
     private Date currDate;
     private String currDateTime;
     private String rmrk;

    public InvoInvoiceMasterStatus() {
    }

	
    public InvoInvoiceMasterStatus(InvoInvoiceMasterStatusId id, InvoInvoiceMaster invoInvoiceMaster) {
        this.id = id;
        this.invoInvoiceMaster = invoInvoiceMaster;
    }
    public InvoInvoiceMasterStatus(InvoInvoiceMasterStatusId id, PerEmploymentMaster perEmploymentMaster, InvoDocumentStatus invoDocumentStatus, InvoInvoiceMaster invoInvoiceMaster, String deskId, Date currDate, String currDateTime, String rmrk) {
       this.id = id;
       this.perEmploymentMaster = perEmploymentMaster;
       this.invoDocumentStatus = invoDocumentStatus;
       this.invoInvoiceMaster = invoInvoiceMaster;
       this.deskId = deskId;
       this.currDate = currDate;
       this.currDateTime = currDateTime;
       this.rmrk = rmrk;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="sectionNoOld", column=@Column(name="SECTION_NO_OLD", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="depNoOld", column=@Column(name="DEP_NO_OLD", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="invoSp", column=@Column(name="INVO_SP", nullable=false, precision=16, scale=0) ), 
        @AttributeOverride(name="accUnitCode", column=@Column(name="ACC_UNIT_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="logSeq", column=@Column(name="LOG_SEQ", nullable=false, precision=4, scale=0) ) } )
    public InvoInvoiceMasterStatusId getId() {
        return this.id;
    }
    
    public void setId(InvoInvoiceMasterStatusId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
    public PerEmploymentMaster getPerEmploymentMaster() {
        return this.perEmploymentMaster;
    }
    
    public void setPerEmploymentMaster(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="DOC_STATUS")
    public InvoDocumentStatus getInvoDocumentStatus() {
        return this.invoDocumentStatus;
    }
    
    public void setInvoDocumentStatus(InvoDocumentStatus invoDocumentStatus) {
        this.invoDocumentStatus = invoDocumentStatus;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="DEP_NO_OLD", referencedColumnName="DEP_NO_OLD", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ACC_UNIT_CODE", referencedColumnName="ACC_UNIT_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="SECTION_NO_OLD", referencedColumnName="SECTION_NO_OLD", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="INVO_SP", referencedColumnName="INVO_SP", nullable=false, insertable=false, updatable=false) } )
    public InvoInvoiceMaster getInvoInvoiceMaster() {
        return this.invoInvoiceMaster;
    }
    
    public void setInvoInvoiceMaster(InvoInvoiceMaster invoInvoiceMaster) {
        this.invoInvoiceMaster = invoInvoiceMaster;
    }

    
    @Column(name="DESK_ID", length=20)
    public String getDeskId() {
        return this.deskId;
    }
    
    public void setDeskId(String deskId) {
        this.deskId = deskId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CURR_DATE", length=7)
    public Date getCurrDate() {
        return this.currDate;
    }
    
    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }

    
    @Column(name="CURR_DATE_TIME", length=20)
    public String getCurrDateTime() {
        return this.currDateTime;
    }
    
    public void setCurrDateTime(String currDateTime) {
        this.currDateTime = currDateTime;
    }

    
    @Column(name="RMRK", length=200)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }




}


