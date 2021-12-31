/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alahram.constants;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mohamed
 */
public class InvoiceDocumentConstants {

    public LinkedHashMap<Integer, String> documentStatus = new LinkedHashMap<Integer, String>() {
        {
            put(1, "تم الإدخال");
            put(2, "تم الإرسال للمراجعة");
            put(3, "تم الإرسال للإعتماد");
            put(4, "valid");
            put(5, "invalid");
            put(6, "canceled");
            put(7, "request cancel");
            put(8, "rejected");
            put(9, "request reject");
        }
    };

    public LinkedHashMap<String, Integer> currency = new LinkedHashMap<String, Integer>() {
        {
            put("EGP", 1);
            put("USD", 2);
            put("GBP", 3);
            put("EUR", 4);
        }
    };

}
