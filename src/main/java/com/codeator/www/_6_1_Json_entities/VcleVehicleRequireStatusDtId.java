package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * VcleVehicleRequireStatusDtId generated by hbm2java
 */
public class VcleVehicleRequireStatusDtId  implements java.io.Serializable {


     private long requireSp;
     private byte statusSeq;

    public VcleVehicleRequireStatusDtId() {
    }

    public VcleVehicleRequireStatusDtId(long requireSp, byte statusSeq) {
       this.requireSp = requireSp;
       this.statusSeq = statusSeq;
    }
   
    public long getRequireSp() {
        return this.requireSp;
    }
    
    public void setRequireSp(long requireSp) {
        this.requireSp = requireSp;
    }
    public byte getStatusSeq() {
        return this.statusSeq;
    }
    
    public void setStatusSeq(byte statusSeq) {
        this.statusSeq = statusSeq;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleRequireStatusDtId) ) return false;
		 VcleVehicleRequireStatusDtId castOther = ( VcleVehicleRequireStatusDtId ) other; 
         
		 return (this.getRequireSp()==castOther.getRequireSp())
 && (this.getStatusSeq()==castOther.getStatusSeq());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getRequireSp();
         result = 37 * result + this.getStatusSeq();
         return result;
   }   


}

