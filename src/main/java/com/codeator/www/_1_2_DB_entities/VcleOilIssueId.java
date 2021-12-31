package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleOilIssueId generated by hbm2java
 */
@Embeddable
public class VcleOilIssueId  implements java.io.Serializable {


     private Date execDate;
     private int issueSp;
     private Date fiscalDate;

    public VcleOilIssueId() {
    }

    public VcleOilIssueId(Date execDate, int issueSp, Date fiscalDate) {
       this.execDate = execDate;
       this.issueSp = issueSp;
       this.fiscalDate = fiscalDate;
    }
   


    @Column(name="EXEC_DATE", nullable=false, length=7)
    public Date getExecDate() {
        return this.execDate;
    }
    
    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }


    @Column(name="ISSUE_SP", nullable=false, precision=9, scale=0)
    public int getIssueSp() {
        return this.issueSp;
    }
    
    public void setIssueSp(int issueSp) {
        this.issueSp = issueSp;
    }


    @Column(name="FISCAL_DATE", nullable=false, length=7)
    public Date getFiscalDate() {
        return this.fiscalDate;
    }
    
    public void setFiscalDate(Date fiscalDate) {
        this.fiscalDate = fiscalDate;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleOilIssueId) ) return false;
		 VcleOilIssueId castOther = ( VcleOilIssueId ) other; 
         
		 return ( (this.getExecDate()==castOther.getExecDate()) || ( this.getExecDate()!=null && castOther.getExecDate()!=null && this.getExecDate().equals(castOther.getExecDate()) ) )
 && (this.getIssueSp()==castOther.getIssueSp())
 && ( (this.getFiscalDate()==castOther.getFiscalDate()) || ( this.getFiscalDate()!=null && castOther.getFiscalDate()!=null && this.getFiscalDate().equals(castOther.getFiscalDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getExecDate() == null ? 0 : this.getExecDate().hashCode() );
         result = 37 * result + this.getIssueSp();
         result = 37 * result + ( getFiscalDate() == null ? 0 : this.getFiscalDate().hashCode() );
         return result;
   }   


}

