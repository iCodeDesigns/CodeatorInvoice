/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//**
// Controling with Application_Name Table
//**
var Table1Load2 = false;
LoadBasicDataFromApplicationSubTabs();
//* 1- Loading Table Application_Name
var Table1Load = false;
//LoadBasicDataFromApplicationName();
function LoadBasicDataFromApplicationName() {
    var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_1_LoadBasicDataFromApplicationName_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("ApplicationNameBasic_Data").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"4\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";
                Table1Load = false;
            } else {
                document.getElementById("ApplicationNameBasic_Data").innerHTML = message;
                Table1Load = true;
            }
        }
    };
}
function LoadBasicDataFromApplicationNameForDropBox() {
    var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_5_LoadBasicDataFromApplicationNameForDropBox_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("applicationId").innerHTML = ""
                        + "<option style='font-size: 15px;font-weight: bold;' value=''>لا يوجد أنظمة</option>";
                document.getElementById("applicationId2").innerHTML = ""
                        + "<option style='font-size: 15px;font-weight: bold;' value=''>لا يوجد أنظمة</option>";
            } else {
                document.getElementById("applicationId").innerHTML = "<option style='font-size: 15px;font-weight: bold;' value=''>اختر النظام</option>" + message;
                document.getElementById("applicationId2").innerHTML = "<option style='font-size: 15px;font-weight: bold;' value=''>اختر النظام</option>" + message;
            }
        }
    };
}

setInterval(intitilization2, 2000);
function intitilization2() {
    if (Table1Load === false) {
        intitilization();
    }
}
setInterval(intitilization3, 2000);
function intitilization3() {
    Table1Load = false;
}
function intitilization() {
    LoadBasicDataFromApplicationName();
}

//* 2- Add to Table Application_Name
function clearInsertApplicationNameFields() {
    document.getElementById("applicationName").value = "";
}
function doAddApplicationName() {
    var applicationName = document.getElementById("applicationName").value;
    if (applicationName === "" || applicationName === null) {
        Warning("برجاء ملئ خانة إسم النظام");
    } else {
        var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_2_doAddApplicationName_AjaxServlet?"
                + "applicationName=" + applicationName;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Success") {
                    Success("تمت عملية الحفظ بنجاح");
                    clearInsertApplicationNameFields();
                    LoadBasicDataFromApplicationName();

                } else {
                    Error(message);
                    LoadBasicDataFromApplicationName();

                }
            }
        };
    }
}

//* 3- Update to Table Application_Name
function clearupdateApplicationNameFields() {
    document.getElementById("applicationNameE").value = "";
}
var applicationIdE = "";
function updateApplicationName(applicationId, applicationName) {
    document.getElementById("applicationNameE").value = applicationName;
    applicationIdE = applicationId;
}
function doUpdateApplicationName() {
    var applicationName = document.getElementById("applicationNameE").value;
    if (applicationName === "" || applicationName === null) {
        Warning("برجاء ملئ خانة إسم النظام");
    } else {


        var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_3_doUpdateApplicationName_AjaxServlet?"
                + "applicationName=" + applicationName
                + "&applicationId=" + applicationIdE;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Success") {
                    Success("تمت عملية الحفظ بنجاح");
                    clearupdateApplicationNameFields();
                    LoadBasicDataFromApplicationName();
                } else {
                    Error(message);
                    LoadBasicDataFromApplicationName();
                }
            }
        };
    }
}
//* 4- Delete From Table Application_Name
function deleteApplicationName(applicationId) {
    applicationIdE = applicationId;
}
function doDeleteApplicationName() {

    var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_4_doDeleteApplicationName_AjaxServlet?"
            + "applicationId=" + applicationIdE;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Success") {
                Success("تمت عملية الحذف بنجاح");
                LoadBasicDataFromApplicationName();
            } else {
                Error("فشلت عملية الحذف .. برجاء إعادة المحاولة");
                LoadBasicDataFromApplicationName();
            }
        }
    };
}
//////////////////////////////////////////////////////////////////////////////////
// TABLE ..
//* 1- Loading Table Application_Tabs
var Table1Load1 = false;
//LoadBasicDataFromApplicationTabs();
function LoadBasicDataFromApplicationTabs() {
    var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_6_LoadBasicDataFromApplicationTabs_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("ApplicationTabsBasic_Data").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"4\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";
                Table1Load1 = false;
            } else {
                document.getElementById("ApplicationTabsBasic_Data").innerHTML = message;
                Table1Load1 = true;
            }
        }
    };
}
setInterval(intitilization21, 2000);
function intitilization21() {
    if (Table1Load1 === false) {
        intitilization1();
    }
}
setInterval(intitilization31, 2000);
function intitilization31() {
    Table1Load1 = false;
}
function intitilization1() {
    LoadBasicDataFromApplicationTabs();
}

