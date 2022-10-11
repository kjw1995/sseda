package com.sseda.dao;

import java.util.List;
import java.util.Map;

import com.sseda.dto.Files;
import com.sseda.dto.Qna;
import com.sseda.dto.Question;

public interface QnaDao {
	public String inset(Question q,Files fi);
	public Map<String,List<Qna>> qna();
	public List<Qna> qnaview(String m);
	public String[] detail(String no);
	public List<Question> mylist(String id);
	public Qna question(String no);
	
}
