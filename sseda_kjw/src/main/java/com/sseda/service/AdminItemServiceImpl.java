package com.sseda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseda.dao.AdminItemDao;
import com.sseda.dto.Cre;
import com.sseda.dto.Item;

@Service
public class AdminItemServiceImpl implements AdminItemService {

	@Autowired
	AdminItemDao itemdao;

	private static final String CHARSET = "utf-8";
	
	@Override
	public List<Item> list(Cre c) {
		return itemdao.itemList(c);
	}

	@Override
	public int getTotalRec(Cre c) {
		return itemdao.gettotal(c);
	}

	@Override
	public int delete(String ino) {
		return itemdao.delete(ino);
	}
	
}