function LoadBasicDataFromApplicationTabsForDropBox() {
    var applicationId2 = document.getElementById("applicationId2").value;
    if (applicationId2 === "" || applicationId2 === null) {
        document.getElementById("tabId").innerHTML = "";
    } else {
        var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_91_LoadBasicDataFromApplicationTabsForDropBox_AjaxServlet?applicationId=" + applicationId2;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("tabId").innerHTML = ""
                            + "<option style='font-size: 15px;font-weight: bold;' value=''>لا يوجد قوائم</option>";
                } else {
                    document.getElementById("tabId").innerHTML = "<option style='font-size: 15px;font-weight: bold;' value=''>اختر قائمة</option>" + message;
                }
            }
        };
    }
}
function clearApplicationTabsForDropBox() {
    document.getElementById("tabId").innerHTML = "";
}
//* 2- Insert to Table Application_Tabs
function clearInsertApplicationTabs() {
    document.getElementById("tabName").value = "";
    document.getElementById("applicationId").value = "";
    document.getElementById("tabFafaIcon").value = "";
    showIcon("tabFafaIcon", "iconSpan");
}
function doAddApplicationTabs() {
    var tabName = document.getElementById("tabName").value;
    var applicationId = document.getElementById("applicationId").value;
    var tabFafaIcon = document.getElementById("tabFafaIcon").value;
    if (tabName === "" || tabName === null) {
        Warning("برجاء ملئ خانة إسم القائمة");
    } else if (applicationId === "" || applicationId === null) {
        Warning("برجاء اختيار النظام");
    } else if (tabFafaIcon === "" || tabFafaIcon === null) {
        Warning("برجاء اختيار أيقونة");
    } else {
        var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_7_doAddApplicationTabs_AjaxServlet?"
                + "tabName=" + tabName
                + "&applicationId=" + applicationId
                + "&tabFafaIcon=" + tabFafaIcon;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Success") {
                    Success("تمت عملية الحفظ بنجاح");
                    clearInsertApplicationTabs();
                    LoadBasicDataFromApplicationTabs();

                } else {
                    Error(message);
                    LoadBasicDataFromApplicationTabs();

                }
            }
        };
    }
}
//* 3- Update to Table Application_Tabs
function clearupdateApplicationTabsFields() {
    document.getElementById("tabNameE").value = "";
    document.getElementById("tabFafaIconE").value = "";
}
var tabIdE = "";
function updateAppTabs(applicationId, tabId, tabName, tabFafaIcon) {
    document.getElementById("tabNameE").value = tabName;
    document.getElementById("tabFafaIconE").value = tabFafaIcon;
    applicationIdE = applicationId;
    tabIdE = tabId;
    showIcon("tabFafaIconE", "iconSpanE");
}
function doUpdateApplicationTabs() {
    var tabName = document.getElementById("tabNameE").value;
    var tabFafaIcon = document.getElementById("tabFafaIconE").value;
    if (tabName === "" || tabName === null) {
        Warning("برجاء ملئ خانة إسم القائمة");
    } else if (tabFafaIcon === "" || tabFafaIcon === null) {
        Warning("برجاء اختيار أيقونة");
    } else {
        var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_8_doUpdateApplicationTabs_AjaxServlet?"
                + "tabName=" + tabName
                + "&tabFafaIcon=" + tabFafaIcon
                + "&applicationId=" + applicationIdE
                + "&tabId=" + tabIdE;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Success") {
                    Success("تمت عملية الحفظ بنجاح");
                    clearupdateApplicationTabsFields();
                    LoadBasicDataFromApplicationTabs();
                } else {
                    Error(message);
                    LoadBasicDataFromApplicationTabs();
                }
            }
        };
    }
}
//* 4- Delete From Table Application_Tabs
function deleteApplicationTabs(applicationId, tabId) {
    applicationIdE = applicationId;
    tabIdE = tabId;
}

