package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * VcleVehicleResponseWorkId generated by hbm2java
 */
public class VcleVehicleResponseWorkId  implements java.io.Serializable {


     private long employeeId;
     private String costCode;

    public VcleVehicleResponseWorkId() {
    }

    public VcleVehicleResponseWorkId(long employeeId, String costCode) {
       this.employeeId = employeeId;
       this.costCode = costCode;
    }
   
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public String getCostCode() {
        return this.costCode;
    }
    
    public void setCostCode(String costCode) {
        this.costCode = costCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleResponseWorkId) ) return false;
		 VcleVehicleResponseWorkId castOther = ( VcleVehicleResponseWorkId ) other; 
         
		 return (this.getEmployeeId()==castOther.getEmployeeId())
 && ( (this.getCostCode()==castOther.getCostCode()) || ( this.getCostCode()!=null && castOther.getCostCode()!=null && this.getCostCode().equals(castOther.getCostCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getEmployeeId();
         result = 37 * result + ( getCostCode() == null ? 0 : this.getCostCode().hashCode() );
         return result;
   }   


}


