package com.sseda.controller;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.Files;
import com.sseda.dto.Page;
import com.sseda.service.FileService;
import com.sseda.service.ItemService;

import oracle.jdbc.proxy.annotation.Post;


@Controller
@RequestMapping("/item/*")
public class ItemController{
	
	@Autowired
	ItemService i;
	@Autowired
	FileService f;
	
	@GetMapping("list")
	public String itemlist(Cre c,Model m) {
		if(c.getCpage() == 0) c.setCpage(1);
		if(c.getRow() == 0) c.setRow(6);
		m.addAttribute("page", new Page(i.getT(c),c));
		m.addAttribute("item",i.list(c));
		
		return "/item/itemlist";
	}
	@GetMapping("detail")
	public String detail(Model m,@ModelAttribute("no") String no,HttpSession sess) {
		String id = (String)sess.getAttribute("sess_id");
		m.addAttribute("detail", i.detail(no,id));
		return "/item/itemdetail";
	}
	@GetMapping("itemregform")
	public String itemregform(Item item,Model m) {
		m.addAttribute(i);
		return "item/itemreg";
	}
	@PostMapping("itemreg")
	public String itemreg(RedirectAttributes rd,Item item) {
		i.reg(item);
		rd.addFlashAttribute("no",item.getSeqno());
		return "redirect:/item/detail";
	}
	@GetMapping("delete")
	public String itemdelete(@ModelAttribute("no") String no) {
		i.delete(no);
		return "redirect:/item/list";
	}
	@GetMapping("insertform")
	public String iteminsertform() {
		return "item/iteminsert";
	}
	@PostMapping("insert")
	public String iteminsert(Item item,RedirectAttributes rd,MultipartFile fileup) {
		rd.addFlashAttribute("no", i.insert(item,fileup));
		return "redirect:/item/detail";
	}
	@GetMapping("report")
	public String itemreport(@RequestParam("no")String no,RedirectAttributes rd) {
		i.reprot(no);
		rd.addFlashAttribute("no", no);
		return "redirect:/item/detail";
	}
	@GetMapping("filedown")
	public void filedown(Files fi,HttpServletResponse res) {
		f.filedown(fi,res);
	}

}
