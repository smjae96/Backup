package ncs.test4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class NoticeTest {
	
	public static void main(String[] args) {
		Object[] obArray = new Object[3];
		obArray[0] = new Notice();
		obArray[1] = new Notice();
		obArray[2] = new Notice();
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while(count<obArray.length) {
			System.out.println("����� ���������� �Է��Ͻÿ�.(3�� �ݺ� �Է� ó����)");
			System.out.print("���� : ");
			String title = sc.nextLine();
			System.out.print("�ۼ��� : ");
			String writer = sc.nextLine();
			System.out.print("���� : ");
			String content = sc.nextLine();
			Date date = new Date();
			System.out.print("�� : ");
			int year = sc.nextInt();
			sc.nextLine();
			System.out.print("�� : ");
			int month = sc.nextInt();
			sc.nextLine();
			System.out.print("�� : ");
			int day = sc.nextInt();
			sc.nextLine();
			date.setYear(year-1900);
			date.setMonth(month-1);
			date.setDate(day);
			for(int i=0; i<obArray.length; i++) {
				obArray[count] = new Notice(count, title, date , writer, content);
			}
			count++;
		}
		System.out.println("����Ʈ�� ����� ��ü ������ ������ �����ϴ�.");
		for(int i=0; i<obArray.length; i++) {
			System.out.println(obArray[i].toString());
		}

		
	}
	
	public void fileSave(Object[] array) {
		
	}
	
	public ArrayList<Notice> fileRead() {
		
	}

}
