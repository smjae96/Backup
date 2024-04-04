package com.kh.practice.file.view;

import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	// 필드
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	// 메소드
	public void mainMenu() {
		while(true) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			sc.nextLine();	// 바로 다음 입력이 nextLine()을 사용하여, 버퍼에 (\n)을 지워주기 위해 호출.
			
			if(num==1) {
				fileSave();
				return;
			} else if(num==2) {
				fileOpen();
				return;
			} else if(num==3) {
				fileEdit();
				return;
			} else if(num==9) {
				System.out.println("프로그램을 종료합니다.");
				return;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}	
	}
	public void fileSave() {

		StringBuilder sb = new StringBuilder("");
		while(true) {
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			String str = sc.nextLine();
			
			if(!str.equals("ex끝it")) {
				sb = sb.append(str+"\n");
			}
			if(str.equals("ex끝it")) {
				
				while(true) {
					System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
					String fileName = sc.nextLine();
					if(fc.checkName(fileName) == true) {
						System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까? (y/n) : ");
						
						String yn = sc.nextLine();
						if(yn.toLowerCase().equals("y")) {	// 문자열.toLowerCase() : 문자열을 소문자로 변경 메소드
															// 문자열.toUpperCase() : 문자열을 대문자로 변경 메소드
							fc.fileSave(fileName, sb);
							mainMenu();
							return;
						} 
					} else {	// 동일한 파일명이 존재하지 않는 경우
						fc.fileSave(fileName, sb);
						mainMenu();
						return;
					}
				}
			}
		}

	}
	public void fileOpen() {
		System.out.print("열 파일 명 : ");
		String file = sc.nextLine();
		if(fc.checkName(file)==false) {
			System.out.println("없는 파일입니다.");
			mainMenu();
			
		} else {
			System.out.println(fc.fileOpen(file));
			System.out.println();
			mainMenu();
			
		}
	}
	public void fileEdit() {
		System.out.print("수정할 파일 명 : ");
		String file = sc.nextLine();
		if(fc.checkName(file)==false) {
			System.out.println("없는 파일입니다.");
			mainMenu();
		} else if(fc.checkName(file)==true) {
			StringBuilder sb = new StringBuilder("");
			while(true) {
				System.out.println("파일에 저장할 내용을 입력하세요.");
				System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
				System.out.print("내용 : ");
				String str = sc.nextLine();
				if(!str.equals("ex끝it")) {
					sb = sb.append(str+"\n");
				}
				if(str.equals("ex끝it")) {
					fc.fileEdit(file, sb);
					mainMenu();
					return;
				}
			}	
		}
	}
}
