package com.sseda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sseda.dto.AdminList;
import com.sseda.dto.Member;
import com.sseda.service.AdminServiceImp;

@WebServlet("/admem/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req,resp);
	}




	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminServiceImp memberservice = new AdminServiceImp();
	
		String uri = req.getRequestURI();		
	    String cmd = uri.substring(uri.lastIndexOf("/")+1);
	    if(cmd.equals("adlogin")) {
	    	String s = memberservice.login(req);
	    	if(s.equals("0")) {
	    		req.setAttribute("id", s);
	    		goView(req,resp,"/ad_main/m_main.jsp");
	    	}else if(s.equals("1")) {
	    		req.setAttribute("id", s);
	    		goView(req,resp,"/ad_main/m_login.jsp");
	    	}else if(s.equals("2")) {
	    		req.setAttribute("id", s);
	    		goView(req,resp,"/ad_main/m_login.jsp");
	    	}
	    }
	    if(cmd.equals("memberList")) {
	    	AdminList member = memberservice.list(req);
	      req.setAttribute("member", member);
		  goView(req, resp, "/ad_member/memberList.jsp");
	      	
	    } else if(cmd.equals("memberDetail")) {
	    	req.setAttribute("member", memberservice.detailList(req.getParameter("id")));
		    goView(req, resp, "/member/memberDetail.jsp");	
	    } else if(cmd.equals("memberDeleteList")) {
	    	 List<Member> member = memberservice.deleteList();
	    	 req.setAttribute("member", member);
	    	 goView(req, resp, "/member/memberDeleteList.jsp");
	    } else if(cmd.equals("memberDelete")) {
	    	req.setAttribute("member", memberservice.delete("id"));
	    	goView(req, resp, "/admem/memberDeleteList");
	    } 
	}


	private void goView(HttpServletRequest req, HttpServletResponse resp, String viewPage) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
	
	
}
