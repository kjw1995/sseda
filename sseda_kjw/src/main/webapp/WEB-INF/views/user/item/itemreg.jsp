<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템 수정</title>
<link rel="stylesheet" href="/css/item.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/sseda/js/item.js"></script>
</head>
<body>
	<%@ include file = "../header.jsp" %>
	<%@ include file = "../menu.jsp" %>
	<br><br><br>
	<div id="iteminsertm">
	<c:set value="${item }" var="i" />
		<form name="iteminsert" method="post" action="/item/itemreg" id="iteminsert">
			<input type="text" name="title" style="margin-left:8%;" value="${i.title }">
			<input type="hidden" name="seqno" value="${i.seqno }">
			<br>
			<fieldset style="width:15%;display:inline;">
				<legend>공개여부</legend>
				<c:choose>
					<c:when test="${i.open eq 'Y' }">
						<input type="radio" name="open" value="Y" checked>공개
					</c:when>
					<c:otherwise>
						<input type="radio" name="open" value="N" checked>비공개
					</c:otherwise>	
				</c:choose>
			</fieldset>
			<input type="file" style="width:10%" value="첨부파일"><br>
			<textarea name="content" id="content">${i.content }</textarea><br>
			<input type="submit" value="수정" >
			<input type="button" onclick="real(${i.seqno})" value="취소" >
		</form>
	</div>
  
<%@include file="../footer.jsp" %>  
  
</body>
</html>