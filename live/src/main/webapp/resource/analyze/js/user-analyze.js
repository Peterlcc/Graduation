function userAnalyze(userSelect, id) {
	var index=userSelect.selectedIndex;
	var attr = userSelect.options[index].text;
	var propertyValue = userSelect.value;
	$.ajax({
		type : "POST",
		url : "/analyze/userAnalyze",
		dataType : "json",
		data : {
			property : propertyValue
		},
		success : function(result) {
			userDraw(result, id, attr);
		}
	});

}

function userDraw(result, id, attr) {

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
		        text: attr,
		        subtext: 'made by peter',
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