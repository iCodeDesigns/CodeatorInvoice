package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleVehicleRequire generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_REQUIRE"
    ,schema="CODEATOR"
)
public class VcleVehicleRequire  implements java.io.Serializable {


     private long requireSp;
     private VcleVehicleType vcleVehicleType;
     private VcleVehicleRequireStatus vcleVehicleRequireStatus;
     private VcleVehicleRequire vcleVehicleRequire;
     private VcleVehicleMaster vcleVehicleMaster;
     private PerEmploymentMaster perEmploymentMasterByEmployeeIdDriver;
     private PerEmploymentMaster perEmploymentMasterByEmployeeId;
     private PerDeptOld perDeptOld;
     private byte requireType;
     private Byte reqNo;
     private Date requireDate;
     private String requireStartHour;
     private String requireEndHour;
     private String requirePlace;
     private String driverPlace;
     private Date execDate;
     private Date delayDate;
     private Long employeeNoApproval;
     private Byte chkOk;
     private String currDate;
     private String requireDateTime;
     private Byte guestNo;
     private Date requireToDate;
     private String requireToDateTime;
     private Byte totDay;
     private Set<VcleVehicleRequire> vcleVehicleRequires = new HashSet<VcleVehicleRequire>(0);
     private Set<VcleVehicleRequireStatusDt> vcleVehicleRequireStatusDts = new HashSet<VcleVehicleRequireStatusDt>(0);
     private VcleRecordMovementJoin vcleRecordMovementJoin;

    public VcleVehicleRequire() {
    }

	
    public VcleVehicleRequire(long requireSp, VcleVehicleType vcleVehicleType, VcleVehicleRequireStatus vcleVehicleRequireStatus, PerEmploymentMaster perEmploymentMasterByEmployeeId, PerDeptOld perDeptOld, byte requireType) {
        this.requireSp = requireSp;
        this.vcleVehicleType = vcleVehicleType;
        this.vcleVehicleRequireStatus = vcleVehicleRequireStatus;
        this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
        this.perDeptOld = perDeptOld;
        this.requireType = requireType;
    }
    public VcleVehicleRequire(long requireSp, VcleVehicleType vcleVehicleType, VcleVehicleRequireStatus vcleVehicleRequireStatus, VcleVehicleRequire vcleVehicleRequire, VcleVehicleMaster vcleVehicleMaster, PerEmploymentMaster perEmploymentMasterByEmployeeIdDriver, PerEmploymentMaster perEmploymentMasterByEmployeeId, PerDeptOld perDeptOld, byte requireType, Byte reqNo, Date requireDate, String requireStartHour, String requireEndHour, String requirePlace, String driverPlace, Date execDate, Date delayDate, Long employeeNoApproval, Byte chkOk, String currDate, String requireDateTime, Byte guestNo, Date requireToDate, String requireToDateTime, Byte totDay, Set<VcleVehicleRequire> vcleVehicleRequires, Set<VcleVehicleRequireStatusDt> vcleVehicleRequireStatusDts, VcleRecordMovementJoin vcleRecordMovementJoin) {
       this.requireSp = requireSp;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleVehicleRequireStatus = vcleVehicleRequireStatus;
       this.vcleVehicleRequire = vcleVehicleRequire;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.perEmploymentMasterByEmployeeIdDriver = perEmploymentMasterByEmployeeIdDriver;
       this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
       this.perDeptOld = perDeptOld;
       this.requireType = requireType;
       this.reqNo = reqNo;
       this.requireDate = requireDate;
       this.requireStartHour = requireStartHour;
       this.requireEndHour = requireEndHour;
       this.requirePlace = requirePlace;
       this.driverPlace = driverPlace;
       this.execDate = execDate;
       this.delayDate = delayDate;
       this.employeeNoApproval = employeeNoApproval;
       this.chkOk = chkOk;
       this.currDate = currDate;
       this.requireDateTime = requireDateTime;
       this.guestNo = guestNo;
       this.requireToDate = requireToDate;
       this.requireToDateTime = requireToDateTime;
       this.totDay = totDay;
       this.vcleVehicleRequires = vcleVehicleRequires;
       this.vcleVehicleRequireStatusDts = vcleVehicleRequireStatusDts;
       this.vcleRecordMovementJoin = vcleRecordMovementJoin;
    }
   
