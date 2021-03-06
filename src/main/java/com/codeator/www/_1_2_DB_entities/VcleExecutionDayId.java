package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleExecutionDayId generated by hbm2java
 */
@Embeddable
public class VcleExecutionDayId  implements java.io.Serializable {


     private Date execMm;
     private byte dayNo;

    public VcleExecutionDayId() {
    }

    public VcleExecutionDayId(Date execMm, byte dayNo) {
       this.execMm = execMm;
       this.dayNo = dayNo;
    }
   


    @Column(name="EXEC_MM", nullable=false, length=7)
    public Date getExecMm() {
        return this.execMm;
    }
    
    public void setExecMm(Date execMm) {
        this.execMm = execMm;
    }


    @Column(name="DAY_NO", nullable=false, precision=2, scale=0)
    public byte getDayNo() {
        return this.dayNo;
    }
    
    public void setDayNo(byte dayNo) {
        this.dayNo = dayNo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleExecutionDayId) ) return false;
		 VcleExecutionDayId castOther = ( VcleExecutionDayId ) other; 
         
		 return ( (this.getExecMm()==castOther.getExecMm()) || ( this.getExecMm()!=null && castOther.getExecMm()!=null && this.getExecMm().equals(castOther.getExecMm()) ) )
 && (this.getDayNo()==castOther.getDayNo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getExecMm() == null ? 0 : this.getExecMm().hashCode() );
         result = 37 * result + this.getDayNo();
         return result;
   }   


}


