package com.kh.io_13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class IOPractice {
	/*
	 * 입출력 (I/O)
	 * - 입력 : 현재 실행중인 프로그램 기준으로 외부로부터 데이터가 내 프로그램으로 들어오는 것.
	 * - 출력 : 현재 실행중인 프로그램에서 외부로 데이터가 나가는 것.
	 * 
	 * - 스트림 (통로의 역할) 
	 * 	: 입출력 시 데이터를 주고받는 통로
	 * 
	 * 	* 스트림의 구분
	 * 	  > 스트림의 사이즈에 따라 구분
	 * 		- 바이트 단위의 스트림 : 1byte 크기의 데이터만 입출력 할 수 있는 사이즈
	 * 			+ 입력 : InputStream
	 * 			+ 출력 : OutputStream
	 * 		- 문자 단위의 스트림 : 2byte 크기의 데이터만 입출력 할 수 있는 사이즈
	 * 			+ 입력 : Reader
	 * 			+ 출력 : Writer
	 * 
	 * 		> 외부 매체와 직접 연결하는 유/무에 따라 구분
	 * 		 - 기반(기본) 스트림 : 외부 매체와 직접적으로 연결되는 스트림(통로) => 필수로 사용
	 * 		 - 보조 스트림 	 : 보조 역할만 하는 스트림(통로) * 속도를 빠르게 해주거나, 그 외에 유용한 기능 제공
	 * 						   보조 스트림만 단독으로 사용 불가 => 반드시 기반스트림이 있어야 함.
	 * 
	 *  		+ BufferedReader, BufferedWriter : 버퍼라는 공간을 제공해주는 보조스트림 ( 속도 향상 )
	 *  			[사용법] 
	 *  					1) 기반 스트림 생성 : ex) FileWriter fw = new FileWriter(fileName);
	 *  					2) 보조 스트림 생성 시 기반 스트림의 객체 전달 : ex) BufferedWriter bw = new BufferedWriter(fw);
	 *  		
	 *  		+ ObjectInputStream, ObjectOutputStream : 객체 단위로 입출력 할 수 있도록 도와주는 보조스트림.
	 *  			* 객체 자체를 입출력할 때는 "직렬화" 과정 필수!
	 *  				- 객체라는 데이터를 스트림을 통해 입출력할 때 한줄로 줄세워서 들어오고 나가도록 처리하는 과정
	 *  				- 직렬화 적용방법 : Serializable 인터페이스 구현(상속) => 입출력 시 사용할 객체
	 *  						ex) public class Phone implements Serializable { }
	 *  
	 *  				[사용법]
	 *  						1) 기반 스트림 생성 : ex) FileOutputStram fos = new FileOutputStream(fileName)
	 *  						2) 보조 스트림 생성 시 기반 스트림의 객체 전달 : ex) ObjectOutputStream oos = new ObjectOutputStream(fos);
	 *  
	 *  
	 *  				
	 * 
	 */
	
	public static void main(String[] args) {
		
		// try ~ with ~ resource
		// 파일 출력용 스트림 생성, 객체 데이터 출력용 스트림 생성
		try(FileOutputStream fos = new FileOutputStream("phone_info.txt") ; 
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			// 저장할 객체 데이터 생성
			Phone p1 = new Phone("iphone", 1500000);
			
			oos.writeObject(p1);		// 객체 데이터를 출력
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();		// 예외 발생 시 콘솔창에 에러 내용(메시지, 발생 위치) 출력
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
