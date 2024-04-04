package com.kh.list.practice;

import java.util.ArrayList;

public class MyStack {
	// �ʵ�
	// -arrayStack:ArrayList<String>=new ArrayList<>();
	private ArrayList<String> arrayStack = new ArrayList<>();
	
	// �޼ҵ�
	// +push(String data): void // ����Ʈ�� data�� �߰�
	public void push(String data) {
		arrayStack.add(data);
	}
	
	// +pop(): String			// ����Ʈ�� ������ data�� �����ϰ� �� ���� ��ȯ
								// ����Ʈ�� ��������� "����Ʈ�� ������ϴ�."�� ��ȯ
	public String pop() {
		if(arrayStack.isEmpty()) {		// isEmpty() -> �÷���(����Ʈ)�� ��� �ִ��� �����ؼ� ��� ������ true ����.
			return "����Ʈ�� ������ϴ�.";
		} else {
			return arrayStack.remove(arrayStack.size()-1);	// remove �޼ҵ��� ��ȯŸ���� Ÿ�ԸŰ�����(E)�̴�.
		}
		
	}
	
	
}
