/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._1_0_0_taxpayerIdentity.api._001_login_to_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._1_0_0_taxpayerIdentity.api._002_received_json._100_Login_as_Taxpayer_System_jsonFile_000_;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author cdc
 */
public class _100_Login_as_Taxpayer_System {

    private static _100_Login_as_Taxpayer_System_jsonFile_000_ login_json = new _100_Login_as_Taxpayer_System_jsonFile_000_();
    private static String jason_body = "";

    public static void main(String[] args) throws IOException {

        /*String idSrvBaseUrl = "https://id.eta.gov.eg";
        String apiBaseUrl = "https://api.invoicing.eta.gov.eg";
        String Client_id = "e0aec0e7-d2e9-4a31-82f4-63250e42272a";
        String Client_secret = "2a102d50-88e4-4579-9830-aa13688f31f4";

        String idSrvBaseUrl = "https://id.preprod.eta.gov.eg";
        String apiBaseUrl = "https://api.preprod.invoicing.eta.gov.eg";
        String Client_id = "53e2d4cd-1b25-4073-8b26-848a71fede19";
        String Client_secret = "f2c70b9e-8d42-4633-8b08-5d59b643e09a";*/
        
        String idSrvBaseUrl = "https://id.eta.gov.eg";
        String apiBaseUrl = "https://api.invoicing.eta.gov.eg";
        String Client_id = "e0aec0e7-d2e9-4a31-82f4-63250e42272a";
        String Client_secret = "2a102d50-88e4-4579-9830-aa13688f31f4";
        _100_Login_as_Taxpayer_System._100_Login_as_Taxpayer_System(
                idSrvBaseUrl,
                Client_id,
                Client_secret);
        System.out.println("    1- access_token : " + login_json.getAccess_token());
        System.out.println("    2- expires_in   : " + login_json.getExpires_in());
        System.out.println("    3- token_type   : " + login_json.getToken_type());
        System.out.println("    4- scope        : " + login_json.getScope());
    }

    /**
     *
     * @param idSrvBaseUrl
     * @param Client_id : its value comes from the Taxpayer Portal site
     * @param Client_secret : its value comes from the Taxpayer Portal site
     * @throws IOException
     */
    public static void _100_Login_as_Taxpayer_System(String idSrvBaseUrl, String Client_id, String Client_secret) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .sslSocketFactory(getSSLSocketFactory())
                .hostnameVerifier(getHostnameVerifier())
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

        RequestBody body = RequestBody.create(mediaType, "Client_id=" + Client_id + "&Client_secret=" + Client_secret + "&grant_type=client_credentials");

        Request request = new Request.Builder()
                .url(idSrvBaseUrl + "/connect/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        Response response = client.newCall(request).execute();

        BufferedReader br = new BufferedReader(new InputStreamReader(response.body().byteStream(), "UTF-8"));

        // 1. read jason if exist
        String json = (br != null) ? br.readLine() : null;
        jason_body = json;
        System.out.println("--->" + json);
        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 3. Convert received JSON to Article
        login_json = mapper.readValue(json, _100_Login_as_Taxpayer_System_jsonFile_000_.class);

    }

    /**
     * get the received json file from the api after login converted to an java
     * class object
     *
     * @return
     */
    public static _100_Login_as_Taxpayer_System_jsonFile_000_ getLogin_json() {
        return login_json;
    }

    /**
     * get the received json file from the api after login
     *
     * @return
     */
    public static String getJason_body() {
        return jason_body;
    }

    public static SSLSocketFactory getSSLSocketFactory() {
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, getTrustManager(), new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static TrustManager[] getTrustManager() {
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            }
        };
        return trustAllCerts;
    }

    public static HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        };
        return hostnameVerifier;
    }

}
