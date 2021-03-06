package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleRecordMovement generated by hbm2java
 */
@Entity
@Table(name="VCLE_RECORD_MOVEMENT"
    ,schema="CODEATOR"
)
public class VcleRecordMovement  implements java.io.Serializable {


     private long goingSp;
     private VcleWorkType vcleWorkType;
     private VcleVehicleType vcleVehicleType;
     private VcleVehicleMaster vcleVehicleMaster;
     private VcleShiftType vcleShiftTypeByShiftTypeComming;
     private VcleShiftType vcleShiftTypeByShiftType;
     private VcleFiscalDate vcleFiscalDate;
     private VcleExecutionDate vcleExecutionDate;
     private PerLocationCode perLocationCode;
     private PerGovernorateCode perGovernorateCode;
     private PerEmploymentMaster perEmploymentMaster;
     private Date goingDate;
     private Byte goingDay;
     private Long goingCountNumber;
     private Boolean goingTimeType;
     private Byte goingHh;
     private Byte goingMi;
     private BigDecimal goingTime;
     private Long comingCountNumber;
     private Boolean comingTimeType;
     private Byte comingHh;
     private Byte comingMi;
     private BigDecimal comingTime;
     private Date comingDate;
     private BigDecimal totTime;
     private Short totDay;
     private BigDecimal totKiloHour;
     private BigDecimal kiloHourPrice;
     private BigDecimal totVal;
     private Long disCountNumber;
     private Integer boardNumberOld;
     private String boardNumber;
     private Integer boardDigital;
     private String boardAlfa1;
     private String boardAlfa2;
     private String boardAlfa3;
     private String goingRmrk;
     private String comingRmrk;
     private String goingUserId;
     private String comingUserId;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Boolean chkLock;
     private String goingDateHour;
     private String comingDateHour;
     private String chkMov;
     private Set<VcleRecordMovementJoin> vcleRecordMovementJoins = new HashSet<VcleRecordMovementJoin>(0);

    public VcleRecordMovement() {
    }

	
    public VcleRecordMovement(long goingSp, VcleVehicleMaster vcleVehicleMaster) {
        this.goingSp = goingSp;
        this.vcleVehicleMaster = vcleVehicleMaster;
    }
    public VcleRecordMovement(long goingSp, VcleWorkType vcleWorkType, VcleVehicleType vcleVehicleType, VcleVehicleMaster vcleVehicleMaster, VcleShiftType vcleShiftTypeByShiftTypeComming, VcleShiftType vcleShiftTypeByShiftType, VcleFiscalDate vcleFiscalDate, VcleExecutionDate vcleExecutionDate, PerLocationCode perLocationCode, PerGovernorateCode perGovernorateCode, PerEmploymentMaster perEmploymentMaster, Date goingDate, Byte goingDay, Long goingCountNumber, Boolean goingTimeType, Byte goingHh, Byte goingMi, BigDecimal goingTime, Long comingCountNumber, Boolean comingTimeType, Byte comingHh, Byte comingMi, BigDecimal comingTime, Date comingDate, BigDecimal totTime, Short totDay, BigDecimal totKiloHour, BigDecimal kiloHourPrice, BigDecimal totVal, Long disCountNumber, Integer boardNumberOld, String boardNumber, Integer boardDigital, String boardAlfa1, String boardAlfa2, String boardAlfa3, String goingRmrk, String comingRmrk, String goingUserId, String comingUserId, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Boolean chkLock, String goingDateHour, String comingDateHour, String chkMov, Set<VcleRecordMovementJoin> vcleRecordMovementJoins) {
       this.goingSp = goingSp;
       this.vcleWorkType = vcleWorkType;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.vcleShiftTypeByShiftTypeComming = vcleShiftTypeByShiftTypeComming;
       this.vcleShiftTypeByShiftType = vcleShiftTypeByShiftType;
       this.vcleFiscalDate = vcleFiscalDate;
       this.vcleExecutionDate = vcleExecutionDate;
       this.perLocationCode = perLocationCode;
       this.perGovernorateCode = perGovernorateCode;
       this.perEmploymentMaster = perEmploymentMaster;
       this.goingDate = goingDate;
       this.goingDay = goingDay;
       this.goingCountNumber = goingCountNumber;
       this.goingTimeType = goingTimeType;
       this.goingHh = goingHh;
       this.goingMi = goingMi;
       this.goingTime = goingTime;
       this.comingCountNumber = comingCountNumber;
       this.comingTimeType = comingTimeType;
       this.comingHh = comingHh;
       this.comingMi = comingMi;
       this.comingTime = comingTime;
       this.comingDate = comingDate;
       this.totTime = totTime;
       this.totDay = totDay;
       this.totKiloHour = totKiloHour;
       this.kiloHourPrice = kiloHourPrice;
       this.totVal = totVal;
       this.disCountNumber = disCountNumber;
       this.boardNumberOld = boardNumberOld;
       this.boardNumber = boardNumber;
       this.boardDigital = boardDigital;
       this.boardAlfa1 = boardAlfa1;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa3 = boardAlfa3;
       this.goingRmrk = goingRmrk;
       this.comingRmrk = comingRmrk;
       this.goingUserId = goingUserId;
       this.comingUserId = comingUserId;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.chkLock = chkLock;
       this.goingDateHour = goingDateHour;
       this.comingDateHour = comingDateHour;
       this.chkMov = chkMov;
       this.vcleRecordMovementJoins = vcleRecordMovementJoins;
    }
   
