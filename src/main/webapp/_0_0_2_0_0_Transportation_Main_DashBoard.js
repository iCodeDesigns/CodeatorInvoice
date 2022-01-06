
function DashTimeView() {
    var DashTimeView = document.getElementById("DashTimeView").value;
    document.getElementById("month").value = "";
    if (DashTimeView === "Year" || DashTimeView === "YearMonth") {
        document.getElementById("MonthDateDiv").style.display = "none";
        document.getElementById("yearDateDiv").style.display = "block";
    } else if (DashTimeView === "Month") {
        document.getElementById("MonthDateDiv").style.display = "block";
        document.getElementById("yearDateDiv").style.display = "block";
    } else {
        document.getElementById("MonthDateDiv").style.display = "none";
        document.getElementById("yearDateDiv").style.display = "none";
    }
}

function sectionOrDept() {
    var sectionOrDept = document.getElementById("sectionOrDept").value;
    if (sectionOrDept === "All") {
        document.getElementById("DashTimeView").innerHTML = "<option value='Year' selected='' class='font-style'>سنة</option>"
                + "<option value='Month' class='font-style'>شهر</option>";
        document.getElementById("DashTimeView").disabled = false;
        document.getElementById("color_13Div").style.display = "none";
        document.getElementById("color_13Div").value = "#26b99a";

    } else {
        document.getElementById("DashTimeView").innerHTML = "<option value='YearMonth' class='font-style'>شهور السنة</option>";

        document.getElementById("DashTimeView").disabled = true;
        document.getElementById("color_13Div").style.display = "block";
    }
    document.getElementById("MonthDateDiv").style.display = "none";
}

function searchLevel() {
    var searchLevel = document.getElementById("searchLevel").value;
    document.getElementById("select2-sectionOrDept-container").innerHTML = "";
    if (searchLevel === "Section") {
        document.getElementById("lbl_title_dept").innerHTML = "القسم";
    } else if (searchLevel === "Dept") {
        document.getElementById("lbl_title_dept").innerHTML = "الإدارة";
    }
    var URL = "_0_0_2_0_0_Transportation_Main_DashBoard_1__AJAX_getSectionOrDept_AjaxServlet?";
    URL += "searchLevel=" + searchLevel;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                Error("حدث خطأ");
            } else {
                document.getElementById("sectionOrDept").innerHTML = message;

            }
        }
    };
}

var status = 'f';

//setInterval(queryLoad, 500);

