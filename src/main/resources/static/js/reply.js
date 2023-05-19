/*즉시 실행함수 (function(){return})();*/

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content")

var replyManager = (function() {
	//replies/100 특정 보드의 댓글 가져오기
	var getAll2 = function(obj, callback) {
		console.log("get All.....");
		$.getJSON("/app/replies/" + obj, callback);
	};
	//선언적 함수
	function beforeSend(xhr){
		xhr.setRequestHeader(header, token);
	}

	//보드에 댓글 추가 {"bno":111, title: "", "writer":"user"}
	var add2 = function(obj, callback) {
		console.log("add.....");
		$.ajax({
			beforeSend:beforeSend,
			type: "post",
			url: "/app/replies/" + obj.bno,
			data: JSON.stringify(obj),
			dataType: "json",
			contentType: "application/json",
			success: callback
		});
	};
	var update2 = function(obj, callback) {
		$.ajax({
			beforeSend:beforeSend,
			type: "put",
			url: "/app/replies/" + obj.bno,
			data: JSON.stringify(obj),
			dataType: "json",
			contentType: "application/json",
			success: callback
		});
	};

	//
	var remove2 = function(obj, callback) {
		$.ajax({
			beforeSend:beforeSend,
			type: "delete",
			url: "/app/replies/" + obj.bno + "/" + obj.rno,
			dataType: "json",
			contentType: "application/json",
			success: callback
		});

	};
	return { getAll: getAll2, add: add2, update: update2, remove: remove2 };
})();