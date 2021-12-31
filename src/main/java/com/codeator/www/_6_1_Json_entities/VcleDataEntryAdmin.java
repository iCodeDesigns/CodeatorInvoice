package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * VcleDataEntryAdmin generated by hbm2java
 */
public class VcleDataEntryAdmin  implements java.io.Serializable {


     private VcleDataEntryAdminId id;
     private BigDecimal userId;
     private String appAdminName;

    public VcleDataEntryAdmin() {
    }

	
    public VcleDataEntryAdmin(VcleDataEntryAdminId id) {
        this.id = id;
    }
    public VcleDataEntryAdmin(VcleDataEntryAdminId id, BigDecimal userId, String appAdminName) {
       this.id = id;
       this.userId = userId;
       this.appAdminName = appAdminName;
    }
   
    public VcleDataEntryAdminId getId() {
        return this.id;
    }
    
    public void setId(VcleDataEntryAdminId id) {
        this.id = id;
    }
    public BigDecimal getUserId() {
        return this.userId;
    }
    
    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }
    public String getAppAdminName() {
        return this.appAdminName;
    }
    
    public void setAppAdminName(String appAdminName) {
        this.appAdminName = appAdminName;
    }




}


