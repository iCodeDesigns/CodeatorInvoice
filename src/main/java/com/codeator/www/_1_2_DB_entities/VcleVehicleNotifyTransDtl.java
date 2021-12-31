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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleVehicleNotifyTransDtl generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_NOTIFY_TRANS_DTL"
    ,schema="CODEATOR"
)
public class VcleVehicleNotifyTransDtl  implements java.io.Serializable {


     private VcleVehicleNotifyTransDtlId id;
     private VcleWorkshopeCode vcleWorkshopeCode;
     private VcleVehicleNotifyTrans vcleVehicleNotifyTrans;
     private VcleEmployeeMaster vcleEmployeeMaster;
     private Date finishRespDate;
     private String curTime;
     private Date instructionDateIni;
     private String notifyRmrkResp;
     private Boolean chkNotifyOk;
     private Date curSysdate;
     private Boolean chkIns;
     private Integer instructionNoSp;
     private Boolean instructionTypeIni;
     private String notifyRmrk;
     private Boolean chkLockResp;
     private Boolean chkStatus;
     private Integer notifySeq;
     private Date sendDate;
     private String curDateTime;
     private Date notifyDate;
     private String boardAlfa1;
     private String boardAlfa2;
     private String boardAlfa3;
     private Integer boardDigital;
     private Integer boardNumberOld;

