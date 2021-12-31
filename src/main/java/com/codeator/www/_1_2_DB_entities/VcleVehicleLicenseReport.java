package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleVehicleLicenseReport generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_LICENSE_REPORT"
    ,schema="CODEATOR"
)
public class VcleVehicleLicenseReport  implements java.io.Serializable {


     private VcleVehicleLicenseReportId id;
     private VcleVehicleType vcleVehicleType;
     private VcleProcedureLicenseType vcleProcedureLicenseType;
     private VcleIssueDocumentLin vcleIssueDocumentLin;
     private Date reportDate;
     private Date execMm;
     private Integer vcIssueDocSeq;
     private String rmrk;
     private Date licenseMm;
     private Set<VcleVehicleLicenseDtl> vcleVehicleLicenseDtls = new HashSet<VcleVehicleLicenseDtl>(0);
     private Set<VcleVehicleLicenseReportDt> vcleVehicleLicenseReportDts = new HashSet<VcleVehicleLicenseReportDt>(0);
     private Set<VcleVehicleLicenseReportCr> vcleVehicleLicenseReportCrs = new HashSet<VcleVehicleLicenseReportCr>(0);

    public VcleVehicleLicenseReport() {
    }

	
    public VcleVehicleLicenseReport(VcleVehicleLicenseReportId id, Date licenseMm) {
        this.id = id;
        this.licenseMm = licenseMm;
    }
    public VcleVehicleLicenseReport(VcleVehicleLicenseReportId id, VcleVehicleType vcleVehicleType, VcleProcedureLicenseType vcleProcedureLicenseType, VcleIssueDocumentLin vcleIssueDocumentLin, Date reportDate, Date execMm, Integer vcIssueDocSeq, String rmrk, Date licenseMm, Set<VcleVehicleLicenseDtl> vcleVehicleLicenseDtls, Set<VcleVehicleLicenseReportDt> vcleVehicleLicenseReportDts, Set<VcleVehicleLicenseReportCr> vcleVehicleLicenseReportCrs) {
       this.id = id;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleProcedureLicenseType = vcleProcedureLicenseType;
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
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="reportType", column=@Column(name="REPORT_TYPE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="fiscalDate", column=@Column(name="FISCAL_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="reportSp", column=@Column(name="REPORT_SP", nullable=false, precision=6, scale=0) ) } )
    public VcleVehicleLicenseReportId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleLicenseReportId id) {
        this.id = id;
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
    @JoinColumn(name="LICENSE_TYPE")
    public VcleProcedureLicenseType getVcleProcedureLicenseType() {
        return this.vcleProcedureLicenseType;
    }
    
    public void setVcleProcedureLicenseType(VcleProcedureLicenseType vcleProcedureLicenseType) {
        this.vcleProcedureLicenseType = vcleProcedureLicenseType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="FISCAL_YEAR", referencedColumnName="FISCAL_YEAR"), 
        @JoinColumn(name="VC_ISSUE_DOC_SP", referencedColumnName="VC_ISSUE_DOC_SP") } )
    public VcleIssueDocumentLin getVcleIssueDocumentLin() {
        return this.vcleIssueDocumentLin;
    }
    
    public void setVcleIssueDocumentLin(VcleIssueDocumentLin vcleIssueDocumentLin) {
        this.vcleIssueDocumentLin = vcleIssueDocumentLin;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="REPORT_DATE", length=7)
    public Date getReportDate() {
        return this.reportDate;
    }
    
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="EXEC_MM", length=7)
    public Date getExecMm() {
        return this.execMm;
    }
    
    public void setExecMm(Date execMm) {
        this.execMm = execMm;
    }

    
    @Column(name="VC_ISSUE_DOC_SEQ", precision=6, scale=0)
    public Integer getVcIssueDocSeq() {
        return this.vcIssueDocSeq;
    }
    
    public void setVcIssueDocSeq(Integer vcIssueDocSeq) {
        this.vcIssueDocSeq = vcIssueDocSeq;
    }

    
    @Column(name="RMRK", length=200)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LICENSE_MM", nullable=false, length=7)
    public Date getLicenseMm() {
        return this.licenseMm;
    }
    
    public void setLicenseMm(Date licenseMm) {
        this.licenseMm = licenseMm;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleVehicleLicenseReport")
    public Set<VcleVehicleLicenseDtl> getVcleVehicleLicenseDtls() {
        return this.vcleVehicleLicenseDtls;
    }
    
    public void setVcleVehicleLicenseDtls(Set<VcleVehicleLicenseDtl> vcleVehicleLicenseDtls) {
        this.vcleVehicleLicenseDtls = vcleVehicleLicenseDtls;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleVehicleLicenseReport")
    public Set<VcleVehicleLicenseReportDt> getVcleVehicleLicenseReportDts() {
        return this.vcleVehicleLicenseReportDts;
    }
    
    public void setVcleVehicleLicenseReportDts(Set<VcleVehicleLicenseReportDt> vcleVehicleLicenseReportDts) {
        this.vcleVehicleLicenseReportDts = vcleVehicleLicenseReportDts;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleVehicleLicenseReport")
    public Set<VcleVehicleLicenseReportCr> getVcleVehicleLicenseReportCrs() {
        return this.vcleVehicleLicenseReportCrs;
    }
    
    public void setVcleVehicleLicenseReportCrs(Set<VcleVehicleLicenseReportCr> vcleVehicleLicenseReportCrs) {
        this.vcleVehicleLicenseReportCrs = vcleVehicleLicenseReportCrs;
    }




}

