package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * StoResponsibilityHistoryDtl generated by hbm2java
 */
public class StoResponsibilityHistoryDtl  implements java.io.Serializable {


     private StoResponsibilityHistoryDtlId id;
     private StoResponsibilityHistoryEmp stoResponsibilityHistoryEmp;
     private String itemRespDesc;
     private Long itemDigital;
     private String serialNoInc;
     private Boolean respTypeActDtl;
     private String rmrk;

    public StoResponsibilityHistoryDtl() {
    }

	
    public StoResponsibilityHistoryDtl(StoResponsibilityHistoryDtlId id, StoResponsibilityHistoryEmp stoResponsibilityHistoryEmp) {
        this.id = id;
        this.stoResponsibilityHistoryEmp = stoResponsibilityHistoryEmp;
    }
    public StoResponsibilityHistoryDtl(StoResponsibilityHistoryDtlId id, StoResponsibilityHistoryEmp stoResponsibilityHistoryEmp, String itemRespDesc, Long itemDigital, String serialNoInc, Boolean respTypeActDtl, String rmrk) {
       this.id = id;
       this.stoResponsibilityHistoryEmp = stoResponsibilityHistoryEmp;
       this.itemRespDesc = itemRespDesc;
       this.itemDigital = itemDigital;
       this.serialNoInc = serialNoInc;
       this.respTypeActDtl = respTypeActDtl;
       this.rmrk = rmrk;
    }
   
    public StoResponsibilityHistoryDtlId getId() {
        return this.id;
    }
    
    public void setId(StoResponsibilityHistoryDtlId id) {
        this.id = id;
    }
    public StoResponsibilityHistoryEmp getStoResponsibilityHistoryEmp() {
        return this.stoResponsibilityHistoryEmp;
    }
    
    public void setStoResponsibilityHistoryEmp(StoResponsibilityHistoryEmp stoResponsibilityHistoryEmp) {
        this.stoResponsibilityHistoryEmp = stoResponsibilityHistoryEmp;
    }
    public String getItemRespDesc() {
        return this.itemRespDesc;
    }
    
    public void setItemRespDesc(String itemRespDesc) {
        this.itemRespDesc = itemRespDesc;
    }
    public Long getItemDigital() {
        return this.itemDigital;
    }
    
    public void setItemDigital(Long itemDigital) {
        this.itemDigital = itemDigital;
    }
    public String getSerialNoInc() {
        return this.serialNoInc;
    }
    
    public void setSerialNoInc(String serialNoInc) {
        this.serialNoInc = serialNoInc;
    }
    public Boolean getRespTypeActDtl() {
        return this.respTypeActDtl;
    }
    
    public void setRespTypeActDtl(Boolean respTypeActDtl) {
        this.respTypeActDtl = respTypeActDtl;
    }
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }




}

