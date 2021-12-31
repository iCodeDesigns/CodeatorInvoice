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
 * VcleVehicleLicense generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_LICENSE"
    ,schema="CODEATOR"
)
public class VcleVehicleLicense  implements java.io.Serializable {


     private VcleVehicleLicenseId id;
     private VcleVehicleMaster vcleVehicleMaster;
     private VcleTrafficCode vcleTrafficCode;
     private VcleProcedureLicenseType vcleProcedureLicenseType;
     private VcleInsuranceCompany vcleInsuranceCompany;
     private PerEmploymentMaster perEmploymentMasterByEmployeeIdReceive;
     private PerEmploymentMaster perEmploymentMasterByEmployeeId;
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
     private Set<VcleVehicleLicenseDtl> vcleVehicleLicenseDtls = new HashSet<VcleVehicleLicenseDtl>(0);

    public VcleVehicleLicense() {
    }

	
    public VcleVehicleLicense(VcleVehicleLicenseId id, VcleVehicleMaster vcleVehicleMaster, VcleProcedureLicenseType vcleProcedureLicenseType) {
        this.id = id;
        this.vcleVehicleMaster = vcleVehicleMaster;
        this.vcleProcedureLicenseType = vcleProcedureLicenseType;
    }
    public VcleVehicleLicense(VcleVehicleLicenseId id, VcleVehicleMaster vcleVehicleMaster, VcleTrafficCode vcleTrafficCode, VcleProcedureLicenseType vcleProcedureLicenseType, VcleInsuranceCompany vcleInsuranceCompany, PerEmploymentMaster perEmploymentMasterByEmployeeIdReceive, PerEmploymentMaster perEmploymentMasterByEmployeeId, Date procedureDate, Date licenseEndDate, Date licenseReceiveDate, Date inspectDateOld, Date inspectDateNew, Long employeeIdRev, Integer formNum, BigDecimal totalValue, Integer boardNumberOld, String boardNumber, Integer boardDigital, String boardAlfa1, String boardAlfa2, String boardAlfa3, String motorNumberOld, String motorNumberNew, String shassNumberOld, String shassNumberNew, Long employeeIdDept, Long employeeIdMan, Boolean chkLock, String rmrk, Date currDate, Long userEmployeeNo, Integer boardDigitalNew, String boardAlfa1New, String boardAlfa2New, String boardAlfa3New, Integer vcleNum, Boolean changeType, Boolean certificateType, Boolean chkPrint, Set<VcleVehicleLicenseDtl> vcleVehicleLicenseDtls) {
       this.id = id;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.vcleTrafficCode = vcleTrafficCode;
       this.vcleProcedureLicenseType = vcleProcedureLicenseType;
       this.vcleInsuranceCompany = vcleInsuranceCompany;
       this.perEmploymentMasterByEmployeeIdReceive = perEmploymentMasterByEmployeeIdReceive;
       this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
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
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="vehicleSp", column=@Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="licenseMm", column=@Column(name="LICENSE_MM", nullable=false, length=7) ), 
        @AttributeOverride(name="licenseType", column=@Column(name="LICENSE_TYPE", nullable=false, precision=3, scale=0) ) } )
    public VcleVehicleLicenseId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleLicenseId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VEHICLE_SP", nullable=false, insertable=false, updatable=false)
    public VcleVehicleMaster getVcleVehicleMaster() {
        return this.vcleVehicleMaster;
    }
    
    public void setVcleVehicleMaster(VcleVehicleMaster vcleVehicleMaster) {
        this.vcleVehicleMaster = vcleVehicleMaster;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="TRAFFIC_CODE")
    public VcleTrafficCode getVcleTrafficCode() {
        return this.vcleTrafficCode;
    }
    
    public void setVcleTrafficCode(VcleTrafficCode vcleTrafficCode) {
        this.vcleTrafficCode = vcleTrafficCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="LICENSE_TYPE", nullable=false, insertable=false, updatable=false)
    public VcleProcedureLicenseType getVcleProcedureLicenseType() {
        return this.vcleProcedureLicenseType;
    }
    
    public void setVcleProcedureLicenseType(VcleProcedureLicenseType vcleProcedureLicenseType) {
        this.vcleProcedureLicenseType = vcleProcedureLicenseType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COMPANY_CODE")
    public VcleInsuranceCompany getVcleInsuranceCompany() {
        return this.vcleInsuranceCompany;
    }
    
    public void setVcleInsuranceCompany(VcleInsuranceCompany vcleInsuranceCompany) {
        this.vcleInsuranceCompany = vcleInsuranceCompany;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID_RECEIVE")
    public PerEmploymentMaster getPerEmploymentMasterByEmployeeIdReceive() {
        return this.perEmploymentMasterByEmployeeIdReceive;
    }
    
    public void setPerEmploymentMasterByEmployeeIdReceive(PerEmploymentMaster perEmploymentMasterByEmployeeIdReceive) {
        this.perEmploymentMasterByEmployeeIdReceive = perEmploymentMasterByEmployeeIdReceive;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
    public PerEmploymentMaster getPerEmploymentMasterByEmployeeId() {
        return this.perEmploymentMasterByEmployeeId;
    }
    
    public void setPerEmploymentMasterByEmployeeId(PerEmploymentMaster perEmploymentMasterByEmployeeId) {
        this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PROCEDURE_DATE", length=7)
    public Date getProcedureDate() {
        return this.procedureDate;
    }
    
    public void setProcedureDate(Date procedureDate) {
        this.procedureDate = procedureDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LICENSE_END_DATE", length=7)
    public Date getLicenseEndDate() {
        return this.licenseEndDate;
    }
    
    public void setLicenseEndDate(Date licenseEndDate) {
        this.licenseEndDate = licenseEndDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LICENSE_RECEIVE_DATE", length=7)
    public Date getLicenseReceiveDate() {
        return this.licenseReceiveDate;
    }
    
    public void setLicenseReceiveDate(Date licenseReceiveDate) {
        this.licenseReceiveDate = licenseReceiveDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INSPECT_DATE_OLD", length=7)
    public Date getInspectDateOld() {
        return this.inspectDateOld;
    }
    
    public void setInspectDateOld(Date inspectDateOld) {
        this.inspectDateOld = inspectDateOld;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INSPECT_DATE_NEW", length=7)
    public Date getInspectDateNew() {
        return this.inspectDateNew;
    }
    
    public void setInspectDateNew(Date inspectDateNew) {
        this.inspectDateNew = inspectDateNew;
    }

    
    @Column(name="EMPLOYEE_ID_REV", precision=10, scale=0)
    public Long getEmployeeIdRev() {
        return this.employeeIdRev;
    }
    
    public void setEmployeeIdRev(Long employeeIdRev) {
        this.employeeIdRev = employeeIdRev;
    }

    
    @Column(name="FORM_NUM", precision=6, scale=0)
    public Integer getFormNum() {
        return this.formNum;
    }
    
    public void setFormNum(Integer formNum) {
        this.formNum = formNum;
    }

    
    @Column(name="TOTAL_VALUE", precision=9)
    public BigDecimal getTotalValue() {
        return this.totalValue;
    }
    
    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    
    @Column(name="BOARD_NUMBER_OLD", precision=8, scale=0)
    public Integer getBoardNumberOld() {
        return this.boardNumberOld;
    }
    
    public void setBoardNumberOld(Integer boardNumberOld) {
        this.boardNumberOld = boardNumberOld;
    }

    
    @Column(name="BOARD_NUMBER", length=12)
    public String getBoardNumber() {
        return this.boardNumber;
    }
    
    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }

    
    @Column(name="BOARD_DIGITAL", precision=6, scale=0)
    public Integer getBoardDigital() {
        return this.boardDigital;
    }
    
    public void setBoardDigital(Integer boardDigital) {
        this.boardDigital = boardDigital;
    }

    
    @Column(name="BOARD_ALFA1", length=1)
    public String getBoardAlfa1() {
        return this.boardAlfa1;
    }
    
    public void setBoardAlfa1(String boardAlfa1) {
        this.boardAlfa1 = boardAlfa1;
    }

    
    @Column(name="BOARD_ALFA2", length=1)
    public String getBoardAlfa2() {
        return this.boardAlfa2;
    }
    
    public void setBoardAlfa2(String boardAlfa2) {
        this.boardAlfa2 = boardAlfa2;
    }

    
    @Column(name="BOARD_ALFA3", length=1)
    public String getBoardAlfa3() {
        return this.boardAlfa3;
    }
    
    public void setBoardAlfa3(String boardAlfa3) {
        this.boardAlfa3 = boardAlfa3;
    }

    
    @Column(name="MOTOR_NUMBER_OLD", length=40)
    public String getMotorNumberOld() {
        return this.motorNumberOld;
    }
    
    public void setMotorNumberOld(String motorNumberOld) {
        this.motorNumberOld = motorNumberOld;
    }

    
    @Column(name="MOTOR_NUMBER_NEW", length=40)
    public String getMotorNumberNew() {
        return this.motorNumberNew;
    }
    
    public void setMotorNumberNew(String motorNumberNew) {
        this.motorNumberNew = motorNumberNew;
    }

    
    @Column(name="SHASS_NUMBER_OLD", length=20)
    public String getShassNumberOld() {
        return this.shassNumberOld;
    }
    
    public void setShassNumberOld(String shassNumberOld) {
        this.shassNumberOld = shassNumberOld;
    }

    
    @Column(name="SHASS_NUMBER_NEW", length=20)
    public String getShassNumberNew() {
        return this.shassNumberNew;
    }
    
    public void setShassNumberNew(String shassNumberNew) {
        this.shassNumberNew = shassNumberNew;
    }

    
    @Column(name="EMPLOYEE_ID_DEPT", precision=10, scale=0)
    public Long getEmployeeIdDept() {
        return this.employeeIdDept;
    }
    
    public void setEmployeeIdDept(Long employeeIdDept) {
        this.employeeIdDept = employeeIdDept;
    }

    
    @Column(name="EMPLOYEE_ID_MAN", precision=10, scale=0)
    public Long getEmployeeIdMan() {
        return this.employeeIdMan;
    }
    
    public void setEmployeeIdMan(Long employeeIdMan) {
        this.employeeIdMan = employeeIdMan;
    }

    
    @Column(name="CHK_LOCK", precision=1, scale=0)
    public Boolean getChkLock() {
        return this.chkLock;
    }
    
    public void setChkLock(Boolean chkLock) {
        this.chkLock = chkLock;
    }

    
    @Column(name="RMRK", length=200)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CURR_DATE", length=7)
    public Date getCurrDate() {
        return this.currDate;
    }
    
    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }

    
    @Column(name="USER_EMPLOYEE_NO", precision=10, scale=0)
    public Long getUserEmployeeNo() {
        return this.userEmployeeNo;
    }
    
    public void setUserEmployeeNo(Long userEmployeeNo) {
        this.userEmployeeNo = userEmployeeNo;
    }

    
    @Column(name="BOARD_DIGITAL_NEW", precision=6, scale=0)
    public Integer getBoardDigitalNew() {
        return this.boardDigitalNew;
    }
    
    public void setBoardDigitalNew(Integer boardDigitalNew) {
        this.boardDigitalNew = boardDigitalNew;
    }

    
    @Column(name="BOARD_ALFA1_NEW", length=1)
    public String getBoardAlfa1New() {
        return this.boardAlfa1New;
    }
    
    public void setBoardAlfa1New(String boardAlfa1New) {
        this.boardAlfa1New = boardAlfa1New;
    }

    
    @Column(name="BOARD_ALFA2_NEW", length=1)
    public String getBoardAlfa2New() {
        return this.boardAlfa2New;
    }
    
    public void setBoardAlfa2New(String boardAlfa2New) {
        this.boardAlfa2New = boardAlfa2New;
    }

    
    @Column(name="BOARD_ALFA3_NEW", length=1)
    public String getBoardAlfa3New() {
        return this.boardAlfa3New;
    }
    
    public void setBoardAlfa3New(String boardAlfa3New) {
        this.boardAlfa3New = boardAlfa3New;
    }

    
    @Column(name="VCLE_NUM", precision=6, scale=0)
    public Integer getVcleNum() {
        return this.vcleNum;
    }
    
    public void setVcleNum(Integer vcleNum) {
        this.vcleNum = vcleNum;
    }

    
    @Column(name="CHANGE_TYPE", precision=1, scale=0)
    public Boolean getChangeType() {
        return this.changeType;
    }
    
    public void setChangeType(Boolean changeType) {
        this.changeType = changeType;
    }

    
    @Column(name="CERTIFICATE_TYPE", precision=1, scale=0)
    public Boolean getCertificateType() {
        return this.certificateType;
    }
    
    public void setCertificateType(Boolean certificateType) {
        this.certificateType = certificateType;
    }

    
    @Column(name="CHK_PRINT", precision=1, scale=0)
    public Boolean getChkPrint() {
        return this.chkPrint;
    }
    
    public void setChkPrint(Boolean chkPrint) {
        this.chkPrint = chkPrint;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleVehicleLicense")
    public Set<VcleVehicleLicenseDtl> getVcleVehicleLicenseDtls() {
        return this.vcleVehicleLicenseDtls;
    }
    
    public void setVcleVehicleLicenseDtls(Set<VcleVehicleLicenseDtl> vcleVehicleLicenseDtls) {
        this.vcleVehicleLicenseDtls = vcleVehicleLicenseDtls;
    }




}


