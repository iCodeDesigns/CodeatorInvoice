/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getDeptsFromAcc() {
    var accUnitCode = $("#accUnitCode").val();
    document.getElementById("depNoOld").innerHTML = "";
    $(".chosen-select").trigger("chosen:updated");
    $.ajax({
        url: "_1_0_0_1_5_Electronic_Invoice_Count_Report_OnDept_01_getDeptsFromAcc_AjaxServlet?",
        type: 'POST',
        //dataType: 'json',
        data: JSON.stringify(accUnitCode),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {

            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<option value='" + data[i].id.accUnitCode + "," + data[i].id.sectionNoOld + "," + data[i].id.depNoOld + "'>" + data[i].perDeptOld.depName + "</option>";
            }
            document.getElementById("depNoOld").innerHTML = html;
            $(".chosen-select").trigger("chosen:updated");
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });

}




////----------------------------------------------------------------------------
//document.getElementById("countsDiv").style.display = "none";
//document.getElementById("dtlDiv").style.display = "none";
function search() {
    var searchType = $("#searchType").val();
    //document.getElementById("countsDiv").style.display = "none";
    //document.getElementById("dtlDiv").style.display = "none";

    var fromDate = document.getElementById("fromDate").value;
    var toDate = document.getElementById("toDate").value;
    if (fromDate === null || fromDate === "") {
        Warning("اختر تاريخ بداية فترة الاستعلام");
    } else if (toDate === null || toDate === "") {
        Warning("اختر تاريخ نهاية فترة الاستعلام");
    }

    if (searchType === "1") {
        //search_counts();
    } else if (searchType === "2") {
        searchDtl();
    } else {
        //search_counts();
        searchDtl();
    }
}


