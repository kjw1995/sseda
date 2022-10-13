package com.sseda.controller;



import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sseda.dto.Cre;
import com.sseda.dto.Member;
import com.sseda.dto.Page;
import com.sseda.service.MemberService;
import com.sseda.service.MemberServiceimp;
import com.sseda.service.MyServiceimp;
import com.sseda.www.HomeController;

@Controller
@RequestMapping("/mem/")
public class MypageController {
	
	@Autowired
	MemberService ms;
	
    @GetMapping("gologin")
    public String gologin() {
    	
    	return "/member/login";
    }
    
    @GetMapping("gosignup")
    public String gosingup() {
    	
    	return "/member/signup";
    }
    
    @PostMapping("DBcheckid")
    public ResponseEntity<String> DBcheckid(@RequestParam("id") String id){
   
    	String rs = ms.DBcheckid(id);
    	
    	return new ResponseEntity<String>(rs,HttpStatus.OK);
    }
    
    @PostMapping("signup") 
    public String signup(Member member) {
    	
    	ms.signup(member);
    	
    	return "redirect:/";
    }
    
    
    @GetMapping("mypage")
    public String mypage(@RequestParam("id") String id,
						 Model model) {
    	
    		
    	model.addAttribute("id",id);
    	
    	return "/mypage/mypage";
    }
    
    @GetMapping("mydetail")
    public String mydetail(@RequestParam("id") String id,
						   Model model) {
    	
    	
    	
    	model.addAttribute("mydetail",ms.mydetail(id));
    	
    	return "/mypage/userinfo";
    }
    
    @GetMapping("checkuser")
    public String checkuser(@RequestParam("pw") String pw,
							 Model model) {
    	
    	
    	
    	model.addAttribute("pw",pw);
    	
    	
    	
		return "/mypage/usercheck";
	 }
    
    @GetMapping("changeuser")
    public String changeuser(@RequestParam("id") String id,
							 Model model) {
    	
    	model.addAttribute("id",ms.changedetail(id));
    	
    	return "/mypage/changeuser";
    }
    
    @PostMapping("changeinfo")
    public ResponseEntity<String> changeinfo(Member member) {
    	
    	String rs = Integer.toString(ms.changeinfo(member));
    	
    	return new ResponseEntity<String>(rs,HttpStatus.OK);
    }
    
    @GetMapping("delreq")
    public String delreq(@RequestParam("id") String id,
    					 HttpSession sess) {
    
    	ms.delreq(id);
    	sess.invalidate();
    	return "redirect:/";
    }
    
    @GetMapping("detailmypage")
    public String userinfoitem(@ModelAttribute("id") String id,
    		                   @RequestParam("cate") String cate,
    						   Model model) {
    	
    	
    	
    	System.out.println("카테고리 = " + cate);
    	System.out.println("내 아이디 = " + id);
    	
    	
    	
    	model.addAttribute("category",cate);
    	model.addAttribute("id", id);
    	
    	return "/mypage/mypage_detail";
    }
    @GetMapping("myitemdel")
    public String myitemdel(@RequestParam("itemdel") String[] seqno,
    					   HttpSession sess,
						   Model model) {
    	
    	model.addAttribute("id",sess.getAttribute("id"));
    	ms.myitemdel(seqno);
    	
    	return "redirect:/mem/userinfoitem";
    }
    @GetMapping("pwfindform")
    public String pwfindform() {
    	return "/member/pwfind";
    }
    
    @PostMapping(value ="phonepw",produces = "text/plain; charset=UTF-8")
    public ResponseEntity<String> phonepw(@RequestBody Member member){
    	return new ResponseEntity<>(ms.phonepw(member.getName(), member.getPhonenumber()),HttpStatus.OK); 
    }
    @PostMapping(value ="emailpw",produces = "text/plain; charset=UTF-8")
    public ResponseEntity<String> emailpw(@RequestBody Member member){
    	return new ResponseEntity<>(ms.emailpw(member.getId(), member.getEmail()),HttpStatus.OK); 
    }
    @GetMapping("idfindform")
    public String idfindform() {
    	return "/member/pwfind";
    }
    
    @PostMapping(value ="phoneid")
    public String phoneid(@ModelAttribute Member member,Model m){
    	m.addAttribute("findid",ms.phoneid(member.getName(), member.getPhonenumber()));
    	return "/member/idfiod"; 
    }
    @PostMapping(value ="emailid")
    public String emailid(@ModelAttribute("name")String name,@ModelAttribute("email")String mail,@ModelAttribute("em")String em,Model m ){
    	String email = mail+"@"+em;
    	m.addAttribute("findid",ms.phoneid(name, email));
    	return "/member/idfiod"; 
    }
    
}


