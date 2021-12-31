var status = 'f';
setInterval(queryLoad, 100);

function searchType() {
    resetSearch();
    var searchType = document.getElementById("searchType").value;
    if (searchType === "All") {
        document.getElementById("CarNumberDiv").style.display = "none";
        document.getElementById("CarModelDiv").style.display = "none";
        document.getElementById("CarTypeDiv").style.display = "none";
        document.getElementById("DriverDiv").style.display = "none";
    } else if (searchType === "Driver") {
        document.getElementById("CarNumberDiv").style.display = "none";
        document.getElementById("CarModelDiv").style.display = "none";
        document.getElementById("CarTypeDiv").style.display = "none";
        document.getElementById("DriverDiv").style.display = "block";
    } else if (searchType === "CarNumber") {
        document.getElementById("CarNumberDiv").style.display = "block";
        document.getElementById("CarModelDiv").style.display = "none";
        document.getElementById("CarTypeDiv").style.display = "none";
        document.getElementById("DriverDiv").style.display = "none";
    } else if (searchType === "CarModel") {
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
    }
}

function searchSubmit() {
    status = 't';
    frame(0);
    document.getElementById("VcleVehicleDriverJoin_Data").innerHTML = "";
    var searchType = document.getElementById("searchType").value;
    var check = true;


    var URL = "_0_0_0_2_7_Vehicle_Driver_Join_query_1__AJAX_LoadVehicleDriverJoin_AjaxServlet?searchType=" + searchType;
    if (searchType === "Driver") {
        var EmployeeId = document.getElementById("EmployeeId").value;
        URL += "&EmployeeId=" + EmployeeId;
        if (EmployeeId === "" || EmployeeId === null) {
            Warning("برجاء اختيار سائق");
            check = false;
        }
    } else if (searchType === "CarNumber") {
        var BoardNumber = document.getElementById("BoardNumber").value;
        URL += "&BoardNumber=" + BoardNumber;
        if (BoardNumber === "" || BoardNumber === null) {
            Warning("برجاء اختيار رقم المركبة");
            check = false;
        }
    } else if (searchType === "CarModel") {
        var ModelCode = document.getElementById("ModelCode").value;
        URL += "&ModelCode=" + ModelCode;
        if (ModelCode === "" || ModelCode === null) {
            Warning("برجاء اختيار موديل المركبة");
            check = false;
        }
    } else if (searchType === "CarType") {
        var VcleType = document.getElementById("VcleType").value;
        URL += "&VcleType=" + VcleType;
        if (VcleType === "" || VcleType === null) {
            Warning("برجاء اختيار نوع المركبة");
            check = false;
        }
    } else {

    }

    if (check) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("VcleVehicleDriverJoin_Data").innerHTML = ""
                            + "<tr>"
                            + "   <td colspan='8'>لا توجد بيانات</td>"
                            + "</tr>";
                    status = 'f';
                } else {
                    document.getElementById("VcleVehicleDriverJoin_Data").innerHTML = message;
                    status = 'f';
                    //reloadDataTable();
                    frame(100);
                }
            }
        };
    }
}

function getLoad() {
    //alert(status);

    var URL = "_0_0_0_2_7_Vehicle_Driver_Join_query_Ajax_2_getLoad_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {

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

function resetSearch() {
    document.getElementById("VcleVehicleDriverJoin_Data").innerHTML = "";
    document.getElementById("EmployeeId").value = "";
    document.getElementById("BoardNumber").value = "";
    document.getElementById("ModelCode").value = "";
    document.getElementById("VcleType").value = "";
}

$(function () {
    $(".SELECT_Combo").select2();
});


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