package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * InvoDeptResource generated by hbm2java
 */
public class InvoDeptResource  implements java.io.Serializable {


     private long resourceSp;
     private PerDeptOld perDeptOld;
     private String resourceCode;
     private String resourceName;

    public InvoDeptResource() {
    }

	
    public InvoDeptResource(long resourceSp, PerDeptOld perDeptOld) {
        this.resourceSp = resourceSp;
        this.perDeptOld = perDeptOld;
    }
    public InvoDeptResource(long resourceSp, PerDeptOld perDeptOld, String resourceCode, String resourceName) {
       this.resourceSp = resourceSp;
       this.perDeptOld = perDeptOld;
       this.resourceCode = resourceCode;
       this.resourceName = resourceName;
    }
   
    public long getResourceSp() {
        return this.resourceSp;
    }
    
    public void setResourceSp(long resourceSp) {
        this.resourceSp = resourceSp;
    }
    public PerDeptOld getPerDeptOld() {
        return this.perDeptOld;
    }
    
    public void setPerDeptOld(PerDeptOld perDeptOld) {
        this.perDeptOld = perDeptOld;
    }
    public String getResourceCode() {
        return this.resourceCode;
    }
    
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }
    public String getResourceName() {
        return this.resourceName;
    }
    
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }




}


