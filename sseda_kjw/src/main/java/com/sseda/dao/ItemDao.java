package com.sseda.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sseda.dto.Cre;
import com.sseda.dto.Item;
import com.sseda.dto.Files;

public interface ItemDao {
	public List<Item> list(Cre c2);
	public Item detail(String seqno, String id);
	public void delete(String no);
	public void reg(Item item);
	public String insert(Item item,Files fi);
	public void report(String no);
	public int getT(Cre c);
}
