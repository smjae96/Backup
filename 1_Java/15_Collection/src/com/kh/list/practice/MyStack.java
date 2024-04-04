package com.kh.list.practice;

import java.util.ArrayList;

public class MyStack {
	// 필드
	// -arrayStack:ArrayList<String>=new ArrayList<>();
	private ArrayList<String> arrayStack = new ArrayList<>();
	
	// 메소드
	// +push(String data): void // 리스트에 data를 추가
	public void push(String data) {
		arrayStack.add(data);
	}
	
	// +pop(): String			// 리스트에 마지막 data를 제거하고 그 값을 반환
								// 리스트가 비어있으면 "리스트가 비었습니다."를 반환
	public String pop() {
		if(arrayStack.isEmpty()) {		// isEmpty() -> 컬렉션(리스트)이 비어 있는지 조사해서 비어 있으면 true 리턴.
			return "리스트가 비었습니다.";
		} else {
			return arrayStack.remove(arrayStack.size()-1);	// remove 메소드의 반환타입이 타입매개변수(E)이다.
		}
		
	}
	
	
}
