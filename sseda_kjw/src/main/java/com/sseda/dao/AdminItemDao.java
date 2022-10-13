package com.sseda.dao;

import java.util.List;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;

public interface AdminItemDao {

	public List<Item> itemList(Cre c);
	
	public int delete(String ino);
	
	public int gettotal(Cre c);
}
