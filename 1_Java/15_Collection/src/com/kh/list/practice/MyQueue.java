package com.kh.list.practice;

import java.util.ArrayList;

public class MyQueue {
	// �ʵ� 
	// -myQueue:ArrayList<String> = new ArrayList<String>();
	private ArrayList<String> myQueue = new ArrayList<>();
	// �޼ҵ�
	// +enQueue(data : String) void		// ������ �߰�
	public void enQueue(String data) {
		myQueue.add(data);
	}
	// +deQueue(): String				// ������ ����
	public String deQueue() {
		if(myQueue.isEmpty()) {
			return "����Ʈ�� ������ϴ�.";
		} else {
			return myQueue.remove(0);
			
		}
	}
}
