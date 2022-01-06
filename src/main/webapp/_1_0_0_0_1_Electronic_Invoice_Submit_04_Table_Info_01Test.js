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

    //var validLine = true;
    var itemCodeElement = document.getElementById("itemCode");
    var itemCode = itemCodeElement.value;

    var extra_description = document.getElementById("extra_description").value;
    var description = document.getElementById("description").value + ((extra_description === "") ? "" : ("-" + extra_description));
    var unitType = document.getElementById("unitType").value;

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
    } else if (description === null || description === "") {
        Warning("لا يوجد مسمى للصنف");
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
    var unitValue = new Object();
    unitValue.currencySold = currencySold;
    unitValue.amountEGP = amountEGP;
    unitValue.amountSold = amountSold;
    unitValue.currencyExchangeRate = currencyExchangeRate;

    var taxableItems = new Object();
    taxableItems.taxLineNumber = null;
    taxableItems.taxType = null;
    taxableItems.subType = null;
    taxableItems.rate = null;
    taxableItems.amount = null;
    taxableItems.subTypeName = null;

    line_number = line_number + 1;
    var invoiceLines = new Object();
    invoiceLines.lineNumber = "" + line_number;
    invoiceLines.description = description;
    invoiceLines.itemType = itemType;
    invoiceLines.itemCode = itemCode;
    invoiceLines.unitType = unitType;
    invoiceLines.quantity = quantity;
    invoiceLines.internalCode = itemCode;
    invoiceLines.unitValue = unitValue;
    var salesTotal = (+quantity * +amountEGP).toFixed(5);
    invoiceLines.salesTotal = parseFloat(salesTotal);
    invoiceLines.discount = discount;
    var netTotal = (+salesTotal - +discount_amount).toFixed(5);
    invoiceLines.netTotal = +netTotal;
    invoiceLines.valueDifference = 0;
    invoiceLines.taxableItems = [];
    invoiceLines.totalTaxableFees = 0;
    invoiceLines.itemsDiscount = 0;
    invoiceLines.total = +((+netTotal + 0) - 0);
    documents.push(invoiceLines);
    drawTable(true);
}


var current_active_line;
function setCurrentActiveLine(line_no) {
    current_active_line = line_no;
}
var taxesLines = 0;
function add_tax_to_line() {
    //current_active_line
    var taxable = document.getElementById("taxable");//تخضع للضريبة أو لا

    var subTypeElement = document.getElementById("subType");
    var taxTypeSubType = subTypeElement.value;

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

drawTable(true);
function drawTable(update) {
    alert(update);
    calcLineTotals();
    var invoiceLines = document.getElementById("invoiceLines");
    invoiceLines.innerHTML = "";
    var TOTAL_salesTotal = 0;
    var TOTAL_discountAmount = 0;
    var TOTAL_netTotal = 0;
    if (documents.length > 0) {
        for (var i = 0; i < documents.length; i++) {
            var data = documents[i];
            TOTAL_salesTotal += +data.salesTotal.toFixed(5);
            TOTAL_discountAmount += +data.discount.amount.toFixed(5);
            TOTAL_netTotal += +data.netTotal.toFixed(5);
            var html =
                    "<tr id=\"line_" + data.lineNumber + "\">" +
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
                html += "            <button type=\"button\" onclick=\"setCurrentActiveLine('" + data.lineNumber + "');\" class=\"btn btn-success fa fa-plus\" data-toggle=\"modal\" data-target=\"#taxModal\" style=\"font-weight: bold;font-size: 10px;text-align: center;\"></button>";
            }
            html += "            <tbody id=\"line_" + data.lineNumber + "_Tax\">";

            for (var j = 0; j < data.taxableItems.length; j++) {
                var taxData = data.taxableItems[j];
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


        invoiceLines.innerHTML += "<tr style='background-color: coral;'><th colspan='7'></th><th>خصم الفاتورة</th><th>" + extraDiscountAmount + "</th><th></th></tr>";

        // صف الإجماليات
        html = "";
        html += "<tr style='background-color: mistyrose;'><th colspan='4'>الإجماليات</th>"
                + "<th>" + TOTAL_salesTotal + "</th>"
                + "<th>" + TOTAL_discountAmount + "</th>"
                + "<th>" + TOTAL_netTotal + "</th>"
                + "<th></th>"
                + "<th>" + totalAmount + "</th>"
                + "<th></th>"
                + "</tr>";
        invoiceLines.innerHTML += html;
    } else {
        invoiceLines.innerHTML = "<tr><td colspan='10'>لا توجد سطور للفاتورة</td></tr>";
        invoiceLines.innerHTML += "<tr style='background-color: coral;'><th colspan='7'></th><th>خصم الفاتورة</th><th>" + extraDiscountAmount + "</th><th></th></tr>";

        var html = "";
        html += "<tr style='background-color: mistyrose;'><th colspan='4'>الإجماليات</th>"
                + "<th>" + TOTAL_salesTotal + "</th>"
                + "<th>" + TOTAL_discountAmount + "</th>"
                + "<th>" + TOTAL_netTotal + "</th>"
                + "<th></th>"
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

