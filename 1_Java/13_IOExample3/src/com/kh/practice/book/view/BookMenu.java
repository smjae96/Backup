package com.kh.practice.book.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;


public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr;
	
	public BookMenu() {
		bc.makeFile();
		bArr = bc.fileRead();
	}
	
	public void mainMenu() {
		while(true) {
			System.out.println("1. ���� �߰� ����");
			System.out.println("2. ���� ���� ���");
			System.out.println("9. ���α׷� ������");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			sc.nextLine();
			if(num==1) {
				fileSave();
			} else if(num==2) {
				fileRead();
			} else if(num==9) {
				System.out.println("���α׷� ����");
				return;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}	
	}
	
	public void fileSave() {
		System.out.print("���� �� : ");
		String bookname = sc.nextLine();
		System.out.print("���� �� : ");
		String author = sc.nextLine();
		System.out.print("���� ���� : ");
		int price = sc.nextInt();
		sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		System.out.print("���� ��¥(yyyy-mm-dd) : ");
		String str = sc.nextLine();
		String[] strS = str.split("-");
		int year = Integer.parseInt(strS[0]);
		int month = Integer.parseInt(strS[1]);
		int day = Integer.parseInt(strS[2]);
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		System.out.println("������ : ");
		double discount = sc.nextDouble();
		sc.nextLine();
		Book b= new Book(bookname, author, price, cal, discount); 
		for(int i=0; i<bArr.length; i++) {
			if(bArr == null) {
				bArr[i] = b;
				break;
			}
		}
		bc.fileSave(bArr);

		mainMenu();
	}
	
	public void fileRead() {
		System.out.println(bc.fileRead());
		mainMenu();
	}
}
