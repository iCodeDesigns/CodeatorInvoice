/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
getScreenElements();
function getScreenElements() {

    var URL = "_9_9_9_9_9_5_Application_Menu_Screen_Elements_Ajax_1_LoadDataFromElements_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("SubTabNameBasic_Data2").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"6\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";
            } else {
                document.getElementById("SubTabNameBasic_Data2").innerHTML = message;
            }
        }
    };

}

function getElementsBySubTab() {

    var Id_element = document.getElementById("subTabId").value;
    var Id = Id_element.split("-");
    var applicationId = Id[0];
    var tabId = Id[1];
    var subTabId = Id[2];
    var URL = "_9_9_9_9_9_5_Application_Menu_Screen_Elements_Ajax_2_LoadDataFromElementsBySubTab_AjaxServlet?";
    URL += "applicationId=" + applicationId;
    URL += "&tabId=" + tabId;
    URL += "&subTabId=" + subTabId;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                document.getElementById("ElementDtl").innerHTML = ""
                        + "<tr>"
                        + "<td colspan=\"3\"><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
                        + "</tr>";
            } else {
                document.getElementById("ElementDtl").innerHTML = message;
            }
        }
    };

}
function FillElementModel(applicationId, tabId, subTabId) {
    document.getElementById("applicationId").value = applicationId;
    document.getElementById("tabId").value = tabId;
    document.getElementById("subTabId").value = subTabId;
    setTimeout(getElementsBySubTab, 500);
}
function Save() {
    var Id_element = document.getElementById("subTabId").value;
    var Id = Id_element.split("-");
    var applicationId = Id[0];
    var tabId = Id[1];
    var subTabId = Id[2];
    var element_name = document.getElementById("element_name").value;
    var elementType = document.getElementById("elementType").value;
    if (element_name === "" || element_name === null) {
        Warning("Please Enter The Element Name");
    } else if (elementType === "" || elementType === null) {
        Warning("Please Choose The Element Type");
    } else {
        var URL = "_9_9_9_9_9_5_Application_Menu_Screen_Elements_Ajax_3_SaveElementsBySubTab_AjaxServlet?";
        URL += "applicationId=" + applicationId;
        URL += "&tabId=" + tabId;
        URL += "&subTabId=" + subTabId;
        URL += "&element_name=" + element_name;
        URL += "&elementType=" + elementType;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("Error .. try Again Later");
                } else if (message === "Element Name Exist Before") {
                    Error(message);
                } else {
                    Success("Operation Done Successfully");
                    document.getElementById("element_name").value = "";
                    setTimeout(getElementsBySubTab(), 500);

                    setTimeout(getScreenElements(), 2000);
                }
            }
        };
    }

}
var applicationIdG;
var tabIdG;
var subTabIdG;
var elementIdG;
function deleteData(applicationId, tabId, subTabId, elementId) {
    applicationIdG = applicationId;
    tabIdG = tabId;
    subTabIdG = subTabId;
    elementIdG = elementId;
}

function deleteElement() {

    var URL = "_9_9_9_9_9_5_Application_Menu_Screen_Elements_Ajax_4_DeleteElementsBySubTab_AjaxServlet?";
    URL += "applicationId=" + applicationIdG;
    URL += "&tabId=" + tabIdG;
    URL += "&subTabId=" + subTabIdG;
    URL += "&elementId=" + elementIdG;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                Error("Error .. try Again Later");
            } else {
                Success("Deletion Done Successfully");
                document.getElementById("element_name").value = "";
                setTimeout(getElementsBySubTab(), 500);

                setTimeout(getScreenElements(), 2000);
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

