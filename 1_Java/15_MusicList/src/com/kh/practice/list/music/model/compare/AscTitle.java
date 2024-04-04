package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

// 리스트 정렬 관련 클래스
//	[1] Comparator 인터페이스 구현 정의
//	[2] compare 메소드를 재정의
public class AscTitle implements Comparator{
	// 오버라이딩 자동 완성 단축키 : Alt + Shift + S / V
	@Override
	public int compare(Object o1, Object o2) {
		// Object o1 = new Music();
		
		// ((Music)o1).getTitle()

		return ((Music)o2).getTitle().compareTo(((Music)o1).getTitle());
				
		
		

		//  Title의 내림차순으로 정렬
		//	정수/실수
		//	* 오름차순 : o1- o2
		//	* 내림차순 : o2 - o1
		
		//	문자열의 경우 : 
		//	* 오름차순 : o1.getTitle().compareTo(o2.getTitle())
		//	* 내림차순 : o2.getTitle().compareTo(o1.getTitle())
	}

}
