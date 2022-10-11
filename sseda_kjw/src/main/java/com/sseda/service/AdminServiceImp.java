package com.sseda.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sseda.dao.AdminDao;
import com.sseda.dto.AdminList;
import com.sseda.dto.Member;

public class AdminServiceImp implements AdminService {
	AdminDao memberdao = new AdminDao();
	
	@Override
	public AdminList list(HttpServletRequest req) {
		return memberdao.memberlist(req);
	}
	

	public Member detailList(String id) {
		
		return memberdao.detailList(id);
	}
	
	
	public List<Member> deleteList() {
		return memberdao.deleteList();
	}
	
	public Member delete(String id) {
		return memberdao.delete(id);
	}


	public String login(HttpServletRequest req) {
		return memberdao.login(req);
	}

}
