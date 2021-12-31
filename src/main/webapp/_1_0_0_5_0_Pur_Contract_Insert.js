/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addNewTitle() {
    addNewTitle_bool = true;
    document.getElementById("title_idDiv").style.display = "none";
    document.getElementById("title_textDiv").style.display = "block";

    document.getElementById("title_id").value = "";
    document.getElementById("title_text").value = "";
}

function chooseTitle() {
    addNewTitle_bool = false;
    document.getElementById("title_idDiv").style.display = "block";
    document.getElementById("title_textDiv").style.display = "none";

    document.getElementById("title_id").value = "";
    document.getElementById("title_text").value = "";
}

function add_months(dt, n)
{
    var d = dt.getDate();
    dt.setMonth(dt.getMonth() + (+n + 1));
    if (dt.getDate() !== d) {
        dt.setDate(0);
    }
    return dt;
}

checkContractPeriod();
function checkContractPeriod() {
    contract_dtl_table = [];//-----> JSON
    var contracts_dtl = document.getElementById("contracts_dtl");
    contracts_dtl.innerHTML = "";
    document.getElementById("2qsatCard").style.display = "none";

    var no_of_years = document.getElementById("no_of_years");
    var no_of_month = document.getElementById("no_of_month");
    var no_of_years_int = +no_of_years.value;
    var no_of_month_int = +no_of_month.value;

    if (no_of_years.value === "") {
        no_of_years.value = 0;
    }
    if (no_of_month.value === "") {
        if (no_of_years_int > 0) {
            no_of_month.value = 0;
        } else {
            no_of_month.value = 1;
        }
    }


    var number_of_years_from_month = Math.floor(no_of_month_int / 12);
    var month_remainder = no_of_month_int % 12;
    if (no_of_month_int > 11) {
        no_of_years_int += number_of_years_from_month;
        no_of_month_int = month_remainder;

        no_of_years.value = no_of_years_int;
        no_of_month.value = no_of_month_int;
    }

    var total_no_of_month = no_of_month_int + (no_of_years_int * 12);
    var periodType = document.getElementById("periodType");

    var split = (total_no_of_month < 12) ? "1" : "*";

    periodType.innerHTML = "<option value=''>اختر طريقة الأقساط ...</option>";
    for (var i = 0; i < periodType_Arr.length; i++) {
        if (split === "*") {
            periodType.innerHTML += "<option class=\"font-style\" value=\"" + periodType_Arr[i].periodType + "," + periodType_Arr[i].periodVal + "," + periodType_Arr[i].periodValAlert + "\">" + periodType_Arr[i].periodName + "</option>";
        } else {
            if (periodType_Arr[i].periodValSplit === split) {
                periodType.innerHTML += "<option class=\"font-style\" value=\"" + periodType_Arr[i].periodType + "," + periodType_Arr[i].periodVal + "," + periodType_Arr[i].periodValAlert + "\">" + periodType_Arr[i].periodName + "</option>";
                break;
            }
        }
    }

}


