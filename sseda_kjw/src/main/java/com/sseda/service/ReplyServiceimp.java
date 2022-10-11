package com.sseda.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sseda.dto.Cre;
import com.sseda.dto.Reply;
import com.sseda.mapper.ReplyMapper;

@Service
public class ReplyServiceimp implements ReplyService {
	
	private static final Logger log = LoggerFactory.getLogger("RplyServiceimp.class");
	
	
	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public int replyinsert(Reply r) {
		log.info("reply insert service called..");
		return mapper.insert(r);
	}

	@Override
	public List<Reply> list(String no, Cre c) {
		return mapper.list(no,c);
	}

	@Override
	public int total(String c) {
		return mapper.total(c);
	}

	@Override
	public Reply detail(String no) {
		return mapper.detail(no);
	}

	@Override
	public int update(Reply r) {
		return mapper.update(r);
	}

	@Override
	public int delete(String no) {
		return mapper.delete(no);
	}

}
