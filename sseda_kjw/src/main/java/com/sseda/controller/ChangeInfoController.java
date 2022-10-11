package com.sseda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sseda.dto.Member;
import com.sseda.service.MemberService;

@RestController
@RequestMapping("/mem/")
public class ChangeInfoController {

	private static final Logger log = LoggerFactory.getLogger(ChangeInfoController.class);
	
	@Autowired
	MemberService ms;
	
	@PostMapping(value = "updateinfo", produces = "text/plain; charset=utf-8") 
	public ResponseEntity<String> updateinfo(@RequestBody Member member) {
		log.info("내정보 수정");
		
		log.info("수정할 비밀번호 = {} ", member.getPw());
		
		return ms.updateinfo(member) == 1 ? new ResponseEntity<>("ok",HttpStatus.OK) :
            								new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
