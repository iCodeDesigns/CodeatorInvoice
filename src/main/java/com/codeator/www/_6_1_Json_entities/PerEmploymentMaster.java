package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PerEmploymentMaster generated by hbm2java
 */
public class PerEmploymentMaster  implements java.io.Serializable {


     private long employeeId;
     private PerEmploymentParameter perEmploymentParameter;
     private PerGeneralCode perGeneralCode;
     private PerOrganizationStructure perOrganizationStructure;
     private PerOrgunitCode perOrgunitCode;
     private PerQualClass perQualClass;
     private PerQualCode perQualCode;
     private PerDeptOld perDeptOld;
     private PerLocationCode perLocationCode;
     private String employeeNo;
     private String empEname;
     private String empAname;
     private Date contractDate;
     private Date contractEnddate;
     private Date birthDate;
     private Date qualYear;
     private Long subDepNoOld;
     private Long secSubDepNo;
     private Set stoResponsibilityHistoryEmps = new HashSet(0);
     private Set vcleVehicleDriverJoins = new HashSet(0);
     private Set stoResponsibilityDepts = new HashSet(0);
     private Set stoResponsibilityDeptItms = new HashSet(0);
     private Set vcleIssueDocumentLiqs = new HashSet(0);
     private StoRespEmpReq stoRespEmpReq;
     private Set vcleVehicleRequiresForEmployeeIdDriver = new HashSet(0);
     private Set purContractMasters = new HashSet(0);
     private Set vcleIssueDocumentMainDtls = new HashSet(0);
     private Set vcleVehicleClassDtls = new HashSet(0);
     private Set purSuppWorkDtls = new HashSet(0);
     private VcleVehicleRequireEmp vcleVehicleRequireEmp;
     private Set vcleVehicleRequiresForEmployeeId = new HashSet(0);
     private VcleAssociationEmp vcleAssociationEmp;
     private Set invoInvoiceMasters = new HashSet(0);
     private Set vcleTrafficEmpPerms = new HashSet(0);
     private Set vcleVehicleLicensesForEmployeeId = new HashSet(0);
     private Set purContractServiceTypes = new HashSet(0);
     private Set purSuppWorksForUpdateEmpId = new HashSet(0);
     private AppAuthJavaUsers appAuthJavaUsers;
     private Set purSuppWorksForInsertEmpId = new HashSet(0);
     private Set vcleRecordMovements = new HashSet(0);
     private Set invoInvoiceMasterStatuses = new HashSet(0);
     private Set vcleVehicleIncomes = new HashSet(0);
     private Set vcleTrafficLines = new HashSet(0);
     private Set vcleMotorChanges = new HashSet(0);
     private Set vcleVehicleRequireStatusDts = new HashSet(0);
     private Set vcleIssueDocumentMans = new HashSet(0);
     private Set appSubElemSpecAuthsForEmployeeId = new HashSet(0);
     private Set vcleVehicleLicenseDtls = new HashSet(0);
     private Set appSubElemSpecAuthsForEmployeeIdAction = new HashSet(0);
     private Set appSubTabSpecAuthsForEmployeeId = new HashSet(0);
     private Set vcleTravelExchanges = new HashSet(0);
     private Set vcleVehicleLicensesForEmployeeIdReceive = new HashSet(0);
     private Set vcleRecordMovementJoins = new HashSet(0);
     private Set appSubTabSpecAuthsForEmployeeIdAction = new HashSet(0);

