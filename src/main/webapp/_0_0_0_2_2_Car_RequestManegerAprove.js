/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var DepNoOld = "";

function DeptOldFunction(GeneralDeptOld) {
    DepNoOld = GeneralDeptOld;
}

setInterval(LoadTablesEach5Min, 10000);
function LoadTablesEach5Min() {
    LoadMainTable();
}
function LoadMainTable() {
    var Type = "1"; // 1- if Data >> Get report
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_2_Car_RequestManegersRequestHandeler_1__AJAX_getEltalabatToManagerToDecide?DataNeeded=" + Type + "&DeptNoOld=" + DepNoOld, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var msg = xhttp.responseText;
            //alert(msg);
            if (msg === 'Error') {
            } else {
                document.getElementById("MainTable").innerHTML = msg;
                LoadNumberOfRequests();
            }
        }

    };
}

function LoadNumberOfRequests() {
    var Type = "2"; //2- if NumberOfRequests >> Get number of records
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_2_Car_RequestManegersRequestHandeler_1__AJAX_getEltalabatToManagerToDecide?DataNeeded=" + Type + "&DeptNoOld=" + DepNoOld, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var msg = xhttp.responseText;
            //alert(msg);
            if (msg === 'Error') {
            } else {
                document.getElementById("numberOfRequestsID").innerHTML = msg;
            }
            LoadMo3tamadaRequestsTable();
        }

    };
}

function LoadMo3tamadaRequestsTable() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_2_Car_RequestManegersRequestHandeler_3__AJAX_getMo3tamadaRequests?DeptNoOld=" + DepNoOld, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var msg = xhttp.responseText;
            //alert(msg);
            if (msg === 'Error') {
            } else {
                document.getElementById("Mo3tamadaID").innerHTML = msg;
            }
            LoadTalabatMo3alakaOrange();
        }

    };
}

function LoadTalabatMo3alakaOrange() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_2_Car_RequestManegersRequestHandeler_4__AJAX_getTalabatMo3alaka?DeptNoOld=" + DepNoOld, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var msg = xhttp.responseText;
            //alert(msg);
            if (msg === 'Error') {
            } else {
                document.getElementById("TalabatMo3alakaOrange").innerHTML = msg;
            }
            LoadTalabatMarfodaRed();
        }
    };
}

function LoadTalabatMarfodaRed() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_2_Car_RequestManegersRequestHandeler_5__AJAX_getTalabatMo3alaka?DeptNoOld=" + DepNoOld, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var msg = xhttp.responseText;
            //alert(msg);
            if (msg === 'Error') {
            } else {
                document.getElementById("TalabatMarfodaRed").innerHTML = msg;
            }
        }

    };
}

