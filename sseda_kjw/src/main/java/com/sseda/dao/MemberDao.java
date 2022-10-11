package com.sseda.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sseda.dto.Cre;
import com.sseda.dto.FirstmyVo;
import com.sseda.dto.Item;
import com.sseda.dto.Member;

public interface MemberDao {

	public String[] loginproc(String id, String pw);
	
	public FirstmyVo firstmy(String id);
	
	public Member mydetail(String id);
	
	public int changeinfo(Member member);
	
	public void delreq(String id);
	
	public String DBcheckid(String id);
	
	public void signup(Member member);
	
	public List<Item> myitem(String id,Cre cre);
	
	public int myitemtotal(String id);
	
}
