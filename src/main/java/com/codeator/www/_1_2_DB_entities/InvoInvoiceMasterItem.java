package com.codeator.www._1_2_DB_entities;
// Generated Oct 15, 2021 2:15:48 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * InvoInvoiceMasterItem generated by hbm2java
 */
@Entity
@Table(name="INVO_INVOICE_MASTER_ITEM"
    ,schema="CODEATOR"
)
public class InvoInvoiceMasterItem  implements java.io.Serializable {


     private InvoInvoiceMasterItemId id;
     private AccCurrencyCode accCurrencyCode;
     private InvoUnitType invoUnitType;
     private InvoDeptItemJoinDescDtl invoDeptItemJoinDescDtl;
     private InvoItemCode invoItemCode;
     private InvoInvoiceMaster invoInvoiceMaster;
     private String itemDescription;
     private BigDecimal quantity;
     private BigDecimal currencyExchangeRate;
     private BigDecimal amountSold;
     private BigDecimal salesTotal;
     private BigDecimal discountAmount;
     private BigDecimal netTotal;
     private BigDecimal total;
     private Integer discountType;
     private BigDecimal amountEgp;
     private BigDecimal discountRate;
     private BigDecimal itemsDiscount;
     private BigDecimal totalTaxableFees;
     private BigDecimal valueDifference;
     private String rmrk;
     private BigDecimal calcUnit;
     private BigDecimal minimumLimit;
     private BigDecimal priceBeforeCalcUnit;
     private Set<InvoInvoiceMasterTax> invoInvoiceMasterTaxes = new HashSet<InvoInvoiceMasterTax>(0);

