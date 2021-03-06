package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * VcleVehicleTypeUserId generated by hbm2java
 */
public class VcleVehicleTypeUserId  implements java.io.Serializable {


     private String vcleType;
     private BigDecimal userId;

    public VcleVehicleTypeUserId() {
    }

    public VcleVehicleTypeUserId(String vcleType, BigDecimal userId) {
       this.vcleType = vcleType;
       this.userId = userId;
    }
   
    public String getVcleType() {
        return this.vcleType;
    }
    
    public void setVcleType(String vcleType) {
        this.vcleType = vcleType;
    }
    public BigDecimal getUserId() {
        return this.userId;
    }
    
    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleTypeUserId) ) return false;
		 VcleVehicleTypeUserId castOther = ( VcleVehicleTypeUserId ) other; 
         
		 return ( (this.getVcleType()==castOther.getVcleType()) || ( this.getVcleType()!=null && castOther.getVcleType()!=null && this.getVcleType().equals(castOther.getVcleType()) ) )
 && ( (this.getUserId()==castOther.getUserId()) || ( this.getUserId()!=null && castOther.getUserId()!=null && this.getUserId().equals(castOther.getUserId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getVcleType() == null ? 0 : this.getVcleType().hashCode() );
         result = 37 * result + ( getUserId() == null ? 0 : this.getUserId().hashCode() );
         return result;
   }   


}


