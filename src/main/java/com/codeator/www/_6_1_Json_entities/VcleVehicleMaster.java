package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * VcleVehicleMaster generated by hbm2java
 */
public class VcleVehicleMaster  implements java.io.Serializable {


     private int vehicleSp;
     private VcleColorCode vcleColorCode;
     private VcleVehicleModel vcleVehicleModel;
     private VcleVehicleShape vcleVehicleShape;
     private VcleVehicleType vcleVehicleType;
     private VcleWorkSide vcleWorkSide;
     private VcleEquipmentType vcleEquipmentType;
     private Boolean fuelType;
     private String shassNumber;
     private String motorNumber;
     private String boardNumber;
     private Byte octane;
     private BigDecimal purchaseValue;
     private Date purchaseDate;
     private Short depRateVehcl;
     private BigDecimal depKst;
     private Short manufactureYear;
     private Boolean loadType;
     private BigDecimal loadVal;
     private String trafficLetterNumber;
     private Date trafficLetterDate;
     private String ownerCertNo;
     private Date ownerCertDate;
     private Short vehicleCc;
     private Boolean vehicleCylinder;
     private Boolean licensePeriod;
     private String couponNum;
     private Date couponDate;
     private BigDecimal insuranceFirstVal;
     private String vehicleDesc;
     private Integer boardNumberOld;
     private Integer boardDigital;
     private String boardAlfa1;
     private String boardAlfa2;
     private String boardAlfa3;
     private Date countNumberDate;
     private Long countNumber;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Date licenseFirstDate;
     private Boolean vcleStatus;
     private Short vehicleCode;
     private Date licenseEndDate;
     private Date inspectDate;
     private Boolean chkOwner;
     private Boolean chkSale;
     private Date saleDate;
     private String saleRmrk;
     private Boolean chkSpecial;
     private Integer vcleNum;
     private Set vcleTravelExchanges = new HashSet(0);
     private Set vcleVehicleInspectCars = new HashSet(0);
     private Set vcleFuelIssueLiquids = new HashSet(0);
     private Set vcleVehicleTransactionDtls = new HashSet(0);
     private Set vcleTrafficLines = new HashSet(0);
     private Set vcleVehicleDriverJoins = new HashSet(0);
     private Set vcleVehicleAccidents = new HashSet(0);
     private Set vcleVehicleCountMms = new HashSet(0);
     private Set vcleVehicleInstructions = new HashSet(0);
     private Set vcleMotorChanges = new HashSet(0);
     private Set vcleRecordMovements = new HashSet(0);
     private Set vcleVehicleIncomes = new HashSet(0);
     private Set vcleWorkTypeTransCars = new HashSet(0);
     private Set vcleVehicleRequires = new HashSet(0);
     private Set vcleVehicleNotifyTranses = new HashSet(0);
     private Set vcleVehicleReceives = new HashSet(0);
     private Set vcleVehicleClassDtls = new HashSet(0);
     private Set vcleOilIssues = new HashSet(0);
     private Set vcleVehicleInvoiceCars = new HashSet(0);
     private Set vcleFuelBookNumberDtls = new HashSet(0);
     private Set vcleVehicleCosts = new HashSet(0);
     private Set vcleWorkSideDtls = new HashSet(0);
     private Set vcleVehicleLicenses = new HashSet(0);
     private Set vcleVehicleIncludings = new HashSet(0);
     private Set vcleVehicleLicenseReportCrs = new HashSet(0);
     private Set vcleVehicleResponsibleJoins = new HashSet(0);
     private Set vcleVehicleInvoiceLiqs = new HashSet(0);

