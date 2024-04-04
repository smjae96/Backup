package com.kh.practice.file.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// DAO : Data Access Object
public class FileDAO {
	// 메소드
	public boolean checkName(String file) {
		// File 클래스 객체, file 매개변수로 생성자 호출
		File f = new File(file);
		return f.exists();		// 해당 파일이 있는지(true) 없는지(false) 확인
		
	}
	
	public void fileSave(String file, String s) {
		// 파일 출력 기능 => 문자 단위로 출력. FileWriter 사용
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	public StringBuilder fileOpen(String file) {
		// 파일 입력 기능 => 파일에서 읽어오는 기능. 문자 단위 입력, FileReader 사용
		StringBuilder sb = new StringBuilder();
		
		try {
			FileReader reader = new FileReader(file);
			char[] buffer = new char[1024];
			while(reader.read(buffer) != -1) {	// read() 의 결과가 -1이면 파일의 끝까지 읽은 것.
				sb.append(buffer);
			}
			reader.close();			// 파일 입력 완료 후 close
		} catch(IOException e) {
			e.printStackTrace();
		} 
		
		return sb;
		
		
//		FileReader fr = null;
//		try {
//			fr = new FileReader(file);
//			int result;
//			char[] buffer = new char[file.length()];
//			while((result = fr.read(buffer)) != -1) {
//				StringBuilder sb = new StringBuilder(file);
//				StringBuilder fileData = new StringBuilder(buffer, 0, result);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
	}
	
	public void fileEdit(String file, String s) {
		// 파일 출력. FileWriter.
		// 이어서 저장될 수 있도록 => FileWriter(파일경로, true)
		//	* FileWriter(파일경로) : 같은 파일이 있을 경우 덮어씌움.
		FileWriter fw = null;
		try {
			fw = new FileWriter(file, true);
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw!= null) fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
