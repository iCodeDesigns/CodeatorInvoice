package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VcleEmployeeVacationId generated by hbm2java
 */
public class VcleEmployeeVacationId  implements java.io.Serializable {


     private long employeeId;
     private short fiscalYear;
     private Date vacStartDate;

    public VcleEmployeeVacationId() {
    }

    public VcleEmployeeVacationId(long employeeId, short fiscalYear, Date vacStartDate) {
       this.employeeId = employeeId;
       this.fiscalYear = fiscalYear;
       this.vacStartDate = vacStartDate;
    }
   
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public short getFiscalYear() {
        return this.fiscalYear;
    }
    
    public void setFiscalYear(short fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
    public Date getVacStartDate() {
        return this.vacStartDate;
    }
    
    public void setVacStartDate(Date vacStartDate) {
        this.vacStartDate = vacStartDate;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleEmployeeVacationId) ) return false;
		 VcleEmployeeVacationId castOther = ( VcleEmployeeVacationId ) other; 
         
		 return (this.getEmployeeId()==castOther.getEmployeeId())
 && (this.getFiscalYear()==castOther.getFiscalYear())
 && ( (this.getVacStartDate()==castOther.getVacStartDate()) || ( this.getVacStartDate()!=null && castOther.getVacStartDate()!=null && this.getVacStartDate().equals(castOther.getVacStartDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getEmployeeId();
         result = 37 * result + this.getFiscalYear();
         result = 37 * result + ( getVacStartDate() == null ? 0 : this.getVacStartDate().hashCode() );
         return result;
   }   


}

