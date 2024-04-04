package test;

import java.sql.Connection;	// 오류 나면 module-info 파일에 requires java.sql; 입력.
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class TestRun {

	public static void main(String[] args) {
		/*
		 * * JDBC 용 객체
		 * 	- Connection	: DB의 연결정보를 담고있는 객체
		 * 	- [Prepared]Statement : 연결된 DB에 sql문을 전달하여 실행하고
		 * 							그 결과를 받아주는 객체 **중요 객체** 
	 	 * 	- ResultSet			: SELECT문 실행 후 조회된 결과들이 담겨있는 객체	
	 	 * 
	 	 * * JDBC 과정 (** 순서 중요 **)
	 	 * 1) jdbc driver 등록	: 해당 DBMS(오라클)가 제공하는 클래스 등록
	 	 * 2) Connection 생성		: 연결하고자 하는 DB정보를 입력해서 해당 DB와 연결하면서 생성
	 	 * 							- url(접속 주소), 사용자이름(id), 비밀번호(pw)
	 	 * 3) Statement 생성		: Connection 객체를 이용하여 생성
	 	 * 						  sql문을 실행하고 결과를 받는 역할
	 	 * 4) sql문을 DB에 전달하여 실행 : Statement 객체를 이용하여 실행
	 	 * 5) 결과 받기
	 	 * 		[1] SELECT문 실행 : ResultSet 객체 (조회된 데이터들이 담겨져있음)
	 	 * 		[2] DML문 실행	: int (처리된 행 수)
	 	 * 6) 결과 처리
	 	 * 		[1] ResultSet에 담겨져 있는 데이터들을 하나하나 뽑아서 vo객체에 옮겨 닮기 [+ Arraylist에 차곡차곡 담기]
	 	 * 		[2] 트랜잭션 처리 (성공적으로 수행했으면 commit, 실패했으면 rollback)
	 	 * 7) 사용이 완료되면 JDBC용 객체들을 반드시 자원 반납 해주어야 함 (close) => 생성 역순으로 	
		 */
//		insertTest();
		
		// 2. 각자 PC의 DB에 JDBC계정으로 접속하여 TEST 테이블의 모든 데이터를 조회(SELECT) 해보기
		//			DQL(SELECT) => ResultSet 객체 (조회된 모든 데이터) => 컬럼 값들을 각각 뽑아내기
		
		// 필요한 변수 세팅
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		// sql문 작성
		String sql = "SELECT * FROM TEST"; // 쿼리문 쓸 때 끝에 ;(세미콜론) 안붙임.
		
		// 1) jdbc driver 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("oracle driver 등록 성공");
			// 2) Connection 객체 생성
			//		-url => jdbc:oracle:thin:@접속IP(호스트명):포트:SID
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			
			// 3) Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4), 5) sql문을 실행하고 결과 받기 (결과: ResultSet)
			rset = stmt.executeQuery(sql);
			//	6) 결과를 하나하나 뽑아보기
			//	   데이터가 있는 지 여부 : rset.next() : boolean (데이터 있으면 true, 없으면 false)	
			while(rset.next()) {
				// 데이터를 가지고 올 때, '컬럼명' 또는 '컬럼순번' 데이터를 꺼내올 수 있음
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				int tno = rset.getInt("TNO");
				String tname = rset.getString("TNAME");
				Date tdate = rset.getDate("TDATE");
				String sdate = dateFormat.format(tdate);
				System.out.printf("번호: %d, 이름: %s, 날짜: %s \n",tno,tname,sdate);
				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("oracle driver 등록에 실패했습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}
	
	public static void insertTest() {	
		// 1. 각자 PC(127.0.0.. | localhost)에 JDBC계정을 연결한 후 TEST테이블에 INSERT 해보기
		//			DML(INSERT) => 처리된 행 수(int) => 트랜잭션 처리
		
		// 필요한 변수 세팅
		int result = 0;			// 결과(처리된 행 수)를 받아줄 변수
		Connection conn = null; // DB의 연결정보를 보관할 객체
		Statement stmt = null;	// sql문을 전달하여 실행 후 결과를 받는 객체
		
		// 실행할 sql문 ("완성 형태"로 만들기)
		//	* Statement 객체에는 항상 완성 형태의 sql문을 작성해야 함.
		//	* SQL문 맨 뒤에 세미콜론이 없어야함!
		Scanner sc = new Scanner(System.in);
		System.out.print("번호를 입력하세요. : ");
		int tno = sc.nextInt();
		
		sc.nextLine();
		System.out.print("이름을 입력하세요. : ");
		String tname = sc.nextLine();
		
		String sql = "INSERT INTO TEST VALUES ("+ tno +", '" + tname + "', SYSDATE)";
		
		try {
			// 1) jdbc driver 등록 -- 주석 이동하기 : alt 누른 상태로 방향기 위아래 조절.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//	* ClassNotFoundException 발생 시 확인할 부분
			//		[1] ojdbcX.jar 파일을 등록(추가)했는 지
			//		[2] 추가했는데도 오류가 난다면, "오타"가 있는 지 확인.
			System.out.println("OracleDriver 등록 완료");
			
			// 2) Connection 객체 생성 : DB에 연결 (url, 사용자명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			
			// 3) Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4, 5) sql문을 전달하면서 실행 후 결과 받기 (결과: 처리된 행 수)
			result = stmt.executeUpdate(sql);
			//	실행한 sql문이 DML문(INSERT, UPDATE, DELETE)일 경우 => stmt.execute(sql) : int
			//	실행한 sql문이 SELECT문일 경우 => stmt.executeUpdate(sql) : ResultSet
			
			// 6) 트랜잭션 처리 (내가 실행한 sql문이 DML문이므로, 트랜잭션 처리 필요)
			/*
			 * Auto commit : 기본 on (jdbc6 버전 이후 auto커밋이 설정됨)
			 * - off 설정 방법
			 * 		* 코드 작성	: conn.setAutoCommit(false);
			 * 		* 실행 시 옵션	: JVM 실행 옵션 추가
			 * 					  -Doracle.jdbc.autoCommitSpecCompliant=false
			 * 					 => Run Configuration -> arguments -> VM arguments에 위 옵션 추가.
			 */
			if (result >0) {	// sql문이 성공했을 경우, commit
				conn.commit();
			} else {			// sql문이 실패했을 경우, rollback
				conn.rollback();
				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver를 찾지 못했습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 7) 사용 완료 후 JDBC 객체 반납 ( 생성 역순으로 )
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		// 확인용
		if (result > 0) {
			System.out.println("성공적으로 데이터가 추가되었습니다.");
		} else {
			System.out.println("데이터 추가에 실패하였습니다.");
		}
	}

}
