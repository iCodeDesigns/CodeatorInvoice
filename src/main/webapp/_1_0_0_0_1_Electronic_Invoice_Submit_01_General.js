/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

$('.myDatepicker4').datetimepicker({
    format: 'YYYY-MM-DD',
    useCurrent: true,
    ignoreReadonly: true,
    allowInputToggle: true
});
$('.myDatepicker5').datetimepicker({
    format: 'YYYY-MM-DD',
    useCurrent: true,
    ignoreReadonly: false,
    allowInputToggle: true
});

/**
 * في حالة اختيار نقدا
 * @return {undefined}
 */
function Cash_Html_manipulation() {
    //var swap_btn = document.getElementById("swap_btn");
    var id_div = document.getElementById("swapper-other");
    var Reciver_Other_info = document.getElementById("Reciver_Other_info");
    var receiverType = document.getElementById("receiverType").value;

    if (receiverType === "small-P" || receiverType === "small-P-split") {
        id_div.style.display = "none";
        Reciver_Other_info.style.display = "none";
        //swap_btn.style.display = "none";
    } else {
        id_div.style.display = "block";
        Reciver_Other_info.style.display = "block";
        //swap_btn.style.display = "block";
    }


}
/**
 * بتتحكم في عنوان بيانات المتعامل لما نقفل التابة بتاعتها
 * @return {undefined}
 */
function copyClientNameToTitle() {
    var ClientName = document.getElementById("receivername").value;
    document.getElementById("copyClientNameToTitle").innerHTML = ": " + ClientName;
}

/**
 * التحكم في نوع البحث في بيانات المتعامل
 * وتحديد مين اللي يتقفل ومين اللي يفتح
 * @type {Boolean}
 */
var searchReseverName = true;//true : search by receivername | false : search by id
function SwapDivsWithClick() {
    document.getElementById("id").readOnly = false;
    document.getElementById("receivername").readOnly = false;
    document.getElementById("receivername").value = "";
    document.getElementById("id").value = "";

    $('.swapIt:last').insertBefore($('.swapIt:first'));

    searchReseverName = !searchReseverName;
    document.getElementById("receivername").value = "";
    document.getElementById("id").value = "";
    document.getElementById("receivername_select").innerHTML = "";
    /*if (searchReseverName) {
     document.getElementById("receivername").readOnly = false;
     
     document.getElementById("id").readOnly = true;
     } else {
     document.getElementById("receivername").readOnly = true;
     
     document.getElementById("id").readOnly = false;
     }*/
    document.getElementById("suppSeqBr").innerHTML = "";
}

/**
 * 
 * @return {undefined}
 */
receiverTypeControlFields();
function receiverTypeControlFields() {
    resetReceiverData();
    document.getElementById("receivername").value = "";
    document.getElementById("id").value = "";
    document.getElementById("receivername_select").innerHTML = "";

    var receiverType = document.getElementById("receiverType").value;
    if (receiverType === "B") {
        document.getElementById("ComRegisterDiv").style.display = "block";
        document.getElementById("nationalIdDiv").style.display = "none";
        document.getElementById("passportNumberDiv").style.display = "none";
        //document.getElementById("country_code_div").style.display = "none";
    } else if (receiverType === "P") {
        document.getElementById("ComRegisterDiv").style.display = "none";
        document.getElementById("nationalIdDiv").style.display = "block";
        document.getElementById("passportNumberDiv").style.display = "none";
        //document.getElementById("country_code_div").style.display = "none";
    } else if (receiverType === "F") {
        document.getElementById("ComRegisterDiv").style.display = "none";
        document.getElementById("nationalIdDiv").style.display = "none";
        document.getElementById("passportNumberDiv").style.display = "block";
        //document.getElementById("country_code_div").style.display = "block";
    }
}

/**
 * إظهار قيمة التحويل العملة من  الأجنبي للمصري في حالة التعامل بالعملات الأجنبية
 * @return {undefined}
 */
currencyExchange();
function currencyExchange() {
    var currencySold = document.getElementById("currencySold").value;
    var currencyExchange_elem = document.getElementById("currencyExchange");
    var currencyExchangeDiv_elem = document.getElementById("currencyExchangeDiv");

    if (currencySold === "EGP") {
        currencyExchange_elem.value = "0";
        currencyExchangeDiv_elem.style.display = "none";
    } else {
        currencyExchange_elem.value = "";
        currencyExchangeDiv_elem.style.display = "block";
    }
}

/**
 * نحديد اذا كان هيشغل بكمية او الحتة
 * @return {undefined}
 */
