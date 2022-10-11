package com.sseda.dao;

import java.util.List;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;

public interface AdminItemDao {

	public List<Item> itemList(Cre cri);
	
	public int delete(String string);
	
	public int gettotal(Cre cri);
}
