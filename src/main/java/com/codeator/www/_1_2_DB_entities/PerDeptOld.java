package com.codeator.www._1_2_DB_entities;
// Generated Sep 11, 2021 5:44:32 PM by Hibernate Tools 4.3.1


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
 * PerDeptOld generated by hbm2java
 */
@Entity
@Table(name="PER_DEPT_OLD"
    ,schema="CODEATOR"
)
public class PerDeptOld  implements java.io.Serializable {


     private PerDeptOldId id;
     private PerSectionOld perSectionOld;
     private String depName;
     private Set<VcleDeptRequireMax> vcleDeptRequireMaxes = new HashSet<VcleDeptRequireMax>(0);
     private Set<PurSuppWork> purSuppWorks = new HashSet<PurSuppWork>(0);
     private Set<InvoDeptItemJoin> invoDeptItemJoins = new HashSet<InvoDeptItemJoin>(0);
     private Set<PerDeptPlace> perDeptPlaces = new HashSet<PerDeptPlace>(0);
     private Set<VcleVehicleDriverJoin> vcleVehicleDriverJoins = new HashSet<VcleVehicleDriverJoin>(0);
     private Set<StoResponsibilityDeptDel> stoResponsibilityDeptDels = new HashSet<StoResponsibilityDeptDel>(0);
     private Set<InvoAccUintDept> invoAccUintDepts = new HashSet<InvoAccUintDept>(0);
     private Set<InvoDeptResource> invoDeptResources = new HashSet<InvoDeptResource>(0);
     private Set<VcleVehicleClassDtl> vcleVehicleClassDtls = new HashSet<VcleVehicleClassDtl>(0);
     private Set<VcleVehicleRequire> vcleVehicleRequires = new HashSet<VcleVehicleRequire>(0);
     private Set<StoResponsibilityDept> stoResponsibilityDepts = new HashSet<StoResponsibilityDept>(0);
     private Set<PerEmploymentMaster> perEmploymentMasters = new HashSet<PerEmploymentMaster>(0);
     private Set<VcleRecordMovementJoin> vcleRecordMovementJoins = new HashSet<VcleRecordMovementJoin>(0);
     private Set<VcleVehicleIncome> vcleVehicleIncomes = new HashSet<VcleVehicleIncome>(0);
     private Set<InvoDeptUnitJoin> invoDeptUnitJoins = new HashSet<InvoDeptUnitJoin>(0);
     private Set<InvoDeptTaxJoin> invoDeptTaxJoins = new HashSet<InvoDeptTaxJoin>(0);
     private Set<VcleDeptNumberJoin> vcleDeptNumberJoins = new HashSet<VcleDeptNumberJoin>(0);

