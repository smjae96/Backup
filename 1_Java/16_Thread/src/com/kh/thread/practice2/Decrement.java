package com.kh.thread.practice2;

public class Decrement implements Runnable{
	private int n1;
	private int n2;
	
	public Decrement(int n1, int n2) {
		this.n1=n1;
		this.n2=n2;
	}
	
	@Override
	public void run() {
		int start = n1>n2 ? n1 : n2;	// start : 큰 값
		int end = n1<n2 ? n1 : n2;		// end : 작은 값
		for(int i= start; i>=end; i--) {
			System.out.println(i);
			try {
				Thread.sleep(100);;		// 0.1초 딜레이
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		if(n1>=n2) {
//			for(int i=n1; i>=n2; i--) {
//				System.out.println(i);
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		} else {
//			for(int i=n2; i>=n1; i--) {
//				System.out.println(i);
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
			
//		}
		System.out.println("**Decrement의 run 종료!**");
	}

}
