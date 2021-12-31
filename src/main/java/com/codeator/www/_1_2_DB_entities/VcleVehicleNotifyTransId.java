package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleVehicleNotifyTransId generated by hbm2java
 */
@Embeddable
public class VcleVehicleNotifyTransId  implements java.io.Serializable {


     private Date fiscalDate;
     private int vehicleSp;
     private int notifySp;

    public VcleVehicleNotifyTransId() {
    }

    public VcleVehicleNotifyTransId(Date fiscalDate, int vehicleSp, int notifySp) {
       this.fiscalDate = fiscalDate;
       this.vehicleSp = vehicleSp;
       this.notifySp = notifySp;
    }
   


    @Column(name="FISCAL_DATE", nullable=false, length=7)
    public Date getFiscalDate() {
        return this.fiscalDate;
    }
    
    public void setFiscalDate(Date fiscalDate) {
        this.fiscalDate = fiscalDate;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleNotifyTransId) ) return false;
		 VcleVehicleNotifyTransId castOther = ( VcleVehicleNotifyTransId ) other; 
         
		 return ( (this.getFiscalDate()==castOther.getFiscalDate()) || ( this.getFiscalDate()!=null && castOther.getFiscalDate()!=null && this.getFiscalDate().equals(castOther.getFiscalDate()) ) )
 && (this.getVehicleSp()==castOther.getVehicleSp())
 && (this.getNotifySp()==castOther.getNotifySp());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFiscalDate() == null ? 0 : this.getFiscalDate().hashCode() );
         result = 37 * result + this.getVehicleSp();
         result = 37 * result + this.getNotifySp();
         return result;
   }   


}

