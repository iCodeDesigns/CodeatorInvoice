<%-- 
    Document   : _0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="java.util.Date"%>
<%@page import="com.codeator.www._1_3_DB_daos.VcleVehicleTypeDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.VcleVehicleType"%>
<%@page import="com.codeator.www._1_3_DB_daos.VcleVehicleDriverJoinDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.VcleVehicleDriverJoin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.codeator.www._1_3_DB_daos.VcleEmployeeMasterDao"%>
<%@page import="com.codeator.www._1_3_DB_daos.VcleVehicleMasterDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.VcleVehicleMaster"%>
<%@page import="com.codeator.www._1_2_DB_entities.VcleEmployeeMaster"%>
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

            List<VcleVehicleMaster> carList = new VcleVehicleMasterDao().GetAllVehiclesCarsHaveGuestNumber();
            //Get All Drivers Employees
            List<VcleEmployeeMaster> vList = new VcleEmployeeMasterDao().GetEmployeesVehiclesOfCarAndBickes();

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

        <title>احصائيات</title>
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

        <!-- Bootstrap Colorpicker -->
        <link href="webDesign/vendors/mjolnic-bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css" rel="stylesheet">


        <!-- bootstrap-wysiwyg -->
        <link href="webDesign/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="webDesign/build/css/custom.min.css" rel="stylesheet">
        <link href="webDesign/vendors/search_select/select2.css" rel="stylesheet">

        <style>
            .cardclass{
                background-color: #851934;
                box-shadow: -3px 12px 12px 5px #888888;
                font-size: 160%;
            }
            .button_style{
                border: none;
                /*background: #337ab7;*/
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
            div.scroll { 
                margin-left: 4px;
                margin-right:  4px;
                margin-top  : 4px;
                margin-bottom:  4px;

                padding:4px; 
                width: 100%; 
                height: 260px; 
                overflow-x: hidden; 
                overflow-y: auto; 
                text-align:justify; 
            }
            /*tbody.bodyScroll {  
                display:block;
                height:300px;
                overflow:auto; 
            }
            thead, tbody tr {
                display:table;
                width:100%;
                table-layout:fixed;
            //even columns width , fix width of table too
            }
            /*thead {
                width: calc( 100% - 1em )
            //scrollbar is average 1em/16px width, remove it from thead width
            }
            table {
                width:400px;
            }*/

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

                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_right">
                                <h3 style="font-weight: bold;">احصائيات</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>




                        <!--card Start -->
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                                <!-- for Edit -->
                                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                            <label class="control-label font-style"> مستوى الاستعلام</label>
                                            <select style="direction: rtl;" type="text" placeholder="مستوى البحث" onchange="searchLevel();" data-placeholder="اختر ..." id="searchLevel" maxlength="45" name="searchLevel" class="form-control font-style" required="">
                                                <option value="" selected="" class="input-large font-style">اختر مستوى الإستعلام ..</option>
                                                <option value="Section" class="input-large font-style">كل الأقسام ..</option>
                                                <option value="Dept"class="font-style"> الإدارات فرعية..</option>
                                            </select>
                                        </div>


                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                            <label class="control-label font-style" id="lbl_title_dept">القسم</label>
                                            <select style="direction: rtl;width:100%;" type="text" placeholder="مستوى البحث" id="sectionOrDept" onchange="sectionOrDept();" maxlength="45" name="sectionOrDept" class="form-control SELECT_Combo font-style" required="">
                                            </select>
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                            <label class="control-label font-style"> نوع عرض الاحصائية</label>
                                            <select type="text" placeholder="مستوى البحث" onchange="DashTimeView();" id="DashTimeView" maxlength="45" name="DashTimeView" class="form-control font-style" required="">

                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <%
                                            String thisYear = new DateOp().Date2String(new DateOp().getSysDate(), "yyyy");
                                        %>
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" id="yearDateDiv" style="display: block;">
                                            <label class="control-label font-style">سنة</label>   
                                            <!--<input type="number" class="form-control font-style" min="2020" max="<%=thisYear%>" id="from_year" value="<%=thisYear%>">-->
                                            <select data-placeholder="اختر بداية سنة الاستعلام ..." name="from_year" id="from_year" class="form-control font-style" required="">     
                                                <%
                                                    List<Date> pList2 = new VcleVehicleRequireDao().GetRequireDateDistnictYear();
                                                    List<String> dates = new ArrayList<String>();
                                                    for (Date p : pList2) {
                                                        String year_str = new DateOp().Date2String(p, "yyyy");
                                                        if (!dates.contains(year_str)) {
                                                            dates.add(year_str);
                                                %>                                                                        
                                                <option class="font-style" value="<%=year_str%>"><%=year_str%></option>
                                                <%
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>                                    

                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" id="MonthDateDiv" style="display: none;" >
                                            <label class="control-label font-style">شهر</label>                                                                   
                                            <select data-placeholder="اختر بداية سنة الاستعلام ..." name="month" id="month" class="form-control font-style" required="">     
                                                <%
                                                    List<String> monthList = new DateOp().monthArabic;
                                                    for (int i = 0; i < monthList.size(); i++) {
                                                %>                                                                        
                                                <option class="font-style" value="<%=i + 1%>"><%=monthList.get(i)%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                            <label class="control-label font-style">نوع الطلب</label>
                                            <select data-placeholder="اختر نوع الطلب ..." name="requireType" id="requireType" style="font-weight: bold;font-size: 15px;" class="form-control" tabindex="-1" required="">                                                     
                                                <option value="All" selected="" class="font-style">الكل...</option>
                                                <option value="6" class="font-style">توصيلات</option>
                                                <option value="1" class="font-style">مذكرة</option> 
                                                <option value="8" class="font-style">تخصص</option>
                                                <option value="2" class="font-style">طوارئ</option>
                                                <option value="3" class="font-style">دوري</option>
                                                <option value="7" class="font-style">صيانة</option>
                                            </select>  
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" >
                                            <label class="control-label font-style">نوع المركبة</label>
                                            <select data-placeholder="اختر نوع المركبة ..." name="VcleType" id="VcleType" class="form-control font-style" required="">     
                                                <option value="All" selected="" class="font-style">الكل...</option>
                                                <%
                                                    List<VcleVehicleType> vvtList = new VcleVehicleTypeDao().GetVehiclesByGuestNo("1");
                                                    for (VcleVehicleType p : vvtList) {
                                                %>                                                                        
                                                <option class="font-style" value="<%=p.getVcleType()%>"><%=p.getVcleTypeName()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                            <label class="control-label font-style" >نوع الرسم</label>
                                            <select type="text" placeholder="نوع الرسم" id="plotType" maxlength="45" name="plotType" class="form-control font-style" required="">
                                                <option value="V" class="font-style" >رأسي</option>
                                                <option value="H" class="font-style" >أفقي</option>                                            
                                            </select>
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" id="color_13Div" style="display: none;">
                                            <label class="control-label font-style" >لون العرض :</label>
                                            <div class="input-group demo2">
                                                <span class="input-group-addon" style="border-radius: 0px;border-right: 2px solid #ccc;"><i></i></span>
                                                <input type="text" value="#26B99A" readonly="" id="color_13" style="direction: ltr;" class="form-control" />                                            
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">                                           
                                            <button type="button" data-placement="top" onclick="checkData('this_window');" class="button_style btn btn-sm btn-warning button_position fa fa-search" style="font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> استعلام</button>
                                        </div>
                                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">                                           
                                            <button type="button" data-placement="top" onclick="checkData('new_window');" class="button_style btn btn-sm btn-success button_position fa fa-search" style="font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> استعلام</button>
                                        </div>
                                    </div>

                                    <style>
                                        #load {
                                            width: 0%;
                                            height: 30px;
                                            background-color: #4CAF50;
                                            text-align: center; 
                                            line-height: 30px;
                                            color: white;
                                        }
                                    </style>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">                                           
                                        <div id="myProgress">
                                            <div id="load">0%</div>
                                            <br>
                                        </div>
                                    </div>
                                    <style>
                                        .vl {
                                            border-left: 2px solid grey;
                                            height: 300px;
                                        }
                                    </style>
                                    <div class="vl"></div>

                                    <!-- /for Edit -->
                                </div>

                                <style>
                                    #dashTableSearch {
                                        background-image: url('webDesign/production/images/search-512.png');
                                        background-position: 6px 6px;
                                        background-repeat: no-repeat;
                                        background-size: 10%;
                                        background-attachment: fixed;
                                    }                                    
                                </style>                                
                                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="dashTableSearchDiv" style="display: none">
                                            <input type="text" name="dashTableSearch" id="dashTableSearch" style="width: 100%;" onkeyup="dashTableSearch();" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 scroll">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">
                                            <table id="dashTable" class="table table-striped table-bordered table-hover">

                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!--card Start -->
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                                <!-- for Edit -->
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">
                                    <div id="EmpCount_DashBoard" style="height:500px;min-width: 800px;"></div>
                                </div>
                            </div>






                        </div>



                        <!-- /page content -->

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

        <!-- ECharts -->
        <script src="webDesign/vendors/echarts/dist/echarts.min.js"></script>
        <script src="webDesign/vendors/echarts/map/js/world.js"></script>

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

        <!-- Bootstrap Colorpicker -->
        <script src="webDesign/vendors/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>

        <!-- bootstrap-wysiwyg -->
        <script src="webDesign/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
        <script src="webDesign/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
        <script src="webDesign/vendors/google-code-prettify/src/prettify.js"></script>

        <!-- PNotify -->
        <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
        <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
        <!-- Custom Theme Scripts -->

        <script src="_0_0_0_0_0_GeneralJavaScript.js"></script>
        <script src="_0_0_2_0_0_Transportation_Main_DashBoard.js"></script>
        <script src="webDesign/vendors/search_select/select2.js"></script>

        <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>

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