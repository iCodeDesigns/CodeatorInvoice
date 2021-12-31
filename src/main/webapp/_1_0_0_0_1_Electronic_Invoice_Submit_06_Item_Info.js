/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getItemCode() {
    var itemType = document.getElementById("itemType").value;
    $.ajax({
        url: "_1_0_0_0_1_Electronic_Invoice_Submit_06_Item_Info_002_getItemCode?"
                + "itemType=" + itemType
                + "&sectionNoOld=" + sectionId
                + "&depNoOld=" + deptId
                + "&accUnitId=" + accUnitId,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(_0_0_0_4_0_0_PerDecisionSheet_1_JasonFile),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
            //fillTheMultiSelectField(data);
            fillTheComboOfItemCode(data, itemType);
            setTimeout(getItemCodeDesc, 200);
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
}
function fillTheComboOfItemCode(data, itemType) {
    if (data.length === 0) {
        Warning("لا يوجد أصناف متاحة في " + itemType + " للادارة  الخاصة بك");
    }
    var itemSeq = document.getElementById("itemCode");
    itemSeq.innerHTML = "";
    for (var i = 0; i < data.length; i++) {
        var val = data[i].itemCode;
        var desc = data[i].description;
        itemSeq.innerHTML += "<option value='" + val + "' >" + desc + "</option>";
    }
}
function getItemCodeDesc() {
    var itemCode = document.getElementById("itemCode").value;
    $.ajax({
        url: "_1_0_0_0_1_Electronic_Invoice_Submit_06_Item_Info_001_getItemCodeDesc?"
                + "itemCode=" + itemCode
                + "&sectionNoOld=" + sectionId
                + "&depNoOld=" + deptId
                + "&accUnitId=" + accUnitId,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(_0_0_0_4_0_0_PerDecisionSheet_1_JasonFile),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
            //fillTheMultiSelectField(data);
            fillTheComboOfItemCodeDesc(data);
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
}

function fillTheComboOfItemCodeDesc(data) {
    var itemSeq = document.getElementById("itemSeq");
    itemSeq.innerHTML = "";
    for (var i = 0; i < data.length; i++) {
        var val = data[i].itemCode;
        var desc = data[i].description;
        itemSeq.innerHTML += "<option value='" + val + "' >" + desc + "</option>";
    }
}