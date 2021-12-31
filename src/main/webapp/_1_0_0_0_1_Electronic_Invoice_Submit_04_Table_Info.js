//var taxType_name = taxTypeElement.options[taxTypeElement.selectedIndex];
invoiceLinesHide();
var documents = [];
var line_number = 0;

var totalSalesAmount = 0;
var totalDiscountAmount = 0;
var netAmount = 0;
var totalItemsDiscountAmount = 0;
var extraDiscountAmount = 0;
var total_of_all_line = 0;
var totalAmount = 0;
function invoiceLinesHide() {
    document.getElementById("invoiceLines").innerHTML = "";
}

function add_to_table_and_object() {
    var quantityType = document.getElementById("quantityType").value;
    if (quantityType === "noQuantity") {
        $("#unitType").val("EA-0");
    }

    var receiverType = document.getElementById("receiverType").value;
    if (receiverType === "small-P-split") {
        if (documents.length === 1) {
            Warning("لايمكن أضافة اكثر من صنف لنوع التعامل المختار");
            return;
        } else if (documents.length > 1) {
            var temp_doc = documents[0];
            documents = [];
            documents.push(temp_doc);
            drawTable(true);
            return;
        }
    }

    var TaxApplyType = document.getElementById("TaxApplyType").value;
    var taxType = "";
    var subType = "";
    var subTypeName = "";
    var taxValue = 0.00000;
    if (TaxApplyType === "taxOnInvoice") {
        //current_active_line
        var taxable = document.getElementById("taxable_top");//تخضع للضريبة أو لا

        var subTypeElement = document.getElementById("subType_top");
        var taxTypeSubType = subTypeElement.value.split(",")[0];


        if (taxTypeSubType === "" || taxTypeSubType === null || taxTypeSubType === "لا توجد ضرائب مسجلة للقطاع") {
            Warning("لا يوجد ضرائب مسجلة لك");
            return;
        }
        taxType = taxTypeSubType.split("-")[0];
        subType = taxTypeSubType.split("-")[1];

        subTypeName = subTypeElement.options[subTypeElement.selectedIndex].text;

        taxValue = (+document.getElementById("taxValue_top").value).toFixed(5);
        if (taxable === "" || taxable === null) {
            Warning("الخضوع للضريبة لا يوجد بها قيمة");
            return;
        } else if (taxTypeSubType === "" || taxTypeSubType === null) {
            Warning("لا يوجد نوع الضريبة");
            return;
        } else if (taxValue === "" || taxValue === null || +taxValue <= 0 || +taxValue > 100) {
            Warning("لا يوجد نوع الضريبة");
            return;
        }
    }

    //var validLine = true;
    var itemCodeElement = document.getElementById("itemCode");
    var itemCode = itemCodeElement.value;

    if (itemCode === "" || itemCode === null) {
        Warning("لابد من اختيار الصنف");
        return;
    }
    var itemSeqElement = document.getElementById("itemSeq");
    var itemSeq = itemSeqElement.value;
    var item_desc = "";
    if (itemSeq === "") {

    } else {
        item_desc = itemSeqElement.options[itemSeqElement.selectedIndex].text;
        item_desc = (item_desc === "" || item_desc === null) ? "" : " - " + item_desc;
    }


    var extra_description = document.getElementById("extra_description").value;

    var description = itemCodeElement.options[itemCodeElement.selectedIndex].text + item_desc + ((extra_description === "") ? "" : (" - " + extra_description));
    var unitTypeCalcType = document.getElementById("unitType").value.split("-")[1];
    var unit_name = document.getElementById("unitType");
    unit_name = unit_name[unit_name.selectedIndex].text;
    switch (unitTypeCalcType) {
        case "1":
            var length = $("#length").val();
            var width = $("#width").val();
            description = description + "  " + width + "x" + length + " " + unit_name;
            break;
        case "2":
            var length = $("#length").val();
            var width = $("#width").val();
            var hieght = $("#hieght").val();
            description = description + "  " + hieght + "x" + width + "x" + length + " " + unit_name;
            break;
    }


    var unitType = document.getElementById("unitType").value.split("-")[0];

    var itemType = document.getElementById("itemType").value;

    var quantity = 1;
    var quantityType = document.getElementById("quantityType").value;
    if (quantityType === "writeQuantity") {
        quantity = (+document.getElementById("quantity").value).toFixed(5);
    } else if (quantityType === "noQuantity") {
        quantity = 1;
    }
    quantity = parseFloat(quantity);//parseInt(quantity);


    var currencySold = document.getElementById("currencySold").value; //EGP | EUR
    var price = (+document.getElementById("price").value).toFixed(5);
    var currencyExchangeRate = (+document.getElementById("currencyExchange").value).toFixed(5);
    var discount_amount = (+document.getElementById("discount_amount").value).toFixed(5);
    if (itemCode === null || itemCode === "") {
        Warning("لا يوجد منتج");
        return;
    } else if (unitType === null || unitType === "") {
        Warning("لا يوجد وحدة قياس");
        return;
    } else if (quantity === null || quantity === "" || +quantity <= 0) {
        Warning("الكمية لا بد ان تكون رقم أكبر من الصفر");
        return;
    } else if (currencySold === null || currencySold === "") {
        Warning("لا يوجد عملة");
        return;
    } else if (price === null || price === "" || +price <= 0) {
        Warning("السعر لا بد ان يكون رقم أكبر من الصفر");
        return;
    } else if (discount_amount !== "" && discount_amount < 0) {
        Warning("الخصم لا بد ان يكون رقم أكبر من أو يساوي الصفر");
        return;
    }
    var discount = new Object();
    discount.rate = 0;
    discount.amount = parseFloat(discount_amount);
    var amountSold = 0;
    var amountEGP = 0;
    if (currencySold === "EGP") {
        amountSold = 0;
        currencyExchangeRate = 0;
        amountEGP = +price;
    } else {
        if (+currencyExchangeRate <= 0 || currencyExchangeRate === null || currencyExchangeRate === "") {
            Warning("برجاء ملئ معدل تحويل العملة");
            return;
        }
        amountSold = +price;
        currencyExchangeRate = +currencyExchangeRate;
        amountEGP = (+amountSold * +currencyExchangeRate).toFixed(5);
    }

    var invoiceLines = new Object();
    //amac special Fields
    var salesTotal = (+quantity * +amountEGP).toFixed(5);
    var netTotal = (+salesTotal - +discount_amount).toFixed(5);

    var iterate = 1;
    var minimumLimit_diff = 0;
    if (calcUnitAndMinimumStatus) {
        var calcUnit = $("#calcUnit").val();
        calcUnit = parseFloat(calcUnit).toFixed(5);
        var priceBeforeCalcUnit = $("#priceBeforeCalcUnit").val();
        priceBeforeCalcUnit = parseFloat(priceBeforeCalcUnit).toFixed(5);

        var minimumLimit = $("#minimumLimit").val();
        minimumLimit = parseFloat(minimumLimit).toFixed(5);
        if (minimumLimit === "") {
            $("#minimumLimit").val(0);
            minimumLimit = 0;
        }
        if (minimumLimit < 0) {
            Warning("الحد الأدنى لا يكون أقل من الصقر");
            return;
        }

        invoiceLines.calcUnit = +calcUnit;
        invoiceLines.priceBeforeCalcUnit = +priceBeforeCalcUnit;
        invoiceLines.minimumLimit = +minimumLimit;

        if (+minimumLimit > +netTotal) {
            iterate = 2;
            minimumLimit_diff = minimumLimit - netTotal;
        }
    } else {
        invoiceLines.calcUnit = 0;
        invoiceLines.priceBeforeCalcUnit = 0;
        invoiceLines.minimumLimit = 0;
    }

    var newsTax = document.getElementById("newsTax").value;
    if (newsTaxStatus && newsTax === "yes") {
        iterate = 2;
        minimumLimit_diff = (0.001 * salesTotal).toFixed(5);
        if (minimumLimit_diff < 0.5) {
            minimumLimit_diff = 0.5;
        } else if (minimumLimit_diff > 100) {
            minimumLimit_diff = 100;
        }
    }

    for (var i = 0; i < iterate; i++) {

        if (i === 0) {
            var unitValue = new Object();
            unitValue.currencySold = currencySold;
            unitValue.amountEGP = amountEGP;
            unitValue.amountSold = amountSold;
            unitValue.currencyExchangeRate = currencyExchangeRate;

            var taxableItems = new Object();
            if (TaxApplyType === "taxOnInvoice") {

                var amount = (+netTotal * (+taxValue / 100.00)).toFixed(5);

                taxesLines = taxesLines + 1;
                var taxableItems = new Object();
                taxableItems.taxLineNumber = taxesLines;
                taxableItems.taxType = taxType;
                taxableItems.subType = subType;
                taxableItems.rate = +taxValue;
                taxableItems.amount = +amount;
                taxableItems.subTypeName = subTypeName;
                invoiceLines.taxableItems = [];
                invoiceLines.taxableItems.push(taxableItems);

                // apply changes on total of Taxes
                var all_line_taxableItem = (+calcTotalTaxableFees_for_total(invoiceLines.taxableItems)).toFixed(5);
                //alert(all_line_taxableItem);
                var total = (+netTotal + +all_line_taxableItem) - 0;
                invoiceLines.total = +(+total).toFixed(5);
            } else {
                taxableItems.taxLineNumber = null;
                taxableItems.taxType = null;
                taxableItems.subType = null;
                taxableItems.rate = null;
                taxableItems.amount = null;
                taxableItems.subTypeName = null;
                invoiceLines.taxableItems = [];
                invoiceLines.total = +((+netTotal + 0) - 0);
            }

            line_number = line_number + 1;

            invoiceLines.lineNumber = "" + line_number;

            invoiceLines.description = description;
            invoiceLines.itemType = itemType;
            invoiceLines.itemCode = itemCode;
            invoiceLines.itemSeq = itemSeq;
            invoiceLines.unitType = unitType;
            invoiceLines.quantity = quantity;
            invoiceLines.internalCode = itemCode;
            invoiceLines.unitValue = unitValue;

            invoiceLines.salesTotal = parseFloat(salesTotal);
            invoiceLines.discount = discount;
            invoiceLines.netTotal = +netTotal;
            invoiceLines.valueDifference = 0;

            invoiceLines.totalTaxableFees = 0;
            invoiceLines.itemsDiscount = 0;


        } else {// يوجد فرق حد أدنى
            quantity = 1;

            discount = new Object();
            discount.rate = 0;
            discount.amount = parseFloat(0);
            amountSold = 0;
            amountEGP = 0;
            if (currencySold === "EGP") {
                amountSold = 0;
                currencyExchangeRate = 0;
                amountEGP = +minimumLimit_diff;
            } else {
                if (+currencyExchangeRate <= 0 || currencyExchangeRate === null || currencyExchangeRate === "") {
                    Warning("برجاء ملئ معدل تحويل العملة");
                    return;
                }
                amountSold = +minimumLimit_diff;
                currencyExchangeRate = +currencyExchangeRate;
                amountEGP = (+amountSold * +currencyExchangeRate).toFixed(5);
            }

            invoiceLines = new Object();
            //amac special Fields
            salesTotal = (+quantity * +amountEGP).toFixed(5);
            netTotal = (+salesTotal - +discount_amount).toFixed(5);

            unitValue = new Object();
            unitValue.currencySold = currencySold;
            unitValue.amountEGP = amountEGP;
            unitValue.amountSold = amountSold;
            unitValue.currencyExchangeRate = currencyExchangeRate;

            taxableItems = new Object();
            if (TaxApplyType === "taxOnInvoice") {

                var amount = (+netTotal * (+taxValue / 100.00)).toFixed(5);

                taxesLines = taxesLines + 1;
                var taxableItems = new Object();
                taxableItems.taxLineNumber = taxesLines;
                taxableItems.taxType = taxType;
                taxableItems.subType = subType;
                taxableItems.rate = +taxValue;
                taxableItems.amount = +amount;
                taxableItems.subTypeName = subTypeName;
                invoiceLines.taxableItems = [];
                invoiceLines.taxableItems.push(taxableItems);

                // apply changes on total of Taxes
                var all_line_taxableItem = (+calcTotalTaxableFees_for_total(invoiceLines.taxableItems)).toFixed(5);
                //alert(all_line_taxableItem);
                var total = (+netTotal + +all_line_taxableItem) - 0;
                invoiceLines.total = +(+total).toFixed(5);
            } else {
                taxableItems.taxLineNumber = null;
                taxableItems.taxType = null;
                taxableItems.subType = null;
                taxableItems.rate = null;
                taxableItems.amount = null;
                taxableItems.subTypeName = null;
                invoiceLines.taxableItems = [];
                invoiceLines.total = +((+netTotal + 0) - 0);
            }

            line_number = line_number + 1;

            invoiceLines.lineNumber = "" + line_number;

            if (newsTaxStatus && newsTax === "yes") {
                invoiceLines.description = "دمغة صحفية" + " - " + description;
            } else {
                invoiceLines.description = "فرق حد أدنى" + " - " + description;
            }
            invoiceLines.itemType = "GS1";
            invoiceLines.itemCode = "10007592";
            invoiceLines.itemSeq = null;
            invoiceLines.unitType = "EA";
            invoiceLines.quantity = quantity;
            invoiceLines.internalCode = "10007592";
            invoiceLines.unitValue = unitValue;

            invoiceLines.salesTotal = parseFloat(salesTotal);
            invoiceLines.discount = discount;
            invoiceLines.netTotal = +netTotal;
            invoiceLines.valueDifference = 0;
            invoiceLines.totalTaxableFees = 0;
            invoiceLines.itemsDiscount = 0;

            invoiceLines.calcUnit = 0;
            invoiceLines.priceBeforeCalcUnit = 0;
            invoiceLines.minimumLimit = 0;
        }


        documents.push(invoiceLines);//
    }
    drawTable(true);


}

