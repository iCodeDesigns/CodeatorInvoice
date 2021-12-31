package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VcleEmployeeVacationDateId generated by hbm2java
 */
public class VcleEmployeeVacationDateId  implements java.io.Serializable {


     private short fiscalYear;
     private Date vacStartDate;
     private long employeeId;
     private Date vacDate;

    public VcleEmployeeVacationDateId() {
    }

    public VcleEmployeeVacationDateId(short fiscalYear, Date vacStartDate, long employeeId, Date vacDate) {
       this.fiscalYear = fiscalYear;
       this.vacStartDate = vacStartDate;
       this.employeeId = employeeId;
       this.vacDate = vacDate;
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
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public Date getVacDate() {
        return this.vacDate;
    }
    
    public void setVacDate(Date vacDate) {
        this.vacDate = vacDate;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleEmployeeVacationDateId) ) return false;
		 VcleEmployeeVacationDateId castOther = ( VcleEmployeeVacationDateId ) other; 
         
		 return (this.getFiscalYear()==castOther.getFiscalYear())
 && ( (this.getVacStartDate()==castOther.getVacStartDate()) || ( this.getVacStartDate()!=null && castOther.getVacStartDate()!=null && this.getVacStartDate().equals(castOther.getVacStartDate()) ) )
 && (this.getEmployeeId()==castOther.getEmployeeId())
 && ( (this.getVacDate()==castOther.getVacDate()) || ( this.getVacDate()!=null && castOther.getVacDate()!=null && this.getVacDate().equals(castOther.getVacDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getFiscalYear();
         result = 37 * result + ( getVacStartDate() == null ? 0 : this.getVacStartDate().hashCode() );
         result = 37 * result + (int) this.getEmployeeId();
         result = 37 * result + ( getVacDate() == null ? 0 : this.getVacDate().hashCode() );
         return result;
   }   


}

