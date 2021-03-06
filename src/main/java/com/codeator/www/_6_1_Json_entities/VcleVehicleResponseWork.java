package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * VcleVehicleResponseWork generated by hbm2java
 */
public class VcleVehicleResponseWork  implements java.io.Serializable {


     private VcleVehicleResponseWorkId id;
     private VcleMainCost vcleMainCost;
     private VcleMainCostCode vcleMainCostCode;
     private VcleVehicleResponsibleEmp vcleVehicleResponsibleEmp;

    public VcleVehicleResponseWork() {
    }

	
    public VcleVehicleResponseWork(VcleVehicleResponseWorkId id, VcleMainCostCode vcleMainCostCode, VcleVehicleResponsibleEmp vcleVehicleResponsibleEmp) {
        this.id = id;
        this.vcleMainCostCode = vcleMainCostCode;
        this.vcleVehicleResponsibleEmp = vcleVehicleResponsibleEmp;
    }
    public VcleVehicleResponseWork(VcleVehicleResponseWorkId id, VcleMainCost vcleMainCost, VcleMainCostCode vcleMainCostCode, VcleVehicleResponsibleEmp vcleVehicleResponsibleEmp) {
       this.id = id;
       this.vcleMainCost = vcleMainCost;
       this.vcleMainCostCode = vcleMainCostCode;
       this.vcleVehicleResponsibleEmp = vcleVehicleResponsibleEmp;
    }
   
    public VcleVehicleResponseWorkId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleResponseWorkId id) {
        this.id = id;
    }
    public VcleMainCost getVcleMainCost() {
        return this.vcleMainCost;
    }
    
    public void setVcleMainCost(VcleMainCost vcleMainCost) {
        this.vcleMainCost = vcleMainCost;
    }
    public VcleMainCostCode getVcleMainCostCode() {
        return this.vcleMainCostCode;
    }
    
    public void setVcleMainCostCode(VcleMainCostCode vcleMainCostCode) {
        this.vcleMainCostCode = vcleMainCostCode;
    }
    public VcleVehicleResponsibleEmp getVcleVehicleResponsibleEmp() {
        return this.vcleVehicleResponsibleEmp;
    }
    
    public void setVcleVehicleResponsibleEmp(VcleVehicleResponsibleEmp vcleVehicleResponsibleEmp) {
        this.vcleVehicleResponsibleEmp = vcleVehicleResponsibleEmp;
    }




}