function getReportDetail(deptId) {
    document.getElementById("loadData2").innerHTML = "جاري إستقبال البيانات ...";
    document.getElementById("QueryResult").innerHTML = "";
    var check = true;
    var from_date = document.getElementById("from_date").value;
    var to_date = document.getElementById("to_date").value;
    //var deptId = <%=PEM.getPerDeptOld().getId().getDepNoOld()%>
    var URL = "_0_0_0_2_2_Car_RequestManegersRequestHandeler_2__AJAX_getRequestsData?from_date=" + from_date + "&to_date=" + to_date + "&deptId=" + deptId;
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
                    document.getElementById("loadData2").innerHTML = "جاري إستقبال البيانات ...";
                    Error("حدث خطأ في إستقبال البيانات");
                } else {
                    Success("تم إستقبال البيانات");
                    document.getElementById("QueryResult").innerHTML = status;
                    document.getElementById("SearchButton").innerHTML = "<button type='button' onclick='getReportDetail();' class='btn btn-custon-four btn-primary' style='width: 100%;'><i class='fa fa-search adminpro-checked-pro' aria-hidden='true'></i> بحث </button>";
                    document.getElementById("loadData2").innerHTML = "";
                }
            }
        };
    } else {
        document.getElementById("SearchButton").innerHTML = "<button type='button' onclick='getReportDetail();' class='btn btn-custon-four btn-primary' style='width: 100%;'><i class='fa fa-search adminpro-checked-pro' aria-hidden='true'></i> بحث </button>";
        document.getElementById("loadData2").innerHTML = "";
    }
}
function clearText() {
    document.getElementById("editor-one").innerHTML = "";
    checkText();
}
function ActivateRequest(RequireSp, EmployeeEnchuranceNumber) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var msg = xhttp.responseText;
            //alert(msg);
            if (msg === 'Done') {
                document.getElementById("cell" + RequireSp).innerHTML = "<img src='webDesign/build/images/Infinity-1.1s-200px.gif' alt='Infinity-1.1s-200px' style='width: 15%;'/>";
                Success('تم عملية قبول الطلب بنجاح');
                //setInterval(Reload, 2000);
            } else {
                Warning('فشلت عملية القبول .. برجاء إعادة المحاولة لاحقا');
            }
        }

    };
    xhttp.open("POST", "_0_0_0_2_2_Car_RequestManegersRequestHandeler_6__AJAX_setEmployeeNoApprovalToVcleVehicleRequire?" +
            "RequireSp=" + RequireSp +
            "&EmployeeEnchuranceNumber=" + EmployeeEnchuranceNumber, true);
    xhttp.send();
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
var RequireSpForIgnore;
function IgnoreRequestModal(RequireSp) {
    RequireSpForIgnore = RequireSp;
}
function DeleteRequest() {
    if (checkText()===false) {

    } else {
        var Confirm = confirm(" هل أنت متأكد من حذف تلك العملية ? .. \n Ok  : إتمام عملية الحذف || cancel : إلغاء");
        if (Confirm === true) {
            var causeOfIgnore = document.getElementById("editor-one").innerHTML;
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function ()
            {

                if (xhttp.readyState === 4 && xhttp.status === 200)
                {
                    var msg = xhttp.responseText;
                    //alert(msg);
                    if (msg === 'Done') {
                        document.getElementById("cell" + RequireSpForIgnore).innerHTML = "<img src='webDesign/build/images/Infinity-1.1s-200px.gif' alt='Infinity-1.1s-200px' style='width: 15%;'/>";
                        Success('تم عملية الحذف بنجاح');
                        //setInterval(Reload, 2000);
                        $("#IgnorReasonDiv").modal('hide');
                    } else {
                        Warning('فشلت عملية الحذف .. برجاء إعادة المحاولة لاحقا');
                    }
                }

            };//
            xhttp.open("POST", "_0_0_0_2_2_Car_RequestManegersRequestHandeler_7__AJAX_deleteFromVcleVehicleRequire?" +
                    "RequireSp=" + RequireSpForIgnore + "&causeOfIgnore=" + causeOfIgnore, true);
            xhttp.send();
        }
    }
}
function DeleteRequest2() {
    var Confirm = confirm(" هل أنت متأكد من حذف تلك العملية ? .. \n Ok  : إتمام عملية الحذف || cancel : إلغاء");
    if (Confirm === true) {
        var causeOfIgnore = document.getElementById("editor-one").innerHTML;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function ()
        {

            if (xhttp.readyState === 4 && xhttp.status === 200)
            {
                var msg = xhttp.responseText;
                //alert(msg);
                if (msg === 'Done') {
                    document.getElementById("cell2" + RequireSpForIgnore).innerHTML = "<img src='webDesign/img/Infinity-1.1s-200px.gif' alt='Infinity-1.1s-200px' style='width: 15%;'/>";
                    Success('تم عملية الحذف بنجاح');
                    //setInterval(Reload, 2000);
                    $("#IgnorReasonDiv").modal('hide');
                } else {
                    Warning('فشلت عملية الحذف .. برجاء إعادة المحاولة لاحقا');
                }
            }

        };

        xhttp.open("POST", "_0_0_0_2_2_Car_RequestManegersRequestHandeler_7__AJAX_deleteFromVcleVehicleRequire?" +
                "RequireSp=" + RequireSpForIgnore + "&causeOfIgnore=" + causeOfIgnore, true);
        xhttp.send();
    }
}
function DeleteRequest3() {
    var Confirm = confirm(" هل أنت متأكد من حذف تلك العملية ? .. \n Ok  : إتمام عملية الحذف || cancel : إلغاء");
    if (Confirm === true) {
        var causeOfIgnore = document.getElementById("editor-one").innerHTML;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function ()
        {

            if (xhttp.readyState === 4 && xhttp.status === 200)
            {
                var msg = xhttp.responseText;
                //alert(msg);
                if (msg === 'Done') {
                    document.getElementById("cell3" + RequireSpForIgnore).innerHTML = "<img src='webDesign/img/Infinity-1.1s-200px.gif' alt='Infinity-1.1s-200px' style='width: 15%;'/>";
                    Success('تم عملية الحذف بنجاح');
                    //setInterval(Reload, 2000);
                    $("#IgnorReasonDiv").modal('hide');
                } else {
                    Warning('فشلت عملية الحذف .. برجاء إعادة المحاولة لاحقا');
                }
            }

        };
        xhttp.open("POST", "_0_0_0_2_2_Car_RequestManegersRequestHandeler_7__AJAX_deleteFromVcleVehicleRequire?" +
                "RequireSp=" + RequireSpForIgnore + "&causeOfIgnore=" + causeOfIgnore, true);
        xhttp.send();
    }
}
function Reload() {
    location.reload();
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