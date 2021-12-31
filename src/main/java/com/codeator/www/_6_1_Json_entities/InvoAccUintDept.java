package com.codeator.www._6_1_Json_entities;
// Generated Sep 16, 2021 11:27:10 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * InvoAccUintDept generated by hbm2java
 */

public class InvoAccUintDept implements java.io.Serializable {

    private InvoAccUintDeptId id;
    private PerDeptOld perDeptOld;
    private PerEmploymentMaster perEmploymentMaster;
    private InvoAccUnitsCode invoAccUnitsCode;
    private String rmrk;
    private String unitTel;
    private String unitFax;

    public InvoAccUintDeptId getId() {
        return id;
    }

    public void setId(InvoAccUintDeptId id) {
        this.id = id;
    }

    public PerDeptOld getPerDeptOld() {
        return perDeptOld;
    }

    public void setPerDeptOld(PerDeptOld perDeptOld) {
        this.perDeptOld = perDeptOld;
    }

    public PerEmploymentMaster getPerEmploymentMaster() {
        return perEmploymentMaster;
    }

    public void setPerEmploymentMaster(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }

    public InvoAccUnitsCode getInvoAccUnitsCode() {
        return invoAccUnitsCode;
    }

    public void setInvoAccUnitsCode(InvoAccUnitsCode invoAccUnitsCode) {
        this.invoAccUnitsCode = invoAccUnitsCode;
    }

    public String getRmrk() {
        return rmrk;
    }

    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    public String getUnitTel() {
        return unitTel;
    }

    public void setUnitTel(String unitTel) {
        this.unitTel = unitTel;
    }

    public String getUnitFax() {
        return unitFax;
    }

    public void setUnitFax(String unitFax) {
        this.unitFax = unitFax;
    }

    public String getChkInvoInternalIdSeq() {
        return chkInvoInternalIdSeq;
    }

    public void setChkInvoInternalIdSeq(String chkInvoInternalIdSeq) {
        this.chkInvoInternalIdSeq = chkInvoInternalIdSeq;
    }

    public String getInvoInternalIdStart() {
        return invoInternalIdStart;
    }

    public void setInvoInternalIdStart(String invoInternalIdStart) {
        this.invoInternalIdStart = invoInternalIdStart;
    }

    public Set<InvoDeptTaxJoin> getInvoDeptTaxJoins() {
        return invoDeptTaxJoins;
    }

    public void setInvoDeptTaxJoins(Set<InvoDeptTaxJoin> invoDeptTaxJoins) {
        this.invoDeptTaxJoins = invoDeptTaxJoins;
    }

    public Set<PurContractServiceType> getPurContractServiceTypes() {
        return purContractServiceTypes;
    }

    public void setPurContractServiceTypes(Set<PurContractServiceType> purContractServiceTypes) {
        this.purContractServiceTypes = purContractServiceTypes;
    }

    public Set<AppAuthJavaUsers> getAppAuthJavaUserses() {
        return appAuthJavaUserses;
    }

    public void setAppAuthJavaUserses(Set<AppAuthJavaUsers> appAuthJavaUserses) {
        this.appAuthJavaUserses = appAuthJavaUserses;
    }

    public Set<InvoDeptUnitJoin> getInvoDeptUnitJoins() {
        return invoDeptUnitJoins;
    }

    public void setInvoDeptUnitJoins(Set<InvoDeptUnitJoin> invoDeptUnitJoins) {
        this.invoDeptUnitJoins = invoDeptUnitJoins;
    }

    public Set<InvoDeptItemJoin> getInvoDeptItemJoins() {
        return invoDeptItemJoins;
    }

    public void setInvoDeptItemJoins(Set<InvoDeptItemJoin> invoDeptItemJoins) {
        this.invoDeptItemJoins = invoDeptItemJoins;
    }

    public Set<InvoInvoiceMaster> getInvoInvoiceMasters() {
        return invoInvoiceMasters;
    }

    public void setInvoInvoiceMasters(Set<InvoInvoiceMaster> invoInvoiceMasters) {
        this.invoInvoiceMasters = invoInvoiceMasters;
    }

    public Set<PurContractTitel> getPurContractTitels() {
        return purContractTitels;
    }

    public void setPurContractTitels(Set<PurContractTitel> purContractTitels) {
        this.purContractTitels = purContractTitels;
    }
    private String chkInvoInternalIdSeq;
    private String invoInternalIdStart;
    private Set<InvoDeptTaxJoin> invoDeptTaxJoins = new HashSet<InvoDeptTaxJoin>(0);
    private Set<PurContractServiceType> purContractServiceTypes = new HashSet<PurContractServiceType>(0);
    private Set<AppAuthJavaUsers> appAuthJavaUserses = new HashSet<AppAuthJavaUsers>(0);
    private Set<InvoDeptUnitJoin> invoDeptUnitJoins = new HashSet<InvoDeptUnitJoin>(0);
    private Set<InvoDeptItemJoin> invoDeptItemJoins = new HashSet<InvoDeptItemJoin>(0);
    private Set<InvoInvoiceMaster> invoInvoiceMasters = new HashSet<InvoInvoiceMaster>(0);
    private Set<PurContractTitel> purContractTitels = new HashSet<PurContractTitel>(0);



}
