package com.kh.practice;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		// Date Ŭ������ ����ؼ� ���� ������ ���
		// - Date ��ü ����
		Date day = new Date(1996-1900, 5-1, 28);
		System.out.println(day);
		
		// LocalDateTime Ŭ����
		// [ ��ü ���� ]
		//	- ��, ��, �� �Է��Ͽ� ���� 	: LocalDateTime.of(LocalDate.of(int year, int month, int dayOfMonth),
		//												LocatTime.of(int hour, int minute))						
		//															
		//	- ���� ��¥�ð� �������� ����	: LocalDateTime.now()
		
		// [ ��¥ ���� ��ȸ ]
		//	- ��(month) : ������.getMonthValue()	// ���ڷ� �� ������ ��ȯ
		//				 ������.getMonth()		// ����� �� ������ ��ȯ
		//	- ��(day)	: ������.getDayofMonth()	// �� ���� �� ���� ��ȯ
		//					������.getDayofYear()	// �� ���� �� ���� ��ȯ
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		System.out.println(dateTime.getMonthValue() + "/" + dateTime.getDayOfMonth());
		// ���� ���..
		LocalDateTime birth = LocalDateTime.of(LocalDate.of(2000, 1, 5), LocalTime.of(0, 0));
		System.out.println(birth);
		
		//DateTimeFormatter
		//	DateTimeFormatter.ofPattern(����) : ��¥ ������ ����(����) ����
		// - YYYY-MM-DD hh:mm:ss
		// - import java.time.format.DateTimeFormatter;
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss")));
		
		//SimpleDateFormat
		SimpleDateFormat dateFormat = new SimpleDateFormat();
	//	dateTime.format(SimpleDateFormat.)
		
		
		// ���� ��ĥ���Ҵ���..
		System.out.println(365 - dateTime.getDayOfYear());
		// ����.. ��ٱ���..
		System.out.println(18 - dateTime.getHour() + "�ð� ���ҽ��ϴ�.");
//		LocalDateTime dateTime = LocalDateTime.now();//LocalDateTime.of(LocalDate.now(), LocalTime.now());
//		System.out.println(dateTime.getMonthValue() + "/" + dateTime.getDayOfMonth());
	}
}