    public PerEmploymentMaster() {
    }

	
    public PerEmploymentMaster(long employeeId, String employeeNo, String empAname) {
        this.employeeId = employeeId;
        this.employeeNo = employeeNo;
        this.empAname = empAname;
    }
    public PerEmploymentMaster(long employeeId, PerEmploymentParameter perEmploymentParameter, PerGeneralCode perGeneralCode, PerOrganizationStructure perOrganizationStructure, PerOrgunitCode perOrgunitCode, PerQualClass perQualClass, PerQualCode perQualCode, PerDeptOld perDeptOld, PerLocationCode perLocationCode, String employeeNo, String empEname, String empAname, Date contractDate, Date contractEnddate, Date birthDate, Date qualYear, Long subDepNoOld, Long secSubDepNo, Set stoResponsibilityHistoryEmps, Set vcleVehicleDriverJoins, Set stoResponsibilityDepts, Set stoResponsibilityDeptItms, Set vcleIssueDocumentLiqs, StoRespEmpReq stoRespEmpReq, Set vcleVehicleRequiresForEmployeeIdDriver, Set purContractMasters, Set vcleIssueDocumentMainDtls, Set vcleVehicleClassDtls, Set purSuppWorkDtls, VcleVehicleRequireEmp vcleVehicleRequireEmp, Set vcleVehicleRequiresForEmployeeId, VcleAssociationEmp vcleAssociationEmp, Set invoInvoiceMasters, Set vcleTrafficEmpPerms, Set vcleVehicleLicensesForEmployeeId, Set purContractServiceTypes, Set purSuppWorksForUpdateEmpId, AppAuthJavaUsers appAuthJavaUsers, Set purSuppWorksForInsertEmpId, Set vcleRecordMovements, Set invoInvoiceMasterStatuses, Set vcleVehicleIncomes, Set vcleTrafficLines, Set vcleMotorChanges, Set vcleVehicleRequireStatusDts, Set vcleIssueDocumentMans, Set appSubElemSpecAuthsForEmployeeId, Set vcleVehicleLicenseDtls, Set appSubElemSpecAuthsForEmployeeIdAction, Set appSubTabSpecAuthsForEmployeeId, Set vcleTravelExchanges, Set vcleVehicleLicensesForEmployeeIdReceive, Set vcleRecordMovementJoins, Set appSubTabSpecAuthsForEmployeeIdAction) {
       this.employeeId = employeeId;
       this.perEmploymentParameter = perEmploymentParameter;
       this.perGeneralCode = perGeneralCode;
       this.perOrganizationStructure = perOrganizationStructure;
       this.perOrgunitCode = perOrgunitCode;
       this.perQualClass = perQualClass;
       this.perQualCode = perQualCode;
       this.perDeptOld = perDeptOld;
       this.perLocationCode = perLocationCode;
       this.employeeNo = employeeNo;
       this.empEname = empEname;
       this.empAname = empAname;
       this.contractDate = contractDate;
       this.contractEnddate = contractEnddate;
       this.birthDate = birthDate;
       this.qualYear = qualYear;
       this.subDepNoOld = subDepNoOld;
       this.secSubDepNo = secSubDepNo;
       this.stoResponsibilityHistoryEmps = stoResponsibilityHistoryEmps;
       this.vcleVehicleDriverJoins = vcleVehicleDriverJoins;
       this.stoResponsibilityDepts = stoResponsibilityDepts;
       this.stoResponsibilityDeptItms = stoResponsibilityDeptItms;
       this.vcleIssueDocumentLiqs = vcleIssueDocumentLiqs;
       this.stoRespEmpReq = stoRespEmpReq;
       this.vcleVehicleRequiresForEmployeeIdDriver = vcleVehicleRequiresForEmployeeIdDriver;
       this.purContractMasters = purContractMasters;
       this.vcleIssueDocumentMainDtls = vcleIssueDocumentMainDtls;
       this.vcleVehicleClassDtls = vcleVehicleClassDtls;
       this.purSuppWorkDtls = purSuppWorkDtls;
       this.vcleVehicleRequireEmp = vcleVehicleRequireEmp;
       this.vcleVehicleRequiresForEmployeeId = vcleVehicleRequiresForEmployeeId;
       this.vcleAssociationEmp = vcleAssociationEmp;
       this.invoInvoiceMasters = invoInvoiceMasters;
       this.vcleTrafficEmpPerms = vcleTrafficEmpPerms;
       this.vcleVehicleLicensesForEmployeeId = vcleVehicleLicensesForEmployeeId;
       this.purContractServiceTypes = purContractServiceTypes;
       this.purSuppWorksForUpdateEmpId = purSuppWorksForUpdateEmpId;
       this.appAuthJavaUsers = appAuthJavaUsers;
       this.purSuppWorksForInsertEmpId = purSuppWorksForInsertEmpId;
       this.vcleRecordMovements = vcleRecordMovements;
       this.invoInvoiceMasterStatuses = invoInvoiceMasterStatuses;
       this.vcleVehicleIncomes = vcleVehicleIncomes;
       this.vcleTrafficLines = vcleTrafficLines;
       this.vcleMotorChanges = vcleMotorChanges;
       this.vcleVehicleRequireStatusDts = vcleVehicleRequireStatusDts;
       this.vcleIssueDocumentMans = vcleIssueDocumentMans;
       this.appSubElemSpecAuthsForEmployeeId = appSubElemSpecAuthsForEmployeeId;
       this.vcleVehicleLicenseDtls = vcleVehicleLicenseDtls;
       this.appSubElemSpecAuthsForEmployeeIdAction = appSubElemSpecAuthsForEmployeeIdAction;
       this.appSubTabSpecAuthsForEmployeeId = appSubTabSpecAuthsForEmployeeId;
       this.vcleTravelExchanges = vcleTravelExchanges;
       this.vcleVehicleLicensesForEmployeeIdReceive = vcleVehicleLicensesForEmployeeIdReceive;
       this.vcleRecordMovementJoins = vcleRecordMovementJoins;
       this.appSubTabSpecAuthsForEmployeeIdAction = appSubTabSpecAuthsForEmployeeIdAction;
    }
   
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public PerEmploymentParameter getPerEmploymentParameter() {
        return this.perEmploymentParameter;
    }
    
