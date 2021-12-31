

function RunDocumentValidation(totalAmount) {
    if (
            ReceiverDataValedator(totalAmount) &&
            DocumentDataValedator() &&
            InvoicLinesValedator() &&
            DepiteAndCreditorValedator() &&
            DepiteAndCreditorWithReciverTypeValedator()
            ) {
        return true;
    } else {
        return false;
    }

}
function ReceiverDataValedator(totalAmount) {
    var receiverType = document.getElementById("receiverType").value;
    var receivername = document.getElementById("receivername").value;
    var id = document.getElementById("id").value;
    var governate = document.getElementById("governate").value;
    var street = document.getElementById("street").value;
    var buildingNumber = document.getElementById("buildingNumber").value;

    //console.log(totalAmount);


    if (receiverType === "small-P" || receiverType === "small-P-split") {
        if (+totalAmount > 50000 && receiverType === "small-P") {
            Warning("لابمكن للإجمالي أن يكون أكبر من 50,000");
            return false;
        }
    } else {

        /**
         * Check Receiver Data if it found in Databse
         */
        //alert(receiverData_selected);
        if (receiverData_selected !== null) {
            var receiver_data = receiverData_selected;
            //receiverData_array
            if (receiver_data.name !== receivername ||
                    receiver_data.id !== id ||
                    receiver_data.address.governate !== governate ||
                    receiver_data.address.street !== street ||
                    receiver_data.address.buildingNumber !== buildingNumber) {
                Warning("تم التلاعب ببيانات الصفحة");
                return false;
            }
        } else {
            Warning("لم يتم اختيار عميل");
            return false;
        }

        /**
         * Check Receiver Data  --- Cant be null
         */
        if (receiverType === "small-P" || receiverType === "small-P-split") {
            receiverType = "P";
        } else {
            console.log(receiverData_selected);
            if (receiverData_selected === null) {
                Warning("برجاء اختيار عميل");
                return false;
            } else if (receivername === "" || receivername === null) {
                Warning("برجاء ملئ اسم العميل");
                return false;
            } else if (id === "" || id === null) {
                if (receiverType === "B") {
                    Warning("برجاء ملئ البطاقة الضريبية");
                } else if (receiverType === "P") {
                    Warning("برجاء ملئ الرقم القومي");
                } else if (receiverType === "F") {
                    Warning("برجاء ملئ رقم جواز السفر");
                }
                return false;
            } else if (receiverType === "B" && id.length !== 9) {
                Warning("رقم البطاقة الضريبية لابد أن يكون 9 أرقام");
                return false;
            } else if (receiverType === "P" && id.length !== 14) {
                Warning("الرقم القومي لابد أن يكون 14 رقما");
                return false;
            } else if (governate === "" || governate === null) {
                Warning("برجاء ملئ خانة المحافظة");
                return false;
            } else if (street === "" || street === null) {
                Warning("برجاء ملئ خانة الشارع");
                return false;
            } /*else if (buildingNumber === "" || buildingNumber === null) {
             Warning("برجاء ملئ خانة رقم المبني");
             return false;
             }*/
        }
    }

    return true;
}


function DocumentDataValedator() {
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

function InvoicLinesValedator() {
    if (documents.length === 0) {
        Warning("لا يوجد صفوف للفاتورة لحفظها");
        return false;
    }
    return true;
}





var Search = false;
var Global_Invoice_Total_Amount = 0;
var Global_inv_Sp = "";
var searched_document_issue_date;

function DepiteAndCreditorValedator() {
    var documentType = document.getElementById("documentType").value;
    console.log("Test ::: " + documentType + " Test ::: " + Search);
    if (documentType === "I" && Search === true) {
        Warning("تم التلاعب ببيانات الصفحة");
        return false;
    } else if (documentType === "D" && Search) {//إشعار خصم
        return validateDepite();
    } else if (documentType === "C") {//إشعار إضافة
        return validateCreditor();
    }

    //last validation
    if (documentType === "C" || documentType === "D" || documentType === "I") {
        return true;
    }
}

function get_differance_between_two_dates(large_date, Small_date) {
    var date1 = new Date(Small_date);//صغير
    var date2 = new Date(large_date);//كبير
    var diffTime = Math.abs(date2 - date1);
    var diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
    //console.log(diffTime + " milliseconds");
    //console.log(diffDays + " days");
    return diffDays;
}

function validateDepite() {//إشعار خصم
    // totalAmount الاجمالي اللي فالجدول
    // Global_Invoice_Total_Amount الاجمالي اللي فالمستند المستعلم عنه

    console.log("إشعار خصم");
    console.log(" totalAmount : " + totalAmount);
    console.log(" Global_Invoice_Total_Amount : " + Global_Invoice_Total_Amount);
    if (+Global_Invoice_Total_Amount < +totalAmount) {
        Warning("لا يمكن زيادة قيمة المستند عن " + Global_Invoice_Total_Amount + " لأن نوع المستند إشعار خصم");
        return false;
    }

    var dateTimeIssued = document.getElementById("dateTimeIssued").value;//من الشاشة
    //searched_document_issue_date//من السيرش
    var no_of_dayes = get_differance_between_two_dates(dateTimeIssued, searched_document_issue_date);
    if (no_of_dayes < 0) {
        Warning("لا يمكن تسجيل إشعار الإضافة بتاريخ يسبق تاريخ المستند الأخير");
        return false;
    }

    return true;
}

function validateCreditor() {//إشعار إضافة

    console.log("إشعار إضافة");
    console.log(" totalAmount : " + totalAmount);
    console.log(" Global_Invoice_Total_Amount : " + Global_Invoice_Total_Amount);
    // totalAmount الاجمالي اللي فالجدول
    // Global_Invoice_Total_Amount الاجمالي اللي فالمستند المستعلم عنه
    if (+totalAmount < +Global_Invoice_Total_Amount) {
        Warning("لا يمكن تقليل قيمة المستند عن " + Global_Invoice_Total_Amount + " لأن نوع المستند إشعار إضافة");
        return false;
    }

    var dateTimeIssued = document.getElementById("dateTimeIssued").value;//من الشاشة
    //searched_document_issue_date//من السيرش
    var no_of_dayes = get_differance_between_two_dates(dateTimeIssued, searched_document_issue_date);
    if (no_of_dayes < 0) {
        Warning("لا يمكن تسجيل إشعار الإضافة بتاريخ يسبق تاريخ المستند الأخير");
        return false;
    }

    return true;
}


function DepiteAndCreditorWithReciverTypeValedator() {
    var documentType = document.getElementById("documentType").value;
    var receiverType = document.getElementById("receiverType").value;

    if ((documentType === "C" || documentType === "D") && receiverType !== receiverData_array[0].type) {
        return false;
    }

    return true;
}
