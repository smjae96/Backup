package com.kh.rank;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.print("����� �� ���� ���� ������!(1����/2����/3����/4����/5����) : ");
		String horse = sc.next();
		List<Horse> horseList = new LinkedList<>();
		Rank r = new Rank();
		horseList.add(new Horse("1����", r));
		horseList.add(new Horse("2����", r));
		horseList.add(new Horse("3����", r));
		horseList.add(new Horse("4����", r));
		horseList.add(new Horse("5����", r));
		
		
		
		Thread t1 = new Thread(horseList.get(0));
		Thread t2 = new Thread(horseList.get(1));
		Thread t3 = new Thread(horseList.get(2));
		Thread t4 = new Thread(horseList.get(3));
		Thread t5 = new Thread(horseList.get(4));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		

		
		Runnable task1 = () -> {
			while(true) {
				Collections.sort(horseList);
				System.out.println("----- �ǽð� ��ŷ -----");
				for(int i=0; i<horseList.size(); i++) {
					
					System.out.println("" + horseList.get(i).name + " " + (i+1) +"��");
				}
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		};
		
		Thread t6 = new Thread(task1);
		t6.setDaemon(true);
			t6.start();
		
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//		int j = 0;
//		
//		for(j=0; j<ho.length; j++) {
//			r.middleRank(ho[j].name);
//		}
//		try {
//			t1.wait();
//			t2.wait();
//			t3.wait();
//			t4.wait();
//			t5.wait();
//		} 
//		catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		t1.interrupt();
//		t2.interrupt();
//		t3.interrupt();
//		t4.interrupt();
//		t5.interrupt();
		
//		try {
//			t1.join();
//			t2.join();
//			t3.join();
//			t4.join();
//			t5.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		for(int i=0; i<ho.length; i++) {
//			if(ho[i].name.equals(horse) && ho[i].rank.rank==1) {
//				System.out.println("�����Դϴ�.");
//				break;
//			}
//			else {
//				System.out.println("Ʋ�Ƚ��ϴ�.");
//				break;
//			}
//		}
	}

}
