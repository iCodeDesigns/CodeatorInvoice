package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleVehicleLicenseReportCrId generated by hbm2java
 */
@Embeddable
public class VcleVehicleLicenseReportCrId  implements java.io.Serializable {


     private int reportSp;
     private boolean reportType;
     private Date fiscalDate;
     private int vehicleSp;

    public VcleVehicleLicenseReportCrId() {
    }

    public VcleVehicleLicenseReportCrId(int reportSp, boolean reportType, Date fiscalDate, int vehicleSp) {
       this.reportSp = reportSp;
       this.reportType = reportType;
       this.fiscalDate = fiscalDate;
       this.vehicleSp = vehicleSp;
    }
   


    @Column(name="REPORT_SP", nullable=false, precision=6, scale=0)
    public int getReportSp() {
        return this.reportSp;
    }
    
    public void setReportSp(int reportSp) {
        this.reportSp = reportSp;
    }


    @Column(name="REPORT_TYPE", nullable=false, precision=1, scale=0)
    public boolean isReportType() {
        return this.reportType;
    }
    
    public void setReportType(boolean reportType) {
        this.reportType = reportType;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleLicenseReportCrId) ) return false;
		 VcleVehicleLicenseReportCrId castOther = ( VcleVehicleLicenseReportCrId ) other; 
         
		 return (this.getReportSp()==castOther.getReportSp())
 && (this.isReportType()==castOther.isReportType())
 && ( (this.getFiscalDate()==castOther.getFiscalDate()) || ( this.getFiscalDate()!=null && castOther.getFiscalDate()!=null && this.getFiscalDate().equals(castOther.getFiscalDate()) ) )
 && (this.getVehicleSp()==castOther.getVehicleSp());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getReportSp();
         result = 37 * result + (this.isReportType()?1:0);
         result = 37 * result + ( getFiscalDate() == null ? 0 : this.getFiscalDate().hashCode() );
         result = 37 * result + this.getVehicleSp();
         return result;
   }   


}


