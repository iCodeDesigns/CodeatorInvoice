package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleVehicleInspect generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_INSPECT"
    ,schema="CODEATOR"
)
public class VcleVehicleInspect  implements java.io.Serializable {


     private VcleVehicleInspectId id;
     private VcleProcedureLicenseType vcleProcedureLicenseType;
     private BigDecimal totalValue;
     private String rmrk;
     private Byte totalCar;
     private BigDecimal costCar;
     private BigDecimal remCost;
     private Boolean chkLock;
     private Date currDate;
     private Date actionDate;
     private Set<VcleVehicleInspectCar> vcleVehicleInspectCars = new HashSet<VcleVehicleInspectCar>(0);
     private Set<VcleVehicleInspectDtl> vcleVehicleInspectDtls = new HashSet<VcleVehicleInspectDtl>(0);

    public VcleVehicleInspect() {
    }

	
    public VcleVehicleInspect(VcleVehicleInspectId id, VcleProcedureLicenseType vcleProcedureLicenseType) {
        this.id = id;
        this.vcleProcedureLicenseType = vcleProcedureLicenseType;
    }
    public VcleVehicleInspect(VcleVehicleInspectId id, VcleProcedureLicenseType vcleProcedureLicenseType, BigDecimal totalValue, String rmrk, Byte totalCar, BigDecimal costCar, BigDecimal remCost, Boolean chkLock, Date currDate, Date actionDate, Set<VcleVehicleInspectCar> vcleVehicleInspectCars, Set<VcleVehicleInspectDtl> vcleVehicleInspectDtls) {
       this.id = id;
       this.vcleProcedureLicenseType = vcleProcedureLicenseType;
       this.totalValue = totalValue;
       this.rmrk = rmrk;
       this.totalCar = totalCar;
       this.costCar = costCar;
       this.remCost = remCost;
       this.chkLock = chkLock;
       this.currDate = currDate;
       this.actionDate = actionDate;
       this.vcleVehicleInspectCars = vcleVehicleInspectCars;
       this.vcleVehicleInspectDtls = vcleVehicleInspectDtls;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="inspectDate", column=@Column(name="INSPECT_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="licenseType", column=@Column(name="LICENSE_TYPE", nullable=false, precision=3, scale=0) ) } )
    public VcleVehicleInspectId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleInspectId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="LICENSE_TYPE", nullable=false, insertable=false, updatable=false)
    public VcleProcedureLicenseType getVcleProcedureLicenseType() {
        return this.vcleProcedureLicenseType;
    }
    
    public void setVcleProcedureLicenseType(VcleProcedureLicenseType vcleProcedureLicenseType) {
        this.vcleProcedureLicenseType = vcleProcedureLicenseType;
    }

    
    @Column(name="TOTAL_VALUE", precision=9)
    public BigDecimal getTotalValue() {
        return this.totalValue;
    }
    
    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    
    @Column(name="RMRK", length=100)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    
    @Column(name="TOTAL_CAR", precision=2, scale=0)
    public Byte getTotalCar() {
        return this.totalCar;
    }
    
    public void setTotalCar(Byte totalCar) {
        this.totalCar = totalCar;
    }

    
    @Column(name="COST_CAR", precision=9)
    public BigDecimal getCostCar() {
        return this.costCar;
    }
    
    public void setCostCar(BigDecimal costCar) {
        this.costCar = costCar;
    }

    
    @Column(name="REM_COST", precision=9)
    public BigDecimal getRemCost() {
        return this.remCost;
    }
    
    public void setRemCost(BigDecimal remCost) {
        this.remCost = remCost;
    }

    
    @Column(name="CHK_LOCK", precision=1, scale=0)
    public Boolean getChkLock() {
        return this.chkLock;
    }
    
    public void setChkLock(Boolean chkLock) {
        this.chkLock = chkLock;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CURR_DATE", length=7)
    public Date getCurrDate() {
        return this.currDate;
    }
    
    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ACTION_DATE", length=7)
    public Date getActionDate() {
        return this.actionDate;
    }
    
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleVehicleInspect")
    public Set<VcleVehicleInspectCar> getVcleVehicleInspectCars() {
        return this.vcleVehicleInspectCars;
    }
    
    public void setVcleVehicleInspectCars(Set<VcleVehicleInspectCar> vcleVehicleInspectCars) {
        this.vcleVehicleInspectCars = vcleVehicleInspectCars;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleVehicleInspect")
    public Set<VcleVehicleInspectDtl> getVcleVehicleInspectDtls() {
        return this.vcleVehicleInspectDtls;
    }
    
    public void setVcleVehicleInspectDtls(Set<VcleVehicleInspectDtl> vcleVehicleInspectDtls) {
        this.vcleVehicleInspectDtls = vcleVehicleInspectDtls;
    }




}


