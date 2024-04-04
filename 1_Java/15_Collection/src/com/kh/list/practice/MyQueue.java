package com.kh.list.practice;

import java.util.ArrayList;

public class MyQueue {
	// 필드 
	// -myQueue:ArrayList<String> = new ArrayList<String>();
	private ArrayList<String> myQueue = new ArrayList<>();
	// 메소드
	// +enQueue(data : String) void		// 데이터 추가
	public void enQueue(String data) {
		myQueue.add(data);
	}
	// +deQueue(): String				// 데이터 제거
	public String deQueue() {
		if(myQueue.isEmpty()) {
			return "리스트가 비었습니다.";
		} else {
			return myQueue.remove(0);
			
		}
	}
}
