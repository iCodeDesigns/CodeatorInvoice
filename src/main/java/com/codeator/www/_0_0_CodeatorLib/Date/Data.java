/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_CodeatorLib.Date;

import static com.codeator.www._0_4_CodeatorLib.Random_Numbers.RandomNumber.RandomNum;
import com.codeator.www._1_2_DB_entities_mysql.Departmens;
import com.codeator.www._1_3_DB_daos_mysql.DepartmensDao;
import java.util.List;

/**
 *
 * @author Mahmoud
 */
public class Data {

    /**
     * method that used to generate full name
     *
     * @return Full Name
     */
    public String getFullName() {
        String fullName = "";//empty Name
        List<String> SingleNames = new SeparitData().getSingleNames();//Get Separate Names
        // generate full Name
        for (int j = 0; j < 3; j++) {
            int randomNum = RandomNum(SingleNames.size());
            if (j == 0) {
                fullName = fullName + SingleNames.get(randomNum);
            } else {
                fullName = fullName + " " + SingleNames.get(randomNum);
            }
        }
        return fullName;
    }

    /**
     * method that used to generate City
     *
     * @return city Name
     */
    public String getCity() {
        String CityName;//empty Name
        List<String> cityies = new SeparitData().getCityes();//Get Cites
        // generate full Name
        int randomNum = RandomNum(cityies.size());
        CityName = cityies.get(randomNum);
        return CityName;
    }

    /**
     * method that used to generate Phone Number
     *
     * @return Full Name
     */
    public String getPhoneNumber() {
        String PhoneNumber = "";//empty Name
        List<String> PhoneNumberStarts = new SeparitData().getPhoneNumberStarts();//Get Separate Names
        int randomNum = RandomNum(PhoneNumberStarts.size());
        PhoneNumber += PhoneNumberStarts.get(randomNum);

        // generate full Name
        for (int j = 0; j < 8; j++) {
            int random = RandomNum(10);
            PhoneNumber += random;
        }
        return PhoneNumber;
    }

    /**
     * method that used to generate Car Brand
     *
     * @return Full Name
     */
    public String getCarBrand() {
        String CarBrandString;//empty Name
        List<String> CarBrand = new SeparitData().getCarBrand();//Get Separate Names
        int randomNum = RandomNum(CarBrand.size());
        CarBrandString = CarBrand.get(randomNum);

        return CarBrandString;
    }

    /**
     * method that used to generate Color
     *
     * @return Full Name
     */
    public String getColor() {
        String Color;//empty Name
        List<String> Colors = new SeparitData().getColors();//Get Separate Names
        int randomNum = RandomNum(Colors.size());
        Color = Colors.get(randomNum);
        return Color;
    }

    /**
     * method that used to generate Price
     *
     * @return Full Name
     */
    public String getPrice() {
        String Price;//empty Name
        List<String> LE = new SeparitData().getLE();//Get Separate Names
        int randomNum = RandomNum(LE.size());
        Price = LE.get(randomNum);
        return Price;
    }

    /**
     * method that used to generate Date
     *
     * @return
     */
    public String getDateRandom() {
        String Date = "";
        // get Random year
        List<String> years = new SeparitData().getYears();//Get Separate Names
        int randomNum = RandomNum(years.size());
        Date += years.get(randomNum) + "-";
        // get Random Month
        List<String> Monthes = new SeparitData().getMonthes();//Get Separate Names
        randomNum = RandomNum(Monthes.size());
        Date += Monthes.get(randomNum) + "-";
        // get Random day
        List<String> Dayes = new SeparitData().getDayes();//Get Separate Names
        randomNum = RandomNum(Dayes.size());
        Date += Dayes.get(randomNum);
        return Date;
    }

    /**
     * method that used to generate Time
     *
     * @return
     */
    public String getTimeRandom() {
        String Time = "";
        // get Random Houres
        List<String> Hours = new SeparitData().getHours();//Get Separate Names
        int randomNum = RandomNum(Hours.size());
        Time += Hours.get(randomNum) + ":";
        // get Random Minuts
        List<String> Minutes = new SeparitData().getMinutes();//Get Separate Names
        randomNum = RandomNum(Minutes.size());
        Time += Minutes.get(randomNum) + ":";
        // get Random Seconds
        List<String> Seconds = new SeparitData().getSeconds();//Get Separate Names
        randomNum = RandomNum(Seconds.size());
        Time += Seconds.get(randomNum);
        return Time;
    }

    public String getPasswordRandom() {
        String Password = "";
        List<String> digit = new SeparitData().getDigit();
        for (int i = 0; i < 5; i++) {
            int randomNum = RandomNum(digit.size());
            Password += digit.get(randomNum);
        }
        return Password;
    }

    public String getRandomEmpNo() {
        String Password = "";
        List<String> digit = new SeparitData().getNumbers();
        for (int i = 0; i < 5; i++) {
            int randomNum = RandomNum(digit.size());
            Password += digit.get(randomNum);
        }
        return Password;
    }

    public Departmens getRandomDepartment() {
        List<Departmens> dList = new DepartmensDao().GetAllDepartments();
        int randomNum = RandomNum(dList.size());
        Departmens d = dList.get(randomNum);
        return d;
    }

}
