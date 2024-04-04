package com.kh.thread.practice;

public class Run {

	public static void main(String[] args) {
		// 데몬 스레드 : 다른 스레드 보조하는 역할을 하는 스레드.
		// 			  다른 스레드들이 종료되면 강제로 종료됨.
		System.out.println("---- 프로그램 시작 -----");
		ThreadClass daemon = new ThreadClass("daemon");
		daemon.setDaemon(true);	// 데몬 스레드 설정
		daemon.start();
		try {
			daemon.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("---- 프로그램 종료 ----");
	}
	
	
	public static void threadTest02() {	
		// Thread 객체 3개 생성
		ThreadClass t1 = new ThreadClass("스레드1");
		ThreadClass t2 = new ThreadClass("스레드2");
		ThreadClass t3 = new ThreadClass("스레드3");
		
		//t3 스레드가 가장 먼저 실행하도록 처리
		//	setPriority(우선순위값) : 우선순위 기본 값(5)
		t1.setPriority(1);
		t2.setPriority(5);
		t3.setPriority(10);
		
		
		t1.start();
		t2.start();
		t3.start();
	}
	public static void threadTest01() {	
		System.out.println("** 프로그램 시작 **");
		// 1. Thread 클래스를 상속했을 경우
		Thread tc = new Thread();
		tc.start();
		
		//2. Runnable 인터페이스를 구현한 경우
		ThreadInterface ti = new ThreadInterface();
		Thread t2 = new Thread(ti);
		t2.start();
		
		// main 스레드가 t2 스레드의 작업을 기다리게 하려면? .join()
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("** 프로그램 종료 **");
		
		// main스레드까지 총 3개의 작업이 분리되어 동시에 실행되고 있다!
	}

}
