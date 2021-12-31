/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//init();
var TodayDateJs = "";
function init(TodayDate) {
    document.getElementById("Taf3elButton").innerHTML = "";
    document.getElementById("DeleteButton").innerHTML = "";
    LoadRequestsCount();
    Timer = 30;
    TodayDateJs = TodayDate;
}
var Timer = 30;
function StartTimer() {
    document.getElementById("refreshTimer").innerHTML = Timer + " ثانية";
    if (Timer === 0) {
        init(TodayDateJs);
    } else {
        Timer = Timer - 1;
    }
}
setInterval(StartTimer, 1000);

var num_of_rows = 0;
var inputElements;
var RequireSpClass;
function IgnoreRequestModal() {
    document.getElementById("DetailsTable").innerHTML = "";
    RequireSpClass = null;
    inputElements = document.getElementsByClassName('RequireSpClass');
    // check if there is  roe selected or not
    num_of_rows = 0;
    for (var i = 0; inputElements[i]; ++i) {
        if (inputElements[i].checked) {
            num_of_rows++;
        }
    }
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
function DeleteRequestsAfterFinalAction() {
    if (checkText2() === false) {

    } else {
        var Confirm = confirm(" هل أنت متأكد من إتمام عملية الإلغاء تلك ? .. \n Ok  : إتمام عملية الإلغاء || cancel : إلغاء");
        if (Confirm === true) {
            var causeOfIgnore = document.getElementById("editor-one2").innerHTML;
            var GoingSp = GoingSpToBeIgnored;
/////////////////////////////////////////////////////////
            //document.getElementById("Taf3elButton").innerHTML = "<button type=\"button\" class=\"btn btn-custon-rounded-three btn-success\" href=\"#\" data-toggle=\"modal\" data-target=\"#ActivateRequest\" onclick=\"SetRequestCarAndDrivers();\"><i class=\"fa fa-check adminpro-checked-pro\" aria-hidden=\"true\"></i> تفعيل الطلب</button>";
            //document.getElementById("DeleteButton").innerHTML = "<button type=\"button\" class=\"btn btn-custon-rounded-three btn-danger\" href=\"#\" data-toggle=\"modal\" data-target=\"#IgnorReasonDiv\" onclick=\"IgnoreRequestModal();\"><i class=\"fa fa-close adminpro-checked-pro\" aria-hidden=\"true\"></i> حذف الطلبات</button>";
            document.getElementById("RequireSP_id").innerHTML = "";
            var URL1 = "";

            URL1 = "GoingSp=" + GoingSp + "&causeOfIgnore=" + causeOfIgnore;

            var xhttp = new XMLHttpRequest();
            var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_14__AJAX_deleteVcleVehicleRequire?" + URL1;
            xhttp.open("POST", URL, true);
            xhttp.send();
            xhttp.onreadystatechange = function ()
            {
                if (xhttp.readyState === 4 && xhttp.status === 200)
                {
                    var msg = xhttp.responseText;
                    if (msg === "Error") {

                    } else {
                        Success("تم إلغاء الطلب بنجاح");
                        //Reload();
                        $("#IgnorReasonDiv2").modal('hide');
                        $("#ActiveCarRequets").modal('hide');
                        LoadRequestsCount();
                        document.getElementById("Taf3elButton").innerHTML = "";
                        document.getElementById("DeleteButton").innerHTML = "";
                    }
                }
            };
        }
    }
}
function DeleteRequests() {
    if (checkText() === false) {

    } else {
        var Confirm = confirm(" هل أنت متأكد من إتمام عملية الحذف تلك ? .. \n Ok  : إتمام عملية الحذف || cancel : إلغاء");
        if (Confirm === true) {
            var causeOfIgnore = document.getElementById("editor-one").innerHTML;
/////////////////////////////////////////////////////////
            if (num_of_rows > 0) {
                document.getElementById("Taf3elButton").innerHTML = "<button type=\"button\" class=\"btn btn-custon-rounded-three btn-success\" href=\"#\" data-toggle=\"modal\" data-target=\"#ActivateRequest\" onclick=\"SetRequestCarAndDrivers();\"><i class=\"fa fa-check adminpro-checked-pro\" aria-hidden=\"true\"></i> تفعيل الطلب</button>";
                document.getElementById("DeleteButton").innerHTML = "<button type=\"button\" class=\"btn btn-custon-rounded-three btn-danger\" href=\"#\" data-toggle=\"modal\" data-target=\"#IgnorReasonDiv\" onclick=\"IgnoreRequestModal();\"><i class=\"fa fa-close adminpro-checked-pro\" aria-hidden=\"true\"></i> حذف الطلبات</button>";
                document.getElementById("RequireSP_id").innerHTML = "";
                var URL1 = "";
                var numberOfChecked = 0;
                for (var i = 0; inputElements[i]; ++i) {

                    if (inputElements[i].checked) {

                        RequireSpClass = inputElements[i].value;
                        if (numberOfChecked === num_of_rows - 1) {
                            URL1 = URL1 + "RequireSpClass=" + RequireSpClass;
                            break;
                        }
                        URL1 = URL1 + "RequireSpClass=" + RequireSpClass + "&";
                        numberOfChecked++;
                    }

                }
                URL1 = URL1 + "&causeOfIgnore=" + causeOfIgnore;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function ()
                {
                    if (xhttp.readyState === 4 && xhttp.status === 200)
                    {
                        var msg = xhttp.responseText;
                        if (msg === "Error") {

                        } else {
                            Success("تم حذف الطلبات بنجاح");
                            //Reload();
                            $("#IgnorReasonDiv").modal('hide');
                            LoadRequestsCount();
                            document.getElementById("Taf3elButton").innerHTML = "";
                            document.getElementById("DeleteButton").innerHTML = "";
                        }
                    }
                };
                var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_3__AJAX_deleteVcleVehicleRequire?" + URL1;
                xhttp.open("POST", URL, true);
                xhttp.send();
            } else {
                alert("لا يوجد صفوف مختارة لعمل التسكين");
                document.getElementById("Taf3elButton").innerHTML = "";
                document.getElementById("DeleteButton").innerHTML = "";
            }
        }
    }
}
var guestNo_Public = "";
function SetRequestCarAndDrivers() {
    document.getElementById("DetailsTable").innerHTML = "";
    var RequireSpClass = null;
    var inputElements = document.getElementsByClassName('RequireSpClass');
    // check if there is  roe selected or not
    var num_of_rows = 0;
    for (var i = 0; inputElements[i]; ++i) {
        if (inputElements[i].checked) {
            num_of_rows++;
        }
    }
//alert(num_of_rows);
/////////////////////////////////////////////////////////

    if (num_of_rows > 0) {
        document.getElementById("Taf3elButton").innerHTML = "<button type=\"button\" class=\"btn btn-custon-rounded-three btn-success\" href=\"#\" data-toggle=\"modal\" data-target=\"#ActivateRequest\" onclick=\"SetRequestCarAndDrivers();\"><i class=\"fa fa-check adminpro-checked-pro\" aria-hidden=\"true\"></i> تفعيل الطلب</button>";
        document.getElementById("DeleteButton").innerHTML = "<button type=\"button\" class=\"btn btn-custon-rounded-three btn-danger\" href=\"#\" data-toggle=\"modal\" data-target=\"#IgnorReasonDiv\" onclick=\"IgnoreRequestModal();\"><i class=\"fa fa-close adminpro-checked-pro\" aria-hidden=\"true\"></i> حذف الطلبات</button>";
        document.getElementById("RequireSP_id").innerHTML = "";
        var URL1 = "";
        var inputElements2 = document.getElementsByClassName('RequireSpClass');
        var numberOfChecked = 0;
        for (var i = 0; inputElements2[i]; ++i) {

            if (inputElements2[i].checked) {
                RequireSpClass = inputElements2[i].value;
                document.getElementById("RequireSP_id").innerHTML += "<input type='hidden' class='r_s_p' value='" + RequireSpClass + "' class='flat' />";
                if (numberOfChecked === num_of_rows - 1) {
                    URL1 = URL1 + "RequireSpClass=" + RequireSpClass;
                    break;
                }
                URL1 = URL1 + "RequireSpClass=" + RequireSpClass + "&";
                numberOfChecked++;
            }
        }
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function ()
        {
            if (xhttp.readyState === 4 && xhttp.status === 200)
            {
                document.getElementById("DetailsTable").innerHTML += xhttp.responseText;
                guestNo_Public = document.getElementById("guestNo").value;
            }
        };
        var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_2__AJAX_getVcleVehicleRequire?" + URL1;
        xhttp.open("POST", URL, true);
        xhttp.send();
    } else {
        alert("لا يوجد صفوف مختارة لعمل التسكين");
        document.getElementById("Taf3elButton").innerHTML = "";
        document.getElementById("DeleteButton").innerHTML = "";
    }
}
//setInterval(CheckTableRequestes, 500);
function CheckTableRequestes() {
    var inputElements = document.getElementsByClassName('RequireSpClass');
    // check if there is  roe selected or not
    var num_of_rows = 0;
    for (var i = 0; inputElements[i]; ++i) {
        if (inputElements[i].checked) {
            num_of_rows++;
        }
    }
/////////////////////////////////////////////////////////
    var URL = "";
    var html = document.getElementById("Taf3elButton").innerHTML;
    if (num_of_rows > 0 && (html !== "" || html !== null)) {
        document.getElementById("Taf3elButton").innerHTML = "<button type=\"button\" class=\"btn btn-custon-rounded-three btn-success\" href=\"#\" data-toggle=\"modal\" data-target=\"#ActivateRequest\" onclick=\"SetRequestCarAndDrivers();\"><i class=\"fa fa-check adminpro-checked-pro\" aria-hidden=\"true\"></i> تفعيل الطلب</button>";
        document.getElementById("DeleteButton").innerHTML = "<button type=\"button\" class=\"btn btn-custon-rounded-three btn-danger\" href=\"#\" data-toggle=\"modal\" data-target=\"#IgnorReasonDiv\" onclick=\"IgnoreRequestModal();\"><i class=\"fa fa-close adminpro-checked-pro\" aria-hidden=\"true\"></i> حذف الطلبات</button>";
    } else {
        document.getElementById("Taf3elButton").innerHTML = "";
        document.getElementById("DeleteButton").innerHTML = "";
    }
}

var empDriverArray;
function setEmpDriverArray(empDriverArray1) {
    empDriverArray = empDriverArray1;
}
function DriverStatus() {
    document.getElementById("CarDetailID").innerHTML = "";
    var emp_Driver_id = document.getElementById("emp_id").value;
    //var empDriverArray = [<%=EmployeesNumberAreOut%>];
    for (var i = 0; i < empDriverArray.length; i++) {
        if (emp_Driver_id === empDriverArray[i]) {
            document.getElementById("Taf3eelSubmitButton").innerHTML = "";
            getDriverRecord(emp_Driver_id);
            break;
        } else {
            document.getElementById("Taf3eelSubmitButton").innerHTML = "<button type=\"button\" onclick=\"TaskeenAction();\" class=\"btn btn-custon-four btn-default\" style=\"font-weight: bold;border-color: black;width: 15%;\">تفعيل الطلب</button>";
        }
    }


}

function checkEmployee() {
    var emp_Driver_id = document.getElementById("emp_id").value;
    if (emp_Driver_id !== "") {
        getDriverRecord(emp_Driver_id);
    }

}
function getDriverRecord(emp_Driver_id) {

    var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_6__AJAX_getDriverTrip?emp_Driver_id=" + emp_Driver_id;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                // Error Action to Current Page.
                //alert("Error");
                document.getElementById("empDetailID").innerHTML = "";
                if (checkSearch === true) {
                    document.getElementById("CarNumDiv").style.display = "block";
                }
                document.getElementById("CarFullNumDiv").style.display = "block";
                getVcleByDriver();
            } else {
                document.getElementById("Taf3eelSubmitButton").innerHTML = "";
                document.getElementById("empDetailID").innerHTML = message;
                //document.getElementById("CarNumDiv").style.display = "none";
                //document.getElementById("CarFullNumDiv").style.display = "none";
            }
            ButtonStatus();
        }
    };

}


