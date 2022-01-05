<%-- 
    Document   : _0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>

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

        <title>طلب سيارة</title>
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

                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_right">
                                <h3 style="font-weight: bold;"> طلب سيارة</h3>
                            </div>
                        </div>
                        <div class="clearfix"></div>




                        <!--card Start -->
                        <div class="x_panel" style="box-shadow: -1px 2px 5px 1px #929292;">
                            <!-- for Edit -->
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <button type="button" class="btn btn-custon-rounded-three btn-warning" onclick="getVcleVcleRequests();" href="#" data-toggle="modal" data-target=".SubmitedRequests" style="background: #77bbff;border-color:  #77bbff;"><i class="fa fa-exclamation-triangle adminpro-warning-danger" aria-hidden="true"></i> الطلبات المرسلة</button>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
                                    <label class="control-label" style="font-size: 15px;">التاريخ</label>
                                    <input type="date" class="form-control" name="requireDate" id="requireDate" min="<%=new DateOp().getCustomSysDate("yyyy-MM-dd")%>" value="" required="">
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" >
                                    <label class="control-label" style="font-size: 15px;">التوقيت</label>                                                                  
                                    <input type="time" class="form-control" name="requireStartHour" id="requireStartHour" value="" required="">
                                </div>

                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" ></div> 
                                <input type="hidden" class="form-control" min="1" name="DepNoOld" id="DepNoOld" value="<%=employee_session.getPerDeptOld().getId().getDepNoOld()%>" required="" readonly="">
                                <div class="col-lg-3 col-md-4 col-sm-6 col-xs-6" >
                                    <label class="control-label" style="font-size: 15px;">الإدارة</label>
                                    <input type="text" class="form-control" name="DepName" id="DepName" value="<%=employee_session.getPerDeptOld().getDepName()%>" required="" readonly="">
                                </div>

                                <input type="hidden" class="form-control" min="1" name="SectionNoOld" id="SectionNoOld" value="<%=employee_session.getPerDeptOld().getId().getSectionNoOld()%>" required="" readonly="">
                                <div class="col-lg-3 col-md-4 col-sm-6 col-xs-6" >
                                    <label class="control-label" style="font-size: 15px;">قسم</label>                                                                   
                                    <input type="text" class="form-control" name="SectionName" id="SectionName" value="<%=employee_session.getPerDeptOld().getPerSectionOld().getSectionName()%>" required="" readonly="">
                                </div>

                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
                                    <label class="control-label" style="font-size: 15px;">اسم طالب السيارة</label>
                                    <select data-placeholder="Choose a Country..." name="EmployeeId" id="EmployeeId" class="form-control" tabindex="-1" required="">
                                        <option value="">اختر طالب السيارة ...</option>
                                        <%
                                            List<PerEmploymentMaster> pList2 = new PerEmploymentMasterDao().GetEmployeesByDept_ID("" + employee_session.getPerDeptOld().getId().getSectionNoOld(), "" + employee_session.getPerDeptOld().getId().getDepNoOld());
                                            for (PerEmploymentMaster p : pList2) {
                                        %>                                                                        
                                        <option value="<%=p.getEmployeeId()%>"><%=p.getEmpAname()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-lg-2 col-md-4 col-sm-6 col-xs-6" >
                                    <label class="control-label" style="font-size: 15px;">عدد الركاب</label>                                                                   
                                    <input type="text" class="form-control" onchange="getVcleTypeAJAX();" name="guestNo" id="guestNo" value="1" required="">
                                </div>

                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" >
                                    <label class="control-label" style="font-size: 15px;">نوع المركبة</label>
                                    <select data-placeholder="اختر نوع المركبة ..." name="VcleType" id="VcleType" class="form-control" required="">     
                                        <option value="">اختر نوع المركبة ...</option>
                                    </select>

                                </div>

                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" >
                                    <label class="control-label" style="font-size: 15px;">مكان مقابلة السائق</label>                                                                   
                                    <input type="text" class="form-control" name="driverPlace" id="driverPlace" placeholder="الجراج"  >
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" >
                                    <label class="control-label" style="font-size: 15px;">نوع الطلب</label>
                                    <select data-placeholder="اختر نوع الطلب ..." name="requireType" id="requireType"  class="form-control" tabindex="-1" required="">     
                                        <option value="">اختر نوع الطلب ...</option>
                                        <option value="1" selected>مذكرة</option>
                                        <option value="2">طوارئ</option>
                                        <option value="3">دوري</option>
                                    </select>
                                </div>

                                <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6" >
                                    <label class="control-label" style="font-size: 15px;">عدد أيام الرحلة</label>                                                                   
                                    <input type="number" class="form-control" name="no_of_days" min="1" value="1" id="no_of_days" onchange="checkAlert()" placeholder="عدد أيام الرحلة"  >
                                </div>

                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="WarningDiv" style="display: none;">
                                    <label class="control-label" style="font-size: 15px;">تحذير</label>
                                    <div class="alert alert-warning alert-st-three" style="" role="alert">                                                                
                                        <p class="message-mg-rt">
                                            <strong style="color: black;">تحذير : </strong>
                                            <br> عدد أيام الرحلة أكبر من يوم <br> وبناءا عليه حساب التكلفة متوقف على <br> المسافة <br> و إجمالي عدد الساعات <br> وسعر الكيلو متر  <br> و المبيت
                                            <i class="fa fa-exclamation-triangle adminpro-warning-danger admin-check-pro" aria-hidden="true"></i>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                                    <label class="control-label" style="font-size: 15px;">خط سير السيارة</label>                  
                                    <input type="text" class="form-control" name="requirePlace" id="requirePlace" placeholder="خط سير السيارة" >
                                </div>

                                <div class="col-lg-12 col-md-4 col-sm-4 col-xs-12">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="i-checks pull-right">
                                            <label><input type="radio" id="S1" value="option1" checked="" name="a"> <i></i>العودة</label>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="i-checks pull-right">
                                            <label><input type="radio" id="S2" value="option2" name="a"> <i></i>إختيار ساعة العودة</label>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" id="Search2">
                                        <label class="control-label" style="font-size: 15px;">التوقيت</label>
                                        <div class="input-group date">                                                                    
                                            <input type="time" name="RequireEndHour" id="RequireEndHour" class="form-control" value="">
                                            <span class="input-group-addon" style="border: 1px solid #e5e6e7;"><i class="fa fa-clock-o"></i></span>
                                        </div>
                                    </div>
                                </div> 



                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group" id="SubmitBtn">                                            
                                    <button type="button" data-placement="top" onclick="addToVcleVehicleRequire('<%=employee_session.getPerDeptOld().getId().getDepNoOld()%>', '<%=employee_session.getPerDeptOld().getId().getSectionNoOld()%>');" class="button_style btn btn-sm btn-primary button_position fa fa-save" style="box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;" data-toggle="modal" data-target="#x"> حفظ</button>
                                </div>

                            </div>
                            <!-- /for Edit -->
                        </div>
                        <!--card Start -->







                    </div>

                    <!-- Modal -->
                    <div class="modal fade SubmitedRequests" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <div id="Header1" class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel21" style="font-size: 30px;">الطلبات المرسلة من إدارة <%=employee_session.getPerDeptOld().getDepName()%></h4>
                                </div>

                                <div class="modal-body" style="direction: rtl;">
                                    <div class="row" >
                                        <div class="chosen-select-single mg-b-20 table-responsive">
                                            <label style="font-size: 140%;">الطلبات</label>
                                            <table class="table table-striped table-bordered" style="text-align: center;">
                                                <thead>
                                                    <tr style="background-color: #337ab7;color: white;">                                                                            
                                                        <th style="text-align: center;">التاريخ</th>
                                                        <th style="text-align: center;">التوقيت</th>
                                                        <th style="text-align: center;">تفاصيل الطلب</th>                                                                                        
                                                        <th style="text-align: center;font-size: 140%;">حالة الطلب عند مسؤول الإدارة <span class="fa fa-user"></span></th>  
                                                        <th style="text-align: center;font-size: 140%;">حالة الطلب عند مسؤول النقل <span class="fa fa-car"></span></th> 
                                                        <th style="text-align: center;font-size: 140%;">حالة الرحلة <span class="fa fa-car"></span></th> 
                                                    </tr>
                                                </thead>
                                                <tbody id="vcleVcleRequires_Table">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                                <div id="Footer1" class="modal-footer" style="background-color: #131e33; direction: rtl;">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" style="font-weight: bold;border-color: black;width: 15%;">اغلاق</button>
                                </div>


                            </div>
                        </div>
                    </div>


                    <div class="modal fade RequestDetails" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-lg" style="border-style: solid;border-color: yellow;">
                            <div class="modal-content">

                                <div id="Header1" class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel21" style="font-size: 30px;">تفاصيل الطلب</h4>
                                </div>

                                <div class="modal-body" style="direction: rtl;">
                                    <div class="row" >
                                        <div class="chosen-select-single mg-b-20 table-responsive">
                                            <label>الطلبات</label>
                                            <table class="table table-striped table-bordered" style="text-align: center;">
                                                <thead>
                                                    <tr style="background-color: #337ab7;color: white;">                                                                            
                                                        <th style="text-align: center;">اسم طالب السيارة</th>
                                                        <th style="text-align: center;">عدد الركاب</th>
                                                        <th style="text-align: center;">مكان مقابلة السائق</th>
                                                        <th style="text-align: center;">نوع الطلب</th>   
                                                        <th style="text-align: center;">موعد العودة</th> 
                                                        <th style="text-align: center;">خط سير السيارة</th>  
                                                    </tr>
                                                </thead>
                                                <tbody id="vcleVcleRequireDT_Table">                                                                        
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>


                                </div>
                                <div id="Footer1" class="modal-footer" style="background-color: #131e33; direction: rtl;">
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
            <div class="modal fade rmrk" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <div class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel2" style="font-size: 30px;">سبب الرفض</h4>
                        </div>
                        <div class="modal-body" >
                            <div id="vcleVcleRequiresRmrk_DIV">

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
    <script src="_0_0_0_2_1_Car_Request.js"></script>
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