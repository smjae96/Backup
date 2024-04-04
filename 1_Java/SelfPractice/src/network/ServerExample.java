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
		System.out.println("������ �����Ϸ��� q �Ǵ� Q�� �Է��ϰ� EnterŰ�� �Է��ϼ���.");
		System.out.println("---------------------------------");
		
		// TCP ���� ����
		startServer();
		
		// Ű���� �Է�
		Scanner sc = new Scanner(System.in);
		while(true) {
			String key = sc.nextLine();
			if(key.toLowerCase().equals("q")) {
				break;
			}
		}
		sc.close();
		
		// TCP ���� ����
		stopServer();
	}
	
	public static void startServer() {
		// �۾� ������ ����
//		Thread thread = new Thread() {
//			@Override
//			public void run() {
//				//ServerSocket ���� �� Port ���ε�
//			}
//		}

		Runnable task1 = () -> {
			// ServerSocket ���� �� Port ���ε�
			try {
				serverSocket = new ServerSocket(3000);
				System.out.println("[����] ���۵�");
				
				while(true) {
					System.out.println("\n[����] ���� ��û�� ��ٸ�\n");
					// ���� ����
					Socket socket = serverSocket.accept();
					// ����� Ŭ���̾�Ʈ ���� ���
					InetSocketAddress isa2 = new InetSocketAddress("www.naver.com", 50001);
					String clientIP2 = isa2.toString();
					InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
					String clientIP = isa.getHostString();	// Ŭ���̾�Ʈ ip�ּ� ���
					System.out.println("[����]" + clientIP2 + "�� ���� ��û�� ������");
					// ���� ����
					socket.close();
					System.out.println("[����]" + clientIP2 + "�� ������ ����");
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
