package com.codeator.www._1_2_DB_entities;
// Generated Sep 11, 2021 5:44:32 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
 * InvoInvoiceMasterTax generated by hbm2java
 */
@Entity
@Table(name="INVO_INVOICE_MASTER_TAX"
    ,schema="CODEATOR"
)
public class InvoInvoiceMasterTax  implements java.io.Serializable {


     private InvoInvoiceMasterTaxId id;
     private InvoTaxTypeDtl invoTaxTypeDtl;
     private InvoInvoiceMasterItem invoInvoiceMasterItem;
     private BigDecimal amount;
     private BigDecimal rate;

    public InvoInvoiceMasterTax() {
    }

	
    public InvoInvoiceMasterTax(InvoInvoiceMasterTaxId id, InvoTaxTypeDtl invoTaxTypeDtl, InvoInvoiceMasterItem invoInvoiceMasterItem, BigDecimal amount) {
        this.id = id;
        this.invoTaxTypeDtl = invoTaxTypeDtl;
        this.invoInvoiceMasterItem = invoInvoiceMasterItem;
        this.amount = amount;
    }
    public InvoInvoiceMasterTax(InvoInvoiceMasterTaxId id, InvoTaxTypeDtl invoTaxTypeDtl, InvoInvoiceMasterItem invoInvoiceMasterItem, BigDecimal amount, BigDecimal rate) {
       this.id = id;
       this.invoTaxTypeDtl = invoTaxTypeDtl;
       this.invoInvoiceMasterItem = invoInvoiceMasterItem;
       this.amount = amount;
       this.rate = rate;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="accUnitCode", column=@Column(name="ACC_UNIT_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="sectionNoOld", column=@Column(name="SECTION_NO_OLD", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="depNoOld", column=@Column(name="DEP_NO_OLD", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="invoSpItem", column=@Column(name="INVO_SP_ITEM", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="invoSp", column=@Column(name="INVO_SP", nullable=false, precision=16, scale=0) ), 
        @AttributeOverride(name="taxSubtype", column=@Column(name="TAX_SUBTYPE", nullable=false, length=5) ), 
        @AttributeOverride(name="taxType", column=@Column(name="TAX_TYPE", nullable=false, length=5) ) } )
    public InvoInvoiceMasterTaxId getId() {
        return this.id;
    }
    
    public void setId(InvoInvoiceMasterTaxId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="TAX_TYPE", referencedColumnName="TAX_TYPE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="TAX_SUBTYPE", referencedColumnName="TAX_SUBTYPE", nullable=false, insertable=false, updatable=false) } )
    public InvoTaxTypeDtl getInvoTaxTypeDtl() {
        return this.invoTaxTypeDtl;
    }
    
    public void setInvoTaxTypeDtl(InvoTaxTypeDtl invoTaxTypeDtl) {
        this.invoTaxTypeDtl = invoTaxTypeDtl;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="ACC_UNIT_CODE", referencedColumnName="ACC_UNIT_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="INVO_SP", referencedColumnName="INVO_SP", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="SECTION_NO_OLD", referencedColumnName="SECTION_NO_OLD", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="DEP_NO_OLD", referencedColumnName="DEP_NO_OLD", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="INVO_SP_ITEM", referencedColumnName="INVO_SP_ITEM", nullable=false, insertable=false, updatable=false) } )
    public InvoInvoiceMasterItem getInvoInvoiceMasterItem() {
        return this.invoInvoiceMasterItem;
    }
    
    public void setInvoInvoiceMasterItem(InvoInvoiceMasterItem invoInvoiceMasterItem) {
        this.invoInvoiceMasterItem = invoInvoiceMasterItem;
    }

    
    @Column(name="AMOUNT", nullable=false, precision=16, scale=5)
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    
    @Column(name="RATE", precision=5, scale=3)
    public BigDecimal getRate() {
        return this.rate;
    }
    
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }




}