var theme;
function setTheme(color_13) {
    theme = {
        color: [
            color_13, '#bd1212', '#423bee',
            '#12a706', '#e68b17', '#b307ac', '#2eaddf',
            '#470a0a', '#7e7e7e', '#a900f8'
        ],

        title: {
            itemGap: 8,
            textStyle: {
                fontWeight: 'normal',
                color: '#408829'
            }
        },

        dataRange: {
            color: ['#1f610a', '#97b58d']
        },

        toolbox: {
            color: ['#408829', '#408829', '#408829', '#408829']
        },

        tooltip: {
            backgroundColor: 'rgba(0,0,0,0.5)',
            axisPointer: {
                type: 'line',
                lineStyle: {
                    color: '#408829',
                    type: 'dashed'
                },
                crossStyle: {
                    color: '#408829'
                },
                shadowStyle: {
                    color: 'rgba(200,200,200,0.3)'
                }
            }
        },

        dataZoom: {
            dataBackgroundColor: '#eee',
            fillerColor: 'rgba(64,136,41,0.2)',
            handleColor: '#408829'
        },
        grid: {
            borderWidth: 0
        },

        categoryAxis: {
            axisLine: {
                lineStyle: {
                    color: '#408829'
                }
            },
            splitLine: {
                lineStyle: {
                    color: ['#eee']
                }
            }
        },

        valueAxis: {
            axisLine: {
                lineStyle: {
                    color: '#408829'
                }
            },
            splitArea: {
                show: true,
                areaStyle: {
                    color: ['rgba(250,250,250,0.1)', 'rgba(200,200,200,0.1)']
                }
            },
            splitLine: {
                lineStyle: {
                    color: ['#eee']
                }
            }
        },
        timeline: {
            lineStyle: {
                color: '#408829'
            },
            controlStyle: {
                normal: {color: '#408829'},
                emphasis: {color: '#408829'}
            }
        },

        k: {
            itemStyle: {
                normal: {
                    color: '#68a54a',
                    color0: '#a9cba2',
                    lineStyle: {
                        width: 1,
                        color: '#408829',
                        color0: '#86b379'
                    }
                }
            }
        },
        map: {
            itemStyle: {
                normal: {
                    areaStyle: {
                        color: '#ddd'
                    },
                    label: {
                        textStyle: {
                            color: '#c12e34'
                        }
                    }
                },
                emphasis: {
                    areaStyle: {
                        color: '#99d2dd'
                    },
                    label: {
                        textStyle: {
                            color: '#c12e34'
                        }
                    }
                }
            }
        },
        force: {
            itemStyle: {
                normal: {
                    linkStyle: {
                        strokeColor: '#408829'
                    }
                }
            }
        },
        chord: {
            padding: 4,
            itemStyle: {
                normal: {
                    lineStyle: {
                        width: 1,
                        color: 'rgba(128, 128, 128, 0.5)'
                    },
                    chordStyle: {
                        lineStyle: {
                            width: 1,
                            color: 'rgba(128, 128, 128, 0.5)'
                        }
                    }
                },
                emphasis: {
                    lineStyle: {
                        width: 1,
                        color: 'rgba(128, 128, 128, 0.5)'
                    },
                    chordStyle: {
                        lineStyle: {
                            width: 1,
                            color: 'rgba(128, 128, 128, 0.5)'
                        }
                    }
                }
            }
        },
        gauge: {
            startAngle: 225,
            endAngle: -45,
            axisLine: {
                show: true,
                lineStyle: {
                    color: [[0.2, '#86b379'], [0.8, '#68a54a'], [1, '#408829']],
                    width: 8
                }
            },
            axisTick: {
                splitNumber: 10,
                length: 12,
                lineStyle: {
                    color: 'auto'
                }
            },
            axisLabel: {
                textStyle: {
                    color: 'auto'
                }
            },
            splitLine: {
                length: 18,
                lineStyle: {
                    color: 'auto'
                }
            },
            pointer: {
                length: '90%',
                color: 'auto'
            },
            title: {
                textStyle: {
                    color: '#333'
                }
            },
            detail: {
                textStyle: {
                    color: 'auto'
                }
            }
        },
        textStyle: {
            fontFamily: 'Arial, Verdana, sans-serif'
        }
    };
}

var checkStatus = false;
function checkData(btnType) {
    var searchLevel = document.getElementById("searchLevel").value;
    var sectionOrDept = document.getElementById("sectionOrDept").value;
    var DashTimeView = document.getElementById("DashTimeView").value;
    var from_year = document.getElementById("from_year").value;
    var month = document.getElementById("month").value;
    var requireType = document.getElementById("requireType").value;
    var VcleType = document.getElementById("VcleType").value;
    var plotType = document.getElementById("plotType").value;
    var color_13 = document.getElementById("color_13").value;

    if (searchLevel === "" || searchLevel === null) {
        Warning("من فضلك اختر مستوى الاستعلام");
        checkStatus = false;
    } else if (sectionOrDept === "" || sectionOrDept === null) {
        Warning("برجاء اختيار القسم أو الإدارة");
        checkStatus = false;
    } else if (DashTimeView === "" || DashTimeView === null) {
        Warning("برجاء اختيار نوع عرض الإحصائية");
        checkStatus = false;
    } else if (from_year === "" || from_year === null) {
        Warning("برجاء اختيار سنة الإستعلام");
        checkStatus = false;
    } else if ((month === "" || month === null) && DashTimeView === "Month") {
        Warning("برجاء اختيار شهر الإستعلام");
        checkStatus = false;
    } else if (requireType === "" || requireType === null) {
        Warning("برجاء اختيار نوع الطلب");
        checkStatus = false;
    } else if (VcleType === "" || VcleType === null) {
        Warning("برجاء اختيار نوع المركبة");
        checkStatus = false;
    } else if (plotType === "" || plotType === null) {
        Warning("برجاء اختيار نوع عرض الرسمة البياني");
        checkStatus = false;
    } else if ((color_13 === "" || color_13 === null) && !sectionOrDept === "All") {
        Warning("برجاء اختيار لون عرض الرسم البياني");
        checkStatus = false;
    } else {
        checkStatus = true;
        setData(btnType);
    }
}

