/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._0_1_0_api_tracks;

import com.codeator.www._0_0_App_tasks._0_0_1_API_Login;
import com.taxdemo.www._1_0_0_taxpayerIdentity.api._001_login_to_api._100_Login_as_Taxpayer_System;
import com.taxdemo.www._2_1_0_systemIntegration.api._001_PUT_documents._210_Cancel_Document;
import com.taxdemo.www._3_0_0_notificationCallbacks.api._001_getPortalData._301_Get_Document;
import com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json._301_Get_Document_JSON_000_;

/**
 *
 * @author Moham
 */
public class _004_connect_and_cancel_document {

    private String json = "";

    public void cancelDocuments(String productionType, String documentUUID, String cancela_reason) throws Exception {
        String idSrvBaseUrl = "";
        String apiBaseUrl = "";

        String Client_id = "";
        String Client_secret = "";
        try {
            apiBaseUrl = _0_0_1_API_Login.getApiBaseUrl();

            String Login_Error = _0_0_1_API_Login.getLogin_Error();
            if (Login_Error.equals("loginError")) {
                System.out.println("    -- error : invalid_client");
            } else {

                // 3. Send Documents
                System.out.println("*2* _101_Submit_Documents_JSON");
                _210_Cancel_Document Get_Documents = new _210_Cancel_Document(
                        apiBaseUrl,//apiBaseUrl
                        _0_0_1_API_Login.getToken_type(),
                        _0_0_1_API_Login.getAccess_token(),
                        documentUUID,
                        cancela_reason);

                json = Get_Documents.getJason_body();

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            if (e.getMessage().endsWith("timed out")) {
                System.out.println("Fire Wall Stands On Request Traffic");
                throw new Exception("Fire Wall Stands On Request Traffic");
            }
        }
    }

    public String getJson() {
        return json;
    }
}
