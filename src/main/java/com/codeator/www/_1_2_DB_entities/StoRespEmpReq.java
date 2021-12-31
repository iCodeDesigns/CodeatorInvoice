package com.codeator.www._1_2_DB_entities;
// Generated Mar 21, 2021 6:34:02 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * StoRespEmpReq generated by hbm2java
 */
@Entity
@Table(name="STO_RESP_EMP_REQ"
    ,schema="CODEATOR"
)
public class StoRespEmpReq  implements java.io.Serializable {


     private long employeeId;
     private PerEmploymentMaster perEmploymentMaster;
     private String reqDate;
     private String employeeNo;
     private Boolean reqStatus;

    public StoRespEmpReq() {
    }

	
    public StoRespEmpReq(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }
    public StoRespEmpReq(PerEmploymentMaster perEmploymentMaster, String reqDate, String employeeNo, Boolean reqStatus) {
       this.perEmploymentMaster = perEmploymentMaster;
       this.reqDate = reqDate;
       this.employeeNo = employeeNo;
       this.reqStatus = reqStatus;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="perEmploymentMaster"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="EMPLOYEE_ID", unique=true, nullable=false, precision=10, scale=0)
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

@OneToOne(fetch=FetchType.EAGER)@PrimaryKeyJoinColumn
    public PerEmploymentMaster getPerEmploymentMaster() {
        return this.perEmploymentMaster;
    }
    
    public void setPerEmploymentMaster(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }

    
    @Column(name="REQ_DATE", length=20)
    public String getReqDate() {
        return this.reqDate;
    }
    
    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    
    @Column(name="EMPLOYEE_NO", length=10)
    public String getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    
    @Column(name="REQ_STATUS", precision=1, scale=0)
    public Boolean getReqStatus() {
        return this.reqStatus;
    }
    
    public void setReqStatus(Boolean reqStatus) {
        this.reqStatus = reqStatus;
    }




}


