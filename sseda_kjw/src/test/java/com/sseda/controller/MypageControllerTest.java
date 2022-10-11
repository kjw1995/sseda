package com.sseda.controller;
import static org.junit.Assert.*;


import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sseda.dto.FirstmyVo;
import com.sseda.dto.Item;
import com.sseda.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MypageControllerTest {
	
private static final Logger log = LoggerFactory.getLogger("MypageControllerTest.class");
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Before
	public void MypageControllerTestSetUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
//	@Test
//	public void gologinTest() {
//		try {
//			
//			String result = mockMvc.perform(MockMvcRequestBuilders.get("/mem/gologin"))
//					        .andReturn().getModelAndView().getViewName();
//			log.info("gologin 맵핑시 = " + result + ".jsp");
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void gosignUp() {
//		try {
//			
//			String result = mockMvc.perform(MockMvcRequestBuilders.get("/mem/gosignup"))
//					        .andReturn().getModelAndView().getViewName();
//			log.info("gosignup 맵핑시 = " + result + ".jsp");
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void dbCheckIdTest() {
//		
//		try {
//				//아이디 가 중복될시
//			 	String result = mockMvc.perform(MockMvcRequestBuilders.post("/mem/DBcheckid")
//			 					.param("id", "kjw"))
//			 			        .andExpect(status().is(200))
//			 			        .andReturn()
//			 			        .getResponse()
//			 			        .getContentAsString();
//				log.info("아이디 중복 검사 결과 = " + result);
//				
//				//아이디 생성이 가능 할시
//				result = mockMvc.perform(MockMvcRequestBuilders.post("/mem/DBcheckid")
//	 					.param("id", "kjw2"))
//	 			        .andExpect(status().is(200))
//	 			        .andReturn()
//	 			        .getResponse()
//	 			        .getContentAsString();
//				log.info("아이디 중복 검사 결과 = " + result);
//				
//				
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void firstMy() {
//		try {
//			
//			String result = mockMvc.perform(MockMvcRequestBuilders.get("/mem/mypage")
//					               .param("id", "kjw"))
//								   .andReturn()
//								   .getModelAndView()
//								   .getViewName();
//			log.info("첫번째 마이페이지 맵핑 =  " + result);
//			
//			FirstmyVo firstmyvo = (FirstmyVo)mockMvc.perform(MockMvcRequestBuilders.get("/mem/mypage")
//		                                   .param("id", "kjw"))
//					                       .andReturn()
//					                       .getModelAndView()
//					                       .getModel()
//					                       .get("my");
//			log.info("아이디 = " + firstmyvo.getId());
//			log.info("이름 = " + firstmyvo.getName());
//			log.info("이메일 = " + firstmyvo.getEmail());
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
		
//	@Test
//	public void checkUser() {
//		try {
//			
//			String result = mockMvc.perform(MockMvcRequestBuilders.get("/mem/checkuser")
//					               .param("pw", "1234"))
//								   .andReturn()
//								   .getModelAndView()
//								   .getViewName();
//			 log.info("비밀번호 체크 맵핑 = " + result + ".jsp" );
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void mydetailTest() {
//		
//		try {
//	          ModelAndView result = mockMvc.perform(MockMvcRequestBuilders.get("/mem/mydetail")
//					               .param("id","kjw"))
//			                       .andReturn()
//			                       .getModelAndView();
//	          Member member = (Member)result.getModel().get("mydetail");
//	          log.info("내 정보 상세조회 시 맵핑 = {}" , result.getViewName());
//	          log.info("내 정보 상세조회, id = {}" , member.getId());
//	          log.info("내 정보 상세조회, pw = {}" , member.getPw());
//	          log.info("내 정보 상세조회, name = {}" , member.getName());
//	          log.info("내 정보 상세조회, gender = {}" , member.getGender());
//	          log.info("내 정보 상세조회, nickname = {}" , member.getNickname());
//	          log.info("내 정보 상세조회, phonenumber = {}" , member.getPhonenumber());
//	          log.info("내 정보 상세조회, email = {}" , member.getEmail());
//
//	          
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void delreqTest() {
//		
//		try {
//			
//			ModelAndView result = mockMvc.perform(MockMvcRequestBuilders.get("/mem/userinfoitem")
//						           .param("id","kjw"))
//								   .andReturn()
//								   .getModelAndView();
//			log.info("내 아이템 조회 시 맵핑 = {} " , result.getViewName());   
//			log.info("내가 가진 아이템 갯수 = {} " , result.getModel().size());
//			List<Item> item = (List<Item>)result.getModel().get("myitem");
//			for(int i=0; i < result.getModel().size(); i++) {
//				log.info("내가 가진 아이템 제목 = {}" ,item.get(i).getTitle());
//			}
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	@Test
	public void updateInfoTest() {
		Member member = new Member();
		
		member.setId("kjw");
		member.setPw("1234");
		member.setNickname("kjwch");
		member.setPhonenumber("01023234466");
		member.setEmail("update@daum.net");
		
		String json = new Gson().toJson(member);
		
		try {
			
			String result = mockMvc.perform(MockMvcRequestBuilders.post("/mem/updateinfo")
								   .contentType(MediaType.APPLICATION_JSON)
								   .content(json))
								   .andExpect(status().is(200))
								   .andReturn()
								   .getResponse()
								   .getContentAsString();
			
			log.info("회원 정보 수정후 결과 = {}" , result);
			
			
		} catch(Exception e) {
			
		}
	}
	
	
	
	
}
