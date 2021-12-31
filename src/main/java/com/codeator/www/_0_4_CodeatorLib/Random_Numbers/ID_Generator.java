/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_4_CodeatorLib.Random_Numbers;


import static com.codeator.www._0_4_CodeatorLib.Random_Numbers.RandomNumber.RandomNum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahmoud
 */
public class ID_Generator {
    private final List<String> digit = new ArrayList<>();

    private List<String> getDigit() {
        for (int i = 0; i < 10; i++) {
            digit.add("" + i + "");
        }
        return digit;
    }

    public String getIDRandom(int passLength) {
        String Password = "";
        List<String> digit = getDigit();
        for (int i = 0; i < passLength; i++) {
            int randomNum = RandomNum(digit.size());
            Password += digit.get(randomNum);
        }
        return Password;
    }
}
