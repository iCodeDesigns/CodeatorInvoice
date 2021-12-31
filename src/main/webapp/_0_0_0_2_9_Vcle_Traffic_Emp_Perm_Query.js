var status = 'f';
setInterval(queryLoad, 100);

function searchType() {
    resetSearch();
    var searchType = document.getElementById("searchType").value;
    if (searchType === "All") {
        document.getElementById("EmpDiv").style.display = "none";
        document.getElementById("ValDiv").style.display = "none";
    } else if (searchType === "EmpId") {
        document.getElementById("ValDiv").style.display = "none";
        document.getElementById("EmpDiv").style.display = "block";
        getEmployee();
    } else if (searchType === "Val") {
        document.getElementById("ValDiv").style.display = "block";
        document.getElementById("EmpDiv").style.display = "none";
        getVal();
    }

    /* else if (searchType === "CarModel") {
     document.getElementById("CarNumberDiv").style.display = "none";
     document.getElementById("CarModelDiv").style.display = "block";
     document.getElementById("CarTypeDiv").style.display = "none";
     document.getElementById("DriverDiv").style.display = "none";
     } else if (searchType === "CarType") {
     document.getElementById("CarNumberDiv").style.display = "none";
     document.getElementById("CarModelDiv").style.display = "none";
     document.getElementById("CarTypeDiv").style.display = "block";
     document.getElementById("DriverDiv").style.display = "none";
     } else {
     document.getElementById("CarNumberDiv").style.display = "none";
     document.getElementById("CarModelDiv").style.display = "none";
     document.getElementById("CarTypeDiv").style.display = "none";
     document.getElementById("DriverDiv").style.display = "none";
     }*/
}

function resetSearch() {
    document.getElementById("LoadTrafficEmpPerm_Data").innerHTML = "";
    frame(0);
    document.getElementById("select2-EmployeeId-container").innerHTML = "";
    document.getElementById("select2-Val-container").innerHTML = "";
    document.getElementById("EmployeeId").value = "";
    document.getElementById("Val").value = "";
    document.getElementById("LoadTrafficEmpPerm_Data").innerHTML = "";
    document.getElementById("DashTableLable").innerHTML = "";
    document.getElementById("dash_table").innerHTML = "";
}
function displaySearchTypeDiv() {
    document.getElementById("searchTypeDiv").style.display = "block";
    document.getElementById("searchType").value = "All";
    document.getElementById("EmpDiv").style.display = "none";
    document.getElementById("ValDiv").style.display = "none";
    document.getElementById("select2-EmployeeId-container").innerHTML = "";
    document.getElementById("select2-Val-container").innerHTML = "";
    document.getElementById("EmployeeId").value = "";
    document.getElementById("Val").value = "";
}
function execSearchType() {
    resetExecSearch();
    resetSearch();
    document.getElementById("searchType").value = "All";
    var execSearchType = document.getElementById("execSearchType").value;
    if (execSearchType === "All") {
        document.getElementById("RangDateDiv").style.display = "none";
        document.getElementById("execMmDiv").style.display = "none";
        document.getElementById("searchTypeDiv").style.display = "block";
    } else if (execSearchType === "DateFromTo") {
        document.getElementById("RangDateDiv").style.display = "block";
        document.getElementById("execMmDiv").style.display = "none";
    } else if (execSearchType === "Month") {
        document.getElementById("RangDateDiv").style.display = "none";
        document.getElementById("execMmDiv").style.display = "block";
    } else {
        document.getElementById("RangDateDiv").style.display = "none";
        document.getElementById("execMmDiv").style.display = "none";
    }
    document.getElementById("searchTypeDiv").style.display = "none";
}

function resetExecSearch() {
    document.getElementById("EmpDiv").style.display = "none";
    document.getElementById("ValDiv").style.display = "none";
    document.getElementById("LoadTrafficEmpPerm_Data").innerHTML = "";
    document.getElementById("DashTableLable").innerHTML = "";
    document.getElementById("dash_table").innerHTML = "";
    document.getElementById("select2-EmployeeId-container").innerHTML = "";
    document.getElementById("select2-Val-container").innerHTML = "";
    document.getElementById("select2-execMm-container").innerHTML = "";
    frame(0);
    document.getElementById("execMm").value = "";
    document.getElementById("from_date").value = "";
    document.getElementById("to_date").value = "";
    document.getElementById("EmployeeId").innerHTML = "";
    document.getElementById("Val").innerHTML = "";
}

