package com.kh.thread.practice;

// 1. Thread Ŭ���� ���
public class ThreadClass extends Thread {
	private String name;
	
	public ThreadClass(String name) {
		this.name = name;
	}
	// run �޼ҵ带 �������̵�
	// �������̵� �ڵ��ϼ� ����Ű:alt+shift+s
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println(name + ": "+ i);
//			try {
//				// ������ ��Ű��. (Thread.sleep())
//				Thread.sleep(1000);	// 1�ʰ� ������
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} 
		}
	}

	
}