    public InvoInvoiceMasterItem() {
    }

	
    public InvoInvoiceMasterItem(InvoInvoiceMasterItemId id, InvoUnitType invoUnitType, InvoItemCode invoItemCode, InvoInvoiceMaster invoInvoiceMaster, String itemDescription, BigDecimal quantity, BigDecimal currencyExchangeRate, BigDecimal amountSold, BigDecimal salesTotal, BigDecimal discountAmount, BigDecimal netTotal, BigDecimal total) {
        this.id = id;
        this.invoUnitType = invoUnitType;
        this.invoItemCode = invoItemCode;
        this.invoInvoiceMaster = invoInvoiceMaster;
        this.itemDescription = itemDescription;
        this.quantity = quantity;
        this.currencyExchangeRate = currencyExchangeRate;
        this.amountSold = amountSold;
        this.salesTotal = salesTotal;
        this.discountAmount = discountAmount;
        this.netTotal = netTotal;
        this.total = total;
    }
    public InvoInvoiceMasterItem(InvoInvoiceMasterItemId id, AccCurrencyCode accCurrencyCode, InvoUnitType invoUnitType, InvoDeptItemJoinDescDtl invoDeptItemJoinDescDtl, InvoItemCode invoItemCode, InvoInvoiceMaster invoInvoiceMaster, String itemDescription, BigDecimal quantity, BigDecimal currencyExchangeRate, BigDecimal amountSold, BigDecimal salesTotal, BigDecimal discountAmount, BigDecimal netTotal, BigDecimal total, Integer discountType, BigDecimal amountEgp, BigDecimal discountRate, BigDecimal itemsDiscount, BigDecimal totalTaxableFees, BigDecimal valueDifference, String rmrk, BigDecimal calcUnit, BigDecimal minimumLimit, BigDecimal priceBeforeCalcUnit, Set<InvoInvoiceMasterTax> invoInvoiceMasterTaxes) {
       this.id = id;
       this.accCurrencyCode = accCurrencyCode;
       this.invoUnitType = invoUnitType;
       this.invoDeptItemJoinDescDtl = invoDeptItemJoinDescDtl;
       this.invoItemCode = invoItemCode;
       this.invoInvoiceMaster = invoInvoiceMaster;
       this.itemDescription = itemDescription;
       this.quantity = quantity;
       this.currencyExchangeRate = currencyExchangeRate;
       this.amountSold = amountSold;
       this.salesTotal = salesTotal;
       this.discountAmount = discountAmount;
       this.netTotal = netTotal;
       this.total = total;
       this.discountType = discountType;
       this.amountEgp = amountEgp;
       this.discountRate = discountRate;
       this.itemsDiscount = itemsDiscount;
       this.totalTaxableFees = totalTaxableFees;
       this.valueDifference = valueDifference;
       this.rmrk = rmrk;
       this.calcUnit = calcUnit;
       this.minimumLimit = minimumLimit;
       this.priceBeforeCalcUnit = priceBeforeCalcUnit;
       this.invoInvoiceMasterTaxes = invoInvoiceMasterTaxes;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="accUnitCode", column=@Column(name="ACC_UNIT_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="invoSp", column=@Column(name="INVO_SP", nullable=false, precision=16, scale=0) ), 
        @AttributeOverride(name="sectionNoOld", column=@Column(name="SECTION_NO_OLD", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="depNoOld", column=@Column(name="DEP_NO_OLD", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="invoSpItem", column=@Column(name="INVO_SP_ITEM", nullable=false, precision=5, scale=0) ) } )
    public InvoInvoiceMasterItemId getId() {
        return this.id;
    }
    
    public void setId(InvoInvoiceMasterItemId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CURRENCY_CODE")
    public AccCurrencyCode getAccCurrencyCode() {
        return this.accCurrencyCode;
    }
    
    public void setAccCurrencyCode(AccCurrencyCode accCurrencyCode) {
        this.accCurrencyCode = accCurrencyCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="UNIT_TYPE", nullable=false)
    public InvoUnitType getInvoUnitType() {
        return this.invoUnitType;
    }
    
    public void setInvoUnitType(InvoUnitType invoUnitType) {
        this.invoUnitType = invoUnitType;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ITEM_SEQ")
    public InvoDeptItemJoinDescDtl getInvoDeptItemJoinDescDtl() {
        return this.invoDeptItemJoinDescDtl;
    }
    
    public void setInvoDeptItemJoinDescDtl(InvoDeptItemJoinDescDtl invoDeptItemJoinDescDtl) {
        this.invoDeptItemJoinDescDtl = invoDeptItemJoinDescDtl;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ITEM_CODE", nullable=false)
    public InvoItemCode getInvoItemCode() {
        return this.invoItemCode;
    }
    
    public void setInvoItemCode(InvoItemCode invoItemCode) {
        this.invoItemCode = invoItemCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="DEP_NO_OLD", referencedColumnName="DEP_NO_OLD", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="ACC_UNIT_CODE", referencedColumnName="ACC_UNIT_CODE", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="SECTION_NO_OLD", referencedColumnName="SECTION_NO_OLD", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="INVO_SP", referencedColumnName="INVO_SP", nullable=false, insertable=false, updatable=false) } )
    public InvoInvoiceMaster getInvoInvoiceMaster() {
        return this.invoInvoiceMaster;
    }
    
    public void setInvoInvoiceMaster(InvoInvoiceMaster invoInvoiceMaster) {
        this.invoInvoiceMaster = invoInvoiceMaster;
    }

    
    @Column(name="ITEM_DESCRIPTION", nullable=false, length=150)
    public String getItemDescription() {
        return this.itemDescription;
    }
    
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    
    @Column(name="QUANTITY", nullable=false, precision=16, scale=5)
    public BigDecimal getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    
    @Column(name="CURRENCY_EXCHANGE_RATE", nullable=false, precision=7)
    public BigDecimal getCurrencyExchangeRate() {
        return this.currencyExchangeRate;
    }
    
    public void setCurrencyExchangeRate(BigDecimal currencyExchangeRate) {
        this.currencyExchangeRate = currencyExchangeRate;
    }

    
    @Column(name="AMOUNT_SOLD", nullable=false, precision=16, scale=5)
    public BigDecimal getAmountSold() {
        return this.amountSold;
    }
    
    public void setAmountSold(BigDecimal amountSold) {
        this.amountSold = amountSold;
    }

    
    @Column(name="SALES_TOTAL", nullable=false, precision=16, scale=5)
    public BigDecimal getSalesTotal() {
        return this.salesTotal;
    }
    
    public void setSalesTotal(BigDecimal salesTotal) {
        this.salesTotal = salesTotal;
    }

    
    @Column(name="DISCOUNT_AMOUNT", nullable=false, precision=16, scale=5)
    public BigDecimal getDiscountAmount() {
        return this.discountAmount;
    }
    
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    
    @Column(name="NET_TOTAL", nullable=false, precision=16, scale=5)
    public BigDecimal getNetTotal() {
        return this.netTotal;
    }
    
    public void setNetTotal(BigDecimal netTotal) {
        this.netTotal = netTotal;
    }

    
    @Column(name="TOTAL", nullable=false, precision=16, scale=5)
    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    
    @Column(name="DISCOUNT_TYPE", precision=5, scale=0)
    public Integer getDiscountType() {
        return this.discountType;
    }
    
    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    
    @Column(name="AMOUNT_EGP", precision=16, scale=5)
    public BigDecimal getAmountEgp() {
        return this.amountEgp;
    }
    
    public void setAmountEgp(BigDecimal amountEgp) {
        this.amountEgp = amountEgp;
    }

    
    @Column(name="DISCOUNT_RATE", precision=7)
    public BigDecimal getDiscountRate() {
        return this.discountRate;
    }
    
    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    
    @Column(name="ITEMS_DISCOUNT", precision=16, scale=5)
    public BigDecimal getItemsDiscount() {
        return this.itemsDiscount;
    }
    
    public void setItemsDiscount(BigDecimal itemsDiscount) {
        this.itemsDiscount = itemsDiscount;
    }

    
    @Column(name="TOTAL_TAXABLE_FEES", precision=16, scale=5)
    public BigDecimal getTotalTaxableFees() {
        return this.totalTaxableFees;
    }
    
    public void setTotalTaxableFees(BigDecimal totalTaxableFees) {
        this.totalTaxableFees = totalTaxableFees;
    }

    
    @Column(name="VALUE_DIFFERENCE", precision=7)
    public BigDecimal getValueDifference() {
        return this.valueDifference;
    }
    
    public void setValueDifference(BigDecimal valueDifference) {
        this.valueDifference = valueDifference;
    }

    
    @Column(name="RMRK", length=200)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    
    @Column(name="CALC_UNIT", precision=16, scale=5)
    public BigDecimal getCalcUnit() {
        return this.calcUnit;
    }
    
    public void setCalcUnit(BigDecimal calcUnit) {
        this.calcUnit = calcUnit;
    }

    
    @Column(name="MINIMUM_LIMIT", precision=16, scale=5)
    public BigDecimal getMinimumLimit() {
        return this.minimumLimit;
    }
    
    public void setMinimumLimit(BigDecimal minimumLimit) {
        this.minimumLimit = minimumLimit;
    }
    
    @Column(name="PRICE_BEFORE_CALC_UNIT", precision=16, scale=5)
    public BigDecimal getPriceBeforeCalcUnit() {
        return this.priceBeforeCalcUnit;
    }
    
    public void setPriceBeforeCalcUnit(BigDecimal priceBeforeCalcUnit) {
        this.priceBeforeCalcUnit = priceBeforeCalcUnit;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoInvoiceMasterItem")
    public Set<InvoInvoiceMasterTax> getInvoInvoiceMasterTaxes() {
        return this.invoInvoiceMasterTaxes;
    }
    
    public void setInvoInvoiceMasterTaxes(Set<InvoInvoiceMasterTax> invoInvoiceMasterTaxes) {
        this.invoInvoiceMasterTaxes = invoInvoiceMasterTaxes;
    }




}