function getDriverByVcle() {
    var BoardDigital = document.getElementById("BoardDigital").value;
    var BoardNumber = document.getElementById("BoardNumber").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            document.getElementById("emp_id").innerHTML = xhttp.responseText;
        }

    };
    var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_13__AJAX_getDriverByVcle?BoardDigital=" + BoardDigital + "&BoardNumber=" + BoardNumber;
    xhttp.open("POST", URL, true);
    xhttp.send();
}

function getVcleByDriver() {
    if (checkSearch === false) {
        var emp_id = document.getElementById("emp_id").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function ()
        {
            if (xhttp.readyState === 4 && xhttp.status === 200)
            {
                var message = xhttp.responseText;
                //document.getElementById("BoardDigital").innerHTML = jason[0];
                document.getElementById("BoardNumber").innerHTML = message;
            }

        };
        var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_15__AJAX_getVcleByDriver?emp_id=" + emp_id;
        xhttp.open("POST", URL, true);
        xhttp.send();
    }
}

var CarNumberAreOut;
function setCarNumberAreOut(CarNumberAreOut1) {
    CarNumberAreOut = CarNumberAreOut1;
}
function CarStatus() {
    var BoardNumber = document.getElementById("BoardNumber").value;
    for (var i = 0; i < CarNumberAreOut.length; i++) {
        if (BoardNumber === CarNumberAreOut[i]) {
            document.getElementById("Taf3eelSubmitButton").innerHTML = "";
            //document.getElementById("CarDetailID").innerHTML = "حالة السيارة";
            getCarRecord(BoardNumber);
            break;
        } else {
            //document.getElementById("Taf3eelSubmitButton").innerHTML = "<button type='button' onclick='TaskeenAction();' class='btn btn-custon-four btn-primary'><i class='fa fa-reply adminpro-checked-pro' aria-hidden='true'></i> تفعيل الطلب</button>";
            //document.getElementById("CarDetailID").innerHTML = "";
        }
    }
}

