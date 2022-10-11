package com.sseda.dao;


import com.sseda.dto.Board;
import com.sseda.dto.BoardList;
import com.sseda.dto.Cre;
import com.sseda.dto.Files;

public interface BoardDao {
	public String insert(Board b,Files file);
	public Board detail(String no, String id);
	public BoardList board(Cre c);
	public void reg(Board b);
	public void del(String no);
	public void report(String no);
	public int getT();
}
