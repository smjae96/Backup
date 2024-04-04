package com.kh.io.practice.log;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// DAO : Data Access Object
public class FileDAO {
	// �ʵ� (����)
	// -reader : FileReader = null
	// -writer : FileWriter = null
	// -f:File
	// -READ_SIZE: int = 1024
	private FileReader reader = null;
	private FileWriter writer = null;
	private File f = null;
	private final int READ_SIZE = 1024;
	// ��� (�޼ҵ�)
	// ���� ���� (access(filepath:string, type:int) : void throws IOException)
	//	filepath : ������ ���� ���
	//	type	 : ����� ����, 0 (�Է�) 1 (���)
	//		type: 0 (�Է�) 1 (���)
	public void access(String filepath, int type)  {
		try {
			// ��Ʈ�� Ŭ������ ����
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
	// ���� �ݱ� (close(type: int) : void throws IOException)
	public void close(int type)  {
		try {
			// �Է� ��Ʈ�� �ݱ�
			if(type ==0 && reader != null) reader.close();
			
			// ��� ��Ʈ�� �ݱ�
			if(type ==1 && writer != null) writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	// ���� �б� (read():StringBuilder)
	public String read() {
		// ��ȯ Ÿ���� String, ���������� StringBuilder�� ���
		StringBuilder sb = new StringBuilder("");
		if(reader != null) {
			
			char[] buffer = new char[READ_SIZE];
			int length;
			try {
				
				while((reader.read(buffer)) != -1) {
					sb.append(buffer);	// char[] Ÿ���� �����ͷ� ���ڿ� ����(��ġ��)
				}
			} catch(IOException e) {
				e.printStackTrace(); 	// ���� �߻� �� ���� ���� ���
			}

		}
		
		return sb.toString();
	}
	// ���� ���� (write(data:String) : boolean)
	public boolean write(String data) {
		System.out.println(data);
		if (writer != null) {
			
			try {
				writer.write(data);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;		// ���ܾ��� ���� ��� �� true ����
		} else {
			// ��Ʈ���� �����ִ� ���
			return false;
		}
		

	}
	// ���� ���� ���� Ȯ�� (isExistFile(filepath:String):boolean)
	public boolean isExistFile(String filepath) {
		// ������ ����(���ϸ�/�����������ð�/��ġ).. Ȯ���� �� ����ϴ� Ŭ���� : File
		f= new File(filepath);
		
		return f.exists();		// exists() : ������ �����ϴ� �� Ȯ���ϴ� �޼ҵ�
		
	}
	
	// ����� ���� ���� ��ȸ (getFilesCount(filepath: String) : int)
	public int getFilesCount(String filepath) {
		f = new File(filepath);
		return f.list().length;
	}
}
