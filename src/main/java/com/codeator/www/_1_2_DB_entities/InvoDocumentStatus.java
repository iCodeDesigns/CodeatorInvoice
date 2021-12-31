package com.codeator.www._1_2_DB_entities;
// Generated Sep 11, 2021 5:44:32 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * InvoDocumentStatus generated by hbm2java
 */
@Entity
@Table(name="INVO_DOCUMENT_STATUS"
    ,schema="CODEATOR"
)
public class InvoDocumentStatus  implements java.io.Serializable {


     private byte docStatus;
     private String docStatusName;
     private Set<InvoInvoiceMaster> invoInvoiceMasters = new HashSet<InvoInvoiceMaster>(0);
     private Set<InvoInvoiceMasterStatus> invoInvoiceMasterStatuses = new HashSet<InvoInvoiceMasterStatus>(0);

    public InvoDocumentStatus() {
    }

	
    public InvoDocumentStatus(byte docStatus) {
        this.docStatus = docStatus;
    }
    public InvoDocumentStatus(byte docStatus, String docStatusName, Set<InvoInvoiceMaster> invoInvoiceMasters, Set<InvoInvoiceMasterStatus> invoInvoiceMasterStatuses) {
       this.docStatus = docStatus;
       this.docStatusName = docStatusName;
       this.invoInvoiceMasters = invoInvoiceMasters;
       this.invoInvoiceMasterStatuses = invoInvoiceMasterStatuses;
    }
   
     @Id 

    
    @Column(name="DOC_STATUS", unique=true, nullable=false, precision=2, scale=0)
    public byte getDocStatus() {
        return this.docStatus;
    }
    
    public void setDocStatus(byte docStatus) {
        this.docStatus = docStatus;
    }

    
    @Column(name="DOC_STATUS_NAME", length=100)
    public String getDocStatusName() {
        return this.docStatusName;
    }
    
    public void setDocStatusName(String docStatusName) {
        this.docStatusName = docStatusName;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoDocumentStatus")
    public Set<InvoInvoiceMaster> getInvoInvoiceMasters() {
        return this.invoInvoiceMasters;
    }
    
    public void setInvoInvoiceMasters(Set<InvoInvoiceMaster> invoInvoiceMasters) {
        this.invoInvoiceMasters = invoInvoiceMasters;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoDocumentStatus")
    public Set<InvoInvoiceMasterStatus> getInvoInvoiceMasterStatuses() {
        return this.invoInvoiceMasterStatuses;
    }
    
    public void setInvoInvoiceMasterStatuses(Set<InvoInvoiceMasterStatus> invoInvoiceMasterStatuses) {
        this.invoInvoiceMasterStatuses = invoInvoiceMasterStatuses;
    }




}


