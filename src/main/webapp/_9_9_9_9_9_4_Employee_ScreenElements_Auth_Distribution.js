/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * /////////////////////////////////////////////////////////////////////////////////////
 * /////////////////////////////////////////////////////////////////////////////////////
 * ///////////////////////////////////////////////////////////////////////////////////// 
 *                              SUB TAPS
 * /////////////////////////////////////////////////////////////////////////////////////
 * /////////////////////////////////////////////////////////////////////////////////////
 * ///////////////////////////////////////////////////////////////////////////////////// 
 */
function LoadSubTabAjax() {
    var applicationIdS_2 = document.getElementById("applicationIdS_2").value;
    if (!(applicationIdS_2 === "" || applicationIdS_2 === null)) {
        var URL = "_9_9_9_9_9_7_Application_Menu_Index_Sort_Ajax_7_LoadApplicationSubTabs_AjaxServlet?";
        URL += "applicationIdS=" + applicationIdS_2;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("applicationTabIdS_2").innerHTML = "<option value=''>اختر النظام ...</option>";
                } else {
                    document.getElementById("applicationTabIdS_2").innerHTML = message;
                }
            }
        };
    } else {
        document.getElementById("applicationTabIdS_2").innerHTML = "<option value=''>اختر النظام ...</option>";
    }
    resetSearch();
}
function LoadSubTabAjax2() {
    var applicationIdS_2 = document.getElementById("applicationIdS_2").value;
    var applicationTabIdS_2 = document.getElementById("applicationTabIdS_2").value;
    if (!(applicationIdS_2 === "" || applicationIdS_2 === null)) {
        var URL = "_9_9_9_9_9_7_Application_Menu_Index_Sort_Ajax_8_LoadApplicationSubTabs2_AjaxServlet?";
        URL += "applicationIdS=" + applicationIdS_2;
        URL += "&applicationTabIdS_2=" + applicationTabIdS_2;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("applicationSubTabIdS_2").innerHTML = "<option value=''>اختر الشاشة ...</option>";
                } else {
                    document.getElementById("applicationSubTabIdS_2").innerHTML = message;
                }
            }
        };
    } else {
        document.getElementById("applicationTabIdS_2").innerHTML = "<option value=''>اختر النظام ...</option>";
    }
    resetSearch();
}
function getEmpDataAjax() {
    var employeeId = document.getElementById("searchEmpId").value;

    if (employeeId === "" || employeeId === null) {
        //Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("searchEmpData").innerHTML = "";
    } else {
        var URL = "_0_0_0_4_0_0_document_scan_Ajax_1_getEmployeeData_AjaxServlet?";

        URL += "employeeId=" + employeeId + "&typeSearch=1";

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("searchEmpData").innerHTML = "لا توجد بيانات موظف";
                    document.getElementById("EmpAuthData").innerHTML = ""
                            + "<tr>"
                            + "<td colspan=\"5\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                            + "</tr>";
                } else {
                    document.getElementById("searchEmpData").innerHTML = message;
                    setTimeout(getEmpAuthScreensAjax(employeeId), 500);
                }

            }

        };
    }
}
function resetSearch() {
    document.getElementById("SubTabNameBasic_Data").innerHTML = ""
            + "<tr>"
            + "<td colspan=\"4\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    document.getElementById("saveAuthBtn").disabled = true;
}

function resetUpperBlockSearch() {
    document.getElementById("searchEmpId").value = "";
    document.getElementById("searchEmpData").innerHTML = "";
    document.getElementById("applicationTabIdS_2").innerHTML = "<option value='''>اختر القائمة ...</option>";
    document.getElementById("applicationIdS_2").value = "";
    document.getElementById("SubTabNameBasic_Data").innerHTML = ""
            + "<tr>"
            + "<td colspan=\"4\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    document.getElementById("saveAuthBtn").disabled = true;
    document.getElementById("EmpAuthData").innerHTML = ""
            + "<tr>"
            + "<td colspan=\"5\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
}

function getEmpAuthScreensAjax(employeeId) {
    var URL = "_9_9_9_9_9_6_Employee_Screen_Auth_Distribution_Ajax_2_getEmpAuthScreens_AjaxServlet?";

    URL += "employeeId=" + employeeId;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("EmpAuthData").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"5\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";
            } else {
                document.getElementById("EmpAuthData").innerHTML = message;
            }
        }
    };
}
window.addEventListener('keypress', function (e) {

    if (e.keyCode === 13) {
        var searchEmpId = document.querySelector("#searchEmpId");

        var applicationIdS_2 = document.getElementById("applicationIdS_2").value;
        var applicationTabIdS_2 = document.getElementById("applicationTabIdS_2").value;

        if (searchEmpId === document.activeElement) {
            if (applicationIdS_2 === "" || applicationIdS_2 === null) {
                Warning("Please Choose Application ... !");
            } else if (applicationTabIdS_2 === "" || applicationTabIdS_2 === null) {
                Warning("Please Choose Application Tab ... !");
            } else {
                LoadBasicDataFromApplicationSubTabElements();
            }
        }
    }
}, false);

