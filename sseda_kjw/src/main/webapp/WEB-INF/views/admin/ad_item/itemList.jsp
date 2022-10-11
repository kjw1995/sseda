<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %>
<link rel="stylesheet" href="../ad_css/Mmanagercss.css">
</head>
<body>
<center>	
<h2>신고 아이템 관리</h2>
<ul class="memmenu">
			<li class="mem"><a href="/ad_item/itemList">아이템 목록</a></li>
			<li><a href="/adre/itemList">신고 아이템 관리</a></li>
		</ul>
<hr>

<div class="memwrap">

		<div class="gradewrap">
 		<p><strong>•등급</strong></p>
		<input type="checkbox" name="grade" class="memsubmit"><p>멘토</p>
		<input type="checkbox" name="grade" class="memsubmit"><p>멘티</p>
		<input type="checkbox" name="grade" class="memsubmit"><p>관리자</p>
		</div>
		<div>
		<p><strong>•아이템 신고 날짜</strong></p>
		<input type="date" id="dateFrom" name="date">~<input type="date" id="dateTo" name="todate">
		</div>
		<div>
		<p><strong>•검색어</strong></p>
		<select>
			<option>카테고리</option>  
			<option>웹소설</option>  
			<option>문학</option>  
			<option>시</option>  
			<option>에세이</option>  
			</select>
		<select name="searchcase">
			<option>전체</option>
			<option>회원 아이디</option>
			<option>아이템 제목</option>
		</select>
		<input type="text" name="keyword" id="keyword">
		<input type="submit" value="검색" class="btn btn-sm btn-black" name="btnSearch" id="btnSearch">
		</div>
</div>
  	<center>
	<div id="list">
	<c:set value="${item}" var ="item" />
	<c:forEach items="${item.item}" var="i" >
		<table class="itemlist" border="1">
			<tr><td colspan="2" style="height:150px;"onclick="location.href='/ad_item/itemDetail?no=${i.seqno}'"><div style="height:150px;"><img src="/img/logo.png" style="height:100%;width:100%;"></div></td>
			<tr><td>제목</td><td>${i.title}</td>
			<tr><td>작성일자</td><td>${i.wdate}</td>
			<tr><td>작성자</td><td>${i.name}</td>
			<tr><td>조회수</td><td>${i.count}</td>
		</table>
	</c:forEach>
	</div>
	<center>	
		<div class="pagination">
	    <c:if test="${page.prev }">
		  <a href="/ad_item/itemList?cpage=${page.start -1 }&row=${page.c.row}">&laquo;</a>
		</c:if>
		  <c:forEach var="n" begin="${page.start }" end="${page.end }">
		  	<a href="/ad_item/itemList?cpage=${n }&row=${page.c.row}&cate=${item.check.category}&mt=${item.check.meto_meti}&ser=${item.check.division}&key=${item.check.key}"
		  	   class="${page.c.cpage == n ?"active" :"" }">${n}</a>
		  </c:forEach>
		<c:if test="${page.next }">
		  <a href="/ad_item/itemList?cpage=${page.end +1 }&row=${page.c.row}">&raquo;</a>
		</c:if>
		</div>
	</center>	



</body>
</html>