package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * VcleVehicleIncomeId generated by hbm2java
 */
public class VcleVehicleIncomeId  implements java.io.Serializable {


     private long goingSp;
     private short goingYear;

    public VcleVehicleIncomeId() {
    }

    public VcleVehicleIncomeId(long goingSp, short goingYear) {
       this.goingSp = goingSp;
       this.goingYear = goingYear;
    }
   
    public long getGoingSp() {
        return this.goingSp;
    }
    
    public void setGoingSp(long goingSp) {
        this.goingSp = goingSp;
    }
    public short getGoingYear() {
        return this.goingYear;
    }
    
    public void setGoingYear(short goingYear) {
        this.goingYear = goingYear;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleIncomeId) ) return false;
		 VcleVehicleIncomeId castOther = ( VcleVehicleIncomeId ) other; 
         
		 return (this.getGoingSp()==castOther.getGoingSp())
 && (this.getGoingYear()==castOther.getGoingYear());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getGoingSp();
         result = 37 * result + this.getGoingYear();
         return result;
   }   


}

