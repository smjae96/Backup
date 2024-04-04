package com.kh.inet.run;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetRun {

	public static void main(String[] args) {
		/*
		 * ��Ʈ��ũ (NetWork) : ���� ���� ��ǻ�͵��� ����Ǿ� �ִ� ��Ÿ�
		 * 					=> �� ��Ʈ��ũ�� ���� ���� �����͸� ��ȯ�� �� ����.
		 * - IP �ּ� : ��Ʈ��ũ �� �� ��ǻ�͵��� �ĺ����ִ� ��ȣ
		 * - ��Ʈ ��ȣ : �� ��ǻ�� ���� ���α׷��� �ĺ����ִ� ��ȣ
		 * 
		 * 
		 * - ����			: Ŭ���̾�Ʈ(��)���� ���񽺸� �������ִ� ���α׷�
		 * 				  Ŭ���̾�Ʈ�� ��û�� ó���ؼ� ����
		 * - Ŭ���̾�Ʈ 	: ������ ��û�� �ϴ� ���α׷�(��ǻ��)
		 * 				  ���񽺸� �����޴� ��
		 * 
		 * * ������ ��û�ϱ� ���ؼ� ��û�ϰ��� �ϴ� ������ "IP �ּ�", "��Ʈ ��ȣ"�� �ʿ���
		 * 
		 */
		
		// InetAddress :��Ʈ��ũ ����(ip�ּ� ����)�� Ȯ���� �� �ִ� Ŭ����
		try {
			InetAddress localhost = InetAddress.getLocalHost();	// getLocalHost() : �� pc�� ���� ������ ��ȯ
			System.out.println(localhost); 		// "PC ���� / IP �ּ�"
			System.out.println("�� pc ���� : " + localhost.getHostAddress());	// ȣ��Ʈ�� IP�ּ� ��ȯ
			System.out.println("�� pc IP�ּ� : " + localhost.getHostName());	// ȣ��Ʈ�� PC ���� ��ȯ
		} catch (UnknownHostException e1) {		// ȣ��Ʈ�� ���� �� �߻��ϴ� ����
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("*".repeat(20));
		// �������� ���ؼ� ���� ������ Ȯ��
		try {
			InetAddress googleHost = InetAddress.getByName("www.google.com");	// getByName(�����θ�) : �������� ���� �ش� ȣ��Ʈ�� ���� ���� ��ȯ
			
			System.out.println("���� IP�ּ� :" +googleHost.getHostAddress());	// IP�ּ� ���� ���� (0~255).(0~255).(0~255).(0~255)
			System.out.println("���� ������ : " +googleHost.getHostName());
			
			System.out.println("*".repeat(20));
			
			// �������� ���ؼ� ���� ���õ� ������ �迭�� �޾Ƽ� Ȯ��
			//	* �޼ҵ� ȣ�� �� ����� ���� ������ ������ Ÿ����.
			//		�޼ҵ��� ��ȯŸ������ ���
			InetAddress[] naverHost = InetAddress.getAllByName("www.naver.com"); 
			System.out.println("���̹��� ȣ��Ʈ ���� : " + naverHost.length);
			for(InetAddress item : naverHost) {		// for(�迭��_���_������_Ÿ��_������ : �迭_������) {}
				System.out.println("���̹� ȣ��Ʈ�� : " + item.getHostName());
				System.out.println("���̹� IP�ּ� : " + item.getHostAddress());
			}
			for(int i=0; i<naverHost.length; i++) {
				System.out.println(i+1 +"��° ���̹� ������ : " +naverHost[i].getHostName());
				System.out.println(i+1 +"��° ���̹� IP�ּ� : " +naverHost[i].getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
