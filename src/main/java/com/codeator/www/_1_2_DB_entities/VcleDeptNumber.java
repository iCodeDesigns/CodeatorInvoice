package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * VcleDeptNumber generated by hbm2java
 */
@Entity
@Table(name="VCLE_DEPT_NUMBER"
    ,schema="CODEATOR"
)
public class VcleDeptNumber  implements java.io.Serializable {


     private int deptId;
     private String deptName;
     private Set<VcleOilIssue> vcleOilIssues = new HashSet<VcleOilIssue>(0);
     private Set<VcleFuelIssueLiquid> vcleFuelIssueLiquids = new HashSet<VcleFuelIssueLiquid>(0);
     private Set<VcleVehicleIncome> vcleVehicleIncomes = new HashSet<VcleVehicleIncome>(0);
     private Set<VcleDeptNumberJoin> vcleDeptNumberJoins = new HashSet<VcleDeptNumberJoin>(0);
     private Set<VcleDeptNumberUser> vcleDeptNumberUsers = new HashSet<VcleDeptNumberUser>(0);
     private Set<VcleRecordMovementJoin> vcleRecordMovementJoins = new HashSet<VcleRecordMovementJoin>(0);

    public VcleDeptNumber() {
    }

	
    public VcleDeptNumber(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }
    public VcleDeptNumber(int deptId, String deptName, Set<VcleOilIssue> vcleOilIssues, Set<VcleFuelIssueLiquid> vcleFuelIssueLiquids, Set<VcleVehicleIncome> vcleVehicleIncomes, Set<VcleDeptNumberJoin> vcleDeptNumberJoins, Set<VcleDeptNumberUser> vcleDeptNumberUsers, Set<VcleRecordMovementJoin> vcleRecordMovementJoins) {
       this.deptId = deptId;
       this.deptName = deptName;
       this.vcleOilIssues = vcleOilIssues;
       this.vcleFuelIssueLiquids = vcleFuelIssueLiquids;
       this.vcleVehicleIncomes = vcleVehicleIncomes;
       this.vcleDeptNumberJoins = vcleDeptNumberJoins;
       this.vcleDeptNumberUsers = vcleDeptNumberUsers;
       this.vcleRecordMovementJoins = vcleRecordMovementJoins;
    }
   
     @Id 

    
    @Column(name="DEPT_ID", unique=true, nullable=false, precision=7, scale=0)
    public int getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    
    @Column(name="DEPT_NAME", nullable=false, length=200)
    public String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleDeptNumber")
    public Set<VcleOilIssue> getVcleOilIssues() {
        return this.vcleOilIssues;
    }
    
    public void setVcleOilIssues(Set<VcleOilIssue> vcleOilIssues) {
        this.vcleOilIssues = vcleOilIssues;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleDeptNumber")
    public Set<VcleFuelIssueLiquid> getVcleFuelIssueLiquids() {
        return this.vcleFuelIssueLiquids;
    }
    
    public void setVcleFuelIssueLiquids(Set<VcleFuelIssueLiquid> vcleFuelIssueLiquids) {
        this.vcleFuelIssueLiquids = vcleFuelIssueLiquids;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleDeptNumber")
    public Set<VcleVehicleIncome> getVcleVehicleIncomes() {
        return this.vcleVehicleIncomes;
    }
    
    public void setVcleVehicleIncomes(Set<VcleVehicleIncome> vcleVehicleIncomes) {
        this.vcleVehicleIncomes = vcleVehicleIncomes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleDeptNumber")
    public Set<VcleDeptNumberJoin> getVcleDeptNumberJoins() {
        return this.vcleDeptNumberJoins;
    }
    
    public void setVcleDeptNumberJoins(Set<VcleDeptNumberJoin> vcleDeptNumberJoins) {
        this.vcleDeptNumberJoins = vcleDeptNumberJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleDeptNumber")
    public Set<VcleDeptNumberUser> getVcleDeptNumberUsers() {
        return this.vcleDeptNumberUsers;
    }
    
    public void setVcleDeptNumberUsers(Set<VcleDeptNumberUser> vcleDeptNumberUsers) {
        this.vcleDeptNumberUsers = vcleDeptNumberUsers;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleDeptNumber")
    public Set<VcleRecordMovementJoin> getVcleRecordMovementJoins() {
        return this.vcleRecordMovementJoins;
    }
    
    public void setVcleRecordMovementJoins(Set<VcleRecordMovementJoin> vcleRecordMovementJoins) {
        this.vcleRecordMovementJoins = vcleRecordMovementJoins;
    }




}