function checkCar() {
    var BoardNumber = document.getElementById("BoardNumber").value;
    if (BoardNumber !== "") {
        getCarRecord(BoardNumber);
    }

}
function getCarRecord(BoardNumber) {
    //document.getElementById("CarDetailID").innerHTML = "حالة السيارة";
    var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_7__AJAX_getCarTrip?BoardNumber=" + BoardNumber;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message.startsWith("<table")) {
                //alert("go");
                document.getElementById("Taf3eelSubmitButton").innerHTML = "";
                //document.getElementById("EmpDiv").style.display = "none";
                document.getElementById("CarDetailID").innerHTML = message;
                document.getElementById("goingCountNumber").readOnly = true;
            } else if (message === "Error") {
                Error("حدث خطأ");
            } else {
                // Error Action to Current Page.
                //alert("Error");
                document.getElementById("CarDetailID").innerHTML = "";
                //document.getElementById("EmpDiv").style.display = "block";
                if (message === "0") {
                    document.getElementById("goingCountNumber").readOnly = false;
                    document.getElementById("goingCountNumber").value = message;
                } else {
                    document.getElementById("goingCountNumber").readOnly = true;
                    document.getElementById("goingCountNumber").value = message;
                }

                //getDriverByVcle();
            }
            ButtonStatus();
        }
    };

}
function ButtonStatus() {
    var CarDetailID = document.getElementById("CarDetailID").innerHTML;
    var empDetailID = document.getElementById("empDetailID").innerHTML;
    if (CarDetailID === "" && empDetailID === "") {
        document.getElementById("Taf3eelSubmitButton").innerHTML = "<button type=\"button\" onclick=\"TaskeenAction();\" class=\"btn btn-custon-four btn-default\" style=\"font-weight: bold;border-color: black;width: 15%;\">تفعيل الطلب</button>";
    } else {
        document.getElementById("Taf3eelSubmitButton").innerHTML = "";
    }
}

