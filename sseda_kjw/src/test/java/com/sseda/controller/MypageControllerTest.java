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
//			log.info("gologin ????????? = " + result + ".jsp");
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
//			log.info("gosignup ????????? = " + result + ".jsp");
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void dbCheckIdTest() {
//		
//		try {
//				//????????? ??? ????????????
//			 	String result = mockMvc.perform(MockMvcRequestBuilders.post("/mem/DBcheckid")
//			 					.param("id", "kjw"))
//			 			        .andExpect(status().is(200))
//			 			        .andReturn()
//			 			        .getResponse()
//			 			        .getContentAsString();
//				log.info("????????? ?????? ?????? ?????? = " + result);
//				
//				//????????? ????????? ?????? ??????
//				result = mockMvc.perform(MockMvcRequestBuilders.post("/mem/DBcheckid")
//	 					.param("id", "kjw2"))
//	 			        .andExpect(status().is(200))
//	 			        .andReturn()
//	 			        .getResponse()
//	 			        .getContentAsString();
//				log.info("????????? ?????? ?????? ?????? = " + result);
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
//			log.info("????????? ??????????????? ?????? =  " + result);
//			
//			FirstmyVo firstmyvo = (FirstmyVo)mockMvc.perform(MockMvcRequestBuilders.get("/mem/mypage")
//		                                   .param("id", "kjw"))
//					                       .andReturn()
//					                       .getModelAndView()
//					                       .getModel()
//					                       .get("my");
//			log.info("????????? = " + firstmyvo.getId());
//			log.info("?????? = " + firstmyvo.getName());
//			log.info("????????? = " + firstmyvo.getEmail());
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
//			 log.info("???????????? ?????? ?????? = " + result + ".jsp" );
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
//	          log.info("??? ?????? ???????????? ??? ?????? = {}" , result.getViewName());
//	          log.info("??? ?????? ????????????, id = {}" , member.getId());
//	          log.info("??? ?????? ????????????, pw = {}" , member.getPw());
//	          log.info("??? ?????? ????????????, name = {}" , member.getName());
//	          log.info("??? ?????? ????????????, gender = {}" , member.getGender());
//	          log.info("??? ?????? ????????????, nickname = {}" , member.getNickname());
//	          log.info("??? ?????? ????????????, phonenumber = {}" , member.getPhonenumber());
//	          log.info("??? ?????? ????????????, email = {}" , member.getEmail());
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
//			log.info("??? ????????? ?????? ??? ?????? = {} " , result.getViewName());   
//			log.info("?????? ?????? ????????? ?????? = {} " , result.getModel().size());
//			List<Item> item = (List<Item>)result.getModel().get("myitem");
//			for(int i=0; i < result.getModel().size(); i++) {
//				log.info("?????? ?????? ????????? ?????? = {}" ,item.get(i).getTitle());
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
			
			log.info("?????? ?????? ????????? ?????? = {}" , result);
			
			
		} catch(Exception e) {
			
		}
	}
	
	
	
	
}
