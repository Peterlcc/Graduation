function allAnalyze(allUserSelect, allHouseSelect, allMiddleSelect, id) {
	var userIndex = allUserSelect.selectedIndex;
	var userAttr = allUserSelect.options[userIndex].text;
	var userPropertyValue = allUserSelect.value;

	var houseIndex = allHouseSelect.selectedIndex;
	var houseAttr = allHouseSelect.options[houseIndex].text;
	var housePropertyValue = allHouseSelect.value;

	var middleIndex = allMiddleSelect.selectedIndex;
	var middleAttr = allMiddleSelect.options[middleIndex].text;
	var middlePropertyValue = allMiddleSelect.value;

	$.ajax({
		type : "POST",
		url : "/analyze/userAndHouseAnalyze",
		dataType : "json",
		data : {
			userProperty : userPropertyValue,
			houseProperty : housePropertyValue,
			middleTable : middlePropertyValue
		},
		success : function(result) {
			allDraw(result, id, userAttr, houseAttr, middleAttr);
		}
	});

}

function allDraw(result, id, userAttr, houseAttr, middleAttr) {

	var hours = new Array();
	var days = new Array();
	var data = new Array();
	for (var i = 0; i < result.length; i++) {
		hours[i] = result[i].userProperty;
		days[i] = result[i].houseProperty;
	}
	hours = Array.from(new Set(hours));
	days = Array.from(new Set(days));
	for (var i = 0; i < result.length; i++) {
		var item = new Array();
		item[0] = days.indexOf(result[i].houseProperty);
		item[1] = hours.indexOf(result[i].userProperty);
		item[2] = result[i].num;
		data[i] = item;
	}
	console.log(data);
	var dom = document.getElementById(id);
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
		title : {
			text : houseAttr+"-"+userAttr+' 统计,关联自 <'+middleAttr+'> 表'
		},
		tooltip : {},
		visualMap : {
			max : 20,
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
			boxWidth : 100,
			boxDepth : 60,
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
			data : data.map(function(item) {
				return {
					value : [ item[1], item[0], item[2] ],
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