package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * AccAccountUnits generated by hbm2java
 */
public class AccAccountUnits  implements java.io.Serializable {


     private String accountUnitCode;
     private String accountUnitName;
     private boolean reviewFlag;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private boolean accountUnitMain;

    public AccAccountUnits() {
    }

	
    public AccAccountUnits(String accountUnitCode, String accountUnitName, boolean reviewFlag, boolean accountUnitMain) {
        this.accountUnitCode = accountUnitCode;
        this.accountUnitName = accountUnitName;
        this.reviewFlag = reviewFlag;
        this.accountUnitMain = accountUnitMain;
    }
    public AccAccountUnits(String accountUnitCode, String accountUnitName, boolean reviewFlag, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, boolean accountUnitMain) {
       this.accountUnitCode = accountUnitCode;
       this.accountUnitName = accountUnitName;
       this.reviewFlag = reviewFlag;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.accountUnitMain = accountUnitMain;
    }
   
    public String getAccountUnitCode() {
        return this.accountUnitCode;
    }
    
    public void setAccountUnitCode(String accountUnitCode) {
        this.accountUnitCode = accountUnitCode;
    }
    public String getAccountUnitName() {
        return this.accountUnitName;
    }
    
    public void setAccountUnitName(String accountUnitName) {
        this.accountUnitName = accountUnitName;
    }
    public boolean isReviewFlag() {
        return this.reviewFlag;
    }
    
    public void setReviewFlag(boolean reviewFlag) {
        this.reviewFlag = reviewFlag;
    }
    public String getRecordCreateUser() {
        return this.recordCreateUser;
    }
    
    public void setRecordCreateUser(String recordCreateUser) {
        this.recordCreateUser = recordCreateUser;
    }
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }
    public String getRecordUpdateUser() {
        return this.recordUpdateUser;
    }
    
    public void setRecordUpdateUser(String recordUpdateUser) {
        this.recordUpdateUser = recordUpdateUser;
    }
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }
    public boolean isAccountUnitMain() {
        return this.accountUnitMain;
    }
    
    public void setAccountUnitMain(boolean accountUnitMain) {
        this.accountUnitMain = accountUnitMain;
    }




}


