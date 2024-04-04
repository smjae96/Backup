package com.kh.thread.practice;

// 1. Thread 클래스 상속
public class ThreadClass extends Thread {
	private String name;
	
	public ThreadClass(String name) {
		this.name = name;
	}
	// run 메소드를 오버라이딩
	// 오버라이딩 자동완성 단축키:alt+shift+s
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println(name + ": "+ i);
//			try {
//				// 딜레이 시키기. (Thread.sleep())
//				Thread.sleep(1000);	// 1초간 딜레이
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} 
		}
	}

	
}