function HuntHacker() {
    var receiverType = document.getElementById("receiverType").value;
    if (receiverType === "small-P-split") {
        if (documents.length > 1) {
            var temp_doc = documents[0];
            documents = [];
            documents.push(temp_doc);

            var temp_tax = documents[0].taxableItems[0];
            documents[0].taxableItems = [];
            documents[0].taxableItems.push(temp_tax);
            drawTable(true);
        }
    }

}


var current_active_line;
function setCurrentActiveLine(line_no) {
    current_active_line = line_no;
}
var taxesLines = 0;
function add_tax_to_line() {

    var receiverType = document.getElementById("receiverType").value;
    if (receiverType === "small-P-split") {
        if (documents[0].taxableItems.length === 1) {
            Warning("لايمكن أضافة اكثر من ضريبة لنوع التعامل المختار");
            return;
        } else if (documents.length > 1) {
            var temp_tax = documents[0].taxableItems[0];
            documents[0].taxableItems = [];
            documents[0].taxableItems.push(temp_tax);
            drawTable(true);
            return;
        }
    }

    //current_active_line
    var taxable = document.getElementById("taxable");//تخضع للضريبة أو لا

    var subTypeElement = document.getElementById("subType");
    var taxTypeSubType = subTypeElement.value.split(",")[0];


    if (taxTypeSubType === "" || taxTypeSubType === null || taxTypeSubType === "لا توجد ضرائب مسجلة للقطاع") {
        Warning("لا يوجد ضرائب مسجلة لك");
        return;
    }
    var taxType = taxTypeSubType.split("-")[0];
    var subType = taxTypeSubType.split("-")[1];

    var subTypeName = subTypeElement.options[subTypeElement.selectedIndex].text;

    var taxValue = (+document.getElementById("taxValue").value).toFixed(5);
    if (taxable === "" || taxable === null) {
        Warning("الخضوع للضريبة لا يوجد بها قيمة");
        return;
    } else if (taxTypeSubType === "" || taxTypeSubType === null) {
        Warning("لا يوجد نوع الضريبة");
        return;
    } else if (taxValue === "" || taxValue === null || +taxValue <= 0 || +taxValue > 100) {
        Warning("لا يوجد نوع الضريبة");
        return;
    }

    //check if subTaxType Exist before
    //line_number - current_active_line
    for (var i = 0; i < documents.length; i++) {
        if (+documents[i].lineNumber === +current_active_line) {
            for (var j = 0; j < documents[i].taxableItems.length; j++) {
                if (documents[i].taxableItems[j].subType === subType) {
                    Warning("هذا الصف متواجد به نوع الضريبة المختارة من قبل");
                    return;
                }
            }
        }
    }


    //apply Tax
    for (var i = 0; i < documents.length; i++) {
        if (+documents[i].lineNumber === +current_active_line) {
            var netTotal = +documents[i].netTotal;
            var amount = (+netTotal * (+taxValue / 100.00)).toFixed(5);

            taxesLines = taxesLines + 1;
            var taxableItems = new Object();
            taxableItems.taxLineNumber = taxesLines;
            taxableItems.taxType = taxType;
            taxableItems.subType = subType;
            taxableItems.rate = +taxValue;
            taxableItems.amount = +amount;
            taxableItems.subTypeName = subTypeName;
            documents[i].taxableItems.push(taxableItems);

            // apply changes on total of Taxes
            var all_line_taxableItem = (+calcTotalTaxableFees_for_total(documents[i].taxableItems)).toFixed(5);
            //alert(all_line_taxableItem);
            var total = (+documents[i].netTotal + +all_line_taxableItem) - +documents[i].itemsDiscount;
            documents[i].total = +(+total).toFixed(5);
        }
    }
    $('#taxModal').modal('toggle');

    drawTable(true);
}
function calcLineTotals() {

    for (var i = 0; i < documents.length; i++) {
        // apply changes on total of Taxes
        var all_line_taxableItem = (+calcTotalTaxableFees_for_total(documents[i].taxableItems)).toFixed(5);
        //alert(all_line_taxableItem);
        var total = (+documents[i].netTotal + +all_line_taxableItem) - +documents[i].itemsDiscount;
        documents[i].total = +(+total).toFixed(5);
    }
    calcAllSettings(documents);
}

