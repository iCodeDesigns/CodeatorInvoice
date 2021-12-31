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
 * VcleVehicleResponsibleJoin generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_RESPONSIBLE_JOIN"
    ,schema="CODEATOR"
)
public class VcleVehicleResponsibleJoin  implements java.io.Serializable {


     private VcleVehicleResponsibleJoinId id;
     private VcleWorkshopeResponse vcleWorkshopeResponse;
     private VcleVehicleType vcleVehicleType;
     private VcleVehicleMaster vcleVehicleMaster;
     private String boardAlfa1;
     private Integer boardDigital;
     private String boardAlfa2;
     private String boardNumber;
     private Integer boardNumberOld;
     private String boardAlfa3;

    public VcleVehicleResponsibleJoin() {
    }

	
    public VcleVehicleResponsibleJoin(VcleVehicleResponsibleJoinId id, VcleWorkshopeResponse vcleWorkshopeResponse, VcleVehicleMaster vcleVehicleMaster) {
        this.id = id;
        this.vcleWorkshopeResponse = vcleWorkshopeResponse;
        this.vcleVehicleMaster = vcleVehicleMaster;
    }
    public VcleVehicleResponsibleJoin(VcleVehicleResponsibleJoinId id, VcleWorkshopeResponse vcleWorkshopeResponse, VcleVehicleType vcleVehicleType, VcleVehicleMaster vcleVehicleMaster, String boardAlfa1, Integer boardDigital, String boardAlfa2, String boardNumber, Integer boardNumberOld, String boardAlfa3) {
       this.id = id;
       this.vcleWorkshopeResponse = vcleWorkshopeResponse;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.boardAlfa1 = boardAlfa1;
       this.boardDigital = boardDigital;
       this.boardAlfa2 = boardAlfa2;
       this.boardNumber = boardNumber;
       this.boardNumberOld = boardNumberOld;
       this.boardAlfa3 = boardAlfa3;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="vehicleSp", column=@Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="workshopeCode", column=@Column(name="WORKSHOPE_CODE", nullable=false, precision=2, scale=0) ) } )
    public VcleVehicleResponsibleJoinId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleResponsibleJoinId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="WORKSHOPE_CODE", referencedColumnName="WORKSHOPE_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="EMPLOYEE_ID", referencedColumnName="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false) } )
    public VcleWorkshopeResponse getVcleWorkshopeResponse() {
        return this.vcleWorkshopeResponse;
    }
    
    public void setVcleWorkshopeResponse(VcleWorkshopeResponse vcleWorkshopeResponse) {
        this.vcleWorkshopeResponse = vcleWorkshopeResponse;
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

    
    @Column(name="BOARD_ALFA1", length=1)
    public String getBoardAlfa1() {
        return this.boardAlfa1;
    }
    
    public void setBoardAlfa1(String boardAlfa1) {
        this.boardAlfa1 = boardAlfa1;
    }

    
    @Column(name="BOARD_DIGITAL", precision=6, scale=0)
    public Integer getBoardDigital() {
        return this.boardDigital;
    }
    
    public void setBoardDigital(Integer boardDigital) {
        this.boardDigital = boardDigital;
    }

    
    @Column(name="BOARD_ALFA2", length=1)
    public String getBoardAlfa2() {
        return this.boardAlfa2;
    }
    
    public void setBoardAlfa2(String boardAlfa2) {
        this.boardAlfa2 = boardAlfa2;
    }

    
    @Column(name="BOARD_NUMBER", length=12)
    public String getBoardNumber() {
        return this.boardNumber;
    }
    
    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }

    
    @Column(name="BOARD_NUMBER_OLD", precision=8, scale=0)
    public Integer getBoardNumberOld() {
        return this.boardNumberOld;
    }
    
    public void setBoardNumberOld(Integer boardNumberOld) {
        this.boardNumberOld = boardNumberOld;
    }

    
    @Column(name="BOARD_ALFA3", length=1)
    public String getBoardAlfa3() {
        return this.boardAlfa3;
    }
    
    public void setBoardAlfa3(String boardAlfa3) {
        this.boardAlfa3 = boardAlfa3;
    }




}


