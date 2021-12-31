/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function getChange() {
    var PageSize = document.getElementById("records").value;
    var PageNo = 1;
    getFromPortal(PageSize, PageNo);
}

getFromPortal(10, 1);
var cuurentPage = 1;
function getFromPortal(PageSize, PageNo) {
    cuurentPage = +PageNo;
    console.log(cuurentPage);
    var portal_type = document.getElementById("portal_type").value;
    var table_data = document.getElementById("Electronic_Invoice_Query_Master_Table");
    var ResultsUp = document.getElementById("ResultsUp");
    var ResultsDown = document.getElementById("ResultsDown");
    table_data.innerHTML = "<tr>"
            + "    <td colspan='6'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    ResultsUp.innerHTML = 0;
    ResultsDown.innerHTML = 0;
    $.ajax({
        url: "_1_0_0_0_4_Electronic_Invoice_Invoice_Status_InTax_01_getFromPortal?"
                + "portal_type=" + portal_type
                + "&PageSize=" + PageSize
                + "&PageNo=" + PageNo,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(_0_0_0_4_0_0_PerDecisionSheet_1_JasonFile),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
            //fillTheMultiSelectField(data);            
            if (data.result.length > 0) {
                table_data.innerHTML = "";
                for (var i = 0; i < data.result.length; i++) {
                    var doc = data.result[i];
                    var color = "green !important";
                    var fafa = "fa-warning";
                    if (doc.status === "Valid") {
                        color = "green !important";
                        fafa = "fa-check-circle-o";
                    } else {
                        color = "red !important";
                        fafa = "fa-warning";
                    }

                    var morning_evening = (doc.dateTimeReceived.split(" ")[2] === "AM") ? "صباحا" : "مساءا";
                    table_data.innerHTML += "<tr>\n" +
                            "    <td>" + doc.internalId + "</td>\n" +
                            "    <td>" + doc.dateTimeReceived.split(" ")[0] + "</td>\n" +
                            "    <td>" + doc.dateTimeReceived.split(" ")[1].split(":")[0] + ":" + doc.dateTimeReceived.split(" ")[1].split(":")[1] + " " + morning_evening + "</td>\n" +
                            "    <td>" + doc.documentTypeNameSecondaryLang + "</td>\n" +
                            "    <td>" + doc.total + "</td>\n" +
                            "    <td>" + doc.receiverName + "</td>\n" +
                            "    <td> <a style=\"color: " + color + "; font - weight: bold; cursor: pointer;\" data-toggle=\"modal\" data-target=\".InvoiceDetails\" onclick=\"getInvoiceData('" + doc.uuid + "');\">" + doc.status + " <span class=\"fa " + fafa + "\"></span></a></td>\n" +
                            "</tr>";
                }
                ResultsUp.innerHTML = data.metadata.totalCount;
                ResultsDown.innerHTML = data.metadata.totalCount;
                loadPaging(data.metadata.totalPages, PageSize);
            } else {
                table_data.innerHTML = "<tr>\n" +
                        "    <td colspan='6'>لا توجد فواتير</td>\n" +
                        "</tr>";
                ResultsUp.innerHTML = 0;
                ResultsDown.innerHTML = 0;
            }

        },
        error: function (xhr, status) {
            //console.log(status); // Output as parseError
            //console.log(xhr.responseText); // My sResponse string ! But Why Here ?
            Error("حدث خطأ");
            table_data.innerHTML = "<tr>\n" +
                    "    <td colspan='6'>لا توجد فواتير</td>\n" +
                    "</tr>";
            ResultsUp.innerHTML = 0;
            ResultsDowns.innerHTML = 0;

        }
    });
}





