<%-- 
    Document   : _0_0_0_0_0_1_loginscreen
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
            request.getSession().invalidate();
%>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8"><meta http-equiv='cache-control' content='no-cache'><meta http-equiv='expires' content='0'><meta http-equiv='pragma' content='no-cache'>
        <title>تسجيل الدخول</title>
        <link rel="shortcut icon" type="image/x-icon" href="webDesign/production/images/login.png">


        <link href="https://fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
        <link rel="stylesheet" href="LoginDesign/css/style_2.css">
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

    <body style="background-color: black;font-family: 'Play', sans-serif;" >

        <div class="wrapper fadeInDown">

            <div id="formContent" >
                <!-- Tabs Titles -->
                <h2 class="active"></h2>

                <!-- Icon -->
                <div class="fadeIn first">
                    <img src="webDesign/production/images/vend.png" id="icon" alt="User Icon" style="width: 50%;"/>
                </div>

                <!-- Login Form -->
                <input type="text" id="username" class="fadeIn third" name="username" autocomplete=""  placeholder="اسم المستخدم">
                <input type="password" id="password" class="fadeIn third" name="Password"  placeholder="كلمة المرور">
                <input type="submit" style="font-weight: bold;box-shadow: 6px 5px 20px black;" onclick="login();" class="fadeIn fourth" value="تسجيل دخول" >


                <!-- Remind Passowrd -->


                <!--<div>
                    <a href="http://10.2.141.191:7778/forms90/f90servlet?config=nwanew" target="_blank"><i class="fa fa-search-plus"></i></a>
                </div>-->



                <div id="formFooter"><br>
                    Copyrights © <%=new DateOp().getCustomSysDate("yyyy")%> | <a class="underlineHover">AMAC</a> AHRAM 
                    <br>
                    <a class="underlineHover" href="_0_0_0_0_LoginAccesServlet">التوجه إلى النظام</a>
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
        <script src="_9_9_0_0_0_1_AdminLogin.js"></script>
        
    </body>

</html>
<%                        } else {

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
