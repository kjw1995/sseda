package com.sseda.controller;

import javax.sql.DataSource;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class LoginTest {

	private static final Logger log = LoggerFactory.getLogger("LoginTest.class");
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void loginTestSetup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		log.info("MockMvc 설정");
	}
	
	@Test
	public void loginTest() {
		try {
			
			//로그인 성공
			String rs = mockMvc.perform(MockMvcRequestBuilders.post("/login")
					.param("id", "kjw").param("pw", "12345"))
					.andReturn().getModelAndView().getViewName();
			log.info("로그인 성공 = " + rs);
			
			//비밀번호 불일치
			rs = mockMvc.perform(MockMvcRequestBuilders.post("/login")
					.param("id", "kjw").param("pw", "123"))
					.andReturn().getModelAndView().getViewName();
			log.info("비밀번호 불일치 = " + rs);
			
			//존재 하지 않는 회원
			rs = mockMvc.perform(MockMvcRequestBuilders.post("/login")
					.param("id", "none").param("pw", "123"))
					.andReturn().getModelAndView().getViewName();
			log.info("존재하지 않는 회원 = " + rs);
			
			//탈퇴 요청 회원
			rs = mockMvc.perform(MockMvcRequestBuilders.post("/login")
					.param("id", "www").param("pw", "123123"))
					.andReturn().getModelAndView().getViewName();
			log.info("탈퇴 요청 회원 = "  + rs);
			
		} catch (Exception e1) {
			e1.printStackTrace();		}
	}
	
}
