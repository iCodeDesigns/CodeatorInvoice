package com.codeator.www._1_2_DB_entities;
// Generated Mar 21, 2021 6:34:02 PM by Hibernate Tools 4.3.1


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
 * StoResponsibilityHistoryEmp generated by hbm2java
 */
@Entity
@Table(name="STO_RESPONSIBILITY_HISTORY_EMP"
    ,schema="CODEATOR"
)
public class StoResponsibilityHistoryEmp  implements java.io.Serializable {


     private StoResponsibilityHistoryEmpId id;
     private PerEmploymentMaster perEmploymentMaster;
     private String itemName;
     private boolean recvType;
     private Date eznDate;
     private BigDecimal qty;
     private String itemDesc;
     private String itemNumberResp;
     private Long eznNo;
     private BigDecimal qtyInitial;
     private Long employeeNo;
     private BigDecimal sal;
     private BigDecimal val;
     private Boolean statusItem;
     private Short unitCode;
     private Short unitCodeInitial;
     private Date issueDateInitial;
     private Boolean chkItem;
     private Long employeeNoTo;
     private Long employeeIdTo;
     private String itemInclude;
     private Long userId;
     private String rmrk;
     private Long employeeNoErr;
     private Boolean chkItemOk;
     private String cateCode;
     private String groupCode;
     private String sectionCode;
     private String itemCode;
     private Long itemDigital;
     private Integer mslAbg;
     private String itemClass;
     private String serialNo;
     private Boolean respTypeAct;
     private String itemEdd;
     private Set<StoResponsibilityHistoryDel> stoResponsibilityHistoryDels = new HashSet<StoResponsibilityHistoryDel>(0);
     private Set<StoResponsibilityHistoryDtl> stoResponsibilityHistoryDtls = new HashSet<StoResponsibilityHistoryDtl>(0);

    public StoResponsibilityHistoryEmp() {
    }

	
    public StoResponsibilityHistoryEmp(StoResponsibilityHistoryEmpId id, PerEmploymentMaster perEmploymentMaster, boolean recvType, Date eznDate) {
        this.id = id;
        this.perEmploymentMaster = perEmploymentMaster;
        this.recvType = recvType;
        this.eznDate = eznDate;
    }
    public StoResponsibilityHistoryEmp(StoResponsibilityHistoryEmpId id, PerEmploymentMaster perEmploymentMaster, String itemName, boolean recvType, Date eznDate, BigDecimal qty, String itemDesc, String itemNumberResp, Long eznNo, BigDecimal qtyInitial, Long employeeNo, BigDecimal sal, BigDecimal val, Boolean statusItem, Short unitCode, Short unitCodeInitial, Date issueDateInitial, Boolean chkItem, Long employeeNoTo, Long employeeIdTo, String itemInclude, Long userId, String rmrk, Long employeeNoErr, Boolean chkItemOk, String cateCode, String groupCode, String sectionCode, String itemCode, Long itemDigital, Integer mslAbg, String itemClass, String serialNo, Boolean respTypeAct, String itemEdd, Set<StoResponsibilityHistoryDel> stoResponsibilityHistoryDels, Set<StoResponsibilityHistoryDtl> stoResponsibilityHistoryDtls) {
       this.id = id;
       this.perEmploymentMaster = perEmploymentMaster;
       this.itemName = itemName;
       this.recvType = recvType;
       this.eznDate = eznDate;
       this.qty = qty;
       this.itemDesc = itemDesc;
       this.itemNumberResp = itemNumberResp;
       this.eznNo = eznNo;
       this.qtyInitial = qtyInitial;
       this.employeeNo = employeeNo;
       this.sal = sal;
       this.val = val;
       this.statusItem = statusItem;
       this.unitCode = unitCode;
       this.unitCodeInitial = unitCodeInitial;
       this.issueDateInitial = issueDateInitial;
       this.chkItem = chkItem;
       this.employeeNoTo = employeeNoTo;
       this.employeeIdTo = employeeIdTo;
       this.itemInclude = itemInclude;
       this.userId = userId;
       this.rmrk = rmrk;
       this.employeeNoErr = employeeNoErr;
       this.chkItemOk = chkItemOk;
       this.cateCode = cateCode;
       this.groupCode = groupCode;
       this.sectionCode = sectionCode;
       this.itemCode = itemCode;
       this.itemDigital = itemDigital;
       this.mslAbg = mslAbg;
       this.itemClass = itemClass;
       this.serialNo = serialNo;
       this.respTypeAct = respTypeAct;
       this.itemEdd = itemEdd;
       this.stoResponsibilityHistoryDels = stoResponsibilityHistoryDels;
       this.stoResponsibilityHistoryDtls = stoResponsibilityHistoryDtls;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="employeeId", column=@Column(name="EMPLOYEE_ID", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="respSp", column=@Column(name="RESP_SP", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="respType", column=@Column(name="RESP_TYPE", nullable=false, precision=1, scale=0) ) } )
    public StoResponsibilityHistoryEmpId getId() {
        return this.id;
    }
    
