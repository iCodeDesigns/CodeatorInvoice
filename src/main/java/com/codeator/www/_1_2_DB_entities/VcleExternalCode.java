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
 * VcleExternalCode generated by hbm2java
 */
@Entity
@Table(name="VCLE_EXTERNAL_CODE"
    ,schema="CODEATOR"
)
public class VcleExternalCode  implements java.io.Serializable {


     private int sideCode;
     private String sideName;
     private Boolean sideType;
     private Set<VcleVehicleInvoiceMan> vcleVehicleInvoiceMans = new HashSet<VcleVehicleInvoiceMan>(0);

    public VcleExternalCode() {
    }

	
    public VcleExternalCode(int sideCode, String sideName) {
        this.sideCode = sideCode;
        this.sideName = sideName;
    }
    public VcleExternalCode(int sideCode, String sideName, Boolean sideType, Set<VcleVehicleInvoiceMan> vcleVehicleInvoiceMans) {
       this.sideCode = sideCode;
       this.sideName = sideName;
       this.sideType = sideType;
       this.vcleVehicleInvoiceMans = vcleVehicleInvoiceMans;
    }
   
     @Id 

    
    @Column(name="SIDE_CODE", unique=true, nullable=false, precision=6, scale=0)
    public int getSideCode() {
        return this.sideCode;
    }
    
    public void setSideCode(int sideCode) {
        this.sideCode = sideCode;
    }

    
    @Column(name="SIDE_NAME", nullable=false, length=100)
    public String getSideName() {
        return this.sideName;
    }
    
    public void setSideName(String sideName) {
        this.sideName = sideName;
    }

    
    @Column(name="SIDE_TYPE", precision=1, scale=0)
    public Boolean getSideType() {
        return this.sideType;
    }
    
    public void setSideType(Boolean sideType) {
        this.sideType = sideType;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleExternalCode")
    public Set<VcleVehicleInvoiceMan> getVcleVehicleInvoiceMans() {
        return this.vcleVehicleInvoiceMans;
    }
    
    public void setVcleVehicleInvoiceMans(Set<VcleVehicleInvoiceMan> vcleVehicleInvoiceMans) {
        this.vcleVehicleInvoiceMans = vcleVehicleInvoiceMans;
    }




}


