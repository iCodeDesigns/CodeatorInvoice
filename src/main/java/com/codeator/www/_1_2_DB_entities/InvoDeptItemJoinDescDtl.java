package com.codeator.www._1_2_DB_entities;
// Generated Sep 12, 2021 10:27:55 PM by Hibernate Tools 4.3.1


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
 * InvoDeptItemJoinDescDtl generated by hbm2java
 */
@Entity
@Table(name="INVO_DEPT_ITEM_JOIN_DESC_DTL"
    ,schema="CODEATOR"
)
public class InvoDeptItemJoinDescDtl  implements java.io.Serializable {


     private long itemSeq;
     private InvoDeptItemJoin invoDeptItemJoin;
     private String AItemDesc;
     private String EItemDesc;
     private String itemBarcode;
     private Set<InvoInvoiceMasterItem> invoInvoiceMasterItems = new HashSet<InvoInvoiceMasterItem>(0);

    public InvoDeptItemJoinDescDtl() {
    }

	
    public InvoDeptItemJoinDescDtl(long itemSeq, InvoDeptItemJoin invoDeptItemJoin) {
        this.itemSeq = itemSeq;
        this.invoDeptItemJoin = invoDeptItemJoin;
    }
    public InvoDeptItemJoinDescDtl(long itemSeq, InvoDeptItemJoin invoDeptItemJoin, String AItemDesc, String EItemDesc, String itemBarcode, Set<InvoInvoiceMasterItem> invoInvoiceMasterItems) {
       this.itemSeq = itemSeq;
       this.invoDeptItemJoin = invoDeptItemJoin;
       this.AItemDesc = AItemDesc;
       this.EItemDesc = EItemDesc;
       this.itemBarcode = itemBarcode;
       this.invoInvoiceMasterItems = invoInvoiceMasterItems;
    }
   
     @Id 

    
    @Column(name="ITEM_SEQ", unique=true, nullable=false, precision=16, scale=0)
    public long getItemSeq() {
        return this.itemSeq;
    }
    
    public void setItemSeq(long itemSeq) {
        this.itemSeq = itemSeq;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="SECTION_NO_OLD", referencedColumnName="SECTION_NO_OLD", nullable=false), 
        @JoinColumn(name="DEP_NO_OLD", referencedColumnName="DEP_NO_OLD", nullable=false), 
        @JoinColumn(name="ITEM_CODE", referencedColumnName="ITEM_CODE", nullable=false), 
        @JoinColumn(name="ACC_UNIT_CODE", referencedColumnName="ACC_UNIT_CODE") } )
    public InvoDeptItemJoin getInvoDeptItemJoin() {
        return this.invoDeptItemJoin;
    }
    
    public void setInvoDeptItemJoin(InvoDeptItemJoin invoDeptItemJoin) {
        this.invoDeptItemJoin = invoDeptItemJoin;
    }

    
    @Column(name="A_ITEM_DESC", length=150)
    public String getAItemDesc() {
        return this.AItemDesc;
    }
    
    public void setAItemDesc(String AItemDesc) {
        this.AItemDesc = AItemDesc;
    }

    
    @Column(name="E_ITEM_DESC", length=150)
    public String getEItemDesc() {
        return this.EItemDesc;
    }
    
    public void setEItemDesc(String EItemDesc) {
        this.EItemDesc = EItemDesc;
    }

    
    @Column(name="ITEM_BARCODE", length=50)
    public String getItemBarcode() {
        return this.itemBarcode;
    }
    
    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoDeptItemJoinDescDtl")
    public Set<InvoInvoiceMasterItem> getInvoInvoiceMasterItems() {
        return this.invoInvoiceMasterItems;
    }
    
    public void setInvoInvoiceMasterItems(Set<InvoInvoiceMasterItem> invoInvoiceMasterItems) {
        this.invoInvoiceMasterItems = invoInvoiceMasterItems;
    }




}


