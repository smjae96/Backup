package com.kh.io_13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class IOPractice {
	/*
	 * ����� (I/O)
	 * - �Է� : ���� �������� ���α׷� �������� �ܺηκ��� �����Ͱ� �� ���α׷����� ������ ��.
	 * - ��� : ���� �������� ���α׷����� �ܺη� �����Ͱ� ������ ��.
	 * 
	 * - ��Ʈ�� (����� ����) 
	 * 	: ����� �� �����͸� �ְ�޴� ���
	 * 
	 * 	* ��Ʈ���� ����
	 * 	  > ��Ʈ���� ����� ���� ����
	 * 		- ����Ʈ ������ ��Ʈ�� : 1byte ũ���� �����͸� ����� �� �� �ִ� ������
	 * 			+ �Է� : InputStream
	 * 			+ ��� : OutputStream
	 * 		- ���� ������ ��Ʈ�� : 2byte ũ���� �����͸� ����� �� �� �ִ� ������
	 * 			+ �Է� : Reader
	 * 			+ ��� : Writer
	 * 
	 * 		> �ܺ� ��ü�� ���� �����ϴ� ��/���� ���� ����
	 * 		 - ���(�⺻) ��Ʈ�� : �ܺ� ��ü�� ���������� ����Ǵ� ��Ʈ��(���) => �ʼ��� ���
	 * 		 - ���� ��Ʈ�� 	 : ���� ���Ҹ� �ϴ� ��Ʈ��(���) * �ӵ��� ������ ���ְų�, �� �ܿ� ������ ��� ����
	 * 						   ���� ��Ʈ���� �ܵ����� ��� �Ұ� => �ݵ�� ��ݽ�Ʈ���� �־�� ��.
	 * 
	 *  		+ BufferedReader, BufferedWriter : ���۶�� ������ �������ִ� ������Ʈ�� ( �ӵ� ��� )
	 *  			[����] 
	 *  					1) ��� ��Ʈ�� ���� : ex) FileWriter fw = new FileWriter(fileName);
	 *  					2) ���� ��Ʈ�� ���� �� ��� ��Ʈ���� ��ü ���� : ex) BufferedWriter bw = new BufferedWriter(fw);
	 *  		
	 *  		+ ObjectInputStream, ObjectOutputStream : ��ü ������ ����� �� �� �ֵ��� �����ִ� ������Ʈ��.
	 *  			* ��ü ��ü�� ������� ���� "����ȭ" ���� �ʼ�!
	 *  				- ��ü��� �����͸� ��Ʈ���� ���� ������� �� ���ٷ� �ټ����� ������ �������� ó���ϴ� ����
	 *  				- ����ȭ ������ : Serializable �������̽� ����(���) => ����� �� ����� ��ü
	 *  						ex) public class Phone implements Serializable { }
	 *  
	 *  				[����]
	 *  						1) ��� ��Ʈ�� ���� : ex) FileOutputStram fos = new FileOutputStream(fileName)
	 *  						2) ���� ��Ʈ�� ���� �� ��� ��Ʈ���� ��ü ���� : ex) ObjectOutputStream oos = new ObjectOutputStream(fos);
	 *  
	 *  
	 *  				
	 * 
	 */
	
	public static void main(String[] args) {
		
		// try ~ with ~ resource
		// ���� ��¿� ��Ʈ�� ����, ��ü ������ ��¿� ��Ʈ�� ����
		try(FileOutputStream fos = new FileOutputStream("phone_info.txt") ; 
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			// ������ ��ü ������ ����
			Phone p1 = new Phone("iphone", 1500000);
			
			oos.writeObject(p1);		// ��ü �����͸� ���
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();		// ���� �߻� �� �ܼ�â�� ���� ����(�޽���, �߻� ��ġ) ���
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
