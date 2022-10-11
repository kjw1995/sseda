package com.sseda.mapper;


import static org.junit.Assert.*;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberMapperTest {

	private static final Logger log = LoggerFactory.getLogger("MemberMapperTest.class");
	
	@Autowired
	private MemberMapper member;
	
	@Test 
	public void test() {
		
		log.info("아이디 결과값 = {}" , member.getById("kjw").getId());
		
	}
	
	
	
	
}
