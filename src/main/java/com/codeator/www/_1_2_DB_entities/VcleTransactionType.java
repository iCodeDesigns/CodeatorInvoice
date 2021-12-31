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
 * VcleTransactionType generated by hbm2java
 */
@Entity
@Table(name="VCLE_TRANSACTION_TYPE"
    ,schema="CODEATOR"
)
public class VcleTransactionType  implements java.io.Serializable {


     private byte transType;
     private String transName;
     private Set<VcleAssociationEmpTrans> vcleAssociationEmpTranses = new HashSet<VcleAssociationEmpTrans>(0);

    public VcleTransactionType() {
    }

	
    public VcleTransactionType(byte transType) {
        this.transType = transType;
    }
    public VcleTransactionType(byte transType, String transName, Set<VcleAssociationEmpTrans> vcleAssociationEmpTranses) {
       this.transType = transType;
       this.transName = transName;
       this.vcleAssociationEmpTranses = vcleAssociationEmpTranses;
    }
   
     @Id 

    
    @Column(name="TRANS_TYPE", unique=true, nullable=false, precision=2, scale=0)
    public byte getTransType() {
        return this.transType;
    }
    
    public void setTransType(byte transType) {
        this.transType = transType;
    }

    
    @Column(name="TRANS_NAME", length=60)
    public String getTransName() {
        return this.transName;
    }
    
    public void setTransName(String transName) {
        this.transName = transName;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleTransactionType")
    public Set<VcleAssociationEmpTrans> getVcleAssociationEmpTranses() {
        return this.vcleAssociationEmpTranses;
    }
    
    public void setVcleAssociationEmpTranses(Set<VcleAssociationEmpTrans> vcleAssociationEmpTranses) {
        this.vcleAssociationEmpTranses = vcleAssociationEmpTranses;
    }




}


