/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

init();
function init() {
    LoadRequestCountAndDeptCount("Requests");
}
setInterval(init, 1000 * 30);
function ActivateRequest(RequireSp) {
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
                getAllDeptRequests();
            } else {
                Warning('فشلت عملية القبول .. برجاء إعادة المحاولة لاحقا');
            }
        }

    };
    xhttp.open("POST", "_0_0_0_2_3_Car_Request_2__AJAX_set1ToRequireStatusToVcleVehicleRequire?" +
            "RequireSp=" + RequireSp, true);
    xhttp.send();
}

var RequireSpForIgnore;
function IgnoreRequestModal(RequireSp) {
    RequireSpForIgnore = RequireSp;
}
function IgnoreRequest() {
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
                        Success('تمت عملية الرفض بنجاح');
                        //setInterval(Reload, 2000);
                        $("#IgnorReasonDiv").modal('hide');
                        getAllDeptRequests();
                    } else {
                        Warning('فشلت عملية رفض الطلب .. برجاء إعادة المحاولة لاحقا');
                    }
                }

            };
            xhttp.open("POST", "_0_0_0_2_3_Car_Request_1__AJAX_set3ToRequireStatusToVcleVehicleRequire?" +
                    "RequireSp=" + RequireSpForIgnore + "&causeOfIgnore=" + causeOfIgnore, true);
            xhttp.send();
        }

    }
}
function Reload() {
    location.reload();
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
//// Table Queries
function getDeptRequests(deptId, sectionId, requestsNumber, deptName) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_3_Car_RequestTranspoetOfficeRequestHandeler_3__AJAX_getDeptRequests?deptId=" + deptId + "&sectionId=" + sectionId, true);
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
                document.getElementById("deptRequests_table").innerHTML = msg;
                document.getElementById("requestsNumber").innerHTML = requestsNumber;
                document.getElementById("deptName").innerHTML = deptName;
            }
        }
    };
}

function getAllDeptRequests() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_3_Car_RequestTranspoetOfficeRequestHandeler_4__AJAX_getAllDeptRequests?", true);
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
                document.getElementById("allDeptRequests_table").innerHTML = msg;


            }
        }
    };
}

function LoadRequestCountAndDeptCount(type) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_3_Car_RequestTranspoetOfficeRequestHandeler_5__AJAX_getReqDeptCount?type=" + type, true);
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
                if (type === "Dept") {
                    document.getElementById("NumberOfDepartments").innerHTML = msg;
                    getAllDeptRequests();
                } else if (type === "Requests") {
                    document.getElementById("NumberOfRequestes").innerHTML = msg;
                    LoadRequestCountAndDeptCount("Dept");
                }
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