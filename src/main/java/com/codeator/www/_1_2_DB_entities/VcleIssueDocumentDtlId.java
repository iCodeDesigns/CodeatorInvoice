package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleIssueDocumentDtlId generated by hbm2java
 */
@Embeddable
public class VcleIssueDocumentDtlId  implements java.io.Serializable {


     private Date fiscalDate;
     private int issueDocSp;
     private byte issueDocSerial;

    public VcleIssueDocumentDtlId() {
    }

    public VcleIssueDocumentDtlId(Date fiscalDate, int issueDocSp, byte issueDocSerial) {
       this.fiscalDate = fiscalDate;
       this.issueDocSp = issueDocSp;
       this.issueDocSerial = issueDocSerial;
    }
   


    @Column(name="FISCAL_DATE", nullable=false, length=7)
    public Date getFiscalDate() {
        return this.fiscalDate;
    }
    
    public void setFiscalDate(Date fiscalDate) {
        this.fiscalDate = fiscalDate;
    }


    @Column(name="ISSUE_DOC_SP", nullable=false, precision=6, scale=0)
    public int getIssueDocSp() {
        return this.issueDocSp;
    }
    
    public void setIssueDocSp(int issueDocSp) {
        this.issueDocSp = issueDocSp;
    }


    @Column(name="ISSUE_DOC_SERIAL", nullable=false, precision=2, scale=0)
    public byte getIssueDocSerial() {
        return this.issueDocSerial;
    }
    
    public void setIssueDocSerial(byte issueDocSerial) {
        this.issueDocSerial = issueDocSerial;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleIssueDocumentDtlId) ) return false;
		 VcleIssueDocumentDtlId castOther = ( VcleIssueDocumentDtlId ) other; 
         
		 return ( (this.getFiscalDate()==castOther.getFiscalDate()) || ( this.getFiscalDate()!=null && castOther.getFiscalDate()!=null && this.getFiscalDate().equals(castOther.getFiscalDate()) ) )
 && (this.getIssueDocSp()==castOther.getIssueDocSp())
 && (this.getIssueDocSerial()==castOther.getIssueDocSerial());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFiscalDate() == null ? 0 : this.getFiscalDate().hashCode() );
         result = 37 * result + this.getIssueDocSp();
         result = 37 * result + this.getIssueDocSerial();
         return result;
   }   


}