function searchSubmitPrem() {
    status = 't';
    frame(0);
    document.getElementById("LoadTrafficEmpPerm_Data").innerHTML = "";
    var searchType = document.getElementById("searchType").value;
    var execSearchType = document.getElementById("execSearchType").value;
    var check = true;


    var URL = "_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_1__AJAX_LoadTrafficEmpPerm_AjaxServlet?";
    URL += "searchType=" + searchType;
    URL += "&execSearchType=" + execSearchType;
    if (searchType === "EmpId") {
        var EmployeeId = document.getElementById("EmployeeId").value;
        if (EmployeeId === "" || EmployeeId === null) {
            Warning("برجاء اختيار موظف");
            check = false;
        } else {
            URL += "&EmployeeId=" + EmployeeId;
        }
    } else if (searchType === "Val") {
        var Val = document.getElementById("Val").value;
        if (Val === "" || Val === null) {
            Warning("برجاء اختيار فئة اشتراك");
            check = false;
        } else {
            URL += "&Val=" + Val;
        }
    } else if (searchType === "CarModel") {
        var ModelCode = document.getElementById("ModelCode").value;
        if (ModelCode === "" || ModelCode === null) {
            Warning("برجاء اختيار موديل المركبة");
            check = false;
        } else {
            URL += "&ModelCode=" + ModelCode;
        }
    } else if (searchType === "CarType") {
        var VcleType = document.getElementById("VcleType").value;
        if (VcleType === "" || VcleType === null) {
            Warning("برجاء اختيار نوع المركبة");
            check = false;
        } else {
            URL += "&VcleType=" + VcleType;
        }
    } else {

    }

    if (execSearchType === "DateFromTo") {
        var from_date = document.getElementById("from_date").value;
        var to_date = document.getElementById("to_date").value;
        if (from_date === "" || from_date === null) {
            Warning("برجاء اختيار بداية فترة البحث");
            check = false;
        } else if (from_date === "" || from_date === null) {
            Warning("برجاء اختيار نهاية فترة البحث");
            check = false;
        } else {
            URL += "&from_date=" + from_date;
            URL += "&to_date=" + to_date;
        }
    } else if (execSearchType === "Month") {
        var execMm = document.getElementById("execMm").value;
        if (execMm === "" || execMm === null) {
            Warning("برجاء اختيار شهر البحث");
            check = false;
        } else {
            URL += "&execMm=" + execMm;
        }
    }

    if (check) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("LoadTrafficEmpPerm_Data").innerHTML = ""
                            + "<tr>"
                            + "   <td colspan='8'>لا توجد بيانات</td>"
                            + "</tr>";
                    status = 'f';
                } else {
                    document.getElementById("LoadTrafficEmpPerm_Data").innerHTML = message;
                    status = 'f';
                    //reloadDataTable();
                    frame(100);
                }
            }
        };
    }
}

function getEmployee() {
    var URL = "_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_3__AJAX_getEmployee?";

    var execSearchType = document.getElementById("execSearchType").value;
    URL += "execSearchType=" + execSearchType;
    if (execSearchType === "All") {

    } else if (execSearchType === "DateFromTo") {
        var from_date = document.getElementById("from_date").value;
        var to_date = document.getElementById("to_date").value;
        URL += "&from_date=" + from_date;
        URL += "&to_date=" + to_date;
    } else if (execSearchType === "Month") {
        var execMm = document.getElementById("execMm").value;
        URL += "&execMm=" + execMm;
    }

    document.getElementById("loadSpin").innerHTML = "<img src='webDesign/production/images/Spin-0.9s-200px.gif' alt='' style='width: 8%;'/>";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                Error("حدث خطأ");
            } else if (message === "NoData") {
                Warning("لا يوجد موظفين تابعين لهذه الإدارة");
                document.getElementById("EmployeeId").innerHTML = "";
            } else {
                document.getElementById("loadSpin").innerHTML = "";
                document.getElementById("EmployeeId").innerHTML = "<option value=\"\">اختر الموظف...</option>" + message;
            }
        }
    };

}
function getDash() {
    document.getElementById("DashTableLable").innerHTML = "";
    status = 't';
    frame(0);
    document.getElementById("dash_table").innerHTML = "<img src='webDesign/production/images/Spin-0.9s-200px.gif' alt='' style='width: 8%;'/>";
    var searchType = document.getElementById("searchType").value;
    var execSearchType = document.getElementById("execSearchType").value;
    var check = true;


    var URL = "_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_5__AJAX_getDash?";
    URL += "searchType=" + searchType;
    URL += "&execSearchType=" + execSearchType;
    if (searchType === "EmpId") {
        var EmployeeId = document.getElementById("EmployeeId").value;
        URL += "&EmployeeId=" + EmployeeId;
    } else if (searchType === "Val") {
        var Val = document.getElementById("Val").value;
        URL += "&Val=" + Val;
    }

    if (execSearchType === "DateFromTo") {
        var from_date = document.getElementById("from_date").value;
        var to_date = document.getElementById("to_date").value;
        if (from_date === "" || from_date === null) {
            check = false;
        } else if (from_date === "" || from_date === null) {
            check = false;
        } else {
            URL += "&from_date=" + from_date;
            URL += "&to_date=" + to_date;
        }
    } else if (execSearchType === "Month") {
        var execMm = document.getElementById("execMm").value;
        if (execMm === "" || execMm === null) {
            Warning("برجاء اختيار شهر البحث");
            check = false;
        } else {
            URL += "&execMm=" + execMm;
        }
    }

    if (check) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("dash_table").innerHTML = "";
                    Error("Error");
                    status = 'f';
                } else {
                    if (searchType !== "EmpId") {
                        document.getElementById("dash_table_Header").innerHTML = "<tr>\n"
                                + "                                                <th style=\"text-align: center;font-size: 15px;width: 15%\">الفئة</th>\n"
                                + "                                                <th style=\"text-align: center;font-size: 15px;width: 20%\">عدد الموظفين</th>\n"
                                + "                                                <th style=\"text-align: center;font-size: 15px;width: 15%\">الإجمالي</th>\n"
                                + "                                            </tr>";
                    } else {
                        document.getElementById("dash_table_Header").innerHTML = "<tr>\n"
                                + "                                                <th style=\"text-align: center;font-size: 15px;width: 15%\">الفئة</th>\n"
                                + "                                                <th style=\"text-align: center;font-size: 15px;width: 20%\">عدد شهورالاشتراك</th>\n"
                                + "                                                <th style=\"text-align: center;font-size: 15px;width: 20%\">الاجمالي</th>\n"
                                + "                                            </tr>";
                    }
                    document.getElementById("dash_table").innerHTML = message;
                    status = 'f';
                    //reloadDataTable();
                    frame(100);
                    fillDashTableLable();
                }
            }
        };
    } else {
        document.getElementById("dash_table").innerHTML = "";
        status = 'f';
        //reloadDataTable();
        frame(100);
    }
}
function getVal() {
    var URL = "_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_4__AJAX_getVal?";

    var execSearchType = document.getElementById("execSearchType").value;
    URL += "execSearchType=" + execSearchType;
    if (execSearchType === "All") {

    } else if (execSearchType === "DateFromTo") {
        var from_date = document.getElementById("from_date").value;
        var to_date = document.getElementById("to_date").value;
        URL += "&from_date=" + from_date;
        URL += "&to_date=" + to_date;
    } else if (execSearchType === "Month") {
        var execMm = document.getElementById("execMm").value;
        URL += "&execMm=" + execMm;
    }

    document.getElementById("loadSpin2").innerHTML = "<img src='webDesign/production/images/Spin-0.9s-200px.gif' alt='' style='width: 8%;'/>";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                Error("حدث خطأ");
            } else if (message === "NoData") {
                Warning("لا يوجد موظفين تابعين لهذه الإدارة");
                document.getElementById("Val").innerHTML = "";
            } else {
                document.getElementById("loadSpin2").innerHTML = "";
                document.getElementById("Val").innerHTML = "<option value=\"\">اختر الفئة...</option>" + message;
            }
        }
    };
}


