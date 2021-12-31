/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_2_CodeatorLib.Baisc_HTML_Generator;

/**
 *
 * @author Eng_MahmoudAhmed
 */
public class MainHiperLinks {

    private final String AMACPageHiperLink = "http://amac.ahram.org.eg/";

    private final String PathOfCustomErrorPage = "_9_9_9_0_1_Error_with_Custom_MessageAccessServlet";
    private final String PathOfInvalidAccessPage = "_9_9_9_0_2_Error_Cant_Access_This_PageAcessServlet";
    private final String PathOfYouDontHaveTheAuth  = "_9_9_9_0_4_No_AuthAccessServlet";

    public  String getAMACPageHiperLink() {
        return AMACPageHiperLink;
    }

    public String getPathOfCustomErrorPage() {
        return PathOfCustomErrorPage;
    }

    public String getPathOfInvalidAccessPage() {
        return PathOfInvalidAccessPage;
    }

    public String getPathOfYouDontHaveTheAuth() {
        return PathOfYouDontHaveTheAuth;
    }
}
