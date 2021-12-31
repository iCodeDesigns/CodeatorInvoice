package com.codeator.www._6_1_Json_entities;
// Generated Aug 21, 2021 10:55:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * AppSubElem generated by hbm2java
 */
public class AppSubElem  implements java.io.Serializable {


     private AppSubElemId id;
     private AppSubTab appSubTab;
     private String elementName;
     private String elementType;
     private Set appSubElemSpecAuths = new HashSet(0);

    public AppSubElem() {
    }

	
    public AppSubElem(AppSubElemId id, AppSubTab appSubTab, String elementName) {
        this.id = id;
        this.appSubTab = appSubTab;
        this.elementName = elementName;
    }
    public AppSubElem(AppSubElemId id, AppSubTab appSubTab, String elementName, String elementType, Set appSubElemSpecAuths) {
       this.id = id;
       this.appSubTab = appSubTab;
       this.elementName = elementName;
       this.elementType = elementType;
       this.appSubElemSpecAuths = appSubElemSpecAuths;
    }
   
    public AppSubElemId getId() {
        return this.id;
    }
    
    public void setId(AppSubElemId id) {
        this.id = id;
    }
    public AppSubTab getAppSubTab() {
        return this.appSubTab;
    }
    
    public void setAppSubTab(AppSubTab appSubTab) {
        this.appSubTab = appSubTab;
    }
    public String getElementName() {
        return this.elementName;
    }
    
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
    public String getElementType() {
        return this.elementType;
    }
    
    public void setElementType(String elementType) {
        this.elementType = elementType;
    }
    public Set getAppSubElemSpecAuths() {
        return this.appSubElemSpecAuths;
    }
    
    public void setAppSubElemSpecAuths(Set appSubElemSpecAuths) {
        this.appSubElemSpecAuths = appSubElemSpecAuths;
    }




}

