package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * VcleMotorChangeId generated by hbm2java
 */
public class VcleMotorChangeId  implements java.io.Serializable {


     private int vehicleSp;
     private boolean changeType;

    public VcleMotorChangeId() {
    }

    public VcleMotorChangeId(int vehicleSp, boolean changeType) {
       this.vehicleSp = vehicleSp;
       this.changeType = changeType;
    }
   
    public int getVehicleSp() {
        return this.vehicleSp;
    }
    
    public void setVehicleSp(int vehicleSp) {
        this.vehicleSp = vehicleSp;
    }
    public boolean isChangeType() {
        return this.changeType;
    }
    
    public void setChangeType(boolean changeType) {
        this.changeType = changeType;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleMotorChangeId) ) return false;
		 VcleMotorChangeId castOther = ( VcleMotorChangeId ) other; 
         
		 return (this.getVehicleSp()==castOther.getVehicleSp())
 && (this.isChangeType()==castOther.isChangeType());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getVehicleSp();
         result = 37 * result + (this.isChangeType()?1:0);
         return result;
   }   


}


