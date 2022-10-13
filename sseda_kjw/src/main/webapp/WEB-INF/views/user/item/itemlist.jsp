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
	<%@ include file="../menu.jsp" %>
	<br>
<center>
	<form id="keyword" action="/item/list">
	 	<div>
		      <div>
		      <div>
		      	<input type="checkbox" id="fruit1" name="fruit-1" value="Apple">
		      	<label for="fruit1">멘토</label>
		      </div>
		      <div>
		      	<input type="checkbox" id="fruit4" name="fruit-4" value="Strawberry">
		      	<label for="fruit4">멘티</label>
		      </div>
		      </div>
		  </div>
		<%@ include file="../item/drodown.jsp" %>
		<div class="search__container">
		<c:choose>
			<c:when test="${page.c.division ne 'A' }">
				<input class="search__input" type="text" placeholder="Search" value="${page.c.key }">
			</c:when>
			<c:otherwise>
				<input type="text" name="key">
			</c:otherwise>	
		</c:choose>
			<input type="submit" value="검색">
			</div>
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
  	
	<c:forEach items="${item }" var="i" >
	<!-- 
		<table class="itemlist" border="1">
			<tr><td colspan="2" style="height:150px;"onclick="location.href='/item/detail?no=${i.seqno}'"><div style="height:150px;">
			<c:if test="${i.cfcheck == 'O' }"><img src="/img/멘토.jpg" style="height:100%;width:100%;"></c:if>
			<c:if test="${i.cfcheck == 'I' }"><img src="/img/멘티.jpg" style="height:100%;width:100%;"></c:if></div></td>
			<tr><td>제목</td><td>${i.title }</td>
			<tr><td>작성일자</td><td>${i.wdate }</td>
			<tr><td>작성자</td><td>${i.name }</td>
			<tr><td>조회수</td><td>${i.count }</td>
		</table>-->
 <div class="table">
  <h2 class="heading">
    ${i.title }
  </h2>
  <div class="block">
  <p class="itemp">${i.name }
    <span class="price">$28/
      <sub>hour</sub>
    </span>   
    <ul class="options">
    <li class="fa-solid fa-user">nickname</li>
    </ul>
 </p>
</div>

<div class="block">
<p class="itemp">250 point
    <span class="price">$29/
      <sub>hour</sub>
    </span>   
    <ul class="options">
      <li>point</li>
    </ul>
 </p>
</div>


<div class="block">
<p class="itemp">${i.wdate }
    <span class="price">$29/
      <sub>hour</sub>
    </span>   
    <ul class="options">
      <li>date</li>
    </ul>
 </p>
</div>

<div class="block">
<p>${i.count }
    <span class="price">$29/
      <sub>hour</sub>
    </span>   
    <ul class="options">
      <li>count</li>
    </ul>
 </p>
</div>
<div id="container">
  <button class="learn-more">
    <span class="circle" aria-hidden="true">
      <span class="icon arrow"></span>
    </span>
    <span class="button-text"> Matching</span>
  </button>
</div>
</div>
</c:forEach>

		
	
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