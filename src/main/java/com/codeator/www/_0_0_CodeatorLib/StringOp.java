/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_CodeatorLib;

import java.util.List;

/**
 *
 * @author Mahmoud
 */
public class StringOp {

    String str = "";

    public StringOp() {

    }

    public StringOp(String str) {
        this.str = str;
    }

    /**
     * StringContainNum id method to check if the passed string contain number
     * or not
     *
     * @return true if the string contain numbers , false if the string not
     * contain numbers
     */
    public boolean StringContainNum() {
        boolean ContainNumber = false;
        for (char Char : this.str.toCharArray()) {
            if (Char == '0' || Char == '1'
                    || Char == '2' || Char == '3'
                    || Char == '4' || Char == '5'
                    || Char == '6' || Char == '7'
                    || Char == '8' || Char == '9') {
                ContainNumber = true;
            }
        }
        return ContainNumber;
    }

    /**
     * StringContainNum id method to check if the passed string contain number
     * or not
     *
     * @return true if the string contain only numbers , false if the string not
     * contain only numbers
     */
    public boolean StringContainOnlyNum() {
        boolean ContainNumber = true;
        for (char Char : this.str.toCharArray()) {
            if (Char == '0' || Char == '1'
                    || Char == '2' || Char == '3'
                    || Char == '4' || Char == '5'
                    || Char == '6' || Char == '7'
                    || Char == '8' || Char == '9') {
            } else {
                ContainNumber = false;
                break;
            }
        }
        return ContainNumber;
    }

    public String[] seperateStringLines() {
        return this.str.split(System.getProperty("line.separator"));
    }

    public static String SeperateListtoTextLines(List<String> SMS_body) {
        String Message = "";
        for (String string : SMS_body) {
            Message += string + "\n";
        }
        return Message;
    }

    public String ConvertNumFromEnToAr(String str, String lang) {

        String Number = "";

        if (lang.equals("ar")) {
            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case '0':
                        Number += "٠";
                        break;
                    case '1':
                        Number += "١";
                        break;
                    case '2':
                        Number += "٢";
                        break;
                    case '3':
                        Number += "٣";
                        break;
                    case '4':
                        Number += "٤";
                        break;
                    case '5':
                        Number += "٥";
                        break;
                    case '6':
                        Number += "٦";
                        break;
                    case '7':
                        Number += "٧";
                        break;
                    case '8':
                        Number += "٨";
                        break;
                    case '9':
                        Number += "٩";
                        break;
                    case '.':
                        Number += ",";
                        break;
                    default:
                        Number += str.charAt(i);
                }
            }

            Number = Number.replace("PM", "مساءا");
            Number = Number.replace("AM", "صباحا");
        } else {
            Number = str;
        }

        return Number;
    }
}
