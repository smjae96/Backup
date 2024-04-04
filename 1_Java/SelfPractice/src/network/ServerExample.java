package network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket;
	public static void main(String[] args) {
		System.out.println("---------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter키를 입력하세요.");
		System.out.println("---------------------------------");
		
		// TCP 서버 시작
		startServer();
		
		// 키보드 입력
		Scanner sc = new Scanner(System.in);
		while(true) {
			String key = sc.nextLine();
			if(key.toLowerCase().equals("q")) {
				break;
			}
		}
		sc.close();
		
		// TCP 서버 종료
		stopServer();
	}
	
	public static void startServer() {
		// 작업 스레드 정의
//		Thread thread = new Thread() {
//			@Override
//			public void run() {
//				//ServerSocket 생성 및 Port 바인딩
//			}
//		}

		Runnable task1 = () -> {
			// ServerSocket 생성 및 Port 바인딩
			try {
				serverSocket = new ServerSocket(3000);
				System.out.println("[서버] 시작됨");
				
				while(true) {
					System.out.println("\n[서버] 연결 요청을 기다림\n");
					// 연결 수락
					Socket socket = serverSocket.accept();
					// 연결된 클라이언트 정보 얻기
					InetSocketAddress isa2 = new InetSocketAddress("www.naver.com", 50001);
					String clientIP2 = isa2.toString();
					InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
					String clientIP = isa.getHostString();	// 클라이언트 ip주소 얻기
					System.out.println("[서버]" + clientIP2 + "의 연결 요청을 수락함");
					// 연결 끊기
					socket.close();
					System.out.println("[서버]" + clientIP2 + "의 연결을 끊음");
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		};
		Thread thread1 = new Thread(task1);
		thread1.start();

	}
	
	public static void stopServer() {
		
	}
}
