<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/css/mypage.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<c:set value="${id}" var="myid" />
<div class="options">
<%@ include file = "../menu.jsp" %>
   <div class="option active" style="--optionBackground:url(../img/mymain_home.png);">
      <div class="shadow"></div>
      <div class="label">
         <div class="icon">
            <i class="fas fa-sun"></i>
         </div>
         <div class="info">
            <div class="main"><h4 onclick="location.href='/'">HOME</h4></div>
            <!-- <div class="sub"></div> -->
         </div>
      </div>
   </div>
   <div class="option" style="--optionBackground:url(../img/mymain_item.png);">
      <div class="shadow"></div>
      <div class="label">
         <div class="icon">
            <i class="fas fa-sun"></i>
         </div>
         <div class="info">
            <div class="main" ><h4 onclick="location.href='/mem/detailmypage?id=${myid}&cate=item'">아이템</h4></div>
            <!-- <div class="sub">Omuke trughte a otufta</div> -->
         </div>
      </div>
   </div>
   <div class="option" style="--optionBackground:url(https://66.media.tumblr.com/5af3f8303456e376ceda1517553ba786/tumblr_o4986gakjh1qho82wo1_1280.jpg);">
      <div class="shadow"></div>
      <div class="label">
         <div class="icon">
            <i class="fas fa-sun"></i>
         </div>
         <div class="info">
            <div class="main"><h4 onclick="location.href='/mem/detailmypage?id=${myid}&cate=board'">게시글</h4></div>
         </div>
      </div>
   </div>
   <div class="option" style="--optionBackground:url(https://66.media.tumblr.com/5516a22e0cdacaa85311ec3f8fd1e9ef/tumblr_o45jwvdsL11qho82wo1_1280.jpg);">
      <div class="shadow"></div>
      <div class="label">
         <div class="icon">
            <i class="fas fa-sun"></i>
         </div>
         <div class="info">
            <div class="main"><h4 onclick="location.href='/mem/detailmypage?id=${myid}&cate=reply'">댓글</h4></div>
         </div>
      </div>
   </div>
   <div class="option" style="--optionBackground:url(https://66.media.tumblr.com/f19901f50b79604839ca761cd6d74748/tumblr_o65rohhkQL1qho82wo1_1280.jpg);">
      <div class="shadow"></div>
      <div class="label">
         <div class="icon">
            <i class="fas fa-sun"></i>
         </div>
         <div class="info">
            <div class="main">관심목록</div>
         </div>
      </div>
   </div>
   <div class="option" style="--optionBackground:url(https://66.media.tumblr.com/f19901f50b79604839ca761cd6d74748/tumblr_o65rohhkQL1qho82wo1_1280.jpg);">
      <div class="shadow"></div>
      <div class="label">
         <div class="icon">
            <i class="fas fa-sun"></i>
         </div>
         <div class="info">
            <div class="main">매칭</div>
         </div>
      </div>
   </div>
   <div class="option" style="--optionBackground:url(https://66.media.tumblr.com/f19901f50b79604839ca761cd6d74748/tumblr_o65rohhkQL1qho82wo1_1280.jpg);">
      <div class="shadow"></div>
      <div class="label">
         <div class="icon">
         	<i class="fas fa-sun"></i>
         </div>
         <div class="info">
            <div class="main">문의현황</div>
         </div>
      </div>
   </div>
   <div class="option" style="--optionBackground:url(../img/mymain_note.png);">
      <div class="shadow"></div>
      <div class="label">
         <div class="icon">
            <i class="fas fa-sun"></i>
         </div>
         <div class="info">
            <div class="main">쪽지</div>
         </div>
      </div>
   </div>
</div>
</body>
<script>
$(".option").click(function(){
	   $(".option").removeClass("active");
	   $(this).addClass("active");
	});
$(document).ready(function(){
	$(".header").css({"position":"absolute"});
	$(".header").css("top","-3%");
	$(".header").css("width","886px");
	$(".search-toggle").css("display","none");
	$(".header-nav").css("padding-right","0em");
});
</script>
</html>