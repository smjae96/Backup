package model.dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import model.vo.User;

public class MemberDao {

	
	public int insertMember(User u, Connection conn) {
		// PreparedStatement 객체 사용
		
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO USERS VALUES(SEQ_USER.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPw());
			pstmt.setString(3, u.getUserName());
			pstmt.setString(4, u.getNickName());
			pstmt.setString(5, u.getEmail());
			pstmt.setString(6, u.getPhone());
			pstmt.setString(7, u.getSsn());
			pstmt.setString(8, u.getAddress());
			pstmt.setString(9, u.getInterest());
			
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public User searchId(Connection conn, String userId) {
		User u = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM USERS WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				u = new User(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("NICKNAME"), rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("SSN"), rset.getString("ADDRESS"), rset.getString("INTEREST"),
						rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return u;
	}
	
	public int updateMember(Member m, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBERLIST SET USERPW = ? , PHONE = ? , HEIGHT = ?, WEIGHT = ? WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPw());
			pstmt.setString(2, m.getPhone());
			pstmt.setDouble(3, m.getHeight());
			pstmt.setDouble(4, m.getWeight());
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
		
		String sql = "DELETE FROM MEMBERLIST WHERE USERID = ?";
		
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
	
	public User foundId(Connection conn, String userName, String phone) {
		User u = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PHONE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, phone);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				u = new User(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("NICKNAME"), rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("SSN"), rset.getString("ADDRESS"), rset.getString("INTEREST"),
						rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return u;
		
	}
	
	public User foundPw(Connection conn, String userId,  String email, String ssn) {
		User u = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM USERS WHERE USERID = ? AND EMAIL = ? AND SSN = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, email);
			pstmt.setString(3, ssn);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				u = new User(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("NICKNAME"), rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("SSN"), rset.getString("ADDRESS"), rset.getString("INTEREST"),
						rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return u;
		
	}
}
