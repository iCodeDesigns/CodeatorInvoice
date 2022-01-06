<%-- 
    Document   : _0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

<%@page import="com.codeator.www._1_3_DB_daos.SupSuppliersInfoTestDao"%>
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

        <title>إحصائيات عن الموردين</title>
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

            .table-font-style{
                font-weight: bold;
                font-size: 15px;
                text-align: center;
            }
            /* خاص بعمل اسبان بجانب الفيلد وعمل دوران للزوايا */
            .searchCustom{
                background-color: #26b99a;
                /*border: black solid 2px;*/
                color: white;
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
                height: 500px; 
                overflow-x: hidden; 
                overflow-y: auto; 
                text-align:justify; 
            }

            /*.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th{
                padding: 0px;
                line-height: 1.42857143;
                vertical-align: top;
                border-top: 1px solid #ddd;
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
                    <div class="">
                        <div class="page-title">
                            <div class="title_right">
                                <h3 style="font-weight: bold;">إحصائيات عن الموردين</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <!--card Start -->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <!-- for Edit -->
                            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                <%
                                    long countRecords = new SupSuppliersInfoTestDao().GetCountRecords();
                                %>
                                <select id="pages" onchange="getSupSuppliersInfo();" class="form-control font-style">
                                    <%
                                        for (int i = 0, pages = 1; i <= countRecords; i += 1001, pages++) {
                                    %>
                                    <option value="<%=i%>">صفحة رقم <%=pages%></option>
                                    <%
                                        }
                                    %>

                                </select>

                            </div>

                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <table id="" class="table table-striped table-bordered table-hover">
                                    <thead style="background-color: #131e33;color: white;">
                                        <tr>
                                            <th style="text-align: center;font-size: 15px;width: fit-content">كود المورد</th>
                                            <th style="text-align: center;font-size: 15px;width: fit-content">اسم المورد</th>
                                            <th style="text-align: center;font-size: 15px;width: fit-content">السجل التجاري</th>
                                            <th style="text-align: center;font-size: 15px;width: fit-content">السجل الضريبي</th>
                                            <!--<th style="text-align: center;font-size: 15px;width: 10%">اسم المالك</th>-->
                                            <!--<th style="text-align: center;font-size: 15px;width: 5%">الفاكس</th>-->
                                            <th style="text-align: center;font-size: 15px;width: fit-content">الحالة</th>
                                            <!--<th style="text-align: center;font-size: 15px;width: 5%">التليفون</th>-->
                                            <!--<th style="text-align: center;font-size: 15px;width: 5%">العنوان</th>-->
                                            <!--<th style="text-align: center;font-size: 15px;width: 5%">الإيميل</th>-->
                                            <th style="text-align: center;font-size: 15px;width: fit-content">نوع المورد</th>
                                            <th style="text-align: center;font-size: 15px;width: fit-content">رقم السجل التجاري</th>
                                            <th style="text-align: center;font-size: 15px;width: fit-content">التقييم</th>
                                            <th style="text-align: center;font-size: 15px;width: fit-content">نسبة التقييم</th>
                                            <th style="text-align: center;font-size: 15px;width: fit-content">عروض المورد</th>
                                            <!--<th style="text-align: center;font-size: 15px;">النشاط</th>-->
                                            <th style="text-align: center;font-size: 15px;width: 5%">البيانات الشخصية</th>
                                            <th style="text-align: center;font-size: 15px;width: 5%;">تفاصيل</th>
                                        </tr>
                                    </thead>

                                    <!--<img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50>-->

                                    <tbody id="SupSuppliersInfo" style='height: 10px;'>
                                        <tr>
                                            <td colspan="13" style="text-align: center;"><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- /page content -->
                    </div>
                </div>

                <div id="" class="modal fade getSupplierInfoModel" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-md" style="height:border-box; width: 85%;border-style: solid; border-color: yellow;">
                        <div class="modal-content">
                            <div id="Header1" class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                </button>
                                <h4 class="modal-title" id="getSupplierInfoTitle" style="font-size: 30px;"></h4>
                            </div>
                            <div class="modal-body scroll" style="direction: rtl;">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <table class="table table-striped table-bordered table-hover" style="border-style: hidden;">
                                        <tbody class="table-font-style" style="width: fit-content;">
                                            <tr>
                                                <td style="font-size: 20px;text-align: right;border-style: hidden;">اسم المالك:</td>
                                                <td id="SuppFullName" style="font-size: 20px;text-align: right;border-style: hidden;color: #0068BA;"></td>
                                            </tr>
                                            <tr>
                                                <td style="font-size: 20px;text-align: right;border-style: hidden;">أرقام التليفون:</td>
                                                <td id="Telephones" style="font-size: 20px;text-align: right;border-style: hidden;color: #0068BA;"></td>
                                                <td style="font-size: 20px;text-align: right;border-style: hidden;">رقم الفاكس:</td>
                                                <td id="Fax" style="font-size: 20px;text-align: right;border-style: hidden;color: #0068BA;"></td>
                                            </tr>
                                            <tr>
                                                <td style="font-size: 20px;text-align: right;border-style: hidden;">الإيميل:</td>
                                                <td id="Email" style="font-size: 20px;text-align: right;border-style: hidden;color: #0068BA;"></td>
                                                <td style="font-size: 20px;text-align: right;border-style: hidden;">العنوان:</td>
                                                <td id="Address" style="font-size: 20px;text-align: right;border-style: hidden;color: #0068BA;"></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                    <table class="table table-striped table-bordered table-hover" style="text-align: center;font-size: 20px;font-weight: bold;">
                                        <thead style="background-color: #131e33;color: white;">
                                            <tr>
                                                <th style="width: 5%;text-align: center;">أنشطة المورد</th>
                                            </tr>
                                        <tbody id="activities" style="width: fit-content;">
                                        </tbody>
                                    </table>
                                </div>                                
                            </div>  
                            <div id="Footer1" class="modal-footer" style="background-color: #131e33; direction: rtl;">
                                <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">اغلاق</button>
                            </div>
                        </div>
                    </div>
                </div>


                <div id="" class="modal fade AllCateCodeGroupsModel" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-md" style="height:border-box; width: 85%;border-style: solid; border-color: yellow;">
                        <div class="modal-content">
                            <div id="Header1" class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                </button>
                                <h4 class="modal-title" id="AllCateCodeGroupsModelTitle" style="font-size: 30px;"></h4>
                            </div>
                            <div class="modal-body scroll" style="direction: rtl;">
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                    <table class="table table-striped table-bordered table-hover" style="width: fit-content;border-style: hidden;">
                                        <tbody class="table-font-style" style="width: fit-content;">
                                            <tr>
                                                <td style="text-align: right;border-style: hidden;">الإجمالي العام للعهد الشخصية:</td>
                                                <td id="TotalGroupsEmp" style="text-align: right;border-style: hidden;color: #0068BA;"></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align: right;border-style: hidden;">الإجمالي العام للعهد المكانية:</td>
                                                <td id="TotalGroupsDept" style="text-align: right;border-style: hidden;color: #0068BA;"></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align: right;border-style: hidden;">الإجمالي العام للعهد:</td>
                                                <td id="TotalGroupsAll" style="text-align: right;border-style: hidden;color: #0068BA;"></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">
                                    <table class="table table-striped table-bordered" style="text-align: center;">
                                        <thead style="background-color: #131e33;color: white;">
                                            <tr>
                                                <th style="text-align: center;font-size: 15px;width: 15%">كود المجموعة</th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">اسم المجموعة</th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">إجمالي العهد الشخصية:<br><span id="TotalGroupsEmp1"></span></th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">إجمالي العهد المكانية: <br><span id="TotalGroupsDept1"></span></th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">إجمالي العهد:<br><span id="TotalGroupsAll1"></span></th>
                                                <th style="text-align: center;font-size: 15px;width: 5%"></th>
                                            </tr>
                                        </thead>

                                        <!--<img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50>-->

                                        <tbody id="x">
                                            <tr>
                                                <td colspan="8" style="text-align: center;"><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>  
                            <div id="Footer1" class="modal-footer" style="background-color: #131e33; direction: rtl;">
                                <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">اغلاق</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="" class="modal fade AllCateCodeSectionsModel" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-md" style="height:border-box; width: 90%;border-style: solid; border-color: cyan;">
                        <div class="modal-content">
                            <div id="Header1" class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                </button>
                                <h4 class="modal-title" id="AllCateCodeSectionsModelTitle" style="font-size: 30px;"></h4>
                            </div>
                            <div class="modal-body scroll" style="direction: rtl;">
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                    <table class="table table-striped table-bordered table-hover" style="width: fit-content;border-style: hidden;">
                                        <tbody class="table-font-style" style="width: fit-content;">
                                            <tr>
                                                <td style="text-align: right;border-style: hidden;">الإجمالي العام للعهد الشخصية:</td>
                                                <td id="TotalSectionsEmp" style="text-align: right;border-style: hidden;color: #0068BA;"></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align: right;border-style: hidden;">الإجمالي العام للعهد المكانية:</td>
                                                <td id="TotalSectionsDept" style="text-align: right;border-style: hidden;color: #0068BA;"></td>
                                            </tr>
                                            <tr>
                                                <td style="text-align: right;border-style: hidden;">الإجمالي العام للعهد:</td>
                                                <td id="TotalSectionsAll" style="text-align: right;border-style: hidden;color: #0068BA;"></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 table-responsive">
                                    <table class="table table-striped table-bordered" style="text-align: center;">
                                        <thead style="background-color: #131e33;color: white;">
                                            <tr>
                                                <th style="text-align: center;font-size: 15px;width: 15%">كود القسم</th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">اسم القسم</th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">إجمالي العهد الشخصية:<br><span id="TotalSectionsEmp1"></span></th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">إجمالي العهد المكانية: <br><span id="TotalSectionsDept1"></span></th>
                                                <th style="text-align: center;font-size: 15px;width: 15%">إجمالي العهد:<br><span id="TotalSectionsAll1"></span></th> <!--<th style="text-align: center;font-size: 15px;width: 5%"></th>-->
                                            </tr>
                                        </thead>

                                        <!--<img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50>-->

                                        <tbody id="AllCateCodeSections">
                                            <tr>
                                                <td colspan="8" style="text-align: center;"><img src="webDesign/production/images/Spin-0.9s-200px.gif" alt="" border=1 height=50 width=50></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>  
                            <div id="Footer1" class="modal-footer" style="background-color: #131e33; direction: rtl;">
                                <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">اغلاق</button>
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
        <script src="_0_0_3_0_0_Sup_Suppliers_Info_Test.js"></script>

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