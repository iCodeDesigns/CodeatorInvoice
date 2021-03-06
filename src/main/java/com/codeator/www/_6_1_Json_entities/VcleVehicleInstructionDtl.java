package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * VcleVehicleInstructionDtl generated by hbm2java
 */
public class VcleVehicleInstructionDtl  implements java.io.Serializable {


     private VcleVehicleInstructionDtlId id;
     private VcleSuspendType vcleSuspendType;
     private VcleVehicleInstruction vcleVehicleInstruction;
     private String rmrk;
     private String boardAlfa1;
     private Boolean repairSide;
     private String boardAlfa2;
     private String boardAlfa3;
     private Short suspendSeq;
     private Integer boardNumberOld;
     private Integer boardDigital;
     private Set vcleVehicleInstructionItems = new HashSet(0);

    public VcleVehicleInstructionDtl() {
    }

	
    public VcleVehicleInstructionDtl(VcleVehicleInstructionDtlId id, VcleVehicleInstruction vcleVehicleInstruction) {
        this.id = id;
        this.vcleVehicleInstruction = vcleVehicleInstruction;
    }
    public VcleVehicleInstructionDtl(VcleVehicleInstructionDtlId id, VcleSuspendType vcleSuspendType, VcleVehicleInstruction vcleVehicleInstruction, String rmrk, String boardAlfa1, Boolean repairSide, String boardAlfa2, String boardAlfa3, Short suspendSeq, Integer boardNumberOld, Integer boardDigital, Set vcleVehicleInstructionItems) {
       this.id = id;
       this.vcleSuspendType = vcleSuspendType;
       this.vcleVehicleInstruction = vcleVehicleInstruction;
       this.rmrk = rmrk;
       this.boardAlfa1 = boardAlfa1;
       this.repairSide = repairSide;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa3 = boardAlfa3;
       this.suspendSeq = suspendSeq;
       this.boardNumberOld = boardNumberOld;
       this.boardDigital = boardDigital;
       this.vcleVehicleInstructionItems = vcleVehicleInstructionItems;
    }
   
    public VcleVehicleInstructionDtlId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleInstructionDtlId id) {
        this.id = id;
    }
    public VcleSuspendType getVcleSuspendType() {
        return this.vcleSuspendType;
    }
    
    public void setVcleSuspendType(VcleSuspendType vcleSuspendType) {
        this.vcleSuspendType = vcleSuspendType;
    }
    public VcleVehicleInstruction getVcleVehicleInstruction() {
        return this.vcleVehicleInstruction;
    }
    
    public void setVcleVehicleInstruction(VcleVehicleInstruction vcleVehicleInstruction) {
        this.vcleVehicleInstruction = vcleVehicleInstruction;
    }
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }
    public String getBoardAlfa1() {
        return this.boardAlfa1;
    }
    
    public void setBoardAlfa1(String boardAlfa1) {
        this.boardAlfa1 = boardAlfa1;
    }
    public Boolean getRepairSide() {
        return this.repairSide;
    }
    
    public void setRepairSide(Boolean repairSide) {
        this.repairSide = repairSide;
    }
    public String getBoardAlfa2() {
        return this.boardAlfa2;
    }
    
    public void setBoardAlfa2(String boardAlfa2) {
        this.boardAlfa2 = boardAlfa2;
    }
    public String getBoardAlfa3() {
        return this.boardAlfa3;
    }
    
    public void setBoardAlfa3(String boardAlfa3) {
        this.boardAlfa3 = boardAlfa3;
    }
    public Short getSuspendSeq() {
        return this.suspendSeq;
    }
    
    public void setSuspendSeq(Short suspendSeq) {
        this.suspendSeq = suspendSeq;
    }
    public Integer getBoardNumberOld() {
        return this.boardNumberOld;
    }
    
    public void setBoardNumberOld(Integer boardNumberOld) {
        this.boardNumberOld = boardNumberOld;
    }
    public Integer getBoardDigital() {
        return this.boardDigital;
    }
    
    public void setBoardDigital(Integer boardDigital) {
        this.boardDigital = boardDigital;
    }
    public Set getVcleVehicleInstructionItems() {
        return this.vcleVehicleInstructionItems;
    }
    
    public void setVcleVehicleInstructionItems(Set vcleVehicleInstructionItems) {
        this.vcleVehicleInstructionItems = vcleVehicleInstructionItems;
    }




}