     @Id 

    
    @Column(name="GOING_SP", unique=true, nullable=false, precision=11, scale=0)
    public long getGoingSp() {
        return this.goingSp;
    }
    
    public void setGoingSp(long goingSp) {
        this.goingSp = goingSp;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="WORK_TYPE")
    public VcleWorkType getVcleWorkType() {
        return this.vcleWorkType;
    }
    
    public void setVcleWorkType(VcleWorkType vcleWorkType) {
        this.vcleWorkType = vcleWorkType;
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
    @JoinColumn(name="VEHICLE_SP", nullable=false)
    public VcleVehicleMaster getVcleVehicleMaster() {
        return this.vcleVehicleMaster;
    }
    
    public void setVcleVehicleMaster(VcleVehicleMaster vcleVehicleMaster) {
        this.vcleVehicleMaster = vcleVehicleMaster;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SHIFT_TYPE_COMMING")
    public VcleShiftType getVcleShiftTypeByShiftTypeComming() {
        return this.vcleShiftTypeByShiftTypeComming;
    }
    
    public void setVcleShiftTypeByShiftTypeComming(VcleShiftType vcleShiftTypeByShiftTypeComming) {
        this.vcleShiftTypeByShiftTypeComming = vcleShiftTypeByShiftTypeComming;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SHIFT_TYPE")
    public VcleShiftType getVcleShiftTypeByShiftType() {
        return this.vcleShiftTypeByShiftType;
    }
    
    public void setVcleShiftTypeByShiftType(VcleShiftType vcleShiftTypeByShiftType) {
        this.vcleShiftTypeByShiftType = vcleShiftTypeByShiftType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="FISCAL_DATE")
    public VcleFiscalDate getVcleFiscalDate() {
        return this.vcleFiscalDate;
    }
    
    public void setVcleFiscalDate(VcleFiscalDate vcleFiscalDate) {
        this.vcleFiscalDate = vcleFiscalDate;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EXEC_MM")
    public VcleExecutionDate getVcleExecutionDate() {
        return this.vcleExecutionDate;
    }
    
    public void setVcleExecutionDate(VcleExecutionDate vcleExecutionDate) {
        this.vcleExecutionDate = vcleExecutionDate;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="LOCATION_CODE", referencedColumnName="LOCATION_CODE"), 
        @JoinColumn(name="LOC_CODE", referencedColumnName="LOC_CODE") } )
    public PerLocationCode getPerLocationCode() {
        return this.perLocationCode;
    }
    
    public void setPerLocationCode(PerLocationCode perLocationCode) {
        this.perLocationCode = perLocationCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="COUNTRY_CODE", referencedColumnName="COUNTRY_CODE"), 
        @JoinColumn(name="GOV_CODE", referencedColumnName="GOV_CODE") } )
    public PerGovernorateCode getPerGovernorateCode() {
        return this.perGovernorateCode;
    }
    
