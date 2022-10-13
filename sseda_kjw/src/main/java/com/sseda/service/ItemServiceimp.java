package com.sseda.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sseda.dao.ItemDao;
import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.Files;

@Service
public class ItemServiceimp implements ItemService {
	
	@Autowired
	ItemDao dao;
	@Autowired
	FileService f;
	
	@Override
	public List<Item> list(Cre c) {
		return dao.list(c);
	}
	@Override
	public Item detail(String parameter, String id) {
		return dao.detail(parameter,id);
		
	}
	@Override
	public void delete(String parameter) {
		dao.delete(parameter);
		
	}
	@Override
	public void reg(Item item) {
		dao.reg(item);
		
	}
	@Override
	public String insert(Item item,MultipartFile file) {
		Files fi = new Files();
		System.out.println(file);
		if(file.getSize() != 0) {
			fi = f.fileupload(file);
		}
		return dao.insert(item,fi);
	}
	@Override
	public void reprot(String no) {
		dao.report(no);
	}
	@Override
	public int getT(Cre c) {
		return dao.getT(c);
	}
	@Override
	public int myitemdel(String[] obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
