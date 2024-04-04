package com.kh.practice.list.music.view;

import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. ������ ��ġ�� �� �߰�");
			System.out.println("2. ù ��ġ�� �� �߰�");
			System.out.println("3. ��ü �� ��� ���");
			System.out.println("4. Ư�� �� �˻�");
			System.out.println("5. Ư�� �� ����");
			System.out.println("6. Ư�� �� ���� ����");
			System.out.println("7. ��� �������� ����");
			System.out.println("8. ������ �������� ����");
			System.out.println("9.����");
			System.out.print("�޴� ��ȣ ���� : ");
			int num = sc.nextInt();
			sc.nextLine();
			if(num==1) {
				addList();
			} else if(num==2) {
				addAtZero();
			} else if(num==3) {
				printAll();
			} else if(num==4) {
				searchMusic();
			} else if(num==5) {
				removeMusic();
			} else if(num==6) {
				setMusic();
			} else if(num==7) {
				ascTitle();
			} else if(num==8) {
				descSinger();
			} else if(num==9) {
				System.out.println("���α׷� ����");
				return;
			} 
		}	
	}
	public void addList() {
		System.out.println("****** ������ ��ġ�� �� �߰� ******");
		System.out.print("�� �� : ");
		String title = sc.nextLine();
		System.out.print("���� �� : ");
		String singer = sc.nextLine();
		Music m = new Music(title, singer);
		int suc = mc.addList(m);
		if(suc ==1) {
			System.out.println("�߰� ����");
		} else {
			System.out.println("�߰� ����");
		}
	}
	public void addAtZero() {
		System.out.println("****** ù ��ġ�� �� �߰� ******");
		System.out.print("�� �� : ");
		String title = sc.nextLine();
		System.out.print("���� �� : ");
		String singer = sc.nextLine();
		Music m = new Music(title, singer);
		int suc = mc.addAtZero(m);
		if(suc ==1) {
			System.out.println("�߰� ����");
		} else {
			System.out.println("�߰� ����");
		}
	}
	public void printAll() {
		System.out.println("****** ��ü �� ��� ��� ******");
		System.out.println(mc.printAll());
	}
	public void searchMusic() {
		System.out.println("****** Ư�� �� �˻� ******");
		System.out.print("�˻��� �� �� : ");
		String title = sc.nextLine();
		Music m = mc.searchMusic(title);
		if(m == null) {
			System.out.println("�˻��� ���� �����ϴ�.");
		} else {
			System.out.println("�˻��� ���� (" +m.getTitle()+", "+m.getSinger()+") �Դϴ�.");
		}
	}
	public void removeMusic() {
		System.out.println("****** Ư�� �� ���� ******");
		System.out.print("������ �� �� : ");
		String title = sc.nextLine();
		Music m = mc.removeMusic(title);
		if(m == null) {
			System.out.println("�˻��� ���� �����ϴ�.");
		} else {
			System.out.println("("+m.getTitle()+", "+m.getSinger()+")�� ���� �߽��ϴ�.");
		}
	}
	public void setMusic() {
		System.out.println("****** Ư�� �� ���� ���� ******");
		System.out.print("�˻��� �� �� : ");
		String titleS = sc.nextLine();
		System.out.print("������ �� �� : ");
		String titleR = sc.nextLine();
		System.out.print("������ ���� �� : ");
		String singer = sc.nextLine();
		Music m = new Music(titleR, singer);
		Music m1 = mc.setMusic(titleS, m);
		if(m1 == null) {
			System.out.println("������ ���� �����ϴ�.");
		} else {
			System.out.println("("+m.getTitle()+", "+m.getSinger()+")�� ���� ���� �Ǿ����ϴ�.");
		}
	}
	public void ascTitle() {
		if(mc.ascTitle()==1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
		
	}
	public void descSinger() {
		if(mc.descSinger()==1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}
}
