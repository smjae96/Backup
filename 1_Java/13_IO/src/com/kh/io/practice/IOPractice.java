package com.kh.io.practice;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOPractice {
	public static void main(String[] args) {
		// (4) 파일 입력 : FileReader(문자 단위)
		FileReader fr = null;		// FileReader 참조변수를 null로 초기화
		
		
			
			try {
				
				fr = new FileReader("test2.txt");
				
				int result;
				char[] buffer = new char[1024];	// 2의 10승 .. > 1024
				while((result = fr.read(buffer)) != -1) {	// .read(buffer) : 메소드 호출 결과 값: 읽어 온 데이터 길이
															//	* buffer : 파일에서 읽은 데이터를 저장됨.
					String fileData = new String(buffer, 0, result);
									// new String(char[], offset, count) : offset(시작위치), count(데이터길이)
					System.out.println(fileData); 			// 읽어 온 데이터를 콘솔창에 출력
				}
				fr.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				if(fr != null)
					try {
						fr.close();
					} catch (IOException e) {
						System.out.println("finally 부분에서 Exception 발생");
						e.printStackTrace();
					}
			}
			
		

	}
	
	public static void fileWriterTest() {	
		// (3) 파일 출력 : FileWriter(문자 단위)	
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter("test2.txt");
			fw.write("안녕하세요. \n");		// FileWriter 클래스는 문자 단위로 출력이 가능해서
			fw.write("나는 심재윤입니다.");		// 문자열을 쓸 수 있음.
											// 이스케이프 문자(\n, \t) 적용됨 
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		System.out.println("END");
	}	
	
	public static void fileInputStreamTest() {
		// (2) 파일 입력 : FileInputStream(바이트 단위)  - 내 프로그램을 기준으로 입력된다.
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");	// 상대경로 :파일명만 작성한 경우 프로젝트 상위경로에 생성(읽어온다).
			
			int i;
			while((i = fis.read()) != -1) {	// i라는 변수에 파일에서 읽어온 값을 저장하고, 그 값이 -1이 아닌지 비교
											// read()의 반환타입은 int이다. 따라서 파일로부터 값(i)을 받을 때는 int로 받고
											// 파일에서 받아온 값(i)을 문자로 출력하고 싶다면 출력문에서 (char)을 통해 형변환을 해준다.
				System.out.println((char)i); 		// 파일에서 읽어온 값(i)을 출력
			}
		
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료!");
	}

	
	
	
	public static void fileOutputStreamTest() {
		// (1) 파일 출력 : FileOutputStream(바이트 단위)
		FileOutputStream fos = null;	// FileOutputStream 참조변수 선언 후 null로 초기화
		try {	// 파일 관련 클래스 사용 시 IOException 예외처리가 "필수"이므로 try~catch문 사용
			
			fos = new FileOutputStream("test.txt");			// FileOutputStream 객체 생성
			
			fos.write(65);		// write() : 파일에 데이터를 쓸 때 사용하는 메소드
			fos.write(122);		// 			저장되는 데이터는 문자형식 (ascii)이다.
			fos.close(); 		// close() : 스트림 사용 후 닫아주는 메소드
			
		}	catch(FileNotFoundException e) {	// FileOutputStream 객체 생성 시 발생가능한 예외
			e.printStackTrace();
		} 	catch(IOException e) {		// write(), close() 등... 메소드 사용 시 발생가능한 예외
			e.printStackTrace();
		} finally {
			// 프로그램 중간에 예외 발생 시 스트림이 닫히지 않는 경우 닫아주기 위해 작성.
			try {
				if(fos != null) fos.close(); // 조건 부분은 작성 해주어야 함. null일 경우(생성 중에 문제가 생길 수)도 있을 수 있으므로.
			} catch(IOException e) {
				
			}
		}
//		FileOutputStream fos2 = null;
//		try {
//			fos2 = new FileOutputStream("test3.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("프로그램 종료!");
		
		
	}
	

	
}
