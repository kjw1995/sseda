package com.sseda.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sseda.dto.Cre;
import com.sseda.dto.Reply;

public interface ReplyMapper {
	
	
	public int insert(Reply r);

	public List<Reply> list(@Param("no")String no,@Param("c") Cre c);

	public int total(String c);

	public Reply detail(String no);
	
	public int update(Reply r);
	
	public int delete(String no);
}
