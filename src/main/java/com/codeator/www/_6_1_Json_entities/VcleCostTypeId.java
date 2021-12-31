package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * VcleCostTypeId generated by hbm2java
 */
public class VcleCostTypeId  implements java.io.Serializable {


     private boolean costType;
     private int costCode;

    public VcleCostTypeId() {
    }

    public VcleCostTypeId(boolean costType, int costCode) {
       this.costType = costType;
       this.costCode = costCode;
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
		 if ( !(other instanceof VcleCostTypeId) ) return false;
		 VcleCostTypeId castOther = ( VcleCostTypeId ) other; 
         
		 return (this.isCostType()==castOther.isCostType())
 && (this.getCostCode()==castOther.getCostCode());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (this.isCostType()?1:0);
         result = 37 * result + this.getCostCode();
         return result;
   }   


}


