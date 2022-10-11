<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/menu.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/js/menu.js"></script>
<div>
<header id="header-1" class="header">
<!-- <h1 class="flag"><a href="/">SSEDA.</a></h1> -->   
<a href="/" class="link-1"> <img src="/img/logo4.png" style="height: 65px;" "width : 65px;"></a>
<!--  <img src="/sseda/img/icon.png" class ="headicon">-->
  <nav class="header-nav">
    <div class="search-button">
      <a href="#" class="search-toggle" data-selector="#header-1"></a>
    </div>
    <ul class="menu">
      <c:set value="${sess_id}" var="id" />
  	  <c:set value="${sess_name}" var="name" />
      <li><a href="#">메인</a></li>
      <li><a href="/qa/qna">Q & A</a></li>
      <c:if test="${id == null}">
	      <li><a href="/mem/gosignup">회원가입</a></li>
	      <li><a href="/mem/gologin">로그인</a></li>
      </c:if>
      <li><a href="#">관심</a></li>
	  <c:if test="${id != null}">
		  <li><a href="/mem/mypage?id=${id}">${name} 님</a></li>
		  <li><a href="/logout">logout</a></li>
	  </c:if>
    </ul>
   <form action="" class="search-box">
      <input type="text" class="text search-input" placeholder="멘토 & 멘티를 검색하세요." />
    </form>
  </nav>
</header>
</div>