    public VcleVehicleMaster() {
    }

	
    public VcleVehicleMaster(int vehicleSp, String boardNumber) {
        this.vehicleSp = vehicleSp;
        this.boardNumber = boardNumber;
    }
    public VcleVehicleMaster(int vehicleSp, VcleColorCode vcleColorCode, VcleVehicleModel vcleVehicleModel, VcleVehicleShape vcleVehicleShape, VcleVehicleType vcleVehicleType, VcleWorkSide vcleWorkSide, VcleEquipmentType vcleEquipmentType, Boolean fuelType, String shassNumber, String motorNumber, String boardNumber, Byte octane, BigDecimal purchaseValue, Date purchaseDate, Short depRateVehcl, BigDecimal depKst, Short manufactureYear, Boolean loadType, BigDecimal loadVal, String trafficLetterNumber, Date trafficLetterDate, String ownerCertNo, Date ownerCertDate, Short vehicleCc, Boolean vehicleCylinder, Boolean licensePeriod, String couponNum, Date couponDate, BigDecimal insuranceFirstVal, String vehicleDesc, Integer boardNumberOld, Integer boardDigital, String boardAlfa1, String boardAlfa2, String boardAlfa3, Date countNumberDate, Long countNumber, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Date licenseFirstDate, Boolean vcleStatus, Short vehicleCode, Date licenseEndDate, Date inspectDate, Boolean chkOwner, Boolean chkSale, Date saleDate, String saleRmrk, Boolean chkSpecial, Integer vcleNum, Set vcleTravelExchanges, Set vcleVehicleInspectCars, Set vcleFuelIssueLiquids, Set vcleVehicleTransactionDtls, Set vcleTrafficLines, Set vcleVehicleDriverJoins, Set vcleVehicleAccidents, Set vcleVehicleCountMms, Set vcleVehicleInstructions, Set vcleMotorChanges, Set vcleRecordMovements, Set vcleVehicleIncomes, Set vcleWorkTypeTransCars, Set vcleVehicleRequires, Set vcleVehicleNotifyTranses, Set vcleVehicleReceives, Set vcleVehicleClassDtls, Set vcleOilIssues, Set vcleVehicleInvoiceCars, Set vcleFuelBookNumberDtls, Set vcleVehicleCosts, Set vcleWorkSideDtls, Set vcleVehicleLicenses, Set vcleVehicleIncludings, Set vcleVehicleLicenseReportCrs, Set vcleVehicleResponsibleJoins, Set vcleVehicleInvoiceLiqs) {
       this.vehicleSp = vehicleSp;
       this.vcleColorCode = vcleColorCode;
       this.vcleVehicleModel = vcleVehicleModel;
       this.vcleVehicleShape = vcleVehicleShape;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleWorkSide = vcleWorkSide;
       this.vcleEquipmentType = vcleEquipmentType;
       this.fuelType = fuelType;
       this.shassNumber = shassNumber;
       this.motorNumber = motorNumber;
       this.boardNumber = boardNumber;
       this.octane = octane;
       this.purchaseValue = purchaseValue;
       this.purchaseDate = purchaseDate;
       this.depRateVehcl = depRateVehcl;
       this.depKst = depKst;
       this.manufactureYear = manufactureYear;
       this.loadType = loadType;
       this.loadVal = loadVal;
       this.trafficLetterNumber = trafficLetterNumber;
       this.trafficLetterDate = trafficLetterDate;
       this.ownerCertNo = ownerCertNo;
       this.ownerCertDate = ownerCertDate;
       this.vehicleCc = vehicleCc;
       this.vehicleCylinder = vehicleCylinder;
       this.licensePeriod = licensePeriod;
       this.couponNum = couponNum;
       this.couponDate = couponDate;
       this.insuranceFirstVal = insuranceFirstVal;
       this.vehicleDesc = vehicleDesc;
       this.boardNumberOld = boardNumberOld;
       this.boardDigital = boardDigital;
       this.boardAlfa1 = boardAlfa1;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa3 = boardAlfa3;
       this.countNumberDate = countNumberDate;
       this.countNumber = countNumber;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.licenseFirstDate = licenseFirstDate;
       this.vcleStatus = vcleStatus;
       this.vehicleCode = vehicleCode;
       this.licenseEndDate = licenseEndDate;
       this.inspectDate = inspectDate;
       this.chkOwner = chkOwner;
       this.chkSale = chkSale;
       this.saleDate = saleDate;
       this.saleRmrk = saleRmrk;
       this.chkSpecial = chkSpecial;
       this.vcleNum = vcleNum;
       this.vcleTravelExchanges = vcleTravelExchanges;
       this.vcleVehicleInspectCars = vcleVehicleInspectCars;
       this.vcleFuelIssueLiquids = vcleFuelIssueLiquids;
       this.vcleVehicleTransactionDtls = vcleVehicleTransactionDtls;
       this.vcleTrafficLines = vcleTrafficLines;
       this.vcleVehicleDriverJoins = vcleVehicleDriverJoins;
       this.vcleVehicleAccidents = vcleVehicleAccidents;
       this.vcleVehicleCountMms = vcleVehicleCountMms;
       this.vcleVehicleInstructions = vcleVehicleInstructions;
       this.vcleMotorChanges = vcleMotorChanges;
       this.vcleRecordMovements = vcleRecordMovements;
       this.vcleVehicleIncomes = vcleVehicleIncomes;
       this.vcleWorkTypeTransCars = vcleWorkTypeTransCars;
       this.vcleVehicleRequires = vcleVehicleRequires;
       this.vcleVehicleNotifyTranses = vcleVehicleNotifyTranses;
       this.vcleVehicleReceives = vcleVehicleReceives;
       this.vcleVehicleClassDtls = vcleVehicleClassDtls;
       this.vcleOilIssues = vcleOilIssues;
       this.vcleVehicleInvoiceCars = vcleVehicleInvoiceCars;
       this.vcleFuelBookNumberDtls = vcleFuelBookNumberDtls;
       this.vcleVehicleCosts = vcleVehicleCosts;
       this.vcleWorkSideDtls = vcleWorkSideDtls;
       this.vcleVehicleLicenses = vcleVehicleLicenses;
       this.vcleVehicleIncludings = vcleVehicleIncludings;
       this.vcleVehicleLicenseReportCrs = vcleVehicleLicenseReportCrs;
       this.vcleVehicleResponsibleJoins = vcleVehicleResponsibleJoins;
       this.vcleVehicleInvoiceLiqs = vcleVehicleInvoiceLiqs;
    }
   
