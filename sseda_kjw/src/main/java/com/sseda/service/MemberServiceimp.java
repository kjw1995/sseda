package com.sseda.service;


import java.sql.Array;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseda.dao.MemberDaoImp;
import com.sseda.dto.Cre;
import com.sseda.dto.FirstmyVo;
import com.sseda.dto.Item;
import com.sseda.dto.Member;
import com.sseda.mapper.MemberMapper;

@Service
public class MemberServiceimp implements MemberService {
	
	@Autowired
	MemberDaoImp dao;
	
	@Autowired
	MemberMapper mapper;
	
	@Override
	public String[] login(String id, String pw) {
		return dao.loginproc(id, pw);
	}
	
	@Override
	public FirstmyVo firstmy(String id) {
		return dao.firstmy(id);
	}
	
	@Override
	public Member mydetail(String id) {
		return dao.mydetail(id);
	}
	
	@Override
	public int changeinfo(Member member) {
		return dao.changeinfo(member);
	}

	@Override
	public void delreq(String id) {
		dao.delreq(id);
	}

	@Override
	public String DBcheckid(String id) {
		return dao.DBcheckid(id);
	}

	@Override
	public void signup(Member member) {
		dao.signup(member);
		
	}

	@Override
	public List<Item> myitem(String id,Cre cre) {
		return dao.myitem(id,cre);
	}

	@Override
	public void myitemdel(String[] seqno) {
		dao.myitemdel(seqno);
		
	}

	@Override
	public int idcheck(String id) {
			
		return mapper.idcheck(id);
	}

	@Override
	public int memreg(Member member) {
		
		return mapper.memreg(member);
	}

	@Override
	public Member changedetail(String id) {
		
		return dao.changedetail(id);
	}

	@Override
	public int updateinfo(Member member) {
		
		return mapper.updateinfo(member);
	}

	@Override
	public int myitemtotal(String id) {
		
		return dao.myitemtotal(id);
	}

	@Override
	public String phoneid(String name, String num) {
		return dao.phoneid(name, num);
	}

	@Override
	public String emailid(String email, String name) {
		return dao.emailid(email, name);
	}

	@Override
	public String phonepw(String name, String phone) {
		return dao.emailpw(name, phone);
	}

	@Override
	public String emailpw(String id, String em) {
		return dao.emailpw(id, em);
	}

	@Override
	public void pwchange(Member m) {
		dao.pwchange(m);
	}
	
	
	
	
}
