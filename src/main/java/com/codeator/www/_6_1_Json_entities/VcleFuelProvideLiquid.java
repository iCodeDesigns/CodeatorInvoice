package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * VcleFuelProvideLiquid generated by hbm2java
 */
public class VcleFuelProvideLiquid  implements java.io.Serializable {


     private VcleFuelProvideLiquidId id;
     private VcleFuelOpenDay vcleFuelOpenDay;
     private VcleShiftType vcleShiftType;
     private Date invoiceDate;
     private BigDecimal fristBnzQun;
     private BigDecimal secondBnzQun;
     private BigDecimal fristSolQun;
     private Long eznSeqRcv;
     private Byte timeHh;
     private Byte timeMi;
     private Boolean timeType;
     private String rmrk;
     private Boolean chkLock;
     private Integer invoiceNo;
     private BigDecimal fristBnzTankNum;
     private BigDecimal secondBnzTankNum;
     private BigDecimal fristSolTankNum;
     private Boolean provideType;
     private BigDecimal qunOver;
     private Date fiscalDate;

    public VcleFuelProvideLiquid() {
    }

	
    public VcleFuelProvideLiquid(VcleFuelProvideLiquidId id, VcleFuelOpenDay vcleFuelOpenDay) {
        this.id = id;
        this.vcleFuelOpenDay = vcleFuelOpenDay;
    }
    public VcleFuelProvideLiquid(VcleFuelProvideLiquidId id, VcleFuelOpenDay vcleFuelOpenDay, VcleShiftType vcleShiftType, Date invoiceDate, BigDecimal fristBnzQun, BigDecimal secondBnzQun, BigDecimal fristSolQun, Long eznSeqRcv, Byte timeHh, Byte timeMi, Boolean timeType, String rmrk, Boolean chkLock, Integer invoiceNo, BigDecimal fristBnzTankNum, BigDecimal secondBnzTankNum, BigDecimal fristSolTankNum, Boolean provideType, BigDecimal qunOver, Date fiscalDate) {
       this.id = id;
       this.vcleFuelOpenDay = vcleFuelOpenDay;
       this.vcleShiftType = vcleShiftType;
       this.invoiceDate = invoiceDate;
       this.fristBnzQun = fristBnzQun;
       this.secondBnzQun = secondBnzQun;
       this.fristSolQun = fristSolQun;
       this.eznSeqRcv = eznSeqRcv;
       this.timeHh = timeHh;
       this.timeMi = timeMi;
       this.timeType = timeType;
       this.rmrk = rmrk;
       this.chkLock = chkLock;
       this.invoiceNo = invoiceNo;
       this.fristBnzTankNum = fristBnzTankNum;
       this.secondBnzTankNum = secondBnzTankNum;
       this.fristSolTankNum = fristSolTankNum;
       this.provideType = provideType;
       this.qunOver = qunOver;
       this.fiscalDate = fiscalDate;
    }
   
    public VcleFuelProvideLiquidId getId() {
        return this.id;
    }
    
    public void setId(VcleFuelProvideLiquidId id) {
        this.id = id;
    }
    public VcleFuelOpenDay getVcleFuelOpenDay() {
        return this.vcleFuelOpenDay;
    }
    
    public void setVcleFuelOpenDay(VcleFuelOpenDay vcleFuelOpenDay) {
        this.vcleFuelOpenDay = vcleFuelOpenDay;
    }
    public VcleShiftType getVcleShiftType() {
        return this.vcleShiftType;
    }
    
    public void setVcleShiftType(VcleShiftType vcleShiftType) {
        this.vcleShiftType = vcleShiftType;
    }
    public Date getInvoiceDate() {
        return this.invoiceDate;
    }
    
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    public BigDecimal getFristBnzQun() {
        return this.fristBnzQun;
    }
    
    public void setFristBnzQun(BigDecimal fristBnzQun) {
        this.fristBnzQun = fristBnzQun;
    }
    public BigDecimal getSecondBnzQun() {
        return this.secondBnzQun;
    }
    
    public void setSecondBnzQun(BigDecimal secondBnzQun) {
        this.secondBnzQun = secondBnzQun;
    }
    public BigDecimal getFristSolQun() {
        return this.fristSolQun;
    }
    
    public void setFristSolQun(BigDecimal fristSolQun) {
        this.fristSolQun = fristSolQun;
    }
    public Long getEznSeqRcv() {
        return this.eznSeqRcv;
    }
    
    public void setEznSeqRcv(Long eznSeqRcv) {
        this.eznSeqRcv = eznSeqRcv;
    }
    public Byte getTimeHh() {
        return this.timeHh;
    }
    
    public void setTimeHh(Byte timeHh) {
        this.timeHh = timeHh;
    }
    public Byte getTimeMi() {
        return this.timeMi;
    }
    
    public void setTimeMi(Byte timeMi) {
        this.timeMi = timeMi;
    }
    public Boolean getTimeType() {
        return this.timeType;
    }
    
    public void setTimeType(Boolean timeType) {
        this.timeType = timeType;
    }
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }
    public Boolean getChkLock() {
        return this.chkLock;
    }
    
    public void setChkLock(Boolean chkLock) {
        this.chkLock = chkLock;
    }
    public Integer getInvoiceNo() {
        return this.invoiceNo;
    }
    
    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    public BigDecimal getFristBnzTankNum() {
        return this.fristBnzTankNum;
    }
    
    public void setFristBnzTankNum(BigDecimal fristBnzTankNum) {
        this.fristBnzTankNum = fristBnzTankNum;
    }
    public BigDecimal getSecondBnzTankNum() {
        return this.secondBnzTankNum;
    }
    
    public void setSecondBnzTankNum(BigDecimal secondBnzTankNum) {
        this.secondBnzTankNum = secondBnzTankNum;
    }
    public BigDecimal getFristSolTankNum() {
        return this.fristSolTankNum;
    }
    
    public void setFristSolTankNum(BigDecimal fristSolTankNum) {
        this.fristSolTankNum = fristSolTankNum;
    }
    public Boolean getProvideType() {
        return this.provideType;
    }
    
    public void setProvideType(Boolean provideType) {
        this.provideType = provideType;
    }
    public BigDecimal getQunOver() {
        return this.qunOver;
    }
    
    public void setQunOver(BigDecimal qunOver) {
        this.qunOver = qunOver;
    }
    public Date getFiscalDate() {
        return this.fiscalDate;
    }
    
    public void setFiscalDate(Date fiscalDate) {
        this.fiscalDate = fiscalDate;
    }




}


