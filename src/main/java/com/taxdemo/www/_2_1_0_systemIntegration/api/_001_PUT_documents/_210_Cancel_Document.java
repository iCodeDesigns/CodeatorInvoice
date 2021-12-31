/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._2_1_0_systemIntegration.api._001_PUT_documents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxdemo.www._2_0_0_systemIntegration.api._002_received_json._101_Submit_Documents_JSON_000_;
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
 * @author Moham
 */
public class _210_Cancel_Document {

    private final String jason_body;

    /**
     *
     * @param token_type : its value comes from the identity server
     * @param access_token : its value comes from the identity server
     * @param json_of_submition_documents : *1* use constructor in class
     * [_201_Submit_Documents_003_json_generated_for_All_documents] from package
     * [com.taxdemo.www._2_0_0_systemIntegration.api._003_creation_of_document_jason]
     * *2* then get the generated json from the method [getDocuments_json_str]
     * @throws IOException
     */
    public _210_Cancel_Document(String idSrvBaseUrl, String token_type, String access_token, String documentUUID, String cancel_reason) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .sslSocketFactory(getSSLSocketFactory())
                .hostnameVerifier(getHostnameVerifier())
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"status\":\"cancelled\",\n\t\"reason\":\"" + cancel_reason + "\"\n}");
        Request request = new Request.Builder()
                .url(idSrvBaseUrl + "/api/v1.0/documents/state/" + documentUUID + "/state")
                .method("PUT", body)
                .addHeader("Authorization", token_type + " " + access_token)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        BufferedReader br = new BufferedReader(new InputStreamReader(response.body().byteStream(), "UTF-8"));

        // 1. read jason if exist
        jason_body = (br != null) ? br.readLine() : null;

    }

    /**
     * get the received json file from the api after submit the documents
     *
     * @return
     */
    public String getJason_body() {
        return jason_body;
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
