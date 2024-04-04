package com.kh.practice.chap01_poly.run;

import java.util.Scanner;

import com.kh.practice.chap01_poly.model.vo.AniBook;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.CookBook;
import com.kh.practice.chap01_poly.view.LibraryMenu;

public class Run {

	public static void main(String[] args) {
		
		LibraryMenu lm = new LibraryMenu();
		lm.mainMenu();

	}
	
	
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		// 도서 관리 프로그램..
		//  만화책(AniBook), 요리책(CookBook)
		
		//  대여 목록
		Book[] bArr = new Book[10];		
		
		System.out.println("===== 대여할 책을 선택하시오 =====");
		System.out.println("1. 만화책");
		System.out.println("2. 요리책");
		System.out.println("3. 소설책");
		System.out.print("선택 > ");
		int select = sc.nextInt();
		
		// 대여하는 경우 객체 생성
		for(int i=0; i<bArr.length; i++) {
			if (bArr[i] == null) {
				if(select == 1) {
					bArr[i] = new AniBook();
					if (bArr[i] instanceof AniBook) {
						// 다운캐스팅하여 AniBook 클래스에 필요한 조건(제한나이에 맞게 대여 가능하도록 처리) 
						if(((AniBook)bArr[i]).getAccessAge() >= 20) {
							// 대여가능..
						} else {
							// 대여하지 못하는 경우
							bArr[i] = null;
						}
					}
					break;
				} else if (select == 2) {
					bArr[i] = new CookBook();
					break;
				} else if (select == 3) {
//					bArr[i] = new SBook();	// SBook 클래스 후 객체 생성부분만 추가 작성
					break;
				}
			}
		}
		
		// 총 대여 건수 조회
		int cnt = 0;
		for(int i=0; i<bArr.length; i++) {
			if (bArr[i] != null) {
				cnt++;
			}
		}
		
	}
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		// 다형성을 적용하지 않은 경우
		
		// 도서 관리 프로그램..
		//  만화책(AniBook), 요리책(CookBook)
		
		//  대여 목록
		AniBook[] abArr = new AniBook[3];
		CookBook[] cbArr = new CookBook[3];
		
		
		System.out.println("===== 대여할 책을 선택하시오 =====");
		System.out.println("1. 만화책");
		System.out.println("2. 요리책");
		System.out.print("선택 > ");
		int select = sc.nextInt();
		
		if(select == 1) {
			for(int i=0; i<abArr.length; i++) {
				if (abArr[i] == null) {		// 배열이 비어있는 지 체크할 때 "배열명[index] == null"
					abArr[i] = new AniBook();
					break;
				}
			}
		} else if (select == 2) {
			for(int i=0; i<cbArr.length; i++) {
				if (cbArr[i] == null) {
					cbArr[i] = new CookBook();
					break;
				}
			}
		}
		
		// 총 대여 건수 조회
		int cnt=0;
		for(int i=0; i<abArr.length; i++) {
			if(abArr[i] != null) {
				cnt++;
			}
		}
		for(int i=0; i<cbArr.length; i++) {
			if(cbArr[i] != null) {
				cnt++;
			}
		}
		
	}
	
	public void test() {
		Book b1 = new AniBook();
		// Book : 총 3개의 필드(title, author, publisher)
		// AniBook : 총 4개의 필드 (title, author, publisher, accessAge)
		System.out.println(b1.toString());		// 결과? (4)개의 필드 
										// 필드 정보가 3개가 확인될 것이라 예상했지만,
										// 총 4개필드 정보가 확인되었다.
										// => 동적바인딩에 의해 상속관계의 다형성이 적용된 클래스의 
										//    메소드가 오버라이딩 되어, 오버라이딩된 코드가 실행되었으므로
										//    총 4개 필드 정보가 확인됨.
		
		// b1.getAccessAge();	// 오류 발생 이유? 참조변수 타입이 부모클래스인 Book으로 선언이 되어 있어
								//				자식클래스(AniBook)에 새로 추가된 메소드로 접근이 불가.
		
		// getAccessAge() 메소드를 호출하려면? 다운캐스팅..
		//  instanceof: 다운캐스팅 시 참조변수가 해당 인스턴스로 생성된 주소를 가지고 있는 지 확인하는 연산자
		if (b1 instanceof AniBook) {	// 참조변수명 instanceof 확인할클래스명
			int accessAge = ((AniBook)b1).getAccessAge();
			System.out.println("다운캐스팅 적용됨. "+accessAge);
		}
	}

}
