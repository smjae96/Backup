package com.kh.tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientProgram {

	public static void main(String[] args) {
		chatIn ci = new chatIn();
		ci.start();
		chatOut co = new chatOut();
		co.start();
		Scanner sc = new Scanner(System.in);
		// 1) ��û�� ������ "IP �ּ�", "��Ʈ ��ȣ" Ȯ��
		String serverIP = "192.168.10.15";
		int port = 3000;
		
		// ���Ǵ� ���(���ɽ� ��Ʈ��) �ʱ�ȭ
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		
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
				pw = new PrintWriter(socket.getOutputStream());
				
				// 5) ��Ʈ�� ����Ͽ� �����(������ ���)
				while(true) {	// ��� ����� �ְ�ޱ� ���� ���ѷ��� ���
					System.out.print("������ ������ �޽��� : ");
					String sendMsg = sc.nextLine();
					
					// ��� - ���������� ������ ����
					pw.println(sendMsg);
					pw.flush(); 			// �Է����� ������ �����Ͱ� ���޵��� ���� �� �־� ���!
					
					// �Է� - �����κ��� �����͸� ���� ����
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
				if(pw != null) pw.close();
				
				if(socket != null) socket.close();		// 6) ��� ����
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
