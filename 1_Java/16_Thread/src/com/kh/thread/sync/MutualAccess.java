package com.kh.thread.sync;

class Counter {
	// ~count : int=0;
	int count = 0;
	
	// +increment() : void	=> count 값을 1 증가
	public void increment() {
		count++;
	}
	
	// +decrement() : void => count 값을 1 감소
	public void decrement() {
		count--;
	}
	
	// +getCount() : int => count 값을 조회
	public int getCount() {
		return count;
	}
}

// 동기화 적용하지 않고 테스트
public class MutualAccess {
	// +cnt:Counter = new Counter(); (밑줄)...
	public static Counter cnt = new Counter();	// 공유 자원으로 쓰기 위해 static으로 선언.
	
	// +main(args:String[]):void (밑줄)
	public static void main(String[] args) {
		// Thread 2개 생성
		
		// 람다식을 사용하여 Thread
		Runnable task1 = () -> {
			// run() 메소드에 재정의한 작업
			for(int i=0; i<100; i++) {
				cnt.increment();
			}
		};
		
		Runnable task2 = () -> {
			for(int i=0; i<100; i++) {
				cnt.decrement();
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);

		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(cnt.getCount());
	}
}