function doDeleteApplicationTabs() {

    var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_9_doDeleteApplicationTabs_AjaxServlet?"
            + "applicationId=" + applicationIdE
            + "&tabId=" + tabIdE;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Success") {
                Success("تمت عملية الحذف بنجاح");
                LoadBasicDataFromApplicationTabs();
            } else {
                Error("فشلت عملية الحذف .. برجاء إعادة المحاولة");
                LoadBasicDataFromApplicationTabs();
            }
        }
    };
}
// TABLE ..
//* 1- Loading Table Application_SubTabs
function LoadBasicDataFromApplicationSubTabs() {
    var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_92_LoadBasicDataFromApplicationSubTabs_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("ApplicationSubTabsBasic_Data").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"3\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";
                //Table1Load2 = false;
            } else {
                document.getElementById("ApplicationSubTabsBasic_Data").innerHTML = message;
                //Table1Load2 = true;
            }
        }
    };
}
/*
 setInterval(intitilization22, 10000);
 function intitilization22() {
 if (Table1Load2 === false) {
 intitilization2();
 }
 }
 setInterval(intitilization32, 10000);
 function intitilization32() {
 Table1Load2 = false;
 }
 function intitilization2() {
 LoadBasicDataFromApplicationSubTabs();
 }*/

//* 2- Insert to Table Application_SubTabs
function clearInsertApplicationSubTabs() {
    document.getElementById("subTabName").value = "";
    document.getElementById("subTabAccessservlet").value = "";
    document.getElementById("applicationId2").value = "";
    document.getElementById("tabId").value = "";
}
function doAddApplicationSubTabs() {
    var subTabName = document.getElementById("subTabName").value;
    var subTabAccessservlet = document.getElementById("subTabAccessservlet").value;
    var applicationId = document.getElementById("applicationId2").value;
    var tabId = document.getElementById("tabId").value;
    if (subTabName === "" || subTabName === null) {
        Warning("برجاء ملئ خانة إسم الشاشة");
    } else if (subTabAccessservlet === "" || subTabAccessservlet === null) {
        Warning("رجاء ملئ خانة إسم ال Servlet");
    } else if (applicationId === "" || applicationId === null) {
        Warning("برجاء اختيار النظام");
    } else if (tabId === "" || tabId === null) {
        Warning("برجاء اختيار القائمة");
    } else {
        var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_93_doAddApplicationSubTabs_AjaxServlet?"
                + "subTabName=" + subTabName
                + "&subTabAccessservlet=" + subTabAccessservlet
                + "&applicationId=" + applicationId
                + "&tabId=" + tabId;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Success") {
                    Success("تمت عملية الحفظ بنجاح");
                    clearInsertApplicationSubTabs();
                    LoadBasicDataFromApplicationSubTabs();

                } else {
                    Error(message);
                    LoadBasicDataFromApplicationSubTabs();

                }
            }
        };
    }
}

