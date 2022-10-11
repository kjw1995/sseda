function check(id,no){
    if(id == ''){
        if(confirm("로그인 하시겠습니까?")){
            location.href="/member/gologin";
        }   
    }else{
        if(no == "1"){
            location.href="/item/insertform";
        }else if(no == "2"){
            location.href="/board/insertform";
        }else if(no == "3"){
            location.href="/qna/insertform";
        }
    }
}