     @Id 

    
    @Column(name="REQUIRE_SP", unique=true, nullable=false, precision=11, scale=0)
    public long getRequireSp() {
        return this.requireSp;
    }
    
    public void setRequireSp(long requireSp) {
        this.requireSp = requireSp;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VCLE_TYPE", nullable=false)
    public VcleVehicleType getVcleVehicleType() {
        return this.vcleVehicleType;
    }
    
    public void setVcleVehicleType(VcleVehicleType vcleVehicleType) {
        this.vcleVehicleType = vcleVehicleType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="REQUIRE_STATUS", nullable=false)
    public VcleVehicleRequireStatus getVcleVehicleRequireStatus() {
        return this.vcleVehicleRequireStatus;
    }
    
    public void setVcleVehicleRequireStatus(VcleVehicleRequireStatus vcleVehicleRequireStatus) {
        this.vcleVehicleRequireStatus = vcleVehicleRequireStatus;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="REQUIRE_SP_OLD")
    public VcleVehicleRequire getVcleVehicleRequire() {
        return this.vcleVehicleRequire;
    }
    
    public void setVcleVehicleRequire(VcleVehicleRequire vcleVehicleRequire) {
        this.vcleVehicleRequire = vcleVehicleRequire;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VEHICLE_SP")
    public VcleVehicleMaster getVcleVehicleMaster() {
        return this.vcleVehicleMaster;
    }
    
    public void setVcleVehicleMaster(VcleVehicleMaster vcleVehicleMaster) {
        this.vcleVehicleMaster = vcleVehicleMaster;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID_DRIVER")
    public PerEmploymentMaster getPerEmploymentMasterByEmployeeIdDriver() {
        return this.perEmploymentMasterByEmployeeIdDriver;
    }
    
    public void setPerEmploymentMasterByEmployeeIdDriver(PerEmploymentMaster perEmploymentMasterByEmployeeIdDriver) {
        this.perEmploymentMasterByEmployeeIdDriver = perEmploymentMasterByEmployeeIdDriver;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false)
    public PerEmploymentMaster getPerEmploymentMasterByEmployeeId() {
        return this.perEmploymentMasterByEmployeeId;
    }
    
    public void setPerEmploymentMasterByEmployeeId(PerEmploymentMaster perEmploymentMasterByEmployeeId) {
        this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="SECTION_NO_OLD", referencedColumnName="SECTION_NO_OLD", nullable=false), 
        @JoinColumn(name="DEP_NO_OLD", referencedColumnName="DEP_NO_OLD", nullable=false) } )
    public PerDeptOld getPerDeptOld() {
        return this.perDeptOld;
    }
    
    public void setPerDeptOld(PerDeptOld perDeptOld) {
        this.perDeptOld = perDeptOld;
    }

    
    @Column(name="REQUIRE_TYPE", nullable=false, precision=2, scale=0)
    public byte getRequireType() {
        return this.requireType;
    }
    
    public void setRequireType(byte requireType) {
        this.requireType = requireType;
    }

    
    @Column(name="REQ_NO", precision=2, scale=0)
    public Byte getReqNo() {
        return this.reqNo;
    }
    
    public void setReqNo(Byte reqNo) {
        this.reqNo = reqNo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="REQUIRE_DATE", length=7)
    public Date getRequireDate() {
        return this.requireDate;
    }
    
    public void setRequireDate(Date requireDate) {
        this.requireDate = requireDate;
    }

    
    @Column(name="REQUIRE_START_HOUR", length=20)
    public String getRequireStartHour() {
        return this.requireStartHour;
    }
    
    public void setRequireStartHour(String requireStartHour) {
        this.requireStartHour = requireStartHour;
    }

    
    @Column(name="REQUIRE_END_HOUR", length=20)
    public String getRequireEndHour() {
        return this.requireEndHour;
    }
    
    public void setRequireEndHour(String requireEndHour) {
        this.requireEndHour = requireEndHour;
    }

    
    @Column(name="REQUIRE_PLACE", length=100)
    public String getRequirePlace() {
        return this.requirePlace;
    }
    
    public void setRequirePlace(String requirePlace) {
        this.requirePlace = requirePlace;
    }

    
    @Column(name="DRIVER_PLACE", length=100)
    public String getDriverPlace() {
        return this.driverPlace;
    }
    
    public void setDriverPlace(String driverPlace) {
        this.driverPlace = driverPlace;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="EXEC_DATE", length=7)
    public Date getExecDate() {
        return this.execDate;
    }
    
    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DELAY_DATE", length=7)
    public Date getDelayDate() {
        return this.delayDate;
    }
    
    public void setDelayDate(Date delayDate) {
        this.delayDate = delayDate;
    }

    
    @Column(name="EMPLOYEE_NO_APPROVAL", precision=11, scale=0)
    public Long getEmployeeNoApproval() {
        return this.employeeNoApproval;
    }
    
    public void setEmployeeNoApproval(Long employeeNoApproval) {
        this.employeeNoApproval = employeeNoApproval;
    }

    
    @Column(name="CHK_OK", precision=2, scale=0)
    public Byte getChkOk() {
        return this.chkOk;
    }
    
    public void setChkOk(Byte chkOk) {
        this.chkOk = chkOk;
    }

    
    @Column(name="CURR_DATE", length=20)
    public String getCurrDate() {
        return this.currDate;
    }
    
    public void setCurrDate(String currDate) {
        this.currDate = currDate;
    }

    
    @Column(name="REQUIRE_DATE_TIME", length=20)
    public String getRequireDateTime() {
        return this.requireDateTime;
    }
    
    public void setRequireDateTime(String requireDateTime) {
        this.requireDateTime = requireDateTime;
    }

    
    @Column(name="GUEST_NO", precision=2, scale=0)
    public Byte getGuestNo() {
        return this.guestNo;
    }
    
    public void setGuestNo(Byte guestNo) {
        this.guestNo = guestNo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="REQUIRE_TO_DATE", length=7)
    public Date getRequireToDate() {
        return this.requireToDate;
    }
    
    public void setRequireToDate(Date requireToDate) {
        this.requireToDate = requireToDate;
    }

    
    @Column(name="REQUIRE_TO_DATE_TIME", length=20)
    public String getRequireToDateTime() {
        return this.requireToDateTime;
    }
    
    public void setRequireToDateTime(String requireToDateTime) {
        this.requireToDateTime = requireToDateTime;
    }

    
    @Column(name="TOT_DAY", precision=2, scale=0)
    public Byte getTotDay() {
        return this.totDay;
    }
    
    public void setTotDay(Byte totDay) {
        this.totDay = totDay;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleVehicleRequire")
    public Set<VcleVehicleRequire> getVcleVehicleRequires() {
        return this.vcleVehicleRequires;
    }
    
    public void setVcleVehicleRequires(Set<VcleVehicleRequire> vcleVehicleRequires) {
        this.vcleVehicleRequires = vcleVehicleRequires;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleVehicleRequire")
    public Set<VcleVehicleRequireStatusDt> getVcleVehicleRequireStatusDts() {
        return this.vcleVehicleRequireStatusDts;
    }
    
    public void setVcleVehicleRequireStatusDts(Set<VcleVehicleRequireStatusDt> vcleVehicleRequireStatusDts) {
        this.vcleVehicleRequireStatusDts = vcleVehicleRequireStatusDts;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="vcleVehicleRequire")
    public VcleRecordMovementJoin getVcleRecordMovementJoin() {
        return this.vcleRecordMovementJoin;
    }
    
    public void setVcleRecordMovementJoin(VcleRecordMovementJoin vcleRecordMovementJoin) {
        this.vcleRecordMovementJoin = vcleRecordMovementJoin;
    }




}


