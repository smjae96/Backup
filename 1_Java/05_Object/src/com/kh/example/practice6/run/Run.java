package com.kh.example.practice6.run;

import com.kh.example.practice6.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		
		//Book b1;	// Book Ŭ���� � ������? � �޼ҵ�?
		//Book b1 = new Book(); // ��� ���α׷��� ������� �Ҵ��ϴ� ��.
		

		
		Book[] bArr = new Book[3];
		/* ��ü�迭�� ���� �� �Ҵ� �Ŀ��� �Ʒ��� ���� ����
		   Book b1;
		   Book b2;
		   Book b3;
		*/
		bArr[0] = new Book();
		bArr[1] = new Book(" ", " ", " ");
		bArr[2] = new Book();
		
		// ��ü �迭�� �ν��Ͻ� �������� �ʱ�ȭ �ʿ�!..
		for(Book b: bArr) {
			b = new Book();
		}
		
		// �⺻�����ڷ� Book ��ü ����
		Book book1 = new Book();
		// �Ű������� 3���� �����ڷ� Book ��ü ����
		Book book2 = new Book("�����" , "���ǻ�1", "�� �����丮");
		// �Ű������� 5���� �����ڷ� Book ��ü ����
		Book book3 = new Book("��� ���� ��" , "���ǻ�2" , "������", 5000, 0.2);
		
		book1.inform();
		System.out.println();
		book2.inform();
		System.out.println();
		book3.inform();
	}

}
