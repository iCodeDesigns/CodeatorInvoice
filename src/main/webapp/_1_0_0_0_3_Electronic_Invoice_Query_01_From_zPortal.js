/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

receiverTypeControlFields1();
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

getInvoiceMaster();
var AllData = [];
var no_of_tries = 0;
var first_load = true;
async function getInvoiceMaster() {
    var table_id = "Electronic_Invoice_Query_Master_Table";
    $("#" + table_id + " tbody").empty();
    if (first_load) {
        first_load = false;
    } else {
        $("#" + table_id).DataTable().destroy();
    }
    $("#" + table_id + " tbody").empty();
    $("#" + table_id + " tbody").append(
            "<tr>"
            + "    <td colspan='8'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>");
    await sleep(1000);


    $.ajax({
        url: "_1_0_0_0_3_Electronic_Invoice_Query_01_From_zPortal_AjaxServlet?deptId=" + deptId + "&sectionId=" + sectionId + "&accUnitId=" + accUnitId,
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
                if (documentType === "I") {
                    if (data[i].documentDividedStatus === "Divided") {
                        documentType = "فاتورة مقسمة إلى <br>" + data[i].endDocSerial + " فاتورة";
                    } else {
                        documentType = "فاتورة";
                    }
                } else if (documentType === "C") {
                    documentType = "إشعار إضافة";
                } else if (documentType === "D") {
                    documentType = "إشعار خصم";
                }
                html += "<tr>"
                        + "<td class=\"table-font-style;\" style='direction : ltr;'>" + printed_internal_id + "</td>"
                        + "<td class=\"table-font-style\">" + receiver_Type + "</td>"
                        + "<td class=\"table-font-style\">" + documentType + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].receiver.name + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].dateTimeIssued + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].totalAmount + "</td>";

                //+ "<td class=\"table-font-style\">" + data[i].statusDescription + "</td>"
                var color = "color: green !important";
                var fafa = "fa-warning";

                var description = "";
                if (data[i].status === "9" /*"Valid"*/) {
                    color = "color: green !important;";
                    fafa = "fa-check-circle-o";
                    description = data[i].statusDescription;
                } else if (data[i].status === "10" || +data[i].status < 9 /*"Invalid"*/) {
                    color = "color: red !important;";
                    fafa = "fa-warning";
                    description = data[i].statusDescription + " - Invalid";
                } else if (data[i].status === "11" /*"Cancelled"*/) {
                    color = "#797775 !important;";
                    fafa = "fa-close";
                    description = data[i].statusDescription;
                } else if (data[i].status === "12" /*"Rejected"*/) {
                    color = "color: #b00 !important; opacity: 0.3;";
                    fafa = "fa-times-circle";
                    description = data[i].statusDescription;
                } else if (data[i].status === "13" /*"Submitted"*/) {
                    color = "color: #925ace !important;";
                    fafa = "fa-refresh";
                    description = data[i].statusDescription;
                } else if (data[i].status === "14" /*"Cancellation Requested"*/) {
                    color = "color: #797775 !important; opacity: 0.3;";
                    fafa = "fa-times-circle-o";
                    description = data[i].statusDescription;
                } else if (data[i].status === "15"/*"Rejection Requested"*/) {
                    color = "color: #797775 !important; opacity: 0.3;";
                    fafa = "fa-file-excel-o";
                    description = data[i].statusDescription;
                }
                html += "    <td> <a style=\" " + color + "; font - weight: bold; cursor: pointer;\" data-toggle=\"modal\" data-target=\".InvoiceDetailsPortal\" onclick=\"getInvoiceData('" + data[i].uuid + "');\"> " + description + " <span class=\"fa " + fafa + "\"></span></a></td>\n";



                html += "<td>"
                        + "     <button type=\"button\" onclick=\"getInvoiceDetails('" + data[i].deptOld + "','" + data[i].sectionOld + "','" + data[i].invSp + "');\" data-toggle=\"modal\" data-target=\".InvoiceDetails\" class=\"fa fa-search btn btn-success\" style=\"font-size: large;border: 2px solid white;\" title=\"استعراض الفاتورة\" data-toggle=\"tooltip\"></button>";

                if (data[i].statusDescription === "Valid") {
                    html += "     <button type=\"button\" onclick=\"cancelDocument('" + data[i].deptOld + "','" + data[i].sectionOld + "','" + data[i].invSp + "');\" data-toggle=\"modal\" data-target=\"#InvoiceCancel\" class=\"fa fa-times-circle-o btn btn-danger\" style=\"font-size: large;border: 2px solid white;\" title=\"عمل إلغاء للفاتورة عند الضرائب\" data-toggle=\"tooltip\"></button>";
                }

                //+ "     <button type=\"button\" onclick=\"Verify('" + data[i].deptOld + "','" + data[i].sectionOld + "','" + data[i].invSp + "');\" data-toggle=\"modal\" data-target=\"#Verify\" class=\"fa fa-check btn btn-primary\" style=\"font-size: large;border: 2px solid white;\"></button>";



                html += "</td>"
                        + "</tr>";

            }
            if (i === 0) {
                AllData = [];
                $("#" + table_id + " tbody").empty();
                if (first_load) {
                    first_load = false;
                } else {
                    $("#" + table_id).DataTable().destroy();
                }
                $("#" + table_id + " tbody").empty();
                $("#" + table_id + " tbody").append("");

            } else {
                AllData = data;
                $("#" + table_id + " tbody").empty();
                if (first_load) {
                    first_load = false;
                } else {
                    $("#" + table_id).DataTable().destroy();
                }
                $("#" + table_id + " tbody").empty();
                $("#" + table_id + " tbody").append(html);

            }
            var table_json = {
                iDisplayLength: 10,
                keys: true,
                paging: true
            };

            var table = $("#" + table_id).DataTable(table_json);
            table.order(0, 'asc').draw();

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





