<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<script src="/admin/js/script.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/js/adminservice.js"></script>
<link rel="stylesheet" href="/ad_css/manager.css">
</head>
<body>
<%@ include file="../ad_main/m_menu.jsp" %>
	<center>	
		<h2>회원 관리</h2>
		<ul class="memmenu">
			<li class="mem"><a href="/admem/memberList">회원 목록</a></li>
			<li><a href="/admem/memberDeleteList">회원 탈퇴 목록</a></li>
		</ul>
		<hr>
		<%@ include file="../ad_member/Mmanager.jsp" %>
		<br>
			<table>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>등급</th>
					<th>가입일</th>
					<th>등급신청</th>
				</tr>
				<c:set value="${member.m }" var="m" />
				<c:forEach items="${m}" var="member">
					<td onclick="location.href='/admem/memberDetail?id=${member.id}'">${member.getId()}</td>
					<td>${member.getName()}</td>
					<td>${member.getNickname()}</td>
					<td>${member.getEmail()}</td>
					<td>${member.getGrade()}</td>
					<td>${member.getWdate()}</td>
					<td><button data-id="${member.id}" id="gradeBtn">신청</button></td>
				</tr>
				
				<script>
				$(document).ready(function(){
					$("#gradeBtn").on("click", function(){
						var id = $(this).data("id");
						adminservice.update(id, function(data){
							alert(data);
						});
						
					});			
				});
				</script>
				</c:forEach>
			</table>
		<p>전체레코드 ${page.t }</p>	
		<div class="pagination">
	    <c:if test="${page.prev }">
		  <a href="/admem/memberList?cpage=${n }&row=${page.c.row}&grade=${page.c.searchname.grade}&start=${page.c.searchname.start}&end=${page.c.searchname.end}&sh=${page.c.searchname.sh}&key=${page.c.searchname.key}">&laquo;</a>
		</c:if>
		  <c:forEach var="n" begin="${page.start }" end="${page.end }">
		  	<a href="/admem/memberList?cpage=${n }&row=${page.c.row}&grade=${page.c.searchname.grade}&start=${page.c.searchname.start}&end=${page.c.searchname.end}&sh=${page.c.searchname.sh}&key=${page.c.searchname.key}"
		  	   class="${page.c.cpage == n ?"active" :"" }">${n}</a>
		  </c:forEach>
		<c:if test="${page.next }">
		  <a href="/admem/memberList?cpage=${n }&row=${page.c.row}&grade=${page.c.searchname.grade}&start=${page.c.searchname.start}&end=${page.c.searchname.end}&sh=${page.c.searchname.sh}&key=${page.c.searchname.key}">&raquo;</a>
		</c:if>
		</div>
	</center>		
		
</body>
</html>