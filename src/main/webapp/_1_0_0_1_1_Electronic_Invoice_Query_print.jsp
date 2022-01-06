

<%@page import="com.codeator.www._1_3_DB_daos.AppSubElemSpecAuth_DAO"%>
<%@page import="com.codeator.www._1_2_DB_entities.AppSubElemSpecAuth"%>
<%@page import="com.codeator.www._1_3_DB_daos.InvoAccUintDeptDao"%>
<%@page import="com.codeator.www._1_2_DB_entities.InvoAccUintDept"%>
<%@page import="java.util.List"%>
<%@page import="com.codeator.www._0_0_CodeatorLib.StringOp"%>
<%@page import="com.codeator.www._0_3_CodeatorLib.GeneralOperations.DateOp"%>
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

            //String employee_name = employee_session.getEmpAname();
            String deptOld = (String) request.getSession().getAttribute("deptOld");
            String sectionOld = (String) request.getSession().getAttribute("sectionOld");
            String searchType = (String) request.getSession().getAttribute("searchType");
            String fromDate = (String) request.getSession().getAttribute("fromDate");
            String toDate = (String) request.getSession().getAttribute("toDate");
            String createdDate_OR_issueDate = (String) request.getSession().getAttribute("createdDate_OR_issueDate");
            String Numbers_Of_Invoices = (String) request.getSession().getAttribute("Numbers_Of_Invoices");

            String inv_sp = (String) request.getSession().getAttribute("inv_sp");

            String lang = (String) request.getSession().getAttribute("lang");

            //String employee_name = employee_session.getEmpAname()+"-"+employee_session.getPerOrganizationStructureByOrgIdFrom().getOrgName()+"-"+employee_session.getPerOrganizationStructureByOrgIdFrom().getEmpBigBoss();
            List<AppSubElemSpecAuth> asesaList = new AppSubElemSpecAuth_DAO().getEmpSubTabElementsSpecAuthInSubTab("" + employee_session.getEmployeeId(), "_1_0_0_1_0_Electronic_Invoice_Query_AccessServlet");

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
    <!-- page content -->
    <%                    //List<PerDeptOld> deptList = new PerDeptOldDao().GetDeptByemployeeId("" + employee_session.getEmployeeId());

    %>

    <%                   // String deptName = (employee_session.getPerDeptOld() == null) ? "" : employee_session.getPerDeptOld().getDepName();//الوحدة
        //String SectionName = (employee_session.getPerDeptOld() == null) ? "" : employee_session.getPerDeptOld().getPerSectionOld().getSectionName();//القطاع
        String accUnitCode = employee_session.getAppAuthJavaUsers().getInvoAccUintDept().getId().getAccUnitCode();
        String sectionNoOld = (employee_session.getPerDeptOld() == null) ? "''" : "" + employee_session.getPerDeptOld().getId().getSectionNoOld() + "";
        String depNoOld = (employee_session.getPerDeptOld() == null) ? "''" : "" + employee_session.getPerDeptOld().getId().getDepNoOld() + "";
        List<InvoAccUintDept> invoAccUintDept = new InvoAccUintDeptDao().GetInvoAccUintInDept(sectionNoOld, depNoOld, accUnitCode);
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
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="UTF-8"><meta http-equiv='cache-control' content='no-cache'><meta http-equiv='expires' content='0'><meta http-equiv='pragma' content='no-cache'>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Load paper.css for happy printing -->
        <link rel="stylesheet" href="webDesign/sheets_printer/print_style.css" >
        <link rel="stylesheet" href="webDesign/sheets_printer/paper.css">
        <link rel="stylesheet" href="webDesign/sheets_printer/normalize.css">

        <!-- Set page size here: A5, A4 or A3 -->
        <!-- Set also "landscape" if you need -->
        <style>@page {
                size: A4 portrait;
                margin-top: 8px;
                margin-bottom: 10px;
                margin-left: 20px;
            }</style>
        <style>
            /* Three image containers (use 25% for four, and 50% for two, etc) */
            .column {
                float: left;
                padding: 5px;
            }

            /* Clear floats after image containers */
            .row::after {
                content: "";
                clear: both;
                display: table;
            }

            table tbody tr td {
                padding: 2px !important;
                line-height: 1.35 !important;
            }

            @media print {
                .box-body {
                    margin-top: 10px !important;
                    margin-bottom: 10px;
                }
            }

            table tbody tr td {
                border-top: 1px solid #9e9e9e;
                line-height: 1.5;
                padding: 8px;
                vertical-align: top
            }

        </style>

        <script>
            /*window.onload = function () {
             window.print();
             window.top.close();
             
             }*/
        </script>
        <style>
            .center-me {
                font-size: 15px;
                margin: auto;
                height: 10px;
                max-width: 500px;
                margin: 75px auto 40px auto;
                display: flex;
            }
            .deletedWaterMark{
                background-image: url('webDesign/production/images/MultiDeleted.png');
                background-repeat: repeat-y;
                background-size: 100%;
            }
        </style>
    </head>
    <!-- Set "A5", "A4" or "A3" for class name -->
    <!-- Set also "landscape" if you need -->
    <body class="A4 portrait" style="direction: rtl;">

        <!-- Each sheet element should have the class "sheet" -->
        <!-- "padding-**mm" is optional: you can set 10, 15, 20 or 25 -->
        <script>
            function printAssessment() {
                //alert("Print the little page");
                window.print();
            }
        </script>
        <%
            int Numbers_Of_Invoices_int = Integer.parseInt(Numbers_Of_Invoices);
            for (int i = 0; i < Numbers_Of_Invoices_int; i++) {
                String invoice_index = (Numbers_Of_Invoices_int == 1) ? "" : "" + i;
        %>
        <section class="sheet" id="content-print<%=invoice_index%>">
            <style>
                table {
                    /*border-collapse: unset !important;*/
                }

                .invoice_lines td {
                    /*border-collapse: unset !important;*/
                    text-align: right;
                }

                .invoice_lines .serial {
                    /*border-collapse: unset !important;*/
                    text-align: center;
                }

            </style>

            <div class="box-body" id="box_data" style="display: flex;padding: 5px 10px 0 10px;margin-bottom: -21px;">
                <div style="width: 100%;padding-right: 10px;" class="col-md-12">
                    <div class="row">
                        <div class="col-lg-8" style="width: 70%;">

                            <a href="#"><p style="font-size: 12px;margin: 0;padding: 0;" onclick="printAssessment();"><img src="webDesign/Resources/images/Codeator_Logo.png" width="150px"></p></a>
                            <h5 style="font-size: 20px;margin-bottom: 15px;margin-top: 0px;font-weight: bold;">مؤسسة الأهرام</h5>
                            <h5 style="font-size: 20px;margin-bottom: 15px;margin-top: 0px;font-weight: bold;">المركز الضريبي لكبار الممولين</h5>
                            <p style="font-size: 12px;margin: 0;padding: 0;font-weight: bold;font-size: 15px;">رقم التسجيل الضريبي</p>
                            <p style="font-size: 12px;margin: 0;padding-top: 3px;font-weight: bold;font-size: 15px;" id="Ahram_id<%=invoice_index%>"></p>
                            <p style="font-size: 12px;margin: 0;padding: 0;display: none;">رقم تليفون</p>
                            <p style="font-size: 12px;margin: 0;padding-top: 5px;direction: ltr;float:right;display: none;" id="tel_Div<%=invoice_index%>"></p>
                            <br>
                        </div>
                        <div class="col-lg-4" style="width: 30%;padding-left: 20px;">
                            <h4 id="documentType<%=invoice_index%>" style="text-align: center;margin-bottom: -15px;"></h4>
                            <h5 id="dept_Name<%=invoice_index%>" style="text-align: center;font-weight: bold;font-size: 15px;"></h5>
                        </div>

                    </div>
                    <div class="" style="display: flex;margin-top: -62px;">
                        <div style="width:40%"></div>
                        <div style="width:60%">
                            <table border="1" >
                                <tr class="" style="background: rgba(217,225,242,1.0)!important;-webkit-print-color-adjust: exact;">
                                    <!--<td style="font-size: 14px;"  class="db text-center" width="30%">
                                        التاريخ الفعلي للفاتورة
                                    </td>-->
                                    <td style="font-size: 14px;"  class="db text-center" width="30%">
                                        تاريخ الفاتورة المرسل للضرائب
                                    </td>
                                    <td style="border-left: none;font-size: 14px;" class="db text-center" width="40%">
                                        رقم الفاتورة
                                    </td>
                                </tr>
                                <tr>
                                    <!--<td style="font-size: 12px;" id="invoRealDate" class="db text-center"></td>-->
                                    <td style="font-size: 12px;" id="invoice_datetime<%=invoice_index%>" class="db text-center"></td>
                                    <td style="font-size: 12px;" id="invoice_internalId<%=invoice_index%>" class="db text-center"></td>
                                </tr>
                            </table>
                        </div>

                    </div>

                    <%
                        if (RecieveDevliverCodeStstus) {
                    %>
                    <br>
                    <br>
                    <br>
                    <div class="" style="display: flex;margin-top: -62px;">
                        <div style="width:40%"></div>
                        <div style="width:60%">
                            <table border="1" >
                                <tr class="" style="background: rgba(217,225,242,1.0)!important;-webkit-print-color-adjust: exact;">
                                    <td style="border-left: none;font-size: 14px;" class="db text-center" width="30%">
                                        تاريخ اذن التسليم والصرف
                                    </td>
                                    <td style="font-size: 14px;"  class="db text-center" width="100px" width="30%">
                                        كود إذن التسليم
                                    </td>
                                    <td style="border-left: none;font-size: 14px;" class="db text-center" width="40%">
                                        كود إذن الصرف
                                    </td>                                    
                                </tr>
                                <tr>
                                    <td style="font-size: 12px;" id="permToReceiveDate1<%=invoice_index%>" class="db text-center"></td>
                                    <!--<td style="font-size: 12px;" id="permToDeliverDate1<%=invoice_index%>" class="db text-center"></td>-->
                                    <td style="font-size: 12px;" id="permToReceiveCode1<%=invoice_index%>" class="db text-center"></td>
                                    <td style="font-size: 12px;" id="permToDeliverCode1<%=invoice_index%>" class="db text-center"></td>

                                </tr>
                            </table>
                        </div>

                    </div>
                    <%
                        }
                    %>
                    <br>

                    <table width="100%" border="1">
                        <tr style="background: rgba(217,225,242,1.0)!important;-webkit-print-color-adjust: exact;">
                            <th class="text-center" colspan="4" style="width: 25%;">بيانات العميل</th>
                        </tr>
                        <tr>
                            <th style="width: 10%;font-size: 12px;background: rgba(217,225,242,1.0) !important;-webkit-print-color-adjust: exact;">إسم العميل</th>
                            <th id="receiver_name<%=invoice_index%>" style="text-align: right;width: 40%;"></th>

                            <th style="width: 15%;font-size: 12px;background: rgba(217,225,242,1.0)!important;-webkit-print-color-adjust: exact;" id="id_name<%=invoice_index%>"></th>
                            <th id="receiver_id<%=invoice_index%>" style="text-align: right;width: 40%;"></th>
                        </tr>
                        <tr>
                            <th style="width: 10%;font-size: 12px;background: rgba(217,225,242,1.0)!important;-webkit-print-color-adjust: exact;">عنوان العميل</th>
                            <th id="receiver_address<%=invoice_index%>" style="text-align: right;" colspan="3"></th>
                        </tr> 
                        <%
                            if (!(AccUintDept.equals("20") || AccUintDept.equals("02"))) {
                        %>
                        <tr>
                            <th style="width: 10%;font-size: 12px;background: rgba(217,225,242,1.0)!important;-webkit-print-color-adjust: exact;">الخدمة</th>
                            <th id="serviceName<%=invoice_index%>" style="text-align: right;" colspan="3"></th>
                        </tr>
                        <%
                            }
                        %>
                        <tr>
                            <th style="width: 10%;font-size: 12px;background: rgba(217,225,242,1.0)!important;-webkit-print-color-adjust: exact;"></th>
                            <th id="notes<%=invoice_index%>" style="text-align: right;" colspan="3"></th>
                        </tr>
                    </table>
                    <br>
                    <table width="100%" border="1px" id="tableID<%=invoice_index%>">
                        <thead>
                            <tr style="background: rgba(217,225,242,1.0)!important;border: 1.5px solid black;-webkit-print-color-adjust: exact;" id="table_head<%=invoice_index%>">
                                <th class="text-center">
                                    #
                                </th>
                                <th class="text-center" colspan="3">
                                    كود الصنف
                                </th>
                                <th class="text-center" colspan="3">
                                    توصيف الصنف
                                </th>
                                <th class="text-center">
                                    الكمية
                                </th>
                                <th class="text-center">
                                    سعر الوحدة
                                </th>
                                <th class="text-center">
                                    الخصم
                                </th>
                                <th class="text-center">
                                    الضريبة
                                </th>
                                <th class="text-center">
                                    إجمالي السعر
                                </th>
                            </tr>
                        </thead>
                        <tbody class="invoice_lines" id="invoice_lines<%=invoice_index%>" style="text-align: right;">
                            <!--<tr>
                                <td class="serial">1</td>
                                <td colspan="3">iPhone xs Plus</td>
                                <td>20000</td>
                                <td>1</td>
                                <td>10</td>
                                <td>
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td>ضريبة قيمة مضافة : 14%</td>
                                                <td>50 ج.م</td>
                                            </tr>
                                            <tr>
                                                <td>ضريبة قيمة مضافة : 14%</td>
                                                <td>50 ج.م</td>
                                            </tr>
                                        </tbody> 
                                    </table>
                                </td>
                                <td>20000</td>
                            </tr>

                            <tr style="background: rgba(217,225,242,1.0);">
                                <td>Tax</td>
                                <td>7%</td>
                                <td>Discount</td>
                                <td>5%</td>
                                <td colspan="2">Total Amount</td>
                                <td colspan="1">5741</td>
                            </tr>
                            <tr style="background: rgba(217,225,242,1.0);">
                                <td colspan="2">401.87</td>
                                <td colspan="2">287.05</td>
                                <td colspan="2">Final Amount</td>
                                <td>5855.82</td>
                            </tr>-->
                        </tbody>
                        <tfoot style="border: black !important;">
                            <tr>
                                <td colspan="12" style="text-align: right;" id="colsapnChange<%=invoice_index%>">
                                    <span>
                                        <br>
                                        <span style="
                                              border: 1px solid #9e9e9e;
                                              padding: 5px;
                                              font-size: 15px;
                                              margin-right: 20px;
                                              ">ما عدا السهو والخطأ</span>

                                        <br>
                                        <br>
                                        <span style="
                                              padding: 5px;
                                              font-size: 15px;
                                              ">
                                            استلمت الفاتورة المحتسب قيمتها طبقا للأسعار المتفق عليها مع
                                            <span id="dept_Name1<%=invoice_index%>"></span>
                                        </span>
                                        <br>

                                        <span  style="
                                               padding: 5px;
                                               font-size: 15px;
                                               ">
                                            <table>
                                                <tbody>
                                                    <tr>
                                                        <td style="text-align: right;border-top: 0px white;width: 10%;">اسم المستلم :</td>
                                                        <td style="text-align: right;border-top: 0px white;width: 20%;">...................................</td>

                                                        <td style="text-align: right;border-top: 0px white;width: 6%;">توقيعه :</td>
                                                        <td style="text-align: right;border-top: 0px white;width: 18%;">..............................</td>

                                                        <td style="text-align: right;border-top: 0px white;width: 6%;">الصفة :</td>
                                                        <td style="text-align: right;border-top: 0px white;width: 17%;">.............................</td>

                                                        <td style="text-align: right;border-top: 0px white;width: 10%;">تاريخ الإستلام :</td>
                                                        <td style="text-align: right;border-top: 0px white;">...................</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </span>

                                    </span>

                                    <br>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                                        <tr>
                                            <td width="19%" rowspan="3" valign="top"><strong class="asd"> &nbsp;<br></strong></td>
                                            <td width="65%" align="center" valign="top" style="text-align: center;">
                                                <span id="dept_Name2<%=invoice_index%>"></span>
                                                <br>
                                                <span id="">شارع الصحافة من شارع الجلاء</span>
                                                <br>
                                                <span id="contact<%=invoice_index%>">ت: 25786775  -  فاكس: 27704386</span>
                                                <br>
                                                <span>ت.إنشاء الفاتورة <span id="invoice_createdate<%=invoice_index%>"></span><span> -- </span> ت.الفاتورة الفعلي <span id="invoRealDate<%=invoice_index%>"></span></span>
                                                <br>
                                                <span>تاريخ الطباعة <%=new StringOp().ConvertNumFromEnToAr(new DateOp().getCustomSysDate("yyyy/MM/dd - hh:mm a"), lang)%></span>

                                            </td>
                                            <td width="16%" valign="top">
                                                <h5 style="margin-bottom: 0;">
                                                    <!--<img src='webDesign/production/images/sign.png'>-->
                                                    <span style="text-decoration: dashed; padding-left: 100%;color: #000; border-bottom: 1px solid black;"></span>
                                                </h5>
                                                <h5 class="text-center"
                                                    style="margin-top: 5px;">Signature and Seal</h5>
                                                <br>
                                                <br>
                                            </td>
                                        </tr>
                                    </table>
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" style="direction: ltr;">
                                        <tr>
                                            <td style="direction: ltr;width: 5%;vertical-align: middle;"><img src="webDesign/Resources/images/Codeator_Logo.png" width="100%"></td>
                                            <td style="direction: ltr;width: 95%;vertical-align: middle;font-size: 10px;">Copyrights © <%=new DateOp().getCustomSysDate("yyyy")%> CODEATOR All rights reserved.</td>
                                            <td style="direction: ltr;" id="footer_internal_id<%=invoice_index%>"></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>

                        </tfoot>
                    </table>

                    <br>
                    <br>


                </div>

            </div>

        </section>
        <%
            }
        %>

        <!-- jQuery -->
        <script>var RecieveDevliverCodeStstus = <%=RecieveDevliverCodeStstus%>;</script><!--المبيعات -->
        <script>var calcUnitAndMinimumStatus = <%=calcUnitAndMinimumStatus%>;</script><!-- أماك-->
        <script src="webDesign/vendors/jquery/dist/jquery.min.js"></script>
        <script src="webDesign/yla_Nf2t.js"></script>
        <script src="_1_0_0_1_1_Electronic_Invoice_Query_print.js"></script>

        <script>
            setLang('<%=lang%>');
            <%
                if (searchType.equals("bulk")) {
            %>
            getInvoice2(accUnitId, deptId, sectionId, '<%=searchType%>', '<%=fromDate%>', '<%=toDate%>', '<%=createdDate_OR_issueDate%>');
            <%
            } else {
            %>
            getInvoice(accUnitId, deptId, sectionId, '<%=inv_sp%>');
            <%
                }
            %>
        </script>
    </body>
</html>
<%                        } else {
            response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("_0_0_0_0_0_1_login_AccessServlet");
    }

    new HibernateSessionCon().clearConn();
%>