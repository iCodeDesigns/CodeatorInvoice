
controlPageAccordingDocumentType();
function controlPageAccordingDocumentType() {
    var documentType = document.getElementById("documentType").value;
    if (documentType === "I") {
        resetPageToNormal();
    } else if (documentType === "C") {
        closeAll();
    } else if (documentType === "D") {
        closeAll();
    } else {

    }
    document.getElementById("dateTimeIssued").min = "";
    document.getElementById("suppSeqBr").innerHTML = "";
}

function closeAll() {
    Search = true;
    document.getElementById("document_internalID_Div").style.display = "block";
    document.getElementById("document_search_Div").style.display = "block";
    document.getElementById("document_search_Div2").style.display = "block";

    document.getElementById("searchTotalAmount_Div").style.display = "block";
    document.getElementById("searchDateTimeIssued_Div").style.display = "block";
    document.getElementById("searchTotalAmount_Div").style.display = "block";

    document.getElementById("searchDateTimeIssued").disabled = true;
    document.getElementById("searchTotalAmount").disabled = true;

    document.getElementById("receiverType").disabled = true;
    document.getElementById("swap_btn").style.display = "none";
    document.getElementById("receivername").disabled = true;
    document.getElementById("receivername_select").style.display = "none";
    document.getElementById("id").disabled = true;
    document.getElementById("suppSeqBr").disabled = true;
    document.getElementById("ServiceSeq").disabled = true;
    if (!chkInvoInternalIdSeq) {
        document.getElementById("Invoice_number").disabled = true;
    }


    resetScreen();

}

function resetPageToNormal() {
    Search = false;
    document.getElementById("document_internalID_Div").style.display = "none";
    document.getElementById("document_search_Div").style.display = "none";
    document.getElementById("document_search_Div2").style.display = "none";
    document.getElementById("searchTotalAmount_Div").style.display = "none";
    document.getElementById("searchDateTimeIssued_Div").style.display = "none";
    document.getElementById("searchTotalAmount_Div").style.display = "none";

    document.getElementById("searchDateTimeIssued").disabled = true;
    document.getElementById("searchTotalAmount").disabled = true;

    document.getElementById("receiverType").disabled = false;
    document.getElementById("swap_btn").style.display = "block";
    document.getElementById("receivername").disabled = false;
    document.getElementById("receivername_select").style.display = "block";
    document.getElementById("id").disabled = false;
    document.getElementById("suppSeqBr").disabled = false;
    document.getElementById("ServiceSeq").disabled = false;
    if (!chkInvoInternalIdSeq) {
        document.getElementById("Invoice_number").disabled = false;
    }

    resetScreen();

}

function documentSearch() {
    var internalID = document.getElementById("document_internalID_search").value;
    if (internalID === "") {
        Warning("برجاء ملئ خانة رقم المستند");
    } else {
        $.ajax({
            url: "_1_0_0_0_1_Electronic_Invoice_Submit_07_document_search_001_getLastDocument?"
                    + "internalId=" + internalID
                    + "&sectionNoOld=" + sectionId
                    + "&depNoOld=" + deptId
                    + "&accUnitId=" + accUnitId,
            type: 'POST',
            dataType: 'json',
            //data: JSON.stringify(_0_0_0_4_0_0_PerDecisionSheet_1_JasonFile),
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data) {
                //fillTheMultiSelectField(data);
                console.log(JSON.stringify(data));
                if (data.length > 0) {
                    filScreen(data[0]);
                } else {
                    Warning("لا يوجد فاتورة بهذا الرقم");
                }

            },
            error: function (xhr, status) {
                //console.log(status); // Output as parseError
                //console.log(xhr.responseText); // My sResponse string ! But Why Here ?
                if (xhr.responseText === "NotSendToTaxPayerServer") {
                    Warning("الفاتورة المستعلم عنها مسجلة ولكن لم يتم ارسالها للضرائب بعد.. أو تكون فاتورة مقسمة");
                } else {
                    Error("خظأ");
                }
            }
        });
    }

}

function filScreen(data) {
    if (data.receiver.type !== "B") {
        Warning("إشعار الخصم والإضافة لا يتم الا على فواتير الشركات فقط");
        resetScreen();
        return;
    }
    Global_inv_Sp = data.invSp;
    Global_Invoice_Total_Amount = data.totalAmount;

    document.getElementById("receiverType").value = data.receiver.type;
    receiverTypeControlFields();
    Cash_Html_manipulation();
    HuntHacker();

    document.getElementById("receivername").value = data.receiver.name;
    document.getElementById("id").value = data.receiver.id;

    receiverData_array = [];
    receiverData_array.push(data.receiver);
    fillFieldsOfOtherReceiverData(receiverData_array[0]);
    if (receiverData_array[0].receiverDetails.length > 0) {
        document.getElementById("suppSeqBr").value = receiverData_array[0].receiverDetails[0].suppSeqBr;
    }

    document.getElementById("swap_btn").style.display = "none";

    document.getElementById("ServiceSeq").value = data.serviceSeq;


    if (!chkInvoInternalIdSeq) {
        var StartSequance = data.internalID.split("/")[0] + "/" + data.internalID.split("/")[1] + "/";
        var internalID = data.internalID.substr(StartSequance.length);
        document.getElementById("Invoice_number").value = internalID;
    }

    searched_document_issue_date = data.dateTimeIssued;

    document.getElementById("searchDateTimeIssued").value = searched_document_issue_date;

    document.getElementById("dateTimeIssued").value = searched_document_issue_date;
    document.getElementById("dateTimeIssued").min = searched_document_issue_date;
//document.getElementById("datefield").setAttribute("max", today);
    documents = [];
    documents = data.invoiceLines;
    line_number = documents.length;
    extraDiscountAmount = +data.extraDiscountAmount.toFixed(5);
    document.getElementById("extraDiscountAmount").value = extraDiscountAmount;
    drawTable(false);
    document.getElementById("searchTotalAmount").value = totalAmount;

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

    if (!chkInvoInternalIdSeq) {
        document.getElementById("Invoice_number").value = "";
    }
    document.getElementById("suppSeqBr").innerHTML = "";

    document.getElementById("searchTotalAmount").value = "";
    document.getElementById("searchDateTimeIssued").value = "";
    document.getElementById("extraDiscountAmount").value = "";

    receiverTypeControlFields();
    resetReceiverData();
    lines_data();
    drawTable(true);
}