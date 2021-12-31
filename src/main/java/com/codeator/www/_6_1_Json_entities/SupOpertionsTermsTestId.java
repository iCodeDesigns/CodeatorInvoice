package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * SupOpertionsTermsTestId generated by hbm2java
 */
public class SupOpertionsTermsTestId  implements java.io.Serializable {


     private int supplierId;
     private int operationId;
     private int termId;

    public SupOpertionsTermsTestId() {
    }

    public SupOpertionsTermsTestId(int supplierId, int operationId, int termId) {
       this.supplierId = supplierId;
       this.operationId = operationId;
       this.termId = termId;
    }
   
    public int getSupplierId() {
        return this.supplierId;
    }
    
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    public int getOperationId() {
        return this.operationId;
    }
    
    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }
    public int getTermId() {
        return this.termId;
    }
    
    public void setTermId(int termId) {
        this.termId = termId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SupOpertionsTermsTestId) ) return false;
		 SupOpertionsTermsTestId castOther = ( SupOpertionsTermsTestId ) other; 
         
		 return (this.getSupplierId()==castOther.getSupplierId())
 && (this.getOperationId()==castOther.getOperationId())
 && (this.getTermId()==castOther.getTermId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSupplierId();
         result = 37 * result + this.getOperationId();
         result = 37 * result + this.getTermId();
         return result;
   }   


}


