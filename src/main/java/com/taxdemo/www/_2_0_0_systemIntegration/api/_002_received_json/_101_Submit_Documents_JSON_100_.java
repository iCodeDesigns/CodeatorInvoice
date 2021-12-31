/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._002_received_json;

/**
 *
 * @author Mahmoud Ahmed
 */
public class _101_Submit_Documents_JSON_100_ {
    private String uuid;
    private String longId;
    private String internalId;
    private String hashKey;
 public _101_Submit_Documents_JSON_100_(){
     
 }
    public _101_Submit_Documents_JSON_100_(String uuid, String longId, String internalId, String hashKey) {
        this.uuid = uuid;
        this.longId = longId;
        this.internalId = internalId;
        this.hashKey = hashKey;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLongId() {
        return longId;
    }

    public void setLongId(String longId) {
        this.longId = longId;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }
}
