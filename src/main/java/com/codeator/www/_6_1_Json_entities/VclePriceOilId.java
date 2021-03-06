package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VclePriceOilId generated by hbm2java
 */
public class VclePriceOilId  implements java.io.Serializable {


     private boolean priceType;
     private Date priceDate;
     private byte oilType;

    public VclePriceOilId() {
    }

    public VclePriceOilId(boolean priceType, Date priceDate, byte oilType) {
       this.priceType = priceType;
       this.priceDate = priceDate;
       this.oilType = oilType;
    }
   
    public boolean isPriceType() {
        return this.priceType;
    }
    
    public void setPriceType(boolean priceType) {
        this.priceType = priceType;
    }
    public Date getPriceDate() {
        return this.priceDate;
    }
    
    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }
    public byte getOilType() {
        return this.oilType;
    }
    
    public void setOilType(byte oilType) {
        this.oilType = oilType;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VclePriceOilId) ) return false;
		 VclePriceOilId castOther = ( VclePriceOilId ) other; 
         
		 return (this.isPriceType()==castOther.isPriceType())
 && ( (this.getPriceDate()==castOther.getPriceDate()) || ( this.getPriceDate()!=null && castOther.getPriceDate()!=null && this.getPriceDate().equals(castOther.getPriceDate()) ) )
 && (this.getOilType()==castOther.getOilType());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (this.isPriceType()?1:0);
         result = 37 * result + ( getPriceDate() == null ? 0 : this.getPriceDate().hashCode() );
         result = 37 * result + this.getOilType();
         return result;
   }   


}


