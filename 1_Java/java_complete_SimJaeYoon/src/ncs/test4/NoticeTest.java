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
			System.out.println("등록할 공지사항을 입력하시오.(3번 반복 입력 처리함)");
			System.out.print("제목 : ");
			String title = sc.nextLine();
			System.out.print("작성자 : ");
			String writer = sc.nextLine();
			System.out.print("내용 : ");
			String content = sc.nextLine();
			Date date = new Date();
			System.out.print("년 : ");
			int year = sc.nextInt();
			sc.nextLine();
			System.out.print("월 : ");
			int month = sc.nextInt();
			sc.nextLine();
			System.out.print("일 : ");
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
		System.out.println("리스트에 저장된 객체 정보는 다음과 같습니다.");
		for(int i=0; i<obArray.length; i++) {
			System.out.println(obArray[i].toString());
		}

		
	}
	
	public void fileSave(Object[] array) {
		
	}
	
	public ArrayList<Notice> fileRead() {
		
	}

}
