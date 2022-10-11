package com.sseda.controller;

import static org.hamcrest.CoreMatchers.containsString;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.sseda.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
								   
public class SignupRestControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger("SignupRestControllerTest.class");
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void SignupRestControllerTest2() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
//	@Test
//	public void idCheckTest() {
//		String id = "kjw";
//		try {
//			String result = mockMvc.perform(get("/mem/idcheck/" + id))
//                			       .andExpect(status().isOk())
//			                       .andReturn()
//                 			       .getResponse()
//			                       .getContentAsString();	
//			
//         	   log.info("아이디 중복 시 검사 결과 = {}", result);
//         	   id = "noneid";
//         	   
//         	  result = mockMvc.perform(get("/mem/idcheck/" + id))
//   			                  .andExpect(status().isOk())
//                              .andReturn()
//    			              .getResponse()
//                              .getContentAsString();
//        	   log.info("아이디 생성 가능시 검사 결과 = {}", result);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	
//	@Test
//	public void memregTest() {
//		Member member = new Member();
//		
//		member.setId("resttest2");
//		member.setPw("123456");
//		member.setName("테스트1");
//		member.setNickname("rest1");
//		member.setPhonenumber("01023445567");
//		member.setGender("M");
//		member.setEmail("rest2@daum.net");
//		
//		String json = new Gson().toJson(member);
//		
//		try {
//			String result = mockMvc.perform(MockMvcRequestBuilders.post("/mem/memreg")
//					        .contentType(MediaType.APPLICATION_JSON)
//					        .content(json))
//							.andExpect(status().is(200))
//							.andReturn()
//							.getResponse()
//							.getContentAsString();
//			log.info("회원 가입 성공시 결과 = {} " , result);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	
	
	
}