    public PerDeptOld() {
    }

	
    public PerDeptOld(PerDeptOldId id, PerSectionOld perSectionOld, String depName) {
        this.id = id;
        this.perSectionOld = perSectionOld;
        this.depName = depName;
    }
    public PerDeptOld(PerDeptOldId id, PerSectionOld perSectionOld, String depName, Set<VcleDeptRequireMax> vcleDeptRequireMaxes, Set<PurSuppWork> purSuppWorks, Set<InvoDeptItemJoin> invoDeptItemJoins, Set<PerDeptPlace> perDeptPlaces, Set<VcleVehicleDriverJoin> vcleVehicleDriverJoins, Set<StoResponsibilityDeptDel> stoResponsibilityDeptDels, Set<InvoAccUintDept> invoAccUintDepts, Set<InvoDeptResource> invoDeptResources, Set<VcleVehicleClassDtl> vcleVehicleClassDtls, Set<VcleVehicleRequire> vcleVehicleRequires, Set<StoResponsibilityDept> stoResponsibilityDepts, Set<PerEmploymentMaster> perEmploymentMasters, Set<VcleRecordMovementJoin> vcleRecordMovementJoins, Set<VcleVehicleIncome> vcleVehicleIncomes, Set<InvoDeptUnitJoin> invoDeptUnitJoins, Set<InvoDeptTaxJoin> invoDeptTaxJoins, Set<VcleDeptNumberJoin> vcleDeptNumberJoins) {
       this.id = id;
       this.perSectionOld = perSectionOld;
       this.depName = depName;
       this.vcleDeptRequireMaxes = vcleDeptRequireMaxes;
       this.purSuppWorks = purSuppWorks;
       this.invoDeptItemJoins = invoDeptItemJoins;
       this.perDeptPlaces = perDeptPlaces;
       this.vcleVehicleDriverJoins = vcleVehicleDriverJoins;
       this.stoResponsibilityDeptDels = stoResponsibilityDeptDels;
       this.invoAccUintDepts = invoAccUintDepts;
       this.invoDeptResources = invoDeptResources;
       this.vcleVehicleClassDtls = vcleVehicleClassDtls;
       this.vcleVehicleRequires = vcleVehicleRequires;
       this.stoResponsibilityDepts = stoResponsibilityDepts;
       this.perEmploymentMasters = perEmploymentMasters;
       this.vcleRecordMovementJoins = vcleRecordMovementJoins;
       this.vcleVehicleIncomes = vcleVehicleIncomes;
       this.invoDeptUnitJoins = invoDeptUnitJoins;
       this.invoDeptTaxJoins = invoDeptTaxJoins;
       this.vcleDeptNumberJoins = vcleDeptNumberJoins;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="sectionNoOld", column=@Column(name="SECTION_NO_OLD", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="depNoOld", column=@Column(name="DEP_NO_OLD", nullable=false, precision=10, scale=0) ) } )
    public PerDeptOldId getId() {
        return this.id;
    }
    
    public void setId(PerDeptOldId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SECTION_NO_OLD", nullable=false, insertable=false, updatable=false)
    public PerSectionOld getPerSectionOld() {
        return this.perSectionOld;
    }
    
    public void setPerSectionOld(PerSectionOld perSectionOld) {
        this.perSectionOld = perSectionOld;
    }

    
    @Column(name="DEP_NAME", nullable=false, length=100)
    public String getDepName() {
        return this.depName;
    }
    
    public void setDepName(String depName) {
        this.depName = depName;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<VcleDeptRequireMax> getVcleDeptRequireMaxes() {
        return this.vcleDeptRequireMaxes;
    }
    
    public void setVcleDeptRequireMaxes(Set<VcleDeptRequireMax> vcleDeptRequireMaxes) {
        this.vcleDeptRequireMaxes = vcleDeptRequireMaxes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<PurSuppWork> getPurSuppWorks() {
        return this.purSuppWorks;
    }
    
    public void setPurSuppWorks(Set<PurSuppWork> purSuppWorks) {
        this.purSuppWorks = purSuppWorks;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<InvoDeptItemJoin> getInvoDeptItemJoins() {
        return this.invoDeptItemJoins;
    }
    
    public void setInvoDeptItemJoins(Set<InvoDeptItemJoin> invoDeptItemJoins) {
        this.invoDeptItemJoins = invoDeptItemJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<PerDeptPlace> getPerDeptPlaces() {
        return this.perDeptPlaces;
    }
    
    public void setPerDeptPlaces(Set<PerDeptPlace> perDeptPlaces) {
        this.perDeptPlaces = perDeptPlaces;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<VcleVehicleDriverJoin> getVcleVehicleDriverJoins() {
        return this.vcleVehicleDriverJoins;
    }
    
    public void setVcleVehicleDriverJoins(Set<VcleVehicleDriverJoin> vcleVehicleDriverJoins) {
        this.vcleVehicleDriverJoins = vcleVehicleDriverJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<StoResponsibilityDeptDel> getStoResponsibilityDeptDels() {
        return this.stoResponsibilityDeptDels;
    }
    
    public void setStoResponsibilityDeptDels(Set<StoResponsibilityDeptDel> stoResponsibilityDeptDels) {
        this.stoResponsibilityDeptDels = stoResponsibilityDeptDels;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<InvoAccUintDept> getInvoAccUintDepts() {
        return this.invoAccUintDepts;
    }
    
    public void setInvoAccUintDepts(Set<InvoAccUintDept> invoAccUintDepts) {
        this.invoAccUintDepts = invoAccUintDepts;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<InvoDeptResource> getInvoDeptResources() {
        return this.invoDeptResources;
    }
    
    public void setInvoDeptResources(Set<InvoDeptResource> invoDeptResources) {
        this.invoDeptResources = invoDeptResources;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<VcleVehicleClassDtl> getVcleVehicleClassDtls() {
        return this.vcleVehicleClassDtls;
    }
    
    public void setVcleVehicleClassDtls(Set<VcleVehicleClassDtl> vcleVehicleClassDtls) {
        this.vcleVehicleClassDtls = vcleVehicleClassDtls;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<VcleVehicleRequire> getVcleVehicleRequires() {
        return this.vcleVehicleRequires;
    }
    
    public void setVcleVehicleRequires(Set<VcleVehicleRequire> vcleVehicleRequires) {
        this.vcleVehicleRequires = vcleVehicleRequires;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<StoResponsibilityDept> getStoResponsibilityDepts() {
        return this.stoResponsibilityDepts;
    }
    
    public void setStoResponsibilityDepts(Set<StoResponsibilityDept> stoResponsibilityDepts) {
        this.stoResponsibilityDepts = stoResponsibilityDepts;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<PerEmploymentMaster> getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(Set<PerEmploymentMaster> perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<VcleRecordMovementJoin> getVcleRecordMovementJoins() {
        return this.vcleRecordMovementJoins;
    }
    
    public void setVcleRecordMovementJoins(Set<VcleRecordMovementJoin> vcleRecordMovementJoins) {
        this.vcleRecordMovementJoins = vcleRecordMovementJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<VcleVehicleIncome> getVcleVehicleIncomes() {
        return this.vcleVehicleIncomes;
    }
    
    public void setVcleVehicleIncomes(Set<VcleVehicleIncome> vcleVehicleIncomes) {
        this.vcleVehicleIncomes = vcleVehicleIncomes;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<InvoDeptUnitJoin> getInvoDeptUnitJoins() {
        return this.invoDeptUnitJoins;
    }
    
    public void setInvoDeptUnitJoins(Set<InvoDeptUnitJoin> invoDeptUnitJoins) {
        this.invoDeptUnitJoins = invoDeptUnitJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<InvoDeptTaxJoin> getInvoDeptTaxJoins() {
        return this.invoDeptTaxJoins;
    }
    
    public void setInvoDeptTaxJoins(Set<InvoDeptTaxJoin> invoDeptTaxJoins) {
        this.invoDeptTaxJoins = invoDeptTaxJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="perDeptOld")
    public Set<VcleDeptNumberJoin> getVcleDeptNumberJoins() {
        return this.vcleDeptNumberJoins;
    }
    
    public void setVcleDeptNumberJoins(Set<VcleDeptNumberJoin> vcleDeptNumberJoins) {
        this.vcleDeptNumberJoins = vcleDeptNumberJoins;
    }




}

