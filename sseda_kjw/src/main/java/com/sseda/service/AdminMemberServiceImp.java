package com.sseda.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseda.dao.AdminDao;
import com.sseda.dao.AdminMemberDao;
import com.sseda.dto.AdminList;
import com.sseda.dto.Cre;
import com.sseda.dto.Member;


@Service
public class AdminMemberServiceImp implements AdminMemberService {
	@Autowired
	AdminMemberDao memberdao;
	
	@Override
	public AdminList list(Cre cre) {
		return memberdao.memberlist(cre);
	}
	

	public Member detailList(String id) {
		
		return memberdao.detailList(id);
	}
	
	
	public List<Member> deleteList() {
		return memberdao.deleteList();
	}
	
	public void delete(String id) {
		 memberdao.delete(id);
	}
	
	
	public int total(Cre cre) {
		System.out.println(memberdao.total(cre));
		return 0;
	}
	
	
	public String update(String id) {
		return memberdao.update(id);
	}

	/*public String login(HttpServletRequest req) {
		return memberdao.login(req);
	}*/

}
