package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * StoItemCateCode generated by hbm2java
 */
public class StoItemCateCode  implements java.io.Serializable {


     private String cateCode;
     private String cateName;
     private Set stoItemCateGroups = new HashSet(0);

    public StoItemCateCode() {
    }

	
    public StoItemCateCode(String cateCode, String cateName) {
        this.cateCode = cateCode;
        this.cateName = cateName;
    }
    public StoItemCateCode(String cateCode, String cateName, Set stoItemCateGroups) {
       this.cateCode = cateCode;
       this.cateName = cateName;
       this.stoItemCateGroups = stoItemCateGroups;
    }
   
    public String getCateCode() {
        return this.cateCode;
    }
    
    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }
    public String getCateName() {
        return this.cateName;
    }
    
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
    public Set getStoItemCateGroups() {
        return this.stoItemCateGroups;
    }
    
    public void setStoItemCateGroups(Set stoItemCateGroups) {
        this.stoItemCateGroups = stoItemCateGroups;
    }




}

