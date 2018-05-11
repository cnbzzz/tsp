/*small中的地图-begin*/
var center = [113.340393,22.998645];
var map = new AMap.Map('maps', {
    resizeEnable: true,
    center: center,
    zoom: 16
}); 
/*small中的地图-end*/

/*small中的实时状态-采集流量曲线-折线面积图-begin*/
function getLine(){
	var line1 = document.getElementById('small-echarts-line-one');
	var myLine1 = echarts.init(line1);
	var line2 = document.getElementById('small-echarts-line-two');
	var myLine2 = echarts.init(line2);
	var data1 = [30,40,15,40,20,100,12,26,62,19,44,65,58,57,45,63,72,31,23,24,17,36,44,27,50,25,10,10,20,350];
	var data2 = [100,250,30,51,60,50,60,69,30,500,641,450];
	var xAxisData1 = ['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日'];
	var xAxisData2 = ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'];
	var option1 = {
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
					interval:1
				},
				
				nameTextStyle:{
					
				},
				boundaryGap : false,
				data:xAxisData1
			}			
		],
		
		yAxis:[
			{
				tpye:'value',
				name:'(km)',
				nameLocation:'middle',
				nameTextStyle:{
					color:'#fdfdfd'
				},
				nameGap:25,
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
				name:'采集流量曲线',
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
	            data:data1
			}			
		]
	};
	var option2 = {
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
	        width:"94%"
		},
		xAxis:[
			{
				type:'category',
				axisLabel:{
					textStyle:{
						color:'#fdfdfd',
						fontStyle:'italic'
					},
					interval:0
				},
				
				nameTextStyle:{
					
				},
				boundaryGap : false,
				data:xAxisData2
			}			
		],
		
		yAxis:[
			{
				tpye:'value',
				name:'(千km)',
				nameLocation:'middle',
				nameTextStyle:{
					color:'#fdfdfd'
				},
				nameGap:25,
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
				name:'采集流量曲线',
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
	            data:data2
			}			
		]
	};

	myLine1.setOption(option1);
	myLine2.setOption(option2);
}
/*small中的实时状态-采集流量曲线-折线面积图-end*/

