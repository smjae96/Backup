package com.kh.practice.chap01_poly.run;

import com.kh.practice.chap01_poly.view.LibraryMenu;

public class Run {
	
	public static void main(String[] args) {
		LibraryMenu lm = new LibraryMenu();
		lm.mainMenu();
		
//		Scanner sc = new Scanner(System.in);
//		// ���� ���� ���α׷�..
//		//	��ȭå(AniBook), �丮å(CookBook)
//		//	�뿩 ��� 
//		Book[] bArr = new Book[10];
//
//		
//		System.out.println("===== �뿩�� å�� �����Ͻÿ� =====");
//		System.out.println("1. ��ȭå");
//		System.out.println("2. �丮å");
//		System.out.println("3. �Ҽ�å");	// å ������ �߰��� ���
//		System.out.println("���� > ");
//		int select = sc.nextInt();
//		
//		for(int i=0; i<bArr.length; i++) {
//			if(bArr[i] == null) {
//				if(select == 1) {
//					bArr[i] = new AniBook();
//					if (bArr[i] instanceof AniBook) {
//						// �ٿ�ĳ�����Ͽ� AniBook Ŭ������ �ʿ��� ����(���ѳ��̿� �°� �뿩 �����ϵ��� ó��)
//						if(((AniBook)bArr[i]).getAccessAge() >= 20) {
//							// �뿩 ����..
//						} else {
//							// �뿩���� ���ϴ� ���
//							bArr[i] = null;
//						}
//					}
//					break;
//				}
//				else if(select == 2) {
//					bArr[i] = new CookBook();
//					break;
//				}
//				else if(select ==3) {
//			//		bArr[i] = new NovelBook(); //NovelBook Ŭ���� �ۼ� �� �����κи� �߰� �ۼ�
//					break;
//				}
//			}
//		}
//		
//		
//		//�� �뿩 �Ǽ� ��ȸ
//		int cnt =0;
//		for(int i=0; i<bArr.length; i++) {
//			if(bArr[i] != null) {
//				cnt++;
//			}
//		}
//		
//		
//		
//	}
//	
//	public void practice1() {
//		// �������� �������� ���� ���
//		
//		Scanner sc = new Scanner(System.in);
//		// ���� ���� ���α׷�..
//		//	��ȭå(AniBook), �丮å(CookBook)
//		//	�뿩 ��� 
//		
//		AniBook[] abArr = new AniBook[3];
//		CookBook[] cbArr = new CookBook[3];
//		
//		System.out.println("===== �뿩�� å�� �����Ͻÿ� =====");
//		System.out.println("1. ��ȭå");
//		System.out.println("2. �丮å");
//		System.out.println("���� > ");
//		int select = sc.nextInt();
//		
//		if(select ==1) {
//			for(int i=0; i<abArr.length; i++) {
//				if(abArr[i] == null) {		// �迭�� ����ִ� �� üũ�� �� "�迭��[index] == null"
//					abArr[i] = new AniBook();
//					break;
//				}
//			}
//		} else if(select ==2 ) {
//			for(int i=0; i<cbArr.length; i++) {
//				if(cbArr[i] == null) {
//					cbArr[i] = new CookBook();
//					break;
//				}
//			}
//		}
//		
//		//�� �뿩 �Ǽ� ��ȸ
//		int cnt =0;
//		for(int i=0; i<abArr.length; i++) {
//			if(abArr[i] != null) {
//				cnt++;
//			}
//		}
//		for(int i=0; i<cbArr.length; i++) {
//			if(cbArr[i] != null) {
//				cnt++;
//			}
//		}
//	}
//	
//	public void test() {
//		Book b1 = new AniBook();
//		// Book : �� 3���� �ʵ�(title, author, publisher)
//		// AniBook : �� 4���� �ʵ� (title, author, publisher, accessAge)
//		System.out.println(b1.toString()); 	// ��� ? ( 4 )���� �ʵ� ����  --> �������ε� �Ǳ� ����.
//										// �ʵ� ������ 3���� Ȯ�ε� ���̶� ����������,
//										// �� 4�� �ʵ� ������ Ȯ�εǾ���.
//										// => �������ε��� ���� ��Ӱ����� �������� ����� Ŭ������
//										//	  �޼ҵ尡 �������̵� �Ǿ�, �������̵��� �ڵ尡 ����Ǿ����Ƿ�
//										//	  �� 4�� �ʵ� ������ Ȯ�ε�.
//		//b1.getAccessAge(); 			// ���� �߻� ����? �������� Ÿ���� �θ�Ŭ������ (Book)���� ���� �Ǿ� �־�
//										//				�ڽ�Ŭ����(AniBook)�� ���� �߰��� �޼ҵ�� ������ �Ұ�.
//		
//		// getAccessAge() �޼ҵ带 ȣ���Ϸ���?
//		// instanceof: �ٿ�ĳ���� �� ���������� �ش� �ν��Ͻ��� ������ �ּҸ� ������ �ִ� �� Ȯ���ϴ� ������
//		if(b1 instanceof AniBook) {		// ���������� instanceof Ȯ����Ŭ������
//			int accessAge = ((AniBook)b1).getAccessAge();
//			System.out.println("�ٿ�ĳ���� �����. "+accessAge);
//		}
	}

}
