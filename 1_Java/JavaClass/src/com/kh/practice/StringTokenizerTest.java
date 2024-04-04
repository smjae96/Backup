package com.kh.practice;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		// key : name, phone, address, email
		//	- key에 해당하는 값과 value에 해당하는 값을 (:)로 구분
		//	- 각 정보는 (,)로 구분
		String data = "name: Hong, phone:010-1234-5678, address: gangnam, email: hong12@gmail.com";
//		
//		// StringTokenizer 를 사용하여 아래 내용을 출력
//		// 이름은 Hong이고, 연락처는 010-1234-5678이고, 주소는 gangnam이고, 이메일은 hong12@gmail.com입니다.
//		//		%s					%s					%s					%s
//		String[] dataArr = new String[8];
//		int index =0;
//		
//		// (1) (,)로 구분하여 토큰화
//		StringTokenizer st = new StringTokenizer(data, ",");
//		
//		while (st.hasMoreTokens()) {
//			String keyValue = st.nextToken();		// , 기준으로 토큰화하여 문자열을 저장
//			System.out.println(keyValue);
//			
//			
//			// (2) (:)으로 구분하여 토큰화
//			StringTokenizer st2 = new StringTokenizer(keyValue, ":");
//			
//			while(st2.hasMoreTokens()) {
//				dataArr[index++] = st2.nextToken();
//			}
//		}
//		// 이름은 Hong이고, 연락처는 010-1234-5678, 주소는 gangnam이고, 이메일은 hong12@gmail.com입니다.
//		System.out.printf("이름은 %s이고, 연락처는 %s이고, 주소는 %s이고, 이메일은 %s입니다.",
//								dataArr[1], dataArr[3], dataArr[5], dataArr[7]);
		
		
		
		
		
		
		
		
		
	// 내 풀이(완성 안됨!)	
		
		String[] arr = new String[4];
		int i = 0;
		
		StringTokenizer st = new StringTokenizer(data, ",");
		
		while(st.hasMoreTokens()) {
			arr[i] = st.nextToken();
		//	System.out.println(arr[i]);
			i++;
		}
		int index = 0;
		String[] arrJ = new String[8];
		for(int j=0; j<arr.length; j++) {
			String dataJ = arr[j];
			StringTokenizer st2 = new StringTokenizer(dataJ, ":");
			while(st2.hasMoreTokens()) {
				
				arrJ[index++] = st2.nextToken();
			}
		}
		System.out.printf("이름은 %s이고, 연락처는 %s이고, 주소는 %s이고, 이메일은 %s입니다.",
				arrJ[1], arrJ[3], arrJ[5], arrJ[7]);
		
		
//		String data0 = arr[0];
//		st = new StringTokenizer(data0, ":");
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
		
		
	}
	
	
	public void test() {
		// StringTokenizer : 문자열 내에 특정 구분자로 나눠주는 클래스(토큰화)
		
		String msg = "안녕하세요|나는누구입니다|반갑습니다"; // 특정 구분자 : |
		
		String[] arr = new String[3];
		int i = 0;
		
		StringTokenizer st = new StringTokenizer(msg, "|");	// 경로가 java.util이므로 import 필요
		
		// 변수명.hasMoreTokens() : 구분자를 통해 토큰화 할 수 있는 지 확인하는 메소드
		//						  true/false : true(토큰화 가능) false(토큰화 불가)
		
		while(st.hasMoreTokens()) { // 토큰화가 가능하다면 계속 반복문을 실행한다.
			
			// 변수명.nextToken(): 구분자 기준으로 값을 분리해서 반환하는 메소드
			// 					 값을 반환하고 다음 구분자 위치로 이동
			//System.out.println(st.nextToken());
			arr[i] = st.nextToken();
			System.out.println(arr[i]);
			i++;
			
		}
		
	}

}
