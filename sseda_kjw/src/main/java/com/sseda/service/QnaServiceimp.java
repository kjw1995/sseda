package com.sseda.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sseda.dao.QnaDao;
import com.sseda.dao.QnaDaoimp;
import com.sseda.dto.Files;
import com.sseda.dto.Qna;
import com.sseda.dto.Question;
import com.sseda.dto.QuestionFile;

@Service
public class QnaServiceimp implements QnaService {
	
	
	@Autowired
	QnaDao dao;
	@Autowired
	FileService f;
	
	@Override
	public String insert(Question q, MultipartFile file) {
		Files fi = new Files();
		if(file != null) {
			fi = f.fileupload(file);
		}
		return dao.inset(q,fi);
	}
	@Override
	public Map<String,List<Qna>> qna() {
		return dao.qna();
	}
	@Override
	public String[] detail(String no) {
		return dao.detail(no);
	}
	@Override
	public List<Question> mylist(String id) {
		return dao.mylist(id);
	}
	@Override
	public Qna question(String no) {
		return dao.question(no);
	}

}
