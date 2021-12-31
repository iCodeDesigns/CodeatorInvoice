package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1



/**
 * PerGovernorateCodeId generated by hbm2java
 */
public class PerGovernorateCodeId  implements java.io.Serializable {


     private String countryCode;
     private String govCode;

    public PerGovernorateCodeId() {
    }

    public PerGovernorateCodeId(String countryCode, String govCode) {
       this.countryCode = countryCode;
       this.govCode = govCode;
    }
   
    public String getCountryCode() {
        return this.countryCode;
    }
    
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getGovCode() {
        return this.govCode;
    }
    
    public void setGovCode(String govCode) {
        this.govCode = govCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerGovernorateCodeId) ) return false;
		 PerGovernorateCodeId castOther = ( PerGovernorateCodeId ) other; 
         
		 return ( (this.getCountryCode()==castOther.getCountryCode()) || ( this.getCountryCode()!=null && castOther.getCountryCode()!=null && this.getCountryCode().equals(castOther.getCountryCode()) ) )
 && ( (this.getGovCode()==castOther.getGovCode()) || ( this.getGovCode()!=null && castOther.getGovCode()!=null && this.getGovCode().equals(castOther.getGovCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCountryCode() == null ? 0 : this.getCountryCode().hashCode() );
         result = 37 * result + ( getGovCode() == null ? 0 : this.getGovCode().hashCode() );
         return result;
   }   


}


