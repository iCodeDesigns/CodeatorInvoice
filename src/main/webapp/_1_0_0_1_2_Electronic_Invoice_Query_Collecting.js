/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

var validEmployeeNo = false;
function getEmpData() {
    var employeeId = document.getElementById("searchEmpId2").value;

    if (employeeId === "" || employeeId === null) {
        //Warning("برحاء ادخال تأمين الموظف");
        document.getElementById("searchEmpData").value = "";
        validEmployeeNo = false;
    } else {
        var URL = "_1_0_0_1_2_Electronic_Invoice_Query_Collecting_Ajax_03_getEmpData_AjaxServlet?"
                + "employeeId=" + employeeId
                + "&deptId=" + deptId
                + "&sectionId=" + sectionId
                + "&accUnitId=" + accUnitId;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("searchEmpData2").value = "لا توجد بيانات موظف او الموظف خارج الإدارة الخاصة بك";
                    validEmployeeNo = false;
                } else {
                    document.getElementById("searchEmpData2").value = message;
                    validEmployeeNo = true;
                }

            }

        };
    }
}

function receiverTypeControlFields1(type) {
    document.getElementById("receivername1").value = "";
    var receiverType = type;
    if (receiverType === "B") {
        document.getElementById("ComRegisterDiv1").style.display = "block";
        document.getElementById("nationalIdDiv1").style.display = "none";
        document.getElementById("passportNumberDiv1").style.display = "none";
    } else if (receiverType === "P") {
        document.getElementById("ComRegisterDiv1").style.display = "none";
        document.getElementById("nationalIdDiv1").style.display = "block";
        document.getElementById("passportNumberDiv1").style.display = "none";
    } else if (receiverType === "F") {
        document.getElementById("ComRegisterDiv1").style.display = "none";
        document.getElementById("nationalIdDiv1").style.display = "none";
        document.getElementById("passportNumberDiv1").style.display = "block";
    }
}

var AllData = [];
var no_of_tries = 0;
async function getInvoiceMaster() {
    document.getElementById("Electronic_Invoice_Query_Master_Table").innerHTML =
            "<tr>"
            + "    <td colspan='7'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    await sleep(100);

    var internalId = document.getElementById("internalId").value;
    if (internalId.length > 0) {
        $.ajax({//

            url: "_1_0_0_1_2_Electronic_Invoice_Query_Collecting_Ajax_02_getInvoiceToPaied_AjaxServlet?"
                    + "deptId=" + deptId
                    + "&sectionId=" + sectionId
                    + "&accUnitId=" + accUnitId
                    + "&internalId=" + internalId,
            type: 'POST',
            dataType: 'json',
            //data: JSON.stringify(),
            //contentType: 'application/json',
            // mimeType: 'application/json',
            success: function (data) {
                //console.log(data);
                //a_0_0_5_2_students = JSON.parse(data.toString());
                var html = "";
                var i = 0;
                for (i = 0; i < data.length; i++) {
                    var printed_internal_id = data[i].internalID;
                    if (data[i].documentDividedStatus === "Divided") {
                        printed_internal_id = data[i].internalID + " ( " + data[i].startDocSerial + " <span class='fa fa-arrow-right'></span> " + data[i].endDocSerial + " )";
                    }

                    var receiver_Type = data[i].receiver.type;
                    if (receiver_Type === "B") {
                        receiver_Type = "شركة";
                    } else if (receiver_Type === "P") {
                        receiver_Type = "فرد";
                    } else if (receiver_Type === "F") {
                        receiver_Type = "أجنبي";
                    }

                    var documentType = data[i].documentType;
                    var documentType_name = "";
                    if (documentType === "I") {
                        if (data[i].documentDividedStatus === "Divided") {
                            documentType_name = "فاتورة مقسمة إلى <br>" + data[i].endDocSerial + " فاتورة";
                        } else {
                            documentType_name = "فاتورة";
                        }
                    } else if (documentType === "C") {
                        documentType_name = "إشعار إضافة";
                    } else if (documentType === "D") {
                        documentType_name = "إشعار خصم";
                    }
                    html += "<tr>"
                            + "<td class=\"table-font-style;\" style='direction : ltr;'>" + printed_internal_id + "</td>"
                            + "<td class=\"table-font-style\">" + receiver_Type + "</td>"
                            + "<td class=\"table-font-style\">" + documentType_name + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].receiver.name + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].dateTimeIssued + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].totalAmount + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].statusDescription + "</td>";
                    html += "<td>"
                            + "     <button type=\"button\" onclick=\"getInvoiceDetails('" + data[i].deptOld + "','" + data[i].sectionOld + "','" + data[i].invSp + "');\" data-toggle=\"modal\" data-target=\".InvoiceDetails\" class=\"fa fa-search btn btn-success\" style=\"font-size: large;border: 2px solid white;\" title=\"استعراض الفاتورة\" data-toggle=\"tooltip\"></button>";

                    if (data[i].chkPaied === "1") {
                        html += "     <span class=\"btn btn-round btn-default fa fa-money\"'> تم تحصيل الفاتورة</span>";
                    } else if (documentType === "D") {
                        html += "     <span class=\"btn btn-round btn-default fa fa-money\"'> لا يمكن تحصيل مستند إشعار خصم</span>";
                    } else {
                        html += "     <button type=\"button\" class=\"btn btn-round btn-info fa fa-money\" onclick='checkPay(" + i + "),checkSafe()'> تحصيل</button>";
                    }

                    html += "</td>";
                    +"</tr>";

                }
                if (i === 0) {
                    AllData = [];
                    document.getElementById("Electronic_Invoice_Query_Master_Table").innerHTML =
                            "<tr>"
                            + "    <td colspan='7'>لا توجد بيانات</td>"
                            + "</tr>";
                } else {
                    AllData = data;
                    document.getElementById("Electronic_Invoice_Query_Master_Table").innerHTML = html;
                }

            },
            error: function (xhr, status) {
                if (no_of_tries > 3) {
                    Error("حدث خطأ");
                } else {
                    getInvoiceMaster();
                    no_of_tries = no_of_tries + 1;
                }

            }
        });
    }
}

