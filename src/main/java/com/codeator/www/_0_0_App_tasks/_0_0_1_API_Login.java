/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_App_tasks;

import com.taxdemo.www._0_1_0_api_tracks._000_connect_url_client;
import com.taxdemo.www._1_0_0_taxpayerIdentity.api._001_login_to_api._100_Login_as_Taxpayer_System;
import com.taxdemo.www._2_0_0_systemIntegration.api._001_submit_document._200_Submit_Documents;
import com.taxdemo.www._2_0_0_systemIntegration.api._002_received_json._101_Submit_Documents_JSON_100_;

/**
 *
 * @author Moham
 */
public class _0_0_1_API_Login {

    private static String Login_Error = "";
    private static String access_token = "";
    private static String token_type = "";
    private static String apiBaseUrl = "";

    public static void _0_0_1_API_Login() throws Exception {
        String idSrvBaseUrl = "";

        String Client_id = "";
        String Client_secret = "";
        try {
            _000_connect_url_client url_client = new _000_connect_url_client();

            String productionType = new _0_0_0_Invoice_Tasks_1_().production;
            if (productionType.equals("pre-production")) {

                idSrvBaseUrl = url_client.getIdSrvBaseUrl_pre();//"https://id.preprod.eta.gov.eg";
                apiBaseUrl = url_client.getApiBaseUrl_pre();//"https://api.preprod.invoicing.eta.gov.eg";
                Client_id = url_client.getClient_id_pre();//"53e2d4cd-1b25-4073-8b26-848a71fede19";
                Client_secret = url_client.getClient_secret_pre();//"f2c70b9e-8d42-4633-8b08-5d59b643e09a";
            } else if (productionType.equals("production")) {
                idSrvBaseUrl = url_client.getIdSrvBaseUrl_pro();//"https://id.eta.gov.eg";
                apiBaseUrl = url_client.getApiBaseUrl_pro();//"https://api.invoicing.eta.gov.eg";
                Client_id = url_client.getClient_id_pro();//"e0aec0e7-d2e9-4a31-82f4-63250e42272a";
                Client_secret = url_client.getClient_secret_pro();//"2a102d50-88e4-4579-9830-aa13688f31f4";
            } else {
                throw new Exception("productionType : Not Specified");
            }

            System.out.println("*1* _100_Login_as_Taxpayer_System");
            _100_Login_as_Taxpayer_System._100_Login_as_Taxpayer_System(
                    idSrvBaseUrl,
                    Client_id,
                    Client_secret);

            if (_100_Login_as_Taxpayer_System.getLogin_json().getError() != null) {
                System.out.println("    -- error : invalid_client");
                Login_Error = "loginError";
                throw new Exception("error : invalid_client");
            } else {
                System.out.println("    1- access_token : " + _100_Login_as_Taxpayer_System.getLogin_json().getAccess_token());
                System.out.println("    2- expires_in   : " + _100_Login_as_Taxpayer_System.getLogin_json().getExpires_in());
                System.out.println("    3- token_type   : " + _100_Login_as_Taxpayer_System.getLogin_json().getToken_type());
                System.out.println("    4- scope        : " + _100_Login_as_Taxpayer_System.getLogin_json().getScope());

                Login_Error = "NoErrors";
                access_token = _100_Login_as_Taxpayer_System.getLogin_json().getAccess_token();
                token_type = _100_Login_as_Taxpayer_System.getLogin_json().getToken_type();

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            Login_Error = "loginError";
            if (e.getMessage().endsWith("timed out")) {
                System.out.println("Fire Wall Stands On Request Traffic");
                throw new Exception("Fire Wall Stands On Request Traffic");
            }
        }

    }

    public static String getLogin_Error() {
        return Login_Error;
    }

    public static String getAccess_token() {
        return access_token;
    }

    public static String getToken_type() {
        return token_type;
    }

    public static String getApiBaseUrl() {
        return apiBaseUrl;
    }
}
