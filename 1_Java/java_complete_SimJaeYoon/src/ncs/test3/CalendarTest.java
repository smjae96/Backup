package ncs.test3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��¥�� �Է��Ͻÿ�.");
		System.out.print("�� : " );
		int year = sc.nextInt();
		System.out.print("�� : " );
		int month = sc.nextInt();
		System.out.print("�� : ");
		int date = sc.nextInt();
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(year, month-1, date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY�� M�� dd�� E����");
		System.out.println(sdf.format(gc.getTime()));
		
		if(((GregorianCalendar) gc).isLeapYear(year)) {
			System.out.println(year +"���� �����̴�.");
			
		}
		
	}

}
