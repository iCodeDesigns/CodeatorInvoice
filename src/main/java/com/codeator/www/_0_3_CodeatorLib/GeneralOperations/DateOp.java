/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_3_CodeatorLib.GeneralOperations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class that used to deal with all Date Operations
 *
 * @author Codeator
 */
public class DateOp {

    // Convert Date to String //////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Date2String method that convert Date data type to String data type
     * according to specific format.
     *
     * @param date : that date in Date data type want to be converted.
     * @param format : the format of returned String.
     * @return String of date according to format given.
     */
    public String Date2String(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String Date_Str = formatter.format(date);
        return Date_Str;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Convert String to Date //////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * String2Date method that convert String data type to Date data type using
     * specific format that is same of the entered String of date. Note : String
     * date entered must be in the same format of the format parameter.
     *
     * @param dateStr : that date in String data type want to be converted.
     * @param format : the format of Entered dateStr String.
     * @return Date of date.
     * @throws java.text.ParseException cause by Error in conversion of date
     * from string data type to Date data type.
     */
    public Date String2Date(String dateStr, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date Date_date = formatter.parse(dateStr);
        return Date_date;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Get System Date ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //1 default System DateTime
    /**
     * getSysDate method that get the system date and time and all time zone
     * information.
     *
     * @return Date of date.
     */
    public Date getSysDate() {
        Date sysDate = new Date();
        return sysDate;
    }

    //2 second default System DateTime
    /**
     * getSysDateDefault2 method that get the system date and time in Simple
     * date formate Default.
     *
     * @return Date of date.
     */
    public String getSysDateDefault2() {
        SimpleDateFormat sysDate = new SimpleDateFormat();
        String sysDateSTR = sysDate.format(getSysDate());
        return sysDateSTR;
    }

    //3 Custom System DateTime
    /**
     * getCustomSysDate method that get the system date and time in Simple date
     * formate according to formate needed.
     *
     * @param format : that date in Date data type want to be converted.
     * @return String of date.
     */
    public String getCustomSysDate(String format) {
        String sysDateSTR = Date2String(getSysDate(), format);
        return sysDateSTR;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // convert Date to SQL Date ///////////////////////////////////////////////////////////////////////////////////////////////
    // 1 ****
    /**
     * differentsBetweenTwoDates method that get the number of days between to
     * dates.
     *
     * @param largeDate : that large date in Date data type .
     * @param smallDate : that small date in Date data type .
     * @return long of number of days.
     */
    public long differentsBetweenTwoDates(Date largeDate, Date smallDate) {

        long diff_days = largeDate.getTime() - smallDate.getTime();
        diff_days = TimeUnit.DAYS.convert(diff_days, TimeUnit.MILLISECONDS);

        return diff_days;
    }

    // 2 ****
    /**
     * differentsBetweenTwoDates method that get the number of days between to
     * dates. Note : two dates entered must be in the same format of the format
     * parameter.
     *
     * @param largeDateSTR : that large date in String data type .
     * @param smallDateSTR : that small date in String data type .
     * @param format : the formate of the entered dates.
     * @return long of number of days.
     * @throws java.lang.Exception cause by Error in conversion of date from
     * string data type to Date data type.
     */
    public long differentsBetweenTwoDates(String largeDateSTR, String smallDateSTR, String format) throws Exception {

        try {
            Date largDate = String2Date(largeDateSTR, format);
            Date smallDate = String2Date(smallDateSTR, format);
            long diff_days = differentsBetweenTwoDates(largDate, smallDate);
            return diff_days;
        } catch (ParseException e) {
            throw new Exception();
        }

    }

    // 3 ****
    /**
     * differentsBetweenTwoDates method that get the number of miunits between
     * to dates.
     *
     * @param largeDate : that large date in Date data type .
     * @param smallDate : that small date in Date data type .
     * @return long of number of miunits.
     */
    public long differentsBetweenTwoDatesInMinuts(Date largeDate, Date smallDate) {

        long diff_Min = largeDate.getTime() - smallDate.getTime();
        diff_Min = TimeUnit.MINUTES.convert(diff_Min, TimeUnit.MILLISECONDS);

        return diff_Min;
    }

    // 3 ****
    /**
     * differentsBetweenTwoDates method that get the number of miunits between
     * to dates.
     *
     * @param largeDate : that large date in Date data type .
     * @param smallDate : that small date in Date data type .
     * @return long of number of Hours.
     */
    public long differentsBetweenTwoDatesInHours(Date largeDate, Date smallDate) {

        long diff_Min = largeDate.getTime() - smallDate.getTime();
        diff_Min = TimeUnit.HOURS.convert(diff_Min, TimeUnit.MILLISECONDS);

        return diff_Min;
    }

    // 4 ****
    /**
     * differentsBetweenTwoDates method that get the number of miunits between
     * to dates. Note : two dates entered must be in the same format of the
     * format parameter.
     *
     * @param largeDateSTR : that large date in String data type .
     * @param smallDateSTR : that small date in String data type .
     * @param format : the formate of the entered dates.
     * @return long of number of miunits.
     * @throws java.lang.Exception cause by Error in conversion of date from
     * string data type to Date data type.
     */
    public long differentsBetweenTwoDatesInHours(String largeDateSTR, String smallDateSTR, String format) throws Exception {

        try {
            Date largDate = String2Date(largeDateSTR, format);
            Date smallDate = String2Date(smallDateSTR, format);
            long diff_Min = differentsBetweenTwoDatesInHours(largDate, smallDate);
            return diff_Min;
        } catch (ParseException e) {
            throw new Exception();
        }

    }

    // 4 ****
    /**
     * differentsBetweenTwoDates method that get the number of miunits between
     * to dates. Note : two dates entered must be in the same format of the
     * format parameter.
     *
     * @param largeDateSTR : that large date in String data type .
     * @param smallDateSTR : that small date in String data type .
     * @param format : the formate of the entered dates.
     * @return long of number of miunits.
     * @throws java.lang.Exception cause by Error in conversion of date from
     * string data type to Date data type.
     */
    public double differentsBetweenTwoDatesInMinuts(String largeDateSTR, String smallDateSTR, String format) throws Exception {

        try {
            Date largDate = String2Date(largeDateSTR, format);
            Date smallDate = String2Date(smallDateSTR, format);
            double diff_Min = differentsBetweenTwoDatesInMinuts(largDate, smallDate);
            return diff_Min;
        } catch (ParseException e) {
            throw new Exception();
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // convert Date to SQL Date ///////////////////////////////////////////////////////////////////////////////////////////////
    // 1 ****
    /**
     * differentsBetweenTwoDates method that get the number of days between to
     * dates. Note : two dates entered must be in the same format of the format
     * parameter.
     *
     * @param date : that date in Date data type .
     * @return SQL Date.
     */
    public java.sql.Date ConvToSqlDate(Date date) {

        java.sql.Date Date_Sql = new java.sql.Date(date.getTime());
        return Date_Sql;
    }

    // 2 ****
    /**
     * differentsBetweenTwoDates method that get the number of days between to
     * dates. Note : two dates entered must be in the same format of the format
     * parameter.
     *
     * @param DateStr : that date in String data type .
     * @param format : the formate of the entered date.
     * @return SQL Date.
     * @throws java.lang.Exception cause by Error in conversion of date from
     * string data type to Date data type.
     */
    public java.sql.Date ConvToSqlDate(String DateStr, String format) throws Exception {

        try {
            Date Date_date = String2Date(DateStr, format);
            java.sql.Date Date_Sql = ConvToSqlDate(Date_date);
            return Date_Sql;
        } catch (ParseException e) {
            throw new Exception();
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    private final List<Character> arabic_numbes = Arrays.asList('٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩');
    private final List<Character> english_numbes = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public String ConvertEngNumbersInString2ArabNumbers(String str) {
        String ModifiedStr = "";
        try {
            char CharactersArr[] = str.toCharArray();
            for (char c : CharactersArr) {
                if (english_numbes.contains(c)) {
                    int i = english_numbes.indexOf(c);
                    ModifiedStr += arabic_numbes.get(i);
                } else {
                    ModifiedStr += c;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ModifiedStr;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    public final List<String> daysEnglish = Arrays.asList("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY");
    public final List<String> daysArabic = Arrays.asList("الأحد", "الإثنين", "الثلاثاء", "الأربعاء", "الخميس", "الجمعة", "السبت");

    public final List<String> monthEnglish = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul","Agu","Sep","Oct","Nov","Dec");
    public final List<String> monthArabic = Arrays.asList("يناير", "فبراير", "مارس", "أبريل", "مايو", "يونيو", "يوليو","أغسطس","سبتمبر","أكتوبر","نوفمبر","ديسمبر");

    public String getDayName(Date d, String lang) {
        String day = Date2String(d, "dd");
        String month = Date2String(d, "MM");
        String year = Date2String(d, "yyyy");
        return SearchDayName(day, month, year, lang);
    }

    public String getDayName(String d, String formate, String lang) throws ParseException {
        return getDayName(String2Date(d, formate), lang);
    }

    private String SearchDayName(String day, String month, String year, String lang) {
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        Calendar c = Calendar.getInstance();
        c.set(y, m - 1, d);
        int p = c.get(Calendar.DAY_OF_WEEK);
        String Day = (lang.equals("ar")) ? daysArabic.get(p - 1) : daysEnglish.get(p - 1);
        return Day;
    }
}
