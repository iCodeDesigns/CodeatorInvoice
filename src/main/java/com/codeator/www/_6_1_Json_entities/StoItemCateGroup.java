package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * StoItemCateGroup generated by hbm2java
 */
public class StoItemCateGroup  implements java.io.Serializable {


     private StoItemCateGroupId id;
     private StoItemCateCode stoItemCateCode;
     private String groupName;
     private Set stoItemCateGroupSecs = new HashSet(0);

    public StoItemCateGroup() {
    }

	
    public StoItemCateGroup(StoItemCateGroupId id, StoItemCateCode stoItemCateCode, String groupName) {
        this.id = id;
        this.stoItemCateCode = stoItemCateCode;
        this.groupName = groupName;
    }
    public StoItemCateGroup(StoItemCateGroupId id, StoItemCateCode stoItemCateCode, String groupName, Set stoItemCateGroupSecs) {
       this.id = id;
       this.stoItemCateCode = stoItemCateCode;
       this.groupName = groupName;
       this.stoItemCateGroupSecs = stoItemCateGroupSecs;
    }
   
    public StoItemCateGroupId getId() {
        return this.id;
    }
    
    public void setId(StoItemCateGroupId id) {
        this.id = id;
    }
    public StoItemCateCode getStoItemCateCode() {
        return this.stoItemCateCode;
    }
    
    public void setStoItemCateCode(StoItemCateCode stoItemCateCode) {
        this.stoItemCateCode = stoItemCateCode;
    }
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public Set getStoItemCateGroupSecs() {
        return this.stoItemCateGroupSecs;
    }
    
    public void setStoItemCateGroupSecs(Set stoItemCateGroupSecs) {
        this.stoItemCateGroupSecs = stoItemCateGroupSecs;
    }




}


