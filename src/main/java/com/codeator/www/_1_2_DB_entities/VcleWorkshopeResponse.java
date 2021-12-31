package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * VcleWorkshopeResponse generated by hbm2java
 */
@Entity
@Table(name="VCLE_WORKSHOPE_RESPONSE"
    ,schema="CODEATOR"
)
public class VcleWorkshopeResponse  implements java.io.Serializable {


     private VcleWorkshopeResponseId id;
     private VcleWorkshopeCode vcleWorkshopeCode;
     private VcleVehicleType vcleVehicleType;
     private VcleEmployeeMaster vcleEmployeeMaster;
     private Boolean chkVcleType;
     private Set<VcleVehicleInstruction> vcleVehicleInstructions = new HashSet<VcleVehicleInstruction>(0);
     private Set<VcleVehicleResponsibleJoin> vcleVehicleResponsibleJoins = new HashSet<VcleVehicleResponsibleJoin>(0);

    public VcleWorkshopeResponse() {
    }

	
    public VcleWorkshopeResponse(VcleWorkshopeResponseId id, VcleWorkshopeCode vcleWorkshopeCode, VcleEmployeeMaster vcleEmployeeMaster) {
        this.id = id;
        this.vcleWorkshopeCode = vcleWorkshopeCode;
        this.vcleEmployeeMaster = vcleEmployeeMaster;
    }
    public VcleWorkshopeResponse(VcleWorkshopeResponseId id, VcleWorkshopeCode vcleWorkshopeCode, VcleVehicleType vcleVehicleType, VcleEmployeeMaster vcleEmployeeMaster, Boolean chkVcleType, Set<VcleVehicleInstruction> vcleVehicleInstructions, Set<VcleVehicleResponsibleJoin> vcleVehicleResponsibleJoins) {
       this.id = id;
       this.vcleWorkshopeCode = vcleWorkshopeCode;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleEmployeeMaster = vcleEmployeeMaster;
       this.chkVcleType = chkVcleType;
       this.vcleVehicleInstructions = vcleVehicleInstructions;
       this.vcleVehicleResponsibleJoins = vcleVehicleResponsibleJoins;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="workshopeCode", column=@Column(name="WORKSHOPE_CODE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0) ) } )
    public VcleWorkshopeResponseId getId() {
        return this.id;
    }
    
    public void setId(VcleWorkshopeResponseId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="WORKSHOPE_CODE", nullable=false, insertable=false, updatable=false)
    public VcleWorkshopeCode getVcleWorkshopeCode() {
        return this.vcleWorkshopeCode;
    }
    
    public void setVcleWorkshopeCode(VcleWorkshopeCode vcleWorkshopeCode) {
        this.vcleWorkshopeCode = vcleWorkshopeCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VCLE_TYPE")
    public VcleVehicleType getVcleVehicleType() {
        return this.vcleVehicleType;
    }
    
    public void setVcleVehicleType(VcleVehicleType vcleVehicleType) {
        this.vcleVehicleType = vcleVehicleType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public VcleEmployeeMaster getVcleEmployeeMaster() {
        return this.vcleEmployeeMaster;
    }
    
    public void setVcleEmployeeMaster(VcleEmployeeMaster vcleEmployeeMaster) {
        this.vcleEmployeeMaster = vcleEmployeeMaster;
    }

    
    @Column(name="CHK_VCLE_TYPE", precision=1, scale=0)
    public Boolean getChkVcleType() {
        return this.chkVcleType;
    }
    
    public void setChkVcleType(Boolean chkVcleType) {
        this.chkVcleType = chkVcleType;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleWorkshopeResponse")
    public Set<VcleVehicleInstruction> getVcleVehicleInstructions() {
        return this.vcleVehicleInstructions;
    }
    
    public void setVcleVehicleInstructions(Set<VcleVehicleInstruction> vcleVehicleInstructions) {
        this.vcleVehicleInstructions = vcleVehicleInstructions;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleWorkshopeResponse")
    public Set<VcleVehicleResponsibleJoin> getVcleVehicleResponsibleJoins() {
        return this.vcleVehicleResponsibleJoins;
    }
    
    public void setVcleVehicleResponsibleJoins(Set<VcleVehicleResponsibleJoin> vcleVehicleResponsibleJoins) {
        this.vcleVehicleResponsibleJoins = vcleVehicleResponsibleJoins;
    }




}

