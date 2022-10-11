<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쓰다메인</title>
<%@ include file = "link.jsp" %>
</head>
<body>


<%@ include file = "menu.jsp" %>

<%@ include file = "mainslide.jsp" %>

<script src="/js/text.js"></script>

<!--라이브보드 참고 -->
<div id="manuicon">
<h2 style= "display: inline-block;
    transform: translate(80%, 140%);">원하는 서비스를 클릭하세요</h2>
		<div class="box1">
			<img src="/img/webnovel.png" class="micon">
			<div class="textcontainer">
				<a href="#">웹소설</a>
				</div>
			</div>
				<div class="box2">
				<img src="/img/novel.png" class="micon">
					<div class="textcontainer">
				<a href="#">문학</a>
					</div>
				</div>
					<div class="box3">
					<img src="/img/poetry.png" class="micon">
						<h4>시</h4>
					</div>
						<div class="box4">
							<img src="/img/essay.png" class="micon">
							<h4>에세이</h4>
						</div>
								<div class="box5">
								<img src="/img/material.png" class="micon">
									<h4>창작소재</h4>
								</div>
</div>


<%@ include file = "howto.jsp" %>


<%@ include file = "liveboard2.jsp" %>
	

<%@ include file = "popular.jsp" %>

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
</div>
<%@ include file = "footer.jsp" %>

</body>
</html>