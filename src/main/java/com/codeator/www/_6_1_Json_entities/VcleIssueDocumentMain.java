package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * VcleIssueDocumentMain generated by hbm2java
 */
public class VcleIssueDocumentMain  implements java.io.Serializable {


     private boolean vcleDeptType;
     private AccCurrencyCode accCurrencyCode;
     private PerOrganizationStructure perOrganizationStructure;
     private Boolean chkAccountUnit;
     private Boolean chkOrgId;
     private Boolean chkCurrency;
     private String accountUnitCode;
     private Short fiscalYear;
     private String issueDocStatus;
     private Set vcleIssueDocumentMainTypes = new HashSet(0);
     private Set vcleIssueDocumentMainDtls = new HashSet(0);

    public VcleIssueDocumentMain() {
    }

	
    public VcleIssueDocumentMain(boolean vcleDeptType) {
        this.vcleDeptType = vcleDeptType;
    }
    public VcleIssueDocumentMain(boolean vcleDeptType, AccCurrencyCode accCurrencyCode, PerOrganizationStructure perOrganizationStructure, Boolean chkAccountUnit, Boolean chkOrgId, Boolean chkCurrency, String accountUnitCode, Short fiscalYear, String issueDocStatus, Set vcleIssueDocumentMainTypes, Set vcleIssueDocumentMainDtls) {
       this.vcleDeptType = vcleDeptType;
       this.accCurrencyCode = accCurrencyCode;
       this.perOrganizationStructure = perOrganizationStructure;
       this.chkAccountUnit = chkAccountUnit;
       this.chkOrgId = chkOrgId;
       this.chkCurrency = chkCurrency;
       this.accountUnitCode = accountUnitCode;
       this.fiscalYear = fiscalYear;
       this.issueDocStatus = issueDocStatus;
       this.vcleIssueDocumentMainTypes = vcleIssueDocumentMainTypes;
       this.vcleIssueDocumentMainDtls = vcleIssueDocumentMainDtls;
    }
   
    public boolean isVcleDeptType() {
        return this.vcleDeptType;
    }
    
    public void setVcleDeptType(boolean vcleDeptType) {
        this.vcleDeptType = vcleDeptType;
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
    public Boolean getChkAccountUnit() {
        return this.chkAccountUnit;
    }
    
    public void setChkAccountUnit(Boolean chkAccountUnit) {
        this.chkAccountUnit = chkAccountUnit;
    }
    public Boolean getChkOrgId() {
        return this.chkOrgId;
    }
    
    public void setChkOrgId(Boolean chkOrgId) {
        this.chkOrgId = chkOrgId;
    }
    public Boolean getChkCurrency() {
        return this.chkCurrency;
    }
    
    public void setChkCurrency(Boolean chkCurrency) {
        this.chkCurrency = chkCurrency;
    }
    public String getAccountUnitCode() {
        return this.accountUnitCode;
    }
    
    public void setAccountUnitCode(String accountUnitCode) {
        this.accountUnitCode = accountUnitCode;
    }
    public Short getFiscalYear() {
        return this.fiscalYear;
    }
    
    public void setFiscalYear(Short fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
    public String getIssueDocStatus() {
        return this.issueDocStatus;
    }
    
    public void setIssueDocStatus(String issueDocStatus) {
        this.issueDocStatus = issueDocStatus;
    }
    public Set getVcleIssueDocumentMainTypes() {
        return this.vcleIssueDocumentMainTypes;
    }
    
    public void setVcleIssueDocumentMainTypes(Set vcleIssueDocumentMainTypes) {
        this.vcleIssueDocumentMainTypes = vcleIssueDocumentMainTypes;
    }
    public Set getVcleIssueDocumentMainDtls() {
        return this.vcleIssueDocumentMainDtls;
    }
    
    public void setVcleIssueDocumentMainDtls(Set vcleIssueDocumentMainDtls) {
        this.vcleIssueDocumentMainDtls = vcleIssueDocumentMainDtls;
    }




}

