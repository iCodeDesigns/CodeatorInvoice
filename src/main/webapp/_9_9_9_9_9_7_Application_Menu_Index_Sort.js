/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

LoadBasicDataFromApplicationName();
function LoadBasicDataFromApplicationName() {
    var URL = "_9_9_9_9_9_7_Application_Menu_Index_Sort_Ajax_1_LoadBasicDataFromApplicationName_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("ApplicationNameBasic_Data").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"3\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";
            } else {
                document.getElementById("ApplicationNameBasic_Data").innerHTML = message;
                document.getElementById("editApplicationIndex").disabled = false;
            }
        }
    };
}

function editApplicationIndex() {
    document.getElementById("editApplicationIndex").disabled = true;
    document.getElementById("cancelApplicationIndex").disabled = false;
    document.getElementById("SaveApplicationIndex").disabled = false;
    var applicationIndex = document.getElementsByName("ApplicationIndex");
    for (var i = 0; i < applicationIndex.length; ) {
        applicationIndex[i].readOnly = false;
        i = i + 1;
    }
}
function cancelApplicationIndex() {
    document.getElementById("editApplicationIndex").disabled = false;
    document.getElementById("cancelApplicationIndex").disabled = true;
    document.getElementById("SaveApplicationIndex").disabled = true;
    var applicationIndex = document.getElementsByName("ApplicationIndex");
    for (var i = 0; i < applicationIndex.length; ) {
        applicationIndex[i].readOnly = true;
        i = i + 1;
    }
}
function SaveApplicationIndex() {

    var applicationIndex = document.getElementsByName("ApplicationIndex");
    /**
     * Check On Index
     * @type {Boolean}
     */
    var check_index = true;
    var IndexURL = "";
    for (var i = 0; i < applicationIndex.length - 1 && check_index === true; ) {
        for (var j = i + 1; j < applicationIndex.length; ) {
            if (applicationIndex[j].value === applicationIndex[i].value) {
                check_index = false;
                break;
            }
            j = j + 1;
        }

        i = i + 1;
    }


    if (check_index) {
        var URL = "_9_9_9_9_9_7_Application_Menu_Index_Sort_Ajax_2_SaveApplicationIndex_AjaxServlet?";
        for (var i = 0; i < applicationIndex.length; ) {
            IndexURL += "index=" + applicationIndex[i].value + "&";
            i = i + 1;
        }
        URL += IndexURL;
        var Applications_ID = document.getElementsByClassName("application_id");
        for (var i = 0; i < Applications_ID.length; ) {
            if (i < Applications_ID.length - 1) {
                URL += "appId=" + Applications_ID[i].innerHTML + "&";
            } else {
                URL += "appId=" + Applications_ID[i].innerHTML;
            }
            i = i + 1;
        }
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                } else {
                    document.getElementById("editApplicationIndex").disabled = false;
                    document.getElementById("cancelApplicationIndex").disabled = true;
                    document.getElementById("SaveApplicationIndex").disabled = true;
                    LoadBasicDataFromApplicationName();
                    Success("Saved Successfully.");
                }
            }
        };
    } else {
        Warning("Application Index Can't Be Dublicated.");
    }
}
/**
 * /////////////////////////////////////////////////////////////////////////////////////
 * /////////////////////////////////////////////////////////////////////////////////////
 * ///////////////////////////////////////////////////////////////////////////////////// 
 *                              TAPS
 * /////////////////////////////////////////////////////////////////////////////////////
 * /////////////////////////////////////////////////////////////////////////////////////
 * ///////////////////////////////////////////////////////////////////////////////////// 
 */
