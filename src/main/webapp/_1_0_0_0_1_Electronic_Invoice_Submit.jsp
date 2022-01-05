<%-- 
    Document   : _0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoAccUintDept"%>
<%@page import="com.codeator.www._1_3_DB_daos.PurContractServiceTypeDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.PurContractServiceType"%>
<%@page import="com.codeator.www._1_3_DB_daos.AppSubElemSpecAuth_DAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.AppSubElemSpecAuth"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoDeptUnitJoinDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoDeptUnitJoin"%>
<%@page import="com.codeator.www._1_3_DB_daos.PerCountryCodeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.PerCountryCode"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoUnitTypeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoUnitType"%>
<%@page import="com.codeator.www._1_3_DB_daos.PerDeptOldDao"%>
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
            List<AppSubElemSpecAuth> asesaList = new AppSubElemSpecAuth_DAO().getEmpSubTabElementsSpecAuthInSubTab("" + employee_session.getEmployeeId(), "_1_0_0_0_1_Electronic_Invoice_Submit_AccessServlet");

            boolean RecieveDevliverCodeStstus = false;
            for (AppSubElemSpecAuth a : asesaList) {
                if (a.getAppSubElem().getElementName().equals("RecieveDevliverCode")) {
                    RecieveDevliverCodeStstus = true;
                    break;
                }
            }
            boolean InvoCashSplitAuthStatus = false;
            for (AppSubElemSpecAuth a : asesaList) {
                if (a.getAppSubElem().getElementName().equals("InvoCashSplit")) {
                    InvoCashSplitAuthStatus = true;
                    break;
                }
            }
            boolean calcUnitAndMinimumStatus = false;
            for (AppSubElemSpecAuth a : asesaList) {
                if (a.getAppSubElem().getElementName().equals("calcUnitAndMinimum")) {
                    calcUnitAndMinimumStatus = true;
                    break;
                }
            }
            boolean newsTaxStatus = false;
            for (AppSubElemSpecAuth a : asesaList) {
                if (a.getAppSubElem().getElementName().equals("newsTax")) {
                    newsTaxStatus = true;
                    break;
                }
            }
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
                background: #337ab7;
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
                /*right: 30px;*/
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
                background-color: #337ab7;
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
    <body class="nav-md" onload="TodayName();" style="color: #000000;" id="bodyClass">
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
                    String accUnitCode = (employee_session.getAppAuthJavaUsers().getInvoAccUintDept() == null) ? "" : employee_session.getAppAuthJavaUsers().getInvoAccUintDept().getId().getAccUnitCode();
                    String sectionNoOld = (employee_session.getPerDeptOld() == null) ? "''" : "" + employee_session.getPerDeptOld().getId().getSectionNoOld() + "";
                    String depNoOld = (employee_session.getPerDeptOld() == null) ? "''" : "" + employee_session.getPerDeptOld().getId().getDepNoOld() + "";
                    List<InvoAccUintDept> invoAccUintDept = new InvoAccUintDeptDao().GetInvoAccUintInDept(sectionNoOld, depNoOld, accUnitCode);
                    String AccUintDept = (invoAccUintDept.get(0).getId().getAccUnitCode() == null) ? "''" : "" + invoAccUintDept.get(0).getId().getAccUnitCode() + "";
                    String AccUintDeptName = (invoAccUintDept.get(0).getInvoAccUnitsCode().getAccUnitName() == null) ? "''" : "" + invoAccUintDept.get(0).getInvoAccUnitsCode().getAccUnitName() + "";
                    String json1 = "'{"
                            + "\"deptId\":\"" + depNoOld + "\","
                            + "\"sectionId\":\"" + sectionNoOld + "\","
                            + "\"accUnitId\":\"" + AccUintDept + "\""
                            + "}'";

                    List<InvoAccUintDept> seqList = new InvoAccUintDeptDao().GetInvoAccUintInDeptAndUnit(AccUintDept, sectionNoOld, depNoOld);
                    boolean chkInvoInternalIdSeq = true;
                    String invoInternalIdStart = "0";

                    if (seqList.isEmpty()) {
                        chkInvoInternalIdSeq = false;
                    } else {
                        InvoAccUintDept seq = seqList.get(0);
                        System.out.println("----===" + seqList.size());
                        chkInvoInternalIdSeq = seq.getChkInvoInternalIdSeq().equals("1");
                        invoInternalIdStart = seq.getInvoInternalIdStart();
                    }
                %>
                <script>
                    var json = JSON.parse(<%=json1%>);
                    var deptId = json.deptId;
                    var sectionId = json.sectionId;
                    var accUnitId = json.accUnitId;

                    var chkInvoInternalIdSeq = <%=chkInvoInternalIdSeq%>;
                    var invoInternalIdStart = <%=invoInternalIdStart%>;
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
                                <h3 style="font-weight: bold;">ادخال فاتورة</h3>
                            </div>
                        </div>
                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" style="direction: rtl;">
                            <label class="control-label font-style" style="font-size: 15px;">نوع المستند</label>
                            <select data-placeholder="Choose a Country..." onchange="controlPageAccordingDocumentType();" name="documentType" id="documentType" class="form-control" tabindex="-1" required="">
                                <option class="font-style" value="I" selected>فاتورة</option><!--invoice -->
                                <option class="font-style" value="C">إشعار إضافة</option><!--creditor -->
                                <option class="font-style" value="D">إشعار خصم</option><!--depite -->
                            </select>
                            <br>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4" id="document_internalID_Div" style="direction: rtl; display: none;">
                            <label class="control-label font-style" style="font-size: 15px;">رقم المستند</label>                                                                   
                            <input type="text" class="form-control" onkeyup="resetScreen();" name="document_internalID_search" id="document_internalID_search" required="">
                            <br>
                        </div>

                        <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2" id="document_search_Div" style="direction: rtl;display: none;">
                            <button type="button" data-placement="top" onclick="documentSearch();" class="button_style btn btn-sm btn-primary button_position fa fa-search" style="font-weight: bold;font-size: 20px;padding-bottom: 7px;margin-top: 26px;width: 100%;" title="بحث" data-toggle="tooltip"></button><br>
                        </div>

                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="searchTotalAmount_Div" style="direction: rtl; display: none;float: left;">
                            <label class="control-label font-style" style="font-size: 15px;">إحمالي المستند الأخير</label>                                                                   
                            <input type="text" class="form-control" name="searchTotalAmount" id="searchTotalAmount" required="">
                            <br>
                        </div>
                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="searchDateTimeIssued_Div" style="direction: rtl; display: none;float: left;">
                            <label class="control-label font-style" style="font-size: 15px;">تاريخ المستند الأخير</label>                                                                   
                            <input type="date" class="form-control" name="searchDateTimeIssued" id="searchDateTimeIssued" required="">
                            <br>
                        </div>

                        <div class="clearfix"></div>




                        <!--card Start -->
                        <%//PerOrg == null
                            if (employee_session.getPerDeptOld() == null) {
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
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
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
                                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                    <label class="control-label" style="font-size: 15px;">نوع التعامل</label>
                                                    <select onchange="receiverTypeControlFields();Cash_Html_manipulation();HuntHacker();" name="receiverType" id="receiverType" class="form-control" tabindex="-1" required="">
                                                        <option class="font-style" value="B">شركة</option><!-- for Edit -->
                                                        <option class="font-style" value="P">فرد</option><!-- Person -->
                                                        <option class="font-style" value="F">أجنبي</option><!-- foreigner -->
                                                        <option class="font-style" value="small-P">نقدا</option><!-- Person -->
                                                        <%
                                                            if (InvoCashSplitAuthStatus) {
                                                        %>
                                                        <option class="font-style" value="small-P-split">نقدا مقسمة</option><!-- Person -->
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                                                    <label class="control-label" style="font-size: 15px;">التعامل مع المتعامل باسم</label>                                                                                                                   
                                                    <select name="suppSeqBr" id="suppSeqBr" onchange="" class="form-control container">                                            
                                                    </select>
                                                </div>
                                                <!--<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                                                    <label class="control-label" style="font-size: 15px;">المنتج</label>                                                                                                                   
                                                    <select name="advProducerCode" id="advProducerCode" onchange="" class="form-control container">                                            
                                                    </select>
                                                </div>
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                                                    <label class="control-label" style="font-size: 15px;">المحصل</label>                                                                                                                   
                                                    <select name="advCollectorCode" id="advCollectorCode" onchange="" class="form-control container">                                            
                                                    </select>
                                                </div> -->


                                            </div>
                                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                                <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2 form-group" id="swap_btn">                                            
                                                    <button type="button" data-placement="top" onclick="SwapDivsWithClick();" class="button_style btn btn-sm btn-primary" data-original-title="تبديل نظام البحث" data-toggle="tooltip" data-placement="bottom" style="font-weight: bold;font-size: 15px;padding-bottom: 6px;padding-top: 6px;margin-top: 26px;" data-toggle="modal" data-target="#x"><i class="fa fa-arrow-right"></i><i class="fa fa-arrow-left"></i></button>
                                                </div>                                                                        
                                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 swapIt" >
                                                    <label class="control-label" style="font-size: 15px;">المتعامل</label>                                                                   
                                                    <input type="text" onkeyup="QueryByReceiverNameOrId();" class="form-control container" name="receivername" id="receivername"  autocomplete="no">
                                                    <select name="receivername_select" id="receivername_select" onchange="getSelected_receivername_Tofileds();" class="form-control container" style="height: 180px;" multiple>                                            
                                                    </select>
                                                </div> 
                                                <div id="swapper-other" class="swapIt">
                                                    <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"  >
                                                        <label class="control-label container" style="font-size: 15px;" id="ComRegisterDiv" style="display: block;">رقم البطاقة الضريبية</label>                                                                   
                                                        <label class="control-label" style="font-size: 15px;" id="nationalIdDiv" style="display: none;">الرقم القومي</label>
                                                        <label class="control-label" style="font-size: 15px;" id="passportNumberDiv" style="display: none;">رقم جواز سفر</label>
                                                        <input type="text" class="form-control" name="id" id="id" onkeyup="QueryByReceiverNameOrId();" required="" autocomplete="disable">

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>                            
                        </div>
                        <div class="row">
                            <div id="Reciver_Other_info" class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
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
                                            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4">
                                                <label class="control-label" style="font-size: 15px;">الدولة<span class="required">*</span></label>                                                                   
                                                <input type="text" readonly="" class="form-control" name="country" id="country" required="">
                                            </div>
                                            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4">
                                                <label class="control-label" style="font-size: 15px;">المحافظة<span class="required">*</span></label>                                                                   
                                                <input type="text" readonly="" class="form-control" name="governate" id="governate" required="">
                                            </div>
                                            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4">
                                                <label class="control-label" style="font-size: 15px;">الشارع<span class="required">*</span></label>                                                                   
                                                <input type="text" readonly="" class="form-control" name="street" id="street" required="">
                                            </div>
                                            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-4">
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
                                    <!-- /for Edit -->
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" >
                                <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;" >
                                    <div class="x_title">
                                        <h2 style="width: 100%;font-weight: bold;float: right;color: #327ab7;">تحويل العملات "سعر البورصة"</h2>
                                        <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;">
                                            <li><a class="collapse-link"><i class="fa fa-chevron-down" onclick="loadCurrency();"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content" style="display: none;">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <!-- Please do not edit this code Mconvert currency-converter-widget starts here -->
                                            <script type="text/javascript">
                                                var fr = 'usd';
                                                var to = 'egp';
                                                var w = '100%';
                                                var h = '290';
                                                var l = 'ar';
                                                var t = 'darkblue';
                                                var f = '2';
                                                var ht = 'mconvert.net/';
                                            </script>
                                            <a href="https://mconvert.net/" title="تحويل العملات">
                                                <script src="//mconvert.net/currency_converter"></script>
                                            </a>
                                            <span style="font-size: 11px; text-align: right; display: block; font-family: Helvetica Neue;">
                                                <a href="https://mconvert.net/" style="color: #337ab7; text-decoration: none; font-family: Helvetica Neue;"></a>
                                            </span>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- /for Edit -->


                        <!--card Start -->
                        <!--card Start -->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <!-- for Edit -->

                            <div class="row">
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" >
                                    <label class="control-label font-style" style="font-size: 15px;">نوع الخدمة</label>
                                    <select data-placeholder="Choose a Country..."  name="ServiceSeq" id="ServiceSeq" class="form-control" tabindex="-1" required="">
                                        <%
                                            List<PurContractServiceType> PurContractServiceTypeList = new PurContractServiceTypeDao().GetAllContractServicePerDept(AccUintDept, sectionNoOld, depNoOld);
                                            for (PurContractServiceType purContractServiceType : PurContractServiceTypeList) {
                                                String ServiceName = purContractServiceType.getServiceName();
                                                String ServiceCode = (purContractServiceType.getServiceCode() == null) ? "" : " - " + purContractServiceType.getServiceCode();
                                                String ServiceSeq = "" + purContractServiceType.getServiceSeq();
                                                /*int currencyCode = Integer.parseInt(accCurrencyCode.getCurrencyCode());
                                                for (Map.Entry<String, Integer> en : new InvoiceDocumentConstants().currency.entrySet()) {
                                                    String Key = en.getKey();// EGP - USD - ...
                                                    Integer val = en.getValue();// 1 - 2 - 3 - 4
                                                    if (currencyCode == val) {
                                                        code = Key;
                                                        break;
                                                    }
                                                }*/
                                        %>
                                        <option class="font-style" value="<%=ServiceSeq%>"><%=ServiceName%><%=ServiceCode%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>

                                <%
                                    if (!chkInvoInternalIdSeq) {
                                %>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">رقم الفاتورة الداخلي</label>
                                    <input type="text" class="form-control" name="Invoice_number" id="Invoice_number" required="" value="55" autocomplete="no">
                                </div>

                                <%
                                    }
                                %>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ الفاتورة عند الضرائب</label>
                                    <div class='input-group date myDatepicker4' style="direction: ltr;">
                                        <input type='text' class="form-control" readonly="readonly" name="dateTimeIssued" id="dateTimeIssued" value="<%=new DateOp().getCustomSysDate("yyyy-MM-dd")%>" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ الفاتورة الفعلي</label>
                                    <div class='input-group date myDatepicker4' style="direction: ltr;">
                                        <input type='text' class="form-control" readonly="readonly" name="invoRealDate" id="invoRealDate" value="<%=new DateOp().getCustomSysDate("yyyy-MM-dd")%>" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" >
                                    <label class="control-label font-style" style="font-size: 15px;">نوع العملة</label>
                                    <select data-placeholder="Choose a Country..." onchange="currencyExchange();" name="currencySold" id="currencySold" class="form-control" tabindex="-1" required="">
                                        <%
                                            List<AccCurrencyCode> AccCurrencyCodeList = new AccCurrencyCodeDAO().GetAccCurrencyCode();
                                            for (AccCurrencyCode accCurrencyCode : AccCurrencyCodeList) {
                                                String currency_name = accCurrencyCode.getCurrencyName();
                                                String code = accCurrencyCode.getCurrencySymbol();
                                                /*int currencyCode = Integer.parseInt(accCurrencyCode.getCurrencyCode());
                                                for (Map.Entry<String, Integer> en : new InvoiceDocumentConstants().currency.entrySet()) {
                                                    String Key = en.getKey();// EGP - USD - ...
                                                    Integer val = en.getValue();// 1 - 2 - 3 - 4
                                                    if (currencyCode == val) {
                                                        code = Key;
                                                        break;
                                                    }
                                                }*/
                                        %>
                                        <option class="font-style" value="<%=code%>"><%=currency_name%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="currencyExchangeDiv">
                                    <label class="control-label font-style" style="font-size: 15px;">معدل تحويل العملة</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('currencyExchange');" name="currencyExchange" id="currencyExchange" required="">
                                </div>
                            </div>
                            <div class="row" >
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">نوع تطبيق الضريبة</label>
                                    <select data-placeholder="Choose a Country..." name="TaxApplyType" id="TaxApplyType" onchange="changeTaxApplyType();" class="form-control" tabindex="-1" required="">
                                        <option class="font-style" value="taxOnLine">ضريبة على مستوى السطر</option><!--invoice -->
                                        <option class="font-style" value="taxOnInvoice">ضريبة على مستوى المستند</option><!--creditor -->
                                    </select>
                                </div>
                                <div id="taxes_top" style="display: none;">
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                        <label class="control-label font-style" style="font-size: 15px;">الخضوع للضريبة</label>
                                        <select data-placeholder="Choose a Country..." name="taxable_top" id="taxable_top" onchange="getTaxes_top();" class="form-control" tabindex="-1" required="">
                                            <option class="font-style" value="1">تخضع</option><!--invoice -->
                                            <option class="font-style" value="2">لا تخضع</option><!--creditor -->
                                        </select>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                        <label class="control-label font-style" style="font-size: 15px;">نوع الضريبة</label>
                                        <select data-placeholder="Choose a Country..." name="subType_top" id="subType_top" onchange="getRate_top();" class="form-control" tabindex="-1" required="">
                                            <option class="font-style" value="T1">قيمة مضافة</option>
                                            <option class="font-style" value="T2">دمغة</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                        <label class="control-label" style="font-size: 15px;">نسبة الضريبة</label>
                                        <div class="input-prepend input-group">                                        
                                            <input type="number" class="form-control" onkeyup="allFloatNumeric('taxValue_top');" id="taxValue_top" value="">
                                            <span class="input-group-addon searchCustom" style="border: 1px solid #e5e6e7;border-radius: 0px;"><i>%</i></span>                                                       
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
                                if (RecieveDevliverCodeStstus) {
                            %>
                            <div class="row">
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">كود إذن التسليم</label>
                                    <input type="text" class="form-control" name="permToReceiveCode" id="permToReceiveCode" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">كود إذن الصرف</label>
                                    <input type="text" class="form-control" name="permToDeliverCode" id="permToDeliverCode" required="">
                                </div>                                
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ التسليم والصرف</label>
                                    <div class='input-group date myDatepicker4' style="direction: ltr;">
                                        <input type='text' class="form-control" readonly="readonly" name="permToReceiveDate" id="permToReceiveDate" value="<%=new DateOp().getCustomSysDate("yyyy-MM-dd")%>" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>         

                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label class="control-label font-style" style="font-size: 15px;">ملاحظات</label>
                                    <input type="text" class="form-control" name="notes" id="notes" required="">
                                </div>
                            </div>


                        </div>
                        <!--card Start -->
                        <!--card Start -->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <!-- for Edit -->
                            <div class="row" style="color: #327ab7;">تفاصيل الفاتورة</div>
                            <%
                                String display = "none";
                                if (newsTaxStatus) {
                                    display = "block";
                                }
                            %>
                            <div class="row" style="display: <%=display%>">
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">الدمغة الصحفية</label>
                                    <select data-placeholder="Choose a Country..." name="newsTax"  id="newsTax" class="form-control" tabindex="-1" required="">
                                        <option class="font-style" selected value="no">غير متضمنة الدمغة</option>
                                        <%
                                            if (newsTaxStatus) {
                                        %>
                                        <option class="font-style" value="yes">متضمنة الدمغة</option>      
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                            <%                                            //                                
                            %>
                            <div class="row">
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">نوع التكويد</label>
                                    <select data-placeholder="Choose a Country..." name="itemType" onchange="getItemCode();" id="itemType" class="form-control" tabindex="-1" required="">
                                        <option class="font-style" value="GS1">GS1</option>
                                        <option class="font-style" selected value="EGS">EGS</option>
                                    </select>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">الصنف</label>
                                    <select data-placeholder="Choose a Country..." onchange="getItemCodeDesc();" name="itemCode" id="itemCode" class="form-control" tabindex="-1" required="">

                                    </select>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">توصيف الصنف</label>
                                    <select data-placeholder="Choose a Country..." name="itemSeq" id="itemSeq" class="form-control" tabindex="-1" required="">
                                    </select>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4" id="" >
                                    <label class="control-label font-style" style="font-size: 15px;">توصيف اضافي</label>
                                    <input type="text" class="form-control" name="extra_description" id="extra_description" placeholder="(اختياري)" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">وحدة القياس</label>
                                    <select data-placeholder="Choose a Country..." name="unitType" id="unitType" onchange="unitTypeCalc();" class="form-control" tabindex="-1" required="">
                                        <%                                            List<InvoDeptUnitJoin> InvUnitTypeList = new InvoDeptUnitJoinDAO().GetInvoUnitTypeInDept(AccUintDept, sectionNoOld, depNoOld);
                                            for (InvoDeptUnitJoin invUnitType : InvUnitTypeList) {
                                        %>
                                        <option class="font-style" <%=(invUnitType.getInvoUnitType().getUnitType().equals("EA")) ? "selected" : ""%> value="<%=invUnitType.getInvoUnitType().getUnitType()%>-<%=invUnitType.getInvoUnitType().getCalcType()%>"><%=invUnitType.getUnitNickname()%></option><!--invoice -->
                                        <%                                            //
                                            }
                                        %>
                                    </select>
                                </div>  
                            </div>
                            <%
                                String readOnly = "";
                                if (calcUnitAndMinimumStatus) {
                                    readOnly = "readOnly";
                            %>
                            <div class="row" id="calcUnitDiv">
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="" >
                                    <label class="control-label font-style" style="font-size: 15px;">الحد الأدني</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('minimumLimit');amac_calculation();" name="minimumLimit" id="minimumLimit" value="0" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">وحدة الحساب</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('calcUnit');amac_calculation();" name="calcUnit" id="calcUnit" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">السعر قبل الحساب</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('priceBeforeCalcUnit');amac_calculation();" name="priceBeforeCalcUnit" id="priceBeforeCalcUnit" required="">
                                </div>                                    
                            </div>
                            <%
                                }
                            %>

                            <div class="row">
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">نوع القيمة</label>
                                    <select data-placeholder="Choose a Country..." onchange="writeQuantity();" name="quantityType" id="quantityType" class="form-control" tabindex="-1" required="">
                                        <option class="font-style" value="writeQuantity">قيمة</option>
                                        <option class="font-style" value="noQuantity">قيمة مقطوعة</option>
                                    </select>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="lengthDiv">
                                    <label class="control-label font-style" style="font-size: 15px;">الطول</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('length');changeDiscountAmount();onCalcQuantity();" name="length" id="length" required="">
                                </div> 
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="widthDiv">
                                    <label class="control-label font-style" style="font-size: 15px;">العرض</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('width');changeDiscountAmount();onCalcQuantity();" name="width" id="width" required="">
                                </div> 
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="hieghtDiv">
                                    <label class="control-label font-style" style="font-size: 15px;">الارتفاع</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('hieght');changeDiscountAmount();onCalcQuantity();" name="hieght" id="hieght" required="">
                                </div> 
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="quantityDiv">
                                    <label class="control-label font-style" style="font-size: 15px;">الكمية</label>
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('quantity');changeDiscountAmount();" name="quantity" id="quantity" required="">
                                </div>                                 
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">السعر</label>
                                    <input type="number" class="form-control <%=readOnly%>" onkeyup="allFloatNumeric('price');
                                            changeDiscountAmount();" name="price" id="price" required="">
                                </div>

                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">نوع الخصم</label>
                                    <select data-placeholder="Choose a Country..." onchange="discountRateType();" name="discountType" id="discountType" class="form-control" tabindex="-1" required="">
                                        <option class="font-style" value="rate">نسبة</option>
                                        <option class="font-style" selected value="noRate">خصم مقطوع</option>
                                    </select>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="discountRateDiv">
                                    <label class="control-label" style="font-size: 15px;">نسبة الخصم</label>   
                                    <div class="input-prepend input-group">
                                        <input type="number" class="form-control" onkeyup="allFloatNumeric('discount_rate');changeDiscountAmount();" name="discount_rate" id="discount_rate" value="0" required="">
                                        <span class="input-group-addon searchCustom" style="border: 1px solid #e5e6e7;border-radius: 0px;"><i>%</i></span>
                                    </div>
                                </div>  
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label" style="font-size: 15px;">خصم</label>                                                                   
                                    <input type="number" class="form-control" onkeyup="allFloatNumeric('discount_amount');" name="discount_amount" id="discount_amount" value="0" required="">
                                </div> 
                            </div>


                            <div class="row">
                                <div class="chosen-select-single mg-b-20 table-responsive" id='TaxAbleTable'>
                                    <label></label>
                                    <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2" id="document_search_Div2" style="float: right;direction: rtl;display: none;">
                                        <button type="button" data-placement="top" onclick="documentSearch();" class="btn btn-sm btn-dark fa fa-refresh" style="font-weight: bold;font-size: 20px;padding-bottom: 7px;margin-top: 26px;width: 100%;" title="اعادة تحميل الفاتورة" data-toggle="tooltip"></button>                            <br>
                                    </div>
                                    <div class="col-lg-9 col-md-9 col-sm-10 col-xs-10 form-group" style="text-align: center;">                                            
                                        <button type="button" data-placement="top" id="add_to_table_and_object" onclick="add_to_table_and_object();" class="button_style btn btn-sm btn-primary button_position fa fa-arrow-circle-down" style="font-weight: bold;font-size: 20px;padding-bottom: 7px;margin-top: 23px;width: 20%;" title="اضافة إلى المنتج للجدول" data-toggle="tooltip"></button>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" style="float: left;" id="extraDiscountAmountDiv">
                                        <label class="control-label" style="font-size: 15px;">خصم على مستوى الفاتورة</label>                                                                   
                                        <input type="number" class="form-control" onkeyup="allFloatNumeric('extraDiscountAmount');drawTable(true);" name="extraDiscountAmount" id="extraDiscountAmount" value="0" required="">
                                        <br>
                                    </div>


                                    <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                                        <thead>
                                            <tr style="background-color: #337ab7;color: white;">   
                                                <th style="text-align: center;">مسلسل</th>
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
                            <!-- /for Edit -->
                        </div>
                        <!--card Start -->
                        <%
                            }
                        %>








                    </div>


                    <!-- /page content -->
                    <button type="button" data-placement="top" onclick="submitDocument();" id="submitDocument" class=" button_styleSuccess btn btn-sm btn-success button_position fixedPosition fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 38px;width: auto;display: block;" title="حفظ الفاتورة" data-toggle="tooltip"></button>


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
                                    <select data-placeholder="Choose a Country..." name="subType" id="subType" onchange="getRate();" class="form-control" tabindex="-1" required="">
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

    <script>var RecieveDevliverCodeStstus = <%=RecieveDevliverCodeStstus%>;</script>
    <script>var calcUnitAndMinimumStatus = <%=calcUnitAndMinimumStatus%></script>
    <script>var newsTaxStatus = <%=newsTaxStatus%></script>
    <script src="_0_0_0_0_0_GeneralJavaScript.js"></script>
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_00_validator.js"></script>
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_01_General.js"></script>    
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_02_Client_Info.js"></script>
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_03_Tax_Info.js"></script>
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_04_Table_Info.js"></script>
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_05_barcode_device.js"></script> 
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_06_Item_Info.js"></script> 

    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_07_document_search.js"></script>
    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_08_document_for_amac.js"></script>

    <script src="_1_0_0_0_1_Electronic_Invoice_Submit_99_submit_document.js"></script>


    <!-- bar code - scanner library 
    <script src="webDesign/barcode_scanner/onscan.js"></script>
    <script src="webDesign/barcode_scanner/onscan_running.js"></script>  -->
    <script>setTimeout(getItemCode, 1000);</script>

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