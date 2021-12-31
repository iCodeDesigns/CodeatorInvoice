package com.codeator.www._1_2_DB_entities;
// Generated Sep 11, 2021 5:44:32 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InvoInvoiceMasterTaxId generated by hbm2java
 */
@Embeddable
public class InvoInvoiceMasterTaxId  implements java.io.Serializable {


     private String accUnitCode;
     private int sectionNoOld;
     private long depNoOld;
     private int invoSpItem;
     private long invoSp;
     private String taxSubtype;
     private String taxType;

    public InvoInvoiceMasterTaxId() {
    }

    public InvoInvoiceMasterTaxId(String accUnitCode, int sectionNoOld, long depNoOld, int invoSpItem, long invoSp, String taxSubtype, String taxType) {
       this.accUnitCode = accUnitCode;
       this.sectionNoOld = sectionNoOld;
       this.depNoOld = depNoOld;
       this.invoSpItem = invoSpItem;
       this.invoSp = invoSp;
       this.taxSubtype = taxSubtype;
       this.taxType = taxType;
    }
   


    @Column(name="ACC_UNIT_CODE", nullable=false, length=2)
    public String getAccUnitCode() {
        return this.accUnitCode;
    }
    
    public void setAccUnitCode(String accUnitCode) {
        this.accUnitCode = accUnitCode;
    }


    @Column(name="SECTION_NO_OLD", nullable=false, precision=5, scale=0)
    public int getSectionNoOld() {
        return this.sectionNoOld;
    }
    
    public void setSectionNoOld(int sectionNoOld) {
        this.sectionNoOld = sectionNoOld;
    }


    @Column(name="DEP_NO_OLD", nullable=false, precision=10, scale=0)
    public long getDepNoOld() {
        return this.depNoOld;
    }
    
    public void setDepNoOld(long depNoOld) {
        this.depNoOld = depNoOld;
    }


    @Column(name="INVO_SP_ITEM", nullable=false, precision=5, scale=0)
    public int getInvoSpItem() {
        return this.invoSpItem;
    }
    
    public void setInvoSpItem(int invoSpItem) {
        this.invoSpItem = invoSpItem;
    }


    @Column(name="INVO_SP", nullable=false, precision=16, scale=0)
    public long getInvoSp() {
        return this.invoSp;
    }
    
    public void setInvoSp(long invoSp) {
        this.invoSp = invoSp;
    }


    @Column(name="TAX_SUBTYPE", nullable=false, length=5)
    public String getTaxSubtype() {
        return this.taxSubtype;
    }
    
    public void setTaxSubtype(String taxSubtype) {
        this.taxSubtype = taxSubtype;
    }


    @Column(name="TAX_TYPE", nullable=false, length=5)
    public String getTaxType() {
        return this.taxType;
    }
    
    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InvoInvoiceMasterTaxId) ) return false;
		 InvoInvoiceMasterTaxId castOther = ( InvoInvoiceMasterTaxId ) other; 
         
		 return ( (this.getAccUnitCode()==castOther.getAccUnitCode()) || ( this.getAccUnitCode()!=null && castOther.getAccUnitCode()!=null && this.getAccUnitCode().equals(castOther.getAccUnitCode()) ) )
 && (this.getSectionNoOld()==castOther.getSectionNoOld())
 && (this.getDepNoOld()==castOther.getDepNoOld())
 && (this.getInvoSpItem()==castOther.getInvoSpItem())
 && (this.getInvoSp()==castOther.getInvoSp())
 && ( (this.getTaxSubtype()==castOther.getTaxSubtype()) || ( this.getTaxSubtype()!=null && castOther.getTaxSubtype()!=null && this.getTaxSubtype().equals(castOther.getTaxSubtype()) ) )
 && ( (this.getTaxType()==castOther.getTaxType()) || ( this.getTaxType()!=null && castOther.getTaxType()!=null && this.getTaxType().equals(castOther.getTaxType()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAccUnitCode() == null ? 0 : this.getAccUnitCode().hashCode() );
         result = 37 * result + this.getSectionNoOld();
         result = 37 * result + (int) this.getDepNoOld();
         result = 37 * result + this.getInvoSpItem();
         result = 37 * result + (int) this.getInvoSp();
         result = 37 * result + ( getTaxSubtype() == null ? 0 : this.getTaxSubtype().hashCode() );
         result = 37 * result + ( getTaxType() == null ? 0 : this.getTaxType().hashCode() );
         return result;
   }   


}

