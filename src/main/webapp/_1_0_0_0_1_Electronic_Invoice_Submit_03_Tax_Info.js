// ----> searchReseverName <---- true : search by receivername | false : search by id
//dep_id
//sec_id
//acc_code
getTaxes();
function getTaxes() {
    var subType = document.getElementById("subType");
    subType.innerHTML = "";
    var taxable = document.getElementById("taxable").value;
    $.ajax({
        url: "_1_0_0_0_1_Electronic_Invoice_Submit_03_Tax_Info_001_getTaxes?"
                + "taxable=" + taxable
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
            if (data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    subType.innerHTML += "<option value='" + data[i].taxType + "-" + data[i].subType + "," + data[i].rate + "'>" + data[i].subTypeName + "</option>";
                }
            } else {
                subType.innerHTML = "<option>لا توجد ضرائب مسجلة للقطاع</option>";
            }
            getRate();

        },
        error: function (xhr, status) {
            //console.log(status); // Output as parseError
            //console.log(xhr.responseText); // My sResponse string ! But Why Here ?
            Error("حدث خطأ");
            subType.innerHTML = "<option>لا توجد ضرائب مسجلة للقطاع</option>";
        }
    });
}

function getRate() {
    var subTypeElement = document.getElementById("subType");
    var taxTypeSubType_rate = subTypeElement.value.split(",")[1];
    document.getElementById("taxValue").value = taxTypeSubType_rate;
}

////////////////////////////////////--------------------------------------------
getTaxes_top();
function getTaxes_top() {
    var subType = document.getElementById("subType_top");
    subType.innerHTML = "";
    var taxable = document.getElementById("taxable_top").value;
    $.ajax({
        url: "_1_0_0_0_1_Electronic_Invoice_Submit_03_Tax_Info_001_getTaxes?"
                + "taxable=" + taxable
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
            if (data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    subType.innerHTML += "<option value='" + data[i].taxType + "-" + data[i].subType + "," + data[i].rate + "'>" + data[i].subTypeName + "</option>";
                }
            } else {
                subType.innerHTML = "<option>لا توجد ضرائب مسجلة للقطاع</option>";
            }
            getRate();

        },
        error: function (xhr, status) {
            //console.log(status); // Output as parseError
            //console.log(xhr.responseText); // My sResponse string ! But Why Here ?
            Error("حدث خطأ");
            subType.innerHTML = "<option>لا توجد ضرائب مسجلة للقطاع</option>";
        }
    });
}

function getRate_top() {
    var subTypeElement = document.getElementById("subType_top");
    var taxTypeSubType_rate = subTypeElement.value.split(",")[1];
    document.getElementById("taxValue_top").value = taxTypeSubType_rate;
}


////////////////////////////////------------------------------------------------

function changeTaxApplyType() {
    var TaxApplyType = document.getElementById("TaxApplyType").value;
    var taxes_top = document.getElementById("taxes_top");
    if (TaxApplyType === "taxOnLine") {
        taxes_top.style.display = "none";
    } else {
        taxes_top.style.display = "block";
    }
}