//LoadBasicDataFromApplicationTab();
function LoadBasicDataFromApplicationTab() {
    var applicationIdS = document.getElementById("applicationIdS").value;
    if (!(applicationIdS === "" || applicationIdS === null)) {
        var URL = "_9_9_9_9_9_7_Application_Menu_Index_Sort_Ajax_3_LoadBasicDataFromApplicationTabs_AjaxServlet?";
        URL += "applicationIdS=" + applicationIdS;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("TabNameBasic_Data").innerHTML = ""
                            + "<tr>"
                            + "<td colspan=\"3\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                            + "</tr>";
                } else {
                    document.getElementById("TabNameBasic_Data").innerHTML = message;
                    document.getElementById("editApplicationTabIndex").disabled = false;
                }
            }
        };
    } else {
        document.getElementById("editApplicationTabIndex").disabled = true;
        document.getElementById("cancelApplicationTabIndex").disabled = true;
        document.getElementById("SaveApplicationTabIndex").disabled = true;
        document.getElementById("TabNameBasic_Data").innerHTML = ""
                + "<tr>"
                + "<td colspan=\"3\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                + "</tr>";

    }

}

function editApplicationTabIndex() {
    document.getElementById("editApplicationTabIndex").disabled = true;
    document.getElementById("cancelApplicationTabIndex").disabled = false;
    document.getElementById("SaveApplicationTabIndex").disabled = false;
    var applicationIndex = document.getElementsByName("ApplicationTabIndex");
    for (var i = 0; i < applicationIndex.length; ) {
        applicationIndex[i].readOnly = false;
        i = i + 1;
    }
}
function cancelApplicationTabIndex() {
    document.getElementById("editApplicationTabIndex").disabled = false;
    document.getElementById("cancelApplicationTabIndex").disabled = true;
    document.getElementById("SaveApplicationTabIndex").disabled = true;
    var applicationIndex = document.getElementsByName("ApplicationTabIndex");
    for (var i = 0; i < applicationIndex.length; ) {
        applicationIndex[i].readOnly = true;
        i = i + 1;
    }
}
function SaveApplicationTabIndex() {

    var applicationIndex = document.getElementsByName("ApplicationTabIndex");
    /**
     * Check On Index
     * @type {Boolean}
     */
    var check_index = true;
    var IndexURL = "";
    for (var i = 0; i < applicationIndex.length - 1 && check_index === true; ) {
        for (var j = i + 1; j < applicationIndex.length; ) {
            if (applicationIndex[j].value === applicationIndex[i].value) {
                check_index = false;
                break;
            }
            j = j + 1;
        }

        i = i + 1;
    }


    if (check_index) {
        var URL = "_9_9_9_9_9_7_Application_Menu_Index_Sort_Ajax_4_SaveApplicationTabsIndex_AjaxServlet?";
        for (var i = 0; i < applicationIndex.length; ) {
            IndexURL += "index=" + applicationIndex[i].value + "&";
            i = i + 1;
        }
        URL += IndexURL;
        var Applications_ID = document.getElementsByClassName("tab_id");
        for (var i = 0; i < Applications_ID.length; ) {
            if (i < Applications_ID.length - 1) {
                URL += "tabId=" + Applications_ID[i].innerHTML + "&";
            } else {
                URL += "tabId=" + Applications_ID[i].innerHTML;
            }
            i = i + 1;
        }
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                } else {
                    document.getElementById("editApplicationTabIndex").disabled = false;
                    document.getElementById("cancelApplicationTabIndex").disabled = true;
                    document.getElementById("SaveApplicationTabIndex").disabled = true;
                    LoadBasicDataFromApplicationTab();
                    Success("Saved Successfully.");
                }
            }
        };
    } else {
        Warning("Application Tab Index Can't Be Dublicated.");
    }
}
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
        document.getElementById("editApplicationSubTabIndex").disabled = true;
        document.getElementById("cancelApplicationSubTabIndex").disabled = true;
        document.getElementById("SaveApplicationSubTabIndex").disabled = true;
        document.getElementById("SubTabNameBasic_Data").innerHTML = ""
                + "<tr>"
                + "<td colspan=\"3\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                + "</tr>";
    }
}
//LoadBasicDataFromApplicationTab();
function LoadBasicDataFromApplicationSubTab() {
    var applicationIdS_2 = document.getElementById("applicationIdS_2").value;
    var applicationTabIdS_2 = document.getElementById("applicationTabIdS_2").value;
    if (!(applicationIdS_2 === "" || applicationIdS_2 === null || applicationTabIdS_2 === "" || applicationTabIdS_2 === null)) {
        var URL = "_9_9_9_9_9_7_Application_Menu_Index_Sort_Ajax_5_LoadBasicDataFromApplicationSubTabs_AjaxServlet?";
        URL += "applicationIdS=" + applicationIdS_2;
        URL += "&applicationTabIdS=" + applicationTabIdS_2;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("SubTabNameBasic_Data").innerHTML = ""
                            + "<tr>"
                            + "<td colspan=\"3\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                            + "</tr>";
                } else {
                    document.getElementById("SubTabNameBasic_Data").innerHTML = message;
                    document.getElementById("editApplicationSubTabIndex").disabled = false;
                }
            }
        };
    } else {
        document.getElementById("editApplicationSubTabIndex").disabled = true;
        document.getElementById("cancelApplicationSubTabIndex").disabled = true;
        document.getElementById("SaveApplicationSubTabIndex").disabled = true;
        document.getElementById("SubTabNameBasic_Data").innerHTML = ""
                + "<tr>"
                + "<td colspan=\"3\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                + "</tr>";

    }

}

