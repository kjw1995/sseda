<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <link rel="stylesheet" href="../ad_css/Mmanagercss.css"> 
 
	<div class="memwrap">
	<form method="get" action="/admin/boardList">
		<div>
		<p><strong>•게시글 등록 날짜</strong></p>
		<input type="date" id="dateFrom" name="date">~<input type="date" id="dateTo" name="todate">
		</div>
	<div>	
		<input type="hidden" name="cpage" value="${page.c.cpage}">
			<select name="searchField">
				<option value="title"
				<c:if test="${page.c.searchField == 'title'}"> selected</c:if>>제목</option>
				<option value="name"
				<c:if test="${page.c.searchField == 'name'}"> selected</c:if>>이름</option>
			</select>

		<input type="text" name="searchText" placeholder="Search..." 
			value="${page.c.searchText}">
			
			<input type="submit" value="검색" > 
			 <select name="row" onchange="goAction()">
	 	  	<c:forEach var="i" begin="5" end="40" step="5">
	 	  	<option value="${i}"
	 	  	<c:if test="${i == page.c.row }"> selected </c:if>
	 	  	>${i}개씩
	 	  	</option>
			</c:forEach>
			</select>
</div>
</form>
</div>