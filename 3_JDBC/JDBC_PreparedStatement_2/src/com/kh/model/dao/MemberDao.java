package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Member;

/*
 * 	DAO (Data Access Object)
 * 	: DB에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환 (JDBC 작업)
 * 	  결과를 Controller 쪽으로 전달
 * 
 */
public class MemberDao {
	/*
	 * * JDBC용 객체
	 * 	- Connection : DB의 연결을 하기 위한 객체. DB 연결정보를 가지고 있음.
	 * 	- [Prepared]Statement : 연결된 DB에 SQL문을 전달하여 실행하고, 결과를 돌려받는 객체
	 *  - ResultSet	: SELECT문(DQL)을 실행하고 조회된 결과문들이 담겨있는 객체
	 *  
	 * * JDBC 과정 -> **순서**
	 *  [1] jdbc driver 등록 : 사용할 DBMS(오라클)가 제공하는 클래스 등록 -- Class.forname(~)
	 *  [2] Connection 객체 생성 : 연결하려는 DB정보를 입력하여 해당 DB와 연결하면서 객체 생성  (내 프로젝트에 Referenced Libraries에 ojdbc8.jar 파일이 있어야 함!)
	 *  [3] Statement 객체 생성 : Connection 객체를 통해 생성.
	 *  [4] SQL문 전달하여 실행 : Statement 객체를 이요하여 실행.
	 *  [5] 결과 받기
	 *  	  - DQL (SELECT) : ResultSet(조회된 결과물) 객체로 결과 받기
	 *  	  - DML (INSERT, UPDATE, DELETE) : int(처리된 행 수)로 결과 받기
	 *  [6] 결과 처리
	 *  	  - DQL 결과 : 하나하나 뽑아서 vo객체에 차곡차곡 담기
	 *  	  - DML 결과 : 처리된 행 수가 있으면(성공했으면) commit, 
	 *  					처리된 행 수가 없으면(실패했으면) rollback
	 *  [7] 사용 완료 후 자원 반납 ( close ) -> 생성 역순으로** 	
	 */
	
