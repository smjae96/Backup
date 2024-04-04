package ncs.test3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜를 입력하시오.");
		System.out.print("년 : " );
		int year = sc.nextInt();
		System.out.print("월 : " );
		int month = sc.nextInt();
		System.out.print("일 : ");
		int date = sc.nextInt();
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(year, month-1, date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 M월 dd일 E요일");
		System.out.println(sdf.format(gc.getTime()));
		
		if(((GregorianCalendar) gc).isLeapYear(year)) {
			System.out.println(year +"년은 윤년이다.");
			
		}
		
	}

}
