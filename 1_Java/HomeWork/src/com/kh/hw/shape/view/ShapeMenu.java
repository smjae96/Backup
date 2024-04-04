package com.kh.hw.shape.view;

import java.util.Scanner;

import com.kh.hw.shape.controller.SquareController;
import com.kh.hw.shape.controller.TriangleController;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();
	
	// �⺻������ ����
	
	//�޼ҵ��
	public void inputMenu() {
		while(true) {
			System.out.println("===== ���� ���α׷� =====");
			System.out.println("3. �ﰢ��");
			System.out.println("4. �簢��");
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			if(num == 3) {
				triangleMenu();
				break;
			}
			else if(num == 4) {
				squareMenu();
				break;
			}
			else if(num == 9) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			else {
				System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}	
	}
	public void triangleMenu() {
		System.out.println("===== �ﰢ�� =====");
		System.out.println("1. �ﰢ�� ����");
		System.out.println("2. �ﰢ�� ��ĥ");
		System.out.println("3. �ﰢ�� ����");
		System.out.println("9. ��������");
		System.out.print("�޴� ��ȣ : ");
		int num = sc.nextInt();
		if(num == 1) {
			inputSize(3, 1);
		}
		else if(num == 3) {
			printInformation(3);
		}
		else if(num == 2) {
			inputSize(3, 2);
		}
		else if(num == 9) {
			System.out.println("�������� ���ư��ϴ�.");
			inputMenu();
		}
	}
	public void squareMenu() {
		System.out.println("===== �簢�� =====");
		System.out.println("1. �簢�� �ѷ�");
		System.out.println("2. �簢�� ����");
		System.out.println("3. �簢�� ��ĥ");
		System.out.println("4. �簢�� ����");
		System.out.println("9. ��������");
		System.out.print("�޴� ��ȣ : ");
		int num = sc.nextInt();
		if(num == 1) {
			inputSize(4, 1);
		}
		else if(num == 2) {
			inputSize(4, 2);
		}
		else if(num == 3) {
			inputSize(4, 3);
		}
		else if(num == 4) {
			printInformation(4);
		}
		else if(num == 9) {
			System.out.println("�������� ���ư��ϴ�.");
			inputMenu();
		}
	}
	public void inputSize(int type, int menuNum) {
		if(type ==3 && menuNum ==1) {
			System.out.print("���� : ");
			int height = sc.nextInt();
			System.out.print("�ʺ� : ");
			int width = sc.nextInt();
			System.out.println("�ﰢ�� ���� : " + tc.calcArea(height, width));
			triangleMenu();
		}
		else if(type ==3 && menuNum == 2) {
			System.out.print("������ �Է��ϼ��� : ");
			String color = sc.next();
			tc.paintColor(color);
			System.out.println("���� �����Ǿ����ϴ�.");
			triangleMenu();
		}
		else if(type == 4 && menuNum == 1) {
			System.out.print("���� :");
			int height = sc.nextInt();
			System.out.print("�ʺ� : ");
			int width = sc.nextInt();
			System.out.println("�簢�� �ѷ� : " +scr.calcPerimether(height, width));
			squareMenu();
		}
		else if(type ==4 && menuNum ==2) {
			System.out.print("���� : ");
			int height = sc.nextInt();
			System.out.print("�ʺ� : ");
			int width = sc.nextInt();
			System.out.println("�簢�� ���� : " + scr.calcArea(height, width));
			squareMenu();
		}
		else if(type ==4 && menuNum ==3) {
			System.out.print("������ �Է��ϼ��� : ");
			String color = sc.next();
			scr.paintColor(color);
			System.out.println("���� �����Ǿ����ϴ�.");
			squareMenu();
		}
	}
	public void printInformation(int type) {
		if(type ==3) {
			System.out.println(tc.print());
			triangleMenu();
		}
		if(type ==4) {
			System.out.println(scr.print());
			squareMenu();
		}
	}
}
