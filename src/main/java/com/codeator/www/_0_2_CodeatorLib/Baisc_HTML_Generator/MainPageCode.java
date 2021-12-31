/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_2_CodeatorLib.Baisc_HTML_Generator;

import com.codeator.www._0_0_CodeatorLib.Encryption;
import com.codeator.www._0_0_CodeatorLib.FileOp;
import com.codeator.www._1_0_SystemFilter._00010_Login_BusinessRule;
import com.codeator.www._1_2_DB_entities.AppName;
import com.codeator.www._1_2_DB_entities.AppSubTab;
import com.codeator.www._1_2_DB_entities.AppSubTabSpecAuth;
import com.codeator.www._1_2_DB_entities.AppTabs;
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import com.codeator.www._1_3_DB_daos.AppName_DAO;
import com.codeator.www._1_3_DB_daos.AppSubTabSpecAuth_DAO;
import com.codeator.www._1_3_DB_daos.AppSubTab_DAO;
import com.codeator.www._1_3_DB_daos.AppTabs_DAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Moham
 */
public class MainPageCode {

    public synchronized String testMethod(HttpServletRequest request, PerEmploymentMaster employee_session) {
        String host = request.getHeader("host"); // -- Server Host IP and PORT
        String Client_IP = request.getRemoteAddr();// -- Client IP
        new _00010_Login_BusinessRule().loginControl(request.getSession(), host, Client_IP, employee_session);
        //DevelopmenUserNametPassword p = new DevelopmenUserNametPassword(employee_session.getEmpAname());
        request.getSession().setAttribute("LastActiveTime", new Date());

        String employeeId = "" + employee_session.getEmployeeId();
        ////System.out.println(employeeId);
        //List<PerOrganizationStructure> PerOrganizationStructureBossList = new PerOrganizationStructure_DAO().getPerOrganizationStructureBigBossID2(employeeId);

        String Sidebar_Menu = "<div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\" style=\"font-size: 16px;\">\n"
                + "    <div class=\"menu_section\">\n"
                + "        <ul class=\"nav side-menu\">\n";
        try {
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
            List<AppName> pList = new AppName_DAO().getAll_ApplicationName();
            for (AppName applicationName : pList) {
                Sidebar_Menu += Nezam(applicationName, employeeId);
                //break;
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        } catch (Exception e) {
            e.printStackTrace();
        }
        Sidebar_Menu += "   </ul></div>\n"
                + "</div>";
        return Sidebar_Menu;
    }

    public String Nezam(AppName applicationName, String employeeId) {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\" id='A_" + applicationName.getApplicationId() + "'><i class=\"fa fa-codepen\"></i>" + applicationName.getApplicationName() + "<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";
        List<AppTabs> pList = new AppTabs_DAO().get_ApplicationTabsByApplicationId("" + applicationName.getApplicationId());
        for (AppTabs applicationTabs : pList) {
            Sidebar_Menu += Tabs(applicationTabs, employeeId);
            //break;
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    public String Tabs(AppTabs applicationTabs, String employeeId) {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\" id='T_" + applicationTabs.getId().getApplicationId() + "-" + applicationTabs.getId().getTabId() + "'><i class=\"" + applicationTabs.getTabFafaIcon() + "\"></i>" + applicationTabs.getTabName() + "<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";
        List<AppSubTab> pList = new AppSubTab_DAO().get_ApplicationSubTabsByApplicationId("" + applicationTabs.getId().getApplicationId(), "" + applicationTabs.getId().getTabId());
        for (AppSubTab applicationSubTab : pList) {
            String AvailableToUserControl = applicationSubTab.getAvailableToUserControl();
            String App = "" + applicationSubTab.getId().getApplicationId();
            String Tab = "" + applicationSubTab.getId().getTabId();
            String SubTab = "" + applicationSubTab.getId().getSubTabId();
            String status = new MainPageCode().checkScreen(AvailableToUserControl, App, Tab, SubTab, employeeId);

            // 0 = Demo | 1 = can use | 2 = DB Manipulation | 3 = No Access
            if (status.equals("1")) {
                Sidebar_Menu += "                    <li><a href=\"" + applicationSubTab.getSubTabAccessservlet() + "\" style=\"font-weight: bold;\" id='S_" + applicationSubTab.getId().getApplicationId() + "-" + applicationSubTab.getId().getTabId() + "-" + applicationSubTab.getId().getSubTabId() + "' >" + applicationSubTab.getSubTabName() + "</a></li>\n";
            } else if (status.equals("2")) {
                Sidebar_Menu += "                    <li><a href=\"#\" onclick=\"Custom_Warning('جاري صيانة هذه الشاشة .. برجاء الإتصال بالدعم الفني','500px');\" style=\"font-weight: bold;\" id='S_" + applicationSubTab.getId().getApplicationId() + "-" + applicationSubTab.getId().getTabId() + "-" + applicationSubTab.getId().getSubTabId() + "' >" + applicationSubTab.getSubTabName() + "</a></li>\n";
            } else if (status.equals("3")) {
                Sidebar_Menu += "                    <li><a href=\"#\" onclick=\"Custom_Warning('ليس لك صلاحية على تلك الشاشة','500px');\" style=\"font-weight: bold;\" id='S_" + applicationSubTab.getId().getApplicationId() + "-" + applicationSubTab.getId().getTabId() + "-" + applicationSubTab.getId().getSubTabId() + "' >" + applicationSubTab.getSubTabName() + "</a></li>\n";
            } else {
                Sidebar_Menu += "                    <li><a href=\"#\" onclick=\"Custom_Warning('هذه الصفحة غير متاحة','500px');\" style=\"font-weight: bold;\" id='S_" + applicationSubTab.getId().getApplicationId() + "-" + applicationSubTab.getId().getTabId() + "-" + applicationSubTab.getId().getSubTabId() + "' >" + applicationSubTab.getSubTabName() + "</a></li>\n";
            }
            // break;
        }

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    public String checkScreen(String AvailableToUserControl, String App, String Tab, String SubTab, String employeeId) {

        List<Character> chars = new Encryption().decrypt_AvailableToUserControl(AvailableToUserControl);

        boolean General = false;
        boolean LIC_File_Exist = false;
        boolean DB_Manipulation = false;
        boolean User_Access = false;
        boolean Screen_Active = false;
        // 0 = Demo | 1 = can use | 2 = DB Manipulation | 3 = No Access
        String Status = "0";
        String AppCode = "" + chars.get(0);
        String TabCode = "" + chars.get(1);
        String SubTabCode = "" + chars.get(2);
        String statusCode = "" + chars.get(3);
        if (App.equals(AppCode) && Tab.equals(TabCode) && SubTab.equals(SubTabCode) && "1".equals(statusCode)) {
            Screen_Active = true;
        } else {
            Screen_Active = false;
        }
        String FileName = "S_" + App + Tab + SubTab;
        try {
            FileOp file = new FileOp("C:\\LIC\\b532t91\\" + FileName + ".txt");
            String line = file.ReadFileInWebApp();//2021-01-01
            if (!AvailableToUserControl.equals(line.split("\r\n")[0])) {
                DB_Manipulation = true;
            } else {
                List<AppSubTab> ApplicationSubTabList = new AppSubTab_DAO().get_ApplicationSubTabsByApplicationIdWithAuthType1(App, Tab, SubTab);
                List<AppSubTabSpecAuth> screenAuthList = new AppSubTabSpecAuth_DAO().getEmpSubTabSpecAuth(employeeId, App, Tab, SubTab);
                if (!ApplicationSubTabList.isEmpty()) {
                    General = true;
                }
                if (!screenAuthList.isEmpty()) {
                    User_Access = true;
                }

            }
            LIC_File_Exist = true;
        } catch (Exception e) {
            LIC_File_Exist = false;
        }
        // 0 = Demo | 1 = can use | 2 = DB Manipulation | 3 = No Access

        if (!LIC_File_Exist || !Screen_Active) {
            Status = "0";
        } else if (DB_Manipulation) {
            Status = "2";
        } else if (General || User_Access) {
            Status = "1";
        } else {
            Status = "3";
        }
        /*//System.out.println(" -------------- APP_TAB_SUBTAB    = " + App+"-"+Tab+"-"+SubTab);
        //System.out.println(" -------------- LIC_File_Exist    = " + LIC_File_Exist);
        //System.out.println(" -------------- DB_Manipulation   = " + DB_Manipulation);
        //System.out.println(" --------------     General       = " + General);
        //System.out.println(" --------------   User_Access     = " + User_Access);
        //System.out.println(" --------------      Status       = " + Status);*/
        return Status;
    }

    public String sidebar_menu() {
        String HTML_Code = "";
        FileReader html_file;
        try {
            html_file = new FileReader("web/sidebar_menu.html");
            BufferedReader in = new BufferedReader(html_file);
            String str;
            while ((str = in.readLine()) != null) {
                HTML_Code += str + "\n";
            }
        } catch (IOException ex) {
            ex.getMessage();
        }

        return HTML_Code;
    }

    public String getUserMenu() {
        return "<ul class=\"dropdown-menu dropdown-usermenu pull-right\" style=\"font-size: 16px;\">\n"
                + "                                        <li><a href=\"_0_0_0_0_MainMenuAccessServlet\"><i class=\"fa fa-home pull-right\" style=\"font-size: 25px;\"></i>الرئيسية</a></li>\n"
                + "                                        <li onclick='OpenResetModel(true);'><a href=\"#\"><i class=\"fa fa-key pull-right\" style=\"font-size: 25px;\"></i>تغيير كلمة المرور</a></li>\n"
                + "                                        <li><a href=\"_0_0_0_0_0_3_userProfile_AccessServlet\"><i class=\"fa fa-user pull-right\" style=\"font-size: 25px;\"></i>البيانات الشخصية</a></li>\n"
                + "                                        <li><a href=\"_0_0_0_0_LogOutControlServlet\"><i class=\"fa fa-sign-out pull-right\" style=\"font-size: 25px;\"></i>خروج</a></li>\n"
                + "                                    </ul>";
    }
}
