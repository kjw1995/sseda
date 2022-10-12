package com.sseda.admincontroller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sseda.controller.QnaController;
import com.sseda.dao.MemberDao;
import com.sseda.dto.Member;
import com.sseda.service.AdminService;




@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService ad;
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(AdminController.class);
	
	@GetMapping("/")
	public String m_login() {
		log.info("admin home...........");
		return "/ad_main/m_login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Member mem, HttpSession sess) {
		log.info("admin login................");
		String map = ad.login(mem.getId(), mem.getPw());
		
		String url = null;
		
		if(map.equals("0")){
			url = "/ad_main/m_main";
			
		} else if(map.equals("1")) {
			url = "/ad_main/m_login";
		} else {
			url = "/ad_main/m_login";
		}
		
		return url;
	}
}	


