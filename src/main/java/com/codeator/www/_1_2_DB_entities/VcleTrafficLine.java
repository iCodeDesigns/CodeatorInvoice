package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * VcleTrafficLine generated by hbm2java
 */
@Entity
@Table(name="VCLE_TRAFFIC_LINE"
    ,schema="CODEATOR"
)
public class VcleTrafficLine  implements java.io.Serializable {


     private short lineCode;
     private VcleVehicleType vcleVehicleType;
     private VcleVehicleMaster vcleVehicleMaster;
     private PerEmploymentMaster perEmploymentMaster;
     private String lineName;
     private String lineRoute;
     private Byte val;
     private Set<VcleAssociationEmpTrans> vcleAssociationEmpTranses = new HashSet<VcleAssociationEmpTrans>(0);
     private Set<VcleAssociationEmp> vcleAssociationEmps = new HashSet<VcleAssociationEmp>(0);
     private Set<VcleTrafficEmpPerm> vcleTrafficEmpPerms = new HashSet<VcleTrafficEmpPerm>(0);

    public VcleTrafficLine() {
    }

	
    public VcleTrafficLine(short lineCode, VcleVehicleType vcleVehicleType, VcleVehicleMaster vcleVehicleMaster, String lineName) {
        this.lineCode = lineCode;
        this.vcleVehicleType = vcleVehicleType;
        this.vcleVehicleMaster = vcleVehicleMaster;
        this.lineName = lineName;
    }
    public VcleTrafficLine(short lineCode, VcleVehicleType vcleVehicleType, VcleVehicleMaster vcleVehicleMaster, PerEmploymentMaster perEmploymentMaster, String lineName, String lineRoute, Byte val, Set<VcleAssociationEmpTrans> vcleAssociationEmpTranses, Set<VcleAssociationEmp> vcleAssociationEmps, Set<VcleTrafficEmpPerm> vcleTrafficEmpPerms) {
       this.lineCode = lineCode;
       this.vcleVehicleType = vcleVehicleType;
       this.vcleVehicleMaster = vcleVehicleMaster;
       this.perEmploymentMaster = perEmploymentMaster;
       this.lineName = lineName;
       this.lineRoute = lineRoute;
       this.val = val;
       this.vcleAssociationEmpTranses = vcleAssociationEmpTranses;
       this.vcleAssociationEmps = vcleAssociationEmps;
       this.vcleTrafficEmpPerms = vcleTrafficEmpPerms;
    }
   
     @Id 

    
    @Column(name="LINE_CODE", unique=true, nullable=false, precision=3, scale=0)
    public short getLineCode() {
        return this.lineCode;
    }
    
    public void setLineCode(short lineCode) {
        this.lineCode = lineCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VCLE_TYPE", nullable=false)
    public VcleVehicleType getVcleVehicleType() {
        return this.vcleVehicleType;
    }
    
    public void setVcleVehicleType(VcleVehicleType vcleVehicleType) {
        this.vcleVehicleType = vcleVehicleType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VEHICLE_SP", nullable=false)
    public VcleVehicleMaster getVcleVehicleMaster() {
        return this.vcleVehicleMaster;
    }
    
    public void setVcleVehicleMaster(VcleVehicleMaster vcleVehicleMaster) {
        this.vcleVehicleMaster = vcleVehicleMaster;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
    public PerEmploymentMaster getPerEmploymentMaster() {
        return this.perEmploymentMaster;
    }
    
    public void setPerEmploymentMaster(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }

    
    @Column(name="LINE_NAME", nullable=false, length=100)
    public String getLineName() {
        return this.lineName;
    }
    
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    
    @Column(name="LINE_ROUTE", length=400)
    public String getLineRoute() {
        return this.lineRoute;
    }
    
    public void setLineRoute(String lineRoute) {
        this.lineRoute = lineRoute;
    }

    
    @Column(name="VAL", precision=2, scale=0)
    public Byte getVal() {
        return this.val;
    }
    
    public void setVal(Byte val) {
        this.val = val;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleTrafficLine")
    public Set<VcleAssociationEmpTrans> getVcleAssociationEmpTranses() {
        return this.vcleAssociationEmpTranses;
    }
    
    public void setVcleAssociationEmpTranses(Set<VcleAssociationEmpTrans> vcleAssociationEmpTranses) {
        this.vcleAssociationEmpTranses = vcleAssociationEmpTranses;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleTrafficLine")
    public Set<VcleAssociationEmp> getVcleAssociationEmps() {
        return this.vcleAssociationEmps;
    }
    
    public void setVcleAssociationEmps(Set<VcleAssociationEmp> vcleAssociationEmps) {
        this.vcleAssociationEmps = vcleAssociationEmps;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleTrafficLine")
    public Set<VcleTrafficEmpPerm> getVcleTrafficEmpPerms() {
        return this.vcleTrafficEmpPerms;
    }
    
    public void setVcleTrafficEmpPerms(Set<VcleTrafficEmpPerm> vcleTrafficEmpPerms) {
        this.vcleTrafficEmpPerms = vcleTrafficEmpPerms;
    }




}


