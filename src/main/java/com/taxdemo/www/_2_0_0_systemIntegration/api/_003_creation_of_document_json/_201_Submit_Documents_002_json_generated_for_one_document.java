/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._003_creation_of_document_json;

import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author cdc
 */
public class _201_Submit_Documents_002_json_generated_for_one_document {

    private String document_json_str_without_signature_element;
    private String document_json_str_with_signature_element;
    
    private final _200_Submit_Documents_001_document document_json_object_without_signature_element;
    private final _200_Submit_Documents_001_document document_json_object_with_signature_element;

    public _201_Submit_Documents_002_json_generated_for_one_document(_200_Submit_Documents_001_document document_json_object_without_signature_element, _200_Submit_Documents_001_document document_json_object_with_signature_element) {
        this.document_json_object_without_signature_element = document_json_object_without_signature_element;
        this.document_json_object_with_signature_element = document_json_object_with_signature_element;
    }

    /**
     *
     * @param includeNullParameters | true : will include all null parameters in
     * the generated json file , false : will not include null parameters in the
     * generated json file
     * @return json result
     * @throws JsonProcessingException
     */
    public String getDocument_json_str_without_signature_element(boolean includeNullParameters) throws JsonProcessingException {
        // Finally show the jason file
        //_200_Submit_Documents_000_documents json_documents = new _200_Submit_Documents_000_documents(documents);
        ObjectMapper mapper = new ObjectMapper();

        if (!includeNullParameters) {
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
        //String json = mapper.writeValueAsString(json_documents);
        this.document_json_str_without_signature_element = mapper.writeValueAsString(this.document_json_object_without_signature_element);
        return document_json_str_without_signature_element;
    }

    public _200_Submit_Documents_001_document getDocument_json_object_without_signature_element() {
        return document_json_object_without_signature_element;
    }
    
    /**
     *
     * @param includeNullParameters | true : will include all null parameters in
     * the generated json file , false : will not include null parameters in the
     * generated json file
     * @return json result
     * @throws JsonProcessingException
     */
    public String getDocument_json_str_with_signature_element(boolean includeNullParameters) throws JsonProcessingException {
        // Finally show the jason file
        //_200_Submit_Documents_000_documents json_documents = new _200_Submit_Documents_000_documents(documents);
        ObjectMapper mapper = new ObjectMapper();

        if (!includeNullParameters) {
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
        //String json = mapper.writeValueAsString(json_documents);
        this.document_json_str_with_signature_element = mapper.writeValueAsString(this.document_json_object_with_signature_element);
        return document_json_str_with_signature_element;
    }

    public _200_Submit_Documents_001_document getDocument_json_object_with_signature_element() {
        return document_json_object_with_signature_element;
    }

}
