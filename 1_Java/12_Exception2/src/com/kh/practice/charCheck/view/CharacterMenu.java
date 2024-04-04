package com.kh.practice.charCheck.view;

import java.util.Scanner;

import com.kh.practice.charCheck.controller.CharacterController;
import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterMenu {

	public void menu() {
		CharacterController cc = new CharacterController();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("문자열 : ");
			String str = sc.nextLine();
			try {
				System.out.println("'"+str+"'에 포함된 염운자 개수 : " +cc.countAlpha(str));
			} catch(CharCheckException e) {
				e.printStackTrace();
				return;
			}
			System.out.println();
			System.out.println("또는");
			System.out.println();
		}

		
	}
}
