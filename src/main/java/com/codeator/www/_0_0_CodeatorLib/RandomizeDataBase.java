/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_CodeatorLib;

import com.codeator.www._0_0_CodeatorLib.Date.Data;
import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import com.codeator.www._1_1_DB_mainDao.HibernateSessionCon;
//import com.codeator.www._1_2_DB_entities.PerScreenAdmin;
import com.codeator.www._1_2_DB_entities_mysql.Employees;
import com.codeator.www._1_3_DB_daos.PerScreenAdminDao;
import com.codeator.www._1_3_DB_daos_mysql.EmployeesDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahmoud
 */
public class RandomizeDataBase {

    public static void main(String[] args) {

        /**
         * MySqlRandom
         */
        /*Data d = new Data();
        HibernateSessionCon HSC = new HibernateSessionCon();
        for (int i = 0; i < 500; i++) {
            try {
                int RandomeEmpNo = Integer.parseInt(d.getRandomEmpNo());
                String Password = d.getPasswordRandom();
                Employees e = new Employees(d.getRandomDepartment(), RandomeEmpNo, d.getFullName(), new DateOp().String2Date(d.getDateRandom(), "yyyy-MM-dd"), "male", Password);
                HSC.beginTrans();
                new EmployeesDao().insert(e);
                HSC.CommitTrans();
                HSC.session.clear();
            } catch (Exception e) {
                HSC.RollBack();
                e.printStackTrace();
                break;
            }
        }
        System.exit(0);*/
 /*List<String> ScreanNames = new ArrayList<String>();
        ScreanNames.add("_0_0_0_1_1_Car_InformAccessServlet");
        ScreanNames.add("_0_0_0_1_2_Car_InformQueryAccessServlet");
        ScreanNames.add("_0_0_0_1_3_Car_InformQueryTrackingAccessServlet");
        ScreanNames.add("_0_0_0_1_4_Car_InformQueryForTechAccessServlet");
        ScreanNames.add("_0_0_0_2_1_Car_RequestAccessServlet");
        ScreanNames.add("_0_0_0_2_2_Car_RequestManegersRequestHandelerAccessServlet");
        ScreanNames.add("_0_0_0_2_3_Car_RequestTranspoetOfficeRequestHandelerAccessServlet");
        ScreanNames.add("_0_0_0_2_4_Car_RequestTranspoetOfficeFinalActionAccessServlet");
        ScreanNames.add("_0_0_0_2_5_Car_RequestTranspoetOfficeHistoryAccessServlet");
        ScreanNames.add("_0_0_0_2_6_Car_Request_FromTransportaionOfficeAccessServlet");
        ScreanNames.add("_0_0_0_3_1_Custodies_EmployeeQueryOfCustodiesAccessServlet");
        try {
            for (String s : ScreanNames) {
                PerScreenAdmin psa = new PerScreenAdmin(s);
                PerScreenAdminDao psadao = new PerScreenAdminDao();
                new HibernateSessionCon().beginTrans();
                psadao.insert(psa);
                new HibernateSessionCon().CommitTrans();
                new HibernateSessionCon().clearConn();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new HibernateSessionCon().RollBack();
        }*/
    }

}
