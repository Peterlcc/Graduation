/**
 * 页面的房屋的条件查询处理
 */

function areaSearch(obj) {
	console.log("***");
	var areaName = obj.value;
	var area = obj.innerText;
	$.ajax({
		type : "POST",
		url : "/house/area",
		dataType : "json",
		data : {
			name : areaName
		},
		success : function(area) {
			console.log(area);
			var streetSelect = document.getElementById("streetSelect");
			while (streetSelect.hasChildNodes()) {
				streetSelect.removeChild(streetSelect.firstChild);
			}
			var pleaseOption = document.createElement("option");
			pleaseOption.value = "";
			pleaseOption.innerHTML = "请选择";

			streetSelect.appendChild(pleaseOption);
			for (var i = 0; i < area.streets.length; i++) {
				var street = area.streets[i];
				var streetOption = document.createElement("option");
				streetOption.value = street.name;
				streetOption.innerHTML = street.name;
				streetOption.className = "street";
				streetSelect.appendChild(streetOption);
			}
			console.log(area.streets.length);
		}
	});
}