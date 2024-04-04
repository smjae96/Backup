package com.kh.network;

public class NetworkPractice {
	/*
	 * 네트워크
	 * : 컴퓨터 간의 데이터를 통신할 수 있도록 연결한 것.
	 * 
	 * * IP 주소		: 컴퓨터를 식별하는 번호	( 컴퓨터의 주민번호 )
	 * * 포트 번호		: 컴퓨터 내에 프로그램을 식별하는 번호
	 * 
	 * * 서버			: 클라이언트로부터 들어온 요청에 대한 응답을 하는 역할
	 * 				  서비스를 제공하는 프로그램
	 * * 클라이언트	: 필요한 정보(데이터)를 서버로 요청하는 역할 (고객)
	 * 				  서비스를 제공받는 프로그램
	 * 
	 * * 소켓		: 서버와 클라이언트가 통신을 하기 위한 통로
	 * 	* 통신 방식 *	
	 * 		- TCP : 안정성, 양방향, 연결지향적, 속도 느림
	 * 				http, 이메일, ftp (파일)
	 * 		- UDP : 신뢰성 없는 데이터 전달, 단방향, 비연결지향적, 속도 빠름
	 * 				실시간 동영상 서비스(스트리밍)
	 * 
	 * * 서버용 프로그램
	 * 		1) 포트번호 설정
	 * 		2) ServerSocket 객체 생성 (포트 번호 사용)
	 * 			: 클라이언트 연결 요청을 대기하는 역할
	 * 			ex) ServerSocket server = new ServerSocket(3000);
	 * 		3) 연결 요청을 수락하고 Socket 객체 생성
	 * 			ex) Socket socket = server.accept();
	 * 		4) 입출력 스트림 사용하여 데이터 통신 ..
	 * 			ex) 입력 스트림 : socket.getInputStream() 메소드를 입력용 스트림 생성자에 전달(할당)
	 * 			ex) 출력 스트림 : socket.getOutputStream() 메소드를 출력용 스트림 생성자에 전달(할당)
	 * 		5) 스트림 메소드 사용하여	... 데이터 통신 진행 ...
	 * 		6) 자원 사용 후에는 자원 반납(close()) **
	 * 			-> 생략 하는 방법 : try ~ with ~ resource 구문 사용하면 자동으로 반납가능!
	 * 			ex) try (ServerSocket server = new ServerSocket(3000);
	 * 						Socket socket = server.accept();	
	 * 							BufferedReader br = new BufferedReader(.....)) {	} catch(...) {	}
	 * * 클라이언트용 프로그램
	 * 		1) 서버의 "IP주소"와 "포트 번호" 확인!!
	 * 		2) 해당 서버의 정보로 Socket 객체 생성
	 * 			ex) Socket socket = new Socket(serverIP, port);
	 * 								// serverIP = InetAddress.getLocalhost().getHostAddress();
	 * 								//	=> serverIP의 위치: 로컬호스트 (나 자신)
	 * 		3) 입출력 스트림 생성.. 데이터 통신 진행..
	 * 		4) 통신 종료 시 자원 반납 (close())
	 */
	
	
}



