/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_CodeatorLib;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Support
 */
public class Encryption {

    public static void main(String[] args) {
        int x = 1;
        switch (x) {
            case 1:
                String Password = "2021-04-15";
                System.out.println(new Encryption().enchrypt_LIC(Password, "123"));
                break;
            case 2:
                String EnchPassword = "420-404-420-404-380-750-765-705-750-765";
                //System.out.println(new Encryption().decrypt1(EnchPassword));
                break;
        }
        

    }

    public String enchrypt1(String real_password) {
        String enc_pass = "";
        byte b[] = real_password.getBytes();
        for (int i = 0; i < b.length / 2; i++) {
            long code = ((b[i] * 2 + 5) * 4);
            enc_pass += code + "-";
        }
        for (int i = b.length / 2; i < b.length; i++) {
            long code = ((b[i] * 3 + 6) * 5);
            enc_pass += (i < b.length - 1) ? code + "-" : code;
        }
        return enc_pass;
    }

    public String decrypt1(String ench_password) {
        String Real_Pass = "";
        String ench_p_str[] = ench_password.split("-");
        for (int i = 0; i < ench_p_str.length / 2; i++) {
            Real_Pass += (char) ((byte) (((Long.parseLong(ench_p_str[i]) / 4) - 5) / 2));
        }
        for (int i = ench_p_str.length / 2; i < ench_p_str.length; i++) {
            String s = ench_p_str[i];
            try {
                Real_Pass += (char) ((byte) (((Long.parseLong(s) / 5) - 6) / 3));
            } catch (Exception e) {
                String ench_p_str_last[] = s.split("\r\n");
                Real_Pass += (char) ((byte) (((Long.parseLong(ench_p_str_last[0]) / 5) - 6) / 3));
            }

        }
        return Real_Pass;
    }

    //////////////////////////////////////////////
    public String enchrypt_LIC(String real_password, String extraKey) {
        String enc_pass = "";
        List<String> ench_Pass_arr = new ArrayList<>();
        byte b[] = real_password.getBytes();
        for (int i = 0; i < b.length / 2; i++) {
            long code = ((b[i] * 2 + 5) * 4);
            //enc_pass += code + "-";
            ench_Pass_arr.add("" + code);
        }
        for (int i = b.length / 2; i < b.length; i++) {
            long code = ((b[i] * 3 + 6) * 5);
            //enc_pass += (i < b.length - 1) ? code + "-" : code;
            ench_Pass_arr.add("" + code);
        }
        List<String> temp_ench_Pass_arr = new ArrayList<>();
        // set ExtraKey
        int Mid = ((ench_Pass_arr.size() - 1) / 2) + 1;
        if (extraKey != null || !extraKey.equals("")) {
            for (int i = 0; i < ench_Pass_arr.size(); i++) {
                if (i == Mid) {
                    temp_ench_Pass_arr.add(extraKey);
                    temp_ench_Pass_arr.add(ench_Pass_arr.get(i));
                } else {
                    temp_ench_Pass_arr.add(ench_Pass_arr.get(i));
                }
            }
        }
        // لخبط
        ench_Pass_arr.clear();
        //Set Even Position First
        for (int i = 0; i < temp_ench_Pass_arr.size(); i += 2) {
            ench_Pass_arr.add(temp_ench_Pass_arr.get(i));
        }
        //Set Odd Position First
        for (int i = 1; i < temp_ench_Pass_arr.size(); i += 2) {
            ench_Pass_arr.add(temp_ench_Pass_arr.get(i));
        }
        // build String
        for (int i = 0; i < ench_Pass_arr.size(); i++) {
            enc_pass += (i < ench_Pass_arr.size() - 1) ? ench_Pass_arr.get(i) + "-" : ench_Pass_arr.get(i);
        }

        return enc_pass;
    }

