package com.kh.io.practice.log;

public class LogTest {
	
	
	
	public static void main(String[] args) {
		FileDAO log = new FileDAO();
		// ���� ����
		log.access("log.txt", 1);
		
		
		// ���� ó��
		try {
			int[] arr = new int[3];
			
			for(int i=0; i<4; i++) {
				arr[i] = i;
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			log.write("[Exception]" + e.getMessage() + "\n");  // getMessage() : ���� ���� �޽���
			
			System.out.println("[Exception]" + e.getMessage());
		} finally {
			System.out.println("try ~ catch ����.");
			log.close(1); 	// (**) close �߿�! close�� ������ ������ ���� ���� ó���� �Ϸ���� ����.
		}
		

	}

}
