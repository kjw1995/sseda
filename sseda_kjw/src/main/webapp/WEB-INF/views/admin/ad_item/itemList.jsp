<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/source/js/ad_item.js"></script>
</head>
<body>
<center>	
<h2>게시물 목록</h2>
<hr>
<%@ include file="Sitem.jsp" %>
<hr>


<div class="container">
		<table class="table" id="table">
		
			<thead>
			<tr>
				<form>
				<th class="header" width="30"><input type="checkbox" id="checkall"></th>
				</form>
				<th>no</th>
				<th>id</th>
				<th>title</th>
				<th>date</th>
				<th>content</th>
				<th></th>
				
			</tr>
			</thead>
	<c:forEach items="${item}" var="item">
			<tbody class="tbody" id="tbody">
			<tr th:each="member :" class="member">
				<td class="membercenter"></td>
				<td class="membercenter">${item.seqno}</td>
				<td class="membercenter">${item.id}</td>
				<td class="membercenter">${item.title}</td>
				<td class="membercenter">${item.wdate}</td>
				<td class="membercenter">${item.content}</td>
				<td><button id="btnDelete" data-no="${item.seqno }">X</button></td>
				</tr>
			</tbody>
	</c:forEach>
		</table>
</div>

<center>	
		<div class="pagination">
	    <c:if test="${page.prev }">
		  <a href="/admin/item/List?cpage=${page.start -1 }&row=${page.c.row}&searchField=${page.c.searchField}&searchText=${page.c.searchText}">&laquo;</a>
		</c:if>
		  <c:forEach var="n" begin="${page.start }" end="${page.end }">
		  	<a href="/admin/item/List?cpage=${n }&row=${page.c.row}&searchField=${page.c.searchField}&searchText=${page.c.searchText}"
		  	   class="${page.c.cpage == n ?"active" :"" }">${n}</a>
		  </c:forEach>
		<c:if test="${page.next }">
		  <a href="/admin/item/List?cpage=${page.end +1 }&row=${page.c.row}&searchField=${page.c.searchField}&searchText=${page.c.searchText}">&raquo;</a>
		</c:if>
		</div>
	</center>	

<script>
$("#btnDelete").on("click",function(e){
 	var ino = $(this).data("no");
 	console.log("삭제 확인:" + ino);
 		AdminItemService.dele(ino, function(result){
 		alert(result);
 	});
 });
</script>
</center>
</body>
</html>