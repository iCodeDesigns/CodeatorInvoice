/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

/**
 *
 * @author Moham
 */
public class _201_itemDescDetails {
    
    private long itemSeq;
    private String aItemDesc;
    private String eItemDesc;
    private String sectionNoOld;
    private String depNoOld;
    private String accUnit;
    private String itemBarcode;

    public String getaItemDesc() {
        return aItemDesc;
    }

    public void setaItemDesc(String aItemDesc) {
        this.aItemDesc = aItemDesc;
    }

    public String geteItemDesc() {
        return eItemDesc;
    }

    public void seteItemDesc(String eItemDesc) {
        this.eItemDesc = eItemDesc;
    }

    public String getSectionNoOld() {
        return sectionNoOld;
    }

    public void setSectionNoOld(String sectionNoOld) {
        this.sectionNoOld = sectionNoOld;
    }

    public String getDepNoOld() {
        return depNoOld;
    }

    public void setDepNoOld(String depNoOld) {
        this.depNoOld = depNoOld;
    }
    
    public String getAccUnit() {
        return accUnit;
    }

    public void setAccUnit(String accUnit) {
        this.accUnit = accUnit;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public long getItemSeq() {
        return itemSeq;
    }

    public void setItemSeq(long itemSeq) {
        this.itemSeq = itemSeq;
    }

    public _201_itemDescDetails(long itemSeq, String aItemDesc, String eItemDesc, String itemBarcode) {
        this.itemSeq = itemSeq;
        this.aItemDesc = aItemDesc;
        this.eItemDesc = eItemDesc;
        this.itemBarcode = itemBarcode;
    }
    
}
