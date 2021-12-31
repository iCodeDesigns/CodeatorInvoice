/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._0_1_0_api_tracks;

import com.codeator.www._0_0_App_tasks._0_0_1_API_Login;
import com.taxdemo.www._1_0_0_taxpayerIdentity.api._001_login_to_api._100_Login_as_Taxpayer_System;
import com.taxdemo.www._2_0_0_systemIntegration.api._001_submit_document._200_Submit_Documents;
import com.taxdemo.www._2_0_0_systemIntegration.api._002_received_json._101_Submit_Documents_JSON_100_;

/**
 *
 * @author Mohamed
 */
public class _001_connect_and_submit_document {

    public static _200_Submit_Documents submitDocument(String json_str) throws Exception {
        String idSrvBaseUrl = "";
        String apiBaseUrl = "";

        String Client_id = "";
        String Client_secret = "";
        try {
            apiBaseUrl = _0_0_1_API_Login.getApiBaseUrl();

            String Login_Error = _0_0_1_API_Login.getLogin_Error();
            if (Login_Error.equals("loginError")) {
                System.out.println("    -- error : invalid_client");
                throw new Exception("error : invalid_client");
            } else {

                // 3. Send Documents
                System.out.println("*2* _101_Submit_Documents_JSON");
                _200_Submit_Documents Submit_Documents = new _200_Submit_Documents(
                        apiBaseUrl,
                        _0_0_1_API_Login.getToken_type(),
                        _0_0_1_API_Login.getAccess_token(),
                        json_str);

                System.out.println("    - SubmissionId : " + Submit_Documents.getSubmit_Documents_JSON().getSubmissionId());
                System.out.println("    - Accepted Documents *** ");

                for (_101_Submit_Documents_JSON_100_ acceptedDocument : Submit_Documents.getSubmit_Documents_JSON().getAcceptedDocuments()) {
                    System.out.println("       - uuid       : " + acceptedDocument.getUuid());
                    System.out.println("       - longId     : " + acceptedDocument.getLongId());
                    System.out.println("       - internalId : " + acceptedDocument.getInternalId());
                    System.out.println("       - hashKey    : " + acceptedDocument.getHashKey());
                    System.out.println(" -------------------------------------------------------------------");
                }
                System.out.println();
                System.out.println("    - Rejected Documents *** ");
                for (_101_Submit_Documents_JSON_100_ rejectedDocument : Submit_Documents.getSubmit_Documents_JSON().getRejectedDocuments()) {
                    System.out.println("       - uuid       : " + rejectedDocument.getUuid());
                    System.out.println("       - longId     : " + rejectedDocument.getLongId());
                    System.out.println("       - internalId : " + rejectedDocument.getInternalId());
                    System.out.println("       - hashKey    : " + rejectedDocument.getHashKey());
                    System.out.println(" -------------------------------------------------------------------");
                }
                return Submit_Documents;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" ---->>@-- " + e.getMessage());
            if (e.getMessage().endsWith("timed out")) {
                System.out.println("Fire Wall Stands On Request Traffic");
                throw new Exception("Fire Wall Stands On Request Traffic");
            }
            return null;
        }

    }

}
