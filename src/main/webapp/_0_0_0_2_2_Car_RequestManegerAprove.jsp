<%-- 
    Document   : _0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

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

        <title>إستعلام طلبات السيارات بالإدارة</title>
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
                                <span style="font-size: 20px;padding-left: 15px;font-weight: bold;">اسم المستخدم</span>
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

                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_right">
                                <h3 style="font-weight: bold;">إستعلام طلبات السيارات بالإدارة</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>




                        <!--card Start -->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <!-- for Edit -->
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    <button type="button" class="btn btn-custon-rounded-three btn-success" href="#" data-toggle="modal" data-target=".Mo3tamadaRequests" style="font-size: 17px;font-weight: bold;"><i class="fa fa-check adminpro-warning-danger" aria-hidden="true"></i> الطلبات المعتمدة من مكتب النقل</button>                                                                    
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    <button type="button" class="btn btn-custon-rounded-three btn-warning" href="#" data-toggle="modal" data-target=".Mo3lakaRequests" style="font-size: 17px;font-weight: bold;"><i class="fa fa-exclamation-triangle adminpro-warning-danger" aria-hidden="true"></i> الطلبات المعلقة من مكتب النقل</button>                                                                    
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    <button type="button" class="btn btn-custon-rounded-three btn-danger" href="#" data-toggle="modal" data-target=".MarfodaRequests" style="font-size: 17px;font-weight: bold;"><i class="fa fa-close adminpro-warning-danger" aria-hidden="true"></i> الطلبات المرفوضة من مكتب النقل</button>                                                                    
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6">
                                    <button type="button" class="btn btn-custon-rounded-three btn-primary" href="#" data-toggle="modal" data-target=".QueryRequests" style="font-size: 17px;font-weight: bold;"><i class="fa fa-question-circle adminpro-warning-danger" aria-hidden="true"></i> إستعلام عن الرحلات</button>                                                                    
                                </div>
                            </div>

                            <div class="row">
                                <%
                                    List<VcleVehicleRequire> vList = new VcleVehicleRequireDao().GetVcleVehicleRequireByDepNoOldAndAprovalNull("" + employee_session.getPerDeptOld().getId().getDepNoOld());
                                    long numbersOfRequestes = vList.size();
                                %>
                                <label class="control-label" style="font-size: 15px;">عدد الطلبات( <span style="color: red;" id="numberOfRequestsID"><%=numbersOfRequestes%></span> )</label>
                                <table class="table table-striped table-bordered" style="text-align: center;">
                                    <thead>
                                        <tr style="background-color: #131e33;color: white;">          
                                            <th style="text-align: center;font-size: 15px;">رقم الطلب</th>
                                            <th style="text-align: center;font-size: 15px;">تاريخ الطلب</th>
                                            <th style="text-align: center;font-size: 15px;">التوقيت</th>
                                            <th style="text-align: center;font-size: 15px;">اسم طالب السيارة</th>
                                            <th style="text-align: center;font-size: 15px;">عدد الركاب</th>
                                            <th style="text-align: center;font-size: 15px;">مكان مقابلة السائق</th>
                                            <th style="text-align: center;font-size: 15px;">نوع الطلب</th>   
                                            <th style="text-align: center;font-size: 15px;">موعد العودة</th> 
                                            <th style="text-align: center;font-size: 15px;">خط سير السيارة</th>
                                            <th style="text-align: center;font-size: 15px;">الإعتماد</th>
                                        </tr>
                                    </thead>
                                    <tbody id="MainTable">

                                    </tbody>
                                </table>

                            </div>
                            <!-- /for Edit -->
                        </div>
                        <!--card Start -->

                    </div>

                    <!-- Modal -->
                    <div class="modal fade Mo3tamadaRequests" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div id="Header1" class="modal-header" style="background-color: #26b99a;color: white;direction: rtl;">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel21" style="font-size: 30px;">الطلبات المعتمدة من مكتب النقل من إدارة<%=employee_session.getPerDeptOld().getDepName()%></h4>
                                </div>

                                <div class="modal-body" style="direction: rtl;">
                                    <div class="row" >
                                        <div class="chosen-select-single mg-b-20 table-responsive">
                                            <label style="font-size: 140%;">الطلبات</label>
                                            <table class="table table-striped table-bordered" style="text-align: center;">
                                                <thead>
                                                    <tr style="background-color: #0a9f77;color: white;">                                         
                                                        <th style="text-align: center;font-size: 15px;">رقم الطلب</th>
                                                        <th style="text-align: center;font-size: 15px;">التاريخ</th>
                                                        <th style="text-align: center;font-size: 15px;">التوقيت</th>
                                                        <th style="text-align: center;font-size: 15px;">اسم طالب السيارة</th>
                                                        <th style="text-align: center;font-size: 15px;">عدد الركاب</th>
                                                        <th style="text-align: center;font-size: 15px;">مكان مقابلة السائق</th>
                                                        <th style="text-align: center;font-size: 15px;">نوع الطلب</th>   
                                                        <th style="text-align: center;font-size: 15px;">موعد العودة</th> 
                                                        <th style="text-align: center;font-size: 15px;">خط سير السيارة</th>   
                                                    </tr>
                                                </thead>
                                                <tbody id="Mo3tamadaID">
                                                </tbody>                                                
                                            </table>
                                        </div>
                                    </div>
                                </div>

                                <div id="Footer1" class="modal-footer" style="background-color: #26b99a; direction: rtl;">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">اغلاق</button>
                                </div>


                            </div>
                        </div>
                    </div>



                    <div class="modal fade Mo3lakaRequests" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div id="Header1" class="modal-header" style="background-color: #ae9167;;color: white;direction: rtl;">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel21" style="font-size: 30px;">الطلبات المعلقة من مكتب النقل من إدارة <%=employee_session.getPerDeptOld().getDepName()%></h4>
                                </div>

                                <div class="modal-body" style="direction: rtl;">
                                    <div class="row" >
                                        <div class="chosen-select-single mg-b-20 table-responsive">
                                            <label>الطلبات</label>
                                            <table class="table table-striped table-bordered" style="text-align: center;">
                                                <thead>
                                                    <tr style="background-color: #e0921b;color: white;">                                                                            
                                                        <th style="text-align: center;font-size: 15px;">التاريخ</th>
                                                        <th style="text-align: center;font-size: 15px;">التوقيت</th>
                                                        <th style="text-align: center;font-size: 15px;">اسم طالب السيارة</th>
                                                        <th style="text-align: center;font-size: 15px;">عدد الركاب</th>
                                                        <th style="text-align: center;font-size: 15px;">مكان مقابلة السائق</th>
                                                        <th style="text-align: center;font-size: 15px;">نوع الطلب</th>   
                                                        <th style="text-align: center;font-size: 15px;">موعد العودة</th> 
                                                        <th style="text-align: center;font-size: 15px;">خط سير السيارة</th>  
                                                        <th style="text-align: center;font-size: 15px;">حذف الطلب</th> 
                                                    </tr>
                                                </thead>
                                                <tbody id="TalabatMo3alakaOrange">
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div id="Footer1" class="modal-footer" style="background-color: #ae9167;; direction: rtl;">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">اغلاق</button>
                                </div>


                            </div>
                        </div>
                    </div>


                    <div class="modal fade MarfodaRequests" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div id="Header1" class="modal-header" style="background-color: #d9534f;color: white;direction: rtl;">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel21" style="font-size: 30px;">الطلبات المرفوضة من مكتب النقل من إدارة <%=employee_session.getPerDeptOld().getDepName()%></h4>
                                </div>

                                <div class="modal-body" style="direction: rtl;">
                                    <div class="row" >
                                        <div class="chosen-select-single mg-b-20 table-responsive">
                                            <label>الطلبات</label>
                                            <table class="table table-striped table-bordered" style="text-align: center;">
                                                <thead>
                                                    <tr style="background-color: #f53955;color: white;">                                                                            
                                                        <th style="text-align: center;font-size: 15px;">التاريخ</th>
                                                        <th style="text-align: center;font-size: 15px;">التوقيت</th>
                                                        <th style="text-align: center;font-size: 15px;">اسم طالب السيارة</th>
                                                        <th style="text-align: center;font-size: 15px;">عدد الركاب</th>
                                                        <th style="text-align: center;font-size: 15px;">مكان مقابلة السائق</th>
                                                        <th style="text-align: center;font-size: 15px;">نوع الطلب</th>   
                                                        <th style="text-align: center;font-size: 15px;">موعد العودة</th> 
                                                        <th style="text-align: center;font-size: 15px;">خط سير السيارة</th>   
                                                        <th style="text-align: center;font-size: 15px;">حذف الطلب</th> 
                                                    </tr>
                                                </thead>
                                                <tbody id="TalabatMarfodaRed">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div id="Footer1" class="modal-footer" style="background-color: #d9534f; direction: rtl;">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">اغلاق</button>
                                </div>


                            </div>
                        </div>
                    </div>


                    <div class="modal fade QueryRequests" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div id="Header1" class="modal-header" style="background-color: #286090;color: white;direction: rtl;">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel21" style="font-size: 30px;">إستعلام عن طلبات لإدارة <%=employee_session.getPerDeptOld().getDepName()%></h4>
                                </div>

                                <div class="modal-body" style="direction: rtl;">
                                    <div class="row" >
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6" >
                                                <label>التاريخ من</label>                                                                   
                                                <input type="date" class="form-control" id="from_date" value="" >
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6" >
                                                <label>التاريخ إلى</label>                                                                   
                                                <input type="date" class="form-control" id="to_date" value="" >
                                            </div>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><br></div>
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="SearchButton">
                                            <button type="reset" onclick="getReportDetail(<%=employee_session.getPerDeptOld().getId().getDepNoOld()%>);" class="btn btn-custon-four btn-primary" style="width: 100%;"><i class="fa fa-search adminpro-checked-pro" aria-hidden="true"></i> بحث </button>
                                        </div>

                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="chosen-select-single mg-b-20 table-responsive">
                                                <label style="font-size: 140%;">الطلبات</label>
                                                <table class="table table-striped table-bordered" style="text-align: center;" id="QueryResult">

                                                </table>
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="loadData2" >

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="Footer1" class="modal-footer" style="background-color: #286090; direction: rtl;">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">اغلاق</button>
                                </div>


                            </div>
                        </div>
                    </div>


                    <div id="IgnorReasonDiv" class="modal fade ElMarfodat" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-lg" style="border-style: solid;border-color: yellow;">
                            <div class="modal-content">
                                <div class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">سبب الرفض</h4>                                                   
                                </div>
                                <div class="modal-body">
                                    <div class="row">
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                            <button type="button" class="btn btn-custon-rounded-three btn-danger" onclick="clearText();" style="font-weight: bold;border-color: black;width: 100%;"><i class="fa fa-trash adminpro-danger-error" aria-hidden="true"></i>مسح المحتوى</button>
                                        </div>
                                    </div>
                                    <div class="row" onkeyup="checkText();" onmouseover="checkText();">                                        
                                        <div class="chosen-select-single mg-b-20 table-responsive" style="border-style: solid;border-color: black;">

                                            <div class="x_content">
                                                <div id="alerts"></div>
                                                <div class="btn-toolbar editor" data-role="editor-toolbar" data-target="#editor-one">
                                                    <div class="btn-group">
                                                        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font"><i class="fa fa-font"></i><b class="caret"></b></a>
                                                        <ul class="dropdown-menu">
                                                        </ul>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="fa fa-text-height"></i>&nbsp;<b class="caret"></b></a>
                                                        <ul class="dropdown-menu">
                                                            <li>
                                                                <a data-edit="fontSize 5">
                                                                    <p style="font-size:17px">Huge</p>
                                                                </a>
                                                            </li>
                                                            <li>
                                                                <a data-edit="fontSize 3">
                                                                    <p style="font-size:14px">Normal</p>
                                                                </a>
                                                            </li>
                                                            <li>
                                                                <a data-edit="fontSize 1">
                                                                    <p style="font-size:11px">Small</p>
                                                                </a>
                                                            </li>
                                                        </ul>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="fa fa-bold"></i></a>
                                                        <a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="fa fa-italic"></i></a>
                                                        <a class="btn" data-edit="strikethrough" title="Strikethrough"><i class="fa fa-strikethrough"></i></a>
                                                        <a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="fa fa-underline"></i></a>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="fa fa-list-ul"></i></a>
                                                        <a class="btn" data-edit="insertorderedlist" title="Number list"><i class="fa fa-list-ol"></i></a>
                                                        <a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="fa fa-dedent"></i></a>
                                                        <a class="btn" data-edit="indent" title="Indent (Tab)"><i class="fa fa-indent"></i></a>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="fa fa-align-left"></i></a>
                                                        <a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="fa fa-align-center"></i></a>
                                                        <a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="fa fa-align-right"></i></a>
                                                        <a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="fa fa-align-justify"></i></a>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Hyperlink"><i class="fa fa-link"></i></a>
                                                        <div class="dropdown-menu input-append">
                                                            <input class="span2" placeholder="URL" type="text" data-edit="createLink" />
                                                            <button class="btn" type="button">Add</button>
                                                        </div>
                                                        <a class="btn" data-edit="unlink" title="Remove Hyperlink"><i class="fa fa-cut"></i></a>
                                                    </div>

                                                    <!--<div class="btn-group">
                                                        <a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="fa fa-picture-o"></i></a>
                                                        <input type="file" data-role="magic-overlay" accept="image/png, image/jpeg, image/jpg" data-target="#pictureBtn" data-edit="insertImage" />
                                                    </div>-->

                                                    <div class="btn-group">
                                                        <a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i class="fa fa-undo"></i></a>
                                                        <a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="fa fa-repeat"></i></a>
                                                    </div>
                                                </div>

                                                <div id="editor-one" class="editor-wrapper"></div>

                                                <textarea name="descr" id="descr" style="display:none;"></textarea>

                                                <!--<br>

                                                <div class="ln_solid row"></div>-->
                                            </div>

                                        </div>
                                        <br>
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <label id="percentage"></label>
                                        </div>
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="delBtn">
                                            <button type="button" class="btn btn-custon-rounded-three btn-danger" onclick="DeleteRequest();" style="font-weight: bold;border-color: black;width: 100%;"><i class="fa fa-save adminpro-danger-error" aria-hidden="true"></i> تنفيذ الرفض</button>
                                        </div>
                                    </div>

                                </div>
                                <div class="modal-footer" style="background-color: #131e33;">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">اغلاق</button>
                                </div>
                            </div>
                        </div>
                    </div>




                    <!-- /page content -->









                </div>
            </div>

            <script>
                function getTafaseal(text) {
                    document.getElementById("SababElRafd").innerHTML = text;
                }
            </script>
            <div class="modal fade ElMarfodat" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <div class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">سبب الرفض</h4>
                        </div>
                        <div class="modal-body" >
                            <div id="SababElRafd" style="direction: rtl;font-size: 30px;">

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
    <script src="_0_0_0_0_0_GeneralJavaScript.js"></script>
    <script src="_0_0_0_2_2_Car_RequestManegerAprove.js"></script>
    <script>DeptOldFunction(<%=employee_session.getPerDeptOld().getId().getDepNoOld()%>), LoadTablesEach5Min();</script>

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