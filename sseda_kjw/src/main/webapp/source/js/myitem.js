var myitem = (function(){
	
	function del(obj,callback,error) {
		
		console.log("del 함수 작동");
		
		$.ajax({
			type : 'POST',
			url : '/item/myitemdel',
			data : JSON.stringify(obj),
			contentType : "application/json; charset=utf-8",
			
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			
			error : function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
			
		});
		
		
		
	}
	
	return{del:del};
	
})();