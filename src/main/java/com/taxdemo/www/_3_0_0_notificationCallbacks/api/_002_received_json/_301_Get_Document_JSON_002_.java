/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json;

/**
 *
 * @author Moham
 */
public class _301_Get_Document_JSON_002_ {

    private int codeTypeId;
    private String codeTypeNamePrimaryLang;
    private String codeTypeNameSecondaryLang;
    private String itemCode;
    private String codeNamePrimaryLang;
    private String codeNameSecondaryLang;

    public _301_Get_Document_JSON_002_() {

    }

    public _301_Get_Document_JSON_002_(int codeTypeId, String codeTypeNamePrimaryLang, String codeTypeNameSecondaryLang, String itemCode, String codeNamePrimaryLang, String codeNameSecondaryLang) {
        this.codeTypeId = codeTypeId;
        this.codeTypeNamePrimaryLang = codeTypeNamePrimaryLang;
        this.codeTypeNameSecondaryLang = codeTypeNameSecondaryLang;
        this.itemCode = itemCode;
        this.codeNamePrimaryLang = codeNamePrimaryLang;
        this.codeNameSecondaryLang = codeNameSecondaryLang;
    }

    public String getCodeNameSecondaryLang() {
        return codeNameSecondaryLang;
    }

    public void setCodeNameSecondaryLang(String codeNameSecondaryLang) {
        this.codeNameSecondaryLang = codeNameSecondaryLang;
    }

    public int getCodeTypeId() {
        return codeTypeId;
    }

    public void setCodeTypeId(int codeTypeId) {
        this.codeTypeId = codeTypeId;
    }

    public String getCodeTypeNamePrimaryLang() {
        return codeTypeNamePrimaryLang;
    }

    public void setCodeTypeNamePrimaryLang(String codeTypeNamePrimaryLang) {
        this.codeTypeNamePrimaryLang = codeTypeNamePrimaryLang;
    }

    public String getCodeTypeNameSecondaryLang() {
        return codeTypeNameSecondaryLang;
    }

    public void setCodeTypeNameSecondaryLang(String codeTypeNameSecondaryLang) {
        this.codeTypeNameSecondaryLang = codeTypeNameSecondaryLang;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getCodeNamePrimaryLang() {
        return codeNamePrimaryLang;
    }

    public void setCodeNamePrimaryLang(String codeNamePrimaryLang) {
        this.codeNamePrimaryLang = codeNamePrimaryLang;
    }

}
