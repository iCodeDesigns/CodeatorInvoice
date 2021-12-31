package com.codeator.www._1_2_DB_entities;
// Generated Sep 11, 2021 5:44:32 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InvoItemCode generated by hbm2java
 */
@Entity
@Table(name="INVO_ITEM_CODE"
    ,schema="CODEATOR"
)
public class InvoItemCode  implements java.io.Serializable {


     private String itemCode;
     private PerEmploymentMaster perEmploymentMaster;
     private String internalItemCode;
     private String codeType;
     private String AItemName;
     private String EItemName;
     private String AItemDesc;
     private String EItemDesc;
     private Date sendDate;
     private Date activeDate;
     private String linkedcode;
     private String recordCreateTime;
     private Date recordCreateDate;
     private String recordUpdateTime;
     private Date recordUpdateDate;
     private Set<InvoDeptItemJoin> invoDeptItemJoins = new HashSet<InvoDeptItemJoin>(0);
     private Set<InvoInvoiceMasterItem> invoInvoiceMasterItems = new HashSet<InvoInvoiceMasterItem>(0);

    public InvoItemCode() {
    }

	
    public InvoItemCode(String itemCode, String internalItemCode, String codeType, String AItemName) {
        this.itemCode = itemCode;
        this.internalItemCode = internalItemCode;
        this.codeType = codeType;
        this.AItemName = AItemName;
    }
    public InvoItemCode(String itemCode, PerEmploymentMaster perEmploymentMaster, String internalItemCode, String codeType, String AItemName, String EItemName, String AItemDesc, String EItemDesc, Date sendDate, Date activeDate, String linkedcode, String recordCreateTime, Date recordCreateDate, String recordUpdateTime, Date recordUpdateDate, Set<InvoDeptItemJoin> invoDeptItemJoins, Set<InvoInvoiceMasterItem> invoInvoiceMasterItems) {
       this.itemCode = itemCode;
       this.perEmploymentMaster = perEmploymentMaster;
       this.internalItemCode = internalItemCode;
       this.codeType = codeType;
       this.AItemName = AItemName;
       this.EItemName = EItemName;
       this.AItemDesc = AItemDesc;
       this.EItemDesc = EItemDesc;
       this.sendDate = sendDate;
       this.activeDate = activeDate;
       this.linkedcode = linkedcode;
       this.recordCreateTime = recordCreateTime;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateTime = recordUpdateTime;
       this.recordUpdateDate = recordUpdateDate;
       this.invoDeptItemJoins = invoDeptItemJoins;
       this.invoInvoiceMasterItems = invoInvoiceMasterItems;
    }
   
     @Id 

    
    @Column(name="ITEM_CODE", unique=true, nullable=false, length=25)
    public String getItemCode() {
        return this.itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID")
    public PerEmploymentMaster getPerEmploymentMaster() {
        return this.perEmploymentMaster;
    }
    
    public void setPerEmploymentMaster(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }

    
    @Column(name="INTERNAL_ITEM_CODE", nullable=false, length=10)
    public String getInternalItemCode() {
        return this.internalItemCode;
    }
    
    public void setInternalItemCode(String internalItemCode) {
        this.internalItemCode = internalItemCode;
    }

    
    @Column(name="CODE_TYPE", nullable=false, length=5)
    public String getCodeType() {
        return this.codeType;
    }
    
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    
    @Column(name="A_ITEM_NAME", nullable=false, length=100)
    public String getAItemName() {
        return this.AItemName;
    }
    
    public void setAItemName(String AItemName) {
        this.AItemName = AItemName;
    }

    
    @Column(name="E_ITEM_NAME", length=100)
    public String getEItemName() {
        return this.EItemName;
    }
    
    public void setEItemName(String EItemName) {
        this.EItemName = EItemName;
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

    @Temporal(TemporalType.DATE)
    @Column(name="SEND_DATE", length=7)
    public Date getSendDate() {
        return this.sendDate;
    }
    
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ACTIVE_DATE", length=7)
    public Date getActiveDate() {
        return this.activeDate;
    }
    
    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    
    @Column(name="LINKEDCODE", length=15)
    public String getLinkedcode() {
        return this.linkedcode;
    }
    
    public void setLinkedcode(String linkedcode) {
        this.linkedcode = linkedcode;
    }

    
    @Column(name="RECORD_CREATE_TIME", length=20)
    public String getRecordCreateTime() {
        return this.recordCreateTime;
    }
    
    public void setRecordCreateTime(String recordCreateTime) {
        this.recordCreateTime = recordCreateTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_CREATE_DATE", length=7)
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }

    
    @Column(name="RECORD_UPDATE_TIME", length=20)
    public String getRecordUpdateTime() {
        return this.recordUpdateTime;
    }
    
    public void setRecordUpdateTime(String recordUpdateTime) {
        this.recordUpdateTime = recordUpdateTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_UPDATE_DATE", length=7)
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoItemCode")
    public Set<InvoDeptItemJoin> getInvoDeptItemJoins() {
        return this.invoDeptItemJoins;
    }
    
    public void setInvoDeptItemJoins(Set<InvoDeptItemJoin> invoDeptItemJoins) {
        this.invoDeptItemJoins = invoDeptItemJoins;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="invoItemCode")
    public Set<InvoInvoiceMasterItem> getInvoInvoiceMasterItems() {
        return this.invoInvoiceMasterItems;
    }
    
    public void setInvoInvoiceMasterItems(Set<InvoInvoiceMasterItem> invoInvoiceMasterItems) {
        this.invoInvoiceMasterItems = invoInvoiceMasterItems;
    }




}

