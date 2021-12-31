package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleFuelBookNumber generated by hbm2java
 */
@Entity
@Table(name="VCLE_FUEL_BOOK_NUMBER"
    ,schema="CODEATOR"
)
public class VcleFuelBookNumber  implements java.io.Serializable {


     private VcleFuelBookNumberId id;
     private VcleEmployeeMaster vcleEmployeeMaster;
     private Date orderDate;
     private Date priceDate;
     private Date issueDate;
     private boolean litreType;
     private Short litreQty;
     private BigDecimal litrePrice;
     private Integer fromBook;
     private Integer toBook;
     private Date returnDate;
     private Boolean octane;
     private Boolean chkLock;
     private Integer vehicleSpOnly;
     private Integer boardDigitalOnly;
     private String boardAlfa1Only;
     private String boardAlfa2Only;
     private String boardAlfa3Only;
     private BigDecimal litreValAll;
     private Set<VcleFuelBookNumberDtl> vcleFuelBookNumberDtls = new HashSet<VcleFuelBookNumberDtl>(0);

    public VcleFuelBookNumber() {
    }

	
    public VcleFuelBookNumber(VcleFuelBookNumberId id, boolean litreType) {
        this.id = id;
        this.litreType = litreType;
    }
    public VcleFuelBookNumber(VcleFuelBookNumberId id, VcleEmployeeMaster vcleEmployeeMaster, Date orderDate, Date priceDate, Date issueDate, boolean litreType, Short litreQty, BigDecimal litrePrice, Integer fromBook, Integer toBook, Date returnDate, Boolean octane, Boolean chkLock, Integer vehicleSpOnly, Integer boardDigitalOnly, String boardAlfa1Only, String boardAlfa2Only, String boardAlfa3Only, BigDecimal litreValAll, Set<VcleFuelBookNumberDtl> vcleFuelBookNumberDtls) {
       this.id = id;
       this.vcleEmployeeMaster = vcleEmployeeMaster;
       this.orderDate = orderDate;
       this.priceDate = priceDate;
       this.issueDate = issueDate;
       this.litreType = litreType;
       this.litreQty = litreQty;
       this.litrePrice = litrePrice;
       this.fromBook = fromBook;
       this.toBook = toBook;
       this.returnDate = returnDate;
       this.octane = octane;
       this.chkLock = chkLock;
       this.vehicleSpOnly = vehicleSpOnly;
       this.boardDigitalOnly = boardDigitalOnly;
       this.boardAlfa1Only = boardAlfa1Only;
       this.boardAlfa2Only = boardAlfa2Only;
       this.boardAlfa3Only = boardAlfa3Only;
       this.litreValAll = litreValAll;
       this.vcleFuelBookNumberDtls = vcleFuelBookNumberDtls;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="fiscalDate", column=@Column(name="FISCAL_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="fuelType", column=@Column(name="FUEL_TYPE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="bookSp", column=@Column(name="BOOK_SP", nullable=false, precision=9, scale=0) ) } )
    public VcleFuelBookNumberId getId() {
        return this.id;
    }
    
    public void setId(VcleFuelBookNumberId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
    public VcleEmployeeMaster getVcleEmployeeMaster() {
        return this.vcleEmployeeMaster;
    }
    
    public void setVcleEmployeeMaster(VcleEmployeeMaster vcleEmployeeMaster) {
        this.vcleEmployeeMaster = vcleEmployeeMaster;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ORDER_DATE", length=7)
    public Date getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="PRICE_DATE", length=7)
    public Date getPriceDate() {
        return this.priceDate;
    }
    
    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ISSUE_DATE", length=7)
    public Date getIssueDate() {
        return this.issueDate;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    
    @Column(name="LITRE_TYPE", nullable=false, precision=1, scale=0)
    public boolean isLitreType() {
        return this.litreType;
    }
    
    public void setLitreType(boolean litreType) {
        this.litreType = litreType;
    }

    
    @Column(name="LITRE_QTY", precision=3, scale=0)
    public Short getLitreQty() {
        return this.litreQty;
    }
    
    public void setLitreQty(Short litreQty) {
        this.litreQty = litreQty;
    }

    
    @Column(name="LITRE_PRICE", precision=5)
    public BigDecimal getLitrePrice() {
        return this.litrePrice;
    }
    
    public void setLitrePrice(BigDecimal litrePrice) {
        this.litrePrice = litrePrice;
    }

    
    @Column(name="FROM_BOOK", precision=9, scale=0)
    public Integer getFromBook() {
        return this.fromBook;
    }
    
    public void setFromBook(Integer fromBook) {
        this.fromBook = fromBook;
    }

    
    @Column(name="TO_BOOK", precision=9, scale=0)
    public Integer getToBook() {
        return this.toBook;
    }
    
    public void setToBook(Integer toBook) {
        this.toBook = toBook;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RETURN_DATE", length=7)
    public Date getReturnDate() {
        return this.returnDate;
    }
    
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    
    @Column(name="OCTANE", precision=1, scale=0)
    public Boolean getOctane() {
        return this.octane;
    }
    
    public void setOctane(Boolean octane) {
        this.octane = octane;
    }

    
    @Column(name="CHK_LOCK", precision=1, scale=0)
    public Boolean getChkLock() {
        return this.chkLock;
    }
    
    public void setChkLock(Boolean chkLock) {
        this.chkLock = chkLock;
    }

    
    @Column(name="VEHICLE_SP_ONLY", precision=6, scale=0)
    public Integer getVehicleSpOnly() {
        return this.vehicleSpOnly;
    }
    
    public void setVehicleSpOnly(Integer vehicleSpOnly) {
        this.vehicleSpOnly = vehicleSpOnly;
    }

    
    @Column(name="BOARD_DIGITAL_ONLY", precision=6, scale=0)
    public Integer getBoardDigitalOnly() {
        return this.boardDigitalOnly;
    }
    
    public void setBoardDigitalOnly(Integer boardDigitalOnly) {
        this.boardDigitalOnly = boardDigitalOnly;
    }

    
    @Column(name="BOARD_ALFA1_ONLY", length=1)
    public String getBoardAlfa1Only() {
        return this.boardAlfa1Only;
    }
    
    public void setBoardAlfa1Only(String boardAlfa1Only) {
        this.boardAlfa1Only = boardAlfa1Only;
    }

    
    @Column(name="BOARD_ALFA2_ONLY", length=1)
    public String getBoardAlfa2Only() {
        return this.boardAlfa2Only;
    }
    
    public void setBoardAlfa2Only(String boardAlfa2Only) {
        this.boardAlfa2Only = boardAlfa2Only;
    }

    
    @Column(name="BOARD_ALFA3_ONLY", length=1)
    public String getBoardAlfa3Only() {
        return this.boardAlfa3Only;
    }
    
    public void setBoardAlfa3Only(String boardAlfa3Only) {
        this.boardAlfa3Only = boardAlfa3Only;
    }

    
    @Column(name="LITRE_VAL_ALL", precision=7)
    public BigDecimal getLitreValAll() {
        return this.litreValAll;
    }
    
    public void setLitreValAll(BigDecimal litreValAll) {
        this.litreValAll = litreValAll;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleFuelBookNumber")
    public Set<VcleFuelBookNumberDtl> getVcleFuelBookNumberDtls() {
        return this.vcleFuelBookNumberDtls;
    }
    
    public void setVcleFuelBookNumberDtls(Set<VcleFuelBookNumberDtl> vcleFuelBookNumberDtls) {
        this.vcleFuelBookNumberDtls = vcleFuelBookNumberDtls;
    }




}