function calcContract_dtl() {
    contract_dtl_table = [];//-----> JSON

    var no_of_years = document.getElementById("no_of_years");
    var no_of_month = document.getElementById("no_of_month");
    var no_of_years_int = +no_of_years.value;
    var no_of_month_int = +no_of_month.value;
    var total_no_of_month = no_of_month_int + (no_of_years_int * 12); // من الشاشة
    var total_no_of_month_temp = total_no_of_month;

    var contractValue = document.getElementById("contractValue").value;
    var contractValue_temp = contractValue;

    var periodType = document.getElementById("periodType").value;
    var periodType_periodVal = periodType.split(",")[1];

    var contractFromDate = document.getElementById("contractFromDate").value;

    var contracts_dtl = document.getElementById("contracts_dtl");
    contracts_dtl.innerHTML = "";
    document.getElementById("2qsatCard").style.display = "none";

    if (no_of_years.value === "") {
        Warning("برجاء ملئ عدد سنوات المدة");
        return;
    } else if (no_of_month.value === "") {
        Warning("برجاء ملئ عدد شهور المدة");
        return;
    } else if (contractValue === "") {
        Warning("برجاء ملئ قيمة العقد");
        return;
    } else if (contractFromDate === "") {
        Warning("برجاء اختيار تاريح بدء العقد");
        return;
    } else if (periodType === "" || periodType === null) {
        Warning("برجاء اختيار الأقساط");
        return;
    }

    /*if (contractValue.split(".").length > 1) {
     if (contractValue.split(".")[1].length > 3) {
     Warning("قيمة الكسر لا تتجاوز الثلاث أرقام عشرية قس قسمة العقد");
     return;
     }
     }*/
    // حسابات المبالغ

    var no_of_parts = Math.floor(total_no_of_month / periodType_periodVal);
    var no_of_parts_reminder = total_no_of_month % periodType_periodVal;
    //var total_parts = (no_of_parts_reminder > 0) ? (no_of_parts + 1) : no_of_parts;
    var contractValue_dtl = /*Math.floor*/(+contractValue / total_no_of_month);//سعر الشهر الواحد
    var kemet_el2st = (+periodType_periodVal * +contractValue_dtl).toFixed(0);// سعر القسط الواحد
    kemet_el2st = +kemet_el2st;
    var upper_parts = 0.0;// مجموع الأقساط المتساوية ماعدا اخر صف



    // حسابات تواريخ الأقساط
    //contractFromDate
    //1- حساب تاريخ النهاية
    var end_date_plus_1 = add_months(new Date(contractFromDate), total_no_of_month);

    var end_date = new Date(getNewDateSub(end_date_plus_1, 1)); // بنخصم يوم واحد
    var month = (+end_date.getMonth() + 1 > 9) ? (+end_date.getMonth() + 1) : "0" + (+end_date.getMonth() + 1);
    var day = (end_date.getDate() > 9) ? end_date.getDate() : "0" + end_date.getDate();

    var end_date_str = end_date.getFullYear() + "-" + month + "-" + day;

    document.getElementById("contractToDate").value = end_date_str;
    getAlertDate();//--calculate Alert Date After calc contractToDate

    var contractFromDate_temp = contractFromDate;
    var end_date_str_temp = "";
    var i = 0;
    for (i = 0; i < no_of_parts; i++) {
        //-- from
        //if (i < no_of_parts - 1) {
        var end_date_str_plus_1_temp = contractFromDate_temp;


        var end_date_plus_1_temp = add_months(new Date(contractFromDate_temp), +periodType_periodVal - 1);
        var end_date_temp = new Date(getNewDateSub(end_date_plus_1_temp, 1)); // بنخصم يوم واحد        

        //** To
        var month_temp = (+end_date_temp.getMonth() + 1 > 9) ? (+end_date_temp.getMonth() + 1) : "0" + (+end_date_temp.getMonth() + 1);
        var day_temp = (end_date_temp.getDate() > 9) ? end_date_temp.getDate() : "0" + end_date_temp.getDate();
        end_date_str_temp = end_date_temp.getFullYear() + "-" + month_temp + "-" + day_temp;

        contractValue_temp -= kemet_el2st;
        upper_parts += kemet_el2st;

        var remaining_contractValue = (+contractValue - upper_parts);


        if (remaining_contractValue !== 0 && i === no_of_parts - 1 && no_of_parts_reminder === 0) {
            kemet_el2st = +kemet_el2st + +remaining_contractValue;
            kemet_el2st = +kemet_el2st;
        }
        contracts_dtl.innerHTML += ""
                + "<tr>"
                + "    <td>" + (i + 1) + "</td>"
                + "    <td>" + end_date_str_plus_1_temp + "</td>"
                + "    <td>" + end_date_str_temp + "</td>"
                + "    <td>" + kemet_el2st + "</td>"
                //+ "    <td></td>"
                + "</tr>";


        //------------------------------------
        //-- Make JSON
        var contract_dtl = new Object();
        contract_dtl.conValue = +kemet_el2st;
        contract_dtl.conFromDate = end_date_str_plus_1_temp;
        contract_dtl.conToDate = end_date_str_temp;
        contract_dtl_table.push(contract_dtl);
        //------------------------------------

        contractFromDate_temp = getNewDateAdd(end_date_str_temp, 1);
        total_no_of_month_temp -= periodType_periodVal;
        /*} else {
         var last_contractValue = (+contractValue - upper_parts);
         //-- from
         var end_date_str_plus_1_temp = contractFromDate_temp;
         
         var end_date_plus_1_temp = add_months(new Date(contractFromDate_temp), total_no_of_month_temp);
         var end_date_temp = new Date(getNewDateSub(end_date_plus_1_temp, 1)); // بنخصم يوم واحد
         
         //** To
         var month_temp = (+end_date_temp.getMonth() + 1 > 9) ? (+end_date_temp.getMonth() + 1) : "0" + (+end_date_temp.getMonth() + 1);
         var day_temp = (end_date_temp.getDate() > 9) ? end_date_temp.getDate() : "0" + end_date_temp.getDate();
         end_date_str_temp = end_date_temp.getFullYear() + "-" + month_temp + "-" + day_temp;
         
         contracts_dtl.innerHTML += ""
         + "<tr>"
         + "    <td>" + (i + 1) + "</td>"
         + "    <td>" + end_date_str_plus_1_temp + "</td>"
         + "    <td>" + end_date_str_temp + "</td>"
         + "    <td>" + last_contractValue + "</td>"
         //+ "    <td></td>"
         + "</tr>";
         contracts_dtl.innerHTML += ""
         + "<tr style='background-color: #405467;color:white;'>"
         + "    <td colspan='3'>الإجمالي</td>"
         + "    <td>" + contractValue + "</td>"
         + "</tr>";
         
         //------------------------------------
         //-- Make JSON
         var contract_dtl = new Object();
         contract_dtl.conValue = +last_contractValue;
         contract_dtl.conFromDate = end_date_str_plus_1_temp;
         contract_dtl.conToDate = end_date_str_temp;
         contract_dtl_table.push(contract_dtl);
         //------------------------------------
         }*/

    }

    // اخر قسط
    // اخر قسط
    var last_contractValue = (+contractValue - upper_parts).toFixed(0);
    if (no_of_parts_reminder > 0) {
        //-- from
        var end_date_str_plus_1_temp = contractFromDate_temp;

        var end_date_plus_1_temp = add_months(new Date(contractFromDate_temp), total_no_of_month_temp);
        var end_date_temp = new Date(getNewDateSub(end_date_plus_1_temp, 1)); // بنخصم يوم واحد

        //** To
        var month_temp = (+end_date_temp.getMonth() + 1 > 9) ? (+end_date_temp.getMonth() + 1) : "0" + (+end_date_temp.getMonth() + 1);
        var day_temp = (end_date_temp.getDate() > 9) ? end_date_temp.getDate() : "0" + end_date_temp.getDate();
        end_date_str_temp = end_date_temp.getFullYear() + "-" + month_temp + "-" + day_temp;

        contracts_dtl.innerHTML += ""
                + "<tr>"
                + "    <td>" + (i + 1) + "</td>"
                + "    <td>" + end_date_str_plus_1_temp + "</td>"
                + "    <td>" + end_date_str_temp + "</td>"
                + "    <td>" + last_contractValue + "</td>"
                //+ "    <td></td>"
                + "</tr>";

        //------------------------------------
        //-- Make JSON
        var contract_dtl = new Object();
        contract_dtl.conValue = +last_contractValue;
        contract_dtl.conFromDate = end_date_str_plus_1_temp;
        contract_dtl.conToDate = end_date_str_temp;
        contract_dtl_table.push(contract_dtl);
        //------------------------------------
    }
    contracts_dtl.innerHTML += ""
            + "<tr style='background-color: #405467;color:white;'>"
            + "    <td colspan='3'>الإجمالي</td>"
            + "    <td>" + contractValue + "</td>"
            + "</tr>";

    document.getElementById("2qsatCard").style.display = "block";
}

