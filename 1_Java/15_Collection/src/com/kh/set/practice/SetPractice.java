package com.kh.set.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetPractice {
	/*
	 * Set의 특징
	 * : 중복 허용이 안되고, 순서가 없는 컬렉션
	 * 
	 * *HashSet
	 * 	- 해시(Hash) : 특정 기준에 따라 데이터를 분류하는 방식(알고리즘)
	 * 
	 * 	- 중복 데이터 판단 : hashCode, equals
	 * 		(1) hashCode : 기준이 되는 값(데이터)을 정의
	 * 		(2) equals   : hashCode 값이 같을 경우 동일 데이터 판단 로직 정의
	 * 
	 * 	- Set 메소드
	 * 		* 데이터 추가 : add(E element)
	 * 		* 데이터 삭제 : remove(Object o)	인덱스가 아닌 삭제할 데이터를 매개변수로 기입.
	 * 		* 데이터 길이 조회 : size()
	 * 		* 데이터 조회 [2가지 방법]
	 * 				(1) Iterator (반복자) 사용
	 * 					- 객체 생성 : set변수명.iterator()
	 * 					- 데이터 유/무 판단 : iterator변수명.hasNext()
	 * 					- 데이터 조회 : iterator변수명.next()
	 * 				(2) for-each문
	 * 					for(자료형 변수명 : set변수명) {
	 * 						// 변수명을 통해 set 내 데이터로 접근
	 * 					}
	 */
	
	public static void main(String[] args) {
		// Member 객체 데이터를 Set 구조로 관리
		Set<Member> set = new HashSet<>();
		
		// 데이터 추가 => Member 타입의 데이터 : 인스턴스를 생성하여 전달하거나, 인스턴스를 가리키는 참조변수 전달함.
		set.add(new Member(1000, "심재윤"));		// 인스턴스 생성하면서 전달.
		Member m1 = new Member(1001, "성시경");
		set.add(m1);							// 인스턴스를 가리키는 참조변수 전달.
		
		// 데이터 조회
		for(Member member : set) {
			System.out.println(member); 			// member => member.toString()이 호출되어 출력됨.
		}
		System.out.println("*".repeat(20));
		
		// 데이터 삭제
		set.remove(new Member(1001, "성시경"));
		
		set.add(new Member(1001, "임한별"));		// 중복이므로 추가 안됨. 삭제한 뒤에 추가 시 추가 됨.
		
		// 데이터 조회
		for(Member member : set) {
			System.out.println(member); 			// member => member.toString()이 호출되어 출력됨.
		}
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(45, "홍길동");
		map.put(23, "심재윤");
		map.put(37, "마틴");
		
		Set<Integer> keySet = map.keySet();
//		for(Integer n : keySet) {
//			System.out.print(n + "\t");
//		}
//		System.out.println();
		Iterator<Integer> iterator = keySet.iterator();
//		while(iterator.hasNext()) {
//			System.out.print(iterator.next() + "\t");
//		}
		
//		for(Integer n : keySet) {
//			System.out.print(map.get(n) + "\t");	// map.get() :키에 해당하는 값(value)
//		}
		System.out.println();
		while(iterator.hasNext()) {
			System.out.print(map.get(iterator.next()) + "\t");
		}
	}	
	
	
	public static void hashSetTest01() {
		// 데이터를 Set 구조로 관리하려면 HashSet 클래스 사용 => 객체 생성(인스턴스화)
		Set<String> set = new HashSet<>();
		
		// Set 구조에 데이터를 추가
		set.add("ISTP");
		set.add("ESFP");
		set.add("ISFJ");
		set.add("ISFP");
		
		set.add("INTJ");
		
		set.add("ESFP");	// 중복 데이터!
		
		// Set에 저장된 데이터를 출력
		System.out.println(set);		// 참조변수만 출력함수로 출력했을 때 [데이터, 데이터, ...] 형식으로 출력됨.
		
		// Iterator 사용하여 출력
		Iterator<String> iterator = set.iterator();		// (1) Iterator 객체를 생성.
		//for(;iterator.hasNext();) {}					// (2) 조건식 위치: 데이터 유/무 판단
		while(iterator.hasNext()) {
			String data = iterator.next();				// (3) 데이터 조회 
			System.out.println(data);
		}
		System.out.println("*".repeat(10));
		
		// 데이터 삭제 : ISFP
		set.remove("ISFP");
		
		// for-each문 사용하여 출력
		for(String data : set) {		// 어떤 데이터들의 모음인지 확인 후 자료형 작성
			System.out.println(data);	// data => Set에 저장된 데이터 하나하나를 꺼내옴.
		}
	}
	
}
