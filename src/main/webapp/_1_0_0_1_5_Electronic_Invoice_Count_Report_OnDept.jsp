<%-- 
    Document   : _0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.codeator.www._1_3_DB_daos.InvoAccUnitsCodeDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoAccUnitsCode"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoAccUintDept"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoDocumentStatusDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoDocumentStatus"%>
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

        <title>تقرير إجمالي عام الفواتير</title>
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

        <link href="_1_0_0_0_4_Electronic_Invoice_Invoice_Status_InTax.css" rel="stylesheet">
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
                                <h3 style="font-weight: bold;">تقرير إجمالي عام الفواتير</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <!--card Start -->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <!-- for Edit -->
                            <!-- <div class="row" style="color: #327ab7;">إضافة خدمة</div>-->                              
                            <div class="row">

                            </div>
                            <div class="row" >
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="chosen-select-single">
                                            <label class="control-label" style="font-size: 15px;">اختر حالة المستند</label> 
                                            <style>
                                                .chosen-container-multi .chosen-choices li{
                                                    float: right;
                                                    list-style: none;
                                                }
                                            </style>
                                            <select data-placeholder="اختر حالة المستند..." style="direction: rtl;" class="chosen-select" name="DocStatus" id="DocStatus" multiple="" tabindex="-1">
                                                <%
                                                    List<InvoDocumentStatus> InvoDocumentStatusList = new InvoDocumentStatusDAO().GetInvoDocumentStatus();
                                                    for (InvoDocumentStatus p : InvoDocumentStatusList) {
                                                %>
                                                <option value="<%=p.getDocStatus()%>"><%=p.getDocStatusName()%></option>
                                                <%//
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  >
                                        <label class="control-label" style="font-size: 15px;">من تاريخ<span class="required">*</span></label>                                                                   
                                        <input type="date" class="form-control" onkeyup="" name="fromDate" id="fromDate" required="">
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  >
                                        <label class="control-label" style="font-size: 15px;">إلى تاريخ<span class="required">*</span></label>                                                                   
                                        <input type="date" class="form-control" onkeyup="" name="toDate" id="toDate" required="">
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  >
                                        <label class="control-label" style="font-size: 15px;">نوع التاريخ المستخدم<span class="required">*</span></label>                                                                   
                                        <select class="form-control" onkeyup="" name="createdDate_OR_issueDate" id="createdDate_OR_issueDate" required="">
                                            <option value="issueDate">تاريخ المستند المرسل للضرائب</option>
                                            <!--<option value="">تاريخ المستند الفعلي</option>-->
                                            <option value="createdDate">تاريخ إدخال المستند على النظام</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  >
                                        <label class="control-label" style="font-size: 15px;">نوع البحث<span class="required">*</span></label>                                                                   
                                        <select class="form-control" onkeyup="" name="searchType" id="searchType" required="">
                                            <option value="1">أعداد ومبالغ المستندات</option>
                                            <option value="2">تفاصيل المستندات</option>
                                            <option value="3">الكل</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"  >
                                        <label class="control-label" style="font-size: 15px;">نوع الجدول<span class="required">*</span></label>                                                                   
                                        <select class="form-control" onkeyup="" name="table_type" id="table_type" required="">
                                            <option value="show">جدول عرض فقط</option>
                                            <option value="export">جدول سحب بيانات</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                    <div class="chosen-select-single">
                                        <label class="control-label" style="font-size: 15px;">اختر الوحدات الحسابية</label> 
                                        <style>
                                            .chosen-container-multi .chosen-choices li{
                                                float: right;
                                                list-style: none;
                                            }
                                        </style>
                                        <select data-placeholder="اختر أعمدة التقرير..." style="direction: rtl;" class="chosen-select" onchange="getDeptsFromAcc();" name="accUnitCode" id="accUnitCode" multiple="" tabindex="-1">
                                            <%
                                                List<InvoAccUnitsCode> InvoAccUnitsCodeList = new InvoAccUnitsCodeDao().GetInvoAccUnitsCodeDistinctFromInvoiceMaster();
                                                for (InvoAccUnitsCode p : InvoAccUnitsCodeList) {
                                            %>
                                            <option value="<%=p.getAccUnitCode()%>"><%=p.getAccUnitName()%></option>
                                            <%//
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                    <div class="chosen-select-single">
                                        <label class="control-label" style="font-size: 15px;">اختر الإدارات</label> 
                                        <style>
                                            .chosen-container-multi .chosen-choices li{
                                                float: right;
                                                list-style: none;
                                            }
                                        </style>
                                        <select data-placeholder="اختر أعمدة التقرير..." style="direction: rtl;" class="chosen-select" name="depNoOld" id="depNoOld" multiple="" tabindex="-1">

                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row" >                                
                                <div class="col-lg-12 col-md-12 col-sm-6 col-xs-6">
                                    <br>
                                    <button type="button" onclick="search();" class="form-control fa fa-search-plus btn btn-primary" style="font-size: large;border: 2px solid white;width: 100%"> بحث</button>
                                </div>
                            </div>
                            <!-- /for Edit -->
                        </div>

                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;" id="countsDiv">
                            <!-- for Edit -->
                            <div class="row" style="color: #327ab7;">أعداد ومبالغ المستندات</div>                            
                            <div class="row" >
                                <div class="chosen-select-single mg-b-20 table-responsive" id='TaxAbleTable'>
                                    <label></label>
                                    <table id="MyTable" class="table table-striped table-bordered" style="text-align: center;width: 100%;">
                                        <thead>
                                            <tr style="background-color: #337ab7;color: white;">                                                                            
                                                <!--<th style="text-align: center;"></th>
                                                <th style="text-align: center;">اسم الخدمة</th>-->
                                            </tr>
                                        </thead>
                                        <tbody> 

                                        </tbody>
                                    </table>
                                </div>
                            </div>                            
                            <!-- /for Edit -->
                        </div>
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;" id="dtlDiv">
                            <!-- for Edit -->
                            <div class="row" style="color: #327ab7;">تفاصيل المستندات</div>                            
                            <div class="row" >
                                <div class="chosen-select-single mg-b-20 table-responsive" id='TaxAbleTable'>
                                    <label></label>
                                    <table id="dataCutomTable" class="table table-striped table-bordered" style="text-align: center;">
                                        <thead>
                                            <tr style="background-color: #41505d;color: white;">  
                                                <th style="text-align: center;">الوحدة الحسابية</th>
                                                <th style="text-align: center;">الإدارة</th>
                                                <th style="text-align: center;">رقم الفاتورة</th>
                                                <th style="text-align: center;">نوع المتعامل</th>
                                                <th style="text-align: center;">نوع المستند</th>
                                                <!--<th style="text-align: center;">البطاقة الضريبية</th>-->
                                                <th style="text-align: center;">اسم المتعامل</th>
                                                <th style="text-align: center;">تاريخ الفاتورة</th>
                                                <th style="text-align: center;">الاجمالي</th>  
                                                <th style="text-align: center;">حالة المستند</th>
                                                <th style="text-align: center;">التفاصيل</th> 
                                            </tr>
                                        </thead>
                                        <tbody id="Electronic_Invoice_Query_Master_Table"> 

                                        </tbody>
                                    </table>
                                </div>
                            </div>                            
                            <!-- /for Edit -->
                        </div>


                    </div>




                    <!-- /page content -->
                </div>
            </div>


            <div class="modal fade InvoiceDetails" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg" style="width: 90%;">
                    <div class="modal-content">

                        <div class="modal-header" style="background-color: #169F85;color: white;direction: rtl;">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">تفاصيل الفاتورة رقم: <span style="direction: ltr;"><i id="invoiceID1"></i></span></h4>
                        </div>
                        <div class="modal-body" style="direction: rtl;">
                            <div class="row">

                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    <label class="control-label" style="font-size: 15px;">نوع التعامل</label>
                                    <input type="text" class="form-control" name="receiverType1" id="receiverType1" readonly="">
                                </div>                                                                       
                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6 " >
                                    <label class="control-label" style="font-size: 15px;">المتعامل</label>                                                                   
                                    <input type="text" class="form-control" name="receivername1" id="receivername1" readonly="">
                                </div> 
                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6"  >
                                    <label class="control-label container" style="font-size: 15px;" id="ComRegisterDiv1" style="display: block;">البطاقة الضريبية</label>                                                                   
                                    <label class="control-label" style="font-size: 15px;" id="nationalIdDiv1" style="display: none;">الرقم القومي</label>
                                    <label class="control-label" style="font-size: 15px;" id="passportNumberDiv1" style="display: none;">رقم جواز سفر</label>
                                    <input type="text" class="form-control" name="id1" id="id1" required="" autocomplete="disable" readonly="">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    <label class="control-label font-style" style="font-size: 15px;">نوع المستند</label>
                                    <input type="text" class="form-control" name="documentType1" id="documentType1" class="form-control"  readonly="">
                                </div>



                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
                                    <label class="control-label font-style" style="font-size: 15px;">رقم الفاتورة الداخلي</label>
                                    <div class="form-control" name="Invoice_number1" id="Invoice_number1" readonly=""></div>
                                </div>



                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>

                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ الفاتورة</label>
                                    <input type="text" class="form-control" name="dateTimeIssued1" id="dateTimeIssued1" readonly="">
                                </div>

                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ الفاتورة الفعلي</label>
                                    <input type="text" class="form-control" name="invoRealDate1" id="invoRealDate1" readonly="">
                                </div>

                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
                                    <label class="control-label font-style" style="font-size: 15px;">نوع الخدمة</label>
                                    <input type="text" class="form-control" name="serviceName1" id="serviceName1" readonly="">
                                </div>
                                <div class="col-lg-11 col-md-11 col-sm-12 col-xs-12">
                                    <label class="control-label font-style" style="font-size: 15px;">الملاحظات</label>
                                    <input type="text" class="form-control" name="notes1" id="notes1" readonly="">
                                </div>



                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="permToDeliverCode1Div">
                                    <label class="control-label font-style" style="font-size: 15px;">كود إذن التسليم</label>
                                    <input type="text" class="form-control readOnly" name="permToReceiveCode1" id="permToReceiveCode1" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="permToReceiveCode1Div">
                                    <label class="control-label font-style" style="font-size: 15px;">كود إذن الصرف</label>
                                    <input type="text" class="form-control readOnly" name="permToDeliverCode1" id="permToDeliverCode1" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" id="permToReceiveDate1Div">
                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ التسليم و الصرف</label>
                                    <input type="text" class="form-control readOnly" name="permToReceiveDate1" id="permToReceiveDate1" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" style="display: none;" id="permToDeliverDate1Div">
                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ الصرف</label>
                                    <input type="text" class="form-control readOnly" name="permToDeliverDate1" id="permToDeliverDate1" required="">
                                </div>

                            </div>

                            <div class="row" >
                                <div class="chosen-select-single mg-b-20 table-responsive" id='TaxAbleTable1'>
                                    <label></label>
                                    <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                                        <thead>
                                            <tr style="background-color: #337ab7;color: white;">   
                                                <th style="text-align: center;">كود الصنف</th>
                                                <th style="text-align: center;">مسمى الصنف</th>
                                                <th style="text-align: center;">سعر الوحدة بالمصري</th>
                                                <th style="text-align: center;">الكمية</th>
                                                <th style="text-align: center;">الاجمالي</th>
                                                <th style="text-align: center;">الخصم</th>
                                                <th style="text-align: center;">الاجمالي قبل الضريبة</th>
                                                <th style="text-align: center;">الضريبة</th>   
                                                <th style="text-align: center;">الاجمالي بعد الضريبة</th>                                                
                                            </tr>
                                        </thead>
                                        <tbody id="invoiceLines1"> 
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
                                            </tr>-->                                         
                                        </tbody>
                                    </table>
                                </div>                                
                            </div>
                            <div class="row" style="background: #ff5f5f;display: none" id="ErrorsDiv">
                                <h1 style="color: white;font-size: 20px;padding: 10px;" id="errorRmrk"></h1>
                            </div>
                        </div>
                        <div class="modal-footer" style="background-color: #169F85;">
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

    <!-- chosen JS
                ============================================ -->
    <script src="jawlaryWebDesign/js/chosen/chosen.jquery.js"></script>
    <script src="jawlaryWebDesign/js/chosen/chosen-active.js"></script>
    <!-- select2 JS
                ============================================ -->
    <script src="jawlaryWebDesign/js/select2/select2.full.min.js"></script>
    <script src="jawlaryWebDesign/js/select2/select2-active.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>
    <script src="_1_0_0_1_5_Electronic_Invoice_Count_Report_OnDept.js"></script>
    <script src="A_notifyies.js"></script>

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