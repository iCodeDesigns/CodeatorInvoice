package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * VcleProcedureLicenseType generated by hbm2java
 */
@Entity
@Table(name="VCLE_PROCEDURE_LICENSE_TYPE"
    ,schema="CODEATOR"
)
public class VcleProcedureLicenseType  implements java.io.Serializable {


     private short licenseType;
     private String licenseTypeName;
     private Set<VcleProcedureLicenseJoin> vcleProcedureLicenseJoins = new HashSet<VcleProcedureLicenseJoin>(0);
     private Set<VcleVehicleLicense> vcleVehicleLicenses = new HashSet<VcleVehicleLicense>(0);
     private Set<VcleVehicleInspect> vcleVehicleInspects = new HashSet<VcleVehicleInspect>(0);
     private Set<VcleVehicleLicenseReport> vcleVehicleLicenseReports = new HashSet<VcleVehicleLicenseReport>(0);

    public VcleProcedureLicenseType() {
    }

	
    public VcleProcedureLicenseType(short licenseType, String licenseTypeName) {
        this.licenseType = licenseType;
        this.licenseTypeName = licenseTypeName;
    }
    public VcleProcedureLicenseType(short licenseType, String licenseTypeName, Set<VcleProcedureLicenseJoin> vcleProcedureLicenseJoins, Set<VcleVehicleLicense> vcleVehicleLicenses, Set<VcleVehicleInspect> vcleVehicleInspects, Set<VcleVehicleLicenseReport> vcleVehicleLicenseReports) {
       this.licenseType = licenseType;
       this.licenseTypeName = licenseTypeName;
       this.vcleProcedureLicenseJoins = vcleProcedureLicenseJoins;
       this.vcleVehicleLicenses = vcleVehicleLicenses;
       this.vcleVehicleInspects = vcleVehicleInspects;
       this.vcleVehicleLicenseReports = vcleVehicleLicenseReports;
    }
   
     @Id 

    
    @Column(name="LICENSE_TYPE", unique=true, nullable=false, precision=3, scale=0)
    public short getLicenseType() {
        return this.licenseType;
    }
    
    public void setLicenseType(short licenseType) {
        this.licenseType = licenseType;
    }

    
    @Column(name="LICENSE_TYPE_NAME", nullable=false, length=100)
    public String getLicenseTypeName() {
        return this.licenseTypeName;
    }
    
    public void setLicenseTypeName(String licenseTypeName) {
        this.licenseTypeName = licenseTypeName;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleProcedureLicenseType")
    public Set<VcleProcedureLicenseJoin> getVcleProcedureLicenseJoins() {
        return this.vcleProcedureLicenseJoins;
    }
    
    public void setVcleProcedureLicenseJoins(Set<VcleProcedureLicenseJoin> vcleProcedureLicenseJoins) {
        this.vcleProcedureLicenseJoins = vcleProcedureLicenseJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleProcedureLicenseType")
    public Set<VcleVehicleLicense> getVcleVehicleLicenses() {
        return this.vcleVehicleLicenses;
    }
    
    public void setVcleVehicleLicenses(Set<VcleVehicleLicense> vcleVehicleLicenses) {
        this.vcleVehicleLicenses = vcleVehicleLicenses;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleProcedureLicenseType")
    public Set<VcleVehicleInspect> getVcleVehicleInspects() {
        return this.vcleVehicleInspects;
    }
    
    public void setVcleVehicleInspects(Set<VcleVehicleInspect> vcleVehicleInspects) {
        this.vcleVehicleInspects = vcleVehicleInspects;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleProcedureLicenseType")
    public Set<VcleVehicleLicenseReport> getVcleVehicleLicenseReports() {
        return this.vcleVehicleLicenseReports;
    }
    
    public void setVcleVehicleLicenseReports(Set<VcleVehicleLicenseReport> vcleVehicleLicenseReports) {
        this.vcleVehicleLicenseReports = vcleVehicleLicenseReports;
    }




}

