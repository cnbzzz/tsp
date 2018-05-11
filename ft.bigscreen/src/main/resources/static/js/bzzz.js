/**
 * This file is part of 车联网大屏 Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/23 11:45
 * Copyright (c) 2017 www.space-walker.cn
 *
 */

function showHeatMap(url, heatMap) {
    return myAjax(url, {}, function (result) {
        if (result.retCode == 1) {
            var dataList = result.data.dataList;
            var max = result.data.max;
            var option = {visualMap: {'max': max}, series: [{'data': convertData(dataList)}]};
            heatMap.setOption(option);
        }
    });
}

function showVehPie(url, pie, vue) {
    return myAjax(url, {}, function (result) {
        if (result.retCode == 1) {
            var vueData = result.data;
            var lengData = [];
            var pieData = [];
            var totalDrivingCount = vueData.totalDrivingCount;
            var totalChargingCount = vueData.totalChargingCount;
            var totalOfflineCount = vueData.totalOfflineCount;
            
            totalDrivingCount && lengData.push('行驶');
			totalDrivingCount && pieData.push({'value':totalDrivingCount || 0, 'name':'行驶'});
			totalChargingCount && lengData.push('充电');
			totalChargingCount && pieData.push({'value':totalChargingCount || 0, 'name':'充电'});
			totalOfflineCount && lengData.push('离线');
			totalOfflineCount && pieData.push({'value':totalOfflineCount || 0, 'name':'离线'});
            var option = {
            	'legend':{
        			textStyle: {
		            	color:'#fdfdfd'
		           },
					data:lengData
				},
                'series': {
                    'data':pieData
                }
            };
            pie.setOption(option);
            vue.veh = vueData;
        }
    });
}

function initVue(id, obj, computed) {
    return new Vue({
        el: '#' + id,
        data: obj || {},
        computed: computed || {}
    });
}
