package com.sseda.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sseda.dto.delIno;
import com.sseda.service.ItemService;

@RestController
@RequestMapping("/item/")
public class ItemRestController {
	
	@Autowired
	ItemService i;
	
	private static final Logger log = LoggerFactory.getLogger(ChangeInfoController.class);
	
	@PostMapping(value = "myitemdel",
		         produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> myitemdel(@RequestBody List<String> obj) {
		
		log.info("내 아이템 삭제 맵핑확인");
		log.info("넘어오는 객체 = {} " ,obj);
		
		String[] ino = new String[obj.size()];
		
		for(int i=0; i < obj.size(); i++) {
			log.info("넘어오는 시퀀스 번호 = {}", obj.get(i));
			ino[i] = obj.get(i);
		}
		
		log.info("만든 배열 객체 = {}" , ino);
		
		i.myitemdel(ino);
		
	    return new ResponseEntity<>("suc",HttpStatus.OK);                          	    
	}
}

	
	
	
	

