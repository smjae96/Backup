package com.kh.practice.chap01_poly.controller;


import java.util.Arrays;

import com.kh.practice.chap01_poly.model.vo.AniBook;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.CookBook;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryController {
	private Member mem = null;	//null�� ��� �ʱ�ȭ
	private Book[] bList = new Book[5];	// ũ�� 5 �Ҵ�
	//�ʱ�ȭ ���, Book ��ü �迭�� 5���� ��ü �����͸� �ʱ�ȭ
	{
		bList[0] = new CookBook("�������� ����", "������", "tvN", true);
		bList[1] = new AniBook("�ѹ� �� �ؿ�", "��Ƽ", "�����", 19);
		bList[2] = new AniBook("������ ���ǽ�", "����", "japan", 12);
		bList[3] = new CookBook("�������� �󸶳� ���ְԿ�", "������", "����", false);
		bList[4] = new CookBook("������ �� �����غ�", "������", "�ұ�å", true);
	}
	// Controller �κ��� �����ڸ� ���� �������� ����
	// 	=> �⺻ �����ڸ� ����Ͽ� ��ü�� ����
	// insertMember => mem ������ setter �޼ҵ�
	public void insertMember(Member mem) {
		this.mem = mem;			// �ּҰ� �����(���Ե�) => ��ġ set�޼ҵ尰��.
	}
	// myInfo => mem ������ getter �޼ҵ�
	public Member myInfo() {
		return mem;		// ��������(mem) ��ü�� �ּҰ��� ������ ����. => ��ġ get�޼ҵ尰��.
	}
	// selectAll => bList ������ getter �޼ҵ�
	public Book[] selectAll() {
		return bList;	// ��������(bList) ��ü�� �ּҰ��� ������ ����. => ��ġ get�޼ҵ尰��.
	}
	
	// Ű���带 �Է� �޾� Ű���尡 ���Ե� ���� ����� ��ȯ�ϴ� �޼ҵ�
	public Book[] searchBook(String keyword) {
		Book[] b1 = new Book[5];
		int count=0;
		for(int i=0; i<bList.length; i++) {
			if(bList[i].getTitle().contains(keyword)) {
				b1[count] = bList[i];
				count++;
			}
		}
//		if(count != 0) {
//			b1 = Arrays.copyOf(bList, b1.length);
//		}

		return b1;
	}
	// 
	public int rentBook(int index) {
		int result = 0;
		
		// index: ��ü(Book) �迭���� ����� ��ġ ��.
		// bList (�������)���� ��ȭå�� ���
		if(bList[index] instanceof AniBook) {
			if(mem != null) {	// ȸ�� ������ �ִٸ�..
				// bList[index] => Book b;
				int accessAge = ((AniBook)(bList[index])).getAccessAge();  // getter&setter �޼ҵ�� �ʵ尡 private���� ����� ���
																		   //(Ŭ�������̾�׷��� �޼ҵ带 �ۼ��϶�� ǥ�ð� ���) �׻� ��������� �Ѵ�!
				//	ȸ�� ���̿� ��ȭå�� ���ѳ��̸� ��
				if(mem.getAge() < accessAge) {
					//		ȸ�� ���� < ��ȭå�� ���ѳ��� : result = 1
					result = 1;
					
				}
				
			}
			
			
			//		ȸ�� ���� < ��ȭå�� ���ѳ��� : result = 1
		}
		else if(bList[index] instanceof CookBook) {
			// bList(�������)���� �丮å(CookBook)�� ���
			
			//		�ش� �丮å�� ���������� ��(true)�� ���
			//		=> CookBook Ŭ������ isCoupon() �޼ҵ带 ���� Ȯ��!
			//			���� ���(bList)���� index ��ġ�� å�� �丮å(CookBook)
			if(((CookBook)bList[index]).isCoupon()) {
				//			- ȸ���� couponCount �� 1 ����
				//			- result = 2 	
				if(mem != null) {	// ȸ�� ������ �ִٸ�
					// �޼ҵ带 ���� �߰��Ͽ� �ۼ�
					mem.addCount();
					
					/* �ǽ����� �������� �ۼ�
					int memCouponeCount = mem.getCouponCount();
					mem.setCouponCount(memCouponeCount +1);
					*/
					result = 2;
				}
			}

		}
		return result; 
	}
}
