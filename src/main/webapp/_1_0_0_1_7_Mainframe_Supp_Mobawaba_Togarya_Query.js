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

function clearUpdatePerDepartments() {
    $('.update_supp_mainFrame').find('input').val('');
}

function checkSearchType() {
    var taxCardStatus = $('#taxCardStatus').val();
    if (taxCardStatus === "mainFrameCode") {
        $('#mainFrameCodeDiv').show();
    } else {
        $('#mainFrameCodeDiv').hide();
    }
}

var supp_mainFrame_data = [];

var first_load = true;
function query_supp_mainFrame() {
    $("body :button").attr("disabled", true);
    var table_id = "supp_mainFrame";
    loadingTable_GIF(table_id, 6);
    var taxCardStatus = $('#taxCardStatus').val();
    var mainFrameCode = $('#mainFrameCode').val();
    $.post("_1_0_0_1_7_Mainframe_Supp_Mobawaba_Togarya_Query_Ajax_01_query_supp_mainFrame_AjaxServlet?"
            + "accUnitId=" + accUnitId
            + "&taxCardStatus=" + taxCardStatus
            + "&mainFrameCode=" + mainFrameCode,
            {}, function (data) {
        supp_mainFrame_data = data;
        $("#" + table_id + " tbody").empty();
        if (first_load) {
            first_load = false;
        } else {
            $("#" + table_id).DataTable().destroy();
        }
        $("#" + table_id + " tbody").empty();

        $.each(data, function (i, item) {
            var color_style = "";
            if (item.taxCardNo === null) {
                color_style = "style='background-color: antiquewhite;'";
            }

            var serviceCode = "";
            try {
                serviceCode = item.serviceSeq.split("-")[1];
            } catch (err) {
                serviceCode = "";
            }

            var taxCardNo = (item.taxCardNo === null) ? "" : item.taxCardNo;
            $("#" + table_id + " tbody").append(
                    "  <tr " + color_style + ">"
                    + "    <td>" + item.mainFrameCode + "</td>"
                    + "    <td>" + item.suppName + "</td>"
                    + "    <td>" + taxCardNo + "</td>"
                    + "    <td>" + item.adress + "</td>"
                    + "    <td>" + item.prodCode + "</td>"
                    + "    <td>" + item.receiverCode + "</td>"
                    + "    <td>" + serviceCode + "</td>"
                    + "    <td>" + item.countryCode.split("-")[1] + "</td>"
                    + "    <td>" + item.govCode.split("-")[1] + "</td>"
                    + "    <td>"
                    + "        <button type='button' class='btn btn-round btn-primary fa fa-edit' onclick=\"update_supp_mainFrame_form('" + i + "');\"></button>"
                    + "        <button type='button' class='btn btn-round btn-success fa fa-send' onclick=\"move_supp_mainFrame_form('" + i + "');\"></button>"
                    + "    </td>"
                    + "</tr>"
                    );

        });

        var table_type = "show";
        var table_json = {};
        if (table_type === "show") {
            table_json = {
                iDisplayLength: 25,
                keys: true,
                paging: true
            };
        } else {
            table_json = {
                iDisplayLength: 25,
                keys: true,
                dom: 'Bfrtip',
                buttons: [
                    'copy', 'csv', 'excel', 'pdf', 'print'
                ]
            };
        }

        var table = $("#" + table_id).DataTable(table_json);
        table.order([0, 'asc']).draw();
        $("body :button").attr("disabled", false);
    });
}