    public List<String> decrypt_LIC(String ench_password) {
        String Real_Pass = "";
        String ench_p_str[] = ench_password.split("-");
        List<String> temp_ench_Pass_arr = new ArrayList<>();
        if (ench_p_str.length % 2 == 0) {
            String temp1[] = new String[ench_p_str.length / 2];
            int t = 0;
            for (int i = 0; i < (ench_p_str.length / 2); i++) {
                temp1[t] = ench_p_str[i];
                t++;
            }
            String temp2[] = new String[ench_p_str.length / 2];
            t = 0;
            for (int i = (ench_p_str.length / 2); i < ench_p_str.length; i++) {
                temp2[t] = ench_p_str[i];
                t++;
            }
            for (int i = 0; i < temp1.length; i++) {
                temp_ench_Pass_arr.add(temp1[i]);
                temp_ench_Pass_arr.add(temp2[i]);
            }
        } else {
            String temp1[] = new String[((ench_p_str.length - 1) / 2) + 1];
            int t = 0;
            for (int i = 0; i < (((ench_p_str.length - 1) / 2) + 1); i++) {
                temp1[t] = ench_p_str[i];
                t++;
            }
            String temp2[] = new String[((ench_p_str.length - 1) / 2)];
            t = 0;
            for (int i = (((ench_p_str.length - 1) / 2) + 1); i < ench_p_str.length; i++) {
                temp2[t] = ench_p_str[i];
                t++;
            }
            for (int i = 0; i < temp1.length; i++) {
                temp_ench_Pass_arr.add(temp1[i]);
                if (i < temp1.length - 1) {
                    temp_ench_Pass_arr.add(temp2[i]);
                }
            }
        }
        //"420-420-532-750-705-750-404-404-380-855-780"
        int Mid = (temp_ench_Pass_arr.size() - 1) / 2;
        String ExtraCode = temp_ench_Pass_arr.get(Mid);
        temp_ench_Pass_arr.remove(Mid);
        ench_password = "";

        for (int i = 0; i < temp_ench_Pass_arr.size(); i++) {
            ench_password += (i < temp_ench_Pass_arr.size() - 1) ? temp_ench_Pass_arr.get(i) + "-" : temp_ench_Pass_arr.get(i);
        }
        ench_p_str = ench_password.split("-");

        for (int i = 0; i < ench_p_str.length / 2; i++) {
            Real_Pass += (char) ((byte) (((Long.parseLong(ench_p_str[i]) / 4) - 5) / 2));
        }
        for (int i = ench_p_str.length / 2; i < ench_p_str.length; i++) {
            String s = ench_p_str[i];
            try {
                Real_Pass += (char) ((byte) (((Long.parseLong(s) / 5) - 6) / 3));
            } catch (Exception e) {
                String ench_p_str_last[] = s.split("\r\n");
                Real_Pass += (char) ((byte) (((Long.parseLong(ench_p_str_last[0]) / 5) - 6) / 3));
            }
        }
        List<String> Result = new ArrayList<>();

        Result.add(ExtraCode);
        Result.add(Real_Pass);

        return Result;
    }

    //////////////////////////////////////
    public String enchrypt_AvailableToUserControl(String App, String Tab, String SubTab, String Status) {
        String Code = "";
        Code += new MathOp().RandomNum(10);
        Code += App;
        Code += new MathOp().RandomNum(10);
        Code += Tab;
        Code += new MathOp().RandomNum(10);
        Code += SubTab;
        Code += new MathOp().RandomNum(10);
        Code += Status;
        Code += new MathOp().RandomNum(10);
        Code += new MathOp().RandomNum(10);
        return Code;
    }

    public List<Character> decrypt_AvailableToUserControl(String AvailableToUserControl) {
        // 0A0T0S0s00
        List<Character> chars = new ArrayList<>();
        char App = AvailableToUserControl.charAt(1);//1
        char Tab = AvailableToUserControl.charAt(3);
        char SubTab = AvailableToUserControl.charAt(5);
        char Status = AvailableToUserControl.charAt(7);
        chars.add(App);
        chars.add(Tab);
        chars.add(SubTab);
        chars.add(Status);
        return chars;
    }

}
