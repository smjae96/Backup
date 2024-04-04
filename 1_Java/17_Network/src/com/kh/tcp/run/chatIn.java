package com.kh.tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class chatIn extends Thread{

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		// 1) 요청할 서버의 "IP 주소", "포트 번호" 확인
		String serverIP = "192.168.10.27";
		int port = 3000;
		
		// 사용되는 통로(소케스 스트림) 초기화
		Socket socket = null;
		BufferedReader br = null;
		
		
		try {
			// 2) 서버에 연결 요청을 보내기 ( 요청하고자 하는 서버의 IP주소와 포트번호를 사용하여 소켓 객체 생성 ) 
			socket = new Socket(serverIP, port);	// 서버로 연결 요청
			
			if(socket != null) {	// 서버와의 연결 성공했을 경우
				System.out.println("서버(" + serverIP + ":" + port + ")로 연결 성공!");
				
				// 3) 서버와 입출력 기반스트림 생성
				// 4) 보조스트림을 통해서 성능 개선
				// 입력용 스트림
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				// 출력용 스트림
				
				// 5) 스트림 사용하여 입출력(데이터 통신)
				while(true) {	// 계속 통신을 주고받기 위해 무한루프 사용
					String message = br.readLine();
					System.out.print("서버로부터 전달된 메시지 : " + message);
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(socket != null) socket.close();		// 6) 통신 종료
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
}
