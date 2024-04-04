package com.kh.thread.sync;

// 동기화 처리 : 메소드 전체, 메소드 내 일정 부분(블럭). synchronized(공유객체) { .. }
// -> 사용 중인 자원(데이터)을 다른 스레드가 접근하지 못하도록 하는 것.
//	  데이터가 변경되는 위치에 처리
class CounterSyncBlock {
	// ~count : int=0;
	int count = 0;
	
	// +increment() : void	=> count 값을 1 증가
	public void increment() {
		synchronized(this) { // (매개변수) 자리에 공유 객체가 들어가야 함. 클래스 자체가 공유객체이므로 this 사용.
		count++;
		}
	}
	
	/**********************
	 * 메소드에 동기화 처리 적용	(둘 다 가능)
	 * [1]
	  	synchronized public void increment() {		
	  		count++;
	  	}
	 * [2]
	 	public synchronized void increment() {
	 		count++;
	 	}	
	 */
	
	// +decrement() : void => count 값을 1 감소
	public void decrement() {
		synchronized(this) {
		count--;
		}
	}
	
	// +getCount() : int => count 값을 조회
	public int getCount() {
		return count;
	}
}
public class MutualAccessSync {
	static CounterSyncBlock csb = new CounterSyncBlock();	// 공유 자원으로 쓰기 위해 static으로 선언.
	
	public static void main(String[] args) {
		Runnable task1 = () -> {
			for(int i=0; i<500; i++) {
				csb.increment();
			}
		};
		Runnable task2 = () -> {
			for(int i=0; i<500; i++) {
				csb.decrement();
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		// 스레드 실행
		t1.start();
		t2.start();
		// 메인스레드가 아래 스레드들의 작업 종료까지 기다리도록 처리 : .join()
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		System.out.println(csb.getCount());
	}
	
}
