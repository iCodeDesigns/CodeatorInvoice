<%-- 
    Document   : _0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoAccUintDept"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoDocumentStatus"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoDocumentStatusDAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.PerDeptOld"%>
<%@page import="com.codeator.www._1_3_DB_daos.PerDeptOldDao"%>
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

        <title>?????????????? ???? ???????? ???????????????? ?????? ?????????? ??????????????</title>
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
            .card_options{
                position: fixed;
                bottom: 20px;
                /*right: 30px;*/
                z-index: 99;
                font-size: 18px;
                border: none;
                outline: none;
                padding: 15px;
                border-radius: 4px;
                background: #1abb9c;
                width: 15%;
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
            /*   ???????? ???????? ???????? ???????? ?????????? ???????????? */ 
            .selectList[multiple],
            .selectList[size] {
                height: 122px;
            }
            /*  ???????? ???????? ?????? ???? ??????????????  */ 
            .SELECT_Combo {
                font-weight: bold;
                font-size: 15px; 
            }
            /* ?????? ?????????? ???????????? ?????? ???????? ???????? ???????? ?????? ????????????  */ 
            .font-style{
                font-weight: bold;
                font-size: 15px;
            }
            /* ?????? ???????? ?????????? ?????????? ???????????? ???????? ?????????? ?????????????? */
            .searchCustom{
                background-color: #131e33;
                /*border: black solid 2px;*/
                color: white;
                border-radius: 13px;
            }
            /* ?????? ???????????????? ???????????? ?????????? ???????????? ?????????? ???????????? */
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
            weekday[0] = "??????????";
            weekday[1] = "??????????????";
            weekday[2] = "????????????????";
            weekday[3] = "????????????????";
            weekday[4] = "????????????";
            weekday[5] = "????????????";
            weekday[6] = "??????????";

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
                                <span style="font-size: 15px;padding-left: 15px;font-weight: bold;">?????? ????????????????</span>
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

                <%                    String deptName = (employee_session.getPerDeptOld() == null) ? "" : employee_session.getPerDeptOld().getDepName();//????????????
                    String SectionName = (employee_session.getPerDeptOld() == null) ? "" : employee_session.getPerDeptOld().getPerSectionOld().getSectionName();//????????????

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
                            <input type="text" class="form-control" placeholder="????????????" data-original-title="????????????" value="<%=SectionName%>" required="" readonly="" data-toggle="tooltip" data-placement="bottom">
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" style="display: block;">
                            <input type="text" class="form-control" placeholder="????????????" data-original-title="????????????" value="<%=deptName%>" required="" readonly=""  data-toggle="tooltip" data-placement="bottom">
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" style="display: block;">
                            <input type="text" class="form-control" placeholder="???????????? ????????????????" data-original-title="???????????? ????????????????" value="<%=AccUintDeptName%>" required="" readonly=""  data-toggle="tooltip" data-placement="bottom">
                        </div>
                    </div>
                    <div class="">
                        <div class="page-title">
                            <div class="title_right">
                                <h3 style="font-weight: bold;">???????????????? ???????????????? ???????????????????? ????????????</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <!--card Start -->
                        <div class="row">
                            <div class="">
                                <div class="x_panel card_options" style="box-shadow: -1px 2px 5px 1px #929292;">
                                    <!-- for Edit -->
                                    <div class="x_title">
                                        <h2 style="width: 50%;font-weight: bold;float: right;color: #000000;">????????</h2>
                                        <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;" >
                                            <li><a class="collapse-link"><i class="fa fa-chevron-down"></i></a>
                                            </li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content" style="display: none;">
                                        <div class="row">

                                        </div>
                                        <div class="row" >
                                            <div class="chosen-select-single mg-b-20 table-responsive" id='TaxAbleTable'>

                                                <div class="col-lg-12 col-md-12 col-sm-6 col-xs-6">
                                                    <label class="control-label" style="font-size: 15px;">??????????????</label>                                        
                                                    <select <%=(auth_to_see_all_dept) ? "" : "disabled"%> onchange="" id="dept" class="form-control" tabindex="-1"  style="border: black solid 2px;">
                                                        <%
                                                            List<PerDeptOld> deptList = null;
                                                            if (auth_to_see_all_dept) {
                                                                deptList = new PerDeptOldDao().GetAllDeptInInvoice();
                                                            } else {
                                                                deptList = new PerDeptOldDao().GetDeptByDept_ID(sectionNoOld, depNoOld);
                                                            }
                                                            String selected = "";

                                                            for (PerDeptOld deptOld : deptList) {

                                                                if (deptOld.getId().getDepNoOld() == Long.parseLong(depNoOld)
                                                                        && deptOld.getId().getSectionNoOld() == Integer.parseInt(sectionNoOld)) {
                                                                    selected = " selected ";
                                                                } else {
                                                                    selected = "";
                                                                }
                                                        %>
                                                        <option class="font-style" <%=selected%> value="<%=deptOld.getId().getSectionNoOld()%>-<%=deptOld.getId().getDepNoOld()%>"><%=deptOld.getDepName()%></option><!-- for Edit -->
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                                <div class="col-lg-12 col-md-12 col-sm-6 col-xs-6">
                                                    <label class="control-label" style="font-size: 15px;">???????? ??????????????</label>                                        
                                                    <select onchange="" id="docStatus" class="form-control" tabindex="-1"  style="border: black solid 2px;">
                                                        <%
                                                            List<InvoDocumentStatus> docStatusList = new InvoDocumentStatusDAO().GetInvoDocumentStatus();

                                                            for (InvoDocumentStatus status : docStatusList) {

                                                                switch (status.getDocStatus()) {
                                                                    case 0:
                                                                    case 13:
                                                                        continue;
                                                                    case 7:
                                                                        selected = " selected ";
                                                                        break;
                                                                    default:
                                                                        selected = "";
                                                                }
                                                        %>
                                                        <option class="font-style" <%=selected%> value="<%=status.getDocStatus()%>"><%=status.getDocStatusName()%></option><!-- for Edit -->
                                                        <%
                                                            }
                                                        %>
                                                        <option value="All">????????</option>
                                                    </select>
                                                </div>

                                                <div class="col-lg-12 col-md-12 col-sm-6 col-xs-6">
                                                    <label class="control-label" style="font-size: 15px;">?????? ??????????</label>                                        
                                                    <select onchange="changeFilter();" id="searchType" class="form-control" tabindex="-1"  style="border: black solid 2px;">                                                        
                                                        <option value="d" selected>????????</option>
                                                        <option value="m" >????????</option>
                                                        <option value="y" >????????</option>
                                                    </select>
                                                </div>

                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="dateDiv">
                                                    <label class="control-label" style="font-size: 15px;">??????????</label>
                                                    <input type="date" value="<%=new DateOp().getCustomSysDate("yyyy-MM-dd")%>" name="date" id="date" class="form-control" style="border: black solid 2px;">
                                                </div>

                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="monthDiv">
                                                    <label class="control-label" style="font-size: 15px;">??????????</label>
                                                    <input type="month" name="month" id="month" class="form-control" style="border: black solid 2px;">
                                                </div>

                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="yearDiv">
                                                    <label class="control-label" style="font-size: 15px;">??????????</label>
                                                    <select onchange="" id="year" class="form-control" tabindex="-1"  style="border: black solid 2px;">                                                        
                                                        <%
                                                            int current_year = Integer.parseInt(new DateOp().getCustomSysDate("yyyy"));
                                                            for (int year = 2021; year <= current_year; year++) {
                                                                if (year == current_year) {
                                                                    selected = " selected ";
                                                                } else {
                                                                    selected = "";
                                                                }
                                                        %>
                                                        <option <%=selected%> value="<%=year%>" ><%=year%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </div>
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                                                    <label class="control-label" style="font-size: 15px;">?????? ?????? ??????????</label>
                                                    <select onchange="" id="values_search" class="form-control" tabindex="-1"  style="border: black solid 2px;">                                                        
                                                        <option value="counter">?????????????? ?????????? ????????????????</option>
                                                        <option value="money">?????????????? ???????????????? ?????????? ????????????????</option>
                                                    </select>
                                                </div>
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                    <button type="button" data-placement="top" onclick="getInvoiceCountNumbers();" class="btn btn-sm btn-primary fa fa-search" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 38px;width: auto;display: block;"> ??????</button>
                                                </div>



                                                <br>                                    


                                            </div>
                                        </div>
                                    </div>

                                    <!-- /for Edit -->
                                </div>
                            </div>


                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                                    <!-- for Edit -->
                                    <div class="x_title">
                                        <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;">?????????????? ?????????? ????????????????</h2>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content" style="direction: ltr;">
                                        <lable id="GraphTitleDiv"></lable>
                                        <div id="Invoice_count_numbers_chart" style="height:350px;"></div>

                                    </div>

                                    <!-- /for Edit -->
                                </div>
                            </div>


                        </div>


                    </div>




                    <!-- /page content -->









                </div>
            </div>




            <!-- footer content -->
            <footer>
                <div class="pull-right">
                    Copyrights ?? <%=new DateOp().getCustomSysDate("yyyy")%> <a href="">CODEATOR</a> All rights reserved.
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

    <!-- ECharts -->
    <script src="webDesign/vendors/echarts/dist/echarts.min.js"></script>
    <script src="webDesign/vendors/echarts/map/js/world.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>
    <script src="_1_0_0_0_7_Electronic_Invoice_Dept_Charts.js"></script>

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