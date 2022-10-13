package com.sseda.admincontroller;



import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;






  @Controller
  
  public class AdminController {
  
	  private static final Logger log = org.slf4j.LoggerFactory.getLogger(AdminController.class);
	  
	  
	  
	  @GetMapping("/") 
	  public String m_login() { 
		  log.info("admin home...........");
		  return "/ad_main/m_login"; 
	  }
	  @PostMapping("adminlogin")
	  public String 
  }
 