function TaskeenAction() {
    var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_4__AJAX_TaskeenEltalabat?";
    var inputElements2 = document.getElementsByClassName('r_s_p');
    // check if there is fields of Final_RequireSP_id
    var num_of_rows = 0;
    for (var i = 0; inputElements2[i]; ++i) {
        num_of_rows++;
    }
    for (var x = 0; inputElements2[x]; ++x) {
        var RequireSpClass = inputElements2[x].value;
        if (i === num_of_rows - 1) {
            URL += "Final_RequireSP_id=" + RequireSpClass;
            break;
        }
        URL += "Final_RequireSP_id=" + RequireSpClass + "&";
    }

    if (num_of_rows === 0) {
        Warning("لا توجد طلبات لتسكينها");
    } else {
        var EmployeeId = document.getElementById("emp_id").value;
        if (EmployeeId === "" || EmployeeId === null) {
            Warning("يرجى إدخال إسم السائق");
        } else {
            URL += "&EmployeeId=" + EmployeeId;
            var BoardNumber = document.getElementById("BoardNumber").value;
            if (BoardNumber === "" || BoardNumber === null) {
                Warning("يرجي إختيار رقم سيارة");
            } else {
                URL += "&BoardNumber=" + BoardNumber;
                var sel = document.getElementById("BoardNumber");
                var val = sel.options[sel.selectedIndex].text;
                var res = val.split("-");
                var GuestNumOfCar = res[2];
                var RequestGuestNumber = guestNo_Public;
                if (GuestNumOfCar < RequestGuestNumber) {
                    Warning("يرجي إختيار سيارة تكفي عدد ركاب الطلب");
                } else {
                    var goingCountNumberStatus = document.getElementById("goingCountNumberStatus").checked;
                    var goingCountNumber = document.getElementById("goingCountNumber").value;
                    var dateTimePicker = document.getElementById("dateTimePicker").value;
                    if (dateTimePicker === "") {
                    } else if ((goingCountNumber === "" || goingCountNumber === null) && (!goingCountNumberStatus)) {
                        Warning("يرجي ملئ خانة قراءة العداد");
                    } else {
                        if (goingCountNumberStatus) {
                            URL += "&goingCountNumberStatus=true";
                            URL += "&dateTimePicker=" + dateTimePicker;
                        } else {
                            URL += "&goingCountNumber=" + goingCountNumber;
                            URL += "&goingCountNumberStatus=false";
                            URL += "&dateTimePicker=" + dateTimePicker;
                        }
                        document.getElementById("Taf3eelSubmitButton").innerHTML = "<img src='webDesign/build/images/Infinity-1.1s-200px.gif' alt='Infinity-1.1s-200px' style='width: 15%;'/>";
                        URL += "&RequestGuestNumber=" + RequestGuestNumber;
                        var xhttp = new XMLHttpRequest();
                        xhttp.open("POST", URL, true);
                        xhttp.send();
                        xhttp.onreadystatechange = function ()
                        {
                            if (xhttp.readyState === 4 && xhttp.status === 200)
                            {
                                var status = xhttp.responseText;
                                if (status === "Success") {
                                    Success("تمت عملية التسكين بنجاح");
                                    //setInterval(Reload, 2000);
                                    //location.reload();
                                    $("#ActivateRequest").modal('hide');
                                    LoadRequestsCount();

                                    resetModuleOfTaskean();
                                } else if (status === "Error") {
                                    document.getElementById("Taf3eelSubmitButton").innerHTML = "<button type=\"button\" onclick=\"TaskeenAction();\" class=\"btn btn-custon-four btn-default\" style=\"font-weight: bold;border-color: black;width: 15%;\">تفعيل الطلب</button>";
                                    Error("فشلت عملية التسكين برجى إعادة المحاولة لاحقا..");
                                } else {
                                    document.getElementById("Taf3eelSubmitButton").innerHTML = "<button type=\"button\" onclick=\"TaskeenAction();\" class=\"btn btn-custon-four btn-default\" style=\"font-weight: bold;border-color: black;width: 15%;\">تفعيل الطلب</button>";
                                    Warning(status);
                                }
                            }
                        };
                    }
                }
            }
        }
    }
}
function resetModuleOfTaskean() {
    document.getElementById("Taf3elButton").innerHTML = "";
    document.getElementById("DeleteButton").innerHTML = "";

    document.getElementById("emp_id").value = "";
    document.getElementById("BoardDigital").value = "";
    document.getElementById("BoardNumber").value = "";
    document.getElementById("goingCountNumber").value = "";
    document.getElementById("goingCountNumberStatus").checked = false;
    //document.getElementById("CarNumDiv").style.display = "none";
    //document.getElementById("CarFullNumDiv").style.display = "none";
    document.getElementById("Taf3eelSubmitButton").innerHTML = "<button type=\"button\" onclick=\"TaskeenAction();\" class=\"btn btn-custon-four btn-default\" style=\"font-weight: bold;border-color: black;width: 15%;\">تفعيل الطلب</button>";
}

