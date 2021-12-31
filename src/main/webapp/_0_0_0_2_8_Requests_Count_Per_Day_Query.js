function searchType() {
    resetSearch();
    var searchType = document.getElementById("searchType").value;
    if (searchType === "All") {
        document.getElementById("DateDiv").style.display = "none";
    } else if (searchType === "Date") {
        document.getElementById("DateDiv").style.display = "block";
    } else {
        document.getElementById("DateDiv").style.display = "none";
    }
}

function searchSubmit() {
    var searchType = document.getElementById("searchType").value;
    var check = true;


    var URL = "_0_0_0_2_8_Requests_Count_Per_Day_Query_1__AJAX_RequestCount_AjaxServlet?searchType=" + searchType;
    if (searchType === "Date") {
        var from_date = document.getElementById("from_date").value;
        var to_date = document.getElementById("to_date").value;
        if (from_date === "" || from_date === null) {
            Warning("برجاء اختيار تاريخ بداية البحث");
            check = false;
        } else if (to_date === "" || to_date === null) {
            Warning("برجاء اختيار تاريخ نهاية البحث");
            check = false;
        } else {
            URL += "&from_date=" + from_date;
            URL += "&to_date=" + to_date;
        }
    } else {
        
    }

    if (check) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);
        xhttp.send();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                if (message === "Error") {
                    document.getElementById("RequestCount_Data").innerHTML = ""
                            + "<tr>"
                            + "   <td colspan='3'>لا توجد بيانات</td>"
                            + "</tr>";
                } else {
                    document.getElementById("RequestCount_Data").innerHTML = message;
                }
            }
        };
    }
}

function resetSearch() {
    document.getElementById("RequestCount_Data").innerHTML = "";
    document.getElementById("from_date").value = "";
    document.getElementById("to_date").value = "";
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