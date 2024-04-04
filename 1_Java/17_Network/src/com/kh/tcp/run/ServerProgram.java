package com.kh.tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerProgram {
	/*
	 * TCP (Transmission Control Protocol)
	 * - 서버, 클라이언트 간의 1:1 통신
	 * - 데이터를 교환하기 전 서버와 클라이언트가 연결되어야 함.
	 * 	 (연결 전에는 서버가 먼저 실행되어 클라이언트를 기다리고 있어야 함)
	 * - 신뢰성 있는 데이터를 전달 가능
	 * 
	 * * Socket : 네트워크에서 통로의 역할
	 * - 프로세스 간의 통신을 담당
	 * - Input / OutputStream을 가지고 있음 ( 이 스트림을 통해 입출력이 이루어짐 )
	 * 
	 * * ServerSocket 
	 * - 포트와 연결되어 외부의 연결 요청을 기다리다 연결 요청이 들어오면 수락하는 용도
	 * 	=> 수락: 통신할 수 있는 socket 생성
	 */
	static BufferedReader br = null;
	static PrintWriter pw = null;
	static ServerSocket serversocket = null;
	public static void main(String[] args) {
		// Scanner 추가
		Scanner sc = new Scanner(System.in);
		// 1) 포트 번호 지정 : 서버측에서 몇 번 포트로 통로를 열어 줄 것인지를 의미
		int port = 3000;
		BufferedReader br = null;
		PrintWriter pw = null;
		ServerSocket serversocket = null;
		// 2) ServerSocket 객체 생성하여 포트를 적용	
		try {
			// ServerSocket : 클라이언트의 연결 요청을 받을 용도의 소켓
			serversocket = new ServerSocket(port);		// 이 때 서버가 구동됨!
			
			// 3) 클라이언트로부터 접속 요청이 들어올 때까지 대기 => 서버 구동 후 대기 상태
			System.out.println("클라이언트의 요청 대기중...");
			
			// 4) 연결 요청이 들어오면 요청 수락 후 해당 클라이언트와 통신 준비
			//		통신 준비 => 서버측에서 Socket 객체 생성
			Socket socket = serversocket.accept();	// accept()메소드의 리턴 타입이 Socket임. 
			// 어디로부터 요청이 왔는지 확인
			System.out.println(socket.getInetAddress().getHostAddress() + "로부터 연결 요청...");
			
			// 5) 클라이언트와 입출력 기반스트림 생성		InputStreamReader가 기반스트림
			// 6) 보조스트림을 통해 생성 개선			BufferedReader가 보조스트림
			// 입력용 스트림 ( 클라이언트로부터 전달된 값을 한 줄씩 읽어오기 위해 사용될 입력용 스트림 )
			br = new BufferedReader (new InputStreamReader(socket.getInputStream()));
			
			// 출력용 스트림 ( 클라이언트에게 값을 한 줄씩 출력할 수 있는 스트림 )
			//	* PrintWriter : print() , println() 메소드를 통해 데이터 출력
			pw = new PrintWriter(socket.getOutputStream());
			
			// 7) 스트림 통해 읽고 쓰기
			while(true) {		// 계속 입력/출력하기 위해 무한루프 사용.
				// 클라이언트로부터 입력을 받기
				String message = br.readLine();
				System.out.println("클라이언트로부터 입력된 메시지 : " + message);
				
				// 클라이언트에게 데이터를 전달(출력)
				//pw.println("수신 완료!");		// 클라이언트에게 출력. PrintWriter로 객체를 만들었기에 write()메소드 대신에 println() 사용 가능.
				System.out.println(" 답변 : ");
				String sendMessage = sc.nextLine();
				
				pw.println(sendMessage);
				pw.flush();					// 현재 스트림에 있는 데이터를 강제로 내보내는 메소드
											// close() 메소드가 호출되면 자동으로 flush됨.
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8) 통신 종료
			
			try {
				// if(조건식) 
				// 한 줄만 수행할 때 중괄호 생략 가능
				// if(조건식) // 한 줄만 수행할 때 중괄호 생략하고 조건식 우측에 수행문 작성 가능
				if(pw != null) pw.close();	
				if(pw != null) br.close();
				
				if(serversocket != null) serversocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}	
		
		
		
	}
}
