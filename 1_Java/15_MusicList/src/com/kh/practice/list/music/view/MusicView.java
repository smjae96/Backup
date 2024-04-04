package com.kh.practice.list.music.view;

import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9.종료");
			System.out.print("메뉴 번호 선택 : ");
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
				System.out.println("프로그램 종료");
				return;
			} 
		}	
	}
	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		Music m = new Music(title, singer);
		int suc = mc.addList(m);
		if(suc ==1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		Music m = new Music(title, singer);
		int suc = mc.addAtZero(m);
		if(suc ==1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		System.out.println(mc.printAll());
	}
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		Music m = mc.searchMusic(title);
		if(m == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			System.out.println("검색한 곡은 (" +m.getTitle()+", "+m.getSinger()+") 입니다.");
		}
	}
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		Music m = mc.removeMusic(title);
		if(m == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			System.out.println("("+m.getTitle()+", "+m.getSinger()+")을 삭제 했습니다.");
		}
	}
	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		System.out.print("검색할 곡 명 : ");
		String titleS = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String titleR = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String singer = sc.nextLine();
		Music m = new Music(titleR, singer);
		Music m1 = mc.setMusic(titleS, m);
		if(m1 == null) {
			System.out.println("수정할 곡이 없습니다.");
		} else {
			System.out.println("("+m.getTitle()+", "+m.getSinger()+")의 값이 변경 되었습니다.");
		}
	}
	public void ascTitle() {
		if(mc.ascTitle()==1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
		
	}
	public void descSinger() {
		if(mc.descSinger()==1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
}
