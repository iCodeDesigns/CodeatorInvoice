/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
async function getInvoice2(accUnitId, deptOld, sectionOld, searchType, fromDate, toDate, createdDate_OR_issueDate) {
    var url = "_1_0_0_1_1_Electronic_Invoice_Query_print_01_getInvoice?"
            + "sectionId=" + sectionOld
            + "&deptId=" + deptOld
            + "&accUnitId=" + accUnitId
            + "&searchType=" + searchType
            + "&fromDate=" + fromDate
            + "&toDate=" + toDate
            + "&createdDate_OR_issueDate=" + createdDate_OR_issueDate;
    applyInvoiceAjax(url);
}
async function getInvoice(accUnitId, deptOld, sectionOld, inv_sp) {
    var url = "_1_0_0_1_1_Electronic_Invoice_Query_print_01_getInvoice?"
            + "invSp=" + inv_sp
            + "&sectionId=" + sectionOld
            + "&deptId=" + deptOld
            + "&accUnitId=" + accUnitId
            + "&searchType=*";
    applyInvoiceAjax(url);
}

async function applyInvoiceAjax(url) {
    await sleep(1000);
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'json',
        //data: json,
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data.length === 1) {
                fillInvoice(data[0], "*");
            } else {
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    fillInvoice(data[i], i);
                }
            }

        },
        error: function (xhr, status) {
            if (xhr.responseText === "Error") {
                alert("حدث خطأ");
            }
        }
    });
}

