package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * VcleVehicleLicense generated by hbm2java
 */
public class VcleVehicleLicense  implements java.io.Serializable {


     private VcleVehicleLicenseId id;
     private VcleInsuranceCompany vcleInsuranceCompany;
     private PerEmploymentMaster perEmploymentMasterByEmployeeId;
     private PerEmploymentMaster perEmploymentMasterByEmployeeIdReceive;
     private VcleProcedureLicenseType vcleProcedureLicenseType;
     private VcleTrafficCode vcleTrafficCode;
     private VcleVehicleMaster vcleVehicleMaster;
     private Date procedureDate;
     private Date licenseEndDate;
     private Date licenseReceiveDate;
     private Date inspectDateOld;
     private Date inspectDateNew;
     private Long employeeIdRev;
     private Integer formNum;
     private BigDecimal totalValue;
     private Integer boardNumberOld;
     private String boardNumber;
     private Integer boardDigital;
     private String boardAlfa1;
     private String boardAlfa2;
     private String boardAlfa3;
     private String motorNumberOld;
     private String motorNumberNew;
     private String shassNumberOld;
     private String shassNumberNew;
     private Long employeeIdDept;
     private Long employeeIdMan;
     private Boolean chkLock;
     private String rmrk;
     private Date currDate;
     private Long userEmployeeNo;
     private Integer boardDigitalNew;
     private String boardAlfa1New;
     private String boardAlfa2New;
     private String boardAlfa3New;
     private Integer vcleNum;
     private Boolean changeType;
     private Boolean certificateType;
     private Boolean chkPrint;
     private Set vcleVehicleLicenseDtls = new HashSet(0);

    public VcleVehicleLicense() {
    }

	
    public VcleVehicleLicense(VcleVehicleLicenseId id, VcleProcedureLicenseType vcleProcedureLicenseType, VcleVehicleMaster vcleVehicleMaster) {
        this.id = id;
        this.vcleProcedureLicenseType = vcleProcedureLicenseType;
        this.vcleVehicleMaster = vcleVehicleMaster;
    }
    public VcleVehicleLicense(VcleVehicleLicenseId id, VcleInsuranceCompany vcleInsuranceCompany, PerEmploymentMaster perEmploymentMasterByEmployeeId, PerEmploymentMaster perEmploymentMasterByEmployeeIdReceive, VcleProcedureLicenseType vcleProcedureLicenseType, VcleTrafficCode vcleTrafficCode, VcleVehicleMaster vcleVehicleMaster, Date procedureDate, Date licenseEndDate, Date licenseReceiveDate, Date inspectDateOld, Date inspectDateNew, Long employeeIdRev, Integer formNum, BigDecimal totalValue, Integer boardNumberOld, String boardNumber, Integer boardDigital, String boardAlfa1, String boardAlfa2, String boardAlfa3, String motorNumberOld, String motorNumberNew, String shassNumberOld, String shassNumberNew, Long employeeIdDept, Long employeeIdMan, Boolean chkLock, String rmrk, Date currDate, Long userEmployeeNo, Integer boardDigitalNew, String boardAlfa1New, String boardAlfa2New, String boardAlfa3New, Integer vcleNum, Boolean changeType, Boolean certificateType, Boolean chkPrint, Set vcleVehicleLicenseDtls) {
       this.id = id;
       this.vcleInsuranceCompany = vcleInsuranceCompany;
       this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
       this.perEmploymentMasterByEmployeeIdReceive = perEmploymentMasterByEmployeeIdReceive;
       this.vcleProcedureLicenseType = vcleProcedureLicenseType;
       this.vcleTrafficCode = vcleTrafficCode;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.procedureDate = procedureDate;
       this.licenseEndDate = licenseEndDate;
       this.licenseReceiveDate = licenseReceiveDate;
       this.inspectDateOld = inspectDateOld;
       this.inspectDateNew = inspectDateNew;
       this.employeeIdRev = employeeIdRev;
       this.formNum = formNum;
       this.totalValue = totalValue;
       this.boardNumberOld = boardNumberOld;
       this.boardNumber = boardNumber;
       this.boardDigital = boardDigital;
       this.boardAlfa1 = boardAlfa1;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa3 = boardAlfa3;
       this.motorNumberOld = motorNumberOld;
       this.motorNumberNew = motorNumberNew;
       this.shassNumberOld = shassNumberOld;
       this.shassNumberNew = shassNumberNew;
       this.employeeIdDept = employeeIdDept;
       this.employeeIdMan = employeeIdMan;
       this.chkLock = chkLock;
       this.rmrk = rmrk;
       this.currDate = currDate;
       this.userEmployeeNo = userEmployeeNo;
       this.boardDigitalNew = boardDigitalNew;
       this.boardAlfa1New = boardAlfa1New;
       this.boardAlfa2New = boardAlfa2New;
       this.boardAlfa3New = boardAlfa3New;
       this.vcleNum = vcleNum;
       this.changeType = changeType;
       this.certificateType = certificateType;
       this.chkPrint = chkPrint;
       this.vcleVehicleLicenseDtls = vcleVehicleLicenseDtls;
    }
   
