/**
 * 
 */
function houseAnalyze(houseSelect, id) {
	var index=houseSelect.selectedIndex;
	var attr = houseSelect.options[index].text;
	var propertyValue=houseSelect.value;
	console.log(propertyValue);
	$.ajax({
		type : "POST",
		url : "/analyze/houseAnalyze",
		dataType : "json",
		data : {
			property : propertyValue
		},
		success : function(result) {
			houseDraw(result, id,attr);
		}
	});

}

function houseDraw(result, id,attr) {
	
	var xdata=new Array();
	var ydata=new Array();
	for(var i=0;i<result.length;i++){
		xdata[i]=result[i].property;
		ydata[i]=result[i].num;
	}
	
	var dom = document.getElementById(id);
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
		title : {
			text : attr,
			subtext : 'made by peter'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ attr ]
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			data : xdata
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [
				{
					name : attr,
					type : 'bar',
					data : ydata,
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				}, ]
	};
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}