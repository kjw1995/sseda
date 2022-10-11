package com.sseda.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sseda.dto.Question;
import com.sseda.service.QnaService;

@Controller
@RequestMapping("/qna/")
public class QnaController {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(QnaController.class);
	
	@Autowired
	QnaService q;
	
	@GetMapping("service")
	public String service(Model m) {
		log.info("service.......");
		m.addAttribute("qna",q.qna());
		return "/service/service";
	}
	@GetMapping("insertform")
	public String insertform() {
		return "/service/serviceinsert";
	}
	@PostMapping("insert")
	public String insert(Question question,@ModelAttribute("file")MultipartFile file,RedirectAttributes rd) {
		log.info("insert................");
		String no = q.insert(question, file);
		rd.addFlashAttribute("no",no);
		return "redirect:/qna/question";
	}
	@GetMapping("myquestion")
	public String questionlist(HttpSession sess,Model m) {
		String id = (String)sess.getAttribute("sess_id");
		m.addAttribute("qna",q.mylist(id));
		return "/mypage/myqnalist";
	}
	@GetMapping("question")
	public String question(@ModelAttribute("no") String no,Model m) {
		log.info("no 값.....:"+no);
		m.addAttribute("qna",q.question(no));
		return "/mypage/question";
	}
	@PostMapping(value="detail",produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> detail(@RequestBody String no){
		String seqno = no.substring(1,no.length()-1);
		log.info("detail controller.................");
		String[] qn = q.detail(seqno);
		return new ResponseEntity<>((qn[1]+"/"+qn[0]),HttpStatus.OK);
	}
	

}
