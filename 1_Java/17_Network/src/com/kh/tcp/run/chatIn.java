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
		// 1) ��û�� ������ "IP �ּ�", "��Ʈ ��ȣ" Ȯ��
		String serverIP = "192.168.10.27";
		int port = 3000;
		
		// ���Ǵ� ���(���ɽ� ��Ʈ��) �ʱ�ȭ
		Socket socket = null;
		BufferedReader br = null;
		
		
		try {
			// 2) ������ ���� ��û�� ������ ( ��û�ϰ��� �ϴ� ������ IP�ּҿ� ��Ʈ��ȣ�� ����Ͽ� ���� ��ü ���� ) 
			socket = new Socket(serverIP, port);	// ������ ���� ��û
			
			if(socket != null) {	// �������� ���� �������� ���
				System.out.println("����(" + serverIP + ":" + port + ")�� ���� ����!");
				
				// 3) ������ ����� ��ݽ�Ʈ�� ����
				// 4) ������Ʈ���� ���ؼ� ���� ����
				// �Է¿� ��Ʈ��
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				// ��¿� ��Ʈ��
				
				// 5) ��Ʈ�� ����Ͽ� �����(������ ���)
				while(true) {	// ��� ����� �ְ�ޱ� ���� ���ѷ��� ���
					String message = br.readLine();
					System.out.print("�����κ��� ���޵� �޽��� : " + message);
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
				if(socket != null) socket.close();		// 6) ��� ����
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
}
