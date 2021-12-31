package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleWorkSideDtlId generated by hbm2java
 */
@Embeddable
public class VcleWorkSideDtlId  implements java.io.Serializable {


     private int vehicleSp;
     private byte workSideCode;
     private int workSp;

    public VcleWorkSideDtlId() {
    }

    public VcleWorkSideDtlId(int vehicleSp, byte workSideCode, int workSp) {
       this.vehicleSp = vehicleSp;
       this.workSideCode = workSideCode;
       this.workSp = workSp;
    }
   


    @Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0)
    public int getVehicleSp() {
        return this.vehicleSp;
    }
    
    public void setVehicleSp(int vehicleSp) {
        this.vehicleSp = vehicleSp;
    }


    @Column(name="WORK_SIDE_CODE", nullable=false, precision=2, scale=0)
    public byte getWorkSideCode() {
        return this.workSideCode;
    }
    
    public void setWorkSideCode(byte workSideCode) {
        this.workSideCode = workSideCode;
    }


    @Column(name="WORK_SP", nullable=false, precision=6, scale=0)
    public int getWorkSp() {
        return this.workSp;
    }
    
    public void setWorkSp(int workSp) {
        this.workSp = workSp;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleWorkSideDtlId) ) return false;
		 VcleWorkSideDtlId castOther = ( VcleWorkSideDtlId ) other; 
         
		 return (this.getVehicleSp()==castOther.getVehicleSp())
 && (this.getWorkSideCode()==castOther.getWorkSideCode())
 && (this.getWorkSp()==castOther.getWorkSp());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getVehicleSp();
         result = 37 * result + this.getWorkSideCode();
         result = 37 * result + this.getWorkSp();
         return result;
   }   


}