    public VcleVehicleLicenseId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleLicenseId id) {
        this.id = id;
    }
    public VcleInsuranceCompany getVcleInsuranceCompany() {
        return this.vcleInsuranceCompany;
    }
    
    public void setVcleInsuranceCompany(VcleInsuranceCompany vcleInsuranceCompany) {
        this.vcleInsuranceCompany = vcleInsuranceCompany;
    }
    public PerEmploymentMaster getPerEmploymentMasterByEmployeeId() {
        return this.perEmploymentMasterByEmployeeId;
    }
    
    public void setPerEmploymentMasterByEmployeeId(PerEmploymentMaster perEmploymentMasterByEmployeeId) {
        this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
    }
    public PerEmploymentMaster getPerEmploymentMasterByEmployeeIdReceive() {
        return this.perEmploymentMasterByEmployeeIdReceive;
    }
    
    public void setPerEmploymentMasterByEmployeeIdReceive(PerEmploymentMaster perEmploymentMasterByEmployeeIdReceive) {
        this.perEmploymentMasterByEmployeeIdReceive = perEmploymentMasterByEmployeeIdReceive;
    }
    public VcleProcedureLicenseType getVcleProcedureLicenseType() {
        return this.vcleProcedureLicenseType;
    }
    
    public void setVcleProcedureLicenseType(VcleProcedureLicenseType vcleProcedureLicenseType) {
        this.vcleProcedureLicenseType = vcleProcedureLicenseType;
    }
    public VcleTrafficCode getVcleTrafficCode() {
        return this.vcleTrafficCode;
    }
    
    public void setVcleTrafficCode(VcleTrafficCode vcleTrafficCode) {
        this.vcleTrafficCode = vcleTrafficCode;
    }
    public VcleVehicleMaster getVcleVehicleMaster() {
        return this.vcleVehicleMaster;
    }
    
    public void setVcleVehicleMaster(VcleVehicleMaster vcleVehicleMaster) {
        this.vcleVehicleMaster = vcleVehicleMaster;
    }
    public Date getProcedureDate() {
        return this.procedureDate;
    }
    
    public void setProcedureDate(Date procedureDate) {
        this.procedureDate = procedureDate;
    }
    public Date getLicenseEndDate() {
        return this.licenseEndDate;
    }
    
    public void setLicenseEndDate(Date licenseEndDate) {
        this.licenseEndDate = licenseEndDate;
    }
    public Date getLicenseReceiveDate() {
        return this.licenseReceiveDate;
    }
    
    public void setLicenseReceiveDate(Date licenseReceiveDate) {
        this.licenseReceiveDate = licenseReceiveDate;
    }
    public Date getInspectDateOld() {
        return this.inspectDateOld;
    }
    
    public void setInspectDateOld(Date inspectDateOld) {
        this.inspectDateOld = inspectDateOld;
    }
    public Date getInspectDateNew() {
        return this.inspectDateNew;
    }
    
    public void setInspectDateNew(Date inspectDateNew) {
        this.inspectDateNew = inspectDateNew;
    }
    public Long getEmployeeIdRev() {
        return this.employeeIdRev;
    }
    
    public void setEmployeeIdRev(Long employeeIdRev) {
        this.employeeIdRev = employeeIdRev;
    }
    public Integer getFormNum() {
        return this.formNum;
    }
    
    public void setFormNum(Integer formNum) {
        this.formNum = formNum;
    }
    public BigDecimal getTotalValue() {
        return this.totalValue;
    }
    
    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
    public Integer getBoardNumberOld() {
        return this.boardNumberOld;
    }
    
    public void setBoardNumberOld(Integer boardNumberOld) {
        this.boardNumberOld = boardNumberOld;
    }
    public String getBoardNumber() {
        return this.boardNumber;
    }
    
    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }
    public Integer getBoardDigital() {
        return this.boardDigital;
    }
    
    public void setBoardDigital(Integer boardDigital) {
        this.boardDigital = boardDigital;
    }
    public String getBoardAlfa1() {
        return this.boardAlfa1;
    }
    
    public void setBoardAlfa1(String boardAlfa1) {
        this.boardAlfa1 = boardAlfa1;
    }
    public String getBoardAlfa2() {
        return this.boardAlfa2;
    }
    
    public void setBoardAlfa2(String boardAlfa2) {
        this.boardAlfa2 = boardAlfa2;
    }
    public String getBoardAlfa3() {
        return this.boardAlfa3;
    }
    
    public void setBoardAlfa3(String boardAlfa3) {
        this.boardAlfa3 = boardAlfa3;
    }
    public String getMotorNumberOld() {
        return this.motorNumberOld;
    }
    
    public void setMotorNumberOld(String motorNumberOld) {
        this.motorNumberOld = motorNumberOld;
    }
    public String getMotorNumberNew() {
        return this.motorNumberNew;
    }
    
    public void setMotorNumberNew(String motorNumberNew) {
        this.motorNumberNew = motorNumberNew;
    }
    public String getShassNumberOld() {
        return this.shassNumberOld;
    }
    
    public void setShassNumberOld(String shassNumberOld) {
        this.shassNumberOld = shassNumberOld;
    }
    public String getShassNumberNew() {
        return this.shassNumberNew;
    }
    
    public void setShassNumberNew(String shassNumberNew) {
        this.shassNumberNew = shassNumberNew;
    }
    public Long getEmployeeIdDept() {
        return this.employeeIdDept;
    }
    
    public void setEmployeeIdDept(Long employeeIdDept) {
        this.employeeIdDept = employeeIdDept;
    }
    public Long getEmployeeIdMan() {
        return this.employeeIdMan;
    }
    
    public void setEmployeeIdMan(Long employeeIdMan) {
        this.employeeIdMan = employeeIdMan;
    }
    public Boolean getChkLock() {
        return this.chkLock;
    }
    
    public void setChkLock(Boolean chkLock) {
        this.chkLock = chkLock;
    }
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }
    public Date getCurrDate() {
        return this.currDate;
    }
    
    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }
    public Long getUserEmployeeNo() {
        return this.userEmployeeNo;
    }
    
    public void setUserEmployeeNo(Long userEmployeeNo) {
        this.userEmployeeNo = userEmployeeNo;
    }
    public Integer getBoardDigitalNew() {
        return this.boardDigitalNew;
    }
    
    public void setBoardDigitalNew(Integer boardDigitalNew) {
        this.boardDigitalNew = boardDigitalNew;
    }
    public String getBoardAlfa1New() {
        return this.boardAlfa1New;
    }
    
    public void setBoardAlfa1New(String boardAlfa1New) {
        this.boardAlfa1New = boardAlfa1New;
    }
    public String getBoardAlfa2New() {
        return this.boardAlfa2New;
    }
    
    public void setBoardAlfa2New(String boardAlfa2New) {
        this.boardAlfa2New = boardAlfa2New;
    }
    public String getBoardAlfa3New() {
        return this.boardAlfa3New;
    }
    
    public void setBoardAlfa3New(String boardAlfa3New) {
        this.boardAlfa3New = boardAlfa3New;
    }
    public Integer getVcleNum() {
        return this.vcleNum;
    }
    
    public void setVcleNum(Integer vcleNum) {
        this.vcleNum = vcleNum;
    }
    public Boolean getChangeType() {
        return this.changeType;
    }
    
    public void setChangeType(Boolean changeType) {
        this.changeType = changeType;
    }
    public Boolean getCertificateType() {
        return this.certificateType;
    }
    
    public void setCertificateType(Boolean certificateType) {
        this.certificateType = certificateType;
    }
    public Boolean getChkPrint() {
        return this.chkPrint;
    }
    
    public void setChkPrint(Boolean chkPrint) {
        this.chkPrint = chkPrint;
    }
    public Set getVcleVehicleLicenseDtls() {
        return this.vcleVehicleLicenseDtls;
    }
    
    public void setVcleVehicleLicenseDtls(Set vcleVehicleLicenseDtls) {
        this.vcleVehicleLicenseDtls = vcleVehicleLicenseDtls;
    }




}


