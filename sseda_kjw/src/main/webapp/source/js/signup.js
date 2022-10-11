function signupcheck() {
	var signupform = document.signupform;
	var id = signupform.id;
	var pw = signupform.pw;
	var name = signupform.name;
	var nickname = signupform.nickname;
	var gender = signupform.gender;
	var phonenumber = signupform.phone;
	var email = signupform.email;
	var edo = signupform.edomain;
	var dbcheckid = signupform.idoverlap
	var overlapch = signupform.overlapch;
	
	if(id.value == "") {
		alert("아이디를 입력해주세요.");
		id.focus();
		return false;
	}
	if(pw.value == "") {
		alert("비밀번호를 입력해주세요.");
		pw.focus();
		return false;
	}
	if(name.value == "") {
		alert("이름을 입력해주세요.");
		name.focus();
		return false;
	}
	if(nickname.value == "") {
		alert("닉네임을 입력해주세요.");
		nickname.focus();
		return false;
	}
	if(gender.value == "") {
		alert("성별을 입력해주세요.");
		nickname.focus();
		return false;
	}
	if(phonenumber.value == "") {
		alert("전화번호를 입력해주세요.");
		phonenumber.focus();
		return false;
	}
	if(email.value == "") {
		alert("이메일을 입력해주세요.");
		email.focus();
		return false;
	}
	if(edo.length == 0) {
		alert("이메일을 입력해주세요.");
		edo.focus();
		return false;
	}
	
	if(overlapch.value == "uncheck") {
		alert("아이디 중복검사를 해주세요.");
		dbcheckid.focus();
		return false;
	} else if(overlapch.value == "imposiid") {
		alert("아이디를 확인해주세요.");
		dbcheckid.focus();
		return false;
	}
	
}

function DBcheckid() {
	var overlapch = document.signupform.overlapch;
	var id = document.signupform.id.value;
	var x = new XMLHttpRequest();
	x.onreadystatechange = function() {
		if(x.readyState === 4 && x.status === 200) {
			if(x.responseText.trim() === "false") {
				overlapch.value = 'imposiid';
				alert("아이디가 중복됩니다.");
			} else {
				overlapch.value = 'check';
				alert("사용할 수 있는 아이디입니다.");
			}
		};
	}
	x.open("POST", "/mem/DBcheckid", true);
	x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	x.send("id="+id);
}


var sign = (function(){
	
	function idcheck(id,callback,error) {
		
		console.log("중복검사 하는 아이디 = " + id);
		
		$.ajax({
			type : 'GET',
			url : '/mem/idcheck/' + id,
			data : JSON.stringify(id),
			contentType : 'application/json; charset=utf-8',
			
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			
			error : function(xhr, status, er) {
				if(error) {
					error(er)
				}
			}
			
		});
	
	}
	
	
	function memreg(member,callback,error) {
		
		console.log("등록할 아이디 = " + member.id);
		console.log("등록할 비밀번호 = " + member.pw);
		console.log("등록할 이름 = " + member.name);
		console.log("등록할 닉네임 = " + member.nickname);
		console.log("등록할 성별 = " + member.gender);
		console.log("등록할 전화번호 = " + member.phonenumber);
		console.log("등록할 이메일 = " + member.email);
		
		$.ajax({
			type : 'POST',
			url : '/mem/memreg',
			data : JSON.stringify(member),
			contentType : "application/json; charset=utf-8",
			
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			
			error : function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
			
		});
			
		
		
	}
	
	
	
	return {idcheck:idcheck,
			memreg:memreg};
	
})();


