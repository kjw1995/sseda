package com.sseda.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
		// 간단한 값을 가져올때는 어노테이션을 이용해 sql문을 작성해도된다. 
		// sql 실행 결과값의 데이터타입은 메소드의 리턴타입.
		@Select("SELECT sysdate FROM dual") 
		public String getTiem();
		
		@Select("SELECT id FROM member WHERE id = 'kjw' ")
		public String getId();
		
}