function delete_invoiceLine(id, line_no) {
    var deleted = delete_invoiceLine_fromObject(line_no);
    if (deleted) {
        deleteDiv(id);
        drawTable(true);
    }
}

function delete_tax_from_invoiceLine(id, line_no, tax_no) {
    var deleted = delete_tax_from_invoiceLineObject(line_no, tax_no);
    if (deleted) {
        deleteDiv(id);
        drawTable(true);
    }
}

function delete_invoiceLine_fromObject(line_no) {
    for (var i = 0; i < documents.length; i++) {
        if (+documents[i].lineNumber === +line_no) {
            const index = documents.indexOf(documents[i]);
            if (index > -1) {
                documents.splice(index, 1);
                return true;
            }
        }
    }
    return false;
}

function delete_tax_from_invoiceLineObject(line_no, tax_no) {
    for (var i = 0; i < documents.length; i++) {
        if (+documents[i].lineNumber === +line_no) {
            for (var j = 0; j < documents[i].taxableItems.length; j++) {
                if (+documents[i].taxableItems[j].taxLineNumber === +tax_no) {
                    const index = documents[i].taxableItems.indexOf(documents[i].taxableItems[j]);
                    if (index > -1) {
                        documents[i].taxableItems.splice(index, 1);
                        return true;
                    }
                }
            }
        }
    }
    return false;
}

