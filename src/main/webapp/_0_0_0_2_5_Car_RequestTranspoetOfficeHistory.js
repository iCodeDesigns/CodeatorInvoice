/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

init();
function init() {
}

function getCarsInThisPeriod() {
    var from_date = document.getElementById("from_date").value;
    var to_date = document.getElementById("to_date").value;
    var check = true;
    if (from_date === null || from_date === "") {
        Warning("لا بد من إختيار التاريخ من");
        check = false;
    } else if (to_date === null || to_date === "") {
        Warning("لا بد من إختيار التاريخ إلى");
        check = false;
    } else {
        var URL = "_0_0_0_2_5_Car_RequestTranspoetOfficeHistory_2__AJAX_getCarBoardNumber?from_date=" + from_date + "&to_date=" + to_date;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function ()
        {
            if (xhttp.readyState === 4 && xhttp.status === 200)
            {
                var status = xhttp.responseText;
                if (status === "Error") {
                    Error("حدث خطأ في إستقبال أرقام السيارات");
                } else {
                    if (status === "NoData") {
                        Warning("لا توجد سيارات في تلك الفترة");
                        document.getElementById("BoardNumber").innerHTML = "";
                    } else {
                        document.getElementById("BoardNumber").innerHTML = status;
                    }
                }
            }
        };
    }

}
function getDriversInThisPeriod() {
    var from_date = document.getElementById("from_date").value;
    var to_date = document.getElementById("to_date").value;
    var check = true;
    if (from_date === null || from_date === "") {
        Warning("لا بد من إختيار التاريخ من");
        check = false;
    } else if (to_date === null || to_date === "") {
        Warning("لا بد من إختيار التاريخ إلى");
        check = false;
    } else {
        var URL = "_0_0_0_2_5_Car_RequestTranspoetOfficeHistory_3__AJAX_getDriversNames?from_date=" + from_date + "&to_date=" + to_date;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function ()
        {
            if (xhttp.readyState === 4 && xhttp.status === 200)
            {
                var status = xhttp.responseText;
                if (status === "Error") {
                    Error("حدث خطأ في إستقبال أسماء السائقين");
                } else {
                    if (status === "NoData") {
                        Warning("لا يوجد سائقين في تلك الفترة");
                        document.getElementById("driver_id").innerHTML = "";
                    } else {
                        document.getElementById("driver_id").innerHTML = status;
                    }
                }
            }
        };
    }
}
function getReportDetail() {
    var Report_Namozag = document.getElementById("reportType").value;

    document.getElementById("SearchButton").innerHTML = "جاري إستقبال البيانات ...";
    document.getElementById("loadingData1").innerHTML = "جاري إستقبال البيانات ...";
    document.getElementById("BodyTable").innerHTML = "";
    var BoardNumber = document.getElementById("BoardNumber").value;
    var driver_id = document.getElementById("driver_id").value;
    var from_date = document.getElementById("from_date").value;
    var to_date = document.getElementById("to_date").value;

    var check = true;
    var carSearch = document.getElementById("carSearch").checked;
    var driverSearch = document.getElementById("driverSearch").checked;
    var fullSearch = document.getElementById("fullSearch").checked;

    var URL = "";
    if (Report_Namozag === "report1") {
        URL += "_0_0_0_2_5_Car_RequestTranspoetOfficeHistory_1__AJAX_TripsHistoryReport";
    } else if (Report_Namozag === "report2") {
        URL += "_0_0_0_2_5_Car_RequestTranspoetOfficeHistory_1__AJAX_TripsHistoryReport2";
    }
    URL += "?from_date=" + from_date + "&to_date=" + to_date;
    if (carSearch) {
        URL += "&BoardNumber=" + BoardNumber;
        URL += "&carSearch=true";
        URL += "&driverSearch=false";
        URL += "&fullSearch=false";
        if (BoardNumber === null || BoardNumber === "") {
            Warning("لا بد من إختيار رقم سيارة");
            check = false;
        }
    } else if (driverSearch) {
        URL += "&driver_id=" + driver_id;
        URL += "&carSearch=false";
        URL += "&driverSearch=true";
        URL += "&fullSearch=false";
        if (driver_id === null || driver_id === "") {
            Warning("لا بد من إختيار سائق");
            check = false;
        }
    } else if (fullSearch) {
        URL += "&carSearch=false";
        URL += "&driverSearch=false";
        URL += "&fullSearch=true";
        var reportType = document.getElementById("reportType").value;
        if (reportType === "report2") {
            var AllSearchCar = document.getElementById("AllSearchCar").checked;
            var AllSearchDriver = document.getElementById("AllSearchDriver").checked;
            if (AllSearchCar) {
                URL += "&AllSearchCar=true";
                URL += "&AllSearchDriver=false";
            } else if (AllSearchDriver) {
                URL += "&AllSearchCar=false";
                URL += "&AllSearchDriver=true";
            }
        }

    }
    if (from_date === null || from_date === "") {
        Warning("لا بد من إختيار التاريخ من");
        check = false;
    } else if (to_date === null || to_date === "") {
        Warning("لا بد من إختيار التاريخ إلى");
        check = false;
    }


    if (check) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function ()
        {
            if (xhttp.readyState === 4 && xhttp.status === 200)
            {
                var status = xhttp.responseText;
                if (status === "Error") {
                    document.getElementById("SearchButton").innerHTML = "<button type='button' onclick='getReportDetail();' class='btn btn-custon-four btn-primary' style='width: 100%;'><i class='fa fa-search adminpro-checked-pro' aria-hidden='true'></i> بحث </button>";
                    document.getElementById("loadingData1").innerHTML = "جاري إستقبال البيانات ...";
                    Error("حدث خطأ في إستقبال البيانات");
                } else {
                    Success("تم إستقبال البيانات");
                    document.getElementById("BodyTable").innerHTML = status;
                    document.getElementById("SearchButton").innerHTML = "<button type='button' onclick='getReportDetail();' class='btn btn-custon-four btn-primary' style='width: 100%;'><i class='fa fa-search adminpro-checked-pro' aria-hidden='true'></i> بحث </button>";
                    document.getElementById("loadingData1").innerHTML = "";
                }
            }
        };
    } else {
        document.getElementById("SearchButton").innerHTML = "<button type='button' onclick='getReportDetail();' class='btn btn-custon-four btn-primary' style='width: 100%;'><i class='fa fa-search adminpro-checked-pro' aria-hidden='true'></i> بحث </button>";
        document.getElementById("loadingData1").innerHTML = "";
    }
}
function getTalabatOfThisTrip(goingSP) {
    document.getElementById("loadData3").innerHTML = "جاري إستقبال البيانات";
    var URL = "_0_0_0_2_5_Car_RequestTranspoetOfficeHistory_2__AJAX_TripsTalabat?goingSP=" + goingSP;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var status = xhttp.responseText;
            if (status === "Error") {
                document.getElementById("loadData3").innerHTML = "جاري إستقبال البيانات";
                Error("حدث خطأ في إستقبال البيانات");
            } else {
                document.getElementById("Talabat_DIV3").innerHTML = status;
                document.getElementById("loadData3").innerHTML = "";
            }
        }
    };
}
function getTripsOfThisCar(BoardNumber, from_date, to_date) {
    document.getElementById("loadData2").innerHTML = "جاري إستقبال البيانات";
    var URL = "_0_0_0_2_5_Car_RequestTranspoetOfficeHistory_4__AJAX_CarTrips?BoardNumber=" + BoardNumber + "&from_date=" + from_date + "&to_date=" + to_date;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var status = xhttp.responseText;
            if (status === "Error") {
                document.getElementById("loadData2").innerHTML = "جاري إستقبال البيانات";
                Error("حدث خطأ في إستقبال البيانات");
            } else {
                document.getElementById("Talabat_DIV2").innerHTML = status;
                document.getElementById("loadData2").innerHTML = "";
            }
        }
    };
}
function getTripsOfThisDriver(driver_id, from_date, to_date) {
    document.getElementById("loadData2").innerHTML = "جاري إستقبال البيانات";
    var URL = "_0_0_0_2_5_Car_RequestTranspoetOfficeHistory_5__AJAX_DriverTrips?driver_id=" + driver_id + "&from_date=" + from_date + "&to_date=" + to_date;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var status = xhttp.responseText;
            if (status === "Error") {
                document.getElementById("loadData2").innerHTML = "جاري إستقبال البيانات";
                Error("حدث خطأ في إستقبال البيانات");
            } else {
                document.getElementById("Talabat_DIV2").innerHTML = status;
                document.getElementById("loadData2").innerHTML = "";
            }
        }
    };
}


