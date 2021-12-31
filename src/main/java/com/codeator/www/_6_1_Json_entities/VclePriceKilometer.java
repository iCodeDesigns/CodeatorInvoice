package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * VclePriceKilometer generated by hbm2java
 */
public class VclePriceKilometer  implements java.io.Serializable {


     private VclePriceKilometerId id;
     private VclePriceDateMaster vclePriceDateMaster;
     private VcleVehicleType vcleVehicleType;
     private BigDecimal kiloHourPrice;
     private BigDecimal minVal;
     private BigDecimal maxVal;

    public VclePriceKilometer() {
    }

	
    public VclePriceKilometer(VclePriceKilometerId id, VclePriceDateMaster vclePriceDateMaster, VcleVehicleType vcleVehicleType, BigDecimal kiloHourPrice) {
        this.id = id;
        this.vclePriceDateMaster = vclePriceDateMaster;
        this.vcleVehicleType = vcleVehicleType;
        this.kiloHourPrice = kiloHourPrice;
    }
    public VclePriceKilometer(VclePriceKilometerId id, VclePriceDateMaster vclePriceDateMaster, VcleVehicleType vcleVehicleType, BigDecimal kiloHourPrice, BigDecimal minVal, BigDecimal maxVal) {
       this.id = id;
       this.vclePriceDateMaster = vclePriceDateMaster;
       this.vcleVehicleType = vcleVehicleType;
       this.kiloHourPrice = kiloHourPrice;
       this.minVal = minVal;
       this.maxVal = maxVal;
    }
   
    public VclePriceKilometerId getId() {
        return this.id;
    }
    
    public void setId(VclePriceKilometerId id) {
        this.id = id;
    }
    public VclePriceDateMaster getVclePriceDateMaster() {
        return this.vclePriceDateMaster;
    }
    
    public void setVclePriceDateMaster(VclePriceDateMaster vclePriceDateMaster) {
        this.vclePriceDateMaster = vclePriceDateMaster;
    }
    public VcleVehicleType getVcleVehicleType() {
        return this.vcleVehicleType;
    }
    
    public void setVcleVehicleType(VcleVehicleType vcleVehicleType) {
        this.vcleVehicleType = vcleVehicleType;
    }
    public BigDecimal getKiloHourPrice() {
        return this.kiloHourPrice;
    }
    
    public void setKiloHourPrice(BigDecimal kiloHourPrice) {
        this.kiloHourPrice = kiloHourPrice;
    }
    public BigDecimal getMinVal() {
        return this.minVal;
    }
    
    public void setMinVal(BigDecimal minVal) {
        this.minVal = minVal;
    }
    public BigDecimal getMaxVal() {
        return this.maxVal;
    }
    
    public void setMaxVal(BigDecimal maxVal) {
        this.maxVal = maxVal;
    }




}

