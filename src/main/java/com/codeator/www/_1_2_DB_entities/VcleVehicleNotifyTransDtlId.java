package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleVehicleNotifyTransDtlId generated by hbm2java
 */
@Embeddable
public class VcleVehicleNotifyTransDtlId  implements java.io.Serializable {


     private byte workshopeCode;
     private int vehicleSp;
     private int notifySp;
     private Date fiscalDate;

    public VcleVehicleNotifyTransDtlId() {
    }

    public VcleVehicleNotifyTransDtlId(byte workshopeCode, int vehicleSp, int notifySp, Date fiscalDate) {
       this.workshopeCode = workshopeCode;
       this.vehicleSp = vehicleSp;
       this.notifySp = notifySp;
       this.fiscalDate = fiscalDate;
    }
   


    @Column(name="WORKSHOPE_CODE", nullable=false, precision=2, scale=0)
    public byte getWorkshopeCode() {
        return this.workshopeCode;
    }
    
    public void setWorkshopeCode(byte workshopeCode) {
        this.workshopeCode = workshopeCode;
    }


    @Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0)
    public int getVehicleSp() {
        return this.vehicleSp;
    }
    
    public void setVehicleSp(int vehicleSp) {
        this.vehicleSp = vehicleSp;
    }


    @Column(name="NOTIFY_SP", nullable=false, precision=9, scale=0)
    public int getNotifySp() {
        return this.notifySp;
    }
    
    public void setNotifySp(int notifySp) {
        this.notifySp = notifySp;
    }


    @Column(name="FISCAL_DATE", nullable=false, length=7)
    public Date getFiscalDate() {
        return this.fiscalDate;
    }
    
    public void setFiscalDate(Date fiscalDate) {
        this.fiscalDate = fiscalDate;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleNotifyTransDtlId) ) return false;
		 VcleVehicleNotifyTransDtlId castOther = ( VcleVehicleNotifyTransDtlId ) other; 
         
		 return (this.getWorkshopeCode()==castOther.getWorkshopeCode())
 && (this.getVehicleSp()==castOther.getVehicleSp())
 && (this.getNotifySp()==castOther.getNotifySp())
 && ( (this.getFiscalDate()==castOther.getFiscalDate()) || ( this.getFiscalDate()!=null && castOther.getFiscalDate()!=null && this.getFiscalDate().equals(castOther.getFiscalDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getWorkshopeCode();
         result = 37 * result + this.getVehicleSp();
         result = 37 * result + this.getNotifySp();
         result = 37 * result + ( getFiscalDate() == null ? 0 : this.getFiscalDate().hashCode() );
         return result;
   }   


}


