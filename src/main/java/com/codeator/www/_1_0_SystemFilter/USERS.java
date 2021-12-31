/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._1_0_SystemFilter;

import com.codeator.www._1_2_DB_entities.JavaUsersTest;
import com.codeator.www._1_3_DB_daos.JavaUsersTestDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Support
 */
public class USERS {

    private final List<String> users = new ArrayList<>();

    public List<String> getUsers() {
        /* ادارة الاوركال */
//        users.add("19723");
//        users.add("9888");
//        users.add("18443");
//        users.add("17170");        
//        /* مكتب استاذ ابراهيم اعلانات */
//        users.add("9875");
//        users.add("10388");
//        users.add("13024");
//        users.add("14251");
//        users.add("9998");
//        users.add("12011");
//        users.add("17262");
//        /*المبيعات */
//        users.add("16817");
//        users.add("13083");
//        users.add("18103");
//        /*الميكروفيلم */
//        users.add("13998");
//        users.add("16486");
//        /*حسابات أماك */
//        users.add("16913");
//        users.add("11880");
//        users.add("18856");
//        users.add("10356");
        //users.add("14534"); //حنان
        List<JavaUsersTest> pList = new JavaUsersTestDAO<>().GetAllUsers();
        for (JavaUsersTest javaUsersTest : pList) {
            users.add(javaUsersTest.getEmployeeId());
        }
        return users;
    }

}
