package com.kh.practice.file.controller;

import com.kh.practice.file.model.dao.FileDAO;

public class FileController {
	private FileDAO fd = new FileDAO();
	
	public boolean checkName(String file) {
		// FileDAO 타입의 fd 참조변수를 사용해서 checkName() 메소드를 호출
		return fd.checkName(file);
	}
	public void fileSave(String file, StringBuilder sb) {
		fd.fileSave(file, sb.toString());		// StringBuilder 클래스의 toString() 오버라이딩됨.
		
												// 	* 값 자체를 문자열로 반환
	}
	public StringBuilder fileOpen(String file) {
		
//		StringBuilder sb = new StringBuilder(fd.fileOpen(file));
		return fd.fileOpen(file);
	}
	public void fileEdit(String file, StringBuilder sb) {
		fd.fileEdit(file, sb.toString());
	}
}