//LoadBasicDataFromApplicationTab();
function LoadBasicDataFromApplicationSubTabElements() {
    var applicationIdS_2 = document.getElementById("applicationIdS_2").value;
    var applicationTabIdS_2 = document.getElementById("applicationTabIdS_2").value;
    var applicationSubTabIdS_2 = document.getElementById("applicationSubTabIdS_2").value;
    var searchEmpId = document.getElementById("searchEmpId").value;
    if (!(applicationIdS_2 === "" || applicationIdS_2 === null || applicationTabIdS_2 === "" || applicationTabIdS_2 === null || applicationSubTabIdS_2 === "" || applicationSubTabIdS_2 === null || searchEmpId === "" || searchEmpId === null)) {
        var URL = "_9_9_9_9_9_4_Employee_ScreenElements_Auth_Distribution_Ajax_1_LoadDataFromApplicationSubTabsElementsSpecAuth_AjaxServlet?";
        URL += "applicationIdS=" + applicationIdS_2;
        URL += "&applicationTabIdS=" + applicationTabIdS_2;
        URL += "&applicationSubTabIdS_2=" + applicationSubTabIdS_2;
        URL += "&searchEmpId=" + searchEmpId;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("SubTabNameBasic_Data").innerHTML = ""
                            + "<tr>"
                            + "<td colspan=\"4\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                            + "</tr>";
                } else {
                    document.getElementById("SubTabNameBasic_Data").innerHTML = message;
                    switchCheck();
                    document.getElementById("saveAuthBtn").disabled = false;
                }
            }
        };
    } else {
        document.getElementById("SubTabNameBasic_Data").innerHTML = ""
                + "<tr>"
                + "<td colspan=\"4\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                + "</tr>";

    }

}


// Switchery
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

function SaveAuth() {
    var applicationIdS_2 = document.getElementById("applicationIdS_2").value;
    var applicationTabIdS_2 = document.getElementById("applicationTabIdS_2").value;
    var applicationSubTabIdS_2 = document.getElementById("applicationSubTabIdS_2").value;
    var searchEmpId = document.getElementById("searchEmpId").value;
    var searchEmpData = document.getElementById("searchEmpData").innerHTML;
    if (applicationIdS_2 === "" || applicationIdS_2 === null) {
        Warning("Please Choose Application");
    } else if (applicationTabIdS_2 === "" || applicationTabIdS_2 === null) {
        Warning("Please Choose Tab");
    } else if (applicationSubTabIdS_2 === "" || applicationSubTabIdS_2 === null) {
        Warning("Please Choose Sub Tab");
    } else if (searchEmpId === "" || searchEmpId === null) {
        Warning("Please Set Employee Number");
    } else if (searchEmpData === "" || searchEmpData === "لا توجد بيانات موظف") {
        Warning("Employee Number Not Found..!");
    } else {
        var url = "";
        var sub_tab_id = document.getElementsByClassName("sub_tab_element_id");
        for (var i = 0; i < sub_tab_id.length; ) {
            url += "sub_tab_element_id=" + sub_tab_id[i].innerHTML + "&";
            i = i + 1;
        }
        var AuthChecked = document.getElementsByName("cheackBox1");
        for (var i = 0; i < AuthChecked.length; ) {
            if (AuthChecked[i].innerHtml === " No Access") {
                url += "AuthChecked=false&";
            } else {
                url += "AuthChecked=" + AuthChecked[i].checked + "&";
            }

            i = i + 1;
        }
        var primaryAuthPass = document.getElementsByName("primaryAuthPass");
        for (var i = 0; i < primaryAuthPass.length; ) {
            var value;
            if (primaryAuthPass[i].innerHtml === " No Access") {
                value = "1";
            } else {
                value = primaryAuthPass[i].value;
            }
            if (i < primaryAuthPass.length - 1) {
                url += "primaryAuthPass=" + value + "&";
            } else {
                url += "primaryAuthPass=" + value;
            }
            i = i + 1;
        }
        var URL = "_9_9_9_9_9_4_Employee_ScreenElements_Auth_Distribution_Ajax_2_GiveEmpAuth_AjaxServlet?";
        URL += url;
        URL += "&employeeId=" + searchEmpId;
        
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("Error .. Try Again");
                } else {
                    Success("Operation Done Successfully");
                    getEmpAuthScreensAjax(searchEmpId);
                }
            }
        };
    }
}

// /Switchery


/*
 * Alerts
 */
function Success(Body) {
    new PNotify({
        title: "تمت",
        delay: 2000,
        text: Body,
        type: 'success',
        position: 'top left',
        styling: 'bootstrap3'
    });
}
function Error(Body) {
    new PNotify({
        title: "خطأ",
        delay: 5000,
        text: Body,
        type: 'error',
        styling: 'bootstrap3'
    });
}
function Warning(Body) {
    new PNotify({
        title: "تحذير",
        delay: 2000,
        text: Body,
        styling: 'bootstrap3'
    });
}