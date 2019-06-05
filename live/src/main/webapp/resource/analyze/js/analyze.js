function allAnalyze(allUserSelect, allHouseSelect, allMiddleSelect, id,aggregateSelect,aggregationSelect) {
	var userPropertyValue = $('#'+allUserSelect).val();
	var userAttr = $('#'+allUserSelect).find("option:selected").text();
	
	var housePropertyValue = $('#'+allHouseSelect).val();
	var houseAttr = $('#'+allHouseSelect).find("option:selected").text();
	
	var middlePropertyValue = $('#'+allMiddleSelect).val();
	var middleAttr = $('#'+allMiddleSelect).find("option:selected").text();

	var aggregate=$('#'+aggregateSelect).val();
	var aggregateAttr=$('#'+aggregateSelect).find("option:selected").text();
	
	var aggregation=$('#'+aggregationSelect).val();
	var aggregationAttr=$('#'+aggregationSelect).find("option:selected").text();
	$.ajax({
		type : "POST",
		url : "/analyze/userAndHouseAnalyze",
		dataType : "json",
		data : {
			userProperty : userPropertyValue,
			houseProperty : housePropertyValue,
			middleTable : middlePropertyValue,
			aggregate:aggregate,
			aggregation:aggregation
		},
		success : function(result) {
			allDraw(result, id, userAttr, houseAttr, middleAttr,aggregateAttr,aggregationAttr);
		}
	});

}

function allDraw(result, id, userAttr, houseAttr, middleAttr,aggregateAttr,aggregationAttr) {

	var hours = new Array();
	var days = new Array();
	var data = new Array();
	for (var i = 0; i < result.length; i++) {
		hours[i] = result[i].userProperty;
		days[i] = result[i].houseProperty;
	}
	hours = Array.from(new Set(hours));
	days = Array.from(new Set(days));
	var maxNum=0;
	for (var i = 0; i < result.length; i++) {
		var item = new Array();
		item[0] = days.indexOf(result[i].houseProperty);
		item[1] = hours.indexOf(result[i].userProperty);
		item[2] = result[i].num;
		maxNum=Math.max(maxNum,result[i].num);
		data[i] = item;
	}
	var dom = document.getElementById(id);
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
		title : {
			text : '维度:房屋'+houseAttr+"-用户"+userAttr+'  度量:'+aggregationAttr+' 聚合方法:'+aggregateAttr+' 中间表:'+middleAttr,
		},
		tooltip : {},
		visualMap : {
			max : maxNum,
			inRange : {
				color : [ '#313695', '#4575b4', '#74add1', '#abd9e9',
						'#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43',
						'#d73027', '#a50026' ]
			}
		},
		xAxis3D : {
			name:userAttr,
			nameTextStyle:{
	            color:"balck", 
	            fontSize:16,  
	            padding:5
	        },
			type : 'category',
			data : hours,
			axisLabel:{
	              rotate:45, //刻度旋转45度角
	              textStyle:{
	                 color:"black",
	                 fontSize:8
	           }
	    	}
		},
		yAxis3D : {
			name:houseAttr,
			nameTextStyle:{
	            color:"balck", 
	            fontSize:16,  
	            padding:5
	        },
	        type: 'category',
	        data: days,
	        axisLabel:{
	              rotate:45, //刻度旋转45度角
	              textStyle:{
	                 color:"black",
	                 fontSize:8
	           }
	    	}
		},
		zAxis3D : {
			type : 'value',
			name:"数量"
		},
		grid3D : {
			boxWidth : 130,
			boxDepth : 70,
			viewControl : {
			// projection: 'orthographic'
			},
			light : {
				main : {
					intensity : 1.2,
					shadow : true
				},
				ambient : {
					intensity : 0.3
				}
			}
		},
		series : [ {
			type : 'bar3D',
			name:aggregationAttr+'的'+aggregateAttr,
			data : data.map(function(item) {
				return {
					value : [ item[1], item[0], item[2] ],
					name:[ hours[item[1]], days[item[0]], '值:'+item[2] ]
				}
			}),
			shading : 'lambert',

			label : {
				textStyle : {
					fontSize : 16,
					borderWidth : 1
				}
			},

			emphasis : {
				label : {
					textStyle : {
						fontSize : 20,
						color : '#900'
					}
				},
				itemStyle : {
					color : '#900'
				}
			}
		} ]
	};
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}