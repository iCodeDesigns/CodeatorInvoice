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
 * VcleVehicleShape generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_SHAPE"
    ,schema="CODEATOR"
)
public class VcleVehicleShape  implements java.io.Serializable {


     private byte shapeCode;
     private String shapeName;
     private Set<VcleVehicleMaster> vcleVehicleMasters = new HashSet<VcleVehicleMaster>(0);

    public VcleVehicleShape() {
    }

	
    public VcleVehicleShape(byte shapeCode, String shapeName) {
        this.shapeCode = shapeCode;
        this.shapeName = shapeName;
    }
    public VcleVehicleShape(byte shapeCode, String shapeName, Set<VcleVehicleMaster> vcleVehicleMasters) {
       this.shapeCode = shapeCode;
       this.shapeName = shapeName;
       this.vcleVehicleMasters = vcleVehicleMasters;
    }
   
     @Id 

    
    @Column(name="SHAPE_CODE", unique=true, nullable=false, precision=2, scale=0)
    public byte getShapeCode() {
        return this.shapeCode;
    }
    
    public void setShapeCode(byte shapeCode) {
        this.shapeCode = shapeCode;
    }

    
    @Column(name="SHAPE_NAME", nullable=false, length=60)
    public String getShapeName() {
        return this.shapeName;
    }
    
    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleVehicleShape")
    public Set<VcleVehicleMaster> getVcleVehicleMasters() {
        return this.vcleVehicleMasters;
    }
    
    public void setVcleVehicleMasters(Set<VcleVehicleMaster> vcleVehicleMasters) {
        this.vcleVehicleMasters = vcleVehicleMasters;
    }




}

