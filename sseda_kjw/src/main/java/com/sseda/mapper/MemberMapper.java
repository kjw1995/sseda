package com.sseda.mapper;

import com.sseda.dto.Member;

public interface MemberMapper {
	
	public Member getById(String id);

	public int idcheck(String id);

	public int memreg(Member member);

	public int updateinfo(Member member);

}