function update_supp_mainFrame_form(data_index) {
    var country_option = getCountryOption(supp_mainFrame_data[data_index].countryCode.split("-")[0]);
    var FormContentArr = [];
    var field;
    var settings = {
        title: "<h3 style='text-align:center;'>تعديل</h3>",
        close_status: true,
        card_fa_fa: "fa fa-money", //fa fa-edit fa-spin
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
        div_class: "col-lg-12 col-md-12 col-sm-12 col-xs-12",
        no_of_top_br: 1,
        no_of_bot_br: 1,
        lable_: "اسم المتعامل",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "suppName",
        filed_id: "suppName",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: supp_mainFrame_data[data_index].suppName,
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-12 col-md-12 col-sm-12 col-xs-12",
        no_of_top_br: 1,
        no_of_bot_br: 1,
        lable_: "رقم البطاقة الضريبية",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "taxCardNo1",
        filed_id: "taxCardNo1",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: (supp_mainFrame_data[data_index].taxCardNo === null) ? "" : supp_mainFrame_data[data_index].taxCardNo,
        filed_func: "onkeyup=\"allNumeric('taxCardNo1');\"  maxlength='9'" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-12 col-md-12 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "العنوان",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "adress",
        filed_id: "adress",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: supp_mainFrame_data[data_index].adress,
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-6 col-md-6 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "الدولة",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "select", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "countryCode",
        filed_id: "countryCode",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: country_option,
        filed_func: "onchange='changeGov();'" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-6 col-md-6 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "المحافظة",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "select", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "govCode1",
        filed_id: "govCode1",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-6 col-md-6 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "كود المحصل",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "receiverCode",
        filed_id: "receiverCode",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: supp_mainFrame_data[data_index].receiverCode,
        filed_func: "onkeyup=\"allNumeric('receiverCode');\"  maxlength='3'" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "",
        div_class: "col-lg-6 col-md-6 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "كود المنتج",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "prodCode",
        filed_id: "prodCode",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: supp_mainFrame_data[data_index].prodCode,
        filed_func: "onkeyup=\"allNumeric(\'prodCode\');\"  maxlength='4'" //onclick='function();
    };
    FormContentArr.push(field);


    var serviceSeq = "";
    try {
        serviceSeq = supp_mainFrame_data[data_index].serviceSeq.split("-")[0];
    } catch (err) {
        serviceSeq = "";
    }
    field = {
        div_style: "",
        div_class: "col-lg-12 col-md-12 col-sm-12 col-xs-12",
        no_of_top_br: 0,
        no_of_bot_br: 1,
        lable_: "كود المصدر",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",
        field_type: "select", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "serviceSeq",
        filed_id: "serviceSeq",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: getServicesOption(serviceSeq),
        filed_func: "" //onclick='function();        
    };

    FormContentArr.push(field);

    field = {
        div_style: "text-align:center;",
        div_class: "col-lg-4 col-md-4 col-sm-6 col-xs-12",
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
        filed_value: "حفظ",
        filed_func: "onclick='update_supp_mainFrame(" + data_index + ",0);'" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "text-align:center;",
        div_class: "col-lg-4 col-md-4 col-sm-6 col-xs-12",
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
        filed_value: "حفظ وإرسال",
        filed_func: "onclick='update_supp_mainFrame(" + data_index + ",1);'" //onclick='function();
    };
    FormContentArr.push(field);

    field = {
        div_style: "text-align:center;",
        div_class: "col-lg-4 col-md-4 col-sm-6 col-xs-12",
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
        filed_value: "الغاء",
        filed_func: "onclick='loader1.remove();'" //onclick='function();
    };
    FormContentArr.push(field);
    var Notify = {
        setting: settings,
        FormContent: FormContentArr
    };
    OpenModel(Notify);

    allNumeric('taxCardNo1');
    getGov(supp_mainFrame_data[data_index].countryCode.split("-")[0], supp_mainFrame_data[data_index].govCode.split("-")[0]);
}

//HTML += "<option " + selected + " value='" + data[i].countryCode + "'>" + data[i].country + "</option>";
var countries = [];
getCountry();
function getCountry() {
    $.ajax({
        url: "_1_0_0_0_6_Pur_Supplier_Work_insert_Query_Ajax_5_getCountry_AjaxServlet?",
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Error") {
                Error(data);
                countries = [];
            } else {
                countries = data;
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
            countries = [];
        }
    });
}
function getCountryOption(selected_country) {
    var HTML = "";
    for (var i = 0; i < countries.length; i++) {
        var selected = "";
        if (+selected_country === +countries[i].countryCode) {
            selected = "selected";
        }
        HTML += "<option " + selected + " value='" + countries[i].countryCode + "'>" + countries[i].country + "</option>";
    }
    return HTML;
}

