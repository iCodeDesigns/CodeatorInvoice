package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * InvoDeptItemJoinId generated by hbm2java
 */
public class InvoDeptItemJoinId  implements java.io.Serializable {


     private int sectionNoOld;
     private long depNoOld;
     private String itemCode;

    public InvoDeptItemJoinId() {
    }

    public InvoDeptItemJoinId(int sectionNoOld, long depNoOld, String itemCode) {
       this.sectionNoOld = sectionNoOld;
       this.depNoOld = depNoOld;
       this.itemCode = itemCode;
    }
   
    public int getSectionNoOld() {
        return this.sectionNoOld;
    }
    
    public void setSectionNoOld(int sectionNoOld) {
        this.sectionNoOld = sectionNoOld;
    }
    public long getDepNoOld() {
        return this.depNoOld;
    }
    
    public void setDepNoOld(long depNoOld) {
        this.depNoOld = depNoOld;
    }
    public String getItemCode() {
        return this.itemCode;
    }
    
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InvoDeptItemJoinId) ) return false;
		 InvoDeptItemJoinId castOther = ( InvoDeptItemJoinId ) other; 
         
		 return (this.getSectionNoOld()==castOther.getSectionNoOld())
 && (this.getDepNoOld()==castOther.getDepNoOld())
 && ( (this.getItemCode()==castOther.getItemCode()) || ( this.getItemCode()!=null && castOther.getItemCode()!=null && this.getItemCode().equals(castOther.getItemCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSectionNoOld();
         result = 37 * result + (int) this.getDepNoOld();
         result = 37 * result + ( getItemCode() == null ? 0 : this.getItemCode().hashCode() );
         return result;
   }   


}

