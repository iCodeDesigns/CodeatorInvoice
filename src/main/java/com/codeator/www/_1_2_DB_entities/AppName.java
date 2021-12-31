package com.codeator.www._1_2_DB_entities;
// Generated Jul 27, 2021 2:00:58 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AppName generated by hbm2java
 */
@Entity
@Table(name="APP_NAME"
    ,schema="CODEATOR"
)
public class AppName  implements java.io.Serializable {


     private short applicationId;
     private String applicationName;
     private Short applicationIndex;
     private Set<AppTabs> appTabses = new HashSet<AppTabs>(0);

    public AppName() {
    }

	
    public AppName(short applicationId, String applicationName) {
        this.applicationId = applicationId;
        this.applicationName = applicationName;
    }
    public AppName(short applicationId, String applicationName, Short applicationIndex, Set<AppTabs> appTabses) {
       this.applicationId = applicationId;
       this.applicationName = applicationName;
       this.applicationIndex = applicationIndex;
       this.appTabses = appTabses;
    }
   
     @Id 

    
    @Column(name="APPLICATION_ID", unique=true, nullable=false, precision=3, scale=0)
    public short getApplicationId() {
        return this.applicationId;
    }
    
    public void setApplicationId(short applicationId) {
        this.applicationId = applicationId;
    }

    
    @Column(name="APPLICATION_NAME", nullable=false, length=50)
    public String getApplicationName() {
        return this.applicationName;
    }
    
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    
    @Column(name="APPLICATION_INDEX", precision=3, scale=0)
    public Short getApplicationIndex() {
        return this.applicationIndex;
    }
    
    public void setApplicationIndex(Short applicationIndex) {
        this.applicationIndex = applicationIndex;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="appName")
    public Set<AppTabs> getAppTabses() {
        return this.appTabses;
    }
    
    public void setAppTabses(Set<AppTabs> appTabses) {
        this.appTabses = appTabses;
    }




}


