package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	
	private CircleController cc = new CircleController();
	
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 원");
		System.out.println("2. 사각형");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();
		if(num ==1) {
			circleMenu();
		}
		else if(num ==2) {
			rectangleMenu();
		}
		else if(num ==9) {
			System.out.println("종료합니다.");
			return;
		}
		else {
			mainMenu();
		}
		
		
	}
	
	public void circleMenu() {
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
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
		System.out.println("===== 사각형 메뉴 ======");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
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
		System.out.print("x 좌표 : ");
		int numX = sc.nextInt();
		System.out.print("y 좌표 : ");
		int numY = sc.nextInt();
		System.out.print("반지름 : ");
		int numR = sc.nextInt();
		System.out.println("둘레 : " +cc.calcCircum(numX, numY, numR));
		mainMenu();
	}
	
	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int numX = sc.nextInt();
		System.out.print("y 좌표 : ");
		int numY = sc.nextInt();
		System.out.print("반지름 : ");
		int numR = sc.nextInt();
		System.out.println("면적 : " +cc.calcArea(numX, numY, numR));
		mainMenu();
	}
	
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int numX = sc.nextInt();
		System.out.print("y 좌표 : ");
		int numY = sc.nextInt();
		System.out.print("높이 : ");
		int numH = sc.nextInt();
		System.out.print("너비 : ");
		int numW = sc.nextInt();
		System.out.println("둘레 : " +rc.calcPerimeter(numX, numY, numH, numW));
		mainMenu();
	}
	
	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int numX = sc.nextInt();
		System.out.print("y 좌표 : ");
		int numY = sc.nextInt();
		System.out.print("높이 : ");
		int numH = sc.nextInt();
		System.out.print("너비 : ");
		int numW = sc.nextInt();
		System.out.println("면적 : " +rc.calcArea(numX, numY, numH, numW));
		mainMenu();
	}
}