function loadPaging(totalPages, PageSize) {
    var Spacing_number = 5;
    var pagingDiv = document.getElementById("pagingDiv");
    if (totalPages > 1) {
        html = "" +
                "<div class=\"paging\" id=\"numberingPaging\" style=\"float: left;direction: ltr;\">\n" +
                "   <button onclick=\"getFromPortal(" + PageSize + ", " + 1 + ");\" class=\"btn\">&laquo;</button>\n";

        if (cuurentPage - 1 > Spacing_number) {
            html += "   <button onclick=\"getFromPortal(" + PageSize + ", " + (+cuurentPage - 1) + ");\" class=\"btn\"><</button>";
        }
        for (var i = 1; i <= totalPages; i++) {
            var active = (cuurentPage === i) ? " activate" : "";
            var spacing = Math.abs(+cuurentPage - i);
            var style = (spacing <= Spacing_number) ? "display: block;" : "display: none;";

            html += "   <button onclick=\"getFromPortal(" + PageSize + ", " + i + ");\" class=\"btn " + active + "\" style='" + style + "'>" + i + "</button>";
        }
        if (totalPages - cuurentPage > Spacing_number) {
            html += "   <button onclick=\"getFromPortal(" + PageSize + ", " + (+cuurentPage + 1) + ");\" class=\"btn\">></button>";
        }
        html += "" +
                "   <button onclick=\"getFromPortal(" + PageSize + ", " + totalPages + ");\" class=\"btn\">&raquo;</button>\n" +
                "</div>"

        pagingDiv.innerHTML = html;
    } else {
        pagingDiv.innerHTML = "";
    }
    var header = document.getElementById("numberingPaging");
    var btns = header.getElementsByClassName("btn");
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function () {
            var current = document.getElementsByClassName("activate");

            console.log(current[0].innerHTML);
            current[0].className = current[0].className.replace(" activate", "");
            this.className += " activate";
        });
    }

    var elmnt = document.getElementById("pagingDiv");
    elmnt.scrollIntoView();
}


function getInvoiceData(uuid) {
    document.getElementById("LoadingCard").style.display = "block";
    document.getElementById("DataCard").style.display = "none";
    var ErrorsDiv = document.getElementById("ErrorsDiv");
    ErrorsDiv.style.display = "none";
    var errors_counter = document.getElementById("errors_counter");
    errors_counter.innerHTML = "";

    var portal_type = document.getElementById("portal_type").value;
    $.ajax({
        url: "_1_0_0_0_4_Electronic_Invoice_Invoice_Status_InTax_02_getInvoiceData?"
                + "portal_type=" + portal_type
                + "&documentUUID=" + uuid,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(_0_0_0_4_0_0_PerDecisionSheet_1_JasonFile),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
            //fillTheMultiSelectField(data);

            dealWithDocumentData(data);
            document.getElementById("LoadingCard").style.display = "none";
            document.getElementById("DataCard").style.display = "block";
        },
        error: function (xhr, status) {
            //console.log(status); // Output as parseError
            //console.log(xhr.responseText); // My sResponse string ! But Why Here ?
            Error("حدث خطأ");
            document.getElementById("LoadingCard").style.display = "block";
            document.getElementById("DataCard").style.display = "none";
        }
    });
}

function dealWithDocumentData(doc_data) {
    dealWithErrors(doc_data);
    fillDocumentRoPlace(doc_data);
}

function dealWithErrors(doc_data) {

    var ErrorsDiv = document.getElementById("ErrorsDiv");
    var errors_counter = document.getElementById("errors_counter");
    errors_counter.innerHTML = "";
    if (doc_data.status === "Invalid") {
        ErrorsDiv.style.display = "block";


        var validationSteps = doc_data.validationResults.validationSteps;
        var html = "<ol>";
        for (var i = 0; i < validationSteps.length; i++) {
            var validation = validationSteps[i];
            if (validation.status === "Invalid") {

                var errors = validation.error;
                html += "<li>" + validation.name;
                html += "<ul>";
                for (var j = 0; j < errors.innerError.length; j++) {
                    var innerError = errors.innerError[j];
                    html += "<li>" + innerError.error + "</li>";
                }
                html += "</li>";
                html += "</ul>";
            }
        }
        html += "</ol>";
        errors_counter.innerHTML = "";
        errors_counter.innerHTML = html;
    } else {
        ErrorsDiv.style.display = "none";
        errors_counter.innerHTML = "";
    }
}