    public int getVehicleSp() {
        return this.vehicleSp;
    }
    
    public void setVehicleSp(int vehicleSp) {
        this.vehicleSp = vehicleSp;
    }
    public VcleColorCode getVcleColorCode() {
        return this.vcleColorCode;
    }
    
    public void setVcleColorCode(VcleColorCode vcleColorCode) {
        this.vcleColorCode = vcleColorCode;
    }
    public VcleVehicleModel getVcleVehicleModel() {
        return this.vcleVehicleModel;
    }
    
    public void setVcleVehicleModel(VcleVehicleModel vcleVehicleModel) {
        this.vcleVehicleModel = vcleVehicleModel;
    }
    public VcleVehicleShape getVcleVehicleShape() {
        return this.vcleVehicleShape;
    }
    
    public void setVcleVehicleShape(VcleVehicleShape vcleVehicleShape) {
        this.vcleVehicleShape = vcleVehicleShape;
    }
    public VcleVehicleType getVcleVehicleType() {
        return this.vcleVehicleType;
    }
    
    public void setVcleVehicleType(VcleVehicleType vcleVehicleType) {
        this.vcleVehicleType = vcleVehicleType;
    }
    public VcleWorkSide getVcleWorkSide() {
        return this.vcleWorkSide;
    }
    
    public void setVcleWorkSide(VcleWorkSide vcleWorkSide) {
        this.vcleWorkSide = vcleWorkSide;
    }
    public VcleEquipmentType getVcleEquipmentType() {
        return this.vcleEquipmentType;
    }
    
    public void setVcleEquipmentType(VcleEquipmentType vcleEquipmentType) {
        this.vcleEquipmentType = vcleEquipmentType;
    }
    public Boolean getFuelType() {
        return this.fuelType;
    }
    
    public void setFuelType(Boolean fuelType) {
        this.fuelType = fuelType;
    }
    public String getShassNumber() {
        return this.shassNumber;
    }
    
    public void setShassNumber(String shassNumber) {
        this.shassNumber = shassNumber;
    }
    public String getMotorNumber() {
        return this.motorNumber;
    }
    
