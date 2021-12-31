package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleFuelBalanceLiquidId generated by hbm2java
 */
@Embeddable
public class VcleFuelBalanceLiquidId  implements java.io.Serializable {


     private String locCode;
     private Date execDate;
     private boolean shiftType;

    public VcleFuelBalanceLiquidId() {
    }

    public VcleFuelBalanceLiquidId(String locCode, Date execDate, boolean shiftType) {
       this.locCode = locCode;
       this.execDate = execDate;
       this.shiftType = shiftType;
    }
   


    @Column(name="LOC_CODE", nullable=false, length=3)
    public String getLocCode() {
        return this.locCode;
    }
    
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }


    @Column(name="EXEC_DATE", nullable=false, length=7)
    public Date getExecDate() {
        return this.execDate;
    }
    
    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }


    @Column(name="SHIFT_TYPE", nullable=false, precision=1, scale=0)
    public boolean isShiftType() {
        return this.shiftType;
    }
    
    public void setShiftType(boolean shiftType) {
        this.shiftType = shiftType;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleFuelBalanceLiquidId) ) return false;
		 VcleFuelBalanceLiquidId castOther = ( VcleFuelBalanceLiquidId ) other; 
         
		 return ( (this.getLocCode()==castOther.getLocCode()) || ( this.getLocCode()!=null && castOther.getLocCode()!=null && this.getLocCode().equals(castOther.getLocCode()) ) )
 && ( (this.getExecDate()==castOther.getExecDate()) || ( this.getExecDate()!=null && castOther.getExecDate()!=null && this.getExecDate().equals(castOther.getExecDate()) ) )
 && (this.isShiftType()==castOther.isShiftType());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocCode() == null ? 0 : this.getLocCode().hashCode() );
         result = 37 * result + ( getExecDate() == null ? 0 : this.getExecDate().hashCode() );
         result = 37 * result + (this.isShiftType()?1:0);
         return result;
   }   


}

