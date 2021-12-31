/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

checkSearch();
function checkSearch() {
    document.getElementById("internalId").value = "";
    document.getElementById("fromDate").value = "";
    document.getElementById("toDate").value = "";
    var searchType = document.getElementById("searchType").value;
    if (searchType === "bulk") {
        document.getElementById("internalIdField").style.display = "none";
        document.getElementById("fromDateField").style.display = "block";
        document.getElementById("toDateField").style.display = "block";
        document.getElementById("createdDate_OR_issueDateField").style.display = "block";
        document.getElementById("searchBTNForDate").style.display = "block";

    } else {
        document.getElementById("internalIdField").style.display = "block";
        document.getElementById("fromDateField").style.display = "none";
        document.getElementById("toDateField").style.display = "none";
        document.getElementById("createdDate_OR_issueDateField").style.display = "none";
        document.getElementById("searchBTNForDate").style.display = "none";
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
var colsppan = RecieveDevliverCodeStstus ? 12 : 9;
getInvoiceMaster();
async function getInvoiceMaster() {

    document.getElementById("Electronic_Invoice_Query_Master_Table").innerHTML =
            "<tr>"
            + "    <td colspan='" + colsppan + "'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    await sleep(100);

    var searchType = document.getElementById("searchType").value;
    var internalId = document.getElementById("internalId").value;
    var fromDate = document.getElementById("fromDate").value;
    var toDate = document.getElementById("toDate").value;
    var createdDate_OR_issueDate = document.getElementById("createdDate_OR_issueDate").value;
    var url = "";

    if (searchType === "bulk" && fromDate !== "" && toDate !== "") {
        url = "_1_0_0_1_0_Electronic_Invoice_Query_01_getInvoice_AjaxServlet?"
                + "deptId=" + deptId
                + "&sectionId=" + sectionId
                + "&accUnitId=" + accUnitId
                + "&fromDate=" + fromDate
                + "&toDate=" + toDate
                + "&createdDate_OR_issueDate=" + createdDate_OR_issueDate
                + "&searchType=" + searchType;
    } else if (internalId.length > 0) {
        url = "_1_0_0_1_0_Electronic_Invoice_Query_01_getInvoice_AjaxServlet?"
                + "deptId=" + deptId
                + "&sectionId=" + sectionId
                + "&accUnitId=" + accUnitId
                + "&internalId=" + internalId
                + "&searchType=" + searchType;
    } else {
        document.getElementById("Electronic_Invoice_Query_Master_Table").innerHTML =
                "<tr>"
                + "    <td colspan='" + colsppan + "'>لا توجد بيانات</td>"
                + "</tr>";
        return;
    }

    $.ajax({//_1_0_0_0_2_Electronic_Invoice_Query_verify_02_getAllInvoiceForVerify_AjaxServlet
        url: url,
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            loadResultTable(data);
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

function loadResultTable(data) {
    var searchType = document.getElementById("searchType").value;
    //console.log(data);
    //a_0_0_5_2_students = JSON.parse(data.toString());
    var html = "";
    var i = 0;
    for (i = 0; i < data.length; i++) {
        var printed_internal_id = data[i].internalID;

        if (printed_internal_id.includes("-")) {
            var printed_internal_id_split = printed_internal_id.split("-");
            if (+printed_internal_id_split[1] > 1) {
                continue;
            }
        }

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
        var del = (data[i].statusDescription === "محذوف" ? "<del style='color : red;'>" : "");
        var del2 = (data[i].statusDescription === "محذوف" ? "</del>" : "");
        html += "<tr>"
                + "<td class=\"table-font-style;\" style='direction : ltr;'>" + del + printed_internal_id + del2 + "</td>"
                + "<td class=\"table-font-style\">" + del + receiver_Type + del2 + "</td>"
                + "<td class=\"table-font-style\">" + del + documentType + del2 + "</td>"
                + "<td class=\"table-font-style\">" + del + data[i].receiver.name + del2 + "</td>"
                + "<td class=\"table-font-style\">" + del + data[i].dateTimeIssued + del2 + "</td>"
                + "<td class=\"table-font-style\">" + del + data[i].totalAmount + del2 + "</td>"
                + "<td class=\"table-font-style\">" + del + data[i].statusDescription + del2 + "</td>"
                + "<td class=\"table-font-style\">" + del + (data[i].paidFormCode === null ? "" : data[i].paidFormCode) + del2 + "</td>";
        if (RecieveDevliverCodeStstus) {
            html += "<td class=\"table-font-style\">" + del + (data[i].permToReceiveCode === null ? "" : data[i].permToReceiveCode) + del2 + "</td>"
                    + "<td class=\"table-font-style\">" + del + (data[i].permToDeliverCode === null ? "" : data[i].permToDeliverCode) + del2 + "</td>"
                    + "<td class=\"table-font-style\">" + del + (data[i].permToReceiveDate === null ? "" : data[i].permToReceiveDate) + del2 + "</td>";
        }
        html += "<td>"
                + "     <button type=\"button\" onclick=\"getInvoiceDetails('" + data[i].accUnitId + "','" + data[i].deptOld + "','" + data[i].sectionOld + "','" + data[i].invSp + "');\" data-toggle=\"modal\" data-target=\".InvoiceDetails\" class=\"fa fa-search btn btn-success\" style=\"font-size: large;border: 2px solid white;\" title=\"استعراض الفاتورة\" data-toggle=\"tooltip\"></button>";
        html += (LogBtnStatus) ? "<button type=\"button\" onclick=\"getInvoiceDetailsLog('" + data[i].accUnitId + "','" + data[i].deptOld + "','" + data[i].sectionOld + "','" + data[i].invSp + "');\" data-toggle=\"modal\" data-target=\".InvoiceDetailsLog\" class=\"fa fa-lock btn btn-dark\" style=\"font-size: large;border: 2px solid white;\" title=\"استعراض مراحل الفاتورة\" data-toggle=\"tooltip\"></button>" : "";
        html += "</td>";
        +"</tr>";

    }
    if (i === 0) {
        AllData = [];
        document.getElementById("Electronic_Invoice_Query_Master_Table").innerHTML =
                "<tr>"
                + "    <td colspan='" + colsppan + "'>لا توجد بيانات</td>"
                + "</tr>";

        document.getElementById("printBulkDiv").style.display = "none";
        Numbers_Of_Invoices = 0;
    } else {
        Numbers_Of_Invoices = 0;
        AllData = data;
        document.getElementById("Electronic_Invoice_Query_Master_Table").innerHTML = html;
        if (searchType === "bulk") {
            document.getElementById("printBulkDiv").style.display = "block";
            Numbers_Of_Invoices = data.length;
        }

    }
}
var Global_print_accUnitId;
var Global_print_deptOld;
var Global_print_sectionOld;
var Global_print_inv_sp;
function printPage(lang) {
    var URL2 = "_1_0_0_1_1_Electronic_Invoice_Query_print_AccessServlet?deptOld=" + Global_print_deptOld + "&sectionOld=" + Global_print_sectionOld + "&inv_sp=" + Global_print_inv_sp + "&Key=Open&lang=" + lang;
    window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=500,width=700,scrollbars=no,status=no');
}
var Numbers_Of_Invoices = 0;
function printPageBulk(lang) {
    var searchType = document.getElementById("searchType").value;
    var fromDate = document.getElementById("fromDate").value;
    var toDate = document.getElementById("toDate").value;
    var createdDate_OR_issueDate = document.getElementById("createdDate_OR_issueDate").value;
    var URL2 = "_1_0_0_1_1_Electronic_Invoice_Query_print2_AccessServlet?deptOld=" + deptId
            + "&sectionOld=" + sectionId
            + "&accUnitId=" + accUnitId
            + "&searchType=" + searchType
            + "&fromDate=" + fromDate
            + "&toDate=" + toDate
            + "&createdDate_OR_issueDate=" + createdDate_OR_issueDate
            + "&Numbers_Of_Invoices=" + Numbers_Of_Invoices
            + "&Key=Open&lang=" + lang;
    window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=500,width=700,scrollbars=no,status=no');
}

function getInvoiceDetails(accUnitId, deptOld, sectionOld, inv_sp) {
    for (var i = 0; i < AllData.length; i++) {
        receiverTypeControlFields1(AllData[i].receiver.type);
        //fillModal(AllData[i]);
        if (AllData[i].accUnitId === accUnitId && AllData[i].deptOld === deptOld && AllData[i].sectionOld === sectionOld && AllData[i].invSp === inv_sp) {
            Global_print_accUnitId = accUnitId;
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
    document.getElementById("invoRealDate1").value = data.invoRealDate;
    document.getElementById("serviceName1").value = data.serviceName;
    document.getElementById("notes1").value = data.notes;

    if (RecieveDevliverCodeStstus) {
        document.getElementById("permToReceiveCode1").value = data.permToReceiveCode;
        document.getElementById("permToDeliverCode1").value = data.permToDeliverCode;
        document.getElementById("permToReceiveDate1").value = data.permToReceiveDate;
        document.getElementById("permToDeliverDate1").value = data.permToDeliverDate;
    }

    var ErrorsDiv = document.getElementById("ErrorsDiv");
    var errorRmrk = document.getElementById("errorRmrk");
    if (data.statusRmrk === null || data.statusRmrk === "أرسلت بواسطة السيرفر" || data.statusRmrk === "عدلت بواسطة السيرفر") {
        ErrorsDiv.style.display = "none";
        errorRmrk.innerHTML = "";
    } else {
        ErrorsDiv.style.display = "block";
        errorRmrk.innerHTML = "سبب رفض المستند : " + data.statusRmrk;
    }

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
        html += "<tr style='background-color: palegreen;'><th colspan='4'>الإجماليات</th>"
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
        html += "<tr style='background-color: palegreen;'><th colspan='4'>الإجماليات</th>"
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

function getInvoiceDetailsLog(accUnitId, deptId, sectionId, invoSp) {
    document.getElementById("Invoice_Log").innerHTML =
            "<tr>"
            + "    <td colspan='5'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";

    var internalId = document.getElementById("internalId").value;
    if (internalId.length > 0) {
        $.ajax({//_1_0_0_0_2_Electronic_Invoice_Query_verify_02_getAllInvoiceForVerify_AjaxServlet
            url: "_1_0_0_1_0_Electronic_Invoice_Query_02_getInvoiceLog_AjaxServlet?"
                    + "deptId=" + deptId
                    + "&sectionId=" + sectionId
                    + "&accUnitId=" + accUnitId
                    + "&invoSp=" + invoSp,
            type: 'POST',
            dataType: 'json',
            //data: JSON.stringify(),
            //contentType: 'application/json',
            // mimeType: 'application/json',
            success: function (data) {
                //console.log(data);
                //a_0_0_5_2_students = JSON.parse(data.toString());
                getInvoiceDetails2(accUnitId, deptId, sectionId, invoSp);
                var html = "";
                var i = 0;
                console.log(data);
                for (i = 0; i < data.length; i++) {
                    html += "<tr>"
                            + "<td class=\"table-font-style;\" style='direction : ltr;'>" + i + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].invoDocumentStatus.docStatusName + "</td>"
                            + "<td class=\"table-font-style\" style='direction: ltr;'>" + data[i].currDateTime + "</td>"
                            + "<td class=\"table-font-style\">" + ((data[i].perEmploymentMaster === undefined) ? "السيرفر" : data[i].perEmploymentMaster.employeeId) + "</td>"
                            + "<td class=\"table-font-style\">" + ((data[i].perEmploymentMaster === undefined) ? "السيرفر" : data[i].perEmploymentMaster.empAname) + "</td>";
                    +"</tr>";

                }
                if (i === 0) {
                    AllData = [];
                    document.getElementById("Invoice_Log").innerHTML =
                            "<tr>"
                            + "    <td colspan='5'>لا توجد بيانات</td>"
                            + "</tr>";
                } else {
                    AllData = data;
                    document.getElementById("Invoice_Log").innerHTML = html;
                }

            },
            error: function (xhr, status) {
                Error("حدث خطأ");

            }
        });
    }
}

function getInvoiceDetails2(accUnitId, deptOld, sectionOld, inv_sp) {
    for (var i = 0; i < AllData.length; i++) {
        //receiverTypeControlFields1(AllData[i].receiver.type);
        //fillModal(AllData[i]);
        if (AllData[i].accUnitId === accUnitId && AllData[i].deptOld === deptOld && AllData[i].sectionOld === sectionOld && AllData[i].invSp === inv_sp) {
            fillModal2(AllData[i]);
            break;
        }
    }
}
function fillModal2(data) {
    console.log(data);
    var printed_internal_id = data.internalID;
    if (data.documentDividedStatus === "Divided") {
        printed_internal_id = " ( " + data.endDocSerial + " <span class='fa fa-arrow-right'></span> " + data.startDocSerial + " )" + data.internalID;
    }
    document.getElementById("invoiceID2").innerHTML = printed_internal_id;
}

/*
 * Alerts
 */
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