function getServicesOption(selected_services) {
    var HTML = "<option value=''>لا يوجد كود مصدر</option>";
    for (var i = 0; i < AllServices.length; i++) {
        var selected = "";
        if (+selected_services === +AllServices[i].countryCode) {
            selected = "selected";
        }
        var serviceCode = (AllServices[i].serviceCode === null) ? "" : " - " + AllServices[i].serviceCode;
        HTML += "<option " + selected + " value='" + AllServices[i].serviceSeq + "'>" + AllServices[i].serviceName + serviceCode + "</option>";
    }
    return HTML;
}

getAllServices();
var AllServices = [];
// serviceCode = (data[i].serviceCode == null) ? "-" : data[i].serviceCode;
//+ "<td class=\"table-font-style\">" + data[i].serviceSeq + "</td>"
//+ "<td class=\"table-font-style\">" + data[i].serviceName + "</td>"
function getAllServices() {
    $.ajax({
        url: "_1_0_0_1_3_PurContractServiceType_insert_Query_Ajax_1_getAllServices_AjaxServlet?"
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
            AllServices = data;
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
            AllServices = [];
        }
    });
}


function changeGov() {
    var countryCode = document.getElementById("countryCode").value;
    getGov(countryCode, "");
}
function getGov(countryCode, selected_gov_id) {
    var HTML = "<option value='*'>لا يوجد محافظة</option>";
    $.ajax({
        url: "_1_0_0_0_6_Pur_Supplier_Work_insert_Query_Ajax_4_getGov_AjaxServlet?"
                + "countryCode=" + countryCode,
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            console.log(data);
            if (data === "Error") {
                Error(data);
                HTML = "";
            } else {
                for (var i = 0; i < data.length; i++) {
                    var selected = "";

                    if ((+selected_gov_id === +data[i].governateCode) && (+countryCode === +data[i].countryCode)) {
                        selected = "selected";
                    }
                    HTML += "<option " + selected + " value='" + data[i].countryCode + "-" + data[i].governateCode + "'>" + data[i].governate + "</option>";
                }
            }
            document.getElementById("govCode1").innerHTML = HTML;
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
            document.getElementById("govCode1").innerHTML = "";
        }
    });
}

function update_supp_mainFrame(data_index, btn_type) {
    var supp_mainFrame_data_Edit = supp_mainFrame_data[data_index];
    var suppName = $('#suppName').val();
    var taxCardNo = $('#taxCardNo1').val();
    var adress = $('#adress').val();
    var countryCode = $('#countryCode').val();
    var govCode = $('#govCode1').val().split('-')[1];
    var receiverCode = $('#receiverCode').val();
    var prodCode = $('#prodCode').val();
    var serviceSeq = $('#serviceSeq').val();
    if (suppName === "") {
        Warning("برجاء ملئ اسم المتعامل");
        return;
    }

    /*if (taxCardNo === "" || taxCardNo.length !== 9) {
     Warning("برجاء ملئ رقم البطاقة الضريبية ب تسعة أرقام");
     return;
     }*/

    if (adress === "") {
        supp_mainFrame_data.adress = "القاهرة";
    }

    if (countryCode === "") {
        Warning("برجاء اختيار دولة");
        return;
    }

    if (countryCode === "1" && govCode === "*") {
        Warning("برجاء اختيار محافظة");
        return;
    }

    if (receiverCode === "") {
        Warning("برجاء ملئ كود المحصل");
        return;
    }

    if (prodCode === "") {
        Warning("برجاء ملئ كود المنتج");
        return;
    }

    if (serviceSeq === "") {
        Warning("برجاء اختيار كود المصدر");
        return;
    }

    supp_mainFrame_data_Edit.suppName = suppName;
    supp_mainFrame_data_Edit.taxCardNo = taxCardNo;
    supp_mainFrame_data_Edit.adress = adress;
    supp_mainFrame_data_Edit.countryCode = countryCode;
    supp_mainFrame_data_Edit.govCode = govCode;
    supp_mainFrame_data_Edit.receiverCode = receiverCode;
    supp_mainFrame_data_Edit.prodCode = prodCode;
    supp_mainFrame_data_Edit.serviceSeq = serviceSeq;
    $("body :button").attr("disabled", true);
    $.ajax({
        url: "_1_0_0_1_7_Mainframe_Supp_Mobawaba_Togarya_Query_Ajax_02_update_supp_mainFrame_AjaxServlet?"
                + "accUnitId=" + accUnitId,
        type: 'POST',
        //dataType: 'json',
        data: JSON.stringify(supp_mainFrame_data_Edit),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Success") {
                Success("تم التعديل");
                if (btn_type === "0") {
                    query_supp_mainFrame();
                } else {
                    do_move_supp_mainFrame_form(supp_mainFrame_data_Edit);
                }
                loader1.remove();
            } else {
                Warning(data);
            }
            $("body :button").attr("disabled", false);
        },
        error: function (xhr, status) {
            Errors("حدث خطأ");
            $("body :button").attr("disabled", false);
        }
    });
}

