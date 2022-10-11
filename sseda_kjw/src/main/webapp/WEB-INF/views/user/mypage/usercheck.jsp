<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/userinfo.css">
<link rel="stylesheet" href="/css/footer.css">
<script src=/js/changeuserinfo.js></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div id="wrap">
	<%@ include file = "../header.jsp" %>
	<%@ include file = "../menu.jsp" %>
<section>	
 <div class="usercontent">
		<div class="columncontent" style="text-align: center">
			<form method="post" action="changeuser" onsubmit="return checkpw()">
			<input type="password" placeholder="비밀번호를 입력해주세요." class="password" id="putpw">
			<input type="hidden" name="id" id="id" value="${id}">
			<input type="hidden" id="chpw" value="${pw}">
			<input type="submit" value="확인" class="usercheck">
			</form>
		</div>
 </div>
</section>
</div>

<%@ include file="../footer.jsp" %>
</body>
<script>
$(".footer-distributed").css({"transform":"translate(-90%,-1500%)"});
</script>
</html>