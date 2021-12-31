/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

function Info(Body, icon) {
    new PNotify({
//title: "خطأ",
        delay: 2000,
        text: Body,
        type: 'info',
        styling: 'bootstrap3',
        icon: icon
    });
}


changeFilter();
function changeFilter() {
    var searchType = document.getElementById("searchType").value;
    var FromDiv = document.getElementById("FromDiv");
    var ToDiv = document.getElementById("ToDiv");
    var yearDiv = document.getElementById("yearDiv");
    if (searchType === "d") {
        FromDiv.style.display = "block";
        ToDiv.style.display = "block";
        yearDiv.style.display = "none";
    } else if (searchType === "y") {
        FromDiv.style.display = "none";
        ToDiv.style.display = "none";
        yearDiv.style.display = "block";
    }
}

/* ECHRTS */


function init_echarts_invoice(id, titleDiv, GraphTitle, y_axis_title, mainData, x_axis_titles, data_series) {

    if (typeof (echarts) === 'undefined') {
        return;
    }
    console.log('init_echarts_invoice');
    var theme = {
        color: [
            '#26B99A',
            '#34495E',
            '#ff0000',
            '#3498DB',
            '#9B59B6',
            '#8abb6f',
            '#ff51b7',
            '#5b02cf',
            '#ffc400',
            '#fa6e2d',
            '#00ffff',
            '#91ff00',
            '#f0b6fc',
            '#000000',
            '#700000',
            '#fc9191'
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
    //echart Bar

    if ($('#' + id).length) {
        document.getElementById(titleDiv).innerHTML = GraphTitle;
        var echartBar = echarts.init(document.getElementById(id), theme);
        echartBar.setOption({
            title: {
                text: "",
                subtext: y_axis_title
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: mainData//['sales', 'purchases']
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
                    data: x_axis_titles//['1?', '2?', '3?', '4?', '5?', '6?', '7?', '8?', '9?', '10?', '11?', '12?']
                }],
            yAxis: [{
                    type: 'value'
                }],
            series: data_series/*[{
             name: 'sales',
             type: series_type, //'bar',
             data: x_axis_values,//[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
             markPoint: {
             data: [{
             type: 'max',
             name: 'أعلى قيمة'
             }, {
             type: 'min',
             name: 'أقل قيمة'
             }]
             },
             markLine: {
             data: [{
             type: 'average',
             name: 'المتوسط'
             }]
             }
             }, {
             name: 'purchases',
             type: series_type, //'bar',
             data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
             markPoint: {
             data: [{
             name: 'sales',
             value: 182.2,
             xAxis: 7,
             yAxis: 183
             }, {
             name: 'purchases',
             value: 2.3,
             xAxis: 11,
             yAxis: 3
             }]
             },
             markLine: {
             data: [{
             type: 'average',
             name: '???'
             }]
             }
             }]*/
        });
    }




}


getInvoiceCountNumbers();
function getInvoiceCountNumbers() {
    var searchType = document.getElementById("searchType").value;
    var docStatus = document.getElementById("docStatus").value;
    var dateFrom = document.getElementById("dateFrom").value;
    var dateTo = document.getElementById("dateTo").value;
    var year = document.getElementById("year").value;
    var values_search = document.getElementById("values_search").value;

    if (docStatus === "") {
        Warning("برجاء اختيار الإدارة");
        return;
    } else if (searchType === "") {
        Warning("برجاء اختيار نوع البحث");
        return;
    } else if (searchType === "d" && (dateFrom === "" || dateTo === "")) {
        if (dateFrom === "") {
            Warning("برجاء اختيار من تاريخ");
        } else if (dateTo === "") {
            Warning("برجاء اختيار الى تاريخ");
        }
        return;
    } else if (searchType === "y" && year === "") {
        Warning("برجاء اختيار سنة");
        return;
    } else if (values_search === "") {
        Warning("برجاء اختيار نوع بحث القيم");
        return;
    }

    $.ajax({
        url: "_1_0_0_0_7_Electronic_Invoice_Dept_Charts_02_get_invoice_numbers?"
                + "docStatus=" + docStatus
                + "&searchType=" + searchType
                + "&dateFrom=" + dateFrom
                + "&dateTo=" + dateTo
                + "&year=" + year
                + "&values_search=" + values_search,
        type: 'POST',
        //dataType: 'json',
        //data: json,
        //contentType: 'application/json',
        // mimeType: 'application/json',
        success: function (data) {
            if (data === "Error") {
                Error("حدث خطأ");
            } else {

                console.log(JSON.stringify(data));

                var Title = "";
                var Y_axisTitle = "";

                if (values_search === "counter") {
                    Title = "إحصائية أعداد الفواتير";
                    Y_axisTitle = "أعداد الفواتير";
                } else {
                    Title = "احصائية إجماليات مالية الفواتير";
                    Y_axisTitle = "إجماليات الفواتير";
                }
                drawBar("Invoice_count_numbers_chart"
                        , "GraphTitleDiv"
                        , data
                        , Title
                        , Y_axisTitle
                        , "bar");
            }
        },
        error: function (xhr, status) {
            if (xhr.responseText === "Error") {
                Error("حدث خطأ");
            }
        }
    });
}

function drawBar(id, titleDiv, data, Title, Y_axisTitle, series_type) {
    var GraphTitle = Title; //"عنوان";
    var y_axis_title = Y_axisTitle; //"Y_axis_title";

    /**
     * ---- serice Types ----
     * bar
     * radar
     * funnel
     * gauge
     * line
     * scatter
     * pie
     * ---------------
     * map
     * 
     */

    var mainData = []; //['sales', 'purchases'];
    var x_axis_titles = [];//['1?', '2?', '3?', '4?', '5?', '6?', '7?', '8?', '9?', '10?', '11?', '12?'];
    var data_series = [];
    /*data_series = [{
     name: 'sales',
     type: series_type, //'bar',
     data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
     markPoint: {
     data: [{
     type: 'max',
     name: 'أعلى قيمة'
     }, {
     type: 'min',
     name: 'أقل قيمة'
     }]
     },
     markLine: {
     data: [{
     type: 'average',
     name: 'المتوسط'
     }]
     }
     }, {
     name: 'purchases',
     type: series_type, //'bar',
     data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
     markPoint: {
     data: [{
     type: 'max',
     name: 'أعلى قيمة'
     }, {
     type: 'min',
     name: 'أقل قيمة'
     }]
     },
     markLine: {
     data: [{
     type: 'average',
     name: '???'
     }]
     }
     }];*/
    for (var i = 0; i < data.length; i++) {
        GraphTitle = Title + " " + data[i].title_extra;

        var data_name = data[i].data_name;
        mainData.push(data_name);

        //x_axis_data
        var xAxis = data[i].x_axis_data;
        x_axis_titles = [];
        var x_axis_data_values = [];

        for (var j = 0; j < xAxis.length; j++) {
            x_axis_titles.push(xAxis[j].x_axis_title);
            x_axis_data_values.push(xAxis[j].value);
        }

        data_series.push({
            name: data_name,
            type: series_type, //'bar',
            data: x_axis_data_values, //[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            markPoint: {
                data: [{
                        type: 'max',
                        name: 'أعلى قيمة'
                    }, {
                        type: 'min',
                        name: 'أقل قيمة'
                    }]
            },
            markLine: {
                data: [{
                        type: 'average',
                        name: 'المتوسط'
                    }]
            }
        });
    }



    init_echarts_invoice(id, titleDiv, GraphTitle, y_axis_title, mainData, x_axis_titles, data_series);
}