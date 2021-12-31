/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import java.io.Serializable;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_016_signature implements Serializable {

    private String signatureType;
    private String value; //Encoded Base-64 calculated on the document's data & Physical Drive

    public _200_Submit_Documents_016_signature() {

    }

    public _200_Submit_Documents_016_signature(_200_Submit_Documents_016_signature Submit_Documents_016_signature) {
        this(
                Submit_Documents_016_signature.getSignatureType(),
                Submit_Documents_016_signature.getValue()
        );
    }

    public _200_Submit_Documents_016_signature(String signatureType, String value) {
        this.signatureType = signatureType;
        this.value = value;
    }

    public String getSignatureType() {
        return signatureType;
    }

    public void setSignatureType(String signatureType) {
        this.signatureType = signatureType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
