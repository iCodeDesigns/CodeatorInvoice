package com.codeator.www._1_2_DB_entities;
// Generated Sep 1, 2020 9:49:26 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VcleDeptNumberUserId generated by hbm2java
 */
@Embeddable
public class VcleDeptNumberUserId  implements java.io.Serializable {


     private BigDecimal userId;
     private int deptId;

    public VcleDeptNumberUserId() {
    }

    public VcleDeptNumberUserId(BigDecimal userId, int deptId) {
       this.userId = userId;
       this.deptId = deptId;
    }
   


    @Column(name="USER_ID", nullable=false, precision=22, scale=0)
    public BigDecimal getUserId() {
        return this.userId;
    }
    
    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }


    @Column(name="DEPT_ID", nullable=false, precision=7, scale=0)
    public int getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VcleDeptNumberUserId) ) return false;
		 VcleDeptNumberUserId castOther = ( VcleDeptNumberUserId ) other; 
         
		 return ( (this.getUserId()==castOther.getUserId()) || ( this.getUserId()!=null && castOther.getUserId()!=null && this.getUserId().equals(castOther.getUserId()) ) )
 && (this.getDeptId()==castOther.getDeptId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUserId() == null ? 0 : this.getUserId().hashCode() );
         result = 37 * result + this.getDeptId();
         return result;
   }   


}

