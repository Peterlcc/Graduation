/**
 * 
 */
function setCollect(){
	var userId=$("#userId").text();
	var houseId=$("#houseid").text();
	$.ajax({
		type : "POST",
		url : "/user/collect",
		dataType : "json",
		data : {
			userId : userId,
			houseId:houseId
		},
		success : function(collect) {
			console.log(collect);
			if(collect!=null){
				var focus=document.getElementById("focus");
				focus.style.background='red';
			}
		}
	});
}
function userCollect(){
	var userId=$("#userId").text();
	var houseId=$("#houseid").text();
	$.ajax({
		type : "POST",
		url : "/user/userCollect",
		dataType : "json",
		data : {
			userId : userId,
			houseId:houseId
		},
		success : function(collect) {
			console.log(collect);
		}
	});
	var focus=document.getElementById("focus");
	if(focus.style.backgroundColor=='red'){
		document.getElementById("focus").style.backgroundColor="gainsboro";
	}
	else {
		document.getElementById("focus").style.backgroundColor="red";
	}
	
	
}