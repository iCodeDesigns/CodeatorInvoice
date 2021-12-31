package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * VcleWorkOnSaturdayEmp generated by hbm2java
 */
@Entity
@Table(name="VCLE_WORK_ON_SATURDAY_EMP"
    ,schema="CODEATOR"
)
public class VcleWorkOnSaturdayEmp  implements java.io.Serializable {


     private long employeeId;
     private VcleJobType vcleJobType;
     private VcleEmployeeMaster vcleEmployeeMaster;
     private Short cardNo;

    public VcleWorkOnSaturdayEmp() {
    }

	
    public VcleWorkOnSaturdayEmp(VcleEmployeeMaster vcleEmployeeMaster) {
        this.vcleEmployeeMaster = vcleEmployeeMaster;
    }
    public VcleWorkOnSaturdayEmp(VcleJobType vcleJobType, VcleEmployeeMaster vcleEmployeeMaster, Short cardNo) {
       this.vcleJobType = vcleJobType;
       this.vcleEmployeeMaster = vcleEmployeeMaster;
       this.cardNo = cardNo;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="vcleEmployeeMaster"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0)
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="JOB_TYPE")
    public VcleJobType getVcleJobType() {
        return this.vcleJobType;
    }
    
    public void setVcleJobType(VcleJobType vcleJobType) {
        this.vcleJobType = vcleJobType;
    }

@OneToOne(fetch=FetchType.EAGER)@PrimaryKeyJoinColumn
    public VcleEmployeeMaster getVcleEmployeeMaster() {
        return this.vcleEmployeeMaster;
    }
    
    public void setVcleEmployeeMaster(VcleEmployeeMaster vcleEmployeeMaster) {
        this.vcleEmployeeMaster = vcleEmployeeMaster;
    }

    
    @Column(name="CARD_NO", precision=4, scale=0)
    public Short getCardNo() {
        return this.cardNo;
    }
    
    public void setCardNo(Short cardNo) {
        this.cardNo = cardNo;
    }




}


