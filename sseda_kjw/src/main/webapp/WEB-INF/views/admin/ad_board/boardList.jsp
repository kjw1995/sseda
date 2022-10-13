<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../ad_main/m_menu.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/source/js/ad_board.js"></script>
</head>
<body>
<center>	
<h2>게시물 목록</h2>
<hr>
<%@ include file="Sboard.jsp" %>
<hr>
<%-- 		<input type="hidden" name="currentPage" value="${pageMaker.c.cpage}">
			<select name="searchField">
				<option value="title"
				<c:if test="${pageMaker.c.searchField == 'title'}"> selected</c:if>>제목</option>
				<option value="name"
				<c:if test="${pageMaker.c.searchField == 'name'}"> selected</c:if>>이름</option>
			</select>

		<input type="text" name="searchText" placeholder="Search..." 
			value="${pageMaker.c.searchText}">
			
			<input type="button" value="검색" onclick="javascript:document.forms['search'].submit()"> 
			 <select name="rowPerPage" onchange="goAction()">
	 	  	<c:forEach var="i" begin="5" end="40" step="5">
	 	  	<option value="${i}"
	 	  	<c:if test="${i == pageMaker.c.row }"> selected </c:if>
	 	  	>${i}개씩
	 	  	</option>
			</c:forEach>
			</select>
			</form> --%>

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
	<c:forEach items="${board}" var="board">
			<tbody class="tbody" id="tbody">
			<tr th:each="member :" class="member">
				<td class="membercenter"></td>
				<td class="membercenter">${board.no}</td>
				<td class="membercenter">${board.id}</td>
				<td class="membercenter">${board.title}</td>
				<td class="membercenter">${board.wdate}</td>
				<td class="membercenter">${board.content}</td>
				<td><button id="btnDelete" data-no="${board.no }">X</button></td>
				</tr>
			</tbody>
	</c:forEach>
		</table>
</div>

<center>	
		<div class="pagination">
	    <c:if test="${page.prev }">
		  <a href="/admin/boardList?cpage=${page.start -1 }&row=${page.c.row}&searchField=${page.c.searchField}&searchText=${page.c.searchText}">&laquo;</a>
		</c:if>
		  <c:forEach var="n" begin="${page.start }" end="${page.end }">
		  	<a href="/admin/boardList?cpage=${n }&row=${page.c.row}&searchField=${page.c.searchField}&searchText=${page.c.searchText}"
		  	   class="${page.c.cpage == n ?"active" :"" }">${n}</a>
		  </c:forEach>
		<c:if test="${page.next }">
		  <a href="/admin/boardList?cpage=${page.end +1 }&row=${page.c.row}&searchField=${page.c.searchField}&searchText=${page.c.searchText}">&raquo;</a>
		</c:if>
		</div>
	</center>	

<script>
$("#btnDelete").on("click",function(e){
 	var bno = $(this).data("no");
 	console.log("삭제 확인:" + bno);
 		AdminBoardService.del(bno, function(result){
 		alert(result);
 	});
 });
</script>
</center>
</body>
</html>