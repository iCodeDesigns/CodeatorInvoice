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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleVehicleIncome generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_INCOME"
    ,schema="CODEATOR"
)
public class VcleVehicleIncome  implements java.io.Serializable {


     private VcleVehicleIncomeId id;
     private VcleWorkType vcleWorkType;
     private VcleWorkSide vcleWorkSide;
     private VcleVehicleType vcleVehicleType;
     private VcleVehicleMaster vcleVehicleMaster;
     private VcleFiscalDate vcleFiscalDate;
     private VcleExecutionDate vcleExecutionDate;
     private VcleDeptNumber vcleDeptNumber;
     private PerLocationCode perLocationCode;
     private PerGovernorateCode perGovernorateCode;
     private PerEmploymentMaster perEmploymentMaster;
     private PerDeptOld perDeptOld;
     private Short requireSp;
     private Boolean requireType;
     private Date goingDate;
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
     private String placeName;
     private BigDecimal totTime;
     private Short totDay;
     private BigDecimal totKiloHour;
     private BigDecimal kiloHourPrice;
     private BigDecimal totVal;
     private Long disCountNumber;
     private Boolean sideType;
     private Boolean chkLock;
     private Integer boardNumberOld;
     private String boardNumber;
     private Integer boardDigital;
     private String boardAlfa1;
     private String boardAlfa2;
     private String boardAlfa3;
     private String goingRmrk;
     private String comingRmrk;
     private Long employeeIdRes;
     private Long employeeIdMan;
     private Byte goingDay;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private String userId;
     private Boolean chkPrint;
     private BigDecimal totValActual;
     private BigDecimal valDay;
     private BigDecimal valDayRem;

