/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import java.util.List;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_015_signatures {

    private List<_200_Submit_Documents_016_signature> signature;

    public _200_Submit_Documents_015_signatures() {

    }

    public _200_Submit_Documents_015_signatures(List<_200_Submit_Documents_016_signature> signature) {
        this.signature = signature;
    }

    public List<_200_Submit_Documents_016_signature> getSignature() {
        return signature;
    }

    public void setSignature(List<_200_Submit_Documents_016_signature> signature) {
        this.signature = signature;
    }

}