function move_supp_mainFrame_form(data_index) {
    var supp_mainFrame_data_Edit = supp_mainFrame_data[data_index];
    do_move_supp_mainFrame_form(supp_mainFrame_data_Edit);
}

function do_move_supp_mainFrame_form(supp_mainFrame_data_Edit) {
    if (supp_mainFrame_data_Edit.suppName === "") {
        Warning("برجاء ملئ اسم المتعامل");
        return;
    }

    /*if (supp_mainFrame_data_Edit.taxCardNo === "" || supp_mainFrame_data_Edit.taxCardNo.length !== 9) {
     Warning("برجاء ملئ رقم البطاقة الضريبية ب تسعة أرقام");
     return;
     }*/

    if (supp_mainFrame_data_Edit.adress === "") {
        supp_mainFrame_data_Edit.adress = "القاهرة";
    }

    if (supp_mainFrame_data_Edit.countryCode === "") {
        Warning("برجاء اختيار دولة");
        return;
    }

    if (supp_mainFrame_data_Edit.countryCode === "1" && supp_mainFrame_data_Edit.govCode === "*") {
        Warning("برجاء اختيار محافظة");
        return;
    }

    if (supp_mainFrame_data_Edit.receiverCode === "") {
        Warning("برجاء ملئ كود المحصل");
        return;
    }

    if (supp_mainFrame_data_Edit.prodCode === "") {
        Warning("برجاء ملئ كود المنتج");
        return;
    }

    if (supp_mainFrame_data_Edit.serviceSeq === "") {
        Warning("برجاء ملئ كود المصدر");
        return;
    }



    $("body :button").attr("disabled", true);
    $.ajax({

        url: "_1_0_0_1_7_Mainframe_Supp_Mobawaba_Togarya_Query_Ajax_03_move_supp_mainFrame_AjaxServlet?"
                + "accUnitId=" + accUnitId
                + "&deptId=" + deptId
                + "&sectionId=" + sectionId,
        type: 'POST',
        //dataType: 'json',
        data: JSON.stringify(supp_mainFrame_data_Edit),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Success") {
                Success("تم التعديل");
                query_supp_mainFrame();
                loader1.remove();
            } else {
                Warning(data);
            }
            $("body :button").attr("disabled", false);
        }
        ,
        error: function (xhr, status) {
            Errors("حدث خطأ");
            $("body :button").attr("disabled", false);
        }
    });
}
function allNumeric(id) {
    var inputtxt = document.getElementById(id);
    inputtxt.value = inputtxt.value.replace(/\D+/g, '');

}
