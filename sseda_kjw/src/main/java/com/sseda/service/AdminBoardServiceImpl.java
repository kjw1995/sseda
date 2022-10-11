package com.sseda.service;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseda.dao.AdminBoardDao;
import com.sseda.dto.Board;
import com.sseda.dto.Cre;
import com.sseda.mapper.BoardMapper;

@Service
public class AdminBoardServiceImpl implements AdminBoardService {

	@Autowired
	AdminBoardDao boarddao;
	
	@Autowired
	BoardMapper bm;
	
	private static final String CHARSET = "utf-8";

	@Override
	public List<Board> list(Cre cri) {
		return boarddao.boardList(cri) ;
	}


	@Override
	public int getTotalRec(Cre cri) {
		return boarddao.gettotal(cri);
	}


	@Override
	public int delete(String bno) {
		return bm.delete(bno);
	}

}
