package com.kh.thread.practice;

//2. Runnable �������̽� ����
public class ThreadInterface implements Runnable{
	// run �޼ҵ� ������(�������̵�)
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println(this.getClass().getSimpleName() + ": " +i);
		}
	}

}