function fillDocumentRoPlace(doc_data) {
    receverData(doc_data);
    issuerData(doc_data);
    issuerInvoiceLines(doc_data);
}

function receverData(doc_data) {
    var doc = JSON.parse(doc_data.document);
    document.getElementById("receivername").value = doc.receiver.name;
    document.getElementById("receiverAddress").value = doc.receiver.address.country + ",\n"
            + doc.receiver.address.governate + ",\n"
            + doc.receiver.address.regionCity + ",\n"
            + doc.receiver.address.street + ",\n"
            + doc.receiver.address.buildingNumber;

    var name = (doc.receiver.name === undefined) ? "" : doc.receiver.name;
    document.getElementById("receivername").value = name;
    var id = (doc.receiver.id === undefined) ? "" : doc.receiver.id;
    document.getElementById("receiverId").value = id;
    if (doc.receiver.type === "B") {
        receiverType = "Business";
    } else if (doc.receiver.type === "P") {
        receiverType = "Person";
    } else if (doc.receiver.type === "F") {
        receiverType = "Foreigner";
    }
    document.getElementById("receiverType").value = receiverType;
}

function issuerData(doc_data) {

    var doc = JSON.parse(doc_data.document);
    document.getElementById("issuerName").value = doc.issuer.name;
    document.getElementById("issuerAddress").value = doc.issuer.address.country + ",\n"
            + doc.issuer.address.governate + ",\n"
            + doc.issuer.address.regionCity + ",\n"
            + doc.issuer.address.street + ",\n"
            + doc.issuer.address.buildingNumber;
    document.getElementById("issuerId").value = doc.issuer.id;
    if (doc.issuer.type === "B") {
        receiverType = "Business";
    } else if (doc.issuer.type === "P") {
        receiverType = "Person";
    } else if (doc.issuer.type === "F") {
        receiverType = "Foreigner";
    }
    document.getElementById("issuerType").value = receiverType;
    document.getElementById("issuerActivityCode").value = doc.taxpayerActivityCode;
}

function issuerInvoiceLines(doc_data) {
    var doc = JSON.parse(doc_data.document);
    var html = "";
    var invoiceLines = document.getElementById("invoiceLines");
    invoiceLines.innerHTML = "";
    document.getElementById("invoiceID").innerHTML = doc.internalID;
    if (doc.invoiceLines.length > 0) {
        for (var i = 0; i < doc.invoiceLines.length; i++) {
            var line = doc.invoiceLines[i];
            html += "<tr id=\"line_" + i + "\">" +
                    "    <td style=\"text-align: center;\">" + line.itemCode + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.description + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.unitValue.amountEGP + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.quantity + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.salesTotal + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.discount.amount + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.netTotal + "</td>" +
                    "    <td style=\"text-align: center;\">" +
                    "        <table class=\"table table-striped table-bordered\">" +
                    "            <tbody id=\"line_" + i + "_Tax\">";

            for (var j = 0; j < line.taxableItems.length; j++) {
                var taxData = line.taxableItems[j];
                html += "<tr id=\"line_" + i + "_Tax_" + j + "\">\n" +
                        "    <td style=\"text-align: center;\">" + taxData.subType + "</td>\n" +
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
        invoiceLines.innerHTML += "<tr><th colspan='8'>الخصم</th><th>" + doc.extraDiscountAmount + "</th></tr>";
        invoiceLines.innerHTML += "<tr><th colspan='8'>الإجمالي</th><th>" + doc.totalAmount + "</th></tr>";
    } else {
        invoiceLines.innerHTML = "<tr><td colspan='10'>لا توجد سطور للفاتورة</td></tr>";
        invoiceLines.innerHTML += "<tr><th colspan='9'>الإجمالي</th><th></th></tr>";
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
