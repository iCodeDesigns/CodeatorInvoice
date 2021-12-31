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

function addToVcleVehicleRequire(DepNoOld, SectionNoOld) {

    var requireDate = document.getElementById("requireDate").value;
    var requireStartHour = document.getElementById("requireStartHour").value;
    var EmployeeId = document.getElementById("EmployeeId").value;
    var guestNo = document.getElementById("guestNo").value;
    var VcleType = document.getElementById("VcleType").value;
    var driverPlace = document.getElementById("driverPlace").value;
    var requireType = document.getElementById("requireType").value;
    var no_of_days = document.getElementById("no_of_days").value;
    var requirePlace = document.getElementById("requirePlace").value;
    var RequireEndHour = document.getElementById("RequireEndHour").value;

    if (requireDate === null || requireDate === "") {
        //alert("x");
        Warning("برجاء ملئ تاريخ الطلب");
        //Go_2();
    } else if (requireStartHour === null || requireStartHour === "") {
        Warning("برجاء ملئ توقيت الطلب");
        //Go_2();
    } else if (DepNoOld === null || DepNoOld === "") {
        Warning("لا توجد قسم");
        //Go_2();
    } else if (SectionNoOld === null || SectionNoOld === "") {
        Warning("لا يوجد قطاع");
        //Go_2();
    } else if (EmployeeId === null || EmployeeId === "") {
        Warning("برجاء اختيار اسم طالب السيارة");
        //Go_2();
    } else if (guestNo === null || guestNo === "") {
        Warning("برجاء ملئ عدد الركاب");
        //Go_2();
    } else if (VcleType === null || VcleType === "") {
        Warning('برجاء ملئ نوع المركبة');
        //Go_2();
    } else if (requireType === null || requireType === "") {
        Warning('برجاء ملئ نوع الطلب');
        //Go_1();
    } else if (no_of_days === null || no_of_days === "") {
        Warning('برجاء ملئ عدد أيام الرحلة');
        //Go_2();
    } else if (requirePlace === null || requirePlace === "") {
        Warning('برجاء ملئ خط السير');
        //Go_2();
    } else {
        document.getElementById("SubmitBtn").innerHTML = "<img src='webDesign/build/images/Infinity-1.1s-200px.gif' alt='Infinity-1.1s-200px' style='width: 15%;'/>";
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function ()
        {
            if (xhttp.readyState === 4 && xhttp.status === 200)
            {
                var msg = xhttp.responseText;
                //alert(msg);
                if (msg === 'Done') {
                    Success("تم تسجيل الطلب بنجاح");
                    clearFields();
                    setInterval(Reload, 2000);
                } else {
                    Error("حدث خطأ أثناء تسجيل الطلب .. يرجى إعادة المحاولة لاحقا");
                    document.getElementById("SubmitBtn").innerHTML = "<button type=\"button\" data-placement=\"top\" onclick=\"addToVcleVehicleRequire('" + DepNoOld + "','" + SectionNoOld + "');\" class=\"button_style btn btn-sm btn-primary button_position fa fa-save\" style=\"box-shadow: -1px 2px 5px 1px black;font-weight: bold;font-size: 20px;\" data-toggle=\"modal\" data-target='#x'>حفظ</button>";
                }
            }

        };
        xhttp.open("POST", "_0_0_0_2_1_Car_Request_1__AJAX_addToVcleVehicleRequire?" +
                "requireDate=" + requireDate +
                "&requireStartHour=" + requireStartHour +
                "&DepNoOld=" + DepNoOld +
                "&SectionNoOld=" + SectionNoOld +
                "&EmployeeId=" + EmployeeId +
                "&guestNo=" + guestNo +
                "&VcleType=" + VcleType +
                "&driverPlace=" + driverPlace +
                "&requireType=" + requireType +
                "&no_of_days=" + no_of_days +
                "&requirePlace=" + requirePlace +
                "&RequireEndHour=" + RequireEndHour, true);
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

////////////////////////////////////////////////////////////////////////////////////
//Table Queries
function getVcleVcleRequestDetail(RequireSp) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_1_Car_Request_3__AJAX_getVcleVehicleRequireByRequireSp?" +
            "RequireSp=" + RequireSp, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var msg = xhttp.responseText;
            //alert(msg);
            if (msg === 'Error') {
                Error('حدث خطأ...!');
            } else {
                document.getElementById("vcleVcleRequireDT_Table").innerHTML = msg;
            }
        }
    };
}
function getVcleVcleRequests() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_1_Car_Request_4__AJAX_getVcleVehicleRequires?", true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var msg = xhttp.responseText;
            //alert(msg);
            if (msg === 'Error') {
                Error('حدث خطأ...!');
            } else {
                document.getElementById("vcleVcleRequires_Table").innerHTML = msg;
            }
        }
    };
}
////////////////////////
function getRMRK(requireSp, requireStatus) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_1_Car_Request_5__AJAX_getVcleVehicleRequiresRmrk?requireSp=" + requireSp + "&requireStatus=" + requireStatus, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var msg = xhttp.responseText;
            //alert(msg);
            if (msg === 'Error') {
                Error('حدث خطأ...!');
            } else {
                document.getElementById("vcleVcleRequiresRmrk_DIV").innerHTML = msg;
            }
        }
    };
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