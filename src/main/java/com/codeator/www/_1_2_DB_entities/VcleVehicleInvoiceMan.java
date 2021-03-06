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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VcleVehicleInvoiceMan generated by hbm2java
 */
@Entity
@Table(name="VCLE_VEHICLE_INVOICE_MAN"
    ,schema="CODEATOR"
)
public class VcleVehicleInvoiceMan  implements java.io.Serializable {


     private VcleVehicleInvoiceManId id;
     private VcleMainCostCode vcleMainCostCode;
     private VcleIssueDocumentMan vcleIssueDocumentMan;
     private VcleExternalCode vcleExternalCode;
     private VcleCostType vcleCostType;
     private String ghaName;
     private Integer invoiceN0;
     private BigDecimal invoiceValue;
     private BigDecimal invoiceTax;
     private Long userEmployeeNo;
     private String rmrk;
     private Boolean chkText;
     private Long issueDocSerial;
     private Date issueDocDate;
     private Set<VcleVehicleInvoiceCar> vcleVehicleInvoiceCars = new HashSet<VcleVehicleInvoiceCar>(0);

    public VcleVehicleInvoiceMan() {
    }

	
    public VcleVehicleInvoiceMan(VcleVehicleInvoiceManId id, VcleCostType vcleCostType) {
        this.id = id;
        this.vcleCostType = vcleCostType;
    }
    public VcleVehicleInvoiceMan(VcleVehicleInvoiceManId id, VcleMainCostCode vcleMainCostCode, VcleIssueDocumentMan vcleIssueDocumentMan, VcleExternalCode vcleExternalCode, VcleCostType vcleCostType, String ghaName, Integer invoiceN0, BigDecimal invoiceValue, BigDecimal invoiceTax, Long userEmployeeNo, String rmrk, Boolean chkText, Long issueDocSerial, Date issueDocDate, Set<VcleVehicleInvoiceCar> vcleVehicleInvoiceCars) {
       this.id = id;
       this.vcleMainCostCode = vcleMainCostCode;
       this.vcleIssueDocumentMan = vcleIssueDocumentMan;
       this.vcleExternalCode = vcleExternalCode;
       this.vcleCostType = vcleCostType;
       this.ghaName = ghaName;
       this.invoiceN0 = invoiceN0;
       this.invoiceValue = invoiceValue;
       this.invoiceTax = invoiceTax;
       this.userEmployeeNo = userEmployeeNo;
       this.rmrk = rmrk;
       this.chkText = chkText;
       this.issueDocSerial = issueDocSerial;
       this.issueDocDate = issueDocDate;
       this.vcleVehicleInvoiceCars = vcleVehicleInvoiceCars;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="invoiceType", column=@Column(name="INVOICE_TYPE", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="invoiceSp", column=@Column(name="INVOICE_SP", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="invoiceDate", column=@Column(name="INVOICE_DATE", nullable=false, length=7) ), 
        @AttributeOverride(name="currDate", column=@Column(name="CURR_DATE", nullable=false, length=7) ) } )
    public VcleVehicleInvoiceManId getId() {
        return this.id;
    }
    
    public void setId(VcleVehicleInvoiceManId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COST_CODE")
    public VcleMainCostCode getVcleMainCostCode() {
        return this.vcleMainCostCode;
    }
    
    public void setVcleMainCostCode(VcleMainCostCode vcleMainCostCode) {
        this.vcleMainCostCode = vcleMainCostCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="FISCAL_YEAR", referencedColumnName="FISCAL_YEAR"), 
        @JoinColumn(name="VC_ISSUE_DOC_SP", referencedColumnName="VC_ISSUE_DOC_SP") } )
    public VcleIssueDocumentMan getVcleIssueDocumentMan() {
        return this.vcleIssueDocumentMan;
    }
    
    public void setVcleIssueDocumentMan(VcleIssueDocumentMan vcleIssueDocumentMan) {
        this.vcleIssueDocumentMan = vcleIssueDocumentMan;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SIDE_CODE")
    public VcleExternalCode getVcleExternalCode() {
        return this.vcleExternalCode;
    }
    
    public void setVcleExternalCode(VcleExternalCode vcleExternalCode) {
        this.vcleExternalCode = vcleExternalCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumns( { 
        @JoinColumn(name="COST_TYPE", referencedColumnName="COST_TYPE", nullable=false), 
        @JoinColumn(name="COST_CODE_TYPE", referencedColumnName="COST_CODE", nullable=false) } )
    public VcleCostType getVcleCostType() {
        return this.vcleCostType;
    }
    
    public void setVcleCostType(VcleCostType vcleCostType) {
        this.vcleCostType = vcleCostType;
    }

    
    @Column(name="GHA_NAME", length=200)
    public String getGhaName() {
        return this.ghaName;
    }
    
    public void setGhaName(String ghaName) {
        this.ghaName = ghaName;
    }

    
    @Column(name="INVOICE_N0", precision=6, scale=0)
    public Integer getInvoiceN0() {
        return this.invoiceN0;
    }
    
    public void setInvoiceN0(Integer invoiceN0) {
        this.invoiceN0 = invoiceN0;
    }

    
    @Column(name="INVOICE_VALUE", precision=11)
    public BigDecimal getInvoiceValue() {
        return this.invoiceValue;
    }
    
    public void setInvoiceValue(BigDecimal invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    
    @Column(name="INVOICE_TAX", precision=7)
    public BigDecimal getInvoiceTax() {
        return this.invoiceTax;
    }
    
    public void setInvoiceTax(BigDecimal invoiceTax) {
        this.invoiceTax = invoiceTax;
    }

    
    @Column(name="USER_EMPLOYEE_NO", precision=10, scale=0)
    public Long getUserEmployeeNo() {
        return this.userEmployeeNo;
    }
    
    public void setUserEmployeeNo(Long userEmployeeNo) {
        this.userEmployeeNo = userEmployeeNo;
    }

    
    @Column(name="RMRK", length=100)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    
    @Column(name="CHK_TEXT", precision=1, scale=0)
    public Boolean getChkText() {
        return this.chkText;
    }
    
    public void setChkText(Boolean chkText) {
        this.chkText = chkText;
    }

    
    @Column(name="ISSUE_DOC_SERIAL", precision=12, scale=0)
    public Long getIssueDocSerial() {
        return this.issueDocSerial;
    }
    
    public void setIssueDocSerial(Long issueDocSerial) {
        this.issueDocSerial = issueDocSerial;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ISSUE_DOC_DATE", length=7)
    public Date getIssueDocDate() {
        return this.issueDocDate;
    }
    
    public void setIssueDocDate(Date issueDocDate) {
        this.issueDocDate = issueDocDate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="vcleVehicleInvoiceMan")
    public Set<VcleVehicleInvoiceCar> getVcleVehicleInvoiceCars() {
        return this.vcleVehicleInvoiceCars;
    }
    
    public void setVcleVehicleInvoiceCars(Set<VcleVehicleInvoiceCar> vcleVehicleInvoiceCars) {
        this.vcleVehicleInvoiceCars = vcleVehicleInvoiceCars;
    }




}


