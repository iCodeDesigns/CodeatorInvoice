package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * VcleVehicleInstruction generated by hbm2java
 */
public class VcleVehicleInstruction  implements java.io.Serializable {


     private VcleVehicleInstructionId id;
     private VcleVehicleMaster vcleVehicleMaster;
     private VcleWorkshopeResponse vcleWorkshopeResponse;
     private String insReason;
     private Date insEndDate;
     private Integer notifySp;
     private String boardAlfa1;
     private Byte localSp;
     private Boolean instructionType;
     private Byte insSeq;
     private Integer boardNumberOld;
     private String boardAlfa3;
     private Date instructionDate;
     private Integer boardDigital;
     private String boardAlfa2;
     private Date notifyDate;
     private String curTime;
     private Set vcleVehicleInstructionDtls = new HashSet(0);
     private Set vcleVehicleInstructionTeches = new HashSet(0);

    public VcleVehicleInstruction() {
    }

	
    public VcleVehicleInstruction(VcleVehicleInstructionId id, VcleVehicleMaster vcleVehicleMaster, VcleWorkshopeResponse vcleWorkshopeResponse, Date instructionDate) {
        this.id = id;
        this.vcleVehicleMaster = vcleVehicleMaster;
        this.vcleWorkshopeResponse = vcleWorkshopeResponse;
        this.instructionDate = instructionDate;
    }
    public VcleVehicleInstruction(VcleVehicleInstructionId id, VcleVehicleMaster vcleVehicleMaster, VcleWorkshopeResponse vcleWorkshopeResponse, String insReason, Date insEndDate, Integer notifySp, String boardAlfa1, Byte localSp, Boolean instructionType, Byte insSeq, Integer boardNumberOld, String boardAlfa3, Date instructionDate, Integer boardDigital, String boardAlfa2, Date notifyDate, String curTime, Set vcleVehicleInstructionDtls, Set vcleVehicleInstructionTeches) {
       this.id = id;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.vcleWorkshopeResponse = vcleWorkshopeResponse;
       this.insReason = insReason;
       this.insEndDate = insEndDate;
       this.notifySp = notifySp;
       this.boardAlfa1 = boardAlfa1;
       this.localSp = localSp;
       this.instructionType = instructionType;
       this.insSeq = insSeq;
       this.boardNumberOld = boardNumberOld;
       this.boardAlfa3 = boardAlfa3;
       this.instructionDate = instructionDate;
       this.boardDigital = boardDigital;
       this.boardAlfa2 = boardAlfa2;
       this.notifyDate = notifyDate;
       this.curTime = curTime;
       this.vcleVehicleInstructionDtls = vcleVehicleInstructionDtls;
       this.vcleVehicleInstructionTeches = vcleVehicleInstructionTeches;
    }
   
    public VcleVehicleInstructionId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleInstructionId id) {
        this.id = id;
    }
    public VcleVehicleMaster getVcleVehicleMaster() {
        return this.vcleVehicleMaster;
    }
    
    public void setVcleVehicleMaster(VcleVehicleMaster vcleVehicleMaster) {
        this.vcleVehicleMaster = vcleVehicleMaster;
    }
    public VcleWorkshopeResponse getVcleWorkshopeResponse() {
        return this.vcleWorkshopeResponse;
    }
    
    public void setVcleWorkshopeResponse(VcleWorkshopeResponse vcleWorkshopeResponse) {
        this.vcleWorkshopeResponse = vcleWorkshopeResponse;
    }
    public String getInsReason() {
        return this.insReason;
    }
    
    public void setInsReason(String insReason) {
        this.insReason = insReason;
    }
    public Date getInsEndDate() {
        return this.insEndDate;
    }
    
    public void setInsEndDate(Date insEndDate) {
        this.insEndDate = insEndDate;
    }
    public Integer getNotifySp() {
        return this.notifySp;
    }
    
    public void setNotifySp(Integer notifySp) {
        this.notifySp = notifySp;
    }
    public String getBoardAlfa1() {
        return this.boardAlfa1;
    }
    
    public void setBoardAlfa1(String boardAlfa1) {
        this.boardAlfa1 = boardAlfa1;
    }
    public Byte getLocalSp() {
        return this.localSp;
    }
    
    public void setLocalSp(Byte localSp) {
        this.localSp = localSp;
    }
    public Boolean getInstructionType() {
        return this.instructionType;
    }
    
    public void setInstructionType(Boolean instructionType) {
        this.instructionType = instructionType;
    }
    public Byte getInsSeq() {
        return this.insSeq;
    }
    
    public void setInsSeq(Byte insSeq) {
        this.insSeq = insSeq;
    }
    public Integer getBoardNumberOld() {
        return this.boardNumberOld;
    }
    
    public void setBoardNumberOld(Integer boardNumberOld) {
        this.boardNumberOld = boardNumberOld;
    }
    public String getBoardAlfa3() {
        return this.boardAlfa3;
    }
    
    public void setBoardAlfa3(String boardAlfa3) {
        this.boardAlfa3 = boardAlfa3;
    }
    public Date getInstructionDate() {
        return this.instructionDate;
    }
    
    public void setInstructionDate(Date instructionDate) {
        this.instructionDate = instructionDate;
    }
    public Integer getBoardDigital() {
        return this.boardDigital;
    }
    
    public void setBoardDigital(Integer boardDigital) {
        this.boardDigital = boardDigital;
    }
    public String getBoardAlfa2() {
        return this.boardAlfa2;
    }
    
    public void setBoardAlfa2(String boardAlfa2) {
        this.boardAlfa2 = boardAlfa2;
    }
    public Date getNotifyDate() {
        return this.notifyDate;
    }
    
    public void setNotifyDate(Date notifyDate) {
        this.notifyDate = notifyDate;
    }
    public String getCurTime() {
        return this.curTime;
    }
    
    public void setCurTime(String curTime) {
        this.curTime = curTime;
    }
    public Set getVcleVehicleInstructionDtls() {
        return this.vcleVehicleInstructionDtls;
    }
    
    public void setVcleVehicleInstructionDtls(Set vcleVehicleInstructionDtls) {
        this.vcleVehicleInstructionDtls = vcleVehicleInstructionDtls;
    }
    public Set getVcleVehicleInstructionTeches() {
        return this.vcleVehicleInstructionTeches;
    }
    
    public void setVcleVehicleInstructionTeches(Set vcleVehicleInstructionTeches) {
        this.vcleVehicleInstructionTeches = vcleVehicleInstructionTeches;
    }




}


