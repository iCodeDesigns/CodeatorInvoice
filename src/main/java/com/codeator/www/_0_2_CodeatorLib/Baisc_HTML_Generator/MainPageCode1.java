package com.codeator.www._0_2_CodeatorLib.Baisc_HTML_Generator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.codeator.www._1_2_DB_entities.PerEmploymentMaster;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eng_MahmoudAhmed
 */
public class MainPageCode1 {

    /**
     * class that used to get the HTML code of main tabs.
     *
     * @return HTML code of the main tabs of each system page.
     */
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
                + "                                        <li><a href=\"#\"><i class=\"fa fa-user pull-right\" style=\"font-size: 25px;\"></i>البيانات الشخصية</a></li>\n"
                + "                                        <li><a href=\"_0_0_0_0_LogOutControlServlet\"><i class=\"fa fa-sign-out pull-right\" style=\"font-size: 25px;\"></i>خروج</a></li>\n"
                + "                                    </ul>";
    }

    /**
     * class that used to get the HTML code of main tabs.
     *
     * @return HTML code of the main tabs of each system page.
     */
    public String testMethod(PerEmploymentMaster employee_session) {

//_9_9_9_9_9_9_Application_Super_ControlAccessServlet
        String Sidebar_Menu = "<div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\" style=\"font-size: 16px;\">\n"
                + "    <div class=\"menu_section\">\n"
                + "        <ul class=\"nav side-menu\">\n";
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Sidebar_Menu += getTalabCar(employee_session);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Sidebar_Menu += get3ohad(employee_session);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Sidebar_Menu += getEinvoice(employee_session);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Sidebar_Menu += getOtherLinks(employee_session);

        Sidebar_Menu += "    </div>\n"
                + "</div>";

        return Sidebar_Menu;
    }

    private String getTalabCar(PerEmploymentMaster employee_session) {
        String Sidebar_Menu = "";
        Sidebar_Menu += "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-car\"></i> طلبات السيارات<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        // البيانات الأساسية
        //Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_1_Car_RequestAccessServlet\" style=\"font-weight: bold;\">طلب سيارة</a></li>\n";
        //Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_2_Car_RequestManegersRequestHandelerAccessServlet\" style=\"font-weight: bold;\">إستعلام طلبات السيارات بالإدارة</a></li>\n";
        //Sidebar_Menu += "                    <li><a href=\"#\" style=\"font-weight: bold;\">الحد الأقصى لطلب السيارات</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_6_Car_Request_FromTransportaionOfficeAccessServlet\" style=\"font-weight: bold;\">طلب سيارة من مكتب النقل</a></li>\n";
        //Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_3_Car_RequestTranspoetOfficeRequestHandelerAccessServlet\" style=\"font-weight: bold;\">إستعلام عن طلبات السيارات بكل الإدارات</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_4_Car_RequestTranspoetOfficeFinalActionAccessServlet\" style=\"font-weight: bold;\">تفعيل الطلبات المقبولة</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_5_Car_RequestTranspoetOfficeHistoryAccessServlet\" style=\"font-weight: bold;\">إستعلام عن الرحلات السابقة</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_7_Vehicle_Driver_Join_query_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عن سائقي السيارات</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_8_Requests_Count_Per_Day_Query_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عدد الرحلات اليومية</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عن الاشتراكات</a></li>\n";/*_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_AccessServlet*/
        Sidebar_Menu += "                    <li><a href=\"_0_0_2_0_0_Transportation_Main_DashBoard_AccessServlet\" style=\"font-weight: bold;\">احصائيات النقل</a></li>\n";/*_0_0_2_0_0_Transportation_Main_DashBoard_AccessServlet*/

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    private String get3ohad(PerEmploymentMaster employee_session) {
        String Sidebar_Menu = "";
        Sidebar_Menu += "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-line-chart\"></i>احصائيات عامة<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += "                    <li><a href=\"_0_0_1_0_0_StoItemCate_Query_AccessServlet\" style=\"font-weight: bold;\">إحصائيات العهد</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_AccessServlet\" style=\"font-weight: bold;\">احصائيات الاشتراكات</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_Main_AccessServlet\" style=\"font-weight: bold;\">احصائيات عامة للاشتراكات</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_0_0_3_0_0_Sup_Suppliers_Info_Test_AccessServlet\" style=\"font-weight: bold;\">احصائيات الموردين</a></li>\n";

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    private String getEinvoice(PerEmploymentMaster employee_session) {
        String Sidebar_Menu = "";
        Sidebar_Menu += "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-money\"></i>الفاتورة الإلكترونية<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                     <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_1_Electronic_Invoice_Submit_AccessServlet\" style=\"font-weight: bold;\">إدخال فاتورة</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_1_Electronic_Invoice_Submit01Test_AccessServlet\" style=\"font-weight: bold;\">إدخال فاتورة للضرائب مباشرة</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_2_Electronic_Invoice_Query_AccessServlet\" style=\"font-weight: bold;\">استعلام عن الفواتير</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_2_Electronic_Invoice_Query_revision_AccessServlet\" style=\"font-weight: bold;\">مراجعة الفواتير</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_2_Electronic_Invoice_Query_verify_AccessServlet\" style=\"font-weight: bold;\">اعتماد الفواتير</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_2_Electronic_Invoice_Query_zPortal_Send_AccessServlet\" style=\"font-weight: bold;\">إرسال الفواتير للضرائب</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_3_Electronic_Invoice_Query_01_From_zPortal_AccessServlet\" style=\"font-weight: bold;\">إستعلام عن الفواتير المرسلة للضرائب</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_4_Electronic_Invoice_Invoice_Status_InTax_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عن حالة الفواتير بمصلحة الضرائب</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_5_Inv_Item_Code_Query_AccessServlet\" style=\"font-weight: bold;\">الاستعلام عن الأصناف</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_6_Pur_Supplier_Work_insert_Query_AccessServlet\" style=\"font-weight: bold;\">إضافة واستعلام عن الموردين</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"_1_0_0_0_7_Electronic_Invoice_Dept_Charts_AccessServlet\" style=\"font-weight: bold;\">أحصائبات الفاتورة الإلكترونية لإدارة</a></li>\n";

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

    private String getOtherLinks(PerEmploymentMaster employee_session) {
        String Sidebar_Menu = "";
        Sidebar_Menu += "            <li><a style=\"font-weight: bold;\"><i class=\"fa fa-search\"></i> روابط أخرى<span style=\"font-size: 17px;\" class=\"fa fa-chevron-circle-down\"></span></a>\n"
                + "                <ul class=\"nav child_menu\">\n";

        Sidebar_Menu += "                    <li><a href=\"#\" style=\"font-weight: bold;\">طلب أجازة</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"#\" style=\"font-weight: bold;\">إستعلام عن الحافز</a></li>\n";
        Sidebar_Menu += "                    <li><a href=\"#\" style=\"font-weight: bold;\">نظم الأهرام الإدارية</a></li>\n";

        Sidebar_Menu += "                </ul>\n"
                + "            </li>\n";
        return Sidebar_Menu;
    }

}
