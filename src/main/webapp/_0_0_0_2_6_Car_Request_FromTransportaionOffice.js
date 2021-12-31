
setInterval(searchByDeptCheck, 500);
var checkSearch = false;
function searchByDeptCheck() {
    checkSearch = document.getElementById("checkSearch").checked;
    if (checkSearch === true) {
        document.getElementById("byEmpDiv-emp").style.display = "none";
        document.getElementById("byDeptDiv-emp").style.display = "block";
        document.getElementById("byEmpDiv-dept").style.display = "none";
        document.getElementById("byDeptDiv-dept").style.display = "block";
    } else {
        document.getElementById("byEmpDiv-emp").style.display = "block";
        document.getElementById("byDeptDiv-emp").style.display = "none";
        document.getElementById("byEmpDiv-dept").style.display = "block";
        document.getElementById("byDeptDiv-dept").style.display = "none";
    }
}
function resetSearchCheck() {
    document.getElementById("SectionName").value = "";
    document.getElementById("EmployeeName").value = "";
    document.getElementById("EmployeeIdCombo").value = "";
    document.getElementById("select2-EmployeeIdCombo-container").innerHTML = "";
    document.getElementById("DepNameCombo").value = "";
    document.getElementById("select2-DepNameCombo-container").innerHTML = "";
    document.getElementById("EmployeeId").innerHTML = "";
    document.getElementById("DepName").innerHTML = "";
}
function getDepOld() {
    var SectionName = document.getElementById("SectionName").value;
    if (SectionName === "" || SectionName === null) {

    } else {
        var URL = "_0_0_0_2_6_Car_Request_FromTransportaionOffice_1__AJAX_getDepOld?SectionName=" + SectionName;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                } else if (message === "NoData") {
                    Warning("لا توجد إدارات تابعة لهذا القطاع");
                    document.getElementById("EmployeeId").innerHTML = "";
                    document.getElementById("DepName").innerHTML = "";
                } else {
                    document.getElementById("DepName").innerHTML = "<option value=\"\">اختر الادارة ...</option>" + message;
                    document.getElementById("EmployeeId").innerHTML = "";
                }
            }
        };
    }
}


function getSection() {
    document.getElementById("EmployeeIdCombo").innerHTML = "";
    document.getElementById("SectionName").value = "";
    var DepNameCombo = document.getElementById("DepNameCombo").value;
    if (DepNameCombo === "" || DepNameCombo === null) {

    } else {
        var URL = "_0_0_0_2_6_Car_Request_FromTransportaionOffice_6__AJAX_getSectionByDept?DepNameCombo=" + DepNameCombo;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                } else if (message === "NoData") {
                    Warning("لا يوجد قسم");
                    document.getElementById("SectionName").innerHTML = "";
                } else {
                    document.getElementById("SectionName").innerHTML = message;
                    setTimeout(getEmployeeByDept(), 5000);
                }
            }
        };
    }
}

function getEmployeeByDept() {
    var DepName = document.getElementById("DepNameCombo").value;
    var SectionName = document.getElementById("SectionName").value;
    if (DepName === "" || DepName === null || SectionName === "" || SectionName === null) {

    } else {
        document.getElementById("loadSpin").innerHTML = "<img src='webDesign/production/images/Spin-0.9s-200px.gif' alt='' style='width: 8%;'/>";
        var URL = "_0_0_0_2_6_Car_Request_FromTransportaionOffice_2__AJAX_getEmployeeByDept?DepName=" + DepName + "&SectionName=" + SectionName;
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
                    document.getElementById("EmployeeIdCombo").innerHTML = "";
                } else {
                    document.getElementById("loadSpin").innerHTML = "";
                    document.getElementById("EmployeeIdCombo").innerHTML = "<option value=\"\">اختر الموظف...</option>" + message;
                }
            }
        };
    }
}

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

init();
function init() {
    setThisDayToDateField();
    getVcleTypeAJAX();
}
function setThisDayToDateField() {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;
    var day = now.getDate();
    document.getElementById("requireDate").value = "" + year + "-" + month + "-" + day;
}