    public void setPerEmploymentParameter(PerEmploymentParameter perEmploymentParameter) {
        this.perEmploymentParameter = perEmploymentParameter;
    }
    public PerGeneralCode getPerGeneralCode() {
        return this.perGeneralCode;
    }
    
    public void setPerGeneralCode(PerGeneralCode perGeneralCode) {
        this.perGeneralCode = perGeneralCode;
    }
    public PerOrganizationStructure getPerOrganizationStructure() {
        return this.perOrganizationStructure;
    }
    
    public void setPerOrganizationStructure(PerOrganizationStructure perOrganizationStructure) {
        this.perOrganizationStructure = perOrganizationStructure;
    }
    public PerOrgunitCode getPerOrgunitCode() {
        return this.perOrgunitCode;
    }
    
    public void setPerOrgunitCode(PerOrgunitCode perOrgunitCode) {
        this.perOrgunitCode = perOrgunitCode;
    }
    public PerQualClass getPerQualClass() {
        return this.perQualClass;
    }
    
    public void setPerQualClass(PerQualClass perQualClass) {
        this.perQualClass = perQualClass;
    }
    public PerQualCode getPerQualCode() {
        return this.perQualCode;
    }
    
    public void setPerQualCode(PerQualCode perQualCode) {
        this.perQualCode = perQualCode;
    }
    public PerDeptOld getPerDeptOld() {
        return this.perDeptOld;
    }
    
    public void setPerDeptOld(PerDeptOld perDeptOld) {
        this.perDeptOld = perDeptOld;
    }
    public PerLocationCode getPerLocationCode() {
        return this.perLocationCode;
    }
    
