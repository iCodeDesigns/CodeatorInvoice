package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * VcleJobType generated by hbm2java
 */
public class VcleJobType  implements java.io.Serializable {


     private short jobType;
     private String jobName;
     private Short valDay;
     private Short valDayMore;
     private BigDecimal dedRatio;
     private Short valVac;
     private Set vcleWorkOnSaturdayses = new HashSet(0);
     private Set vcleEmployeeMasters = new HashSet(0);
     private Set vcleTravelExchanges = new HashSet(0);
     private Set vcleWorkOnSaturdayEmps = new HashSet(0);

    public VcleJobType() {
    }

	
    public VcleJobType(short jobType, String jobName) {
        this.jobType = jobType;
        this.jobName = jobName;
    }
    public VcleJobType(short jobType, String jobName, Short valDay, Short valDayMore, BigDecimal dedRatio, Short valVac, Set vcleWorkOnSaturdayses, Set vcleEmployeeMasters, Set vcleTravelExchanges, Set vcleWorkOnSaturdayEmps) {
       this.jobType = jobType;
       this.jobName = jobName;
       this.valDay = valDay;
       this.valDayMore = valDayMore;
       this.dedRatio = dedRatio;
       this.valVac = valVac;
       this.vcleWorkOnSaturdayses = vcleWorkOnSaturdayses;
       this.vcleEmployeeMasters = vcleEmployeeMasters;
       this.vcleTravelExchanges = vcleTravelExchanges;
       this.vcleWorkOnSaturdayEmps = vcleWorkOnSaturdayEmps;
    }
   
    public short getJobType() {
        return this.jobType;
    }
    
    public void setJobType(short jobType) {
        this.jobType = jobType;
    }
    public String getJobName() {
        return this.jobName;
    }
    
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public Short getValDay() {
        return this.valDay;
    }
    
    public void setValDay(Short valDay) {
        this.valDay = valDay;
    }
    public Short getValDayMore() {
        return this.valDayMore;
    }
    
    public void setValDayMore(Short valDayMore) {
        this.valDayMore = valDayMore;
    }
    public BigDecimal getDedRatio() {
        return this.dedRatio;
    }
    
    public void setDedRatio(BigDecimal dedRatio) {
        this.dedRatio = dedRatio;
    }
    public Short getValVac() {
        return this.valVac;
    }
    
    public void setValVac(Short valVac) {
        this.valVac = valVac;
    }
    public Set getVcleWorkOnSaturdayses() {
        return this.vcleWorkOnSaturdayses;
    }
    
    public void setVcleWorkOnSaturdayses(Set vcleWorkOnSaturdayses) {
        this.vcleWorkOnSaturdayses = vcleWorkOnSaturdayses;
    }
    public Set getVcleEmployeeMasters() {
        return this.vcleEmployeeMasters;
    }
    
    public void setVcleEmployeeMasters(Set vcleEmployeeMasters) {
        this.vcleEmployeeMasters = vcleEmployeeMasters;
    }
    public Set getVcleTravelExchanges() {
        return this.vcleTravelExchanges;
    }
    
    public void setVcleTravelExchanges(Set vcleTravelExchanges) {
        this.vcleTravelExchanges = vcleTravelExchanges;
    }
    public Set getVcleWorkOnSaturdayEmps() {
        return this.vcleWorkOnSaturdayEmps;
    }
    
    public void setVcleWorkOnSaturdayEmps(Set vcleWorkOnSaturdayEmps) {
        this.vcleWorkOnSaturdayEmps = vcleWorkOnSaturdayEmps;
    }




}


