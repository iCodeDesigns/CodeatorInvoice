package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleIssueDocumentMainTypeId generated by hbm2java
 */
@Embeddable
public class VcleIssueDocumentMainTypeId  implements java.io.Serializable {


     private boolean vcleDeptType;
     private byte issueMainCode;

    public VcleIssueDocumentMainTypeId() {
    }

    public VcleIssueDocumentMainTypeId(boolean vcleDeptType, byte issueMainCode) {
       this.vcleDeptType = vcleDeptType;
       this.issueMainCode = issueMainCode;
    }
   


    @Column(name="VCLE_DEPT_TYPE", nullable=false, precision=1, scale=0)
    public boolean isVcleDeptType() {
        return this.vcleDeptType;
    }
    
    public void setVcleDeptType(boolean vcleDeptType) {
        this.vcleDeptType = vcleDeptType;
    }


    @Column(name="ISSUE_MAIN_CODE", nullable=false, precision=2, scale=0)
    public byte getIssueMainCode() {
        return this.issueMainCode;
    }
    
    public void setIssueMainCode(byte issueMainCode) {
        this.issueMainCode = issueMainCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleIssueDocumentMainTypeId) ) return false;
		 VcleIssueDocumentMainTypeId castOther = ( VcleIssueDocumentMainTypeId ) other; 
         
		 return (this.isVcleDeptType()==castOther.isVcleDeptType())
 && (this.getIssueMainCode()==castOther.getIssueMainCode());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (this.isVcleDeptType()?1:0);
         result = 37 * result + this.getIssueMainCode();
         return result;
   }   


}


