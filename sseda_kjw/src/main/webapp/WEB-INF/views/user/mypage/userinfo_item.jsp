<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/useritem.css">
<link rel="stylesheet" href="/css/useritem_list.css">
<script src="/js/myitem.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div id="wrap">
 <%@ include file = "../header.jsp" %>
 <%@ include file = "../menu.jsp" %>
<section>
<div class="container">
	<div class="locate-rwd-table">
		<h1>내 아이템 정보</h1>
	<c:set value="${myitem}" var="myitem" />
	<input type="hidden" id="id" value="${id}">	
	<form method="GET" action="itemdel">
  		<table class="rwd-table">
	    	<tbody>
		      <tr>
		      	<th></th>
		        <th>번호</th>
		        <th>아이템제목</th>
		        <th>가격</th>
		        <th>공개여부</th>		        
		        <th>매칭여부</th>
		        <th>아이템등록일자</th>
		      </tr>
		      <c:forEach items="${myitem}" var="item">
			      <tr>
			      	<td><input type="checkbox" class="myitemdel" name="myitemdel" data-ino="${item.seqno}" value="${item.seqno}"></td>
			        <td onclick="location.href='/it/detail?no=${item.seqno}'">${item.seqno }</td>
			        <td>${item.title }</td>
			        <td>${item.price }</td>
			        <c:choose>
				        <c:when test="${item.open eq 'Y' }">
				        <td>공개</td>
			        </c:when>
			        <c:otherwise>
			        	<td>비공개</td>
			        </c:otherwise>
			        </c:choose>
			        <c:choose>
				        <c:when test="${item.matching eq 'Y' }">
				        <td>매칭완료</td>
			        </c:when>
			        <c:otherwise>
			        	<td>매칭중</td>
			        </c:otherwise>
			        </c:choose>
			        <td>${item.wdate }</td>
			      </tr>
		      </c:forEach>
	    	</tbody>
	  	</table>
	  	<input type="button" id="del-btn" value="삭제">
  	</form>
  </div>
</div>

	<%-- <div class="pagination">
	    <c:if test="${page.prev }">
		  <a href="/boardList.bo?cpage=${page.start -1 }&row=${page.c.row}">&laquo;</a>
		 </c:if>
		  <c:forEach var="n" begin="${page.start}" end="${page.end}">
		  	<a href="/boardList.bo?cpage=${n}&row=${page.c.row}"
		  	class="${page.c.cpage == n ?"active" :"" }">${n}</a>
		  </c:forEach>
		 <c:if test="${page.next }">
		  <a href="/boardList.bo?cpage=${page.end +1 }&row=${page.c.row}">&raquo;</a>
		 </c:if>
		</div> --%>
</section>
<%@ include file="../footer.jsp" %>
</div>
</body>
<script>
var id = document.getElementById("id").value;
$(".footer-distributed").css({"transform":"translate(-90%,15%)"});



$(document).ready(function(){
	$("#del-btn").on("click",function(){
		var obj = putIno();
		console.log("넘어오는 객체 = " + obj);
		/* console.log("넘어오는 시퀀스번호 = " + obj.seqno); */
		myitem.del(obj, function(result){
			if(result == "suc") {
				location.href="/mem/userinfoitem?id=" + id;
			} else {
				return false;
			}
			
		});
				
	});
	
function putIno() {
	
	var idxArr = new Array();
	var seqno = new Array();
	var inoObj = new Object();
	
	$("input[name=myitemdel]:checked").each(function() {
		idxArr.push($("input[name=myitemdel]").index(this));
	});

	for (var i = 0; i < idxArr.length; i++) {
		console.log("인덱스번호 = " + idxArr[i]);
		console.log("삭제할 아이템 시퀀스 번호 = " + $(".rwd-table tbody").children().eq(idxArr[i]+1).children().eq(1).text());
		seqno[i] = $(".rwd-table tbody").children().eq(idxArr[i]+1).children().eq(1).text();
		/* console.log(inoObj[i]); */
		 
	}
	
	inoObj = {
			seqno : seqno	
		}; 
	
	/* console.log("함수 실행 후 객체 = " + inoObj); */
	return inoObj.seqno;
	
}
	
	/* myitem.del(ino,function(result){
			
		if(result == "compl") {
			location.href="/mem/myitem?id=" + id;
		}
	});
 */	
 });
</script>
</html>