    public void setMotorNumber(String motorNumber) {
        this.motorNumber = motorNumber;
    }
    public String getBoardNumber() {
        return this.boardNumber;
    }
    
    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }
    public Byte getOctane() {
        return this.octane;
    }
    
    public void setOctane(Byte octane) {
        this.octane = octane;
    }
    public BigDecimal getPurchaseValue() {
        return this.purchaseValue;
    }
    
    public void setPurchaseValue(BigDecimal purchaseValue) {
        this.purchaseValue = purchaseValue;
    }
    public Date getPurchaseDate() {
        return this.purchaseDate;
    }
    
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public Short getDepRateVehcl() {
        return this.depRateVehcl;
    }
    
    public void setDepRateVehcl(Short depRateVehcl) {
        this.depRateVehcl = depRateVehcl;
    }
    public BigDecimal getDepKst() {
        return this.depKst;
    }
    
    public void setDepKst(BigDecimal depKst) {
        this.depKst = depKst;
    }
    public Short getManufactureYear() {
        return this.manufactureYear;
    }
    
    public void setManufactureYear(Short manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
    public Boolean getLoadType() {
        return this.loadType;
    }
    
    public void setLoadType(Boolean loadType) {
        this.loadType = loadType;
    }
    public BigDecimal getLoadVal() {
        return this.loadVal;
    }
    
    public void setLoadVal(BigDecimal loadVal) {
        this.loadVal = loadVal;
    }
    public String getTrafficLetterNumber() {
        return this.trafficLetterNumber;
    }
    
    public void setTrafficLetterNumber(String trafficLetterNumber) {
        this.trafficLetterNumber = trafficLetterNumber;
    }
    public Date getTrafficLetterDate() {
        return this.trafficLetterDate;
    }
    
    public void setTrafficLetterDate(Date trafficLetterDate) {
        this.trafficLetterDate = trafficLetterDate;
    }
    public String getOwnerCertNo() {
        return this.ownerCertNo;
    }
    
    public void setOwnerCertNo(String ownerCertNo) {
        this.ownerCertNo = ownerCertNo;
    }
    public Date getOwnerCertDate() {
        return this.ownerCertDate;
    }
    
    public void setOwnerCertDate(Date ownerCertDate) {
        this.ownerCertDate = ownerCertDate;
    }
    public Short getVehicleCc() {
        return this.vehicleCc;
    }
    
    public void setVehicleCc(Short vehicleCc) {
        this.vehicleCc = vehicleCc;
    }
    public Boolean getVehicleCylinder() {
        return this.vehicleCylinder;
    }
    
    public void setVehicleCylinder(Boolean vehicleCylinder) {
        this.vehicleCylinder = vehicleCylinder;
    }
    public Boolean getLicensePeriod() {
        return this.licensePeriod;
    }
    
    public void setLicensePeriod(Boolean licensePeriod) {
        this.licensePeriod = licensePeriod;
    }
    public String getCouponNum() {
        return this.couponNum;
    }
    
    public void setCouponNum(String couponNum) {
        this.couponNum = couponNum;
    }
    public Date getCouponDate() {
        return this.couponDate;
    }
    
    public void setCouponDate(Date couponDate) {
        this.couponDate = couponDate;
    }
    public BigDecimal getInsuranceFirstVal() {
        return this.insuranceFirstVal;
    }
    
    public void setInsuranceFirstVal(BigDecimal insuranceFirstVal) {
        this.insuranceFirstVal = insuranceFirstVal;
    }
    public String getVehicleDesc() {
        return this.vehicleDesc;
    }
    
    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc;
    }
    public Integer getBoardNumberOld() {
        return this.boardNumberOld;
    }
    
    public void setBoardNumberOld(Integer boardNumberOld) {
        this.boardNumberOld = boardNumberOld;
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
    public Date getCountNumberDate() {
        return this.countNumberDate;
    }
    
    public void setCountNumberDate(Date countNumberDate) {
        this.countNumberDate = countNumberDate;
    }
    public Long getCountNumber() {
        return this.countNumber;
    }
    
    public void setCountNumber(Long countNumber) {
        this.countNumber = countNumber;
    }
    public String getRecordCreateUser() {
        return this.recordCreateUser;
    }
    
    public void setRecordCreateUser(String recordCreateUser) {
        this.recordCreateUser = recordCreateUser;
    }
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }
    public String getRecordUpdateUser() {
        return this.recordUpdateUser;
    }
    
    public void setRecordUpdateUser(String recordUpdateUser) {
        this.recordUpdateUser = recordUpdateUser;
    }
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }
    public Date getLicenseFirstDate() {
        return this.licenseFirstDate;
    }
    
    public void setLicenseFirstDate(Date licenseFirstDate) {
        this.licenseFirstDate = licenseFirstDate;
    }
    public Boolean getVcleStatus() {
        return this.vcleStatus;
    }
    
    public void setVcleStatus(Boolean vcleStatus) {
        this.vcleStatus = vcleStatus;
    }
    public Short getVehicleCode() {
        return this.vehicleCode;
    }
    
    public void setVehicleCode(Short vehicleCode) {
        this.vehicleCode = vehicleCode;
    }
    public Date getLicenseEndDate() {
        return this.licenseEndDate;
    }
    
    public void setLicenseEndDate(Date licenseEndDate) {
        this.licenseEndDate = licenseEndDate;
    }
    public Date getInspectDate() {
        return this.inspectDate;
    }
    
    public void setInspectDate(Date inspectDate) {
        this.inspectDate = inspectDate;
    }
    public Boolean getChkOwner() {
        return this.chkOwner;
    }
    
    public void setChkOwner(Boolean chkOwner) {
        this.chkOwner = chkOwner;
    }
    public Boolean getChkSale() {
        return this.chkSale;
    }
    
    public void setChkSale(Boolean chkSale) {
        this.chkSale = chkSale;
    }
    public Date getSaleDate() {
        return this.saleDate;
    }
    
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    public String getSaleRmrk() {
        return this.saleRmrk;
    }
    
    public void setSaleRmrk(String saleRmrk) {
        this.saleRmrk = saleRmrk;
    }
    public Boolean getChkSpecial() {
        return this.chkSpecial;
    }
    
    public void setChkSpecial(Boolean chkSpecial) {
        this.chkSpecial = chkSpecial;
    }
    public Integer getVcleNum() {
        return this.vcleNum;
    }
    
    public void setVcleNum(Integer vcleNum) {
        this.vcleNum = vcleNum;
    }
    public Set getVcleTravelExchanges() {
        return this.vcleTravelExchanges;
    }
    
    public void setVcleTravelExchanges(Set vcleTravelExchanges) {
        this.vcleTravelExchanges = vcleTravelExchanges;
    }
    public Set getVcleVehicleInspectCars() {
        return this.vcleVehicleInspectCars;
    }
    
    public void setVcleVehicleInspectCars(Set vcleVehicleInspectCars) {
        this.vcleVehicleInspectCars = vcleVehicleInspectCars;
    }
    public Set getVcleFuelIssueLiquids() {
        return this.vcleFuelIssueLiquids;
    }
    
    public void setVcleFuelIssueLiquids(Set vcleFuelIssueLiquids) {
        this.vcleFuelIssueLiquids = vcleFuelIssueLiquids;
    }
    public Set getVcleVehicleTransactionDtls() {
        return this.vcleVehicleTransactionDtls;
    }
    
    public void setVcleVehicleTransactionDtls(Set vcleVehicleTransactionDtls) {
        this.vcleVehicleTransactionDtls = vcleVehicleTransactionDtls;
    }
    public Set getVcleTrafficLines() {
        return this.vcleTrafficLines;
    }
    
    public void setVcleTrafficLines(Set vcleTrafficLines) {
        this.vcleTrafficLines = vcleTrafficLines;
    }
    public Set getVcleVehicleDriverJoins() {
        return this.vcleVehicleDriverJoins;
    }
    
    public void setVcleVehicleDriverJoins(Set vcleVehicleDriverJoins) {
        this.vcleVehicleDriverJoins = vcleVehicleDriverJoins;
    }
    public Set getVcleVehicleAccidents() {
        return this.vcleVehicleAccidents;
    }
    
    public void setVcleVehicleAccidents(Set vcleVehicleAccidents) {
        this.vcleVehicleAccidents = vcleVehicleAccidents;
    }
    public Set getVcleVehicleCountMms() {
        return this.vcleVehicleCountMms;
    }
    
    public void setVcleVehicleCountMms(Set vcleVehicleCountMms) {
        this.vcleVehicleCountMms = vcleVehicleCountMms;
    }
    public Set getVcleVehicleInstructions() {
        return this.vcleVehicleInstructions;
    }
    
    public void setVcleVehicleInstructions(Set vcleVehicleInstructions) {
        this.vcleVehicleInstructions = vcleVehicleInstructions;
    }
    public Set getVcleMotorChanges() {
        return this.vcleMotorChanges;
    }
    
    public void setVcleMotorChanges(Set vcleMotorChanges) {
        this.vcleMotorChanges = vcleMotorChanges;
    }
    public Set getVcleRecordMovements() {
        return this.vcleRecordMovements;
    }
    
    public void setVcleRecordMovements(Set vcleRecordMovements) {
        this.vcleRecordMovements = vcleRecordMovements;
    }
    public Set getVcleVehicleIncomes() {
        return this.vcleVehicleIncomes;
    }
    
    public void setVcleVehicleIncomes(Set vcleVehicleIncomes) {
        this.vcleVehicleIncomes = vcleVehicleIncomes;
    }
    public Set getVcleWorkTypeTransCars() {
        return this.vcleWorkTypeTransCars;
    }
    
    public void setVcleWorkTypeTransCars(Set vcleWorkTypeTransCars) {
        this.vcleWorkTypeTransCars = vcleWorkTypeTransCars;
    }
    public Set getVcleVehicleRequires() {
        return this.vcleVehicleRequires;
    }
    
    public void setVcleVehicleRequires(Set vcleVehicleRequires) {
        this.vcleVehicleRequires = vcleVehicleRequires;
    }
    public Set getVcleVehicleNotifyTranses() {
        return this.vcleVehicleNotifyTranses;
    }
    
    public void setVcleVehicleNotifyTranses(Set vcleVehicleNotifyTranses) {
        this.vcleVehicleNotifyTranses = vcleVehicleNotifyTranses;
    }
    public Set getVcleVehicleReceives() {
        return this.vcleVehicleReceives;
    }
    
    public void setVcleVehicleReceives(Set vcleVehicleReceives) {
        this.vcleVehicleReceives = vcleVehicleReceives;
    }
    public Set getVcleVehicleClassDtls() {
        return this.vcleVehicleClassDtls;
    }
    
    public void setVcleVehicleClassDtls(Set vcleVehicleClassDtls) {
        this.vcleVehicleClassDtls = vcleVehicleClassDtls;
    }
    public Set getVcleOilIssues() {
        return this.vcleOilIssues;
    }
    
    public void setVcleOilIssues(Set vcleOilIssues) {
        this.vcleOilIssues = vcleOilIssues;
    }
    public Set getVcleVehicleInvoiceCars() {
        return this.vcleVehicleInvoiceCars;
    }
    
    public void setVcleVehicleInvoiceCars(Set vcleVehicleInvoiceCars) {
        this.vcleVehicleInvoiceCars = vcleVehicleInvoiceCars;
    }
    public Set getVcleFuelBookNumberDtls() {
        return this.vcleFuelBookNumberDtls;
    }
    
    public void setVcleFuelBookNumberDtls(Set vcleFuelBookNumberDtls) {
        this.vcleFuelBookNumberDtls = vcleFuelBookNumberDtls;
    }
    public Set getVcleVehicleCosts() {
        return this.vcleVehicleCosts;
    }
    
    public void setVcleVehicleCosts(Set vcleVehicleCosts) {
        this.vcleVehicleCosts = vcleVehicleCosts;
    }
    public Set getVcleWorkSideDtls() {
        return this.vcleWorkSideDtls;
    }
    
    public void setVcleWorkSideDtls(Set vcleWorkSideDtls) {
        this.vcleWorkSideDtls = vcleWorkSideDtls;
    }
    public Set getVcleVehicleLicenses() {
        return this.vcleVehicleLicenses;
    }
    
    public void setVcleVehicleLicenses(Set vcleVehicleLicenses) {
        this.vcleVehicleLicenses = vcleVehicleLicenses;
    }
    public Set getVcleVehicleIncludings() {
        return this.vcleVehicleIncludings;
    }
    
    public void setVcleVehicleIncludings(Set vcleVehicleIncludings) {
        this.vcleVehicleIncludings = vcleVehicleIncludings;
    }
    public Set getVcleVehicleLicenseReportCrs() {
        return this.vcleVehicleLicenseReportCrs;
    }
    
    public void setVcleVehicleLicenseReportCrs(Set vcleVehicleLicenseReportCrs) {
        this.vcleVehicleLicenseReportCrs = vcleVehicleLicenseReportCrs;
    }
    public Set getVcleVehicleResponsibleJoins() {
        return this.vcleVehicleResponsibleJoins;
    }
    
    public void setVcleVehicleResponsibleJoins(Set vcleVehicleResponsibleJoins) {
        this.vcleVehicleResponsibleJoins = vcleVehicleResponsibleJoins;
    }
    public Set getVcleVehicleInvoiceLiqs() {
        return this.vcleVehicleInvoiceLiqs;
    }
    
    public void setVcleVehicleInvoiceLiqs(Set vcleVehicleInvoiceLiqs) {
        this.vcleVehicleInvoiceLiqs = vcleVehicleInvoiceLiqs;
    }




}


