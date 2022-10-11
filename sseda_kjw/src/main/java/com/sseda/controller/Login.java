package com.sseda.controller;

import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.sseda.service.MemberService;

@Controller
public class Login {
	
	@Autowired
	MemberService ms;
	
	@PostMapping("/login")
    public String login(@RequestParam("id") String id,
    				    @RequestParam("pw") String pw,
    				    HttpSession sess,
    					Model model) {
		
    	String view = "/member/login";
    	String[] loginStat = ms.login(id, pw);
    	
    	switch(loginStat[0]) {
    	case "ok" : //로그인 성공
    		sess.setAttribute("sess_id", id);
			sess.setAttribute("sess_name", loginStat[1]);
			model.addAttribute("loginmsg", "loginok");
			view = "/main";
			break;
    	case "pwfail" : //비밀번호 불일치
			model.addAttribute("loginmsg", "pwfail");
			break;
		case "loginfail" : //존재하지 않는 회원
			model.addAttribute("loginmsg", "loginfail");
			break;	
		case "deluser" : //탈퇴 요청 회원
			model.addAttribute("loginmsg", "deluser");
			break;
    	}
    	return view;
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession sess) {
    	
    	sess.invalidate();
    	return "main";
    }
	
}