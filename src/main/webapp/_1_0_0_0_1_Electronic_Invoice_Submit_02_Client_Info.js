// ----> searchReseverName <---- true : search by receivername | false : search by id
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

var receiverData_array = [];
var receiverData_selected = null;
var foundedInAhramData = "In";// In || NotIn
async function QueryByReceiverNameOrId() {
    clearReceiverFields();
    //searchReseverName = true : search by receivername | false : search by id 
    await sleep(1000);
    if (searchReseverName) {
        var receivername = document.getElementById("receivername");
        if ($(receivername).is(':focus')) {
            document.getElementById("id").value = "";
        }
        QueryByReceiverName();
    } else {
        var id = document.getElementById("id");
        if ($(id).is(':focus')) {
            document.getElementById("receivername").value = "";
        }
        QueryByReceiverId();
    }
}
function QueryByReceiverName() {
    var receivername = document.getElementById("receivername").value;
    var receiverType = document.getElementById("receiverType").value;
    if (receivername.length > 3) {
        $.ajax({
            url: "_1_0_0_0_1_Electronic_Invoice_Submit_02_Client_Info_001_QueryByReceiverName?"
                    + "receivername=" + receivername
                    + "&receiverType=" + receiverType
                    + "&deptId=" + deptId
                    + "&sectionId=" + sectionId
                    + "&accUnitId=" + accUnitId,
            type: 'POST',
            //dataType: 'json',
            //data: JSON.stringify(_0_0_0_4_0_0_PerDecisionSheet_1_JasonFile),
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data) {
                //fillTheMultiSelectField(data);
                receiverData_array = data;
                fillTheMultiSelectField();
            },
            error: function (xhr, status) {
                //console.log(status); // Output as parseError
                //console.log(xhr.responseText); // My sResponse string ! But Why Here ?
                Error("حدث خطأ");
                foundedInAhramData = "NotIn";
                receiverData_array = [];
                receiverData_selected = null;
            }
        });
    } else {
        var receivername_select = document.getElementById("receivername_select");
        receivername_select.innerHTML = "";
    }
}

function QueryByReceiverId() {
    var id = document.getElementById("id").value;
    var receiverType = document.getElementById("receiverType").value;
    if (id.length > 3) {
        $.ajax({
            url: "_1_0_0_0_1_Electronic_Invoice_Submit_02_Client_Info_002_QueryByReceiverId?"
                    + "id=" + id
                    + "&receiverType=" + receiverType            
                    + "&deptId=" + deptId
                    + "&sectionId=" + sectionId
                    + "&accUnitId=" + accUnitId,
            type: 'POST',
            //dataType: 'json',
            //data: JSON.stringify(_0_0_0_4_0_0_PerDecisionSheet_1_JasonFile),
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data) {
                console.log(data);
                //fillTheMultiSelectField(data);
                receiverData_array = data;
                fillTheMultiSelectField();
            },
            error: function (xhr, status) {
                //console.log(status); // Output as parseError
                //console.log(xhr.responseText); // My sResponse string ! But Why Here ?
                Error("حدث خطأ");
                foundedInAhramData = "NotIn";
                receiverData_array = [];
                receiverData_selected = null;
            }
        });
    } else {
        var receivername_select = document.getElementById("receivername_select");
        receivername_select.innerHTML = "";
    }
}

function fillTheMultiSelectField() {

    /* const receiver_array = JSON.parse(receiverData_array);*/
    var receivername_select = document.getElementById("receivername_select");
    receivername_select.innerHTML = "";
    if (receiverData_array.length > 0) {
        for (var i = 0; i < receiverData_array.length; i++) {
            receivername_select.innerHTML +=
                    "<option value='" + receiverData_array[i].suppSeq + "'>"
                    + receiverData_array[i].suppSeq + " - " + receiverData_array[i].name + " - " + receiverData_array[i].id
                    + "</option>";
        }
        //document.getElementById("addReceiverCheck").style.display = 'none';
    } else {
        //document.getElementById("addReceiverCheck").style.display = 'block';
    }
}
function getSelected_receivername_Tofileds() {
    var receivername_select = document.getElementById("receivername_select").value;
    for (var i = 0; i < receiverData_array.length; i++) {
        if (receivername_select === receiverData_array[i].suppSeq) {
            fillFieldsOfOtherReceiverData(receiverData_array[i]);
        }
    }
    if (searchReseverName) {
        document.getElementById("id").readOnly = true;
    } else {
        document.getElementById("receivername").readOnly = true;
    }

}

