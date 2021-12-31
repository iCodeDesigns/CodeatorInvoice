<%-- 
    Document   : _0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.codeator.www._0_0_App_tasks._0_0_0_Invoice_Tasks_1_"%>
<%@page import="com.codeator.www._1_3_DB_daos.AppSubElemSpecAuth_DAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.AppSubElemSpecAuth"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoAccUintDept"%>
<%@page import="com.codeator.www._1_3_DB_daos.AccCurrencyCodeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.AccCurrencyCode"%>
<%@page import="com.codeator.www._1_3_DB_daos.PerCountryCodeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.PerCountryCode"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoUnitTypeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoUnitType"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoItemCodeDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvItemCode"%>
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
            List<AppSubElemSpecAuth> asesaList = new AppSubElemSpecAuth_DAO().getEmpSubTabElementsSpecAuthInSubTab("" + employee_session.getEmployeeId(), "_1_0_0_0_2_Electronic_Invoice_Query_verify_AccessServlet");

            boolean RecieveDevliverCodeStstus = false;
            for (AppSubElemSpecAuth a : asesaList) {
                if (a.getAppSubElem().getElementName().equals("RecieveDevliverCode")) {//مبيعات
                    RecieveDevliverCodeStstus = true;
                    break;
                }
            }

            boolean calcUnitAndMinimumStatus = false;
            for (AppSubElemSpecAuth a : asesaList) {
                if (a.getAppSubElem().getElementName().equals("calcUnitAndMinimum")) {//أماك
                    calcUnitAndMinimumStatus = true;
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

        <title>اعتماد الفواتير</title>
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
            .button_position{
                margin-top: 32px;
                width: 100%;

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
                        <div class="navbar nav_title" style="border: 0;padding-top: 10px;">
                            <a href="_0_0_0_0_MainMenuAccessServlet" class="site_title">
                                <div style="width: 50%; margin-left: 0px;">
                                    <img src="webDesign/production/images/ahramTitle5.png" alt="..." height="50" style="margin-top: 0px;margin-left: 15%;border-radius: 15%;padding: 0px;width: 140%;">
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
                                <h3 style="font-weight: bold;">اعتماد الفواتير</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>



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
                        <!--card Start -->
                        <div class="row" style="display: none;">
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                <label class="control-label" style="font-size: 15px;">Portal Type</label>
                                <select onchange="getChange();" name="portal_type_portal" id="portal_type_portal" class="form-control" tabindex="-1" required="">
                                    <!--<option class="font-style" value="pre-production">pre-production</option>-->
                                    <option class="font-style" value="<%=new _0_0_0_Invoice_Tasks_1_().production%>"><%=new _0_0_0_Invoice_Tasks_1_().production%></option>
                                </select>
                            </div>
                        </div>
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <!-- for Edit -->
                            <div class="row" style="color: #327ab7;">اعتماد الفواتير</div>   
                            <div class="col-lg-3 col-md-4 col-sm-6 col-xs-6">
                                <label>نوع المستند</label>
                                <select onchange="getInvoiceMaster();" name="documentStatus" id="documentStatus" class="form-control" tabindex="-1" required="">
                                    <option class="font-style" value="6">المستندات الغير معتمدة</option><!-- for Edit -->
                                    <option class="font-style" value="7">المستندات المعتمدة ولم يتم ارسالها بعد</option><!-- for Edit -->
                                </select>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" ></div>
                            <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2" id="document_search_Div2" style="float: right;direction: rtl;">
                                <button type="button" data-placement="top" onclick="getInvoiceMaster();" class="btn btn-sm btn-dark fa fa-refresh" style="font-weight: bold;font-size: 20px;padding-bottom: 7px;margin-top: 26px;width: 100%;" title="اعادة تحميل الفاتورة" data-toggle="tooltip"></button><br>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                                <label></label>
                                <div class="chosen-select-single mg-b-20 table-responsive" id='TaxAbleTable'>
                                    <table class="table table-striped table-bordered" style="text-align: center;">
                                        <thead id="table_header">
                                            <tr style="background-color: #337ab7;color: white;">                                                                            
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
                        <%
                            }
                        %>

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
                                <%
                                    if (RecieveDevliverCodeStstus) {
                                %>

                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">كود إذن التسليم</label>
                                    <input type="text" class="form-control readOnly" name="permToReceiveCode1" id="permToReceiveCode1" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">كود إذن الصرف</label>
                                    <input type="text" class="form-control readOnly" name="permToDeliverCode1" id="permToDeliverCode1" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ التسليم و الصرف</label>
                                    <input type="text" class="form-control readOnly" name="permToReceiveDate1" id="permToReceiveDate1" required="">
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-4 col-xs-4" style="display: none;">
                                    <label class="control-label font-style" style="font-size: 15px;">تاريخ الصرف</label>
                                    <input type="text" class="form-control readOnly" name="permToDeliverDate1" id="permToDeliverDate1" required="">
                                </div>

                                <%
                                    }
                                %>
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

            <div class="modal fade" id="InvoiceRevision" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header" style="background-color: #f0ad4e;color: white;direction: rtl;">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;">
                                <span aria-hidden="true" style="color: white;">×</span>
                            </button>
                            <h5 class="modal-title" id="exampleModalCenterTitle" style="font-size: 30px;">تحذير</h5>

                        </div>
                        <div class="modal-body" style="direction: rtl;">
                            <div class="row" >
                                <h1 style="color: #f0ad4e;text-align: center">هل أنت متأكد من رفض هذا المستند ؟؟!...</h1>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label class="control-label font-style" style="font-size: 15px;">سبب الرفض</label>
                                    <textarea maxlength="200" id="rmrk" style="margin: 0px; width: 570px; height: 300px;font-size: 20px;text-align: right;resize: none;">
                                        
                                    </textarea>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer" style="background-color: #f0ad4e; text-align: center;font-size: 20px;font-weight: bold;">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal" style="font-size: 20px;font-weight: bold;">لا</button>
                            <button type="button" class="btn btn-default" onclick="sendInvoiceForRevision();"  style="font-size: 20px;font-weight: bold;">نعم</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="Verify" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header" style="background-color: #204d74;color: white;direction: rtl;">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;">
                                <span aria-hidden="true" style="color: white;">×</span>
                            </button>
                            <h5 class="modal-title" id="exampleModalCenterTitle" style="font-size: 30px;">نأكيد</h5>

                        </div>
                        <div class="modal-body" style="direction: rtl;">
                            <div class="row" >
                                <h1 style="color: #204d74;text-align: center">هل أنت متأكد من إعتماد هذا المستند؟؟!...</h1>
                            </div>
                        </div>
                        <div class="modal-footer" style="background-color: #204d74; text-align: center;font-size: 20px;font-weight: bold;">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal" style="font-size: 20px;font-weight: bold;">لا</button>
                            <button type="button" class="btn btn-default" onclick="sendVerify();"  style="font-size: 20px;font-weight: bold;">نعم</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade InvoiceDetailsPortal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg" style="width: 80%;">
                    <div class="modal-content">

                        <div class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">تفاصيل الفاتورة رقم: <span id="invoiceID_portal" style="float: left;"></span> عند الضرائب</h4>
                        </div>
                        <div class="modal-body" >
                            <div id="ErrorsDiv_portal" style="direction: rtl;font-size: 30px;">
                                <div class="btn-danger" >
                                    أخطاء الفاتورة
                                    <div id="errors_counter_portal" style="direction: ltr; font-size: 20px;">
                                        <!--<ol>                                           
                                            <li> step 3 00
                                                <ul>                                           
                                                    <li>x</li>
                                                    <li>z</li>
                                                </ul>
                                            </li>
                                        </ol>-->
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="LoadingCard_portal">
                                    <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                                        <tbody>
                                            <tr> 
                                                <td colspan='7'><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="DataCard_portal">
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                        <div class="chosen-select-single mg-b-20 table-responsive" id='TaxAbleTable_portal'>
                                            <br>
                                            <table id="MyTable" class="table table-striped table-bordered" style="text-align: center;">
                                                <thead>
                                                    <tr style="background-color: #337ab7;color: white;">                                                                            
                                                        <th colspan="3">Receiver (To)</th>                                                    
                                                    </tr>
                                                </thead>
                                                <tbody id="Electronic_Invoice_Query_Master_Table_portal"> 
                                                    <tr>                                                                            
                                                        <th>
                                                            <label class="control-label" style="font-size: 15px;">Name</label>                                                                   
                                                            <input type="text" class="form-control container" id="receivername_portal" readonly="">
                                                        </th>
                                                        <td>
                                                            <label class="control-label" style="font-size: 15px;">National ID / Registration Number</label>                                                                   
                                                            <input type="text" class="form-control container" id="receiverId_portal" readonly="">
                                                        </td>
                                                        <td>
                                                            <label class="control-label" style="font-size: 15px;">Type</label>                                                                   
                                                            <input type="text" class="form-control container" id="receiverType_portal" readonly="">
                                                        </td>
                                                    </tr>
                                                    <tr>                                                                            
                                                        <td colspan="3">
                                                            <label class="control-label" style="font-size: 15px;">Address</label>                                                                   
                                                            <textarea type="text" class="form-control container" id="receiverAddress_portal"  style="height: 100px;" readonly=""></textarea>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                        <div class="chosen-select-single mg-b-20 table-responsive" id='TaxAbleTable_portal'>
                                            <br>
                                            <table id="MyTable" class="table table-striped table-bordered" style="text-align: center;">
                                                <thead>
                                                    <tr style="background-color: #337ab7;color: white;">                                                                            
                                                        <th colspan="3">Issuer (From)</th>                                                    
                                                    </tr>
                                                </thead>
                                                <tbody> 
                                                    <tr>                                                                            
                                                        <th>
                                                            <label class="control-label" style="font-size: 15px;">Name</label>                                                                   
                                                            <input type="text" class="form-control container" id="issuerName_portal" readonly="">
                                                        </th>
                                                        <td>
                                                            <label class="control-label" style="font-size: 15px;">Registration Number</label>                                                                   
                                                            <input type="text" class="form-control container" id="issuerId_portal" readonly="">
                                                        </td>
                                                        <td>
                                                            <label class="control-label" style="font-size: 15px;">Type</label>                                                                   
                                                            <input type="text" class="form-control container" id="issuerType_portal" readonly="">
                                                        </td>
                                                    </tr>
                                                    <tr>                                                                            
                                                        <td colspan="2">
                                                            <label class="control-label" style="font-size: 15px;">Address</label>                                                                   
                                                            <textarea type="text" class="form-control container" id="issuerAddress_portal" style="height: 120px;" readonly=""></textarea>
                                                        </td>
                                                        <td>
                                                            <label class="control-label" style="font-size: 15px;">Tax Activity Code</label>                                                                   
                                                            <input type="text" class="form-control container" id="issuerActivityCode_portal" readonly="">
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="direction: rtl;float: right;">
                                        <input type="text" class="form-control container" id="notes" readonly="">
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="chosen-select-single mg-b-20 table-responsive" id='TaxAbleTable_portal' style="direction: rtl;">
                                            <br>
                                            <table class="table table-striped table-bordered table-hover" style="text-align: center;">
                                                <thead>
                                                    <tr style="background-color: #337ab7;color: white;">   
                                                        <th style="text-align: center;">كود الصنف<br>Item Code</th>
                                                        <th style="text-align: center;">مسمى الصنف<br>Item Name</th>
                                                        <th style="text-align: center;">سعر الوحدة بالمصري<br>EGP Price</th>
                                                        <th style="text-align: center;">الكمية<br>Quantity</th>
                                                        <th style="text-align: center;">الاجمالي<br>Sales Total</th>
                                                        <th style="text-align: center;">الخصم<br>Discount</th>
                                                        <th style="text-align: center;">الاجمالي قبل الضريبة<br>Net Total</th>
                                                        <th style="text-align: center;">الضريبة<br>Tax Sub Type</th>   
                                                        <th style="text-align: center;">الاجمالي بعد الضريبة<br>Total</th>                                                
                                                    </tr>
                                                </thead>
                                                <tbody id="invoiceLines_portal"> 
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
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer" style="background-color: #131e33;">
                        </div>

                    </div>
                </div>
            </div>


            <!-- footer content -->
            <footer>
                <div class="pull-right">
                    Copyrights © <%=new DateOp().getCustomSysDate("yyyy")%> <a href="">AMAC-AHRAM</a> All rights reserved.
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
    <script src="_0_0_0_0_0_GeneralJavaScript.js"></script>


    <script src="_0_0_0_0_0_GeneralJavaScript.js"></script>

    <script>
                                function sleep(ms) {
                                    return new Promise(resolve => setTimeout(resolve, ms));
                                }

                                sleep(2000);
    </script>

    <script>var RecieveDevliverCodeStstus = <%=RecieveDevliverCodeStstus%>;</script><!--المبيعات -->
    <script>var calcUnitAndMinimumStatus = <%=calcUnitAndMinimumStatus%>;</script><!-- أماك-->

    <script src="A_notifyies.js"></script>
    <script src="_1_0_0_0_2_Electronic_Invoice_Query_verify.js"></script>
    <script src="_1_0_0_0_3_Electronic_Invoice_Query_02_From_zPortal_modal.js"></script>



    <!-- bar code - scanner library 
    <script src="webDesign/barcode_scanner/onscan.js"></script>
    <script src="webDesign/barcode_scanner/onscan_running.js"></script> --> 
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