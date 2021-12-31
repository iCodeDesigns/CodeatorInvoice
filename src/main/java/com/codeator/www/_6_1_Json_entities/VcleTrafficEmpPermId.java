package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VcleTrafficEmpPermId generated by hbm2java
 */
public class VcleTrafficEmpPermId  implements java.io.Serializable {


     private Date execMm;
     private long employeeId;

    public VcleTrafficEmpPermId() {
    }

    public VcleTrafficEmpPermId(Date execMm, long employeeId) {
       this.execMm = execMm;
       this.employeeId = employeeId;
    }
   
    public Date getExecMm() {
        return this.execMm;
    }
    
    public void setExecMm(Date execMm) {
        this.execMm = execMm;
    }
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleTrafficEmpPermId) ) return false;
		 VcleTrafficEmpPermId castOther = ( VcleTrafficEmpPermId ) other; 
         
		 return ( (this.getExecMm()==castOther.getExecMm()) || ( this.getExecMm()!=null && castOther.getExecMm()!=null && this.getExecMm().equals(castOther.getExecMm()) ) )
 && (this.getEmployeeId()==castOther.getEmployeeId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getExecMm() == null ? 0 : this.getExecMm().hashCode() );
         result = 37 * result + (int) this.getEmployeeId();
         return result;
   }   


}

