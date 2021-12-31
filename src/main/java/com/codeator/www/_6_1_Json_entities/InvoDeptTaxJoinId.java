package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * InvoDeptTaxJoinId generated by hbm2java
 */
public class InvoDeptTaxJoinId  implements java.io.Serializable {


     private String taxType;
     private String taxSubtype;
     private long depNoOld;
     private int sectionNoOld;

    public InvoDeptTaxJoinId() {
    }

    public InvoDeptTaxJoinId(String taxType, String taxSubtype, long depNoOld, int sectionNoOld) {
       this.taxType = taxType;
       this.taxSubtype = taxSubtype;
       this.depNoOld = depNoOld;
       this.sectionNoOld = sectionNoOld;
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
    public long getDepNoOld() {
        return this.depNoOld;
    }
    
    public void setDepNoOld(long depNoOld) {
        this.depNoOld = depNoOld;
    }
    public int getSectionNoOld() {
        return this.sectionNoOld;
    }
    
    public void setSectionNoOld(int sectionNoOld) {
        this.sectionNoOld = sectionNoOld;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InvoDeptTaxJoinId) ) return false;
		 InvoDeptTaxJoinId castOther = ( InvoDeptTaxJoinId ) other; 
         
		 return ( (this.getTaxType()==castOther.getTaxType()) || ( this.getTaxType()!=null && castOther.getTaxType()!=null && this.getTaxType().equals(castOther.getTaxType()) ) )
 && ( (this.getTaxSubtype()==castOther.getTaxSubtype()) || ( this.getTaxSubtype()!=null && castOther.getTaxSubtype()!=null && this.getTaxSubtype().equals(castOther.getTaxSubtype()) ) )
 && (this.getDepNoOld()==castOther.getDepNoOld())
 && (this.getSectionNoOld()==castOther.getSectionNoOld());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTaxType() == null ? 0 : this.getTaxType().hashCode() );
         result = 37 * result + ( getTaxSubtype() == null ? 0 : this.getTaxSubtype().hashCode() );
         result = 37 * result + (int) this.getDepNoOld();
         result = 37 * result + this.getSectionNoOld();
         return result;
   }   


}

