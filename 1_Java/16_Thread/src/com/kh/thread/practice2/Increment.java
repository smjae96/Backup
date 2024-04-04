package com.kh.thread.practice2;

public class Increment implements Runnable{

	private int num;
	
	public Increment(int num) {
		this.num=num;
	}
	@Override
	public void run() {
		for(int i=1; i<=num; i+=2) {
			System.out.println(i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("**IncrementÀÇ run Á¾·á!**");
	}

}
