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
 * VcleWorkTypeTransCar generated by hbm2java
 */
@Entity
@Table(name="VCLE_WORK_TYPE_TRANS_CAR"
    ,schema="CODEATOR"
)
public class VcleWorkTypeTransCar  implements java.io.Serializable {


     private VcleWorkTypeTransCarId id;
     private VcleWorkTypeJoin vcleWorkTypeJoin;
     private VcleVehicleType vcleVehicleType;
     private VcleVehicleMaster vcleVehicleMaster;
     private Integer boardDigital;
     private String boardAlfa1;
     private String boardAlfa2;
     private String boardAlfa3;

    public VcleWorkTypeTransCar() {
    }

	
    public VcleWorkTypeTransCar(VcleWorkTypeTransCarId id, VcleWorkTypeJoin vcleWorkTypeJoin, VcleVehicleMaster vcleVehicleMaster) {
        this.id = id;
        this.vcleWorkTypeJoin = vcleWorkTypeJoin;
        this.vcleVehicleMaster = vcleVehicleMaster;
    }
    public VcleWorkTypeTransCar(VcleWorkTypeTransCarId id, VcleWorkTypeJoin vcleWorkTypeJoin, VcleVehicleType vcleVehicleType, VcleVehicleMaster vcleVehicleMaster, Integer boardDigital, String boardAlfa1, String boardAlfa2, String boardAlfa3) {
       this.id = id;
       this.vcleWorkTypeJoin = vcleWorkTypeJoin;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.boardDigital = boardDigital;
       this.boardAlfa1 = boardAlfa1;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa3 = boardAlfa3;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="workType", column=@Column(name="WORK_TYPE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="vehicleSp", column=@Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0) ) } )
    public VcleWorkTypeTransCarId getId() {
        return this.id;
    }
    
    public void setId(VcleWorkTypeTransCarId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="WORK_TYPE", referencedColumnName="WORK_TYPE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="EMPLOYEE_ID", referencedColumnName="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false) } )
    public VcleWorkTypeJoin getVcleWorkTypeJoin() {
        return this.vcleWorkTypeJoin;
    }
    
    public void setVcleWorkTypeJoin(VcleWorkTypeJoin vcleWorkTypeJoin) {
        this.vcleWorkTypeJoin = vcleWorkTypeJoin;
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
    @JoinColumn(name="VEHICLE_SP", nullable=false, insertable=false, updatable=false)
    public VcleVehicleMaster getVcleVehicleMaster() {
        return this.vcleVehicleMaster;
    }
    
    public void setVcleVehicleMaster(VcleVehicleMaster vcleVehicleMaster) {
        this.vcleVehicleMaster = vcleVehicleMaster;
    }

    
    @Column(name="BOARD_DIGITAL", precision=6, scale=0)
    public Integer getBoardDigital() {
        return this.boardDigital;
    }
    
    public void setBoardDigital(Integer boardDigital) {
        this.boardDigital = boardDigital;
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




}


