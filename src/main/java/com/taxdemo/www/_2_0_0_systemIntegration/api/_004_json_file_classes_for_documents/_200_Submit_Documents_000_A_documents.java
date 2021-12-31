/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author cdc
 */
public class _200_Submit_Documents_000_A_documents {

    private _200_Submit_Documents_000_documents documents;

    public _200_Submit_Documents_000_A_documents() {

    }

    public _200_Submit_Documents_000_A_documents(_200_Submit_Documents_000_documents documents) {
        this.documents = documents;
    }

    public _200_Submit_Documents_000_documents getDocuments() {
        return documents;
    }

    public void setDocuments(_200_Submit_Documents_000_documents documents) {
        this.documents = documents;
    }
    
    /**
     *
     * @param includeNullParameters | true : will include all null parameters in
     * the generated json file , false : will not include null parameters in the
     * generated json file
     * @return json result
     * @throws JsonProcessingException
     */
    public String getDocumentsJson(boolean includeNullParameters) throws JsonProcessingException {
        // Finally show the jason file
        //_200_Submit_Documents_000_documents json_documents = new _200_Submit_Documents_000_documents(documents);
        ObjectMapper mapper = new ObjectMapper();

        if (!includeNullParameters) {
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
        //String json = mapper.writeValueAsString(json_documents);
        return mapper.writeValueAsString(this.documents);
    }

}
