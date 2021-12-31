package com.codeator.www._1_2_DB_entities;
// Generated Mar 21, 2021 6:34:02 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * StoItemCateGroupSecDtl generated by hbm2java
 */
@Entity
@Table(name="STO_ITEM_CATE_GROUP_SEC_DTL"
    ,schema="CODEATOR"
)
public class StoItemCateGroupSecDtl  implements java.io.Serializable {


     private int itemNumberSp;
     private StoItemCateGroupSec stoItemCateGroupSec;
     private String itemCode;
     private long itemDigital;
     private String itemName;
     private String itemDesc;
     private Set<StoItemCateGroupSecSer> stoItemCateGroupSecSers = new HashSet<StoItemCateGroupSecSer>(0);

    public StoItemCateGroupSecDtl() {
    }

	
    public StoItemCateGroupSecDtl(int itemNumberSp, StoItemCateGroupSec stoItemCateGroupSec, String itemCode, long itemDigital, String itemName) {
        this.itemNumberSp = itemNumberSp;
        this.stoItemCateGroupSec = stoItemCateGroupSec;
        this.itemCode = itemCode;
        this.itemDigital = itemDigital;
        this.itemName = itemName;
    }
    public StoItemCateGroupSecDtl(int itemNumberSp, StoItemCateGroupSec stoItemCateGroupSec, String itemCode, long itemDigital, String itemName, String itemDesc, Set<StoItemCateGroupSecSer> stoItemCateGroupSecSers) {
       this.itemNumberSp = itemNumberSp;
       this.stoItemCateGroupSec = stoItemCateGroupSec;
       this.itemCode = itemCode;
       this.itemDigital = itemDigital;
       this.itemName = itemName;
       this.itemDesc = itemDesc;
       this.stoItemCateGroupSecSers = stoItemCateGroupSecSers;
    }
   
     @Id 

    
    @Column(name="ITEM_NUMBER_SP", unique=true, nullable=false, precision=9, scale=0)
    public int getItemNumberSp() {
        return this.itemNumberSp;
    }
    
    public void setItemNumberSp(int itemNumberSp) {
        this.itemNumberSp = itemNumberSp;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="GROUP_CODE", referencedColumnName="GROUP_CODE", nullable=false), 
        @JoinColumn(name="CATE_CODE", referencedColumnName="CATE_CODE", nullable=false), 
        @JoinColumn(name="SECTION_CODE", referencedColumnName="SECTION_CODE", nullable=false) } )
    public StoItemCateGroupSec getStoItemCateGroupSec() {
        return this.stoItemCateGroupSec;
    }
    
    public void setStoItemCateGroupSec(StoItemCateGroupSec stoItemCateGroupSec) {
        this.stoItemCateGroupSec = stoItemCateGroupSec;
    }

    
    @Column(name="ITEM_CODE", nullable=false, length=3)
    public String getItemCode() {
        return this.itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    
    @Column(name="ITEM_DIGITAL", nullable=false, precision=11, scale=0)
    public long getItemDigital() {
        return this.itemDigital;
    }
    
    public void setItemDigital(long itemDigital) {
        this.itemDigital = itemDigital;
    }

    
    @Column(name="ITEM_NAME", nullable=false, length=200)
    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    
    @Column(name="ITEM_DESC", length=200)
    public String getItemDesc() {
        return this.itemDesc;
    }
    
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="stoItemCateGroupSecDtl")
    public Set<StoItemCateGroupSecSer> getStoItemCateGroupSecSers() {
        return this.stoItemCateGroupSecSers;
    }
    
    public void setStoItemCateGroupSecSers(Set<StoItemCateGroupSecSer> stoItemCateGroupSecSers) {
        this.stoItemCateGroupSecSers = stoItemCateGroupSecSers;
    }




}

