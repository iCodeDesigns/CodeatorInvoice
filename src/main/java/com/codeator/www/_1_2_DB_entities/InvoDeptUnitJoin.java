package com.codeator.www._1_2_DB_entities;
// Generated Sep 12, 2021 9:58:05 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * InvoDeptUnitJoin generated by hbm2java
 */
@Entity
@Table(name="INVO_DEPT_UNIT_JOIN"
    ,schema="CODEATOR"
)
public class InvoDeptUnitJoin  implements java.io.Serializable {


     private InvoDeptUnitJoinId id;
     private InvoUnitType invoUnitType;
     private InvoAccUintDept invoAccUintDept;
     private String unitNickname;

    public InvoDeptUnitJoin() {
    }

	
    public InvoDeptUnitJoin(InvoDeptUnitJoinId id, InvoUnitType invoUnitType, InvoAccUintDept invoAccUintDept) {
        this.id = id;
        this.invoUnitType = invoUnitType;
        this.invoAccUintDept = invoAccUintDept;
    }
    public InvoDeptUnitJoin(InvoDeptUnitJoinId id, InvoUnitType invoUnitType, InvoAccUintDept invoAccUintDept, String unitNickname) {
       this.id = id;
       this.invoUnitType = invoUnitType;
       this.invoAccUintDept = invoAccUintDept;
       this.unitNickname = unitNickname;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="unitType", column=@Column(name="UNIT_TYPE", nullable=false, length=5) ), 
        @AttributeOverride(name="depNoOld", column=@Column(name="DEP_NO_OLD", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="sectionNoOld", column=@Column(name="SECTION_NO_OLD", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="accUnitCode", column=@Column(name="ACC_UNIT_CODE", nullable=false, length=2) ) } )
    public InvoDeptUnitJoinId getId() {
        return this.id;
    }
    
    public void setId(InvoDeptUnitJoinId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="UNIT_TYPE", nullable=false, insertable=false, updatable=false)
    public InvoUnitType getInvoUnitType() {
        return this.invoUnitType;
    }
    
    public void setInvoUnitType(InvoUnitType invoUnitType) {
        this.invoUnitType = invoUnitType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="ACC_UNIT_CODE", referencedColumnName="ACC_UNIT_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="DEP_NO_OLD", referencedColumnName="DEP_NO_OLD", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="SECTION_NO_OLD", referencedColumnName="SECTION_NO_OLD", nullable=false, insertable=false, updatable=false) } )
    public InvoAccUintDept getInvoAccUintDept() {
        return this.invoAccUintDept;
    }
    
    public void setInvoAccUintDept(InvoAccUintDept invoAccUintDept) {
        this.invoAccUintDept = invoAccUintDept;
    }

    
    @Column(name="UNIT_NICKNAME", length=75)
    public String getUnitNickname() {
        return this.unitNickname;
    }
    
    public void setUnitNickname(String unitNickname) {
        this.unitNickname = unitNickname;
    }




}


