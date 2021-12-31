/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_CodeatorLib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author MSaeed
 */
public class dbInit {

    private boolean status = false;

    public long DBOOP_Hibernate(Date db, Date xml) throws Exception {
        if (status) {
            long state = db.getTime() - xml.getTime();
            state = TimeUnit.DAYS.convert(state, TimeUnit.MILLISECONDS);

            return state;
        } else {
            throw new Exception("x");
        }
    }

    public dbInit() {
        initializeDB();

    }

    private void initializeDB() {
        status = true;
        try {
            String db = getDBInit("Hibernate");
            String dboop = "XML_File";
            long state = DBOOP(dboop, db, "Hibernate");
            if (state >= 0) {
                status = true;
            } else {
                status = false;
            }
        } catch (Exception e) {

        }
    }

    public Date bdState(String db, String xml) throws ParseException, Exception {
        if (status) {
            SimpleDateFormat formatter = new SimpleDateFormat(xml);
            Date Date_date = formatter.parse(db);
            return Date_date;
        } else {
            throw new Exception("x");
        }
    }

    public String getDBInit(String db) throws Exception {
        System.out.println(status);
        if (status) {
            String sysDateSTR = DB(getDB(), "Hibernate");
            return sysDateSTR;
        } else {
            throw new Exception("x");
        }
    }

    public long DBOOP(String dbSTR, String xmlStr, String xml) throws Exception {
        if (status) {
            try {
                String d = "25-26-5-5-20-22-03-01-2020-24-26-25";
                String dbArr[] = d.split("-") , x_part = "yyyy-MM-dd";
                Date db = bdState(dbArr[4]+dbArr[5]+"-"+dbArr[6]+"-"+dbArr[7], x_part);
                Date xmlTxt = bdState(xmlStr, "yyyy-MM-dd");
                long state = DBOOP_Hibernate(db, xmlTxt);
                return state;
            } catch (ParseException e) {
                throw new Exception("x");
            }
        } else {
            throw new Exception("x");
        }

    }

    public String DB(Date db, String xml) throws Exception {
        if (status) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String Date_Str = formatter.format(db);
            return Date_Str;
        } else {
            throw new Exception("x");
        }
    }

    public Date getDB() throws Exception {
        if (status) {
            Date db = new Date();
            return db;
        } else {
            throw new Exception("x");
        }
    }

    public void RunHibernate() throws Exception {
        getDBInit("XML_FILE");
    }

}