function SearchType() {
    var S1 = document.getElementById("S1").checked;
    var S1 = document.getElementById("S1").checked;
    if (S1) {
        document.getElementById("Search2").style.display = "none";
    } else {
        document.getElementById("Search2").style.display = "block";
    }
}
setInterval(SearchType, 1);
function addToVcleVehicleRequire(AddType) {
    var Check = false;
    var checkSearchStatus = "";
    var requireDate = document.getElementById("requireDate").value;
    var requireStartHour = document.getElementById("requireStartHour").value;
    var EmployeeId = "";
    var DepNoOld = "";
    if (checkSearch === true) {
        DepNoOld = document.getElementById("DepNameCombo").value;
        EmployeeId = document.getElementById("EmployeeIdCombo").value;
        checkSearchStatus = "byDept";
    } else {
        DepNoOld = document.getElementById("DepName").value;
        EmployeeId = document.getElementById("EmployeeId").value;
        checkSearchStatus = "byEmp";
    }
    var SectionNoOld = document.getElementById("SectionName").value;
    var guestNo = document.getElementById("guestNo").value;
    var VcleType = document.getElementById("VcleType").value;
    var driverPlace = document.getElementById("driverPlace").value;
    var requireType = document.getElementById("requireType").value;
    var requirePlace = document.getElementById("requirePlace").value;
    var RequireEndHour = document.getElementById("RequireEndHour").value;
    var S1 = document.getElementById("S1").checked;
    if (AddType === "Reject") {
        var rmrk = document.getElementById("editor-one").innerHTML;
    }

    if (requireDate === null || requireDate === "") {
        Check = false;
    } else if (requireStartHour === null || requireStartHour === "") {
        Check = false;
        Warning("برجاء ملئ توقيت الطلب");
    } else if (SectionNoOld === null || SectionNoOld === "") {
        Check = false;
        Warning("برجاء إختيار قسم");
    } else if (DepNoOld === null || DepNoOld === "") {
        Check = false;
        Warning("برجاء إختيار إدارة");
    } else if (EmployeeId === null || EmployeeId === "") {
        Check = false;
        Warning("برجاء اختيار اسم طالب السيارة");
    } else if (guestNo === null || guestNo === "") {
        Check = false;
        Warning("برجاء ملئ عدد الركاب");
    } else if (VcleType === null || VcleType === "") {
        Check = false;
        Warning('برجاء ملئ نوع المركبة');
    } else if (requireType === null || requireType === "") {
        Check = false;
        Warning('برجاء ملئ نوع الطلب');
    } else if (requirePlace === null || requirePlace === "") {
        Check = false;
        Warning('برجاء ملئ خط السير');
    } else if (AddType === "Reject" && (rmrk === "" || rmrk === null)) {
        Warning("برجاء ملئ سبب الرفض");
        Check = false;
    } else {
        Check = true;
    }
    if (S1 === false) {
        if (RequireEndHour === null || RequireEndHour === "") {
            Warning("برجاء ملئ توقيت العودة");
            Check = false;
        } else {
            Check = true;
        }
    }
    if (Check === true) {
        document.getElementById("SubmitBtn").innerHTML = "<img src='webDesign/build/images/Infinity-1.1s-200px.gif' alt='Infinity-1.1s-200px' style='width: 15%;'/>";
        document.getElementById("delBtn").innerHTML = "<img src='webDesign/build/images/Infinity-1.1s-200px.gif' alt='Infinity-1.1s-200px' style='width: 15%;'/>";
        
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function ()
        {
            if (xhttp.readyState === 4 && xhttp.status === 200)
            {
                var msg = xhttp.responseText;
                //alert(msg);
                if (msg === 'Done') {
                    Success("تم تسجيل الطلب بنجاح");
                    setInterval(Reload, 2000);
                } else if (msg === 'Error') {
                    Error("حدث خطأ أثناء تسجيل الطلب .. يرجى إعادة المحاولة لاحقا");
                    document.getElementById("SubmitBtn").innerHTML = "<a href=\"#\" class=\"buttonNext buttonDisabled btn btn-success\" style=\"width: 20%; font-weight: bold;\" onclick=\"addToVcleVehicleRequire('Normal');\">حفظ مع الموافقة</a>\n" +
                            "                                <a href=\"#\" data-toggle=\"modal\" data-target=\"#IgnorReasonDiv\" class=\"buttonPrevious btn btn-danger\" style=\"width: 20%; font-weight: bold;\">حفظ مع الرفض</a><br><br>";
                    document.getElementById("delBtn").innerHTML = "<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" style=\"font-weight: bold;border-color: black;width: 15%;\">اغلاق</button>";
                } else {
                    Warning(msg);
                    document.getElementById("SubmitBtn").innerHTML = "<a href=\"#\" class=\"buttonNext buttonDisabled btn btn-success\" style=\"width: 20%; font-weight: bold;\" onclick=\"addToVcleVehicleRequire('Normal');\">حفظ مع الموافقة</a>\n" +
                            "                                <a href=\"#\" data-toggle=\"modal\" data-target=\"#IgnorReasonDiv\" class=\"buttonPrevious btn btn-danger\" style=\"width: 20%; font-weight: bold;\">حفظ مع الرفض</a><br><br>";
                    document.getElementById("delBtn").innerHTML = "<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" style=\"font-weight: bold;border-color: black;width: 15%;\">اغلاق</button>";
                }
            }

        };
        if (driverPlace === "" || driverPlace === null) {
            driverPlace = "الأهرام";
        }

        var URL = "_0_0_0_2_6_Car_Request_FromTransportaionOffice_3__AJAX_addToVcleVehicleRequire?" +
                "AddType=" + AddType +
                "&checkSearchStatus=" + checkSearchStatus +
                "&requireDate=" + requireDate +
                "&requireStartHour=" + requireStartHour +
                "&DepNoOld=" + DepNoOld +
                "&SectionNoOld=" + SectionNoOld +
                "&EmployeeId=" + EmployeeId +
                "&guestNo=" + guestNo +
                "&VcleType=" + VcleType +
                "&driverPlace=" + driverPlace +
                "&requireType=" + requireType +
                "&requirePlace=" + requirePlace +
                "&RequireEndHour=" + RequireEndHour;
        if (AddType === "Reject") {
            URL += "&rmrk=" + rmrk;
        }
        xhttp.open("POST", URL, true);
        xhttp.send();
    }

}

