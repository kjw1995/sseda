package com.sseda.dao;

import java.util.List;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.myList;

public interface MyPageDao {
	
	public myList mylist(Cre cre, String id,String cate);
	
	public int total(String id, String cata);
	
}
