package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * StoResponsibilityDeptDelId generated by hbm2java
 */
public class StoResponsibilityDeptDelId  implements java.io.Serializable {


     private long depNoOld;
     private int respSp;
     private int sectionNoOld;
     private short delSp;

    public StoResponsibilityDeptDelId() {
    }

    public StoResponsibilityDeptDelId(long depNoOld, int respSp, int sectionNoOld, short delSp) {
       this.depNoOld = depNoOld;
       this.respSp = respSp;
       this.sectionNoOld = sectionNoOld;
       this.delSp = delSp;
    }
   
    public long getDepNoOld() {
        return this.depNoOld;
    }
    
    public void setDepNoOld(long depNoOld) {
        this.depNoOld = depNoOld;
    }
    public int getRespSp() {
        return this.respSp;
    }
    
    public void setRespSp(int respSp) {
        this.respSp = respSp;
    }
    public int getSectionNoOld() {
        return this.sectionNoOld;
    }
    
    public void setSectionNoOld(int sectionNoOld) {
        this.sectionNoOld = sectionNoOld;
    }
    public short getDelSp() {
        return this.delSp;
    }
    
    public void setDelSp(short delSp) {
        this.delSp = delSp;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StoResponsibilityDeptDelId) ) return false;
		 StoResponsibilityDeptDelId castOther = ( StoResponsibilityDeptDelId ) other; 
         
		 return (this.getDepNoOld()==castOther.getDepNoOld())
 && (this.getRespSp()==castOther.getRespSp())
 && (this.getSectionNoOld()==castOther.getSectionNoOld())
 && (this.getDelSp()==castOther.getDelSp());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getDepNoOld();
         result = 37 * result + this.getRespSp();
         result = 37 * result + this.getSectionNoOld();
         result = 37 * result + this.getDelSp();
         return result;
   }   


}


