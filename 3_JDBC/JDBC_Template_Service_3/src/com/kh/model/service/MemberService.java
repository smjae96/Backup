package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

public class MemberService {
	/*
	 * 	1) JDBC driver 등록
	 * 	2) Connection 객체 생성
	 * 	3) Connection 객체 처리
	 */
	
	// 회원 추가
	public int insertMember(Member m) {
		// 1) Connection 객체 생성 (jdbc driver 등록 포함)
		Connection conn = JDBCTemplate.getConnection();
		
		// 2) Member객체 dao 전달하여 데이터 처리에 대한 결과 받기
		int result = new MemberDao().insertMember(m, conn);
		
		// 3) 데이터 추가/수정/삭제(DML) 작업 시 트랜잭션 처리
		if(result>0) {		// 회원 추가 성공
			JDBCTemplate.commit(conn);
		} else {				// 회원 추가 실패
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	// 전체 회원 목록 조회
	public ArrayList<Member> selectAllList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().selectAllList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	// 아이디로 검색
	public Member searchId(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().searchId(conn, userId);
		
		JDBCTemplate.close(conn);
		
		return m;
	}
	
	// 회원 이름에 대한 키워드 검색
	public ArrayList<Member> searchByName(String keyWord) {
		Connection conn = JDBCTemplate.getConnection();	// Connection 객체 생성
		
		// DAO 에게 필요한 데이터 전달 후 DB 조회(처리) 결과를 받기
		ArrayList<Member> list = new MemberDao().searchByName(conn, keyWord);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMember(m, conn);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(m, conn);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
