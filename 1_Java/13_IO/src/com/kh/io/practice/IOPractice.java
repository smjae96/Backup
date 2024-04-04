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
		// (4) ���� �Է� : FileReader(���� ����)
		FileReader fr = null;		// FileReader ���������� null�� �ʱ�ȭ
		
		
			
			try {
				
				fr = new FileReader("test2.txt");
				
				int result;
				char[] buffer = new char[1024];	// 2�� 10�� .. > 1024
				while((result = fr.read(buffer)) != -1) {	// .read(buffer) : �޼ҵ� ȣ�� ��� ��: �о� �� ������ ����
															//	* buffer : ���Ͽ��� ���� �����͸� �����.
					String fileData = new String(buffer, 0, result);
									// new String(char[], offset, count) : offset(������ġ), count(�����ͱ���)
					System.out.println(fileData); 			// �о� �� �����͸� �ܼ�â�� ���
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
						System.out.println("finally �κп��� Exception �߻�");
						e.printStackTrace();
					}
			}
			
		

	}
	
	public static void fileWriterTest() {	
		// (3) ���� ��� : FileWriter(���� ����)	
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter("test2.txt");
			fw.write("�ȳ��ϼ���. \n");		// FileWriter Ŭ������ ���� ������ ����� �����ؼ�
			fw.write("���� �������Դϴ�.");		// ���ڿ��� �� �� ����.
											// �̽������� ����(\n, \t) ����� 
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
		// (2) ���� �Է� : FileInputStream(����Ʈ ����)  - �� ���α׷��� �������� �Էµȴ�.
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");	// ����� :���ϸ� �ۼ��� ��� ������Ʈ ������ο� ����(�о�´�).
			
			int i;
			while((i = fis.read()) != -1) {	// i��� ������ ���Ͽ��� �о�� ���� �����ϰ�, �� ���� -1�� �ƴ��� ��
											// read()�� ��ȯŸ���� int�̴�. ���� ���Ϸκ��� ��(i)�� ���� ���� int�� �ް�
											// ���Ͽ��� �޾ƿ� ��(i)�� ���ڷ� ����ϰ� �ʹٸ� ��¹����� (char)�� ���� ����ȯ�� ���ش�.
				System.out.println((char)i); 		// ���Ͽ��� �о�� ��(i)�� ���
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
		System.out.println("���α׷� ����!");
	}

	
	
	
	public static void fileOutputStreamTest() {
		// (1) ���� ��� : FileOutputStream(����Ʈ ����)
		FileOutputStream fos = null;	// FileOutputStream �������� ���� �� null�� �ʱ�ȭ
		try {	// ���� ���� Ŭ���� ��� �� IOException ����ó���� "�ʼ�"�̹Ƿ� try~catch�� ���
			
			fos = new FileOutputStream("test.txt");			// FileOutputStream ��ü ����
			
			fos.write(65);		// write() : ���Ͽ� �����͸� �� �� ����ϴ� �޼ҵ�
			fos.write(122);		// 			����Ǵ� �����ʹ� �������� (ascii)�̴�.
			fos.close(); 		// close() : ��Ʈ�� ��� �� �ݾ��ִ� �޼ҵ�
			
		}	catch(FileNotFoundException e) {	// FileOutputStream ��ü ���� �� �߻������� ����
			e.printStackTrace();
		} 	catch(IOException e) {		// write(), close() ��... �޼ҵ� ��� �� �߻������� ����
			e.printStackTrace();
		} finally {
			// ���α׷� �߰��� ���� �߻� �� ��Ʈ���� ������ �ʴ� ��� �ݾ��ֱ� ���� �ۼ�.
			try {
				if(fos != null) fos.close(); // ���� �κ��� �ۼ� ���־�� ��. null�� ���(���� �߿� ������ ���� ��)�� ���� �� �����Ƿ�.
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
		
		System.out.println("���α׷� ����!");
		
		
	}
	

	
}