function deleteDiv(id) {
    $("#" + id).remove();
}

function updatePosition(old_position, new_position, current_index, next_index, update) {

    documents[current_index].index = +new_position;
    documents[next_index].index = +old_position;

    for (var i = 0; i < documents.length; i++) {
        for (var j = 0; j < documents.length - i - 1; j++) {

            if (+documents[j].index > +documents[j + 1].index) {
                var temp_line = documents[j];
                documents[j] = documents[j + 1];
                documents[j + 1] = temp_line;
            }
        }
    }

    drawTable(update);
}

drawTable(true);
function drawTable(update) {
    var add_to_table_and_object = document.getElementById("add_to_table_and_object");
    var extraDiscountAmountDiv = document.getElementById("extraDiscountAmountDiv");
    if (update) {
        add_to_table_and_object.style.display = "block";
        extraDiscountAmountDiv.style.display = "block";
    } else {
        add_to_table_and_object.style.display = "none";
        extraDiscountAmountDiv.style.display = "none";
    }
    calcLineTotals();
    var invoiceLines = document.getElementById("invoiceLines");
    invoiceLines.innerHTML = "";
    var TOTAL_salesTotal = 0;
    var TOTAL_discountAmount = 0;
    var TOTAL_netTotal = 0;
    var TOTAL_Tax = 0;
    if (documents.length > 0) {
        for (var i = 0; i < documents.length; i++) {
            documents[i].index = (i + 1);
            var data = documents[i];
            TOTAL_salesTotal += +data.salesTotal.toFixed(5);
            TOTAL_discountAmount += +data.discount.amount.toFixed(5);
            TOTAL_netTotal += +data.netTotal.toFixed(5);
            var html =
                    "<tr id=\"line_" + data.lineNumber + "\">" +
                    "    <td style=\"text-align: center;\">" + (i + 1) + ""

                    + ((i !== 0) ? "<button type='button' class='btn btn-round btn-default fa fa-arrow-up' onclick='updatePosition(" + data.index + "," + (data.index - 1) + "," + i + "," + (i - 1) + "," + update + ");'></button>" :
                            "       <span type='button' class='btn btn-round btn-default fa fa-arrow-up' disabled></span>")

                    + ((i !== documents.length - 1) ? "  <button type='button' class='btn btn-round btn-default fa fa-arrow-down' onclick='updatePosition(" + data.index + "," + (data.index + 1) + "," + i + "," + (i + 1) + "," + update + ");'></button>" :
                            "       <span type='button' class='btn btn-round btn-default fa fa-arrow-down' disabled></span>")

                    + "</td>" +
                    "    <td style=\"text-align: center;\">" + data.itemCode + "</td>" +
                    "    <td style=\"text-align: center;\">" + data.description + "</td>" +
                    "    <td style=\"text-align: center;\">" + data.unitValue.amountEGP + "</td>" +
                    "    <td style=\"text-align: center;\">" + data.quantity + "</td>" +
                    "    <td style=\"text-align: center;\">" + data.salesTotal + "</td>" +
                    "    <td style=\"text-align: center;\">" + data.discount.amount + "</td>" +
                    "    <td style=\"text-align: center;\">" + data.netTotal + "</td>" +
                    "    <td style=\"text-align: center;\">" +
                    "        <table class=\"table table-striped table-bordered\">";
            if (update) {
                html += "            <button type=\"button\" onclick=\"setCurrentActiveLine('" + data.lineNumber + "');\" class=\"btn btn-success fa fa-plus\" data-toggle=\"modal\" data-target=\"#taxModal\" style=\"font-weight: bold;font-size: 10px;text-align: center;\" title=\"إضافة ضريبة\" data-toggle=\"tooltip\"></button>";
            }
            html += "            <tbody id=\"line_" + data.lineNumber + "_Tax\">";

            for (var j = 0; j < data.taxableItems.length; j++) {
                var taxData = data.taxableItems[j];
                TOTAL_Tax += +taxData.amount.toFixed(5);
                html += "<tr id=\"line_" + data.lineNumber + "_Tax_" + taxData.taxLineNumber + "\">\n" +
                        "    <td style=\"text-align: center;\">" + taxData.subType + "</td>\n" +
                        "    <td style=\"text-align: center;\">" + taxData.subTypeName + "</td>\n" +
                        "    <td style=\"text-align: center;\">" + taxData.rate + "</td>\n" +
                        "    <td style=\"text-align: center;\">" + taxData.amount + "</td>\n" +
                        "    <td style=\"text-align: center;\">\n";

                if (update) {
                    html += "        <button type=\"button\" onclick=\"delete_tax_from_invoiceLine('line_" + data.lineNumber + "_Tax_" + taxData.taxLineNumber + "', '" + data.lineNumber + "', '" + taxData.taxLineNumber + "');\" class=\"btn btn-danger fa fa-close\" style=\"font-weight: bold;font-size: 10px;text-align: center;\"></button>\n";
                }
                html += "    </td>\n" +
                        "</tr>";
            }
            html += "            </tbody>" +
                    "        </table>" +
                    "    </td>" +
                    "    <td style=\"text-align: center;\">" + data.total + "</td>" +
                    "    <td style=\"text-align: center;\">";
            if (update) {
                html += "<button type=\"button\" onclick=\"delete_invoiceLine('line_" + data.lineNumber + "', '" + data.lineNumber + "');\" class=\"btn btn-danger fa fa-close\" style=\"font-weight: bold;font-size: 10px;text-align: center;\" data-toggle=\"modal\" data-target=\"#x\"></button></td>";
            }
            html += "</tr>";
            invoiceLines.innerHTML += html;
        }
        // صف الإجماليات
        html = "";
        invoiceLines.innerHTML += "<tr style='background-color: coral;'><th colspan='8'></th><th>خصم الفاتورة</th><th>" + extraDiscountAmount + "</th><th></th></tr>";

        // صف الإجماليات
        html = "";
        html += "<tr style='background-color: palegreen;'><th colspan='5'>الإجماليات</th>"
                + "<th>" + TOTAL_salesTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_discountAmount.toFixed(5) + "</th>"
                + "<th>" + TOTAL_netTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_Tax.toFixed(5) + "</th>"
                + "<th>" + totalAmount + "</th>"
                + "<th></th>"
                + "</tr>";
        invoiceLines.innerHTML += html;
    } else {
        invoiceLines.innerHTML = "<tr><td colspan='11'>لا توجد سطور للفاتورة</td></tr>";
        invoiceLines.innerHTML += "<tr style='background-color: coral;'><th colspan='8'></th><th>خصم الفاتورة</th><th>" + extraDiscountAmount + "</th><th></th></tr>";

        var html = "";
        html += "<tr style='background-color: palegreen;'><th colspan='5'>الإجماليات</th>"
                + "<th>" + TOTAL_salesTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_discountAmount.toFixed(5) + "</th>"
                + "<th>" + TOTAL_netTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_Tax.toFixed(5) + "</th>"
                + "<th>" + totalAmount + "</th>"
                + "<th></th>"
                + "</tr>";
        invoiceLines.innerHTML += html;
    }
}

