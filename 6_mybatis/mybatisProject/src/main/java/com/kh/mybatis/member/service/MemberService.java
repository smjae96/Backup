package com.kh.mybatis.member.service;

import org.apache.ibatis.annotations.Insert;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {
	// 인터페이스 : 상수필드(public static final) + 추상메소드(public abstract)
//	@Insert ("insert into member values(#{userId}, #{userPwd}, #{userName}, "
//			+ "#{email}, #{birthday}, #{gender}, #{phone}, #{address}, #{enrollDate}, #{modifyDate}, #{status}")
	public abstract int insertMember(Member m);
	
	public abstract Member loginMember(Member m);
	
	public abstract int updateMember(Member m);
	
	public abstract int deleteMember(String userId);
}