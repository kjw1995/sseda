package com.sseda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sseda.dao.AdminItemDao;
import com.sseda.dto.Cre;
import com.sseda.dto.Item;

public class AdminItemServiceImpl implements AdminItemService {

	@Autowired
	AdminItemDao itemdao;

	@Override
	public List<Item> list(Cre cri) {
		return itemdao.itemList(cri);
	}

	@Override
	public int getTotalRec(Cre cri) {
		return itemdao.gettotal(cri);
	}

	@Override
	public int delete(String ino) {
		return itemdao.delete(ino);
	}
	
}
