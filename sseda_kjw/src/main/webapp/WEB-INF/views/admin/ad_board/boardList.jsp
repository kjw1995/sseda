<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sseda.dao.ad_BoardDaoImpl" %>
<%@ page import="com.sseda.dto.ad_BoardDTO" %>
<%@ page import="java.util.*" %>
<%
ad_BoardDaoImpl list = new ad_BoardDaoImpl();
	List<ad_BoardDTO> li = list.selectAll();
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/adm_menu/adm_Mmenu.jsp" %>
</head>
<body>
<center>	
<h2>게시물 목록</h2>
<hr>
<%@ include file="/ad_board/Sboard.jsp" %>
<hr>
<div class="container">
		<table class="table" id="table">
		
			<thead>
			<tr>
				<th class="header" width="30"><input type="checkbox" id="checkall" /></th>
				<th>id</th>
				<th>title</th>
				<th>date</th>
				<th>content</th>
				<th>view</th>
			</tr>
			</thead>
<%
for(int i=0; i<li.size(); i++){
		ad_BoardDTO b = li.get(i);
%>			
			<tbody class="tbody" id="tbody">
			<tr th:each="member :${members}" class="member">
				<td class="membercenter"></td>
				<td class="membercenter"><%=b.getId() %></td>
				<td class="membercenter"><%=b.getTitle() %></td>
				<td class="membercenter"><%=b.getWdate() %></td>
				<td class="membercenter"><%=b.getContent() %></td>
				<td class="membercenter"><%=b.getViews() %></td>
				</tr>
			</tbody>
<%
	}
%>				
		</table>
</div>

</center>
</body>
</html>