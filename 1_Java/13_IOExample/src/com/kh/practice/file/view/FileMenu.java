package com.kh.practice.file.view;

import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	// �ʵ�
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	// �޼ҵ�
	public void mainMenu() {
		while(true) {
			System.out.println("***** My Note *****");
			System.out.println("1. ��Ʈ ���� �����");
			System.out.println("2. ��Ʈ ����");
			System.out.println("3. ��Ʈ ��� �����ϱ�");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			sc.nextLine();	// �ٷ� ���� �Է��� nextLine()�� ����Ͽ�, ���ۿ� (\n)�� �����ֱ� ���� ȣ��.
			
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
				System.out.println("���α׷��� �����մϴ�.");
				return;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}	
	}
	public void fileSave() {

		StringBuilder sb = new StringBuilder("");
		while(true) {
			System.out.println("���Ͽ� ������ ������ �Է��ϼ���.");
			System.out.println("ex��it �̶�� �Է��ϸ� ����˴ϴ�.");
			System.out.print("���� : ");
			String str = sc.nextLine();
			
			if(!str.equals("ex��it")) {
				sb = sb.append(str+"\n");
			}
			if(str.equals("ex��it")) {
				
				while(true) {
					System.out.print("������ ���� ���� �Է����ּ���(ex. myFile.txt) : ");
					String fileName = sc.nextLine();
					if(fc.checkName(fileName) == true) {
						System.out.print("�̹� �����ϴ� �����Դϴ�. ����ðڽ��ϱ�? (y/n) : ");
						
						String yn = sc.nextLine();
						if(yn.toLowerCase().equals("y")) {	// ���ڿ�.toLowerCase() : ���ڿ��� �ҹ��ڷ� ���� �޼ҵ�
															// ���ڿ�.toUpperCase() : ���ڿ��� �빮�ڷ� ���� �޼ҵ�
							fc.fileSave(fileName, sb);
							mainMenu();
							return;
						} 
					} else {	// ������ ���ϸ��� �������� �ʴ� ���
						fc.fileSave(fileName, sb);
						mainMenu();
						return;
					}
				}
			}
		}

	}
	public void fileOpen() {
		System.out.print("�� ���� �� : ");
		String file = sc.nextLine();
		if(fc.checkName(file)==false) {
			System.out.println("���� �����Դϴ�.");
			mainMenu();
			
		} else {
			System.out.println(fc.fileOpen(file));
			System.out.println();
			mainMenu();
			
		}
	}
	public void fileEdit() {
		System.out.print("������ ���� �� : ");
		String file = sc.nextLine();
		if(fc.checkName(file)==false) {
			System.out.println("���� �����Դϴ�.");
			mainMenu();
		} else if(fc.checkName(file)==true) {
			StringBuilder sb = new StringBuilder("");
			while(true) {
				System.out.println("���Ͽ� ������ ������ �Է��ϼ���.");
				System.out.println("ex��it �̶�� �Է��ϸ� ����˴ϴ�.");
				System.out.print("���� : ");
				String str = sc.nextLine();
				if(!str.equals("ex��it")) {
					sb = sb.append(str+"\n");
				}
				if(str.equals("ex��it")) {
					fc.fileEdit(file, sb);
					mainMenu();
					return;
				}
			}	
		}
	}
}
