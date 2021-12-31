/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





var loader1 = "0";
function drawInputType(field) {
    var txt_field = "";
    txt_field += "<div class='" + field.div_class + "' style='" + field.div_style + "'>";

    for (var i = 0; i < field.no_of_top_br; i++) {
        txt_field += "<br>";
    }

    switch (field.field_type) {
        case 'select':
            txt_field += "<label class='" + field.lable_class + "' style='" + field.lable_style + "'>" + field.lable_ + "</label>";
            txt_field += "<select class='" + field.filed_class + "' style='" + field.filed_style + "' name='" + field.field_name + "' id='" + field.filed_id + "' " + field.filed_func + ">" + field.filed_value + "</select>";
            break;
        case 'input':
            txt_field += "<label class='" + field.lable_class + "' style='" + field.lable_style + "'>" + field.lable_ + "</label>";
            txt_field += "<input type='" + field.field_sub_type + "' class='" + field.filed_class + "' style='" + field.filed_style + "' name='" + field.field_name + "' id='" + field.filed_id + "' value='" + field.filed_value + "' " + field.filed_func + ">";
            break;
        case 'btn':
            txt_field += "<button type='" + field.field_sub_type + "' class='" + field.filed_class + "' style='" + field.filed_style + "' name='" + field.field_name + "' id='" + field.filed_id + "' " + field.filed_func + "> " + field.filed_value + "</button>";
            break;
    }
    for (var i = 0; i < field.no_of_bot_br; i++) {
        txt_field += "<br>";
    }
    txt_field += "</div>";
    return txt_field;
}
function OpenModel(Notify) {

    if (loader1 !== "0") {
        loader1.remove();
    }

    var settings = Notify.setting;
    var FormContentArr = Notify.FormContent;

    var txt = "<div class='" + settings.card_class + "' style='" + settings.card_style + "' id='" + settings.card_id + "'>";
    for (var i = 0; i < FormContentArr.length; i++) {
        var field = FormContentArr[i];
        txt += drawInputType(field);
    }
    txt += "</div>";

    loader1 = new PNotify({
        title: settings.title,
        text: txt,
        icon: settings.card_fa_fa,
        styling: 'bootstrap3',
        hide: false,
        addclass: settings.addclass, // dark // stack-modal //'body-device stack-topleft':'stack-topleft' //notify-custom
        type: settings.type, //"notice", "info", "success", or "error".
        fontsize: settings.fontsize,
        sound: true,
        width: settings.width,
        confirm: {
            prompt: true
        },
        buttons: {
            closer: settings.close_status,
            sticker: false
        },
        history: {
            history: false
        }
    });
}




function createForm_testing() {
    var FormContentArr = [];
    var field;

    var settings = {
        title: "",
        close_status: true,
        card_fa_fa: "fa fa-lock fa-spin",
        addclass: 'dark', // dark // stack-modal //'body-device stack-topleft':'stack-topleft' //notify-custom
        type: 'info', //"notice", "info", "success", or "error".
        width: '10%'
    };


    field = {
        div_style: "",
        div_class: "",

        lable_: "إسم الفصل الدراسي باللعة العربية",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",

        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "semesterArName_update",
        filed_id: "semesterArName_update",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "",
        filed_func: "" //onclick='function();
    };
    FormContentArr.push(field);


    field = {
        col_lg_: 12, col_md_: 12, col_sm_: 12, col_xs_: 12,

        lable_: "إسم الفصل الدراسي باللعة الإنجليزية",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",

        field_type: "input", //select - input - btn
        field_sub_type: "text", //button - password - text - date - number - etc.
        field_name: "semesterEnName_update",
        filed_id: "semesterEnName_update",
        filed_style: "",
        filed_class: "form-control", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "",
        filed_func: "" //onclick:'function();
    };
    FormContentArr.push(field);


    field = {
        col_lg_: 12, col_md_: 12, col_sm_: 12, col_xs_: 12,

        lable_: "إسم الفصل الدراسي باللعة الإنجليزية",
        lable_style: "font-size: 15px;",
        lable_class: "control-label",

        field_type: "btn", //select - input - btn
        field_sub_type: "button", //button - password - text - date - number - etc.
        field_name: "",
        filed_id: "",
        filed_style: "text-align:center;",
        filed_class: "btn btn-round btn-success fa fa-edit", // btn class -- btn btn-sm btn-default fa fa-save
        filed_value: "تعديل",
        filed_func: "edit_sys_semester_type();" //onclick='function();
    };
    FormContentArr.push(field);

    var Notify = {
        setting: settings,
        FormContent: FormContentArr
    };

    OpenModel(Notify);
}



function Success(Body) {
    new PNotify({
        addclass: "stack-topright",
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
        addclass: "stack-topright",
        title: "خطأ",
        delay: 5000,
        text: Body,
        type: 'error',
        styling: 'bootstrap3'
    });
}
function Warning(Body) {
    new PNotify({
        addclass: "stack-topright",
        title: "تحذير",
        delay: 2000,
        text: Body,
        styling: 'bootstrap3'
    });
}

function Info(Body, icon) {
    new PNotify({
        addclass: "stack-topright",
        //title: "خطأ",
        delay: 2000,
        text: Body,
        type: 'info',
        styling: 'bootstrap3',
        icon: icon
    });
}
