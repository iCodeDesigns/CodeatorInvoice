package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * VclePriceOil generated by hbm2java
 */
public class VclePriceOil  implements java.io.Serializable {


     private VclePriceOilId id;
     private VcleOilType vcleOilType;
     private VclePriceDateMaster vclePriceDateMaster;
     private BigDecimal oilPrice;

    public VclePriceOil() {
    }

    public VclePriceOil(VclePriceOilId id, VcleOilType vcleOilType, VclePriceDateMaster vclePriceDateMaster, BigDecimal oilPrice) {
       this.id = id;
       this.vcleOilType = vcleOilType;
       this.vclePriceDateMaster = vclePriceDateMaster;
       this.oilPrice = oilPrice;
    }
   
    public VclePriceOilId getId() {
        return this.id;
    }
    
    public void setId(VclePriceOilId id) {
        this.id = id;
    }
    public VcleOilType getVcleOilType() {
        return this.vcleOilType;
    }
    
    public void setVcleOilType(VcleOilType vcleOilType) {
        this.vcleOilType = vcleOilType;
    }
    public VclePriceDateMaster getVclePriceDateMaster() {
        return this.vclePriceDateMaster;
    }
    
    public void setVclePriceDateMaster(VclePriceDateMaster vclePriceDateMaster) {
        this.vclePriceDateMaster = vclePriceDateMaster;
    }
    public BigDecimal getOilPrice() {
        return this.oilPrice;
    }
    
    public void setOilPrice(BigDecimal oilPrice) {
        this.oilPrice = oilPrice;
    }




}

