/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getEmployeeNoOut(employeeNo) {
    document.getElementById("searchEmpId").value = employeeNo;
    getEmpDataAjaxDelay();
}


function getEmpDataAjaxDelay() {
    setTimeout(getEmpDataAjax, 500);
}
$('#chkLockDiv').hide();
function getEmpDataAjax() {
    document.getElementById("chkLockDiv").innerHTML = "";
    $('#chkLockDiv').hide();
    var employeeId = document.getElementById("searchEmpId").value;

    if (employeeId === "" || employeeId === null) {
        //Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("searchEmpData").innerHTML = "";
    } else {
        var URL = "_0_0_0_4_5_1_Employees_Auth_Ajax_1_getEmployeeData_AjaxServlet?"
                + "sectionId=" + sectionId
                + "&deptId=" + deptId
                + "&accUnitId=" + accUnitId
                + "&employeeId=" + employeeId
                + "&typeSearch=1";


        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                var chkLockStatus = "";
                if (message === "Not Exist") {
                    document.getElementById("searchEmpData").innerHTML = "رقم التأمين هذا غير موجود او غير مسجل  بإدارات في شئون العاملين";
                    document.getElementById("EmpAuthData").innerHTML = "";
                    $('#btnAddAcc').hide();
                    $('#chkLockDiv').hide();
                } else if (message.startsWith("NotInACC")) {
                    $('#btnAddAcc').show();
                    document.getElementById("EmpAuthData").innerHTML = "";
                    document.getElementById("searchEmpData").innerHTML = message.split(",?")[1];
                    chkLockStatus = message.split(",?")[2];
                } else if (message.startsWith("InACC")) {
                    $('#btnAddAcc').hide();
                    $('#chkLockDiv').show();
                    document.getElementById("searchEmpData").innerHTML = message.split(",?")[1];
                    getAvailableScreens();
                    chkLockStatus = message.split(",?")[2];
                }
                var lable = "";
                var checked = "";
                if (chkLockStatus === "1") {
                    checked = ("true") ? " checked " : "";
                    lable = "الموظف متاح دخوله إلى النظام";
                    document.getElementById("chkLockDiv").innerHTML = "<td colspan=\"3\"><input id='chkLock' type=\"checkbox\" onchange='lockOrUnlock();' value='' class=\"js-switch\" " + checked + "/> " + lable + "";
                } else {
                    lable = "الموظف لا يستطيع الدخول إلى النظام";
                    document.getElementById("chkLockDiv").innerHTML = "<td colspan=\"3\"><input id='chkLock' type=\"checkbox\" onchange=\"lockOrUnlock();\" value='' class=\"js-switch\" " + checked + "/> " + lable + "";
                }
            }
        };
    }
}
function ResetModal() {
    document.getElementById("searchEmpName").value = "";
    document.getElementById("EmpDataSearchResult").innerHTML = "";
}

function getEmpDataByNameSearchDelay() {
    setTimeout(getEmpDataByNameSearch, 500);
}
function getEmpDataByNameSearch() {
    var searchEmpName = document.getElementById("searchEmpName").value;
    var searchEmpNameArr = searchEmpName.split(" ");
    if (searchEmpName === "" || searchEmpName === null) {
        //Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("EmpDataSearchResult").innerHTML = "";
    } else if (searchEmpNameArr.length < 4) {
        document.getElementById("EmpDataSearchResult").innerHTML = "";
    } else {
        var URL = "_0_0_0_4_5_0_Employees_Rewards_Ajax_7_getEmployeesData_AjaxServlet?";

        URL += "searchEmpName=" + searchEmpName;
        URL += "&deptId=" + deptId;
        URL += "&sectionId=" + sectionId;
        URL += "&accUnitId=" + accUnitId;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                    document.getElementById("EmpDataSearchResult").innerHTML = "";
                } else {
                    document.getElementById("EmpDataSearchResult").innerHTML = message;
                }
            }
        };
    }
}

