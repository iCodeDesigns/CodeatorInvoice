
///////////////////// Portal Start
function getInvoiceData(uuid) {
    document.getElementById("LoadingCard_portal").style.display = "block";
    document.getElementById("DataCard_portal").style.display = "none";
    var ErrorsDiv = document.getElementById("ErrorsDiv_portal");
    ErrorsDiv.style.display = "none";
    var errors_counter = document.getElementById("errors_counter_portal");
    errors_counter.innerHTML = "";

    var portal_type = document.getElementById("portal_type_portal").value;
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
            document.getElementById("LoadingCard_portal").style.display = "none";
            document.getElementById("DataCard_portal").style.display = "block";
        },
        error: function (xhr, status) {
            //console.log(status); // Output as parseError
            //console.log(xhr.responseText); // My sResponse string ! But Why Here ?
            Error("حدث خطأ");
            document.getElementById("LoadingCard_portal").style.display = "block";
            document.getElementById("DataCard_portal").style.display = "none";
        }
    });
}
function dealWithDocumentData(doc_data) {
    dealWithErrors(doc_data);
    fillDocumentRoPlace(doc_data);
}

function dealWithErrors(doc_data) {

    var ErrorsDiv = document.getElementById("ErrorsDiv_portal");
    var errors_counter = document.getElementById("errors_counter_portal");
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

    document.getElementById("receiverAddress_portal").value = doc.receiver.address.country + ",\n"
            + doc.receiver.address.governate + ",\n"
            + doc.receiver.address.regionCity + ",\n"
            + doc.receiver.address.street + ",\n"
            + doc.receiver.address.buildingNumber;

    var name = (doc.receiver.name === undefined) ? "" : doc.receiver.name;
    document.getElementById("receivername_portal").value = name;
    var id = (doc.receiver.id === undefined) ? "" : doc.receiver.id;
    document.getElementById("receiverId_portal").value = id;
    if (doc.receiver.type === "B") {
        receiverType = "Business";
    } else if (doc.receiver.type === "P") {
        receiverType = "Person";
    } else if (doc.receiver.type === "F") {
        receiverType = "Foreigner";
    }
    document.getElementById("receiverType_portal").value = receiverType;
}

function issuerData(doc_data) {
    var doc = JSON.parse(doc_data.document);
    document.getElementById("issuerName_portal").value = doc.issuer.name;
    document.getElementById("issuerAddress_portal").value = doc.issuer.address.country + ",\n"
            + doc.issuer.address.governate + ",\n"
            + doc.issuer.address.regionCity + ",\n"
            + doc.issuer.address.street + ",\n"
            + doc.issuer.address.buildingNumber;
    document.getElementById("issuerId_portal").value = doc.issuer.id;
    if (doc.issuer.type === "B") {
        receiverType = "Business";
    } else if (doc.issuer.type === "P") {
        receiverType = "Person";
    } else if (doc.issuer.type === "F") {
        receiverType = "Foreigner";
    }
    document.getElementById("issuerType_portal").value = receiverType;
    document.getElementById("issuerActivityCode_portal").value = doc.taxpayerActivityCode;
}

function issuerInvoiceLines(doc_data) {
    var doc = JSON.parse(doc_data.document);
    var html = "";
    document.getElementById("notes").value = (doc.salesOrderDescription === undefined ? "" : doc.salesOrderDescription);
    var invoiceLines = document.getElementById("invoiceLines_portal");
    invoiceLines.innerHTML = "";
    document.getElementById("invoiceID_portal").innerHTML = doc.internalID;
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

///////////////////// Portal End