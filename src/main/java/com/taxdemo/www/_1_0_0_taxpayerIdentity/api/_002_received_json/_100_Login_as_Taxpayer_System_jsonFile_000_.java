/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxdemo.www._1_0_0_taxpayerIdentity.api._002_received_json;

/**
 *
 * @author cdc
 */
public class _100_Login_as_Taxpayer_System_jsonFile_000_ {

    private String access_token;
    private long expires_in;
    private String token_type;
    private String scope;

    /**
     * Error Message
     */
    private String error;

    /**
     * this class is a mirror for api json received when try to submit document
     * :
     *
     * - json file :
     *
     * {
     *
     * "access_token" : "",
     *
     * "expires_in" : 0,
     *
     * "token_type" : "",
     *
     * "scope" : "",
     *
     * }
     *
     * -----------------------------------------------------------------------
     *
     * - or error json file :
     *
     * {
     *
     * "error" : ""
     *
     * }
     *
     * @author Mahmoud Ahmed
     */
    public _100_Login_as_Taxpayer_System_jsonFile_000_() {
    }

    public _100_Login_as_Taxpayer_System_jsonFile_000_(String access_token, long expires_in, String token_type, String scope, String error) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.token_type = token_type;
        this.scope = scope;
        this.error = error;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
