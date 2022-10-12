<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:choose>
<c:when test="${page.c.code eq 'N' }">
	<title>소설</title>
</c:when>
<c:when test="${page.c.code eq 'W' }">
	<title>웹소설</title>
</c:when>
<c:when test="${page.c.code eq 'E' }">
	<title>에세이</title>
</c:when>
<c:when test="${page.c.code eq 'P' }">
	<title>시</title>
</c:when>
<c:when test="${page.c.code eq 'A' || page.c.code eq ''}">
	<title>아이템페이지</title>
</c:when>
</c:choose>
<link rel="stylesheet" href="/css/item.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/insert.js"></script>
</head>
<body>
<div id="wrap" style="margin-top: 50px;">
	<%@ include file="../header.jsp" %>
	<%@ include file="../menu.jsp" %>
	<br>
<center>
	<form id="keyword" action="/item/list">
		<select name="code">
			<option value="A"
			<c:if test="${page.c.code eq 'A'}">selected</c:if>>전체</option>
			<option value="N"
			<c:if test="${page.c.code eq 'N'}"> selected</c:if>>소설</option>
			<option value="W"
			<c:if test="${page.c.code eq 'W'}">selected</c:if>>웹소설</option>
			<option value="E"
			<c:if test="${page.c.code eq 'E'}">selected</c:if>>에세이</option>
			<option value="P"
			<c:if test="${page.c.code eq 'P'}">selected</c:if>>시</option>
		</select>
		<select name="meto_meti">
			<option value="A"
			<c:if test="${page.c.meto_meti eq 'A'}">selected</c:if>>전체</option>
			<option value="O"
			<c:if test="${page.c.meto_meti eq 'O' }">selected</c:if>>멘토</option>
			<option value="I"
			<c:if test="${page.c.meto_meti eq 'I' }">selected</c:if>>멘티</option>
		</select>
		<select name="division">
			<option value="A"
			<c:if test="${page.c.division eq 'A' }">selected</c:if>>전체</option>
			<option value="t" 
			<c:if test="${page.c.division eq 't' }">selected</c:if>>제목</option>
			<option value="c"
			<c:if test="${page.c.division eq 'c' }">selected</c:if>>내용</option>
			<option value="n"
			<c:if test="${page.c.division eq 'n' }">selected</c:if>>이름</option>
		</select>
		<c:choose>
			<c:when test="${page.c.division ne 'A' }">
				<input type="text" name="key" value="${page.c.key }">
			</c:when>
			<c:otherwise>
				<input type="text" name="key">
			</c:otherwise>	
		</c:choose>
			<input type="submit" value="검색">
	</form>
		<div class="container">
		<c:if test="${sess_id != null }">
			<c:set value="${sess_id }" var="id"/>
		</c:if>
		<c:if test="${sess_id == null }">
			<c:set value="" var="id"/>
		</c:if>
	    	<a href="javascript:check('${id }',1)" class="button btnPush btnPurple" style="top: 36%; left: 93%">글등록</a>
	  	</div>
  	<center>
	<div id="list">
	<c:forEach items="${item }" var="i" >
		<table class="itemlist" border="1">
			<tr><td colspan="2" style="height:150px;"onclick="location.href='/item/detail?no=${i.seqno}'"><div style="height:150px;">
			<c:if test="${i.cfcheck == 'O' }"><img src="/img/멘토.jpg" style="height:100%;width:100%;"></c:if>
			<c:if test="${i.cfcheck == 'I' }"><img src="/img/멘티.jpg" style="height:100%;width:100%;"></c:if></div></td>
			<tr><td>제목</td><td>${i.title }</td>
			<tr><td>작성일자</td><td>${i.wdate }</td>
			<tr><td>작성자</td><td>${i.name }</td>
			<tr><td>조회수</td><td>${i.count }</td>
		</table>
	</c:forEach>
	</div>
	<center>
	<p>전체레코드 ${page.t }</p>	
		<div class="pagination">
	    <c:if test="${page.prev }">
		  <a href="/item/item?cpage=${n }&row=${page.c.row}&code=${page.c.code}&meto_teti=${page.c.meto_meti}&division=${page.c.division}&key=${page.c.key}">&laquo;</a>
		</c:if>
		  <c:forEach var="n" begin="${page.start }" end="${page.end }">
		  	<a href="/item/list?cpage=${n }&row=${page.c.row}&code=${page.c.code}&meto_teti=${page.c.meto_meti}&division=${page.c.division}&key=${page.c.key}"
		  	   class="${page.c.cpage == n ?"active" :"" }">${n}</a>
		  </c:forEach>
		<c:if test="${page.next }">
		  <a href="/item/list?cpage=${n }&row=${page.c.row}&code=${page.c.code}&meto_teti=${page.c.meto_meti}&division=${page.c.division}&key=${page.c.key}">&raquo;</a>
		</c:if>
		</div>
	</center>	
	<%@include file="../footer.jsp" %>
</div>	
</body>
</html>