////////////     invoiceCalculation   ////////////////////////
var totalTaxableFees_calculatedOnTaxType_for_total =
        ["T1", "T2", "T3", "T4",
            "T5", "T6", "T7", "T8",
            "T9", "T10", "T11", "T12"];
function calcTotalTaxableFees_for_total(taxableItems) {
    var totalTaxableFees = 0.0;
    for (var i = 0; i < taxableItems.length; i++) {
        if (totalTaxableFees_calculatedOnTaxType_for_total.includes(taxableItems[i].taxType)) {
            //alert(totalTaxableFees_calculatedOnTaxType_for_total.includes(taxableItems[i].taxType));
            //alert(taxableItems[i].amount);
            totalTaxableFees = +totalTaxableFees + +taxableItems[i].amount;
        }
    }
    return +totalTaxableFees;
}

function calcTotalSalesAmount(invoiceLines) {
    var totalSalesAmount_inner = 0;
    for (var i = 0; i < invoiceLines.length; i++) {
        totalSalesAmount_inner = +totalSalesAmount_inner + +invoiceLines[i].salesTotal;
    }
    return totalSalesAmount_inner;
}

function calcTotalDiscountAmount(invoiceLines) {
    var totalDiscountAmount_inner = 0;
    for (var i = 0; i < invoiceLines.length; i++) {
        totalDiscountAmount_inner = +totalDiscountAmount_inner + +invoiceLines[i].discount.amount;
    }
    return totalDiscountAmount_inner;
}
function calcTotalItemDiscount(invoiceLines) {
    var totalItemDiscount_inner = 0;
    for (var i = 0; i < invoiceLines.length; i++) {
        totalItemDiscount_inner = +totalItemDiscount_inner + +invoiceLines[i].itemsDiscount;
    }
    return totalItemDiscount_inner;
}

