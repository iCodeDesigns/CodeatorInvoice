package com.codeator.www._1_2_DB_entities;
// Generated Sep 16, 2021 11:27:10 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InvoAccUintDeptId generated by hbm2java
 */
@Embeddable
public class InvoAccUintDeptId  implements java.io.Serializable {


     private String accUnitCode;
     private long depNoOld;
     private int sectionNoOld;

    public InvoAccUintDeptId() {
    }

    public InvoAccUintDeptId(String accUnitCode, long depNoOld, int sectionNoOld) {
       this.accUnitCode = accUnitCode;
       this.depNoOld = depNoOld;
       this.sectionNoOld = sectionNoOld;
    }
   


    @Column(name="ACC_UNIT_CODE", nullable=false, length=2)
    public String getAccUnitCode() {
        return this.accUnitCode;
    }
    
    public void setAccUnitCode(String accUnitCode) {
        this.accUnitCode = accUnitCode;
    }


    @Column(name="DEP_NO_OLD", nullable=false, precision=10, scale=0)
    public long getDepNoOld() {
        return this.depNoOld;
    }
    
    public void setDepNoOld(long depNoOld) {
        this.depNoOld = depNoOld;
    }


    @Column(name="SECTION_NO_OLD", nullable=false, precision=5, scale=0)
    public int getSectionNoOld() {
        return this.sectionNoOld;
    }
    
    public void setSectionNoOld(int sectionNoOld) {
        this.sectionNoOld = sectionNoOld;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InvoAccUintDeptId) ) return false;
		 InvoAccUintDeptId castOther = ( InvoAccUintDeptId ) other; 
         
		 return ( (this.getAccUnitCode()==castOther.getAccUnitCode()) || ( this.getAccUnitCode()!=null && castOther.getAccUnitCode()!=null && this.getAccUnitCode().equals(castOther.getAccUnitCode()) ) )
 && (this.getDepNoOld()==castOther.getDepNoOld())
 && (this.getSectionNoOld()==castOther.getSectionNoOld());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAccUnitCode() == null ? 0 : this.getAccUnitCode().hashCode() );
         result = 37 * result + (int) this.getDepNoOld();
         result = 37 * result + this.getSectionNoOld();
         return result;
   }   


}

