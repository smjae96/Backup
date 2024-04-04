package com.kh.inet.run;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetRun {

	public static void main(String[] args) {
		/*
		 * 네트워크 (NetWork) : 여러 대의 컴퓨터들이 연결되어 있는 통신망
		 * 					=> 이 네트워크를 통해 서로 데이터를 교환할 수 있음.
		 * - IP 주소 : 네트워크 상에 각 컴퓨터들을 식별해주는 번호
		 * - 포트 번호 : 한 컴퓨터 내에 프로그램을 식별해주는 번호
		 * 
		 * 
		 * - 서버			: 클라이언트(고객)에게 서비스를 제공해주는 프로그램
		 * 				  클라이언트의 요청을 처리해서 응답
		 * - 클라이언트 	: 서버에 요청을 하는 프로그램(컴퓨터)
		 * 				  서비스를 제공받는 고객
		 * 
		 * * 서버에 요청하기 위해서 요청하고자 하는 서버의 "IP 주소", "포트 번호"가 필요함
		 * 
		 */
		
		// InetAddress :네트워크 정보(ip주소 관련)를 확인할 수 있는 클래스
		try {
			InetAddress localhost = InetAddress.getLocalHost();	// getLocalHost() : 내 pc에 대한 정보를 반환
			System.out.println(localhost); 		// "PC 정보 / IP 주소"
			System.out.println("내 pc 정보 : " + localhost.getHostAddress());	// 호스트의 IP주소 반환
			System.out.println("내 pc IP주소 : " + localhost.getHostName());	// 호스트의 PC 정보 반환
		} catch (UnknownHostException e1) {		// 호스트가 없을 때 발생하는 예외
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("*".repeat(20));
		// 도메인을 통해서 서버 정보를 확인
		try {
			InetAddress googleHost = InetAddress.getByName("www.google.com");	// getByName(도메인명) : 도메인을 통해 해당 호스트에 대한 정보 반환
			
			System.out.println("구글 IP주소 :" +googleHost.getHostAddress());	// IP주소 숫자 범위 (0~255).(0~255).(0~255).(0~255)
			System.out.println("구글 서버명 : " +googleHost.getHostName());
			
			System.out.println("*".repeat(20));
			
			// 도메인을 통해서 서버 관련된 정보를 배열로 받아서 확인
			//	* 메소드 호출 후 결과를 받을 변수의 데이터 타입은.
			//		메소드의 반환타입으로 사용
			InetAddress[] naverHost = InetAddress.getAllByName("www.naver.com"); 
			System.out.println("네이버의 호스트 개수 : " + naverHost.length);
			for(InetAddress item : naverHost) {		// for(배열에_담긴_데이터_타입_변수명 : 배열_변수명) {}
				System.out.println("네이버 호스트명 : " + item.getHostName());
				System.out.println("네이버 IP주소 : " + item.getHostAddress());
			}
			for(int i=0; i<naverHost.length; i++) {
				System.out.println(i+1 +"번째 네이버 서버명 : " +naverHost[i].getHostName());
				System.out.println(i+1 +"번째 네이버 IP주소 : " +naverHost[i].getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
