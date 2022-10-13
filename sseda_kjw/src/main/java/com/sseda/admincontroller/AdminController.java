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
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(AdminController.class);
	
	@GetMapping("/")
	public String m_login() {
		log.info("admin home...........");
		return "/ad_main/m_login";
	}
}	


