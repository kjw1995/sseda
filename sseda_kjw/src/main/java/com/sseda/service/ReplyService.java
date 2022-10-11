package com.sseda.service;

import java.util.List;

import com.sseda.dto.Cre;
import com.sseda.dto.Reply;

public interface ReplyService {

	public int replyinsert(Reply r);

	public List<Reply> list(String no, Cre c);

	public int total(String no);

	public Reply detail(String no);
	
	public int update(Reply r);

	public int delete(String no);
}
