package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VcleVehicleClassDtlId generated by hbm2java
 */
public class VcleVehicleClassDtlId  implements java.io.Serializable {


     private int vehicleSp;
     private Date useDate;

    public VcleVehicleClassDtlId() {
    }

    public VcleVehicleClassDtlId(int vehicleSp, Date useDate) {
       this.vehicleSp = vehicleSp;
       this.useDate = useDate;
    }
   
    public int getVehicleSp() {
        return this.vehicleSp;
    }
    
    public void setVehicleSp(int vehicleSp) {
        this.vehicleSp = vehicleSp;
    }
    public Date getUseDate() {
        return this.useDate;
    }
    
    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleClassDtlId) ) return false;
		 VcleVehicleClassDtlId castOther = ( VcleVehicleClassDtlId ) other; 
         
		 return (this.getVehicleSp()==castOther.getVehicleSp())
 && ( (this.getUseDate()==castOther.getUseDate()) || ( this.getUseDate()!=null && castOther.getUseDate()!=null && this.getUseDate().equals(castOther.getUseDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getVehicleSp();
         result = 37 * result + ( getUseDate() == null ? 0 : this.getUseDate().hashCode() );
         return result;
   }   


}


