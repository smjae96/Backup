package com.kh.practice.file.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// DAO : Data Access Object
public class FileDAO {
	// �޼ҵ�
	public boolean checkName(String file) {
		// File Ŭ���� ��ü, file �Ű������� ������ ȣ��
		File f = new File(file);
		return f.exists();		// �ش� ������ �ִ���(true) ������(false) Ȯ��
		
	}
	
	public void fileSave(String file, String s) {
		// ���� ��� ��� => ���� ������ ���. FileWriter ���
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
		// ���� �Է� ��� => ���Ͽ��� �о���� ���. ���� ���� �Է�, FileReader ���
		StringBuilder sb = new StringBuilder();
		
		try {
			FileReader reader = new FileReader(file);
			char[] buffer = new char[1024];
			while(reader.read(buffer) != -1) {	// read() �� ����� -1�̸� ������ ������ ���� ��.
				sb.append(buffer);
			}
			reader.close();			// ���� �Է� �Ϸ� �� close
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
		// ���� ���. FileWriter.
		// �̾ ����� �� �ֵ��� => FileWriter(���ϰ��, true)
		//	* FileWriter(���ϰ��) : ���� ������ ���� ��� �����.
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
