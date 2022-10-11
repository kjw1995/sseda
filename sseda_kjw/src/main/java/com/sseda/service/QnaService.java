package com.sseda.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.sseda.dto.Qna;
import com.sseda.dto.Question;

public interface QnaService {
	public String insert(Question q, MultipartFile file);
	public Map<String,List<Qna>> qna();
	public String[] detail(String no);
	public List<Question> mylist(String id);
	public Qna question(String no);
}
