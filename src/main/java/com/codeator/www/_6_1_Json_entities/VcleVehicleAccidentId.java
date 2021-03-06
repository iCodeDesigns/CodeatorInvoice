package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VcleVehicleAccidentId generated by hbm2java
 */
public class VcleVehicleAccidentId  implements java.io.Serializable {


     private Date accidentDate;
     private int vehicleSp;

    public VcleVehicleAccidentId() {
    }

    public VcleVehicleAccidentId(Date accidentDate, int vehicleSp) {
       this.accidentDate = accidentDate;
       this.vehicleSp = vehicleSp;
    }
   
    public Date getAccidentDate() {
        return this.accidentDate;
    }
    
    public void setAccidentDate(Date accidentDate) {
        this.accidentDate = accidentDate;
    }
    public int getVehicleSp() {
        return this.vehicleSp;
    }
    
    public void setVehicleSp(int vehicleSp) {
        this.vehicleSp = vehicleSp;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleAccidentId) ) return false;
		 VcleVehicleAccidentId castOther = ( VcleVehicleAccidentId ) other; 
         
		 return ( (this.getAccidentDate()==castOther.getAccidentDate()) || ( this.getAccidentDate()!=null && castOther.getAccidentDate()!=null && this.getAccidentDate().equals(castOther.getAccidentDate()) ) )
 && (this.getVehicleSp()==castOther.getVehicleSp());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAccidentDate() == null ? 0 : this.getAccidentDate().hashCode() );
         result = 37 * result + this.getVehicleSp();
         return result;
   }   


}


