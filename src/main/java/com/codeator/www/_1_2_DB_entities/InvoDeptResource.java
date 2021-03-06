package com.codeator.www._1_2_DB_entities;
// Generated Sep 11, 2021 5:44:32 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * InvoDeptResource generated by hbm2java
 */
@Entity
@Table(name="INVO_DEPT_RESOURCE"
    ,schema="CODEATOR"
)
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
   
     @Id 

    
    @Column(name="RESOURCE_SP", unique=true, nullable=false, precision=16, scale=0)
    public long getResourceSp() {
        return this.resourceSp;
    }
    
    public void setResourceSp(long resourceSp) {
        this.resourceSp = resourceSp;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="SECTION_NO_OLD", referencedColumnName="SECTION_NO_OLD", nullable=false), 
        @JoinColumn(name="DEP_NO_OLD", referencedColumnName="DEP_NO_OLD", nullable=false) } )
    public PerDeptOld getPerDeptOld() {
        return this.perDeptOld;
    }
    
    public void setPerDeptOld(PerDeptOld perDeptOld) {
        this.perDeptOld = perDeptOld;
    }

    
    @Column(name="RESOURCE_CODE", length=20)
    public String getResourceCode() {
        return this.resourceCode;
    }
    
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    
    @Column(name="RESOURCE_NAME", length=100)
    public String getResourceName() {
        return this.resourceName;
    }
    
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }




}


