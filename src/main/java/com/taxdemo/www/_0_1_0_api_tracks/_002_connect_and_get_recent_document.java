/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._0_1_0_api_tracks;

import com.codeator.www._0_0_App_tasks._0_0_1_API_Login;
import com.taxdemo.www._1_0_0_taxpayerIdentity.api._001_login_to_api._100_Login_as_Taxpayer_System;
import com.taxdemo.www._3_0_0_notificationCallbacks.api._001_getPortalData._300_Get_Recent_Documents;
import com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json._300_Get_Recent_Documents_JSON_000_;

/**
 *
 * @author Moham
 */
public class _002_connect_and_get_recent_document {

    private _300_Get_Recent_Documents_JSON_000_ get_Recent_Documents_JSON;
    private String json = "";

    public void getRecentDocuments(String productionType, String PageSize, String PageNo) throws Exception {
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
                _300_Get_Recent_Documents Submit_Documents = new _300_Get_Recent_Documents(
                        apiBaseUrl,
                        _0_0_1_API_Login.getToken_type(),
                        _0_0_1_API_Login.getAccess_token(),
                        PageSize,
                        PageNo);

                json = Submit_Documents.getJason_body();
                get_Recent_Documents_JSON = Submit_Documents.getGet_Recent_Documents_JSON();

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

    public _300_Get_Recent_Documents_JSON_000_ getGet_Recent_Documents_JSON() {
        return get_Recent_Documents_JSON;
    }

    public String getJson() {
        return json;
    }
}
