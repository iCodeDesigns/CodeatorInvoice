/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
getItems();
function getItems() {
    document.getElementById("Inv_Item_Code_Query_Table").innerHTML =
            "<tr>"
            + "    <td colspan='7'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    $.ajax({
        url: "_1_0_0_0_5_Inv_Item_Code_Query_Ajax_1_getAllItems_AjaxServlet?",
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //console.log(data);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var i = 0;
            for (i = 0; i < data.length; i++) {
                html += "<tr>"
                        + "<td class=\"table-font-style\">" + data[i].internalCode + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].lineNumber + "</td>"
                        //+ "<td class=\"table-font-style\">" + data[i].itemEname + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].itemCode + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].itemType + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].description + "</td>"
                        + "</tr>";

            }
            if (i === 0) {
                document.getElementById("Inv_Item_Code_Query_Table").innerHTML =
                        "<tr>"
                        + "    <td colspan='7'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                document.getElementById("Inv_Item_Code_Query_Table").innerHTML = html;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}


function TableSearch() {
  var input, filter, found, table, tr, td, i, j;
    input = document.getElementById("TableSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("Inv_Item_Code_Query_Table");
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
  table = document.getElementById("ItemaTable");
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