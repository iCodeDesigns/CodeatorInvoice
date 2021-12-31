package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * VcleDataEntryAdminId generated by hbm2java
 */
public class VcleDataEntryAdminId  implements java.io.Serializable {


     private byte appAdminType;
     private long employeeNo;

    public VcleDataEntryAdminId() {
    }

    public VcleDataEntryAdminId(byte appAdminType, long employeeNo) {
       this.appAdminType = appAdminType;
       this.employeeNo = employeeNo;
    }
   
    public byte getAppAdminType() {
        return this.appAdminType;
    }
    
    public void setAppAdminType(byte appAdminType) {
        this.appAdminType = appAdminType;
    }
    public long getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(long employeeNo) {
        this.employeeNo = employeeNo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleDataEntryAdminId) ) return false;
		 VcleDataEntryAdminId castOther = ( VcleDataEntryAdminId ) other; 
         
		 return (this.getAppAdminType()==castOther.getAppAdminType())
 && (this.getEmployeeNo()==castOther.getEmployeeNo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getAppAdminType();
         result = 37 * result + (int) this.getEmployeeNo();
         return result;
   }   


}