function applyMethode() {
    GetFullCarNumber();
}
setInterval(SearchType, 1);
function SearchType() {
    var carSearch = document.getElementById("carSearch").checked;
    var driverSearch = document.getElementById("driverSearch").checked;
    var fullSearch = document.getElementById("fullSearch").checked;
    if (carSearch) {
        document.getElementById("CarSearch").style.display = "block";
        document.getElementById("DriverSearch").style.display = "none";
        document.getElementById("ALLSearch").style.display = "none";
    } else if (driverSearch) {
        document.getElementById("CarSearch").style.display = "none";
        document.getElementById("DriverSearch").style.display = "block";
        document.getElementById("ALLSearch").style.display = "none";
    } else if (fullSearch) {
        document.getElementById("CarSearch").style.display = "none";
        document.getElementById("DriverSearch").style.display = "none";
        var reportType = document.getElementById("reportType").value;
        if (reportType === "report2") {
            document.getElementById("ALLSearch").style.display = "block";
        } else {
            document.getElementById("ALLSearch").style.display = "none";
        }
    }
}


function Sound() {
    var soundFx = $('#soundFX'); // Get our sound FX.
    soundFx[0].play(); // Plays sound.
}

// AJAX Part
function GetFullCarNumber() {
    var BoardDigital = document.getElementById("BoardDigital").value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            document.getElementById("BoardNumber").innerHTML = xhttp.responseText;
        }

    };
    var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_1__AJAX_getFullCarNumber?BoardDigital=" + BoardDigital;
    xhttp.open("POST", URL, true);
    xhttp.send();
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