var Global_print_deptOld;
var Global_print_sectionOld;
var Global_print_inv_sp;

function getInvoiceDetails(deptOld, sectionOld, inv_sp) {
    for (var i = 0; i < AllData.length; i++) {
        receiverTypeControlFields1(AllData[i].receiver.type);
        //fillModal(AllData[i]);
        if (AllData[i].deptOld === deptOld && AllData[i].sectionOld === sectionOld && AllData[i].invSp === inv_sp) {
            Global_print_deptOld = deptOld;
            Global_print_sectionOld = sectionOld;
            Global_print_inv_sp = inv_sp;
            fillModal(AllData[i]);
            break;
        }
    }
}
function fillModal(data) {
    console.log(data);
    var printed_internal_id = data.internalID;
    if (data.documentDividedStatus === "Divided") {
        printed_internal_id = " ( " + data.endDocSerial + " <span class='fa fa-arrow-right'></span> " + data.startDocSerial + " )" + data.internalID;
    }
    var receiver_Type = data.receiver.type;
    if (receiver_Type === "B") {
        receiver_Type = "شركة";
    } else if (receiver_Type === "P") {
        receiver_Type = "فرد";
    } else if (receiver_Type === "F") {
        receiver_Type = "أجنبي";
    }

    var documentType = data.documentType;
    if (documentType === "I") {
        if (data.documentDividedStatus === "Divided") {
            documentType = "فاتورة مقسمة إلى  " + data.endDocSerial + " فاتورة";
        } else {
            documentType = "فاتورة";
        }
    } else if (documentType === "C") {
        documentType = "إشعار إضافة";
    } else if (documentType === "D") {
        documentType = "إشعار خصم";
    }

    document.getElementById("receiverType1").value = receiver_Type;
    document.getElementById("receivername1").value = data.receiver.name;
    document.getElementById("id1").value = data.receiver.id;
    document.getElementById("documentType1").value = documentType;

    document.getElementById("Invoice_number1").innerHTML = printed_internal_id;
    document.getElementById("invoiceID1").innerHTML = printed_internal_id;


    document.getElementById("dateTimeIssued1").value = data.dateTimeIssued;
    document.getElementById("serviceName1").value = data.serviceName;
    document.getElementById("notes1").value = data.notes;

    var html = "";
    var invoiceLines = document.getElementById("invoiceLines1");
    invoiceLines.innerHTML = "";
    var TOTAL_salesTotal = 0;
    var TOTAL_discountAmount = 0;
    var TOTAL_netTotal = 0;
    var TOTAL_Tax = 0;
    if (data.invoiceLines.length > 0) {
        for (var i = 0; i < data.invoiceLines.length; i++) {
            var line = data.invoiceLines[i];
            TOTAL_salesTotal += +line.salesTotal.toFixed(5);
            TOTAL_discountAmount += +line.discount.amount.toFixed(5);
            TOTAL_netTotal += +line.netTotal.toFixed(5);

            html += "<tr id=\"line_" + line.lineNumber + "\">" +
                    "    <td style=\"text-align: center;\">" + line.itemCode + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.description + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.unitValue.amountEGP + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.quantity + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.salesTotal + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.discount.amount + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.netTotal + "</td>" +
                    "    <td style=\"text-align: center;\">" +
                    "        <table class=\"table table-striped table-bordered\">" +
                    "            <tbody id=\"line_" + line.lineNumber + "_Tax\">";

            for (var j = 0; j < line.taxableItems.length; j++) {
                var taxData = line.taxableItems[j];
                TOTAL_Tax += +taxData.amount.toFixed(5);
                html += "<tr id=\"line_" + data.lineNumber + "_Tax_" + taxData.taxLineNumber + "\">\n" +
                        "    <td style=\"text-align: center;\">" + taxData.subType + "</td>\n" +
                        "    <td style=\"text-align: center;\">" + taxData.subTypeName + "</td>\n" +
                        "    <td style=\"text-align: center;\">" + taxData.rate + " %</td>\n" +
                        "    <td style=\"text-align: center;\">" + taxData.amount + "</td>\n" +
                        "</tr>";
            }
            html += "            </tbody>" +
                    "        </table>" +
                    "    </td>" +
                    "    <td style=\"text-align: center;\">" + line.total + "</td>" +
                    "</tr>";

        }
        invoiceLines.innerHTML += html;
        invoiceLines.innerHTML += "<tr><th colspan='8'>الخصم</th><th>" + data.extraDiscountAmount + "</th></tr>";

        // صف الإجماليات
        html = "";
        html += "<tr style='background-color: mistyrose;'><th colspan='4'>الإجماليات</th>"
                + "<th>" + TOTAL_salesTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_discountAmount.toFixed(5) + "</th>"
                + "<th>" + TOTAL_netTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_Tax.toFixed(5) + "</th>"
                + "<th>" + data.totalAmount.toFixed(5) + "</th>"
                + "</tr>";
        invoiceLines.innerHTML += html;
    } else {
        invoiceLines.innerHTML = "<tr><td colspan='10'>لا توجد سطور للفاتورة</td></tr>";
        invoiceLines.innerHTML += "<tr style='background-color: coral;'><th colspan='7'></th><th>خصم الفاتورة</th><th>" + extraDiscountAmount + "</th><th></th></tr>";

        var html = "";
        html += "<tr style='background-color: mistyrose;'><th colspan='4'>الإجماليات</th>"
                + "<th>" + TOTAL_salesTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_discountAmount.toFixed(5) + "</th>"
                + "<th>" + TOTAL_netTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_Tax.toFixed(5) + "</th>"
                + "<th>" + data.totalAmount.toFixed(5) + "</th>"
                + "</tr>";
        invoiceLines.innerHTML += html;
    }


}


