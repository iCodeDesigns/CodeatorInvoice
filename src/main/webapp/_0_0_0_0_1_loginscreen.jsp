<%-- 
    Document   : _0_0_0_1_loginscreen
    Created on : Dec 26, 2019, 8:16:17 PM
    Author     : Mohamed
--%>

<%@page import="com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp"%>
<%@page import="com.codeator.www._1_1_DB_mainDao.HibernateSessionCon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    new HibernateSessionCon().OpenCon();
    try {
        String key = (String) request.getSession().getAttribute("OpenHTMLFile");
        if (key.equals("Open")) {
%>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8"><meta http-equiv='cache-control' content='no-cache'><meta http-equiv='expires' content='0'><meta http-equiv='pragma' content='no-cache'>
        <title>تسجيل الدخول</title>
        <link rel="shortcut icon" type="image/x-icon" href="webDesign/production/images/login.png">


        <link href="https://fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
        <link rel="stylesheet" href="LoginDesign/css/style_3.css">
        <!-- Bootstrap -->
        <link href="webDesign/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="webDesign/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="webDesign/vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- jQuery custom content scroller -->
        <link href="webDesign/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
        <!-- PNotify -->
        <link href="webDesign/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
        <link href="webDesign/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">

    </head>

    <body>


        <div style="background-color: white;min-height: 100%;font-family: 'Play', sans-serif;" class="col-lg-4 col-md-4 col-sm-4 col-xs-4 wrapper">
            <div class="">
                <!-- Tabs Titles -->
                <h2 class="active"></h2>

                <!-- Icon -->
                <div class="fadeInDown" style="text-align: center;">
                    <img src="webDesign/Resources/images/Codeator_Logo.png" id="icon" alt="User Icon" style="width:90%;" />
                </div>
            </div>
        </div>
        <div style="background-color: #851b36;min-height: 100%;font-family: 'Play', sans-serif;" class="col-lg-8 col-md-8 col-sm-8 col-xs-8 wrapper">
            <div class="fadeInDown2">
                <div id="formContent">
                    <!-- Tabs Titles -->
                    <h2 class="active fadeIn second">تسجيل الدخول</h2>

                    <!-- Login Form -->
                    <input type="text" id="username" class="fadeIn third" name="username" autocomplete="off"  placeholder="رقم تأمين الموظف">
                    <input type="password" id="password" class="fadeIn third" name="Password" autocomplete="off"  placeholder="كلمة المرور">
                    <input type="submit" style="margin-bottom: 20px;width: 85%;text-align: center;" onclick="login();" class="fadeIn fourth" value="تسجيل دخول">


                    <!-- Remind Passowrd -->


                    <!--<div>
                        <a href="http://10.2.141.191:7778/forms90/f90servlet?config=nwanew" target="_blank"><i class="fa fa-search-plus"></i></a>
                    </div>-->


                    <div class="fadeIn fourth">
                        <a Style="font-weight: bold;font-size: 15px;">Ver 3.9.4 النسخة الفعلية</a><br>
                        <a Style="font-weight: bold;font-size: 15px;">بتاريخ 01-01-2022</a>
                    </div>
                    <div id="formFooter" class="fadeIn fourth"><br>
                        Copyrights © <%=new DateOp().getCustomSysDate("yyyy")%> | <a class="underlineHover">Codeator</a>
                    </div>
                </div>
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
        <!-- PNotify -->
        <script src="webDesign/vendors/pnotify/dist/pnotify.js"></script>
        <script src="webDesign/vendors/pnotify/dist/pnotify.buttons.js"></script>
        <script src="_0_0_0_0_1_loginscreen.js"></script>
    </body>

</html>
<%                        } else {

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
