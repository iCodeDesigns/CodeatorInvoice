package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * VcleVehicleCost generated by hbm2java
 */
public class VcleVehicleCost  implements java.io.Serializable {


     private VcleVehicleCostId id;
     private VcleVehicleMaster vcleVehicleMaster;
     private String buyerName;
     private Date recordDate;
     private String rmrk;
     private Integer boardDigital;
     private String boardAlfa1;
     private String boardAlfa2;
     private String boardAlfa3;
     private Integer boardNumberOld;
     private Date execMm;
     private BigDecimal totDisCount;
     private BigDecimal totLitreQty;
     private BigDecimal totIssueQun;
     private BigDecimal totValLiq;
     private BigDecimal totValBook;
     private BigDecimal totValue;
     private Byte fuelType;

    public VcleVehicleCost() {
    }

	
    public VcleVehicleCost(VcleVehicleCostId id, VcleVehicleMaster vcleVehicleMaster) {
        this.id = id;
        this.vcleVehicleMaster = vcleVehicleMaster;
    }
    public VcleVehicleCost(VcleVehicleCostId id, VcleVehicleMaster vcleVehicleMaster, String buyerName, Date recordDate, String rmrk, Integer boardDigital, String boardAlfa1, String boardAlfa2, String boardAlfa3, Integer boardNumberOld, Date execMm, BigDecimal totDisCount, BigDecimal totLitreQty, BigDecimal totIssueQun, BigDecimal totValLiq, BigDecimal totValBook, BigDecimal totValue, Byte fuelType) {
       this.id = id;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.buyerName = buyerName;
       this.recordDate = recordDate;
       this.rmrk = rmrk;
       this.boardDigital = boardDigital;
       this.boardAlfa1 = boardAlfa1;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa3 = boardAlfa3;
       this.boardNumberOld = boardNumberOld;
       this.execMm = execMm;
       this.totDisCount = totDisCount;
       this.totLitreQty = totLitreQty;
       this.totIssueQun = totIssueQun;
       this.totValLiq = totValLiq;
       this.totValBook = totValBook;
       this.totValue = totValue;
       this.fuelType = fuelType;
    }
   
    public VcleVehicleCostId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleCostId id) {
        this.id = id;
    }
    public VcleVehicleMaster getVcleVehicleMaster() {
        return this.vcleVehicleMaster;
    }
    
    public void setVcleVehicleMaster(VcleVehicleMaster vcleVehicleMaster) {
        this.vcleVehicleMaster = vcleVehicleMaster;
    }
    public String getBuyerName() {
        return this.buyerName;
    }
    
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
    public Date getRecordDate() {
        return this.recordDate;
    }
    
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
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
    public Integer getBoardNumberOld() {
        return this.boardNumberOld;
    }
    
    public void setBoardNumberOld(Integer boardNumberOld) {
        this.boardNumberOld = boardNumberOld;
    }
    public Date getExecMm() {
        return this.execMm;
    }
    
    public void setExecMm(Date execMm) {
        this.execMm = execMm;
    }
    public BigDecimal getTotDisCount() {
        return this.totDisCount;
    }
    
    public void setTotDisCount(BigDecimal totDisCount) {
        this.totDisCount = totDisCount;
    }
    public BigDecimal getTotLitreQty() {
        return this.totLitreQty;
    }
    
    public void setTotLitreQty(BigDecimal totLitreQty) {
        this.totLitreQty = totLitreQty;
    }
    public BigDecimal getTotIssueQun() {
        return this.totIssueQun;
    }
    
    public void setTotIssueQun(BigDecimal totIssueQun) {
        this.totIssueQun = totIssueQun;
    }
    public BigDecimal getTotValLiq() {
        return this.totValLiq;
    }
    
    public void setTotValLiq(BigDecimal totValLiq) {
        this.totValLiq = totValLiq;
    }
    public BigDecimal getTotValBook() {
        return this.totValBook;
    }
    
    public void setTotValBook(BigDecimal totValBook) {
        this.totValBook = totValBook;
    }
    public BigDecimal getTotValue() {
        return this.totValue;
    }
    
    public void setTotValue(BigDecimal totValue) {
        this.totValue = totValue;
    }
    public Byte getFuelType() {
        return this.fuelType;
    }
    
    public void setFuelType(Byte fuelType) {
        this.fuelType = fuelType;
    }




}