function applyCheckCheckerr(GoingSp) {
    var comingCountNumberStatus = document.getElementById("comingCountNumberStatus" + GoingSp).checked;
    if (comingCountNumberStatus) {
        document.getElementById("comingCountNumberDIV" + GoingSp).style.display = "none";
    } else {
        document.getElementById("comingCountNumberDIV" + GoingSp).style.display = "block";
    }
}

function BackAction(GoingSp, GoingCountNumber) {
    document.getElementById("BackSubmitButton").innerHTML = "تحميل البيانات ...";
    var BackDate = document.getElementById("BackDate" + GoingSp).value;
    var BackHour = document.getElementById("BackHour" + GoingSp).value;
    var comingCountNumber = document.getElementById("comingCountNumber" + GoingSp).value;
    var comingCountNumberStatus = document.getElementById("comingCountNumberStatus" + GoingSp).checked;
    if (BackDate === null || BackDate === "") {
        Warning("برجاء ملئ تاريخ الرجوع");
        document.getElementById("BackSubmitButton").innerHTML = "<button type=\"button\" onclick=\"BackAction(" + GoingSp + "," + GoingCountNumber + ");\" style=\"font-weight: bold;border-color: black;width: 15%;\" class=\"btn btn-custon-four btn-defult\"><i class=\"fa fa-reply adminpro-checked-pro\" aria-hidden=\"true\"></i>حفظ</button>";
    } else if (BackHour === null || BackHour === "") {
        Warning("برجاء ملئ توقيت الرجوع");
        document.getElementById("BackSubmitButton").innerHTML = "<button type=\"button\" onclick=\"BackAction(" + GoingSp + "," + GoingCountNumber + ");\" style=\"font-weight: bold;border-color: black;width: 15%;\" class=\"btn btn-custon-four btn-defult\"><i class=\"fa fa-reply adminpro-checked-pro\" aria-hidden=\"true\"></i>حفظ</button>";
    } else if ((comingCountNumber === null || comingCountNumber === "") && (!comingCountNumberStatus)) {
        Warning("برجاء ملئ خانة قراءة عداد السيارة عند العودة");
        document.getElementById("BackSubmitButton").innerHTML = "<button type=\"button\" onclick=\"BackAction(" + GoingSp + "," + GoingCountNumber + ");\" style=\"font-weight: bold;border-color: black;width: 15%;\" class=\"btn btn-custon-four btn-defult\"><i class=\"fa fa-reply adminpro-checked-pro\" aria-hidden=\"true\"></i>حفظ</button>";
    } else if ((comingCountNumber <= GoingCountNumber) && (!comingCountNumberStatus)) {
        Warning("لا يمكن أن يكون قراءة العداد أقل من أو تساوي " + GoingCountNumber);
        document.getElementById("BackSubmitButton").innerHTML = "<button type=\"button\" onclick=\"BackAction(" + GoingSp + "," + GoingCountNumber + ");\" style=\"font-weight: bold;border-color: black;width: 15%;\" class=\"btn btn-custon-four btn-defult\"><i class=\"fa fa-reply adminpro-checked-pro\" aria-hidden=\"true\"></i>حفظ</button>";
    } else {

        var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_5__AJAX_BackEltalabat?GoingSp=" + GoingSp + "&BackDate=" + BackDate + "&BackHour=" + BackHour + "&comingCountNumber=" + comingCountNumber;
        if (comingCountNumberStatus) {
            URL += "&comingCountNumberStatus=true";
        } else {
            URL += "&comingCountNumber=" + comingCountNumber;
            URL += "&comingCountNumberStatus=false";
        }
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function ()
        {
            if (xhttp.readyState === 4 && xhttp.status === 200)
            {
                var status = xhttp.responseText;
                if (status === "Success") {
                    Success("تمت عملية الإرجاع بنجاح بنجاح");
                    // setInterval(Reload, 2000);
                    //location.reload();
                    $("#RequestBack").modal('hide');
                    getRunningTrips();
                } else {
                    document.getElementById("BackSubmitButton").innerHTML = "<button type=\"button\" onclick=\"BackAction(" + GoingSp + "," + GoingCountNumber + ");\" style=\"font-weight: bold;border-color: black;width: 15%;\" class=\"btn btn-custon-four btn-defult\"><i class=\"fa fa-reply adminpro-checked-pro\" aria-hidden=\"true\"></i>حفظ</button>";
                    Error("فشلت عملية الإرجاع برجى إعادة المحاولة لاحقا .. يرجى التأكد من أن تاريخ ووقت الرجوع بعد تاريخ وتوقيت الخروج وقبل التوقيت الحالي..");
                }
            }
        };
    }
}

