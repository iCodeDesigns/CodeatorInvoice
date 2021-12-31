package com.codeator.www._1_2_DB_entities;
// Generated Jul 27, 2021 2:00:58 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AppSubElemId generated by hbm2java
 */
@Embeddable
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
   


    @Column(name="APPLICATION_ID", nullable=false, precision=3, scale=0)
    public short getApplicationId() {
        return this.applicationId;
    }
    
    public void setApplicationId(short applicationId) {
        this.applicationId = applicationId;
    }


    @Column(name="TAB_ID", nullable=false, precision=5, scale=0)
    public int getTabId() {
        return this.tabId;
    }
    
    public void setTabId(int tabId) {
        this.tabId = tabId;
    }


    @Column(name="SUB_TAB_ID", nullable=false, precision=8, scale=0)
    public int getSubTabId() {
        return this.subTabId;
    }
    
    public void setSubTabId(int subTabId) {
        this.subTabId = subTabId;
    }


    @Column(name="ELEMENT_ID", nullable=false, precision=5, scale=0)
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

