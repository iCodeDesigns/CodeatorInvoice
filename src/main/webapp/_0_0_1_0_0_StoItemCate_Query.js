getAllCateCodeDoors();
function getAllCateCodeDoors() {    
    $.ajax({
        url: "_0_0_1_0_0_StoItemCate_Query_Ajax_1_getAllCateCodeDoors_AjaxServlet?",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var i = 0;
            var AllcateCodeEmpTotal = 0;
            var AllcateCodeDeptTotal = 0;
            var AllcateCodeTotal = 0;
            for (i = 0; i < data.length; i++) {
                if (data[i].cateCodeTotal === "0" && data[i].cateCodeDeptTotal === "0") {
                } else {
                    html += "<tr>"
                            + "<td class=\"table-font-style\">" + data[i].cateCode + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].cateName + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].cateCodeTotal + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].cateCodeDeptTotal + "</td>"
                            + "<td class=\"table-font-style\">" + (parseInt(data[i].cateCodeDeptTotal) + parseInt(data[i].cateCodeTotal)) + "</td>"
                            + "<td>"
                            + "     <button type=\"button\" onclick=\"getAllCateCodeGroups('" + data[i].cateCode + "');\" data-toggle=\"modal\" data-target=\".AllCateCodeGroupsModel\" class=\"fa fa-search btn btn-primary\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>"
                            + "</td>"
                            + "</tr>";
                    AllcateCodeEmpTotal = parseInt(AllcateCodeEmpTotal) + parseInt(data[i].cateCodeTotal);
                    AllcateCodeDeptTotal = parseInt(AllcateCodeDeptTotal) + parseInt(data[i].cateCodeDeptTotal);
                    AllcateCodeTotal = parseInt(AllcateCodeDeptTotal) + parseInt(AllcateCodeEmpTotal);
                }
            }
            if (i === 0) {
                document.getElementById("AllCateCodeDoors").innerHTML =
                        "<tr>"
                        + "    <td colspan='7'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                document.getElementById("AllCateCodeDoors").innerHTML = html;
                document.getElementById("TotalDoorsEmp").innerHTML = AllcateCodeEmpTotal;
                document.getElementById("TotalDoorsDept").innerHTML = AllcateCodeDeptTotal;
                document.getElementById("TotalDoorsAll").innerHTML = AllcateCodeTotal;

                document.getElementById("TotalDoorsEmp1").innerHTML = AllcateCodeEmpTotal;
                document.getElementById("TotalDoorsDept1").innerHTML = AllcateCodeDeptTotal;
                document.getElementById("TotalDoorsAll1").innerHTML = AllcateCodeTotal;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function getAllCateCodeGroups(cateCode) {
    document.getElementById("AllCateCodeGroups").innerHTML = "";
    document.getElementById("AllCateCodeGroupsModelTitle").innerHTML = "";
    document.getElementById("TotalGroupsEmp").innerHTML = "";
    document.getElementById("TotalGroupsDept").innerHTML = "";
    document.getElementById("TotalGroupsAll").innerHTML = "";

    document.getElementById("TotalGroupsEmp1").innerHTML = "";
    document.getElementById("TotalGroupsDept1").innerHTML = "";
    document.getElementById("TotalGroupsAll1").innerHTML = "";
    $.ajax({
        url: "_0_0_1_0_0_StoItemCate_Query_Ajax_2_getAllCateCodeGroups_AjaxServlet?cateCode=" + cateCode + "",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var title = "";
            var i = 0;
            var AllgroupCodeEmpTotal = 0;
            var AllgroupCodeDeptTotal = 0;
            var AllgroupCodeTotal = 0;
            for (i = 0; i < data.length; i++) {
                title = data[i].cateCode + "-" + data[i].cateName;
                if (data[i].groupCodeTotal === "0" && data[i].groupCodeDeptTotal === "0") {
                } else {
                    html += "<tr>"
                            + "<td class=\"table-font-style\">" + data[i].groupCode + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].groupName + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].groupCodeTotal + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].groupCodeDeptTotal + "</td>"
                            + "<td class=\"table-font-style\">" + (parseInt(data[i].groupCodeDeptTotal) + parseInt(data[i].groupCodeTotal)) + "</td>"
                            + "<td>"
                            + "     <button type=\"button\" onclick=\"getAllCateCodeSections('" + data[i].cateCode + "','" + data[i].groupCode + "');\" data-toggle=\"modal\" data-target=\".AllCateCodeSectionsModel\" class=\"fa fa-search btn btn-primary\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>"
                            + "</td>"
                            + "</tr>";
                    AllgroupCodeEmpTotal = parseInt(AllgroupCodeEmpTotal) + parseInt(data[i].groupCodeTotal);
                    AllgroupCodeDeptTotal = parseInt(AllgroupCodeDeptTotal) + parseInt(data[i].groupCodeDeptTotal);
                    AllgroupCodeTotal = parseInt(AllgroupCodeDeptTotal) + parseInt(AllgroupCodeEmpTotal);
                }
            }
            if (i === 0) {
                document.getElementById("AllCateCodeGroups").innerHTML =
                        "<tr>"
                        + "    <td colspan='7'>لا توجد بيانات</td>"
                        + "</tr>";
                document.getElementById("AllCateCodeGroupsModelTitle").innerHTML = title;
            } else {
                document.getElementById("AllCateCodeGroups").innerHTML = html;
                document.getElementById("AllCateCodeGroupsModelTitle").innerHTML = title;

                document.getElementById("TotalGroupsEmp").innerHTML = AllgroupCodeEmpTotal;
                document.getElementById("TotalGroupsDept").innerHTML = AllgroupCodeDeptTotal;
                document.getElementById("TotalGroupsAll").innerHTML = AllgroupCodeTotal;

                document.getElementById("TotalGroupsEmp1").innerHTML = AllgroupCodeEmpTotal;
                document.getElementById("TotalGroupsDept1").innerHTML = AllgroupCodeDeptTotal;
                document.getElementById("TotalGroupsAll1").innerHTML = AllgroupCodeTotal;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function getAllCateCodeSections(cateCode, groupCode) {
    document.getElementById("AllCateCodeSections").innerHTML = "";
    document.getElementById("AllCateCodeSectionsModelTitle").innerHTML = "";
    document.getElementById("TotalSectionsEmp").innerHTML = "";
    document.getElementById("TotalSectionsDept").innerHTML = "";
    document.getElementById("TotalSectionsAll").innerHTML = "";

    document.getElementById("TotalSectionsEmp1").innerHTML = "";
    document.getElementById("TotalSectionsDept1").innerHTML = "";
    document.getElementById("TotalSectionsAll1").innerHTML = "";


    $.ajax({
        url: "_0_0_1_0_0_StoItemCate_Query_Ajax_3_getAllCateCodeSections_AjaxServlet?cateCode=" + cateCode + "&groupCode=" + groupCode + "",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var title = "";
            var i = 0;
            var AllSectionCodeEmpTotal = 0;
            var AllSectionCodeDeptTotal = 0;
            var AllSectionCodeTotal = 0;
            for (i = 0; i < data.length; i++) {
                title = data[i].cateCode + "-" + data[i].cateName + " <span class='fa fa-arrow-left'></span> " + data[i].groupCode + "-" + data[i].groupName;
                if (data[i].sectionCodeTotal === "0" && data[i].sectionCodeDeptTotal === "0") {
                } else {
                    html += "<tr>"
                            + "<td class=\"table-font-style\">" + data[i].sectionCode + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].sectionName + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].sectionCodeTotal + "</td>"
                            + "<td class=\"table-font-style\">" + data[i].sectionCodeDeptTotal + "</td>"
                            + "<td class=\"table-font-style\">" + (parseInt(data[i].sectionCodeDeptTotal) + parseInt(data[i].sectionCodeTotal)) + "</td>"
                            /*+ "<td>"
                             + "     <button type=\"button\" onclick=\"\" data-toggle=\"modal\" data-target=\".ElDetail\" class=\"fa fa-search btn btn-primary\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>"
                             + "</td>"*/
                            + "</tr>";
                    AllSectionCodeEmpTotal = parseInt(AllSectionCodeEmpTotal) + parseInt(data[i].sectionCodeTotal);
                    AllSectionCodeDeptTotal = parseInt(AllSectionCodeDeptTotal) + parseInt(data[i].sectionCodeDeptTotal);
                    AllSectionCodeTotal = parseInt(AllSectionCodeDeptTotal) + parseInt(AllSectionCodeEmpTotal);
                }
            }
            if (i === 0) {
                document.getElementById("AllCateCodeSections").innerHTML =
                        "<tr>"
                        + "    <td colspan='7'>لا توجد بيانات</td>"
                        + "</tr>";
                document.getElementById("AllCateCodeSectionsModelTitle").innerHTML = title;
            } else {
                document.getElementById("AllCateCodeSections").innerHTML = html;
                document.getElementById("AllCateCodeSectionsModelTitle").innerHTML = title;

                document.getElementById("TotalSectionsEmp").innerHTML = AllSectionCodeEmpTotal;
                document.getElementById("TotalSectionsDept").innerHTML = AllSectionCodeDeptTotal;
                document.getElementById("TotalSectionsAll").innerHTML = AllSectionCodeTotal;

                document.getElementById("TotalSectionsEmp1").innerHTML = AllSectionCodeEmpTotal;
                document.getElementById("TotalSectionsDept1").innerHTML = AllSectionCodeDeptTotal;
                document.getElementById("TotalSectionsAll1").innerHTML = AllSectionCodeTotal;

            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
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