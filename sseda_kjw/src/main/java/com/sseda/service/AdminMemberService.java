package com.sseda.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sseda.dto.AdminList;
import com.sseda.dto.Cre;
import com.sseda.dto.Member;

public interface AdminMemberService {
	
	public AdminList list(Cre cre);
	
	public Member detailList(String id);
	
	public List<Member> deleteList();
	
	public void delete(String id);

	public int total(Cre cre);

	public String update(String id);
	
	
}
