package com.sseda.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sseda.dto.Board;
import com.sseda.dto.Cre;
import com.sseda.dto.Files;
import com.sseda.dto.Page;
import com.sseda.service.BoardService;
import com.sseda.service.BoardServiceimp;
import com.sseda.service.FileService;
import com.sseda.service.ReplyService;

@Controller
@RequestMapping("/board/")
public class BoardController extends HttpServlet {
	
	@Autowired
	BoardService b;
	@Autowired
	FileService f;
	
	@GetMapping("list")
	public String boardlist(Cre c,Model m) {
		if(c.getCpage() == 0) c.setCpage(1);
		if(c.getRow()==0) c.setRow(6);
		
		m.addAttribute("board", b.board(c));
		m.addAttribute("page", new Page(b.getT(c),c));
		
		return "/board/board";
	}
	@GetMapping("detail")
	public String boarddetail(@ModelAttribute("no")String no,HttpSession sess,Model m) {
		m.addAttribute("b",b.detail(no,(String)sess.getAttribute("sess_id")));
		return "/board/boarddetail";
	}
	@GetMapping("insertform")
	public String insertform() {
		return "/board/boardinsert";
	}
	@PostMapping("insert")
	public String insert(Board board,MultipartFile fileup,RedirectAttributes rd,HttpSession sess) {
		board.setId((String)sess.getAttribute("sess_id"));
		rd.addFlashAttribute("no",b.insert(board,fileup));
		return "redirect:/board/detail";
	}
	@GetMapping("delete")
	public String delete(@ModelAttribute("no")String no) {
		b.del(no);
		return "redirect:/board/list";
	}
	@GetMapping("regform")
	public String regform() {
		return "/board/boardreg";
	}
	@PostMapping("reg")
	public String reg(Board board,RedirectAttributes rd) {
		b.reg(board);
		rd.addFlashAttribute("no",board.getNo());
		return "redirect:/board/detail";
	}
	@GetMapping("report")
	public String report(RedirectAttributes rd,@ModelAttribute("no")String no) {
		b.report(no);
		rd.addFlashAttribute("no",no);
		return "redirect:/board/detail";
	}
	@GetMapping("filedown")
	public void filedonw (Files fi,HttpServletResponse res) {
		f.filedown(fi, res);
	}

}
