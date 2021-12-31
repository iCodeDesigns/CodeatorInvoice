package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * VcleColorCode generated by hbm2java
 */
public class VcleColorCode  implements java.io.Serializable {


     private byte colorCode;
     private String colorName;
     private Set vcleVehicleMasters = new HashSet(0);

    public VcleColorCode() {
    }

	
    public VcleColorCode(byte colorCode) {
        this.colorCode = colorCode;
    }
    public VcleColorCode(byte colorCode, String colorName, Set vcleVehicleMasters) {
       this.colorCode = colorCode;
       this.colorName = colorName;
       this.vcleVehicleMasters = vcleVehicleMasters;
    }
   
    public byte getColorCode() {
        return this.colorCode;
    }
    
    public void setColorCode(byte colorCode) {
        this.colorCode = colorCode;
    }
    public String getColorName() {
        return this.colorName;
    }
    
    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
    public Set getVcleVehicleMasters() {
        return this.vcleVehicleMasters;
    }
    
    public void setVcleVehicleMasters(Set vcleVehicleMasters) {
        this.vcleVehicleMasters = vcleVehicleMasters;
    }




}

