package com.kh.controller;

import java.util.Scanner;

import com.kh.model.vo.User;

public class Game1{
	
	Scanner sc = new Scanner(System.in);
	public void UpDownGame (User user) {	// �޼ҵ带 ���� �� User Ÿ�� �Ű����� �������� ����!
		System.out.println("===== Up&Down ���� =====");
		System.out.println("1~50 ������ ���� ���߱�");
		
		int random = (int)(Math.random()*50+1);
		
		for(int i=0; i<3; i++) {
			System.out.print("��ȣ�� �Է��ϼ���: ");
			int num = sc.nextInt();

			if(random> num) {
				System.out.println("=== Up! ===");
			}
			else if(random < num) {
				System.out.println("=== Down! ===");
			}
			else {
				System.out.println(" === Catch! +100��!!===");
				user.setScore(user.getScore()+100);
				break;
			}
			
		}
		System.out.println("������ " + random + "�Դϴ�.");
	}
}
