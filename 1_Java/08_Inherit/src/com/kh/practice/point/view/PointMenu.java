package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	
	private CircleController cc = new CircleController();
	
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		
		System.out.println("===== �޴� =====");
		System.out.println("1. ��");
		System.out.println("2. �簢��");
		System.out.println("9. ������");
		System.out.print("�޴� ��ȣ : ");
		int num = sc.nextInt();
		if(num ==1) {
			circleMenu();
		}
		else if(num ==2) {
			rectangleMenu();
		}
		else if(num ==9) {
			System.out.println("�����մϴ�.");
			return;
		}
		else {
			mainMenu();
		}
		
		
	}
	
	public void circleMenu() {
		System.out.println("===== �� �޴� =====");
		System.out.println("1. �� �ѷ�");
		System.out.println("2. �� ����");
		System.out.println("9. ��������");
		System.out.print("�޴� ��ȣ : ");
		int num = sc.nextInt();
		if(num == 1) {
			calcCircum();
		}
		else if(num == 2) {
			calcCircleArea();
		}
		else if(num == 9) {
			mainMenu();
		}
		else {
			mainMenu();
		}
	}
	
	public void rectangleMenu() {
		System.out.println("===== �簢�� �޴� ======");
		System.out.println("1. �簢�� �ѷ�");
		System.out.println("2. �簢�� ����");
		System.out.println("9. ��������");
		System.out.print("�޴� ��ȣ : ");
		int num = sc.nextInt();
		if(num==1) {
			calcPerimeter();
		}
		else if(num==2) {
			calcRectArea();
		}
		else if(num==9) {
			mainMenu();
		}
		else {
			mainMenu();
		}
		
	}
	
	public void calcCircum() {
		System.out.print("x ��ǥ : ");
		int numX = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int numY = sc.nextInt();
		System.out.print("������ : ");
		int numR = sc.nextInt();
		System.out.println("�ѷ� : " +cc.calcCircum(numX, numY, numR));
		mainMenu();
	}
	
	public void calcCircleArea() {
		System.out.print("x ��ǥ : ");
		int numX = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int numY = sc.nextInt();
		System.out.print("������ : ");
		int numR = sc.nextInt();
		System.out.println("���� : " +cc.calcArea(numX, numY, numR));
		mainMenu();
	}
	
	public void calcPerimeter() {
		System.out.print("x ��ǥ : ");
		int numX = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int numY = sc.nextInt();
		System.out.print("���� : ");
		int numH = sc.nextInt();
		System.out.print("�ʺ� : ");
		int numW = sc.nextInt();
		System.out.println("�ѷ� : " +rc.calcPerimeter(numX, numY, numH, numW));
		mainMenu();
	}
	
	public void calcRectArea() {
		System.out.print("x ��ǥ : ");
		int numX = sc.nextInt();
		System.out.print("y ��ǥ : ");
		int numY = sc.nextInt();
		System.out.print("���� : ");
		int numH = sc.nextInt();
		System.out.print("�ʺ� : ");
		int numW = sc.nextInt();
		System.out.println("���� : " +rc.calcArea(numX, numY, numH, numW));
		mainMenu();
	}
}
