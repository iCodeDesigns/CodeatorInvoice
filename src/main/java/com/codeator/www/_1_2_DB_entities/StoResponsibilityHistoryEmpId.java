package com.codeator.www._1_2_DB_entities;
// Generated Mar 21, 2021 6:34:02 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StoResponsibilityHistoryEmpId generated by hbm2java
 */
@Embeddable
public class StoResponsibilityHistoryEmpId  implements java.io.Serializable {


     private long employeeId;
     private int respSp;
     private boolean respType;

    public StoResponsibilityHistoryEmpId() {
    }

    public StoResponsibilityHistoryEmpId(long employeeId, int respSp, boolean respType) {
       this.employeeId = employeeId;
       this.respSp = respSp;
       this.respType = respType;
    }
   


    @Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0)
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name="RESP_SP", nullable=false, precision=6, scale=0)
    public int getRespSp() {
        return this.respSp;
    }
    
    public void setRespSp(int respSp) {
        this.respSp = respSp;
    }


    @Column(name="RESP_TYPE", nullable=false, precision=1, scale=0)
    public boolean isRespType() {
        return this.respType;
    }
    
    public void setRespType(boolean respType) {
        this.respType = respType;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StoResponsibilityHistoryEmpId) ) return false;
		 StoResponsibilityHistoryEmpId castOther = ( StoResponsibilityHistoryEmpId ) other; 
         
		 return (this.getEmployeeId()==castOther.getEmployeeId())
 && (this.getRespSp()==castOther.getRespSp())
 && (this.isRespType()==castOther.isRespType());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getEmployeeId();
         result = 37 * result + this.getRespSp();
         result = 37 * result + (this.isRespType()?1:0);
         return result;
   }   


}