    public void setPerGovernorateCode(PerGovernorateCode perGovernorateCode) {
        this.perGovernorateCode = perGovernorateCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
    public PerEmploymentMaster getPerEmploymentMaster() {
        return this.perEmploymentMaster;
    }
    
    public void setPerEmploymentMaster(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="GOING_DATE", length=7)
    public Date getGoingDate() {
        return this.goingDate;
    }
    
    public void setGoingDate(Date goingDate) {
        this.goingDate = goingDate;
    }

    
    @Column(name="GOING_DAY", precision=2, scale=0)
    public Byte getGoingDay() {
        return this.goingDay;
    }
    
    public void setGoingDay(Byte goingDay) {
        this.goingDay = goingDay;
    }

    
    @Column(name="GOING_COUNT_NUMBER", precision=11, scale=0)
    public Long getGoingCountNumber() {
        return this.goingCountNumber;
    }
    
    public void setGoingCountNumber(Long goingCountNumber) {
        this.goingCountNumber = goingCountNumber;
    }

    
    @Column(name="GOING_TIME_TYPE", precision=1, scale=0)
    public Boolean getGoingTimeType() {
        return this.goingTimeType;
    }
    
    public void setGoingTimeType(Boolean goingTimeType) {
        this.goingTimeType = goingTimeType;
    }

    
    @Column(name="GOING_HH", precision=2, scale=0)
    public Byte getGoingHh() {
        return this.goingHh;
    }
    
    public void setGoingHh(Byte goingHh) {
        this.goingHh = goingHh;
    }

    
    @Column(name="GOING_MI", precision=2, scale=0)
    public Byte getGoingMi() {
        return this.goingMi;
    }
    
    public void setGoingMi(Byte goingMi) {
        this.goingMi = goingMi;
    }

    
    @Column(name="GOING_TIME", precision=7)
    public BigDecimal getGoingTime() {
        return this.goingTime;
    }
    
    public void setGoingTime(BigDecimal goingTime) {
        this.goingTime = goingTime;
    }

    
    @Column(name="COMING_COUNT_NUMBER", precision=11, scale=0)
    public Long getComingCountNumber() {
        return this.comingCountNumber;
    }
    
    public void setComingCountNumber(Long comingCountNumber) {
        this.comingCountNumber = comingCountNumber;
    }

    
    @Column(name="COMING_TIME_TYPE", precision=1, scale=0)
    public Boolean getComingTimeType() {
        return this.comingTimeType;
    }
    
    public void setComingTimeType(Boolean comingTimeType) {
        this.comingTimeType = comingTimeType;
    }

    
    @Column(name="COMING_HH", precision=2, scale=0)
    public Byte getComingHh() {
        return this.comingHh;
    }
    
    public void setComingHh(Byte comingHh) {
        this.comingHh = comingHh;
    }

    
    @Column(name="COMING_MI", precision=2, scale=0)
    public Byte getComingMi() {
        return this.comingMi;
    }
    
    public void setComingMi(Byte comingMi) {
        this.comingMi = comingMi;
    }

    
    @Column(name="COMING_TIME", precision=7)
    public BigDecimal getComingTime() {
        return this.comingTime;
    }
    
    public void setComingTime(BigDecimal comingTime) {
        this.comingTime = comingTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="COMING_DATE", length=7)
    public Date getComingDate() {
        return this.comingDate;
    }
    
    public void setComingDate(Date comingDate) {
        this.comingDate = comingDate;
    }

    
    @Column(name="TOT_TIME", precision=7)
    public BigDecimal getTotTime() {
        return this.totTime;
    }
    
    public void setTotTime(BigDecimal totTime) {
        this.totTime = totTime;
    }

    
    @Column(name="TOT_DAY", precision=4, scale=0)
    public Short getTotDay() {
        return this.totDay;
    }
    
    public void setTotDay(Short totDay) {
        this.totDay = totDay;
    }

    
    @Column(name="TOT_KILO_HOUR", precision=7)
    public BigDecimal getTotKiloHour() {
        return this.totKiloHour;
    }
    
    public void setTotKiloHour(BigDecimal totKiloHour) {
        this.totKiloHour = totKiloHour;
    }

    
    @Column(name="KILO_HOUR_PRICE", precision=5)
    public BigDecimal getKiloHourPrice() {
        return this.kiloHourPrice;
    }
    
    public void setKiloHourPrice(BigDecimal kiloHourPrice) {
        this.kiloHourPrice = kiloHourPrice;
    }

    
    @Column(name="TOT_VAL", precision=9)
    public BigDecimal getTotVal() {
        return this.totVal;
    }
    
    public void setTotVal(BigDecimal totVal) {
        this.totVal = totVal;
    }

    
    @Column(name="DIS_COUNT_NUMBER", precision=11, scale=0)
    public Long getDisCountNumber() {
        return this.disCountNumber;
    }
    
    public void setDisCountNumber(Long disCountNumber) {
        this.disCountNumber = disCountNumber;
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

    
    @Column(name="GOING_RMRK", length=200)
    public String getGoingRmrk() {
        return this.goingRmrk;
    }
    
    public void setGoingRmrk(String goingRmrk) {
        this.goingRmrk = goingRmrk;
    }

    
    @Column(name="COMING_RMRK", length=200)
    public String getComingRmrk() {
        return this.comingRmrk;
    }
    
    public void setComingRmrk(String comingRmrk) {
        this.comingRmrk = comingRmrk;
    }

    
    @Column(name="GOING_USER_ID", length=22)
    public String getGoingUserId() {
        return this.goingUserId;
    }
    
    public void setGoingUserId(String goingUserId) {
        this.goingUserId = goingUserId;
    }

    
    @Column(name="COMING_USER_ID", length=22)
    public String getComingUserId() {
        return this.comingUserId;
    }
    
    public void setComingUserId(String comingUserId) {
        this.comingUserId = comingUserId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_CREATE_DATE", length=7)
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }

    
    @Column(name="RECORD_UPDATE_USER", length=22)
    public String getRecordUpdateUser() {
        return this.recordUpdateUser;
    }
    
    public void setRecordUpdateUser(String recordUpdateUser) {
        this.recordUpdateUser = recordUpdateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_UPDATE_DATE", length=7)
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }

    
    @Column(name="CHK_LOCK", precision=1, scale=0)
    public Boolean getChkLock() {
        return this.chkLock;
    }
    
    public void setChkLock(Boolean chkLock) {
        this.chkLock = chkLock;
    }

    
    @Column(name="GOING_DATE_HOUR", length=20)
    public String getGoingDateHour() {
        return this.goingDateHour;
    }
    
    public void setGoingDateHour(String goingDateHour) {
        this.goingDateHour = goingDateHour;
    }

    
    @Column(name="COMING_DATE_HOUR", length=20)
    public String getComingDateHour() {
        return this.comingDateHour;
    }
    
    public void setComingDateHour(String comingDateHour) {
        this.comingDateHour = comingDateHour;
    }

    
    @Column(name="CHK_MOV", length=1)
    public String getChkMov() {
        return this.chkMov;
    }
    
    public void setChkMov(String chkMov) {
        this.chkMov = chkMov;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleRecordMovement")
    public Set<VcleRecordMovementJoin> getVcleRecordMovementJoins() {
        return this.vcleRecordMovementJoins;
    }
    
    public void setVcleRecordMovementJoins(Set<VcleRecordMovementJoin> vcleRecordMovementJoins) {
        this.vcleRecordMovementJoins = vcleRecordMovementJoins;
    }




}


