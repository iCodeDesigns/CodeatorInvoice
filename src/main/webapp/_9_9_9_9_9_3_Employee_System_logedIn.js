/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

query_sys_online_users();

setInterval(query_sys_online_users, 5000);
var first_load = true;
function query_sys_online_users() {
    var table_id = "sys_online_users_data";
    $.post("_9_9_9_9_9_3_sys_online_users_Ajax_01_query_sys_semester_type_AjaxServlet", {}, function (data) {
        console.log(data);
        data = JSON.parse(data);

        $("#" + table_id + " tbody").empty();
        if (first_load) {
            first_load = false;
        } else {
            $("#" + table_id).DataTable().destroy();
        }
        $("#" + table_id + " tbody").empty();

        $.each(data, function (i, item) {
            var date = new Date(item.birthDate);
            date = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
            $("#" + table_id + " tbody").append(
                    "  <tr>"
                    + "    <td>" + item.employeeId + "</td>"
                    + "    <td>" + item.empAname + "</td>"
                    + "    <td>" + item.perDeptOld.depName + "</td>"
                    + "    <td>" + date + "</td>"
                    + "    <td>" + item.employeeNo + "</td>"
                    + "    <td>" + item.empEname + "</td>"
                    + "</tr>"
                    );

        });

        var table_json = {
            iDisplayLength: 100,
            keys: true,
            paging: true
        };

        var table = $("#" + table_id).DataTable(table_json);
        table.order([4, 'desc']).draw();
    });
}