function getVcleTypeAJAX() {
    var guestNo = document.getElementById("guestNo").value;
    var xhttp = new XMLHttpRequest();
    var URL = "_0_0_0_2_1_Car_Request_2__AJAX_getVcleTypeByGuestNo?guestNo=" + guestNo;
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            document.getElementById("VcleType").innerHTML = xhttp.responseText;
        }

    };
}


function checkAlert() {
    var no_of_days = document.getElementById("no_of_days").value;
    if (no_of_days > 1) {
        document.getElementById("WarningDiv").style.display = "block";
    } else {
        document.getElementById("WarningDiv").style.display = "none";
    }
}

function Reload() {
    location.reload();
}


function clearFields() {
    TodayName();
    document.getElementById("requireStartHour").value = "";
    document.getElementById("EmployeeId").value = "";
    document.getElementById("guestNo").value = "";
    document.getElementById("VcleType").value = "";
    document.getElementById("driverPlace").value = "";
    document.getElementById("requireType").value = "";
    document.getElementById("no_of_days").value = "";
    document.getElementById("requirePlace").value = "";
    document.getElementById("RequireEndHour").value = "";
}

function getEmpDataByNameSearch() {
    var EmployeeName = document.getElementById("EmployeeName").value;
    var EmployeeNameArr = EmployeeName.split(" ");
    if (EmployeeName === "" || EmployeeName === null) {
//Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("EmployeeId").innerHTML = "";
    } else if (EmployeeNameArr.length < 3) {
        document.getElementById("EmployeeId").innerHTML = "";
    } else {
        var URL = "_0_0_0_2_6_Car_Request_FromTransportaionOffice_4__AJAX_getEmployeesData?";
        URL += "EmployeeName=" + EmployeeName;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    Error("حدث خطأ");
                    document.getElementById("EmployeeId").innerHTML = "";
                } else {
                    document.getElementById("EmployeeId").innerHTML = message;
                }
            }
        };
    }
}

function copyName() {
    var EmpName_element = document.getElementById("EmployeeId");
    var EmpName = EmpName_element.options[EmpName_element.selectedIndex].text;
    document.getElementById("EmployeeName").value = EmpName;
    getdeptByEmp();
}

function getdeptByEmp() {
    var empId = document.getElementById("EmployeeId").value;
    if (empId === "" || empId === null) {

    } else {
        var URL = "_0_0_0_2_6_Car_Request_FromTransportaionOffice_5__AJAX_getDeptByEmpId?empId=" + empId;
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
                    document.getElementById("DepName").value = "";
                } else {
                    var Message = message.split("cutarry");
                    var Dept = Message[0];
                    var section = Message[1];
                    document.getElementById("DepName").innerHTML = Dept;
                    document.getElementById("SectionName").innerHTML = section;
                }
            }
        };
    }
}

$(function () {
    $(".SELECT_Combo").select2();
});
function Go_1() {
    $("#wizard").smartWizard("goToStep", "1");
}
function Go_2() {
    $("#wizard").smartWizard("goToStep", "2"); //disableStep
}

function clearText() {
    document.getElementById("editor-one").innerHTML = "";
    checkText();
}
function checkText() {
    var causeOfIgnore = document.getElementById("editor-one").innerHTML;
    var percentage = (+causeOfIgnore.length * (+100)) / (+500);

    document.getElementById("percentage").innerHTML = percentage + "%";
    if (percentage > 100) {
        document.getElementById("delBtn").style.display = "none";
        return false;
    } else {
        document.getElementById("delBtn").style.display = "block";
        return true;
    }
}
function clearText2() {
    document.getElementById("editor-one2").innerHTML = "";
    checkText();
}
function checkText2() {
    var causeOfIgnore = document.getElementById("editor-one2").innerHTML;
    var percentage = (+causeOfIgnore.length * (+100)) / (+500);

    document.getElementById("percentage2").innerHTML = percentage + "%";
    if (percentage > 100) {
        document.getElementById("delBtn2").style.display = "none";
        return false;
    } else {
        document.getElementById("delBtn2").style.display = "block";
        return true;
    }
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

