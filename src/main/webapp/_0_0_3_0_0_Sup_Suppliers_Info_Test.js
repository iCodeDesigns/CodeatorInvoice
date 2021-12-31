getSupSuppliersInfo();
function getSupSuppliersInfo() {
    console.log("asdasdsadasdasdad");
    var start = document.getElementById("pages").value;
    document.getElementById("SupSuppliersInfo").innerHTML =
            "<tr>"
            + "    <td colspan='12'><img src=\"webDesign/production/images/Spin-0.9s-200px.gif\" alt=\"\" border=1 height=50 width=50></td>"
            + "</tr>";
    $.ajax({
        url: "_0_0_3_0_0_Sup_Suppliers_Info_Test_Ajax_1_getAllSuppliersInfoTest_AjaxServlet?start=" + start,
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            console.log(data);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            var html = "";
            var i = 0;
            for (i = 0; i < data.length; i++) {
                html += "<tr>"
                        + "<td class=\"table-font-style\">" + data[i].supplierId + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].supplierName + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].commercialRegister + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].taxRegister + "</td>"
                        //+ "<td class=\"table-font-style\">" + data[i].ownerFirstName + " " + data[i].ownerMiddleName + " " + data[i].ownerLastName + "</td>"
                        //+ "<td class=\"table-font-style\">" + data[i].fax + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].supplierStatus + "</td>"
                        //+ "<td class=\"table-font-style\">" + data[i].telephone1 + "-" + data[i].telephone2 + "</td>"
                        //+ "<td class=\"table-font-style\">" + data[i].address + "</td>"
                        //+ "<td class=\"table-font-style\">" + data[i].email + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].supplierType + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].salesTaxNo + "</td>"
                        + "<td class=\"table-font-style\">" + data[i].rankStar + "</td>";
                if (data[i].supplierOffers === "" || data[i].supplierOffers === null) {
                    html += "<td class=\"table-font-style\">0%</td>";
                } else {
                    html += "<td class=\"table-font-style\">" + data[i].rankPercent + "</td>";
                }
                if (data[i].supplierOffers === "لا يوجد ملف عرض للمورد") {
                    html += "<td class=\"table-font-style\"></td>";
                } else {
                    html += "<td class=\"table-font-style\">" + data[i].supplierOffers + "</td>";
                }
                //+ "<td class=\"table-font-style\"margin-left: 4px;margin-right:  4px;margin-top  : 4px;margin-bottom:  4px;padding:4px;width: 100%;height: 1px;overflow-x: hidden;overflow-y: auto;text-align:justify;\">" + data[i].activities + "</td>"
                html += "<td>"
                        + "     <button type=\"button\" onclick=\"getSupplierInfo('" + data[i].supplierId + "','" + data[i].supplierName + "','" + data[i].ownerFirstName + " " + data[i].ownerMiddleName + " " + data[i].ownerLastName + "','" + data[i].fax + "','" + data[i].telephone1 + "-" + data[i].telephone2 + "','" + data[i].address + "','" + data[i].email + "','" + data[i].activities + "');\" data-toggle=\"modal\" data-target=\".getSupplierInfoModel\" class=\"fa fa-user btn btn-success\" style=\"font-size: large;border: 2px solid white;\"></button>"
                        + "</td>"
                        + "<td>"
                        + "     <button type=\"button\" onclick=\"getAllCateCodeGroups('" + data[i].supplierId + "');\" data-toggle=\"modal\" data-target=\".AllCateCodeGroupsModel\" class=\"fa fa-search btn btn-primary\" style=\"font-size: large;font-weight: bold;border: 2px solid white;\"></button>"
                        + "</td>"
                        + "</tr>";

            }
            if (i === 0) {
                document.getElementById("SupSuppliersInfo").innerHTML =
                        "<tr>"
                        + "    <td colspan='13'>لا توجد بيانات</td>"
                        + "</tr>";
            } else {
                document.getElementById("SupSuppliersInfo").innerHTML = html;
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function getSupplierInfo(supplierId, supplierName, ownerFullName, fax, telephones, address, email, activities) {
    document.getElementById("getSupplierInfoTitle").innerHTML = "";
    document.getElementById("SuppFullName").innerHTML = "";
    document.getElementById("Fax").innerHTML = "";
    document.getElementById("Telephones").innerHTML = "";
    document.getElementById("Address").innerHTML = "";
    document.getElementById("Email").innerHTML = "";
    document.getElementById("activities").innerHTML = "";

    document.getElementById("getSupplierInfoTitle").innerHTML = supplierId + " - " + supplierName;
    document.getElementById("SuppFullName").innerHTML = ownerFullName;
    document.getElementById("Fax").innerHTML = fax;
    document.getElementById("Telephones").innerHTML = telephones;
    document.getElementById("Address").innerHTML = address;
    document.getElementById("Email").innerHTML = email;

    var activitiesContents = activities;
    var activitiesSplit = activitiesContents.replaceAll("-", "</td></tr><tr><td>");
    //alert(activitiesSplit);
    document.getElementById("activities").innerHTML = "<tr><td>" + activitiesSplit + "</td></tr>";
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
        //data: JSON.stringify(),
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