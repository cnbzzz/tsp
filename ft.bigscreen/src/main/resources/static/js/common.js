//数据接口ip
// var df_ip ='http://127.0.0.1:9102';
// var baseUrl = "http://127.0.0.1:9102/tsp";
var df_ip ='http://112.74.180.11:8088/';
var baseUrl = "http://112.74.180.11:8088/tsp";

//刷新时间
var df_time = 10000;
//蒙层
var tip_show = '<div class="tip-show">'+
			   '<div id="bonfire-pageloader">'+
			   '<div class="bonfire-pageloader-icon">'+
				    '<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"'+
						'width="512px" height="512px" viewBox="0 0 512 512" enable-background="new 0 0 512 512" xml:space="preserve">'+
						'<path id="loading-12-icon" d="M291,82.219c0,16.568-13.432,30-30,30s-30-13.432-30-30s13.432-30,30-30S291,65.65,291,82.219z'+
						' M261,404.781c-15.188,0-27.5,12.312-27.5,27.5s12.312,27.5,27.5,27.5s27.5-12.312,27.5-27.5S276.188,404.781,261,404.781z'+
						' M361.504,113.167c-4.142,7.173-13.314,9.631-20.487,5.489c-7.173-4.141-9.631-13.313-5.49-20.487'+
						'c4.142-7.173,13.314-9.631,20.488-5.489C363.188,96.821,365.645,105.994,361.504,113.167z M188.484,382.851'+
						'c-14.348-8.284-32.697-3.368-40.98,10.98c-8.285,14.349-3.367,32.696,10.98,40.981c14.35,8.283,32.697,3.367,40.98-10.981'+
						'C207.75,409.482,202.834,391.135,188.484,382.851z M421.33,184.888c-8.368,4.831-19.07,1.965-23.901-6.404'+
						'c-4.832-8.368-1.965-19.07,6.404-23.902c8.368-4.831,19.069-1.964,23.9,6.405C432.566,169.354,429.699,180.056,421.33,184.888z'+
						' M135.399,329.767c-8.285-14.35-26.633-19.266-40.982-10.982c-14.348,8.285-19.264,26.633-10.979,40.982'+
						'c8.284,14.348,26.632,19.264,40.981,10.98C138.767,362.462,143.683,344.114,135.399,329.767z M436.031,277.249'+
						'c-11.044,0-20-8.953-20-19.999c0-11.045,8.955-20.001,20.001-20.001c11.044,0,19.999,8.955,19.999,20.002'+
						'C456.031,268.295,447.078,277.249,436.031,277.249z M115.97,257.251c-0.001-16.57-13.433-30.001-30.001-30.002'+
						'c-16.568,0.001-29.999,13.432-30,30.002c0.001,16.566,13.433,29.998,30.001,30C102.538,287.249,115.969,273.817,115.97,257.251z'+
						' M401.333,364.248c-10.759-6.212-14.446-19.97-8.234-30.73c6.212-10.759,19.971-14.446,30.731-8.233'+
						'c10.759,6.211,14.445,19.971,8.232,30.73C425.852,366.774,412.094,370.46,401.333,364.248z M135.398,184.736'+
						'c8.285-14.352,3.368-32.698-10.98-40.983c-14.349-8.283-32.695-3.367-40.981,10.982c-8.282,14.348-3.366,32.696,10.981,40.981'+
						'C108.768,204,127.115,199.082,135.398,184.736z M326.869,421.328c-6.902-11.953-2.807-27.242,9.148-34.145'+
						's27.243-2.806,34.146,9.149c6.902,11.954,2.806,27.243-9.15,34.145C349.059,437.381,333.771,433.284,326.869,421.328z'+
						' M188.482,131.649c14.352-8.286,19.266-26.633,10.982-40.982c-8.285-14.348-26.631-19.264-40.982-10.98'+
						'c-14.346,8.285-19.264,26.633-10.98,40.982C155.787,135.017,174.137,139.932,188.482,131.649z"/>'+
					'</svg>'+
				'</div>'+
			'</div>'+
		'</div>';
//没有数据时
var pHtml = '<p class="pHtml">暂无数据</p>';

