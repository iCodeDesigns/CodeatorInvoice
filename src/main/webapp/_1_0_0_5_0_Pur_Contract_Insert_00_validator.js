/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var addNewTitle_bool = false;
var ContractSp_Global = "";
var TitleId_Global = "";
var contract_dtl_table = [];
function RunContractValidation(transaction_type) {
    if (
            TransactionValidatot(transaction_type) &&
            ReceiverDataValedator() &&
            ContractDtlValedator() &&
            ContractValedator()

            ) {
        return true;
    } else {
        return false;
    }

}
function TransactionValidatot(transaction_type) {
    var div_transaction_type = document.getElementById("transaction_type").value;
    if (div_transaction_type === transaction_type) {
        if (transaction_type === "edit" && (ContractSp_Global === "" || ContractSp_Global === null) && (TitleId_Global === "" || TitleId_Global === null)) {
            Warning("لا يوجد عقد مختار لتعديله");
            return false;
        }
        return true;
    } else {
        Warning("نم التلاعب ببيانات الصفحة بشكل غير صحيح");
        return false;
    }
}
function ReceiverDataValedator() {
    var receiverType = document.getElementById("receiverType").value;
    var receivername = document.getElementById("receivername").value;
    var id = document.getElementById("id").value;
    var governate = document.getElementById("governate").value;
    var street = document.getElementById("street").value;
    var buildingNumber = document.getElementById("buildingNumber").value;


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
    if (receiverType === "small-P") {
        receiverType = "P";
    } else {
        //console.log(receiverData_selected);
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

    return true;
}

function ContractValedator() {
//service_seq
//title_id
//title_text

    var title_id = document.getElementById("title_id").value;
    var title_text = document.getElementById("title_text").value;

    var selected_service_seq = [];
    for (var option of document.getElementById('service_seq').options)
    {
        if (option.selected) {
            selected_service_seq.push(option.value);
        }
    }

    console.log(selected_service_seq);

    var contractDate = document.getElementById("contractDate").value;
    var contractValue = document.getElementById("contractValue").value;
    var contractTax = document.getElementById("contractTax").value;
    var paymentKind = document.getElementById("paymentKind").value;
    var periodType = document.getElementById("periodType").value;
    var contractFromDate = document.getElementById("contractFromDate").value;
    var contractToDate = document.getElementById("contractToDate").value;
    var alertDate = document.getElementById("alertDate").value;



    var contract_date = new Date(contractDate);
    var start_of_interval = new Date(contractFromDate);
    // end - start returns difference in milliseconds 
    var diff_contracts = new Date(start_of_interval - contract_date);
    // get days
    var days_of_contracts = diff_contracts / 1000 / 60 / 60 / 24;




    var start_of_interval = new Date(contractFromDate);
    var end_of_interval = new Date(contractToDate);
    // end - start returns difference in milliseconds 
    var diff_of_interval = new Date(end_of_interval - start_of_interval);
    // get days
    var days_of_interval = diff_of_interval / 1000 / 60 / 60 / 24;


    var alertDate_of_interval = new Date(alertDate);
    // end - start returns difference in milliseconds 
    var diff_alertDate_of_interval = new Date(alertDate_of_interval - start_of_interval);
    // get days
    var days_alertDate_of_interval = diff_alertDate_of_interval / 1000 / 60 / 60 / 24;


    var diff_alertDate_of_interval_2 = new Date(end_of_interval - alertDate_of_interval);
    // get days
    var days_alertDate_of_interval_2 = diff_alertDate_of_interval_2 / 1000 / 60 / 60 / 24;

    /*var start_of_interval = new Date(contractFromDate);
     var end_of_interval = new Date(contractToDate);
     // end - start returns difference in milliseconds 
     var diff_of_interval = new Date(end_of_interval - start_of_interval);
     // get days
     var days_of_interval = diff_of_interval / 1000 / 60 / 60 / 24;*/



    if (title_id === "" && addNewTitle_bool === false) {
        Warning("برجاء اختيار عنوان العقد");
        return false;
    } else if (title_text === "" && addNewTitle_bool === true) {
        Warning("برجاء كتابة عنوان العقد");
        return false;
    } else if (selected_service_seq.length === 0) {
        Warning("برجاء اختيار نوع الخدمة");
        return false;
    } else if (contractDate === "") {
        Warning("برجاء اختيار تاريخ التعاقد");
        return false;
    } else if (contractValue === "") {
        Warning("برجاء كتابة قيمة العقد");
        return false;
    } else if (contractTax === "") {
        Warning("برجاء اختيار الموقف الضريبي");
        return false;
    } else if (paymentKind === "") {
        Warning("برجاء اختيار طريقة السداد");
        return false;
    } else if (periodType === "") {
        Warning("برجاء اختيار الأقساط");
        return false;
    } else if (contractFromDate === "") {
        Warning("برجاء اختيار تاريخ بدأ العقد");
        return false;
    } /*else if (contractToDate === "") {
     Warning("برجاء اختيار تاريخ نهاية القعد");
     return false;
     }*/ else if (alertDate === "") {
        Warning("برجاء اختيار تاريخ بدأ التنبيه بنهاية القعد");
        return false;
    } else if (+days_of_contracts < 0) {
        Warning("تاريخ بداية العقد لا يمكن أن يسبق تارخ التعاقد");
        return false;
    } else if (+days_of_interval < 0) {
        Warning("تاريخ نهاية العقد لا يمكن أن يسبق تارخ بدايته");
        return false;
    } else if (+days_alertDate_of_interval < 0) {
        Warning("تاريخ  بدأ التنبيه بنهاية العقد لا يمكن أن يسبق تارخ بدايته");
        return false;
    } else if (+days_alertDate_of_interval_2 < 0) {
        Warning("تاريخ  بدأ التنبيه بنهاية العقد لا يمكن أن يكون بعد تارخ نهايته");
        return false;
    }
    return true;
}

function ContractDtlValedator() {
    if (contract_dtl_table.length === 0) {
        Warning("برجاء حساب الأقساط قبل الحفظ");
        return false;
    }
    return true;
}
