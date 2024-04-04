package com.kh.practice;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		// Date 클래스를 사용해서 생일 정보를 출력
		// - Date 객체 생성
		Date day = new Date(1996-1900, 5-1, 28);
		System.out.println(day);
		
		// LocalDateTime 클래스
		// [ 객체 생성 ]
		//	- 년, 월, 일 입력하여 생성 	: LocalDateTime.of(LocalDate.of(int year, int month, int dayOfMonth),
		//												LocatTime.of(int hour, int minute))						
		//															
		//	- 현재 날짜시간 기준으로 생성	: LocalDateTime.now()
		
		// [ 날짜 정보 조회 ]
		//	- 월(month) : 변수명.getMonthValue()	// 숫자로 월 정보를 반환
		//				 변수명.getMonth()		// 영어로 월 정보를 반환
		//	- 일(day)	: 변수명.getDayofMonth()	// 월 기준 일 정보 반환
		//					변수명.getDayofYear()	// 연 기준 일 정보 반환
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		System.out.println(dateTime.getMonthValue() + "/" + dateTime.getDayOfMonth());
		// 생일 출력..
		LocalDateTime birth = LocalDateTime.of(LocalDate.of(2000, 1, 5), LocalTime.of(0, 0));
		System.out.println(birth);
		
		//DateTimeFormatter
		//	DateTimeFormatter.ofPattern(포맷) : 날짜 정보의 포맷(형식) 정의
		// - YYYY-MM-DD hh:mm:ss
		// - import java.time.format.DateTimeFormatter;
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss")));
		
		//SimpleDateFormat
		SimpleDateFormat dateFormat = new SimpleDateFormat();
	//	dateTime.format(SimpleDateFormat.)
		
		
		// 올해 며칠남았는지..
		System.out.println(365 - dateTime.getDayOfYear());
		// 오늘.. 퇴근까지..
		System.out.println(18 - dateTime.getHour() + "시간 남았습니다.");
//		LocalDateTime dateTime = LocalDateTime.now();//LocalDateTime.of(LocalDate.now(), LocalTime.now());
//		System.out.println(dateTime.getMonthValue() + "/" + dateTime.getDayOfMonth());
	}
}
