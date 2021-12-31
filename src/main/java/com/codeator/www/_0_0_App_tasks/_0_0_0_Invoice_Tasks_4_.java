/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_0_App_tasks;

import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author Moham
 */
public class _0_0_0_Invoice_Tasks_4_ extends TimerTask {

    private boolean letsRun = true;

    @Override
    public void run() {
        if (letsRun) {
            letsRun = false;
            try {
                System.out.println(" ---------------------------------------------------------- ");
                System.out.println(" -------------------- Token Generation --------------------- ");
                System.out.println(" - Token Generated In : " + new Date());
                _0_0_1_API_Login._0_0_1_API_Login();
                System.out.println(" ---------------------------------------------------------- ");
            } catch (Exception e) {
                //e.printStackTrace();
            }
            letsRun = true;
        }
    }
}
