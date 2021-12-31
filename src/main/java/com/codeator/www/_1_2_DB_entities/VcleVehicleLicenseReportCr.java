package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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

/**
 * VcleVehicleLicenseReportCr generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_LICENSE_REPORT_CR"
    ,schema="CODEATOR"
)
public class VcleVehicleLicenseReportCr  implements java.io.Serializable {


     private VcleVehicleLicenseReportCrId id;
     private VcleVehicleMaster vcleVehicleMaster;
     private VcleVehicleLicenseReport vcleVehicleLicenseReport;
     private String boardAlfa1;
     private String boardAlfa2;
     private String boardAlfa3;
     private Integer boardDigital;
     private BigDecimal valAll;
     private Byte repCrSeq;

    public VcleVehicleLicenseReportCr() {
    }

	
    public VcleVehicleLicenseReportCr(VcleVehicleLicenseReportCrId id, VcleVehicleMaster vcleVehicleMaster, VcleVehicleLicenseReport vcleVehicleLicenseReport) {
        this.id = id;
        this.vcleVehicleMaster = vcleVehicleMaster;
        this.vcleVehicleLicenseReport = vcleVehicleLicenseReport;
    }
    public VcleVehicleLicenseReportCr(VcleVehicleLicenseReportCrId id, VcleVehicleMaster vcleVehicleMaster, VcleVehicleLicenseReport vcleVehicleLicenseReport, String boardAlfa1, String boardAlfa2, String boardAlfa3, Integer boardDigital, BigDecimal valAll, Byte repCrSeq) {
       this.id = id;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.vcleVehicleLicenseReport = vcleVehicleLicenseReport;
       this.boardAlfa1 = boardAlfa1;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa3 = boardAlfa3;
       this.boardDigital = boardDigital;
       this.valAll = valAll;
       this.repCrSeq = repCrSeq;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="reportSp", column=@Column(name="REPORT_SP", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="reportType", column=@Column(name="REPORT_TYPE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="fiscalDate", column=@Column(name="FISCAL_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="vehicleSp", column=@Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0) ) } )
    public VcleVehicleLicenseReportCrId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleLicenseReportCrId id) {
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
    @JoinColumns( { 
        @JoinColumn(name="REPORT_TYPE", referencedColumnName="REPORT_TYPE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="FISCAL_DATE", referencedColumnName="FISCAL_DATE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="REPORT_SP", referencedColumnName="REPORT_SP", nullable=false, insertable=false, updatable=false) } )
    public VcleVehicleLicenseReport getVcleVehicleLicenseReport() {
        return this.vcleVehicleLicenseReport;
    }
    
    public void setVcleVehicleLicenseReport(VcleVehicleLicenseReport vcleVehicleLicenseReport) {
        this.vcleVehicleLicenseReport = vcleVehicleLicenseReport;
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

    
    @Column(name="BOARD_DIGITAL", precision=6, scale=0)
    public Integer getBoardDigital() {
        return this.boardDigital;
    }
    
    public void setBoardDigital(Integer boardDigital) {
        this.boardDigital = boardDigital;
    }

    
    @Column(name="VAL_ALL", precision=9)
    public BigDecimal getValAll() {
        return this.valAll;
    }
    
    public void setValAll(BigDecimal valAll) {
        this.valAll = valAll;
    }

    
    @Column(name="REP_CR_SEQ", precision=2, scale=0)
    public Byte getRepCrSeq() {
        return this.repCrSeq;
    }
    
    public void setRepCrSeq(Byte repCrSeq) {
        this.repCrSeq = repCrSeq;
    }




}

