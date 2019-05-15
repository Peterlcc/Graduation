/**
 * 
 */

function houseLog(houseId){
	var userId=$("#userId").text();
	$.ajax({
		type : "POST",
		url : "/user/log",
		dataType : "json",
		data : {
			userId : userId,
			houseId:houseId
		},
		success : function(log) {
			console.log(log);
		}
	});
}

function housePhone(houseId){
	var userId=$("#userId").text();
	$.ajax({
		type : "POST",
		url : "/user/phone",
		dataType : "json",
		data : {
			userId : userId,
			houseId:houseId
		},
		success : function(phone) {
			console.log(phone);
		}
	});
}