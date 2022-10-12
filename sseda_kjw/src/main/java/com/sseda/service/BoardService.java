package com.sseda.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.sseda.dto.Board;
import com.sseda.dto.BoardList;
import com.sseda.dto.Cre;

public interface BoardService {
	public String insert(Board b,MultipartFile file);
	public Board detail(String no, String id);
	public BoardList board(Cre c);
	public void reg(Board b);
	public void del(String no);
	public void report(String no);
	public int getT(Cre c);
}
