package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleEmployeeOvertimeId generated by hbm2java
 */
@Embeddable
public class VcleEmployeeOvertimeId  implements java.io.Serializable {


     private Date execMm;
     private Date execDay;
     private long employeeId;

    public VcleEmployeeOvertimeId() {
    }

    public VcleEmployeeOvertimeId(Date execMm, Date execDay, long employeeId) {
       this.execMm = execMm;
       this.execDay = execDay;
       this.employeeId = employeeId;
    }
   


    @Column(name="EXEC_MM", nullable=false, length=7)
    public Date getExecMm() {
        return this.execMm;
    }
    
    public void setExecMm(Date execMm) {
        this.execMm = execMm;
    }


    @Column(name="EXEC_DAY", nullable=false, length=7)
    public Date getExecDay() {
        return this.execDay;
    }
    
    public void setExecDay(Date execDay) {
        this.execDay = execDay;
    }


    @Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0)
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleEmployeeOvertimeId) ) return false;
		 VcleEmployeeOvertimeId castOther = ( VcleEmployeeOvertimeId ) other; 
         
		 return ( (this.getExecMm()==castOther.getExecMm()) || ( this.getExecMm()!=null && castOther.getExecMm()!=null && this.getExecMm().equals(castOther.getExecMm()) ) )
 && ( (this.getExecDay()==castOther.getExecDay()) || ( this.getExecDay()!=null && castOther.getExecDay()!=null && this.getExecDay().equals(castOther.getExecDay()) ) )
 && (this.getEmployeeId()==castOther.getEmployeeId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getExecMm() == null ? 0 : this.getExecMm().hashCode() );
         result = 37 * result + ( getExecDay() == null ? 0 : this.getExecDay().hashCode() );
         result = 37 * result + (int) this.getEmployeeId();
         return result;
   }   


}


