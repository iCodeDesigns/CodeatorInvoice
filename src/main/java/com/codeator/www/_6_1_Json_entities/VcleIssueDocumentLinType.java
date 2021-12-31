package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VcleIssueDocumentLinType generated by hbm2java
 */
public class VcleIssueDocumentLinType  implements java.io.Serializable {


     private VcleIssueDocumentLinTypeId id;
     private VcleIssueDocumentMainType vcleIssueDocumentMainType;
     private VcleIssueDocumentLin vcleIssueDocumentLin;
     private Byte docCount;
     private Date docDate;
     private Long docNo;
     private String rmrk;

    public VcleIssueDocumentLinType() {
    }

	
    public VcleIssueDocumentLinType(VcleIssueDocumentLinTypeId id, VcleIssueDocumentLin vcleIssueDocumentLin) {
        this.id = id;
        this.vcleIssueDocumentLin = vcleIssueDocumentLin;
    }
    public VcleIssueDocumentLinType(VcleIssueDocumentLinTypeId id, VcleIssueDocumentMainType vcleIssueDocumentMainType, VcleIssueDocumentLin vcleIssueDocumentLin, Byte docCount, Date docDate, Long docNo, String rmrk) {
       this.id = id;
       this.vcleIssueDocumentMainType = vcleIssueDocumentMainType;
       this.vcleIssueDocumentLin = vcleIssueDocumentLin;
       this.docCount = docCount;
       this.docDate = docDate;
       this.docNo = docNo;
       this.rmrk = rmrk;
    }
   
    public VcleIssueDocumentLinTypeId getId() {
        return this.id;
    }
    
    public void setId(VcleIssueDocumentLinTypeId id) {
        this.id = id;
    }
    public VcleIssueDocumentMainType getVcleIssueDocumentMainType() {
        return this.vcleIssueDocumentMainType;
    }
    
    public void setVcleIssueDocumentMainType(VcleIssueDocumentMainType vcleIssueDocumentMainType) {
        this.vcleIssueDocumentMainType = vcleIssueDocumentMainType;
    }
    public VcleIssueDocumentLin getVcleIssueDocumentLin() {
        return this.vcleIssueDocumentLin;
    }
    
    public void setVcleIssueDocumentLin(VcleIssueDocumentLin vcleIssueDocumentLin) {
        this.vcleIssueDocumentLin = vcleIssueDocumentLin;
    }
    public Byte getDocCount() {
        return this.docCount;
    }
    
    public void setDocCount(Byte docCount) {
        this.docCount = docCount;
    }
    public Date getDocDate() {
        return this.docDate;
    }
    
    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }
    public Long getDocNo() {
        return this.docNo;
    }
    
    public void setDocNo(Long docNo) {
        this.docNo = docNo;
    }
    public String getRmrk() {
        return this.rmrk;
    }
    
    public void setRmrk(String rmrk) {
        this.rmrk = rmrk;
    }




}


