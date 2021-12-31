/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json;

import java.util.List;

/**
 *
 * @author Moham
 */
public class _300_Get_Recent_Documents_JSON_000_ {

    private List<_300_Get_Recent_Documents_JSON_001_> result;
    private _300_Get_Recent_Documents_JSON_002_ metadata;

    public _300_Get_Recent_Documents_JSON_000_() {

    }

    public _300_Get_Recent_Documents_JSON_000_(List<_300_Get_Recent_Documents_JSON_001_> result, _300_Get_Recent_Documents_JSON_002_ metadata) {
        this.result = result;
        this.metadata = metadata;
    }

    public List<_300_Get_Recent_Documents_JSON_001_> getResult() {
        return result;
    }

    public void setResult(List<_300_Get_Recent_Documents_JSON_001_> result) {
        this.result = result;
    }

    public _300_Get_Recent_Documents_JSON_002_ getMetadata() {
        return metadata;
    }

    public void setMetadata(_300_Get_Recent_Documents_JSON_002_ metadata) {
        this.metadata = metadata;
    }

}