function editApplicationSubTabIndex() {
    document.getElementById("editApplicationSubTabIndex").disabled = true;
    document.getElementById("cancelApplicationSubTabIndex").disabled = false;
    document.getElementById("SaveApplicationSubTabIndex").disabled = false;
    var applicationIndex = document.getElementsByName("AppSubTabIndex");
    for (var i = 0; i < applicationIndex.length; ) {
        applicationIndex[i].readOnly = false;
        i = i + 1;
    }
}
function cancelApplicationSubTabIndex() {
    document.getElementById("editApplicationSubTabIndex").disabled = false;
    document.getElementById("cancelApplicationSubTabIndex").disabled = true;
    document.getElementById("SaveApplicationSubTabIndex").disabled = true;
    var applicationIndex = document.getElementsByName("ApplicationSubTabIndex");
    for (var i = 0; i < applicationIndex.length; ) {
        applicationIndex[i].readOnly = true;
        i = i + 1;
    }
}
function SaveApplicationSubTabIndex() {

    var applicationIndex = document.getElementsByName("AppSubTabIndex");
    /**
     * Check On Index
     * @type {Boolean}
     */
    var check_index = true;
    var IndexURL = "";
    for (var i = 0; i < applicationIndex.length - 1 && check_index === true; ) {
        for (var j = i + 1; j < applicationIndex.length; ) {
            if (applicationIndex[j].value === applicationIndex[i].value) {
                check_index = false;
                break;
            }
            j = j + 1;
        }

        i = i + 1;
    }


    if (check_index) {
        var URL = "_9_9_9_9_9_7_Application_Menu_Index_Sort_Ajax_6_SaveApplicationSubTabsIndex_AjaxServlet?";
        for (var i = 0; i < applicationIndex.length; ) {
            IndexURL += "index=" + applicationIndex[i].value + "&";
            i = i + 1;
        }
        URL += IndexURL;
        var Applications_ID = document.getElementsByClassName("sub_tab_id");
        for (var i = 0; i < Applications_ID.length; ) {
            if (i < Applications_ID.length - 1) {
                URL += "subTabId=" + Applications_ID[i].innerHTML + "&";
            } else {
                URL += "subTabId=" + Applications_ID[i].innerHTML;
            }
            i = i + 1;
        }
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                } else {
                    document.getElementById("editApplicationSubTabIndex").disabled = false;
                    document.getElementById("cancelApplicationSubTabIndex").disabled = true;
                    document.getElementById("SaveApplicationSubTabIndex").disabled = true;
                    LoadBasicDataFromApplicationSubTab();
                    Success("Saved Successfully.");
                }
            }
        };
    } else {
        Warning("Application Tab Index Can't Be Dublicated.");
    }
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