package com.codeator.www._1_2_DB_entities;
// Generated Dec 24, 2021 10:50:22 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * InvoAccUintDept generated by hbm2java
 */
@Entity
@Table(name="INVO_ACC_UINT_DEPT"
    ,schema="CODEATOR"
)
public class InvoAccUintDept  implements java.io.Serializable {


     private InvoAccUintDeptId id;
     private PerDeptOld perDeptOld;
     private PerEmploymentMaster perEmploymentMaster;
     private InvoAccUnitsCode invoAccUnitsCode;
     private String rmrk;
     private String unitTel;
     private String unitFax;
     private String chkInvoInternalIdSeq;
     private String invoInternalIdStart;
     private Set<InvoDeptTaxJoin> invoDeptTaxJoins = new HashSet<InvoDeptTaxJoin>(0);
     private Set<PurContractServiceType> purContractServiceTypes = new HashSet<PurContractServiceType>(0);
     private Set<AppAuthJavaUsers> appAuthJavaUserses = new HashSet<AppAuthJavaUsers>(0);
     private Set<InvoDeptUnitJoin> invoDeptUnitJoins = new HashSet<InvoDeptUnitJoin>(0);
     private Set<PurSuppWorkDtl> purSuppWorkDtls = new HashSet<PurSuppWorkDtl>(0);
     private Set<InvoDeptItemJoin> invoDeptItemJoins = new HashSet<InvoDeptItemJoin>(0);
     private Set<InvoAdvCollectorCode> invoAdvCollectorCodes = new HashSet<InvoAdvCollectorCode>(0);
     private Set<InvoAdvProducerCode> invoAdvProducerCodes = new HashSet<InvoAdvProducerCode>(0);
     private Set<InvoInvoiceMaster> invoInvoiceMasters = new HashSet<InvoInvoiceMaster>(0);
     private Set<PurContractTitel> purContractTitels = new HashSet<PurContractTitel>(0);

    public InvoAccUintDept() {
    }

	
    public InvoAccUintDept(InvoAccUintDeptId id, PerDeptOld perDeptOld, InvoAccUnitsCode invoAccUnitsCode) {
        this.id = id;
        this.perDeptOld = perDeptOld;
        this.invoAccUnitsCode = invoAccUnitsCode;
    }
    public InvoAccUintDept(InvoAccUintDeptId id, PerDeptOld perDeptOld, PerEmploymentMaster perEmploymentMaster, InvoAccUnitsCode invoAccUnitsCode, String rmrk, String unitTel, String unitFax, String chkInvoInternalIdSeq, String invoInternalIdStart, Set<InvoDeptTaxJoin> invoDeptTaxJoins, Set<PurContractServiceType> purContractServiceTypes, Set<AppAuthJavaUsers> appAuthJavaUserses, Set<InvoDeptUnitJoin> invoDeptUnitJoins, Set<PurSuppWorkDtl> purSuppWorkDtls, Set<InvoDeptItemJoin> invoDeptItemJoins, Set<InvoAdvCollectorCode> invoAdvCollectorCodes, Set<InvoAdvProducerCode> invoAdvProducerCodes, Set<InvoInvoiceMaster> invoInvoiceMasters, Set<PurContractTitel> purContractTitels) {
       this.id = id;
       this.perDeptOld = perDeptOld;
       this.perEmploymentMaster = perEmploymentMaster;
       this.invoAccUnitsCode = invoAccUnitsCode;
       this.rmrk = rmrk;
       this.unitTel = unitTel;
       this.unitFax = unitFax;
       this.chkInvoInternalIdSeq = chkInvoInternalIdSeq;
       this.invoInternalIdStart = invoInternalIdStart;
       this.invoDeptTaxJoins = invoDeptTaxJoins;
       this.purContractServiceTypes = purContractServiceTypes;
       this.appAuthJavaUserses = appAuthJavaUserses;
       this.invoDeptUnitJoins = invoDeptUnitJoins;
       this.purSuppWorkDtls = purSuppWorkDtls;
       this.invoDeptItemJoins = invoDeptItemJoins;
       this.invoAdvCollectorCodes = invoAdvCollectorCodes;
       this.invoAdvProducerCodes = invoAdvProducerCodes;
       this.invoInvoiceMasters = invoInvoiceMasters;
       this.purContractTitels = purContractTitels;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="accUnitCode", column=@Column(name="ACC_UNIT_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="depNoOld", column=@Column(name="DEP_NO_OLD", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="sectionNoOld", column=@Column(name="SECTION_NO_OLD", nullable=false, precision=5, scale=0) ) } )
    public InvoAccUintDeptId getId() {
        return this.id;
    }
    
    public void setId(InvoAccUintDeptId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="SECTION_NO_OLD", referencedColumnName="SECTION_NO_OLD", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="DEP_NO_OLD", referencedColumnName="DEP_NO_OLD", nullable=false, insertable=false, updatable=false) } )
    public PerDeptOld getPerDeptOld() {
        return this.perDeptOld;
    }
    
