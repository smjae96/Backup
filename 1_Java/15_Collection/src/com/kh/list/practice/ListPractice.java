package com.kh.list.practice;

import java.util.ArrayList;	// import : 다른 경로에 있는 클래스 사용 시 위치를 알려준다.
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListPractice {

	/*
	 * List 특징
	 * : 순서가 있고, 중복이 허용되는 컬렉션 
	 * 
	 * *ArrayList
	 * 	- 배열 구조
	 * 	- 데이터 조회가 상대적으로 빠르다.
	 * 	- 데이터 추가/삭제 시 복잡하여 오래 걸린다.
	 * 
	 * 	- 표현법 : List<E> 참조변수명 = new ArrayList<[E]>();
	 * 			 ArrayList<E> 참조변수명 = new ArrayList<[E]>();
	 * 
	 * *LinkedList
	 * 	- 리스트 구조
	 * 	- 데이터 추가/삭제가 빠르다.
	 * 	- 데이터 조회가 느리다.
	 * 
	 * 	- 표현법 : List<E> 참조변수명 = new LinkedList<[E]>();		// [E] : E 타입 생략 가능.
	 * 			 LinkedList<E> 참조변수명 = new LinkedList<[E]>();
	 * 
	 * * List 관련 메소드	=> ArrayList, LinkedList 클래스에서 정의되어 있음
	 * 	- 데이터 추가 : add(데이터)		// E 타입의 데이터 추가
	 * 	- 데이터 삭제 : remove(인덱스)	// 인덱스 위치의 데이터 삭제
	 * 	- 데이터 조회 : get(인덱스)		// 인덱스의 위치의 데이터 조회
	 * 	- 저장된 데이터 길이 : size()
	 */
	
	public static void main(String[] args) {
		arrayListTest();
		//큐(Queue) 	: 처음 저장된 데이터가 가장 처음으로 꺼내올 수 있는 구조 (FIFO: First In First Out)
		
		// 데이터 추가 : 순서대로 추가
		
		// 데이터 제거 : 처음부터 제거
		MyQueue mq = new MyQueue();
		mq.enQueue("심재윤");
		mq.enQueue("레몬");
		mq.enQueue("에이드");
		
		System.out.println(mq.deQueue());
		System.out.println(mq.deQueue());
		System.out.println(mq.deQueue());
		System.out.println(mq.deQueue());
		
		char ch = 'a';
		String result = Character.valueOf(ch).isUpperCase(ch) ? "대문자" : "대문자 아님";
		System.out.println(result);
		
		
	}
	
	
	public static void StackTest() {	
		// 스택(Stack): 제일 마지막에 저장된 데이터가 제일 처음으로 꺼내올 수 있는 구조 (LIFO: Last In First Out)
		
		// 데이터 추가	 : 순서대로 추가
		
		// 데이터 제거	 : 마지막 위치부터 제거
		MyStack mStack = new MyStack();
		mStack.push("심재윤");
		mStack.push("레몬");
		mStack.push("에이드");
		System.out.println(mStack.pop());
		System.out.println(mStack.pop());
		System.out.println(mStack.pop());
	
	}
	public static void linkedListTest() {
		// [2] LinkedList<E>
		List<Integer> list = new LinkedList<>();
		
		// 사용자에게 저장할 데이터 길이를 입력 받아 
		Scanner sc = new Scanner(System.in);
		System.out.print("저장할 데이터 길이를 입력하세요 : ");
		int size = sc.nextInt();
		
		// 그 길이만큼 랜덤 값을 저장
		for(int i=0; i<size; i++) {
			// (int)(Math.random()*size+1)	// 단항 연산자 : 연산 대상이 1개, (type) => 단항연산자 (우선 순위가 꽤 높은편!)
											// Math.random() => 0 <= n <1 (0.000000xxx1 ~ 0.999999xx)
			int num= (int)(Math.random()*size)+1;
			list.add(num);		// int -> Integer
		}
		
		// 저장된 데이터를 출력
		printItem(list);
		System.out.println("=".repeat(10));
		System.out.println("list의 길이: " +list.size());
	}
	
	
	
	public static void arrayListTest() {
		// [1] ArrayList<E>
		ArrayList<String> arr = new ArrayList<>();
		
		//	데이터 추가: add
		arr.add("한식(맥주창고)");		// 이전 배열에서 데이터 추가 시: arr2[i] = "한식(맥주창고)"
		arr.add("마라탕");
		arr.add("자장면");
		
		//	데이터 조회: get
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		//	데이터 삭제: remove
		arr.remove(1);		// 두번째 위치의 데이터("마라탕") 제거
		System.out.println("-".repeat(10)); 	// 문자열.repeat(int count) : 해당 문자열을 count만큼 반복하여 문자열 반환
		for(String item : arr) {
			System.out.println(item);
		}
		
		// 데이터 추가 (원하는 위치에) : add(int index, E element)
		arr.add(1, "돈까스");	 		// 두번째 위치에 데이터 추가
		
		System.out.println("-".repeat(10));
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		System.out.println("-".repeat(10));
		Iterator<String> iterator = arr.iterator();		// Iterator<E> 참조변수명 = List나 Set의 참조변수명.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("-".repeat(10));
		printItem(arr);
		
		//	데이터 수정 (수정할 위치에) : set(int index, E element)
		System.out.println("-".repeat(10));
		arr.set(1, "비빔밥");
		printItem(arr);
	}

		
	
	
	// printItem 메소드 : 중복 제거하기 위해 정의. 리스트 내 아이템 출력
	public static <E> void printItem(List<E> list) {	// 제네릭 메소드 정의
			// 인터페이스를 구현한 클래스의 인스턴스가 매개변수로 전달 가능!
			// List<E> list = new ArrayList<>();
			// List<E> list = new LinkedList<>();
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+"번째: "+list.get(i));
		}
			
	}
}
