package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * VcleVehicleLicenseReportDt generated by hbm2java
 */
public class VcleVehicleLicenseReportDt  implements java.io.Serializable {


     private VcleVehicleLicenseReportDtId id;
     private VcleCostType vcleCostType;
     private VcleVehicleLicenseReport vcleVehicleLicenseReport;
     private Byte repSeq;

    public VcleVehicleLicenseReportDt() {
    }

	
    public VcleVehicleLicenseReportDt(VcleVehicleLicenseReportDtId id, VcleCostType vcleCostType, VcleVehicleLicenseReport vcleVehicleLicenseReport) {
        this.id = id;
        this.vcleCostType = vcleCostType;
        this.vcleVehicleLicenseReport = vcleVehicleLicenseReport;
    }
    public VcleVehicleLicenseReportDt(VcleVehicleLicenseReportDtId id, VcleCostType vcleCostType, VcleVehicleLicenseReport vcleVehicleLicenseReport, Byte repSeq) {
       this.id = id;
       this.vcleCostType = vcleCostType;
       this.vcleVehicleLicenseReport = vcleVehicleLicenseReport;
       this.repSeq = repSeq;
    }
   
    public VcleVehicleLicenseReportDtId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleLicenseReportDtId id) {
        this.id = id;
    }
    public VcleCostType getVcleCostType() {
        return this.vcleCostType;
    }
    
    public void setVcleCostType(VcleCostType vcleCostType) {
        this.vcleCostType = vcleCostType;
    }
    public VcleVehicleLicenseReport getVcleVehicleLicenseReport() {
        return this.vcleVehicleLicenseReport;
    }
    
    public void setVcleVehicleLicenseReport(VcleVehicleLicenseReport vcleVehicleLicenseReport) {
        this.vcleVehicleLicenseReport = vcleVehicleLicenseReport;
    }
    public Byte getRepSeq() {
        return this.repSeq;
    }
    
    public void setRepSeq(Byte repSeq) {
        this.repSeq = repSeq;
    }




}