    public VcleVehicleNotifyTransDtl() {
    }

	
    public VcleVehicleNotifyTransDtl(VcleVehicleNotifyTransDtlId id, VcleWorkshopeCode vcleWorkshopeCode, VcleVehicleNotifyTrans vcleVehicleNotifyTrans) {
        this.id = id;
        this.vcleWorkshopeCode = vcleWorkshopeCode;
        this.vcleVehicleNotifyTrans = vcleVehicleNotifyTrans;
    }
    public VcleVehicleNotifyTransDtl(VcleVehicleNotifyTransDtlId id, VcleWorkshopeCode vcleWorkshopeCode, VcleVehicleNotifyTrans vcleVehicleNotifyTrans, VcleEmployeeMaster vcleEmployeeMaster, Date finishRespDate, String curTime, Date instructionDateIni, String notifyRmrkResp, Boolean chkNotifyOk, Date curSysdate, Boolean chkIns, Integer instructionNoSp, Boolean instructionTypeIni, String notifyRmrk, Boolean chkLockResp, Boolean chkStatus, Integer notifySeq, Date sendDate, String curDateTime, Date notifyDate, String boardAlfa1, String boardAlfa2, String boardAlfa3, Integer boardDigital, Integer boardNumberOld) {
       this.id = id;
       this.vcleWorkshopeCode = vcleWorkshopeCode;
       this.vcleVehicleNotifyTrans = vcleVehicleNotifyTrans;
       this.vcleEmployeeMaster = vcleEmployeeMaster;
       this.finishRespDate = finishRespDate;
       this.curTime = curTime;
       this.instructionDateIni = instructionDateIni;
       this.notifyRmrkResp = notifyRmrkResp;
       this.chkNotifyOk = chkNotifyOk;
       this.curSysdate = curSysdate;
       this.chkIns = chkIns;
       this.instructionNoSp = instructionNoSp;
       this.instructionTypeIni = instructionTypeIni;
       this.notifyRmrk = notifyRmrk;
       this.chkLockResp = chkLockResp;
       this.chkStatus = chkStatus;
       this.notifySeq = notifySeq;
       this.sendDate = sendDate;
       this.curDateTime = curDateTime;
       this.notifyDate = notifyDate;
       this.boardAlfa1 = boardAlfa1;
       this.boardAlfa2 = boardAlfa2;
       this.boardAlfa3 = boardAlfa3;
       this.boardDigital = boardDigital;
       this.boardNumberOld = boardNumberOld;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="workshopeCode", column=@Column(name="WORKSHOPE_CODE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="vehicleSp", column=@Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="notifySp", column=@Column(name="NOTIFY_SP", nullable=false, precision=9, scale=0) ), 
        @AttributeOverride(name="fiscalDate", column=@Column(name="FISCAL_DATE", nullable=false, length=7) ) } )
    public VcleVehicleNotifyTransDtlId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleNotifyTransDtlId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="WORKSHOPE_CODE", nullable=false, insertable=false, updatable=false)
    public VcleWorkshopeCode getVcleWorkshopeCode() {
        return this.vcleWorkshopeCode;
    }
    
    public void setVcleWorkshopeCode(VcleWorkshopeCode vcleWorkshopeCode) {
        this.vcleWorkshopeCode = vcleWorkshopeCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="FISCAL_DATE", referencedColumnName="FISCAL_DATE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="VEHICLE_SP", referencedColumnName="VEHICLE_SP", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="NOTIFY_SP", referencedColumnName="NOTIFY_SP", nullable=false, insertable=false, updatable=false) } )
    public VcleVehicleNotifyTrans getVcleVehicleNotifyTrans() {
        return this.vcleVehicleNotifyTrans;
    }
    
    public void setVcleVehicleNotifyTrans(VcleVehicleNotifyTrans vcleVehicleNotifyTrans) {
        this.vcleVehicleNotifyTrans = vcleVehicleNotifyTrans;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
    public VcleEmployeeMaster getVcleEmployeeMaster() {
        return this.vcleEmployeeMaster;
    }
    
    public void setVcleEmployeeMaster(VcleEmployeeMaster vcleEmployeeMaster) {
        this.vcleEmployeeMaster = vcleEmployeeMaster;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FINISH_RESP_DATE", length=7)
    public Date getFinishRespDate() {
        return this.finishRespDate;
    }
    
    public void setFinishRespDate(Date finishRespDate) {
        this.finishRespDate = finishRespDate;
    }

    
    @Column(name="CUR_TIME", length=5)
    public String getCurTime() {
        return this.curTime;
    }
    
    public void setCurTime(String curTime) {
        this.curTime = curTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INSTRUCTION_DATE_INI", length=7)
    public Date getInstructionDateIni() {
        return this.instructionDateIni;
    }
    
    public void setInstructionDateIni(Date instructionDateIni) {
        this.instructionDateIni = instructionDateIni;
    }

    
    @Column(name="NOTIFY_RMRK_RESP", length=200)
    public String getNotifyRmrkResp() {
        return this.notifyRmrkResp;
    }
    
    public void setNotifyRmrkResp(String notifyRmrkResp) {
        this.notifyRmrkResp = notifyRmrkResp;
    }

    
    @Column(name="CHK_NOTIFY_OK", precision=1, scale=0)
    public Boolean getChkNotifyOk() {
        return this.chkNotifyOk;
    }
    
    public void setChkNotifyOk(Boolean chkNotifyOk) {
        this.chkNotifyOk = chkNotifyOk;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CUR_SYSDATE", length=7)
    public Date getCurSysdate() {
        return this.curSysdate;
    }
    
    public void setCurSysdate(Date curSysdate) {
        this.curSysdate = curSysdate;
    }

    
    @Column(name="CHK_INS", precision=1, scale=0)
    public Boolean getChkIns() {
        return this.chkIns;
    }
    
    public void setChkIns(Boolean chkIns) {
        this.chkIns = chkIns;
    }

    
    @Column(name="INSTRUCTION_NO_SP", precision=8, scale=0)
    public Integer getInstructionNoSp() {
        return this.instructionNoSp;
    }
    
    public void setInstructionNoSp(Integer instructionNoSp) {
        this.instructionNoSp = instructionNoSp;
    }

    
    @Column(name="INSTRUCTION_TYPE_INI", precision=1, scale=0)
    public Boolean getInstructionTypeIni() {
        return this.instructionTypeIni;
    }
    
    public void setInstructionTypeIni(Boolean instructionTypeIni) {
        this.instructionTypeIni = instructionTypeIni;
    }

    
    @Column(name="NOTIFY_RMRK", length=200)
    public String getNotifyRmrk() {
        return this.notifyRmrk;
    }
    
    public void setNotifyRmrk(String notifyRmrk) {
        this.notifyRmrk = notifyRmrk;
    }

    
    @Column(name="CHK_LOCK_RESP", precision=1, scale=0)
    public Boolean getChkLockResp() {
        return this.chkLockResp;
    }
    
    public void setChkLockResp(Boolean chkLockResp) {
        this.chkLockResp = chkLockResp;
    }

    
    @Column(name="CHK_STATUS", precision=1, scale=0)
    public Boolean getChkStatus() {
        return this.chkStatus;
    }
    
    public void setChkStatus(Boolean chkStatus) {
        this.chkStatus = chkStatus;
    }

    
    @Column(name="NOTIFY_SEQ", precision=6, scale=0)
    public Integer getNotifySeq() {
        return this.notifySeq;
    }
    
    public void setNotifySeq(Integer notifySeq) {
        this.notifySeq = notifySeq;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="SEND_DATE", length=7)
    public Date getSendDate() {
        return this.sendDate;
    }
    
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    
    @Column(name="CUR_DATE_TIME", length=20)
    public String getCurDateTime() {
        return this.curDateTime;
    }
    
    public void setCurDateTime(String curDateTime) {
        this.curDateTime = curDateTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="NOTIFY_DATE", length=7)
    public Date getNotifyDate() {
        return this.notifyDate;
    }
    
    public void setNotifyDate(Date notifyDate) {
        this.notifyDate = notifyDate;
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

    
    @Column(name="BOARD_DIGITAL", precision=6, scale=0)
    public Integer getBoardDigital() {
        return this.boardDigital;
    }
    
    public void setBoardDigital(Integer boardDigital) {
        this.boardDigital = boardDigital;
    }

    
    @Column(name="BOARD_NUMBER_OLD", precision=8, scale=0)
    public Integer getBoardNumberOld() {
        return this.boardNumberOld;
    }
    
    public void setBoardNumberOld(Integer boardNumberOld) {
        this.boardNumberOld = boardNumberOld;
    }




}