function getTalabatOfThisTrip(goingSP) {
    document.getElementById("loadData3").innerHTML = "جاري إستقبال البيانات";
    var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_2__AJAX_TripsTalabat?goingSP=" + goingSP;
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

function getTafaseal(text) {
    document.getElementById("SababElRafd").innerHTML = text;
}

function applyMethode() {
    DriverStatus();
    GetFullCarNumber();
    CarStatus();
}
setInterval(guestNoChecker, 2000);
function guestNoChecker() {
    var DetailsTable = document.getElementById("DetailsTable").innerHTML;
    if (DetailsTable !== "" && guestNo_Public !== "") {

        document.getElementById("guestNo").value = guestNo_Public;
    }
}
function GetFullCarNumber() {
    var guestNo = guestNo_Public;
    var BoardDigital = document.getElementById("BoardDigital").value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            document.getElementById("BoardNumber").innerHTML = xhttp.responseText;
        }

    };
    var URL = "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_1__AJAX_getFullCarNumber?BoardDigital=" + BoardDigital + "&guestNo=" + guestNo + "&useGuestNo=true";
    xhttp.open("POST", URL, true);
    xhttp.send();
    /*DriverStatus();*/
}

function Reload() {
    location.reload();
}

setInterval(chechOnCheckBox, 200);
function chechOnCheckBox() {
    var goingCountNumberStatus = document.getElementById("goingCountNumberStatus").checked;
    if (goingCountNumberStatus) {
        document.getElementById("goingCountNumberDIV").style.display = "none";
    } else {
        document.getElementById("goingCountNumberDIV").style.display = "block";
    }

}
///Query Main Table
function LoadRequestsCount() {
    var dateChosen = document.getElementById("dateChosen").value;
    if (dateChosen === "" || dateChosen === null) {
        dateChosen = TodayDateJs;
        document.getElementById("dateChosen").value = TodayDateJs;
    }
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_8__AJAX_LoadRequestsCount?dateChosen=" + dateChosen, true);
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
                document.getElementById("NumberOfRequestesToTaskeen").innerHTML = msg;
                LoadRequestsTable();
            }
        }
    };
}
function LoadRequestsTable() {
    var dateChosen = document.getElementById("dateChosen").value;
    if (dateChosen === "" || dateChosen === null) {
        dateChosen = TodayDateJs;
        document.getElementById("dateChosen").value = TodayDateJs;
    }

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_9__AJAX_LoadRequestsTable?dateChosen=" + dateChosen, true);
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
                document.getElementById("RequestsTable").innerHTML = msg;
            }
        }
    };
}

