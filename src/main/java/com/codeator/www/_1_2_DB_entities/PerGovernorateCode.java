package com.codeator.www._1_2_DB_entities;
// Generated Aug 3, 2021 9:29:05 PM by Hibernate Tools 4.3.1


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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PerGovernorateCode generated by hbm2java
 */
@Entity
@Table(name="PER_GOVERNORATE_CODE"
    ,schema="CODEATOR"
)
public class PerGovernorateCode  implements java.io.Serializable {


     private PerGovernorateCodeId id;
     private PerCountryCode perCountryCode;
     private String AGovName;
     private String EGovName;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set<InvoInvoiceMaster> invoInvoiceMasters = new HashSet<InvoInvoiceMaster>(0);
     private Set<VcleRecordMovement> vcleRecordMovements = new HashSet<VcleRecordMovement>(0);
     private Set<VcleTravelExchange> vcleTravelExchanges = new HashSet<VcleTravelExchange>(0);
     private Set<VcleTrafficCode> vcleTrafficCodes = new HashSet<VcleTrafficCode>(0);
     private Set<PurSuppWork> purSuppWorks = new HashSet<PurSuppWork>(0);
     private Set<VcleVehicleIncome> vcleVehicleIncomes = new HashSet<VcleVehicleIncome>(0);
     private Set<PerCityCode> perCityCodes = new HashSet<PerCityCode>(0);
     private Set<PerLocationCode> perLocationCodes = new HashSet<PerLocationCode>(0);

    public PerGovernorateCode() {
    }

	
    public PerGovernorateCode(PerGovernorateCodeId id, PerCountryCode perCountryCode, String AGovName) {
        this.id = id;
        this.perCountryCode = perCountryCode;
        this.AGovName = AGovName;
    }
    public PerGovernorateCode(PerGovernorateCodeId id, PerCountryCode perCountryCode, String AGovName, String EGovName, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set<InvoInvoiceMaster> invoInvoiceMasters, Set<VcleRecordMovement> vcleRecordMovements, Set<VcleTravelExchange> vcleTravelExchanges, Set<VcleTrafficCode> vcleTrafficCodes, Set<PurSuppWork> purSuppWorks, Set<VcleVehicleIncome> vcleVehicleIncomes, Set<PerCityCode> perCityCodes, Set<PerLocationCode> perLocationCodes) {
       this.id = id;
       this.perCountryCode = perCountryCode;
       this.AGovName = AGovName;
       this.EGovName = EGovName;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.invoInvoiceMasters = invoInvoiceMasters;
       this.vcleRecordMovements = vcleRecordMovements;
       this.vcleTravelExchanges = vcleTravelExchanges;
       this.vcleTrafficCodes = vcleTrafficCodes;
       this.purSuppWorks = purSuppWorks;
       this.vcleVehicleIncomes = vcleVehicleIncomes;
       this.perCityCodes = perCityCodes;
       this.perLocationCodes = perLocationCodes;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="countryCode", column=@Column(name="COUNTRY_CODE", nullable=false, length=5) ), 
        @AttributeOverride(name="govCode", column=@Column(name="GOV_CODE", nullable=false, length=5) ) } )
    public PerGovernorateCodeId getId() {
        return this.id;
    }
    
    public void setId(PerGovernorateCodeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COUNTRY_CODE", nullable=false, insertable=false, updatable=false)
    public PerCountryCode getPerCountryCode() {
        return this.perCountryCode;
    }
    
    public void setPerCountryCode(PerCountryCode perCountryCode) {
        this.perCountryCode = perCountryCode;
    }

    
    @Column(name="A_GOV_NAME", nullable=false, length=50)
    public String getAGovName() {
        return this.AGovName;
    }
    
    public void setAGovName(String AGovName) {
        this.AGovName = AGovName;
    }

    
    @Column(name="E_GOV_NAME", length=50)
    public String getEGovName() {
        return this.EGovName;
    }
    
    public void setEGovName(String EGovName) {
        this.EGovName = EGovName;
    }

    
    @Column(name="RECORD_CREATE_USER", length=15)
    public String getRecordCreateUser() {
        return this.recordCreateUser;
    }
    
    public void setRecordCreateUser(String recordCreateUser) {
        this.recordCreateUser = recordCreateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_CREATE_DATE", length=7)
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }

    
    @Column(name="RECORD_UPDATE_USER", length=15)
    public String getRecordUpdateUser() {
        return this.recordUpdateUser;
    }
    
    public void setRecordUpdateUser(String recordUpdateUser) {
        this.recordUpdateUser = recordUpdateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_UPDATE_DATE", length=7)
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGovernorateCode")
    public Set<InvoInvoiceMaster> getInvoInvoiceMasters() {
        return this.invoInvoiceMasters;
    }
    
    public void setInvoInvoiceMasters(Set<InvoInvoiceMaster> invoInvoiceMasters) {
        this.invoInvoiceMasters = invoInvoiceMasters;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGovernorateCode")
    public Set<VcleRecordMovement> getVcleRecordMovements() {
        return this.vcleRecordMovements;
    }
    
    public void setVcleRecordMovements(Set<VcleRecordMovement> vcleRecordMovements) {
        this.vcleRecordMovements = vcleRecordMovements;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGovernorateCode")
    public Set<VcleTravelExchange> getVcleTravelExchanges() {
        return this.vcleTravelExchanges;
    }
    
    public void setVcleTravelExchanges(Set<VcleTravelExchange> vcleTravelExchanges) {
        this.vcleTravelExchanges = vcleTravelExchanges;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGovernorateCode")
    public Set<VcleTrafficCode> getVcleTrafficCodes() {
        return this.vcleTrafficCodes;
    }
    
    public void setVcleTrafficCodes(Set<VcleTrafficCode> vcleTrafficCodes) {
        this.vcleTrafficCodes = vcleTrafficCodes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGovernorateCode")
    public Set<PurSuppWork> getPurSuppWorks() {
        return this.purSuppWorks;
    }
    
    public void setPurSuppWorks(Set<PurSuppWork> purSuppWorks) {
        this.purSuppWorks = purSuppWorks;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGovernorateCode")
    public Set<VcleVehicleIncome> getVcleVehicleIncomes() {
        return this.vcleVehicleIncomes;
    }
    
    public void setVcleVehicleIncomes(Set<VcleVehicleIncome> vcleVehicleIncomes) {
        this.vcleVehicleIncomes = vcleVehicleIncomes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGovernorateCode")
    public Set<PerCityCode> getPerCityCodes() {
        return this.perCityCodes;
    }
    
    public void setPerCityCodes(Set<PerCityCode> perCityCodes) {
        this.perCityCodes = perCityCodes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perGovernorateCode")
    public Set<PerLocationCode> getPerLocationCodes() {
        return this.perLocationCodes;
    }
    
    public void setPerLocationCodes(Set<PerLocationCode> perLocationCodes) {
        this.perLocationCodes = perLocationCodes;
    }




}


