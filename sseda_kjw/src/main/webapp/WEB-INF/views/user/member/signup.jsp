<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/css/member.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/signup.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div id="wrap" style="margin-top: 50px;">
<%@ include file="../header.jsp" %>
<%@ include file="../menu.jsp" %>
		<div id="member">
			<input type="text" id="putid" name="id" placeholder="아이디" >
			<input type="button" value="중복검사" class="checkid-button" name="idoverlap"> <!-- onclick="DBcheckid()" -->
			<input type="hidden" id="overlapch" name="overlapch" value="uncheck">
			<input type="password" id="pw" name="pw" placeholder="비밀번호" style="display:block"> 
			<input type="text" id="name" name="name" placeholder="이름" style="display:block">
			<input type="text" id="nickname" name="nickname" placeholder="닉네임"style="display:block">
			<fieldset style="width:42%;">
				<legend>성별</legend>
				<input type="radio" name ="gender" value="M">남자
				<input type="radio" name ="gender" value="F">여자
			</fieldset>
			<input type="number" id="phonenumber" name="phonenumber" style="display:block"placeholder="휴대전화" maxlength="11"> 
			<input type="text" id="email" name="email" style="width:17%;"placeholder="이메일"> @
			<select id="edomain" name="edomain" id="sel"> <!-- onchange="inputDomain()" -->
      			<option value="" >직접입력</option>
      			<option value="naver.com" >naver.com</option>
      			<option value="daum.net" >daum.net</option>
      			<option value="gmail.com" >gmail.com</option>
       		</select>
			<input type="submit" id="memreg" value="가입하기" style="display:block">
		</div>	
</div>	
	<%@include file="../footer.jsp" %>  		
</body>
<script>
 $(".footer-distributed").css({"transform":"translate(-90%,-5%)"});
 
 
 
 $(document).ready(function(){
	 
     $(".checkid-button").on("click",function(e) {
     	var id = document.getElementById("putid").value;
     	console.log(id);
     	sign.idcheck(id,function(result){
     		if(result == "true") {
     			document.getElementById("overlapch").value = "imposiid";
     			console.log("중복된아이디");
     			alert("중복된 아이디입니다.");
     		} else {
     			document.getElementById("overlapch").value = "check";
     			console.log("사용가능한 아이디");
     			alert("사용가능한 아이디입니다.");
     		}
     	
     	});
     
 	});
     
     $("#memreg").on("click",function(){
    	 
    	 console.log(document.getElementsByName("gender")[0].value);
    	 
    	 
    	 var member  = {
    		 
    		id : document.getElementById("putid").value,
    		pw : document.getElementById("pw").value,
    		gender : document.getElementsByName("gender")[0].value,
    		nickname : document.getElementById("nickname").value,
    		phonenumber : document.getElementById("phonenumber").value,
    		name : document.getElementById("name").value,
    		email : document.getElementById("email").value + "@" + $("#edomain option:selected").val(),
    			 
    	 };
    	 
    	 
    	 sign.memreg(member, function(result) {
    		 
    		 console.log(result);
    		 
    		if(result == 'ok') {
    			alert("회원가입 완료 되었습니다.");
    			location.href="/";
    		} else {
    			alert("회원가입에 실패하셨습니다.")
    			return;
    		}
    		
    		
    	 });
    	 
     });
     
     
 });
 
</script>
</html>