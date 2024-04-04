package com.kh.io.practice.log;

public class LogTest {
	
	
	
	public static void main(String[] args) {
		FileDAO log = new FileDAO();
		// 파일 생성
		log.access("log.txt", 1);
		
		
		// 예외 처리
		try {
			int[] arr = new int[3];
			
			for(int i=0; i<4; i++) {
				arr[i] = i;
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			log.write("[Exception]" + e.getMessage() + "\n");  // getMessage() : 예외 관련 메시지
			
			System.out.println("[Exception]" + e.getMessage());
		} finally {
			System.out.println("try ~ catch 종료.");
			log.close(1); 	// (**) close 중요! close를 해주지 않으면 파일 관련 처리가 완료되지 않음.
		}
		

	}

}
