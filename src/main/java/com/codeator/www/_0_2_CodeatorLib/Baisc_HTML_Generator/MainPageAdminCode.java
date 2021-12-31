/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeator.www._0_2_CodeatorLib.Baisc_HTML_Generator;

/**
 *
 * @author Moham
 */
public class MainPageAdminCode {

    public String AdminMethod() {
        return getDBMenu();
    }

    private static String getDBMenu() {

        String Sidebar_Menu = "<div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\" style=\"font-size: 16px;\">\n"
                + "    <div class=\"menu_section\">\n"
                + "        <ul class=\"nav side-menu\">\n";

        Sidebar_Menu += ControlPanal();
        Sidebar_Menu += Authorization();

        Sidebar_Menu += "   </ul></div>\n"
                + "</div>";

        return Sidebar_Menu;
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    private static String ControlPanal() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-codepen\"></i>Control Panal<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += ScreenControl();

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    private static String ScreenControl() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-gears\"></i>Screens Control<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += "                    <li><a href=\"_9_9_9_9_9_9_Application_Super_Control_AccessServlet\" style=\"font-weight: bold;\">System Screens Basic Data</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_9_9_9_9_9_7_Application_Menu_Index_Sort_AccessServlet\" style=\"font-weight: bold;\">System Screens Index Sorting</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_9_9_9_9_9_5_Application_Menu_Screen_Elements_AccessServlet\" style=\"font-weight: bold;\">System Screens Add Elements</a></li>\n";

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    private static String Authorization() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-codepen\"></i>Screen Auth<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += Screen_Auth_Distribution();

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    private static String Screen_Auth_Distribution() {
        String Sidebar_Menu = "<li><a style=\"font-weight: bold;\"><i class=\"fa fa-users\"></i>Screen Authorization<span style=\"font-size: 17px;width: 9px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += "                    <li><a href=\"_9_9_9_9_9_6_Employee_Screen_Auth_Distribution_AccessServlet\" style=\"font-weight: bold;\">Employee - Screen Authorization Distribution</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_9_9_9_9_9_4_Employee_ScreenElements_Auth_Distribution_AccessServlet\" style=\"font-weight: bold;\">Employee - Screen Elements Authorization Distribution</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_9_9_9_9_9_3_Employee_System_logedIn_AccessServlet\" style=\"font-weight: bold;\">Employee Watch</a></li>\n";

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    public String getAdimMenu() {
        return "<ul class=\"dropdown-menu dropdown-usermenu pull-right\" style=\"font-size: 16px;\">\n"
                + "                                        <li><a href=\"_9_9_9_9_9_8_DevelopWelcomePage_AccessServlet\"><i class=\"fa fa-home pull-right\" style=\"font-size: 25px;\"></i>الرئيسية</a></li>\n"
                + "                                        <li><a href=\"LogOutDevelopControlServlet\"><i class=\"fa fa-sign-out pull-right\" style=\"font-size: 25px;\"></i>خروج</a></li>\n"
                + "                                    </ul>";
    }
}
