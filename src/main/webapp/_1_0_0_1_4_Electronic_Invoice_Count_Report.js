/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var lastRow = [];
function search_counts() {
    var table_id = "MyTable";
    var selected_DocStatus = [];
    $("#DocStatus option:selected").each(function () {
        var $this = $(this);
        if ($this.length) {
            var columns = {
                value: $this.val(),
                str: $this.text()
            };
            selected_DocStatus.push(columns);
        }
    });
    /*for (var option of document.getElementById('DocStatus').options)
     {
     if (option.selected) {
     
     }
     }*/





    var json = {
        docStatus: selected_DocStatus,
        dept: []
    };
    var fromDate = document.getElementById("fromDate").value;
    var toDate = document.getElementById("toDate").value;
    $.ajax({
        url: "_1_0_0_1_4_Electronic_Invoice_Count_Report_insert_Query_Ajax_1_search_counts_AjaxServlet?"
                + "fromDate=" + fromDate
                + "&toDate=" + toDate
                + "&createdDate_OR_issueDate=createdDate",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(json),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            console.log(JSON.stringify(data));
            $("#" + table_id + " thead").empty();
            var headerHtml = "";
            ///// 1st Header Row
            headerHtml += "  <tr style='background: #131e33;color: white;'>"
                    + "    <td>الإدارات</td>";
            $.each(selected_DocStatus, function (i, item) {
                headerHtml += "      <td colspan='2'>" + item.str + "</td>";
            });
            headerHtml += "      <td colspan='2'>الإجماليات</td>";
            headerHtml += "  </tr>";
            ///// 2nd Header Row
            headerHtml += "  <tr style='background: #337ab7;color: white;'>"
                    + "    <td></td>";
            $.each(selected_DocStatus, function (i, item) {
                headerHtml += "      <td>عدد</td>";
                headerHtml += "      <td>الإجمالي</td>";
            });

            headerHtml += "      <td>إجمالي الأعداد</td>";
            headerHtml += "      <td>إجمالي الفواتير</td>";

            headerHtml += "  </tr>";
            $("#" + table_id + " thead").append(headerHtml);



            ///// table body
            lastRow = [];

            $("#" + table_id + " tbody").empty();
            var html_body = "";
            for (var i = 0; i < data.length; i++) {
                var item = data[i];
                var totalCount = 0;
                var totalSum = 0;
                html_body += "  <tr>";
                html_body += "     <td>" + item.deptName + "</td>";
                $.each(item.dataDetail, function (i, nums) {// حالة المستند
                    html_body += "     <td>" + nums.count + "</td>";
                    html_body += "     <td>" + nums.sum + "</td>";
                    totalCount += (+nums.count);
                    totalSum += (+nums.sum);
                    fillLastRowJSON(+nums.documentStatusId, +nums.count, +nums.sum);
                });
                html_body += "     <td style='background: bisque;'>" + totalCount + "</td>";
                html_body += "     <td style='background: bisque;'>" + totalSum + "</td>";
                html_body += "  </tr>";
            }


            var Last_totalCount = 0;
            var Last_totalSum = 0;
            html_body += "  <tr style='background: bisque;'>";
            html_body += "     <td style='background: #131e33;color: white;'>*الإجماليات</td>";
            for (var i = 0; i < lastRow.length; i++) {//Last Row
                var item = lastRow[i];
                html_body += "     <td>" + item.countTotal + "</td>";
                html_body += "     <td>" + item.sumTotal + "</td>";
                Last_totalCount += (+item.countTotal);
                Last_totalSum += (+item.sumTotal);
            }
            html_body += "     <td>" + Last_totalCount + "</td>";
            html_body += "     <td>" + Last_totalSum + "</td>";
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

            if (+item.documentStatusId === +documentStatusId) {
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

}
