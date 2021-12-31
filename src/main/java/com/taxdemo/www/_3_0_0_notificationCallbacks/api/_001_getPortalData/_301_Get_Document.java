/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._3_0_0_notificationCallbacks.api._001_getPortalData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._3_0_0_notificationCallbacks.api._002_received_json._301_Get_Document_JSON_000_;
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
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author Moham
 */
public class _301_Get_Document {

    private final _301_Get_Document_JSON_000_ get_Document_JSON;
    private final String jason_body;

    /**
     *
     * @param token_type : its value comes from the identity server
     * @param access_token : its value comes from the identity server
     * @param PageSize : Number of Records to Be Displayed
     * [_201_Submit_Documents_003_json_generated_for_All_documents] from package
     * [com.taxdemo.www._2_0_0_systemIntegration.api._003_creation_of_document_jason]
     * *2* then get the generated json from the method [getDocuments_json_str]
     * @throws IOException
     */
    public _301_Get_Document(String apiBaseUrl, String token_type, String access_token, String documentUUID) throws IOException {
        
        OkHttpClient client = new OkHttpClient().newBuilder()
                .sslSocketFactory(getSSLSocketFactory())
                .hostnameVerifier(getHostnameVerifier())
                .build();
        Request request = new Request.Builder()
                .url(apiBaseUrl + "/api/v1/documents/" + documentUUID + "/raw")
                .method("GET", null)
                .addHeader("Authorization", token_type + " " + access_token)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        BufferedReader br = new BufferedReader(new InputStreamReader(response.body().byteStream(), "UTF-8"));

        // 1. read jason if exist
        String json = (br != null) ? br.readLine() : null;
        this.jason_body = json;
        System.out.println(this.jason_body);
        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 3. Convert received JSON to Article
        this.get_Document_JSON = mapper.readValue(json, _301_Get_Document_JSON_000_.class);

    }

    /**
     * get the received json file from the api after submit the documents
     *
     * @return
     */
    public String getJason_body() {
        return jason_body;
    }

    /**
     * get the received json file from the api after submit the documents
     * converted to an java class object
     *
     * @return
     */
    public _301_Get_Document_JSON_000_ getGet_Document_JSON() {
        return get_Document_JSON;
    }

    public SSLSocketFactory getSSLSocketFactory() {
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, getTrustManager(), new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private TrustManager[] getTrustManager() {
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

    public HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        };
        return hostnameVerifier;
    }
}
