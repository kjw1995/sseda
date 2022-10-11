package com.sseda.service;

import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sseda.dto.Files;



@Service
public class FileServiceimp implements FileService {
	
	
	@Override
	public Files fileupload(MultipartFile file) {
		long l = file.getSize();
		Files fi = new Files();
		String filename = file.getOriginalFilename();
		String save_filename =	filename.substring(0,(filename.lastIndexOf(".")));
		String save_fileexe = filename.substring(filename.lastIndexOf(".")+1);
		String filepath = "d:/sseda/upload/";
		UUID uid = UUID.randomUUID();
		String savefilename = save_filename + "_" + uid + "." + save_fileexe;
		
		File f = new File(filepath+savefilename);
		try {
			file.transferTo(f);
			String filetype = file.getContentType();
			String filetype1 = filetype.substring(0,filetype.indexOf("/"));
			
			fi.setFilename(filename);
			fi.setFilepath(filepath);
			fi.setSavefile(savefilename);
			fi.setFilesize(String.valueOf(l));
			fi.setFiletype(filetype);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fi;
	}
	@Override
	public void filedown(Files fi,HttpServletResponse res) {
		File f = new File(fi.getFilepath()+"/"+fi.getSavefile());
		
		try {
			InputStream in = new FileInputStream(f);
			OutputStream os = res.getOutputStream();
			res.reset();
			res.setHeader("Cache-control", "no-cache");
			res.addHeader("Content-disposition", "attachen; fileName="+URLEncoder.encode(fi.getFilename(),"UTF-8"));
			byte[] fb = new byte[(int)f.length()];
			
			int rd = 0;
			while(0 < (rd = in.read(fb))) {
				os.write(fb,0, rd);
				os.flush();
			}
			in.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