function addContract(transaction_type) {
    var validationContract = RunContractValidation(transaction_type);

    if (validationContract) {

        var title_id = document.getElementById("title_id").value;
        var title_text = document.getElementById("title_text").value;
        //addNewTitle_bool

        var selected_service_seq = [];
        for (var option of document.getElementById('service_seq').options)
        {
            if (option.selected) {
                selected_service_seq.push(option.value);
            }
        }

        var contractDate = document.getElementById("contractDate").value;
        var contractValue = document.getElementById("contractValue").value;
        var contractTax = document.getElementById("contractTax").value;
        var paymentKind = document.getElementById("paymentKind").value;
        var periodType = document.getElementById("periodType").value;
        var contractFromDate = document.getElementById("contractFromDate").value;
        var contractToDate = document.getElementById("contractToDate").value;
        var alertDate = document.getElementById("alertDate").value;
        var rmrk = document.getElementById("rmrk").value;

        var no_of_years = document.getElementById("no_of_years");
        var no_of_month = document.getElementById("no_of_month");
        var no_of_years_int = +no_of_years.value;
        var no_of_month_int = +no_of_month.value;
        var total_no_of_month = no_of_month_int + (no_of_years_int * 12); // من الشاشة

        //- نعمل حساب المتعامل 
        // JSON --> receiverData_selected
        //- نعمل حساب الجدول 
        // JSON --> contract_dtl_table

        var contract = new Object();
        contract.titleId = title_id.split(",")[0];
        contract.titleText = title_text;
        contract.addNewTitle = addNewTitle_bool;

        contract.serviceSeq = selected_service_seq;
        contract.contractDate = contractDate;
        contract.contractValue = contractValue;
        contract.contractFromDate = contractFromDate;
        contract.contractToDate = contractToDate;
        contract.contractTax = contractTax;
        contract.periodType = periodType.split(",")[0];
        contract.paymentKind = paymentKind;
        contract.contractAlertDate = alertDate;
        contract.periodVal = total_no_of_month;
        contract.rmrk = rmrk;
        contract.purContractMasterDtl = contract_dtl_table;// -- []
        contract.receiver = receiverData_selected;// -- []

        var sub_url = "";
        if (transaction_type === "edit") {
            sub_url = "&contractSp=" + ContractSp_Global
                    + "&titleId=" + TitleId_Global.split(",")[0];
        }

        console.log(JSON.stringify(contract));
        $.ajax({

            url: "_1_0_0_5_0_Pur_Contract_Insert_01_saveContract_AjaxServlet?deptId=" + deptId + "&sectionId=" + sectionId + "&transaction_type=" + transaction_type + sub_url + "&accUnitId=" + accUnitId,
            type: 'POST',
            //dataType: 'json',
            data: JSON.stringify(contract),
            //contentType: 'application/json',
            // mimeType: 'application/json',
            success: function (data) {
                //console.log(data);
                //a_0_0_5_2_students = JSON.parse(data.toString());
                if (data === "Success") {
                    Success("تم حفظ العقد");
                    resetPage();
                } else {
                    Warning(data);
                }
            },
            error: function (xhr, status) {
                Error("حدث خطأ");
            }
        });
    }
}
function resetPage() {
    ContractSp_Global = "";
    TitleId_Global = "";
    contract_dtl_table = [];

    receiverData_array = [];
    receiverData_selected = null;
    document.getElementById("receivername").value = "";
    document.getElementById("receivername_select").innerHTML = "";
    document.getElementById("id").value = "";
    document.getElementById("contracts_search_result").innerHTML = "";
    document.getElementById("contracts_dtl").innerHTML = "";
    document.getElementById("2qsatCard").style.display = "none";

    document.getElementById("contractDate").value = sysDate;
    document.getElementById("contractValue").value = "";
    document.getElementById("contractTax").value = "1";

    document.getElementById("no_of_month").value = "";
    document.getElementById("no_of_years").value = "";

    document.getElementById("contractFromDate").value = "";
    document.getElementById("contractToDate").value = "";

    document.getElementById("paymentKind").value = "";
    document.getElementById("alertDate").value = "";
    document.getElementById("rmrk").value = "";

    document.getElementById("title_id").value = "";
    document.getElementById("title_text").value = "";
    chooseTitle();
    clearSelected();

    getAllDeptTitles();
}

