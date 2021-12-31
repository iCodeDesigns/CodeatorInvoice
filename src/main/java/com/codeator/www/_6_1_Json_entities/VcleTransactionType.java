package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * VcleTransactionType generated by hbm2java
 */
public class VcleTransactionType  implements java.io.Serializable {


     private byte transType;
     private String transName;
     private Set vcleAssociationEmpTranses = new HashSet(0);

    public VcleTransactionType() {
    }

	
    public VcleTransactionType(byte transType) {
        this.transType = transType;
    }
    public VcleTransactionType(byte transType, String transName, Set vcleAssociationEmpTranses) {
       this.transType = transType;
       this.transName = transName;
       this.vcleAssociationEmpTranses = vcleAssociationEmpTranses;
    }
   
    public byte getTransType() {
        return this.transType;
    }
    
    public void setTransType(byte transType) {
        this.transType = transType;
    }
    public String getTransName() {
        return this.transName;
    }
    
    public void setTransName(String transName) {
        this.transName = transName;
    }
    public Set getVcleAssociationEmpTranses() {
        return this.vcleAssociationEmpTranses;
    }
    
    public void setVcleAssociationEmpTranses(Set vcleAssociationEmpTranses) {
        this.vcleAssociationEmpTranses = vcleAssociationEmpTranses;
    }




}