    public void setPerLocationCode(PerLocationCode perLocationCode) {
        this.perLocationCode = perLocationCode;
    }
    public String getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }
    public String getEmpEname() {
        return this.empEname;
    }
    
    public void setEmpEname(String empEname) {
        this.empEname = empEname;
    }
    public String getEmpAname() {
        return this.empAname;
    }
    
    public void setEmpAname(String empAname) {
        this.empAname = empAname;
    }
    public Date getContractDate() {
        return this.contractDate;
    }
    
    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }
    public Date getContractEnddate() {
        return this.contractEnddate;
    }
    
    public void setContractEnddate(Date contractEnddate) {
        this.contractEnddate = contractEnddate;
    }
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Date getQualYear() {
        return this.qualYear;
    }
    
    public void setQualYear(Date qualYear) {
        this.qualYear = qualYear;
    }
    public Long getSubDepNoOld() {
        return this.subDepNoOld;
    }
    
    public void setSubDepNoOld(Long subDepNoOld) {
        this.subDepNoOld = subDepNoOld;
    }
    public Long getSecSubDepNo() {
        return this.secSubDepNo;
    }
    
    public void setSecSubDepNo(Long secSubDepNo) {
        this.secSubDepNo = secSubDepNo;
    }
    public Set getStoResponsibilityHistoryEmps() {
        return this.stoResponsibilityHistoryEmps;
    }
    
    public void setStoResponsibilityHistoryEmps(Set stoResponsibilityHistoryEmps) {
        this.stoResponsibilityHistoryEmps = stoResponsibilityHistoryEmps;
    }
    public Set getVcleVehicleDriverJoins() {
        return this.vcleVehicleDriverJoins;
    }
    
    public void setVcleVehicleDriverJoins(Set vcleVehicleDriverJoins) {
        this.vcleVehicleDriverJoins = vcleVehicleDriverJoins;
    }
    public Set getStoResponsibilityDepts() {
        return this.stoResponsibilityDepts;
    }
    
    public void setStoResponsibilityDepts(Set stoResponsibilityDepts) {
        this.stoResponsibilityDepts = stoResponsibilityDepts;
    }
    public Set getStoResponsibilityDeptItms() {
        return this.stoResponsibilityDeptItms;
    }
    
    public void setStoResponsibilityDeptItms(Set stoResponsibilityDeptItms) {
        this.stoResponsibilityDeptItms = stoResponsibilityDeptItms;
    }
    public Set getVcleIssueDocumentLiqs() {
        return this.vcleIssueDocumentLiqs;
    }
    
    public void setVcleIssueDocumentLiqs(Set vcleIssueDocumentLiqs) {
        this.vcleIssueDocumentLiqs = vcleIssueDocumentLiqs;
    }
    public StoRespEmpReq getStoRespEmpReq() {
        return this.stoRespEmpReq;
    }
    
    public void setStoRespEmpReq(StoRespEmpReq stoRespEmpReq) {
        this.stoRespEmpReq = stoRespEmpReq;
    }
    public Set getVcleVehicleRequiresForEmployeeIdDriver() {
        return this.vcleVehicleRequiresForEmployeeIdDriver;
    }
    
    public void setVcleVehicleRequiresForEmployeeIdDriver(Set vcleVehicleRequiresForEmployeeIdDriver) {
        this.vcleVehicleRequiresForEmployeeIdDriver = vcleVehicleRequiresForEmployeeIdDriver;
    }
    public Set getPurContractMasters() {
        return this.purContractMasters;
    }
    
    public void setPurContractMasters(Set purContractMasters) {
        this.purContractMasters = purContractMasters;
    }
    public Set getVcleIssueDocumentMainDtls() {
        return this.vcleIssueDocumentMainDtls;
    }
    
    public void setVcleIssueDocumentMainDtls(Set vcleIssueDocumentMainDtls) {
        this.vcleIssueDocumentMainDtls = vcleIssueDocumentMainDtls;
    }
    public Set getVcleVehicleClassDtls() {
        return this.vcleVehicleClassDtls;
    }
    
    public void setVcleVehicleClassDtls(Set vcleVehicleClassDtls) {
        this.vcleVehicleClassDtls = vcleVehicleClassDtls;
    }
    public Set getPurSuppWorkDtls() {
        return this.purSuppWorkDtls;
    }
    
    public void setPurSuppWorkDtls(Set purSuppWorkDtls) {
        this.purSuppWorkDtls = purSuppWorkDtls;
    }
    public VcleVehicleRequireEmp getVcleVehicleRequireEmp() {
        return this.vcleVehicleRequireEmp;
    }
    
    public void setVcleVehicleRequireEmp(VcleVehicleRequireEmp vcleVehicleRequireEmp) {
        this.vcleVehicleRequireEmp = vcleVehicleRequireEmp;
    }
    public Set getVcleVehicleRequiresForEmployeeId() {
        return this.vcleVehicleRequiresForEmployeeId;
    }
    
    public void setVcleVehicleRequiresForEmployeeId(Set vcleVehicleRequiresForEmployeeId) {
        this.vcleVehicleRequiresForEmployeeId = vcleVehicleRequiresForEmployeeId;
    }
    public VcleAssociationEmp getVcleAssociationEmp() {
        return this.vcleAssociationEmp;
    }
    
    public void setVcleAssociationEmp(VcleAssociationEmp vcleAssociationEmp) {
        this.vcleAssociationEmp = vcleAssociationEmp;
    }
    public Set getInvoInvoiceMasters() {
        return this.invoInvoiceMasters;
    }
    
    public void setInvoInvoiceMasters(Set invoInvoiceMasters) {
        this.invoInvoiceMasters = invoInvoiceMasters;
    }
    public Set getVcleTrafficEmpPerms() {
        return this.vcleTrafficEmpPerms;
    }
    
    public void setVcleTrafficEmpPerms(Set vcleTrafficEmpPerms) {
        this.vcleTrafficEmpPerms = vcleTrafficEmpPerms;
    }
    public Set getVcleVehicleLicensesForEmployeeId() {
        return this.vcleVehicleLicensesForEmployeeId;
    }
    
    public void setVcleVehicleLicensesForEmployeeId(Set vcleVehicleLicensesForEmployeeId) {
        this.vcleVehicleLicensesForEmployeeId = vcleVehicleLicensesForEmployeeId;
    }
    public Set getPurContractServiceTypes() {
        return this.purContractServiceTypes;
    }
    
    public void setPurContractServiceTypes(Set purContractServiceTypes) {
        this.purContractServiceTypes = purContractServiceTypes;
    }
    public Set getPurSuppWorksForUpdateEmpId() {
        return this.purSuppWorksForUpdateEmpId;
    }
    
    public void setPurSuppWorksForUpdateEmpId(Set purSuppWorksForUpdateEmpId) {
        this.purSuppWorksForUpdateEmpId = purSuppWorksForUpdateEmpId;
    }
    public AppAuthJavaUsers getAppAuthJavaUsers() {
        return this.appAuthJavaUsers;
    }
    
    public void setAppAuthJavaUsers(AppAuthJavaUsers appAuthJavaUsers) {
        this.appAuthJavaUsers = appAuthJavaUsers;
    }
    public Set getPurSuppWorksForInsertEmpId() {
        return this.purSuppWorksForInsertEmpId;
    }
    
    public void setPurSuppWorksForInsertEmpId(Set purSuppWorksForInsertEmpId) {
        this.purSuppWorksForInsertEmpId = purSuppWorksForInsertEmpId;
    }
    public Set getVcleRecordMovements() {
        return this.vcleRecordMovements;
    }
    
    public void setVcleRecordMovements(Set vcleRecordMovements) {
        this.vcleRecordMovements = vcleRecordMovements;
    }
    public Set getInvoInvoiceMasterStatuses() {
        return this.invoInvoiceMasterStatuses;
    }
    
    public void setInvoInvoiceMasterStatuses(Set invoInvoiceMasterStatuses) {
        this.invoInvoiceMasterStatuses = invoInvoiceMasterStatuses;
    }
    public Set getVcleVehicleIncomes() {
        return this.vcleVehicleIncomes;
    }
    
    public void setVcleVehicleIncomes(Set vcleVehicleIncomes) {
        this.vcleVehicleIncomes = vcleVehicleIncomes;
    }
    public Set getVcleTrafficLines() {
        return this.vcleTrafficLines;
    }
    
    public void setVcleTrafficLines(Set vcleTrafficLines) {
        this.vcleTrafficLines = vcleTrafficLines;
    }
    public Set getVcleMotorChanges() {
        return this.vcleMotorChanges;
    }
    
    public void setVcleMotorChanges(Set vcleMotorChanges) {
        this.vcleMotorChanges = vcleMotorChanges;
    }
    public Set getVcleVehicleRequireStatusDts() {
        return this.vcleVehicleRequireStatusDts;
    }
    
    public void setVcleVehicleRequireStatusDts(Set vcleVehicleRequireStatusDts) {
        this.vcleVehicleRequireStatusDts = vcleVehicleRequireStatusDts;
    }
    public Set getVcleIssueDocumentMans() {
        return this.vcleIssueDocumentMans;
    }
    
    public void setVcleIssueDocumentMans(Set vcleIssueDocumentMans) {
        this.vcleIssueDocumentMans = vcleIssueDocumentMans;
    }
    public Set getAppSubElemSpecAuthsForEmployeeId() {
        return this.appSubElemSpecAuthsForEmployeeId;
    }
    
    public void setAppSubElemSpecAuthsForEmployeeId(Set appSubElemSpecAuthsForEmployeeId) {
        this.appSubElemSpecAuthsForEmployeeId = appSubElemSpecAuthsForEmployeeId;
    }
    public Set getVcleVehicleLicenseDtls() {
        return this.vcleVehicleLicenseDtls;
    }
    
    public void setVcleVehicleLicenseDtls(Set vcleVehicleLicenseDtls) {
        this.vcleVehicleLicenseDtls = vcleVehicleLicenseDtls;
    }
    public Set getAppSubElemSpecAuthsForEmployeeIdAction() {
        return this.appSubElemSpecAuthsForEmployeeIdAction;
    }
    
    public void setAppSubElemSpecAuthsForEmployeeIdAction(Set appSubElemSpecAuthsForEmployeeIdAction) {
        this.appSubElemSpecAuthsForEmployeeIdAction = appSubElemSpecAuthsForEmployeeIdAction;
    }
    public Set getAppSubTabSpecAuthsForEmployeeId() {
        return this.appSubTabSpecAuthsForEmployeeId;
    }
    
    public void setAppSubTabSpecAuthsForEmployeeId(Set appSubTabSpecAuthsForEmployeeId) {
        this.appSubTabSpecAuthsForEmployeeId = appSubTabSpecAuthsForEmployeeId;
    }
    public Set getVcleTravelExchanges() {
        return this.vcleTravelExchanges;
    }
    
    public void setVcleTravelExchanges(Set vcleTravelExchanges) {
        this.vcleTravelExchanges = vcleTravelExchanges;
    }
    public Set getVcleVehicleLicensesForEmployeeIdReceive() {
        return this.vcleVehicleLicensesForEmployeeIdReceive;
    }
    
    public void setVcleVehicleLicensesForEmployeeIdReceive(Set vcleVehicleLicensesForEmployeeIdReceive) {
        this.vcleVehicleLicensesForEmployeeIdReceive = vcleVehicleLicensesForEmployeeIdReceive;
    }
    public Set getVcleRecordMovementJoins() {
        return this.vcleRecordMovementJoins;
    }
    
    public void setVcleRecordMovementJoins(Set vcleRecordMovementJoins) {
        this.vcleRecordMovementJoins = vcleRecordMovementJoins;
    }
    public Set getAppSubTabSpecAuthsForEmployeeIdAction() {
        return this.appSubTabSpecAuthsForEmployeeIdAction;
    }
    
    public void setAppSubTabSpecAuthsForEmployeeIdAction(Set appSubTabSpecAuthsForEmployeeIdAction) {
        this.appSubTabSpecAuthsForEmployeeIdAction = appSubTabSpecAuthsForEmployeeIdAction;
    }




}


