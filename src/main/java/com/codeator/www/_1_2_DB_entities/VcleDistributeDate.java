package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleDistributeDate generated by hbm2java
 */
@Entity
@Table(name="VCLE_DISTRIBUTE_DATE"
    ,schema="CODEATOR"
)
public class VcleDistributeDate  implements java.io.Serializable {


     private VcleDistributeDateId id;
     private VcleDistributeDateOpen vcleDistributeDateOpen;
     private String rmrkDay;
     private Date travelDate;
     private Set<VcleDistributeDateAhramPm> vcleDistributeDateAhramPms = new HashSet<VcleDistributeDateAhramPm>(0);
     private Set<VcleDistributeDateAhramAm> vcleDistributeDateAhramAms = new HashSet<VcleDistributeDateAhramAm>(0);

    public VcleDistributeDate() {
    }

	
    public VcleDistributeDate(VcleDistributeDateId id, VcleDistributeDateOpen vcleDistributeDateOpen) {
        this.id = id;
        this.vcleDistributeDateOpen = vcleDistributeDateOpen;
    }
    public VcleDistributeDate(VcleDistributeDateId id, VcleDistributeDateOpen vcleDistributeDateOpen, String rmrkDay, Date travelDate, Set<VcleDistributeDateAhramPm> vcleDistributeDateAhramPms, Set<VcleDistributeDateAhramAm> vcleDistributeDateAhramAms) {
       this.id = id;
       this.vcleDistributeDateOpen = vcleDistributeDateOpen;
       this.rmrkDay = rmrkDay;
       this.travelDate = travelDate;
       this.vcleDistributeDateAhramPms = vcleDistributeDateAhramPms;
       this.vcleDistributeDateAhramAms = vcleDistributeDateAhramAms;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="travelDd", column=@Column(name="TRAVEL_DD", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="travelMm", column=@Column(name="TRAVEL_MM", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="fiscalYear", column=@Column(name="FISCAL_YEAR", nullable=false, precision=4, scale=0) ) } )
    public VcleDistributeDateId getId() {
        return this.id;
    }
    
    public void setId(VcleDistributeDateId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="FISCAL_YEAR", referencedColumnName="FISCAL_YEAR", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="TRAVEL_MM", referencedColumnName="TRAVEL_MM", nullable=false, insertable=false, updatable=false) } )
    public VcleDistributeDateOpen getVcleDistributeDateOpen() {
        return this.vcleDistributeDateOpen;
    }
    
    public void setVcleDistributeDateOpen(VcleDistributeDateOpen vcleDistributeDateOpen) {
        this.vcleDistributeDateOpen = vcleDistributeDateOpen;
    }

    
    @Column(name="RMRK_DAY", length=100)
    public String getRmrkDay() {
        return this.rmrkDay;
    }
    
    public void setRmrkDay(String rmrkDay) {
        this.rmrkDay = rmrkDay;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="TRAVEL_DATE", length=7)
    public Date getTravelDate() {
        return this.travelDate;
    }
    
    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleDistributeDate")
    public Set<VcleDistributeDateAhramPm> getVcleDistributeDateAhramPms() {
        return this.vcleDistributeDateAhramPms;
    }
    
    public void setVcleDistributeDateAhramPms(Set<VcleDistributeDateAhramPm> vcleDistributeDateAhramPms) {
        this.vcleDistributeDateAhramPms = vcleDistributeDateAhramPms;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleDistributeDate")
    public Set<VcleDistributeDateAhramAm> getVcleDistributeDateAhramAms() {
        return this.vcleDistributeDateAhramAms;
    }
    
    public void setVcleDistributeDateAhramAms(Set<VcleDistributeDateAhramAm> vcleDistributeDateAhramAms) {
        this.vcleDistributeDateAhramAms = vcleDistributeDateAhramAms;
    }




}


