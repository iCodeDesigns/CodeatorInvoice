/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(".Integer").on("keypress", function (event) {
    var keyCode = event.charCode || event.keyCode;
    if (keyCode === 46) {
        return false;
    }
});
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


/**
 * في حالة اختيار نقدا
 * @return {undefined}
 */
function Cash_Html_manipulation() {
    var swap_btn = document.getElementById("swap_btn");
    var id_div = document.getElementById("swapper-other");
    var receiverType = document.getElementById("receiverType").value;

    if (receiverType === "small-P") {
        id_div.style.display = "none";
        swap_btn.style.display = "none";
    } else {
        id_div.style.display = "block";
        swap_btn.style.display = "block";
    }
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
 * 
 * @param {type} id
 * @return {undefined}
 */
function setThreeFloatingPoint(id) {
    var inputtxt = +document.getElementById(id).value;

    document.getElementById(id).value = inputtxt;
}
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