package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * AppAuthJavaUsers generated by hbm2java
 */
public class AppAuthJavaUsers  implements java.io.Serializable {


     private long employeeId;
     private PerEmploymentMaster perEmploymentMaster;
     private String employeePassword;
     private String employeeEmail;
     private String updateIpAddress;
     private String rmrk;
     private String passwordResetStatus;

    public AppAuthJavaUsers() {
    }

	
    public AppAuthJavaUsers(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }
    public AppAuthJavaUsers(PerEmploymentMaster perEmploymentMaster, String employeePassword, String employeeEmail, String updateIpAddress, String rmrk, String passwordResetStatus) {
       this.perEmploymentMaster = perEmploymentMaster;
       this.employeePassword = employeePassword;
       this.employeeEmail = employeeEmail;
       this.updateIpAddress = updateIpAddress;
       this.rmrk = rmrk;
       this.passwordResetStatus = passwordResetStatus;
    }
   
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public PerEmploymentMaster getPerEmploymentMaster() {
        return this.perEmploymentMaster;
    }
    
    public void setPerEmploymentMaster(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }
    public String getEmployeePassword() {
        return this.employeePassword;
    }
    
    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
    public String getEmployeeEmail() {
        return this.employeeEmail;
    }
    
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
    public String getUpdateIpAddress() {
        return this.updateIpAddress;
    }
    
    public void setUpdateIpAddress(String updateIpAddress) {
        this.updateIpAddress = updateIpAddress;
    }
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }
    public String getPasswordResetStatus() {
        return this.passwordResetStatus;
    }
    
    public void setPasswordResetStatus(String passwordResetStatus) {
        this.passwordResetStatus = passwordResetStatus;
    }




}

