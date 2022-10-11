package com.sseda.controller;

import org.hamcrest.core.Is;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class itemRestControllerTest {

	private static final Logger log = LoggerFactory.getLogger("itemRestControllerTest.class");
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void SignupRestControllerTest2() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void myitemdelTest() {
		
		String[] seqno = {"30"};
		
		String json = new Gson().toJson(seqno);
		
		try {
			
			String result = mockMvc.perform(MockMvcRequestBuilders.post("/item/myitemdel")
								   .contentType(MediaType.APPLICATION_JSON)
								   .content(json))
								   .andExpect(status().is(200))
								   .andReturn()
								   .getResponse()
								   .getContentAsString();
			
			log.info("아이템 삭제후 결과 = {}" , result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
