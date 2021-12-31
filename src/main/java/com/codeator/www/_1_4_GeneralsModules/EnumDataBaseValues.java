/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_4_GeneralsModules;

/**
 *
 * @author Mahmoud
 */
public class EnumDataBaseValues {

    public String RequireType(int requireType) {
        String RequireType = "";
        switch (requireType) {
            case 1:
                RequireType = "مذكرة";
                break;
            case 2:
                RequireType = "طوارئ";
                break;
            case 3:
                RequireType = "دوري";
                break;
            case 4:
                RequireType = "تليفون";
                break;
            case 5:
                RequireType = "توصية";
                break;
            case 6:
                RequireType = "توصيلات";
                break;
            case 7:
                RequireType = "صيانة";
                break;
            case 8:
                RequireType = "تخصص";
                break;
        }
        return RequireType;
    }
}
