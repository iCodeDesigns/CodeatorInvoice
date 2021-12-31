package com.codeator.www._1_2_DB_entities;
// Generated Sep 12, 2021 9:58:05 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * InvoDeptUnitJoinId generated by hbm2java
 */
@Embeddable
public class InvoDeptUnitJoinId  implements java.io.Serializable {


     private String unitType;
     private long depNoOld;
     private int sectionNoOld;
     private String accUnitCode;

    public InvoDeptUnitJoinId() {
    }

    public InvoDeptUnitJoinId(String unitType, long depNoOld, int sectionNoOld, String accUnitCode) {
       this.unitType = unitType;
       this.depNoOld = depNoOld;
       this.sectionNoOld = sectionNoOld;
       this.accUnitCode = accUnitCode;
    }
   


    @Column(name="UNIT_TYPE", nullable=false, length=5)
    public String getUnitType() {
        return this.unitType;
    }
    
    public void setUnitType(String unitType) {
        this.unitType = unitType;
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


    @Column(name="ACC_UNIT_CODE", nullable=false, length=2)
    public String getAccUnitCode() {
        return this.accUnitCode;
    }
    
    public void setAccUnitCode(String accUnitCode) {
        this.accUnitCode = accUnitCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof InvoDeptUnitJoinId) ) return false;
		 InvoDeptUnitJoinId castOther = ( InvoDeptUnitJoinId ) other; 
         
		 return ( (this.getUnitType()==castOther.getUnitType()) || ( this.getUnitType()!=null && castOther.getUnitType()!=null && this.getUnitType().equals(castOther.getUnitType()) ) )
 && (this.getDepNoOld()==castOther.getDepNoOld())
 && (this.getSectionNoOld()==castOther.getSectionNoOld())
 && ( (this.getAccUnitCode()==castOther.getAccUnitCode()) || ( this.getAccUnitCode()!=null && castOther.getAccUnitCode()!=null && this.getAccUnitCode().equals(castOther.getAccUnitCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUnitType() == null ? 0 : this.getUnitType().hashCode() );
         result = 37 * result + (int) this.getDepNoOld();
         result = 37 * result + this.getSectionNoOld();
         result = 37 * result + ( getAccUnitCode() == null ? 0 : this.getAccUnitCode().hashCode() );
         return result;
   }   


}


