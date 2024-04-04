package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import model.vo.Member;

public class MemberDao {

	
	public int insertMember(Member m, Connection conn) {
		// PreparedStatement 객체 사용
		
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO MEMBERLIST VALUES(SEQ_MEM.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPw());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getSsn());
			pstmt.setInt(6, m.getAge());
			pstmt.setDouble(7, m.getHeight());
			pstmt.setDouble(8, m.getWeight());
			
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public Member searchId(Connection conn, String userId) {
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBERLIST WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("GENDER"), rset.getString("SSN"), rset.getInt("AGE"), rset.getDouble("HEIGHT"), rset.getDouble("WEIGHT"),
						rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	public int deleteMember(Member m, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
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
