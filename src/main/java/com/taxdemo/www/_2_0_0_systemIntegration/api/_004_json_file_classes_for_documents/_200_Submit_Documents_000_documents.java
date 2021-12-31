/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_000_documents {

    private List<_200_Submit_Documents_001_document> documents;

    public _200_Submit_Documents_000_documents() {

    }

    public _200_Submit_Documents_000_documents(List<_200_Submit_Documents_001_document> documents) {
        this.documents = documents;
    }

    public List<_200_Submit_Documents_001_document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<_200_Submit_Documents_001_document> documents) {
        this.documents = documents;
    }

    
    
}
