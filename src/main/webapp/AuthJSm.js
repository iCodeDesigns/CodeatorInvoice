/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(".readOnly").prop("readonly", true);

function isInt(n) {
    return Number(n) === n && n % 1 === 0;
}

function isFloat(n) {
    return Number(n) === n && n % 1 !== 0;
}
function isIntegerNumber(elem) {
    alert(elem);
    if (new RegExp(/^\d*\$/).test(elem)) {
        alert("true");
        return true;
    } else {
        alert("false");
        return false;
    }
}
function Custom_Warning(Body, w) {
    new PNotify({
        title: "تحذير",
        text: Body,
        type: 'info',
        styling: 'bootstrap3',
        width: w
    });
}

function Success22(Body) {
    new PNotify({
        title: "تمت",
        delay: 2000,
        text: Body,
        type: 'success',
        position: 'top left',
        styling: 'bootstrap3'
    });
}
function Warning22(Body) {
    new PNotify({
        title: "تحذير",
        delay: 2000,
        text: Body,
        styling: 'bootstrap3'
    });
}
function Error22(Body) {
    new PNotify({
        title: "خطأ",
        delay: 5000,
        text: Body,
        type: 'error',
        styling: 'bootstrap3'
    });
}

checkPasswordReset();
function checkPasswordReset() {
    $.ajax({
        url: "_0_0_0_4_5_1_Employees_Auth_Ajax_4_checkPasswordReset_AjaxServlet?",
        type: 'POST',
        icon: 'glyphicon glyphicon-lock',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "NotUpdated") {
                OpenResetModel(false);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function submitNewPassword() {
    var new_password = document.getElementById("new_password").value;
    var new_password2 = document.getElementById("new_password2").value;
    if (new_password === new_password2) {
        $.ajax({
            url: "_0_0_0_4_5_1_Employees_Auth_Ajax_5_updateEmpPass_AjaxServlet?"
                    + "new_password=" + new_password,
            type: 'POST',
            icon: 'glyphicon glyphicon-lock',
            //dataType: 'json',
            //data: JSON.stringify(),
            //contentType: 'application/json',
            // mimeType: 'application/json',
            success: function (data) {
                if (data === "Success") {
                    Success22("تم حفظ كلمة المرور الجديدة");
                    loader.remove();
                } else {
                    Warning22(data);
                }
            },
            error: function (xhr, status) {
                Error22("حدث خطأ");
            }
        });
    } else {
        Warning22("كلمة المرور لابد أن تكون متطابقة");
    }
}

var loader;
function OpenResetModel(close_status) {
    loader = new PNotify({
        title: 'برجاء تغيير كلمة المرور',
        text: '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">\n' +
                '  <label class="control-label" style="font-size: 15px;">كلمة المرور الجديدة</label> ' +
                '  <input type="password" class="form-control container" name="new_password" id="new_password" > ' +
                '</div>' +
                '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">\n' +
                '  <label class="control-label" style="font-size: 15px;">إعادة كلمة المرور الجديدة</label> ' +
                '  <input type="password" class="form-control container" name="new_password2" id="new_password2" > ' +
                '</div>' +
                '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="text-align: center;">\n' +
                '  <br><button type="button" data-placement="top" onclick="submitNewPassword();" style="font-size: 15px;" class="btn btn-sm btn-default fa fa-save"> حفظ كلمة المرور</button> ' +
                '</div>',
        icon: 'fa fa-lock fa-spin',
        styling: 'bootstrap3',
        hide: false,
        addclass: 'dark', // stack-modal
        type: 'info',
        fontsize: '50px',
        sound: true,
        confirm: {
            prompt: true
        },
        buttons: {
            closer: close_status,
            sticker: false
        },
        history: {
            history: false
        }
    });
}




setInterval(checkSessionHot, 10000);
function checkSessionHot() {
    $.ajax({
        url: "_0_0_0_0_isSessionIsHot_AjaxServlet?",
        type: 'POST',
        //dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "true") {

            } else if (data === "false") {
                var waitTime = 5000;
                fake_load("هذه الجلسة لم تعد صالحة", waitTime);
                setTimeout(signOut, 5000);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function signOut() {
    window.location.href = "_0_0_0_0_LoginAccesServlet";
}


var bars = 0;
function fake_load(message, timeWait) {
    timeWait = timeWait - 1000;
    bars = bars + 1;

    // Make a loader.
    var loader = new PNotify({
        //title: "Lowering the Moon",
        title: message,
        type: 'info',
        addclass: 'dark stack-modal',
        styling: 'bootstrap3',
        width: "20%",
        text: '<div class="progress progress-striped active" style="margin:0;font-size: 30px;">\
	<div class="progress-bar" id=\"bar_' + bars + '\" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 2%">\
		<span id=\"bar_val_' + bars + '\">0%</span>\
	</div>\
</div>',
        //icon: 'fa fa-moon-o fa-spin',
        icon: 'fa fa-cog fa-spin',
        hide: false,
        buttons: {
            closer: false,
            sticker: false
        },
        history: {
            history: false
        }
    });
    loading(bars, loader, timeWait);
}
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
async function loading(bars, loader, timeWait) {
    for (var i = 0; i <= 100; i++) {
        await sleep(timeWait / 100);
        if (i > 2) {
            document.getElementById('bar_' + bars).style.width = "" + i + "%";
        }
        document.getElementById('bar_val_' + bars).innerHTML = i + "%";
    }
    loader.remove();
    await sleep(2000);
    getInvoiceMaster();
}


function loadingTable_GIF(table_id, colspan) {
    $("#" + table_id + " tbody").empty();
    var loadingTable_GIF = "<tr>"
            + "    <td colspan='" + colspan + "'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50> برجاء الانتظار ...</td>"
            + "</tr>";
    $("#" + table_id + " tbody").append(loadingTable_GIF);

}