//仪表盘的区间颜色
var colors_common = [[0.2, '#fb0609'],[0.8, '#00f3f0'],[1,'#82f706']];
var colors_v = [[0.2, '#fb0609'],[0.8, '#00f3f0'],[1,'#82f706']];
var colors_C = [[0.33, '#fb0609'],[0.94, '#00f3f0'],[1,'#fb0609']];
var colors_a = [[0.1, '#fb0609'],[0.9, '#00f3f0'],[1,'#fb0609']];
var colors_hy = [[0.1, '#fb0609'],[0.9, '#00f3f0'],[1,'#fb0609']];
var colors_DC = [[0.2, '#fb0609'],[0.8, '#00f3f0'],[1,'#fb0609']];
//百分比,电量
var precent_format = function(v){
	switch (v + '') {
		case '0' : return '0';
//		case '10':return '10';
		case '20':return '20%';
//		case '30': return '30%';
//		case '40':return '40%';
		case '50':return '50%';
//		case '60':return '60%';
//		case '70':return '70%';
		case '80':return '80%';
//		case '90':return '90%';
		case '100':return '100%'
	}
};
//电压
var v_format = function(v){
	switch (v + '') {
		case '0' : return '0';
		case '20' : return '300';
		case '40':return '400';
		case '60' : return '500';
		case '80' : return '600';
		case '100' : return '1000'
	}
};
//电流
var a_format = function(v){
	switch (v + '') {
		case '-50' : return '-1000';		
		case '-40':return '-100';
		case '-30':return '-75';
		case '-20' : return '-50';		
		case '-10' : return '-25';
		case '0' : return '0';		
		case '10':return '25';
		case '20':return '50';
		case '30' : return '75';		
		case '40' : return '100';
		case '50':return '1000';
	}
};
//温度
var C_format = function(v){
	switch (v + '') {
		case '-90' : return '-90';
		case '-70':return '-70';
		case '-50':return '-50';
		case '-30' : return '-30';
		case '-10' : return '-10';
		case '10' : return '10';
		case '30' : return '30';
		case '50' : return '50';
		case '70':return '70';
		case '90':return '90'
	}
}
//氢气浓度
var hy_format = function(v){
	switch(v+''){
		case '0' :return '0';
		case '5' :return '5';
		case '10' :return '10';
		case '15' :return '15';
		case '20' :return '20';
		case '25' :return '25';
		case '30' :return '30';
		case '35' :return '35';
		case '40' :return '40';
		case '45' :return '45';
		case '50' :return '50'
		
	}
}
//高压DC/DC状态
var DC_format = function(v){
	switch (v + '') {
		case '0' : return '失效';
		case '1' : return '工作';
		case '2' : return '断开';
		case '3' : return '异常'
	}
}
// $('body').append(tip_show);
$(document).ready(function(){
	$('.btn-back').on('click',function(){
		window.location = '../index.html';
	});
	$('.small_btn').on('click',function(){
		$(this).addClass('active').siblings().removeClass('active');
		var btn_text = $(this).text();
		btn_text = btn_text.replace(/\s/g,'');
		if(btn_text == '全部'){
			btn_text = '';
		}
		getSmallerro(df_vin,btn_text);
		setInterval('getSmallerro()',df_time);
	});
});

/*获取时间(当前时间和星期数)、天气--begin*/
$.getScript('http://php.weather.sina.com.cn/iframe/index/w_cl.php?code=js&day=0&city=&dfc=1&charset=utf-8',function(a){
    var s="",r="",q="";
    var weekdays = ['星期日','星期一','星期二','星期三','星期四','星期五','星期六']; 
    for(s in window.SWther.w){
        q=SWther.w[s][0];
        r={
        	city:s,
        	date:SWther.add.now.split(" ")[0]||"",
        	date2:SWther.add.now.split(" ")[1]||"",
        	day_weather:q.s1,
        	night_weather:q.s2,
        	day_temp:q.t1,
        	night_temp:q.t2,
        	day_wind:q.p1,
        	night_wind:q.p2
        },
       	$('.weather-date').html(r.date);
	   	$('.weather-week').html(weekdays[getWeek(r.date)]);
	   	$('.weather-min').html(r.date2.substr(0,r.date2.length-3));
	   	$('.weather-text').html('天气  : ');
	    $(".weather-tq").html(q.s1);
	    dateTime = r.date;
//      alert(q.s1+" "+r.date+" "+r.date2.substr(0,r.date2.length-3)+" "+weekdays[getWeek(r.date)]+" "+r.date2+" ")
    }
    
});
//周几转换
function getWeek(date){
     return transformDate(date).getDay();
}
 //日期转换
