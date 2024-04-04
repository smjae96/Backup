package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class TestRun {

	public static void main(String[] args) {
		// Properties 
		
		/*
		 * 특징)
		 * 		- Map 계열의 컬렉션 (key-value 세트로 데이터를 저장)
		 * 		- 문자열 (String) 타입으로 저장
		 * 		- 값을 저장(담을때) 	: setProperty(key, value)
		 * 		- 값을 조회(꺼내올때) 	: getProperty(key)	=> value 반환
		 * 		- 저장할 파일 종류		: .properties / .xml 형식으로 저장
		 */
		
		// SQL문 관련 파일 출력
		Properties prop = new Properties();
		
		// SQL문 저장
		String insertQuery = "INSERT INTO MEMBER\n VALUES(SEQ_UNO.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		String selectAllListQuery = "SELECT *\n FROM MEMBER";
		String searchIdQuery = "SELECT *\n FROM MEMBER WHERE USERID = ?";
		String searchByNameQuery = "SELECT *\n FROM MEMBER WHERE USERNAME Like ?";
		String updateMemberQuery = "UPDATE INTO MEMBER\n SET USERPW = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE USERNAME = ?";
		String deleteMemberQuery = "DELETE FROM MEMBER\n WHERE USERID = ?";
		prop.setProperty("insertMember", insertQuery);
		prop.setProperty("selectAllList", selectAllListQuery);
		prop.setProperty("searchId", searchIdQuery);
		prop.setProperty("searchByName", searchByNameQuery);
		prop.setProperty("updateMember", updateMemberQuery);
		prop.setProperty("deleteMember", deleteMemberQuery);
		//-----------------------------------------------------------------------
		try {
			
			// 폴더경로/파일명.확장자 (확장자: 파일 형식)
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "query.xml");
			
			System.out.println("설정 파일 저장 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			// xml 형식의 데이터를 입력받을 때는 .loadFromXML() 사용
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
			System.out.println(prop.getProperty("insertMember"));
			System.out.println(prop.getProperty("selectAllList"));
			System.out.println(prop.getProperty("searchId"));
			System.out.println(prop.getProperty("searchByName"));
			System.out.println(prop.getProperty("updateMember"));
			System.out.println(prop.getProperty("deleteMember"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	public static void jdbcOptionTest() {	
		// JDBC 관련 설정 파일 출력
		Properties prop = new Properties();
		
		
		// -----------------------------------------------
		// jdbc drvier 정보, url, username, userPw 정보 => 설정 파일에 저장
		prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
		prop.setProperty("userName", "C##JDBC");
		prop.setProperty("userPw", "JDBC");
		
		try {
			prop.store(new FileOutputStream("resources/driver.properties"), "JDBC option");
			
			System.out.println("설정 파일 저장 완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	----------------------------------------------- 
		// 파일 읽어오기 (입력)
		try {
			
			prop.load(new FileInputStream("resources/driver.properties"));
			
			String driver = prop.getProperty("driver");
			System.out.println(driver);
			String url = prop.getProperty("url");
			String userName = prop.getProperty("userName");
			String userPw = prop.getProperty("userPw");
			System.out.println(url);
			System.out.println(userName);
			System.out.println(userPw);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void propTest() {
		// 파일을 출력하는 것 => 파일에 데이터를 저장
		Properties prop = new Properties();		// Properties 객체 생성
		
		prop.setProperty("C", "INSERT");		// Create : 데이터 추가, 게시글 작성
		prop.setProperty("R", "SELECT");		// Read	  : 데이터 조회, 게시글 목록 조회
		prop.setProperty("U", "UPDATE");		// Update : 데이터 수정, 게시글 수정	
		prop.setProperty("D", "DELETE");		// Delete : 데이터 삭제, 게시글 삭제

		// 파일에 출력
		try {
			// 설정들을 저장하기 위한 파일 : .properties 형식 사용
			prop.store(new FileOutputStream("resources/test.properties"), "properties test");	// prop.store(new FileOutputStream("파일경로/파일명"), "주석");
			
			// SQL문들을 저장하기 위한 파일 : .xml 형식 사용
			//prop.store(new FileOutputStream("resources/testXml.xml"), "properties test");
			
			prop.storeToXML(new FileOutputStream("resources/testXml.xml"), "properties test");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
