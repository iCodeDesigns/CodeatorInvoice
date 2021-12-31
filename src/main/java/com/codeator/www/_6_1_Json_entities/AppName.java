package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * AppName generated by hbm2java
 */
public class AppName  implements java.io.Serializable {


     private short applicationId;
     private String applicationName;
     private Short applicationIndex;
     private Set appTabses = new HashSet(0);

    public AppName() {
    }

	
    public AppName(short applicationId, String applicationName) {
        this.applicationId = applicationId;
        this.applicationName = applicationName;
    }
    public AppName(short applicationId, String applicationName, Short applicationIndex, Set appTabses) {
       this.applicationId = applicationId;
       this.applicationName = applicationName;
       this.applicationIndex = applicationIndex;
       this.appTabses = appTabses;
    }
   
    public short getApplicationId() {
        return this.applicationId;
    }
    
    public void setApplicationId(short applicationId) {
        this.applicationId = applicationId;
    }
    public String getApplicationName() {
        return this.applicationName;
    }
    
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
    public Short getApplicationIndex() {
        return this.applicationIndex;
    }
    
    public void setApplicationIndex(Short applicationIndex) {
        this.applicationIndex = applicationIndex;
    }
    public Set getAppTabses() {
        return this.appTabses;
    }
    
    public void setAppTabses(Set appTabses) {
        this.appTabses = appTabses;
    }




}

