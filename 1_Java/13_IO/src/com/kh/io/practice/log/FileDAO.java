package com.kh.io.practice.log;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// DAO : Data Access Object
public class FileDAO {
	// 필드 (변수)
	// -reader : FileReader = null
	// -writer : FileWriter = null
	// -f:File
	// -READ_SIZE: int = 1024
	private FileReader reader = null;
	private FileWriter writer = null;
	private File f = null;
	private final int READ_SIZE = 1024;
	// 기능 (메소드)
	// 파일 접근 (access(filepath:string, type:int) : void throws IOException)
	//	filepath : 접근할 파일 경로
	//	type	 : 입출력 종류, 0 (입력) 1 (출력)
	//		type: 0 (입력) 1 (출력)
	public void access(String filepath, int type)  {
		try {
			// 스트림 클래스를 생성
			if(type == 0 && reader == null) {
				reader = new FileReader(filepath);
			}
			
			if(type == 1 && writer == null) {
				writer = new FileWriter(filepath);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	// 파일 닫기 (close(type: int) : void throws IOException)
	public void close(int type)  {
		try {
			// 입력 스트림 닫기
			if(type ==0 && reader != null) reader.close();
			
			// 출력 스트림 닫기
			if(type ==1 && writer != null) writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	// 파일 읽기 (read():StringBuilder)
	public String read() {
		// 반환 타입은 String, 내부적으로 StringBuilder를 사용
		StringBuilder sb = new StringBuilder("");
		if(reader != null) {
			
			char[] buffer = new char[READ_SIZE];
			int length;
			try {
				
				while((reader.read(buffer)) != -1) {
					sb.append(buffer);	// char[] 타입의 데이터로 문자열 변경(합치기)
				}
			} catch(IOException e) {
				e.printStackTrace(); 	// 예외 발생 시 오류 내용 출력
			}

		}
		
		return sb.toString();
	}
	// 파일 쓰기 (write(data:String) : boolean)
	public boolean write(String data) {
		System.out.println(data);
		if (writer != null) {
			
			try {
				writer.write(data);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;		// 예외없이 파일 출력 후 true 리턴
		} else {
			// 스트림이 닫혀있는 경우
			return false;
		}
		

	}
	// 파일 존재 유무 확인 (isExistFile(filepath:String):boolean)
	public boolean isExistFile(String filepath) {
		// 파일의 정보(파일명/마지막수정시간/위치).. 확인할 때 사용하는 클래스 : File
		f= new File(filepath);
		
		return f.exists();		// exists() : 파일이 존재하는 지 확인하는 메소드
		
	}
	
	// 경로의 파일 개수 조회 (getFilesCount(filepath: String) : int)
	public int getFilesCount(String filepath) {
		f = new File(filepath);
		return f.list().length;
	}
}
