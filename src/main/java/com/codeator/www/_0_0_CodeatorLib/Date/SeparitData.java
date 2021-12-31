/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_CodeatorLib.Date;

import com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahmoud
 */
public class SeparitData {

    private final List<String> SingleNames = new ArrayList<>();
    private final List<String> Cityes = new ArrayList<>();
    private final List<String> PhoneNumberStarts = new ArrayList<>();
    private final List<String> CarBrand = new ArrayList<>();
    private final List<String> Colors = new ArrayList<>();
    private final List<String> LE = new ArrayList<>();
    private final List<String> years = new ArrayList<>();
    private final List<String> Monthes = new ArrayList<>();
    private final List<String> Dayes = new ArrayList<>();
    private final List<String> Hours = new ArrayList<>();
    private final List<String> Minutes = new ArrayList<>();
    private final List<String> Seconds = new ArrayList<>();
    private final List<String> digit = new ArrayList<>();
    private final List<String> quantaty = new ArrayList<>();
    private final List<String> tonPrice = new ArrayList<>();

    public List<String> getSingleNames() {
        SingleNames.add("علي");
        SingleNames.add("أحمد");
        SingleNames.add("محمد");
        SingleNames.add("عمر");
        SingleNames.add("محمود");
        SingleNames.add("سلامة");
        SingleNames.add("فتحي");
        SingleNames.add("سيد");
        SingleNames.add("زكي");
        SingleNames.add("شوكري");
        SingleNames.add("مهند");
        SingleNames.add("سمير");
        SingleNames.add("خالد");
        SingleNames.add("صبري");
        SingleNames.add("أمير");
        SingleNames.add("ناجي");
        SingleNames.add("مؤمن");
        SingleNames.add("حسن");
        SingleNames.add("سامي");
        SingleNames.add("سعيد");
        return SingleNames;
    }
    ////////////////////////////////////////////////////////////////////////////////

    public List<String> getCityes() {
        Cityes.add("القاهرة");
        Cityes.add("الجيزة");
        Cityes.add("حلوان");
        Cityes.add("الأسكندرية");
        Cityes.add("المنيا");
        Cityes.add("أسيوط");
        Cityes.add("المنصورة");
        Cityes.add("كفر الشيخ");
        Cityes.add("الشرقية");
        Cityes.add("سوهاج");
        Cityes.add("المنوفية");
        Cityes.add("الفيوم");
        Cityes.add("البحر الأحمر");
        Cityes.add("الغردقة");
        Cityes.add("العين السخنة");
        Cityes.add("اللإسماعيلية");
        Cityes.add("السويس");
        Cityes.add("سيناء");
        return Cityes;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public List<String> getPhoneNumberStarts() {
        PhoneNumberStarts.add("011");
        PhoneNumberStarts.add("012");
        PhoneNumberStarts.add("010");
        return PhoneNumberStarts;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public List<String> getCarBrand() {
        CarBrand.add("مرسيدس");
        CarBrand.add("تيوتا");
        CarBrand.add("كيا");
        CarBrand.add("بي ام دابليو");
        CarBrand.add("سوزوكي");
        CarBrand.add("ماروتي");
        CarBrand.add("فيات");
        CarBrand.add("هايونداي");
        CarBrand.add("سبرانزا");
        CarBrand.add("بي وا دي");
        CarBrand.add("هوندا");
        CarBrand.add("نيسان");
        CarBrand.add("لانسر");
        return CarBrand;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public List<String> getColors() {
        Colors.add("أحمر");
        Colors.add("أسود");
        Colors.add("أبيض");
        Colors.add("أخضر");
        Colors.add("برتقالي");
        Colors.add("أخضر");
        Colors.add("بني");
        Colors.add("أزرق");
        Colors.add("أصفر");
        Colors.add("فضي");
        Colors.add("ذهبي");
        return Colors;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public List<String> getLE() {
        for (int i = 100; i <= 20000; i += 100) {
            LE.add(String.valueOf(i));
        }
        return LE;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public List<String> getYears() {
        int SysYear = Integer.parseInt(new DateOp().getCustomSysDate("yyyy"));
        for (int i = (SysYear - 20); i > (SysYear - 25); i--) {
            years.add(String.valueOf(i));
        }
        return years;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public List<String> getMonthes() {
        for (int i = 1; i < 13; i++) {
            Monthes.add(String.valueOf(i));
        }
        return Monthes;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public List<String> getDayes() {
        for (int i = 1; i < 28; i++) {
            Dayes.add(String.valueOf(i));
        }
        return Dayes;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public List<String> getHours() {
        for (int i = 0; i < 24; i++) {
            Hours.add(String.valueOf(i));
        }
        return Hours;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public List<String> getMinutes() {
        for (int i = 0; i < 59; i++) {
            Minutes.add(String.valueOf(i));
        }
        return Minutes;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public List<String> getSeconds() {
        for (int i = 0; i < 59; i++) {
            Seconds.add(String.valueOf(i));
        }
        return Seconds;
    }

    ////////////////////////////////////////////////////////////////////////////////       
    public List<String> getDigit() {
        List<String> digit = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digit.add("" + i + "");
        }
        digit.add("A");
        digit.add("B");
        digit.add("C");
        digit.add("D");
        digit.add("E");
        digit.add("F");
        digit.add("G");
        digit.add("H");
        digit.add("I");
        digit.add("J");
        digit.add("K");
        digit.add("L");
        digit.add("M");
        digit.add("N");
        digit.add("O");
        digit.add("P");
        digit.add("Q");
        digit.add("R");
        digit.add("S");
        digit.add("T");
        digit.add("U");
        digit.add("V");
        digit.add("W");
        digit.add("X");
        digit.add("Y");
        digit.add("Z");
        return digit;
    }
    public List<String> getNumbers() {
        List<String> digit = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digit.add("" + i + "");
        }
        return digit;
    }

    public List<String> getQuantaty() {
        for (int i = 1; i < 21; i++) {
            quantaty.add("" + i + "");
        }
        return quantaty;
    }

    public List<String> getTonPrice() {
        for (int i = 150; i < 600; i += 50) {
            tonPrice.add("" + i + "");
        }
        return tonPrice;
    }

}