function transformDate(date){
    if(typeof date =="string"){
    return new Date(date.replace(/-/ig,"/").replace("T"," "));
    }else{
        return date;
    }
}

/*获取时间(当前时间和星期数)、天气--end*/

/*small中的实时状态-采集流量曲线-折线面积图-begin*/
function getLine(id,xAxisData,interval,yAxisName,seriesName,data){
	var myLine = echarts.init(document.getElementById(id));
	var option = {
		tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            shadowStyle : 'line'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	   	},
		legend:{
			show:false
		},
		grid:{
			top:'5%',
	        left: '3%',
	        right: 0,
	        bottom: '2%',
	        containLabel: true,
	        width:"96%"
		},
		xAxis:[
			{
				type:'category',
				axisLabel:{
					textStyle:{
						color:'#fdfdfd',
						fontStyle:'italic'
					},
					interval:interval
				},
				
				nameTextStyle:{
					
				},
				boundaryGap : false,
				data:xAxisData || ['08-26']
			}			
		],
		
		yAxis:[
			{
				tpye:'value',
				name:yAxisName || '(km)',
				nameLocation:'middle',
				nameTextStyle:{
					color:'#fdfdfd'
				},
				nameGap:35,
				nameRotate:90,
				splitLine: {
		            lineStyle: {
		                color: '#3daaab',
		                opacity: .85
		                
		            }
		       },
            	boundarGap:[0,0.01],
            	axisLabel:{
					textStyle:{
						color:'#fdfdfd'
					}
				},
            	symbol: 'none'
			}			
		],
		series:[
			{
				name:seriesName || '总里程数',
				type:"line",
				stack: '总量',
		        smooth: true,
		        symbol: 'circle',
		        symbolSize: 5,
		        showSymbol: false,
           		lineStyle: {
		            normal: {
		                width: 1
		            }
		        },
		        areaStyle: {
		            normal: {
		                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
		                    offset: 0,
		                    color: '#62fafc',
		                    opacity: .9
		                }, {
		                    offset: 0.8,
		                    color: '#62fafc',
		                     opacity: .3
		                }], false),
		                shadowColor: 'rgba(0, 0, 0, .1)',
		                shadowBlur: 10
		            }
		        },
		     	itemStyle: {
	                normal: {
	                    color: '#62fafc',
	                    barBorderWidth: 6,
	                    barBorderRadius:0	                    
	                }
	            },
	            data:data || [0]
			}			
		]
	};

	myLine.setOption(option,{
		notMerge:true,
		lazyUpdate:false
	});
}
/*small中的实时状态-采集流量曲线-折线面积图-end*/

/*small中的电池实时监控-begin*/
function getDash(id,seriesName,min,max,splitNumber,colors,alabel_fontsize,alabel_format,detail_format,data){
		var myDash = echarts.init(document.getElementById(id));
		var option = {
			backgroundColor: 'transparent',
		    tooltip : {
	        	formatter: "{a} <br/>{c} {b}"
		    },
		    series : [
		        {
		            name:seriesName,
		            type:'gauge',
		            min:min,
		            max:max,
		            splitNumber:splitNumber,
		            radius: '100%',
		            axisLine: {            // 坐标轴线
		                lineStyle: {       // 属性lineStyle控制线条样式
		                    color: colors,
		                    width: 3,
		                    // shadowColor : '#fff', //默认透明
		                    shadowBlur: 10
		                }
		            },
		            axisLabel: {            // 坐标轴小标记
		                textStyle: {       // 属性lineStyle控制线条样式
		                    color:'#fdfdfd',
		                    fontSize:alabel_fontsize,
		                    shadowBlur: 10
	               		},
	               		distance:0,
	               		
	               		formatter: alabel_format
		            },
		            axisTick: {            // 坐标轴小标记
		                length :5,        // 属性length控制线长
		                lineStyle: {       // 属性lineStyle控制线条样式
		                    color: 'auto',
		                    shadowBlur: 10
		                }
		                
		            },
		            splitLine: {           // 分隔线
		                length :10,         // 属性length控制线长
		                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
		                     fontWeight: 'bolder',
		                     color: 'auto'
		                }
		            },
		            pointer: {           // 分隔线
		                // shadowColor : '#fff', //默认透明
		                shadowBlur: 5,
		                width:3,
		                length:'60%'
		            },
		            itemStyle:{
		            	normal:{
		            		color:'#62fafc'
		            	}
		            },
		            title : {
		                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
		                    fontWeight: 'bolder',
		                    fontSize: 14,
		                    fontStyle: 'normal',
		                    color: '#fff',
		                   
//		                    shadowColor : '#fff', //默认透明
		                    shadowBlur: 10
		                },
		                 offsetCenter:['0','-15%'],
		            },
		            detail : {
		                formatter:detail_format,
		                offsetCenter: [0, '50%'],       // x, y，单位px
		                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
		                    fontWeight: 'bolder',
		                    color: 'auto',
		                    fontSize:17
		                }
		            },
		            data:data
		        }
		      
		    ]
		};
		myDash.setOption(option);
}
/*small中的电池实时监控-end*/

