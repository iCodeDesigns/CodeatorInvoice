package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * SupPurchasingOperationsTestId generated by hbm2java
 */
public class SupPurchasingOperationsTestId  implements java.io.Serializable {


     private int supplierId;
     private int operationId;

    public SupPurchasingOperationsTestId() {
    }

    public SupPurchasingOperationsTestId(int supplierId, int operationId) {
       this.supplierId = supplierId;
       this.operationId = operationId;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SupPurchasingOperationsTestId) ) return false;
		 SupPurchasingOperationsTestId castOther = ( SupPurchasingOperationsTestId ) other; 
         
		 return (this.getSupplierId()==castOther.getSupplierId())
 && (this.getOperationId()==castOther.getOperationId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSupplierId();
         result = 37 * result + this.getOperationId();
         return result;
   }   


}


