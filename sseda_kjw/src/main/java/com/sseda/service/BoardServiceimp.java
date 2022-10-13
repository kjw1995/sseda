package com.sseda.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sseda.dao.BoardDao;
import com.sseda.dao.BoardDaoimp;
import com.sseda.dto.Board;
import com.sseda.dto.BoardList;
import com.sseda.dto.Cre;
import com.sseda.dto.Files;

@Service
public class BoardServiceimp implements BoardService {
	
	@Autowired
	BoardDao dao;
	@Autowired
	FileService fs;
	
	public String insert(Board b,MultipartFile file) {
		Files f = new Files();
		System.out.println(file);
		if(file.getSize() != 0) {
			f = fs.fileupload(file);
		}
		return dao.insert(b,f);
	}
	public Board detail(String no, String id) {
		return dao.detail(no,id);
	}
	public BoardList board(Cre c) {
		return dao.board(c);
	}
	public void reg(Board b) {
		dao.reg(b);
	}
	public void del(String no) {
		dao.del(no);
	}
	public void report(String no) {
		dao.report(no);
	}
	public int getT(Cre c) {
		return dao.getT(c);
	}

}