function getInvoiceDetails(deptOld, sectionOld, inv_sp) {
    for (var i = 0; i < AllData.length; i++) {
        receiverTypeControlFields1(AllData[i].receiver.type);
        //fillModal(AllData[i]);
        if (AllData[i].deptOld === deptOld && AllData[i].sectionOld === sectionOld && AllData[i].invSp === inv_sp) {
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
    document.getElementById("invoRealDate1").value = data.invoRealDate;
    document.getElementById("serviceName1").value = data.serviceName;
    document.getElementById("notes1").value = data.notes;

    if (RecieveDevliverCodeStstus) {
        document.getElementById("permToReceiveCode1").value = data.permToReceiveCode;
        document.getElementById("permToDeliverCode1").value = data.permToDeliverCode;
        document.getElementById("permToReceiveDate1").value = data.permToReceiveDate;
        document.getElementById("permToDeliverDate1").value = data.permToDeliverDate;
    }

    /*var ErrorsDiv = document.getElementById("ErrorsDiv");
    var errorRmrk = document.getElementById("errorRmrk");
    if (data.statusRmrk === null || data.statusRmrk === "") {
        ErrorsDiv.style.display = "none";
        errorRmrk.innerHTML = "";
    } else {
        ErrorsDiv.style.display = "block";
        errorRmrk.innerHTML = "سبب رفض المستند : " + data.statusRmrk;
    }*/


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
var Global_inv_sp;
var Global_deptOld;
var Global_sectionOld;
function cancelDocument(deptOld, sectionOld, inv_sp) {
    document.getElementById("rmrk").value = "";
    Global_inv_sp = inv_sp;
    Global_deptOld = deptOld;
    Global_sectionOld = sectionOld;
}
async function sendInvoiceForCancellation() {
    if (portal_send_btn) {
        var rmrk = document.getElementById("rmrk").value;
        var portal_type = document.getElementById("portal_type_portal").value;
        if (rmrk === null || rmrk === "") {
            Warning("برجاء كتابة سبب عدم قبول المستند");
        } else {
            $.ajax({
                url: "_1_0_0_0_3_Electronic_Invoice_Query_02_cancelDocument?"
                        + "invSp=" + Global_inv_sp
                        + "&sectionId=" + Global_sectionOld
                        + "&deptId=" + Global_deptOld
                        + "&rmrk=" + rmrk
                        + "&portal_type=" + portal_type,
                type: 'POST',
                //dataType: 'json',
                //data: json,
                //contentType: 'application/json',
                // mimeType: 'application/json',
                success: function (data) {
                    if (data === "Success") {
                        Success("تم إلغاء الفاتورة");
                        $('#InvoiceCancel').modal('toggle');
                        Global_inv_sp = "";
                        Global_deptOld = "";
                        Global_sectionOld = "";
                        getInvoiceMaster();
                    } else if (data === "Error") {
                        Error("حدث خطأ");
                    } else {
                        Warning(data);
                    }
                },
                error: function (xhr, status) {
                    if (xhr.responseText === "Error") {
                        Error("حدث خطأ");
                    }
                }
            });
            //await sleep(1000);
        }
    } else {
        Warning("موقع الضرائب غير متصل");
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

function Info(Body, icon) {
    new PNotify({
        //title: "خطأ",
        delay: 2000,
        text: Body,
        type: 'info',
        styling: 'bootstrap3',
        icon: icon
    });
}

var portal_send_btn = false;
getServiceStatus();
setInterval(getServiceStatus, 10000);
function getServiceStatus() {

    var taxStatusDiv = document.getElementById("taxStatus");
    var signAppStatusDiv = document.getElementById("signAppStatus");
    var tokenStatusDiv = document.getElementById("tokenStatus");

    $.ajax({
        url: "_1_0_0_0_2_Electronic_Invoice_Query_zPortal_Send_03_getServiceStatus_AjaxServlet?",
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            console.log(data);
            if (data === "Error") {

            } else {
                taxStatus = data.split(",")[0];
                signAppStatus = data.split(",")[1];
                tokenStatus = data.split(",")[2];
                if (taxStatus === "0") {
                    taxStatusDiv.className = "fa fa-chain-broken";
                    taxStatusDiv.style.color = "red";
                    taxStatusDiv.innerHTML = " غير متصل .. برجاء الاتصال بالدعم الفني";
                } else {
                    taxStatusDiv.className = "fa fa-chain";
                    taxStatusDiv.style.color = "green";
                    taxStatusDiv.innerHTML = " متصل";
                }

                if (signAppStatus === "0") {
                    signAppStatusDiv.className = "fa fa-chain-broken";
                    signAppStatusDiv.style.color = "red";
                    signAppStatusDiv.innerHTML = " غير متصل .. برجاء الاتصال بالدعم الفني";
                } else {
                    signAppStatusDiv.className = "fa fa-chain";
                    signAppStatusDiv.style.color = "green";
                    signAppStatusDiv.innerHTML = " متصل";
                }

                if (tokenStatus === "0") {
                    tokenStatusDiv.className = "fa fa-chain-broken";
                    tokenStatusDiv.style.color = "red";
                    tokenStatusDiv.innerHTML = " غير متصل .. برجاء الاتصال بالدعم الفني";
                } else {
                    tokenStatusDiv.className = "fa fa-chain";
                    tokenStatusDiv.style.color = "green";
                    tokenStatusDiv.innerHTML = " متصل";
                }

                if (taxStatus === "1") {
                    portal_send_btn = true;
                } else {
                    portal_send_btn = false;
                }
            }


        },
        error: function (xhr, status) {
            taxStatusDiv.className = "fa fa-chain-broken";
            taxStatusDiv.style.color = "red";
            taxStatusDiv.innerHTML = " غير متصل .. برجاء الاتصال بالدعم الفني";

            signAppStatusDiv.className = "fa fa-chain-broken";
            signAppStatusDiv.style.color = "red";
            signAppStatusDiv.innerHTML = " غير متصل .. برجاء الاتصال بالدعم الفني";

            tokenStatusDiv.className = "fa fa-chain-broken";
            tokenStatusDiv.style.color = "red";
            tokenStatusDiv.innerHTML = " غير متصل .. برجاء الاتصال بالدعم الفني";

            portal_send_btn = false;
        }
    });
}