package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleVehicleInstructionItemId generated by hbm2java
 */
@Embeddable
public class VcleVehicleInstructionItemId  implements java.io.Serializable {


     private int suspendSp;
     private Date fiscalDate;
     private int instructionNo;
     private byte workshopeCode;
     private long employeeId;
     private int vehicleSp;
     private int itemSp;

    public VcleVehicleInstructionItemId() {
    }

    public VcleVehicleInstructionItemId(int suspendSp, Date fiscalDate, int instructionNo, byte workshopeCode, long employeeId, int vehicleSp, int itemSp) {
       this.suspendSp = suspendSp;
       this.fiscalDate = fiscalDate;
       this.instructionNo = instructionNo;
       this.workshopeCode = workshopeCode;
       this.employeeId = employeeId;
       this.vehicleSp = vehicleSp;
       this.itemSp = itemSp;
    }
   


    @Column(name="SUSPEND_SP", nullable=false, precision=6, scale=0)
    public int getSuspendSp() {
        return this.suspendSp;
    }
    
    public void setSuspendSp(int suspendSp) {
        this.suspendSp = suspendSp;
    }


    @Column(name="FISCAL_DATE", nullable=false, length=7)
    public Date getFiscalDate() {
        return this.fiscalDate;
    }
    
    public void setFiscalDate(Date fiscalDate) {
        this.fiscalDate = fiscalDate;
    }


    @Column(name="INSTRUCTION_NO", nullable=false, precision=6, scale=0)
    public int getInstructionNo() {
        return this.instructionNo;
    }
    
    public void setInstructionNo(int instructionNo) {
        this.instructionNo = instructionNo;
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


    @Column(name="VEHICLE_SP", nullable=false, precision=6, scale=0)
    public int getVehicleSp() {
        return this.vehicleSp;
    }
    
    public void setVehicleSp(int vehicleSp) {
        this.vehicleSp = vehicleSp;
    }


    @Column(name="ITEM_SP", nullable=false, precision=6, scale=0)
    public int getItemSp() {
        return this.itemSp;
    }
    
    public void setItemSp(int itemSp) {
        this.itemSp = itemSp;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleVehicleInstructionItemId) ) return false;
		 VcleVehicleInstructionItemId castOther = ( VcleVehicleInstructionItemId ) other; 
         
		 return (this.getSuspendSp()==castOther.getSuspendSp())
 && ( (this.getFiscalDate()==castOther.getFiscalDate()) || ( this.getFiscalDate()!=null && castOther.getFiscalDate()!=null && this.getFiscalDate().equals(castOther.getFiscalDate()) ) )
 && (this.getInstructionNo()==castOther.getInstructionNo())
 && (this.getWorkshopeCode()==castOther.getWorkshopeCode())
 && (this.getEmployeeId()==castOther.getEmployeeId())
 && (this.getVehicleSp()==castOther.getVehicleSp())
 && (this.getItemSp()==castOther.getItemSp());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSuspendSp();
         result = 37 * result + ( getFiscalDate() == null ? 0 : this.getFiscalDate().hashCode() );
         result = 37 * result + this.getInstructionNo();
         result = 37 * result + this.getWorkshopeCode();
         result = 37 * result + (int) this.getEmployeeId();
         result = 37 * result + this.getVehicleSp();
         result = 37 * result + this.getItemSp();
         return result;
   }   


}

