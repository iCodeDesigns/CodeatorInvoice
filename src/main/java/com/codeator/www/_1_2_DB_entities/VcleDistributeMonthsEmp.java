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
 * VcleDistributeMonthsEmp generated by hbm2java
 */
@Entity
@Table(name="VCLE_DISTRIBUTE_MONTHS_EMP"
    ,schema="CODEATOR"
)
public class VcleDistributeMonthsEmp  implements java.io.Serializable {


     private VcleDistributeMonthsEmpId id;
     private VcleEmployeeMaster vcleEmployeeMaster;
     private VcleDistributeLocation vcleDistributeLocation;
     private BigDecimal valAllLoc;
     private Short ccLoc;
     private Boolean chkPrnt;

    public VcleDistributeMonthsEmp() {
    }

	
    public VcleDistributeMonthsEmp(VcleDistributeMonthsEmpId id, VcleEmployeeMaster vcleEmployeeMaster, VcleDistributeLocation vcleDistributeLocation) {
        this.id = id;
        this.vcleEmployeeMaster = vcleEmployeeMaster;
        this.vcleDistributeLocation = vcleDistributeLocation;
    }
    public VcleDistributeMonthsEmp(VcleDistributeMonthsEmpId id, VcleEmployeeMaster vcleEmployeeMaster, VcleDistributeLocation vcleDistributeLocation, BigDecimal valAllLoc, Short ccLoc, Boolean chkPrnt) {
       this.id = id;
       this.vcleEmployeeMaster = vcleEmployeeMaster;
       this.vcleDistributeLocation = vcleDistributeLocation;
       this.valAllLoc = valAllLoc;
       this.ccLoc = ccLoc;
       this.chkPrnt = chkPrnt;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="fiscalYear", column=@Column(name="FISCAL_YEAR", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="execMm", column=@Column(name="EXEC_MM", nullable=false, length=7) ), 
        @AttributeOverride(name="distributeCode", column=@Column(name="DISTRIBUTE_CODE", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="ahramType", column=@Column(name="AHRAM_TYPE", nullable=false, precision=1, scale=0) ) } )
    public VcleDistributeMonthsEmpId getId() {
        return this.id;
    }
    
    public void setId(VcleDistributeMonthsEmpId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public VcleEmployeeMaster getVcleEmployeeMaster() {
        return this.vcleEmployeeMaster;
    }
    
    public void setVcleEmployeeMaster(VcleEmployeeMaster vcleEmployeeMaster) {
        this.vcleEmployeeMaster = vcleEmployeeMaster;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="DISTRIBUTE_CODE", nullable=false, insertable=false, updatable=false)
    public VcleDistributeLocation getVcleDistributeLocation() {
        return this.vcleDistributeLocation;
    }
    
    public void setVcleDistributeLocation(VcleDistributeLocation vcleDistributeLocation) {
        this.vcleDistributeLocation = vcleDistributeLocation;
    }

    
    @Column(name="VAL_ALL_LOC", precision=11)
    public BigDecimal getValAllLoc() {
        return this.valAllLoc;
    }
    
    public void setValAllLoc(BigDecimal valAllLoc) {
        this.valAllLoc = valAllLoc;
    }

    
    @Column(name="CC_LOC", precision=4, scale=0)
    public Short getCcLoc() {
        return this.ccLoc;
    }
    
    public void setCcLoc(Short ccLoc) {
        this.ccLoc = ccLoc;
    }

    
    @Column(name="CHK_PRNT", precision=1, scale=0)
    public Boolean getChkPrnt() {
        return this.chkPrnt;
    }
    
    public void setChkPrnt(Boolean chkPrnt) {
        this.chkPrnt = chkPrnt;
    }




}