getAllDeptTitles();
function getAllDeptTitles() {
    $.ajax({

        url: "_1_0_0_5_0_Pur_Contract_Insert_03_getDeptTitles_AjaxServlet?deptId=" + deptId + "&sectionId=" + sectionId + "&accUnitId=" + accUnitId,
        type: 'POST',
        dataType: 'json',
        //data: JSON.stringify(contract),
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data1) {
            //console.log(data1);
            //a_0_0_5_2_students = JSON.parse(data.toString());
            if (data1.length > 0) {
                var title_id = document.getElementById("title_id");
                title_id.innerHTML = "<option class='font-style' value=''>أختر العنوان...</option>";

                for (var j = 0; j < data1.length; j++) {
                    title_id.innerHTML += "<option class='font-style' value='" + data1[j].titleId + "," + data1[j].sectionNoOld + "," + data1[j].deptNoOld + "," + data1[j].accUnitId + "'>" + data1[j].titleText + "</option>";
                }
            }

        },
        error: function (xhr, status) {
            Error("حدث خطأ");
        }
    });
}

function getdate(my_date, days, op) {

    var tt = my_date;

    var date = new Date(tt);
    var newdate = new Date(date);

    if (op === "+") {
        newdate.setDate(newdate.getDate() + days);
    } else if (op === "-") {
        newdate.setDate(newdate.getDate() - days);
    }


    var dd = newdate.getDate();
    var mm = newdate.getMonth() + 1;
    var y = newdate.getFullYear();

    var someFormattedDate = y + '-' + mm + '-' + dd;
    return someFormattedDate;
}