/*small中的电池实时监控-begin*/
function getDash1(){
		var myDash = echarts.init(document.getElementById('dash1'));
	var option = {
		backgroundColor: 'transparent',
	    tooltip : {
	        formatter: "{a} <br/> {b} {c}%"
	    },
	    series : [
	        {
	            name:'电流',
	            type:'gauge',
	            min:0,
	            max:100,
	            splitNumber:10,
	            radius: '100%',
	            axisLine: {            // 坐标轴线
	                lineStyle: {       // 属性lineStyle控制线条样式
	                    color: [[0.2, '#82f706'],[0.8, '#00f3f0'],[1, '#fb0609']],
	                    width: 3,
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            axisLabel: {            // 坐标轴小标记
	                textStyle: {       // 属性lineStyle控制线条样式
	                    color:'#fdfdfd',
	                    fontSize:10,
	                    shadowBlur: 10
               		},
               		formatter:function(v){
	                    switch (v + '') {
	                        case '0' : return '0';
	                        case '10' : return '10%';
	                        case '20':return '20%';
	                        case '30' : return '30%';
	                        case '40':return '40%';
	                        case '50' : return '50%';
	                        case '60' : return '60%';
	                        case '70':return '70%';
	                        case '80' : return '80%';
	                        case '90':return '90%';
	                        case '100':return '100%';
	                    }
	                }
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
	                    fontSize: 20,
	                    fontStyle: 'italic',
	                    color: '#fdfdfd',
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            detail : {
//			                backgroundColor: 'rgba(0,0,0,0.3)',
//			                borderWidth: 1,
//			                borderColor: '#fff',
	                // shadowColor : '#fff', //默认透明
//			                shadowBlur: 5,
//			                height:20,
//			                width:60,
	                formatter:'{value}%',
	                offsetCenter: [0, '50%'],       // x, y，单位px
	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                    fontWeight: 'bolder',
	                    color: 'auto',
	                    fontSize:17
	                }
	            },
	            data:[{value:10, name: ''}]
	        }
	      
	    ]
	};
	myDash.setOption(option);
}

function getDash2(){
	var myDash = echarts.init(document.getElementById('dash2'));
	var option = {
		backgroundColor: 'transparent',
	    tooltip : {
	        formatter: "{a} <br/> {b} {c}%"
	    },
	    series : [
	        {
	            name:'电压',
	            type:'gauge',
	            min:0,
	            max:1000,
	            splitNumber:10,
	            radius: '100%',
	            axisLine: {            // 坐标轴线
	                lineStyle: {       // 属性lineStyle控制线条样式
	                    color: [[0.1, '#82f706'],[0.8, '#00f3f0'],[1, '#fb0609']],
	                    width: 3,
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            axisLabel: {            // 坐标轴小标记
	                textStyle: {       // 属性lineStyle控制线条样式
	                    color:'#fdfdfd',
	                    fontSize:10,
	                    shadowBlur: 10
               		},
               		formatter:function(v){
	                    switch (v + '') {
	                        case '0' : return '0';
	                        case '100' : return '100V';
	                        case '200':return '200V';
	                        case '300' : return '300V';
	                        case '400':return '400V';
	                        case '500' : return '500V';
	                        case '600' : return '600V';
	                        case '700':return '700V';
	                        case '800' : return '800V';
	                        case '900':return '900V';
	                        case '1000':return '1000V'
	                    }
	                }
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
	                    fontSize: 20,
	                    fontStyle: 'italic',
	                    color: '#fdfdfd',
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            detail : {
//			                backgroundColor: 'rgba(0,0,0,0.3)',
//			                borderWidth: 1,
//			                borderColor: '#fff',
	                // shadowColor : '#fff', //默认透明
//			                shadowBlur: 5,
//			                height:20,
//			                width:60,
	                formatter:'{value}V',
	                offsetCenter: [0, '50%'],       // x, y，单位px
	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                    fontWeight: 'bolder',
	                    color: 'auto',
	                    fontSize:17
	                }
	            },
	            data:[{value:100, name: ''}]
	        }
	      
	    ]
	};
	myDash.setOption(option);
}

function getDash3(){
	var myDash = echarts.init(document.getElementById('dash3'));
	var option = {
		backgroundColor: 'transparent',
	    tooltip : {
	        formatter: "{a} <br/> {b} {c}%"
	    },
	    series : [
	        {
	            name:'电流',
	            type:'gauge',
	            min:0,
	            max:2000,
	            splitNumber:10,
	            radius: '100%',
	            axisLine: {            // 坐标轴线
	                lineStyle: {       // 属性lineStyle控制线条样式
	                    color: [[0.2, '#82f706'],[0.82, '#00f3f0'],[1, '#fb0609']],
	                    width: 3,
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            axisLabel: {            // 坐标轴小标记
	                textStyle: {       // 属性lineStyle控制线条样式
	                    color:'#fdfdfd',
	                    fontSize:10,
	                    shadowBlur: 10
               		},
               		formatter:function(v){
	                    switch (v + '') {
	                        case '0' : return '0';
	                        case '200' : return '200A';
	                        case '400':return '400A';
	                        case '600' : return '600A';
	                        case '800':return '800A';
	                        case '1000' : return '1000A';
	                        case '1200' : return '1200A';
	                        case '1400':return '1400A';
	                        case '1600' : return '1600A';
	                        case '1800':return '1800A';
	                        case '2000':return '2000A'
	                    }
	                }
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
	                    fontSize: 20,
	                    fontStyle: 'italic',
	                    color: '#fdfdfd',
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            detail : {
//			                backgroundColor: 'rgba(0,0,0,0.3)',
//			                borderWidth: 1,
//			                borderColor: '#fff',
	                // shadowColor : '#fff', //默认透明
//			                shadowBlur: 5,
//			                height:20,
//			                width:60,
	                formatter:'{value}A',
	                offsetCenter: [0, '50%'],       // x, y，单位px
	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                    fontWeight: 'bolder',
	                    color: 'auto',
	                    fontSize:17
	                }
	            },
	            data:[{value:100, name: ''}]
	        }
	      
	    ]
	};
	myDash.setOption(option);
}

function getDash4(){
	var myDash = echarts.init(document.getElementById('dash4'));
	var option = {
		backgroundColor: 'transparent',
	    tooltip : {
	        formatter: "{a} <br/> {b} {c}%"
	    },
	    series : [
	        {
	            name:'温度',
	            type:'gauge',
	            min:-90,
	            max:90,
	            splitNumber:18,
	            radius: '100%',
	            axisLine: {            // 坐标轴线
	                lineStyle: {       // 属性lineStyle控制线条样式
	                    color: [[0.2, '#82f706'],[0.82, '#00f3f0'],[1, '#fb0609']],
	                    width: 3,
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            axisLabel: {            // 坐标轴小标记
	                textStyle: {       // 属性lineStyle控制线条样式
	                    color:'#fdfdfd',
	                    fontSize:8,
	                    shadowBlur: 10
               		},
               		formatter:function(v){
	                    switch (v + '') {
	                        case '-90' : return '-90°';
	                        case '-80' : return '-80°';
	                        case '-70':return '-70°';
	                        case '-60' : return '-60°';
	                        case '-50':return '-50°';
	                        case '-40' : return '-40°';
	                        case '-30' : return '-30°';
	                        case '-20':return '-20°';
	                        case '-10' : return '-10°';
	                        case '0':return '0°';
	                        case '10' : return '10°';
	                        case '20':return '20°';
	                        case '30' : return '30°';
	                        case '40':return '40°';
	                        case '50' : return '50°';
	                        case '60' : return '60°';
	                        case '70':return '70°';
	                        case '80' : return '80°';
	                        case '90':return '90°'
	                    }
	                }
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
	                    fontSize: 20,
	                    fontStyle: 'italic',
	                    color: '#fdfdfd',
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            detail : {
//			                backgroundColor: 'rgba(0,0,0,0.3)',
//			                borderWidth: 1,
//			                borderColor: '#fff',
	                // shadowColor : '#fff', //默认透明
//			                shadowBlur: 5,
//			                height:20,
//			                width:60,
	                formatter:'{value}°',
	                offsetCenter: [0, '50%'],       // x, y，单位px
	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                    fontWeight: 'bolder',
	                    color: 'auto',
	                    fontSize:17
	                }
	            },
	            data:[{value:10, name: ''}]
	        }
	      
	    ]
	};
	myDash.setOption(option);
}

function getDash5(){
	var myDash = echarts.init(document.getElementById('dash5'));
	var option = {
		backgroundColor: 'transparent',
	    tooltip : {
	        formatter: "{a} <br/> {b} {c}%"
	    },
	    series : [
	        {
	            name:'氢气浓度',
	            type:'gauge',
	            min:0,
	            max:100,
	            splitNumber:10,
	            radius: '100%',
	            axisLine: {            // 坐标轴线
	                lineStyle: {       // 属性lineStyle控制线条样式
	                    color: [[0.2, '#82f706'],[0.8, '#00f3f0'],[1, '#fb0609']],
	                    width: 3,
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            axisLabel: {            // 坐标轴小标记
	                textStyle: {       // 属性lineStyle控制线条样式
	                    color:'#fdfdfd',
	                    fontSize:10,
	                    shadowBlur: 10
               		},
               		formatter:function(v){
	                    switch (v + '') {
	                        case '0' : return '0';
	                        case '10' : return '10%';
	                        case '20':return '20%';
	                        case '30' : return '30%';
	                        case '40':return '40%';
	                        case '50' : return '50%';
	                        case '60' : return '60%';
	                        case '70':return '70%';
	                        case '80' : return '80%';
	                        case '90':return '90%';
	                        case '100':return '100%';
	                    }
	                }
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
	                    fontWeight: '600',
	                    fontSize: 10,
	                    fontStyle: 'normal',
	                    color: '#fdfdfd',
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            detail : {
//			                backgroundColor: 'rgba(0,0,0,0.3)',
//			                borderWidth: 1,
//			                borderColor: '#fff',
	                // shadowColor : '#fff', //默认透明
//			                shadowBlur: 5,
//			                height:20,
//			                width:60,
	                formatter:'{value}%',
	                offsetCenter: [0, '50%'],       // x, y，单位px
	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                    fontWeight: 'bolder',
	                    color: 'auto',
	                    fontSize:17
	                }
	            },
	            data:[{value:90, name: 'mg/km'}]
	        }
	      
	    ]
	};
	myDash.setOption(option);
}

function getDash6(){
	var myDash = echarts.init(document.getElementById('dash6'));
	var option = {
		backgroundColor: 'transparent',
	    tooltip : {
	        formatter: "{a} <br/> {b} {c}%"
	    },
	    series : [
	        {
	            name:'高压DC/DC状态',
	            type:'gauge',
	            min:0,
	            max:2,
	            splitNumber:2,
	            radius: '100%',
	            axisLine: {            // 坐标轴线
	                lineStyle: {       // 属性lineStyle控制线条样式
	                    color: [[0.2, '#82f706'],[0.8, '#00f3f0'],[1, '#fb0609']],
	                    width: 3,
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            axisLabel: {            // 坐标轴小标记
	                textStyle: {       // 属性lineStyle控制线条样式
	                    color:'#fdfdfd',
	                    fontSize:10,
	                    shadowBlur: 10
               		},
               		formatter:function(v){
	                    switch (v + '') {
	                        case '0' : return '未工作';
	                        case '1' : return '状态';
	                        case '2':return '工作中'
	                    }
	                }
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
	                    fontWeight: '600',
	                    fontSize: 10,
	                    fontStyle: 'normal',
	                    color: '#fdfdfd',
	                    // shadowColor : '#fff', //默认透明
	                    shadowBlur: 10
	                }
	            },
	            detail : {
//			                backgroundColor: 'rgba(0,0,0,0.3)',
//			                borderWidth: 1,
//			                borderColor: '#fff',
	                // shadowColor : '#fff', //默认透明
//			                shadowBlur: 5,
//			                height:20,
//			                width:60,
					show:false,
	                offsetCenter: [0, '50%'],       // x, y，单位px
	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                    fontWeight: 'bolder',
	                    color: 'auto',
	                    fontSize:17
	                }
	            },
	            data:[{value:2, name: ''}]
	        }
	      
	    ]
	};
	myDash.setOption(option);
}
/*small中的电池实时监控-end*/
