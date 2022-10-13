package com.sseda.admincontroller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sseda.dto.Cre;
import com.sseda.dto.Page;
import com.sseda.dto.SeachName;
import com.sseda.service.AdminMemberService;
import com.sseda.service.AdminService;



@Controller
public class AdminMemberController  {
	private static final Logger log = LoggerFactory.getLogger(AdminMemberController.class);
	@Autowired 
	AdminMemberService adservic;
	
	@GetMapping("memberList") 
	public String AdmemberList(SeachName sn, Cre cre, Model model) {
		cre.setSearchname(sn);
		if(cre.getCpage() == 0) {
			cre.setCpage(1);
		}
		if(cre.getRow() == 0) {
			cre.setRow(5);
		}
		model.addAttribute("page", new Page(adservic.total(cre),cre));
		model.addAttribute("member", adservic.list(cre));
		return "/ad_member/memberList";
	}
	
	@GetMapping("memberDetail")
	public String AdmemberDetail(@ModelAttribute("id") String id, Model model) {
		model.addAttribute("member", adservic.detailList(id));
		return "/ad_member/memberDetail";
	}
	
	
	@GetMapping("memberDeleteList")
	public String AdDeleteList(Model model) {
		model.addAttribute("member", adservic.deleteList());
		return "/ad_member/memberDeleteList";
	}
	
	@GetMapping("memberDelete") 
	public String AdDelete(@ModelAttribute("id") String id) {
		adservic.delete(id);
		return "redirect:/admem/memberDeleteList";
	}
	
	@PutMapping(value="update", produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> update(@RequestBody String id) {
		log.info("==========업데이트 컨드롤러========");
		return new ResponseEntity<>(adservic.update(id),HttpStatus.OK);
	}
	


	
}
