/**
 * 
 */
function houseAnalyze(houseSelect, id,aggregateSelect,aggregationSelect) {
	var propertyValue=$('#'+houseSelect).val();
	var attr = $('#'+houseSelect).find("option:selected").text();
	
	var aggregate=$('#'+aggregateSelect).val();
	var aggregateAttr=$('#'+aggregateSelect).find("option:selected").text();
	
	var aggregation=$('#'+aggregationSelect).val();
	var aggregationAttr=$('#'+aggregationSelect).find("option:selected").text();
	
	$.ajax({
		type : "POST",
		url : "/analyze/houseAnalyze",
		dataType : "json",
		data : {
			property : propertyValue,
			aggregate:aggregate,
			aggregation:aggregation
		},
		success : function(result) {
			houseDraw(result, id,attr,aggregateAttr,aggregationAttr);
		}
	});

}

function houseDraw(result, id,attr,aggregateAttr,aggregationAttr) {
	
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
			text :  '维度:'+attr+'  度量:'+aggregationAttr+' 聚合方法:'+aggregateAttr,
			subtext : 'made by ilive'
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