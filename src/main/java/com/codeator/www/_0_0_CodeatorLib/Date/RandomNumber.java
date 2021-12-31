/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_CodeatorLib.Date;

/**
 *
 * @author Mahmoud
 */
public class RandomNumber {

    public static int RandomNum(int End) {
        int Start = 0;
        int range = (End - Start);
        int random_no = Start + (int) (Math.random() * range);
        return random_no;
    }
    
    public static int RandomNum(int start , int End) {
        int Start = start;
        int range = (End - Start);
        int random_no = Start + (int) (Math.random() * range);
        return random_no;
    }
}
