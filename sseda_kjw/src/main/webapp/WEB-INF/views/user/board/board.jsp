<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트게시판</title>
<link rel="stylesheet" href="/css/board.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/insert.js"></script>
</head>
<body>
<div id="wrap" style="margin-top: 50px;">
	<%@ include file="../header.jsp" %>
	<%@ include file="../menu.jsp" %>
	<br>
	<div class="container">
		<c:if test="${sess_id != null }">
			<c:set value="${sess_id }" var="id"/>
		</c:if>
		<c:if test="${sess_id == null }">
			<c:set value="" var="id"/>
		</c:if>
	    	<a href="javascript:check('${id }',2)" class="button btnPush btnPurple" style="top: 36%; left: 93%">글등록</a>
	  	</div>
  	<form action="/board/list">
  		<select name="cate">
  			<option value=""
  			<c:if test="${page.c.cate eq '' }">selected</c:if>>전체</option>
  			<option value="N"
  			<c:if test="${page.c.cate eq 'N' }">selected</c:if>>작성자</option>
  			<option value="T"
  			<c:if test="${page.c.cate eq 'T' }">selected</c:if>>제목</option>
  			<option value="K"
  			<c:if test="${page.c.cate eq 'K' }">selected</c:if>>키워드</option>
  		</select>
		<input type="text" name="key" value="${page.c.key }">
		<input type="submit" value="검색">
  	</form>
	<div style="margin-left:5%">
		<h1>이주의 키워드 :${board.k.keyword }</h1>
	</div>
	<center>
	<div id="boardlistm">
		<table id="boardlist">
			<tr><th style="width:40%;">제목</th>
				<th style="width:15%;">작성자</th>
				<th style="width:15%;">조회수</th>
				<th style="width:15%;">작성일자</th>
			<c:forEach items="${board.b }" var="b" >
			<tr><th onclick="location.href='/board/detail?no=${b.no}'">${b.title }</th>
				<th>${b.name }</th>
				<th>${b.count }</th>
				<th>${b.wdate }</th>
			</c:forEach>	
		</table>
	</div>
	<div class="pagination">
	    <c:if test="${page.prev }">
			<a href="/board/list?cpage=${page.start -1 }&row=${page.c.row}&cate=${page.c.cate}&key=${page.c.key}">&laquo;</a>
		</c:if>
		<c:forEach var="n" begin="${page.start }" end="${page.end }">
		  	<a href="/board/list?cpage=${n }&row=${page.c.row}&cate=${page.c.cate}&key=${page.c.key}"
		  	   class="${page.c.cpage == n ?"active" :"" }">${n}</a>
		</c:forEach>
		<c:if test="${page.next }">
			<a href="/board/list?cpage=${page.end +1 }&row=${page.c.row}&cate=${page.c.cate}&key=${page.c.key}">&raquo;</a>
		</c:if>
	</div>
	<%@include file="../footer.jsp" %>
</div>	
</body>
</html>