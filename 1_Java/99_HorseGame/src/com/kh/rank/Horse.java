package com.kh.rank;

public class Horse implements Runnable, Comparable<Horse>{
	String name;
	int meter;
	static int count = 1;
	static int count2 = 1;
	Rank rank;
	
	public Horse() {
		meter = 1000;
	}
	public Horse(String name, Rank rank) {
		this();
		this.name=name;
		this.rank=rank;
	}
	@Override
	public void run() {
		
		while(true) {
			int num = (int)(Math.random()*3000+1);
			meter = meter - 20;

			if(meter ==0) {
				rank.finishLine(name);
				break;
			}
			try {
				Thread.sleep(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
//		for(int i= meter; i>=0; i-=20) {
//			int num = (int)(Math.random()*3000+1);
//			System.out.println(name +"의 결승점까지 남은 거리 : " +i+ "미터");
//			try {
//				Thread.sleep(num);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			if(i==0) {
//				rank.finishLine(name);
//			}
//			if(i==60) {
//				rank.middleRank(name);
//			}
//		}
	}
	
	@Override
    public int compareTo(Horse o) {
        return meter- o.getMeter()  ;
    }
	public int getMeter() {
		return meter;
	}
	public void setMeter(int meter) {
		this.meter = meter;
	}
}
