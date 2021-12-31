package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * StoItemCateGroupSecId generated by hbm2java
 */
public class StoItemCateGroupSecId  implements java.io.Serializable {


     private String groupCode;
     private String cateCode;
     private String sectionCode;

    public StoItemCateGroupSecId() {
    }

    public StoItemCateGroupSecId(String groupCode, String cateCode, String sectionCode) {
       this.groupCode = groupCode;
       this.cateCode = cateCode;
       this.sectionCode = sectionCode;
    }
   
    public String getGroupCode() {
        return this.groupCode;
    }
    
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
    public String getCateCode() {
        return this.cateCode;
    }
    
    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }
    public String getSectionCode() {
        return this.sectionCode;
    }
    
    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StoItemCateGroupSecId) ) return false;
		 StoItemCateGroupSecId castOther = ( StoItemCateGroupSecId ) other; 
         
		 return ( (this.getGroupCode()==castOther.getGroupCode()) || ( this.getGroupCode()!=null && castOther.getGroupCode()!=null && this.getGroupCode().equals(castOther.getGroupCode()) ) )
 && ( (this.getCateCode()==castOther.getCateCode()) || ( this.getCateCode()!=null && castOther.getCateCode()!=null && this.getCateCode().equals(castOther.getCateCode()) ) )
 && ( (this.getSectionCode()==castOther.getSectionCode()) || ( this.getSectionCode()!=null && castOther.getSectionCode()!=null && this.getSectionCode().equals(castOther.getSectionCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getGroupCode() == null ? 0 : this.getGroupCode().hashCode() );
         result = 37 * result + ( getCateCode() == null ? 0 : this.getCateCode().hashCode() );
         result = 37 * result + ( getSectionCode() == null ? 0 : this.getSectionCode().hashCode() );
         return result;
   }   


}


