package com.sseda.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.sseda.dto.Files;

public interface FileService {
	
	public Files fileupload(MultipartFile file);

	public void filedown(Files fi,HttpServletResponse res); 
}
