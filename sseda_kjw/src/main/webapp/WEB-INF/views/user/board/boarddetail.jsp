<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 게시판</title>
<script src="/js/boarddetail.js"></script>
<link rel="stylesheet" href="/css/board.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<input type="hidden" value="${b.like_seqno }" id="like">
<div id="wrap" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
	<div id="detail">
		<h2>${b.title }</h2>
		<c:if test="${b.id eq sess_id }">
			<button style="float:right;" onclick="location.href='/board/delete?no=${b.no}'">삭제</button>
			<button style="float:right;" onclick="location.href='/board/regform?no=${b.no}&content=${b.content }&name=${b.name }&title=${b.title }&open=${b.open }'">수정</button>
		</c:if>
		<button style="float:right;" onclick="location.href='/board/report?no=${b.no}'">신고</button>
		<a style="float:left">${b.name }</a><br>
		<a style="float:left">${b.wdate }</a>
		<a style="float:left">${b.count }</a><br>
		<hr>
		<a style="display:block;height:500px;">${b.content }</a>
		<a style="float:left">좋아요:${b.like }</a><br>
		<c:if test="${sess_id  eq b.id }" >
			<a style="float:left" href="javascript:likeon(${b.no })"><img src="/img/heart.png" style="height:15px;width:15px;"id="no"></a>
			<a style="float:left" href="javascript:likeoff(${b.no })"><img src="/img/heart1.png" style="height:15px;width:15px;"id="yes"></a>
		</c:if>
		댓글 클릭시 디테일 활성화(자신의 댓글만 수정/삭제가능)
		<br>
		<hr>
		<c:if test="${sess_id ne null }">
				<textarea id="content" style="width:85%;resize:none"></textarea>
				<button id="replybutton"style="float:right;">댓글등록</button>
		</c:if>	
		<table id="reply">
			<tr data-no="1"></tr>
		</table>
		<div class="reply_page"></div>
<script type="text/javascript">
$(document).ready(function(){
	
	var board_no ='<c:out value="${b.no}"/>';
	var id ='<c:out value="${sess_id}"/>';
	//댓글등록
	$("#replybutton").on("click",function(e){
		var content = document.getElementById("content").value;
		var reply = {board_no:board_no,id:id,content:content};
		replyService.insert(reply,function(data){
			console.log(data);
			document.getElementById("content").value ="";
			list(-1);
		});
	});
	list(1);
	var page = 1;
	//댓글 리스트
	function list(cpage){
		var board = {board_no:board_no,cpage:cpage || 1};
		replyService.list(board,function(cnt,replylist){
			var listlen = replylist.length || 0 ;
			//댓글등록시
			if(cpage == -1){
				page = Math.ceil(cnt/5.0);
				list(page);
				return;
			}
			if(listlen == 0 ){
				$("#reply").html("");
			}else{
				var str="";
				for(var i = 0; i < listlen; i++){
					str += "<tr data-ro='"+replylist[i].no+"'><td style='width:20%'>" + 
							replylist[i].name +"</td><td style='width:40%' class='replycontent"+replylist[i].no+"'>"+replylist[i].content+
							"</td><td style='width:15%'>"+replylist[i].wdate+"</td><td style='width:20%'>"+
							"<button class='reply_report"+replylist[i].no+"' data-report="+replylist[i].no+">신고</button></td></tr>";
					$("#reply").html(str);
					repage(cnt);
				}
			}
		});
	};
	//페이지분할
	function repage(cnt){
		var row = 5;
		var end = Math.ceil(page/(row*1.0))*row;
		var start = end - (row-1);
		var prev = false;
		if(start != 1){
			prev = true;
		}
		var next = false;
		if(end * row >= cnt){
			end = Math.ceil(cnt/(row*1.0));
		}
		if(end * row < cnt){
			next = true;
		}
		var str = "<div class='page'>";
		if(prev){
			str += "<a calss= 'page-link'>";
			str += "<a href='"+(start-1)+"'이전페이지</a>";
		}
		for(var i = start; i <= end; i++){
			var active = page == i ? "active" : "";
			str += "<a calss= 'page-link"+active+"'>";
			str += "<a data-page='"+i+"'>"+i+"</a></a>";
		}
		if(next){
			str += "<a calss= 'page-link'>";
			str += "<a href='"+(end+1)+"'>다음페이지</a></a>";
		}
		str += "</div>";
		$(".reply_page").html(str);
	};
	//페이지 클릭
	$(".reply_page").on("click","a",function(e){
		var clickpage = $(this).data("page");
		page = clickpage;
		list(page);
	});
	
	//댓글클릭시 디테일
	$("#reply").on("click","tr",function(){
		var rno = $(this).data("ro");
		replyService.detail(rno,function(data){
			if($("#reply_re").prop('tagName') != 'TEXTAREA'){
				if(id == data.id){
					$(".replycontent"+data.no).html("<textarea autofocus id='reply_re'>"+data.content+"</textarea>");
					var str = "<button data-no='"+data.no+"' name='reply_reg'>댓글수정</button><button data-no='"+data.no+"' name ='reply_del'>댓글삭제</button>";
					$(".reply_report"+data.no).replaceWith(str);
				}
			}
		});
	});
	//댓글수정
	$(document).on("click","button[name='reply_reg']",function(){
		var no = $(this).data("no");
		var content = document.getElementById("reply_re").value;
		replyService.update({no:no,content:content},function(data){
			if(data == '수정완료'){
				list(1);
			}
		});
	});
	//댓글삭제
	$(document).on("click","button[name='reply_del']",function(){
		var no = $(this).data("no");
		replyService.del(no,function(data){
			if(data == '삭제성공'){
				list(1);
			}
		});
	});
});
</script>
	</div>
</div>
<%@include file="../footer.jsp" %>	
</body>
</html>