unitTypeCalc();
function unitTypeCalc() {
    var unitTypeCalcType = document.getElementById("unitType").value.split("-")[1];
    $("#length").val('');
    $("#width").val('');
    $("#hieght").val('');
    $("#quantity").val('');
    switch (unitTypeCalcType) {
        case "1":
            $("#quantity").attr('readonly', true);
            $("#lengthDiv").show();
            $("#widthDiv").show();
            $("#hieghtDiv").hide();
            $("#quantityType").val("writeQuantity");
            break;
        case "2":
            $("#quantity").attr('readonly', true);
            $("#lengthDiv").show();
            $("#widthDiv").show();
            $("#hieghtDiv").show();
            $("#quantityType").val("writeQuantity");
            break;
        default:
            $("#quantity").attr('readonly', false);
            $("#lengthDiv").hide();
            $("#widthDiv").hide();
            $("#hieghtDiv").hide();
    }
}

function onCalcQuantity() {
    var unitTypeCalcType = document.getElementById("unitType").value.split("-")[1];
    switch (unitTypeCalcType) {
        case "1":
            var length = $("#length").val();
            var width = $("#width").val();
            var quantity = +length * +width;
            $("#quantity").val(quantity.toFixed(5));
            break;
        case "2":
            var length = $("#length").val();
            var width = $("#width").val();
            var hieght = $("#hieght").val();
            var quantity = +length * +width * +hieght;
            $("#quantity").val(quantity.toFixed(5));
            break;

    }
}

writeQuantity();
function writeQuantity() {
    var quantityType = document.getElementById("quantityType").value;
    var quantityDiv = document.getElementById("quantityDiv");
    var quantity = document.getElementById("quantity");
    if (quantityType === "writeQuantity") {
        quantityDiv.style.display = "block";
        quantity.value = "";
        unitTypeCalc();
    } else if (quantityType === "noQuantity") {
        quantityDiv.style.display = "none";
        quantity.value = '1';
        $("#unitType").val("EA-0");
        $("#lengthDiv").hide();
        $("#widthDiv").hide();
        $("#hieghtDiv").hide();
        $("#length").val('');
        $("#width").val('');
        $("#hieght").val('');
    }
}

/**
 * 
 * @param {type} id
 * @return {undefined}
 */

function allNumeric(id) {
    var inputtxt = document.getElementById(id);
    inputtxt.value = inputtxt.value.replace(/\D+/g, '');

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

/*$('.quantity').keypress(function(eve) {
 if ((eve.which != 46 || $(this).val().indexOf('.') != -1) && (eve.which < 48 || eve.which > 57) || (eve.which == 46 && $(this).caret().start == 0)) {
 eve.preventDefault();
 }
 
 // this part is when left part of number is deleted and leaves a . in the leftmost position. For example, 33.25, then 33 is deleted
 $('.quantity').keyup(function(eve) {
 if ($(this).val().indexOf('.') == 0) {
 $(this).val($(this).val().substring(1));
 }
 });
 });*/


function resetReceiverData() {
    document.getElementById("governate").value = "";
    document.getElementById("street").value = "";
    document.getElementById("buildingNumber").value = "";
    document.getElementById("postalCode").value = "";
    document.getElementById("floor").value = "";
    document.getElementById("room").value = "";
    document.getElementById("landmark").value = "";

    var status = true;
    document.getElementById("governate").readOnly = status;
    document.getElementById("street").readOnly = status;
    document.getElementById("buildingNumber").readOnly = status;
    document.getElementById("postalCode").readOnly = status;
    document.getElementById("floor").readOnly = status;
    document.getElementById("room").readOnly = status;
    document.getElementById("landmark").readOnly = status;
}

function lines_data() {
    document.getElementById("quantity").value = "";
    document.getElementById("price").value = "";
    document.getElementById("currencyExchange").value = "";
    document.getElementById("discount_amount").value = "0";
    document.getElementById("taxValue").value = "";
}

function discountRateType() {
    var discountType = document.getElementById("discountType").value;
    var discountRateDiv = document.getElementById("discountRateDiv");
    var discount_amount = document.getElementById("discount_amount");

    if (discountType === "rate") {
        discountRateDiv.style.display = "block";
        discount_amount.readOnly = true;
    } else {
        discountRateDiv.style.display = "none";
        discount_amount.readOnly = false;
    }

    document.getElementById("discount_rate").value = 0;
    document.getElementById("discount_amount").value = 0;
}
discountRateType();


function changeDiscountAmount() {
    var discountType = document.getElementById("discountType").value;
    if (discountType === "rate") {
        var quantity = +document.getElementById("quantity").value;
        var price = +document.getElementById("price").value;
        var discount_rate = +document.getElementById("discount_rate").value;

        quantity = quantity.toFixed(5);
        price = price.toFixed(5);
        var total = quantity * price;
        discount_rate = (discount_rate / 100.0).toFixed(5);

        var discount_amount = total * discount_rate;
        discount_amount = discount_amount.toFixed(5);

        document.getElementById("discount_amount").value = discount_amount;

    }
}