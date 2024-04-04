package service;

import java.lang.reflect.Member;
import java.sql.Connection;

import common.JDBCTemplate;
import model.dao.MemberDao;
import model.vo.User;

public class MemberService {

	// 회원 추가
	public int insertMember(User u) {
		// 1) Connection 객체 생성 (jdbc driver 등록 포함)
		Connection conn = JDBCTemplate.getConnection();
		
		// 2) Member객체 dao 전달하여 데이터 처리에 대한 결과 받기
		int result = new MemberDao().insertMember(u, conn);
		
		// 3) 데이터 추가/수정/삭제(DML) 작업 시 트랜잭션 처리
		if(result>0) {		// 회원 추가 성공
			JDBCTemplate.commit(conn);
		} else {				// 회원 추가 실패
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public User searchId(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		User u = new MemberDao().searchId(conn, userId);
		
		JDBCTemplate.close(conn);
		
		return u;
	}
	
		
	public User foundId(String userName, String phone) {
		Connection conn = JDBCTemplate.getConnection();
		
		User u = new MemberDao().foundId(conn, userName, phone);
		
		JDBCTemplate.close(conn);
		
		return u;
	}
	
	public User foundPw(String userId, String email, String ssn) {
		Connection conn = JDBCTemplate.getConnection();
		
		User u = new MemberDao().foundPw(conn, userId, email, ssn);
		
		JDBCTemplate.close(conn);
		
		return u;
	}
	
	public int updateMember(User u) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMember(u, conn);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteMember(User u) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(u, conn);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