function getSumOfAll_Totals_InAllLines(invoiceLines) {
    var total_of_all_line_inner = 0;
    for (var i = 0; i < invoiceLines.length; i++) {
        total_of_all_line_inner = +total_of_all_line_inner + +invoiceLines[i].total;
    }
    return total_of_all_line_inner;
}

function calcAllSettings(invoiceLines) {
    var totalSalesAmount_temp = (+calcTotalSalesAmount(invoiceLines)).toFixed(5);
    totalSalesAmount = totalSalesAmount_temp;

    var totalDiscountAmount_temp = (+calcTotalDiscountAmount(invoiceLines)).toFixed(5);
    totalDiscountAmount = totalDiscountAmount_temp;

    netAmount = (+totalSalesAmount_temp - +totalDiscountAmount_temp).toFixed(5);

    var totalItemsDiscountAmount_temp = (+calcTotalItemDiscount(invoiceLines)).toFixed(5);
    totalItemsDiscountAmount = totalItemsDiscountAmount_temp;

    var extraDiscountAmount_elements = (+document.getElementById("extraDiscountAmount").value).toFixed(5);
    if (extraDiscountAmount_elements === "" || extraDiscountAmount_elements === null) {
        extraDiscountAmount_elements = 0;
    }

    extraDiscountAmount = extraDiscountAmount_elements;

    var total_of_all_line_temp = (+getSumOfAll_Totals_InAllLines(invoiceLines)).toFixed(5);
    total_of_all_line = total_of_all_line_temp;

    totalAmount = (+total_of_all_line_temp - +extraDiscountAmount_elements).toFixed(5);
}

function roundForTwoDicimalPoints() {
    var numb = 12312214.124124124;
    numb = numb.toFixed(5);
}

