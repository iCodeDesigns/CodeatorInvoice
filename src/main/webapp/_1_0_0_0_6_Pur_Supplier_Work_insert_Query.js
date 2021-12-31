/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
function Success(Body) {
    new PNotify({
        title: "تمت",
        delay: 2000,
        text: Body,
        type: 'success',
        position: 'top left',
        styling: 'bootstrap3'
    });
}
function Error(Body) {
    new PNotify({
        title: "خطأ",
        delay: 5000,
        text: Body,
        type: 'error',
        styling: 'bootstrap3'
    });
}
function Warning(Body) {
    new PNotify({
        title: "تحذير",
        delay: 2000,
        text: Body,
        styling: 'bootstrap3'
    });
}

function Info(Body, icon) {
    new PNotify({
        //title: "خطأ",
        delay: 2000,
        text: Body,
        type: 'info',
        styling: 'bootstrap3',
        icon: icon
    });
}

getAllSuppliers();
var AllData = [];
function getAllSuppliers() {
    document.getElementById("supplierData").innerHTML = "<tr>"
            + "    <td colspan='6'><img src='webDesign/production/images/Spin-0.9s-200px.gif' alt='' style='width: 8%;'/></td>"
            + "</tr>";
    $.ajax({
        url: "_1_0_0_0_6_Pur_Supplier_Work_insert_Query_Ajax_1_getAllSuppliers_AjaxServlet?",
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            console.log(data);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var i = 0;
            for (i = 0; i < data.length; i++) {
                var taxCardNo = data[i].taxCardNo;
                var identNo = data[i].identNo;
                var passportNo = data[i].passportNo;
                html += "<tr>"
                        + "<td class=\"table-font-style\">" + data[i].suppSeq + "</td>";


                if (passportNo === "") {
                    html += "<td class=\"table-font-style\">مصري</td>";
                    html += "<td class=\"table-font-style\">البطاقة الضريبية : " + ((taxCardNo === null || taxCardNo === "") ? "-" : taxCardNo) + "<br>الرقم القومي : " + ((identNo === null || identNo === "") ? "-" : identNo) + "</td>";
                } else {
                    html += "<td class=\"table-font-style\">أجنبي</td>";
                    html += "<td class=\"table-font-style\">رقم جواز السفر : " + ((passportNo === null || passportNo === "") ? "-" : passportNo) + "</td>";
                }

                html += "<td class=\"table-font-style\">" + data[i].name + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].address.governate + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].address.street + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].address.buildingNumber + "</td>";
                html += "<td>"


                        + "     <button type=\"button\" onclick=\"currentEditSupplier('"
                        + data[i].suppSeq + "','"
                        + taxCardNo + "','"
                        + identNo + "','"
                        + passportNo + "','"
                        + data[i].name
                        + "','" + data[i].address.country // governate Code --> countryCode_govCode
                        + "','" + data[i].address.additionalInformation // governate Code --> countryCode_govCode
                        + "','" + data[i].address.street
                        + "','" + ((data[i].address.buildingNumber === null || data[i].address.buildingNumber === "") ? "-" : data[i].address.buildingNumber)
                        + "');\" data-toggle=\"modal\" data-target=\".supplierDetails\" class=\"fa fa-edit btn btn-success\" style=\"font-size: large;border: 2px solid white;\" title=\"تعديل بيانات العميل\" data-toggle=\"tooltip\"></button>"


                        + "</td>"
                        + "</tr>";
            }
            if (i === 0) {
                AllData = [];
                document.getElementById("supplierData").innerHTML =
                        "<tr>"
                        + "    <td colspan='6'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                AllData = data;
                document.getElementById("supplierData").innerHTML = html;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function addSupplier() {
    var supplierName = document.getElementById("supplierName").value;
    var taxCardNo = document.getElementById("taxCardNo").value;
    var identNo = document.getElementById("identNo").value;
    var countryCode_govCode = document.getElementById("countryCode_govCode").value;
    var street = document.getElementById("street").value;
    var buildingNumber = document.getElementById("buildingNumber").value;

    var countryCode = document.getElementById("countryCode").value;
    var passport = document.getElementById("passport").value;
    if (supplierName === "" || supplierName === null) {
        Warning("برجاء ملئ خانة اسم العميل");
        return;
    } else if (countryCode === "1" && (taxCardNo === "" && identNo === "")) {
        Warning("برجاء ملئ خانة واحدة على الأقل من خانتي البطاقة الضريبية و الرقم القومي");
        return;
    } else if (countryCode === "1" && (taxCardNo !== "" && taxCardNo.length !== 9)) {
        Warning("خانة البطاقة الضريبية لابد أن تكون أرقاما فقط و مكونة من 9 أرقام");
        return;
    } else if (countryCode !== "1" && passport === "") {
        Warning("برجاء ملئ خانة رقم جواز السفر");
        return;
    } else if (countryCode === "1" && (identNo !== "" && identNo.length !== 14)) {
        Warning("خانة يطافة الرقم القومي لابد أن تكون أرقاما فقط و مكونة من 14 رقم");
        return;
    }

    var gov_code = "";
    if (countryCode_govCode !== "") {
        gov_code = countryCode_govCode.split("-")[1];
    }

    $.ajax({
        url: "_1_0_0_0_6_Pur_Supplier_Work_insert_Query_Ajax_2_addSupplier_AjaxServlet?"
                + "supplierName=" + supplierName
                + "&taxCardNo=" + taxCardNo
                + "&identNo=" + identNo
                + "&passport=" + passport
                + "&countryCode=" + countryCode
                + "&govCode=" + gov_code
                + "&street=" + street
                + "&buildingNumber=" + buildingNumber,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Success") {
                Success("تم حفظ العميل بنجاح");
                clearModales();
                $('.addSupplier').modal('toggle');
            } else {
                Error(data);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

var suppSeq_GLOBAL;
var TaxCardNumberTemp
async function currentEditSupplier(suppSeq, taxCardNo, identNo, passportNo, name, countryCode, countryCode_govCode, street, buildingNumber) {
    TaxCardNumberTemp = taxCardNo;
    suppSeq_GLOBAL = suppSeq;
    document.getElementById("supplierName_edit").value = name;

    if (passportNo === "" || passportNo === null) {
        document.getElementById("passport_editDiv").style.display = "none";
        document.getElementById("passport_edit").readOnly = true;

        document.getElementById("taxCardNo_editDiv").style.display = "block";
        document.getElementById("taxCardNo_edit").readOnly = false;

        document.getElementById("identNo_editDiv").style.display = "block";
        document.getElementById("identNo_edit").readOnly = false;



    } else {
        document.getElementById("passport_editDiv").style.display = "block";
        document.getElementById("passport_edit").readOnly = false;

        document.getElementById("taxCardNo_editDiv").style.display = "none";
        document.getElementById("taxCardNo_edit").readOnly = true;

        document.getElementById("identNo_editDiv").style.display = "none";
        document.getElementById("identNo_edit").readOnly = true;
    }
    document.getElementById("taxCardNo_edit").value = taxCardNo;
    document.getElementById("identNo_edit").value = identNo;
    document.getElementById("passport_edit").value = passportNo;

    document.getElementById("countryCode_edit").value = countryCode;
    getGov('countryCode_govCode_edit', 'countryCode_edit');
    await sleep(2000);

    if (countryCode_govCode === "") {
    } else {
        document.getElementById("countryCode_govCode_edit").value = countryCode_govCode;
    }


    document.getElementById("street_edit").value = street;
    document.getElementById("buildingNumber_edit").value = buildingNumber;

}
function editSupplier() {
    var supplierName = document.getElementById("supplierName_edit").value;
    var taxCardNo = document.getElementById("taxCardNo_edit").value;
    var identNo = document.getElementById("identNo_edit").value;
    var countryCode_govCode = document.getElementById("countryCode_govCode_edit").value;
    var street = document.getElementById("street_edit").value;
    var buildingNumber = document.getElementById("buildingNumber_edit").value;

    var buildingNumber = document.getElementById("buildingNumber_edit").value;

    var countryCode = document.getElementById("countryCode_edit").value;
    var passport = document.getElementById("passport_edit").value;
    if (supplierName === "" || supplierName === null) {
        Warning("برجاء ملئ خانة اسم العميل");
        return;
    } else if (countryCode === "1" && (taxCardNo === "" && identNo === "")) {
        Warning("برجاء ملئ خانة واحدة على الأقل من خانتي البطاقة الضريبية و الرقم القومي");
        return;
    } else if (countryCode === "1" && (taxCardNo !== "" && taxCardNo.length !== 9)) {
        Warning("خانة البطاقة الضريبية لابد أن تكون أرقاما فقط و مكونة من 9 أرقام");
        return;
    } else if (countryCode !== "1" && passport === "") {
        Warning("برجاء ملئ خانة رقم جواز السفر");
        return;
    } else if (countryCode === "1" && (identNo !== "" && identNo.length !== 14)) {
        Warning("خانة يطافة الرقم القومي لابد أن تكون أرقاما فقط و مكونة من 14 رقم");
        return;
    }

    var gov_code = "";
    if (countryCode_govCode !== "") {
        gov_code = countryCode_govCode.split("-")[1];
    }

    $.ajax({
        url: "_1_0_0_0_6_Pur_Supplier_Work_insert_Query_Ajax_3_editSupplier_AjaxServlet?"
                + "suppSeq=" + suppSeq_GLOBAL
                + "&supplierName=" + supplierName
                + "&taxCardNo=" + taxCardNo
                + "&TaxCardNumberTemp=" + TaxCardNumberTemp
                + "&identNo=" + identNo
                + "&passport=" + passport
                + "&countryCode=" + countryCode
                + "&govCode=" + gov_code
                + "&street=" + street
                + "&buildingNumber=" + buildingNumber,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Success") {
                Success("تم حفظ العميل بنجاح");
                clearModales();
                $('.supplierDetails').modal('toggle');
            } else {
                Error(data);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}
function getGov(id, from_id) {
    var countryCode = document.getElementById(from_id).value;

    $.ajax({
        url: "_1_0_0_0_6_Pur_Supplier_Work_insert_Query_Ajax_4_getGov_AjaxServlet?"
                + "countryCode=" + countryCode,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Error") {
                Error(data);
            } else {
                var countryCode_govCode = document.getElementById(id);
                countryCode_govCode.innerHTML = "";
                for (var i = 0; i < data.length; i++) {
                    countryCode_govCode.innerHTML += "<option value='" + data[i].countryCode + "-" + data[i].governateCode + "'>" + data[i].governate + "</option>";
                }
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}
function clearModales() {
    suppSeq_GLOBAL = "";
    document.getElementById("supplierName").value = "";
    document.getElementById("taxCardNo").value = "";
    document.getElementById("identNo").value = "";
    document.getElementById("street").value = "";
    document.getElementById("buildingNumber").value = "";

    document.getElementById("supplierName_edit").value = "";
    document.getElementById("taxCardNo_edit").value = "";
    document.getElementById("identNo_edit").value = "";
    document.getElementById("street_edit").value = "";
    document.getElementById("buildingNumber_edit").value = "";

    getAllSuppliers();
}

function TableSearch() {
    var input, filter, found, table, tr, td, i, j;
    input = document.getElementById("TableSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("supplierData");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td");
        for (j = 0; j < td.length; j++) {
            if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
                found = true;
            }
        }
        if (found) {
            tr[i].style.display = "";
            found = false;
        } else {
            tr[i].style.display = "none";
        }
    }
}
suppType();
function suppType() {
    var countryCode = document.getElementById("countryCode").value;
    if (countryCode === "1") {
        document.getElementById("passportDiv").style.display = "none";
        document.getElementById("passport").readOnly = true;

        document.getElementById("taxCardNoDiv").style.display = "block";
        document.getElementById("taxCardNo").readOnly = false;

        document.getElementById("identNoDiv").style.display = "block";
        document.getElementById("identNo").readOnly = false;
    } else {

        document.getElementById("passportDiv").style.display = "block";
        document.getElementById("passport").readOnly = false;

        document.getElementById("taxCardNoDiv").style.display = "none";
        document.getElementById("taxCardNo").readOnly = true;

        document.getElementById("identNoDiv").style.display = "none";
        document.getElementById("identNo").readOnly = true;
    }
}
function suppType2() {
    var countryCode = document.getElementById("countryCode_edit").value;
    if (countryCode === "1") {
        document.getElementById("passport_editDiv").style.display = "none";
        document.getElementById("passport_edit").readOnly = true;

        document.getElementById("taxCardNo_editDiv").style.display = "block";
        document.getElementById("taxCardNo_edit").readOnly = false;

        document.getElementById("identNo_editDiv").style.display = "block";
        document.getElementById("identNo_edit").readOnly = false;
    } else {

        document.getElementById("passport_editDiv").style.display = "block";
        document.getElementById("passport_edit").readOnly = false;

        document.getElementById("taxCardNo_editDiv").style.display = "none";
        document.getElementById("taxCardNo_edit").readOnly = true;

        document.getElementById("identNo_editDiv").style.display = "none";
        document.getElementById("identNo_edit").readOnly = true;
    }
}
function allNumeric(id) {
    var inputtxt = document.getElementById(id);
    inputtxt.value = inputtxt.value.replace(/\D+/g, '');

}
