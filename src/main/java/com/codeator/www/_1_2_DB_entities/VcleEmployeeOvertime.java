package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VcleEmployeeOvertime generated by hbm2java
 */
@Entity
@Table(name="VCLE_EMPLOYEE_OVERTIME"
    ,schema="CODEATOR"
)
public class VcleEmployeeOvertime  implements java.io.Serializable {


     private VcleEmployeeOvertimeId id;
     private VcleWorkType vcleWorkType;
     private VcleEmployeeMaster vcleEmployeeMaster;
     private BigDecimal valHour;
     private BigDecimal valHourOk;
     private String rmrk;
     private Boolean chkLock;

    public VcleEmployeeOvertime() {
    }

	
    public VcleEmployeeOvertime(VcleEmployeeOvertimeId id, VcleWorkType vcleWorkType, VcleEmployeeMaster vcleEmployeeMaster) {
        this.id = id;
        this.vcleWorkType = vcleWorkType;
        this.vcleEmployeeMaster = vcleEmployeeMaster;
    }
    public VcleEmployeeOvertime(VcleEmployeeOvertimeId id, VcleWorkType vcleWorkType, VcleEmployeeMaster vcleEmployeeMaster, BigDecimal valHour, BigDecimal valHourOk, String rmrk, Boolean chkLock) {
       this.id = id;
       this.vcleWorkType = vcleWorkType;
       this.vcleEmployeeMaster = vcleEmployeeMaster;
       this.valHour = valHour;
       this.valHourOk = valHourOk;
       this.rmrk = rmrk;
       this.chkLock = chkLock;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="execMm", column=@Column(name="EXEC_MM", nullable=false, length=7) ), 
        @AttributeOverride(name="execDay", column=@Column(name="EXEC_DAY", nullable=false, length=7) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0) ) } )
    public VcleEmployeeOvertimeId getId() {
        return this.id;
    }
    
    public void setId(VcleEmployeeOvertimeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="WORK_TYPE", nullable=false)
    public VcleWorkType getVcleWorkType() {
        return this.vcleWorkType;
    }
    
    public void setVcleWorkType(VcleWorkType vcleWorkType) {
        this.vcleWorkType = vcleWorkType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public VcleEmployeeMaster getVcleEmployeeMaster() {
        return this.vcleEmployeeMaster;
    }
    
    public void setVcleEmployeeMaster(VcleEmployeeMaster vcleEmployeeMaster) {
        this.vcleEmployeeMaster = vcleEmployeeMaster;
    }

    
    @Column(name="VAL_HOUR", precision=4)
    public BigDecimal getValHour() {
        return this.valHour;
    }
    
    public void setValHour(BigDecimal valHour) {
        this.valHour = valHour;
    }

    
    @Column(name="VAL_HOUR_OK", precision=4)
    public BigDecimal getValHourOk() {
        return this.valHourOk;
    }
    
    public void setValHourOk(BigDecimal valHourOk) {
        this.valHourOk = valHourOk;
    }

    
    @Column(name="RMRK", length=150)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    
    @Column(name="CHK_LOCK", precision=1, scale=0)
    public Boolean getChkLock() {
        return this.chkLock;
    }
    
    public void setChkLock(Boolean chkLock) {
        this.chkLock = chkLock;
    }




}


