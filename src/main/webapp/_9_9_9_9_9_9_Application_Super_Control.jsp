<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>


<%@page import="com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp"%>
<%@page import="com.codeator.www._1_3_DB_daos.AppSubTabAuthType_DAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.AppSubTabAuthType"%>
<%@page import="com.codeator.www._0_2_CodeatorLib.Baisc_HTML_Generator.IconsDropBox"%>
<%@page import="com.codeator.www._0_2_CodeatorLib.Baisc_HTML_Generator.MainPageAdminCode"%>
<%@page import="com.taxdemo.www._6_0_2_Enities_For_Developers.Admin_session"%>
<%@page import="com.codeator.www._1_1_DB_mainDao.HibernateSessionCon"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    new HibernateSessionCon().OpenCon();
    new HibernateSessionCon().clearConn();
    try {
        String key = (String) request.getSession().getAttribute("OpenHTMLFile");
        if (key.equals("Open")) {
            Admin_session admin_session = (Admin_session) request.getSession().getAttribute("admin_session");

            String employee_name = admin_session.getName();

            //String employee_name = employee_session.getEmpAname()+"-"+employee_session.getPerOrganizationStructureByOrgIdFrom().getOrgName()+"-"+employee_session.getPerOrganizationStructureByOrgIdFrom().getEmpBigBoss();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="UTF-8"><meta http-equiv='cache-control' content='no-cache'><meta http-equiv='expires' content='0'><meta http-equiv='pragma' content='no-cache'>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>شاشة التحكم الرئيسية</title>
        <link rel="shortcut icon" type="image/x-icon" href="webDesign/production/images/calendar.png">


        <link href="https://fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
        <!-- Bootstrap -->
        <link href="webDesign/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="webDesign/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="webDesign/vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- jQuery custom content scroller -->
        <link href="webDesign/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>

        <!-- Datatables -->
        <link href="webDesign/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="webDesign/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

        <!-- bootstrap-daterangepicker -->
        <link href="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
        <!-- bootstrap-datetimepicker -->
        <link href="webDesign/vendors/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
        <!-- PNotify -->
        <link href="webDesign/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
        <link href="webDesign/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">

        <!-- bootstrap-wysiwyg -->
        <link href="webDesign/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">

        <!-- jQuery custom content scroller -->
        <link href="webDesign/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>

        <!-- Custom Theme Style -->
        <link href="webDesign/build/css/custom.min.css" rel="stylesheet">

        <style>
            /*Menu Color*/
            /*.systemColor{
                background-color: #3086d2;
            }*/
            /*opened Tab right  Color*/
            /*.nav.side-menu>li.active, 
            .nav.side-menu>li.current-page{
                border-right: 5px solid #bb1aaf;
            }  */      
            /*opened Tab Color*/
            /*.nav.side-menu>li.active>a {
                text-shadow: rgba(0,0,0,.25) 0 -1px 0;
                background: linear-gradient(#3ea1ff,#1e2cca),#131e33;
                box-shadow: rgba(0,0,0,.25) 0 1px 0, inset rgba(255,255,255,.16) 0 1px 0;
            }*/
            /*Text Tab color*/
            /*.nav.child_menu>li>a, 
            .nav.side-menu>li>a {
                color: #ff0000;
            }*/
            /*Text Tab color*/
            /*.nav li li.current-page a, 
            .nav.child_menu li li a.active, 
            .nav.child_menu li li a:hover {
                color: #ff0000;
            }*/
            /*Hover On Text Sub Tab*/
            /*.nav li li.current-page a, .nav.child_menu li li a.active, .nav.child_menu li li a:hover {
                color: #ff0000;
            }
            .nav-md ul.nav.child_menu li:before {
                background: #ff0000;
            }
            .nav-md ul.nav.child_menu li:after {
                border-left: 1px solid #ff0000;
            }*/
            /*******************************************************************************************************************************/
            /*******************************************************************************************************************************/
            /*******************************************************************************************************************************/
            /*******************************************************************************************************************************/
            .cardclass{
                background-color: #851934;
                box-shadow: -3px 12px 12px 5px #888888;
                font-size: 160%;
            }
            .button_style{
                border: none;
                background: #131e33;
                color: #ffffff !important;
                font-weight: 100;
                padding: 10px;
                text-transform: uppercase;
                border-radius: 6px;
                display: inline-block;
                transition: all 0.3s ease 0s;
            }
            .button_style:hover {
                color: #ffffff !important;
                font-weight: 700 !important;
                letter-spacing: 3px;
                background: #131e33;
                -webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
                -moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
                transition: all 0.3s ease 0s;
            }
            .button_position{
                margin-top: 32px;
                width: 100%;

            }
            input:focus {
                background-color: #c4f5fa;
            }
            select:focus {
                background-color: #c4f5fa;
            }
            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none; 
                margin: 0; 
            }
            .left_col {
                background: black;
            }
            .nav_title {
                width: 230px;
                float: left;
                background: black;
                border-radius: 0;
                height: 57px;
            }
            .bg-black{
                background: black !important;
                border: 1px solid black !important;
                color: #fff;
            }
        </style>

    </head>

    <script>
        setInterval(drawTime, 1000);


        function drawTime() {
            var now = new Date();
            var year = now.getFullYear();
            var month = now.getMonth() + 1;
            var day = now.getDate();
            var hour = now.getHours();
            var minute = now.getMinutes();
            var second = now.getSeconds();
            var AM = "AM";
            document.getElementById("clock").innerHTML = " " + hour + " : " + minute + " : " + second;
            document.getElementById("dateD").innerHTML = " " + year + " - " + month + " - " + day;
        }
        function TodayName() {
            var d = new Date();
            var weekday = new Array(7);
            weekday[0] = "الأحد";
            weekday[1] = "الإثنين";
            weekday[2] = "الثلاثاء";
            weekday[3] = "الأربعاء";
            weekday[4] = "الخميس";
            weekday[5] = "الجمعة";
            weekday[6] = "السبت";

            var n = weekday[d.getDay()];
            document.getElementById("dayId").innerHTML = n;
        }

    </script><!--oncontextmenu="return false"-->

    <body class="nav-md" onload="TodayName();" style="color: #000000;" >
        <div class="container body">
            <div class="main_container">
                <div class="systemColor col-md-3 left_col menu_fixed ">
                    <div class="systemColor left_col scroll-view">
                        <div class="systemColor navbar nav_title" style="border: 0;padding-top: 10px;">
                            <a href="_0_0_0_0_MainMenuAccessServlet" class="site_title">
                                <div style="text-align: center;">
                                </div>
                            </a>
                        </div>

                        <div class="clearfix"></div>

                        <!-- menu profile quick info -->
                        <div class="profile clearfix" style="padding-top: 10px;">
                            <div class="profile_pic" style="padding-top: 8px;">
                                <img src="webDesign/production/images/vendCircleWhite.png" alt="..." class="img-circle profile_img" style="background: #000;">
                            </div>
                            <div class="profile_info">
                                <span style="font-size: 20px;padding-left: 15px;font-weight: bold;">اسم المستخدم</span>
                                <h2 style="font-size: 15px;font-weight: bold;"><%=employee_name%></h2>
                            </div>
                        </div>
                        <!-- /menu profile quick info -->

                        <br />

                        <!-- side bar menu -->
                        <%
                            String M = new MainPageAdminCode().AdminMethod();
                        %>
                        <%=M%>
                        <!-- /side bar menu -->


                    </div>
                </div>

                <!-- top navigation -->
                <div class="top_nav">
                    <div class="nav_menu">
                        <nav>
                            <div class="nav toggle">
                                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                            </div>

                            <ul class="nav navbar-nav navbar-right">
                                <li class="" >
                                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="color: black;font-size: 20px;">
                                        <%=employee_name%>
                                        <span class=" fa fa-angle-down"></span>
                                    </a>
                                    <%
                                        String M2 = new MainPageAdminCode().getAdimMenu();
                                    %>
                                    <%=M2%>
                                </li>
                                <li role="presentation" class="dropdown" >
                                    <a href="javascript:;" class=""  aria-expanded="false">

                                        <span class="badge bg-black fa fa-clock-o" id="clock" style="font-size: 20px;"></span>                                        
                                        <span class="badge bg-black fa fa-calendar" id="dateD" style="font-size: 20px;"></span>                                         
                                        <span class="" id="dayId" style="color: black;font-size: 20px;"></span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- /top navigation -->





                <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->




                <!-- page content -->

                <div class="right_col" role="main">

                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                        <div class="page-title">
                            <div class="title_right">
                                <h3 style="font-weight: bold;">شاشة التحم الرئيسية</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <!--card Start -->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <div class="x_title">
                                <h2 style="width: 50%;">إضافة الأنظمة</h2>
                                <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-down"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <!-- for Edit -->                            

                            <div class="x_content" style="display: none;">
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" style="border-left: 2px solid #e6e9ed;">                                
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                        <label class="control-label" style="font-size: 20px;">إسم النظام</label>
                                        <input style="font-size: 15px;font-weight: bold;" type="text" placeholder="إسم النظام" maxlength="50" data-placement="bottom" id="applicationName" name="applicationName" class="form-control" required="">
                                    </div>                                  

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">                                            
                                        <button type="button" data-placement="top" onclick="doAddApplicationName();" class="button_style btn btn-sm btn-primary button_position fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> حفظ</button>
                                    </div>
                                </div>
                                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" style="border-right: 2px solid #e6e9ed;">                                
                                    <table id="" class="table table-striped table-bordered table-hover" style="text-align: center;font-size: large;">
                                        <thead style="background-color: #131e33;color: white;">
                                            <tr>
                                                <th style="text-align: center;font-size: large;">كود النظام</th>
                                                <th style="text-align: center;font-size: large;">الترتيب في القائمة</th>
                                                <th style="text-align: center;font-size: large;">إسم النظام</th>
                                                <th style="text-align: center;font-size: large;"></th>
                                            </tr>
                                        </thead>

                                        <tbody id="ApplicationNameBasic_Data">
                                            <tr>
                                                <td colspan="3"><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /for Edit -->
                            <div class="modal fade UpdateApplication" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">

                                        <div class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                            </button>
                                            <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">تعديل بيانات النظام</h4>
                                        </div>
                                        <div class="modal-body" >
                                            <div class="row" id="EditFloorBody" style="direction: rtl;font-size: 30px;">
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                                    <label class="control-label" style="font-size: 20px;">إسم النظام</label>
                                                    <input style="font-size: 15px;font-weight: bold;" type="text" placeholder="إسم النظام" maxlength="50" data-placement="bottom" id="applicationNameE" name="applicationNameE" class="form-control" required="">
                                                </div>                               

                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">                                            
                                                    <button type="button" data-placement="top" onclick="doUpdateApplicationName();" data-dismiss="modal" class="button_style btn btn-sm btn-primary button_position fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> تعديل</button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer" style="background-color: #131e33;">

                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="modal fade DeleteApplication" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-lg" >
                                    <div class="modal-content">

                                        <div class="modal-header" style="background: #d9534f;color: white;direction: rtl;">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                            </button>
                                            <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">تنبيه</h4>
                                        </div>
                                        <div class="modal-body" >

                                            <div class="row" id="DeleteFloorDone" style="direction: rtl;font-size: 30px;text-align: center;">
                                                <h1 style="color: #d9534f;">هل انت متأكد من عملية الحذف تلك ؟</h1>
                                            </div>
                                        </div>
                                        <div class="modal-footer" style="background-color: #d9534f;">

                                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="doDeleteApplicationName();" style="font-weight: bold;border-color: black;width: 15%;float: right;" id="ModalButton1">نعم</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;float: left;">لا</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <div class="x_title">
                                <h2 style="width: 50%;">إضافة القوائم</h2>
                                <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-down"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <!-- for Edit -->                            

                            <div class="x_content" style="display: none;">
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" style="border-left: 2px solid #e6e9ed;">                                
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                        <label class="control-label" style="font-size: 20px;">إسم القائمة</label>
                                        <input style="font-size: 15px;font-weight: bold;" type="text" placeholder="إسم القائمة" onkeyup="LoadBasicDataFromApplicationNameForDropBox();" maxlength="50" data-placement="bottom" id="tabName" name="tabName" class="form-control" required="">
                                    </div>   
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <label class="control-label" style="font-size: 20px;">النظام</label>
                                        <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="النظام" id="applicationId" maxlength="45" name="applicationId" class="form-control" required="">                                            
                                        </select>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group" >
                                        <label class="control-label" style="font-size: 20px;">أيقونة القائمة</label>                                                                               
                                        <div class='input-group date' id='' style="direction: ltr;">
                                            <select style="font-size: 15px;font-weight: bold;" onchange="showIcon('tabFafaIcon', 'iconSpan');" type="text" placeholder="أيقونة القائمة" id="tabFafaIcon" maxlength="45" name="tabFafaIcon" class="form-control" required="">                                            
                                                <option value="">اختر أيقونة</option>       
                                                <%
                                                    String i = new IconsDropBox().getIconsOptions();
                                                %>
                                                <%=i%>
                                            </select>
                                            <span class="input-group-addon" style="font-size: xx-large;">
                                                <span class="" id="iconSpan"></span>
                                            </span>
                                        </div>                               
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">                                            
                                        <button type="button" data-placement="top" onclick="doAddApplicationTabs();" class="button_style btn btn-sm btn-primary button_position fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> حفظ</button>
                                    </div>
                                </div>
                                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" style="border-right: 2px solid #e6e9ed;">                                
                                    <table id="ApplicationTabsBasic_Data" class="table table-striped table-bordered table-hover" style="text-align: center;font-size: large;">
                                        <tr>
                                            <td colspan="2"><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50></td>
                                        </tr>                                        
                                    </table>
                                </div>
                            </div>
                            <!-- /for Edit -->
                            <div class="modal fade UpdateAppTabs" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">

                                        <div class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                            </button>
                                            <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">تعديل بيانات القوائم</h4>
                                        </div>
                                        <div class="modal-body" >
                                            <div class="row" id="EditFloorBody" style="direction: rtl;font-size: 30px;">
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                                    <label class="control-label" style="font-size: 20px;">إسم القائمة</label>
                                                    <input style="font-size: 15px;font-weight: bold;" type="text" placeholder="إسم القائمة" maxlength="50" data-placement="bottom" id="tabNameE" name="tabNameE" class="form-control" required="">
                                                </div>
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group" >
                                                    <label class="control-label" style="font-size: 20px;">أيقونة القائمة</label>                                                                               
                                                    <div class='input-group date' id='' style="direction: ltr;">
                                                        <select style="font-size: 15px;font-weight: bold;" onchange="showIcon('tabFafaIconE', 'iconSpanE');" type="text" placeholder="أيقونة القائمة" id="tabFafaIconE" maxlength="45" name="tabFafaIconE" class="form-control" required="">                                            
                                                            <option value="">اختر أيقونة</option>       
                                                            <%=i%>
                                                        </select>
                                                        <span class="input-group-addon" style="font-size: xx-large;">
                                                            <span class="" id="iconSpanE"></span>
                                                        </span>
                                                    </div>                               
                                                </div>

                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">                                            
                                                    <button type="button" data-placement="top" onclick="doUpdateApplicationTabs();" data-dismiss="modal" class="button_style btn btn-sm btn-primary button_position fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> تعديل</button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer" style="background-color: #131e33;">

                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="modal fade DeleteApplicationTabs" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-lg" >
                                    <div class="modal-content">

                                        <div class="modal-header" style="background: #d9534f;color: white;direction: rtl;">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                            </button>
                                            <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">تنبيه</h4>
                                        </div>
                                        <div class="modal-body" >

                                            <div class="row" id="DeleteFloorDone" style="direction: rtl;font-size: 30px;text-align: center;">
                                                <h1 style="color: #d9534f;">هل انت متأكد من عملية الحذف تلك ؟</h1>
                                            </div>
                                        </div>
                                        <div class="modal-footer" style="background-color: #d9534f;">

                                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="doDeleteApplicationTabs();" style="font-weight: bold;border-color: black;width: 15%;float: right;" id="ModalButton1">نعم</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;float: left;">لا</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <div class="x_title">
                                <h2 style="width: 50%;">إضافة شاشات</h2>
                                <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-down"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <!-- for Edit -->                            

                            <div class="x_content" style="display: none;">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">                                
                                    <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 form-group">
                                        <label class="control-label" style="font-size: 20px;">إسم الشاشة</label>
                                        <input style="font-size: 15px;font-weight: bold;" type="text" placeholder="إسم الشاشة" onkeyup="LoadBasicDataFromApplicationNameForDropBox();clearApplicationTabsForDropBox()" maxlength="50" data-placement="bottom" id="subTabName" name="subTabName" class="form-control" required="">
                                    </div>   
                                    <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12 form-group">
                                        <label class="control-label" style="font-size: 20px;">إسم ال Servlet</label>
                                        <input style="font-size: 15px;font-weight: bold;direction: ltr;" type="text" placeholder="إسم الServlet" onkeyup="LoadBasicDataFromApplicationNameForDropBox();clearApplicationTabsForDropBox()" maxlength="100" data-placement="bottom" id="subTabAccessservlet" name="subTabAccessservlet" class="form-control" required="">
                                    </div>  
                                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
                                        <label class="control-label" style="font-size: 20px;">النظام</label>
                                        <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="النظام" id="applicationId2" onclick="LoadBasicDataFromApplicationTabsForDropBox();" maxlength="45" name="applicationId2" class="form-control" required="">                                            
                                        </select>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
                                        <label class="control-label" style="font-size: 20px;">القائمة</label>
                                        <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="القائمة" id="tabId" maxlength="45" name="tabId" class="form-control" required="">                                            
                                        </select>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">                                            
                                        <button type="button" data-placement="top" onclick="doAddApplicationSubTabs();" class="button_style btn btn-sm btn-primary button_position fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> حفظ</button>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">   
                                        <br>                             
                                        <table id="ApplicationSubTabsBasic_Data" class="table table-striped table-bordered table-hover" style="text-align: center;font-size: large;">


                                        </table>
                                    </div>
                                </div>


                            </div>
                            <!-- /for Edit -->
                            <div class="modal fade UpdateAppSubTabs" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">

                                        <div class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                            </button>
                                            <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">تعديل بيانات القوائم</h4>
                                        </div>
                                        <div class="modal-body" >
                                            <div class="row" id="EditFloorBody" style="direction: rtl;font-size: 30px;">
                                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                                    <label class="control-label" style="font-size: 20px;">إسم الشاشة</label>
                                                    <input style="font-size: 15px;font-weight: bold;" type="text" placeholder="إسم الشاشة"  maxlength="50" data-placement="bottom" id="subTabNameE" name="subTabNameE" class="form-control" required="">
                                                </div>   
                                                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 form-group">
                                                    <label class="control-label" style="font-size: 20px;">إسم ال Servlet</label>
                                                    <input style="font-size: 15px;font-weight: bold;direction: ltr;" type="text" placeholder="إسم الServlet"  maxlength="100" data-placement="bottom" id="subTabAccessservletE" name="subTabAccessservletE" class="form-control" required="">
                                                </div>
                                                <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
                                                    <label class="control-label" style="font-size: 20px;">تفعيل الشاشة</label>
                                                    <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="تفعيل الشاشة" id="availableToUserControl"  maxlength="45" name="applicationId2" class="form-control" required="">                                            
                                                        <option>اختر نوع التفعيل ..</option>
                                                        <option value="0">غير مفعلة</option>
                                                        <option value="1">مفعلة</option>
                                                    </select>
                                                </div>
                                                <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12">
                                                    <label class="control-label" style="font-size: 20px;">نوع الشاشة</label>
                                                    <select style="font-size: 15px;font-weight: bold;" type="text" placeholder="نوع الشاشة" id="authTypeId"  maxlength="45" name="authTypeId" class="form-control" required="">                                            
                                                        <option>اختر نوع الشاشة ..</option>
                                                        <%
                                                            List<AppSubTabAuthType> pList = new AppSubTabAuthType_DAO().getAllApplicationSubTabAuthType();
                                                            for (AppSubTabAuthType p : pList) {
                                                        %>
                                                        <option value="<%=p.getAuthTypeId()%>"><%=p.getAuthTypeName()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>


                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">                                            
                                                    <button type="button" data-placement="top" onclick="doUpdateApplicationSubTabs();" data-dismiss="modal" class="button_style btn btn-sm btn-primary button_position fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> تعديل</button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer" style="background-color: #131e33;">

                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="modal fade DeleteAppSubTabs" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-lg" >
                                    <div class="modal-content">

                                        <div class="modal-header" style="background: #d9534f;color: white;direction: rtl;">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                            </button>
                                            <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">تنبيه</h4>
                                        </div>
                                        <div class="modal-body" >

                                            <div class="row" id="DeleteFloorDone" style="direction: rtl;font-size: 30px;text-align: center;">
                                                <h1 style="color: #d9534f;">هل انت متأكد من عملية الحذف تلك ؟</h1>
                                            </div>
                                        </div>
                                        <div class="modal-footer" style="background-color: #d9534f;">

                                            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="doDeleteApplicationSubTabs();" style="font-weight: bold;border-color: black;width: 15%;float: right;" id="ModalButton1">نعم</button>
                                            <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;float: left;">لا</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>






                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <div class="x_title">
                                <h2 style="width: 50%;">تكوين كود الفلتر</h2>
                                <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <!-- for Edit -->                            

                            <div class="x_content" style="display: block;direction: ltr;float :left;">
                                <div class="row">
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group" style="float: left;">
                                        <label class="control-label" style="font-size: 20px;">Filter Name</label>
                                        <input value="SystemMainFilter" readonly="" disabled="" style="font-size: 15px;font-weight: bold;" type="text" placeholder="Filter Name" autocomplete="ON"  maxlength="100" data-placement="bottom" id="filterName" name="filterName" class="form-control" required="">
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group" style="float: left;">
                                        <label class="control-label" style="font-size: 20px;">Filter Path</label>
                                        <input  value="com.codeator.www._1_0_SystemFilter" readonly="" disabled="" style="font-size: 15px;font-weight: bold;" type="text" placeholder="Filter Path" autocomplete="ON" maxlength="100" data-placement="bottom" id="filterPath" name="filterPath" class="form-control" required="">
                                    </div>
                                </div>
                                <div class="row">
                                    <br>
                                    <button type="button" class="fa fa-gears btn btn-default " onclick="Generat_XML_Code();" style="font-size: large;font-weight: bold;border: 2px solid black;box-shadow: -1px 5px 8px black;">Generate Code</button>                                               
                                </div>
                                <div class="row">                              
                                    <br>
                                    <textarea type="text" class="form-control" readonly="" name="filter_xml_code" id="filter_xml_code"  value="" required="" style="resize: none;height: 500px;border: 2px solid black;"></textarea>

                                </div>
                            </div>
                            <!-- /for Edit -->                            

                        </div>

                    </div>
                    <!-- /page content -->

                </div>
            </div>






            <!-- footer content -->
            <footer>
                <div class="pull-right">
                    Copyrights © <%=new DateOp().getCustomSysDate("yyyy")%> <a href="">CODEATOR</a> All rights reserved.
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->
        </div>

        <!-- jQuery -->
        <script src="webDesign/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="webDesign/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="webDesign/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="webDesign/vendors/nprogress/nprogress.js"></script>
        <!-- jQuery custom content scroller -->
        <script src="webDesign/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>


        <!-- Datatables -->
        <script src="webDesign/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="webDesign/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script src="webDesign/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="webDesign/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
        <script src="webDesign/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
        <script src="webDesign/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="webDesign/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="webDesign/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
        <script src="webDesign/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <script src="webDesign/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="webDesign/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
        <script src="webDesign/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
        <script src="webDesign/vendors/jszip/dist/jszip.min.js"></script>
        <script src="webDesign/vendors/pdfmake/build/pdfmake.min.js"></script>
        <script src="webDesign/vendors/pdfmake/build/vfs_fonts.js"></script>
        <!-- bootstrap-wysiwyg -->
        <script src="webDesign/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
        <script src="webDesign/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
        <script src="webDesign/vendors/google-code-prettify/src/prettify.js"></script>

        <!-- bootstrap-daterangepicker -->
        <script src="webDesign/vendors/moment/min/moment.min.js"></script>
        <script src="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

        <!-- bootstrap-datetimepicker -->
        <script src="webDesign/vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>

        <!-- PNotify -->
        <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
        <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
        <!-- jQuery custom content scroller -->
        <script src="webDesign/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="webDesign/build/js/custom.js"></script>

        <script src="_9_9_9_9_9_9_Application_Super_Control.js"></script>


        <script type="text/javascript">
                                        function isIntegerNumber(elem) {
                                            if (new RegExp(/^\d*\$/).test(elem)) {
                                                return true;
                                            } else {
                                                return false;
                                            }
                                        }
                                        $('#myDatepicker4').datetimepicker({
                                            ignoreReadonly: true,
                                            allowInputToggle: true,
                                            format: 'YYYY-MM-DD'
                                        });
        </script>
    </body>
</html>
<%                        } else {
            response.sendRedirect("_0_0_0_0_LoginAccesServlet");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("_0_0_0_0_LoginAccesServlet");
    }
    new HibernateSessionCon().clearConn();
%>