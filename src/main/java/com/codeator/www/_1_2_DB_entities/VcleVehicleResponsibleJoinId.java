package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleVehicleResponsibleJoinId generated by hbm2java
 */
@Embeddable
public class VcleVehicleResponsibleJoinId  implements java.io.Serializable {


     private int vehicleSp;
     private long employeeId;
     private byte workshopeCode;

    public VcleVehicleResponsibleJoinId() {
    }

    public VcleVehicleResponsibleJoinId(int vehicleSp, long employeeId, byte workshopeCode) {
       this.vehicleSp = vehicleSp;
       this.employeeId = employeeId;
       this.workshopeCode = workshopeCode;
    }
   


    @Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0)
    public int getVehicleSp() {
        return this.vehicleSp;
    }
    
    public void setVehicleSp(int vehicleSp) {
        this.vehicleSp = vehicleSp;
    }


    @Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0)
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name="WORKSHOPE_CODE", nullable=false, precision=2, scale=0)
    public byte getWorkshopeCode() {
        return this.workshopeCode;
    }
    
    public void setWorkshopeCode(byte workshopeCode) {
        this.workshopeCode = workshopeCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleResponsibleJoinId) ) return false;
		 VcleVehicleResponsibleJoinId castOther = ( VcleVehicleResponsibleJoinId ) other; 
         
		 return (this.getVehicleSp()==castOther.getVehicleSp())
 && (this.getEmployeeId()==castOther.getEmployeeId())
 && (this.getWorkshopeCode()==castOther.getWorkshopeCode());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getVehicleSp();
         result = 37 * result + (int) this.getEmployeeId();
         result = 37 * result + this.getWorkshopeCode();
         return result;
   }   


}


