package com.kh.horse;

public class Rank {
	int rank;
	
	public Rank() {}
	
	public void finishLine(String name) {
		rank = Horse.count++;	// static �����̹Ƿ� �� �ϳ��� ����� ������ �� ���� ���� 1���� �ö�.
		
			if(rank==1) {
				System.out.println(name + " 1���Դϴ�!");
				
			}
			else {
				System.out.println(name+ "�� ����� " +rank+ "���Դϴ�.");
			}
	}
	
	public void middleRank(String name) {
		int rank2 = Horse.count2++;
		
		if(rank2==1) {
			System.out.println(name + " �߰���� 1���Դϴ�!");
		}
		else {
			System.out.println(name + "�� �߰������ " + rank2+ "���Դϴ�.");
		}
	}
}