//生成柱形图
function getLineBar(id,xAxisData,barData){
	var myLineBar = echarts.init(document.getElementById(id));
	var option ={
			tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'shadow'
		        }
		    },
		    grid:{
		    	height:'63%',
		    	bottom:'25%'
		    },
		    calculable : true,
		    xAxis: {
		        data: xAxisData,
		        axisLine: {
		            lineStyle: {
		                color: '#ccc'
		            }
		        },
		        type:'category',
				axisLabel:{
					textStyle:{
						color:'#fdfdfd',
						fontStyle:'italic'
					},
					interval:0
				},
				z:4
		    },
		    yAxis: {
		        splitLine: {show: false},
		        type:'value',
		        boundarGap:[0,0.01],
		        axisLine: {
		            lineStyle: {
		                color: '#ccc'
		            }
		        },
		        
		    },
		    series: [{
		        name: '总件数',
		        type: 'bar',
		        barWidth: 20,
		        itemStyle: {
		            normal: {
		                barBorderRadius: 5,
		                 color: function(params) {
	                        // build a color map as your need.
	                        var colorList = [
	                          '#05fcfe','#01cde3','#398efe','#4ec9fd'
	                        ];
	                        return colorList[params.dataIndex]
	                   }
		            }
		        },
	            label: {
	                normal: {
	                    show: true,
	                    position: 'top',					                    
	                }
	            },
		        data: barData    
		    }] 
   };
   myLineBar.setOption(option);
}

//生成电量实时监控饼图
function getPie(id,lengdata,lenghttop,top,radius,length,pieData){
	var myPie = echarts.init(document.getElementById(id));
	var option = {
			tooltip:{
				show:true,
				trigger:'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},
			legend:{
				orient:'horizontal',
				data:lengdata,
				itemGap:2,
				left:'center',
				textStyle: {
	            	color:'#fdfdfd'
	           },
	           top:lenghttop,
	           show:true
			},
			color:['#13369a','#05fcfe','#01cde3','#398efe'],
			series:[
				{
					name:'电量实时监控',
					type:'pie',
					radius:radius,
					center:['50%','50%'],
					bottom:'-10%',
//					top:top,
					label: {
			            normal: {
			                textStyle: {
			                    fontSize: 12,
			                    color: '#fdfdfd'
			                }
			            }
			        },
			        labelLine: {
			            normal: {
			                lineStyle: {
			                    color: '#fdfdfd'
			                },
			                length:length || 40
			            }
			        },
		            data:pieData,
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.9)',
		                    color:'#fdfdfd'
		                }
		            }
				}
			]				
	};
	myPie.setOption(option);
	return myPie;
}

//small故障信息
function getSmallerro(vin,text){
	console.log('getSmallerro(vin)'+vin)
	$.ajax({
		type:"post",
		url:df_ip+"/tsp/queryErrorlog",
		async:true,
		dataType:'json',
		data:{'vin':vin,'errorType':text||'','limit':10},
		success:function(reslut){
			$('.small_ul_erro li').not($('.small_ul_erro li:first-child')).detach();
			$('.small_ul_erro p').detach();
			var datas = reslut.data;
			if(datas.length >0){
				for (var i = 0; i<datas.length; i++) {						
					var errorDate = format(parseInt(datas[i].errorDate));
					var errorType = datas[i].errorType;
					var errorGrade = datas[i].errorGrade;
					var errorName = datas[i].errorName;
					var lng = datas[i].longitude;
					var lat = datas[i].latitude;
					var lnglat = ['N:'+lng.substr(0,6)+'°','E:'+lat.substr(0,5)+'°'];
					
					var li_div = '<li>'+								 
		  					 '<div>'+errorDate+'</div>'+
							 '<div>'+errorType+'</div>'+
		  					 '<div>'+errorGrade+'</div>'+
		  					 '<div>'+errorName+'</div>'+
							 '<div>'+vin+'</div>'+
		  					 '<div>'+lnglat.join(',')+'</div>'+
							'</li>';
//				    console.log(li_div)
					$('.small_ul_erro').append(li_div);
				}
			}else{
				$('.small_ul_erro').append(pHtml);
			}
		},
		error:function(reslut){
			alert(reslut.retCode+' 数据获取失败');
			$('.tip-show').toggle();
			console.log('reslut.retCode:'+reslut.retCode)
		}
	});
}

