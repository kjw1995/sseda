package com.sseda.service;

import java.sql.Array;

import java.util.List;

import com.sseda.dto.Cre;
import com.sseda.dto.FirstmyVo;
import com.sseda.dto.Item;
import com.sseda.dto.Member;

public interface MemberService {
	
	public String[] login(String id, String pw);

	public FirstmyVo firstmy(String id);
	
	public Member mydetail(String id);

	public int changeinfo(Member member);

	public void delreq(String id);

	public String DBcheckid(String id);

	public void signup(Member member);

	public List<Item> myitem(String id,Cre cre);

	public void myitemdel(String[] seqno);

	public int idcheck(String id);
	
	public int memreg(Member member);

	public Member changedetail(String id);

	public int updateinfo(Member member);

	public int myitemtotal(String id);
	
	
}