function fillFieldsOfOtherReceiverData(data) {

    receiverData_selected = data;
    var status = true;
    if (data.id === null || data.id === "") {
        status = false;
        var id_name = (data.type === "B") ? "سجل تجاري" : "رقم قومي";
        Warning("العميل مسجل ولكن ليس له " + id_name);
    } else {
        if (data.type === "B" && data.id.length !== 9) {
            status = false;
            Warning("رقم البطاقة الضريبية لابد أن يكون 9 أرقام");
        } else if (data.type === "P" && data.id.length !== 14) {
            status = false;
            Warning("الرقم القومي لابد أن يكون 14 رقم");
        } else if (data.type === "F") {
            status = false;
        }
    }
    //console.log(status);
    lockFieldsOfOtherReceiverData();

    //status ? lockFieldsOfOtherReceiverData() : unLockFieldsOfOtherReceiverData();
    //document.getElementById("id").readOnly = status;

    document.getElementById("id").value = (status || (data.id !== null || data !== "")) ? data.id : "";

    document.getElementById("receivername").value = data.name;

    document.getElementById("country").value = data.address.countryCode;
    document.getElementById("governate").value = data.address.governate;
    document.getElementById("street").value = data.address.street;
    document.getElementById("buildingNumber").value = data.address.buildingNumber;
    document.getElementById("postalCode").value = data.address.postalCode;
    document.getElementById("floor").value = data.address.floor;
    document.getElementById("room").value = data.address.room;
    document.getElementById("landmark").value = data.address.landmark;

    document.getElementById("suppSeqBr").innerHTML = "<option value=''>اختر اسم التعامل مع العميل</option>";
    console.log(data);
    for (var i = 0; i < data.receiverDetails.length; i++) {
        var dtl = data.receiverDetails[i];
        console.log("-----------------");
        console.log(dtl);
        var address = (dtl.addressBr !== null) ? "-" + dtl.addressBr : "";
        var suppMainFrameCode = (dtl.suppMainFrameCode !== null) ? "-" + dtl.suppMainFrameCode : "";
        document.getElementById("suppSeqBr").innerHTML += "<option value='" + dtl.suppSeqBr + "'>" + dtl.suppNameBr + address + suppMainFrameCode + "</option>";
    }

}
function lockFieldsOfOtherReceiverData() {
    FieldsOfOtherReceiverData(true);
}
function unLockFieldsOfOtherReceiverData() {
    FieldsOfOtherReceiverData(true);
}
function FieldsOfOtherReceiverData(status) {
    document.getElementById("governate").readOnly = status;
    document.getElementById("street").readOnly = status;
    document.getElementById("buildingNumber").readOnly = status;
    document.getElementById("postalCode").readOnly = status;
    document.getElementById("floor").readOnly = status;
    document.getElementById("room").readOnly = status;
    document.getElementById("landmark").readOnly = status;
    document.getElementById("country").readOnly = status;
}
function clearReceiverFields() {
    document.getElementById("id").readOnly = false;
    document.getElementById("receivername").readOnly = false;

    document.getElementById("governate").value = "";
    document.getElementById("street").value = "";
    document.getElementById("buildingNumber").value = "";
    document.getElementById("postalCode").value = "";
    document.getElementById("floor").value = "";
    document.getElementById("room").value = "";
    document.getElementById("landmark").value = "";
    unLockFieldsOfOtherReceiverData();
    receiverData_array = [];
    receiverData_selected = null;
}