function add0(m){
	return m<10?'0'+m:m;
}
function format(datetime){
	if(!datetime)
	return ""
	//shijianchuo是整数，否则要parseInt转换
	var time = new Date(datetime);
	var y = time.getFullYear();
	var m = time.getMonth()+1;
	var d = time.getDate();
	var h = time.getHours();
	var mm = time.getMinutes();
	var s = time.getSeconds();
//	return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
	return y+'-'+add0(m)+'-'+add0(d);
}
function myAjax(url, param, succ, fail) {
    return $.ajax({
        url: url,
        type: 'POST', //GET
        async: true,    //或false,是否异步
        data: param,
        timeout: 5000,    //超时时间
        dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
        beforeSend: function (xhr) {
            console.log(xhr);
            console.log('发送前');
        },
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
            succ && succ(data);
        },
        error: function (xhr, textStatus) {
            console.log('错误');
            console.log(xhr);
            console.log(textStatus);
            fail && fail(xhr, textStatus);
        },
        complete: function () {
            console.log('结束');
        }
    });
}

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}

function json2Arr(dataArr) {
    var obj = {};
    for (var i = 0; i < dataArr.length; i++) {
        var o = dataArr[i];
        for (var x in o) {
            var ox = o[x];
            if(x == 'datetime'){
            	ox = ox.substr(ox.length - 8, ox.length - 1);
			}
        	var tmp = obj[x];
            if (!tmp) {
                tmp = [];
            }
            tmp.push(ox);
            obj[x] = tmp;
        }
    }
    return obj;
}

function calcPercent(num, count, percent){
    num = num || 0;
    count = count || 0;
    percent = percent || 100;
    return (count && num / count * percent).toFixed();
}

function showHeatMap(url, heatMap) {
    myAjax(url, {}, function (result) {
        if (result.retCode == 1) {
            var dataList = result.data.dataList;
            var max = result.data.max;
            var option = {visualMap: {'max': max}, series: [{'data': convertData(dataList)}]};
            heatMap.setOption(option);
        }
    }).always(function () {
        $('.tip-show').hide();
    });
}
function showNoData(pie,positions) {
    if (pie) {
        var option = {
            tooltip: {
                show: true,
                trigger: 'item',
                formatter: function (params, ticket, callback) {
                    var str = '<div style="text-align: center" id="toolTipBox"><p style="font-size:12px;margin:0px">无数据</p></div>'
                    return str
                },
                position: function (point, params, dom, rect, size) {
                    //size参数可以拿到提示框的outerWidth和outerheight，dom参数可以拿到提示框div节点。
                    //console.log(dom)可以看到，提示框是用position定位
                    var marginW = Math.ceil(size.contentSize[0] / 2);
                    var marginH = Math.ceil(size.contentSize[1] * 1.5);
                    console.log(marginH);
                    dom.style.marginLeft = '-' + marginW + 'px';
                    dom.style.marginTop = '-' + marginH + 'px';
                    return positions || ['50%','50%'];
                },
                alwaysShowContent: true,
                backgroundColor: '#f3f5f6',	//设置提示框的背景色
                textStyle: {
                    color: '#333'
                }
            },
            color: ['#DBDBDB'],
            series: [{
                silent: true,
                label: {
			            normal: {
			                textStyle: {
			                    fontSize: 12,
			                    color: '#fdfdfd'
			                },
			                show:false
			            }
			        },
                labelLine: {
			            normal: {
			                lineStyle: {
			                    color: 'transparent'
			                },
			                length:0,
			                show:false
			            }
			        },
                data: [
                    {value: 100, name: '无数据'}
                ]
            }]
        };
        pie.setOption(option);
        pie.dispatchAction({
            type: 'showTip',
            seriesIndex: 0,
            dataIndex: 0
        });
    }
}