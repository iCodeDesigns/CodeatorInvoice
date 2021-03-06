package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * AppSubElemId generated by hbm2java
 */
public class AppSubElemId  implements java.io.Serializable {


     private short applicationId;
     private int tabId;
     private int subTabId;
     private int elementId;

    public AppSubElemId() {
    }

    public AppSubElemId(short applicationId, int tabId, int subTabId, int elementId) {
       this.applicationId = applicationId;
       this.tabId = tabId;
       this.subTabId = subTabId;
       this.elementId = elementId;
    }
   
    public short getApplicationId() {
        return this.applicationId;
    }
    
    public void setApplicationId(short applicationId) {
        this.applicationId = applicationId;
    }
    public int getTabId() {
        return this.tabId;
    }
    
    public void setTabId(int tabId) {
        this.tabId = tabId;
    }
    public int getSubTabId() {
        return this.subTabId;
    }
    
    public void setSubTabId(int subTabId) {
        this.subTabId = subTabId;
    }
    public int getElementId() {
        return this.elementId;
    }
    
    public void setElementId(int elementId) {
        this.elementId = elementId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AppSubElemId) ) return false;
		 AppSubElemId castOther = ( AppSubElemId ) other; 
         
		 return (this.getApplicationId()==castOther.getApplicationId())
 && (this.getTabId()==castOther.getTabId())
 && (this.getSubTabId()==castOther.getSubTabId())
 && (this.getElementId()==castOther.getElementId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getApplicationId();
         result = 37 * result + this.getTabId();
         result = 37 * result + this.getSubTabId();
         result = 37 * result + this.getElementId();
         return result;
   }   


}


