package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

// DAO (Data Access Object)
public class MemberDao {
	/*
	 * 	 기존 : DAO 클래스에 사용자가 요청할 때마다 실행해야하는 SQL문을 자바 소스코드 내에 명시적으로 작성 (정적코딩방식)
	 * 	 -> 문제점 : SQL문을 수정해야 할 때 자바 소스코드를 수정해야 함 => 수정한 내용을 반영할 때 프로그램을 종료 후 재시작해야 함.
	 * 	 -> 해결 : SQL문을 별도로 관리하는 외부 파일(.xml)로 만들어서 실시간으로 기록된 SQL문을 읽어서 실행 (동적코딩방식)
	 */
	private Properties prop = new Properties();
	
	public MemberDao() {	// 생성자로 파일 읽어오기!
		try {
			// xml 파일 읽기
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 회원 추가 메소드 (사용자가 입력한 데이터들을 DB에 추가)
	 * @param conn, m : Connection 객체와 사용자가 입력한 데이터(Member)
	 * @return result : 처리된 행 수 (회원 추가 결과)
	 */
	public int insertMember(Member m, Connection conn) {
		// PreparedStatement 객체 사용
		
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertMember");
		//String sql = "INSERT INTO MEMBER VALUES(SEQ_UNO.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPw());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	/**
	 * 회원 전체 목록 조회
	 * @param conn : Connection 객체
	 * @return list : 회원 전체 목록을 담은 ArrayList<Member> 타입의 데이터
	 * @param conn
	 * @return
	 */
	public ArrayList<Member> selectAllList(Connection conn) {
		
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// SQL문 작성
		//String sql = "SELECT * FROM MEMBER";
		String sql = prop.getProperty("selectAllList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("GENDER"), rset.getInt("AGE"), rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE"));
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public Member searchId(Connection conn, String userId) {
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		String sql = prop.getProperty("searchId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("GENDER"), rset.getInt("AGE"), rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	/**
	 * 사용자가 입력한 회원 이름에 대한 키워드 검색
	 * @param conn
	 * @param keyWord
	 * @return list : 키워드에 해당되는 회원 목록
	 */
	public ArrayList<Member> searchByName(Connection conn, String keyWord) {
		ArrayList<Member> list = new ArrayList<>();	// 검색 결과를 담을 리스트
		
		PreparedStatement pstmt = null;	// SQL문 실행할 객체
		ResultSet rset = null;		   // SQL 실행 결과 타입
		
		//String sql = "SELECT * FROM MEMBER WHERE USERNAME Like ?";
		String sql = prop.getProperty("searchByName");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyWord+"%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("GENDER"), rset.getInt("AGE"), rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public int updateMember(Member m, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		//String sql = "UPDATE INTO MEMBER SET USERPW = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE USERNAME = ?";
		String sql = prop.getProperty("updateMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPw());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Member m, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		//String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		String sql = prop.getProperty("deleteMember");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}
}
