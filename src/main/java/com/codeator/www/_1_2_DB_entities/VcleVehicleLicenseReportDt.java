package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


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
 * VcleVehicleLicenseReportDt generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_LICENSE_REPORT_DT"
    ,schema="CODEATOR"
)
public class VcleVehicleLicenseReportDt  implements java.io.Serializable {


     private VcleVehicleLicenseReportDtId id;
     private VcleVehicleLicenseReport vcleVehicleLicenseReport;
     private VcleCostType vcleCostType;
     private Byte repSeq;

    public VcleVehicleLicenseReportDt() {
    }

	
    public VcleVehicleLicenseReportDt(VcleVehicleLicenseReportDtId id, VcleVehicleLicenseReport vcleVehicleLicenseReport, VcleCostType vcleCostType) {
        this.id = id;
        this.vcleVehicleLicenseReport = vcleVehicleLicenseReport;
        this.vcleCostType = vcleCostType;
    }
    public VcleVehicleLicenseReportDt(VcleVehicleLicenseReportDtId id, VcleVehicleLicenseReport vcleVehicleLicenseReport, VcleCostType vcleCostType, Byte repSeq) {
       this.id = id;
       this.vcleVehicleLicenseReport = vcleVehicleLicenseReport;
       this.vcleCostType = vcleCostType;
       this.repSeq = repSeq;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="reportType", column=@Column(name="REPORT_TYPE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="fiscalDate", column=@Column(name="FISCAL_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="reportSp", column=@Column(name="REPORT_SP", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="costType", column=@Column(name="COST_TYPE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="costCode", column=@Column(name="COST_CODE", nullable=false, precision=6, scale=0) ) } )
    public VcleVehicleLicenseReportDtId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleLicenseReportDtId id) {
        this.id = id;
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

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="COST_TYPE", referencedColumnName="COST_TYPE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="COST_CODE", referencedColumnName="COST_CODE", nullable=false, insertable=false, updatable=false) } )
    public VcleCostType getVcleCostType() {
        return this.vcleCostType;
    }
    
    public void setVcleCostType(VcleCostType vcleCostType) {
        this.vcleCostType = vcleCostType;
    }

    
    @Column(name="REP_SEQ", precision=2, scale=0)
    public Byte getRepSeq() {
        return this.repSeq;
    }
    
    public void setRepSeq(Byte repSeq) {
        this.repSeq = repSeq;
    }




}

