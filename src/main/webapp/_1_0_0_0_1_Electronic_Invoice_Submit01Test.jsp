<%-- 
    Document   : _0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.alahram.constants.InvoiceDocumentConstants"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoUnitTypeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoUnitType"%>
<%@page import="java.util.Map"%>
<%@page import="com.codeator.www._1_3_DB_daos.AccCurrencyCodeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.AccCurrencyCode"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvUnitTypeDAO"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoItemCodeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvItemCode"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvItemCode"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvAccDeptEmpJoinDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.PerDeptOld"%>
<%@page import="com.codeator.www._1_3_DB_daos.PerOrganizationStructureDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.PerOrganizationStructure"%>
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

        <title>ادخال فاتورة</title>
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

        <!-- Custom Theme Style -->
        <link href="webDesign/build/css/custom.min.css" rel="stylesheet">
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
            .combo_position{
                margin-top: 32px;
                width: 100%;
            }
            .combo_position:focus{
                background-color: #da7721
            }
            .combo_styleSuccess{
                position: fixed;
                bottom: 105px;
                right: 30px;
                z-index: 99;
                font-size: 18px;
                border: none;
                outline: none;
                background-color: #b75805;
                color: #ffffff !important;
                cursor: pointer;
                padding: 15px;
                border-radius: 4px;
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

                    String sectionNoOld = (employee_session.getPerDeptOld() == null) ? "''" : "" + employee_session.getPerDeptOld().getId().getSectionNoOld() + "";
                    String depNoOld = (employee_session.getPerDeptOld() == null) ? "''" : "" + employee_session.getPerDeptOld().getId().getDepNoOld() + "";
                %>
                <script>

                    var deptId = <%=depNoOld%>;
                    var sectionId = <%=sectionNoOld%>;


                </script>
                <div class="right_col" role="main"> 
                    <div class="row" style="direction: rtl">
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" style="display: block;">
                            <input type="text" class="form-control" placeholder="القطاع" data-original-title="القطاع" value="<%=SectionName%>" required="" readonly="" data-toggle="tooltip" data-placement="bottom">
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" style="display: block;">
                            <input type="text" class="form-control" placeholder="الوحدة" data-original-title="الوحدة" value="<%=deptName%>" required="" readonly=""  data-toggle="tooltip" data-placement="bottom">
                        </div>
                    </div>                    
                    <div class="">
                        <div class="page-title">
                            <div class="title_right">
                                <h3 style="font-weight: bold;">ادخال فاتورة</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>




                        <!--card Start -->
                        <%//PerOrg == null
                            if (false) {
                        %>
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">                            
                            <!-- for Edit -->
                            <div class="x_content">
                                <div class="row">
                                    <h1 class="required">أنت لست مسجل بقطاع</h1>
                                </div>                                
                            </div>
                        </div>
                        <%
                        } else {
                        %>
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <div class="x_title">
                                <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;" onclick="copyClientNameToTitle();">بيانات المتعامل <span style="color: black;" id="copyClientNameToTitle"></span></h2>
                                <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;" onclick="copyClientNameToTitle();">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <!-- for Edit -->
                            <div class="x_content">
                                <div class="row">

                                </div>
                                <div class="row">
                                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                        <label class="control-label" style="font-size: 15px;">نوع التعامل</label>
                                        <select onchange="receiverTypeControlFields();" name="receiverType" id="receiverType" class="form-control" tabindex="-1" required="">
                                            <option class="font-style" value="B">شركة</option><!-- for Edit -->
                                            <option class="font-style" value="P">فرد</option><!-- Person -->
                                            <option class="font-style" value="F">أجنبي</option><!-- foreigner -->
                                        </select>
                                    </div>

                                    <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2 form-group" id="">                                            
                                        <button type="button" data-placement="top" onclick="SwapDivsWithClick();" class="button_style btn btn-sm btn-primary" data-original-title="تبديل نظام البحث" data-toggle="tooltip" data-placement="bottom" style="font-weight: bold;font-size: 15px;padding-bottom: 6px;padding-top: 6px;margin-top: 26px;" data-toggle="modal" data-target="#x"><i class="fa fa-arrow-right"></i><i class="fa fa-arrow-left"></i></button>
                                    </div>                                                                        
                                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6 swapIt" >
                                        <label class="control-label" style="font-size: 15px;">المتعامل</label>                                                                   
                                        <input type="text" onkeyup="QueryByReceiverNameOrId();" class="form-control container" name="receivername" id="receivername">
                                        <select name="receivername_select" id="receivername_select" onchange="getSelected_receivername_Tofileds();" class="form-control container" multiple>                                            
                                        </select>
                                    </div> 

                                    <div id="swapper-other" class="swapIt">
                                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6"  >
                                            <label class="control-label container" style="font-size: 15px;" id="ComRegisterDiv" style="display: block;">البطاقة الضريبية</label>                                                                   
                                            <label class="control-label" style="font-size: 15px;" id="nationalIdDiv" style="display: none;">الرقم القومي</label>
                                            <label class="control-label" style="font-size: 15px;" id="passportNumberDiv" style="display: none;">رقم جواز سفر</label>
                                            <input type="text" class="form-control" name="id" id="id" onkeyup="QueryByReceiverNameOrId();" required="" autocomplete="disable">

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /for Edit -->

                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <div class="x_title">
                                <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;">بيانات اخرى للمتعامل</h2>
                                <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <!-- for Edit -->
                            <div class="x_content">
                                <div class="row">                            
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                        <label class="control-label" style="font-size: 15px;">المحافظة<span class="required">*</span></label>                                                                   
                                        <input type="text" class="form-control" name="governate" id="governate" required="">
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                        <label class="control-label" style="font-size: 15px;">الشارع<span class="required">*</span></label>                                                                   
                                        <input type="text" class="form-control" name="street" id="street" required="">
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                        <label class="control-label" style="font-size: 15px;">رقم المبني<span class="required">*</span></label>                                                                   
                                        <input type="text" class="form-control" name="buildingNumber" id="buildingNumber" required="">
                                    </div>                                    
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                        <label class="control-label" style="font-size: 15px;">الرقم البريدي</label>                                                                   
                                        <input type="text" class="form-control" name="postalCode" id="postalCode" required="">
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                        <label class="control-label" style="font-size: 15px;">رقم الطابق</label>                                                                   
                                        <input type="text" class="form-control" name="floor" id="floor">
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                        <label class="control-label" style="font-size: 15px;">رقم الغرفة</label>                                                                   
                                        <input type="text" class="form-control" name="room" id="room">
                                    </div>
                                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                        <label class="control-label" style="font-size: 15px;">علامة مميزة</label>                                                                   
                                        <input type="text" class="form-control" name="landmark" id="landmark">
                                    </div>
                                    <!--<div class="col-lg-3 col-md-3 col-sm-4 col-xs-4 checkbox pull-right" style="direction: ltr;" id="addReceiverCheck">
                                        <label class="" style="font-size: 15px;font-weight: bold;color: red;margin-top: 26px;">هذا العميل غير مسجل هل تريد حفظ بياناته .......</label>
                                        <input type="checkbox" id="checkSearch" value="" onclick="" onchange="" style="transform: scale(2);margin-top: 27px;" class="font-style" name="a">
                                    </div>-->
                                </div>
                            </div>
                            <!-- /for Edit -->
                        </div>
                        <!--card Start -->
                        <!--card Start -->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <!-- for Edit -->

                            <div class="row">
                                <div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">نوع المستند</label>
                                    <select data-placeholder="Choose a Country..." name="documentType" id="documentType" class="form-control" tabindex="-1" required="">
                                        <option class="font-style" value="I">فاتورة</option><!--invoice -->
                                        <option class="font-style" value="C">إشعار إضافة</option><!--creditor -->
                                        <option class="font-style" value="D">إشعار خصم</option><!--depite -->
                                    </select>
                                </div>                                                                                               
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">رقم الفاتورة الداخلي</label>
                                    <input type="text" class="form-control" name="Invoice_number" id="Invoice_number" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ الفاتورة</label>
                                    <input type="date" class="form-control" name="dateTimeIssued" id="dateTimeIssued" value="<%=new DateOp().getCustomSysDate("yyyy-MM-dd")%>"  value="" required="">
                                </div>


                            </div>
                        </div>
                        <!--card Start -->
                        <!--card Start -->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <!-- for Edit -->
                            <div class="row" style="color: #327ab7;">تفاصيل الفاتورة</div>
                            <div class="row">
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="">
                                    <label class="control-label font-style" style="font-size: 15px;">كود الصنف</label>
                                    <input type="text" class="form-control" name="itemCode" id="itemCode" required="">
                                </div>
                                <div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">نوع التكويد</label>
                                    <select data-placeholder="Choose a Country..." name="itemType" id="itemType" class="form-control" tabindex="-1" required="">
                                        <option class="font-style" value="GS1">GS1</option>
                                        <option class="font-style" value="EGS">EGS</option>
                                    </select>
                                </div> 
                                <div class="col-lg-5 col-md-5 col-sm-4 col-xs-4" id="">
                                    <label class="control-label font-style" style="font-size: 15px;">مسمى الصنف</label>
                                    <input type="text" class="form-control" name="description" id="description" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">وحدة القياس</label>
                                    <select data-placeholder="Choose a Country..." name="unitType" id="unitType" class="form-control" tabindex="-1" required="">
                                        <%
                                            List<InvoUnitType> InvoUnitTypeList = new InvoUnitTypeDAO().GetInvoUnitType();
                                            for (InvoUnitType invoUnitType : InvoUnitTypeList) {
                                        %>
                                        <option class="font-style" <%=(invoUnitType.getUnitType().equals("EA")) ? "selected" : ""%> value="<%=invoUnitType.getUnitType()%>"><%=invoUnitType.getAUnitName()%></option><!--invoice -->
                                        <%                                            //
                                            }
                                        %>
                                    </select>
                                </div> 
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">نوع الكمية</label>
                                    <select data-placeholder="Choose a Country..." onchange="writeQuantity();" name="quantityType" id="quantityType" class="form-control" tabindex="-1" required="">
                                        <option class="font-style" value="writeQuantity">كمية</option>
                                        <option class="font-style" value="noQuantity">قيمة مقطوعة</option>
                                    </select>
                                </div>
                                <div class="col-lg-1 col-md-1 col-sm-4 col-xs-4" id="quantityDiv">
                                    <label class="control-label font-style" style="font-size: 15px;">الكمية</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('quantity');" name="quantity" id="quantity" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" >
                                    <label class="control-label font-style" style="font-size: 15px;">نوع العملة</label>
                                    <select data-placeholder="Choose a Country..." onchange="currencyExchange();" name="currencySold" id="currencySold" class="form-control" tabindex="-1" required="">
                                        <%
                                            List<AccCurrencyCode> AccCurrencyCodeList = new AccCurrencyCodeDAO().GetAccCurrencyCode();
                                            for (AccCurrencyCode accCurrencyCode : AccCurrencyCodeList) {
                                                String currency_name = accCurrencyCode.getCurrencyName();
                                                String code = "";
                                                int currencyCode = Integer.parseInt(accCurrencyCode.getCurrencyCode());
                                                for (Map.Entry<String, Integer> en : new InvoiceDocumentConstants().currency.entrySet()) {
                                                    String Key = en.getKey();// EGP - USD - ...
                                                    Integer val = en.getValue();// 1 - 2 - 3 - 4
                                                    if (currencyCode == val) {
                                                        code = Key;
                                                        break;
                                                    }
                                                }
                                        %>
                                        <option class="font-style" value="<%=code%>"><%=currency_name%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>                                
                                <div class="col-lg-1 col-md-1 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">السعر</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('price');" name="price" id="price" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="currencyExchangeDiv">
                                    <label class="control-label font-style" style="font-size: 15px;">معدل تحويل العملة</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('currencyExchange');" name="currencyExchange" id="currencyExchange" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label" style="font-size: 15px;">خصم</label>                                                                   
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('discount_amount');" name="discount_amount" id="discount_amount" value="0" required="">
                                </div>   
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label" style="font-size: 15px;">خصم على مستوى الفاتورة</label>                                                                   
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('extraDiscountAmount');drawTable();" name="extraDiscountAmount" id="extraDiscountAmount" value="0" required="">
                                </div> 
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                    <div class="col-lg-5 col-md-5 col-sm-2 col-xs-2 form-group"></div>
                                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12 form-group">                                            
                                        <button type="button" data-placement="top" onclick="add_to_table_and_object();" class="button_style btn btn-sm btn-primary button_position fa fa-arrow-circle-down" style="font-weight: bold;font-size: 20px;padding-bottom: 7px;margin-top: 23px;"></button>
                                    </div>
                                    <div class="col-lg-5 col-md-5 col-sm-2 col-xs-2 form-group"></div>
                                </div>

                            </div>
                            <div class="row" >
                                <div class="chosen-select-single mg-b-20 table-responsive" id='TaxAbleTable'>
                                    <label></label>
                                    <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                                        <thead>
                                            <tr style="background-color: #131e33;color: white;">   
                                                <th style="text-align: center;">كود الصنف</th>
                                                <th style="text-align: center;">مسمى الصنف</th>
                                                <th style="text-align: center;">سعر الوحدة بالمصري</th>
                                                <th style="text-align: center;">الكمية</th>
                                                <th style="text-align: center;">الاجمالي</th>
                                                <th style="text-align: center;">الخصم</th>
                                                <th style="text-align: center;">الاجمالي قبل الضريبة</th>
                                                <th style="text-align: center;">الضريبة</th>   
                                                <th style="text-align: center;">الاجمالي بعد الضريبة</th>
                                                <th style="text-align: center;"></th> 
                                            </tr>
                                        </thead>
                                        <tbody id="invoiceLines"> 
                                            <!--<tr id="line_1">                                       
                                                <td style="text-align: center;"></td>
                                                <td style="text-align: center;"></td>
                                                <td style="text-align: center;"></td>
                                                <td style="text-align: center;"></td>
                                                <td style="text-align: center;"></td>
                                                <td style="text-align: center;"></td>
                                                <td style="text-align: center;"></td>
                                                <td style="text-align: center;">

                                                    <table class="table table-striped table-bordered table-hover">                                                        
                                                        <button type="button" onclick="openTaxForm(1);" class="btn btn-success fa fa-plus" data-toggle="modal" data-target="#taxModal" style="font-weight: bold;font-size: 10px;text-align: center;"></button>
                                                        <tbody id="line_1_Tax">
                                                            <tr id="line_1_Tax_1">
                                                                <td style="text-align: center;"></td>
                                                                <td style="text-align: center;"></td>
                                                                <td style="text-align: center;"></td>
                                                                <td style="text-align: center;"></td>
                                                                <td style="text-align: center;">
                                                                    <button type="button" onclick="delete_line_tax_Record('line_1_Tax_1', 1, 1);" class="btn btn-danger fa fa-close" style="font-weight: bold;font-size: 10px;text-align: center;"></button>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </td>
                                                <td style="text-align: center;"></td>
                                                <td style="text-align: center;"><button type="button" onclick="" class="btn btn-danger fa fa-close" style="font-weight: bold;font-size: 10px;text-align: center;" data-toggle="modal" data-target="#x"></button></td>
                                            </tr>  -->                                          
                                        </tbody>
                                    </table>
                                </div>                                
                            </div> 
                            <div class="row">
                                <div class="col-lg-1 col-md-1 col-sm-12 col-xs-12 form-group"></div>
                                <div class="col-lg-11 col-md-11 col-sm-12 col-xs-12 form-group">
                                    <label class="control-label" style="font-size: 15px;">ملف ال json</label>                                                                   
                                    <textarea class="form-control" id="json_field" style="height: 500px;direction: ltr;" readonly=""></textarea>
                                </div>
                            </div>
                            <!-- /for Edit -->
                        </div>
                        <!--card Start -->
                        <%
                            }
                        %>








                    </div>


                    <!-- /page content -->
                    <select data-placeholder="" name="sendType" id="sendType" class="form-control combo_styleSuccess combo_position fixedPosition" tabindex="-1" required="" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 13px;width: 7%;display: block;padding: 0px;">
                        <option class="font-style" selected="" value="pre-production">إرسال تجربة</option>
                        <option class="font-style" value="production">إرسال فعلي</option>
                        <option class="font-style" value="postman">postman</option>
                    </select>                    

                    <button type="button" data-placement="top" onclick="submitDocument();" id="PrintBtn" class=" button_styleSuccess btn btn-sm btn-success button_position fixedPosition fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 38px;width: auto;display: block;"></button>

                </div>
            </div>



            <div class="modal fade" id="taxModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;">
                                <span aria-hidden="true">×</span>
                            </button>
                            <h5 class="modal-title" id="exampleModalCenterTitle" style="font-size: 30px;">إضافة ضريبة</h5>

                        </div>
                        <div class="modal-body" style="direction: rtl;">
                            <div class="row" >
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">الخضوع للضريبة</label>
                                    <select data-placeholder="Choose a Country..." name="taxable" id="taxable" onchange="getTaxes();" class="form-control" tabindex="-1" required="">
                                        <option class="font-style" value="1">تخضع</option><!--invoice -->
                                        <option class="font-style" value="2">لا تخضع</option><!--creditor -->
                                    </select>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">نوع الضريبة</label>
                                    <select data-placeholder="Choose a Country..." name="subType" id="subType" class="form-control" tabindex="-1" required="">
                                        <option class="font-style" value="T1">قيمة مضافة</option>
                                        <option class="font-style" value="T2">دمغة</option>
                                    </select>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                    <label class="control-label" style="font-size: 15px;">نسبة الضريبة</label>
                                    <div class="input-prepend input-group">                                        
                                        <input type="number" class="form-control" onkeyup="allFloatNumeric('taxValue');" id="taxValue" value="">
                                        <span class="input-group-addon searchCustom" style="border: 1px solid #e5e6e7;border-radius: 0px;"><i>%</i></span>                                                       
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" onclick="add_tax_to_line();">Save changes</button>
                        </div>
                    </div>
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

    <!-- PNotify -->
    <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
    <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>
    <!--<script src="webDesign/swapper.js"></script>-->



    <script src="_0_0_0_0_0_GeneralJavaScript.js"></script>    
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_00_validator.js"></script>
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_01_General.js"></script>    
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_02_Client_Info.js"></script>
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_03_Tax_Info.js"></script>
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_04_Table_Info_01Test.js"></script>
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_05_barcode_device.js"></script>    
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_99_submit_document_01Test.js"></script>

    <!-- bar code - scanner library -->
    <script src="webDesign/barcode_scanner/onscan.js"></script>
    <script src="webDesign/barcode_scanner/onscan_running.js"></script>  


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