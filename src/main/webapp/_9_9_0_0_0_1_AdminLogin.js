/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('keypress', function (e) {
    if (e.keyCode === 13) {
        login();
    }
}, false);


function login() {
    var username = document.getElementById("username").value;//ID
    var password = document.getElementById("password").value;//Birthdate

    if (username === "" || username === null) {
        Warning("برجاء إدخال  اسم المستخدم");
        document.getElementById('username').style.borderColor = "red";
    } else if (password === "" || password === null) {
        Warning("برجاء إدخال  كلمة المرور");
        document.getElementById('password').style.borderColor = "red";
        document.getElementById('username').style.borderColor = "#737373";
    } else {
        var URL = "LoginDevelopAjaxServlet?username=" + username + "&password=" + password;

        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", URL, true);

        xhttp.send();

        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                var message = xhttp.responseText;
                //==SUCCESS IS A ALERT VAR WHICH DECLARED IN THE END OF CODE==============
                if (message !== "Success") {
                    // Error Action to Current Page.
                    Warning(message);
                } else {
                    window.location = 'LoginDevelopControlServlet?username=' + username + "&password=" + password;
                }
            }
        };
    }
}


function Success(Body) {
    new PNotify({
        title: "تمت",
        text: Body,
        type: 'success',
        styling: 'bootstrap3'
    });
}
function Error(Body) {
    new PNotify({
        title: "خطأ",
        text: Body,
        type: 'error',
        styling: 'bootstrap3'
    });
}
function Warning(Body) {
    new PNotify({
        title: "تحذير",
        text: Body,
        styling: 'bootstrap3'
    });
}
