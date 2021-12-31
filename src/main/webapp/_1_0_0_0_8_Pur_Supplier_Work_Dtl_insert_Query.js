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

getAllSuppliersDtl();
var AllData = [];
var nameArry = [];
function getAllSuppliersDtl() {
    document.getElementById("supplierData").innerHTML = "<tr>"
            + "    <td colspan='6'><img src='webDesign/production/images/Spin-0.9s-200px.gif' alt='' style='width: 8%;'/></td>"
            + "</tr>";
    $.ajax({
        url: "_1_0_0_0_8_Pur_Supplier_Work_Dtl_insert_Query_Ajax_1_getAllSuppliersDtl_AjaxServlet?"
                + "deptId=" + deptId
                + "&sectionId=" + sectionId
                + "&accUnitId=" + accUnitId,
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            console.log(data);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var suppMainFrameCode = "";
            for (var i = 0; i < data.length; i++) {
                var suppSeq = data[i].suppSeq;
                var taxCardNo = data[i].taxCardNo;
                suppMainFrameCode = (data[i].receiverDetails[0].suppMainFrameCode == null) ? "-" : data[i].receiverDetails[0].suppMainFrameCode;
                var noOfDtl = data[i].receiverDetails.length;
                html += "<tr>";
                html += "<td rowspan='" + noOfDtl + "' class=\"table-font-style\" style=\"background-color: #ded5d5;vertical-align : middle;text-align:center;\">" + taxCardNo + "</td>";
                html += "<td rowspan='" + noOfDtl + "' class=\"table-font-sytle\" style=\"background-color: #ded5d5;vertical-align : middle;text-align:center;\">" + data[i].name + "</td>";
                html += "<td class=\"table-font-style\">" + data[i].receiverDetails[0].suppNameBr + "</td>";
                html += "<td class=\"table-font-style\">" + data[i].receiverDetails[0].addressBr + "</td>";
                html += "<td class=\"table-font-style\">" + suppMainFrameCode + "</td>";
                html += "<td>     <button type=\"button\" onclick=\"getUpdateModelData('" + suppSeq + "','" + data[i].name + "','" + data[i].receiverDetails[0].suppSeqBr + "',\n\
'" + data[i].receiverDetails[0].suppNameBr + "',\n\
'" + data[i].receiverDetails[0].addressBr + "',\n\
'" + suppMainFrameCode + "');\" data-toggle=\"modal\" data-target=\".supplierDetails\" class=\"fa fa-edit btn btn-success\" style=\"font-size: large;border: 2px solid white;\"></button>"
                        + "</td>";

                +"</tr>";

                var receiverDetails = data[i].receiverDetails;
                var suppMainFrameCodeJ = "";
                for (var j = 1; j < noOfDtl; j++) {
                    suppMainFrameCodeJ = (receiverDetails[j].suppMainFrameCode == null) ? "-" : receiverDetails[j].suppMainFrameCode;
                    html += "<tr>";
                    html += "<td class=\"table-font-style\">" + receiverDetails[j].suppNameBr + "</td>";
                    html += "<td class=\"table-font-style\">" + receiverDetails[j].addressBr + "</td>";
                    html += "<td class=\"table-font-style\">" + suppMainFrameCodeJ + "</td>";
                    html += "<td>      <button type=\"button\" onclick=\"getUpdateModelData('" + suppSeq + "','" + data[i].name + "','" + receiverDetails[j].suppSeqBr + "',\n\
'" + receiverDetails[j].suppNameBr + "',\n\
'" + receiverDetails[j].addressBr + "',\n\
'" + suppMainFrameCodeJ + "');\" data-toggle=\"modal\" data-target=\".supplierDetails\" class=\"fa fa-edit btn btn-success\" style=\"font-size: large;border: 2px solid white;\"></button>"
                            + "</td>";
                    +"</tr>";
                }


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


function addSupplierDtl() {
    var SuppSeq = document.getElementById("SuppSeq").value;
    var suppNameBr = document.getElementById("suppNameBr").value;
    var AddressBr = document.getElementById("AddressBr").value;
    var suppMainFrameCode = document.getElementById("suppMainFrameCode").value;

    if (SuppSeq === "" || SuppSeq === null) {
        Warning("برجاء اختيار المتعامل");
        return;
    } /*else if (suppNameBr === "" || suppNameBr === null) {
        Warning("برجاء ملئ خانة اسم القسم او الفرع");
        return;
    }*/

    $.ajax({
        url: "_1_0_0_0_8_Pur_Supplier_Work_Dtl_insert_Query_Ajax_2_addSupplierDtl_AjaxServlet?"
                + "SuppSeq=" + SuppSeq
                + "&suppNameBr=" + suppNameBr
                + "&AddressBr=" + AddressBr
                + "&suppMainFrameCode=" + suppMainFrameCode
                + "&deptId=" + deptId
                + "&sectionId=" + sectionId
                + "&accUnitId=" + accUnitId,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Success") {
                Success("تم حفظ العميل بنجاح");
                //clearModales();
                //$('.addSupplier').modal('toggle');
                getAllSuppliersDtl();
            } else {
                Error(data);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

var GLOBAL_SuppSeqBr;
function getUpdateModelData(suppSeq, suppName, suppSeqBr, suppNameBr, addressBr, suppMainFrameCode) {
    GLOBAL_SuppSeqBr = suppSeqBr;

    var FormContentArr = [];
    var field;
    var settings = {
        title: "<h3 style='text-align:center;'>تعديل فرع المتعامل: " + suppName + "</h3><br>",
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
        lable_: "اسم الفرع",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "suppNameBr1",
        filed_id: "suppNameBr1",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "" + suppNameBr + "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-6 col-md-6 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "عنوان الفرع",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "addressBr1",
        filed_id: "addressBr1",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "" + addressBr + "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-6 col-md-6 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "كود العميل الخاص بالمين فريم",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "suppMainFrameCode1",
        filed_id: "suppMainFrameCode1",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "" + suppMainFrameCode + "",
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
        filed_func: "onclick='updateSuppDetail(" + GLOBAL_SuppSeqBr + "," + suppSeq + ");'" //onclick='function();
    };
    FormContentArr.push(field);

    var Notify = {
        setting: settings,
        FormContent: FormContentArr
    };
    OpenModel(Notify);
}

function updateSuppDetail(suppSeqBr, suppSeq) {
    GLOBAL_SuppSeqBr = suppSeqBr;

    var suppNameBr1 = document.getElementById("suppNameBr1").value
    var addressBr1 = document.getElementById("addressBr1").value
    var suppMainFrameCode1 = document.getElementById("suppMainFrameCode1").value

    var suppNameBr = (suppNameBr1 == "null" || suppNameBr1 == "-") ? "" : suppNameBr1;
    var addressBr = (addressBr1 == "null" || addressBr1 == "-") ? "" : addressBr1;
    var suppMainFrameCode = (suppMainFrameCode1 == "null" || suppMainFrameCode1 == "-") ? "" : suppMainFrameCode1;



    $.ajax({
        url: "_1_0_0_0_8_Pur_Supplier_Work_Dtl_insert_Query_Ajax_3_updateSuppDetail_AjaxServlet?"
                + "suppSeq=" + suppSeq
                + "&suppSeqBr=" + GLOBAL_SuppSeqBr
                + "&suppNameBr=" + suppNameBr
                + "&addressBr=" + addressBr
                + "&suppMainFrameCode=" + suppMainFrameCode
                + "&deptId=" + deptId
                + "&sectionId=" + sectionId
                + "&accUnitId=" + accUnitId,
                type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Success") {
                Success("تم تعديل بيانات الفرع بنجاح");
                getAllSuppliersDtl();
                //clearModales();
                loader1.remove();
            } else {
                Error(data);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });

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

function allNumeric(id) {
    var inputtxt = document.getElementById(id);
    inputtxt.value = inputtxt.value.replace(/\D+/g, '');

}


$(function () {
    $(".SELECT_Combo").select2();
});