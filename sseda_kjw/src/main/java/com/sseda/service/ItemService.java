package com.sseda.service;


import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;


public interface ItemService {
	public List<Item> list(Cre c);
	public Item detail(String parameter, String id);
	public void delete(String parameter);
	public void reg(Item item);
	public String insert(Item item,MultipartFile file);
	public void reprot(String no);
	public int getT(Cre c);
	public int myitemdel(String[] obj);
	
}