function ss() {
    var start_of_interval = new Date("2021-02-01");
    var days = 35;
    var date = getdate(start_of_interval, days - 1);
    alert(date);
}

function getNewDateAdd(date_str, no_of_days) {
    var start_of_interval = new Date(date_str.toString());
    var days = +no_of_days;
    var new_date = getdate(start_of_interval, days, "+").toString();
    var month = (new_date.split("-")[1].toString().length === 2) ? new_date.split("-")[1].toString() : "0" + new_date.split("-")[1].toString();
    var day = (new_date.split("-")[2].toString().length === 2) ? new_date.split("-")[2].toString() : "0" + new_date.split("-")[2].toString();
    var EndContract = new_date.split("-")[0].toString() + "-" + month + "-" + day;
    return  EndContract;
}

function getNewDateSub(date_str, no_of_days) {
    var start_of_interval = new Date(date_str.toString());
    var days = +no_of_days;
    var new_date = getdate(start_of_interval, days, "-").toString();
    var month = (new_date.split("-")[1].toString().length === 2) ? new_date.split("-")[1].toString() : "0" + new_date.split("-")[1].toString();
    var day = (new_date.split("-")[2].toString().length === 2) ? new_date.split("-")[2].toString() : "0" + new_date.split("-")[2].toString();
    var EndContract = new_date.split("-")[0].toString() + "-" + month + "-" + day;
    return  EndContract;
}

function getAlertDate() {
    var periodValueAlert = document.getElementById("periodType").value.split(",")[2];
    var EndContract = document.getElementById("contractToDate").value;

    var Alert = getNewDateSub(EndContract, periodValueAlert);
    document.getElementById("alertDate").value = Alert;
}



function changeSequance() {
    var transaction_type = document.getElementById("transaction_type").value;
    var searchBtnDiv = document.getElementById("searchBtnDiv");
    var addBtnDiv = document.getElementById("addBtnDiv");
    var editBtnDiv = document.getElementById("editBtnDiv");
    if (transaction_type === "add") {
        searchBtnDiv.style.display = "none";
        addBtnDiv.style.display = "block";
        editBtnDiv.style.display = "none";
    } else {
        searchBtnDiv.style.display = "block";
        addBtnDiv.style.display = "none";
        editBtnDiv.style.display = "block";
    }
    resetPage()
    document.getElementById("2qsatCard").style.display = "none";
}

var all_contracts_data = [];
function searchContracts() {
    /*
     var contract = new Object();
     contract.serviceSeq = serviceSeq;
     contract.contractDate = contractDate;
     contract.contractValue = contractValue;
     contract.contractFromDate = contractFromDate;
     contract.contractToDate = contractToDate;
     contract.contractTax = contractTax;
     contract.periodType = periodType.split(",")[0];
     contract.paymentKind = paymentKind;
     contract.contractAlertDate = alertDate;
     contract.rmrk = rmrk;
     contract.purContractMasterDtl = contract_dtl_table;// -- []
     contract.receiver = receiverData_selected;// -- []
     
     
     var contract_dtl = new Object();
     contract_dtl.conValue = +last_contractValue;
     contract_dtl.conFromDate = end_date_str_plus_1_temp;
     contract_dtl.conToDate = end_date_str_temp;
     contract_dtl_table.push(contract_dtl);
     
     */

    //deptId
    //sectionId
    //receiverData_selected
    if (ReceiverDataValedator()) {
        var title_id = document.getElementById("title_id").value;
        if (title_id === "") {
            Warning("برجاء اختيار عنوان العقد");
            return;
        } else {
            var contract = new Object();
            contract.receiver = receiverData_selected;// -- []
            $.ajax({
                url: "_1_0_0_5_0_Pur_Contract_Insert_02_getContracts_AjaxServlet?"
                        + "deptId=" + deptId
                        + "&sectionId=" + sectionId
                        + "&accUnitId=" + accUnitId
                        + "&title_id=" + title_id.split(",")[0],
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(contract),
                //contentType: 'application/json',
                // mimeType: 'application/json',
                success: function (data) {
                    //console.log(data);
                    //a_0_0_5_2_students = JSON.parse(data.toString());
                    all_contracts_data = data;
                    fillTable(data);
                },
                error: function (xhr, status) {
                    Error("حدث خطأ");
                }
            });
        }
    }
}

