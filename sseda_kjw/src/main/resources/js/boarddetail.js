function replyupdate(no){
	
			document.getElementById("replyup").style.display="block";
			var x = new XMLHttpRequest(); 
					x.onreadystatechange = function(){
						t = document.forms[replyup][content].value;
						t.innerHTML = x.responseText.trim();
					};
				x.open("POST","/sseda/bo/reply_re",true);
				x.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
				x.send("no="+no);
}
function replayclose(){
	document.getElementById("replyup").style.display="none"
}
/*
function view(){
		var l = document.getElementById("like").value;
		if(l == 'no'){
			document.getElementById("no").style.display="inline";
		}else{
			document.getElementById("yes").style.display="inline";
		}
}
*/
function likeon(no){
		var x = new XMLHttpRequest(); 
			x.onreadystatechange = function(){
				document.getElementById("yes").style.display="inline";
				document.getElementById("no").style.display="none";
			};
		x.open("POST","/sseda/bo/like",true);
		x.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
		x.send("no="+no+"&stat=1");
	}
function likeoff(no){
	var x = new XMLHttpRequest(); 
			x.onreadystatechange = function(){
				document.getElementById("no").style.display="inline";
				document.getElementById("yes").style.display="none";
			};
		x.open("POST","/sseda/bo/like",true);
		x.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
		x.send("no="+no+"&stat=");
}

var replyService = (function(){
	function replyinsert(reply, callback,error){
		$.ajax({
			type : 'post',
			url : '/reply/insert',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(data,status,xhr){
				if(callback){
					callback(data);
				}
			},
			error : function(status,xhr,er){
				if(er){
					error(er);
				}
			}
		});
	}
	function replylist(board,callback,error){
		$.ajax({
			type : 'get',
			url : '/reply/list/'+board.board_no+'/'+board.cpage,
			contentType : "application/json; charset=utf-8",
			success : function(data,status,xhr){
				if(callback){
					callback(data.total,data.reply);
				}
			},
			error : function(xhr,status,er){
				if(er){
					error(er);
				}
			}
		});
	};
	function replydetail(no,callback,error){
		$.ajax({
			type : 'post',
			url : '/reply/detail',
			data : JSON.stringify(no),
			contentType : "application/json; charset=utf-8",
			success : function(data,stasus,xhr){
				if(callback){
					callback(data);
				}
			},
			error : function(status,xhr,er){
				if(er){
					error(er);
				}
			}
		});
	};
	function replyupdate(reply,callback,error){
		$.ajax({
			type : 'put',
			url : '/reply/reg',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(data,status,xhr){
				if(callback){
					callback(data);
				}
			},
			error : function(status,xhr,er){
				if(error){
					error(er);
				}
			}
		});
	};
	function replydelete(no,callback,error){
		$.ajax({
			type : 'delete',
			url : '/reply/delete',
			data : JSON.stringify(no),
			success : function(data,status,xhr){
				if(callback){
					callback(data);
				}
			},
			error : function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});
	};

	return {insert:replyinsert,list:replylist,detail:replydetail,update:replyupdate,del:replydelete};
})();