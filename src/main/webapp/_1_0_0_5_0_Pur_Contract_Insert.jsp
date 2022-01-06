<%-- 
Document   : _0_0_0_0_2_WelcomePage
Created on : Dec 26, 2019, 8:15:55 PM
Author: Mohamed
--%>

<%@page import="com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoAccUintDept"%>
<%@page import="com.codeator.www._1_3_DB_daos.PurContractTitelDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.PurContractTitel"%>
<%@page import="com.codeator.www._1_2_DB_entities.PurContractPeriodType"%>
<%@page import="com.codeator.www._1_3_DB_daos.PurContractPeriodTypeDAO"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoSuppPaymentTypeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoSuppPaymentType"%>
<%@page import="com.codeator.www._1_3_DB_daos.PurContractServiceTypeDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.PurContractServiceType"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoItemCodeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvItemCode"%>
<%@page import="com.codeator.www._1_3_DB_daos.PerCountryCodeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.PerCountryCode"%>
<%@page import="com.codeator.www._1_2_DB_entities.PerGovernorateCode"%>
<%@page import="com.codeator.www._1_3_DB_daos.PerGovernorateCodeDAO"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvAccDeptEmpJoinDAO"%>
<%@page import="com.codeator.www._1_3_DB_daos.VcleVehicleRequireStatusDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.VcleVehicleRequireStatus"%>
<%@page import="com.codeator.www._1_4_GeneralsModules.EnumDataBaseValues"%>
<%@page import="com.codeator.www._1_3_DB_daos.VcleVehicleRequireDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.VcleVehicleRequire"%>
<%@page import="com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp"%>
<%@page import="com.codeator.www._0_2_CodeatorLib.Baisc_HTML_Generator.MainPageCode"%>
<%@page import="com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.PerEmploymentMaster"%>
<%@page import="com.codeator.www._1_1_DB_mainDao.HibernateSessionCon"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    new HibernateSessionCon().OpenCon();
    new HibernateSessionCon().clearConn();
    try {
        String key = (String) request.getSession().getAttribute("OpenHTMLFile");
        if (key.equals("Open")) {
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");

            List<PerEmploymentMaster> pList = new PerEmploymentMasterDao().GetEmployeesByEmployee_ID("" + employee_session.getEmployeeId());
            employee_session = pList.get(0);
            String employee_name = employee_session.getEmpAname();

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

        <title>استعلام عن حالة الفواتير لدى مصلحة الضرائب</title>
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

        <!-- iCheck -->
        <link href="webDesign/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- Switchery -->
        <link href="webDesign/vendors/switchery/dist/switchery.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="webDesign/build/css/custom.min.css" rel="stylesheet">

        <link href="_1_0_0_0_4_Electronic_Invoice_Invoice_Status_InTax.css" rel="stylesheet">
        <link href="webDesign/vendors/search_select/select2.css" rel="stylesheet">
        <style>
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
            /*   لعمل ليست ايتم بدون كومبو استايل */ 
            .selectList[multiple],
            .selectList[size] {
                height: 122px;
            }
            /*  لعمل فيلد بحث في الكومبو  */ 
            .SELECT_Combo {
                font-weight: bold;
                font-size: 15px; 
            }
            .select2-selection__rendered {
                text-align: right;
                color: black;
                font-size:15px;
                font-weight: bold;
                direction: rtl;
            }
            /* خاص بعمل اسبان بجانب الفيلد وعمل دوران للزوايا */
            .searchCustom{
                background-color: #131e33;
                /*border: black solid 2px;*/
                color: white;
                border-radius: 13px;
            }
            /* خاص بالكومبو السيرش بيقلب اليستة ناحية اليمين */
            .select2-dropdown--below{
                color:#73879C;
                font-size:15px;
                font-weight: bold;
                line-height:1.471;
                text-align: right;
                color: black;
            }
            .select2-selection__rendered {
                text-align: right;
                color: black;
                font-size:15px;
                font-weight: bold;
                direction: rtl;
            }
            /* خاص بتغير الفونت لاي فيلد بضاف اليه هذا الكلاس  */ 
            .font-style{
                font-weight: bold;
                font-size: 15px;
            }
            /* خاص بعمل اسبان بجانب الفيلد وعمل دوران للزوايا */
            .searchCustom{
                background-color: #131e33;
                /*border: black solid 2px;*/
                color: white;
                border-radius: 13px;
            }
            /* خاص بالكومبو السيرش بيقلب اليستة ناحية اليمين */
            .top_nav .nav>li>a:hover{
                background:#D9DEE4}
            body{color:#73879C;
                 background:#131e33;
                 font-family: 'Play', sans-serif;
                 font-size:15px;
                 font-weight: bold;
                 line-height:1.471;
                 /*text-align: right;*/
            }
            .required{
                color:red;
                font-size: 20px;
            }

            /* For Check*/
            .checkbox {
                display: inherit;
                cursor: pointer;
                position: relative;
            }

            .checkbox > span {
                color: #34495E;
                padding: 13px;
            }

            .checkbox > input {
                height: 25px;
                width: 25px;
                -webkit-appearance: none;
                -moz-appearance: none;
                -o-appearance: none;
                appearance: none;
                border: 1px solid #34495E;
                border-radius: 4px;
                outline: none;
                transition-duration: 0.3s;
                background-color: #d7dcde;
                cursor: pointer;
            }

            .checkbox > input:checked {
                border: 1px solid #41B883;
                background-color: #34495E;
            }

            .checkbox > input:checked + span::before {
                content: '\2713';
                display: block;
                text-align: center;
                color: #41B883;
                position: absolute;
                left: 0.7rem;
                top: 0.2rem;
            }

            .checkbox > input:active {
                border: 2px solid #34495E;
            }

            .centered {
                position: fixed;
                top: 50%;
                left: 50%;
                /* bring your own prefixes */
                transform: translate(-50%, -50%);
            }

            .animated {
                background-image: url(/css/images/logo.png);
                background-repeat: no-repeat;
                background-position: left top;
                padding-top:95px;
                margin-bottom:60px;
                -webkit-animation-duration: 10s;
                animation-duration: 3s;
                -webkit-animation-fill-mode: both;
                animation-fill-mode: both;
            }

            @keyframes flash {
                0%, 50%, 100% {
                    opacity: 1;
                }
                25%, 75% {
                    opacity: 0;
                }
            }

            .flash {
                animation-name: flash;
            }

            .customTable tr{
                border: 1px solid gray;
                padding: 8px;
                line-height: 1.42857143;
                vertical-align: top;
                border-top: 1px solid #ddd;
                border-bottom: solid black;
            }


            .myTextArea {
                resize: none;
                height: 100px;
            }

            .button_position{
                margin-top: 32px;
                width: 100%;

            }
            .button_styleSuccess{
                position: fixed;
                bottom: 20px;
                right: 30px;
                z-index: 99;
                font-size: 18px;
                border: none;
                outline: none;
                background-color: #26B99A;
                color: #ffffff !important;
                cursor: pointer;
                padding: 15px;
                border-radius: 4px;
            }

            .addTextColor{color: black;}
            .addTextColor:hover{color: white;}

        </style>

        <!-- select2 CSS
                ============================================ -->
        <link rel="stylesheet" href="jawlaryWebDesign/css/select2/select2.min.css">
        <!-- chosen CSS
                    ============================================ -->
        <link rel="stylesheet" href="jawlaryWebDesign/css/chosen/bootstrap-chosen.css">

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

    </script>
    <body class="nav-md" onload="TodayName();" style="color: #000000;" >
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col menu_fixed">
                    <div class="left_col scroll-view">
                        <div class="navbar nav_title" style="border: 0;padding-top: 10px;height: auto;">
                            <a href="_0_0_0_0_MainMenuAccessServlet" class="site_title" style="height: inherit;padding-left: 0px;">
                                <div style="text-align: center;">
                                    <img src="webDesign/Resources/images/Codeator_Logo.png" alt="..." style="border-radius: 15%;padding: 0px;width: 75%;">
                                </div>
                            </a>
                        </div>

                        <div class="clearfix"></div>

                        <!-- menu profile quick info -->
                        <div class="profile clearfix" style="padding-top: 10px;">
                            <div class="profile_pic" style="padding-top: 8px;">
                                <img src="webDesign/Resources/images/user.png" alt="..." class="img-circle profile_img">
                            </div>
                            <div class="profile_info">
                                <span style="font-size: 15px;padding-left: 15px;font-weight: bold;">اسم المستخدم</span>
                                <h2 style="font-size: 15px;font-weight: bold;"><%=employee_name%></h2>
                            </div>
                        </div>
                        <!-- /menu profile quick info -->

                        <br />

                        <!-- side bar menu -->
                        <%
                            String M = new MainPageCode().testMethod(request, employee_session);
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
                                        String M2 = new MainPageCode().getUserMenu();
                                    %>
                                    <%=M2%>
                                </li>
                                <li role="presentation" class="dropdown" >
                                    <a href="javascript:;" class=""  aria-expanded="false">

                                        <span class="badge bg-green fa fa-clock-o" id="clock" style="font-size: 20px;"></span>
                                        <span class="badge bg-green fa fa-calendar" id="dateD" style="font-size: 20px;"></span> 
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
                <%
                    //List<PerDeptOld> deptList = new PerDeptOldDao().GetDeptByemployeeId("" + employee_session.getEmployeeId());

                %>

                <%                    String deptName = (employee_session.getPerDeptOld() == null) ? "" : employee_session.getPerDeptOld().getDepName();//الوحدة
                    String SectionName = (employee_session.getPerDeptOld() == null) ? "" : employee_session.getPerDeptOld().getPerSectionOld().getSectionName();//القطاع

                    String accUnitCode = employee_session.getAppAuthJavaUsers().getInvoAccUintDept().getId().getAccUnitCode();
                    String sectionNoOld = (employee_session.getPerDeptOld() == null) ? "''" : "" + employee_session.getPerDeptOld().getId().getSectionNoOld() + "";
                    String depNoOld = (employee_session.getPerDeptOld() == null) ? "''" : "" + employee_session.getPerDeptOld().getId().getDepNoOld() + "";
                    List<InvoAccUintDept> invoAccUintDept = new InvoAccUintDeptDao().GetInvoAccUintInDept(sectionNoOld, depNoOld,accUnitCode);
                    String AccUintDept = (invoAccUintDept.get(0).getId().getAccUnitCode() == null) ? "''" : "" + invoAccUintDept.get(0).getId().getAccUnitCode() + "";
                    String AccUintDeptName = (invoAccUintDept.get(0).getInvoAccUnitsCode().getAccUnitName() == null) ? "''" : "" + invoAccUintDept.get(0).getInvoAccUnitsCode().getAccUnitName() + "";
                    String json1 = "'{"
                            + "\"deptId\":\"" + depNoOld + "\","
                            + "\"sectionId\":\"" + sectionNoOld + "\","
                            + "\"accUnitId\":\"" + AccUintDept + "\""
                            + "}'";
                %>
                <script>
                    var json = JSON.parse(<%=json1%>);
                    var deptId = json.deptId;
                    var sectionId = json.sectionId;
                    var accUnitId = json.accUnitId;
                </script>
                <div class="right_col" role="main"> 
                    <div class="row" style="direction: rtl">
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" style="display: block;">
                            <input type="text" class="form-control" placeholder="القطاع" data-original-title="القطاع" value="<%=SectionName%>" required="" readonly="" data-toggle="tooltip" data-placement="bottom">
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" style="display: block;">
                            <input type="text" class="form-control" placeholder="الوحدة" data-original-title="الوحدة" value="<%=deptName%>" required="" readonly=""  data-toggle="tooltip" data-placement="bottom">
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" style="display: block;">
                            <input type="text" class="form-control" placeholder="الوحدة الحسابية" data-original-title="الوحدة الحسابية" value="<%=AccUintDeptName%>" required="" readonly=""  data-toggle="tooltip" data-placement="bottom">
                        </div>
                    </div>
                    <div class="">
                        <div class="page-title">
                            <div class="title_right">
                                <h3 style="font-weight: bold;">إدخال عقد</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <!--card Start -->
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                                <div class="x_title">
                                    <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;">بيانات المتعامل</h2>
                                    <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;" >
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <!-- for Edit -->
                                <div class="x_content">

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <br>
                                        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-6">
                                            <label class="control-label" style="font-size: 15px;">نوع التعامل</label>
                                            <select onchange="receiverTypeControlFields();Cash_Html_manipulation();" name="receiverType" id="receiverType" class="form-control" tabindex="-1" required="">
                                                <option class="font-style" value="B">شركة</option><!-- for Edit -->
                                                <option class="font-style" value="P">فرد</option><!-- Person -->
                                                <option class="font-style" value="F">أجنبي</option><!-- foreigner -->
                                            </select>
                                        </div>

                                        <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2" id="swap_btn">
                                            <button type="button" data-placement="top" onclick="SwapDivsWithClick();" class="button_style btn btn-sm btn-primary" data-original-title="تبديل نظام البحث" data-toggle="tooltip" data-placement="bottom" style="font-weight: bold;font-size: 15px;padding-bottom: 6px;padding-top: 6px;margin-top: 26px;" data-toggle="modal" data-target="#x">
                                                <i class="fa fa-exchange"></i>
                                            </button>
                                        </div>  
                                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 swapIt" >
                                            <label class="control-label" style="font-size: 15px;">المتعامل</label>  
                                            <input type="text" onkeyup="QueryByReceiverNameOrId();" class="form-control container" name="receivername" id="receivername"  autocomplete="no">
                                            <select name="receivername_select" id="receivername_select" onchange="getSelected_receivername_Tofileds();" class="form-control container" multiple>
                                            </select>
                                        </div> 

                                        <div id="swapper-other" class="swapIt">
                                            <div class="col-lg-4 col-md-4 col-sm-5 col-xs-5"  >
                                                <label class="control-label container" style="font-size: 15px;" id="ComRegisterDiv" style="display: block;">البطاقة الضريبية</label>  
                                                <label class="control-label" style="font-size: 15px;" id="nationalIdDiv" style="display: none;">الرقم القومي</label>
                                                <label class="control-label" style="font-size: 15px;" id="passportNumberDiv" style="display: none;">رقم جواز سفر</label>
                                                <input type="text" class="form-control" name="id" id="id" onkeyup="QueryByReceiverNameOrId();" required="" autocomplete="disable">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                        <label class="control-label" style="font-size: 15px;">نوع الإدخال</label>
                                        <select style="width: 100%;" onchange="changeSequance();" data-placeholder="أختر خدمة..." name="transaction_type" id="transaction_type" class="form-control SELECT_Combo" tabindex="-1" required="">
                                            <option class="font-style" value="add">عقد جديد</option>
                                            <option class="font-style" value="edit">تعديل عقد</option>
                                        </select>
                                    </div>

                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6" id="title_idDiv" style="display: block;">
                                        <label class="control-label" style="font-size: 15px;">عنوان العقد</label>
                                        <div class="input-prepend input-group" >
                                            <select style="width: 100%;" data-placeholder="أختر العنوان..." name="title_id" id="title_id" class="form-control SELECT_Combo" tabindex="-1" required="">
                                                <option class="font-style" value="">أختر العنوان...</option>

                                            </select>                                            
                                            <span onclick="addNewTitle();" class="input-group-addon btn btn-warning addTextColor" style="border: 1px solid #e5e6e7;border-top-right-radius: 0;border-bottom-right-radius: 0;"><i class="fa fa-plus"></i></span>
                                        </div>
                                    </div>

                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6" id="title_textDiv" style="display: none;">
                                        <label class="control-label" style="font-size: 15px;">عنوان العقد</label>
                                        <div class="input-prepend input-group">
                                            <input type="text" class="form-control" placeholder="عنوان العقد" name="title_text" id="title_text" onkeyup="QueryByReceiverNameOrId();" required="" autocomplete="disable">
                                            <span onclick="chooseTitle();" class="input-group-addon btn btn-warning addTextColor" style="border: 1px solid #e5e6e7;border-top-right-radius: 0;border-bottom-right-radius: 0;" ><i class="fa fa-search-plus"></i></span>
                                        </div>
                                    </div>


                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="searchBtnDiv" style="display: none;">
                                        <button type="button" data-placement="top" onclick="searchContracts();" class="btn btn-sm btn-dark font-style fa fa-search" style="font-weight: bold;font-size: 15px;padding-bottom: 6px;padding-top: 6px;margin-top: 26px;width: 100%;"> بحث</button>
                                        <br>
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                                            <div class="chosen-select-single mg-b-20 table-responsive">
                                                <label>عقود المتعامل</label> 
                                                <table class="table table-striped jambo_table bulk_action table-bordered" style="text-align: center;">  
                                                    <thead>
                                                        <tr>
                                                            <td style="background-color: white;padding: 0px;" colspan="2"></td>
                                                            <td style="padding: 0px;" colspan="2">فترة التعاقد</td>
                                                        </tr>
                                                        <tr>
                                                            <td style="padding: 0px;">م</td>
                                                            <td style="padding: 0px;">تاريخ التعاقد</td>
                                                            <td style="padding: 0px;">من</td>
                                                            <td style="padding: 0px;">إلى</td>
                                                            <td style="padding: 0px;">قيمة العقد</td>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="contracts_search_result"> 

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row" style="display: none;" >
                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                            <label class="control-label" style="font-size: 15px;">الدولة<span class="required">*</span></label>  
                                            <input type="text" readonly="" class="form-control" name="country" id="country" required="">
                                        </div>
                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                            <label class="control-label" style="font-size: 15px;">المحافظة<span class="required">*</span></label>  
                                            <input type="text" readonly="" class="form-control" name="governate" id="governate" required="">
                                        </div>
                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                            <label class="control-label" style="font-size: 15px;">الشارع<span class="required">*</span></label>  
                                            <input type="text" readonly="" class="form-control" name="street" id="street" required="">
                                        </div>
                                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                            <label class="control-label" style="font-size: 15px;">رقم المبني<span class="required">*</span></label>  
                                            <input type="text" readonly="" class="form-control" name="buildingNumber" id="buildingNumber" required="">
                                        </div> 
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>
                                        <div style="display: none;">
                                            <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                                <label class="control-label" style="font-size: 15px;">الرقم البريدي</label>  
                                                <input type="text" readonly="" class="form-control" name="postalCode" id="postalCode" required="">
                                            </div>
                                            <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                                <label class="control-label" style="font-size: 15px;">رقم الطابق</label>  
                                                <input type="text" readonly="" class="form-control" name="floor" id="floor">
                                            </div>
                                            <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                                <label class="control-label" style="font-size: 15px;">رقم الغرفة</label>  
                                                <input type="text" readonly="" class="form-control" name="room" id="room">
                                            </div>
                                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                                <label class="control-label" style="font-size: 15px;">علامة مميزة</label>  
                                                <input type="text" readonly="" class="form-control" name="landmark" id="landmark">
                                            </div>
                                        </div>
                                        <!--<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 checkbox pull-right" style="direction: ltr;" id="addReceiverCheck">
                                        <label class="" style="font-size: 15px;font-weight: bold;color: red;margin-top: 26px;">هذا العميل غير مسجل هل تريد حفظ بياناته .......</label>
                                        <input type="checkbox" id="checkSearch" value="" onclick="" onchange="" style="transform: scale(2);margin-top: 27px;" class="font-style" name="a">
                                        </div>-->
                                    </div>
                                </div>
                            </div>
                            <div id="2qsatCard" style="display: none;">
                                <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;" >
                                    <div class="x_title">
                                        <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;">أقساط العقد</h2>
                                        <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;" >
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <!-- for Edit -->
                                    <div class="x_content">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                                            <div class="chosen-select-single mg-b-20 table-responsive">
                                                <label>عقود المتعامل</label> 
                                                <table class="table table-striped jambo_table bulk_action table-bordered" style="text-align: center;">  
                                                    <thead>
                                                        <tr>
                                                            <td style="background-color: white;padding: 8px;"></td>
                                                            <td style="padding: 0px;" colspan="2">تاريخ القسط</td>
                                                        </tr>
                                                        <tr>
                                                            <td style="padding: 0px;" >م</td>
                                                            <td style="padding: 0px;" >من</td>
                                                            <td style="padding: 0px;" >إلى</td>
                                                            <td style="padding: 0px;" >قيمة القسط</td>
                                                            <!--<td>ملاحظات</td>-->
                                                        </tr>
                                                    </thead>
                                                    <tbody id="contracts_dtl"> 

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                                <div class="x_title">
                                    <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;">بيانات العقد</h2>
                                    <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;" >
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <!-- for Edit -->
                                <div class="x_content">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >    
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="chosen-select-single">
                                                <label class="control-label" style="font-size: 15px;">أنواع الخدمات</label> 
                                                <style>
                                                    .chosen-container-multi .chosen-choices li{
                                                        float: right;
                                                        list-style: none;
                                                    }
                                                </style>
                                                <select data-placeholder="اختر خدمة..." style="direction: rtl;" class="chosen-select" name="service_seq" id="service_seq" multiple="" tabindex="-1">
                                                    <%
                                                        List<PurContractServiceType> PurContractServiceTypeList = new PurContractServiceTypeDao().GetAllContractServicePerDept(AccUintDept, sectionNoOld, depNoOld);
                                                        for (PurContractServiceType p : PurContractServiceTypeList) {
                                                    %>
                                                    <option value="<%=p.getServiceSeq()%>"><%=p.getServiceName()%></option>
                                                    <%//
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                            <label class="control-label font-style" style="font-size: 15px;">تاريخ التعاقد</label>
                                            <input type="date" class="form-control" name="contractDate" id="contractDate" value="<%=new DateOp().getCustomSysDate("yyyy-MM-dd")%>" max="<%=new DateOp().getCustomSysDate("yyyy-MM-dd")%>" value="" required="">
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>
                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                            <label class="control-label" style="font-size: 15px;">قيمة العقد</label>  
                                            <input type="number" class="form-control Integer" onchange="setThreeFloatingPoint('contractValue');" onkeyup="allFloatNumeric('contractValue');checkContractPeriod();" name="contractValue" id="contractValue" required="">
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                            <label class="control-label" style="font-size: 15px;">الموقف الضريبي</label>
                                            <select onchange="" name="contractTax" id="contractTax" class="form-control" tabindex="-1" required="">
                                                <option class="font-style" value="1">شامل الضريبية</option><!-- for Edit -->
                                                <option class="font-style" value="0">غير شامل للضريبية</option><!-- Person -->
                                            </select>
                                        </div>
                                        <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                                            <label class="control-label font-style" style="font-size: 15px;text-align: center;">عدد الشهور</label>
                                            <input type="number" onchange="checkContractPeriod();" class="form-control Integer" style="text-align: center;" name="no_of_month" id="no_of_month" value="1" required="">
                                        </div>
                                        <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12" style="text-align: center;margin-top: 3%;">  
                                            <label class="control-label font-style" style="font-size: 15px;text-align: center;color: blue;"><span class="fa fa-arrow-right"></span> المدة <span class="fa fa-arrow-left"></span></label>
                                            <h1 style="text-align: center;margin-top: -20px;">-</h1>
                                        </div>
                                        <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                                            <label class="control-label font-style" style="font-size: 15px;text-align: center;">عدد السنوات</label>
                                            <input type="number" onchange="checkContractPeriod();" class="form-control Integer" style="text-align: center;" name="no_of_years" id="no_of_years" value="0" required="">
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                            <label class="control-label font-style" style="font-size: 15px;">تاريخ بدأ العقد</label>
                                            <input type="date" class="form-control" onkeyup="checkContractPeriod();" onchange="checkContractPeriod();"  name="contractFromDate" id="contractFromDate" required="">
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                            <label class="control-label font-style" style="font-size: 15px;">تاريخ نهاية القعد</label>
                                            <input type="date" class="form-control" readonly="" name="contractToDate" id="contractToDate"  required="">
                                        </div> 

                                        <div class="row">
                                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">                                                  
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                    <label class="control-label" style="font-size: 15px;">طريقة السداد</label>
                                                    <select onchange="" name="paymentKind" id="paymentKind" class="form-control" tabindex="-1" required="">
                                                        <option value="">اختر طريقة السداد ...</option>
                                                        <%
                                                            List<InvoSuppPaymentType> PaymentTypeList = new InvoSuppPaymentTypeDAO().GetAllInvoSuppPaymentType();
                                                            for (InvoSuppPaymentType p : PaymentTypeList) {
                                                        %>
                                                        <option class="font-style" value="<%=p.getPaymentType()%>"><%=p.getPaymentName()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>

                                                <script>
                                                    var periodType_Arr = [];
                                                    var periodTypeData = new Object();

                                                    <%
                                                        List<PurContractPeriodType> PurContractPeriodTypeList = new PurContractPeriodTypeDAO().GetAllContractService();
                                                        for (PurContractPeriodType p : PurContractPeriodTypeList) {
                                                    %>
                                                    periodTypeData = new Object();
                                                    periodTypeData.periodType = "<%=p.getPeriodType()%>";
                                                    periodTypeData.periodName = "<%=p.getPeriodName()%>";
                                                    periodTypeData.periodVal = "<%=p.getPeriodVal()%>";
                                                    periodTypeData.periodValAlert = "<%=p.getPeriodValAlert()%>";
                                                    periodTypeData.periodValSplit = "<%=p.getPeriodValSplit()%>";
                                                    periodType_Arr.push(periodTypeData);
                                                    <%
                                                        }
                                                    %>

                                                </script>
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                    <label class="control-label" style="font-size: 15px;">الأقساط</label>
                                                    <select onchange="" name="periodType" id="periodType" class="form-control" tabindex="-1" required="">
                                                        <option>اختر طريقة الأقساط ...</option>  
                                                    </select>
                                                </div>
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                    <button type="button" data-placement="top" onclick="calcContract_dtl();" class="btn btn-sm btn-dark font-style fa fa-calculator" style="font-weight: bold;font-size: 15px;padding-bottom: 6px;padding-top: 6px;margin-top: 26px;width: 70%;"> <span class="fa-arrow-right"> حساب الأقساط</span></button>
                                                </div>
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ بدأ التنبيه بنهاية القعد</label>
                                                    <input type="date" class="form-control" name="alertDate" id="alertDate"  required="">
                                                </div>

                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                                <label class="control-label" style="font-size: 15px;">ملاحظات</label>  
                                                <textarea type="text" class="form-control myTextArea" name="rmrk" id="rmrk" required="" style="height: 200px;"></textarea>
                                            </div>
                                        </div>

                                        <button type="button" data-placement="top" id="addBtnDiv" onclick="addContract('add');" class=" button_styleSuccess btn btn-sm btn-success button_position fixedPosition fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 38px;width: auto;display: block;"> حفظ</button>
                                        <button type="button" data-placement="top" id="editBtnDiv" onclick="addContract('edit');" class=" button_styleSuccess btn btn-sm btn-success button_position fixedPosition fa fa-edit" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 38px;width: auto;display: none;"> تعديل</button>


                                    </div>
                                </div>
                            </div>
                        </div>


                        <!-- /pagecontent -->

                        <div class="clearfix"></div>







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

        <!-- Search_combo -->
        <script src="webDesign/vendors/search_select/select2.js"></script>

        <!-- iCheck -->
        <script src="webDesign/vendors/iCheck/icheck.min.js"></script>
        <!-- Switchery -->
        <script src="webDesign/vendors/switchery/dist/switchery.min.js"></script>

        <!-- PNotify -->
        <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
        <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>



        <script>
                                            /*
                                             * Alerts
                                             */
                                            function Success(Body) {
                                                new PNotify({
                                                    title: "تمت",
                                                    delay: 2000,
                                                    text: Body,
                                                    type: 'success',
                                                    position: 'top left',
                                                    styling: 'bootstrap3'
                                                });
                                            }
                                            function Error(Body) {
                                                new PNotify({
                                                    title: "خطأ",
                                                    delay: 5000,
                                                    text: Body,
                                                    type: 'error',
                                                    styling: 'bootstrap3'
                                                });
                                            }
                                            function Warning(Body) {
                                                new PNotify({
                                                    title: "تحذير",
                                                    delay: 2000,
                                                    text: Body,
                                                    styling: 'bootstrap3'
                                                });
                                            }

                                            var sysDate = "<%=new DateOp().getCustomSysDate("yyyy-MM-dd")%>";
        </script>


        <!-- chosen JS
                ============================================ -->
        <script src="jawlaryWebDesign/js/chosen/chosen.jquery.js"></script>
        <script src="jawlaryWebDesign/js/chosen/chosen-active.js"></script>
        <!-- select2 JS
                    ============================================ -->
        <script src="jawlaryWebDesign/js/select2/select2.full.min.js"></script>
        <script src="jawlaryWebDesign/js/select2/select2-active.js"></script>

        <script src="_1_0_0_5_0_Pur_Contract_Insert_00_validator.js"></script>
        <script src="_1_0_0_5_0_Pur_Contract_Insert_01_General.js"></script>
        <script src="_1_0_0_5_0_Pur_Contract_Insert_02_Client_Info.js"></script>

        <script src="_1_0_0_5_0_Pur_Contract_Insert.js"></script>

    </body>
</html>
<%} else {
            response.sendRedirect("_0_0_0_0_LoginAccesServlet");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("_0_0_0_0_LoginAccesServlet");
    }
    new HibernateSessionCon().clearConn();
%>