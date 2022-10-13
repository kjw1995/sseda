package com.sseda.admincontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.Page;
import com.sseda.service.AdminItemService;

@Controller
@RequestMapping(value="item")
public class AdminItemController {
private static final Logger log = LoggerFactory.getLogger(AdminItemController.class);
	@Autowired
	AdminItemService itemService;

	@RequestMapping(value="/List", method= {RequestMethod.POST, RequestMethod.GET})
    public String itemlist(Model m, Cre c) {
    	log.info("itemlist......");
    	if(c.getCpage() == 0) c.setCpage(1);
    	if(c.getRow() == 0) c.setRow(3);
    	
    	List<Item> item = itemService.list(c);
    	
    	m.addAttribute("page", new Page(itemService.getTotalRec(c), c));
    	m.addAttribute("item", itemService.list(c));
    	
    	return "/ad_item/itemList";
    }
	
	 @DeleteMapping(value="/delete",
				produces = "text/plain; charset=utf-8")
	 	public ResponseEntity<String> delete(@RequestBody String rno)  {
		log.info("itemdelete............");
		 int id = itemService.delete(rno); 
		return id > 0 ? new ResponseEntity<>("삭제완료", HttpStatus.OK)
 						:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
}

}
