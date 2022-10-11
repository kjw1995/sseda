package com.sseda.service;

import java.util.List;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;

public interface AdminItemService {

	public List<Item> list(Cre cri);
	
	public int getTotalRec(Cre cri);
	
	public int delete(String ino);
}
