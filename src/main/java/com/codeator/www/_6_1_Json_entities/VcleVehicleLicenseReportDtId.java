package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VcleVehicleLicenseReportDtId generated by hbm2java
 */
public class VcleVehicleLicenseReportDtId  implements java.io.Serializable {


     private boolean reportType;
     private Date fiscalDate;
     private int reportSp;
     private boolean costType;
     private int costCode;

    public VcleVehicleLicenseReportDtId() {
    }

    public VcleVehicleLicenseReportDtId(boolean reportType, Date fiscalDate, int reportSp, boolean costType, int costCode) {
       this.reportType = reportType;
       this.fiscalDate = fiscalDate;
       this.reportSp = reportSp;
       this.costType = costType;
       this.costCode = costCode;
    }
   
    public boolean isReportType() {
        return this.reportType;
    }
    
    public void setReportType(boolean reportType) {
        this.reportType = reportType;
    }
    public Date getFiscalDate() {
        return this.fiscalDate;
    }
    
    public void setFiscalDate(Date fiscalDate) {
        this.fiscalDate = fiscalDate;
    }
    public int getReportSp() {
        return this.reportSp;
    }
    
    public void setReportSp(int reportSp) {
        this.reportSp = reportSp;
    }
    public boolean isCostType() {
        return this.costType;
    }
    
    public void setCostType(boolean costType) {
        this.costType = costType;
    }
    public int getCostCode() {
        return this.costCode;
    }
    
    public void setCostCode(int costCode) {
        this.costCode = costCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleLicenseReportDtId) ) return false;
		 VcleVehicleLicenseReportDtId castOther = ( VcleVehicleLicenseReportDtId ) other; 
         
		 return (this.isReportType()==castOther.isReportType())
 && ( (this.getFiscalDate()==castOther.getFiscalDate()) || ( this.getFiscalDate()!=null && castOther.getFiscalDate()!=null && this.getFiscalDate().equals(castOther.getFiscalDate()) ) )
 && (this.getReportSp()==castOther.getReportSp())
 && (this.isCostType()==castOther.isCostType())
 && (this.getCostCode()==castOther.getCostCode());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (this.isReportType()?1:0);
         result = 37 * result + ( getFiscalDate() == null ? 0 : this.getFiscalDate().hashCode() );
         result = 37 * result + this.getReportSp();
         result = 37 * result + (this.isCostType()?1:0);
         result = 37 * result + this.getCostCode();
         return result;
   }   


}


