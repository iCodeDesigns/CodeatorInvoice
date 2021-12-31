package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleFuelIssueLiquid generated by hbm2java
 */
@Entity
@Table(name="VCLE_FUEL_ISSUE_LIQUID"
    ,schema="CODEATOR"
)
public class VcleFuelIssueLiquid  implements java.io.Serializable {


     private VcleFuelIssueLiquidId id;
     private VcleWorkshopeCode vcleWorkshopeCode;
     private VcleVehicleType vcleVehicleType;
     private VcleVehicleMaster vcleVehicleMaster;
     private VcleShiftType vcleShiftType;
     private VcleFuelOpenDay vcleFuelOpenDay;
     private VcleEmployeeMaster vcleEmployeeMaster;
     private VcleDeptNumber vcleDeptNumber;
     private Boolean fuelType;
     private BigDecimal issueQun;
     private BigDecimal fuelRate;
     private Long eznSeqIss;
     private Integer boardDigital;
     private String boardAlfa1;
     private String boardAlfa2;
     private String boardAlfa3;
     private Boolean chkLock;
     private String rmrk;
     private BigDecimal tankNum;
     private Integer boardNumberOld;
     private Long countNumber;
     private Boolean chkBarrel;
     private Byte chkOwner;
     private Date fiscalDate;
     private BigDecimal issueSal;
     private BigDecimal issueVal;
     private Date provideExecDate;