//* 3- Update to Table Application_Tabs
function clearupdateApplicationSubTabsFields() {
    document.getElementById("subTabNameE").value = "";
    document.getElementById("subTabAccessservletE").value = "";
}
var subTabIdE;
function updateAppSubTabs(applicationId, tabId, subTabId, subTabName, subTabAccessservlet, availableToUserControl, authTypeId) {
    document.getElementById("subTabNameE").value = subTabName;
    document.getElementById("subTabAccessservletE").value = subTabAccessservlet;
    document.getElementById("availableToUserControl").value = availableToUserControl.charAt(7);
    document.getElementById("authTypeId").value = authTypeId;

    applicationIdE = applicationId;
    tabIdE = tabId;
    subTabIdE = subTabId;
}
function doUpdateApplicationSubTabs() {
    var subTabName = document.getElementById("subTabNameE").value;
    var subTabAccessservlet = document.getElementById("subTabAccessservletE").value;
    var availableToUserControl = document.getElementById("availableToUserControl").value;
    var authTypeId = document.getElementById("authTypeId").value;
    if (subTabName === "" || subTabName === null) {
        Warning("برجاء ملئ خانة إسم الشاشة");
    } else if (subTabAccessservlet === "" || subTabAccessservlet === null) {
        Warning("برجاء ملئ خانة إسم ال Access Servlet");
    } else if (availableToUserControl === "" || availableToUserControl === null) {
        Warning("برجاء اختيار نوع التفعيل");
    } else if (authTypeId === "" || authTypeId === null) {
        Warning("برجاء اختيار نوع الشاشة");
    } else {
        var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_94_doUpdateApplicationSubTabs_AjaxServlet?"
                + "subTabName=" + subTabName
                + "&subTabAccessservlet=" + subTabAccessservlet
                + "&availableToUserControl=" + availableToUserControl
                + "&applicationId=" + applicationIdE
                + "&tabId=" + tabIdE
                + "&authTypeId=" + authTypeId
                + "&subTabId=" + subTabIdE;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Success") {
                    Success("تمت عملية الحفظ بنجاح");
                    clearupdateApplicationSubTabsFields();
                    LoadBasicDataFromApplicationSubTabs();
                } else {
                    Error(message);
                    LoadBasicDataFromApplicationSubTabs();
                }
            }
        };
    }
}

//* 4- Delete From Table Application_Tabs
function deleteAppSubTabs(applicationId, tabId, subTabId) {
    applicationIdE = applicationId;
    tabIdE = tabId;
    subTabIdE = subTabId;
}

function doDeleteApplicationSubTabs() {

    var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_95_doDeleteApplicationSubTabs_AjaxServlet?"
            + "applicationId=" + applicationIdE
            + "&tabId=" + tabIdE
            + "&subTabId=" + subTabIdE;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Success") {
                Success("تمت عملية الحذف بنجاح");
                LoadBasicDataFromApplicationSubTabs();
            } else {
                Error("فشلت عملية الحذف .. برجاء إعادة المحاولة");
                LoadBasicDataFromApplicationSubTabs();
            }
        }
    };
}
/////////////////////////////////////////////////////////////////////////////////
function show(id) {
    var status = document.getElementById(id).style.display;
    if (status === "none") {
        document.getElementById(id).style.display = "block";
    } else {
        document.getElementById(id).style.display = "none";
    }
}

function Generat_XML_Code() {
    var filterName = document.getElementById("filterName").value;
    var filterPath = document.getElementById("filterPath").value;
    var URL = "_9_9_9_9_9_9_Application_Super_Control_Ajax_96_Generat_XML_Code_AjaxServlet?"
            + "filterName=" + filterName
            + "&filterPath=" + filterPath;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                Error("فشلت عملية تكوين الكود");
            } else {
                Success("تم تكوين الكود بنجاح");
                document.getElementById("filter_xml_code").value = message;
            }
        }
    };
}
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
function showIcon(sourceId, distId) {
    var tabFafaIcon = document.getElementById(sourceId).value;
    document.getElementById(distId).className = tabFafaIcon;
}