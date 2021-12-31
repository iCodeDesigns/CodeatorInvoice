package com.codeator.www._1_2_DB_entities;
// Generated Mar 21, 2021 6:34:02 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * StoItemCateGroup generated by hbm2java
 */
@Entity
@Table(name="STO_ITEM_CATE_GROUP"
    ,schema="CODEATOR"
)
public class StoItemCateGroup  implements java.io.Serializable {


     private StoItemCateGroupId id;
     private StoItemCateCode stoItemCateCode;
     private String groupName;
     private Set<StoItemCateGroupSec> stoItemCateGroupSecs = new HashSet<StoItemCateGroupSec>(0);

    public StoItemCateGroup() {
    }

	
    public StoItemCateGroup(StoItemCateGroupId id, StoItemCateCode stoItemCateCode, String groupName) {
        this.id = id;
        this.stoItemCateCode = stoItemCateCode;
        this.groupName = groupName;
    }
    public StoItemCateGroup(StoItemCateGroupId id, StoItemCateCode stoItemCateCode, String groupName, Set<StoItemCateGroupSec> stoItemCateGroupSecs) {
       this.id = id;
       this.stoItemCateCode = stoItemCateCode;
       this.groupName = groupName;
       this.stoItemCateGroupSecs = stoItemCateGroupSecs;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="cateCode", column=@Column(name="CATE_CODE", nullable=false, length=2) ), 
        @AttributeOverride(name="groupCode", column=@Column(name="GROUP_CODE", nullable=false, length=3) ) } )
    public StoItemCateGroupId getId() {
        return this.id;
    }
    
    public void setId(StoItemCateGroupId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CATE_CODE", nullable=false, insertable=false, updatable=false)
    public StoItemCateCode getStoItemCateCode() {
        return this.stoItemCateCode;
    }
    
    public void setStoItemCateCode(StoItemCateCode stoItemCateCode) {
        this.stoItemCateCode = stoItemCateCode;
    }

    
    @Column(name="GROUP_NAME", nullable=false, length=200)
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="stoItemCateGroup")
    public Set<StoItemCateGroupSec> getStoItemCateGroupSecs() {
        return this.stoItemCateGroupSecs;
    }
    
    public void setStoItemCateGroupSecs(Set<StoItemCateGroupSec> stoItemCateGroupSecs) {
        this.stoItemCateGroupSecs = stoItemCateGroupSecs;
    }




}


