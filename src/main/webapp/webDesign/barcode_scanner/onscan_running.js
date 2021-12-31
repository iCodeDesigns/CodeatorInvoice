/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function applyScannedBarCode_And_Quantity(barcode, quantity) {
    //alert("barcode : "+barcode+" - quantity : "+quantity);
    Info(barcode, 'fa fa-barcode');
    FunctionInPageController(barcode, quantity);
}


if (typeof console !== "undefined")
    if (typeof console.log !== 'undefined')
        console.olog = console.log;
    else
        console.olog = function () {};

console.log = function (message, error) {
    console.olog(message);
    //var oOutput = document.getElementById('consoleTextField');
    if (error) {
        //oOutput.value += "ERROR: " + message + '\n';
        Error("ERROR: " + message + '\n');
    } else {
        //oOutput.value += ('> ' + message + '\n');        
    }
    //oOutput.scrollTop = oOutput.scrollHeight;
};
console.error = console.debug = console.info = console.log;

window.onerror = function (msg) {
    console.log(msg, true);
};

function initOnScan() {
    var options = {
        timeBeforeScanTest: parseInt(20),
        avgTimeByChar: parseInt(30),
        minLength: parseInt(6),
        suffixKeyCodes: [], //suffixKeyCodes,
        prefixKeyCodes: [], //prefixKeyCodes, 
        scanButtonLongPressTime: parseInt(500),
        stopPropagation: false, //document.getElementById("iStopPropagation").checked, 
        preventDefault: false, //document.getElementById("iPreventDefault").checked,
        reactToPaste: true, //document.getElementById("iAcceptPasteInput").checked,
        reactToKeyDown: true, //document.getElementById("iAcceptKeyInput").checked,
        singleScanQty: parseInt(1)
    };

    if (true) {
        options.onScan = function (barcode, qty) {
            console.log("[onScan]: Code: " + barcode + " Quantity: " + qty);
            applyScannedBarCode_And_Quantity(barcode, qty);
        };
    } else {
        options.onScan = function () {};
    }

    if (true) {
        options.onScanError = function (err) {
            var sFormatedErrorString = "Error Details: {\n";
            for (var i in err) {
                sFormatedErrorString += '    ' + i + ': ' + err[i] + ",\n";
            }
            sFormatedErrorString = sFormatedErrorString.trim().replace(/,$/, '') + "\n}";
            console.log("[onScanError]: " + sFormatedErrorString);
        };
    } else {
        options.onScanError = function () {};
    }

    try {
        onScan.attachTo(document, options);
        console.log("onScan Started!");
    } catch (e) {
        onScan.setOptions(document, options);
        console.log("onScansettings changed!");
    }

}

function destroyOnScan() {
    console.log("onScan destroyed!");
    onScan.detachFrom(document);
}

function fireTestInput() {
    var sInput = (document.getElementById("iTestInput").value || '').trim();
    if (sInput.startsWith('[') && sInput.endsWith(']')) {
        onScan.simulate(document, JSON.parse(sInput));
    } else {
        onScan.simulate(document, sInput);
    }
}

(function () {
    initOnScan();
    document.querySelectorAll("#playground input").forEach(function (oInput) {
        if (oInput.type === 'button' || oInput.readonly) {
            return;
        }

        oInput.addEventListener('change', function () {
            console.log('onScan configuration updated');
            onScan.detachFrom(document);
            initOnScan();
        });
    });
})();


function restart_barcode_device() {
    initOnScan();
    document.querySelectorAll("#playground input").forEach(function (oInput) {
        if (oInput.type === 'button' || oInput.readonly) {
            return;
        }

        oInput.addEventListener('change', function () {
            console.log('onScan configuration updated');
            onScan.detachFrom(document);
            initOnScan();
        });
    });
    Success("تم اعادة ضبط برنام ال Barcode");
}