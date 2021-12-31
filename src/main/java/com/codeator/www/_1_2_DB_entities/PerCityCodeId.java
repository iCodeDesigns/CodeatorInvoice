package com.codeator.www._1_2_DB_entities;
// Generated Jun 14, 2021 10:15:42 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PerCityCodeId generated by hbm2java
 */
@Embeddable
public class PerCityCodeId  implements java.io.Serializable {


     private String countryCode;
     private String govCode;
     private String cityCode;

    public PerCityCodeId() {
    }

    public PerCityCodeId(String countryCode, String govCode, String cityCode) {
       this.countryCode = countryCode;
       this.govCode = govCode;
       this.cityCode = cityCode;
    }
   


    @Column(name="COUNTRY_CODE", nullable=false, length=5)
    public String getCountryCode() {
        return this.countryCode;
    }
    
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    @Column(name="GOV_CODE", nullable=false, length=5)
    public String getGovCode() {
        return this.govCode;
    }
    
    public void setGovCode(String govCode) {
        this.govCode = govCode;
    }


    @Column(name="CITY_CODE", nullable=false, length=5)
    public String getCityCode() {
        return this.cityCode;
    }
    
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PerCityCodeId) ) return false;
		 PerCityCodeId castOther = ( PerCityCodeId ) other; 
         
		 return ( (this.getCountryCode()==castOther.getCountryCode()) || ( this.getCountryCode()!=null && castOther.getCountryCode()!=null && this.getCountryCode().equals(castOther.getCountryCode()) ) )
 && ( (this.getGovCode()==castOther.getGovCode()) || ( this.getGovCode()!=null && castOther.getGovCode()!=null && this.getGovCode().equals(castOther.getGovCode()) ) )
 && ( (this.getCityCode()==castOther.getCityCode()) || ( this.getCityCode()!=null && castOther.getCityCode()!=null && this.getCityCode().equals(castOther.getCityCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCountryCode() == null ? 0 : this.getCountryCode().hashCode() );
         result = 37 * result + ( getGovCode() == null ? 0 : this.getGovCode().hashCode() );
         result = 37 * result + ( getCityCode() == null ? 0 : this.getCityCode().hashCode() );
         return result;
   }   


}

