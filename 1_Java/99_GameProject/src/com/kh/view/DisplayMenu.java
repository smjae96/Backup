package com.kh.view;

import java.util.Scanner;

import com.kh.controller.Game1;
import com.kh.controller.Game2;
import com.kh.controller.Game3;
import com.kh.controller.PlayController;
import com.kh.model.vo.User;

public class DisplayMenu {
	Game1 g1 = new Game1();
	Game2 g2 = new Game2();
	Game3 g3 = new Game3();
	Scanner sc = new Scanner(System.in);
	PlayController pc = new PlayController();
	public User user = new User("������");
	public void mainMenu() {
		while(true) {
			System.out.println("=====Console Game=====");
			System.out.println("1. Up & Down");	// �������� �̾Ƽ� 3�� ��ȸ �ȿ� ���߸� ���� ȹ��
			System.out.println("2. ����������");	// ��ǻ��(������) ����� �Է� ���̶� ���ؼ� �̱� ���� ȹ��
			System.out.println("3. ���� �߱�"); 	// 2�ڸ� ��� ���߸� ��Ʈ����ũ!(����ȹ��), ���ڸ� ���߸� ��(-), 5�� ��� Ʋ���� �ƿ�(���� ����)
			System.out.println("9. ���� ��ȸ");	
			System.out.println("0. ���� ����");
			System.out.println("======================");
			
			// ���� ���� �� �ش� ������ ������ �� �ֵ��� -->
			System.out.print("���� ����: ");
			int sel = sc.nextInt();
			if(sel ==1) {
				
				g1.UpDownGame(user);
			}
			else if(sel ==2) {
				
				g2.RSP(user);
			}
			else if(sel ==3) {
				
				g3.numBaseBall(user);
			}
			else if(sel ==9) {
				System.out.println(user.toString());
			}
			else if(sel ==0) {
				System.out.println("���� ����");
				break;
			}
			else {
				mainMenu();
			}
			
		}
		System.out.println("=======================");

	}
}