function fillTable(data) {

    var html = "";
    if (data.length > 0) {
        for (var i = 0; i < data.length; i++) {
            html += "<tr>"
                    + "    <td>" + (i + 1) + "</td>"
                    + "    <td>" + data[i].contractDate + "</td>"
                    + "    <td>" + data[i].contractFromDate + "</td>"
                    + "    <td>" + data[i].contractToDate + "</td>"
                    + "    <td>" + data[i].contractValue + "</td>"
                    + "    <td><button type=\"button\" data-placement=\"top\" onclick=\"fillScreen('" + i + "');\" class=\"btn btn-sm btn-warning font-style fa fa-edit\" style=\"font-weight: bold;font-size: 15px;padding-bottom: 6px;padding-top: 6px;\"></button></td>"
                    + "</tr>";
        }

    } else {
        html += "<tr>"
                + "    <td colsapn='5'>لا توجد عقود</td>"
                + "</tr>";
        Warning("لا يوجد عقود");
    }
    document.getElementById("contracts_search_result").innerHTML = html;
}

function clearSelected() {
    $('.search-choice-close').trigger('click');
}


function fillScreen(index) {

    data = all_contracts_data[index];

    ContractSp_Global = data.contractSp;
    TitleId_Global = data.titleId;

    var serviceSeq = data.serviceSeq;
    clearSelected();
    if (serviceSeq.length > 0) {

        var x = document.getElementById('service_seq');
        for (var i = 0; i < x.options.length; i++) {
            if (serviceSeq.includes(x.options[i].value)) {
                x.options[i].selected = true;
            }
        }

        $(".chosen-select").trigger("chosen:updated");
    }

    //document.getElementById("serviceSeq").value = data.serviceSeq;

    document.getElementById("title_id").value = data.titleId;
    document.getElementById("contractDate").value = data.contractDate;
    document.getElementById("contractValue").value = data.contractValue;
    setThreeFloatingPoint('contractValue');

    document.getElementById("contractTax").value = data.contractTax;
    document.getElementById("paymentKind").value = data.paymentKind;

    document.getElementById("contractFromDate").value = data.contractFromDate;
    document.getElementById("contractToDate").value = data.contractToDate;
    document.getElementById("rmrk").value = data.rmrk;


    var no_of_month_int = data.periodVal;
    document.getElementById("no_of_month").value = no_of_month_int;
    checkContractPeriod();


    contract_dtl_table = data.purContractMasterDtl;

    var contracts_dtl = document.getElementById("contracts_dtl");
    contracts_dtl.innerHTML = "";

    for (var i = 0; i < contract_dtl_table.length; i++) {
        contracts_dtl.innerHTML += ""
                + "<tr>"
                + "    <td>" + (i + 1) + "</td>"
                + "    <td>" + contract_dtl_table[i].conFromDate + "</td>"
                + "    <td>" + contract_dtl_table[i].conToDate + "</td>"
                + "    <td>" + (+contract_dtl_table[i].conValue) + "</td>"
                //+ "    <td></td>"
                + "</tr>";
    }
    contracts_dtl.innerHTML += ""
            + "<tr style='background-color: #405467;color:white;'>"
            + "    <td colspan='3'>الإجمالي</td>"
            + "    <td>" + (+data.contractValue) + "</td>"
            + "</tr>";

    document.getElementById("2qsatCard").style.display = "block";

    document.getElementById("periodType").value = data.periodType;
    document.getElementById("alertDate").value = data.contractAlertDate;



}
/*
 * Alerts
 */
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



