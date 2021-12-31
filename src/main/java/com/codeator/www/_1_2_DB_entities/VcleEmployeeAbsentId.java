package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleEmployeeAbsentId generated by hbm2java
 */
@Embeddable
public class VcleEmployeeAbsentId  implements java.io.Serializable {


     private byte workshopeCode;
     private long employeeId;
     private Date fromDate;

    public VcleEmployeeAbsentId() {
    }

    public VcleEmployeeAbsentId(byte workshopeCode, long employeeId, Date fromDate) {
       this.workshopeCode = workshopeCode;
       this.employeeId = employeeId;
       this.fromDate = fromDate;
    }
   


    @Column(name="WORKSHOPE_CODE", nullable=false, precision=2, scale=0)
    public byte getWorkshopeCode() {
        return this.workshopeCode;
    }
    
    public void setWorkshopeCode(byte workshopeCode) {
        this.workshopeCode = workshopeCode;
    }


    @Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0)
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name="FROM_DATE", nullable=false, length=7)
    public Date getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleEmployeeAbsentId) ) return false;
		 VcleEmployeeAbsentId castOther = ( VcleEmployeeAbsentId ) other; 
         
		 return (this.getWorkshopeCode()==castOther.getWorkshopeCode())
 && (this.getEmployeeId()==castOther.getEmployeeId())
 && ( (this.getFromDate()==castOther.getFromDate()) || ( this.getFromDate()!=null && castOther.getFromDate()!=null && this.getFromDate().equals(castOther.getFromDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getWorkshopeCode();
         result = 37 * result + (int) this.getEmployeeId();
         result = 37 * result + ( getFromDate() == null ? 0 : this.getFromDate().hashCode() );
         return result;
   }   


}

