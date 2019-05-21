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
				focus.children[0].setAttribute("class","fa fa-star text-red");
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
			//console.log(collect);
		}
	});
	var focus=document.getElementById("focus");
	if(focus.children[0].getAttribute("class")=='fa fa-star text-red'){
		focus.children[0].setAttribute("class","fa fa-star-o");
	}
	else {
		focus.children[0].setAttribute("class","fa fa-star text-red");
	}
	
	
}