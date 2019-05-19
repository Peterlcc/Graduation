function userAnalyze(userSelect, id,aggregateSelect,aggregationSelect) {
	var propertyValue = $('#'+userSelect).val();
	var attr = $('#'+userSelect).find("option:selected").text();
	
	var aggregate=$('#'+aggregateSelect).val();
	var aggregateAttr=$('#'+aggregateSelect).find("option:selected").text();
	
	var aggregation=$('#'+aggregationSelect).val();
	var aggregationAttr=$('#'+aggregationSelect).find("option:selected").text();
	$.ajax({
		type : "POST",
		url : "/analyze/userAnalyze",
		dataType : "json",
		data : {
			property : propertyValue,
			aggregate:aggregate,
			aggregation:aggregation
		},
		success : function(result) {
			userDraw(result, id, attr,aggregateAttr,aggregationAttr);
		}
	});

}

function userDraw(result, id, attr,aggregateAttr,aggregationAttr) {

	var xdata = new Array();
	var ydata = new Array();
	var objs=new Array();
	for (var i = 0; i < result.length; i++) {
		xdata[i] = result[i].property;
		ydata[i] = result[i].num;
		objs[i]=new Object()
		objs[i]={name:result[i].property,value:result[i].num};
	}
	var dom = document.getElementById(id);
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	option = {
		    title : {
		        text: '维度:'+attr+'  度量:'+aggregationAttr+' 聚合方法:'+aggregateAttr,
		        subtext: 'made by ilive',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        x : 'center',
		        y : 'bottom',
		        data:xdata
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel']
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    series : [
		        {
		            name:attr,
		            type:'pie',
		            radius : [30, 110],
		            center : ['50%', 200],
		            roseType : 'area',
		            x: '50%',               // for funnel
		            max: 40,                // for funnel
		            sort : 'ascending',     // for funnel
		            data:objs
		        }
		    ]
		};
	if (option && typeof option === "object") {
		myChart.setOption(option, true);
	}
}