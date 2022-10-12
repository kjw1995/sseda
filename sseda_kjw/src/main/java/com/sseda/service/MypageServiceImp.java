package com.sseda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseda.dao.MyPageDao;
import com.sseda.dto.Cre;
import com.sseda.dto.myListVO;

@Service
public class MypageServiceImp implements MyPageService{

	@Autowired
	MyPageDao my;
	
	@Override
	public myListVO myList(Cre cre, String id, String cate) {
		
		return new myListVO(my.total(id, cate),
				            my.mylist(cre, id, cate));
	}

}