    public void setId(StoResponsibilityHistoryEmpId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
    public PerEmploymentMaster getPerEmploymentMaster() {
        return this.perEmploymentMaster;
    }
    
    public void setPerEmploymentMaster(PerEmploymentMaster perEmploymentMaster) {
        this.perEmploymentMaster = perEmploymentMaster;
    }

    
    @Column(name="ITEM_NAME", length=200)
    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    
    @Column(name="RECV_TYPE", nullable=false, precision=1, scale=0)
    public boolean isRecvType() {
        return this.recvType;
    }
    
    public void setRecvType(boolean recvType) {
        this.recvType = recvType;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="EZN_DATE", nullable=false, length=7)
    public Date getEznDate() {
        return this.eznDate;
    }
    
    public void setEznDate(Date eznDate) {
        this.eznDate = eznDate;
    }

    
    @Column(name="QTY", precision=11, scale=3)
    public BigDecimal getQty() {
        return this.qty;
    }
    
    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    
    @Column(name="ITEM_DESC", length=200)
    public String getItemDesc() {
        return this.itemDesc;
    }
    
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    
    @Column(name="ITEM_NUMBER_RESP", length=6)
    public String getItemNumberResp() {
        return this.itemNumberResp;
    }
    
    public void setItemNumberResp(String itemNumberResp) {
        this.itemNumberResp = itemNumberResp;
    }

    
    @Column(name="EZN_NO", precision=11, scale=0)
    public Long getEznNo() {
        return this.eznNo;
    }
    
    public void setEznNo(Long eznNo) {
        this.eznNo = eznNo;
    }

    
    @Column(name="QTY_INITIAL", precision=11, scale=3)
    public BigDecimal getQtyInitial() {
        return this.qtyInitial;
    }
    
    public void setQtyInitial(BigDecimal qtyInitial) {
        this.qtyInitial = qtyInitial;
    }

    
    @Column(name="EMPLOYEE_NO", precision=10, scale=0)
    public Long getEmployeeNo() {
        return this.employeeNo;
    }
    
    public void setEmployeeNo(Long employeeNo) {
        this.employeeNo = employeeNo;
    }

    
    @Column(name="SAL", precision=11, scale=3)
    public BigDecimal getSal() {
        return this.sal;
    }
    
    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    
    @Column(name="VAL", precision=20, scale=3)
    public BigDecimal getVal() {
        return this.val;
    }
    
    public void setVal(BigDecimal val) {
        this.val = val;
    }

    
    @Column(name="STATUS_ITEM", precision=1, scale=0)
    public Boolean getStatusItem() {
        return this.statusItem;
    }
    
    public void setStatusItem(Boolean statusItem) {
        this.statusItem = statusItem;
    }

    
    @Column(name="UNIT_CODE", precision=3, scale=0)
    public Short getUnitCode() {
        return this.unitCode;
    }
    
    public void setUnitCode(Short unitCode) {
        this.unitCode = unitCode;
    }

    
    @Column(name="UNIT_CODE_INITIAL", precision=3, scale=0)
    public Short getUnitCodeInitial() {
        return this.unitCodeInitial;
    }
    
    public void setUnitCodeInitial(Short unitCodeInitial) {
        this.unitCodeInitial = unitCodeInitial;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ISSUE_DATE_INITIAL", length=7)
    public Date getIssueDateInitial() {
        return this.issueDateInitial;
    }
    
    public void setIssueDateInitial(Date issueDateInitial) {
        this.issueDateInitial = issueDateInitial;
    }

    
    @Column(name="CHK_ITEM", precision=1, scale=0)
    public Boolean getChkItem() {
        return this.chkItem;
    }
    
    public void setChkItem(Boolean chkItem) {
        this.chkItem = chkItem;
    }

    
    @Column(name="EMPLOYEE_NO_TO", precision=10, scale=0)
    public Long getEmployeeNoTo() {
        return this.employeeNoTo;
    }
    
    public void setEmployeeNoTo(Long employeeNoTo) {
        this.employeeNoTo = employeeNoTo;
    }

    
    @Column(name="EMPLOYEE_ID_TO", precision=10, scale=0)
    public Long getEmployeeIdTo() {
        return this.employeeIdTo;
    }
    
    public void setEmployeeIdTo(Long employeeIdTo) {
        this.employeeIdTo = employeeIdTo;
    }

    
    @Column(name="ITEM_INCLUDE", length=200)
    public String getItemInclude() {
        return this.itemInclude;
    }
    
    public void setItemInclude(String itemInclude) {
        this.itemInclude = itemInclude;
    }

    
    @Column(name="USER_ID", precision=10, scale=0)
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
    @Column(name="RMRK", length=200)
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }

    
    @Column(name="EMPLOYEE_NO_ERR", precision=10, scale=0)
    public Long getEmployeeNoErr() {
        return this.employeeNoErr;
    }
    
    public void setEmployeeNoErr(Long employeeNoErr) {
        this.employeeNoErr = employeeNoErr;
    }

    
    @Column(name="CHK_ITEM_OK", precision=1, scale=0)
    public Boolean getChkItemOk() {
        return this.chkItemOk;
    }
    
    public void setChkItemOk(Boolean chkItemOk) {
        this.chkItemOk = chkItemOk;
    }

    
    @Column(name="CATE_CODE", length=2)
    public String getCateCode() {
        return this.cateCode;
    }
    
    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    
    @Column(name="GROUP_CODE", length=3)
    public String getGroupCode() {
        return this.groupCode;
    }
    
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    
    @Column(name="SECTION_CODE", length=3)
    public String getSectionCode() {
        return this.sectionCode;
    }
    
    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    
    @Column(name="ITEM_CODE", length=3)
    public String getItemCode() {
        return this.itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    
    @Column(name="ITEM_DIGITAL", precision=11, scale=0)
    public Long getItemDigital() {
        return this.itemDigital;
    }
    
    public void setItemDigital(Long itemDigital) {
        this.itemDigital = itemDigital;
    }

    
    @Column(name="MSL_ABG", precision=6, scale=0)
    public Integer getMslAbg() {
        return this.mslAbg;
    }
    
    public void setMslAbg(Integer mslAbg) {
        this.mslAbg = mslAbg;
    }

    
    @Column(name="ITEM_CLASS", length=200)
    public String getItemClass() {
        return this.itemClass;
    }
    
    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    
    @Column(name="SERIAL_NO", length=60)
    public String getSerialNo() {
        return this.serialNo;
    }
    
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    
    @Column(name="RESP_TYPE_ACT", precision=1, scale=0)
    public Boolean getRespTypeAct() {
        return this.respTypeAct;
    }
    
    public void setRespTypeAct(Boolean respTypeAct) {
        this.respTypeAct = respTypeAct;
    }

    
    @Column(name="ITEM_EDD", length=200)
    public String getItemEdd() {
        return this.itemEdd;
    }
    
    public void setItemEdd(String itemEdd) {
        this.itemEdd = itemEdd;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="stoResponsibilityHistoryEmp")
    public Set<StoResponsibilityHistoryDel> getStoResponsibilityHistoryDels() {
        return this.stoResponsibilityHistoryDels;
    }
    
    public void setStoResponsibilityHistoryDels(Set<StoResponsibilityHistoryDel> stoResponsibilityHistoryDels) {
        this.stoResponsibilityHistoryDels = stoResponsibilityHistoryDels;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="stoResponsibilityHistoryEmp")
    public Set<StoResponsibilityHistoryDtl> getStoResponsibilityHistoryDtls() {
        return this.stoResponsibilityHistoryDtls;
    }
    
    public void setStoResponsibilityHistoryDtls(Set<StoResponsibilityHistoryDtl> stoResponsibilityHistoryDtls) {
        this.stoResponsibilityHistoryDtls = stoResponsibilityHistoryDtls;
    }




}

