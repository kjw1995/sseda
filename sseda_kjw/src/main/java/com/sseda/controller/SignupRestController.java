package com.sseda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakjw.controller.user.RestControllerSample;
import com.sseda.dto.Member;
import com.sseda.service.MemberService;

@RestController
@RequestMapping("/mem/")
public class SignupRestController {

	private static final Logger log = LoggerFactory.getLogger(SignupRestController.class);

	@Autowired
	MemberService ms;

	@GetMapping(value = "idcheck/{id}", produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> idCheck(@PathVariable("id") String id) {
		log.info("아이디 중복검사 맵핑");
		log.info("중복검사 아이디 = {}", id);

		boolean status = true;

		if (ms.idcheck(id) == 0) {
			status = false;
		}

		String result = String.valueOf(status);

		log.info("중복검사후 넘어오는 값 = {}", result);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PostMapping(value = "memreg", produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> memreg(@RequestBody Member member) {

		log.info("회원가입 맵핑");
		log.info("회원가입 아이디 = {} ", member.getId());
		log.info("회원가입 비밀번호 = {} ", member.getPw());

		return ms.memreg(member) == 1 ? new ResponseEntity<>("ok", HttpStatus.OK) :
   				                        new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