$('#btnAddAcc').hide();
function getAvailableScreens() {
    $("#btnAddAcc").hide();
    var employee_no = document.getElementById("searchEmpId").value;
    var searchEmpData = document.getElementById("searchEmpData").innerHTML;
    if (!(searchEmpData === "" || searchEmpData === "لا توجد بيانات موظف")) {
        if (employee_no === "" || employee_no === null) {
            //Warning("برحاء ادخال تأمين الموظف");
            document.getElementById("EmpAuthData").innerHTML = "";
        } else {
            var URL = "_0_0_0_4_5_1_Employees_Auth_Ajax_2_getEmployeesAuth_AjaxServlet?"
                    + "sectionId=" + sectionId
                    + "&deptId=" + deptId
                    + "&accUnitId=" + accUnitId
                    + "&employeeId=" + employee_no;

            var xhttp = new XMLHttpRequest();
            xhttp.open("POST", URL, true);

            xhttp.send();

            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4 && xhttp.status === 200) {
                    var message = xhttp.responseText;
                    if (message === "Error") {
                        Error("حدث خطأ");
                        document.getElementById("EmpAuthData").innerHTML = "";
                    } else {
                        document.getElementById("EmpAuthData").innerHTML = message;
                        switchCheck();
                        ShowBTN();
                    }
                }
            };
        }
    }
}
function ShowBTN() {
    var sub_tab_id = document.getElementsByClassName("sub_tab_id2");
    if (sub_tab_id.length > 0) {
        document.getElementById("saveAuthBtn2").disabled = false;
    } else {
        document.getElementById("saveAuthBtn2").disabled = true;
    }
}
function SaveAuth2() {
    var searchEmpId = document.getElementById("searchEmpId").value;
    var searchEmpData = document.getElementById("searchEmpData").innerHTML;
    if (searchEmpId === "" || searchEmpId === null) {
        Warning("برجاء إدخال رقم الموظف");
    } else if (searchEmpData === "" || searchEmpData === "لا توجد بيانات موظف") {
        Warning("رقم الموظف غير موجود");
    } else {
        var url = "";
        var sub_tab_id = document.getElementsByClassName("sub_tab_id2");
        for (var i = 0; i < sub_tab_id.length; ) {
            url += "sub_tab_id=" + sub_tab_id[i].innerHTML + "&";
            i = i + 1;
        }
        var AuthChecked = document.getElementsByName("cheackBox2");
        for (var i = 0; i < AuthChecked.length; ) {
            url += "AuthChecked=" + AuthChecked[i].checked + "&";
            i = i + 1;
        }
        var primaryAuthPass = document.getElementsByName("primaryAuthPass2");
        for (var i = 0; i < primaryAuthPass.length; ) {
            if (i < primaryAuthPass.length - 1) {
                url += "primaryAuthPass=" + primaryAuthPass[i].value + "&";
            } else {
                url += "primaryAuthPass=" + primaryAuthPass[i].value;
            }
            i = i + 1;
        }
        var URL = "_0_0_0_4_5_1_Employees_Auth_Ajax_3_GiveEmpAuth_AjaxServlet?"
                + url
                + "sectionId=" + sectionId
                + "&deptId=" + deptId
                + "&accUnitId=" + accUnitId
                + "&employeeId=" + searchEmpId;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                } else {
                    Success("تم إعطاء الصلاحية بنجاح");
                    getAvailableScreens();
                }
            }
        };
    }
}
switchCheck();
function switchCheck() {
    $(document).ready(function () {
        if ($(".js-switch")[0]) {
            var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
            elems.forEach(function (html) {
                var switchery = new Switchery(html, {
                    color: '#26B99A'
                    , secondaryColor: '#dc0000'
                });
            });
        }
    });
}


function addToACCUnit() {
    var searchEmpId = document.getElementById("searchEmpId").value;
    $.ajax({//_1_0_0_0_2_Electronic_Invoice_Query_verify_02_getAllInvoiceForVerify_AjaxServlet
        url: "_0_0_0_4_5_1_Employees_Auth_Ajax_6_addToACCUnit_AjaxServlet?"
                + "sectionId=" + sectionId
                + "&deptId=" + deptId
                + "&accUnitId=" + accUnitId
                + "&employeeId=" + searchEmpId,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //console.log(data);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            if (data === "Success") {
                Success("تمت عملية الإضافة بنجاح");
                getAvailableScreens();
                $('#chkLockDiv').show();
            } else {
                Error("حدث خطأ");
            }
        }
        ,
        error: function (xhr, status) {
            Error("حدث خطأ");

        }
    }
    );
}


function lockOrUnlock() {
    var searchEmpId = document.getElementById("searchEmpId").value;
    var chkLock = document.getElementById("chkLock").checked;
    var chkLockStatus = "";

var checked ="";
var lable ="";
    if (chkLock === true) {
        chkLockStatus = "true";
        checked = ("true") ? " checked " : "";
        lable = "الموظف متاح دخوله إلى النظام";
        document.getElementById("chkLockDiv").innerHTML = "<td colspan=\"3\"><input id='chkLock' type=\"checkbox\" onchange='lockOrUnlock();' value='' class=\"js-switch\" " + checked + "/> " + lable + "";

    } else {
        chkLockStatus = "false";
        lable = "الموظف لا يستطيع الدخول إلى النظام";
        document.getElementById("chkLockDiv").innerHTML = "<td colspan=\"3\"><input id='chkLock' type=\"checkbox\" onchange=\"lockOrUnlock();\" value='' class=\"js-switch\" " + checked + "/> " + lable + "";

    }


    $.ajax({//_1_0_0_0_2_Electronic_Invoice_Query_verify_02_getAllInvoiceForVerify_AjaxServlet
        url: "_0_0_0_4_5_1_Employees_Auth_Ajax_7_lockOrUnlock_AjaxServlet?"
                + "sectionId=" + sectionId
                + "&deptId=" + deptId
                + "&accUnitId=" + accUnitId
                + "&employeeId=" + searchEmpId
                + "&chkLockStatus=" + chkLockStatus,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //console.log(data);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            if (data === "Success") {
                Success("تمت العملية بنجاح");
                getAvailableScreens();
            } else {
                Error("حدث خطأ");
            }
        }
        ,
        error: function (xhr, status) {
            Error("حدث خطأ");

        }
    }
    );
}

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
function StickyAlarm(type, addclass, title, body) {
    new PNotify({
        title: title,
        text: body,
        type: type,
        hide: false,
        styling: 'bootstrap3',
        addclass: addclass
    });
}