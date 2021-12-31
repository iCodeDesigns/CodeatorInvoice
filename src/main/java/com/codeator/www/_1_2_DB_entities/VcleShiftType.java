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
 * VcleShiftType generated by hbm2java
 */
@Entity
@Table(name="VCLE_SHIFT_TYPE"
    ,schema="CODEATOR"
)
public class VcleShiftType  implements java.io.Serializable {


     private boolean shiftType;
     private Byte shiftFromHh;
     private Byte shiftFromMi;
     private Byte shiftToHh;
     private Byte shiftToMi;
     private Boolean shiftFromType;
     private Boolean shiftToType;
     private Set<VcleFuelIssueLiquid> vcleFuelIssueLiquids = new HashSet<VcleFuelIssueLiquid>(0);
     private Set<VcleEmployeeMaster> vcleEmployeeMasters = new HashSet<VcleEmployeeMaster>(0);
     private Set<VcleFuelProvideLiquid> vcleFuelProvideLiquids = new HashSet<VcleFuelProvideLiquid>(0);
     private Set<VcleRecordMovement> vcleRecordMovementsForShiftTypeComming = new HashSet<VcleRecordMovement>(0);
     private Set<VcleRecordMovement> vcleRecordMovementsForShiftType = new HashSet<VcleRecordMovement>(0);
     private Set<VcleTankBalance> vcleTankBalances = new HashSet<VcleTankBalance>(0);
     private Set<VcleFuelBalanceLiquid> vcleFuelBalanceLiquids = new HashSet<VcleFuelBalanceLiquid>(0);

    public VcleShiftType() {
    }

	
    public VcleShiftType(boolean shiftType) {
        this.shiftType = shiftType;
    }
    public VcleShiftType(boolean shiftType, Byte shiftFromHh, Byte shiftFromMi, Byte shiftToHh, Byte shiftToMi, Boolean shiftFromType, Boolean shiftToType, Set<VcleFuelIssueLiquid> vcleFuelIssueLiquids, Set<VcleEmployeeMaster> vcleEmployeeMasters, Set<VcleFuelProvideLiquid> vcleFuelProvideLiquids, Set<VcleRecordMovement> vcleRecordMovementsForShiftTypeComming, Set<VcleRecordMovement> vcleRecordMovementsForShiftType, Set<VcleTankBalance> vcleTankBalances, Set<VcleFuelBalanceLiquid> vcleFuelBalanceLiquids) {
       this.shiftType = shiftType;
       this.shiftFromHh = shiftFromHh;
       this.shiftFromMi = shiftFromMi;
       this.shiftToHh = shiftToHh;
       this.shiftToMi = shiftToMi;
       this.shiftFromType = shiftFromType;
       this.shiftToType = shiftToType;
       this.vcleFuelIssueLiquids = vcleFuelIssueLiquids;
       this.vcleEmployeeMasters = vcleEmployeeMasters;
       this.vcleFuelProvideLiquids = vcleFuelProvideLiquids;
       this.vcleRecordMovementsForShiftTypeComming = vcleRecordMovementsForShiftTypeComming;
       this.vcleRecordMovementsForShiftType = vcleRecordMovementsForShiftType;
       this.vcleTankBalances = vcleTankBalances;
       this.vcleFuelBalanceLiquids = vcleFuelBalanceLiquids;
    }
   
     @Id 

    
    @Column(name="SHIFT_TYPE", unique=true, nullable=false, precision=1, scale=0)
    public boolean isShiftType() {
        return this.shiftType;
    }
    
    public void setShiftType(boolean shiftType) {
        this.shiftType = shiftType;
    }

    
    @Column(name="SHIFT_FROM_HH", precision=2, scale=0)
    public Byte getShiftFromHh() {
        return this.shiftFromHh;
    }
    
    public void setShiftFromHh(Byte shiftFromHh) {
        this.shiftFromHh = shiftFromHh;
    }

    
    @Column(name="SHIFT_FROM_MI", precision=2, scale=0)
    public Byte getShiftFromMi() {
        return this.shiftFromMi;
    }
    
