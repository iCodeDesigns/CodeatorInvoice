package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * VcleFuelOpenDay generated by hbm2java
 */
public class VcleFuelOpenDay  implements java.io.Serializable {


     private Date execDate;
     private Date approvalDate;
     private Boolean chkLockDay;
     private Set vcleFuelProvideLiquids = new HashSet(0);
     private Set vcleFuelBalanceLiquids = new HashSet(0);
     private Set vcleFuelIssueLiquids = new HashSet(0);

    public VcleFuelOpenDay() {
    }

	
    public VcleFuelOpenDay(Date execDate) {
        this.execDate = execDate;
    }
    public VcleFuelOpenDay(Date execDate, Date approvalDate, Boolean chkLockDay, Set vcleFuelProvideLiquids, Set vcleFuelBalanceLiquids, Set vcleFuelIssueLiquids) {
       this.execDate = execDate;
       this.approvalDate = approvalDate;
       this.chkLockDay = chkLockDay;
       this.vcleFuelProvideLiquids = vcleFuelProvideLiquids;
       this.vcleFuelBalanceLiquids = vcleFuelBalanceLiquids;
       this.vcleFuelIssueLiquids = vcleFuelIssueLiquids;
    }
   
    public Date getExecDate() {
        return this.execDate;
    }
    
    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }
    public Date getApprovalDate() {
        return this.approvalDate;
    }
    
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
    public Boolean getChkLockDay() {
        return this.chkLockDay;
    }
    
    public void setChkLockDay(Boolean chkLockDay) {
        this.chkLockDay = chkLockDay;
    }
    public Set getVcleFuelProvideLiquids() {
        return this.vcleFuelProvideLiquids;
    }
    
    public void setVcleFuelProvideLiquids(Set vcleFuelProvideLiquids) {
        this.vcleFuelProvideLiquids = vcleFuelProvideLiquids;
    }
    public Set getVcleFuelBalanceLiquids() {
        return this.vcleFuelBalanceLiquids;
    }
    
    public void setVcleFuelBalanceLiquids(Set vcleFuelBalanceLiquids) {
        this.vcleFuelBalanceLiquids = vcleFuelBalanceLiquids;
    }
    public Set getVcleFuelIssueLiquids() {
        return this.vcleFuelIssueLiquids;
    }
    
    public void setVcleFuelIssueLiquids(Set vcleFuelIssueLiquids) {
        this.vcleFuelIssueLiquids = vcleFuelIssueLiquids;
    }




}


