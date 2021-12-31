package com.codeator.www._1_2_DB_entities;
// Generated Jul 27, 2021 2:00:58 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AppSubTabSpecAuthId generated by hbm2java
 */
@Embeddable
public class AppSubTabSpecAuthId  implements java.io.Serializable {


     private int subTabId;
     private long employeeId;
     private short applicationId;
     private int tabId;

    public AppSubTabSpecAuthId() {
    }

    public AppSubTabSpecAuthId(int subTabId, long employeeId, short applicationId, int tabId) {
       this.subTabId = subTabId;
       this.employeeId = employeeId;
       this.applicationId = applicationId;
       this.tabId = tabId;
    }
   


    @Column(name="SUB_TAB_ID", nullable=false, precision=8, scale=0)
    public int getSubTabId() {
        return this.subTabId;
    }
    
    public void setSubTabId(int subTabId) {
        this.subTabId = subTabId;
    }


    @Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0)
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AppSubTabSpecAuthId) ) return false;
		 AppSubTabSpecAuthId castOther = ( AppSubTabSpecAuthId ) other; 
         
		 return (this.getSubTabId()==castOther.getSubTabId())
 && (this.getEmployeeId()==castOther.getEmployeeId())
 && (this.getApplicationId()==castOther.getApplicationId())
 && (this.getTabId()==castOther.getTabId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSubTabId();
         result = 37 * result + (int) this.getEmployeeId();
         result = 37 * result + this.getApplicationId();
         result = 37 * result + this.getTabId();
         return result;
   }   


}

