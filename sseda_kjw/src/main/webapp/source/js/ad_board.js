/**
 * 
 */
 
 var AdminBoardService = (function(){
		
	function ad_delete(rno, callback, error){
		$.ajax({
			type : 'delete',
			url : "/admin/delete",
			data : JSON.stringify(rno),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	return {
		del : ad_delete
		};
})();