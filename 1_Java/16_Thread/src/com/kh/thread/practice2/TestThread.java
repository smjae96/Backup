package com.kh.thread.practice2;

public class TestThread {
	// - Thread 클래스를 멀티 스레딩(멀티 스레드 방식으로 실행)
	public static void main(String[] args) {
		Runnable i = new Increment(30);
		Thread t1 = new Thread(i);
		Runnable d = new Decrement(15, 2);
		Thread t2 = new Thread(d);
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Runnable task3 = () -> {	// 람다식을 이용하면 Thread클래스를 만들거나, Runnable 인터페이스를 구현한 클래스를 만들 필요 없이 
									// main메소드에서 바로 스레드 생성 및 실행 가능.
			System.out.println("심재윤");
		};
		
		Thread t3 = new Thread(task3);
		t3.start();
		
		Thread t4 = new Thread(() -> {
			System.out.println("람다식 어려움");
		});
		t4.start();
	}
}