    public VcleFuelIssueLiquid() {
    }

	
    public VcleFuelIssueLiquid(VcleFuelIssueLiquidId id, VcleFuelOpenDay vcleFuelOpenDay) {
        this.id = id;
        this.vcleFuelOpenDay = vcleFuelOpenDay;
    }
    public VcleFuelIssueLiquid(VcleFuelIssueLiquidId id, VcleWorkshopeCode vcleWorkshopeCode, VcleVehicleType vcleVehicleType, VcleVehicleMaster vcleVehicleMaster, VcleShiftType vcleShiftType, VcleFuelOpenDay vcleFuelOpenDay, VcleEmployeeMaster vcleEmployeeMaster, VcleDeptNumber vcleDeptNumber, Boolean fuelType, BigDecimal issueQun, BigDecimal fuelRate, Long eznSeqIss, Integer boardDigital, String boardAlfa1, String boardAlfa2, String boardAlfa3, Boolean chkLock, String rmrk, BigDecimal tankNum, Integer boardNumberOld, Long countNumber, Boolean chkBarrel, Byte chkOwner, Date fiscalDate, BigDecimal issueSal, BigDecimal issueVal, Date provideExecDate) {
       this.id = id;
       this.vcleWorkshopeCode = vcleWorkshopeCode;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.vcleShiftType = vcleShiftType;
       this.vcleFuelOpenDay = vcleFuelOpenDay;
       this.vcleEmployeeMaster = vcleEmployeeMaster;
       this.vcleDeptNumber = vcleDeptNumber;
       this.fuelType = fuelType;
       this.issueQun = issueQun;
       this.fuelRate = fuelRate;
       this.eznSeqIss = eznSeqIss;
       this.boardDigital = boardDigital;
       this.boardAlfa1 = boardAlfa1;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa3 = boardAlfa3;
       this.chkLock = chkLock;
       this.rmrk = rmrk;
       this.tankNum = tankNum;
       this.boardNumberOld = boardNumberOld;
       this.countNumber = countNumber;
       this.chkBarrel = chkBarrel;
       this.chkOwner = chkOwner;
       this.fiscalDate = fiscalDate;
       this.issueSal = issueSal;
       this.issueVal = issueVal;
       this.provideExecDate = provideExecDate;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="locCode", column=@Column(name="LOC_CODE", nullable=false, length=3) ), 
        @AttributeOverride(name="issueSp", column=@Column(name="ISSUE_SP", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="sideType", column=@Column(name="SIDE_TYPE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="execDate", column=@Column(name="EXEC_DATE", nullable=false, length=7) ) } )
    public VcleFuelIssueLiquidId getId() {
        return this.id;
    }
    
    public void setId(VcleFuelIssueLiquidId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="WORKSHOPE_CODE")
    public VcleWorkshopeCode getVcleWorkshopeCode() {
        return this.vcleWorkshopeCode;
    }
    
    public void setVcleWorkshopeCode(VcleWorkshopeCode vcleWorkshopeCode) {
        this.vcleWorkshopeCode = vcleWorkshopeCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VCLE_TYPE")
    public VcleVehicleType getVcleVehicleType() {
        return this.vcleVehicleType;
    }
    
    public void setVcleVehicleType(VcleVehicleType vcleVehicleType) {
        this.vcleVehicleType = vcleVehicleType;
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
    @JoinColumn(name="SHIFT_TYPE")
    public VcleShiftType getVcleShiftType() {
        return this.vcleShiftType;
    }
    
    public void setVcleShiftType(VcleShiftType vcleShiftType) {
        this.vcleShiftType = vcleShiftType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EXEC_DATE", nullable=false, insertable=false, updatable=false)
    public VcleFuelOpenDay getVcleFuelOpenDay() {
        return this.vcleFuelOpenDay;
    }
    
    public void setVcleFuelOpenDay(VcleFuelOpenDay vcleFuelOpenDay) {
        this.vcleFuelOpenDay = vcleFuelOpenDay;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
    public VcleEmployeeMaster getVcleEmployeeMaster() {
        return this.vcleEmployeeMaster;
    }
    
    public void setVcleEmployeeMaster(VcleEmployeeMaster vcleEmployeeMaster) {
        this.vcleEmployeeMaster = vcleEmployeeMaster;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="DEPT_ID")
    public VcleDeptNumber getVcleDeptNumber() {
        return this.vcleDeptNumber;
    }
    
    public void setVcleDeptNumber(VcleDeptNumber vcleDeptNumber) {
        this.vcleDeptNumber = vcleDeptNumber;
    }

    
    @Column(name="FUEL_TYPE", precision=1, scale=0)
    public Boolean getFuelType() {
        return this.fuelType;
    }
    
    public void setFuelType(Boolean fuelType) {
        this.fuelType = fuelType;
    }

    
    @Column(name="ISSUE_QUN", precision=12, scale=3)
    public BigDecimal getIssueQun() {
        return this.issueQun;
    }
    
    public void setIssueQun(BigDecimal issueQun) {
        this.issueQun = issueQun;
    }

    
    @Column(name="FUEL_RATE", precision=5, scale=3)
    public BigDecimal getFuelRate() {
        return this.fuelRate;
    }
    
    public void setFuelRate(BigDecimal fuelRate) {
        this.fuelRate = fuelRate;
    }

    
    @Column(name="EZN_SEQ_ISS", precision=10, scale=0)
    public Long getEznSeqIss() {
        return this.eznSeqIss;
    }
    
    public void setEznSeqIss(Long eznSeqIss) {
        this.eznSeqIss = eznSeqIss;
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

    
    @Column(name="TANK_NUM", precision=12, scale=3)
    public BigDecimal getTankNum() {
        return this.tankNum;
    }
    
    public void setTankNum(BigDecimal tankNum) {
        this.tankNum = tankNum;
    }

    
    @Column(name="BOARD_NUMBER_OLD", precision=8, scale=0)
    public Integer getBoardNumberOld() {
        return this.boardNumberOld;
    }
    
    public void setBoardNumberOld(Integer boardNumberOld) {
        this.boardNumberOld = boardNumberOld;
    }

    
    @Column(name="COUNT_NUMBER", precision=11, scale=0)
    public Long getCountNumber() {
        return this.countNumber;
    }
    
    public void setCountNumber(Long countNumber) {
        this.countNumber = countNumber;
    }

    
    @Column(name="CHK_BARREL", precision=1, scale=0)
    public Boolean getChkBarrel() {
        return this.chkBarrel;
    }
    
    public void setChkBarrel(Boolean chkBarrel) {
        this.chkBarrel = chkBarrel;
    }

    
    @Column(name="CHK_OWNER", precision=2, scale=0)
    public Byte getChkOwner() {
        return this.chkOwner;
    }
    
    public void setChkOwner(Byte chkOwner) {
        this.chkOwner = chkOwner;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FISCAL_DATE", length=7)
    public Date getFiscalDate() {
        return this.fiscalDate;
    }
    
    public void setFiscalDate(Date fiscalDate) {
        this.fiscalDate = fiscalDate;
    }

    
    @Column(name="ISSUE_SAL", precision=12, scale=3)
    public BigDecimal getIssueSal() {
        return this.issueSal;
    }
    
    public void setIssueSal(BigDecimal issueSal) {
        this.issueSal = issueSal;
    }

    
    @Column(name="ISSUE_VAL", precision=12, scale=3)
    public BigDecimal getIssueVal() {
        return this.issueVal;
    }
    
    public void setIssueVal(BigDecimal issueVal) {
        this.issueVal = issueVal;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PROVIDE_EXEC_DATE", length=7)
    public Date getProvideExecDate() {
        return this.provideExecDate;
    }
    
    public void setProvideExecDate(Date provideExecDate) {
        this.provideExecDate = provideExecDate;
    }




}


