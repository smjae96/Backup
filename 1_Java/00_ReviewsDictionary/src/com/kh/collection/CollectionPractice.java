package com.kh.collection;

import java.util.ArrayList;
import java.util.List;

class Food {
	String name;
	int kcal;
	//	재료 : 데이터 타입 -> Set (재료 목록), Map<재료, 용량> ( 좀 더 자세히.. 구성한다면..)
	public Food() {}
	
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}
}

class Pizza extends Food {

	public Pizza() {
		super();
	}

	public Pizza(String name, int kcal) {
		super(name, kcal);
	}
	
}


public class CollectionPractice {
	/*
	 * 컬렉션 (Collection) : 자바에서 제공해주는 자료구조 관련 라이브러리(기본 클래스)
	 * 	- 여러 개의 자료구조 관련 인터페이스가 정의되어 있고, 
	 * 			그 인터페이스를 구현한 클래스들이 있다.
	 * 
	 * 	- Collection 인터페이스	: 데이터를 모아서 관리
	 * 
	 * 		* List 인터페이스 : 순서 ㅇ, 중복 허용 ㅇ (주소록, to-do 리스트)
	 * 			( * <E> : 제네릭 -> 하나의 타입이 아닌 여러 타입을 사용할 수 있도록 정의한 것.)
	 * 			+ ArrayList<E>	:	데이터 조회 시 속도가 빠름(배열 기반, 인덱스로 바로 조회)
	 * 			
	 * 			+ LinkedList<E>	:	데이터 추가/삭제 시 속도가 빠름(리스트 기반, 연결 구조로 빠르게 처리 가능)
	 * 			
	 * 		* Set 인터페이스  : 순서 x, 중복 허용 x (집합)
	 * 			+ HashSet<E>	:	해시 알고리즘 기반으로 데이터 중복 처리
	 * 								 - equals(), hashCode() 메소드를 사용하여 중복 체크.
	 * 								 - 1)hashCode() 메소드의 반환 값이 동일하고,
	 * 								   2)equals() 메소드의 반환 값이 true인 경우 동일한 객체로 판단한다.
	 * 
	 * 	- Map 인터페이스			: 키-값으로 한 쌍인 데이터를 모아서 관리
	 * 		* 순서 x, 키는 중복 허용 x, 값은 중복 허용 o
	 * 		+ HashMap<K, V>	: 키 값을 기준으로 해시 알고리즘을 적용하여 중복을 체크
	 * 						  키 목록을 조회하면 "Set" 구조이다. ( keySet() 메소드로 조회 가능. )
	 * 
	 * 	* 메소드 정리
	 * 				List					Set									Map
	 * 	데이터 추가	add(데이터)				add(데이터)							put(키 데이터, 값 데이터)
	 * 
	 * 	데이터 삭제	remove(인덱스)			remove(데이터)						remove(키 데이터)
	 * 				remove(데이터)
	 * 
	 * 	데이터 조회	get(인덱스)				* Iterator 객체						get(키 데이터)	 // 해당 키와 쌍으로 저장된 값을 조회
	 * 									 1) Iterator 객체 생성 : 
	 * 									Iterator iterator = Set객체_참조변수명.iterator()
	 * 									 2) 다음 데이터 존재 유/무 판단
	 * 									 	iterator.hasNext() 메소드 호출하여 확인 => 조건식
	 * 									 3) 해당 데이터를 꺼내오는 메소드 : next()
	 * 										iterator.next()	 // 데이터 타입은 Set<E> 선언 시 사용된 E 타입
	 * 										
	 * 										* for-each 문
	 * 									for(E data : set객체_참조변수명) {	}		
	 * 
	 * 데이터 길이		size()					size()								size()	
	 */
	public static void main(String[] args) {
		// ArrayList 에...
		// ArrayList 컬렉션으로 여러 개의 Food를 관리하기 위해 객체 생성
		List<Food> fList = new ArrayList<>();
		
		// Food 객체를 리스트에 추가.
		// 밥 한공기 , 300...?
		// 햄버거, 414...
		Food f1 = new Food("밥 한공기", 300);
		fList.add(f1);
		
		// add(E e)
		// => add(Food e) => 매개변수가 객체타입(Food)이면, 메소드 호출 시 어떤 값을 전달해야 할까?
		//						** 객체 인스턴스(객체 생성) 전달 **
		// fList.add("피자"); // 내가 지정한 타입에 해당하는 인스턴스를 전달해야 함.
		
		fList.add(new Food("햄버거", 414));

		// 다형성 적용되어, 부모 타입의 컬렉션을 정의했지만 자식 타입의 데이터들도 추가 가능.
		// * Food e = new Pizza();
		fList.add(new Pizza("피자", 600));
		System.out.println(fList.get(0).name);
		System.out.println(fList.get(2).name);
	}
}
