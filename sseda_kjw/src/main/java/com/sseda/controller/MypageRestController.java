package com.sseda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakjw.service.ReplyServiceImp;
import com.sseda.dto.Cre;
import com.sseda.dto.myListVO;
import com.sseda.service.MyPageService;

@RestController
@RequestMapping("/memre/")
public class MypageRestController {
	
	private static final Logger log = LoggerFactory.getLogger(MypageRestController.class);

	@Autowired
	MyPageService ms;
	
	
	@GetMapping(value="mypagelist/{id}/{cate}/{page}",
				produces= {MediaType.APPLICATION_XML_VALUE,
						   MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<myListVO> mypagelist(@PathVariable("id")String id,
											   @PathVariable("cate")String cate,
											   @PathVariable("page")int page ) {
		
		log.info("레스트 컨트롤러 카테고리 확인 = {}", cate);
		log.info("페이지 = {}", page);
		Cre cre = new Cre(page,15);
		
		log.info("내아이템 개수 = {} " , ms.myList(cre, id, cate).getTotal());
		
		return new ResponseEntity<myListVO>(ms.myList(cre, id, cate),HttpStatus.OK);
	}
}
