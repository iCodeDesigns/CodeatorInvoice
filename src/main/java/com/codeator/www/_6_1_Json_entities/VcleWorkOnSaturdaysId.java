package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VcleWorkOnSaturdaysId generated by hbm2java
 */
public class VcleWorkOnSaturdaysId  implements java.io.Serializable {


     private long employeeId;
     private Date execDay;

    public VcleWorkOnSaturdaysId() {
    }

    public VcleWorkOnSaturdaysId(long employeeId, Date execDay) {
       this.employeeId = employeeId;
       this.execDay = execDay;
    }
   
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public Date getExecDay() {
        return this.execDay;
    }
    
    public void setExecDay(Date execDay) {
        this.execDay = execDay;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleWorkOnSaturdaysId) ) return false;
		 VcleWorkOnSaturdaysId castOther = ( VcleWorkOnSaturdaysId ) other; 
         
		 return (this.getEmployeeId()==castOther.getEmployeeId())
 && ( (this.getExecDay()==castOther.getExecDay()) || ( this.getExecDay()!=null && castOther.getExecDay()!=null && this.getExecDay().equals(castOther.getExecDay()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getEmployeeId();
         result = 37 * result + ( getExecDay() == null ? 0 : this.getExecDay().hashCode() );
         return result;
   }   


}