////////////////////////////////////////////////////////////////-----------------
var AllData = [];
var first_load = true;
loadTableFirstTime();
function loadTableFirstTime() {
    var table_id = "per_users_data";
    $("#" + table_id + " tbody").empty();
    if (first_load) {
        first_load = false;
    } else {
        $("#" + table_id).DataTable().destroy();
    }
    $("#" + table_id + " tbody").empty();

    var table_json = {
        iDisplayLength: 10,
        keys: true,
        paging: true
    };

    $("#" + table_id).DataTable(table_json);
}
function searchDtl() {
    accUnitCode = document.getElementById("accUnitCode").value;
    depNoOld = document.getElementById("depNoOld").value;
    if (accUnitCode === null || accUnitCode === "") {
        Warning("اختر وحدة حسابية واحدة على الاقل لعرض تفاصيل الفواتير");
    } else if (depNoOld === null || depNoOld === "") {
        Warning("اختر إدارة واحدة على الاقل لعرض تفاصيل الفواتير");
    }


    document.getElementById("dtlDiv").style.display = "block";
    var table_id = "dataCutomTable";
    /*var selected_DocStatus = [];
     selected_DocStatus.push('17');*/

    var selected_DepNoOld = [];
    $("#depNoOld option:selected").each(function () {
        var $this = $(this);
        if ($this.length) {
            var id = $this.val().split(",");
            var id_str = "'" + id[0] + "','" + id[1] + "','" + id[2] + "'";
            selected_DepNoOld.push(id_str);
        }
    });


    /*for (var option of document.getElementById('DocStatus').options)
     {
     if (option.selected) {
     
     }
     }*/





    var json = {
        //docStatus: selected_DocStatus,
        dept: selected_DepNoOld
    };

    var createdDate_OR_issueDate = $("#createdDate_OR_issueDate").val();
    var fromDate = document.getElementById("fromDate").value;
    var toDate = document.getElementById("toDate").value;

    document.getElementById("Electronic_Invoice_Query_Master_Table").innerHTML =
            "<tr>"
            + "    <td colspan='9'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    $.ajax({//
        url: "_1_0_0_1_6_Electronic_Dept_Credit_Count_Report_OnDept_02_getInvoicesFromDeptsAcc_AjaxServlet?"
                + "fromDate=" + fromDate
                + "&toDate=" + toDate
                + "&createdDate_OR_issueDate=" + createdDate_OR_issueDate,
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(json),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            $("#" + table_id + " tbody").empty();
            if (first_load) {
                first_load = false;
            } else {
                $("#" + table_id).DataTable().destroy();
            }
            $("#" + table_id + " tbody").empty();

            console.log(JSON.stringify(data));
            var html = "";
            var i = 0;
            for (i = 0; i < data.length; i++) {
                var printed_internal_id = data[i].internalID;
                if (data[i].documentDividedStatus === "Divided") {
                    printed_internal_id = data[i].internalID + " ( " + data[i].startDocSerial + " <span class='fa fa-arrow-right'></span> " + data[i].endDocSerial + " )";
                }

                var receiver_Type = data[i].receiver.type;
                if (receiver_Type === "B") {
                    receiver_Type = "شركة";
                } else if (receiver_Type === "P") {
                    receiver_Type = "فرد";
                } else if (receiver_Type === "F") {
                    receiver_Type = "أجنبي";
                }

                var documentType = data[i].documentType;
                if (documentType === "I") {
                    if (data[i].documentDividedStatus === "Divided") {
                        documentType = "فاتورة مقسمة إلى <br>" + data[i].endDocSerial + " فاتورة";
                    } else {
                        documentType = "فاتورة";
                    }
                } else if (documentType === "C") {
                    documentType = "إشعار إضافة";
                } else if (documentType === "D") {
                    documentType = "إشعار خصم";
                }
                html += "<tr>"
                        + "<td class=\"table-font-style;\" style='direction : ltr;'>" + data[i].accUnitId + " - " + data[i].accAcountUnitCode + "</td>"
                        + "<td class=\"table-font-style;\" style='direction : ltr;'>" + data[i].sectionOld + "" + data[i].deptOld + " - " + data[i].newAccAcountUnitCode + "</td>"
                        + "<td class=\"table-font-style;\" style='direction : ltr;'>" + printed_internal_id + "</td>"
                        + "<td class=\"table-font-style\">" + receiver_Type + "</td>"
                        + "<td class=\"table-font-style\">" + documentType + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].receiver.name + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].dateTimeIssued + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].totalAmount + "</td>";


                if (data[i].uuid === undefined || data[i].uuid === null || data[i].uuid === "") {
                    html += "<td class=\"table-font-style\">" + data[i].statusDescription + "</td>";
                } else {
                    var description = data[i].statusDescription;

                    var color = "";
                    var fafa = "";
                    switch (description) {
                        case "Valid":
                            color = "color: green !important;";
                            fafa = "fa-check";
                            break;
                        case "Invalid":
                            color = "color: red !important;";
                            fafa = "fa-warning";
                            break;
                        case "Cancelled":
                            color = "color: red !important;";
                            fafa = "fa-close";
                            break;
                        case "Rejected":
                            color = "color: red !important;";
                            fafa = "fa-close";
                            break;
                        case "Submitted":
                            color = "color: blue !important;";
                            fafa = "fa-close";
                            break;
                        case "Cancellation Requested":
                            color = "color: gray !important;";
                            fafa = "fa-close";
                            break;
                        case "Rejection Requested":
                            color = "color: gray !important;";
                            fafa = "fa-close";
                            break;
                    }

                    html += "    <td><a style=\" " + color + "; font - weight: bold; cursor: pointer;\" data-toggle=\"modal\" data-target=\".InvoiceDetailsPortal\" onclick=\"getInvoiceData('" + data[i].uuid + "');\"> " + description + " <span class=\"fa " + fafa + "\"></span></a></td>\n";
                }

                html += "<td>"
                        + "     <button type=\"button\" onclick=\"getInvoiceRelationMaster('" + data[i].accUnitId + "','" + data[i].deptOld + "','" + data[i].sectionOld + "','" + data[i].invSp + "');\" data-toggle=\"modal\" data-target=\".InvoiceDtlMain\" class=\"fa fa-search btn btn-success\" style=\"font-size: large;border: 2px solid white;\" title=\"استعراض الفاتورة\" data-toggle=\"tooltip\"></button>";

                html += "</td>"
                        + "</tr>";

            }
            if (i === 0) {
                AllData = [];
                document.getElementById("Electronic_Invoice_Query_Master_Table").innerHTML =
                        "<tr>"
                        + "    <td colspan='9'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                AllData = data;

                document.getElementById("Electronic_Invoice_Query_Master_Table").innerHTML = html;

                var table_type = $("#table_type").val();
                var table_json = {};
                if (table_type === "show") {
                    table_json = {
                        iDisplayLength: 10,
                        keys: true,
                        paging: true
                    };
                } else {//export
                    table_json = {
                        iDisplayLength: 10,
                        keys: true,
                        dom: 'Bfrtip',
                        buttons: [
                            'copy', 'csv', 'excel', 'pdf', 'print'
                        ]
                    };
                }

                $("#" + table_id).DataTable(table_json);
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}
////////////////////////////////////////////////////////////////-----------------
var lastRow = [];
function search_counts() {
    //document.getElementById("countsDiv").style.display = "block";
    var table_id = "MyTable";
    var selected_taxSubType = [];
    $("#taxTypeDtl option:selected").each(function () {
        var $this = $(this);
        if ($this.length) {
            var columns = {
                value: $this.val(),
                str: $this.text()
            };
            selected_taxSubType.push(columns);
        }
    });

    var selected_DepNoOld = [];
    $("#depNoOld option:selected").each(function () {
        var $this = $(this);
        if ($this.length) {
            var id = $this.val().split(",");
            var id_str = "'" + id[0] + "','" + id[1] + "','" + id[2] + "'";
            selected_DepNoOld.push(id_str);
        }
    });


    /*for (var option of document.getElementById('DocStatus').options)
     {
     if (option.selected) {
     
     }
     }*/





    var json = {
        taxSubType: selected_taxSubType,
        dept: selected_DepNoOld
    };
    var fromDate = document.getElementById("fromDate").value;
    var toDate = document.getElementById("toDate").value;
    var createdDate_OR_issueDate = $("#createdDate_OR_issueDate").val();
    $.ajax({
        url: "_1_0_0_1_4_Electronic_Invoice_Count_Report_insert_Query_Ajax_1_search_counts_AjaxServlet?"
                + "fromDate=" + fromDate
                + "&toDate=" + toDate
                + "&createdDate_OR_issueDate=" + createdDate_OR_issueDate,
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(json),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //console.log(JSON.stringify(data));
            $("#" + table_id + " thead").empty();
            var headerHtml = "";
            ///// 1st Header Row
            headerHtml += "  <tr style='background: #131e33;color: white;'>"
                    + "    <td>الإدارات</td>";
            $.each(selected_taxSubType, function (i, item) {
                headerHtml += "      <td>" + item.str + "</td>";
            });
//            headerHtml += "      <td colspan='2'>الإجماليات</td>";
            headerHtml += "  </tr>";
            ///// 2nd Header Row
            headerHtml += "  <tr style='background: #337ab7;color: white;'>"
                    + "    <td></td>";
            $.each(selected_taxSubType, function (i, item) {
                //headerHtml += "      <td>عدد</td>";
                headerHtml += "      <td>الإجمالي</td>";
            });

//            headerHtml += "      <td>إجمالي الأعداد</td>";
//            headerHtml += "      <td>إجمالي الفواتير</td>";

            headerHtml += "  </tr>";
            $("#" + table_id + " thead").append(headerHtml);



            ///// table body
            lastRow = [];

            $("#" + table_id + " tbody").empty();
            var html_body = "";
            for (var i = 0; i < data.length; i++) {
                var item = data[i];
                //var totalCount = 0;
                var totalSum = 0;
                html_body += "  <tr>";
                html_body += "     <td>" + item.deptName + "</td>";
                $.each(item.dataDetail, function (i, nums) {// حالة المستند
                    //html_body += "     <td>" + +nums.count + "</td>";
                    html_body += "     <td>" + (+nums.sum).toFixed(5) + "</td>";
                    //totalCount += (+nums.count);
                    totalSum += (+nums.sum);
                    fillLastRowJSON(nums.documentStatusId, 0, +nums.sum);
                });
//                html_body += "     <td style='background: bisque;'>" + totalCount + "</td>";
//                html_body += "     <td style='background: bisque;'>" + totalSum + "</td>";
                html_body += "  </tr>";
            }


            //var Last_totalCount = 0;
            var Last_totalSum = 0;
            html_body += "  <tr style='background: bisque;'>";
            html_body += "     <td style='background: #131e33;color: white;'>*الإجماليات</td>";
            for (var i = 0; i < lastRow.length; i++) {//Last Row
                var item = lastRow[i];
                //html_body += "     <td>" + +item.countTotal + "</td>";
                html_body += "     <td>" + (+item.sumTotal).toFixed(5) + "</td>";
                //Last_totalCount += (+item.countTotal);
                Last_totalSum += (+item.sumTotal);
            }
//            html_body += "     <td>" + Last_totalCount + "</td>";
//            html_body += "     <td>" + Last_totalSum + "</td>";
            html_body += "  </tr>";
            $("#" + table_id + " tbody").append(html_body);


            /*$("#" + table_id).DataTable({
             "iDisplayLength": 100
             });*/
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}



function fillLastRowJSON(documentStatusId, countTotal, sumTotal) {

    if (lastRow.length === 0) {
        var docuType = {
            documentStatusId: documentStatusId,
            countTotal: +countTotal,
            sumTotal: +sumTotal
        };
        lastRow.push(docuType);
    } else {
        var added = false;
        for (var i = 0; i < lastRow.length; i++) {
            var item = lastRow[i];
            console.log(item.documentStatusId + " : " + documentStatusId);
            if (item.documentStatusId === documentStatusId) {
                item.countTotal += +countTotal;
                item.sumTotal += +sumTotal;
                added = true;
            }
        }
        if (!added) {
            var docuType = {
                documentStatusId: documentStatusId,
                countTotal: +countTotal,
                sumTotal: +sumTotal
            };
            lastRow.push(docuType);
        }
    }
    console.log(lastRow);
}

function getInvoiceRelationMaster(accUnitId, deptOld, sectionOld, inv_sp) {
    var table_id = "dataCutomTableDtl";
    document.getElementById("Electronic_Invoice_Query_Master_DTL_Table").innerHTML =
            "<tr>"
            + "    <td colspan='9'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    $.ajax({//
        url: "_1_0_0_1_6_Electronic_Dept_Credit_Count_Report_OnDept_03_getInvoicesDtlFromInvoiceMain_AjaxServlet?"
                + "accUnitId=" + accUnitId
                + "&deptOld=" + deptOld
                + "&sectionOld=" + sectionOld
                + "&inv_sp=" + inv_sp,
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(json),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {

            /*$("#" + table_id + " tbody").empty();
            if (first_load1) {
                first_load1 = false;
            } else {
                $("#" + table_id).DataTable().destroy();
            }*/
            $("#" + table_id + " tbody").empty();

            var html = "";
            var i = 0;
            var Sum_Final_total = 0;
            for (i = 0; i < data.length; i++) {
                var printed_internal_id = data[i].internalID;
                if (data[i].documentDividedStatus === "Divided") {
                    printed_internal_id = data[i].internalID + " ( " + data[i].startDocSerial + " <span class='fa fa-arrow-right'></span> " + data[i].endDocSerial + " )";
                }

                var receiver_Type = data[i].receiver.type;
                if (receiver_Type === "B") {
                    receiver_Type = "شركة";
                } else if (receiver_Type === "P") {
                    receiver_Type = "فرد";
                } else if (receiver_Type === "F") {
                    receiver_Type = "أجنبي";
                }

                var documentType = data[i].documentType;
                if (documentType === "I") {
                    if (data[i].documentDividedStatus === "Divided") {
                        documentType = "فاتورة مقسمة إلى <br>" + data[i].endDocSerial + " فاتورة";
                    } else {
                        documentType = "فاتورة";
                    }
                    Sum_Final_total += data[i].totalAmount;
                } else if (documentType === "C") {
                    documentType = "إشعار إضافة";
                    Sum_Final_total += data[i].totalAmount;
                } else if (documentType === "D") {
                    documentType = "إشعار خصم";
                    Sum_Final_total -= data[i].totalAmount;
                }
                html += "<tr>"
                        + "<td class=\"table-font-style;\" style='direction : ltr;'>" + data[i].accUnitId + " - " + data[i].accAcountUnitCode + "</td>"
                        + "<td class=\"table-font-style;\" style='direction : ltr;'>" + data[i].sectionOld + "" + data[i].deptOld + " - " + data[i].newAccAcountUnitCode + "</td>"
                        + "<td class=\"table-font-style;\" style='direction : ltr;'>" + printed_internal_id + "</td>"
                        + "<td class=\"table-font-style\">" + receiver_Type + "</td>"
                        + "<td class=\"table-font-style\">" + documentType + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].receiver.name + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].dateTimeIssued + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].totalAmount + "</td>";


                if (data[i].uuid === undefined || data[i].uuid === null || data[i].uuid === "") {
                    html += "<td class=\"table-font-style\">" + data[i].statusDescription + "</td>";
                } else {
                    var description = data[i].statusDescription;

                    var color = "";
                    var fafa = "";
                    switch (description) {
                        case "مرتبطة بإشعار":
                        case "Valid":
                            description = "Valid";
                            color = "color: green !important;";
                            fafa = "fa-check";
                            break;
                        case "Invalid":
                            color = "color: red !important;";
                            fafa = "fa-warning";
                            break;
                        case "Cancelled":
                            color = "color: red !important;";
                            fafa = "fa-close";
                            break;
                        case "Rejected":
                            color = "color: red !important;";
                            fafa = "fa-close";
                            break;
                        case "Submitted":
                            color = "color: blue !important;";
                            fafa = "fa-close";
                            break;
                        case "Cancellation Requested":
                            color = "color: gray !important;";
                            fafa = "fa-close";
                            break;
                        case "Rejection Requested":
                            color = "color: gray !important;";
                            fafa = "fa-close";
                            break;
                    }

                    html += "    <td><a style=\" " + color + "; font - weight: bold; cursor: pointer;\" data-toggle=\"modal\" data-target=\".InvoiceDetailsPortal\" onclick=\"getInvoiceData('" + data[i].uuid + "');\"> " + description + " <span class=\"fa " + fafa + "\"></span></a></td>\n";
                }

                html += "<td>"
                        + "     <button type=\"button\" onclick=\"getInvoiceDetails('" + data[i].accUnitId + "','" + data[i].deptOld + "','" + data[i].sectionOld + "','" + data[i].invSp + "');\" data-toggle=\"modal\" data-target=\".InvoiceDetails\" class=\"fa fa-search btn btn-success\" style=\"font-size: large;border: 2px solid white;\" title=\"استعراض الفاتورة\" data-toggle=\"tooltip\"></button>";

                html += "</td>"
                        + "</tr>";

            }
            if (i === 0) {
                AllData = [];
                document.getElementById("Electronic_Invoice_Query_Master_DTL_Table").innerHTML =
                        "<tr>"
                        + "    <td colspan='9'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                AllData = data;
                html += "<tr style='background: lightgrey;'><td colspan='7' style='text-align:left;'>الصافي</td><td>" + Sum_Final_total + "</td><td colspan='2'></td></tr>";
                document.getElementById("Electronic_Invoice_Query_Master_DTL_Table").innerHTML = html;

                /*var table_type = $("#table_type").val();
                var table_json = {};
                if (table_type === "show") {
                    table_json = {
                        iDisplayLength: 10,
                        keys: true,
                        paging: true
                    };
                } else {//export
                    table_json = {
                        iDisplayLength: 10,
                        keys: true,
                        dom: 'Bfrtip',
                        buttons: [
                            'copy', 'csv', 'excel', 'pdf', 'print'
                        ]
                    };
                }

                $("#" + table_id).DataTable(table_json);*/
            }
        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

///////////////////////////////////////////////---------------------------------
function getInvoiceDetails(accUnitId, deptOld, sectionOld, inv_sp) {
    for (var i = 0; i < AllData.length; i++) {
        receiverTypeControlFields1(AllData[i].receiver.type);
        //fillModal(AllData[i]);
        if (AllData[i].accUnitId === accUnitId && AllData[i].deptOld === deptOld && AllData[i].sectionOld === sectionOld && AllData[i].invSp === inv_sp) {
            fillModal(AllData[i]);
            break;
        }
    }
}
function fillModal(data) {
    console.log(data);

    var printed_internal_id = data.internalID;
    if (data.documentDividedStatus === "Divided") {
        printed_internal_id = " ( " + data.endDocSerial + " <span class='fa fa-arrow-right'></span> " + data.startDocSerial + " )" + data.internalID;
    }
    var receiver_Type = data.receiver.type;
    if (receiver_Type === "B") {
        receiver_Type = "شركة";
    } else if (receiver_Type === "P") {
        receiver_Type = "فرد";
    } else if (receiver_Type === "F") {
        receiver_Type = "أجنبي";
    }

    var documentType = data.documentType;
    if (documentType === "I") {
        if (data.documentDividedStatus === "Divided") {
            documentType = "فاتورة مقسمة إلى  " + data.endDocSerial + " فاتورة";
        } else {
            documentType = "فاتورة";
        }
    } else if (documentType === "C") {
        documentType = "إشعار إضافة";
    } else if (documentType === "D") {
        documentType = "إشعار خصم";
    }

    document.getElementById("receiverType1").value = receiver_Type;
    document.getElementById("receivername1").value = data.receiver.name;
    document.getElementById("id1").value = data.receiver.id;
    document.getElementById("documentType1").value = documentType;

    document.getElementById("Invoice_number1").innerHTML = printed_internal_id;
    document.getElementById("invoiceID1").innerHTML = printed_internal_id;


    document.getElementById("dateTimeIssued1").value = data.dateTimeIssued;
    document.getElementById("invoRealDate1").value = data.invoRealDate;
    document.getElementById("serviceName1").value = data.serviceName;
    document.getElementById("notes1").value = data.notes;

    document.getElementById("permToReceiveCode1").value = (data.permToReceiveCode === null) ? "" : data.permToReceiveCode;
    document.getElementById("permToDeliverCode1").value = (data.permToDeliverCode === null) ? "" : data.permToDeliverCode;
    document.getElementById("permToReceiveDate1").value = (data.permToReceiveDate === null) ? "" : data.permToReceiveDate;
    document.getElementById("permToDeliverDate1").value = (data.permToDeliverDate === null) ? "" : data.permToDeliverDate;
    document.getElementById("permToReceiveCode1Div").style.display = (data.permToReceiveCode === null) ? "none" : "block";
    document.getElementById("permToDeliverCode1Div").style.display = (data.permToDeliverCode === null) ? "none" : "block";
    document.getElementById("permToReceiveDate1Div").style.display = (data.permToReceiveDate === null) ? "none" : "block";
    document.getElementById("permToDeliverDate1Div").style.display = (data.permToDeliverDate === null) ? "none" : "block";


    var ErrorsDiv = document.getElementById("ErrorsDiv");
    var errorRmrk = document.getElementById("errorRmrk");
    if (data.statusRmrk === null || data.statusRmrk === "أرسلت بواسطة السيرفر" || data.statusRmrk === "عدلت بواسطة السيرفر") {
        ErrorsDiv.style.display = "none";
        errorRmrk.innerHTML = "";
    } else {
        ErrorsDiv.style.display = "block";
        errorRmrk.innerHTML = "سبب رفض المستند : " + data.statusRmrk;
    }


    var html = "";
    var invoiceLines = document.getElementById("invoiceLines1");
    invoiceLines.innerHTML = "";
    var TOTAL_salesTotal = 0;
    var TOTAL_discountAmount = 0;
    var TOTAL_netTotal = 0;
    var TOTAL_Tax = 0;
    if (data.invoiceLines.length > 0) {
        for (var i = 0; i < data.invoiceLines.length; i++) {
            var line = data.invoiceLines[i];
            TOTAL_salesTotal += +line.salesTotal.toFixed(5);
            TOTAL_discountAmount += +line.discount.amount.toFixed(5);
            TOTAL_netTotal += +line.netTotal.toFixed(5);

            html += "<tr id=\"line_" + line.lineNumber + "\">" +
                    "    <td style=\"text-align: center;\">" + line.itemCode + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.description + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.unitValue.amountEGP + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.quantity + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.salesTotal + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.discount.amount + "</td>" +
                    "    <td style=\"text-align: center;\">" + line.netTotal + "</td>" +
                    "    <td style=\"text-align: center;\">" +
                    "        <table class=\"table table-striped table-bordered\">" +
                    "            <tbody id=\"line_" + line.lineNumber + "_Tax\">";

            for (var j = 0; j < line.taxableItems.length; j++) {
                var taxData = line.taxableItems[j];
                TOTAL_Tax += +taxData.amount.toFixed(5);
                html += "<tr id=\"line_" + data.lineNumber + "_Tax_" + taxData.taxLineNumber + "\">\n" +
                        "    <td style=\"text-align: center;\">" + taxData.subType + "</td>\n" +
                        "    <td style=\"text-align: center;\">" + taxData.subTypeName + "</td>\n" +
                        "    <td style=\"text-align: center;\">" + taxData.rate + " %</td>\n" +
                        "    <td style=\"text-align: center;\">" + taxData.amount + "</td>\n" +
                        "</tr>";
            }
            html += "            </tbody>" +
                    "        </table>" +
                    "    </td>" +
                    "    <td style=\"text-align: center;\">" + line.total + "</td>" +
                    "</tr>";

        }
        invoiceLines.innerHTML += html;
        invoiceLines.innerHTML += "<tr><th colspan='8'>الخصم</th><th>" + data.extraDiscountAmount + "</th></tr>";

        // صف الإجماليات
        html = "";
        html += "<tr style='background-color: palegreen;'><th colspan='4'>الإجماليات</th>"
                + "<th>" + TOTAL_salesTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_discountAmount.toFixed(5) + "</th>"
                + "<th>" + TOTAL_netTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_Tax.toFixed(5) + "</th>"
                + "<th>" + data.totalAmount.toFixed(5) + "</th>"
                + "</tr>";
        invoiceLines.innerHTML += html;
    } else {
        invoiceLines.innerHTML = "<tr><td colspan='10'>لا توجد سطور للفاتورة</td></tr>";
        invoiceLines.innerHTML += "<tr style='background-color: coral;'><th colspan='7'></th><th>خصم الفاتورة</th><th>" + extraDiscountAmount + "</th><th></th></tr>";

        var html = "";
        html += "<tr style='background-color: palegreen;'><th colspan='4'>الإجماليات</th>"
                + "<th>" + TOTAL_salesTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_discountAmount.toFixed(5) + "</th>"
                + "<th>" + TOTAL_netTotal.toFixed(5) + "</th>"
                + "<th>" + TOTAL_Tax.toFixed(5) + "</th>"
                + "<th>" + data.totalAmount.toFixed(5) + "</th>"
                + "</tr>";
        invoiceLines.innerHTML += html;
    }


}

function receiverTypeControlFields1(type) {
    document.getElementById("receivername1").value = "";
    var receiverType = type;
    if (receiverType === "B") {
        document.getElementById("ComRegisterDiv1").style.display = "block";
        document.getElementById("nationalIdDiv1").style.display = "none";
        document.getElementById("passportNumberDiv1").style.display = "none";
    } else if (receiverType === "P") {
        document.getElementById("ComRegisterDiv1").style.display = "none";
        document.getElementById("nationalIdDiv1").style.display = "block";
        document.getElementById("passportNumberDiv1").style.display = "none";
    } else if (receiverType === "F") {
        document.getElementById("ComRegisterDiv1").style.display = "none";
        document.getElementById("nationalIdDiv1").style.display = "none";
        document.getElementById("passportNumberDiv1").style.display = "block";
    }
}