    public void setPerDeptOld(PerDeptOld perDeptOld) {
        this.perDeptOld = perDeptOld;
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
    @JoinColumn(name="ACC_UNIT_CODE", nullable=false, insertable=false, updatable=false)
    public InvoAccUnitsCode getInvoAccUnitsCode() {
        return this.invoAccUnitsCode;
    }
    
    public void setInvoAccUnitsCode(InvoAccUnitsCode invoAccUnitsCode) {
        this.invoAccUnitsCode = invoAccUnitsCode;
    }

    
    @Column(name="RMRK", length=200)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    
    @Column(name="UNIT_TEL", length=20)
    public String getUnitTel() {
        return this.unitTel;
    }
    
    public void setUnitTel(String unitTel) {
        this.unitTel = unitTel;
    }

    
    @Column(name="UNIT_FAX", length=20)
    public String getUnitFax() {
        return this.unitFax;
    }
    
    public void setUnitFax(String unitFax) {
        this.unitFax = unitFax;
    }

    
    @Column(name="CHK_INVO_INTERNAL_ID_SEQ", length=1)
    public String getChkInvoInternalIdSeq() {
        return this.chkInvoInternalIdSeq;
    }
    
    public void setChkInvoInternalIdSeq(String chkInvoInternalIdSeq) {
        this.chkInvoInternalIdSeq = chkInvoInternalIdSeq;
    }

    
    @Column(name="INVO_INTERNAL_ID_START", length=15)
    public String getInvoInternalIdStart() {
        return this.invoInternalIdStart;
    }
    
    public void setInvoInternalIdStart(String invoInternalIdStart) {
        this.invoInternalIdStart = invoInternalIdStart;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoAccUintDept")
    public Set<InvoDeptTaxJoin> getInvoDeptTaxJoins() {
        return this.invoDeptTaxJoins;
    }
    
    public void setInvoDeptTaxJoins(Set<InvoDeptTaxJoin> invoDeptTaxJoins) {
        this.invoDeptTaxJoins = invoDeptTaxJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoAccUintDept")
    public Set<PurContractServiceType> getPurContractServiceTypes() {
        return this.purContractServiceTypes;
    }
    
    public void setPurContractServiceTypes(Set<PurContractServiceType> purContractServiceTypes) {
        this.purContractServiceTypes = purContractServiceTypes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoAccUintDept")
    public Set<AppAuthJavaUsers> getAppAuthJavaUserses() {
        return this.appAuthJavaUserses;
    }
    
    public void setAppAuthJavaUserses(Set<AppAuthJavaUsers> appAuthJavaUserses) {
        this.appAuthJavaUserses = appAuthJavaUserses;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoAccUintDept")
    public Set<InvoDeptUnitJoin> getInvoDeptUnitJoins() {
        return this.invoDeptUnitJoins;
    }
    
    public void setInvoDeptUnitJoins(Set<InvoDeptUnitJoin> invoDeptUnitJoins) {
        this.invoDeptUnitJoins = invoDeptUnitJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoAccUintDept")
    public Set<PurSuppWorkDtl> getPurSuppWorkDtls() {
        return this.purSuppWorkDtls;
    }
    
    public void setPurSuppWorkDtls(Set<PurSuppWorkDtl> purSuppWorkDtls) {
        this.purSuppWorkDtls = purSuppWorkDtls;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoAccUintDept")
    public Set<InvoDeptItemJoin> getInvoDeptItemJoins() {
        return this.invoDeptItemJoins;
    }
    
    public void setInvoDeptItemJoins(Set<InvoDeptItemJoin> invoDeptItemJoins) {
        this.invoDeptItemJoins = invoDeptItemJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoAccUintDept")
    public Set<InvoAdvCollectorCode> getInvoAdvCollectorCodes() {
        return this.invoAdvCollectorCodes;
    }
    
    public void setInvoAdvCollectorCodes(Set<InvoAdvCollectorCode> invoAdvCollectorCodes) {
        this.invoAdvCollectorCodes = invoAdvCollectorCodes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoAccUintDept")
    public Set<InvoAdvProducerCode> getInvoAdvProducerCodes() {
        return this.invoAdvProducerCodes;
    }
    
    public void setInvoAdvProducerCodes(Set<InvoAdvProducerCode> invoAdvProducerCodes) {
        this.invoAdvProducerCodes = invoAdvProducerCodes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoAccUintDept")
    public Set<InvoInvoiceMaster> getInvoInvoiceMasters() {
        return this.invoInvoiceMasters;
    }
    
    public void setInvoInvoiceMasters(Set<InvoInvoiceMaster> invoInvoiceMasters) {
        this.invoInvoiceMasters = invoInvoiceMasters;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoAccUintDept")
    public Set<PurContractTitel> getPurContractTitels() {
        return this.purContractTitels;
    }
    
    public void setPurContractTitels(Set<PurContractTitel> purContractTitels) {
        this.purContractTitels = purContractTitels;
    }




}


