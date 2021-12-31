package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VcleVehicleInvoiceDtl generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_INVOICE_DTL"
    ,schema="CODEATOR"
)
public class VcleVehicleInvoiceDtl  implements java.io.Serializable {


     private VcleVehicleInvoiceDtlId id;
     private BigDecimal invQty;
     private BigDecimal invVal;
     private Long storeCodeItem;
     private Long itemNumber;
     private BigDecimal invPrice;
     private String rmrk;

    public VcleVehicleInvoiceDtl() {
    }

	
    public VcleVehicleInvoiceDtl(VcleVehicleInvoiceDtlId id, BigDecimal invQty, BigDecimal invVal) {
        this.id = id;
        this.invQty = invQty;
        this.invVal = invVal;
    }
    public VcleVehicleInvoiceDtl(VcleVehicleInvoiceDtlId id, BigDecimal invQty, BigDecimal invVal, Long storeCodeItem, Long itemNumber, BigDecimal invPrice, String rmrk) {
       this.id = id;
       this.invQty = invQty;
       this.invVal = invVal;
       this.storeCodeItem = storeCodeItem;
       this.itemNumber = itemNumber;
       this.invPrice = invPrice;
       this.rmrk = rmrk;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="invoiceSp", column=@Column(name="INVOICE_SP", nullable=false, length=240) ), 
        @AttributeOverride(name="invoiceType", column=@Column(name="INVOICE_TYPE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="invoiceSeq", column=@Column(name="INVOICE_SEQ", nullable=false, precision=3, scale=0) ) } )
    public VcleVehicleInvoiceDtlId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleInvoiceDtlId id) {
        this.id = id;
    }

    
    @Column(name="INV_QTY", nullable=false, precision=9)
    public BigDecimal getInvQty() {
        return this.invQty;
    }
    
    public void setInvQty(BigDecimal invQty) {
        this.invQty = invQty;
    }

    
    @Column(name="INV_VAL", nullable=false, precision=9)
    public BigDecimal getInvVal() {
        return this.invVal;
    }
    
    public void setInvVal(BigDecimal invVal) {
        this.invVal = invVal;
    }

    
    @Column(name="STORE_CODE_ITEM", precision=12, scale=0)
    public Long getStoreCodeItem() {
        return this.storeCodeItem;
    }
    
    public void setStoreCodeItem(Long storeCodeItem) {
        this.storeCodeItem = storeCodeItem;
    }

    
    @Column(name="ITEM_NUMBER", precision=15, scale=0)
    public Long getItemNumber() {
        return this.itemNumber;
    }
    
    public void setItemNumber(Long itemNumber) {
        this.itemNumber = itemNumber;
    }

    
    @Column(name="INV_PRICE", precision=9)
    public BigDecimal getInvPrice() {
        return this.invPrice;
    }
    
    public void setInvPrice(BigDecimal invPrice) {
        this.invPrice = invPrice;
    }

    
    @Column(name="RMRK", length=100)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }




}

