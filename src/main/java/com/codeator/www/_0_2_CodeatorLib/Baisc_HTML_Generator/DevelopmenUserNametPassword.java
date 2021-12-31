/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_2_CodeatorLib.Baisc_HTML_Generator;

/**
 *
 * @author Mohamed
 */
public class DevelopmenUserNametPassword {

    private final String UserName = "1234";
    private final String Password = "24688642";
    private final String Name = "Administrator";

    private boolean Status = false;

    public DevelopmenUserNametPassword() {
    }

    public DevelopmenUserNametPassword(String UserName, String Password, String Name) {
        if (UserName.equals(this.UserName) && Password.equals(this.Password) && Name.equals(this.Name)) {
            this.Status = true;
        } else {
            this.Status = false;
        }
    }
    public DevelopmenUserNametPassword(String Name) {
        if (Name.equals(this.Name)) {
            this.Status = true;
        } else {
            this.Status = false;
        }
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }

    public boolean isStatus() {
        return Status;
    }

}