	/**
	 * 사용자가 입력한 정보들을 db에 추가하는 메소드
	 * @param m : 사용자가 입력한 회원 정보를 담고있는 Member 객체
	 * @return : insert문 실행 후 처리된 행 수
	 */
	public int insertMember(Member m) {
		// INSERT문 실행 => 처리된 행 수 => 트랜잭션 처리
		
		// 필요한 변수들 세팅
		Connection conn = null;		// DB 연결
		PreparedStatement pstmt = null;		// SQL 실행 및 결과 받기
		int result = 0;				// 처리된 결과
		
		// SQL문 작성. 완성된 형태의 SQL.
		// INSERT INTO MEMBER VALUES(SEQ_UNO.NEXTVAL, 'user1', 'pass1', '홍길동',
		//			'남', 25, 'hong@gmail.com', '01012345678', '강남', '독서', SYSDATE);
		String sql = " INSERT INTO MEMBER VALUES(SEQ_UNO.NEXTVAL, "
					+	"?, "
					+	"?, "
					+ 	"?, "
					+	"?, "
					+ 	"?, "
					+ 	"?, "
					+	"?, "
					+	"?, "
					+	"?, "
					+	"SYSDATE)";
		
		
		try {
			// [1] jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// [2] Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			
			// [3] Statement 객체 생성
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
			
			
			// [4], [5] SQL문 실행 및 결과 받기
			result = pstmt.executeUpdate();
			
			// [6] DML -> 트랜잭션 처리 (결과가 0일 때 (실패) rollback, 0보다 클 때 (성공) commit)
			if(result>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//	[7] 사용한 자원 반납
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	/**
	 * 회원 목록 전체 조회
	 * @return ArrayList<Member> : 회원 목록을 담은 ArrayList 객체를 반환
	 */
	public ArrayList<Member> selectAllList() {
		// SELECT문 (여러 행 조회) => ResultSet 객체 => ArrayList<Member>에 담기
		
		// 필요한 변수 세팅
		ArrayList<Member> list = new ArrayList<>();		// 비어있는 상태
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		// 조회된 결과들이 담길 객체
		
		// SQL문 작성
		String sql = "SELECT * FROM MEMBER";
		
		
		
		try {
			// [1] jdbc driver 등록 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// [2] Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			
			// [3] Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// [4], [5] SQL문 실행하고 결과 받기 (ResultSet 타입으로 결과 받기)
			rset = pstmt.executeQuery();
			
			// [6] 결과 처리
			while(rset.next()) {
				Member m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
							rset.getString("GENDER"), rset.getInt("AGE"), rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
							rset.getString("HOBBY"), rset.getDate("ENROLLDATE"));
				/*
				 * Member m = new Member();
				 * 
				 * m.setUserNo(rset.getInt("USERNO"));
				 * m.setUserId(rset.getString("USERID"));
				 * ...
				 * m.setEnrollDate(rset.getDate("ENROLLDATE"));
				 */
				// 현재 참조하고 있는 행에 대한 모든 데이터들을 Member 객체에 담기
				list.add(m);
			}
			// 반복문 끝난 시점
			// 조회된 데이터가 없다면 리스트가 비어있을 것이고
			// 조회된 데이터가 있다면 리스트에는 한 개 이상의 데이터가 담겨있을 것이다.
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// [7] 자원 반납 (생성 역순으로)
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
		
	}
	/**
	 * 사용자가 입력한 회원id 값에 해당하는 회원 정보 조회
	 * @param userId : 회원 ID
	 * @return Member : 회원 정보
	 */
	public Member searchId(String userId) {
		// 회원 정보 조회(한개 행) => ResultSet 객체 => Member 객체
		
		// 필요한 변수 세팅
		Member m = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// SQL문 작성
		// SELECT * FROM MEMBER WHERE USERID = 'user1'
		
		//* Statement 객체 사용 시 작성한 SQL문
		//	String sql = "SELECT * FROM MEMBER " + "WHERE USERID = '"+ userId + "'";
		//*	PreparedStatement 객체 사용 시 작성한 SQL문
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");	// url 에러 시 확인할 곳.
			
			// Statement 객체 생성
			// stmt = conn.createStatement();
			// * PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);		// PreparedStatement 객체 생성 시 SQL문을 전달(미완성/완성된 상태 상관x)
			pstmt.setString(1, userId);			// setXXX (XXX: 데이터 타입) setXXX(변수순번, 전달할변수(값))
			//* Statement 객체 사용 시
			//rset = stmt.executeQuery(sql);
			// * PreparedStatement 객체 사용 시
			rset = pstmt.executeQuery();
			
			
			
			while(rset.next()) {
				m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("GENDER"), rset.getInt("AGE"), rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE"));
				
			}
			// 위의 조건문이 끝난 시점
			// 조회된 결과가 없다면, member 객체는 null
			// 조회된 결과가 있다면, member 객체가 생성된 상태.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// [7] 사용한 자원 반납 (역순으로)
				rset.close();
				//stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	
	public ArrayList<Member> searchByName(String userKeyWord) {
		
		ArrayList<Member> list = new ArrayList<>();
		
		Connection conn = null;
		// 객체 변경 : Statemet -> PreparedStatement
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE ?";
					//"SELECT * FROM MEMBER WHERE USERNAME LIKE '%' || ? || '%'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+userKeyWord+"%");
			//pstmt.setString(1, userKeyWord);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member(rset.getInt("USERNO"), rset.getString("USERID"), rset.getString("USERPW"), rset.getString("USERNAME"),
						rset.getString("GENDER"), rset.getInt("AGE"), rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLLDATE"));
				list.add(m);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return list;
	}
	/**
	 * 사용자가 입력한 정보로 회원 정보 수정
	 * @param m : 수정할 정보가 포함된 Member 객체
	 * @return result : 처리된 행 수(int)
	 */
	public int updateMember(Member m) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET USERPW = ?, EMAIL= ?, PHONE= ?, ADDRESS= ? WHERE USERID= ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPw());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			result = pstmt.executeUpdate();
			
			if(result>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	public int deleteMember(Member m) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID= ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			result = pstmt.executeUpdate();
			
			if(result>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
}
