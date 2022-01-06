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

getAllServices();
var AllData = [];
function getAllServices() {
    document.getElementById("serviceData").innerHTML = "<tr>"
            + "    <td colspan='6'><img src='webDesign/production/images/Spin-0.9s-200px.gif' alt='' style='width: 8%;'/></td>"
            + "</tr>";
    $.ajax({
        url: "_1_0_0_1_8_InvoAdvCollectorCode_insert_Query_Ajax_1_getAllServices_AjaxServlet?"
                + "deptId=" + deptId
                + "&sectionId=" + sectionId
                + "&accUnitId=" + accUnitId,
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //console.log(data);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var i = 0;
            for (i = 0; i < data.length; i++) {
                serviceCode = (data[i].serviceCode == null) ? "-" : data[i].serviceCode;
                html += "<tr>"
                        + "<td class=\"table-font-style\">" + data[i].serviceSeq + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].serviceName + "</td>"
                        + "<td class=\"table-font-style\">" + serviceCode + "</td>"
                        + "<td>      <button type=\"button\" onclick=\"updateService_form('" + data[i].serviceSeq + "','" + data[i].serviceName + "','" + data[i].serviceCode + "');\"  class=\"fa fa-edit btn btn-success\" style=\"font-size: large;border: 2px solid white;\"></button>"
                        + "<button type=\"button\" onclick=\"deleteButton('" + data[i].serviceSeq + "');\" class=\"fa fa-trash btn btn-danger\" style=\" background-color: #851934;font-size: large;border: 2px solid white;\"></button>"
                        + "</td>"
                        + "</tr>";

            }
            if (i === 0) {
                document.getElementById("serviceData").innerHTML =
                        "<tr>"
                        + "    <td colspan='2'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                document.getElementById("serviceData").innerHTML = html;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function addService() {
    var serviceName = document.getElementById("serviceName").value;
    var serviceCode = document.getElementById("serviceCode").value;
    if (serviceName === "" || serviceName === null) {
        Warning("برجاء ملئ خانة اسم الخدمة");
        return;
    }
    $.ajax({
        url: "_1_0_0_1_8_InvoAdvCollectorCode_insert_Query_Ajax_2_addService_AjaxServlet?"
                + "serviceName=" + serviceName
                + "&serviceCode=" + serviceCode
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
                Success("تم حفظ الخدمة بنجاح");
                getAllServices();
            } else {
                Error(data);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

var serviceSeq_GLOBAL;
async function updateServiceContains(serviceSeq, serviceName) {
    serviceSeq_GLOBAL = serviceSeq;
    document.getElementById("serviceNameEdit").value = serviceName;

    await sleep(2000);
}

function updateService(serviceSeq) {
    var serviceNameEdit = document.getElementById("serviceNameEdit").value;
    var serviceCodeEdit = document.getElementById("serviceCodeEdit").value;

    if (serviceNameEdit === "" || serviceNameEdit === null) {
        Warning("برجاء ملئ خانة اسم الخدمة");
        return;
    }

    $.ajax({
        url: "_1_0_0_1_8_InvoAdvCollectorCode_insert_Query_Ajax_3_updateService_AjaxServlet?"
                + "serviceSeq=" + serviceSeq
                + "&serviceName=" + serviceNameEdit
                + "&serviceCode=" + serviceCodeEdit
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
                Success("تم تعديل الخدمة بنجاح");
                getAllServices();
                loader1.remove();
                //clearModales();
                //$('.updateService').modal('toggle');
            } else {
                Error(data);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function deleteService(serviceSeq) {
    serviceSeq_GLOBAL = serviceSeq;

    $.ajax({
        url: "_1_0_0_1_8_InvoAdvCollectorCode_insert_Query_Ajax_4_deleteService_AjaxServlet?"
                + "serviceSeq=" + serviceSeq_GLOBAL
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
                Success("تم حذف الخدمة بنجاح");
                getAllServices();
                loader1.remove();
                //clearModales();
            } else {
                Error(data);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function updateService_form(serviceSeq, serviceName, serviceCode) {
    var FormContentArr = [];
    var field;
    var settings = {
        title: "<h3 style='text-align:center;'>تعديل خدمة</h3>",
        close_status: true,
        card_fa_fa: "fa fa-spin", //fa fa-edit fa-spin
        addclass: 'stack-modal', // dark // stack-modal //'body-device stack-topleft':'stack-topleft' //notify-custom
        type: 'info', //"notice", "info", "success", or "error".
        width: '20%',
        card_class: "check_lock_div",
        card_id: "",
        card_style: "",
        fontsize: "60px"
    };

    field = {
        div_style: "",
        div_class: "col-lg-12 col-md-12 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "اسم الخدمة<span class=\"required\">*</span>",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "serviceNameEdit",
        filed_id: "serviceNameEdit",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: serviceName,
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-12 col-md-12 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "كود الخدمة<span class=\"required\">*</span>",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "serviceCodeEdit",
        filed_id: "serviceCodeEdit",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: serviceCode,
        filed_func: "" //onclick='function();
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
        filed_class: "btn btn-round btn-dark fa fa-check", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "نعم",
        filed_func: "onclick='updateService(" + serviceSeq + ");'" //onclick='function();
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

function deleteButton(serviceSeq) {
    var FormContentArr = [];
    var field;
    var settings = {
        title: "<h3 style='text-align:center;'>هل أنت متأكد من حذف الخدمة ؟؟..</h3>",
        close_status: true,
        card_fa_fa: "fa fa-spin", //fa fa-edit fa-spin
        addclass: 'stack-modal', // dark // stack-modal //'body-device stack-topleft':'stack-topleft' //notify-custom
        type: 'info', //"notice", "info", "success", or "error".
        width: '20%',
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
        filed_func: "onclick='deleteService(" + serviceSeq + ");'" //onclick='function();
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
