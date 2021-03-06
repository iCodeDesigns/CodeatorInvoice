package com.codeator.www._1_2_DB_entities;
// Generated Jul 27, 2021 2:00:58 PM by Hibernate Tools 4.3.1


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
 * AppSubElemSpecAuth generated by hbm2java
 */
@Entity
@Table(name="APP_SUB_ELEM_SPEC_AUTH"
    ,schema="CODEATOR"
)
public class AppSubElemSpecAuth  implements java.io.Serializable {


     private AppSubElemSpecAuthId id;
     private PerEmploymentMaster perEmploymentMasterByEmployeeId;
     private PerEmploymentMaster perEmploymentMasterByEmployeeIdAction;
     private AppSubElem appSubElem;
     private Date actionDate;
     private String actionDateDetails;
     private Byte primaryAuthPass;

    public AppSubElemSpecAuth() {
    }

	
    public AppSubElemSpecAuth(AppSubElemSpecAuthId id, PerEmploymentMaster perEmploymentMasterByEmployeeId, AppSubElem appSubElem) {
        this.id = id;
        this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
        this.appSubElem = appSubElem;
    }
    public AppSubElemSpecAuth(AppSubElemSpecAuthId id, PerEmploymentMaster perEmploymentMasterByEmployeeId, PerEmploymentMaster perEmploymentMasterByEmployeeIdAction, AppSubElem appSubElem, Date actionDate, String actionDateDetails, Byte primaryAuthPass) {
       this.id = id;
       this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
       this.perEmploymentMasterByEmployeeIdAction = perEmploymentMasterByEmployeeIdAction;
       this.appSubElem = appSubElem;
       this.actionDate = actionDate;
       this.actionDateDetails = actionDateDetails;
       this.primaryAuthPass = primaryAuthPass;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="applicationId", column=@Column(name="APPLICATION_ID", nullable=false, precision=3, scale=0) ), 
        @AttributeOverride(name="tabId", column=@Column(name="TAB_ID", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="subTabId", column=@Column(name="SUB_TAB_ID", nullable=false, precision=8, scale=0) ), 
        @AttributeOverride(name="elementId", column=@Column(name="ELEMENT_ID", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0) ) } )
    public AppSubElemSpecAuthId getId() {
        return this.id;
    }
    
    public void setId(AppSubElemSpecAuthId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public PerEmploymentMaster getPerEmploymentMasterByEmployeeId() {
        return this.perEmploymentMasterByEmployeeId;
    }
    
    public void setPerEmploymentMasterByEmployeeId(PerEmploymentMaster perEmploymentMasterByEmployeeId) {
        this.perEmploymentMasterByEmployeeId = perEmploymentMasterByEmployeeId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID_ACTION")
    public PerEmploymentMaster getPerEmploymentMasterByEmployeeIdAction() {
        return this.perEmploymentMasterByEmployeeIdAction;
    }
    
    public void setPerEmploymentMasterByEmployeeIdAction(PerEmploymentMaster perEmploymentMasterByEmployeeIdAction) {
        this.perEmploymentMasterByEmployeeIdAction = perEmploymentMasterByEmployeeIdAction;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="APPLICATION_ID", referencedColumnName="APPLICATION_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="TAB_ID", referencedColumnName="TAB_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="SUB_TAB_ID", referencedColumnName="SUB_TAB_ID", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ELEMENT_ID", referencedColumnName="ELEMENT_ID", nullable=false, insertable=false, updatable=false) } )
    public AppSubElem getAppSubElem() {
        return this.appSubElem;
    }
    
    public void setAppSubElem(AppSubElem appSubElem) {
        this.appSubElem = appSubElem;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ACTION_DATE", length=7)
    public Date getActionDate() {
        return this.actionDate;
    }
    
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    
    @Column(name="ACTION_DATE_DETAILS", length=25)
    public String getActionDateDetails() {
        return this.actionDateDetails;
    }
    
    public void setActionDateDetails(String actionDateDetails) {
        this.actionDateDetails = actionDateDetails;
    }

    
    @Column(name="PRIMARY_AUTH_PASS", precision=2, scale=0)
    public Byte getPrimaryAuthPass() {
        return this.primaryAuthPass;
    }
    
    public void setPrimaryAuthPass(Byte primaryAuthPass) {
        this.primaryAuthPass = primaryAuthPass;
    }




}