function getLoad() {
    //alert(status);

    var URL = "_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_Ajax_2_getLoad_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                status = 'f';
                frame(0);
            } else {
                console.log(message);
                frame(message);
            }
        }
    };
}

function queryLoad() {
    console.log(status);
    if (status === 't') {
        getLoad();
    } else {

    }
}
var old = 0;
var New = 0;
function frame(width) {
    New = width;
    var elem = document.getElementById("load");
    if (width > 100) {
        elem.style.width = 100 + "%";
        elem.innerHTML = 100 + "%";
        clearInterval(id);
    } else {
        elem.style.width = width + "%";
        elem.innerHTML = width + "%";
    }
    old = width;
}

$(function () {
    $(".SELECT_Combo").select2();
});

function fillDashTableLable() {
    var execSearchType = document.getElementById("execSearchType").value;
    var searchType = document.getElementById("searchType").value;

    var execSearchTypeString = "";
    var searchTypeString = "";

    if (execSearchType === "All") {
        execSearchTypeString = "ككل";
    } else if (execSearchType === "DateFromTo") {
        var from_date = document.getElementById("from_date").value;
        var to_date = document.getElementById("to_date").value;
        execSearchTypeString = "- عن الفترة من ";
        execSearchTypeString += from_date;
        execSearchTypeString += " إلى ";
        execSearchTypeString += to_date;
        execSearchTypeString += " ";
    } else if (execSearchType === "Month") {
        var execMm_element = document.getElementById("execMm");
        var execMm = execMm_element.options[execMm_element.selectedIndex].text;
        execSearchTypeString = "- عن شهر ";
        execSearchTypeString += execMm;
    }
    if (searchType === "All") {
        searchTypeString = "عدد الموظفين وفئات الإشتراكات ومجموعها ";
    } else if (searchType === "EmpId") {
        var EmpName_element = document.getElementById("EmployeeId");
        var EmpName = EmpName_element.options[EmpName_element.selectedIndex].text;
        searchTypeString = "اجمالي فئات الاشتراك الخاصة بالموظف: ";
        searchTypeString += EmpName;
        searchTypeString += " ";
    } else if (searchType === "Val") {
        var Val = document.getElementById("Val").value;
        searchTypeString = "مجموع الموظفين واجمالي الاشتراكات في الفئة ";
        searchTypeString += Val;
        searchTypeString += " ";
    }
    document.getElementById("DashTableLable").innerHTML = "بيان احصائي عن ";
    document.getElementById("DashTableLable").innerHTML += searchTypeString;
    document.getElementById("DashTableLable").innerHTML += execSearchTypeString;
}


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