    public VcleVehicleIncome() {
    }

	
    public VcleVehicleIncome(VcleVehicleIncomeId id, VcleVehicleMaster vcleVehicleMaster) {
        this.id = id;
        this.vcleVehicleMaster = vcleVehicleMaster;
    }
    public VcleVehicleIncome(VcleVehicleIncomeId id, VcleWorkType vcleWorkType, VcleWorkSide vcleWorkSide, VcleVehicleType vcleVehicleType, VcleVehicleMaster vcleVehicleMaster, VcleFiscalDate vcleFiscalDate, VcleExecutionDate vcleExecutionDate, VcleDeptNumber vcleDeptNumber, PerLocationCode perLocationCode, PerGovernorateCode perGovernorateCode, PerEmploymentMaster perEmploymentMaster, PerDeptOld perDeptOld, Short requireSp, Boolean requireType, Date goingDate, Long goingCountNumber, Boolean goingTimeType, Byte goingHh, Byte goingMi, BigDecimal goingTime, Long comingCountNumber, Boolean comingTimeType, Byte comingHh, Byte comingMi, BigDecimal comingTime, Date comingDate, String placeName, BigDecimal totTime, Short totDay, BigDecimal totKiloHour, BigDecimal kiloHourPrice, BigDecimal totVal, Long disCountNumber, Boolean sideType, Boolean chkLock, Integer boardNumberOld, String boardNumber, Integer boardDigital, String boardAlfa1, String boardAlfa2, String boardAlfa3, String goingRmrk, String comingRmrk, Long employeeIdRes, Long employeeIdMan, Byte goingDay, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, String userId, Boolean chkPrint, BigDecimal totValActual, BigDecimal valDay, BigDecimal valDayRem) {
       this.id = id;
       this.vcleWorkType = vcleWorkType;
       this.vcleWorkSide = vcleWorkSide;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.vcleFiscalDate = vcleFiscalDate;
       this.vcleExecutionDate = vcleExecutionDate;
       this.vcleDeptNumber = vcleDeptNumber;
       this.perLocationCode = perLocationCode;
       this.perGovernorateCode = perGovernorateCode;
       this.perEmploymentMaster = perEmploymentMaster;
       this.perDeptOld = perDeptOld;
       this.requireSp = requireSp;
       this.requireType = requireType;
       this.goingDate = goingDate;
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
       this.placeName = placeName;
       this.totTime = totTime;
       this.totDay = totDay;
       this.totKiloHour = totKiloHour;
       this.kiloHourPrice = kiloHourPrice;
       this.totVal = totVal;
       this.disCountNumber = disCountNumber;
       this.sideType = sideType;
       this.chkLock = chkLock;
       this.boardNumberOld = boardNumberOld;
       this.boardNumber = boardNumber;
       this.boardDigital = boardDigital;
       this.boardAlfa1 = boardAlfa1;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa3 = boardAlfa3;
       this.goingRmrk = goingRmrk;
       this.comingRmrk = comingRmrk;
       this.employeeIdRes = employeeIdRes;
       this.employeeIdMan = employeeIdMan;
       this.goingDay = goingDay;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.userId = userId;
       this.chkPrint = chkPrint;
       this.totValActual = totValActual;
       this.valDay = valDay;
       this.valDayRem = valDayRem;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="goingSp", column=@Column(name="GOING_SP", nullable=false, precision=11, scale=0) ), 
        @AttributeOverride(name="goingYear", column=@Column(name="GOING_YEAR", nullable=false, precision=4, scale=0) ) } )
    public VcleVehicleIncomeId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleIncomeId id) {
        this.id = id;
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
    @JoinColumn(name="WORK_SIDE_CODE")
    public VcleWorkSide getVcleWorkSide() {
        return this.vcleWorkSide;
    }
    
    public void setVcleWorkSide(VcleWorkSide vcleWorkSide) {
        this.vcleWorkSide = vcleWorkSide;
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
    @JoinColumn(name="DEPT_ID")
    public VcleDeptNumber getVcleDeptNumber() {
        return this.vcleDeptNumber;
    }
    
    public void setVcleDeptNumber(VcleDeptNumber vcleDeptNumber) {
        this.vcleDeptNumber = vcleDeptNumber;
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

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="SECTION_NO_OLD", referencedColumnName="SECTION_NO_OLD"), 
        @JoinColumn(name="DEP_NO_OLD", referencedColumnName="DEP_NO_OLD") } )
    public PerDeptOld getPerDeptOld() {
        return this.perDeptOld;
    }
    
    public void setPerDeptOld(PerDeptOld perDeptOld) {
        this.perDeptOld = perDeptOld;
    }

    
    @Column(name="REQUIRE_SP", precision=3, scale=0)
    public Short getRequireSp() {
        return this.requireSp;
    }
    
    public void setRequireSp(Short requireSp) {
        this.requireSp = requireSp;
    }

    
    @Column(name="REQUIRE_TYPE", precision=1, scale=0)
    public Boolean getRequireType() {
        return this.requireType;
    }
    
    public void setRequireType(Boolean requireType) {
        this.requireType = requireType;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="GOING_DATE", length=7)
    public Date getGoingDate() {
        return this.goingDate;
    }
    
    public void setGoingDate(Date goingDate) {
        this.goingDate = goingDate;
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

    
    @Column(name="PLACE_NAME", length=200)
    public String getPlaceName() {
        return this.placeName;
    }
    
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
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

    
    @Column(name="TOT_KILO_HOUR", precision=11)
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

    
    @Column(name="SIDE_TYPE", precision=1, scale=0)
    public Boolean getSideType() {
        return this.sideType;
    }
    
    public void setSideType(Boolean sideType) {
        this.sideType = sideType;
    }

    
    @Column(name="CHK_LOCK", precision=1, scale=0)
    public Boolean getChkLock() {
        return this.chkLock;
    }
    
    public void setChkLock(Boolean chkLock) {
        this.chkLock = chkLock;
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

    
    @Column(name="EMPLOYEE_ID_RES", precision=10, scale=0)
    public Long getEmployeeIdRes() {
        return this.employeeIdRes;
    }
    
    public void setEmployeeIdRes(Long employeeIdRes) {
        this.employeeIdRes = employeeIdRes;
    }

    
    @Column(name="EMPLOYEE_ID_MAN", precision=10, scale=0)
    public Long getEmployeeIdMan() {
        return this.employeeIdMan;
    }
    
    public void setEmployeeIdMan(Long employeeIdMan) {
        this.employeeIdMan = employeeIdMan;
    }

    
    @Column(name="GOING_DAY", precision=2, scale=0)
    public Byte getGoingDay() {
        return this.goingDay;
    }
    
    public void setGoingDay(Byte goingDay) {
        this.goingDay = goingDay;
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

    
    @Column(name="USER_ID", length=22)
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    @Column(name="CHK_PRINT", precision=1, scale=0)
    public Boolean getChkPrint() {
        return this.chkPrint;
    }
    
    public void setChkPrint(Boolean chkPrint) {
        this.chkPrint = chkPrint;
    }

    
    @Column(name="TOT_VAL_ACTUAL", precision=11)
    public BigDecimal getTotValActual() {
        return this.totValActual;
    }
    
    public void setTotValActual(BigDecimal totValActual) {
        this.totValActual = totValActual;
    }

    
    @Column(name="VAL_DAY", precision=9)
    public BigDecimal getValDay() {
        return this.valDay;
    }
    
    public void setValDay(BigDecimal valDay) {
        this.valDay = valDay;
    }

    
    @Column(name="VAL_DAY_REM", precision=9)
    public BigDecimal getValDayRem() {
        return this.valDayRem;
    }
    
    public void setValDayRem(BigDecimal valDayRem) {
        this.valDayRem = valDayRem;
    }




}


