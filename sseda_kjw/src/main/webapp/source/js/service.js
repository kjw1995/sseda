	function all(){
		var all = document.getElementById("all").style.backgroundColor
		var mem = document.getElementById("mem").style.backgroundColor
		var lim = document.getElementById("lim").style.backgroundColor
		var bre = document.getElementById("bre").style.backgroundColor
		var data = document.getElementById("data").style.backgroundColor
		var men = document.getElementById("men").style.backgroundColor
		if(all == "rgb(217, 217, 217)"){
			document.getElementById("all").style.backgroundColor="Thistle";
			document.getElementById("mem").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("lim").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("bre").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("data").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("men").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("allbox").style.display="contents"
			document.getElementById("membox").style.display="none"
			document.getElementById("limit").style.display="none"
			document.getElementById("braek").style.display="none"
			document.getElementById("databox").style.display="none"
			document.getElementById("menbox").style.display="none"
		} else{
			document.getElementById("all").style.backgroundColor="rgb(217, 217, 217)";
		}
	}
	function mem(){
		var all = document.getElementById("all").style.backgroundColor
		var mem = document.getElementById("mem").style.backgroundColor
		var lim = document.getElementById("lim").style.backgroundColor
		var bre = document.getElementById("bre").style.backgroundColor
		var data = document.getElementById("data").style.backgroundColor
		var men = document.getElementById("men").style.backgroundColor
		if(mem === "rgb(217, 217, 217)"){
			document.getElementById("mem").style.backgroundColor="Thistle";
			document.getElementById("all").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("lim").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("bre").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("data").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("men").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("membox").style.display="contents"
			document.getElementById("limit").style.display="none"
			document.getElementById("allbox").style.display="none"
			document.getElementById("menbox").style.display="none"
			document.getElementById("braek").style.display="none"
			document.getElementById("databox").style.display="none"
		} else{
			document.getElementById("mem").style.backgroundColor="rgb(217, 217, 217)";
		}
	}
	function lim(){
		var all = document.getElementById("all").style.backgroundColor
		var mem = document.getElementById("mem").style.backgroundColor
		var lim = document.getElementById("lim").style.backgroundColor
		var bre = document.getElementById("bre").style.backgroundColor
		var data = document.getElementById("data").style.backgroundColor
		var men = document.getElementById("men").style.backgroundColor
		if(lim === "rgb(217, 217, 217)"){
			document.getElementById("lim").style.backgroundColor="Thistle";
			document.getElementById("mem").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("all").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("bre").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("data").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("men").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("limit").style.display="contents"
			document.getElementById("allbox").style.display="none"
			document.getElementById("menbox").style.display="none"
			document.getElementById("braek").style.display="none"
			document.getElementById("databox").style.display="none"
			document.getElementById("membox").style.display="none"
		} else{
			document.getElementById("lim").style.backgroundColor="rgb(217, 217, 217)";
		}
	}
	function bre(){
		var all = document.getElementById("all").style.backgroundColor
		var mem = document.getElementById("mem").style.backgroundColor
		var lim = document.getElementById("lim").style.backgroundColor
		var bre = document.getElementById("bre").style.backgroundColor
		var data = document.getElementById("data").style.backgroundColor
		var men = document.getElementById("men").style.backgroundColor
		if(bre === "rgb(217, 217, 217)"){
			document.getElementById("bre").style.backgroundColor="Thistle";
			document.getElementById("mem").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("lim").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("all").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("data").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("men").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("braek").style.display="contents"
			document.getElementById("limit").style.display="none"
			document.getElementById("allbox").style.display="none"
			document.getElementById("membox").style.display="none"
			document.getElementById("menbox").style.display="none"
			document.getElementById("databox").style.display="none"
		} else{
			document.getElementById("bre").style.backgroundColor="rgb(217, 217, 217)";
		}
	}
	function men(){
		var all = document.getElementById("all").style.backgroundColor
		var mem = document.getElementById("mem").style.backgroundColor
		var lim = document.getElementById("lim").style.backgroundColor
		var bre = document.getElementById("bre").style.backgroundColor
		var data = document.getElementById("data").style.backgroundColor
		var men = document.getElementById("men").style.backgroundColor
		if(data === "rgb(217, 217, 217)"){
			document.getElementById("men").style.backgroundColor="Thistle";
			document.getElementById("data").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("mem").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("lim").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("bre").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("all").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("menbox").style.display="contents"
			document.getElementById("databox").style.display="none"
			document.getElementById("braek").style.display="none"
			document.getElementById("limit").style.display="none"
			document.getElementById("allbox").style.display="none"
			document.getElementById("membox").style.display="none"
		} else{
			document.getElementById("all").style.backgroundColor="rgb(217, 217, 217)";
		}
	}
	function data(){
		var all = document.getElementById("all").style.backgroundColor
		var mem = document.getElementById("mem").style.backgroundColor
		var lim = document.getElementById("lim").style.backgroundColor
		var bre = document.getElementById("bre").style.backgroundColor
		var data = document.getElementById("data").style.backgroundColor
		var men = document.getElementById("men").style.backgroundColor
		if(data === "rgb(217, 217, 217)"){
			document.getElementById("data").style.backgroundColor="Thistle";
			document.getElementById("mem").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("lim").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("bre").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("all").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("men").style.backgroundColor="rgb(217, 217, 217)";
			document.getElementById("databox").style.display="contents"
			document.getElementById("braek").style.display="none"
			document.getElementById("limit").style.display="none"
			document.getElementById("allbox").style.display="none"
			document.getElementById("menbox").style.display="none"
			document.getElementById("membox").style.display="none"
		} else{
			document.getElementById("all").style.backgroundColor="rgb(217, 217, 217)";
		}
	}
	
	var qnaservice =(function(){
		function detail(no,callback,error){
			$.ajax({
				type : 'post',
				url : '/qna/detail',
				data : JSON.stringify(no),
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
		return {detail:detail};
	})();
	
	function mclose(){
		document.getElementById("modal").style.display = "none"
	}
	function answer(){
		document.getElementById("answer").style.display ="block"
	}
	function answerclose(){
		document.getElementById("answer").style.display ="none"
	}	
	