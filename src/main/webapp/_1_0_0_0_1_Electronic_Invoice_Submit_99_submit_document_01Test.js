
function submitDocument() {

    document.getElementById("json_field").value = "";
    var validationDocument = RunDocumentValidation(totalAmount);
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
        var Invoice_number = document.getElementById("Invoice_number").value;
        var dateTimeIssued = document.getElementById("dateTimeIssued").value;


        var address = new Object();
        address.country = "EG";
        address.governate = governate;
        address.regionCity = governate;
        address.street = street;
        address.buildingNumber = (buildingNumber === null) ? "" : buildingNumber;
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
        document_json.internalID = Invoice_number;
        document_json.invoiceLines = documents;
        document_json.totalSalesAmount = +totalSalesAmount;
        document_json.totalDiscountAmount = +totalDiscountAmount;
        document_json.netAmount = +netAmount;
        document_json.totalItemsDiscountAmount = +totalItemsDiscountAmount;
        document_json.extraDiscountAmount = +extraDiscountAmount;
        document_json.totalAmount = +totalAmount;

        var json = JSON.stringify(document_json);

        var sendType = document.getElementById("sendType").value;
        //console.log(json);
        $.ajax({
            url: "_1_0_0_0_1_Electronic_Invoice_Submit_99_submit_document_001_submitDocument_API_Direct?sendType=" + sendType,
            type: 'POST',
            //dataType: 'json',
            data: json,
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data) {
                document.getElementById("json_field").value = JSON.stringify(data);
            },
            error: function (xhr, status) {
                if (xhr.responseText === "Success") {
                    Success("تم إرسال الفاتورة");
                    //resetScreen();
                } else {
                    Error(xhr.responseText);
                }
            }
        });
    } else {
        //مش هنبعت عشان في غلط
        Warning("تأكد من إكتمال الفاتورة قبل الحفظ");
    }
}


function resetScreen() {
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
}



