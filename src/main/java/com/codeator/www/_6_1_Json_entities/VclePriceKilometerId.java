package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VclePriceKilometerId generated by hbm2java
 */
public class VclePriceKilometerId  implements java.io.Serializable {


     private String vcleType;
     private boolean priceType;
     private Date priceDate;

    public VclePriceKilometerId() {
    }

    public VclePriceKilometerId(String vcleType, boolean priceType, Date priceDate) {
       this.vcleType = vcleType;
       this.priceType = priceType;
       this.priceDate = priceDate;
    }
   
    public String getVcleType() {
        return this.vcleType;
    }
    
    public void setVcleType(String vcleType) {
        this.vcleType = vcleType;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VclePriceKilometerId) ) return false;
		 VclePriceKilometerId castOther = ( VclePriceKilometerId ) other; 
         
		 return ( (this.getVcleType()==castOther.getVcleType()) || ( this.getVcleType()!=null && castOther.getVcleType()!=null && this.getVcleType().equals(castOther.getVcleType()) ) )
 && (this.isPriceType()==castOther.isPriceType())
 && ( (this.getPriceDate()==castOther.getPriceDate()) || ( this.getPriceDate()!=null && castOther.getPriceDate()!=null && this.getPriceDate().equals(castOther.getPriceDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getVcleType() == null ? 0 : this.getVcleType().hashCode() );
         result = 37 * result + (this.isPriceType()?1:0);
         result = 37 * result + ( getPriceDate() == null ? 0 : this.getPriceDate().hashCode() );
         return result;
   }   


}


