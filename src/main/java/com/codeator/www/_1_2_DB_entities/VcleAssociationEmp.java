package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * VcleAssociationEmp generated by hbm2java
 */
@Entity
@Table(name="VCLE_ASSOCIATION_EMP"
    ,schema="CODEATOR"
)
public class VcleAssociationEmp  implements java.io.Serializable {


     private long employeeId;
     private VcleTrafficLine vcleTrafficLine;
     private VcleExecutionDate vcleExecutionDate;
     private PerEmploymentParameter perEmploymentParameter;
     private PerEmploymentMaster perEmploymentMaster;
     private boolean methodType;
     private Long employeeNo;
     private Boolean statusType;
     private Byte memValue;
     private String rmrk;
     private String recordCreateUser;
     private String recordUpdateUser;
     private Date recordCreateDate;
     private Date recordUpdateDate;
     private Integer telWork;
     private String cellPhone;
     private Boolean chkHistory;
     private Set<VcleAssociationEmpTrans> vcleAssociationEmpTranses = new HashSet<VcleAssociationEmpTrans>(0);

    public VcleAssociationEmp() {
    }

	
    public VcleAssociationEmp(PerEmploymentMaster perEmploymentMaster, boolean methodType) {
        this.perEmploymentMaster = perEmploymentMaster;
        this.methodType = methodType;
    }
    public VcleAssociationEmp(VcleTrafficLine vcleTrafficLine, VcleExecutionDate vcleExecutionDate, PerEmploymentParameter perEmploymentParameter, PerEmploymentMaster perEmploymentMaster, boolean methodType, Long employeeNo, Boolean statusType, Byte memValue, String rmrk, String recordCreateUser, String recordUpdateUser, Date recordCreateDate, Date recordUpdateDate, Integer telWork, String cellPhone, Boolean chkHistory, Set<VcleAssociationEmpTrans> vcleAssociationEmpTranses) {
       this.vcleTrafficLine = vcleTrafficLine;
       this.vcleExecutionDate = vcleExecutionDate;
       this.perEmploymentParameter = perEmploymentParameter;
       this.perEmploymentMaster = perEmploymentMaster;
       this.methodType = methodType;
       this.employeeNo = employeeNo;
       this.statusType = statusType;
       this.memValue = memValue;
       this.rmrk = rmrk;
       this.recordCreateUser = recordCreateUser;
       this.recordUpdateUser = recordUpdateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateDate = recordUpdateDate;
       this.telWork = telWork;
       this.cellPhone = cellPhone;
       this.chkHistory = chkHistory;
       this.vcleAssociationEmpTranses = vcleAssociationEmpTranses;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="perEmploymentMaster"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0)
    public long getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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
    @JoinColumn(name="EXEC_MM")
    public VcleExecutionDate getVcleExecutionDate() {
        return this.vcleExecutionDate;
    }
    
    public void setVcleExecutionDate(VcleExecutionDate vcleExecutionDate) {
        this.vcleExecutionDate = vcleExecutionDate;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYMENT_SOURCE_CODE")
    public PerEmploymentParameter getPerEmploymentParameter() {
        return this.perEmploymentParameter;
    }
    
    public void setPerEmploymentParameter(PerEmploymentParameter perEmploymentParameter) {
        this.perEmploymentParameter = perEmploymentParameter;
    }

@OneToOne(fetch=FetchType.EAGER)@PrimaryKeyJoinColumn
    public PerEmploymentMaster getPerEmploymentMaster() {
        return this.perEmploymentMaster;
    }
    
    public void setPerEmploymentMaster(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }

    
    @Column(name="METHOD_TYPE", nullable=false, precision=1, scale=0)
    public boolean isMethodType() {
        return this.methodType;
    }
    
    public void setMethodType(boolean methodType) {
        this.methodType = methodType;
    }

    
    @Column(name="EMPLOYEE_NO", precision=10, scale=0)
    public Long getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(Long employeeNo) {
        this.employeeNo = employeeNo;
    }

    
    @Column(name="STATUS_TYPE", precision=1, scale=0)
    public Boolean getStatusType() {
        return this.statusType;
    }
    
    public void setStatusType(Boolean statusType) {
        this.statusType = statusType;
    }

    
    @Column(name="MEM_VALUE", precision=2, scale=0)
    public Byte getMemValue() {
        return this.memValue;
    }
    
    public void setMemValue(Byte memValue) {
        this.memValue = memValue;
    }

    
    @Column(name="RMRK", length=100)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    
    @Column(name="RECORD_CREATE_USER", length=15)
    public String getRecordCreateUser() {
        return this.recordCreateUser;
    }
    
    public void setRecordCreateUser(String recordCreateUser) {
        this.recordCreateUser = recordCreateUser;
    }

    
    @Column(name="RECORD_UPDATE_USER", length=15)
    public String getRecordUpdateUser() {
        return this.recordUpdateUser;
    }
    
    public void setRecordUpdateUser(String recordUpdateUser) {
        this.recordUpdateUser = recordUpdateUser;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_CREATE_DATE", length=7)
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_UPDATE_DATE", length=7)
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }

    
    @Column(name="TEL_WORK", precision=5, scale=0)
    public Integer getTelWork() {
        return this.telWork;
    }
    
    public void setTelWork(Integer telWork) {
        this.telWork = telWork;
    }

    
    @Column(name="CELL_PHONE", length=12)
    public String getCellPhone() {
        return this.cellPhone;
    }
    
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    
    @Column(name="CHK_HISTORY", precision=1, scale=0)
    public Boolean getChkHistory() {
        return this.chkHistory;
    }
    
    public void setChkHistory(Boolean chkHistory) {
        this.chkHistory = chkHistory;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleAssociationEmp")
    public Set<VcleAssociationEmpTrans> getVcleAssociationEmpTranses() {
        return this.vcleAssociationEmpTranses;
    }
    
    public void setVcleAssociationEmpTranses(Set<VcleAssociationEmpTrans> vcleAssociationEmpTranses) {
        this.vcleAssociationEmpTranses = vcleAssociationEmpTranses;
    }




}


