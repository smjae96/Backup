package com.kh.practice.chap01_poly.model.vo;

// Book Ŭ������ ��ӹ���
// ��ȭå ��ü
public class AniBook extends Book {
	// ��� ����: (3) + (1) = (4)
	private int accessAge;		// ���� ����
	
	// ������: (0) + (2) = (2) 
	//  - �⺻ ������, �Ű������� 4���� ������(title, author, publisher, accessAge)
	public AniBook() {}
	
	public AniBook(String title, String author, String publisher, int accessAge) {
		super(title, author, publisher);
		this.accessAge = accessAge;
	}
	
	// �޼ҵ�: (1) - toString() �޼ҵ� �������̵�
	//				�θ�Ŭ������ ������� ������ ����Ŭ����(AniBook)�� ������� ������ ��� ���ڿ� ��ȯ
	@Override
	public String toString() {
		return String.format("%s / %d", super.toString(), accessAge);
	}
	
	public int getAccessAge() {
		return accessAge;
	}
}





