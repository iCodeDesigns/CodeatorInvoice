/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
getTaxesChecks();
var no_of_tries = 0;
function getTaxesChecks() {
    var cellsInRow = 3;
    document.getElementById("taxTableCheck").innerHTML =
            "<tr>"
            + "    <td colspan='" + cellsInRow + "'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    //await sleep(1000);


    $.ajax({
        url: "_1_0_0_0_9_Invo_Item_Tax_Unit_Join_01_getTaxs_AjaxServlet?deptId=" + deptId + "&sectionId=" + sectionId + "&accUnitId=" + accUnitId,
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //console.log(data);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            html += "<tr>";
            for (var i = 0, row = 1; i < data.length; i++, row++) {
                var checked = (data[i].active === "true") ? " checked " : "";
                var taxable = (data[i].taxbleStatus === "1") ? "خاضع للضريبة" : "غير خاضع للضريبة";
                html += "<td id='Tax_" + data[i].deptId + "," + data[i].sectionId + "," + data[i].accUnitId + "," + data[i].taxType + "," + data[i].subType + "' style='text-align:right;'>"
                        + " <div class=\"\">\n"
                        + "    <label>\n"
                        + "      <input type=\"checkbox\" value=\"" + data[i].deptId + "," + data[i].sectionId + "," + data[i].accUnitId + "," + data[i].taxType + "," + data[i].subType + "\" name='taxCheck' class=\"js-switch\" " + checked + " /> " + data[i].subTypeName + "(" + taxable + ")\n"
                        + "    </label>\n"
                        + " </div>"
                        + " <input type=\"text\" class=\"form-control\" placeholder=\"تسمية المطلوبة\" value=\"" + data[i].subTypeNickName + "\" name=\"taxNickName\">"
                        + " <input type=\"number\" onkeyup=\"allFloatNumeric('tax_id_" + i + "');\" id=\"tax_id_" + i + "\" class=\"form-control\" placeholder=\"نسبة الضريبة\" value=\"" + data[i].rate + "\" name=\"taxRate\">"
                        + "</td>";

                if (row % cellsInRow === 0) {
                    html += "</tr>";
                    if (i !== data.length - 1) {
                        html += "<tr>";
                    }
                }


            }
            if (i === 0) {
                AllData = [];
                document.getElementById("taxTableCheck").innerHTML =
                        "<tr>"
                        + "    <td colspan='" + cellsInRow + "'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                AllData = data;
                document.getElementById("taxTableCheck").innerHTML = html;
            }
            getUnitsChecks();
        },
        error: function (xhr, status) {
            if (no_of_tries > 3) {
                Error("حدث خطأ");
            } else {
                getTaxesChecks();
                no_of_tries = no_of_tries + 1;
            }

        }
    });
}
function saveTaxs() {

    var selected_tax = [];

    var taxCheckArr = document.getElementsByName("taxCheck");
    var taxNickNameArr = document.getElementsByName("taxNickName");
    var taxRateArr = document.getElementsByName("taxRate");
    var Errors = 0;
    for (var i = 0; i < taxCheckArr.length; i++) {

        document.getElementById('Tax_' + taxCheckArr[i].value).style.backgroundColor = "";
        if (taxCheckArr[i].checked) {
            var taxNickName = taxNickNameArr[i].value;
            var taxRate = taxRateArr[i].value;
            if (taxNickName === "") {
                Warning("الضرائب المختارة لابد أن يكون لها تسمية");
                document.getElementById('Tax_' + taxCheckArr[i].value).style.backgroundColor = "#ffbfbf";
                Errors++;
            }
            if (taxRate === "") {
                Warning("الضرائب المختارة لابد أن يكون لها نسبة ضريبة");
                document.getElementById('Tax_' + taxCheckArr[i].value).style.backgroundColor = "#ffbfbf";
                Errors++;
            }


            var id = taxCheckArr[i].value.split(",");
            var one_tax_selected = new Object();
            one_tax_selected.deptId = id[0];
            one_tax_selected.sectionId = id[1];
            one_tax_selected.accUnitId = id[2];
            one_tax_selected.taxType = id[3];
            one_tax_selected.subType = id[4];

            one_tax_selected.subTypeNickName = taxNickName;
            one_tax_selected.rate = +taxRate;
            selected_tax.push(one_tax_selected);
        }
    }
    if (Errors > 0) {
        return;
    }

    $.ajax({
        url: "_1_0_0_0_9_Invo_Item_Tax_Unit_Join_02_saveTaxs_AjaxServlet?deptId=" + deptId + "&sectionId=" + sectionId + "&accUnitId=" + accUnitId,
        type: 'POST',
        //dataType: 'json',
        data: JSON.stringify(selected_tax),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //console.log(data);
            if (data === "Success") {
                getTaxesChecks();
                Success("تمت عملية الحفظ بنجاح");
            } else {
                Error("حدث خطأ");
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });

}
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////


var no_of_tries = 0;
function getUnitsChecks() {
    var cellsInRow = 6;
    document.getElementById("unitsTableCheck").innerHTML =
            "<tr>"
            + "    <td colspan='" + cellsInRow + "'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    //await sleep(1000);


    $.ajax({
        url: "_1_0_0_0_9_Invo_Item_Tax_Unit_Join_03_getUnits_AjaxServlet?deptId=" + deptId + "&sectionId=" + sectionId + "&accUnitId=" + accUnitId,
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //console.log(data);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            html += "<tr>";
            for (var i = 0, row = 1; i < data.length; i++, row++) {
                var checked = (data[i].active === "true") ? " checked " : "";
                html += "<td id='Unit_" + data[i].deptId + "," + data[i].sectionId + "," + data[i].accUnitId + "," + data[i].unitCode + "' style='text-align:right;'>"
                        + " <div class=\"\">\n"
                        + "    <label>\n"
                        + "      <input type=\"checkbox\" value=\"" + data[i].deptId + "," + data[i].sectionId + "," + data[i].accUnitId + "," + data[i].unitCode + "\" name='unitCheck' class=\"js-switch\" " + checked + " /> " + data[i].unitName + "\n"
                        + "    </label>\n"
                        + " </div>"
                        + " <input type=\"text\" class=\"form-control\" placeholder=\"تسمية المطلوبة\" value=\"" + data[i].unitNickName + "\" name=\"unitNickName\">"
                        + "</td>";

                if (row % cellsInRow === 0) {
                    html += "</tr>";
                    if (i !== data.length - 1) {
                        html += "<tr>";
                    }
                }


            }
            if (i === 0) {
                AllData = [];
                document.getElementById("unitsTableCheck").innerHTML =
                        "<tr>"
                        + "    <td colspan='" + cellsInRow + "'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                AllData = data;
                document.getElementById("unitsTableCheck").innerHTML = html;
            }
            switchCheck();
            getAllItemsDtl();
        },
        error: function (xhr, status) {
            if (no_of_tries > 3) {
                Error("حدث خطأ");
            } else {
                getTaxesChecks();
                no_of_tries = no_of_tries + 1;
            }

        }
    });
}
function saveUnits() {

    var selected_unit = [];

    var unitCheckArr = document.getElementsByName("unitCheck");
    var unitNickNameArr = document.getElementsByName("unitNickName");
    var Errors = 0;
    for (var i = 0; i < unitCheckArr.length; i++) {

        document.getElementById('Unit_' + unitCheckArr[i].value).style.backgroundColor = "";
        if (unitCheckArr[i].checked) {
            var unitNickName = unitNickNameArr[i].value;
            if (unitNickName === "") {
                Warning("وحدات القياس المختارة لابد أن يكون لها تسمية");
                document.getElementById('Unit_' + unitCheckArr[i].value).style.backgroundColor = "#ffbfbf";
                Errors++;
            }

            var id = unitCheckArr[i].value.split(",");
            var one_unit_selected = new Object();
            one_unit_selected.deptId = id[0];
            one_unit_selected.sectionId = id[1];
            one_unit_selected.accUnitId = id[2];
            one_unit_selected.unitCode = id[3];

            one_unit_selected.unitNickName = unitNickName;
            selected_unit.push(one_unit_selected);
        }
    }
    if (Errors > 0) {
        return;
    }

    $.ajax({
        url: "_1_0_0_0_9_Invo_Item_Tax_Unit_Join_04_saveUnits_AjaxServlet?deptId=" + deptId + "&sectionId=" + sectionId + "&accUnitId=" + accUnitId,
        type: 'POST',
        //dataType: 'json',
        data: JSON.stringify(selected_unit),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //console.log(data);
            if (data === "Success") {
                getUnitsChecks();
                Success("تمت عملية الحفظ بنجاح");
            } else {
                Error("حدث خطأ");
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });

}




////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

var AllData = [];
var nameArry = [];
function getAllItemsDtl() {
    document.getElementById("itemsTableData").innerHTML = "<tr>"
            + "    <td colspan='6'><img src='webDesign/production/images/Spin-0.9s-200px.gif' alt='' style='width: 8%;'/></td>"
            + "</tr>";
    $.ajax({
        url: "_1_0_0_0_9_Invo_Item_Tax_Unit_Join_05_getAllItemsDtl_AjaxServlet?deptId=" + deptId + "&sectionId=" + sectionId + "&accUnitId=" + accUnitId,
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            console.log(data);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var aItemDesc = "";
            var eItemDesc = "";
            var itemBarCode = "";
            for (var i = 0; i < data.length; i++) {
                aItemDesc = (data[i].itemDescDetails[0].aItemDesc == null) ? "-" : data[i].itemDescDetails[0].aItemDesc;
                eItemDesc = (data[i].itemDescDetails[0].eItemDesc == null) ? "-" : data[i].itemDescDetails[0].eItemDesc;
                itemBarCode = (data[i].itemDescDetails[0].itemBarcode == null) ? "-" : data[i].itemDescDetails[0].itemBarcode;
                var noOfDtl = data[i].itemDescDetails.length;
                html += "<tr>";
                html += "<td rowspan='" + noOfDtl + "' class=\"table-font-style\" style=\"background-color: #ded5d5;vertical-align : middle;text-align:center;\">" + data[i].itemCode + "</td>";
                html += "<td rowspan='" + noOfDtl + "' class=\"table-font-sytle\" style=\"background-color: #ded5d5;vertical-align : middle;text-align:center;\">" + data[i].description + "</td>";
                if (aItemDesc === "-" && eItemDesc === "-") {
                    html += "<td colspan='3' style='color: blue;'>لا يوجد توصبف لهذا الصنف</td>";
                } else {
                    html += "<td class=\"table-font-style\">" + aItemDesc + "</td>";
                    html += "<td class=\"table-font-style\">" + eItemDesc + "</td>";
                    html += "<td class=\"table-font-style\">" + itemBarCode + "</td>";
                    html += "<td>     <button type=\"button\" onclick=\"getUpdateModelData('" + data[i].itemDescDetails[0].itemSeq + "',\n\
'" + data[i].itemCode + "',\n\
'" + data[i].itemDescDetails[0].aItemDesc + "',\n\
'" + data[i].itemDescDetails[0].eItemDesc + "',\n\
'" + data[i].itemDescDetails[0].itemBarcode + "',\n\
'" + data[i].description + "');\" data-toggle=\"\" data-target=\"\" class=\"fa fa-edit btn btn-success\" style=\"font-size: large;border: 2px solid white;\"></button>";
                    html += "</td>";
                    html += "<td>     <button type=\"button\" onclick=\"getDeleteModelData('" + data[i].itemDescDetails[0].itemSeq + "');\" data-toggle=\"\" data-target=\"\" class=\"fa fa-trash btn btn-danger\" style=\"font-size: large;border: 2px solid white;\"></button>";
                    html += "</td>";
                }

                +"</tr>";

                var itemDescDetails = data[i].itemDescDetails;
                for (var j = 1; j < noOfDtl; j++) {
                    aItemDesc = (itemDescDetails[j].aItemDesc == null) ? "-" : itemDescDetails[j].aItemDesc;
                    eItemDesc = (itemDescDetails[j].eItemDesc == null) ? "-" : itemDescDetails[j].eItemDesc;
                    itemBarCode = (itemDescDetails[j].itemBarcode == null) ? "-" : itemDescDetails[j].itemBarcode;
                    html += "<tr>";
                    html += "<td class=\"table-font-style\">" + aItemDesc + "</td>";
                    html += "<td class=\"table-font-style\">" + eItemDesc + "</td>";
                    html += "<td class=\"table-font-style\">" + itemBarCode + "</td>";
                    html += "<td>      <button type=\"button\" onclick=\"getUpdateModelData('" + itemDescDetails[j].itemSeq + "',\n\
'" + data[i].itemCode + "',\n\
'" + itemDescDetails[j].aItemDesc + "',\n\
'" + itemDescDetails[j].eItemDesc + "',\n\
'" + itemDescDetails[j].itemBarcode + "',\n\
'" + data[i].description + "');\" data-toggle=\"\" data-target=\"\" class=\"fa fa-edit btn btn-success\" style=\"font-size: large;border: 2px solid white;\"></button>";
                    +"</td>";
                    html += "<td>     <button type=\"button\" onclick=\"getDeleteModelData('" + itemDescDetails[j].itemSeq + "');\" data-toggle=\"\" data-target=\"\" class=\"fa fa-trash btn btn-danger\" style=\"font-size: large;border: 2px solid white;\"></button>";
                    html += "</td>";
                    html += "</tr>";
                }


            }
            if (i === 0) {
                AllData = [];
                document.getElementById("itemsTableData").innerHTML =
                        "<tr>"
                        + "    <td colspan='6'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                AllData = data;
                document.getElementById("itemsTableData").innerHTML = html;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}


function addItemDtl() {
    var itemCode = document.getElementById("itemCode").value;
    var aItemDesc = document.getElementById("aItemDesc").value;
    var eItemDesc = document.getElementById("eItemDesc").value;
    var itemBarcode = document.getElementById("itemBarcode").value;

    if (itemCode === "" || itemCode === null) {
        Warning("برجاء اختيار صنف");
        return;
    } else if (aItemDesc === "" && eItemDesc === "" && itemBarcode !== "") {
        Warning("لادخال باركود للصنف لابد من ادخال توصيف بالعربية او الانجليزية");
        return;
    }

    $.ajax({
        url: "_1_0_0_0_9_Invo_Item_Tax_Unit_Join_06_AddItemDescDtl_AjaxServlet?"
                + "deptId=" + deptId
                + "&sectionId=" + sectionId
                + "&accUnitId=" + accUnitId
                + "&itemCode=" + itemCode
                + "&aItemDesc=" + aItemDesc
                + "&eItemDesc=" + eItemDesc
                + "&itemBarcode=" + itemBarcode,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Success") {
                Success("تم حفظ التوصيف بنجاح");
                getAllItemsDtl();
                //clearModales();
                //$('.addSupplier').modal('toggle');
            } else {
                Error(data);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

var GLOBAL_DescItemSeq;
function updateDescDetail(itemSeq) {
    GLOBAL_DescItemSeq = itemSeq;

    var aItemDesc = (document.getElementById("aItemDesc1").value == "null") ? "" : document.getElementById("aItemDesc1").value;
    var eItemDesc = (document.getElementById("eItemDesc1").value == "null") ? "" : document.getElementById("eItemDesc1").value;
    var itemBarcode = (document.getElementById("itemBarcode1").value == "null") ? "" : document.getElementById("itemBarcode1").value;

    if (aItemDesc === "" && eItemDesc === "" && itemBarcode !== "") {
        Warning("لادخال باركود للصنف لابد من ادخال توصيف بالعربية او الانجليزية");
        return;
    }

    $.ajax({
        url: "_1_0_0_0_9_Invo_Item_Tax_Unit_Join_07_UpdateItemDescDtl_AjaxServlet?"
                + "itemSeq=" + GLOBAL_DescItemSeq
                + "&aItemDesc=" + aItemDesc
                + "&eItemDesc=" + eItemDesc
                + "&itemBarcode=" + itemBarcode,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Success") {
                Success("تم تعديل التوصيف بنجاح");
                getAllItemsDtl();
                //clearModales();
                loader1.remove();
            } else {
                if (data === "Item Desc In InvoItem") {
                    Error("لم يتم التعديل لارتباط التوصيف بفواتير مدخلة");
                    getAllItemsDtl();
                    //clearModales();
                    loader1.remove();
                } else {
                    Error(data);
                }
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });

}


function getUpdateModelData(itemSeq, itemCode, aItemDesc1, eItemDesc1, itemBarcode1, itemName) {
    GLOBAL_DescItemSeq = itemSeq;

    var itemBarcode = (itemBarcode1 == "null") ? "" : itemBarcode1;
    var aItemDesc = (aItemDesc1 == "null") ? "" : aItemDesc1;
    var eItemDesc = (eItemDesc1 == "null") ? "" : eItemDesc1;

    var FormContentArr = [];
    var field;
    var settings = {
        title: "<h3 style='text-align:center;'>تعديل توصيف الصنف: " + itemName + "</h3><h3>كود الصنف: " + itemCode + "</h3><br>",
        close_status: true,
        card_fa_fa: "fa fa-edit", //fa fa-edit fa-spin
        addclass: 'stack-modal', // dark // stack-modal //'body-device stack-topleft':'stack-topleft' //notify-custom
        type: 'info', //"notice", "info", "success", or "error".
        width: '40%',
        card_class: "check_lock_div",
        card_id: "",
        card_style: "",
        fontsize: "60px"
    };

    field = {
        div_style: "",
        div_class: "col-lg-6 col-md-6 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "توصيف الصنف بالعربية",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "aItemDesc1",
        filed_id: "aItemDesc1",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "" + aItemDesc + "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-6 col-md-6 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "توصيف الصنف بالانجليزية",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "eItemDesc1",
        filed_id: "eItemDesc1",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "" + eItemDesc + "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-6 col-md-6 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "باركود الصنف ان وجد",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "itemBarcode1",
        filed_id: "itemBarcode1",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "" + itemBarcode + "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "text-align:center;",
        div_class: "col-lg-12 col-md-12 col-sm-6 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 0,
        lable_: "",
        lable_style: "",
        lable_class: "",
        field_type: "btn", //select - input - btn
        field_sub_type: "button", //button - password - text - date - number - etc.
        field_name: "",
        filed_id: "",
        filed_style: "",
        filed_class: "btn btn-round btn-dark fa fa-edit", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "حفظ التعديل",
        filed_func: "onclick='updateDescDetail(" + itemSeq + ");'" //onclick='function();
    };
    FormContentArr.push(field);

    var Notify = {
        setting: settings,
        FormContent: FormContentArr
    };
    OpenModel(Notify);
}


function deleteDescDetail(itemSeq) {
    GLOBAL_DescItemSeq = itemSeq;
    var xhttp = new XMLHttpRequest();
    var URL = "_1_0_0_0_9_Invo_Item_Tax_Unit_Join_08_DeleteItemDescDtl_AjaxServlet?"
            + "itemSeq=" + GLOBAL_DescItemSeq;
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function ()
    {
        if (xhttp.readyState === 4 && xhttp.status === 200)
        {
            var msg = xhttp.responseText;
            if (msg === "Success") {
                Success("تم الحذف بنجاح");
                getAllItemsDtl();
                //clearModales();
                loader1.remove();

            } else {
                if (msg === "Item Desc In InvoItem") {
                    Error("لم يتم الحذف لارتباط التوصيف بفواتير مدخلة");
                    getAllItemsDtl();
                    //clearModales();
                    loader1.remove();
                } else {
                    Error(msg);
                }
            }
        }
    }
}

function getDeleteModelData(itemSeq) {
    var FormContentArr = [];
    var field;
    var settings = {
        title: "<h3 style='text-align:center;'>هل أنت متأكد من حذف التوصيف؟؟..</h3><br>",
        close_status: true,
        card_fa_fa: "fa fa-trash", //fa fa-edit fa-spin
        addclass: 'stack-modal', // dark // stack-modal //'body-device stack-topleft':'stack-topleft' //notify-custom
        type: 'error', //"notice", "info", "success", or "error".
        width: '40%',
        card_class: "check_lock_div",
        card_id: "",
        card_style: "",
        fontsize: "60px"
    };


    field = {
        div_style: "text-align:center;",
        div_class: "col-lg-6 col-md-6 col-sm-6 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 0,
        lable_: "",
        lable_style: "",
        lable_class: "",
        field_type: "btn", //select - input - btn
        field_sub_type: "button", //button - password - text - date - number - etc.
        field_name: "",
        filed_id: "",
        filed_style: "",
        filed_class: "btn btn-round btn-dark fa fa-check", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "نعم",
        filed_func: "onclick='deleteDescDetail(" + itemSeq + ");'" //onclick='function();
    };
    FormContentArr.push(field);
    field = {
        div_style: "text-align:center;",
        div_class: "col-lg-6 col-md-6 col-sm-6 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 0,
        lable_: "",
        lable_style: "",
        lable_class: "",
        field_type: "btn", //select - input - btn
        field_sub_type: "button", //button - password - text - date - number - etc.
        field_name: "",
        filed_id: "",
        filed_style: "",
        filed_class: "btn btn-round btn-dark fa fa-close", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "لا",
        filed_func: "onclick='loader1.remove();'" //onclick='function();
    };
    FormContentArr.push(field);
    var Notify = {
        setting: settings,
        FormContent: FormContentArr
    };
    OpenModel(Notify);

}




function allFloatNumeric(id) {
    var inputtxt = document.getElementById(id).value;
    var dot_length = 0;
    //console.log(inputtxt !== null);
    if (inputtxt !== null) {
        var matched_str = inputtxt.match(/\./g);
        if (matched_str !== null) {
            dot_length = matched_str.length;
        }
    }
    if (dot_length <= 1) {
        if (inputtxt.match(/^(?!0\d)\d*(\.\d+)?$/)) {
            var matched_str = inputtxt.match(/\./g);
            if (matched_str !== null) {
                if (inputtxt.match(/\./g).length > 1) {
                    document.getElementById(id).value = "";
                }
            }
        } else {
            document.getElementById(id).value = inputtxt.replace(/[^\d.-]/g, '');
        }
    } else {
        inputtxt = process(inputtxt);//inputtxt.slice(0, -1);
        document.getElementById(id).value = inputtxt.replace(/[^\d.-]/g, '');
    }

}
function process(str) {
    return str.replace(/^([^.]*\.)(.*)$/, function (a, b, c) {
        return b + c.replace(/\./g, '');
    });
}


// Switchery
switchCheck();
function switchCheck() {
    $(document).ready(function () {
        if ($(".js-switch")[0]) {
            var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
            elems.forEach(function (html) {
                var switchery = new Switchery(html, {
                    color: '#26B99A'
                    , secondaryColor: '#dc0000'
                });
            });
        }
    });
}


$(function () {
    $(".SELECT_Combo").select2();
});
/*
 * Alerts
 */
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
