<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쓰다메인</title>
<%@ include file = "link.jsp" %>
<script src="/js/text.js"></script>
<script src="/js/mainjs.js"></script>
</head>
<body>
<%@ include file = "menu.jsp" %>
<%@ include file = "mainslide.jsp" %>
<!--라이브보드 참고 -->
<div id="manuicon">
<h2 style= "display: inline-block;
    transform: translate(80%, 140%);">원하는 서비스를 클릭하세요</h2>
		<div class="box1">
			<a href="/item/list?code=W"><img src="/img/webnovel.png" class="micon"></a>
			<div class="textcontainer">
				<a href="/item/list?code=W">웹소설</a>
			</div>
		</div>
		<div class="box2">
			<a href="/item/list?code=N"><img src="/img/novel.png" class="micon"></a>
			<div class="textcontainer">
				<a href="/item/list?code=N">문학</a>
			</div>
		</div>
		<div class="box3">
			<a href="/item/list?code=P"><img src="/img/poetry.png" class="micon"></a>
			<div class="textcontainer">
				<a href="/item/list?code=P">시</a>
			</div>	
		</div>
		<div class="box4">
			<a href="/item/list?code=E"><img src="/img/essay.png" class="micon"></a>
			<div class="textcontainer">
				<a href="/item/list?code=E">에세이</a>
			</div>
		</div>
		<div class="box5">
			<a href="/board/list"><img src="/img/material.png" class="micon"></a>
			<div class="textcontainer">
				<a href="/board/list">이벤트게시판</a>
			</div>
		</div>
</div>


<%@ include file = "howto.jsp" %>
	

<div id="mentor">
<h2 class="mentorh2"> 작가로 활동하고 계신가요? <br>
 	저희 "쓰다"에서  <br>
 	문하생과 손쉽게 만남을 약속해보세요 ! </h2>	
<button class="button white">
    <div class="icon">
        <div class="cannon"></div>
        <div class="confetti">
            <svg viewBox="0 0 18 16">
                <polyline points="1 10 4 7 4 5 6 1" />
                <path d="M4,13 C5.33333333,9 7,7 9,7 C11,7 12.3340042,6 13.0020125,4" />
                <path d="M6,15 C7.83362334,13.6666667 9.83362334,12.6666667 12,12 C14.1663767,11.3333333 15.8330433,9.66666667 17,7" />
            </svg>
            <i></i><i></i><i></i><i></i><i></i><i></i>
            <div class="emitter"></div>
        </div>
    </div>
    <span>멘토가입</span>
</button>

<%@ include file = "slide.jsp" %>
<%@ include file = "footer.jsp" %>
</div>
<script>
$(".footer-distributed").css({"transform":"translate(-90%,-650%)"});
</script>
</body>
</html>