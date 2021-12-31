package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleAssociationEmpTrans generated by hbm2java
 */
@Entity
@Table(name="VCLE_ASSOCIATION_EMP_TRANS"
    ,schema="CODEATOR"
)
public class VcleAssociationEmpTrans  implements java.io.Serializable {


     private VcleAssociationEmpTransId id;
     private VcleTransactionType vcleTransactionType;
     private VcleTrafficLine vcleTrafficLine;
     private VcleExecutionDate vcleExecutionDate;
     private VcleAssociationEmp vcleAssociationEmp;
     private Long employeeNo;
     private Date transDate;
     private BigDecimal val;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;

    public VcleAssociationEmpTrans() {
    }

	
    public VcleAssociationEmpTrans(VcleAssociationEmpTransId id, VcleTransactionType vcleTransactionType, VcleExecutionDate vcleExecutionDate, VcleAssociationEmp vcleAssociationEmp) {
        this.id = id;
        this.vcleTransactionType = vcleTransactionType;
        this.vcleExecutionDate = vcleExecutionDate;
        this.vcleAssociationEmp = vcleAssociationEmp;
    }
    public VcleAssociationEmpTrans(VcleAssociationEmpTransId id, VcleTransactionType vcleTransactionType, VcleTrafficLine vcleTrafficLine, VcleExecutionDate vcleExecutionDate, VcleAssociationEmp vcleAssociationEmp, Long employeeNo, Date transDate, BigDecimal val, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate) {
       this.id = id;
       this.vcleTransactionType = vcleTransactionType;
       this.vcleTrafficLine = vcleTrafficLine;
       this.vcleExecutionDate = vcleExecutionDate;
       this.vcleAssociationEmp = vcleAssociationEmp;
       this.employeeNo = employeeNo;
       this.transDate = transDate;
       this.val = val;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="execMm", column=@Column(name="EXEC_MM", nullable=false, length=7) ) } )
    public VcleAssociationEmpTransId getId() {
        return this.id;
    }
    
    public void setId(VcleAssociationEmpTransId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="TRANS_TYPE", nullable=false)
    public VcleTransactionType getVcleTransactionType() {
        return this.vcleTransactionType;
    }
    
    public void setVcleTransactionType(VcleTransactionType vcleTransactionType) {
        this.vcleTransactionType = vcleTransactionType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="LINE_CODE")
    public VcleTrafficLine getVcleTrafficLine() {
        return this.vcleTrafficLine;
    }
    
    public void setVcleTrafficLine(VcleTrafficLine vcleTrafficLine) {
        this.vcleTrafficLine = vcleTrafficLine;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EXEC_MM", nullable=false, insertable=false, updatable=false)
    public VcleExecutionDate getVcleExecutionDate() {
        return this.vcleExecutionDate;
    }
    
    public void setVcleExecutionDate(VcleExecutionDate vcleExecutionDate) {
        this.vcleExecutionDate = vcleExecutionDate;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public VcleAssociationEmp getVcleAssociationEmp() {
        return this.vcleAssociationEmp;
    }
    
    public void setVcleAssociationEmp(VcleAssociationEmp vcleAssociationEmp) {
        this.vcleAssociationEmp = vcleAssociationEmp;
    }

    
    @Column(name="EMPLOYEE_NO", precision=10, scale=0)
    public Long getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(Long employeeNo) {
        this.employeeNo = employeeNo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="TRANS_DATE", length=7)
    public Date getTransDate() {
        return this.transDate;
    }
    
    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    
    @Column(name="VAL", precision=5)
    public BigDecimal getVal() {
        return this.val;
    }
    
    public void setVal(BigDecimal val) {
        this.val = val;
    }

    
    @Column(name="RECORD_CREATE_USER", length=15)
    public String getRecordCreateUser() {
        return this.recordCreateUser;
    }
    
    public void setRecordCreateUser(String recordCreateUser) {
        this.recordCreateUser = recordCreateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_CREATE_DATE", length=7)
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }

    
    @Column(name="RECORD_UPDATE_USER", length=15)
    public String getRecordUpdateUser() {
        return this.recordUpdateUser;
    }
    
    public void setRecordUpdateUser(String recordUpdateUser) {
        this.recordUpdateUser = recordUpdateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_UPDATE_DATE", length=7)
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }




}

