package com.sseda.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sseda.dto.Cre;
import com.sseda.dto.Reply;
import com.sseda.dto.Replylist;
import com.sseda.service.ReplyService;

import oracle.jdbc.proxy.annotation.Post;

@RestController
@RequestMapping("/reply/")
public class ReplyController {
	
	private static final Logger log = LoggerFactory.getLogger("ReplyContriller.class");
	
	@Autowired
	private ReplyService r;
	
	//consumes는 request시 데이터 처리방식
	@PostMapping(value = "insert", consumes = "application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> replyinsert(@RequestBody Reply reply){
		log.info("insert.............");
		log.info("ReplyController replyinsert called"+reply);
		int rs = r.replyinsert(reply);
		return rs == 1 ? new ResponseEntity<String>("성공",HttpStatus.OK) 
					   : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping(value="list/{bno}/{cpage}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
	public ResponseEntity<Replylist> list(@PathVariable("bno")String no,@PathVariable("cpage")int cpage){
		log.info("list.....................");
		Cre c = new Cre(cpage,5);
		Replylist rl = new Replylist();
		rl.setReply(r.list(no,c));
		rl.setTotal(r.total(no));
		return new ResponseEntity<>(rl,HttpStatus.OK);
	}
	@PostMapping(value="detail",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
	public ResponseEntity<Reply> detail(@RequestBody String no){
		return new ResponseEntity<>(r.detail(no),HttpStatus.OK);
	}
	@PutMapping(value="reg", produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> update(@RequestBody Reply reply){
		int rs = r.update(reply);
		return rs == 1 ? new ResponseEntity<>("수정완료",HttpStatus.OK)
					   : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping(value="delete", produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> delete(@RequestBody String no){
		log.info("delete .......................");
		return r.delete(no) == 1 ? new ResponseEntity<>("삭제성공",HttpStatus.OK)
								 : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