    public void setShiftFromMi(Byte shiftFromMi) {
        this.shiftFromMi = shiftFromMi;
    }

    
    @Column(name="SHIFT_TO_HH", precision=2, scale=0)
    public Byte getShiftToHh() {
        return this.shiftToHh;
    }
    
    public void setShiftToHh(Byte shiftToHh) {
        this.shiftToHh = shiftToHh;
    }

    
    @Column(name="SHIFT_TO_MI", precision=2, scale=0)
    public Byte getShiftToMi() {
        return this.shiftToMi;
    }
    
    public void setShiftToMi(Byte shiftToMi) {
        this.shiftToMi = shiftToMi;
    }

    
    @Column(name="SHIFT_FROM_TYPE", precision=1, scale=0)
    public Boolean getShiftFromType() {
        return this.shiftFromType;
    }
    
    public void setShiftFromType(Boolean shiftFromType) {
        this.shiftFromType = shiftFromType;
    }

    
    @Column(name="SHIFT_TO_TYPE", precision=1, scale=0)
    public Boolean getShiftToType() {
        return this.shiftToType;
    }
    
    public void setShiftToType(Boolean shiftToType) {
        this.shiftToType = shiftToType;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleShiftType")
    public Set<VcleFuelIssueLiquid> getVcleFuelIssueLiquids() {
        return this.vcleFuelIssueLiquids;
    }
    
    public void setVcleFuelIssueLiquids(Set<VcleFuelIssueLiquid> vcleFuelIssueLiquids) {
        this.vcleFuelIssueLiquids = vcleFuelIssueLiquids;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleShiftType")
    public Set<VcleEmployeeMaster> getVcleEmployeeMasters() {
        return this.vcleEmployeeMasters;
    }
    
    public void setVcleEmployeeMasters(Set<VcleEmployeeMaster> vcleEmployeeMasters) {
        this.vcleEmployeeMasters = vcleEmployeeMasters;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleShiftType")
    public Set<VcleFuelProvideLiquid> getVcleFuelProvideLiquids() {
        return this.vcleFuelProvideLiquids;
    }
    
    public void setVcleFuelProvideLiquids(Set<VcleFuelProvideLiquid> vcleFuelProvideLiquids) {
        this.vcleFuelProvideLiquids = vcleFuelProvideLiquids;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleShiftTypeByShiftTypeComming")
    public Set<VcleRecordMovement> getVcleRecordMovementsForShiftTypeComming() {
        return this.vcleRecordMovementsForShiftTypeComming;
    }
    
    public void setVcleRecordMovementsForShiftTypeComming(Set<VcleRecordMovement> vcleRecordMovementsForShiftTypeComming) {
        this.vcleRecordMovementsForShiftTypeComming = vcleRecordMovementsForShiftTypeComming;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleShiftTypeByShiftType")
    public Set<VcleRecordMovement> getVcleRecordMovementsForShiftType() {
        return this.vcleRecordMovementsForShiftType;
    }
    
    public void setVcleRecordMovementsForShiftType(Set<VcleRecordMovement> vcleRecordMovementsForShiftType) {
        this.vcleRecordMovementsForShiftType = vcleRecordMovementsForShiftType;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleShiftType")
    public Set<VcleTankBalance> getVcleTankBalances() {
        return this.vcleTankBalances;
    }
    
    public void setVcleTankBalances(Set<VcleTankBalance> vcleTankBalances) {
        this.vcleTankBalances = vcleTankBalances;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleShiftType")
    public Set<VcleFuelBalanceLiquid> getVcleFuelBalanceLiquids() {
        return this.vcleFuelBalanceLiquids;
    }
    
    public void setVcleFuelBalanceLiquids(Set<VcleFuelBalanceLiquid> vcleFuelBalanceLiquids) {
        this.vcleFuelBalanceLiquids = vcleFuelBalanceLiquids;
    }




}


