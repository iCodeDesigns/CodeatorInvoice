
function updateDocument() {
    $("body :button").attr("disabled", true);
    var validationDocument = RunDocumentUpdateValidation();
    if (validationDocument) {
        //هنبعت
        var receiverType = document.getElementById("receiverType").value;
        if (receiverType === "small-P") {
            receiverType = "P";
        }
        var receivername = document.getElementById("receivername").value;
        var id = document.getElementById("id").value;
        var governate = document.getElementById("governate").value;
        var street = document.getElementById("street").value;
        var buildingNumber = document.getElementById("buildingNumber").value;
        // optional
        var postalCode = document.getElementById("postalCode").value;
        var floor = document.getElementById("floor").value;
        var room = document.getElementById("room").value;
        var landmark = document.getElementById("landmark").value;
        var additionalInformation = "";//document.getElementById("additionalInformation").value;

        var documentType = document.getElementById("documentType").value;
        var Invoice_number;
        if (chkInvoInternalIdSeq) {
            Invoice_number = invoInternalIdStart;
        } else {
            Invoice_number = document.getElementById("Invoice_number").value;
        }
        var dateTimeIssued = document.getElementById("dateTimeIssued").value;
        var invoRealDate = document.getElementById("invoRealDate").value;

        var country = "EG";
        if (receiverType === "F") {
            var country_code = document.getElementById("country_code").value;
            country = country_code;
        }

        var address = new Object();
        address.country = country;
        address.governate = (governate === null || governate === "") ? "-" : governate;
        address.regionCity = (governate === null || governate === "") ? "-" : governate;
        address.street = (street === null || street === "") ? "-" : street;
        address.buildingNumber = (buildingNumber === null || buildingNumber === "") ? "-" : buildingNumber;
        address.postalCode = (postalCode === null) ? "" : postalCode;
        address.floor = (floor === null) ? "" : floor;
        address.room = (room === null) ? "" : room;
        address.landmark = (landmark === null) ? "" : landmark;
        address.additionalInformation = (additionalInformation === null) ? "" : additionalInformation;

        var receiver = new Object();
        receiver.address = address;
        receiver.type = receiverType;
        receiver.id = id;
        receiver.name = receivername;

        //documents
        var document_json = new Object();
        document_json.receiver = receiver;
        document_json.documentType = documentType;
        document_json.dateTimeIssued = dateTimeIssued;
        document_json.invoRealDate = invoRealDate;
        document_json.internalID = Invoice_number;
        console.log("------------------------- standby");
        console.log(documents);
        document_json.invoiceLines = documents;
        document_json.totalSalesAmount = +totalSalesAmount;
        document_json.totalDiscountAmount = +totalDiscountAmount;
        document_json.netAmount = +netAmount;
        document_json.totalItemsDiscountAmount = +totalItemsDiscountAmount;
        document_json.extraDiscountAmount = +extraDiscountAmount;
        document_json.totalAmount = +totalAmount;

        var notes = document.getElementById("notes").value;
        var ServiceSeq = document.getElementById("ServiceSeq").value;
        document_json.notes = notes;
        document_json.serviceSeq = ServiceSeq;

        if (RecieveDevliverCodeStstus) {
            var permToReceiveCode = document.getElementById("permToReceiveCode").value;
            var permToDeliverCode = document.getElementById("permToDeliverCode").value;
            var permToReceiveDate = document.getElementById("permToReceiveDate").value;
            document_json.permToReceiveCode = permToReceiveCode;
            document_json.permToDeliverCode = permToDeliverCode;
            document_json.permToReceiveDate = permToReceiveDate;
        } else {
            document_json.permToReceiveCode = "";
            document_json.permToDeliverCode = "";
            document_json.permToReceiveDate = "";
        }

        var json = JSON.stringify(document_json);

        console.log(json);
        console.log("-- > main update btn");
        console.log("    -- > Global_inv_sp     : " + Global_inv_sp);
        console.log("    -- > Global_deptOld    : " + Global_deptOld);
        console.log("    -- > Global_sectionOld : " + Global_sectionOld);

        $.ajax({
            url: "_1_0_0_0_2_Electronic_Invoice_Query_99_submit_update_document_002_submitDocument?invSp=" + Global_inv_sp
                    + "&sectionId=" + Global_sectionOld
                    + "&deptId=" + Global_deptOld
                    + "&accUnitId=" + Global_accUnitId
                    + "&chkInvoInternalIdSeq=" + chkInvoInternalIdSeq,
            type: 'POST',
            //dataType: 'json',
            data: json,
            //contentType: 'application/json',
            // mimeType: 'application/json',
            success: function (data) {
                if (data === "Success") {
                    Success("تم حفظ الفاتورة");
                    resetScreen();
                    $('.InvoiceDetailsUpdate').modal('toggle');

                } else if (data === "Error") {
                    Error("حدث خطأ");
                } else {
                    Warning(data);

                }
                $("body :button").attr("disabled", false);
            },
            error: function (xhr, status) {
                if (xhr.responseText === "Error") {
                    Error("حدث خطأ");
                }
                $("body :button").attr("disabled", false);
            }
        });
    } else {
        //مش هنبعت عشان في غلط
        Warning("تأكد من إكتمال الفاتورة قبل الحفظ");
        $("body :button").attr("disabled", false);
    }
}


async function resetScreen() {
    receiverData_array = [];
    receiverData_selected = null;
    foundedInAhramData = "In";// In || NotIn
    unLockFieldsOfOtherReceiverData();

    documents = [];
    line_number = 0;

    totalSalesAmount = 0;
    totalDiscountAmount = 0;
    netAmount = 0;
    totalItemsDiscountAmount = 0;
    extraDiscountAmount = 0;
    total_of_all_line = 0;
    totalAmount = 0;

    document.getElementById("Invoice_number").value = "";
    receiverTypeControlFields();
    resetReceiverData();
    lines_data();
    drawTable();

    Global_inv_sp = "";
    Global_deptOld = "";
    Global_sectionOld = "";
    Global_accUnitId = "";
    //await sleep(1000);
    getInvoiceMaster();
}