function fillInvoice(data, invoice_index) {

    if (invoice_index === "*") {
        invoice_index = "";
    }

    var content_print = document.getElementById("content-print" + invoice_index);
    if (data.statusDescription === "محذوف") {
        content_print.classList.add("deletedWaterMark");
    }

    var doc_type;
    if (data.documentType === "I") {
        doc_type = "فاتورة";
    } else if (data.documentType === "C") {
        doc_type = "إشعار إضافة";
    } else if (data.documentType === "D") {
        doc_type = "إشعار خصم";
    }
    document.getElementById("Ahram_id" + invoice_index).innerHTML = NumFromEnToAr("100534287");
    document.getElementById("tel_Div" + invoice_index).innerHTML = NumFromEnToAr("02/24539687");
    document.getElementById("documentType" + invoice_index).innerHTML = doc_type;


    document.getElementById("invoice_createdate" + invoice_index).innerHTML = NumFromEnToAr('' + data.dateTimeCreated);
    document.getElementById("invoRealDate" + invoice_index).innerHTML = NumFromEnToAr('' + data.invoRealDate);
    document.getElementById("invoice_datetime" + invoice_index).innerHTML = NumFromEnToAr('' + data.dateTimeIssued);
    document.getElementById("invoice_internalId" + invoice_index).innerHTML = NumFromEnToAr('' + data.internalID);
    document.getElementById("footer_internal_id" + invoice_index).innerHTML = NumFromEnToAr('' + data.internalID);

    if (RecieveDevliverCodeStstus) {
        document.getElementById("permToReceiveCode1" + invoice_index).innerHTML = NumFromEnToAr('' + data.permToReceiveCode);
        document.getElementById("permToDeliverCode1" + invoice_index).innerHTML = NumFromEnToAr('' + data.permToDeliverCode);
        document.getElementById("permToReceiveDate1" + invoice_index).innerHTML = NumFromEnToAr('' + data.permToReceiveDate);
        //document.getElementById("permToDeliverDate1"+invoice_index).innerHTML = NumFromEnToAr('' + data.permToDeliverDate);
    }

    document.getElementById("receiver_name" + invoice_index).innerHTML = data.receiver.name;
    document.getElementById("dept_Name" + invoice_index).innerHTML = data.accAcountUnitCode;
    document.getElementById("dept_Name1" + invoice_index).innerHTML = data.accAcountUnitCode;
    document.getElementById("dept_Name2" + invoice_index).innerHTML = data.accAcountUnitCode;

    var tel = (data.tel === null) ? "-" : data.tel;
    var fax = (data.fax === null) ? "-" : data.fax;
    if (tel === undefined || tel === null || tel === "") {
        tel = "...";
    } else if (fax === undefined || fax === null || fax === "") {
        fax = "...";
    }

    document.getElementById("contact" + invoice_index).innerHTML = "ت: " + tel + "  -  فاكس: " + fax;

    //id_name
    if (data.receiver.type === "B") {
        document.getElementById("id_name" + invoice_index).innerHTML = "رقم البطاقة الضريبية";
    } else if (data.receiver.type === "P") {
        document.getElementById("id_name" + invoice_index).innerHTML = "الرقم القومي";
    } else if (data.receiver.type === "F") {
        document.getElementById("id_name" + invoice_index).innerHTML = "رقم جواز السفر";
    }

    document.getElementById("receiver_id" + invoice_index).innerHTML = (data.receiver.id === null) ? "" : NumFromEnToAr('' + data.receiver.id);
    var address = "";

    try {
        if (data.receiver.receiverDetails.length === 0) {
            address = '' + data.receiver.address.countryCode + ","
                    + data.receiver.address.governate + ","
                    + data.receiver.address.street;
        } else {
            console.log(data.receiver);
            address = (data.receiver.receiverDetails[0].addressBr === null) ? '' + data.receiver.address.countryCode + ","
                    + data.receiver.address.governate + ","
                    + data.receiver.address.street
                    :
                    '' + data.receiver.address.countryCode + ","
                    + data.receiver.receiverDetails[0].addressBr;
        }
    } catch (err) {

    }
    document.getElementById("receiver_address" + invoice_index).innerHTML = NumFromEnToAr(address);

    document.getElementById("serviceName" + invoice_index).innerHTML = data.serviceName;
    document.getElementById("notes" + invoice_index).innerHTML = data.notes;

    var invoice_lines = data.invoiceLines;
    var html = "";
    var html_head;
    var TOTAL_salesTotal = 0;
    var TOTAL_discountAmount = 0;
    var TOTAL_netTotal = 0;
    var TOTAL_Tax = 0;
    var TOTAL_Quantity = 0;

    //testDiscount 
    var TOTAL_discountAmount_forVisible = 0;
    for (var i = 0; i < invoice_lines.length; i++) {
        TOTAL_discountAmount_forVisible += +invoice_lines[i].discount.amount.toFixed(5);
    }

    html_head = "<th class=\"text-center\">"
            + "   #"
            + "</th>"
            + "<th class=\"text-center\" colspan='3'>"
            + "    كود الصنف"
            + "</th>"
            + "<th class=\"text-center\" colspan='3'>"
            + "    توصيف الصنف"
            + "</th>"
            + "<th class=\text-center\">"
            + "    الكمية"
            + "</th>"
            + "<th class=\"text-center\">"
            + "   سعر الوحدة"
            + "</th>";
    if (+TOTAL_discountAmount_forVisible.toFixed(5) !== 0) {
        html_head += "<th class=\"text-center\">"
                + "    الخصم"
                + "</th>";
    }
    html_head += "<th class=\"text-center\">"
            + "    الضريبة"
            + "</th>"
            + "<th class=\"text-center\">"
            + "    إجمالي السعر"
            + "</th>";

    for (var i = 0; i < invoice_lines.length; i++) {
        TOTAL_salesTotal += +invoice_lines[i].salesTotal.toFixed(5);
        TOTAL_discountAmount += +invoice_lines[i].discount.amount.toFixed(5);
        TOTAL_netTotal += +invoice_lines[i].netTotal.toFixed(5);
        TOTAL_Quantity += +invoice_lines[i].quantity.toFixed(5);

        var itemCode = invoice_lines[i].itemCode;
        if (invoice_lines[i].itemType === "EGS") {
            itemCode = itemCode.split("-")[2];
        }

        html += "<tr>\n" +
                "    <td class=\"serial\">" + NumFromEnToAr('' + (i + 1)) + "</td>\n" +
                "    <td colspan=\"3\">" + NumFromEnToAr('' + itemCode) + "</td>\n" +
                "    <td colspan=\"3\">" + NumFromEnToAr('' + invoice_lines[i].description) + "</td>\n" +
                "    <td>" + NumFromEnToAr('' + invoice_lines[i].quantity) + "</td>\n" +
                "    <td>" + NumFromEnToAr('' + invoice_lines[i].unitValue.amountEGP) + "</td>\n";

        if (+TOTAL_discountAmount_forVisible.toFixed(5) !== 0) {
            html += "    <td>" + NumFromEnToAr('' + invoice_lines[i].discount.amount) + "</td>\n";
        }

        html += "    <td>\n";
        if (invoice_lines[i].taxableItems.length > 0) {
            html += "        <table>\n" +
                    "            <tbody>\n";
            for (var j = 0; j < invoice_lines[i].taxableItems.length; j++) {
                var taxData = invoice_lines[i].taxableItems[j];
                TOTAL_Tax += +taxData.amount;
                html += "                <tr>\n" +
                        "                    <td>" + NumFromEnToAr('' + taxData.subTypeName + ": " + taxData.rate) + "%</td>\n" +
                        "                    <td>" + NumFromEnToAr('' + taxData.amount) + " ج.م</td>\n" +
                        "                </tr>\n";
            }
            html += "            </tbody> \n" +
                    "        </table>\n";
        } else {
            html += "-";
        }

        html += "    </td>\n" +
                "    <td>" + NumFromEnToAr('' + invoice_lines[i].total) + "</td>\n" +
                "</tr>";
    }


    /////// الإجماليات
    if (!data.extraDiscountAmount.toFixed(5) === 0) {
        html += "<tr style=\"background: rgba(217,225,242,1.0)!important;border: 1.5px solid black;-webkit-print-color-adjust: exact;\">\n" +
                "    <td colspan='" + ((+TOTAL_discountAmount_forVisible.toFixed(5) !== 0) ? "11" : "10") + "' style='text-align: left;'>الخصم على الفاتورة</td>\n" +
                "    <td colspan=\"2\">" + NumFromEnToAr('' + data.extraDiscountAmount.toFixed(5)) + "</td>\n" +
                "</tr>\n";
    }




    TOTAL_Quantity = trim_number(TOTAL_Quantity.toFixed(5), false, false);
    TOTAL_discountAmount = trim_number(TOTAL_discountAmount.toFixed(5), true, false);
    TOTAL_Tax = +trim_number(TOTAL_Tax.toFixed(5), true, false);
    var TOTAL_TotalAmount = trim_number(data.totalAmount.toFixed(5), true, true);
    html += "<tr style=\"background: rgba(217,225,242,1.0)!important;border: 1.5px solid black;-webkit-print-color-adjust: exact;\">\n" +
            "    <td colspan='7' style='text-align:center;'>الإجماليات</td>\n" +
            "    <td>" + NumFromEnToAr('' + TOTAL_Quantity) + "</td>\n" +
            "    <td></td>";

    if (+TOTAL_discountAmount_forVisible.toFixed(5) !== 0) {
        html += "    <td>" + NumFromEnToAr('' + TOTAL_discountAmount) + "</td>\n";
    }

    html += "    <td>" + NumFromEnToAr('' + TOTAL_Tax) + "</td>\n" +
            "    <td colspan=\"2\">" + NumFromEnToAr('' + TOTAL_TotalAmount) + "</td>\n" +
            "</tr>\n";


    /// التفقيط
    html += "<tr style=\"background: rgba(217,225,242,1.0)!important;border: 1.5px solid black;-webkit-print-color-adjust: exact;\">\n" +
            "    <td colspan='2' style='text-align:left;'></td>\n" +
            "    <td colspan='9' style='text-align:center;'>فقط و قدره(" + f2t('' + TOTAL_TotalAmount) + ")</td>";
    "</tr>\n";


    ////////////////////////
    if (+TOTAL_discountAmount_forVisible.toFixed(5) !== 0) {
        document.getElementById("colsapnChange" + invoice_index).colSpan = "12";
    } else {
        document.getElementById("colsapnChange" + invoice_index).colSpan = "11";
    }

    document.getElementById("table_head" + invoice_index).innerHTML = html_head;
    document.getElementById("invoice_lines" + invoice_index).innerHTML = html;
}
function trim_number(num, allow_floatingPoints, MaxPoint) {
    var num_parts = num.split(".");
    if (num_parts.length > 1) {
        if (+num_parts[1] === 0) {
            if (allow_floatingPoints) {
                num = num_parts[0] + ".00";
            } else {
                num = num_parts[0];
            }

        } else {
            var digit_1 = num_parts[1].charAt(0);
            var digit_2 = num_parts[1].charAt(1);
            var digit_3 = num_parts[1].charAt(2);
            var digit_4 = num_parts[1].charAt(3);
            var digit_5 = num_parts[1].charAt(4);

            if (+digit_1 === 0 && +digit_2 === 0 && +digit_3 === 0 && +digit_4 === 0 && +digit_5 === 0) {
                num = num_parts[0] + "." + digit_1 + digit_2;

            } else if (+digit_2 === 0 && +digit_3 === 0 && +digit_4 === 0 && +digit_5 === 0) {
                num = num_parts[0] + "." + digit_1 + digit_2;
            } else if (+digit_3 === 0 && +digit_4 === 0 && +digit_5 === 0) {
                TOTAL_Quantity = num_parts[0] + "." + digit_1 + digit_2;
            } else if (+digit_4 === 0 && +digit_5 === 0) {
                num = num_parts[0] + "." + digit_1 + digit_2 + digit_3;
            } else if (+digit_5 === 0) {
                num = num_parts[0] + "." + digit_1 + digit_2 + digit_3 + digit_4;
            } else {
                num = num_parts[0] + "." + num_parts[1];
            }

            if (MaxPoint) {
                if (num.split(".")[1].length > 3) {
                    num = num.split(".")[0] + "."
                            + num.split(".")[1].charAt(0)
                            + num.split(".")[1].charAt(1)
                            + num.split(".")[1].charAt(2);
                }
                if (num.split(".")[1].charAt(2) === "0") {
                    num = num.split(".")[0] + "."
                            + num.split(".")[1].charAt(0)
                            + num.split(".")[1].charAt(1);
                }
            }
            return num;
        }
    }
    return num;
}
var lang;
function setLang(lan) {
    lang = lan;
}

function NumFromEnToAr(str) {
    var Number = "";
    if (lang === "ar") {
        for (var i = 0; i < str.length; i++) {
            switch (str.charAt(i)) {
                case '0':
                    Number += "٠";
                    break;
                case '1':
                    Number += "١";
                    break;
                case '2':
                    Number += "٢";
                    break;
                case '3':
                    Number += "٣";
                    break;
                case '4':
                    Number += "٤";
                    break;
                case '5':
                    Number += "٥";
                    break;
                case '6':
                    Number += "٦";
                    break;
                case '7':
                    Number += "٧";
                    break;
                case '8':
                    Number += "٨";
                    break;
                case '9':
                    Number += "٩";
                    break;
                case '.':
                    Number += ",";
                    break;
                default:
                    Number += str.charAt(i);
            }
        }
    } else {
        Number = str;
    }

    if (Number.length === 10 && lang === "ar") {
        var arabDate = Number.split("-");
        if (arabDate.length === 3) {
            Number = arabDate[2] + "-" + arabDate[1] + "-" + arabDate[0];
        }
    }

    return Number;
}