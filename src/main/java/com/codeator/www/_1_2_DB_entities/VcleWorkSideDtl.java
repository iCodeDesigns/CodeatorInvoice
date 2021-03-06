package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleWorkSideDtl generated by hbm2java
 */
@Entity
@Table(name="VCLE_WORK_SIDE_DTL"
    ,schema="CODEATOR"
)
public class VcleWorkSideDtl  implements java.io.Serializable {


     private VcleWorkSideDtlId id;
     private VcleWorkSide vcleWorkSide;
     private VcleVehicleMaster vcleVehicleMaster;
     private Date workDate;
     private String workRmrk;
     private Boolean chkStop;

    public VcleWorkSideDtl() {
    }

	
    public VcleWorkSideDtl(VcleWorkSideDtlId id, VcleWorkSide vcleWorkSide, VcleVehicleMaster vcleVehicleMaster, Date workDate) {
        this.id = id;
        this.vcleWorkSide = vcleWorkSide;
        this.vcleVehicleMaster = vcleVehicleMaster;
        this.workDate = workDate;
    }
    public VcleWorkSideDtl(VcleWorkSideDtlId id, VcleWorkSide vcleWorkSide, VcleVehicleMaster vcleVehicleMaster, Date workDate, String workRmrk, Boolean chkStop) {
       this.id = id;
       this.vcleWorkSide = vcleWorkSide;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.workDate = workDate;
       this.workRmrk = workRmrk;
       this.chkStop = chkStop;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="vehicleSp", column=@Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="workSideCode", column=@Column(name="WORK_SIDE_CODE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="workSp", column=@Column(name="WORK_SP", nullable=false, precision=6, scale=0) ) } )
    public VcleWorkSideDtlId getId() {
        return this.id;
    }
    
    public void setId(VcleWorkSideDtlId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="WORK_SIDE_CODE", nullable=false, insertable=false, updatable=false)
    public VcleWorkSide getVcleWorkSide() {
        return this.vcleWorkSide;
    }
    
    public void setVcleWorkSide(VcleWorkSide vcleWorkSide) {
        this.vcleWorkSide = vcleWorkSide;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VEHICLE_SP", nullable=false, insertable=false, updatable=false)
    public VcleVehicleMaster getVcleVehicleMaster() {
        return this.vcleVehicleMaster;
    }
    
    public void setVcleVehicleMaster(VcleVehicleMaster vcleVehicleMaster) {
        this.vcleVehicleMaster = vcleVehicleMaster;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="WORK_DATE", nullable=false, length=7)
    public Date getWorkDate() {
        return this.workDate;
    }
    
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    
    @Column(name="WORK_RMRK", length=100)
    public String getWorkRmrk() {
        return this.workRmrk;
    }
    
    public void setWorkRmrk(String workRmrk) {
        this.workRmrk = workRmrk;
    }

    
    @Column(name="CHK_STOP", precision=1, scale=0)
    public Boolean getChkStop() {
        return this.chkStop;
    }
    
    public void setChkStop(Boolean chkStop) {
        this.chkStop = chkStop;
    }




}


