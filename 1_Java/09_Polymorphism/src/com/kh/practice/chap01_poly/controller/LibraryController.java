package com.kh.practice.chap01_poly.controller;


import java.util.Arrays;

import com.kh.practice.chap01_poly.model.vo.AniBook;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.CookBook;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryController {
	private Member mem = null;	//null로 명시 초기화
	private Book[] bList = new Book[5];	// 크기 5 할당
	//초기화 블록, Book 객체 배열에 5개의 객체 데이터를 초기화
	{
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}
	// Controller 부분은 생성자를 따로 정의하지 않음
	// 	=> 기본 생성자만 사용하여 객체를 생성
	// insertMember => mem 변수의 setter 메소드
	public void insertMember(Member mem) {
		this.mem = mem;			// 주소값 복사됨(대입됨) => 마치 set메소드같음.
	}
	// myInfo => mem 변수의 getter 메소드
	public Member myInfo() {
		return mem;		// 참조변수(mem) 자체가 주소값을 가지고 있음. => 마치 get메소드같음.
	}
	// selectAll => bList 변수의 getter 메소드
	public Book[] selectAll() {
		return bList;	// 참조변수(bList) 자체가 주소값을 가지고 있음. => 마치 get메소드같음.
	}
	
	// 키워드를 입력 받아 키워드가 포함된 도서 목록을 반환하는 메소드
	public Book[] searchBook(String keyword) {
		Book[] b1 = new Book[5];
		int count=0;
		for(int i=0; i<bList.length; i++) {
			if(bList[i].getTitle().contains(keyword)) {
				b1[count] = bList[i];
				count++;
			}
		}
//		if(count != 0) {
//			b1 = Arrays.copyOf(bList, b1.length);
//		}

		return b1;
	}
	// 
	public int rentBook(int index) {
		int result = 0;
		
		// index: 객체(Book) 배열에서 사용할 위치 값.
		// bList (도서목록)에서 만화책인 경우
		if(bList[index] instanceof AniBook) {
			if(mem != null) {	// 회원 정보가 있다면..
				// bList[index] => Book b;
				int accessAge = ((AniBook)(bList[index])).getAccessAge();  // getter&setter 메소드는 필드가 private으로 선언될 경우
																		   //(클래스다이어그램에 메소드를 작성하라는 표시가 없어도) 항상 생성해줘야 한다!
				//	회원 나이와 만화책의 제한나이를 비교
				if(mem.getAge() < accessAge) {
					//		회원 나이 < 만화책의 제한나이 : result = 1
					result = 1;
					
				}
				
			}
			
			
			//		회원 나이 < 만화책의 제한나이 : result = 1
		}
		else if(bList[index] instanceof CookBook) {
			// bList(도서목록)에서 요리책(CookBook)인 경우
			
			//		해당 요리책의 쿠폰유무가 유(true)인 경우
			//		=> CookBook 클래스의 isCoupon() 메소드를 통해 확인!
			//			도서 목록(bList)에서 index 위치의 책이 요리책(CookBook)
			if(((CookBook)bList[index]).isCoupon()) {
				//			- 회원의 couponCount 값 1 증가
				//			- result = 2 	
				if(mem != null) {	// 회원 정보가 있다면
					// 메소드를 따로 추가하여 작성
					mem.addCount();
					
					/* 실습문제 기준으로 작성
					int memCouponeCount = mem.getCouponCount();
					mem.setCouponCount(memCouponeCount +1);
					*/
					result = 2;
				}
			}

		}
		return result; 
	}
}
