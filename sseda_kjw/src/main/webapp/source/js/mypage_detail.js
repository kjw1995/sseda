var mypage = (function() {
	
	function list(param, callback, error) {
		var id = param.id;
		var cate = param.cate;
		var page = param.currentPage || 1;
		console.log("넘길떄 페이지값 확인 = " + page);
		
		$.getJSON("/memre/mypagelist/" + id + "/" + cate + "/" + page + ".json", function(data) {
			if(callback) {
				callback(data);
			}
		}).fail(function(xhr,status,err){
			if(err) {
				error();
			}
		});
	}
	
	return {list:list};
	
})();