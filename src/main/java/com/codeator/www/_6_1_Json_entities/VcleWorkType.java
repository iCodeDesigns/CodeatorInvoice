package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * VcleWorkType generated by hbm2java
 */
public class VcleWorkType  implements java.io.Serializable {


     private byte workType;
     private String workName;
     private Boolean chkWork;
     private Set vcleEmployeeOvertimes = new HashSet(0);
     private Set vcleTravelExchanges = new HashSet(0);
     private Set vcleVehicleIncomes = new HashSet(0);
     private Set vcleEmployeeMasters = new HashSet(0);
     private Set vcleWorkTypeJoins = new HashSet(0);
     private Set vcleRecordMovements = new HashSet(0);

    public VcleWorkType() {
    }

	
    public VcleWorkType(byte workType, String workName) {
        this.workType = workType;
        this.workName = workName;
    }
    public VcleWorkType(byte workType, String workName, Boolean chkWork, Set vcleEmployeeOvertimes, Set vcleTravelExchanges, Set vcleVehicleIncomes, Set vcleEmployeeMasters, Set vcleWorkTypeJoins, Set vcleRecordMovements) {
       this.workType = workType;
       this.workName = workName;
       this.chkWork = chkWork;
       this.vcleEmployeeOvertimes = vcleEmployeeOvertimes;
       this.vcleTravelExchanges = vcleTravelExchanges;
       this.vcleVehicleIncomes = vcleVehicleIncomes;
       this.vcleEmployeeMasters = vcleEmployeeMasters;
       this.vcleWorkTypeJoins = vcleWorkTypeJoins;
       this.vcleRecordMovements = vcleRecordMovements;
    }
   
    public byte getWorkType() {
        return this.workType;
    }
    
    public void setWorkType(byte workType) {
        this.workType = workType;
    }
    public String getWorkName() {
        return this.workName;
    }
    
    public void setWorkName(String workName) {
        this.workName = workName;
    }
    public Boolean getChkWork() {
        return this.chkWork;
    }
    
    public void setChkWork(Boolean chkWork) {
        this.chkWork = chkWork;
    }
    public Set getVcleEmployeeOvertimes() {
        return this.vcleEmployeeOvertimes;
    }
    
    public void setVcleEmployeeOvertimes(Set vcleEmployeeOvertimes) {
        this.vcleEmployeeOvertimes = vcleEmployeeOvertimes;
    }
    public Set getVcleTravelExchanges() {
        return this.vcleTravelExchanges;
    }
    
    public void setVcleTravelExchanges(Set vcleTravelExchanges) {
        this.vcleTravelExchanges = vcleTravelExchanges;
    }
    public Set getVcleVehicleIncomes() {
        return this.vcleVehicleIncomes;
    }
    
    public void setVcleVehicleIncomes(Set vcleVehicleIncomes) {
        this.vcleVehicleIncomes = vcleVehicleIncomes;
    }
    public Set getVcleEmployeeMasters() {
        return this.vcleEmployeeMasters;
    }
    
    public void setVcleEmployeeMasters(Set vcleEmployeeMasters) {
        this.vcleEmployeeMasters = vcleEmployeeMasters;
    }
    public Set getVcleWorkTypeJoins() {
        return this.vcleWorkTypeJoins;
    }
    
    public void setVcleWorkTypeJoins(Set vcleWorkTypeJoins) {
        this.vcleWorkTypeJoins = vcleWorkTypeJoins;
    }
    public Set getVcleRecordMovements() {
        return this.vcleRecordMovements;
    }
    
    public void setVcleRecordMovements(Set vcleRecordMovements) {
        this.vcleRecordMovements = vcleRecordMovements;
    }




}