function getRunningTrips() {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_10__AJAX_getRunningTrips?", true);
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
                document.getElementById("runningTrips").innerHTML = msg;
            }
        }
    };
}

function getRequestsOfRunningTrips(GoingSp) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_11__AJAX_getRequestsOfRunningTrips?GoingSp=" + GoingSp, true);
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
                document.getElementById("RequestsOfTripsTable").innerHTML = msg;
            }
        }
    };
}

function backRunningTrip(GoingSp) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "_0_0_0_2_4_Car_RequestTranspoetOfficeFinalAction_12__AJAX_backRunningTrip?GoingSp=" + GoingSp, true);
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
                document.getElementById("BakFormDiv").innerHTML = msg;
            }
        }
    };
}

setInterval(searchByDeptCheck, 500);
var checkSearch = true;
function searchByDeptCheck() {
    checkSearch = document.getElementById("checkSearch").checked;
    if (checkSearch === false) {
        document.getElementById("CarNumDiv").style.display = "none";
    } else {
        document.getElementById("CarNumDiv").style.display = "block";
    }
}

function resetSearchCheck() {
    document.getElementById("BoardNumber").innerHTML = "";
    document.getElementById("BoardDigital").value = "";
    document.getElementById("emp_id").value = "";
}


var GoingSpToBeIgnored;
function setGoingSpInGlobal(GoingSp) {
    GoingSpToBeIgnored = GoingSp;
}


///////////////////////////////////
///////////////////////////////////
///////////////////////////////////
var serverTime;
var localTime;
var timeDiff;
var startClock = false;
function getStartDate(startDate) {
    serverTime = new Date(startDate);
    localTime = +Date.now();
    timeDiff = serverTime - localTime;
    startClock = true;
}


setInterval(function () {
    if (startClock) {
        var newDate = new Date(+Date.now() + timeDiff).toISOString();
        newDate = newDate.substring(0, 16);
        console.log(newDate);
        var checkDatePicker = document.getElementById("checkDatePicker").checked;
        if (checkDatePicker === false) {
            document.getElementById("dateTimePicker").value = newDate;
            document.getElementById("dateTimePicker").disabled = true;
        } else {
            document.getElementById("dateTimePicker").disabled = false;
        }
    }
}, 1000);
///////////////////////////////////
///////////////////////////////////
///////////////////////////////////

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