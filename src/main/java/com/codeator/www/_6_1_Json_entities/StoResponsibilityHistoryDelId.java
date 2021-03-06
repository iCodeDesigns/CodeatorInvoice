package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * StoResponsibilityHistoryDelId generated by hbm2java
 */
public class StoResponsibilityHistoryDelId  implements java.io.Serializable {


     private long employeeId;
     private int respSp;
     private boolean respType;
     private short delSp;

    public StoResponsibilityHistoryDelId() {
    }

    public StoResponsibilityHistoryDelId(long employeeId, int respSp, boolean respType, short delSp) {
       this.employeeId = employeeId;
       this.respSp = respSp;
       this.respType = respType;
       this.delSp = delSp;
    }
   
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public int getRespSp() {
        return this.respSp;
    }
    
    public void setRespSp(int respSp) {
        this.respSp = respSp;
    }
    public boolean isRespType() {
        return this.respType;
    }
    
    public void setRespType(boolean respType) {
        this.respType = respType;
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
		 if ( !(other instanceof StoResponsibilityHistoryDelId) ) return false;
		 StoResponsibilityHistoryDelId castOther = ( StoResponsibilityHistoryDelId ) other; 
         
		 return (this.getEmployeeId()==castOther.getEmployeeId())
 && (this.getRespSp()==castOther.getRespSp())
 && (this.isRespType()==castOther.isRespType())
 && (this.getDelSp()==castOther.getDelSp());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getEmployeeId();
         result = 37 * result + this.getRespSp();
         result = 37 * result + (this.isRespType()?1:0);
         result = 37 * result + this.getDelSp();
         return result;
   }   


}


