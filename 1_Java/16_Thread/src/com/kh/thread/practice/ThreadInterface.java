package com.kh.thread.practice;

//2. Runnable 인터페이스 구현
public class ThreadInterface implements Runnable{
	// run 메소드 재정의(오버라이딩)
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println(this.getClass().getSimpleName() + ": " +i);
		}
	}

}
