<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device=width, initial-scale=1.0">
<title>로그인 및 회원가입</title>
<link rel="stylesheet" href="/css/login.css">
<link rel="stylesheet" href="/css/footer.css">
<script src="/js/loginjs.js"></script>
<script src="/js/loginjs2.js"></script>
<script src="/js/signup.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body onload="init()">
<input type="hidden" name="loginmsg" value="<%= request.getAttribute("loginmsg") %>">
<%@ include file = "../menu.jsp" %>
<div class='box'>
  <div class='box-form'>
    <div class='box-login-tab'></div>
    <div class='box-login-title'>
      <div class='i i-login'></div><h2>LOGIN</h2>
    </div>
    <div class='box-login'>
      <div class='fieldset-body' id='login_form'>
        <button onclick="openLoginInfo();" class='b b-form i i-more' title='Mais Informações'></button>
        <form method="post" action="/login">
        	<p class='field'>
          <label for='user'>아이디</label>
          
          <input type='text' id='user' name='id' title='Username' />
          <span id='valida' class='i i-warning'></span>
        </p>
      	  <p class='field'>
          <label for="pass">비밀번호</label>
          <input type="password" id='pass' name='pw' title='Password' />
          <span id='valida' class='i i-close'></span>
        </p>
        	<input type="submit" id="do_login" value='로그인' title='Get Started' />
        	</form>
      </div>
    </div>
  </div>
  <div class='box-info'>
					    <p><button onclick="closeLoginInfo();" class='b b-info i i-left' title='Back to Sign In'></button><h3>도움이 필요하신가요??</h3>
    </p>
					    <div class='line-wh'></div>
    <button onclick="location.href='/mem/gosignup'" class='b-cta' title='Sign up now!'> SIGN UP</button>
    					<button onclick="location.href='/mem/pwfindform'" class='b-support' title='Forgot Password?'> 비밀번호찾기</button>
    					<div class='line-wh'></div>
    <button onclick="location.href='/mem/idfindform'" class='b-support' title='Contact Support'> 아이디찾기 </button>
  				</div>
</div>

<%@ include file = "../footer.jsp" %>
</body>
<script>
$(".footer-distributed").css({"transform":"translate(-90%,-1150%)"});
</script>
</html>