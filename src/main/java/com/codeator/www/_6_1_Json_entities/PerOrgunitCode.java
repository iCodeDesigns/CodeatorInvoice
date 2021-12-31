package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PerOrgunitCode generated by hbm2java
 */
public class PerOrgunitCode  implements java.io.Serializable {


     private String orgunitCode;
     private String orgunitName;
     private byte orgunitOrder;
     private String recordCreateUser;
     private Date recordCreateDate;
     private String recordUpdateUser;
     private Date recordUpdateDate;
     private Set perOrganizationStructures = new HashSet(0);
     private Set perEmploymentMasters = new HashSet(0);

    public PerOrgunitCode() {
    }

	
    public PerOrgunitCode(String orgunitCode, String orgunitName, byte orgunitOrder) {
        this.orgunitCode = orgunitCode;
        this.orgunitName = orgunitName;
        this.orgunitOrder = orgunitOrder;
    }
    public PerOrgunitCode(String orgunitCode, String orgunitName, byte orgunitOrder, String recordCreateUser, Date recordCreateDate, String recordUpdateUser, Date recordUpdateDate, Set perOrganizationStructures, Set perEmploymentMasters) {
       this.orgunitCode = orgunitCode;
       this.orgunitName = orgunitName;
       this.orgunitOrder = orgunitOrder;
       this.recordCreateUser = recordCreateUser;
       this.recordCreateDate = recordCreateDate;
       this.recordUpdateUser = recordUpdateUser;
       this.recordUpdateDate = recordUpdateDate;
       this.perOrganizationStructures = perOrganizationStructures;
       this.perEmploymentMasters = perEmploymentMasters;
    }
   
    public String getOrgunitCode() {
        return this.orgunitCode;
    }
    
    public void setOrgunitCode(String orgunitCode) {
        this.orgunitCode = orgunitCode;
    }
    public String getOrgunitName() {
        return this.orgunitName;
    }
    
    public void setOrgunitName(String orgunitName) {
        this.orgunitName = orgunitName;
    }
    public byte getOrgunitOrder() {
        return this.orgunitOrder;
    }
    
    public void setOrgunitOrder(byte orgunitOrder) {
        this.orgunitOrder = orgunitOrder;
    }
    public String getRecordCreateUser() {
        return this.recordCreateUser;
    }
    
    public void setRecordCreateUser(String recordCreateUser) {
        this.recordCreateUser = recordCreateUser;
    }
    public Date getRecordCreateDate() {
        return this.recordCreateDate;
    }
    
    public void setRecordCreateDate(Date recordCreateDate) {
        this.recordCreateDate = recordCreateDate;
    }
    public String getRecordUpdateUser() {
        return this.recordUpdateUser;
    }
    
    public void setRecordUpdateUser(String recordUpdateUser) {
        this.recordUpdateUser = recordUpdateUser;
    }
    public Date getRecordUpdateDate() {
        return this.recordUpdateDate;
    }
    
    public void setRecordUpdateDate(Date recordUpdateDate) {
        this.recordUpdateDate = recordUpdateDate;
    }
    public Set getPerOrganizationStructures() {
        return this.perOrganizationStructures;
    }
    
    public void setPerOrganizationStructures(Set perOrganizationStructures) {
        this.perOrganizationStructures = perOrganizationStructures;
    }
    public Set getPerEmploymentMasters() {
        return this.perEmploymentMasters;
    }
    
    public void setPerEmploymentMasters(Set perEmploymentMasters) {
        this.perEmploymentMasters = perEmploymentMasters;
    }




}

