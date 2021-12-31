package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
 * VcleVehicleInspectCar generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_INSPECT_CAR"
    ,schema="CODEATOR"
)
public class VcleVehicleInspectCar  implements java.io.Serializable {


     private VcleVehicleInspectCarId id;
     private VcleVehicleMaster vcleVehicleMaster;
     private VcleVehicleInspect vcleVehicleInspect;
     private Integer boardDigital;
     private String boardAlfa3;
     private String boardAlfa2;
     private String boardAlfa1;
     private String rmrk;
     private BigDecimal valCar;
     private Byte carSeq;

    public VcleVehicleInspectCar() {
    }

	
    public VcleVehicleInspectCar(VcleVehicleInspectCarId id, VcleVehicleMaster vcleVehicleMaster, VcleVehicleInspect vcleVehicleInspect) {
        this.id = id;
        this.vcleVehicleMaster = vcleVehicleMaster;
        this.vcleVehicleInspect = vcleVehicleInspect;
    }
    public VcleVehicleInspectCar(VcleVehicleInspectCarId id, VcleVehicleMaster vcleVehicleMaster, VcleVehicleInspect vcleVehicleInspect, Integer boardDigital, String boardAlfa3, String boardAlfa2, String boardAlfa1, String rmrk, BigDecimal valCar, Byte carSeq) {
       this.id = id;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.vcleVehicleInspect = vcleVehicleInspect;
       this.boardDigital = boardDigital;
       this.boardAlfa3 = boardAlfa3;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa1 = boardAlfa1;
       this.rmrk = rmrk;
       this.valCar = valCar;
       this.carSeq = carSeq;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="inspectDate", column=@Column(name="INSPECT_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="licenseType", column=@Column(name="LICENSE_TYPE", nullable=false, precision=3, scale=0) ), 
        @AttributeOverride(name="vehicleSp", column=@Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0) ) } )
    public VcleVehicleInspectCarId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleInspectCarId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VEHICLE_SP", nullable=false, insertable=false, updatable=false)
    public VcleVehicleMaster getVcleVehicleMaster() {
        return this.vcleVehicleMaster;
    }
    
    public void setVcleVehicleMaster(VcleVehicleMaster vcleVehicleMaster) {
        this.vcleVehicleMaster = vcleVehicleMaster;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="INSPECT_DATE", referencedColumnName="INSPECT_DATE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="LICENSE_TYPE", referencedColumnName="LICENSE_TYPE", nullable=false, insertable=false, updatable=false) } )
    public VcleVehicleInspect getVcleVehicleInspect() {
        return this.vcleVehicleInspect;
    }
    
    public void setVcleVehicleInspect(VcleVehicleInspect vcleVehicleInspect) {
        this.vcleVehicleInspect = vcleVehicleInspect;
    }

    
    @Column(name="BOARD_DIGITAL", precision=6, scale=0)
    public Integer getBoardDigital() {
        return this.boardDigital;
    }
    
    public void setBoardDigital(Integer boardDigital) {
        this.boardDigital = boardDigital;
    }

    
    @Column(name="BOARD_ALFA3", length=1)
    public String getBoardAlfa3() {
        return this.boardAlfa3;
    }
    
    public void setBoardAlfa3(String boardAlfa3) {
        this.boardAlfa3 = boardAlfa3;
    }

    
    @Column(name="BOARD_ALFA2", length=1)
    public String getBoardAlfa2() {
        return this.boardAlfa2;
    }
    
    public void setBoardAlfa2(String boardAlfa2) {
        this.boardAlfa2 = boardAlfa2;
    }

    
    @Column(name="BOARD_ALFA1", length=1)
    public String getBoardAlfa1() {
        return this.boardAlfa1;
    }
    
    public void setBoardAlfa1(String boardAlfa1) {
        this.boardAlfa1 = boardAlfa1;
    }

    
    @Column(name="RMRK", length=200)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    
    @Column(name="VAL_CAR", precision=9)
    public BigDecimal getValCar() {
        return this.valCar;
    }
    
    public void setValCar(BigDecimal valCar) {
        this.valCar = valCar;
    }

    
    @Column(name="CAR_SEQ", precision=2, scale=0)
    public Byte getCarSeq() {
        return this.carSeq;
    }
    
    public void setCarSeq(Byte carSeq) {
        this.carSeq = carSeq;
    }




}


