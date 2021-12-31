package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * VcleWorkshopeResponseId generated by hbm2java
 */
public class VcleWorkshopeResponseId  implements java.io.Serializable {


     private byte workshopeCode;
     private long employeeId;

    public VcleWorkshopeResponseId() {
    }

    public VcleWorkshopeResponseId(byte workshopeCode, long employeeId) {
       this.workshopeCode = workshopeCode;
       this.employeeId = employeeId;
    }
   
    public byte getWorkshopeCode() {
        return this.workshopeCode;
    }
    
    public void setWorkshopeCode(byte workshopeCode) {
        this.workshopeCode = workshopeCode;
    }
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleWorkshopeResponseId) ) return false;
		 VcleWorkshopeResponseId castOther = ( VcleWorkshopeResponseId ) other; 
         
		 return (this.getWorkshopeCode()==castOther.getWorkshopeCode())
 && (this.getEmployeeId()==castOther.getEmployeeId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getWorkshopeCode();
         result = 37 * result + (int) this.getEmployeeId();
         return result;
   }   


}


