<%-- 
    Document   : _0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.codeator.www._1_2_DB_entities.InvoItemCode"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoAccUintDept"%>
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
            .select2-selection__rendered {
                text-align: right;
                color: black;
                font-size:15px;
                font-weight: bold;
                direction: rtl;
            }
            /* ?????? ???????? ?????????? ?????????? ???????????? ???????? ?????????? ?????????????? */
            .searchCustom{
                background-color: #131e33;
                /*border: black solid 2px;*/
                color: white;
                border-radius: 13px;
            }
            /* ?????? ???????????????? ???????????? ?????????? ???????????? ?????????? ???????????? */
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
                                <h3 style="font-weight: bold;">???????????? ?????????? ?????????????? ????????????????</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <!--card Start -->
                        <div class="col-lg-12 col-md-12 col-sm-6 col-xs-6">
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                                <div class="x_title">
                                    <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;">???????????? ?????????????? ????????????????</h2>
                                    <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;" onclick="copyClientNameToTitle();">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-down"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <!-- for Edit -->
                                <div class="x_content" style="display: none;">
                                    <div class="row">

                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-6 col-xs-6">
                                            <div class="chosen-select-single mg-b-20 table-responsive">
                                                <label></label>                                    
                                                <table class="table table-striped jambo_table bulk_action table-bordered" style="text-align: center;">                                                    
                                                    <tbody class="customTable" id="taxTableCheck"> 

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2 form-group" id="swap_btn">                                            
                                            <button type="button" data-placement="top" onclick="saveTaxs();" class="button_style btn btn-sm btn-primary" data-original-title="?????????? ???????? ??????????" data-toggle="tooltip" data-placement="bottom" style="font-weight: bold;font-size: 15px;padding-bottom: 6px;padding-top: 6px;margin-top: 26px;" data-toggle="modal" data-target="#x"><i class="fa fa-save"> ??????</i></button>
                                        </div>                                                                        

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-6 col-xs-6">
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                                <div class="x_title">
                                    <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;">???????????? ?????????? ???????????? ????????????????</h2>
                                    <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;" onclick="">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-down"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <!-- for Edit -->
                                <div class="x_content" style="display: none;">
                                    <div class="row">

                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-6 col-xs-6">
                                            <div class="chosen-select-single mg-b-20 table-responsive">
                                                <label></label>                                    
                                                <table class="table table-striped jambo_table bulk_action table-bordered" style="text-align: center;">                                                    
                                                    <tbody class="customTable" id="unitsTableCheck"> 

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2 form-group" id="swap_btn">                                            
                                            <button type="button" data-placement="top" onclick="saveUnits();" class="button_style btn btn-sm btn-primary" data-original-title="?????????? ???????? ??????????" data-toggle="tooltip" data-placement="bottom" style="font-weight: bold;font-size: 15px;padding-bottom: 6px;padding-top: 6px;margin-top: 26px;" data-toggle="modal" data-target="#x"><i class="fa fa-save"> ??????</i></button>
                                        </div>    
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-6 col-xs-6">
                            <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                                <div class="x_title">
                                    <h2 style="width: 50%;font-weight: bold;float: right;color: #327ab7;">???????????? ?????????? ?????????????? ????????????????</h2>
                                    <ul class="nav navbar-left panel_toolbox" style="direction: ltr;float: left;width: 50%;" onclick="">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <!-- for Edit -->
                                <div class="x_content">
                                    <div class="row">
                                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
                                            <label class="control-label" style="font-size: 15px;">??????????????</label>                                                                   
                                            <select style="width: 100%;" data-placeholder="???????? ??????..." name="itemCode" id="itemCode" class="form-control SELECT_Combo" tabindex="-1" required="">
                                                <option class="font-style" value=""></option>
                                                <%
                                                    List<InvoItemCode> InvoItemCodeList = new InvoItemCodeDAO().GetInvItemCode();
                                                    String ItemCode = "";
                                                    for (InvoItemCode p : InvoItemCodeList) {
                                                        if (p.getCodeType().equals("EGS")) {
                                                            String ItemCodeArr[] = p.getItemCode().split("-");
                                                            ItemCode = ItemCodeArr[2];
                                                        } else {
                                                            ItemCode = p.getItemCode();
                                                        }

                                                %>
                                                <option class="font-style" value="<%=p.getItemCode()%>"><%=p.getCodeType()%> / <%=ItemCode%> / <%=p.getAItemName()%></option>
                                                <%   //

                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
                                            <label class="control-label" style="font-size: 15px;">?????????? ?????????? ????????????????</label>                                                                   
                                            <input type="text" class="form-control" name="aItemDesc" id="aItemDesc" required="">
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
                                            <label class="control-label" style="font-size: 15px;">?????????? ?????????? ??????????????????????</label>                                                                   
                                            <input type="text" class="form-control" name="eItemDesc" id="eItemDesc" required="">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
                                            <label class="control-label" style="font-size: 15px;">???????????? ?????????? ???? ??????</label>                                                                   
                                            <input type="text" class="form-control" name="itemBarcode" id="itemBarcode" required="">
                                        </div>                                
                                    </div>
                                    <div class="col-lg-1 col-md-1 col-sm-2 col-xs-2 form-group" id="swap_btn">                                            
                                        <button type="button" data-placement="top" onclick="addItemDtl();" class="button_style btn btn-sm btn-primary" data-original-title="?????????? ???????? ??????????" data-toggle="tooltip" data-placement="bottom" style="font-weight: bold;font-size: 15px;padding-bottom: 6px;padding-top: 6px;margin-top: 26px;" data-toggle="modal" data-target="#x"><i class="fa fa-save"> ??????</i></button>
                                    </div> 
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-6 col-xs-6">
                                            <div class="chosen-select-single mg-b-20 table-responsive">
                                                <label></label>                                    
                                                <table class="table table-striped jambo_table bulk_action table-bordered" style="text-align: center;">                                                    
                                                    <thead>
                                                        <tr style="background-color: #131e33;color: white;">                                                                            
                                                            <th style="text-align: center;">?????? ??????????</th>
                                                            <th style="text-align: center;">?????? ??????????</th>
                                                            <th style="text-align: center;">?????????? ?????????? ????????????????</th>
                                                            <th style="text-align: center;">?????????? ?????????? ??????????????????????</th>
                                                            <th style="text-align: center;">???????????? ??????????</th>
                                                            <th style="text-align: center;width: 5%;" colspan="2"></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody class="customTable" id="itemsTableData"> 

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>



                                    </div>
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

    <!-- Search_combo -->
    <script src="webDesign/vendors/search_select/select2.js"></script>

    <!-- iCheck -->
    <script src="webDesign/vendors/iCheck/icheck.min.js"></script>
    <!-- Switchery -->
    <script src="webDesign/vendors/switchery/dist/switchery.min.js"></script>

    <!-- PNotify -->
    <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
    <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
    <script src="A_notifyies.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>
    <script src="_1_0_0_0_9_Invo_Item_Tax_Unit_Join.js"></script>


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