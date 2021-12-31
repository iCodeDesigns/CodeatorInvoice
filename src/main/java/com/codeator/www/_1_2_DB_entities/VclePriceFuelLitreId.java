package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VclePriceFuelLitreId generated by hbm2java
 */
@Embeddable
public class VclePriceFuelLitreId  implements java.io.Serializable {


     private boolean priceType;
     private Date priceDate;
     private boolean fuelType;
     private byte octane;

    public VclePriceFuelLitreId() {
    }

    public VclePriceFuelLitreId(boolean priceType, Date priceDate, boolean fuelType, byte octane) {
       this.priceType = priceType;
       this.priceDate = priceDate;
       this.fuelType = fuelType;
       this.octane = octane;
    }
   


    @Column(name="PRICE_TYPE", nullable=false, precision=1, scale=0)
    public boolean isPriceType() {
        return this.priceType;
    }
    
    public void setPriceType(boolean priceType) {
        this.priceType = priceType;
    }


    @Column(name="PRICE_DATE", nullable=false, length=7)
    public Date getPriceDate() {
        return this.priceDate;
    }
    
    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }


    @Column(name="FUEL_TYPE", nullable=false, precision=1, scale=0)
    public boolean isFuelType() {
        return this.fuelType;
    }
    
    public void setFuelType(boolean fuelType) {
        this.fuelType = fuelType;
    }


    @Column(name="OCTANE", nullable=false, precision=2, scale=0)
    public byte getOctane() {
        return this.octane;
    }
    
    public void setOctane(byte octane) {
        this.octane = octane;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VclePriceFuelLitreId) ) return false;
		 VclePriceFuelLitreId castOther = ( VclePriceFuelLitreId ) other; 
         
		 return (this.isPriceType()==castOther.isPriceType())
 && ( (this.getPriceDate()==castOther.getPriceDate()) || ( this.getPriceDate()!=null && castOther.getPriceDate()!=null && this.getPriceDate().equals(castOther.getPriceDate()) ) )
 && (this.isFuelType()==castOther.isFuelType())
 && (this.getOctane()==castOther.getOctane());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (this.isPriceType()?1:0);
         result = 37 * result + ( getPriceDate() == null ? 0 : this.getPriceDate().hashCode() );
         result = 37 * result + (this.isFuelType()?1:0);
         result = 37 * result + this.getOctane();
         return result;
   }   


}


