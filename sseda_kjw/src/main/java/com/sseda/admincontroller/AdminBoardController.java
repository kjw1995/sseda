package com.sseda.admincontroller;

import java.util.List;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.sseda.dto.Board;
import com.sseda.dto.Cre;
import com.sseda.dto.Page;
import com.sseda.service.AdminBoardService;

@Controller
public class AdminBoardController {
private static final Logger log = LoggerFactory.getLogger(AdminBoardController.class);
	@Autowired
	AdminBoardService boardService;
	
	@RequestMapping(value="boardList", method= {RequestMethod.POST, RequestMethod.GET})
	public String list(Model model, Cre cri) {
		log.info("boardlist......");
		if(cri.getCpage() == 0) cri.setCpage(1);
		if(cri.getRow() == 0) cri.setRow(3);
		
		List<Board> board = boardService.list(cri);
	
		model.addAttribute("page", new Page(boardService.getTotalRec(cri), cri));
		model.addAttribute("board", board);
		
		return "/ad_board/boardList";
	}
	
	
    @DeleteMapping(value="delete",
    				produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> delete(@RequestBody String rno)  {
    	log.info("boarddelete......");
       int bd = boardService.delete(rno); 
       System.out.println("삭제확인" + bd);
        return bd == -1 ? new ResponseEntity<>("삭제완료", HttpStatus.OK)
        				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
    }
    
	
}