function setData(btnType) {
    var searchLevel = document.getElementById("searchLevel").value;
    var sectionOrDept = document.getElementById("sectionOrDept").value;
    var DashTimeView = document.getElementById("DashTimeView").value;
    var from_year = document.getElementById("from_year").value;
    var month = document.getElementById("month").value;
    var requireType = document.getElementById("requireType").value;
    var VcleType = document.getElementById("VcleType").value;
    var plotType = document.getElementById("plotType").value;
    var color_13 = document.getElementById("color_13").value;

    refresh(searchLevel, sectionOrDept, DashTimeView, from_year, month, requireType, VcleType, plotType, color_13, btnType);
}

var HtmlTable = "";
var jason_data;
function refresh(searchLevel, sectionOrDept, DashTimeView, from_year, month, requireType, VcleType, plotType, color_13, btnType) {
    HtmlTable = "";
    status = 't';
    var chartType = 'bar';

    setTheme(color_13);
    $.ajax({
        url: "_0_0_2_0_0_Transportation_Main_DashBoard_Ajax_3_getdataAnalysis_AjaxServlet?"
                + "searchLevel=" + searchLevel
                + "&sectionOrDept=" + sectionOrDept
                + "&DashTimeView=" + DashTimeView
                + "&from_year=" + from_year
                + "&month=" + month
                + "&requireType=" + requireType
                + "&VcleType=" + VcleType,
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',

        success: function (data) {

            jason_data = data;
            if (typeof (echarts) === 'undefined') {
                return;
            }
            console.log('init_echarts');



            //echart Bar

            // Get Parts of Charts
            var part = [];
            var names = [];
            var series = [];
            var series2 = [];
            $.each(data, function (index, mainData) {                
                //part.push(article.x_part_name);
                HtmlTable += "<thead style='background-color: #131e33;color: white;'>";
                HtmlTable += "<tr>";
                var sortingStatus0 = "";
                var sortingStatus1 = "";
                if(sectionOrDept==="All"){
                    sortingStatus0 = "class='sortIcon fa fa-sort' onclick='sortTable(0);";
                    sortingStatus1 = "class='sortIcon fa fa-sort' onclick='sortTable(1);";
                    document.getElementById("dashTableSearch").style.display = "block";
                }else{
                    sortingStatus0="";
                    sortingStatus1 = "";
                    document.getElementById("dashTableSearch").style.display = "none";
                }
                HtmlTable += "  <th style='font-size: 15px;width: 15%;text-align: right'><a href='#' style='color: white;' "+sortingStatus0+"'></a></th>";
                $.each(mainData.parts, function (i, part1) {
                    //item = tag + " - " + item;
                    HtmlTable += "  <th style='font-size: 15px;width: 15%;text-align: right'><a href='#' style='color: white;' "+sortingStatus1+"'></a> " + part1 + "</th>";
                    part.push(part1);
                });
                HtmlTable += "</tr>";
                HtmlTable += "</thead>";

                HtmlTable += "<tbody class='bodyScroll'>";
                $.each(mainData.data_list, function (j, data_list1) {

                    HtmlTable += "<tr >";
                    //Success(items_profit1.data_names);
                    HtmlTable += "  <td>" + data_list1.data_name + "</td>";
                    names.push(data_list1.data_name);

                    var vals = [];
                    $.each(data_list1.values, function (k, values1) {

                        HtmlTable += "  <td>" + values1 + "</td>";
                        //Success(values1);
                        vals.push(values1);
                    });
                    HtmlTable += "</tr>";


                    series.push({
                        name: data_list1.data_name,
                        type: chartType, // bar , line
                        data: vals,
                        markPoint: {
                            data: [{
                                    type: 'max',
                                    name: 'أعلى عدد'
                                }, {
                                    type: 'min',
                                    name: 'أقل عدد'
                                }]
                        },
                        markLine: {
                            data: [{
                                    type: 'average',
                                    name: 'المتوسط'
                                }]
                        }
                    });
                    series2.push({
                        name: data_list1.data_name,
                        type: chartType,
                        data: vals//[18203, 23489, 29034, 104970, 131744, 630230]
                    });

                });

                HtmlTable += "</tbody>";
                

            });
            document.getElementById("dashTableSearchDiv").style.display = "block";
            ////////////
            if (plotType === "V") {
                document.getElementById("EmpCount_DashBoard").style.height = "500px";
                if ($('#EmpCount_DashBoard').length) {

                    var echartBar = echarts.init(document.getElementById('EmpCount_DashBoard'), theme);

                    echartBar.setOption({
                        title: {
                            text: '',
                            subtext: ''
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: names//['sales', 'purchases']
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                magicType: {
                                    show: true,
                                    title: {
                                        line: 'Line',
                                        bar: 'Bar',
                                        stack: 'Stack',
                                        tiled: 'Tiled'
                                    },
                                    type: ['line', 'bar', 'stack', 'tiled']
                                },
                                restore: {
                                    show: true,
                                    title: "Restore"
                                },
                                saveAsImage: {
                                    show: true,
                                    title: "Save Image"
                                }
                            }
                        },
                        calculable: false,
                        xAxis: [{
                                type: 'category',
                                data: part//['1?', '2?', '3?', '4?', '5?', '6?', '7?', '8?', '9?', '10?', '11?', '12?']
                            }],
                        yAxis: [{
                                type: 'value'
                            }],
                        series: series
                    });

                }
            } else if (plotType === "H") {
                document.getElementById("EmpCount_DashBoard").style.height = "2000px";
                if ($('#EmpCount_DashBoard').length) {

                    var echartBar = echarts.init(document.getElementById('EmpCount_DashBoard'), theme);

                    echartBar.setOption({
                        title: {
                            text: '',
                            subtext: ''
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            x: 100,
                            data: names//['2015', '2016']
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                magicType: {
                                    show: true,
                                    title: {
                                        line: 'Line',
                                        bar: 'Bar',
                                        stack: 'Stack',
                                        tiled: 'Tiled'
                                    },
                                    type: ['line', 'bar', 'stack', 'tiled']
                                },
                                restore: {
                                    show: true,
                                    title: "Restore"
                                },
                                saveAsImage: {
                                    show: true,
                                    title: "Save Image"
                                }
                            }
                        },
                        calculable: true,
                        xAxis: [{
                                type: 'value',
                                boundaryGap: [0, 0.01]
                            }],
                        yAxis: [{
                                type: 'category',
                                minBarLength: 2,
                                data: part//['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun']
                            }],
                        series: series2
                    });

                }
            }
            status = 'f';
            frame(100);
            if (btnType === "new_window") {
                document.getElementById("dashTable").innerHTML = "نتيجة الجدول ستظهر في نافذة جديدة";
                var jason_str = JSON.stringify(jason_data);
                var URL2 = "_0_0_2_0_0_Transportation_Main_DashBoard_output_1_AccessServlet?"
                        + "plotType=" + plotType
                        + "&color_13=" + color_13.split('#')[1]
                        + "&data=" + jason_str
                        + "&Key=Open";
                //console.log(jason_data);
                window.open(URL2, '_blank', 'toolbar=no,titlebar=no,menubar=no,top=50,left=200,height=900,width=1500,scrollbars=no,status=no');
            } else {
                document.getElementById("dashTable").innerHTML = HtmlTable;
            }
        },
        error: function (data, status, er) {
            alert("error: " + data + " status: " + status + " er:" + er);
            status = 'f';
            document.getElementById("dashTable").innerHTML = "<thrad><th>حدث خطأ</th></thrad>";
            document.getElementById("dashTableSearchDiv").style.display = "none";
        }
    });
}
function createTableDash(plotType, color_1, data) {
    color_1 = "#" + color_1;
    console.log(data);
    HtmlTable = "";
    var chartType = 'bar';
    if (typeof (echarts) === 'undefined') {
        return;
    }
    console.log('init_echarts');

    setTheme(color_1);


    //echart Bar

    // Get Parts of Charts
    var part = [];
    var names = [];
    var series = [];
    var series2 = [];
    $.each(data, function (index, mainData) {
        //part.push(article.x_part_name);
        HtmlTable += "<thead style='background-color: #131e33;color: white;'>";
        HtmlTable += "<tr>";
        HtmlTable += "  <th style='text-align: center;font-size: 15px;width: 15%'></th>";
        $.each(mainData.parts, function (i, part1) {
            //item = tag + " - " + item;
            HtmlTable += "  <th style='text-align: center;font-size: 15px;width: 15%'>" + part1 + "</th>";
            part.push(part1);
        });
        HtmlTable += "</tr>";
        HtmlTable += "</thead>";

        HtmlTable += "<tbody>";
        $.each(mainData.data_list, function (j, data_list1) {

            HtmlTable += "<tr >";
            //Success(items_profit1.data_names);
            HtmlTable += "  <td>" + data_list1.data_name + "</td>";
            names.push(data_list1.data_name);

            var vals = [];
            $.each(data_list1.values, function (k, values1) {

                HtmlTable += "  <td>" + values1 + "</td>";
                //Success(values1);
                vals.push(values1);
            });
            HtmlTable += "</tr>";


            series.push({
                name: data_list1.data_name,
                type: chartType, // bar , line
                data: vals,
                markPoint: {
                    data: [{
                            type: 'max',
                            name: 'أعلى عدد'
                        }, {
                            type: 'min',
                            name: 'أقل عدد'
                        }]
                },
                markLine: {
                    data: [{
                            type: 'average',
                            name: 'المتوسط'
                        }]
                }
            });
            series2.push({
                name: data_list1.data_name,
                type: chartType,
                data: vals//[18203, 23489, 29034, 104970, 131744, 630230]
            });

        });

        HtmlTable += "</tbody>";

    });
    ////////////
    if (plotType === "V") {
        document.getElementById("EmpCount_DashBoard").style.height = "500px";
        if ($('#EmpCount_DashBoard').length) {

            var echartBar = echarts.init(document.getElementById('EmpCount_DashBoard'), theme);

            echartBar.setOption({
                title: {
                    text: '',
                    subtext: ''
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: names//['sales', 'purchases']
                },
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {
                            show: true,
                            title: {
                                line: 'Line',
                                bar: 'Bar',
                                stack: 'Stack',
                                tiled: 'Tiled'
                            },
                            type: ['line', 'bar', 'stack', 'tiled']
                        },
                        restore: {
                            show: true,
                            title: "Restore"
                        },
                        saveAsImage: {
                            show: true,
                            title: "Save Image"
                        }
                    }
                },
                calculable: false,
                xAxis: [{
                        type: 'category',
                        data: part//['1?', '2?', '3?', '4?', '5?', '6?', '7?', '8?', '9?', '10?', '11?', '12?']
                    }],
                yAxis: [{
                        type: 'value'
                    }],
                series: series
            });

        }
    } else if (plotType === "H") {
        document.getElementById("EmpCount_DashBoard").style.height = "2000px";
        if ($('#EmpCount_DashBoard').length) {

            var echartBar = echarts.init(document.getElementById('EmpCount_DashBoard'), theme);

            echartBar.setOption({
                title: {
                    text: '',
                    subtext: ''
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    x: 100,
                    data: names//['2015', '2016']
                },
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {
                            show: true,
                            title: {
                                line: 'Line',
                                bar: 'Bar',
                                stack: 'Stack',
                                tiled: 'Tiled'
                            },
                            type: ['line', 'bar', 'stack', 'tiled']
                        },
                        restore: {
                            show: true,
                            title: "Restore"
                        },
                        saveAsImage: {
                            show: true,
                            title: "Save Image"
                        }
                    }
                },
                calculable: true,
                xAxis: [{
                        type: 'value',
                        boundaryGap: [0, 0.01]
                    }],
                yAxis: [{
                        type: 'category',
                        minBarLength: 2,
                        data: part//['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun']
                    }],
                series: series2
            });

        }
    }
    status = 'f';
    frame(100);
    document.getElementById("dashTable").innerHTML = HtmlTable;
    reloadDataTable();
}
function reloadDataTable() {

    $('#dashTable').DataTable()
            .rows().invalidate('data')
            .draw(true);
}

function getLoad() {
    //alert(status);
    var URL = "_0_0_2_0_0_Transportation_Main_DashBoard_Ajax_4_getLoad_1_AjaxServlet?";

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);

    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            var message = xhttp.responseText;
            if (message === "Error") {
                //document.getElementById("load").innerHTML = "";

            } else {
                //document.getElementById("load").innerHTML = message;
                frame(message);
            }
        }
    };
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
        clearInterval(id);
    } else {
        elem.style.width = width + "%";
        elem.innerHTML = width + "%";
    }
    old = width;
}

$(function () {
    try {
        $(".SELECT_Combo").select2();
    } catch (err) {

    }
});

function dashTableSearch() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("dashTableSearch");
  filter = input.value.toUpperCase();
  table = document.getElementById("dashTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
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



function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("dashTable");
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