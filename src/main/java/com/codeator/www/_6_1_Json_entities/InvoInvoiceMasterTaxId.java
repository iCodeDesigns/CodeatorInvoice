package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * InvoInvoiceMasterTaxId generated by hbm2java
 */
public class InvoInvoiceMasterTaxId  implements java.io.Serializable {


     private int sectionNoOld;
     private int invoSpItem;
     private long depNoOld;
     private long invoSp;
     private String taxType;
     private String taxSubtype;

    public InvoInvoiceMasterTaxId() {
    }

    public InvoInvoiceMasterTaxId(int sectionNoOld, int invoSpItem, long depNoOld, long invoSp, String taxType, String taxSubtype) {
       this.sectionNoOld = sectionNoOld;
       this.invoSpItem = invoSpItem;
       this.depNoOld = depNoOld;
       this.invoSp = invoSp;
       this.taxType = taxType;
       this.taxSubtype = taxSubtype;
    }
   
    public int getSectionNoOld() {
        return this.sectionNoOld;
    }
    
    public void setSectionNoOld(int sectionNoOld) {
        this.sectionNoOld = sectionNoOld;
    }
    public int getInvoSpItem() {
        return this.invoSpItem;
    }
    
    public void setInvoSpItem(int invoSpItem) {
        this.invoSpItem = invoSpItem;
    }
    public long getDepNoOld() {
        return this.depNoOld;
    }
    
    public void setDepNoOld(long depNoOld) {
        this.depNoOld = depNoOld;
    }
    public long getInvoSp() {
        return this.invoSp;
    }
    
    public void setInvoSp(long invoSp) {
        this.invoSp = invoSp;
    }
    public String getTaxType() {
        return this.taxType;
    }
    
    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }
    public String getTaxSubtype() {
        return this.taxSubtype;
    }
    
    public void setTaxSubtype(String taxSubtype) {
        this.taxSubtype = taxSubtype;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InvoInvoiceMasterTaxId) ) return false;
		 InvoInvoiceMasterTaxId castOther = ( InvoInvoiceMasterTaxId ) other; 
         
		 return (this.getSectionNoOld()==castOther.getSectionNoOld())
 && (this.getInvoSpItem()==castOther.getInvoSpItem())
 && (this.getDepNoOld()==castOther.getDepNoOld())
 && (this.getInvoSp()==castOther.getInvoSp())
 && ( (this.getTaxType()==castOther.getTaxType()) || ( this.getTaxType()!=null && castOther.getTaxType()!=null && this.getTaxType().equals(castOther.getTaxType()) ) )
 && ( (this.getTaxSubtype()==castOther.getTaxSubtype()) || ( this.getTaxSubtype()!=null && castOther.getTaxSubtype()!=null && this.getTaxSubtype().equals(castOther.getTaxSubtype()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSectionNoOld();
         result = 37 * result + this.getInvoSpItem();
         result = 37 * result + (int) this.getDepNoOld();
         result = 37 * result + (int) this.getInvoSp();
         result = 37 * result + ( getTaxType() == null ? 0 : this.getTaxType().hashCode() );
         result = 37 * result + ( getTaxSubtype() == null ? 0 : this.getTaxSubtype().hashCode() );
         return result;
   }   


}


