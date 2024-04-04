package com.kh.horse;

public class Horse implements Runnable{
	String name;
	int meter;
	static int count = 1;
	static int count2 = 1;
	Rank rank;
	
	public Horse() {
		meter = 100;
	}
	public Horse(String name, Rank rank) {
		this();
		this.name=name;
		this.rank=rank;
	}
	@Override
	public void run() {
		for(int i= meter; i>=0; i-=20) {
			int num = (int)(Math.random()*3000+1);
			System.out.println(name +"의 결승점까지 남은 거리 : " +i+ "미터");
			try {
				Thread.sleep(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i==0) {
				rank.finishLine(name);
			}
			if(i==60) {
				rank.middleRank(name);
			}
		}
	}
}
