
function RunDocumentUpdateValidation() {
    if (
            DocumentDataUpdateValedator() &&
            InvoicLinesUpdateValedator()
            ) {
        return true;
    } else {
        return false;
    }

}

function DocumentDataUpdateValedator() {
    var Invoice_number;
    if (chkInvoInternalIdSeq) {
        Invoice_number = invoInternalIdStart;
    } else {
        Invoice_number = document.getElementById("Invoice_number").value;
    }
    var dateTimeIssued = document.getElementById("dateTimeIssued").value;
    
    if (RecieveDevliverCodeStstus) {
        var permToReceiveCode = document.getElementById("permToReceiveCode").value;
        var permToDeliverCode = document.getElementById("permToDeliverCode").value;
        var permToReceiveDate = document.getElementById("permToReceiveDate").value;
        if (RecieveDevliverCodeStstus === true && permToReceiveCode === "") {
            Warning("برجاء إدخال كود إذن التسليم");
            return false;
        }

        if (RecieveDevliverCodeStstus === true && permToDeliverCode === "") {
            Warning("برجاء إدخال كود إذن الصرف");
            return false;
        }

        if (RecieveDevliverCodeStstus === true && permToReceiveDate === "") {
            Warning("برجاء إدخال تاريخ التسليم والصرف");
            return false;
        }
    }
    
    if (Invoice_number === "" || Invoice_number === null) {
        Warning("برجاء إدخال رقم الفاتورة الداخلي");
        return false;
    } else if (dateTimeIssued === "" || dateTimeIssued === null) {
        Warning("تاريخ الفاتورة");
        return false;
    }
    return true;
}

function InvoicLinesUpdateValedator() {
    if (documents.length === 0) {
        Warning("لا يوجد صفوف للفاتورة لإجراء التعديل");
        return false;
    }
    return true;
}

