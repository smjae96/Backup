package com.kh.tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class chatOut extends Thread {

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		// 1) ��û�� ������ "IP �ּ�", "��Ʈ ��ȣ" Ȯ��
		String serverIP = "192.168.10.27";
		int port = 3000;
		
		// ���Ǵ� ���(���ɽ� ��Ʈ��) �ʱ�ȭ
		Socket socket = null;
		PrintWriter pw = null;
		
		
		try {
			// 2) ������ ���� ��û�� ������ ( ��û�ϰ��� �ϴ� ������ IP�ּҿ� ��Ʈ��ȣ�� ����Ͽ� ���� ��ü ���� ) 
			socket = new Socket(serverIP, port);	// ������ ���� ��û
			
			if(socket != null) {	// �������� ���� �������� ���
				System.out.println("����(" + serverIP + ":" + port + ")�� ���� ����!");
				
				// 3) ������ ����� ��ݽ�Ʈ�� ����
				// 4) ������Ʈ���� ���ؼ� ���� ����
				// �Է¿� ��Ʈ��
				
				// ��¿� ��Ʈ��
				pw = new PrintWriter(socket.getOutputStream());
				
				// 5) ��Ʈ�� ����Ͽ� �����(������ ���)
				while(true) {	// ��� ����� �ְ�ޱ� ���� ���ѷ��� ���
					System.out.print("������ ������ �޽��� : ");
					String sendMsg = sc.nextLine();
					
					// ��� - ���������� ������ ����
					pw.println(sendMsg);
					pw.flush(); 			// �Է����� ������ �����Ͱ� ���޵��� ���� �� �־� ���!
					
					// �Է� - �����κ��� �����͸� ���� ����
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pw != null) pw.close();
				if(socket != null) socket.close();		// 6) ��� ����
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	
}
