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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleMaintanceRepair generated by hbm2java
 */
@Entity
@Table(name="VCLE_MAINTANCE_REPAIR"
    ,schema="CODEATOR"
)
public class VcleMaintanceRepair  implements java.io.Serializable {


     private VcleMaintanceRepairId id;
     private VcleMainCostCode vcleMainCostCode;
     private String rmrk;
     private Date exitDate;
     private Set<VcleMaintanceRepairDtl> vcleMaintanceRepairDtls = new HashSet<VcleMaintanceRepairDtl>(0);

    public VcleMaintanceRepair() {
    }

	
    public VcleMaintanceRepair(VcleMaintanceRepairId id, VcleMainCostCode vcleMainCostCode) {
        this.id = id;
        this.vcleMainCostCode = vcleMainCostCode;
    }
    public VcleMaintanceRepair(VcleMaintanceRepairId id, VcleMainCostCode vcleMainCostCode, String rmrk, Date exitDate, Set<VcleMaintanceRepairDtl> vcleMaintanceRepairDtls) {
       this.id = id;
       this.vcleMainCostCode = vcleMainCostCode;
       this.rmrk = rmrk;
       this.exitDate = exitDate;
       this.vcleMaintanceRepairDtls = vcleMaintanceRepairDtls;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="notifyDate", column=@Column(name="NOTIFY_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="instructionDate", column=@Column(name="INSTRUCTION_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="vehicleSp", column=@Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="employeeIdHave", column=@Column(name="EMPLOYEE_ID_HAVE", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="costCode", column=@Column(name="COST_CODE", nullable=false, length=10) ), 
        @AttributeOverride(name="enterDate", column=@Column(name="ENTER_DATE", nullable=false, length=7) ) } )
    public VcleMaintanceRepairId getId() {
        return this.id;
    }
    
    public void setId(VcleMaintanceRepairId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COST_CODE", nullable=false, insertable=false, updatable=false)
    public VcleMainCostCode getVcleMainCostCode() {
        return this.vcleMainCostCode;
    }
    
    public void setVcleMainCostCode(VcleMainCostCode vcleMainCostCode) {
        this.vcleMainCostCode = vcleMainCostCode;
    }

    
    @Column(name="RMRK", length=150)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="EXIT_DATE", length=7)
    public Date getExitDate() {
        return this.exitDate;
    }
    
    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleMaintanceRepair")
    public Set<VcleMaintanceRepairDtl> getVcleMaintanceRepairDtls() {
        return this.vcleMaintanceRepairDtls;
    }
    
    public void setVcleMaintanceRepairDtls(Set<VcleMaintanceRepairDtl> vcleMaintanceRepairDtls) {
        this.vcleMaintanceRepairDtls = vcleMaintanceRepairDtls;
    }




}