////////////////////////////////////////////////////////////////////////////////
//checkSafe();
function checkSafe() {
    var safeCheckBox = document.getElementById("safeCheckBox").checked;
    var searchEmpId2 = document.getElementById("searchEmpId2");
    var searchEmpData2 = document.getElementById("searchEmpData2");
    //var paidFormCode = document.getElementById("paidFormCode");

    if (safeCheckBox === true) {
        searchEmpId2.disabled = true;
        searchEmpId2.style.backgroundColor = "#b3afaf";
        searchEmpData2.disabled = true;
        searchEmpData2.style.backgroundColor = "#b3afaf";
        //paidFormCode.disabled = false;
        //paidFormCode.style.backgroundColor = "";
    } else {
        searchEmpId2.disabled = false;
        searchEmpId2.style.backgroundColor = "";
        searchEmpData2.disabled = false;
        searchEmpData2.style.backgroundColor = "";
        //paidFormCode.disabled = true;
        //paidFormCode.style.backgroundColor = "#b3afaf";
    }

}

function updateCheckPay(data_index) {
    var safeCheckBox = document.getElementById("safeCheckBox").checked;
    var searchEmpId2 = document.getElementById("searchEmpId2").value;
    var paidFormCode = document.getElementById("paidFormCode").value;
    var paidDate = document.getElementById("paidDate").value;
    var paied_rmrk = document.getElementById("paied_rmrk").value;

    var safeCheckBoxStatus = "";
    if (safeCheckBox === true) {
        safeCheckBoxStatus = true;
    } else {
        safeCheckBoxStatus = false;
    }

    if (paidFormCode === "") {
        Warning("برجاء ملئ كود استمارة تحصيل الخزنة");
        return;
    } else if (searchEmpId2 === "" && safeCheckBox === false) {
        Warning("برجاء ملئ رقم تأمين الموظف");
        return;
    } else if (!validEmployeeNo && safeCheckBox === false) {
        Warning("رقم تأمين الموظف خطأ");
        return;
    } else if (paidDate === "") {
        Warning("برجاء ملئ تاريخ التحصيل");
        return;
    } else if (paied_rmrk === "") {
        Warning("لا بد من ملئ خانة الملاحظات");
        return;
    }
    var row = AllData[data_index];
    $.ajax({
        url: "_1_0_0_1_2_Electronic_Invoice_Query_Collecting_Ajax_01_updateCheckPay_AjaxServlet?"
                + "invSp=" + row.invSp
                + "&deptOld=" + row.deptOld
                + "&sectionOld=" + row.sectionOld
                + "&accUnitId=" + row.accUnitId
                + "&safeCheckBoxStatus=" + safeCheckBoxStatus
                + "&employeeId=" + searchEmpId2
                + "&paidFormCode=" + paidFormCode
                + "&paidDate=" + paidDate
                + "&paiedRmrk=" + paied_rmrk,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(SysSemesterType),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Success") {
                Success("تم التحصيل");
                getInvoiceMaster();
                loader1.remove();
            } else if (data === "EmpError") {
                Warning("هذا الموظف غير موجود بإدارة التحصيل");
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}


function checkPay(data_index) {
    var FormContentArr = [];
    var field;
    var settings = {
        title: "<h3 style='text-align:center;'>هل أنت متأكد من تحصيل المستند ؟؟..</h3>",
        close_status: true,
        card_fa_fa: "fa fa-money", //fa fa-edit fa-spin
        addclass: 'stack-modal', // dark // stack-modal //'body-device stack-topleft':'stack-topleft' //notify-custom
        type: 'info', //"notice", "info", "success", or "error".
        width: '40%',
        card_class: "check_lock_div",
        card_id: "",
        card_style: "",
        fontsize: "60px"
    };

    field = {
        div_style: "",
        div_class: "col-lg-4 col-md-4 col-sm-4 col-xs-4",
        no_of_top_br: 1,
        no_of_bot_br: 1,
        lable_: "تم التحصيل في الخزنة",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "checkbox", //button - password - text - date - number - etc.
        field_name: "safeCheckBox",
        filed_id: "safeCheckBox",
        filed_style: "text-align: right;color: red",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "",
        filed_func: "onclick=\"checkSafe();\"" //onclick='function();
    };
    FormContentArr.push(field);


    field = {
        div_style: "",
        div_class: "col-lg-8 col-md-8 col-sm-12 col-xs-12",
        no_of_top_br: 1,
        no_of_bot_br: 1,
        lable_: "كود التحصيل",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "paidFormCode",
        filed_id: "paidFormCode",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "width: 100%;height: 0px;",
        div_class: "col-lg-12 col-md-12 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "",
        lable_style: "",
        lable_class: "",
        field_type: "", //select - input - btn
        field_sub_type: "", //button - password - text - date - number - etc.
        field_name: "",
        filed_id: "",
        filed_style: "",
        filed_class: "", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-4 col-md-4 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "تأمين الموظف",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "searchEmpId2",
        filed_id: "searchEmpId2",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "",
        filed_func: "onkeyup=\"getEmpData();\"" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-8 col-md-8 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "إسم الموظف",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "searchEmpData2",
        filed_id: "searchEmpData2",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "",
        filed_func: " readOnly " //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-4 col-md-4 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "تاريخ التحصيل",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "date", //button - password - text - date - number - etc.
        field_name: "paidDate",
        filed_id: "paidDate",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-8 col-md-8 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "ملاحظات",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "paied_rmrk",
        filed_id: "paied_rmrk",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);
    field = {
        div_style: "text-align:center;",
        div_class: "col-lg-6 col-md-6 col-sm-6 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 0,
        lable_: "",
        lable_style: "",
        lable_class: "",
        field_type: "btn", //select - input - btn
        field_sub_type: "button", //button - password - text - date - number - etc.
        field_name: "",
        filed_id: "",
        filed_style: "",
        filed_class: "btn btn-round btn-dark fa fa-check", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "نعم",
        filed_func: "onclick='updateCheckPay(" + data_index + ");'" //onclick='function();
    };
    FormContentArr.push(field);
    field = {
        div_style: "text-align:center;",
        div_class: "col-lg-6 col-md-6 col-sm-6 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 0,
        lable_: "",
        lable_style: "",
        lable_class: "",
        field_type: "btn", //select - input - btn
        field_sub_type: "button", //button - password - text - date - number - etc.
        field_name: "",
        filed_id: "",
        filed_style: "",
        filed_class: "btn btn-round btn-dark fa fa-close", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "لا",
        filed_func: "onclick='loader1.remove();'" //onclick='function();
    };
    FormContentArr.push(field);
    var Notify = {
        setting: settings,
        FormContent: FormContentArr
    };
    OpenModel(Notify);
}