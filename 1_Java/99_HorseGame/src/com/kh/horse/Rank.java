package com.kh.horse;

public class Rank {
	int rank;
	
	public Rank() {}
	
	public void finishLine(String name) {
		rank = Horse.count++;	// static 변수이므로 말 하나가 등수를 찍으면 그 다음 말은 1등이 올라감.
		
			if(rank==1) {
				System.out.println(name + " 1등입니다!");
				
			}
			else {
				System.out.println(name+ "의 등수는 " +rank+ "등입니다.");
			}
	}
	
	public void middleRank(String name) {
		int rank2 = Horse.count2++;
		
		if(rank2==1) {
			System.out.println(name + " 중간등수 1등입니다!");
		}
		else {
			System.out.println(name + "의 중간등수는 " + rank2+ "등입니다.");
		}
	}
}
