<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
<link rel="stylesheet" href="/css/changeuser.css">
<script src="/js/changeuserinfo.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>    
<c:set value="${id}" var="id" />
<div class="changediv">
		<form name="changeform">
			<input type="hidden" id="id" name="chid" value="${id.id}">
				<table class="changeuser-table">
					<tbody class="changeuser-hover">
						<tr>
							<td class="text-left">비밀번호</td>
							<td class="text-right"><input type="password" id="pw" name="changepw" ></td>
						</tr>
						<tr>
							<td class="text-left">비밀번호 재확인</td>
							<td class="text-right"><input type="password" name="checkpw" >
							<input type="button" onclick="chms()" value="확인">
							<a class="cha" id="chms"></a>
							</td>
						</tr>
						<tr>
							<td class="text-left">닉네임</td>
							<td class="text-right"><input type="text" id="nickname" name="changenickname" > <!-- onchange="dupnickname()" -->
							<!-- <input type="button" onclick="dupnickname()" value="확인"> -->
							<a class="cha" id="chni"></a>
							</td>
						</tr>
						<tr>
							<td class="text-left">휴대전화</td>
							<td class="text-right"><input type="text" id="phonenumber" name="changephone" > <!-- onchange="dupcheck()" -->
							<a class="cha" id="chph"></a>
							</td>
						</tr>
						<tr>
							<td class="text-left">이메일</td>
							<td class="text-right"><input type="text" id="email" name="changeemail" > <!-- onchange="dupcheck()" --> 
							<a class="cha" id="chem"></a>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="button" value="수정" class="change-submit"> <!-- onclick="changeuser()" -->
				<input type="button" value="취소" class="cancel" onclick="location.href='mydetail?id=${id}'">
				</form>
</div>
</body>
<script>
var changediv = $(".changediv");
var id = document.getElementById("id").value;
/* var replycontent = replydiv.find("textarea[name='content']"); */
	$(document).ready(function(){
		
			
			
		$(".change-submit").on("click",function(e){
			var pw = changediv.find("input[id='pw']").val();
			var nickname = changediv.find("input[id='nickname']").val();
			var phonenumber = changediv.find("input[id='phonenumber']").val();
			var email = changediv.find("input[id='email']").val();
			console.log("아이디 = " + id);
			console.log("수정할 비밀번호 = " + pw);
			console.log("버튼확인");
			
			var member = {
					id : id,
					pw : pw,
					nickname : nickname,
					phonenumber : phonenumber,
					email : email
			};
			
			mem.change(member, function(result){
				 if(result == "ok") {
					var con = confirm("수정되었습니다 이동하시겠습니까?");
					if(con) {
						location.href="/mem/mydetail?id=" + id ;
					} else {
						$("#pw").attr("value",pw);
						$("#nickname").attr("value",nickname);
						$("#phonenumber").attr("value",phonenumber);
						$("#email").attr("value",email);	
						return false;
					}
					
					
				} 
			});
			
		});
	});
</script>
</html>