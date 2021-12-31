package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * StoItemCateGroupId generated by hbm2java
 */
public class StoItemCateGroupId  implements java.io.Serializable {


     private String cateCode;
     private String groupCode;

    public StoItemCateGroupId() {
    }

    public StoItemCateGroupId(String cateCode, String groupCode) {
       this.cateCode = cateCode;
       this.groupCode = groupCode;
    }
   
    public String getCateCode() {
        return this.cateCode;
    }
    
    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }
    public String getGroupCode() {
        return this.groupCode;
    }
    
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StoItemCateGroupId) ) return false;
		 StoItemCateGroupId castOther = ( StoItemCateGroupId ) other; 
         
		 return ( (this.getCateCode()==castOther.getCateCode()) || ( this.getCateCode()!=null && castOther.getCateCode()!=null && this.getCateCode().equals(castOther.getCateCode()) ) )
 && ( (this.getGroupCode()==castOther.getGroupCode()) || ( this.getGroupCode()!=null && castOther.getGroupCode()!=null && this.getGroupCode().equals(castOther.getGroupCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCateCode() == null ? 0 : this.getCateCode().hashCode() );
         result = 37 * result + ( getGroupCode() == null ? 0 : this.getGroupCode().hashCode() );
         return result;
   }   


}


