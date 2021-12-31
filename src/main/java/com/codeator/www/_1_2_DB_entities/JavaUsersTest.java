package com.codeator.www._1_2_DB_entities;
// Generated Jun 21, 2021 11:28:26 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JavaUsersTest generated by hbm2java
 */
@Entity
@Table(name="JAVA_USERS_TEST"
    ,schema="CODEATOR"
)
public class JavaUsersTest  implements java.io.Serializable {


     private String employeeId;
     private String rmrk;

    public JavaUsersTest() {
    }

	
    public JavaUsersTest(String employeeId) {
        this.employeeId = employeeId;
    }
    public JavaUsersTest(String employeeId, String rmrk) {
       this.employeeId = employeeId;
       this.rmrk = rmrk;
    }
   
     @Id 

    
    @Column(name="EMPLOYEE_ID", unique=true, nullable=false, length=10)
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    
    @Column(name="RMRK", length=20)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }




}

