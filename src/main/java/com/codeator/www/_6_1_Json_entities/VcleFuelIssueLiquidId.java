package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VcleFuelIssueLiquidId generated by hbm2java
 */
public class VcleFuelIssueLiquidId  implements java.io.Serializable {


     private String locCode;
     private int issueSp;
     private boolean sideType;
     private Date execDate;

    public VcleFuelIssueLiquidId() {
    }

    public VcleFuelIssueLiquidId(String locCode, int issueSp, boolean sideType, Date execDate) {
       this.locCode = locCode;
       this.issueSp = issueSp;
       this.sideType = sideType;
       this.execDate = execDate;
    }
   
    public String getLocCode() {
        return this.locCode;
    }
    
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }
    public int getIssueSp() {
        return this.issueSp;
    }
    
    public void setIssueSp(int issueSp) {
        this.issueSp = issueSp;
    }
    public boolean isSideType() {
        return this.sideType;
    }
    
    public void setSideType(boolean sideType) {
        this.sideType = sideType;
    }
    public Date getExecDate() {
        return this.execDate;
    }
    
    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleFuelIssueLiquidId) ) return false;
		 VcleFuelIssueLiquidId castOther = ( VcleFuelIssueLiquidId ) other; 
         
		 return ( (this.getLocCode()==castOther.getLocCode()) || ( this.getLocCode()!=null && castOther.getLocCode()!=null && this.getLocCode().equals(castOther.getLocCode()) ) )
 && (this.getIssueSp()==castOther.getIssueSp())
 && (this.isSideType()==castOther.isSideType())
 && ( (this.getExecDate()==castOther.getExecDate()) || ( this.getExecDate()!=null && castOther.getExecDate()!=null && this.getExecDate().equals(castOther.getExecDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getLocCode() == null ? 0 : this.getLocCode().hashCode() );
         result = 37 * result + this.getIssueSp();
         result = 37 * result + (this.isSideType()?1:0);
         result = 37 * result + ( getExecDate() == null ? 0 : this.getExecDate().hashCode() );
         return result;
   }   


}

