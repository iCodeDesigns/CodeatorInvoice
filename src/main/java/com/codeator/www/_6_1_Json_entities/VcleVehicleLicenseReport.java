package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * VcleVehicleLicenseReport generated by hbm2java
 */
public class VcleVehicleLicenseReport  implements java.io.Serializable {


     private VcleVehicleLicenseReportId id;
     private VcleProcedureLicenseType vcleProcedureLicenseType;
     private VcleVehicleType vcleVehicleType;
     private VcleIssueDocumentLin vcleIssueDocumentLin;
     private Date reportDate;
     private Date execMm;
     private Integer vcIssueDocSeq;
     private String rmrk;
     private Date licenseMm;
     private Set vcleVehicleLicenseDtls = new HashSet(0);
     private Set vcleVehicleLicenseReportDts = new HashSet(0);
     private Set vcleVehicleLicenseReportCrs = new HashSet(0);

    public VcleVehicleLicenseReport() {
    }

	
    public VcleVehicleLicenseReport(VcleVehicleLicenseReportId id, Date licenseMm) {
        this.id = id;
        this.licenseMm = licenseMm;
    }
    public VcleVehicleLicenseReport(VcleVehicleLicenseReportId id, VcleProcedureLicenseType vcleProcedureLicenseType, VcleVehicleType vcleVehicleType, VcleIssueDocumentLin vcleIssueDocumentLin, Date reportDate, Date execMm, Integer vcIssueDocSeq, String rmrk, Date licenseMm, Set vcleVehicleLicenseDtls, Set vcleVehicleLicenseReportDts, Set vcleVehicleLicenseReportCrs) {
       this.id = id;
       this.vcleProcedureLicenseType = vcleProcedureLicenseType;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleIssueDocumentLin = vcleIssueDocumentLin;
       this.reportDate = reportDate;
       this.execMm = execMm;
       this.vcIssueDocSeq = vcIssueDocSeq;
       this.rmrk = rmrk;
       this.licenseMm = licenseMm;
       this.vcleVehicleLicenseDtls = vcleVehicleLicenseDtls;
       this.vcleVehicleLicenseReportDts = vcleVehicleLicenseReportDts;
       this.vcleVehicleLicenseReportCrs = vcleVehicleLicenseReportCrs;
    }
   
    public VcleVehicleLicenseReportId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleLicenseReportId id) {
        this.id = id;
    }
    public VcleProcedureLicenseType getVcleProcedureLicenseType() {
        return this.vcleProcedureLicenseType;
    }
    
    public void setVcleProcedureLicenseType(VcleProcedureLicenseType vcleProcedureLicenseType) {
        this.vcleProcedureLicenseType = vcleProcedureLicenseType;
    }
    public VcleVehicleType getVcleVehicleType() {
        return this.vcleVehicleType;
    }
    
    public void setVcleVehicleType(VcleVehicleType vcleVehicleType) {
        this.vcleVehicleType = vcleVehicleType;
    }
    public VcleIssueDocumentLin getVcleIssueDocumentLin() {
        return this.vcleIssueDocumentLin;
    }
    
    public void setVcleIssueDocumentLin(VcleIssueDocumentLin vcleIssueDocumentLin) {
        this.vcleIssueDocumentLin = vcleIssueDocumentLin;
    }
    public Date getReportDate() {
        return this.reportDate;
    }
    
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
    public Date getExecMm() {
        return this.execMm;
    }
    
    public void setExecMm(Date execMm) {
        this.execMm = execMm;
    }
    public Integer getVcIssueDocSeq() {
        return this.vcIssueDocSeq;
    }
    
    public void setVcIssueDocSeq(Integer vcIssueDocSeq) {
        this.vcIssueDocSeq = vcIssueDocSeq;
    }
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }
    public Date getLicenseMm() {
        return this.licenseMm;
    }
    
    public void setLicenseMm(Date licenseMm) {
        this.licenseMm = licenseMm;
    }
    public Set getVcleVehicleLicenseDtls() {
        return this.vcleVehicleLicenseDtls;
    }
    
    public void setVcleVehicleLicenseDtls(Set vcleVehicleLicenseDtls) {
        this.vcleVehicleLicenseDtls = vcleVehicleLicenseDtls;
    }
    public Set getVcleVehicleLicenseReportDts() {
        return this.vcleVehicleLicenseReportDts;
    }
    
    public void setVcleVehicleLicenseReportDts(Set vcleVehicleLicenseReportDts) {
        this.vcleVehicleLicenseReportDts = vcleVehicleLicenseReportDts;
    }
    public Set getVcleVehicleLicenseReportCrs() {
        return this.vcleVehicleLicenseReportCrs;
    }
    
    public void setVcleVehicleLicenseReportCrs(Set vcleVehicleLicenseReportCrs) {
        this.vcleVehicleLicenseReportCrs = vcleVehicleLicenseReportCrs;
    }




}


