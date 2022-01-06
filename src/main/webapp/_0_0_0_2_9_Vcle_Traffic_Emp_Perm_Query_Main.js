function getMainDash() {
    var year = document.getElementById("year").value;
    document.getElementById("LoadTrafficEmpPermMain_Data").innerHTML = "";
    $.ajax({
        url: "_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_Main_Ajax_6_getMainDash_AjaxServlet?year=" + year + "",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var i = 0;
            var countEmployeeIdInMonthSum = 0;
            var countValInMonthSum = 0.0;
            for (i = 0; i < data.length; i++) {
                html += "<tr>"
                        + "<td class=\"table-font-style\">" + data[i].execMm + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].countEmployeeIdInMonth + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].countValInMonth + "</td>"
                        + "<td>"
                        + "     <button type=\"button\" onclick=\"getValDashByMonth('" + data[i].execMm + "');\" data-toggle=\"modal\" data-target=\".FeaatDetails\" class=\"fa fa-search btn btn-primary\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>"
                        + "</td>"
                        + "</tr>";
                countEmployeeIdInMonthSum += +data[i].countEmployeeIdInMonth;
                countValInMonthSum += +data[i].countValInMonth;
            }
            if (i === 0) {
                document.getElementById("LoadTrafficEmpPermMain_Data").innerHTML =
                        "<tr>"
                        + "    <td colspan='3' class=\"table-font-style\">لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                document.getElementById("LoadTrafficEmpPermMainFoot_Data").innerHTML = "<td class=\"table-font-style\" Style=\"background-color: #131e33;color: white;\">الإجمالي</td>"
                        + "<td><img src=\"webDesign/production/images/Spinner.gif\" alt=\"\" border=1 height=25 width=25></td>"
                        + "<td><img src=\"webDesign/production/images/Spinner.gif\" alt=\"\" border=1 height=25 width=25></td></td>";
                var Foot = "<td class=\"table-font-style\" Style=\"background-color: #131e33;color: white;\">الإجمالي</td>"
                        + "<td class=\"table-font-style\">" + countEmployeeIdInMonthSum + "</td>"
                        + "<td class=\"table-font-style\">" + countValInMonthSum + "</td>"
                setTimeout(() => {
                    document.getElementById("LoadTrafficEmpPermMainFoot_Data").innerHTML = Foot;
                }, 1000);
                document.getElementById("LoadTrafficEmpPermMain_Data").innerHTML = html;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}


function getValDashByMonth(Month) {
    document.getElementById("FeaatDetails_table").innerHTML = "";
    document.getElementById("FeaatDetails_table").innerHTML = "<img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50>";
    $.ajax({
        url: "_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_Main_Ajax_7_getValDashByMonth?Month=" + Month + "",
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var i = 0;
            var countEmployeeIdInMonthSum = 0;
            var countValInMonthSum = 0.0;
            for (i = 0; i < data.length; i++) {
                html += "<tr>"
                        + "<td class=\"table-font-style\">" + data[i].val + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].countEmployeeIdInMonth + "</td>"
                        + "<td class=\"table-font-style\">" + +data[i].val * +data[i].countEmployeeIdInMonth + "</td>"
                        + "<td>"
                        + "     <button type=\"button\" onclick=\"getValDashByMonthVal('" + Month + "','" + data[i].val + "');\" data-toggle=\"modal\" data-target=\".EmpDetailsByVal\" class=\"fa fa-search btn btn-primary\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>"
                        + "</td>"
                        + "</tr>";
                countEmployeeIdInMonthSum += +data[i].countEmployeeIdInMonth;
                countValInMonthSum += +data[i].val * +data[i].countEmployeeIdInMonth;
            }


            document.getElementById("FeaatDetails_MonthTitle").innerHTML = "فئات اشتراكات شهر " + Month;
            if (i === 0) {
                document.getElementById("FeaatDetails_table").innerHTML =
                        "<tr>"
                        + "    <td colspan='3' class=\"table-font-style\">لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                document.getElementById("FeaatDetails_tableFoot").innerHTML = "<td class=\"table-font-style\" Style=\"background-color: #131e33;color: white;\">الإجمالي</td>"
                        + "<td><img src=\"webDesign/production/images/Spinner.gif\" alt=\"\" border=1 height=25 width=25></td>"
                        + "<td><img src=\"webDesign/production/images/Spinner.gif\" alt=\"\" border=1 height=25 width=25></td></td>";
                var Foot = "<td class=\"table-font-style\" Style=\"background-color: #131e33;color: white;\">الإجمالي</td>"
                        + "<td class=\"table-font-style\">" + countEmployeeIdInMonthSum + "</td>"
                        + "<td class=\"table-font-style\">" + countValInMonthSum + "</td>"
                setTimeout(() => {
                    document.getElementById("FeaatDetails_tableFoot").innerHTML = Foot;
                }, 1000);
                document.getElementById("FeaatDetails_table").innerHTML = html;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}
function getValDashByMonthVal(Month, val) {
    document.getElementById("EmpDetails_MonthVal_Data").innerHTML = "";
    document.getElementById("EmpDetails_MonthVal_Data").innerHTML = "<img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50>";
    $.ajax({
        url: "_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_Main_Ajax_8_getValDashByMonth?Month=" + Month + "&val=" + val,
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //a_0_0_5_2_students = JSON.parse(data.toString());
            console.log(data);
            var html = "";
            var i = 0;
            for (i = 0; i < data.length; i++) {
                html += "<tr>"
                        + "<td class=\"table-font-style\">" + data[i].employeeNo + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].employee_name + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].depNoOld + "</td>"
                        + "</tr>";
            }


            document.getElementById("EmpDetails_MonthValTitle").innerHTML = "بيانات الموظفين في فئة " + val + " عن شهر " + Month + " - الإجمالي (<span style='color: yellow;'>" + data.length + "</span>)";
            if (i === 0) {
                document.getElementById("EmpDetails_MonthVal_Data").innerHTML =
                        "<tr>"
                        + "    <td colspan='3' class=\"table-font-style\">لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                document.getElementById("EmpDetails_MonthVal_Data").innerHTML = html;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}
function getLoad() {

    var URL = "_0_0_0_2_9_Vcle_Traffic_Emp_Perm_Query_Ajax_2_getLoad_AjaxServlet?";
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                status = 'f';
                frame(0);
            } else {
                console.log(message);
                frame(message);
            }
        }
    };
}

function dashTableSearch() {  //بحث على مستوى كولم واحد
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("dashTableSearch");
  filter = input.value.toUpperCase();
  table = document.getElementById("EmpDetails_MonthVal_Data");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {      
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}

function searchTable() { //بحث على مستوى الجدول كامل
    var input, filter, found, table, tr, td, i, j;
    input = document.getElementById("dashTableSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("EmpDetails_MonthVal_Data");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td");
        for (j = 0; j < td.length; j++) {
            if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
                found = true;
            }
        }
        if (found) {
            tr[i].style.display = "";
            found = false;
        } else {
            tr[i].style.display = "none";
        }
    }
}

function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("EmpDetails_MonthVal_Table");
  switching = true;
  //Set the sorting direction to ascending:
  dir = "asc"; 
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      /*check if the two rows should switch place,
      based on the direction, asc or desc:*/
      if (dir === "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          //if so, mark as a switch and break the loop:
          shouldSwitch= true;
          break;
        }
      } else if (dir === "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          //if so, mark as a switch and break the loop:
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      //Each time a switch is done, increase this count by 1:
      switchcount ++;      
    } else {
      /*If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again.*/
      if (switchcount === 0 && dir === "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}

function queryLoad() {
    console.log(status);
    if (status === 't') {
        getLoad();
    } else {

    }
}
var old = 0;
var New = 0;
function frame(width) {
    New = width;
    var elem = document.getElementById("load");
    if (width > 100) {
        elem.style.width = 100 + "%";
        elem.innerHTML = 100 + "%";
        clearInterval(id);
    } else {
        elem.style.width = width + "%";
        elem.innerHTML = width + "%";
    }
    old = width;
}

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