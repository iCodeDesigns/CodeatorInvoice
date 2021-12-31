package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * AppSubTabSpecAuth generated by hbm2java
 */
public class AppSubTabSpecAuth  implements java.io.Serializable {


     private AppSubTabSpecAuthId id;
     private PerEmploymentMaster perEmploymentMasterByEmployeeId;
     private PerEmploymentMaster perEmploymentMasterByEmployeeIdAction;
     private AppSubTab appSubTab;
     private Date actionDate;
     private String actionDateDetails;
     private byte primaryAuthPass;

    public AppSubTabSpecAuth() {
    }

	
    public AppSubTabSpecAuth(AppSubTabSpecAuthId id, PerEmploymentMaster perEmploymentMasterByEmployeeId, AppSubTab appSubTab, byte primaryAuthPass) {
        this.id = id;
        this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
        this.appSubTab = appSubTab;
        this.primaryAuthPass = primaryAuthPass;
    }
    public AppSubTabSpecAuth(AppSubTabSpecAuthId id, PerEmploymentMaster perEmploymentMasterByEmployeeId, PerEmploymentMaster perEmploymentMasterByEmployeeIdAction, AppSubTab appSubTab, Date actionDate, String actionDateDetails, byte primaryAuthPass) {
       this.id = id;
       this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
       this.perEmploymentMasterByEmployeeIdAction = perEmploymentMasterByEmployeeIdAction;
       this.appSubTab = appSubTab;
       this.actionDate = actionDate;
       this.actionDateDetails = actionDateDetails;
       this.primaryAuthPass = primaryAuthPass;
    }
   
    public AppSubTabSpecAuthId getId() {
        return this.id;
    }
    
    public void setId(AppSubTabSpecAuthId id) {
        this.id = id;
    }
    public PerEmploymentMaster getPerEmploymentMasterByEmployeeId() {
        return this.perEmploymentMasterByEmployeeId;
    }
    
    public void setPerEmploymentMasterByEmployeeId(PerEmploymentMaster perEmploymentMasterByEmployeeId) {
        this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
    }
    public PerEmploymentMaster getPerEmploymentMasterByEmployeeIdAction() {
        return this.perEmploymentMasterByEmployeeIdAction;
    }
    
    public void setPerEmploymentMasterByEmployeeIdAction(PerEmploymentMaster perEmploymentMasterByEmployeeIdAction) {
        this.perEmploymentMasterByEmployeeIdAction = perEmploymentMasterByEmployeeIdAction;
    }
    public AppSubTab getAppSubTab() {
        return this.appSubTab;
    }
    
    public void setAppSubTab(AppSubTab appSubTab) {
        this.appSubTab = appSubTab;
    }
    public Date getActionDate() {
        return this.actionDate;
    }
    
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
    public String getActionDateDetails() {
        return this.actionDateDetails;
    }
    
    public void setActionDateDetails(String actionDateDetails) {
        this.actionDateDetails = actionDateDetails;
    }
    public byte getPrimaryAuthPass() {
        return this.primaryAuthPass;
    }
    
    public void setPrimaryAuthPass(byte primaryAuthPass) {
        this.primaryAuthPass = primaryAuthPass;
    }




}


