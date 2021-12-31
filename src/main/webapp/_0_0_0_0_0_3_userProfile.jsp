<%-- 
    Document   : _0_0_0_0_0_2_WelcomePage
    Created on : Dec 26, 2019, 8:15:55 PM
    Author     : Mohamed
--%>


<%@page import="com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp"%>
<%@page import="com.codeator.www._1_3_DB_daos.PerEmploymentMasterDao"%>
<%@page import="java.util.List"%>
<%@page import="com.codeator.www._0_2_CodeatorLib.Baisc_HTML_Generator.MainPageCode"%>
<%@page import="com.codeator.www._1_2_DB_entities.PerEmploymentMaster"%>
<%@page import="com.codeator.www._1_1_DB_mainDao.HibernateSessionCon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    new HibernateSessionCon().OpenCon();
    new HibernateSessionCon().clearConn();
    try {
        String key = (String) request.getSession().getAttribute("OpenHTMLFile");
        if (key.equals("Open")) {
            PerEmploymentMaster employee_session = (PerEmploymentMaster) request.getSession().getAttribute("employee_session");
            String employee_name = employee_session.getEmpAname();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="UTF-8"><meta http-equiv='cache-control' content='no-cache'><meta http-equiv='expires' content='0'><meta http-equiv='pragma' content='no-cache'>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>البيانات الشخصية</title>
        <link rel="shortcut icon" type="image/x-icon" href="webDesign/production/images/home.png">


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

        <!-- PNotify -->
        <link href="webDesign/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
        <link href="webDesign/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">

        <!-- bootstrap-wysiwyg -->
        <link href="webDesign/vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">

        <!-- bootstrap-daterangepicker -->
        <link href="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
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
                background: #851934;
                -webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
                -moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
                transition: all 0.3s ease 0s;
            }
            .button_position{
                margin-top: 32px;
                width: 100%;

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
                            <a href="_0_0_0_0_0_2_WelcomePage_AccessServlet" class="site_title">
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
                                    <a href="javascript:;" id="user_menu" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false" style="color: black;font-size: 20px;">
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










                <!-- page content https://howtodoinjava.com/hibernate/hibernate-example-of-insertselect-blob-from-database/-->

                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">

                        </div>


                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="title_right" style="direction: rtl;">
                                <h3> البيانات الشخصية</h3>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                                <div class="x_panel" style="box-shadow: -1px 2px 5px 1px grey;background-color: #1a3348;color: white;background-image: url('webDesign/production/images/template.jpg');">

                                    <div class="x_content" style="font-size: large;font-weight: bold;">
                                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 profile_left">
                                            <ul class="list-unstyled user_data">
                                                <div class="profile_img"><br>
                                                    <div id="crop-avatar">
                                                        <!-- Current avatar -->
                                                        <img class="img-responsive avatar-view" src="webDesign/production/images/user.png" alt="Avatar" title="Change the avatar" style="border: 5px groove white;">
                                                    </div>
                                                </div>
                                            </ul>
                                            <ul class="list-unstyled user_data">
                                                <li><i class="user-profile-icon"></i><%=employee_name%>
                                                </li>
                                            </ul>
                                            <br>

                                            <!-- start skills -->
                                            <div class="col-md-12 col-sm-12 col-lg-12 col-xs-12">
                                                <ul list-unstyled user_data">
                                                    <button type="button" class="fa fa-key btn btn-success" onclick="ResetChangePasswordModule();" data-toggle="modal" style="font-size: large;font-weight: bold;" data-target=".resetPasswordModal"> إعادة تعيين كلمة المرور </button>
                                                </ul>
                                            </div>
                                            <script>
                                                function ResetChangePasswordModule() {
                                                    document.getElementById("ModelBodyAndFooter").innerHTML = "<div class=\"modal-body\" id=\"resetPasswordBody\" style=\"background - color: white; direction: rtl;\">\n" +
                                                            "                                                                                            <div class=\"row\">\n" +
                                                            "                                                                                            <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group\" id=\"\">\n" +
                                                            "                                                                                                <label class=\"control-label\" style=\"font-size: 20px;\"> كلمة المرور الحالية</label>\n" +
                                                            "                                                                                                <input style=\"font-size: 15px;font-weight: bold;\" type=\"password\"  maxlength=\"15\" data-placement=\"bottom\" placeholder=\"رقم المرور الحالي\" id=\"oldPassword\" name=\"employeeId\" class=\"form-control\" required=\"\" value=\"\">\n" +
                                                            "                                                                                            </div>\n" +
                                                            "                                                                                            <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group\" id=\"\">\n" +
                                                            "                                                                                                <label class=\"control-label\" style=\"font-size: 20px;\"> كلمة المرور الجديدة</label>\n" +
                                                            "                                                                                                <input style=\"font-size: 15px;font-weight: bold;\" type=\"password\" onclick=\"clearReTypePasswordField();\" maxlength=\"15\" data-placement=\"bottom\" placeholder=\"رقم المرور الجديد\" id=\"newPassword\" name=\"employeeId\" class=\"form-control\" required=\"\" value=\"\">\n" +
                                                            "                                                                                            </div>\n" +
                                                            "                                                                                            <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group\" id=\"\">\n" +
                                                            "                                                                                                <label class=\"control-label\" style=\"font-size: 20px;\"> إعادة كلمة المرور الجديدة</label>\n" +
                                                            "                                                                                                <input style=\"font-size: 15px;font-weight: bold;\" type=\"password\" onkeyup=\"checkPasswordMatch();\" maxlength=\"15\" data-placement=\"bottom\" placeholder=\" إعادة رقم المرور الجديد\" id=\"reTypePassword\" name=\"employeeId\" class=\"form-control\" required=\"\" value=\"\">\n" +
                                                            "                                                                                            </div>\n" +
                                                            "                                                                                        </div>\n" +
                                                            "                                                                                        </div>\n" +
                                                            "                                                                                    <div id= \"Footer1\" class=\"modal-footer \" style=\"background-color: #131e33; direction: rtl;\">\n" +
                                                            "                                                                                        <button type=\"button\" class=\"btn btn-default\" onclick=\"ChangePass();\" style=\"font-weight: bold;border-color: black;width: 40%;\" id=\"ModalButton1\">تغيير كلمة المرور</button>\n" +
                                                            "                                                                                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" style=\"font-weight: bold;border-color: black;width: 40%;\">اغلاق</button>\n" +
                                                            "                                                                                        </div>";
                                                }

                                            </script>


                                        </div>


                                        <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12" style="background-color: #f5f7fa;border-style: groove;">
                                            <div class="profile_title" style="font-size: large;background-color: #f5f7fa;">                                               
                                                <ul class="col-md-12" style="font-size: large;background-color: #f5f7fa;">
                                                    <%
                                                        List<PerEmploymentMaster> pList = new PerEmploymentMasterDao().GetEmployeesByEmployee_ID("" + employee_session.getEmployeeId());
                                                        PerEmploymentMaster m = pList.get(0);
                                                        String AGovName1, BirthDate;
                                                        try {
                                                            BirthDate = "" + m.getBirthDate();
                                                        } catch (Exception ex) {
                                                            BirthDate = "لا يوجد تاريخ ميلاد";
                                                        }
                                                    %>
                                                    <li style="color: #0a57a7;font-weight: bold;"><i class="fa fa-calendar user-profile-icon" ></i> تاريخ الميلاد : <h style="color: black;"><%=BirthDate%>.</h2>
                                                        </li><br>

                                                        <%

                                                            String LocAddress;
                                                            try {
                                                                if (m.getPerLocationCode().getPerGovernorateCode().getAGovName() == null) {
                                                                    LocAddress = "لا يوجد عنوان مسجل";
                                                                } else {
                                                                    LocAddress = "" + m.getPerLocationCode().getPerGovernorateCode().getAGovName();
                                                                }
                                                            } catch (Exception ex) {
                                                                LocAddress = "لا يوجد عنوان";
                                                            }
                                                        %>
                                                        <li style="color: #0a57a7;font-weight: bold;"><i class="fa fa-map-marker user-profile-icon"></i> العنوان : <h style="color: black;"><%=LocAddress%>.</h2>
                                                            </li><br>

                                                            <%
                                                                String OrgunitName = "", OrgName = "";

                                                                try {
                                                                    OrgunitName = m.getPerDeptOld().getPerSectionOld().getSectionName();
                                                                } catch (Exception ex) {
                                                                    OrgunitName = "لا يوجد مستوى";
                                                                }
                                                                try {
                                                                    OrgName = m.getPerDeptOld().getDepName();
                                                                } catch (Exception ex) {
                                                                    OrgName = "لا يوجد مستوى";
                                                                }
                                                            %>
                                                            <li style="color: #0a57a7;font-weight: bold;"><i class="fa fa-bank user-profile-icon"></i> الإدارة : <h style="color: black;"><%=OrgunitName%> - <%=OrgName%>.</h2>
                                                                </li><br>

                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <br>
                                                                </ul>
                                                                </div>
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
                                                                        Copyrights © <%=new DateOp().getCustomSysDate("yyyy")%> <a href="">AMAC-AHRAM</a> All rights reserved.
                                                                    </div>
                                                                    <div class="clearfix"></div>
                                                                </footer>
                                                                <!-- /footer content -->



                                                                <div class="modal fade resetPasswordModal" tabindex="-1" role="dialog" aria-hidden="true" >
                                                                    <div class="modal-dialog modal-sm">
                                                                        <div class="modal-content">

                                                                            <div id="Header1" class="modal-header" style="background-color: #131e33;color: white;direction: rtl;">
                                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="opacity: 1;float: left;"><span aria-hidden="true" style="color: white;">×</span>
                                                                                </button>
                                                                                <h4 class="modal-title" id="myModalLabel21" style="font-size: 20px;">تغيير كلمة المرور</h4>
                                                                            </div>
                                                                            <div id="ModelBodyAndFooter">

                                                                                <!--////////////////////////////////////////////////////////////////////////////////////////////
                                                                                //////////////// Model Body's contents are in function ResetChangePasswordModule() /////////////////////////
                                                                                ////////////////////////////////////////////////////////////////////////////////////////////// -->


                                                                                <!--////////////////////////////////////////////////////////////////////////////////////////////
                                                                                //////////////// Model Footer's contents are in function ResetChangePasswordModule() /////////////////////////
                                                                                ////////////////////////////////////////////////////////////////////////////////////////////// -->
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <script>
                                                                    function clearReTypePasswordField() {
                                                                        document.getElementById("reTypePassword").value = "";
                                                                        document.getElementById("reTypePassword").style.backgroundColor = "";
                                                                        document.getElementById('newPassword').style.backgroundColor = "";
                                                                    }

                                                                    function checkPasswordMatch() {
                                                                        var newPassword = document.getElementById("newPassword").value;
                                                                        var reTypePassword = document.getElementById("reTypePassword").value;
                                                                        if (reTypePassword === newPassword) {
                                                                            document.getElementById("newPassword").style.backgroundColor = "#0080004a";
                                                                            document.getElementById("reTypePassword").style.backgroundColor = "#0080004a";
                                                                        } else {
                                                                            document.getElementById("newPassword").style.backgroundColor = "#ff00004d";
                                                                            document.getElementById("reTypePassword").style.backgroundColor = "#ff00004d";
                                                                        }
                                                                    }

                                                                    function ChangePass() {
                                                                        var oldPassword = document.getElementById("oldPassword").value;
                                                                        var newPassword = document.getElementById("newPassword").value;
                                                                        var reTypePassword = document.getElementById("reTypePassword").value;
                                                                        if (oldPassword === "" || oldPassword === null) {
                                                                            Warning("برجاء إدخال  كلمة المرور");
                                                                            document.getElementById('oldPassword').style.borderColor = "red";
                                                                            document.getElementById('newPassword').style.borderColor = "#737373";
                                                                            document.getElementById('reTypePassword').style.borderColor = "#737373";
                                                                            document.getElementById('oldPassword').focus();
                                                                        } else if (newPassword === "" || newPassword === null) {
                                                                            Warning("برجاء إدخال  كلمة المرور الجديدة ");
                                                                            document.getElementById('oldPassword').style.borderColor = "#737373";
                                                                            document.getElementById('newPassword').style.borderColor = "red";
                                                                            document.getElementById('reTypePassword').style.borderColor = "#737373";
                                                                            document.getElementById('newPassword').focus();
                                                                        } else if (reTypePassword === "" || reTypePassword === null) {

                                                                            Warning("برجاء اعد كتاية كلمة المرور الجديدة");
                                                                            document.getElementById('oldPassword').style.borderColor = "#737373";
                                                                            document.getElementById('newPassword').style.borderColor = "#737373";
                                                                            document.getElementById('reTypePassword').style.borderColor = "red";
                                                                            document.getElementById('reTypePassword').focus();
                                                                        } else if (newPassword !== reTypePassword) {

                                                                            Warning("كلمة المرور الجديدة واعادنها لا تتشابهتان");
                                                                            document.getElementById('newPassword').style.borderColor = "red";
                                                                            document.getElementById("reTypePassword").style.borderColor = "red";
                                                                            document.getElementById('oldPassword').style.borderColor = "#737373";
                                                                            document.getElementById('newPassword').focus();
                                                                            document.getElementById('newPassword').value = "";
                                                                            document.getElementById('reTypePassword').value = "";
                                                                        } else if (newPassword === oldPassword) {

                                                                            Warning("لا يمكن ان تكون كلمة المرور الجديد مشابهة للقديمة");
                                                                            document.getElementById('newPassword').style.borderColor = "red";
                                                                            document.getElementById("reTypePassword").style.borderColor = "red";
                                                                            document.getElementById('oldPassword').style.borderColor = "red";
                                                                            document.getElementById("reTypePassword").style.backgroundColor = "";
                                                                            document.getElementById('newPassword').style.backgroundColor = "";
                                                                            document.getElementById('oldPassword').focus();
                                                                            document.getElementById('newPassword').value = "";
                                                                            document.getElementById('reTypePassword').value = "";
                                                                            document.getElementById('oldPassword').value = "";
                                                                        } else {
                                                                            document.getElementById('oldPassword').style.borderColor = "#737373";
                                                                            document.getElementById('newPassword').style.borderColor = "#737373";
                                                                            document.getElementById("reTypePassword").style.borderColor = "#737373";
                                                                            var URL = "_0_0_0_0_0_3_userProfile_1_ChangePassword_AjaxServlet?emp_id=" + <%=employee_session.getEmployeeId()%> + "&newPassword=" + newPassword + "&userPwd=" + oldPassword;
                                                                            var xhttp = new XMLHttpRequest();
                                                                            xhttp.open("POST", URL, true);
                                                                            xhttp.send();
                                                                            xhttp.onreadystatechange = function () {
                                                                                if (xhttp.readyState === 4 && xhttp.status === 200) {
                                                                                    var message = xhttp.responseText;
                                                                                    if (message === "Success") {
                                                                                        Success("تمت العملية بنجاح");
                                                                                        document.getElementById("resetPasswordBody").innerHTML = "<img src=\"webDesign/production/images/Update.gif\" alt=\"\" border=1 height=80 width=80 style=';'></img>";
                                                                                        document.getElementById("ModalButton1").style.display = "none";
                                                                                    } else {
                                                                                        Error(message);
                                                                                    }
                                                                                }
                                                                            };
                                                                        }
                                                                    }



                                                                </script>









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
                                                                <!-- PNotify -->
                                                                <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
                                                                <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>

                                                                <!-- morris.js -->
                                                                <script src="webDesign/vendors/raphael/raphael.min.js"></script>
                                                                <script src="webDesign/vendors/morris.js/morris.min.js"></script>
                                                                <!-- bootstrap-progressbar -->
                                                                <script src="webDesign/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
                                                                <!-- bootstrap-daterangepicker -->
                                                                <script src="webDesign/vendors/moment/min/moment.min.js"></script>
                                                                <script src="webDesign/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>


                                                                <!-- Custom Theme Scripts -->
                                                                <script src="webDesign/build/js/custom.js"></script><script src="AuthJSm.js"></script>
                                                                <script type="text/javascript">
                                                                    function Success(Body) {
                                                                        new PNotify({
                                                                            title: "تمت",
                                                                            text: Body,
                                                                            type: 'success',
                                                                            styling: 'bootstrap3'
                                                                        });
                                                                    }
                                                                    function Error(Body) {
                                                                        new PNotify({
                                                                            title: "خطأ",
                                                                            text: Body,
                                                                            type: 'error',
                                                                            styling: 'bootstrap3'
                                                                        });
                                                                    }
                                                                    function Warning(Body) {
                                                                        new PNotify({
                                                                            title: "تحذير",
                                                                            text: Body,
                                                                            styling: 'bootstrap3'
                                                                        });
                                                                    }
                                                                </script>
                                                                </body>
                                                                </html>
                                                                <%                        } else {
                                                                            response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
                                                                        }
                                                                    } catch (Exception e) {
                                                                        response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
                                                                    }
                                                                    new HibernateSessionCon().clearConn();
                                                                    new HibernateSessionCon().closeConn();
                                                                %>