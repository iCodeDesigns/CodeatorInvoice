/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_0_0_systemIntegration.api._005_creation_of_document_json_Custom;

import com.taxdemo.www._2_0_0_systemIntegration.api._003_creation_of_document_json.*;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_000_documents;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_001_document;
import com.taxdemo.www._2_0_0_systemIntegration.api._004_json_file_classes_for_documents._200_Submit_Documents_000_A_documents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._5_0_0_SignWithSmartCard.signWithCsharp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cdc
 */
public class _201_Submit_Documents_003_json_generated_for_All_documents_custom {

    private String documents_json_str;

    private _200_Submit_Documents_000_A_documents documents_json_object;

    /**
     *
     * @param documentTypeVersion | 0.9 >> pre production | 1.0 >> production
     * @param doucumentsIds | List of all Documents
     * @param includeNullParameters | true : will include all null parameters in
     * the generated json file , false : will not include null parameters in the
     * generated json file
     * @throws JsonProcessingException
     */
    public _201_Submit_Documents_003_json_generated_for_All_documents_custom(String documentTypeVersion, List<_200_Submit_Documents_001_document> doucuments, boolean includeNullParameters) throws JsonProcessingException, UnsupportedEncodingException, IOException, Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<_200_Submit_Documents_001_document> documentsList = new ArrayList<>();
        _201_Submit_Documents_001_create_json_from_database_custom Submit_Documents_create_json
                = new _201_Submit_Documents_001_create_json_from_database_custom(documentTypeVersion);

        for (_200_Submit_Documents_001_document doucument : doucuments) {
            _201_Submit_Documents_002_json_generated_for_one_document_custom json_generated
                    = Submit_Documents_create_json.createJsonOfOneDocument(doucument);

            _200_Submit_Documents_001_document one_document_ready;
            if (documentTypeVersion.equals("0.9")) {
                one_document_ready = json_generated.getDocument_json_object_without_signature_element();
                documentsList.add(one_document_ready);
            } else {
                String document_json_str_without_signature_element = json_generated.getDocument_json_str_without_signature_element(false);
                System.out.println("--------------------------------------- document without Sign");
                System.out.println(document_json_str_without_signature_element);

                //sign With C#
                String signed_Document = signWithCsharp.invokeCsharp(document_json_str_without_signature_element);

                if (signed_Document.equals("")) {
                    throw new Exception("Token Server Not Running");
                }
                // de-serialize document

                // 3. Convert received JSON to Article
                one_document_ready = mapper.readValue(signed_Document, _200_Submit_Documents_001_document.class);
                documentsList.add(one_document_ready);

            }
        }
        _200_Submit_Documents_000_documents documents = new _200_Submit_Documents_000_documents(documentsList);

        //collect All Document
        this.documents_json_object = new _200_Submit_Documents_000_A_documents();

        documents_json_object.setDocuments(documents);

        documents_json_str = documents_json_object.getDocumentsJson(includeNullParameters);
        //System.out.println("First ----------------> ");
        //System.out.println(documents_json_str);
    }

    /**
     * method to return json file as a string value of all documents
     *
     * @return
     */
    public String getDocuments_json_str() {
        return documents_json_str;
    }

    /**
     * method to return json file of all documents as a java class Object value
     *
     * @return
     */
    public _200_Submit_Documents_000_A_documents getDocuments_json_object() {
        return documents_json_object;
    }

}
