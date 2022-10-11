function gradewindow(url, name){
 var options = 'top=125, left=550, width=750, height=750, status=no, menubar=no, toolbar=no, resizable=no';
 	window.open(url,name,options);
         }
             	
function secession(myid) {
	var result = confirm("정말 탈퇴하시겠습니까?");
	if(result) {
		location.href="/mem/delreq?id=" + myid;
	} else {
	 alert("취소되었습니다.");
	 location.href="/mem/mydetail?id=" + myid;
	}
}

function chms() {
	var chpw = document.forms["changeform"]["checkpw"].value;
	var pw = document.forms["changeform"]["changepw"].value;
	var chms = document.getElementById("chms");
	
	if(pw == chpw) {
		chms.innerHTML="<a style='color: green'>비밀번호가 일치합니다.</a>";
	} else {
		chms.innerHTML="<a style='color: red'>비밀번호가 불일치합니다.</a>";
	}
}
	
	
function changeuser() {
	var id = document.forms["changeform"]["chid"].value;
	var pw = document.forms["changeform"]["changepw"].value;
	var nickname = document.forms["changeform"]["changenickname"].value;
	var phone = document.forms["changeform"]["changephone"].value;
	var email = document.forms["changeform"]["changeemail"].value;
	var x = new XMLHttpRequest();
	x.onreadystatechange = function() {
		if(x.readyState === 4 && x.status === 200) {
			if(x.responseText.trim() === "0") {
				alert("닉네임이 중복됩니다.");
			} else {
				alert("수정이 완료되었습니다.");
				location.href="/mem/mydetail?id=" + id;
			}
		};
	}
	x.open("POST", "changeinfo", true);
	x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	x.send("id="+id+"&pw="+pw+"&nickname="+nickname+"&phonenumber="+phone+"&email="+email);
} 

function dupnickname() {
	var nickname = document.forms["changeform"]["changenickname"].value;
	var chms = document.getElementById("chni"); 
		
	var x = new XMLHttpRequest();
	x.onreadystatechange = function() {
		if(x.readyState === 4 && x.status === 200) {
			/*alert(x.responseText.trim());*/
			if(x.responseText.trim() === "3") {
				chms.innerHTML="<a style='color: black'>닉네임을 입력해주세요.</a>";
			} else if(x.responseText.trim() === "1"){
				chms.innerHTML="<a style='color: red'>이미 사용되고있는 닉네임입니다.</a>";
			} else if(x.responseText.trim() === "2"){
				chms.innerHTML="<a style='color: green'>사용가능한 닉네임입니다.</a>";
			} else {
				chms.innerHTML="";
			}
		};
	}
	x.open("POST", "/sseda/mem/dupcheck", true);
	x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	x.send("nickname="+nickname);
	
}
    
function checkpw() {
	var putpw = document.getElementById("putpw").value;
	var chpw = document.getElementById("chpw").value;
	
	if(putpw != chpw) {
		alert("비밀번호를 다시 입력하세요.");
		return false;
	}
	
}

var mem = (function(){
	
	function change(member, callback, error) {
		console.log("내정보 수정");
		
		$.ajax({
			
			type : 'POST',
			url : '/mem/updateinfo',
			data : JSON.stringify(member),
			contentType : 'application/json; charset=utf-8',
			
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
		
		
		
	};
	
	return {change:change};
	
})();

     
         